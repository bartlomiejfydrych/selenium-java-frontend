package testerczaki.base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import testerczaki.configuration.Config;
import testerczaki.providers.DriverProvider;
import testerczaki.providers.UrlProvider;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TestBase {

    public WebDriver driver;

    @BeforeAll
    public static void setUpAll() {
        /*
        NOTE:
        Since I don't use the Allure report for further learning, I added deleting its files so that it doesn't fill up my disk.
        Set 'clearAllureReportFiles=true' in [config.properties] if you need to use the Allure report.
        */
        if (Config.getClearAllureReportFiles()) {
            cleanAllureResultsDirectory();
        }
    }

    @BeforeEach
    public void setUp() {
        driver = DriverProvider.getDriver(Config.getBrowser(), Config.getTestResourcesPath());
        driver.get(UrlProvider.getHomePageUrl());
    }

    @AfterEach
    public void cleanUp() {
        driver.quit();
    }

    @AfterAll
    public static void cleanUpAll() {
        System.out.println("Remember to check and delete the directory: [project/output/allure_results] before running the tests again." +
                "(If in [config.properties] is set 'clearAllureReportFiles=false').");
        System.out.println("If you want to fully use 'Allure Report' remember to set 'clearAllureReportFiles=true' in [config.properties].");
    }

    // -------
    // HELPERS
    // -------

    // Allure report files are generated every time the tests are run. This method will clean them up regularly.
    private static void cleanAllureResultsDirectory() {
        Path allureResultsPath = Paths.get("output", "allure_results");
        try {
            if (Files.exists(allureResultsPath)) {
                try (Stream<Path> paths = Files.walk(allureResultsPath)) {
                    paths.sorted((path1, path2) -> path2.compareTo(path1)) // First internal files, then directories.
                            .forEach(path -> {
                                try {
                                    Files.delete(path);
                                } catch (IOException e) {
                                    System.err.println("Error deleting file: " + path);
                                }
                            });
                }
            }
        } catch (IOException e) {
            System.err.println("Error cleaning allure_results directory: " + e.getMessage());
        }
    }
}
