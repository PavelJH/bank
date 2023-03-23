package pages.bankManagerLogin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;
import pages.wait.Wait;

public class BankManagerLoginPage extends PageBase {

    public BankManagerLoginPage(WebDriver driver) {
        super(driver);
    }

    Wait wait;
    @FindBy(xpath = "//*[@ng-click='addCust()']")
    protected WebElement addCustomerTab;

    @FindBy(xpath = "//*[@ng-click='openAccount()']")
    protected WebElement openAccountTab;

    @FindBy(xpath = "//*[@ng-click='showCust()']")
    protected WebElement customersTab;

    public void waitForLoading() {// проверка на все елементы на HomePage
        wait = new Wait(driver);
        wait.forVisibility(addCustomerTab);
        wait.forVisibility(openAccountTab);
        wait.forVisibility(customersTab);
        //wait.forVisibility();
    }

    public void openAddCustomerTab() {
        click(addCustomerTab);
    }

    public void openAccountTab() {
        click(openAccountTab);
    }

    public void openCustomersTab() {
        click(customersTab);
    }
}
