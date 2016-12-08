package com.lexmark.automation.test.PageObject.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObject_Devicelist {

	public PageObject_Devicelist(WebDriver driver) { //Constructor of Class
		PageFactory.initElements(driver,this);
}
	
//#########PageDevice Management - Device Details Page########
@FindBy(linkText="Devices")
public WebElement devices_tab;
@FindBy(xpath="(//input[@type='text'])[3]")
public WebElement search_field;
//@FindBy(css="button[class='search']")
//@FindBy(css="div[id='deviceListTab']")
@FindBy(xpath="(//input[@type='text'])[3]")
public WebElement search_icon;
@FindBy(linkText="4021013000787")
public WebElement selected_item;


//###########################
@FindBy(css="p.info-list > span.ng-binding")
public WebElement product_model;
//css=p.info-list > span.ng-binding
@FindBy(xpath="//div[@id='device']/div[4]/div[2]/p/span[4]")
public WebElement serial_no;
@FindBy(xpath="//div[@id='device']/div[4]/div[2]/p/span[6]")
public WebElement device_cust_tag;

//################Page count summary Details

@FindBy(css="div.info-list__item-value.ng-scope")
public WebElement total_pages;
@FindBy(xpath="//div[@id='deviceInfoTab']/div/ul/li[3]/div[2]")
public WebElement mono;


//########location Details##################
@FindBy(css="div.info-list__item-value.ng-binding")
public WebElement install_date;
@FindBy(css="div.info-list__item-value > span.ng-binding")
public WebElement address_detail;


//########  Contact for this Device
@FindBy(xpath="//div[@id='deviceInfoTab']/div/ul[4]/li/div[2]")
public WebElement name;
@FindBy(xpath="//div[@id='deviceInfoTab']/div/ul[4]/li[2]/div[2]")
public WebElement address_block1;
@FindBy(xpath="//div[@id='deviceInfoTab']/div/ul[4]/li[3] ")
public WebElement email;
@FindBy(xpath="//div[@id='deviceInfoTab']/div/ul[4]/li[4]/div[2]")
public WebElement phone;


//########################Network configuration#############

@FindBy(xpath="//div[@id='deviceInfoTab']/div/ul[3]/li/div[2] ")
public WebElement ip_address;
@FindBy(xpath="//div[@id='deviceInfoTab']/div/ul[3]/li[2]/div[2]")
public WebElement hostname;

//###############Device billing and tracking
@FindBy(xpath="//div[@id='deviceInfoTab']/div/ul[5]/li ")
public WebElement cost_centre;
@FindBy(xpath="//div[@id='deviceInfoTab']/div/ul[5]/li[2]/div[2]")
public WebElement chl_detail;
@FindBy(xpath="//div[@id='deviceInfoTab']/div/ul[5]/li[3]/div[2]")
public WebElement cust_device_tag;

//###############Service request number Details Page######
@FindBy(css="div.well.well--no-shadow")
public WebElement req_createdby2;
@FindBy(xpath="//div[2]/div/p")
public WebElement contact2;
@FindBy(css="div.info-list__item-value.ng-binding")
public WebElement reqfId2;
@FindBy(css="li.info-list__item.ng-scope > div.info-list__item-value.ng-binding")
public WebElement serial_no2;
@FindBy(xpath="//div[7]/div/div/ul/li[2]/div[2]")
public WebElement ip_address2;
@FindBy(xpath="//div[7]/div/div/ul/li[3]/div[2]")
public WebElement primary_contact2;
@FindBy(xpath="//div[10]/div/div/ul/li/div[2]")
public WebElement desc2;

}