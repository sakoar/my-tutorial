package com.lexmark.automation.test.PageObject.helper;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;



public class HomePage_PageObjects {
	
	SoftAssert softAssert = new SoftAssert();
	String OpenBF;   //This is instance variable as this needs to be shared among methods in this class
	public HomePage_PageObjects(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
//HOME Page
	
	@FindBy(linkText="Home")
	public WebElement HomePage;
	
//Reqst for Service -RollUp
	@FindBy (xpath="//div[1]/div/div[1]/h4")
	public WebElement ServiceRollUp_Header;

//Open service Reqst from Home-Role UP
	@FindBy(xpath="//html/body/div[1]/div/div/div/div/div/div[1]/div[2]/div[1]/div/div[2]/a/h1/span[1]")
	public WebElement OpenServiceCount;
	
//On Click on Open SR, it takes user to Requests->Service Requests Tab
	@FindBy(linkText="Service requests")
	public WebElement BF_Tab;
	@FindBy(linkText="Address requests")
	public WebElement Address_Tab;
	
	@FindBy(xpath="//div[@id='serviceRequestsServiceTab']/span/div/div/div/h2")
	public WebElement BF_SR_Text;

//Method to verify Service-Roll up
	
	public void BF_RollUP_Verification() throws Exception{
		Thread.sleep(3000);
		softAssert.assertEquals(ServiceRollUp_Header.getText(),"Requests for Service");
		OpenBF = OpenServiceCount.getText(); //This has been declared as instance/class variable so that it can be accessible to other methods
		System.out.println("Count of Open BF: " +OpenBF);
		OpenServiceCount.click(); //This takes user to REQUESTS page
		Thread.sleep(4000);
		}
	public void requestTabVerification(){
		String str = BF_SR_Text.getText();
		String[] strArr = str.split("\\("); // '(' is used to represent intervals in regular expression, you need to escape it, since String.split does use regular expressions.
		System.out.println("Service Request part of the string: " +strArr[0]);
		String[] strArr2=strArr[1].split("\\)");
		System.out.println("Service Request Count is: "+strArr2[0]);
		
		softAssert.assertEquals(strArr2[0], OpenBF);
		}
	
	
//Search Bar Page Object
	@FindBy(css="css=div.selectricButton")
	public WebElement SearchDropDown;
	
	@FindBy(xpath="//div[3]/ul/li[2]")
	public WebElement CustDeviceTag;   

	@FindBy(xpath="//div[3]/ul/li[3]")
	public WebElement HostName;
	
	@FindBy(xpath="//div[3]/ul/li[4]")
	public WebElement IPV4;
	
	@FindBy(css="li.last")
	public WebElement ProductModel;
	
	@FindBy(xpath="(//input[@type='text'])[2]")
	public WebElement searchInput;
	
	@FindBy(xpath="//button")
	public WebElement searchButton;	

public void HomePageDeviceSearch(String parameter) throws InterruptedException{
	Thread.sleep(2000);
	SearchDropDown.click();
	CustDeviceTag.click();
	searchInput.sendKeys(parameter);
	searchButton.click();
	Thread.sleep(2000);
}
	
	
}




















/*

//Reqst for Order -RollUp
	@FindBy (xpath="//div[2]/div/div[1]/h4")
	public WebElement OrderRollUp_Header;
		
	@FindBy(xpath="//div[2]/div[2]/div/div[2]")
	public WebElement OrderRollUp_Body;

	@FindBy(xpath="//div[2]/div/div[3]/a/p/span")
	public WebElement OrderRollUp_Footer;
		
//Reqst for Order -RollUp
	@FindBy (xpath="//div[3]/div/div[1]/h4")
	public WebElement DeviceRollUp_Header;
				
	@FindBy(xpath="//div[2]/div[3]/div/div[2]")
	public WebElement DeviceRollUp_Body;
	
	@FindBy(xpath="//div[3]/div/div[3]/a/p/span")
	public WebElement DeviceRollUp_Footer;
*/


/*
//Closed Service reqst from Home-Role UP	
	@FindBy(xpath="//html/body/div[1]/div/div/div/div/div/div[1]/div[2]/div[1]/div/div[3]/a/p/span")
	public WebElement CompletedServiceCount;
	
	@FindBy(xpath="//div[@id='serviceRequestsServiceTab']/span/div/div/div/h2")
	public WebElement MatchOpenCount_inRequest;
	
	@FindBy(xpath="//div[@id='serviceRequestsServiceTab']/span/div/div/div/h2")
	public WebElement MatchCompletedCount_inRequest;
*/