package com.mps.test;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.CacheLookup;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.lexmark.automation.test.PageObject.helper.LogIn_Page;
import com.lexmark.automation.test.PageObject.helper.PageObject_DeviceMove;

public class Test_DeviceMove {
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
signin.Login("perftest_amica11@customer.com", "Lexmark01");  // Sign in with credentials
//signin.Login("perftest_bestbuy11@customer.com", "Lexmark01");// Sign in with credentials
Thread.sleep(8000);
	 }	

@Test
public void updateContact()throws Exception{
PageObject_DeviceMove move_device= new PageObject_DeviceMove(driver);
move_device.device_tab.click();
move_device.serialno_input_field.sendKeys("4021013000787");
move_device.serialno_input_field.sendKeys(Keys.ENTER);
move_device.serial_select_key.click();
move_device.move_device_button.click();
Thread.sleep(5000);
logger.info("Clicking on Device Move Button & Navigating to next page");

/*******************************Navigating to the next page & clicking on Change Install Address*****/
move_device.address_change_link.click();
Thread.sleep(5000);
logger.info("Changing address by clicking on Change Address link");

/********************Changing Address details**************/
move_device.input_address_field.sendKeys("Hartford Regional/Glastonbury");
move_device.input_address_field.sendKeys(Keys.ENTER);
Thread.sleep(5000);
move_device.address_select_key.click();
move_device.change_install_address_button.click();
Thread.sleep(5000);
logger.info("Navigating to the next page & performing Operations");

/*************************************Navigating to the next page & performing Operations*******/
move_device.building2.sendKeys("Lexmark SEZ");
move_device.floor2.sendKeys("5th Floor");
move_device.office2.sendKeys("Lexmark Inc.");
move_device.review_button.click();
Thread.sleep(5000);
logger.info("Clicking Review button, Navigating to the next page & performing Operations");
/*********************************Providing more details on the next page***************/
move_device.ref_Id.sendKeys("Lex12345");
move_device.req_cost_center.sendKeys("Lexington");
move_device.user_comments.sendKeys("This is for Testing");
move_device.submit_device_req_button.click();
Thread.sleep(5000);
logger.info("Clicking Submit Button & Navigating to the Final Page");

/**********************************Navigating to the Final Page**************************/

String msg=move_device.message.getText().trim();
logger.info(msg);
String updated_address=move_device.updated_address_final_page.getText().trim();
logger.info(updated_address);

/*******************Validation*******************************/
Assert.assertTrue(updated_address.contains("43 Western Blvd"));
logger.info("Test Passed: Install Address Details Updated with new Address");
}

/*******************Logout & Closing browser*********************/
@AfterTest
public void tearDown() throws Exception{	
 LogIn_Page logout = new LogIn_Page(driver); //Logout
 logout.Logout();
 driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
 driver.close();
}
}