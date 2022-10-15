package Banktests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import util.DriverManager;
import util.PropertyUtil;

import static util.DriverManager.getDriver;

public class BaseTest {

    @BeforeMethod
    public void setup() {
        DriverManager.init();
        getDriver().get(PropertyUtil.getURL());
        getDriver().manage().window().fullscreen();
    }

//    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
