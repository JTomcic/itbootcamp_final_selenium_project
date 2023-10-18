package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage extends BasicPage {
    public NavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getLanguageMenuButton() {
        return driver.findElement(By.cssSelector(".btnLocaleActivation"));
    }
    public void clickOnLanguageButton() {
        getLanguageMenuButton().click();
    }
    public WebElement getLanguageMenuContent() {
        return driver.findElement(By.cssSelector(".menuable__content__active"));
    }
    public void waitForVisibilityOfLanguageMenu() {
        wait
                .withMessage("After click on language button should be visible language menu.")
                .until(ExpectedConditions.visibilityOf(getLanguageMenuContent()));
    }
    public WebElement getENButton() {
        return driver.findElement(By.cssSelector(".btnEN"));
    }
    public void clickOnENButton() {
        getENButton().click();
    }
    public WebElement getNavLoginLink() {
        return driver.findElement(By.xpath("//div[@class = 'v-toolbar__items']/a[3]"));
//        .flex > button
    }
    public void clickOnNavLoginLink() {
        getNavLoginLink().click();
    }
    public void waitForRedirectionToLoginPage() {
        wait
                .withMessage("After click on Login should be redirected to Login page.")
                .until(ExpectedConditions.urlToBe("https://vue-demo.daniel-avellaneda.com/login"));
    }
}
