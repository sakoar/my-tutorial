package com.lexmark.automation.test.PageObject.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObject_AddShippingLink {
public PageObject_AddShippingLink(WebDriver driver) { //Constructor of Class
		PageFactory.initElements(driver,this);
		}

/************************Details of Home page**********************/
@FindBy(xpath="//li[3]/a/span[2]")
public WebElement portal_admin_link;
@FindBy(linkText="Carrier Management")
public WebElement carrier_mgmt_link;
@FindBy(xpath="//button[@type='button']")
public WebElement add_carrier_link_button1;
@FindBy(name="carrierName")
public WebElement carrier_name;
@FindBy(name="trackingUrl")
public WebElement tracking_Url;
@FindBy(css="button.btn.btn--primary")
public WebElement add_carrier_link_button2;
@FindBy(xpath="(//a[contains(text(),'Delete value')])[2]")
public WebElement delete_value_link;



}
