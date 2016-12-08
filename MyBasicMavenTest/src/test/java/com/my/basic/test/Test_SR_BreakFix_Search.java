package com.my.basic.test;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.lexmark.automation.test.PageObject.helper.LogIn_Page;
import com.lexmark.automation.test.PageObject.helper.PageObject_SR_BreakFix_Search;

public class Test_SR_BreakFix_Search {
WebDriver driver;
String baseUrl = "http://managedservices.qa.lexmark.com";//URL  
Logger logger = Logger.getLogger(Test_UpdateUser.class);
	String RqstNo = "1-167029552521";
	String DeviceTag = "P012-Home Theater";
	String IP = "10.32.32.205";
	String host = "bby00032p012.na";
	String serialNo = "072M9342";
	String product_model="Lexmark E360dn";
	
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
//signin.Login("perftest_amica11@customer.com", "Lexmark01");  // Sign in with credentials
signin.Login("perftest_bestbuy11@customer.com", "Lexmark01");// Sign in with credentials
Thread.sleep(8000);
	 }	

@Test
public void search() throws InterruptedException{
	PageObject_SR_BreakFix_Search break_fix_search = new PageObject_SR_BreakFix_Search(driver);
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	break_fix_search.request_tab.click();
	Thread.sleep(5000);
	break_fix_search.service_request.click();
	Thread.sleep(5000);
	break_fix_search.searchRequest(RqstNo);
	break_fix_search.input_field.clear();
	break_fix_search.input_field.sendKeys(RqstNo);
	break_fix_search.input_field.sendKeys(Keys.ENTER);
	Thread.sleep(5000);


	String device_tag1=break_fix_search.device_tag.getText().trim();
	System.out.println(device_tag1);
	String hostname1=break_fix_search.hostname.getText().trim();
	System.out.println(hostname1);
	String ip_address1=break_fix_search.ip_address_table.getText().trim();
	System.out.println(ip_address1);
	String serial_no1=break_fix_search.serial_no.getText().trim();
	System.out.println(serial_no1);
	String product_model1=break_fix_search.product_model.getText().trim();
	System.out.println(product_model1);
	String req_no1=break_fix_search.req_no.getText().trim();
	break_fix_search.req_no.click();
	Thread.sleep(3000);
	String[] SR= break_fix_search.message1.getText().split(": ");
	System.out.println(SR[1]);
	String ip_address2=break_fix_search.ip_address_finalpage.getText().trim();
	System.out.println(ip_address2);
	String serial_no2=break_fix_search.serial_no_final.getText().trim();
	System.out.println(serial_no2);
	Assert.assertEquals(req_no1,SR[1]);
	System.out.println("SR Nos are same");
	Assert.assertEquals(ip_address1, ip_address2);
	System.out.println("IP Addresses are same");
	Assert.assertEquals(serial_no1, serial_no2);
	System.out.println("Serial Nos are same");
	System.out.println("Search Through Request No. Completed");
	Thread.sleep(8000);
	break_fix_search.request_tab.click();
	Thread.sleep(5000);
	break_fix_search.service_request.click();
	Thread.sleep(5000);
	
//#################################Searching through SR No####################################
		driver.findElement(By.xpath("//*[@id='serviceRequestsServiceTab']/span/div[3]/div[1]/div/div/div[1]/div[1]/div/div/div[2]/div")).click();
		System.out.println("click on down");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='serviceRequestsServiceTab']/span/div[3]/div[1]/div/div/div[1]/div[1]/div/div/div[3]/ul/li[1]")).click();
		System.out.println("Request No selected");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).clear();
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys(RqstNo);
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys(Keys.ENTER);
		Thread.sleep(10000);
		
//#################################Searching through DeviceTag####################################
		driver.findElement(By.xpath("//*[@id='serviceRequestsServiceTab']/span/div[3]/div[1]/div/div/div[1]/div[1]/div/div/div[2]/div")).click();
		System.out.println("drop down selected");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='serviceRequestsServiceTab']/span/div[3]/div[1]/div/div/div[1]/div[1]/div/div/div[3]/ul/li[2]")).click();
		Thread.sleep(2000);
		System.out.println("DeviceTag Selected");
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).clear();
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys(DeviceTag);
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys(Keys.ENTER);
		Thread.sleep(10000);
		
//######################################################################Searching through Hostname##############
		driver.findElement(By.xpath("//*[@id='serviceRequestsServiceTab']/span/div[3]/div[1]/div/div/div[1]/div[1]/div/div/div[2]/div")).click();
		System.out.println("drop down selected");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='serviceRequestsServiceTab']/span/div[3]/div[1]/div/div/div[1]/div[1]/div/div/div[3]/ul/li[3]")).click();
		Thread.sleep(2000);
		System.out.println("Hostname Selected");
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).clear();
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys(host);
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys(Keys.ENTER);
		Thread.sleep(10000);
	

//######################################################################Searching through IP ADDRESS##############
	driver.findElement(By.xpath("//*[@id='serviceRequestsServiceTab']/span/div[3]/div[1]/div/div/div[1]/div[1]/div/div/div[2]/div")).click();
	System.out.println("drop down selected");
	Thread.sleep(4000);
	driver.findElement(By.xpath("//*[@id='serviceRequestsServiceTab']/span/div[3]/div[1]/div/div/div[1]/div[1]/div/div/div[3]/ul/li[4]")).click();
	Thread.sleep(2000);
	System.out.println("Ip Address selected");
	driver.findElement(By.xpath("(//input[@type='text'])[3]")).clear();
	driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys(IP);
	Thread.sleep(5000);
	driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys(Keys.ENTER);
	Thread.sleep(10000);
	
//##############################################################Searching through Serial No######################	
	driver.findElement(By.xpath("//*[@id='serviceRequestsServiceTab']/span/div[3]/div[1]/div/div/div[1]/div[1]/div/div/div[2]/div")).click();
	System.out.println("drop down selected");
	Thread.sleep(4000);
	driver.findElement(By.xpath("//*[@id='serviceRequestsServiceTab']/span/div[3]/div[1]/div/div/div[1]/div[1]/div/div/div[3]/ul/li[5]")).click();
	System.out.println("Serial no selected");
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//input[@type='text'])[3]")).clear();
	driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys(serialNo);
	Thread.sleep(5000);
	driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys(Keys.ENTER);
	Thread.sleep(6000);
	
	//##############################################################Searching through Product Model######################	
		driver.findElement(By.xpath("//*[@id='serviceRequestsServiceTab']/span/div[3]/div[1]/div/div/div[1]/div[1]/div/div/div[2]/div")).click();
		System.out.println("drop down selected");
		Thread.sleep(4000);
		String strText=driver.findElement(By.xpath("//*[@id='serviceRequestsServiceTab']/span/div[3]/div[1]/div/div/div[1]/div[1]/div/div/div[3]/ul/li[6]")).getText();
				System.out.println(strText);
		driver.findElement(By.xpath("//*[@id='serviceRequestsServiceTab']/span/div[3]/div[1]/div/div/div[1]/div[1]/div/div/div[3]/ul/li[6]")).click();
		System.out.println("Product Model selected");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).clear();
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys(product_model);
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys(Keys.ENTER);
		Thread.sleep(10000);
}

@AfterTest
public void tearDown() throws Exception{	
 LogIn_Page logout = new LogIn_Page(driver); //Logout
 logout.Logout();
 driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
 driver.close();
 }
}


