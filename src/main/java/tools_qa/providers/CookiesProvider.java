package tools_qa.providers;

import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import tools_qa.configuration.Config;
import tools_qa.pages.commons.TrainingPage;
import tools_qa.pages.normal.book_store_application_pages.LoginPage;
import tools_qa.pages.normal.book_store_application_pages.ProfilePage;

import java.io.*;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CookiesProvider {

    // FILE PATHS
    private static final String GENERAL_FILES_PATH = Config.getDownloadFilePath();
    private static final String COOKIES_DIR = "Auth";
    private static final String COOKIES_FILE_PATH = Paths.get(GENERAL_FILES_PATH, COOKIES_DIR, "cookies.txt").toString();

    // -----------
    // MAIN METHOD
    // -----------

    public static void loadCookiesOrLogIn(WebDriver driver) {
        if (checkIfCookieFileExists() && checkCookieValidity()) {
            loadCookies(driver);
            driver.navigate().refresh(); // Refresh to apply cookies
        } else {
            logIn(driver);
            saveCookiesToFile(driver);
            driver.get(UrlProvider.getHomePageUrl());
        }
    }

    // -----------
    // SUB METHODS
    // -----------

    // LOG IN

    public static void logIn(WebDriver driver) {
        // Load .env variables
        Dotenv dotenv = Dotenv.configure().directory("./environment").load();
        String userName = dotenv.get("TQ_BSA_USERNAME");
        String password = dotenv.get("TQ_BSA_PASSWORD");
        // Go to login page
        driver.get(UrlProvider.getLoginPageUrl());
        // Remove footer and ads
        TrainingPage trainingPage = new TrainingPage(driver);
        trainingPage.removeFooterAndAds();
        // Log in
        LoginPage loginPage = new LoginPage(driver);
        loginPage.writeUserName(userName)
                .writePassword(password)
                .clickLoginButton();
        // Wait for log in
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.waitForLogOutButton();
    }

    // SAVE AND LOAD

    public static void saveCookiesToFile(WebDriver driver) {
        Set<Cookie> cookies = driver.manage().getCookies();

        File cookieFile = new File(COOKIES_FILE_PATH);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(cookieFile))) {
            for (Cookie cookie : cookies) {
                String cookieString = String.format(
                        "%s;%s;%s;%s;%s;%s;%b",
                        cookie.getName(),
                        cookie.getValue(),
                        cookie.getDomain(),
                        cookie.getPath(),
                        cookie.getExpiry() != null ? cookie.getExpiry().toString() : "null",
                        cookie.isSecure(),
                        cookie.isHttpOnly()
                );
                writer.write(cookieString);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to save cookies to file", e);
        }
    }

    public static void loadCookies(WebDriver driver) {
        List<Cookie> cookies = readCookiesFromFile();
        for (Cookie cookie : cookies) {
            driver.manage().addCookie(cookie);
        }
    }

    // VALIDATION

    public static boolean checkIfCookieFileExists() {
        File cookieFile = new File(COOKIES_FILE_PATH);
        return cookieFile.exists() && cookieFile.isFile();
    }

    public static boolean checkCookieValidity() {
        List<Cookie> cookies = readCookiesFromFile();
        Date now = new Date();

        for (Cookie cookie : cookies) {
            if (cookie.getExpiry() != null && cookie.getExpiry().before(now)) {
                System.out.println("Expired cookie: " + cookie.getName() + " (expired: " + cookie.getExpiry() + ")");
                return false; // At least one cookie has expired
            }
        }
        return true; // All cookies are valid
    }

    // READ FROM FILE

    private static List<Cookie> readCookiesFromFile() {
        File cookieFile = new File(COOKIES_FILE_PATH);
        List<Cookie> cookies = new ArrayList<>();

        // Handle different date formats
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
        SimpleDateFormat iso8601DateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX", Locale.ENGLISH);

        try (BufferedReader reader = new BufferedReader(new FileReader(cookieFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length < 6) {
                    throw new IllegalArgumentException("Incorrect line format: " + line);
                }

                String name = parts[0];
                String value = parts[1];
                String domain = parts[2];
                String path = parts[3];
                Date expiry = null;

                // Parsing the expiration date
                if (!parts[4].equals("null")) {
                    try {
                        expiry = iso8601DateFormat.parse(parts[4]);
                    } catch (ParseException e) {
                        try {
                            expiry = simpleDateFormat.parse(parts[4]);
                        } catch (ParseException ignored) {
                            // Unhandled date format
                        }
                    }
                }

                boolean isSecure = Boolean.parseBoolean(parts[5]);
                boolean isHttpOnly = Boolean.parseBoolean(parts[6]);

                // Creating a Cookie Object
                Cookie.Builder cookieBuilder = new Cookie.Builder(name, value)
                        .domain(domain)
                        .path(path)
                        .isSecure(isSecure);

                if (expiry != null) {
                    cookieBuilder.expiresOn(expiry);
                }
                if (isHttpOnly) {
                    cookieBuilder.isHttpOnly(true);
                }

                cookies.add(cookieBuilder.build());
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading cookie file", e);
        }
        return cookies;
    }
}
