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
    public WebElement getESButton() {
        return driver.findElement(By.cssSelector(".btnES"));
    }
    public void clickOnESButton() {
        getESButton().click();
    }
    public WebElement getCNButton() {
        return driver.findElement(By.cssSelector(".btnCN"));
    }
    public void clickOnCNButton() {
        getCNButton().click();
    }
    public WebElement getFRButton() {
        return driver.findElement(By.cssSelector(".btnFR"));
    }
    public void clickOnFRButton() {
        getFRButton().click();
    }
    public String getHeaderTitleText() {
        return driver.findElement(By.tagName("h1")).getText();
    }

    public WebElement getNavLoginLink() {
        return driver.findElement(By.xpath("//div[@class = 'v-toolbar__items']/a[3]"));
    }
    public void clickOnNavLoginLink() {
        getNavLoginLink().click();
    }
    public void waitForRedirectionToLoginPage() {
        wait
                .withMessage("After click on Login should be redirected to Login page.")
                .until(ExpectedConditions.urlToBe("https://vue-demo.daniel-avellaneda.com/login"));
    }
    public WebElement getSignupLink() {
        return driver.findElement(By.xpath("//div[@class = 'v-toolbar__items']/a[4]"));
    }
    public void clickOnSignupLink() {
        getSignupLink().click();
    }
    public void waitForRedirectionToSignupPage() {
        wait
                .withMessage("After click on Login should be redirected to Signup page.")
                .until(ExpectedConditions.urlToBe("https://vue-demo.daniel-avellaneda.com/signup"));
    }
}
