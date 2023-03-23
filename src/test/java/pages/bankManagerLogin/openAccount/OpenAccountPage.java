package pages.bankManagerLogin.openAccount;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;
import pages.wait.Wait;

public class OpenAccountPage extends PageBase {
    public OpenAccountPage(WebDriver driver) {
        super(driver);
    }

    Wait wait;

    public class AddCustomer extends PageBase {
        public AddCustomer(WebDriver driver) {
            super(driver);
        }

        @FindBy(xpath = "//select[@id='userSelect']")
        protected WebElement customerNameDropdown;
        @FindBy(xpath = "//select[@id='currency']")
        protected WebElement currencyDropdown;
        @FindBy(xpath = "//button[normalize-space()='Process']")
        protected WebElement processButton;

        public void waitForLoading() {
            wait = new Wait(driver);
            wait.forVisibility(customerNameDropdown);
            wait.forVisibility(currencyDropdown);
            wait.forVisibility(processButton);
        }

        public void selectExistingUser(String userName) {
            //Select selectUser = new Select((customerNameDropdown));
            selectOption(userName, customerNameDropdown);
        }

        public void selectCurrency(String currency) {
            //Select selectCurrency = new Select((currencyDropdown));
            selectOption(currency, currencyDropdown);
        }

        public void clickOnProcessButton() {
            click(processButton);
        }
    }
}
