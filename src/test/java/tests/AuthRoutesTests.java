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
    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void forbidsVisitsToProfileUrlIfNotAuthenticated() {
        driver.navigate().to(baseUrl + "profile");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"),
                "Should be redirected to Login page.");
    }
    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void forbidsVisitsToAdminCitiesUrlIfNotAuthenticated() {
        driver.navigate().to(baseUrl + "admin/cities");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"),
                "Should be redirected to Login page.");
    }
    @Test(priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void forbidsVisitsToAdminUsersUrlIfNotAuthenticated() {
        driver.navigate().to(baseUrl + "admin/users");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"),
                "Should be redirected to Login page.");
    }
}
