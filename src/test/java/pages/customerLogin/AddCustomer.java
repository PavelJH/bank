package pages.customerLogin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;
import pages.wait.Wait;

public class AddCustomer extends PageBase {


    Wait wait;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    protected WebElement firstNameField;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    protected WebElement lastManeField;
    @FindBy(xpath = "//input[@placeholder='Post Code']")
    protected WebElement postCodeField;

    @FindBy(xpath = "//button[@type='submit']")
    protected WebElement addCustomerButton;

    public AddCustomer(WebDriver driver) {
        super(driver);
    }

    public void waitForLoading() {
        wait = new Wait(driver);
        wait.forVisibility(firstNameField);
        wait.forVisibility(lastManeField);
        wait.forVisibility(postCodeField);
        wait.forVisibility(addCustomerButton);
    }

    public void fillAddCustomerForm(String firstName, String lastName, String postCode) {
        fillField(firstNameField, firstName);
        fillField(lastManeField, lastName);
        fillField(postCodeField, postCode);
    }

    public void clickOnAddCustomerButton() {
        click(addCustomerButton);
    }
}
