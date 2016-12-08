package com.lexmark.automation.test.PageObject.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjectDeviceServiceRequest {
	public PageObjectDeviceServiceRequest(WebDriver driver) { //Constructor of Class
		PageFactory.initElements(driver,this);
		}
	
//#########PageDevice Management - Device Details Page########
@FindBy(linkText="Devices")
public WebElement devices_tab;
@FindBy(xpath="(//input[@type='text'])[3]")
public WebElement search_field;
@FindBy(xpath="(//input[@type='text'])[3]")
public WebElement search_icon;

public void searchDevice(String deviceNo) throws InterruptedException{
	devices_tab.click();
	Thread.sleep(4000);
	search_field.sendKeys(deviceNo);
	Thread.sleep(3000);
	search_icon.click();
}
//###########################
@FindBy(css="div.btns > button.btn.ng-scope")
//css=div.btns > button.btn.ng-scope
//@FindBy(xpath="//button[text()='request service']")
public WebElement request_service_button;

//######Next Page details#######

@FindBy(name="buildingName")
public WebElement building;
@FindBy(name="floorName")
public WebElement floor;
@FindBy(name="siteName")
public WebElement office;
@FindBy(name="description")
public WebElement desc;
@FindBy(css="button[type='submit']")
public WebElement review_button;

//############################Additional Detail Page details
@FindBy(name="internalReferenceId")
public WebElement refId;
@FindBy(css="button[type='submit']")
public WebElement submit_request_button;

//######################Request No Generation Page#####
@FindBy(css="span.ng-scope > span.ng-scope")
public WebElement request_no;
@FindBy(css="p.ng-binding")
public WebElement req_createdby1;
@FindBy(xpath="//div[2]/div/p")
public WebElement contact1;
@FindBy(css="div.info-list__item-value.ng-binding")
public WebElement reqfno1 ;
@FindBy(xpath="//li[3]/div[2]")
public WebElement serial_no1;
@FindBy(xpath="//li[4]/div[2]")
public WebElement ip_address1;
//@FindBy(css="div.ng-binding.ng-scope")
public WebElement service_address1;
@FindBy(xpath="//div[7]/div/div/ul/li/div[2]")
public WebElement desc_msg1;


//#####Searching through Service request Tab###########
@FindBy(linkText="Service requests")
public WebElement service_req_tab;
@FindBy(xpath="(//input[@type='text'])[2]")
public WebElement req_no_search_field;
@FindBy(css="button.search.hover")
public WebElement req_search_icon;
@FindBy(css="div.status-state-date.ng-binding")
public WebElement date1;
//@FindBy(xpath="//div[contains(@id,'-uiGrid-')")
//public WebElement date2;
//@FindBy(css="li.info-list__item.ng-scope > div.info-list__item-value.ng-binding")
//@FindBy(xpath="/html/body/div[1]/div/div/div/div/div[2]/div[7]/div/div/ul/li[1]/div[2]")
@FindBy(className="info-list__item-value ng-binding")
public WebElement serial_no2;


//html/body/div[1]/div/div/div/div/div[2]/div[7]/div/div/ul/li[1]/div[2]
/*
//###############Searching through Request Tab#############
@FindBy(linkText="Requests")
public WebElement request_tab;
@FindBy(xpath="(//input[@type='text'])[3]")
public WebElement reqno_search_field;
@FindBy(css="button.search.focus")
public WebElement req_search_icon2;
//@FindBy(linkText=message1)
//public WebElement selected_item2;
*/

//###############Service request number Details Page######
@FindBy(css="div.well.well--no-shadow")
public WebElement req_createdby2;
@FindBy(xpath="//div[2]/div/p")
public WebElement contact2;
@FindBy(css="div.info-list__item-value.ng-binding")
public WebElement reqfno2;
//@FindBy(css="li.info-list__item.ng-scope > div.info-list__item-value.ng-binding")
//public WebElement serial_no2;
@FindBy(xpath="//div[7]/div/div/ul/li[2]/div[2]")
public WebElement ip_address2;
@FindBy(xpath="//div[7]/div/div/ul/li[3]/div[2]")
public WebElement service_address2;
@FindBy(xpath="//div[10]/div/div/ul/li/div[2]")
public WebElement desc_msg2;


}
