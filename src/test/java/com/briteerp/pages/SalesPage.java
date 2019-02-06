package com.briteerp.pages;

import com.briteerp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class SalesPage {
    public SalesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//a[@data-menu-xmlid='sale.menu_sale_quotations']")
    public WebElement quotationsButton;

    @FindBy (xpath = "//a[@data-menu-xmlid='sale.menu_sale_order']")
    public WebElement ordersButton;

    @FindBy (xpath = "//a[@data-menu-xmlid='sale.res_partner_menu']")
    public WebElement customersButton;

    @FindBy (xpath = "//a[@data-menu-xmlid='sale.menu_product_pricelist_main']")
    public WebElement priceList;

    @FindBy (xpath = "//button[@aria-label='list']")
    public WebElement listViewButton;

    @FindBy (xpath = "//button[@aria-label='kanban']")
    public WebElement kanbanViewButton;

    @FindBy (xpath = "//button[@aria-label='calendar']")
    public WebElement calendarViewButton;

}
