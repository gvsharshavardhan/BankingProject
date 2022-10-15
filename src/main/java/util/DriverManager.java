package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

    private static WebDriver driver;
    private static ThreadLocal<WebDriver> tl = new ThreadLocal<>();

    public static void init() {
        String browser = PropertyUtil.getBrowser();
        if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        tl.set(driver);
    }

    public static WebDriver getDriver() {
        return tl.get();
    }

    public static void quitDriver() {
        tl.get().quit();
    }

}