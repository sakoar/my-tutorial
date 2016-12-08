package com.lexmark.automation.test.PageObject.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class PageObject_CreateContact {
	public PageObject_CreateContact(WebDriver driver) { //Constructor of Class
		PageFactory.initElements(driver,this);
		}

//##################################Create Address Page Details#########
@FindBy(linkText="Contacts")// Clicking on Address tab of 1st page
public WebElement contact;
@FindBy(xpath="//button[@type='button']")
public WebElement add_new_contact_button;

public void createNewContact() throws Exception{ //This method is to Navigate to Address & Click on CREATE NEW CONTACT
	contact.click();
	Thread.sleep(3000);
	add_new_contact_button.click();
	Thread.sleep(3000);
	//Assert.assertEquals(pageHeader_CapturePage.getText(), "Add Install Address");
}
	
//##################################Contact Details Page Details#########
@FindBy(name="firstName")
public WebElement first_name;
@FindBy(name="lastName")
public WebElement last_name;
@FindBy(name="email")
public WebElement email_id;
@FindBy(name="workPhone")
public WebElement phone_no;
@FindBy(name="country")
public WebElement country_name;
@FindBy(name="addressLine1")
public WebElement address1;
@FindBy(name="addressLine2")
public WebElement address2;
@FindBy(name="city")
public WebElement city_name;
@FindBy(name="postalCode")
public WebElement zipcode;
@FindBy(name="buildingName")
public WebElement building_name;
@FindBy(name="floorName")
public WebElement floor_no;
@FindBy(name="siteName")
public WebElement office;
@FindBy(name="cancel")
public WebElement cancel_button;
@FindBy(name="submit")
public WebElement create_contact;

public void captureContactDetails() throws InterruptedException{
first_name.sendKeys("Tim");
last_name.sendKeys("Capuano");
email_id.sendKeys("tim.capuano123@gmail.com");
phone_no.sendKeys("9999999999");
new Select(country_name).selectByVisibleText("USA");//Country Selection from Dropdown//
Thread.sleep(3000);
address1.sendKeys("740 W New Circle Rd");
address2.sendKeys("Lab Dept");
city_name.sendKeys("Lexington");
zipcode.sendKeys("40511");
building_name.sendKeys("Bloack-5");
floor_no.sendKeys("12");
office.sendKeys("Lexmark Mfg Industries");
create_contact.click();
}
}
