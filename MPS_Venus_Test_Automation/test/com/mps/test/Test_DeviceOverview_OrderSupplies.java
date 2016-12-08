package com.mps.test;

import java.util.concurrent.TimeUnit;

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
import org.testng.asserts.SoftAssert;

import com.lexmark.automation.test.PageObject.helper.LogIn_Page;

import com.lexmark.automation.test.PageObject.helper.PageObject_DeviceOverview_OrderSupplies;
import com.lexmark.automation.test.PageObject.helper.PageObject_OrderSupplies;
import com.lexmark.automation.test.PageObject.helper.dateCalculations;

public class Test_DeviceOverview_OrderSupplies {

		WebDriver driver;
		String baseUrl = "https://managedservices.qa.lexmark.com";//"Launching url 
		//String contactFirstName="TEST13";
		SoftAssert s_assert;
		String deviceNumber = "3505MV0";
		String SR;
		dateCalculations date = new dateCalculations();
@BeforeClass
public void setUp() throws InterruptedException{
System.setProperty("webdriver.firefox.bin", "C:\\Users\\sanoaoa\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
//System.setProperty("webdriver.firefox.bin", "C:\\Users\\sanoaoa\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
//System.setProperty("webdriver.gecko.driver", "C:\\Users\\sanoaoa\\workspace\\MPS_Venus_Test_Automation\\drivers\\geckodriver.exe");
//driver=new ChromeDriver();*/
driver = new FirefoxDriver();
driver.manage().window().maximize();
driver.get(baseUrl);
Thread.sleep(5000);
LogIn_Page signin = new LogIn_Page(driver);
signin.Login("perftest_amica11@customer.com", "Lexmark01");
driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
Thread.sleep(12000);
 }	

//##########################Performing Operation & Capturing SR No# through Order tab of Home Page##############
@Test(priority=0)
public void orderSupplies()throws Exception{
PageObject_OrderSupplies ordersupply= new PageObject_OrderSupplies(driver);
ordersupply.searchDevice(deviceNumber);
driver.findElement(By.linkText(deviceNumber)).click();
System.out.println("in Device page");
Thread.sleep(3000);
driver.findElement(By.xpath("//button[text()='ORDER SUPPLIES']")).click();

//#####################Performing Operations on 2nd Page#######################
System.out.println("Adding parts");
ordersupply.add_order1.click();
Thread.sleep(2000);
ordersupply.review_and_submit.click();
ordersupply.buiding.clear();
ordersupply.buiding.sendKeys("100");
ordersupply.floor.clear();
ordersupply.floor.sendKeys("5th");
ordersupply.office.sendKeys("Lexmark Technologies");
ordersupply.delivery_instructions.sendKeys("Before 5 pm");
ordersupply.po_number.sendKeys("1234567");
Thread.sleep(2000);
//String order_create1= ordersupply.order_createdby_block1.getAttribute("value");
//String contact1= ordersupply.contact_block1.getAttribute("value");
Thread.sleep(2000);
ordersupply.refId.sendKeys("7654321");
ordersupply.cost_centre.sendKeys("Lexington");
ordersupply.user_comments.sendKeys("NA");
ordersupply.submit_button2.click();
Thread.sleep(8000);
WebDriverWait wait = new WebDriverWait(driver, 30);
WebElement actualSubmitMessage = wait.until(ExpectedConditions.elementToBeClickable(ordersupply.submitPageMessage));

String message2= "Your request ( generating request number... ) is being submitted.";

if(message2.equalsIgnoreCase(ordersupply.submitPageMessage2.getText())){
	System.out.println("in Queue/IF block");
	Assert.assertEquals(message2, ordersupply.submitPageMessage2.getText());
	} else {
		System.out.println("in else block/SR generation block");
	//	String ExpectedSR_message="Submitted | Supplies order for "+ productModel;//productModel;
	//	Assert.assertEquals(actualSubmitMessage.getText(),ExpectedSR_message);
		String str=ordersupply.readSRNumber.getText();
		System.out.println(str);
		String[] Split = str.split("\\: ");
		SR = Split[1];
	
		String SRConfirmationMessage ="Details for supplies order number: "+SR;
		Assert.assertEquals(SRConfirmationMessage, str);
		System.out.println(str);
		System.out.println("Order Supplies SR number generated is: "+SR);
	}

PageObject_DeviceOverview_OrderSupplies dev_order_supply= new PageObject_DeviceOverview_OrderSupplies(driver);
System.out.println("Searching for Device again");
//dev_order_supply.DevicesTab.click();
dev_order_supply.searchDevice(deviceNumber);
Thread.sleep(2000);
driver.findElement(By.linkText(deviceNumber)).click();
//dev_order_supply.order_search_icon.click();
System.out.println("Navigate to Order Supplies tab");
Thread.sleep(4000);
driver.findElement(By.linkText("Supply orders")).click();
Thread.sleep(4000);
String SRinDeviceOverview = driver.findElement(By.xpath("//*[@id='orderTab']/div/div/div[1]/div/div[1]/div[1]")).getText();
System.out.println("Asserting the SR Number");
Assert.assertEquals(SRinDeviceOverview,SR);
System.out.println("Asserting the SR Status");
Assert.assertEquals(driver.findElement(By.xpath("//div[@id='orderTab']/div/div/div/div/div/div[2]/div/div/div[2]/div")).getText(),"Submitted");
System.out.println("Asserting the SR Creation Date");
Assert.assertEquals(driver.findElement(By.cssSelector("div.status-state-date.ng-binding")).getText(), date.dateCalculate());
//driver.findElement(By.cssSelector("css=div.status-state-date.ng-binding")).getText();
	
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


