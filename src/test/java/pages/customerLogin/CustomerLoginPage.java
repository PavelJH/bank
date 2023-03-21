package pages.customerLogin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;
import pages.wait.Wait;

public class CustomerLoginPage extends PageBase {
    public CustomerLoginPage(WebDriver driver) {
        super(driver);
    }

    Wait wait;


    @FindBy(id = "userSelect")
    protected WebElement userSelect;

    @FindBy(xpath = "//*[@type='submit']")
    protected WebElement loginButton;

    public void waitForLoading() {// проверка на все елементы на HomePage
        wait = new Wait(driver);
        wait.forVisibility(userSelect);
        //wait.forVisibility();
    }

    public void selectExistingUser(String userName) {
        selectOption(userName, userSelect);
    }

    public void clickOnLoginButton() {
        click(loginButton);
    }

    public void checkForVisibilityLoginButton() {
        wait = new Wait(driver);
        wait.forVisibility(loginButton);
    }
}