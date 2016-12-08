package com.mps.test;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.lexmark.automation.test.PageObject.helper.LogIn_Page;
import com.lexmark.automation.test.PageObject.helper.PageObject_DeviceMove;
import com.lexmark.automation.test.PageObject.helper.PageObject_PortalAdmin_DocUpload;

public class Test_PortalAdmin_DocUpload {
	WebDriver driver;
	String baseUrl = "https://managedservices.qa.lexmark.com";  //URL
	Logger logger = Logger.getLogger(Test_UpdateUser.class);
	
	
@BeforeClass
public void setUp() throws InterruptedException{
PropertyConfigurator.configure("log4j.properties");
System.setProperty("webdriver.firefox.bin", "C:\\Users\\sanoaoa\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
driver = new FirefoxDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
logger.info("Launching URL");
driver.get(baseUrl);//Launching URL
logger.info("Home Page Launced");
LogIn_Page signin = new LogIn_Page(driver);
//signin.Login("perftest_amica11@customer.com", "Lexmark01");  // Sign in with credentials
signin.Login("sumand", "Welcome!123");
//signin.Login("perftest_bestbuy11@customer.com", "Lexmark01");// Sign in with credentials
Thread.sleep(8000);
	 }	

@Test
public void updateContact()throws Exception{
PageObject_PortalAdmin_DocUpload admin_doc_upload= new PageObject_PortalAdmin_DocUpload(driver);
admin_doc_upload.portal_admin.click();
Thread.sleep(2000);
admin_doc_upload.doc_mgmt_link.click();
admin_doc_upload.add_doc_button.click();
Thread.sleep(5000);
admin_doc_upload.uploadFile();
Thread.sleep(5000);
String documentname= admin_doc_upload.doc_name.getText().trim();
admin_doc_upload.description.sendKeys("This is for Testing");
admin_doc_upload.tagging.sendKeys("Reports");
Thread.sleep(8000);
admin_doc_upload.tagging.sendKeys(Keys.ENTER);
admin_doc_upload.publish_from.sendKeys("11/25/2016");
Thread.sleep(5000);
admin_doc_upload.publish_to.sendKeys("12/25/2016");
Thread.sleep(5000);
admin_doc_upload.publish_button.click();
Thread.sleep(10000);
logger.info("Navigating to the next page & performing operations on that"); 

//********************Performing Operations on the next Page******************
String message=admin_doc_upload.message.getText().trim();
logger.info(message);
Assert.assertTrue(message.contains(documentname));
logger.info("File Uploaded Successfully");
driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div[2]/div[2]/div[1]/div/div/div[1]/div[1]/div/div/div[2]/span")).click();
admin_doc_upload.input_field.sendKeys(documentname);
admin_doc_upload.input_field.sendKeys(Keys.ENTER);
Thread.sleep(3000);
logger.info("Getting File Searched");
}
	
/*******************Logout & Closing browser*********************/
@AfterTest
public void tearDown() throws Exception{	
 LogIn_Page logout = new LogIn_Page(driver); //Logout
 logout.Logout();
 driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
 driver.quit();
}	

	
}
