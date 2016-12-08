package com.my.basic.pageObject;

import org.testng.Assert;
import java.sql.Driver;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageObject_CreateAddress {
	public PageObject_CreateAddress(WebDriver driver) { //Constructor of Class
		PageFactory.initElements(driver,this);
	}
	
	
//############################# Navigate to Address & Click on CREATE NEW ######################## 	
	@FindBy(linkText="Addresses")
	public WebElement addresses;
	
	@FindBy(xpath="//button[@type='button']")
	public WebElement createNewButton;
	
	@FindBy(css="div.col-lg-2-3.col-md-1-1 > h1.ng-scope") //Page header of Create new Page
	public WebElement pageHeader_CapturePage;
	
	@FindBy(name="addressName") //Capturing Address Name
	public WebElement AddressName;

public void createNewAddress() throws Exception{ //This method is to Navigate to Address & Click on CREATE NEW
		addresses.click();
		Thread.sleep(3000);
		createNewButton.click();
		Thread.sleep(5000);
		Assert.assertEquals(pageHeader_CapturePage.getText(), "Add Install Address");
		
		}
//############################# Capture Address Details ########################	
	
@FindBy(id="store-front-question-no")
public WebElement StoreFrontQuestionSelectionNo;
@FindBy(id="store-front-question-yes")
public WebElement StoreFrontQuestionSelectionYes;
@FindBy(id="storeFrontName")
public WebElement StoreFront;
@FindBy(name="country") //Country Selection	
public WebElement Country;
@FindBy(id="sameAddress")
public WebElement SameAddress;	
@FindBy(name="addressLine1")
public WebElement AddressLine1;
@FindBy(name="addressLine2")
public WebElement AddressLine2;
@FindBy(name="city")
public WebElement City;
@FindBy(name="state")  //State Selection
public WebElement State;
@FindBy(name="postalCode")
public WebElement ZipCode;
@FindBy(name="cancel")//Abandon button
public WebElement AbondonAddressCreation;
@FindBy(xpath="//button[@type='submit']")
public WebElement Review;

	public void captureAddressName() throws InterruptedException{ //this method is to Capture Address Details
		AddressName.sendKeys("testAutomationLab");
		StoreFrontQuestionSelectionYes.click();
		SameAddress.click();
		Thread.sleep(4000);
	}
	public void captureAddressLocation() throws InterruptedException{
		//******************Country Selection from Dropdown****************************//
		new Select(Country).selectByVisibleText("USA");
		Thread.sleep(4000);
		AddressLine1.sendKeys("740 W New Circle Rd");
		AddressLine2.sendKeys("Lab Dept");
		City.sendKeys("Lexington");
		new Select(State).selectByVisibleText("Kentucky");
		ZipCode.sendKeys("40511");
		Thread.sleep(3000);
		Review.click();
	}
//############################# REVIEW Address Details ########################	

	@FindBy(name="addressName")
	public WebElement AddressNameReview;
	@FindBy(name="id=store-front-question-yes")
	public WebElement StoreFrontReviewSelectionYes;
	@FindBy(name="name=storeFrontName")
	public WebElement StoreFrontReview;
	@FindBy(id="sameAddress")
	public WebElement SameAddressReview;
	@FindBy(css="div.ng-binding")
	public WebElement ReviewPageAdln1;
	@FindBy(xpath="//div[2]/div/div/div[3]")
	public WebElement ReviewPageAdln2;
	@FindBy(css="address-bod > div.row")
	public WebElement ReviewCity;
	@FindBy(xpath="//div[5]/span[2]")
	public WebElement ReviewState;
	@FindBy(xpath="//span[3]")
	public WebElement ReviewZIPCODE;	 
	@FindBy(xpath="//div[2]/div/div/div[6]")
	public WebElement ReviewCountry;
	
	//#############################Submitting Review Button####################
	@FindBy(xpath="//button[@type='submit']")
	public WebElement ReviewPageReviewButton;
	
	//#############################Submit Page Details####################
	@FindBy(xpath="//html/body/div[1]/div/div/div/div/div/div[2]/form/div[10]/div/div/ul/li/div")
	public WebElement SubmitPageAddressBlock;
	@FindBy(xpath="//html/body/div[1]/div/div/div/div/div/div[2]/form/div[15]/div/div[1]/div/p")
	public WebElement SubmitPageRequestCreatedBy;
	@FindBy(xpath="//html/body/div[1]/div/div/div/div/div/div[2]/form/div[15]/div/div[2]/div/p")
	public WebElement SubmitPageContactBlock;
	
	@FindBy(name="internalReferenceId")
	public WebElement SubmitPageCustRefId;
	@FindBy(name="cancel")
	public WebElement CancelButton;
	@FindBy(xpath="	//button[@type='submit']")
	public WebElement SumitAddrReqButton;
	
	//#############################Confirmation/Final Page Details####################
	//Confirmation page SR DETAILS
	@FindBy(css="div.col-lg-2-3.col-md-1-1 > h1.ng-scope")  
	public WebElement submitPageMessage;
	@FindBy(css="css=span.ng-scope > span.ng-scope")  
	public WebElement submitPageMessage2;
	@FindBy(xpath="//h2")  
	public WebElement readSRNumber;

	
	@FindBy(css="p.ng-binding")
	public WebElement ConfPageRequestCreatedBlock;
	@FindBy(xpath="//div[3]/div/div[2]/div")
	public WebElement ConfPageContactBlock;	
	@FindBy(css="div.info-list__item-value.ng-binding")
	public WebElement ConfPageCustRefId;
	@FindBy(xpath="//div[11]/div/div/ul/li")
	public WebElement ConfPageAddressBlock;
	
	//Confirmation page STATUS BAR
	@FindBy(xpath="//div[2]/div/div/div/div[2]/div")
	public WebElement status;
	@FindBy(css="div.status-state-date.ng-binding")
	public WebElement date;
	
}
    