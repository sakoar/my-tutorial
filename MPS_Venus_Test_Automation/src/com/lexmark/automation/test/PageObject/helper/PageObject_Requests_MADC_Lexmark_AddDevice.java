package com.lexmark.automation.test.PageObject.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageObject_Requests_MADC_Lexmark_AddDevice {
	
public PageObject_Requests_MADC_Lexmark_AddDevice(WebDriver driver) {
PageFactory.initElements(driver,this);
	}
	
//##########Home Page Details#######
@FindBy(linkText="Devices")
@CacheLookup
public WebElement device_tab; 
//###########Registering Device ##############
@FindBy(xpath="//button[text()='REGISTER DEVICE']")
public WebElement register_device_button; 
@FindBy(id="lexmark-device-question-yes")
public WebElement lexmark_device_yes; 
//@FindBy(xpath="//div[2]/label")
@FindBy(id="lexmark-device-question-no")
public WebElement lexmark_device_no; 
@FindBy(name="productModel")
public WebElement product_model_field;
@FindBy(name="serialNumber")
@CacheLookup
public WebElement serial_no; 
//@FindBy(name="productModel")
@FindBy(xpath="/html/body/div[1]/div/div/div/div/div[2]/div/div/form/div[1]/div[5]/select")
public WebElement product_no;  
//@FindBy(xpath="//div[132]/div/div/table/tbody/tr/td[3]")
@FindBy(xpath="(//input[@type='text'])[3]")
public WebElement date_select; 

//Select product from product list
public void productSelection() throws InterruptedException{
new Select(product_no).selectByIndex(1);
Thread.sleep(5000);
}

@FindBy(linkText="Please select an install address >")
public WebElement address_link; 

/*******Details of Address Install page**********/
@FindBy(xpath="(//input[@type='text'])[2]")
@CacheLookup
public WebElement address_input;
@FindBy(css="button.search")
public WebElement search_icon; 
@FindBy(xpath="//button[text()='Select Install Address']")
public WebElement select_install_address_button;

//########Next page details##########
@FindBy(name="buildingName")
@CacheLookup
public WebElement building; 
@FindBy(name="floorName")
@CacheLookup
public WebElement floor;
@FindBy(name="siteName")
@CacheLookup
public WebElement office;
@FindBy(name="ipAddress")
@CacheLookup
public WebElement ip_address;
@FindBy(name="hostName")
@CacheLookup
public WebElement hostname;
@FindBy(name="costCenter")
@CacheLookup
public WebElement cost_center;
@FindBy(name="customerDeviceTag")
public WebElement device_tag;
@FindBy(xpath="//button[@type='submit']")
public WebElement registration_submit_button1;

//#####Next Page Details after clicking  Registration Submit Button#######

@FindBy(css="div.info-list__item-value.ng-binding")
public WebElement serial_no1;
@FindBy(xpath="//li[3]/div[2]")
public WebElement adress_block1;
@FindBy(css="p.ng-binding")
public WebElement reqcreated_by_block1;
@FindBy(xpath="//div[2]/div/p")
public WebElement contact_block1;
@FindBy(name="internalReferenceId")
public WebElement ref_id1;
@FindBy(name="requestCostCenter")
public WebElement request_cost_center;
@FindBy(name="comments")
public WebElement user_comments;
@FindBy(xpath="//button[@type='submit']")
public WebElement registration_submit_button2;


//#######Final Page Details################################
@FindBy(xpath="//h2")
public WebElement message;
@FindBy(css="p.ng-binding")
public WebElement reqcreated_by_block2;
@FindBy(xpath="//div[2]/div/p")
public WebElement contact_block2;
//@FindBy(css="li.info-list__item.ng-scope > div.info-list__item-value.ng-binding")
//public WebElement serial_no2;
@FindBy(xpath="//div[7]/div/div/ul/li[3]/div[2]")
public WebElement adress_block2;

//Confirmation page SR DETAILS
		@FindBy(xpath="/html/body/div[1]/div/div/div/div/div[1]/div/div[3]/div/h1")  
		public WebElement submitPageMessage;
		@FindBy(css="span.ng-scope > span.ng-scope")  
		public WebElement submitPageMessage2;
		@FindBy(xpath="//h2")  
		public WebElement readSRNumber;

/*
//h2  Message     Details for Register Device Request Number:1-166827295551

css=p.ng-binding   Req Created by2

//div[2]/div/p   contact 2

css=li.info-list__item.ng-scope > div.info-list__item-value.ng-binding      Serial no2

//div[7]/div/div/ul/li[2]/div[2]    Product no

//div[7]/div/div/ul/li[3]/div[2]  Install Adress 
*/

}