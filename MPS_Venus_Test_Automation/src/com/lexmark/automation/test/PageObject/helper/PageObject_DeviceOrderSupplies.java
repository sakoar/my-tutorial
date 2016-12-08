package com.lexmark.automation.test.PageObject.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObject_DeviceOrderSupplies {
	public PageObject_DeviceOrderSupplies(WebDriver driver) { //Constructor of Class
		PageFactory.initElements(driver,this);
}

@FindBy(linkText="Devices")
public WebElement DevicesTab;

//See if default search option is Serial no or not
@FindBy(xpath="//*[@id='deviceListTab']/div[3]/div[1]/div/div/div[1]/div[1]/div/div/div[2]/span")
public WebElement DefaultSerialNoSelection;

//Search box
@FindBy(xpath="(//input[@type='text'])[3]")  
public WebElement SearchInput;
//Search Button
@FindBy(css="button.search")
public WebElement SearchButton; //These completes device search
public void searchDevice(String deviceNumber) throws InterruptedException{
DevicesTab.click();
Thread.sleep(3000);
SearchInput.sendKeys(deviceNumber);
SearchButton.click();
Thread.sleep(4000);
}


//Searching Through Device--->Supply Orders--------
//@FindBy(linkText="Supply orders")
@FindBy(linkText="orderTab")
public WebElement Supply_orders_tab;
@FindBy(xpath="(//input[@type='text'])[3]")
public WebElement Orderno_search_field;
@FindBy(css="button.search")
public WebElement order_search_icon;
@FindBy(linkText="1-166570093171")
public WebElement selected_order;
@FindBy(css="div.status-state-date.ng-binding")
public WebElement date_submission_page;
@FindBy(css="li.info-list__item.ng-scope > div.info-list__item-value.ng-binding")
public WebElement serial_submission_page;

	
	
	
	
}