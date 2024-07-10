package tools_qa.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import tools_qa.pages.base.BasePage;

import java.util.HashMap;
import java.util.Map;

public class FileManagement {

    public static WebDriver createChromeDriverForDownloads(String downloadFilePath) {
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", downloadFilePath);
        prefs.put("download.prompt_for_download", false);
        // To disable Chrome PDF viewer we should write this:
        // prefs.put("plugins.always_open_pdf_externally", true);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        return new ChromeDriver(options);
    }
}
