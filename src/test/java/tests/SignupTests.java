package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class SignupTests extends BasicTest{
    @Test (priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void verifyTheUrl() {
        Assert.assertEquals(
                driver.getCurrentUrl(),
                baseUrl,
                "Should be redirected to 'https://vue-demo.daniel-avellaneda.com/'.");
    }
    @Test (priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void visitsTheSignupPage() {
        navPage.clickOnSignupLink();
        Assert.assertEquals(
                driver.getCurrentUrl(),
                baseUrl + "signup",
                "Should be redirected to Signup page.");
    }
    @Test (priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void checksInputTypes() {
        navPage.clickOnSignupLink();
        Assert.assertEquals(
                driver.getCurrentUrl(),
                baseUrl + "signup",
                "Should be redirected to Signup page.");

        Assert.assertEquals(signupPage.getNameInputTypeAttribute(), "text",
                "Name input type should be 'text'");
        Assert.assertEquals(signupPage.getEmailInputTypeAttribute(), "email",
                "Email input type should be 'email'");
        Assert.assertEquals(signupPage.getPasswordInputTypeAttribute(), "password",
                "Password input type should be 'password'");
        Assert.assertEquals(signupPage.getConfirmPasswordInputTypeAttribute(), "password",
                "Confirm password input type should be 'password'");
    }
    @Test (priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void displaysErrorWhenUserAlreadyExists() {
        String name = "Another User";
        String email = "admin@admin.com";
        String password = "12345";
        String confirmPassword = "12345";

        navPage.clickOnSignupLink();
        Assert.assertEquals(
                driver.getCurrentUrl(),
                baseUrl + "signup",
                "Should be redirected to Signup page.");

        signupPage.clearAndTypeName(name);
        signupPage.clearAndTypeEmail(email);
        signupPage.clearAndTypePassword(password);
        signupPage.clearAndTypeConfirmPassword(confirmPassword);
        signupPage.clickOnSignUpButton();

        messagePopUpPage.waitUntilPopUpMessageIsVisible();
        Assert.assertEquals(
                messagePopUpPage.getTextFromPopUpMessage(),
                "E-mail already exists",
                "Pop-up error message text should be 'E-mail already exists'.");

        Assert.assertEquals(
                driver.getCurrentUrl(),
                baseUrl + "signup",
                "Current page should still be Signup page.");
    }
    @Test (priority = 5, retryAnalyzer = RetryAnalyzer.class)
    public void signup() {
        String name = "Milica Milicic";
        String email = "milica.milicic@itbootcamp.rs";
        String password = "12345";
        String confirmPassword = "12345";

        navPage.clickOnSignupLink();
        Assert.assertEquals(
                driver.getCurrentUrl(),
                baseUrl + "signup",
                "Should be redirected to Signup page.");

        signupPage.clearAndTypeName(name);
        signupPage.clearAndTypeEmail(email);
        signupPage.clearAndTypePassword(password);
        signupPage.clearAndTypeConfirmPassword(confirmPassword);
        signupPage.clickOnSignUpButton();
        loginPage.waitForRedirectionToHomePage();

        Assert.assertEquals(
                driver.getCurrentUrl(),
                baseUrl + "home",
                "URL should still be 'https://vue-demo.daniel-avellaneda.com/home'.");

        messagePopUpPage.waitUntilDialogIsVisible();
        Assert.assertEquals(
                messagePopUpPage.getTextFromDialogTitle(),
                "IMPORTANT: Verify your account",
                "Pop-up error message text should be 'IMPORTANT: Verify your account'.");

        messagePopUpPage.clickOnCloseButton();
        loginPage.clickOnLogoutButton();
    }
}
