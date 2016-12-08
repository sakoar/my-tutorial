package com.my.basic.pageObject;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObject_UpdateContact {
	public PageObject_UpdateContact(WebDriver driver) { //Constructor of Class
		PageFactory.initElements(driver,this);
		}
	
	@FindBy(linkText="Contacts")
	@CacheLookup
	public WebElement contact;
	//#############Capturing Details###############
	@FindBy(xpath="(//input[@type='text'])[3]") //Input box
	public WebElement search_box;
	@FindBy(xpath="//div[2]/button")
	public WebElement search_icon;
	@FindBy(xpath="(//button[@type='button'])[2])")
	public WebElement update_button;
	@FindBy(xpath="//*[@id='contactInfoTab']/div/div/form/div[2]/p")
	public WebElement firstName;
	@FindBy(xpath="//div[@id='contactInfoTab']/div/div/form/div[3]/p")
	public WebElement lastName;
	

public void search4Contact(String contactName) throws InterruptedException{
	contact.click();
	Thread.sleep(3000);
	search_box.sendKeys(contactName);
	Thread.sleep(500);
	search_icon.click();
	Thread.sleep(2000);
}
	//#####################Update Supplies Contact page##########
	@FindBy(name="email")
	public WebElement email;
	@FindBy(name="workPhone")
	public WebElement phone;
	//@FindBy(xpath="//button[@name='submit']")  
	//xpath=//button[@name='submit']
	@FindBy(xpath="//*[type='submit']")
	public WebElement update_contact_info_button;
	
	//@FindBy(css="button[@name='submit']")
	//public WebElement final_update_button;
	
	
	public void updateEmailDetails() throws InterruptedException{
		email.clear();
		email.sendKeys(generateEmail());
		
	}
		
//########Capturing Email & Phone Details after 1st search############
@FindBy(xpath="//div[@id='1477373595425-0-uiGrid-00I9-cell']/div")
public WebElement email_field;
@FindBy(xpath="//div[@id='1477373595425-0-uiGrid-00IA-cell']/div")
public WebElement phone_field;
//########Capturing Email & Phone Details after updating details############
@FindBy(xpath="//div[@id='1477373595427-0-uiGrid-00Z7-cell']/div")
public WebElement updated_email_field;
@FindBy(xpath="//div[@id='1477373595427-0-uiGrid-00Z8-cell']/div")
public WebElement updated_phone_field;
	
public String generateEmail(){  //This will generate random email ID which is going to be Unique
			//Map <String, String> userMap1 = new HashMap<>();
			long random = Math.round(Math.random()*1357);
			String email="selenium." + random + "@domain.com";
			//System.out.println(email); //this will create random email
			//userMap1.put("email", email);
			//userMap1.put("lastName", String.valueOf(random));
			return email;
			}


//###############
@FindBy(xpath="//div[3]/div[2]/div")
public WebElement update_message;

	//#########Capturing details after clicking Contact Address Tab########
	@FindBy(linkText="Contact address")
	@CacheLookup
	public WebElement contact_address_tab;
	@FindBy(linkText="Select different Contact Address")
	public WebElement diff_address_link;
	@FindBy(xpath="(//input[@type='text'])[2]")
	public WebElement address_search_field;
	@FindBy(xpath="//*[text()='CHANGE CONTACT ADDRESS']")
	public WebElement change_address_button;
	
	@FindBy(name="addressLine1")
	public WebElement address1;
	@FindBy(name="addressLine2")
	public WebElement address2;
	@FindBy(name="city")
	public WebElement city_name;
	@FindBy(name="postalCode")
	public WebElement zipcode;
	@FindBy(name="buildingName")
	public WebElement building;
	@FindBy(name="floorName")
	public WebElement floor;
	@FindBy(name="siteName")
	public WebElement office;
	
	@FindBy(css="button[@type='submit']")
	public WebElement update_address_button1;
	
	//##########Detail of 2nd Page############
	//@FindBy(xpath="//button[@type='submit']")
	@FindBy(css="button[@type='submit']")
	public WebElement update_address_button2;
		
	//##########Details of Update Supplies Contact Page################
	@FindBy(css="div.ng-binding")
	public WebElement contact_info1;
	@FindBy(xpath="//li/div[2]")
	public WebElement contact_info2;
	@FindBy(css="div.col-1-3 > div.well.well--no-shadow")
	public WebElement req_created_block1;
	//@FindBy(css="p.ng-binding")
	//public WebElement req_createdby1;
	@FindBy(xpath="//div[2]/div/p")
	public WebElement contact_block1;
	@FindBy(name="internalReferenceId")
	public WebElement refId;
	@FindBy(name="requestCostCenter")
	public WebElement cost_centre;
	@FindBy(name="comments")
	public WebElement user_comments;
	@FindBy(xpath="//button[@type='submit']")
	//@FindBy(css="button[type='submit']")
	public WebElement submit_address_button;
	
	////##########Details of Final Submitted Page################
	@FindBy(css="p.ng-binding")
	public WebElement req_createdby2;
	@FindBy(xpath="//div[2]/div/p")
	public WebElement contact_block2;
	@FindBy(xpath="//div[5]/div/ul/li/div[2]")
	public WebElement contact_submit_page;
	@FindBy(css="span.ng-scope > span.ng-scope")
	public WebElement confirmation_message;
	//@FindBy(css="h1.ng-scope > span")
	//public WebElement request_no;
	
	//css=h1.ng-scope > span
	
}
