package XYZBank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BankHomePage extends BasePage{

    private By CustomerLoginButton = By.xpath("//button[.='Customer Login']");
    private By BankManagerLoginButton = By.xpath("//button[.='Bank Manager Login']");
    private final By homeButton = By.xpath("//button[normalize-space(text())='Home']");

    public BankHomePage(){
        super();
    }

    public CustomerLoginPage goToCustomerLoginPage(){
        click(CustomerLoginButton);
        return new CustomerLoginPage();
    }

    public BankMangerLoginPage goToBankManagerLoginPage(){
        click(BankManagerLoginButton);
        return new BankMangerLoginPage();
    }

    public void goToBankHomePage(){
        click(homeButton);
    }

}