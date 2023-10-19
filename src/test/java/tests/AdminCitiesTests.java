package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class AdminCitiesTests extends BasicTest {
    @Test (priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void verifyTheUrl() {
        Assert.assertEquals(
                driver.getCurrentUrl(),
                baseUrl,
                "Should be redirected to 'https://vue-demo.daniel-avellaneda.com/'.");
    }
    @Test (priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void visitsTheAdminCitiesPage() {
        String adminEmail = "admin@admin.com";
        String adminPassword = "12345";

        navPage.clickOnNavLoginLink();
        navPage.waitForRedirectionToLoginPage();

        loginPage.clearAndTypeEmail(adminEmail);
        loginPage.clearAndTypePassword(adminPassword);
        loginPage.clickOnLoginButton();
        loginPage.waitForRedirectionToHomePage();
        Assert.assertEquals(
                driver.getCurrentUrl(),
                baseUrl + "home",
                "URL should still be 'https://vue-demo.daniel-avellaneda.com/home'.");

        loginPage.clickOnAdminLink();
        loginPage.waitForVisibilityOfAdminMenu();

        loginPage.clickOnCitiesButtonFromAdminList();
        loginPage.waitForRedirectionToAdminCitiesPage();

        Assert.assertEquals(
                driver.getCurrentUrl(),
                baseUrl + "admin/cities",
                "Should be redirected to Admin Cities page.");
    }
}
