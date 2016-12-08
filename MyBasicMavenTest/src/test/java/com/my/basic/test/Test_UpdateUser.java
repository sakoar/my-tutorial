package com.my.basic.test;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.lexmark.automation.test.PageObject.helper.LogIn_Page;
import com.lexmark.automation.test.PageObject.helper.PageObject_OrderSupplies;
import com.lexmark.automation.test.PageObject.helper.Users_PageObject;

public class Test_UpdateUser {
WebDriver driver;
String baseUrl = "http://managedservices.qa.lexmark.com";//"Launching url 

String email="selenium.1113@domain.com";
Logger logger = Logger.getLogger(Test_UpdateUser.class);

@BeforeClass
public void setUp() throws InterruptedException{
PropertyConfigurator.configure("log4j.properties");
System.setProperty("webdriver.firefox.bin", "C:\\Users\\sanoaoa\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
driver = new FirefoxDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
logger.info("######################This is UPDATE USER TEST#####################");
logger.info("Navigating to url");
System.out.println("navigating to base url");
driver.get(baseUrl);
System.out.println("navigated to base url");
Thread.sleep(5000);
LogIn_Page signin = new LogIn_Page(driver);
signin.Login("perftest_amica11@customer.com", "Lexmark01");

 }	

@Test
public void orderSupplies()throws Exception{
Users_PageObject user_udate= new Users_PageObject(driver);
driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
user_udate.users.click();
//Thread.sleep(3000);
driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys(email);
//Thread.sleep(2000);
driver.findElement(By.xpath("//div[@id='allUsers']/span/div[3]/div/div/div/div/div[2]/div/div/div[2]/button")).click();
//Thread.sleep(2000);
driver.findElement(By.linkText(email)).click();
//Thread.sleep(2000);
user_udate.firstName.clear();
user_udate.firstName.sendKeys("Selenium");
user_udate.lastName.clear();
user_udate.lastName.sendKeys("456");
user_udate.workPhone.clear();
user_udate.workPhone.sendKeys("9835733391");
Thread.sleep(6000);
Select option = new Select(driver.findElement(By.name("country")));
String countrySelected=option.getFirstSelectedOption().getText();
System.out.println("The value of Country selected is: "+option.getFirstSelectedOption().getText());

if(countrySelected.equalsIgnoreCase("USA")){
	System.out.println("Country is USA, so we are in if block, updating to ZA");
	option.selectByVisibleText("South Africa");
	user_udate.captureAddress("10 Tyrewhitt Road", "Johannesburg", "Gauteng", "2016");
}else{
	System.out.println("Country is ZA, so we are in else block, updating to USA");
	option.selectByVisibleText("USA");
	user_udate.captureAddress("3351 Cove Lake Drive", "Lexington", "Kentucky", "40515");
}

Thread.sleep(3000);
driver.findElement(By.xpath("//div[@id='userProfileTab']/span/div/form/div[3]/div/button[2]")).click(); //Update User
System.out.println("clicked on Update button");

Thread.sleep(12000);
/*
WebDriverWait wait = new WebDriverWait(driver,40);
wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[4]/span"))));
*/
String msg1=driver.findElement(By.xpath("//div[4]/span")).getText().trim();
System.out.println(msg1);
Assert.assertTrue(msg1.contains("User has been successfully updated"));

//System.out.println("Address Details has been updated");
Thread.sleep(3000);
//user_udate.users.click();
/*
driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys(email);
driver.findElement(By.xpath("//div[@id='allUsers']/span/div[3]/div/div/div/div/div[2]/div/div/div[2]/button")).click();
Thread.sleep(2000);
Thread.sleep(2000);*/
//search for email again
System.out.println("searching for email again");
user_udate.searchEmail(email);
driver.findElement(By.linkText(email)).click();
System.out.println("going to update the account access");
driver.findElement(By.linkText("Account access")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//div[@id='accountAccessTab']/span/div/form/div[3]/div[2]/div[2]/label/span")).click();
driver.findElement(By.xpath("//div[@id='accountAccessTab']/span/div/form/div[4]/div/button[2]")).click();
String msg2=driver.findElement(By.xpath("//div[4]")).getText().trim();
//System.out.println(msg2);
//Assert.assertTrue(msg1.contains("User has been successfully updated"));
}

@AfterTest
public void tearDown() throws Exception{
	  LogIn_Page logout = new LogIn_Page(driver); //Logout
	  logout.Logout();
	  Thread.sleep(4000);
	  driver.close();
}	 
	 
}
