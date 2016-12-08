package com.lexmark.automation.test.PageObject.helper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PageObject_BreakFix {
  public PageObject_BreakFix(WebDriver driver) {
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
	SearchInput.sendKeys(deviceNo);
	SearchButton.click();
	Thread.sleep(4000);
	}


//--------------------------------------------------------------
//Device Detail Page 

	@FindBy(xpath="//div[@id='device']/div[4]/div[2]/p/span[4]")  //serial no
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
	
	@FindBy(xpath="//li[3]/div[2]")  //serial no
	public WebElement capturePageSerialNumber;
	@FindBy(css="div.info-list__item-value.ng-binding")   //product model
	public WebElement capturePageProductModel;
	@FindBy(css="div.ng-binding.ng-scope")   //Install Address
	public WebElement capturePageInstallAddress;
	@FindBy(xpath="//li[4]/div[2]")   //ip address
	public WebElement capturePageIPAddress;
	
	@FindBy(name="buildingName")
	public WebElement Building;
	@FindBy(name="floorName")
	public WebElement floor;
	@FindBy(name="siteName")
	public WebElement office;
	@FindBy(name="description")
	public WebElement ProblemStatement;
	@FindBy(xpath="//button[@type='submit']")
	public WebElement ReviewButton;
		
public void captureDetails() throws InterruptedException{
	Building.clear();
	Building.sendKeys("Building 004");
	floor.clear();
	floor.sendKeys("floor 3");
	office.clear();
	office.sendKeys("Office HealthCare");
	ProblemStatement.sendKeys("Defect on arrival-DOA-This is for testing, Do not process");
	ReviewButton.click();
	Thread.sleep(3000);
}
//----------------------------------------------------------------	
//Review Page

@FindBy(css="div.info-list__item-value.ng-binding")  //serial no
public WebElement reviewPageSerialNumber;
@FindBy(xpath="//li[2]/div[2]")   //product model
public WebElement reviewPageProductModel;
@FindBy(xpath="//li[3]/div[2]")   //ip address
public WebElement reviewPageIPAddress;
@FindBy(xpath="//li[4]/div[2]")   //Install Address
public WebElement reviewPageInstallAddress;
@FindBy(xpath="//div[2]/div/p")   //Contact for this reqst
public WebElement reviewPageContactforthisreqst;
@FindBy(css="p.ng-binding")   //Request Created By;
public WebElement reviewPageRequestCreatedBy;

@FindBy(name="internalReferenceId")
public WebElement RefID;
@FindBy(xpath="//button[@type='submit']")
public WebElement SubmitButton;

public void reviewPage() throws Exception{
		RefID.sendKeys("Hello There");
		SubmitButton.click();
		Thread.sleep(6000);
	}



//CONFIRMATION PAGE OTHER DETAILS
@FindBy(css="li.info-list__item.ng-scope > div.info-list__item-value.ng-binding")  //serial no
public WebElement submitPageSerialNumber;
@FindBy(xpath="//div[7]/div/div/ul/li[2]/div[2]")   //product model
public WebElement submitPageProductModel;
@FindBy(xpath="//div[7]/div/div/ul/li[3]/div[2]")   //ip address
public WebElement submitPageIPAddress;
@FindBy(xpath="//html/body/div[1]/div/div/div/div/div[2]/div[7]/div/div/ul/li[4]/div[2]")   //Install Address   //li[4]/div[2]
public WebElement submitPageInstallAddress;
@FindBy(css="p.ng-binding")   //Request Created By
public WebElement submitPageReqstCreatedBy;
@FindBy(xpath="//div[2]/div/p")   //Contact for this Reqst
public WebElement submitPageContactforthisReqst;

//Confirmation page STATUS BAR
	@FindBy(xpath="//div[2]/div/div/div/div[2]/div")
	public WebElement status;
	@FindBy(css="div.status-state-date.ng-binding")
	public WebElement date;
	
//####################Submit Page Confirmation Messages
	@FindBy(css="div.col-lg-2-3.col-md-1-1 > h1.ng-scope")  
	public WebElement submitPageMessage;
	@FindBy(css="span.ng-scope > span.ng-scope")  
	public WebElement submitPageMessage2;
	@FindBy(xpath="//h2")  
	public WebElement readSRNumber;
	
}
