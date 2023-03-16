package pages.bankManagerLogin.customers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;

public class CostomersPage extends PageBase {
    public CostomersPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userSelect")
    private WebElement userSelect;
    @FindBy(xpath = "//*[@type='submit']")
    private WebElement loginButton;

    public void selectExistingUser(String userName) {// не должно быть данных
        selectOption(userName, userSelect);
    }

    public void clickOnLoginButton() {
        click(loginButton);
    }
}
