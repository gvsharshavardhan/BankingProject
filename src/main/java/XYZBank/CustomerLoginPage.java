package XYZBank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerLoginPage extends BasePage {

    public CustomerLoginPage() {
        super();
    }

    private final By nameDropDown = By.id("userSelect");
    private final By loginButton = By.xpath("//button[normalize-space(text())='Login']");
    private final By amountField = By.xpath("//input[normalize-space(@placeholder)='amount']");
    private final By depositButton = By.xpath("//button[normalize-space(text())='Deposit' and @type='submit'] ");
    private final By withdrawButton = By.xpath("//button[normalize-space(text())='Withdraw' and @type='submit'] ");
    private final By accountDetails = By.xpath("//div[contains(.,'Balance') and @ng-hide='noAccount']");
    private final By depositHeader = By.xpath("//button[normalize-space(text())='Deposit' and contains(@class,'btn-lg')]");
    private final By withDrawlHeader = By.xpath("//button[normalize-space(text())='Withdrawl' and contains(@class,'btn-lg')]");

    public void login(String customerName) {
        selectFromDropDown(nameDropDown, customerName);
        click(loginButton);
    }

    public String deposit(String amount) {
        click(depositHeader);
        sendKeys(amountField, amount);
        click(depositButton);
        return getCurrentBalance();
    }

    public String getCurrentBalance() {
        return getText(accountDetails).split(",")[1].split(":")[1].trim();
    }

    public String withdraw(String amt) {
        click(withDrawlHeader);
        sendKeys(amountField, amt);
        click(withdrawButton);
        return getCurrentBalance();
    }

}