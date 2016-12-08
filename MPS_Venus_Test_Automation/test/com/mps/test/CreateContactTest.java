package com.mps.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import org.testng.Assert;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import com.lexmark.automation.test.PageObject.helper.LogIn_Page;
import com.lexmark.automation.test.PageObject.helper.PageObject_CreateNewContact;


public class CreateContactTest {
	//BasicConfigurator.configure();
	//Properties prop = new Properties();
	//prop.load(new FileInputStream("log4j.properties"));
	//prop.load(new FileInputStream("log4j.properties"));
	//PropertyConfigurator.configure(prop);
	
	
	Logger logger = Logger.getLogger(CreateContactTest.class);
	
	
	
	WebDriver driver;
	String baseUrl = "https://managedservices.qa.lexmark.com";//"https://managedservices.qa.lexmark.com";
	LogIn_Page login;
	String emailID;
	String lastName;
	PageObject_CreateNewContact createContact;
	

@BeforeClass
	public void setUp() throws InterruptedException{
	PropertyConfigurator.configure("log4j.properties");
	logger.info("################# This is CONTACT Creation Test ####################");
		//System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		//driver=new ChromeDriver();
	    System.setProperty("webdriver.firefox.bin", "C:\\Users\\sanoaoa\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
	    driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
		logger.info("Firefox Launched & Navigated to the Base URL");
			login = new LogIn_Page(driver);
			driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
			login.Login("perftest_bestbuy@customer.com", "Lexmark01"); //Login Test
			logger.info("Login Successful");
	}

  @Test
  public void contactDetails() throws InterruptedException {
	  createContact = new PageObject_CreateNewContact(driver);
	  createContact.contactTab.click();
	  Thread.sleep(1500);
	  createContact.createNewContactBtn.click();
	  Thread.sleep(4000);
	  System.out.println("All okay");
//Contact Info	  
	  createContact.firstName.sendKeys("selenium");
	  System.out.println("All okay");
	  Map <String, String> userMap = createContact.captureContactInfo(); //declare the email
	  
	  createContact.lastName.sendKeys(userMap.get("lastName"));
	  logger.info("fetching the random email & last name");
	  System.out.println("all okay");
	  createContact.email.sendKeys(userMap.get("email"));
	  createContact.workPhone.sendKeys("+919876543210");
//Contact Location
	  System.out.println("going to click on Country field");
	  new Select(createContact.country).selectByVisibleText("USA");
	  createContact.addLine1.sendKeys("3351 Cove Lake Drive");
	  createContact.city.sendKeys("Lexington");
	  new Select(createContact.state).selectByVisibleText("Kentucky");
	  createContact.postalCode.sendKeys("40515");
	  createContact.bldgName.sendKeys("3");
	  createContact.floorName.sendKeys("4 floor");
	  createContact.sitName.sendKeys("site name");
	  
	  createContact.submitButton.click();
	  logger.info("Captured all the details & clicked on Submit button");
	  Thread.sleep(2000);
	  createContact.submitButton.click();
	  Thread.sleep(4000);
	  String confMessage="Update Supplies Contact | "+createContact.firstName+" "+userMap.get("lastName");
	  System.out.println(confMessage);
	  AssertJUnit.assertEquals(createContact.confirmationPageMessage.getText(),confMessage);
	  logger.info("Assertion done");
	  
	  }
  
  @AfterMethod
 @AfterTest
  public void tearDown() throws Exception{
	  LogIn_Page logout = new LogIn_Page(driver); //Logout
	  logout.Logout();
	  logger.info("Loged Out");
	  driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
	  driver.quit();
	  logger.info("& browser close");
	  
  }
  
//Compare data in detail page & review page


}
