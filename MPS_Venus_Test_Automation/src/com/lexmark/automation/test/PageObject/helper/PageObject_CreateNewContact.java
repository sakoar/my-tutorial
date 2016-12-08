package com.lexmark.automation.test.PageObject.helper;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObject_CreateNewContact {
	public PageObject_CreateNewContact(WebDriver driver) 
		{
		  PageFactory.initElements(driver,this);
		}
	
//Contact capture
	@FindBy(linkText = "Contacts")
	public WebElement contactTab;
	@FindBy(xpath = "//button[@type='button']")
	public WebElement createNewContactBtn;
	
	@FindBy(name="firstName")
	public WebElement firstName;
	@FindBy(name="lastName")
	public WebElement lastName;
	@FindBy(name="email")
	public WebElement email;
	@FindBy(name="workPhone")
	public WebElement workPhone;
	
	public Map captureContactInfo() throws InterruptedException{
		Map <String, String> userMap = new HashMap<>();
		long random = Math.round(Math.random()*1357);
		String email="selenium." + random + "@domain.com";
		userMap.put("email", email); //System.out.println(email); //this will create random email
		userMap.put("lastName", String.valueOf(random));
		return userMap;	
	}

	@FindBy(name="country")
	public WebElement country;
	@FindBy(name="addressLine1")
	public WebElement addLine1;
	@FindBy(name="city")
	public WebElement city;
	@FindBy(name="state")
	public WebElement state;
	@FindBy(name="postalCode")
	public WebElement postalCode;
	
	@FindBy(name="buildingName")
	public WebElement bldgName;
	@FindBy(name="floorName")
	public WebElement floorName;
	@FindBy(name="siteName")
	public WebElement sitName;
	
	@FindBy(name="submit")
	public WebElement submitButton;
	

	@FindBy(css="div.col-lg-2-3.col-md-1 > h1")
	public WebElement confirmationPageMessage;


}
