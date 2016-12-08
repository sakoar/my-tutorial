package com.mps.test;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.lexmark.automation.test.PageObject.helper.LogIn_Page;
import com.lexmark.automation.test.PageObject.helper.PageObject_Requests_MADC_Lexmark_AddDevice;
import com.lexmark.automation.test.PageObject.helper.dateCalculations;

public class Test_MADC_NonLexmark_AddDevice {
		WebDriver driver;
		String baseUrl = "http://managedservices.qa.lexmark.com";//URL  
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
		//signin.Login("perftest_amica11@customer.com", "Lexmark01");
		signin.Login("perftest_bestbuy11@customer.com", "Lexmark01");// Signing in with credentials
		 }	

		@Test
		public void registerDevice()throws Exception{
		PageObject_Requests_MADC_Lexmark_AddDevice register_device= new PageObject_Requests_MADC_Lexmark_AddDevice(driver);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		register_device.device_tab.click();
		Thread.sleep(4000);
		register_device.register_device_button.click();//Clicking on Register Device Button
		Thread.sleep(5000);
		register_device.lexmark_device_no.click();
		logger.info("Non Lexmark Deice Selected");
		Thread.sleep(4000);
		register_device.product_model_field.sendKeys("PXO1285");
		register_device.serial_no.sendKeys("1234567");
		Thread.sleep(4000);
		/*
		System.out.println(date.dateCalculate());
		String dateAdd = date.dateCalculate().split("/")[1].split("/")[0];
		//String days = dateAdd+10;
		Integer days =Integer.parseInt(dateAdd+10);
		*/
		register_device.date_select.sendKeys("12/13/2016");// Entering date through keyboard
		Thread.sleep(3000);
		register_device.address_link.click();
		Thread.sleep(5000);
		logger.info("Navigating to next page after clicking address link");
		//########################Navigating to next page & performing operations on that page#######
		register_device.address_input.sendKeys("691");
		register_device.search_icon.click();
		register_device.select_install_address_button.click();

		//##################################Navigating to next page###########
		register_device.building.sendKeys("Tower 8");
		register_device.floor.sendKeys("5");
		register_device.office.sendKeys("Lexmarlk Inc");
		register_device.ip_address.sendKeys("10.11.15.156");
		register_device.hostname.sendKeys("hostname");
		register_device.cost_center.sendKeys("Lexington");
		register_device.device_tag.sendKeys("987765432");
		register_device.registration_submit_button1.click();
		Thread.sleep(5000);

		//##### Performing operations on page after clicking  Registration Submit Button1###########

		//String sr1=register_device.serial_no1.getText().trim();
		String addr1=register_device.adress_block1.getAttribute("value");
		String req1=register_device.reqcreated_by_block1.getAttribute("value");
		String contact1=register_device.contact_block1.getAttribute("value");

		register_device.ref_id1.sendKeys("2345678");
		register_device.request_cost_center.sendKeys("NA");
		register_device.user_comments.sendKeys("This is for Testing");
		register_device.registration_submit_button2.click();
		Thread.sleep(5000);
		logger.info("Navigating to Final Page");
		//#############Performing operations on Final Page###########
		String msg=register_device.message.getText().trim();//Details for Register Device Request Number:#########
		logger.info(msg);
		String addr2=register_device.adress_block2.getAttribute("value");
		String req2=register_device.reqcreated_by_block2.getAttribute("value");
		String contact2=register_device.contact_block2.getAttribute("value");

		//#############################Validation######################################
		String message1 = "Your Register device request is being submitted";
		String message2= "Your request ( generating request number... ) is being submitted.";
			if(message1.equalsIgnoreCase(register_device.submitPageMessage.getText())){
				Assert.assertEquals(message2, register_device.submitPageMessage2.getText());
				System.out.println("removeAdrs.submitPageMessage2.getText()");
				} else {
					System.out.println("SR number has been generate");
					String successSR_message="Submitted | Register device request";
					Assert.assertEquals(register_device.submitPageMessage.getText(),successSR_message);
					String str=register_device.readSRNumber.getText();
					String SR = str.split("\\:")[1];
					System.out.println("SR number generated is: "+SR);
				}
			
		//Assert.assertEquals(sr1, sr2);
		Assert.assertEquals(addr1, addr2);
		logger.info("Addres Details validated");
		Assert.assertEquals(req1, req2);
		logger.info("Request Created By Details validated");
		Assert.assertEquals(contact1, contact2);
		logger.info("Contact Details validated");

		logger.info("All Details Validated:Requests - MADC - Add Device - Non-Lexmark Device Completed successfully");
		}

@AfterTest
public void tearDown() throws Exception{
	  LogIn_Page logout = new LogIn_Page(driver); //Logout
	  logout.Logout();
	  driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
	  driver.close();
}


}
		

