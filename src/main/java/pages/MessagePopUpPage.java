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
}