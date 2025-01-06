package tools_qa.base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import tools_qa.configuration.Config;
import tools_qa.providers.DriverProvider;
import tools_qa.providers.UrlProvider;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TestBase {
    public WebDriver driver;

    @BeforeEach
    public void setUp() {
        // NOTE:
        // Since I don't use the Allure report for further learning, I added deleting its files so that it doesn't fill up my disk
        cleanAllureResultsDirectory(); // Comment if you need to use the Allure report
        driver = DriverProvider.getDriver(Config.getBrowser(), Config.getDownloadFilePath());
        driver.get(UrlProvider.homePage);
    }

    @AfterEach
    public void cleanUp() {
        driver.quit();
        System.out.println("Remember to delete the directory: [project/target/allure-results] before running the tests again.");
    }

    // -------
    // HELPERS
    // -------

    // Allure report files are generated every time the tests are run. This method will clean them up regularly.
    private static void cleanAllureResultsDirectory() {
        Path allureResultsPath = Paths.get("target", "allure-results");
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
            System.err.println("Error cleaning allure-results directory: " + e.getMessage());
        }
    }
}
