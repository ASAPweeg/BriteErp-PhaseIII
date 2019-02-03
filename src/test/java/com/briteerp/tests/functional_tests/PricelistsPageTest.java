package com.briteerp.tests.functional_tests;

import com.briteerp.pages.HomeAndSignInPage;
import com.briteerp.pages.PricelistsPage;
import com.briteerp.tests.TestBase;
import com.briteerp.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PricelistsPageTest extends TestBase {

    @Test



    public void Test()throws InterruptedException{

        HomeAndSignInPage homeAndSignInPage = new HomeAndSignInPage();

        homeAndSignInPage.managerLogIn();
        PricelistsPage  pricelistsPage = new PricelistsPage();
        Thread.sleep(5000);
        pricelistsPage.pricelistsButton.click();
        Thread.sleep(5000);
        Assert.assertEquals(driver.getTitle(),"Pricelists - Odoo");

    }



}
