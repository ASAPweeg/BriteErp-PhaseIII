package com.briteerp.pages;

import com.briteerp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PricelistsPage {
    public PricelistsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath ="//a[@data-menu-xmlid='sale.menu_product_pricelist_main']" )
    public WebElement pricelistsButton;

    LogInPage pricelistPage = new LogInPage();


}
