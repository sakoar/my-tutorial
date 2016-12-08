package com.mps.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import com.lexmark.automation.test.PageObject.helper.PageObject_OrderDevice;
import com.lexmark.automation.test.PageObject.helper.PageObject_OrderDevice_Accessiories;


public class Test_OrderDevice {
WebDriver driver;
String baseUrl = "https://managedservices.qa.lexmark.com";//"Launching url 

String shippAddress = "Dallas Regional Office, Frisco, TX";
String billAddress = "PO BOX 6008";

@BeforeClass
public void setUp() throws InterruptedException{

//logger.info("################# This is REMOVE Adrress Test ####################");
System.out.println("################# THis is REMOVE Adrress Test ####################");
System.setProperty("webdriver.firefox.bin", "C:\\Users\\sanoaoa\\AppData\\Local\\Mozilla Firefox\\firefox.exe");

	//logger.info("################# This is REMOVE Adrress Test ####################");
	System.out.println("################# THis is Order Device Test ####################");
System.setProperty("webdriver.firefox.bin", "C:\\Users\\sanoaoa\\AppData\\Local\\Mozilla Firefox\\firefox.exe");

//System.setProperty("webdriver.gecko.driver", "C:\\Users\\sanoaoa\\workspace\\MPS_Venus_Test_Automation\\drivers\\geckodriver.exe");
//driver=new ChromeDriver();*/
driver = new FirefoxDriver();
driver.manage().window().maximize();
driver.get(baseUrl);
Thread.sleep(10000);
LogIn_Page signin = new LogIn_Page(driver);
//signin.Login("perftest_walmart@customer.com","Lexmark01");
signin.Login("perftest_amica11@customer.com  ", "Lexmark01");
driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

  }	

@Test
public void orderDevice()throws Exception{
	PageObject_OrderDevice orderdevice= new PageObject_OrderDevice(driver);
//WebDriverWait wait1 =new WebDriverWait(driver,20);
//WebElement e1= wait1.until(ExpectedConditions.elementToBeClickable(By.linkText("Orders")));
//e1.click();
orderdevice.order_tab.click();
Thread.sleep(2000);
driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
orderdevice.order_device_button.click();
driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
//Select Agreement & Contract
orderdevice.selectContract();    //SELECT AGREEMENT
WebDriverWait wait1 =new WebDriverWait(driver,30);
WebElement e1= wait1.until(ExpectedConditions.elementToBeClickable(orderdevice.pay_now));
e1.click();                     //Click on PAY NOW

WebDriverWait wait2 =new WebDriverWait(driver,30);
WebElement e2= wait2.until(ExpectedConditions.elementToBeClickable(By.id("device-catalog"))); // Printer Bundle Order
e2.click();    					//click on DEVICE CATALOG

orderdevice.continue_button.click();
Thread.sleep(4000);

//################# performing Operation on Account Page#############
orderdevice.add_to_order.click();
System.out.println("Added to Cart");
Thread.sleep(2000);
String part1=orderdevice.part_no1.getAttribute("value");
orderdevice.review_button.click();
Thread.sleep(3000);
System.out.println("Navigating to Review | Hardware order Page");

//################# Address Selection #############


orderdevice.searchShippingAddress(shippAddress);  //This function is to select the
orderdevice.searchBillingAddress(billAddress); 
String RPorderCreatedBy = orderdevice.order_createdby_block1.getText();
String RPPrimaryContact = orderdevice.contact_block1.getText();

//################# Fill details & move to submit page #############
orderdevice.fillingUpOtherDetails();
Thread.sleep(8000);

//################# Verify Submit page #############
orderdevice.submit_hardware_order.click();
Thread.sleep(8000);

driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
String Actual=driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[1]/div/div[3]/div/h1")).getText();

String message1 = "Your Service request is being submitted";
String message2= "Your request ( generating request number... ) is being submitted.";
	
	if(message1.equalsIgnoreCase(Actual)){
		System.out.println("SR went to Queue page:"+message2 );
		} else {
			System.out.println("SR number has been generate");
			String successSR_message="Submitted | Device Order request";
			Assert.assertEquals(Actual,successSR_message);
			System.out.println(Actual);
			String str=orderdevice.readSRNumber.getText();
			System.out.println(str);
			String SR = str.split("\\-")[1];
			System.out.println("SR number generated is: 1-"+SR);
		}

//Assert.assertEquals(orderdevice.SPOrderCreatedBy, RPorderCreatedBy);
//Assert.assertEquals(orderdevice.SPPrimaryContact, RPPrimaryContact);
}

@AfterTest
	public void Logout() throws Exception{
		Thread.sleep(3000);
		  LogIn_Page logout = new LogIn_Page(driver); //Logout
		  logout.Logout();
		  driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		  driver.quit();
	}

	//Compare data in detail page & review page
/*
@AfterClass
	public void quitBrowser(){
		  driver.quit();
	}*/

}



















