package com.lexmark.automation.test.PageObject.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObject_DeviceMove {
	public PageObject_DeviceMove(WebDriver driver) { //Constructor of Class
		PageFactory.initElements(driver,this);
		}
	
/***********************HomePage Details after Login*************/	
@FindBy(linkText="Devices")
public WebElement device_tab;
@FindBy(xpath="(//input[@type='text'])[3]")
public WebElement serialno_input_field;
@FindBy(xpath="//div[contains(@id,'-0-uiGrid-')]")
public WebElement serial_select_key;
@FindBy(xpath="//*[text()='REQUEST DEVICE MOVE']")
public WebElement move_device_button;

/*************Navigating to Next page*********************************/
//@FindBy(css="form[name="srForm"] > div > div.contact-info > div.ng-binding")
//public WebElement original_address_detail;
@FindBy(name="buildingName")
public WebElement building1;
@FindBy(name="floorName")
public WebElement floor1;
@FindBy(name="siteName")
public WebElement office1;

@FindBy(linkText="Select a different install address")
public WebElement address_change_link;

@FindBy(xpath="(//input[@type='text'])[2]")
public WebElement input_address_field;

@FindBy(xpath="//div[contains(@id,'-0-uiGrid-')]")
public WebElement address_select_key;
@FindBy(xpath="//*[text()='CHANGE DEVICE INSTALL ADDRESS']")
public WebElement change_install_address_button;

@FindBy(xpath="/html/body/div[1]/div/div/div/div/div[2]/form/div[1]/div[3]/input")
public WebElement building2;
@FindBy(xpath="/html/body/div[1]/div/div/div/div/div[2]/form/div[1]/div[4]/input")
public WebElement floor2;
@FindBy(xpath="/html/body/div[1]/div/div/div/div/div[2]/form/div[1]/div[5]/input")
public WebElement office2;
@FindBy(xpath="//*[text()='REVIEW']")
public WebElement review_button;

/***************Providing more details on the next page*******************************/
@FindBy(name="internalReferenceId")
public WebElement ref_Id;
@FindBy(name="requestCostCenter")
public WebElement req_cost_center;
@FindBy(name="comments")
public WebElement user_comments;
@FindBy(xpath="//*[text()='SUBMIT DEVICE REQUEST']")
public WebElement submit_device_req_button;

/**************************Final Page Details****************************/
@FindBy(xpath="//h2")
public WebElement message;
@FindBy(xpath="//li[8]/div[2]")
public WebElement updated_address_final_page;
}
