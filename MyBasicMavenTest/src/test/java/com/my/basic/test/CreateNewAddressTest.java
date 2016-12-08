/**
 * 
 */
package com.my.basic.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;

import com.my.basic.pageObject.LogIn_Page;
import com.my.basic.pageObject.PageObject_CreateAddress;
import com.my.basic.pageObject.dateCalculations;

public class CreateNewAddressTest {
	
	WebDriver driver;
	String baseUrl = "https://managedservices.qa.lexmark.com";//"Launching url 
	SoftAssert s_assert = new SoftAssert();	
//	Logger logger = Logger.getLogger(CreateNewAddressTest.class);
	
@BeforeClass
	public void setUp() throws InterruptedException{
//	PropertyConfigurator.configure("log4j.properties");
//	logger.info("################# This is Create New Adrress Test ####################");
	System.out.println("################# This is Create New Address Test ####################");
	
//	System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
	//System.setProperty("webdriver.chrome.driver", "/Users/sakoar/Documents/workspace/MyBasicMavenTest/drivers/chromedriver");
    //driver = new ChromeDriver();
	//driver = new FirefoxDriver();
	System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
	driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
//		logger.info("Browser Launched & navigated to base url");
		 	LogIn_Page signin = new LogIn_Page(driver);
		 	signin.Login("perftest_bestbuy@customer.com", "Lexmark01");
//		 	logger.info("Login Successful");
	}

@Test
public void CreateNewAddress_Test()throws Exception{
PageObject_CreateAddress createNewAddress = new PageObject_CreateAddress(driver);
createNewAddress.createNewAddress();//To open Create New Address Form

PageObject_CreateAddress address= new PageObject_CreateAddress(driver);
address.captureAddressName(); //Review Button on Capture Page 
address.captureAddressLocation();
Thread.sleep(8000);

address.ReviewPageReviewButton.click();//to navigate to submit page 
//logger.info("Address details Captured");
driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
Thread.sleep(10000);
//######################################### Submit Page #######################################

/*
 String SubmitPageAddressBlock = address.SubmitPageAddressBlock.getText();//------------------
 
logger.info("SPaddressBlock" + SubmitPageAddressBlock);
System.out.println("SPaddressBlock" + SubmitPageAddressBlock);
String SubmitPageRequestCreatedBlock = address.SubmitPageRequestCreatedBy.getText();
System.out.println("SPreqstCreated" + SubmitPageRequestCreatedBlock);
logger.info("SPreqstCreated" + SubmitPageRequestCreatedBlock);
String SubmitPageContactBlock = address.SubmitPageContactBlock.getText();
System.out.println("SPpramContact" + SubmitPageContactBlock);
logger.info("SPpramContact" + SubmitPageContactBlock);
String SubmitPageCustRefId = address.SubmitPageCustRefId.getText();
*/
//######################################### Navigating to Confirmation/Final Page #######################################
address.SumitAddrReqButton.click();
Thread.sleep(6000);
	WebDriverWait wait = new WebDriverWait(driver, 30);
	WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(address.submitPageMessage)); 
//######################################### Capturing the SR DETAILS #######################################
String message1 = "Your Service request is being submitted";
String message2= "Your request ( generating request number... ) is being submitted.";
System.out.println("message 2 is set as: "+message2);
//logger.info("message 2 is set as: "+message2);

	if(message1.equalsIgnoreCase(webElement.getText())){
		Assert.assertEquals(message2, address.submitPageMessage2.getText());
		} else {
			System.out.println("SR Number has been generated");
//			logger.info("SR number submitted");
			String successSR_message="Submitted | Add install address request";
			Assert.assertEquals(webElement.getText(),successSR_message);
			String str=address.readSRNumber.getText();
			String[] split =str.split("\\:"); 
			String SR = split[1];
			System.out.println("SR number generated is: "+SR);
//			logger.info("SR number generated is: "+SR);
		}
	
//######################################### Confirmation/Final Page #######################################
	//Assert.assertEquals(address.status.getText(), "Submitted");
	dateCalculations dateExpected = new dateCalculations();
//Date calculation done	
	s_assert.assertEquals(address.date.getText(), dateExpected.dateCalculate());
	System.out.println("Date shows as: "+address.date.getText());
	
String ConfPageAddressBlock = address.ConfPageAddressBlock.getText();
//System.out.println("CPaddressBlock" + ConfPageAddressBlock);
//logger.info("CPaddressBlock" + ConfPageAddressBlock);
String ConfPageRequestCreatedBlock = address.ConfPageRequestCreatedBlock.getText();
//System.out.println("CPreqstCreatedBy" + ConfPageRequestCreatedBlock);
//logger.info("CPreqstCreatedBy" + ConfPageRequestCreatedBlock);
String ConfPageContactBlock = address.ConfPageContactBlock.getText();
//System.out.println("CPpramContct" + ConfPageContactBlock);
//logger.info("CPpramContct" + ConfPageContactBlock);
String ConfPageCustRefId = address.ConfPageCustRefId.getText();
//logger.info("CPpramContct" + ConfPageCustRefId);



//######################################### Comparison / Assertions #######################################
/*
Assert.assertEquals(SubmitPageAddressBlock,ConfPageAddressBlock);
//System.out.println("Address Added Successfully");
logger.info("Address Added Successfully");
Assert.assertEquals(SubmitPageRequestCreatedBlock,ConfPageRequestCreatedBlock);
//System.out.println("Request Created Successfully");
logger.info("Request Created Successfully");
Assert.assertEquals(SubmitPageContactBlock,ConfPageContactBlock);
//System.out.println("Contact Details Verified");
logger.info("Contact Details Verified");

}
*/

driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
LogIn_Page logout = new LogIn_Page(driver); //Logout
logout.Logout();
//logger.info("Log out");
driver.quit();
}

/*
@AfterTest
public void tearDown() throws Exception{
	driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
	  LogIn_Page logout = new LogIn_Page(driver); //Logout
	  logout.Logout();
//	  logger.info("Log out");
	  driver.quit();
//	  logger.info("& browser close");
*/	  
}



