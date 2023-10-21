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
    @Test (priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void checksInputTypesForCreateEditNewCity() {
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

        citiesPage.clickOnNewItemButton();
        citiesPage.waitForVisibilityOfNewItemMenu();
        Assert.assertEquals(citiesPage.getCityInputFieldTypeAttribute(), "text",
                "City input field type should be 'text'");
    }
    @Test (priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void createNewCity() {
        String adminEmail = "admin@admin.com";
        String adminPassword = "12345";
        String city = "Jovana Tomcic's city";

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

        citiesPage.clickOnNewItemButton();
        citiesPage.waitForVisibilityOfNewItemMenu();
        Assert.assertEquals(citiesPage.getCityInputFieldTypeAttribute(), "text",
                "City input field type should be 'text'");

        citiesPage.clearAndTypeCityName(city);
        citiesPage.clickOnSaveButton();
        messagePopUpPage.waitUntilPopUpMessageForNewItemIsVisible();
        Assert.assertTrue(messagePopUpPage.getTextFromPopUpMessageForNewItem().contains("Saved successfully"),
                "Pop-up message text should be 'Saved successfully'.");
    }
    @Test (priority = 5, retryAnalyzer = RetryAnalyzer.class)
    public void editCity() {
        String adminEmail = "admin@admin.com";
        String adminPassword = "12345";
        String oldCityName = "Jovana Tomcic's city";
        String newCityName = "Jovana Tomcic's city Edited";

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

        citiesPage.clearAndTypeOldCityName(oldCityName);
        citiesPage.waitForNumberRowsInTable(1);
        citiesPage.clickOnEditButton();
        citiesPage.waitForVisibilityOfEditDialog();
        citiesPage.clearAndTypeNewCityName(newCityName);
        citiesPage.clickOnSaveButton();
        messagePopUpPage.waitUntilPopUpMessageForNewItemIsVisible();
        Assert.assertTrue(messagePopUpPage.getTextFromPopUpMessageForNewItem().contains("Saved successfully"),
                "Pop-up message text should be 'Saved successfully'.");
    }
    @Test (priority = 6, retryAnalyzer = RetryAnalyzer.class)
    public void searchCity() {
        String adminEmail = "admin@admin.com";
        String adminPassword = "12345";
        String cityName = "Jovana Tomcic's city Edited";

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

        citiesPage.clearAndTypeOldCityName(cityName);
        citiesPage.waitForNumberRowsInTable(1);
        Assert.assertEquals(citiesPage.getTextFromCellFromRow(1,2), cityName,
                "City name in first row should be" + cityName);
    }
    @Test (priority = 7, retryAnalyzer = RetryAnalyzer.class)
    public void deleteCity() {
        String adminEmail = "admin@admin.com";
        String adminPassword = "12345";
        String cityName = "Jovana Tomcic's city Edited";

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

        citiesPage.clearAndTypeOldCityName(cityName);
        citiesPage.waitForNumberRowsInTable(1);
        Assert.assertEquals(citiesPage.getTextFromCellFromRow(1,2), cityName,
                "City name in first row should be" + cityName);

        citiesPage.clickOnDeleteButton();
        citiesPage.waitForVisibilityOfDeleteDialog();
        citiesPage.clickOnDeleteButtonFromDeleteDialog();
        messagePopUpPage.waitUntilPopUpMessageAfterDeleteIsVisible();
        Assert.assertTrue(messagePopUpPage.getTextFromPopUpMessageForDelete(),
                "Pop up message should contain text 'Deleted successfully'.");
    }
}
