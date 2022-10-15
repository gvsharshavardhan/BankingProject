package Banktests;

import XYZBank.BankHomePage;
import XYZBank.BankMangerLoginPage;
import XYZBank.CustomerLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.ReportLogger;

public class BankTests extends BaseTest {

    @Test
    public void testAddCustomerOpenAccountDeleteCustomer() {
        BankHomePage bankHomePage = new BankHomePage();
        BankMangerLoginPage bmlp = new BankMangerLoginPage();
        String firstname = "sachin";
        String lastname = "joshi";
        String postcode = "abc123";
        bankHomePage
                .goToBankManagerLoginPage()
                .addCustomer(firstname, lastname, postcode);
        ReportLogger.infoAndScreenShot("Added customer!");
        String accountNumber = bmlp.openAccount(firstname + " " + lastname, "Rupee");
        ReportLogger.infoAndScreenShot("Account opened!");
        bmlp.verifyCustomerAccountNumberIsPresent(firstname, accountNumber);
        ReportLogger.infoAndScreenShot("Customer verified!");
        bmlp.deleteCustomerUsingSearch(firstname);
        ReportLogger.infoAndScreenShot("Customer deleted!");
    }

    @Test
    public void testAddCustomerOpenAccountDepositAndWithdraw() {
        BankHomePage bankHomePage = new BankHomePage();
        String firstname = "john";
        String lastname = "bob";
        String postcode = "xyz123";
        String currency = "Rupee";
        String fullName = firstname + " " + lastname;
        BankMangerLoginPage bmlp = bankHomePage.goToBankManagerLoginPage();
        bmlp.addCustomer(firstname, lastname, postcode);
        String accountNumber = bmlp.openAccount(fullName, currency);
        bmlp.verifyCustomerAccountNumberIsPresent(firstname, accountNumber);
        bankHomePage.goToBankHomePage();
        CustomerLoginPage customerLoginPage = bankHomePage.goToCustomerLoginPage();
        customerLoginPage.login(fullName);
        String depositAmt = "1000";
        String withdrawAmt = "600";
        String afterDeposit = customerLoginPage.deposit(depositAmt);
        Assert.assertEquals(afterDeposit, depositAmt);
        String afterWithdraw = customerLoginPage.withdraw(withdrawAmt);
        Assert.assertEquals(afterWithdraw,"400");
    }
}