package com.briteerp.tests.smoke_tests;

import com.briteerp.pages.LogInPage;
import com.briteerp.tests.TestBase;
import com.briteerp.utilities.BrowserUtils;
import com.briteerp.utilities.ConfigurationReader;
import com.briteerp.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SalesTest extends TestBase {

    @Test (groups = "smoke")
    public void salesPageTest() {
        LogInPage logInPage = new LogInPage();
        WebDriverWait wait = new WebDriverWait(driver, 15);

        // check that the user is redirected to the database selector page
        String dBase = driver.getCurrentUrl();
        Assert.assertTrue(dBase.contains("database") && dBase.contains("selector"));

        // check that once the database is selected, the user is directed to the login page
        logInPage.databaseSelector.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("login") && driver.getTitle().contains("Login"));
        // also check that is the correct database is selected
        Assert.assertEquals("BriteErpDemo", logInPage.currentDatabase.getAttribute("value"));

        // assert that the user is redirected to the user inbox after logging in
        logInPage.email.sendKeys(ConfigurationReader.getProperty("salesmanager_email"));
        logInPage.password.sendKeys(ConfigurationReader.getProperty("salesmanager_password") + Keys.ENTER);

        wait.until(ExpectedConditions.titleIs("#Inbox - Odoo"));
        Assert.assertEquals("#Inbox - Odoo", driver.getTitle());

        // check that Sales button goes to the correct page
        logInPage.salesButton.click();
        wait.until(ExpectedConditions.titleContains("Quotations"));
    }

    @Test (groups = "smoke")
    public void managersQuotationsTest(){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        LogInPage logInPage = new LogInPage();
        logInPage.managerLogIn();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//div[@data-menu-xmlid='sale.menu_sale_config']")));
        List<WebElement> headersEle = driver.findElements(By.xpath("/html/body/div/div/div/div[6]/div"));
        List<String> headers = new ArrayList<>();
        List<String> actualHeaders = new ArrayList<>(Arrays.asList("Orders", "Invoicing", "Catalog", "Reporting", "Configuration"));

        for(WebElement temp : headersEle) {
            headers.add(temp.getText());

        }

        Assert.assertEquals(headers, actualHeaders);
    }

    @Test (groups = "smoke")
    public void usersQuotationsTest(){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        LogInPage logInPage = new LogInPage();
        logInPage.userLogIn();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//div[@data-menu-xmlid='sale.product_menu_catalog']")));
        List<WebElement> headersEle = driver.findElements(By.xpath("/html/body/div/div/div/div[6]/div"));
        List<String> headers = new ArrayList<>();
        List<String> actualHeaders = new ArrayList<>(Arrays.asList("Orders", "Invoicing", "Catalog"));

        for(WebElement temp : headersEle) {
            headers.add(temp.getText());
            System.out.println(temp.getText());
        }

        Assert.assertEquals(headers, actualHeaders);
    }
}
