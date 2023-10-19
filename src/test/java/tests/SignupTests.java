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

}
