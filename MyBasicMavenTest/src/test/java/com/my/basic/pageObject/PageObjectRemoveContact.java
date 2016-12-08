package com.my.basic.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjectRemoveContact {
	public PageObjectRemoveContact(WebDriver driver) { //Constructor of Class
		PageFactory.initElements(driver,this);
		}
	
//#####################################
@FindBy(linkText="Contacts")
public WebElement contact;


//######################Selecting Item##########
@FindBy(xpath="//html/body/div[1]/div/div/div/div/div[2]/div[4]/div[1]/div/div[1]/div[1]/div[1]/div/div/div[2]/div")
public WebElement arrowKey;
@FindBy(xpath="//div[3]/ul/li[3]")
public WebElement email_id;
@FindBy(xpath="(//input[@type='text'])[3]") //Input box
public WebElement search_box;
@FindBy(xpath="//div[2]/button")
public WebElement search_icon;

@FindBy(xpath="(//button[@type='button'])[3]")
public WebElement remove_button;

public void searchItem(String email) throws Exception{ //This method is to Navigate to Address & Click on CREATE NEW CONTACT
System.out.println("going to click on the arraow btn");
search_box.sendKeys(email); //input search value
Thread.sleep(2000);
search_icon.click(); //click on search icon
Thread.sleep(3000);
}

//########################Update Supplies Contact | TEST13 CONTACT13 Page##########
@FindBy(xpath="//button[@type='button']")
public WebElement delete_supplies_button;


//########################Delete Supplies Contact Page##########
@FindBy(css="div.ng-binding")
public WebElement contactInfo1;
@FindBy(xpath="//li/div[2]")
public WebElement contactLocation1;
@FindBy(css="p.ng-binding")
public WebElement req_created_by1;
@FindBy(xpath="//div[2]/div/p")
public WebElement primaryContact1;
@FindBy(name="internalReferenceId")
public WebElement ref_id;
@FindBy(name="requestCostCenter")
public WebElement cost_centre;
@FindBy(name="comments")
public WebElement comment;
@FindBy(xpath="//button[@type='submit']")
//@FindBy(css="button[type='submit']")
public WebElement submit_delete_button;


//#######Delete Contact Request Submission Page########
@FindBy(css="div.well.well--no-shadow")
public WebElement req_created_by2;
@FindBy(xpath="//div[3]/div/div[2]/div")
public WebElement primaryContact2;
@FindBy(xpath="//div[12]/div/div/ul/li/div")
public WebElement contactInfo2;
@FindBy(xpath="//div[12]/div/div/ul/li/div[2]")
public WebElement contactLocation2;

}
