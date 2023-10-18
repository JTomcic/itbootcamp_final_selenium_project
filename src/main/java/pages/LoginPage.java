package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage{
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getEmailInput() {
        return driver.findElement(By.id("email"));
    }
    public String getEmailInputTypeAttribute() {
        return getEmailInput().getAttribute("type");
    }
    public WebElement getPasswordInput() {
        return driver.findElement(By.id("password"));
    }
    public String getPasswordInputTypeAttribute() {
        return getPasswordInput().getAttribute("type");
    }
}