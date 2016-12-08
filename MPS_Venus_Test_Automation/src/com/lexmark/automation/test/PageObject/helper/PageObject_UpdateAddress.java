package com.lexmark.automation.test.PageObject.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class PageObject_UpdateAddress {
public PageObject_UpdateAddress(WebDriver driver) { //Constructor of Class
PageFactory.initElements(driver,this);
}
//############################# Search for an ADDRESS ########################
@FindBy(linkText="Addresses")
public WebElement addresses;
@FindBy(className="selectricButton")
public WebElement all_addresses;//Selecting All Address
@FindBy(xpath="//html/body/div[1]/div/div/div/div/div[2]/div[5]/div[1]/div/div/div[1]/div[1]/div/div/div[2]/span")
public WebElement searchFilter;//Address dropdown list
@FindBy(xpath="(//input[@type='text'])[3]")//Search Option
public WebElement searchInput;
@FindBy(css="button.search")
public WebElement searchIcon;
@FindBy(xpath="//*[starts-with(@class,'ui-grid-cell ng-scope ui-grid-coluiGrid-')]")
									   
public WebElement selectKey;//Checkbox
@FindBy(xpath="(//button[@type='button'])[2]")
public WebElement update_address_button;

public void addressSearchAndClickUpdate(String addressName) throws Exception{ //This method is to Navigate to Address Page
	addresses.click();
	Thread.sleep(2000);
	searchInput.sendKeys(addressName);
	Thread.sleep(500);
	searchIcon.click();
	Thread.sleep(2000);
	selectKey.click();
	update_address_button.click();
	Thread.sleep(2000);
}
//############################# Update Install Address Page//############################# 

@FindBy(name="addressName")
public WebElement address_name;
@FindBy(xpath="//INPUT[contains(@id,'store-front-question-yes')]")
public WebElement store_selection_yes;
@FindBy(id="sameAddress")
public WebElement sameAddress;
@FindBy(name="country")
public WebElement country_name;
@FindBy(name="addressLine1")
public WebElement address_line1;
@FindBy(name="addressLine2")
public WebElement address_line2;
@FindBy(name="city")
public WebElement city_name;
@FindBy(name="state")
public WebElement state_name;
@FindBy(name="postalCode")
public WebElement postal_code;
@FindBy(name="cancel")
public WebElement discard_update_button;
@FindBy(xpath="//button[@type='submit']")
public WebElement review_button;


public void captureAddressLocation() throws InterruptedException{
	address_name.clear();
	address_name.sendKeys("Address Update");
	store_selection_yes.click();
	sameAddress.click();
	new Select(country_name).selectByVisibleText("South Africa");//Country Selection from Dropdown
	Thread.sleep(2000);
	address_line1.clear();
	address_line1.sendKeys("10 Tyrewhitt Road");
	address_line2.clear();
	address_line2.sendKeys("Don Suite");
	city_name.sendKeys("Johannesburg");
	new Select(state_name).selectByVisibleText("Gauteng");//State Selection from Dropdown
	postal_code.clear();
	postal_code.sendKeys("2016");
	Thread.sleep(2000);
	review_button.click();
}
//############### Review Page data#####################
@FindBy (xpath="//button[@type='submit']")
public WebElement reviewReviewBtn;

@FindBy(css="div.info-list__item-value.ng-binding")
public WebElement rpAddressBlock;

@FindBy(css="p.ng-binding")
public WebElement rpReqstCreatedBy;

@FindBy(xpath="//div[2]/div/p")
public WebElement rpPramContact;


//############### Submit Page data#####################

@FindBy(xpath="//div[11]/div/div/ul/li/div") //change it here
public WebElement spAddressBlock;

@FindBy(css="p.ng-binding")
public WebElement spReqstCreatedBy;

@FindBy(xpath="//div[2]/div/p")
public WebElement spPramContact;

 
//######################### Review | Update install address Details ############################# 
@FindBy(css="li.info-list__item")
public WebElement address_updated1;
@FindBy(css="div.col-1-3 > div.well.well--no-shadow")
public WebElement request_created_by1;
@FindBy(xpath="/html/body/div[1]/div/div/div/div/div/div[2]/form/div[15]/div/div[2]/div/p")
public WebElement contact1;
@FindBy(name="internalReferenceId")
public WebElement customer_ref_no1;
@FindBy(name="cancel")
public WebElement discard_review_update_button;
@FindBy(xpath="//button[@type='submit']")
public WebElement review_update_button;


//######################### ConfirmationPage Details ############################# 
@FindBy(css="div.well.well--no-shadow")
public WebElement request_created_by2;
@FindBy(xpath="//div[2]/div/p")
public WebElement contact2;
@FindBy(xpath="//div[11]/div/div/ul/li")
public WebElement address_updated2;
@FindBy(css="li.info-list__item")
public WebElement customer_ref_no2;

}

