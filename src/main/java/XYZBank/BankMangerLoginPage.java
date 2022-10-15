package XYZBank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BankMangerLoginPage extends BasePage {

    private final By addCustomerButton = By.xpath("//button[normalize-space(text())='Add Customer']");
    private final By openAccountButton = By.xpath("//button[normalize-space(text())='Open Account']");
    private final By CustomersButton = By.xpath("//button[normalize-space(text())='Customers']");


    //add customer
    private final By addCustomerSubmitButton = By.xpath("//button[normalize-space(text())='Add Customer' and @type='submit']");
    private final By firstnameField = By.xpath("//input[normalize-space(@placeholder)='First Name']");
    private final By lastnameField = By.xpath("//input[normalize-space(@placeholder)='Last Name']");
    private final By postalCodeField = By.xpath("//input[normalize-space(@placeholder)='Post Code']");

    //openAccount
    private final By customerNameDropDown = By.id("userSelect");
    private final By currencyDropDown = By.id("currency");
    private final By processButton = By.xpath("//button[normalize-space(text())='Process']");

    //search customer
    private final By searchCustomerField = By.xpath("//input[normalize-space(@placeholder)='Search Customer']");
    private final By deleteCustomerAfterSearchButton = By.xpath("//button[normalize-space(text())='Delete']");
    private String customerAccountNumberXpath = "//td[normalize-space(text())='$$']/following-sibling::td[3]";

    public BankMangerLoginPage() {
        super();
    }

    /**
     * creates the customer using requested firstname ,lastname and post code . returns customerID
     *
     * @param firstName
     * @param lastName
     * @param postCode
     * @return customer id
     */
    public String addCustomer(String firstName, String lastName, String postCode) {
        click(addCustomerButton);
        sendKeys(firstnameField, firstName);
        sendKeys(lastnameField, lastName);
        sendKeys(postalCodeField, postCode);
        click(addCustomerSubmitButton);
        String customerID = getTextFromAlert().split(":")[1].trim();
        acceptAlert();
        return customerID;
    }

    /**
     * opens account for requested customer and returns the account number
     *
     * @param customerName
     * @param currency
     * @return account number
     */
    public String openAccount(String customerName, String currency) {
        click(openAccountButton);
        selectFromDropDown(customerNameDropDown, customerName);
        selectFromDropDown(currencyDropDown, currency);
        click(processButton);
        String accountNumber = getTextFromAlert().split(":")[1].trim();
        acceptAlert();
        return accountNumber;
    }

    public void verifyCustomerAccountNumberIsPresent(String firstName, String accountNumber){
        searchCustomer(firstName);
        String accountNumbers = getText(By.xpath(customerAccountNumberXpath.replace("$$",firstName)));
        Assert.assertTrue(accountNumbers.contains(accountNumber));
    }

    public void deleteCustomerUsingSearch(String firstName) {
        searchCustomer(firstName);
        click(deleteCustomerAfterSearchButton);
    }

    public void searchCustomer(String firstName){
        click(CustomersButton);
        sendKeys(searchCustomerField, firstName);
    }



}