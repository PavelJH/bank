package tests.login;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.customerLogin.CustomerLoginPage;
import pages.customerLogin.account.AccountPage;
import tests.TestBase;

public class CostumerLoginTest extends TestBase {

    HomePage homepage;
    CustomerLoginPage customerPage;
    AccountPage accountPage;
    String userName = "Harry Potter";
    String userNameNoExist = "Pavlo Kelbas";

    @Test
    public void loginExistingUser() {
        homepage = new HomePage(app.driver);
        homepage.waitForLoading();
        homepage.clickOnCustomerLoginButton();

        customerPage = new CustomerLoginPage(app.driver);
        customerPage.waitForLoading();
        customerPage.selectExistingUser(userName);
        customerPage.checkForVisibilityLoginButton();
        customerPage.clickOnLoginButton();

        accountPage = new AccountPage(app.driver);
        accountPage.waitForLoading();
    }

    @Test
    public void loginWithoutSelectingUser() {
        homepage = new HomePage(app.driver);
        homepage.waitForLoading();
        homepage.clickOnCustomerLoginButton();

        customerPage = new CustomerLoginPage(app.driver);
        customerPage.waitForLoading();

        customerPage.foundLoginButton();
    }
}
