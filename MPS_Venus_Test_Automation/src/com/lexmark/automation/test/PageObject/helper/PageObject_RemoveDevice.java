package com.lexmark.automation.test.PageObject.helper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PageObject_RemoveDevice {
  public PageObject_RemoveDevice(WebDriver driver) {
	  PageFactory.initElements(driver,this);
}
//--------------------------------------------------------------
//Device Grid Page
	
	@FindBy(linkText="Devices")
	public WebElement DevicesTab;
	
	//See if default search option is Serial no or not
	@FindBy(xpath="//*[@id='deviceListTab']/div[3]/div[1]/div/div/div[1]/div[1]/div/div/div[2]/span")
	public WebElement DefaultSerialNoSelection;
	
	//Search box
	@FindBy(xpath="(//input[@type='text'])[3]")  
	public WebElement SearchInput;
	
	//Search Button
	@FindBy(css="button.search")
	public WebElement SearchButton; //These completes device search
	
public void searchDevice(String deviceNo) throws InterruptedException{
	DevicesTab.click();
	Thread.sleep(2000);
	SearchInput.clear();
	SearchInput.sendKeys(deviceNo);
	SearchButton.click();
	Thread.sleep(4000);
	
}

//--------------------------------------------------------------
//Device Detail Page 

	@FindBy(xpath="//*[@id='device']/div[4]/div[2]/p/span[4]")  //serial no
	public WebElement serialNumber;
	@FindBy(css="p.info-list > span.ng-binding")   //product model
	public WebElement productModel;
	@FindBy(css="div.info-list__item-value > span.ng-binding")   //Install Address
	public WebElement installAddress;
	@FindBy(xpath="//div[@id='deviceInfoTab']/div/ul[3]/li/div[2]")   //ip address
	public WebElement ipAddress;
	@FindBy(xpath="//div[@id='deviceInfoTab']/div/ul[4]/li/div[2]")   //Primary contact
	public WebElement primaryContact;
	
//Capture page details 
	@FindBy(css="div.col-lg-2-3.col-md-1-1 > h1.ng-scope")  
	public WebElement pageHeader;
	@FindBy(xpath="//li[3]/div[2]")				//serial no
	public WebElement capturePageSerialNo;
	@FindBy(css="div.info-list__item-value.ng-binding") //Product model
	public WebElement capturePageProductModel;
	@FindBy(xpath="//li[2]/div[2]")			//Part number
	public WebElement capturePagePartNo;
	@FindBy(xpath="//li[4]/div[2]")				//IP Address
	public WebElement capturePageIpAddress;
	@FindBy(css="div.ng-binding.ng-scope")				//Insta;; Address
	public WebElement capturePageInstallAddress;
	
	
	
//Click on Remove button
	@FindBy(xpath="//button[@type='submit']")				//Insta;; Address
	public WebElement removeButton;
	
//Review Page
	@FindBy(css="div.info-list__item-value.ng-binding")				//serial no
	public WebElement reviewPageSerailNo;
	@FindBy(xpath="//li[2]/div[2]")				//serial no
	public WebElement reviewPagePartNo;
	@FindBy(xpath="//html/body/div[1]/div/div/div/div/div/div[2]/form/div[4]/div/div/ul/li[3]/div[2]")				//Prod modl
	public WebElement reviewPageProductModel;
	@FindBy(xpath="//li[4]/div[2]")				//IPV4
	public WebElement reviewPageIPAddress;
	@FindBy(xpath="//li[5]/div[2]")				//Host Name
	public WebElement reviewPageHostName;
	@FindBy(xpath="//li[6]/div[2]")				//serial no
	public WebElement reviewPageInstallAddress;
	@FindBy(xpath="//li[7]/div[2]")				//Supply Contact
	public WebElement reviewPageSuppluContact;
	@FindBy(xpath="//html/body/div[1]/div/div/div/div/div/div[2]/form/div[15]/div/div[1]/div/p")				//reqst Created By
	public WebElement reviewPageReqstCreatedBy;
	@FindBy(xpath="//html/body/div[1]/div/div/div/div/div/div[2]/form/div[15]/div/div[2]/div/p")				//Contact for reqst
	public WebElement reviewPageContactForReqst;
	
// Additinal Reqst details & SUBMIT
	@FindBy(name="internalReferenceId")				//Contact for reqst
	public WebElement RefNumber;
	@FindBy(name="requestCostCenter")				//Contact for reqst
	public WebElement costCenter;
	@FindBy(name="comments")				//Contact for reqst
	public WebElement comments;

	@FindBy(xpath="//button[@type='submit']")				//Contact for reqst
	public WebElement SUBMIT_Button;

public void submitButton() throws InterruptedException{
	RefNumber.sendKeys("This is Ref no");
	costCenter.sendKeys("cost center");
	comments.sendKeys("this space is for comments");
	Thread.sleep(2000);
	SUBMIT_Button.click();
	Thread.sleep(3000);
}

//Submit or Final Page
@FindBy(xpath="//html/body/div[1]/div/div/div/div/div[2]/div[3]/div/div[1]/div/p")				
public WebElement submitPageReqstCreatedBy;
@FindBy(xpath="//html/body/div[1]/div/div/div/div/div[2]/div[3]/div/div[2]/div/p")				//serial no
public WebElement submitPageContactRest;

//Submit Page Confirmation Messages
@FindBy(css="div.col-lg-2-3.col-md-1-1 > h1.ng-scope")  
public WebElement submitPageMessage;
@FindBy(css="span.ng-scope > span.ng-scope")  
public WebElement submitPageMessage2;
@FindBy(xpath="//h2")  
public WebElement readSRNumber;



}	
	


