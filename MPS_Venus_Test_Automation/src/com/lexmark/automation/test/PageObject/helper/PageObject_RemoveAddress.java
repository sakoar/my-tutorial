package com.lexmark.automation.test.PageObject.helper;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

	public class PageObject_RemoveAddress {
	public PageObject_RemoveAddress(WebDriver driver) { //Constructor of Class
		PageFactory.initElements(driver,this);
	}
	
	
//############################# Search for an ADDRESS ######################## 	
	@FindBy(linkText="Addresses")
	public WebElement addresses;
	
	@FindBy(xpath="//html/body/div[1]/div/div/div/div/div[2]/div[5]/div[1]/div/div/div[1]/div[1]/div/div/div[2]/span")
	public WebElement searchFilter;//Address dropdown list
	
	@FindBy(xpath="(//input[@type='text'])[3]")//Search Option
	public WebElement searchInput;
	@FindBy(css="button.search")
	public WebElement searchIcon;
	@FindBy(xpath="//div[contains(@id,'-0-uiGrid-')]/div/div/div")
	
											
	public WebElement selectKey;//Checkbox
	
//############################# REVIEW PAGE ######################## 		

	@FindBy(xpath="(//button[@type='button'])[3]")
	public WebElement removeButton;
	@FindBy(css="div.info-list__item-value.ng-binding")
	public WebElement reviewPageAddrsDetail;
	@FindBy(css="p.ng-binding")
	public WebElement reviewPagePrimaryContact;
	@FindBy(xpath="//div[2]/div/p")
	public WebElement reviewPageReqstCreatedBy;
	@FindBy(name="internalReferenceId")
	public WebElement refID;
	
//############################# SUBMIT PAGE ######################## 
	//Confirmation page SR DETAILS
		@FindBy(xpath="/html/body/div[1]/div/div/div/div/div[1]/div/div[3]/div/h1")  
		public WebElement submitPageMessage;
		@FindBy(css="span.ng-scope > span.ng-scope")  
		public WebElement submitPageMessage2;
		@FindBy(xpath="//h2")  
		public WebElement readSRNumber;

	@FindBy(xpath="//button[@type='submit']")
	public WebElement reviewPageRemoveButton;
	
	@FindBy(xpath="//div[11]/div/div/ul/li/div")
	public WebElement submitPageAddrsDetail;
	@FindBy(css="p.ng-binding")
	public WebElement submitPagePrimaryContact;
	@FindBy(xpath="//div[2]/div/p")
	public WebElement submitPageReqstCreatedBy;
	
	//Confirmation page STATUS BAR
		@FindBy(xpath="//div[2]/div/div/div/div[2]/div")
		public WebElement status;
		@FindBy(css="div.status-state-date.ng-binding")
		public WebElement date;
	
	}
		
	