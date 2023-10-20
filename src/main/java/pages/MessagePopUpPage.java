package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePopUpPage extends BasicPage{
    public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getPopUpMessage () {
        return driver.findElement(By.cssSelector(".v-snack__content ul li"));
    }

    public void waitUntilPopUpMessageIsVisible () {
        wait
                .withMessage("Pop-up message should be visible.")
                .until(ExpectedConditions.visibilityOf(getPopUpMessage()));
    }
    public String getTextFromPopUpMessage () {
        return getPopUpMessage().getText();
    }
    public void waitUntilDialogIsVisible () {
        wait
                .withMessage("Dialog should be visible.")
                .until(ExpectedConditions.visibilityOf(getDialogTitle()));
    }
    public WebElement getDialogTitle() {
        return driver.findElement(By.cssSelector(".dlgVerifyAccount"));
    }
    public String getTextFromDialogTitle () {
        return getDialogTitle().getText();
    }
    public WebElement getCloseButton () {
        return driver.findElement(By.cssSelector(".btnClose"));
    }
    public void clickOnCloseButton () {
        getCloseButton().click();
    }
    public WebElement getPopUpMessageForNewItem () {
        return driver.findElement(By.cssSelector(".success .v-snack__content"));
    }

    public void waitUntilPopUpMessageForNewItemIsVisible () {
        wait
                .withMessage("Pop-up message should be visible.")
                .until(ExpectedConditions.visibilityOf(getPopUpMessageForNewItem()));
    }
    public String getTextFromPopUpMessageForNewItem () {
        return getPopUpMessageForNewItem().getText();
    }
}
