package com.mps.test;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.lexmark.automation.test.PageObject.helper.LogIn_Page;
import com.lexmark.automation.test.PageObject.helper.PageObject_Requests_MADC_ChangeMultipleDevices;
import com.lexmark.automation.test.PageObject.helper.PageObject_Requests_MADC_Lexmark_AddDevice;
import com.lexmark.automation.test.PageObject.helper.dateCalculations;

public class Test_ChangeDevice_MultipleDevices {
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
PageObject_Requests_MADC_ChangeMultipleDevices change_device= new PageObject_Requests_MADC_ChangeMultipleDevices(driver);
driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
change_device.device_tab.click();
Thread.sleep(8000);
change_device.serial_no.sendKeys("3500");
Thread.sleep(3000);
change_device.search_serial_icon.click();
change_device.first_item_selected.click();
change_device.second_item_selected.click();
change_device.update_device_button.click();
Thread.sleep(3000);

//############################Navigating to next page####################
String serial1a= change_device.first_device_serial_no1.getText().trim();
logger.info(serial1a);
String serial1b= change_device.second_device_serial_no1.getText().trim();
logger.info(serial1b);
change_device.change_contact_link.click();
Thread.sleep(5000);
change_device.contactUpdate();
Thread.sleep(5000);
change_device.change_contact_button.click();
Thread.sleep(5000);// Change contact updating & navigating back to previous page
change_device.cost_centre.sendKeys("Lexmark Inc.");
change_device.review_button.click();

//############################Performing Operation after navigating to next page####################
change_device.ref_Id.sendKeys("1234567");
change_device.req_cost_centre.sendKeys("Lexington");
change_device.user_comments.sendKeys("This is for Testing");
change_device.submit_device_req_button.click();

//############################Performing Operation on final Page####################
String message=change_device.update_message.getText().trim();
logger.info(message);
String[] request_nos=message.split(": ");
logger.info(request_nos);
//String[] SR=request_nos.split(",")[0].split(":")[1];
//String dateAdd = date.dateCalculate().split("/")[1].split("/")[0];

String serial2a= change_device.first_device_serial_no2.getText().trim();
logger.info(serial2a);
String serial2b= change_device.second_device_serial_no2.getText().trim();
logger.info(serial2b);
//################Validation######################################
String message1 = "Your Service request is being submitted";
String message2= "Your request ( generating request number... ) is being submitted.";
System.out.println("message 2 is set as: "+message2);
logger.info("message 2 is set as: "+message2);
	if(message1.equalsIgnoreCase(change_device.submitPageMessage.getText())){
		Assert.assertEquals(message2, change_device.submitPageMessage2.getText());
		} else {
			System.out.println("SR number has been generate");
			logger.info("SR number has been generate");
			//String successSR_message="Submitted | Update device information for "+productModel;
			//Assert.assertEquals(successSR_message, device.submitPageMessage.getText());
			String str=change_device.readSRNumber.getText();
			
			//	String[] SR	=	str.split("\\: ")[1].split(", ");
				
			System.out.println(str);
			logger.info("SR number generated is: "+str);
		}
Assert.assertEquals(serial1a, serial2a);
Assert.assertEquals(serial1b, serial2b);
}


@AfterTest
public void Logout() throws Exception{
	Thread.sleep(3000);
	  LogIn_Page logout = new LogIn_Page(driver); //Logout
	  logout.Logout();
	  driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
	  driver.close();
}

}
