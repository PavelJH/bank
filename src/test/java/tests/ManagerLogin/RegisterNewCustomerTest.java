package tests.ManagerLogin;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.bankManagerLogin.BankManagerLoginPage;
import pages.bankManagerLogin.addCustomer.AddCustomerPage;
import pages.bankManagerLogin.openAccount.OpenAccountPage;
import pages.customerLogin.CustomerLoginPage;
import pages.customerLogin.account.AccountPage;
import tests.TestBase;

public class RegisterNewCustomerTest extends TestBase {
    HomePage homePage;
    BankManagerLoginPage bankManagerLoginPage;
    AddCustomerPage addCustomerPage;
    OpenAccountPage openAccountPage;
    CustomerLoginPage customerLoginPage;
    AccountPage accountPage;

    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String postCode = "12345";

    @Test
    public void registerNewCustomerOpenAccountAndCustomerLogin() {
        homePage = new HomePage(app.driver);
        homePage.waitForLoading();
        homePage.clickOnBankManagerLoginButton();

        bankManagerLoginPage = new BankManagerLoginPage(app.driver);
        bankManagerLoginPage.waitForLoading();
        bankManagerLoginPage.openAddCustomerTab();

        addCustomerPage = new AddCustomerPage(app.driver);
        addCustomerPage.waitForLoading();
        addCustomerPage.fillAddCustomerForm(firstName, lastName, postCode);
        addCustomerPage.clickOnAddCustomerButton();

        String expectedResult = "Customer added successfully with customer id :";
        String actualResult = addCustomerPage.getAlertText();
        Assert.assertTrue(actualResult.contains(expectedResult));
        addCustomerPage.clickAlertOkButton();

        bankManagerLoginPage.openAccountTab();

        openAccountPage = new OpenAccountPage(app.driver);
        openAccountPage.waitForLoading();
        openAccountPage.selectExistingUser(firstName + " " + lastName);
        openAccountPage.selectCurrency("Dollar");
        openAccountPage.clickOnProcessButton();

        String expectedRes = "Account created successfully with account Number :";
        String actualRes = addCustomerPage.getAlertText();
        Assert.assertTrue(actualRes.contains(expectedRes));
        addCustomerPage.clickAlertOkButton();

        homePage.clickOnHomeButton();
        homePage.waitForLoading();
        homePage.clickOnCustomerLoginButton();

        CustomerLoginPage customerLoginPage = new CustomerLoginPage(app.driver);
        customerLoginPage.waitForLoading();
        customerLoginPage.selectExistingUser(firstName + " " + lastName);
        customerLoginPage.clickOnLoginButton();

        accountPage = new AccountPage(app.driver);
        accountPage.waitForLoading();


    }

}
