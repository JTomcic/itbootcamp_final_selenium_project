package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage{
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getEmailInput() {
        return driver.findElement(By.id("email"));
    }
    public void clearAndTypeEmail(String email) {
        getEmailInput().clear();
        getEmailInput().sendKeys(email);
    }
    public String getEmailInputTypeAttribute() {
        return getEmailInput().getAttribute("type");
    }
    public WebElement getPasswordInput() {
        return driver.findElement(By.id("password"));
    }
    public void clearAndTypePassword(String password) {
        getPasswordInput().clear();
        getPasswordInput().sendKeys(password);
    }
    public String getPasswordInputTypeAttribute() {
        return getPasswordInput().getAttribute("type");
    }
    public WebElement getLoginButton() {
        return driver.findElement(By.xpath("//button[@type = 'submit']"));
    }
    public void clickOnLoginButton() {
        getLoginButton().click();
    }
    public void waitForRedirectionToHomePage() {
        wait
                .withMessage("After click on Login URL should be 'https://vue-demo.daniel-avellaneda.com/home'.")
                .until(ExpectedConditions.urlToBe("https://vue-demo.daniel-avellaneda.com/home"));
    }
    public WebElement getLogoutButton() {
        return driver.findElement(By.cssSelector(".btnLogout"));
    }
    public void clickOnLogoutButton() {
        getLogoutButton().click();
    }
    public void waitForVisibilityOfLogoutButton() {
        wait
                .withMessage("Logout button should be visible.")
                .until(ExpectedConditions.visibilityOf(getLogoutButton()));
    }
    public WebElement getAdminLink() {
        return driver.findElement(By.cssSelector(".btnAdmin"));
    }
    public void clickOnAdminLink() {
        getAdminLink().click();
    }
    public WebElement getAdminMenuContent() {
        return driver.findElement(By.cssSelector(".btnAdminCities"));
    }

    public void waitForVisibilityOfAdminMenu() {
        wait
                .withMessage("After click on Admin button should be visible admin menu.")
                .until(ExpectedConditions.visibilityOf(getAdminMenuContent()));
    }
    public WebElement getCitiesButtonFromAdminList() {
        return driver.findElement(By.cssSelector(".btnAdminCities"));
    }
    public void clickOnCitiesButtonFromAdminList() {
        getCitiesButtonFromAdminList().click();
    }
    public void waitForRedirectionToAdminCitiesPage() {
        wait
                .withMessage("After click on button Cities" +
                        "url should be 'https://vue-demo.daniel-avellaneda.com/admin/cities'.")
                .until(ExpectedConditions.urlToBe("https://vue-demo.daniel-avellaneda.com/admin/cities"));
    }
}
