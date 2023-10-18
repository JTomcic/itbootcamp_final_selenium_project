package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class LoginTests extends BasicTest {
    @Test (priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void verifyTheUrl() {
        Assert.assertEquals(
                driver.getCurrentUrl(),
                baseUrl,
                "Should be redirected to 'https://vue-demo.daniel-avellaneda.com/'.");
    }
    @Test (priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void visitsTheLoginPage() {
        navPage.clickOnLanguageButton();
        navPage.waitForVisibilityOfLanguageMenu();
        navPage.clickOnENButton();

        navPage.clickOnNavLoginLink();
        Assert.assertEquals(
                driver.getCurrentUrl(),
                baseUrl + "login",
                "Should be redirected to Login page.");
    }
    @Test (priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void checksInputTypes() {
        navPage.clickOnNavLoginLink();
        navPage.waitForRedirectionToLoginPage();

        Assert.assertEquals(loginPage.getEmailInputTypeAttribute(), "email",
                "Email input type should be 'email'");
        Assert.assertEquals(loginPage.getPasswordInputTypeAttribute(), "password",
                "Password input type should be 'password'");
    }
    @Test (priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void displaysErrorWhenUserDoesNotExist() {
        String email = "non-existing-user@gmal.com";
        String password = "password123";

        navPage.clickOnNavLoginLink();
        navPage.waitForRedirectionToLoginPage();

        loginPage.clearAndTypeEmail(email);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();

        messagePopUpPage.waitUntilPopUpMessageIsVisible();
        Assert.assertEquals(
                messagePopUpPage.getTextFromPopUpMessage(),
                "User does not exists",
                "Pop-up error message text should be 'User does not exists'.");

        Assert.assertEquals(
                driver.getCurrentUrl(),
                baseUrl + "login",
                "Current page should still be Login page.");
    }
}
