package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.wait.Wait;

public class HomePage extends PageBase {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    Wait wait;
    @FindBy(xpath = "//*[@ng-click='home()']")
    protected WebElement homeButton;

    @FindBy(xpath = "//button[normalize-space()='Customer Login']")
    protected WebElement customerLoginButton;

    @FindBy(xpath = "//*[@ng-click='manager()']")
    protected WebElement bankManagerLoginButton;

    public void clickOnHomeButton() {
        click(homeButton);
    }

    public void waitForLoading() {// проверка на все елементы на HomePage
        wait = new Wait(driver);
        wait.forVisibility(homeButton);
        wait.forVisibility(customerLoginButton);
        wait.forVisibility(bankManagerLoginButton);
        //wait.forVisibility();
    }

    public void clickOnCustomerLoginButton() {
        click(customerLoginButton);
    }

    public void clickOnBankManagerLoginButton() {
        click(bankManagerLoginButton);
    }


}
