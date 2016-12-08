package com.mps.test;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.lexmark.automation.test.PageObject.helper.LogIn_Page;
import com.lexmark.automation.test.PageObject.helper.PageObject_PortalAdmin_HomePageNotification;


public class Test_PortalAdmin_HomePageNotification {
	WebDriver driver;
	String baseUrl = "https://managedservices.qa.lexmark.com";  //URL
	Logger logger = Logger.getLogger(Test_UpdateUser.class);
	LogIn_Page signin;
	String message1="Hello user!This is automation test";
	
@BeforeClass
public void setUp() throws InterruptedException{
PropertyConfigurator.configure("log4j.properties");
System.setProperty("webdriver.firefox.bin", "C:\\Users\\sanoaoa\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
driver = new FirefoxDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
logger.info("Launching URL");
driver.get(baseUrl);//Launching URL
logger.info("Home Page Launced");
signin = new LogIn_Page(driver);
signin.Login("sumand", "Welcome!123");
Thread.sleep(8000);
	 }	

@Test
public void homePageNotification()throws Exception{
PageObject_PortalAdmin_HomePageNotification homepage_notify= new PageObject_PortalAdmin_HomePageNotification(driver);
driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
homepage_notify.portal_admin_link.click();
homepage_notify.homepage_notification_tab.click();
//Thread.sleep(5000);
homepage_notify.create_notification_button.click();
//homepage_notify.createAdminNotification();
//Thread.sleep(2000);
//Calling method for Admin Notification creation

homepage_notify.from_date.sendKeys("12/01/2016 01:00");
homepage_notify.to_date.sendKeys("12/31/2016 23:00");
homepage_notify.title.sendKeys("TestAuto");
homepage_notify.message_display.sendKeys(message1);

logger.info(message1);
//homepage_notify.url.sendKeys("http://www.seleniumhq.org");
homepage_notify.url.sendKeys("http://www.google.co.in");
homepage_notify.save_notification_button.click();
homepage_notify.title_link.click(); 
homepage_notify.log_out.click();// logged out from Sumand
logger.info("Portal Admin Logged Out from the Application");

//Loggin in to amica
driver.get("http://managedservices.qa.lexmark.com/");
logger.info("URL Launced");
//signin= new LogIn_Page(driver);
signin.Login("perftest_amica11@customer.com", "Lexmark01");
logger.info("Different User logged in to the Application & Home Page Launced");
String message2=homepage_notify.msg.getText().trim();
Assert.assertEquals(message1,message2);
Thread.sleep(3000);
//String url2=homepage_notify.link2.getText().trim();
logger.info(message2);
//logger.info(url2);
/*******************************Validation of HomePage notification with different user****************/

logger.info("HomePage Notification validated for different Users");
homepage_notify.log_out.click(); //logout from amica
logger.info("Different User logged out");
logger.info("Portal Admin Logging to Application");
//homepage_notify.deleteAdminNotification();///Calling method for Admin Notification creation
//homepage_notify.log_out.click();
//driver.close();

/*******************************Relogin to SUMAND****************/
driver.get("http://managedservices.qa.lexmark.com/");
logger.info("URL Launced");
//LogIn_Page signin = new LogIn_Page(driver);
signin.Login("sumand", "Welcome!123");
logger.info("Portal Admin logged in to the Application");
homepage_notify.portal_admin_link.click();
homepage_notify.homepage_notification_tab.click();
//homepage_notify.link2.click();
homepage_notify.link_to_delete.click();
Thread.sleep(2000);
homepage_notify.delete_notification_button.click();
logger.info("Notification deleted by Portal Admin");
homepage_notify.log_out.click();
logger.info("SumanD logged out from the Application");
driver.get("http://managedservices.qa.lexmark.com/");
logger.info("URL Launced");
//LogIn_Page signin = new LogIn_Page(driver);
signin.Login("perftest_amica11@customer.com", "Lexmark01");
logger.info("amica User logged in to the Application");
String message3=homepage_notify.msg3.getText().trim();
//Assert.assertFalse(message1.contains(msg));
Assert.assertNotEquals(message3,message1);
logger.info("Notification Deleted from the Users Homepage");



}
}
