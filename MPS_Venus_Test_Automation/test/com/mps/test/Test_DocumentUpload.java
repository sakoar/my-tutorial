package com.mps.test;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.lexmark.automation.test.PageObject.helper.LogIn_Page;
import com.lexmark.automation.test.PageObject.helper.PageObject_DocumentUpload;
import com.lexmark.automation.test.PageObject.helper.dateCalculations;

public class Test_DocumentUpload {
WebDriver driver;
String baseUrl = "http://managedservices.qa.lexmark.com";//URL  
//String baseUrl = "http://only-testing-blog.blogspot.in/2014/01/textbox.html";  //URL
Logger logger = Logger.getLogger(Test_UpdateUser.class);
dateCalculations date = new dateCalculations();

@BeforeClass
public void setUp() throws InterruptedException{
PropertyConfigurator.configure("log4j.properties");
System.setProperty("webdriver.firefox.bin", "C:\\Users\\sanoaoa\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
driver = new FirefoxDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
logger.info("Launching URL");
driver.get(baseUrl);//Launching URL
logger.info("Home Page");
LogIn_Page signin = new LogIn_Page(driver);
signin.Login("perftest_amica11@customer.com", "Lexmark01");  // Sign in with credentials
//signin.Login("perftest_bestbuy11@customer.com", "Lexmark01");// Sign in with credentials
 }	

@Test
public void registerDevice()throws Exception{
PageObject_DocumentUpload doc_upload= new PageObject_DocumentUpload(driver);
driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
doc_upload.documents_tab.click();
doc_upload.add_doc_button.click();
doc_upload.uploadFile();
Thread.sleep(8000);
String documentname=doc_upload.doc_name.getText().trim();
doc_upload.description.sendKeys("This is for Testing");
doc_upload.tagging.sendKeys("Reports");
Thread.sleep(8000);
doc_upload.tagging.sendKeys(Keys.ENTER);
doc_upload.publish_from.sendKeys("11/25/2016");
Thread.sleep(5000);
doc_upload.publish_to.sendKeys("12/25/2016");
Thread.sleep(5000);
doc_upload.publish_button.click();
Thread.sleep(5000);
logger.info("Navigating to the next page & performing operations on that"); 

//********************Performing Operations on the next Page******************
String message=doc_upload.message.getText().trim();
logger.info(message);
Assert.assertTrue(message.contains(documentname));
logger.info("File Uploaded Successfully");
doc_upload.input_field.sendKeys(documentname);
doc_upload.input_field.sendKeys(Keys.ENTER);
logger.info("Getting File Searched");
}

}
