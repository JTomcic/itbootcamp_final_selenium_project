package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class LocaleTests extends BasicTest {
    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void setLocaleToES() {
        navPage.clickOnLanguageButton();
        navPage.waitForVisibilityOfLanguageMenu();
        navPage.clickOnESButton();
        Assert.assertEquals(navPage.getHeaderTitleText(),
                "Página de aterrizaje",
                "After click on ES button the header title should be 'Página de aterrizaje'.");
    }
    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void setLocaleToEN() {
        navPage.clickOnLanguageButton();
        navPage.waitForVisibilityOfLanguageMenu();
        navPage.clickOnENButton();
        Assert.assertEquals(navPage.getHeaderTitleText(),
                "Landing",
                "After click on EN button the header title should be 'Landing'.");
    }
    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void setLocaleToCN() {
        navPage.clickOnLanguageButton();
        navPage.waitForVisibilityOfLanguageMenu();
        navPage.clickOnCNButton();
        Assert.assertEquals(navPage.getHeaderTitleText(),
                "首页",
                "After click on CN button the header title should be '首页'.");
    }
}
