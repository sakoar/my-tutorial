/** This Test is to add a Career Link in Portal Admin Page
 * Author- Sushma
 */

package com.my.basic.test;

import java.util.concurrent.TimeUnit;




import java.util.logging.Logger;

import org.apache.commons.logging.impl.Log4JLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.my.basic.pageObject.LogIn_Page;
import com.my.basic.pageObject.PageObject_AddShippingLink;


public class AddShippingLinkTest {
	WebDriver driver;
	String baseUrl = "https://managedservices.qa.lexmark.com";  //URL
	//final static Logger logger = Logger.getLogger(AddShippingLinkTest.class);
		
			
	
	
@BeforeClass
public void setUp() throws InterruptedException{
	System.out.println("################# This is Add Shipping Link Test ####################");
//PropertyConfigurator.configure("log4j.properties");
//System.setProperty("webdriver.firefox.bin", "C:\\Users\\sanoaoa\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
driver = new FirefoxDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
//logger.info("Launching URL");
driver.get(baseUrl);//Launching URL
//logger.info("Home Page Launced");
LogIn_Page signin = new LogIn_Page(driver);
signin.Login("sumand", "Welcome!123");
Thread.sleep(8000);
	 }	

@Test
public void updateContact()throws Exception{
PageObject_AddShippingLink add_shiplink= new PageObject_AddShippingLink(driver);
add_shiplink.portal_admin_link.click();
Thread.sleep(3000);
add_shiplink.carrier_mgmt_link.click();
Thread.sleep(3000);
add_shiplink.add_carrier_link_button1.click();
add_shiplink.carrier_name.sendKeys("First Flight");
add_shiplink.tracking_Url.sendKeys("http://firstflight.net:8081/single-web-tracking/singleTracking.do");
add_shiplink.add_carrier_link_button2.click();
//logger.info("New carrier link added to the list");
Thread.sleep(3000);
add_shiplink.delete_value_link.click();
//logger.info("New carrier link deleted from the list");

//Log-off
Thread.sleep(4000);
LogIn_Page logout = new LogIn_Page(driver); //Logout
logout.Logout();
driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
driver.close();

}
/*
@AfterTest
public void tearDown() throws Exception{
	Thread.sleep(4000);
	  LogIn_Page logout = new LogIn_Page(driver); //Logout
	  logout.Logout();
	  driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
	  driver.close();

}*/
}
