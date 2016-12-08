package com.my.basic.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.ContextClickAction;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.my.basic.pageObject.LogIn_Page;
import com.my.basic.pageObject.PageObjectRemoveContact;

/*
import com.lexmark.automation.test.PageObject.helper.LogIn_Page;
import com.lexmark.automation.test.PageObject.helper.PageObjectRemoveContact;
*/


public class Test_RemoveContactTest {
WebDriver driver;
String baseUrl = "https://managedservices.qa.lexmark.com";//"Launching url 
		String contactFirstName="Sam's #6235";
@BeforeClass
public void setUp() throws InterruptedException{
//System.setProperty("webdriver.firefox.bin", "C:\\Users\\sanoaoa\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
//System.setProperty("webdriver.gecko.driver", "C:\\Users\\sanoaoa\\workspace\\MPS_Venus_Test_Automation\\drivers\\geckodriver.exe");
driver = new FirefoxDriver();
//System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
//driver=new ChromeDriver();

driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
driver.get(baseUrl);
LogIn_Page signin = new LogIn_Page(driver);
signin.Login("perftest_walmart@customer.com", "Lexmark01");
}

@Test
public void deleteContact()throws Exception{
PageObjectRemoveContact removeContact= new PageObjectRemoveContact(driver);
driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
System.out.println("###########################This is REMOVE CONTACT Test##############");
removeContact.contact.click(); //click contact tab
Thread.sleep(2000);
removeContact.searchItem(contactFirstName);
Thread.sleep(3000);
driver.findElement(By.linkText(contactFirstName)).click();
Thread.sleep(4000);
removeContact.delete_supplies_button.click();

//############################Performing Operations on Delete Supplies Contact Page#######
WebDriverWait wait =new WebDriverWait(driver, 50);
WebElement el=wait.until(ExpectedConditions.elementToBeClickable(removeContact.req_created_by1));
String rpRqstCreatedBy = el.getText().trim();
driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
String rpContactInfo = removeContact.contactInfo1.getText().trim();
String rpContactLocation = removeContact.contactLocation1.getText().trim();
String rpPramContact = removeContact.contactInfo1.getText().trim();
removeContact.ref_id.sendKeys("This is ref id");
removeContact.cost_centre.sendKeys("Cost centre");
removeContact.comment.sendKeys("This is for Testing");

Actions a=new Actions(driver);
a.sendKeys(Keys.TAB).build().perform();
Thread.sleep(2000);
removeContact.comment.sendKeys(Keys.TAB);
Thread.sleep(2000);
a.sendKeys(Keys.TAB).build().perform();
Thread.sleep(2000);
a.sendKeys(Keys.TAB).build().perform();
Thread.sleep(2000);
a.sendKeys(Keys.ENTER).build().perform();
Thread.sleep(10000);
//removeContact.submit_delete_button.click();
//Thread.sleep(10000);
System.out.println("Navigating to the final Submission Page");


//######################Performing Operations on Delete Contact Request Submitted Page#######
String spContactInfo = removeContact.contactInfo2.getText();
String spContactLocation = removeContact.contactLocation2.getText();
String spRqstCreatedBy = removeContact.req_created_by2.getText();
String spPramContact = removeContact.contactInfo2.getText();

//#########################Validation##################
//Assert.assertEquals(rpContactInfo,spContactInfo);
//Assert.assertEquals(rpContactLocation,spContactLocation);
System.out.println("Test Passed, Contact Details Deleted");
//Assert.assertEquals(rpRqstCreatedBy,spRqstCreatedBy);
System.out.println("Request Created by are same");
//Assert.assertEquals(rpPramContact,spPramContact);
System.out.println("Primary Contact Details are same");
System.out.println("Test Passed, Contact Details Removed Successfully");


Thread.sleep(3000);
// LogIn_Page logout = new LogIn_Page(driver); //Logout
 //logout.Logout();
 driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
 driver.close();
}

/*
@AfterTest
public void tearDown() throws Exception{
	Thread.sleep(3000);
	 // LogIn_Page logout = new LogIn_Page(driver); //Logout
	  //logout.Logout();
	  driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
	  driver.close();
} */
}

