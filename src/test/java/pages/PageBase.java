package pages;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class PageBase {
    public WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void click(WebElement element) {
        element.click();
    }

    public void selectOption(String optionName, WebElement selectElement) {
        Select select = new Select(selectElement);
        select.selectByVisibleText(optionName);
    }

    public void fillField(WebElement field, String text) {
        click(field);
        field.clear();
        field.sendKeys(text);
    }

    public String getAlertText() {
        return driver.switchTo().alert().getText();
    }

    public void clickAlertOkButton() {
        driver.switchTo().alert().accept();
    }

    public void takeAndCompareScreenshot(String actualScreenshotName, WebElement element) throws IOException {
        String referenceImageFilePath = "reference/" + actualScreenshotName + ".png";
        String tmpFilePath = "reference/tmp" + actualScreenshotName + ".png";
        File tmp;// переменую иницыализируем
        if (element == null) {
            tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);// скрин всей страницы и записывается в tmp(переменую)
        } else {
            tmp = element.getScreenshotAs(OutputType.FILE);
        }
        Files.copy(tmp.toPath(), new File(tmpFilePath).toPath(), StandardCopyOption.REPLACE_EXISTING);
        //File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); // скрин всего екрана
        File referenceImageFile = new File(referenceImageFilePath);
        if (!referenceImageFile.exists()) {
            throw new RuntimeException("Reference image file does not exist: " + referenceImageFile);
        }

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();// для того что бы узнать размеры(шырину и высоту)
        int screenWide = screenSize.width;
        int screenHeight = screenSize.height;

        double maxDiffPercent = 0.01 * screenWide * screenHeight;

        ProcessBuilder pb = new ProcessBuilder("compare", "-metric", "AE", referenceImageFilePath, tmpFilePath, "null:");
        Process process = pb.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        String line;
        double difference = 0;
        while ((line = reader.readLine()) != null) {
            difference = Integer.parseInt(line.trim());
        }
        reader.close();
        process.destroy();

        if (difference > maxDiffPercent) {
            throw new RuntimeException("Screenshot are diff");
        }
        Files.deleteIfExists(new File(tmpFilePath).toPath());
    }
}

