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
}
