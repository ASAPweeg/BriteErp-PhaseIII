package com.briteerp.pages;

import com.briteerp.utilities.ConfigurationReader;
import com.briteerp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeAndSignInPage {

    public HomeAndSignInPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText = "BriteErpDemo")
    public WebElement databaseSelector;

    @FindBy(id = "login")
    public WebElement email;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement logInButton;

    @FindBy(xpath = "//a[@data-menu-xmlid='sale.sale_menu_root']")
    public WebElement salesButton;

    /**
     * Logs manager in and takes them to the sales portion of the website.
     */
    public void managerLogIn() {
        databaseSelector.click();
        email.sendKeys(ConfigurationReader.getProperty("salesmanager_email"));
        password.sendKeys(ConfigurationReader.getProperty("salesmanager_password"));
        logInButton.click();
        salesButton.click();
    }

    /**
     * Logs manager in and takes them to the sales portion of the website.
     */
    public void userLogIn() {
        databaseSelector.click();
        email.sendKeys(ConfigurationReader.getProperty("salesuser_email"));
        password.sendKeys(ConfigurationReader.getProperty("salesuser_password"));
        logInButton.click();
        salesButton.click();
    }

}
