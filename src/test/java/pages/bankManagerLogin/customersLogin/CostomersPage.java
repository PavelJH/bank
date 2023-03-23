package pages.bankManagerLogin.customersLogin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;
import pages.wait.Wait;

public class CostomersPage extends PageBase {
    public CostomersPage(WebDriver driver) {
        super(driver);
    }

    Wait wait;
    @FindBy(id = "userSelect")
    private WebElement userSelect;
    @FindBy(xpath = "//*[@type='submit']")
    private WebElement loginButton;

    public void waitForLoading() {// проверка на все елементы на HomePage
        wait = new Wait(driver);
        wait.forVisibility(userSelect);
        wait.forVisibility(loginButton);
    }

    public void selectExistingUser(String userName) {// не должно быть данных
        selectOption(userName, userSelect);
    }

    public void clickOnLoginButton() {
        click(loginButton);
    }
}
