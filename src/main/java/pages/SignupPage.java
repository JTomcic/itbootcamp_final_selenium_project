package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage extends BasicPage {
    public SignupPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getNameInput() {
        return driver.findElement(By.id("name"));
    }
    public void clearAndTypeName(String name) {
        getNameInput().clear();
        getNameInput().sendKeys(name);
    }
    public String getNameInputTypeAttribute() {
        return getNameInput().getAttribute("type");
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
    public WebElement getConfirmPasswordInput() {
        return driver.findElement(By.id("confirmPassword"));
    }
    public void clearAndTypeConfirmPassword(String email) {
        getConfirmPasswordInput().clear();
        getConfirmPasswordInput().sendKeys(email);
    }
    public String getConfirmPasswordInputTypeAttribute() {
        return getConfirmPasswordInput().getAttribute("type");
    }
}
