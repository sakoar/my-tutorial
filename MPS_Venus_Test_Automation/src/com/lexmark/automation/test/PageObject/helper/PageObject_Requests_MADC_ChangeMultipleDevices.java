package com.lexmark.automation.test.PageObject.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageObject_Requests_MADC_ChangeMultipleDevices {
public PageObject_Requests_MADC_ChangeMultipleDevices(WebDriver driver) {
PageFactory.initElements(driver,this);
}

//##########Home Page Details#######
@FindBy(linkText="Devices")
@CacheLookup
public WebElement device_tab; 
@FindBy(xpath="(//input[@type='text'])[3]")
public WebElement serial_no; 
@FindBy(className="search")
public WebElement search_serial_icon;
@FindBy(xpath="//div[contains(@id,'-0-uiGrid-')]/div/div/div")
//@FindBy(xpath="/html/body/div[1]/div/div/div/div/div[2]/div/div[2]/div/div[7]/div/div[1]/div/div[1]/div/div[2]/div/div[1]/div/div/div/div/div")
public WebElement first_item_selected; 
//@FindBy(xpath="//div[contains(@id,'-uiGrid']")
@FindBy(xpath="//div[contains(@id,'-1-uiGrid-')]/div/div/div")
//@FindBy(xpath="/html/body/div[1]/div/div/div/div/div[2]/div/div[2]/div/div[7]/div/div[1]/div/div[1]/div/div[2]/div/div[2]/div/div/div/div/div")
public WebElement second_item_selected;
@FindBy(xpath="//button[text()='UPDATE DEVICE INFORMATION']")
public WebElement update_device_button;
//#################################Details of next page after clicking Update Button#######
//@FindBy(xpath="//tr[1]/td)")	
@FindBy(css="td.ng-binding")  // 1st device detail in table 
public WebElement first_device_serial_no1;
@FindBy(xpath="//tr[2]/td")		// 2nd device detail in table 
public WebElement second_device_serial_no1;
@FindBy(linkText="Change contact")	//  
public WebElement change_contact_link;

//@FindBy(className="selectric")
//public WebElement list_select;
@FindBy(xpath="(//input[@type='text'])[2]")
public WebElement first_name_field;
@FindBy(className="search")
public WebElement search_name_icon;

public void contactUpdate() throws InterruptedException{
//new Select(list_select).selectByIndex(1);
first_name_field.sendKeys("jay");
search_name_icon.click();
Thread.sleep(4000);
}

@FindBy(xpath="//button[text()='Change Contact']")
public WebElement change_contact_button;
//######################Navigating to Next Page#######################
@FindBy(name="costCenter")//  
public WebElement cost_centre;
@FindBy(xpath="//button[@type='submit']")
public WebElement review_button;
@FindBy(name="internalReferenceId")//  
public WebElement ref_Id;
@FindBy(name="requestCostCenter")//  
public WebElement req_cost_centre;
@FindBy(name="comments")//  
public WebElement user_comments;
@FindBy(xpath="//button[@type='submit']")
public WebElement submit_device_req_button;

//###############################Final Page Details###############
@FindBy(xpath="//h2")
public WebElement update_message;
//@FindBy(xpath="//tr[1]/td)") // 1st device detail in Final Page
@FindBy(css="td.ng-binding")  // 1st device detail in Final Page
public WebElement first_device_serial_no2;
@FindBy(xpath="//tr[2]/td")// 2nd device detail in Final Page 
public WebElement second_device_serial_no2;   

//#############################Confirmation/Final Page Details####################
	//Confirmation page SR DETAILS
	@FindBy(css="div.col-lg-2-3.col-md-1-1 > h1.ng-scope")  
	public WebElement submitPageMessage;
	@FindBy(css="css=span.ng-scope > span.ng-scope")  
	public WebElement submitPageMessage2;
	@FindBy(xpath="//h2")  
	public WebElement readSRNumber;
}
