package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class AuthRoutesTests extends BasicTest{
    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void forbidsVisitsToHomeUrlIfNotAuthenticated() {
        driver.navigate().to(baseUrl + "home");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"),
                "Should be redirected to Login page.");
    }
}
