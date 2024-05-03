package tools_qa.pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait defaultWait;

    // Konfiguracja WebDrivera

    private void initDriver(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        defaultWait = new WebDriverWait(driver, Duration.ofSeconds(Config.getDefaultWait()));
    }


    // Konstruktor/Konstruktory klasy

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        initDriver(driver);
    }

    // Nadpisanie metod na metody logujące akcje

    // Metoda/Typy generyczne
}
