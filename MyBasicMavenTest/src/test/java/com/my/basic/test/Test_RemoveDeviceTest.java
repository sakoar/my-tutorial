package com.my.basic.test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import com.my.basic.pageObject.LogIn_Page;
import com.my.basic.pageObject.PageObject_RemoveDevice;




public class Test_RemoveDeviceTest {
	
	private static final String[] KEY = null;
	WebDriver driver;
	String baseUrl= "https://managedservices.qa.lexmark.com";
	String operationKey ="REMOVE";
	String deviceNumber = "0250064";
	PageObject_RemoveDevice device;
	SoftAssert s_assert =new SoftAssert(); 
//	Logger logger = Logger.getLogger(Test_RemoveDeviceTest.class);
@BeforeClass
public void SetUP() throws InterruptedException{
	System.out.println("################# This is Remove Device Test ####################");
//	PropertyConfigurator.configure("log4j.properties");
//	logger.info("################# This is REMOVE Device Test ####################");
	//System.setProperty("webdriver.firefox.bin", "C:\\Users\\sanoaoa\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
    driver = new FirefoxDriver();
	//System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
    //driver = new ChromeDriver();
	driver.get(baseUrl);
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	driver.manage().window().maximize();
	Thread.sleep(5000);
//	logger.info("Browser launched & navigated to url");
			LogIn_Page signin = new LogIn_Page(driver);
			signin.Login("perftest_cummins11@customer.com", "Lexmark01");
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
//			logger.info("login successful");
		}

 @Test
  public void RemoveDeviceTest() throws Exception{

	  device= new PageObject_RemoveDevice(driver);
	  device.searchDevice(deviceNumber);
	  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	  driver.findElement(By.linkText(deviceNumber)).click();
	  
//Device details page
	  Thread.sleep(3000);
	  s_assert.assertEquals(deviceNumber, device.serialNumber.getText()); // asserting on the serial no searched for & the one in detail page
	  String productModel=device.productModel.getText();
	  String ipAddress=device.ipAddress.getText();
	  String primaryContact = device.primaryContact.getText();
	  String installAddress = device.installAddress.getText();
	  System.out.println("Install address should pass");
//	 logger.info("Install address should pass");
	  Thread.sleep(500);
	 
//search for Service Reqst button	  
	  for (int i=1;i<=5;i++){  //*[@id='deviceListTab']/div[5]/button[1]
				  String strText= driver.findElement(By.xpath("//*[@id='device']/div[4]/div[2]/div/button["+i+"]")).getText();
				  String [] splitStr = strText.split(" ");
				  String KEY = splitStr[0]; 
				  System.out.println(KEY); //split the product key & take only REMOVE key
//		logger.info("split the product key & take only REMOVE key");		  
				  if(KEY.equalsIgnoreCase(operationKey)){
					  driver.findElement(By.xpath("//*[@id='device']/div[4]/div[2]/div/button["+i+"]")).click(); 
					  Thread.sleep(4000);
					  Assert.assertEquals(device.pageHeader.getText(), "Request Device Removal for "+productModel);
					  break;
				  	}
				  		else {
				  			System.out.println(operationKey+"does not exixts");
//				 			logger.info(operationKey+"does not exixts");
				  			}
				  	}
//Capture Page	  
	
	  s_assert.assertEquals(device.capturePageSerialNo.getText(), deviceNumber);
	  s_assert.assertEquals(device.capturePageIpAddress.getText(), ipAddress);
	  s_assert.assertEquals(device.capturePageProductModel.getText(), productModel);
	  s_assert.assertEquals(device.capturePageInstallAddress.getText(), installAddress);
	  device.removeButton.click();
	  Thread.sleep(4000);
	  driver.manage().timeouts().implicitlyWait(12,TimeUnit.SECONDS);
//Review PAge	  
	  System.out.println("careful, next line might fail");
	  s_assert.assertEquals(device.reviewPageSerailNo.getText(),deviceNumber);
	  System.out.println("is this failing gain?");
	  s_assert.assertEquals(device.reviewPageIPAddress.getText(),ipAddress);
	  s_assert.assertEquals(device.reviewPageInstallAddress.getText(),installAddress);
	  System.out.println("last line passed, but next might fail");
//	  s_assert.assertTrue(device.reviewPageReqstCreatedBy.isDisplayed());
	  System.out.println("again-last line passed, but next might fail");
//	  s_assert.assertTrue(device.reviewPageContactForReqst.isDisplayed());
	  String reviewPageRequestCreatedBy = device.reviewPageReqstCreatedBy.getText();
	  String reviewPageContactforRequest = device.reviewPageContactForReqst.getText();
	  device.submitButton();
	  
//Submit or Final Page
	  Thread.sleep(10000);
	  WebDriverWait wait = new WebDriverWait(driver,30);
	  WebElement element = wait.until(ExpectedConditions.elementToBeClickable(device.submitPageContactRest));
	  String submitPageContactforRequest = device.submitPageContactRest.getText();
	  
	  String submitPageRequestCreatedBy = device.submitPageReqstCreatedBy.getText();
	  
	 s_assert.assertEquals(submitPageRequestCreatedBy, reviewPageRequestCreatedBy);
	 System.out.println("reqst created by passed");
//	 logger.info("reqst created by passed");
	 s_assert.assertEquals(submitPageContactforRequest, reviewPageContactforRequest);
	 System.out.println("pramry contact passed");
//	 logger.info("pramry contact passed");
//Submit Page Confirmation message
	  String message1 = "Your Data Asset Deregister request is being submitted";
	  String message2= "Your request ( generating request number... ) is being submitted.";
	  System.out.println("message 2 is set as: "+message2);
//	  logger.info("message 2 is set as: "+message2);
	  	if(message1.equalsIgnoreCase(device.submitPageMessage.getText())){
	  		System.out.println("in Queue/IF block");
//	 		logger.info("in Queue/IF block");
			Assert.assertEquals(message2, device.submitPageMessage2.getText());
			} else {
				System.out.println("in else block/SR generation block");
	//			logger.info("in else block/SR generation block");
				String successSR_message="Submitted | Remove Device Request for "+ productModel;//productModel;
				Assert.assertEquals(device.submitPageMessage.getText(),successSR_message);
				String str=device.readSRNumber.getText();
				String SR = str.split("\\:")[1];
				String SRConfirmationMessage ="Details for Remove Device Request Number:"+SR;
				Assert.assertEquals(SRConfirmationMessage, device.readSRNumber.getText());
				System.out.println("SR number generated is: "+SR);
		//		logger.info("SR number generated is: "+SR);
			}
   }
  
  @AfterTest
  public void tearDown() throws Exception{
	  driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
	  LogIn_Page logout = new LogIn_Page(driver); //Logout
	  logout.Logout();
//	  logger.info("logged out"); 
	  driver.close();
//	  logger.info("& browser close");
  }
  
//Compare data in detail page & review page



}













/* ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", device.installAddress);

Assert.assertTrue(IsElementPresent(device.installAddress));  //install address verificstion in detail page
System.out.println("Install address has passed");*/
