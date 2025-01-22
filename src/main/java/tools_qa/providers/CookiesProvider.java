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
    private static final String COOKIES_DIR = "auth";
    private static final String COOKIES_FILE_PATH = Paths.get(GENERAL_FILES_PATH, COOKIES_DIR, "cookies.txt").toString();

    // -----------
    // MAIN METHOD
    // -----------

    public static void loadCookiesOrLogIn(WebDriver driver) {
        if (checkIfCookieFileExists() && areCookiesValid()) {
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

    /**
     * Log in to the application and navigate to the home page.
     */
    private static void logIn(WebDriver driver) {
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

    /**
     * Save cookies to a file.
     */
    private static void saveCookiesToFile(WebDriver driver) {
        Set<Cookie> cookies = driver.manage().getCookies();
        File cookieFile = new File(COOKIES_FILE_PATH);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(cookieFile))) {
            for (Cookie cookie : cookies) {
                writer.write(formatCookie(cookie));
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to save cookies to file", e);
        }
    }

    /**
     * Load cookies from a file and add them to the browser.
     */
    private static void loadCookies(WebDriver driver) {
        List<Cookie> cookies = readCookiesFromFile();
        for (Cookie cookie : cookies) {
            driver.manage().addCookie(cookie);
        }
    }

    // VALIDATION

    /**
     * Check if the cookie file exists.
     */
    private static boolean checkIfCookieFileExists() {
        File cookieFile = new File(COOKIES_FILE_PATH);
        return cookieFile.exists() && cookieFile.isFile();
    }

    /**
     * Check if cookies in the file are valid (not expired).
     */
    private static boolean areCookiesValid() {
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

    /**
     * Read cookies from the file.
     */
    private static List<Cookie> readCookiesFromFile() {
        File cookieFile = new File(COOKIES_FILE_PATH);
        List<Cookie> cookies = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(cookieFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                cookies.add(parseCookie(line));
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading cookie file", e);
        }
        return cookies;
    }

    // -------
    // HELPERS
    // -------

    /**
     * Format a cookie as a string for saving to a file.
     */
    private static String formatCookie(Cookie cookie) {
        return String.format("%s;%s;%s;%s;%s;%b;%b",
                cookie.getName(),
                cookie.getValue(),
                cookie.getDomain(),
                cookie.getPath(),
                cookie.getExpiry() != null ? cookie.getExpiry().toString() : "null",
                cookie.isSecure(),
                cookie.isHttpOnly());
    }

    /**
     * Parse a 'cookie string' into a 'Cookie object'.
     */
    private static Cookie parseCookie(String line) {
        String[] parts = line.split(";");
        if (parts.length < 6) {
            throw new IllegalArgumentException("Incorrect cookie format: " + line);
        }

        String name = parts[0];
        String value = parts[1];
        String domain = parts[2];
        String path = parts[3];
        Date expiry = parseDate(parts[4]);
        boolean isSecure = Boolean.parseBoolean(parts[5]);
        boolean isHttpOnly = Boolean.parseBoolean(parts[6]);

        return new Cookie.Builder(name, value)
                .domain(domain)
                .path(path)
                .isSecure(isSecure)
                .expiresOn(expiry)
                .isHttpOnly(isHttpOnly)
                .build();
    }

    private static Date parseDate(String dateString) {
        SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
        SimpleDateFormat ISO_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX", Locale.ENGLISH);

        if ("null".equals(dateString)) {
            return null;
        }

        try {
            return ISO_DATE_FORMAT.parse(dateString);
        } catch (ParseException e) {
            try {
                return SIMPLE_DATE_FORMAT.parse(dateString);
            } catch (ParseException ex) {
                throw new IllegalArgumentException("Unsupported date format: " + dateString, ex);
            }
        }
    }
}
