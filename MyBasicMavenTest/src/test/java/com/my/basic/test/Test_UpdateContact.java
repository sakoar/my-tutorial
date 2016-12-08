package com.my.basic.test;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.lexmark.automation.test.PageObject.helper.LogIn_Page;
import com.lexmark.automation.test.PageObject.helper.PageObjectRemoveContact;
import com.lexmark.automation.test.PageObject.helper.PageObject_UpdateContact;

public class Test_UpdateContact {
WebDriver driver;
String baseUrl = "https://managedservices.qa.lexmark.com";//"Launching url 
String contactFirstName="jay";

@BeforeClass
public void setUp() throws InterruptedException{
System.setProperty("webdriver.firefox.bin", "C:\\Users\\sanoaoa\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
//System.setProperty("webdriver.gecko.driver", "C:\\Users\\sanoaoa\\workspace\\MPS_Venus_Test_Automation\\drivers\\geckodriver.exe");
//driver=new ChromeDriver();*/
driver = new FirefoxDriver();
driver.manage().window().maximize();
driver.get(baseUrl);
Thread.sleep(2000);
LogIn_Page signin = new LogIn_Page(driver);
signin.Login("perftest_bestbuy@customer.com", "Lexmark01");
driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
}

@Test()
public void contactAddressUpdate() throws InterruptedException{
PageObject_UpdateContact updateaddress= new PageObject_UpdateContact(driver);
updateaddress.contact.click();
updateaddress.search4Contact(contactFirstName);
Thread.sleep(2000);
driver.findElement(By.linkText(contactFirstName)).click();
Thread.sleep(2000);
updateaddress.contact_address_tab.click();
updateaddress.address1.clear();
updateaddress.address1.sendKeys("3351 Cove Lake Dr");
updateaddress.address2.sendKeys("Lane2");
//updateaddress.city_name.clear();
//updateaddress.city_name.sendKeys("");
updateaddress.zipcode.clear();
updateaddress.zipcode.sendKeys("40511");
updateaddress.building.sendKeys("Building No1");
updateaddress.floor.sendKeys("4");
updateaddress.office.sendKeys("Lexmark");
//Thread.sleep(2000);
driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
updateaddress.update_address_button1.click();
driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
//Thread.sleep(2000);
updateaddress.update_address_button2.click();
driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
//Thread.sleep(2000);
String req1=updateaddress.req_created_block1.getAttribute("value");
String cont1=updateaddress.contact_block1.getAttribute("value");
updateaddress.refId.sendKeys("12345");
updateaddress.cost_centre.sendKeys("Lexmark");
updateaddress.user_comments.sendKeys("NA");
Thread.sleep(2000);
updateaddress.submit_address_button.click();
//WebDriver wait = new WebDriver(driver,40);
driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
System.out.println("Navigating to the Final Submission Page");

//##################################Performing Operation on Final Page & Validation#####
WebDriverWait wait1 =new WebDriverWait(driver, 50);
WebElement el=wait1.until(ExpectedConditions.elementToBeClickable(updateaddress.req_createdby2));
//String req2 = el.getText().trim();
String req2 = el.getAttribute("value");

WebDriverWait wait2 =new WebDriverWait(driver, 50);
WebElement e2=wait2.until(ExpectedConditions.elementToBeClickable(updateaddress.contact_block2));
//String cont2 = e2.getText().trim();
String cont2 = e2.getAttribute("value");


//String req2=updateaddress.req_createdby2.getAttribute("value");
//String address2=updateaddress.contact2.getAttribute("value");
Assert.assertEquals(req1, req2);
System.out.println("Request Created By Details are same");
Assert.assertEquals(cont1, cont2);
System.out.println("Contact Details Created By are same");
/*
//####Verifying Confirmation Message of Request Page######
//String confirmation_message=el.getText();
//######Assertion ###########################
WebDriverWait wait = new WebDriverWait(driver, 10);
WebElement updatemsg = wait.until(ExpectedConditions.elementToBeClickable(updateaddress.confirmation_message));
String confirmation_message=updatemsg.getText();
System.out.println(confirmation_message);


String msg1 = "Details for Update Device Request Number:";
//String msg2=driver.findElement(By.cssSelector("h1.ng-scope > span")).getAttribute("value");
//String msg2 = "Details for Update Device Request Number "+"\""+request_no+"\"";
String confmsg=msg1+msg2;
//"Changes to "+"\""+fullName+"\""+" have been saved!
*/
        
}


@AfterTest
public void tearDown() throws Exception{
	  LogIn_Page logout = new LogIn_Page(driver); //Logout
	  logout.Logout();
	  driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
	  driver.close();
}
}


