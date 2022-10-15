package XYZBank;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.SleepHelper;

import java.time.Duration;

import static util.DriverManager.getDriver;


public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage() {
        this.driver = getDriver();
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
    }

    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        SleepHelper.sleep(1);
    }

    public void sendKeys(By locator, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }

    public void selectFromDropDown(By dropDownLocator, String option){
        WebElement dropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(dropDownLocator));
        Select select = new Select(dropdownElement);
        select.selectByVisibleText(option);
    }

    public String getText(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText().trim();
    }

    public String getTextFromAlert(){
        return wait.until(ExpectedConditions.alertIsPresent()).getText();
    }

    public void acceptAlert(){
        wait.until(ExpectedConditions.alertIsPresent()).accept();
    }

    public void dismissAlert(){
        wait.until(ExpectedConditions.alertIsPresent()).dismiss();
    }
}