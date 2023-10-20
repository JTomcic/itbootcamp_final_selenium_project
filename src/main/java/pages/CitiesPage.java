package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitiesPage extends BasicPage {
    public CitiesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getNewItemButton() {
        return driver.findElement(By.cssSelector(".btnNewItem"));
    }
    public void clickOnNewItemButton() {
        getNewItemButton().click();
    }
    public WebElement getNeItemMenuContent() {
        return driver.findElement(By.cssSelector(".dlgNewEditItem"));
    }

    public void waitForVisibilityOfNewItemMenu() {
        wait
                .withMessage("After click on New Item button should be visible New Item menu.")
                .until(ExpectedConditions.visibilityOf(getNeItemMenuContent()));
    }
    public WebElement getNameInput() {
        return driver.findElement(By.id("name"));
    }
    public String getCityInputFieldTypeAttribute() {
        return getNameInput().getAttribute("type");
    }
    public void clearAndTypeCityName(String city) {
        getNameInput().clear();
        getNameInput().sendKeys(city);
    }
    public WebElement getSaveButton() {
        return driver.findElement(By.cssSelector(".btnSave"));
    }
    public void clickOnSaveButton() {
        getSaveButton().click();
    }
}
