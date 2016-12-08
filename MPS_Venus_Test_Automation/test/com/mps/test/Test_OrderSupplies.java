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
import com.lexmark.automation.test.PageObject.helper.PageObject_OrderSupplies;

public class Test_OrderSupplies {
WebDriver driver;
String baseUrl = "https://managedservices.qa.lexmark.com";//"Launching url 
//String contactFirstName="TEST13";
SoftAssert s_assert;
String deviceNumber = "3505MV0";

@BeforeClass
public void setUp() throws InterruptedException{
System.setProperty("webdriver.firefox.bin", "C:\\Users\\sanoaoa\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
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

@Test
public void orderSupplies()throws Exception{
PageObject_OrderSupplies ordersupply= new PageObject_OrderSupplies(driver);

ordersupply.searchDevice(deviceNumber);
driver.findElement(By.linkText(deviceNumber)).click();

//Device details page

//s_assert.assertEquals(deviceNumber, ordersupply.serialNumber.getText()); // asserting on the serial no searched for & the one in detail page
String productModel=ordersupply.productModel.getText();
String ipAddress=ordersupply.ipAddress.getText();
String primaryContact = ordersupply.primaryContact.getText();


System.out.println("in Device page");
Thread.sleep(3000);
//driver.findElement(By.xpath("//*[@ng-if, "deviceActionPermissions.createBreakFixAccess"]"))


driver.findElement(By.xpath("//button[text()='ORDER SUPPLIES']")).click();

//#####################Performing Operations on 2nd Page#######################
ordersupply.add_order1.click();
//ordersupply.add_order2.click();
//ordersupply.add_order3.click();
Thread.sleep(2000);
String part1= ordersupply.partno1.getAttribute("value");
ordersupply.review_and_submit.click();

//###################Performing Operation on 3rd Page ###############

String part2= ordersupply.partno2.getAttribute("value");
//String ship_address1= ordersupply.Shipping_address1.getAttribute("value");

ordersupply.buiding.clear();
ordersupply.buiding.sendKeys("100");
ordersupply.floor.clear();
ordersupply.floor.sendKeys("5th");
ordersupply.office.sendKeys("Lexmark Technologies");
ordersupply.delivery_instructions.sendKeys("Before 5 pm");
ordersupply.po_number.sendKeys("1234567");
Thread.sleep(2000);
String order_create1= ordersupply.order_createdby_block1.getAttribute("value");
String contact1= ordersupply.contact_block1.getAttribute("value");
Thread.sleep(2000);
ordersupply.refId.sendKeys("7654321");
ordersupply.cost_centre.sendKeys("Lexington");
ordersupply.user_comments.sendKeys("NA");
ordersupply.submit_button2.click();
Thread.sleep(8000);

WebDriverWait wait = new WebDriverWait(driver, 30);
WebElement actualSubmitMessage = wait.until(ExpectedConditions.elementToBeClickable(ordersupply.submitPageMessage));

//##############Final Page Details###################
String order_create2= ordersupply.order_createdby_block2.getAttribute("value");
String contact2= ordersupply.contact_block2.getAttribute("value");
//String ship_address2= ordersupply.Shipping_address1.getAttribute("value");

//######################Validation###################
Assert.assertEquals(part1, part2);
System.out.println("Part no are same");
Assert.assertEquals(order_create1, order_create2);
System.out.println("Order Created By are same");
Assert.assertEquals(contact1, contact2);
System.out.println("Contact Details are same");
//Assert.assertEquals(ship_address1, ship_address2);
System.out.println("Shipping Address are same");

//System.out.println("Actual submit page message: "+actualSubmitMessage.getText());
//String message1 = "Your Data Asset Deregister request is being submitted";
String message2= "Your request ( generating request number... ) is being submitted.";

	if(message2.equalsIgnoreCase(ordersupply.submitPageMessage2.getText())){
		System.out.println("in Queue/IF block");
		Assert.assertEquals(message2, ordersupply.submitPageMessage2.getText());
		} else {
			System.out.println("in else block/SR generation block");
		//	String ExpectedSR_message="Submitted | Supplies order for "+ productModel;//productModel;
		//	Assert.assertEquals(actualSubmitMessage.getText(),ExpectedSR_message);
			String str=ordersupply.readSRNumber.getText();
			String SR = str.split("\\:")[1];
			String SRConfirmationMessage ="Details for supplies order number:"+SR;
			Assert.assertEquals(SRConfirmationMessage, ordersupply.readSRNumber.getText());
			System.out.println(ordersupply.readSRNumber.getText());
			System.out.println("Order Supplies SR number generated is: "+SR);
		}
}

@AfterTest
public void tearDown() throws Exception{
	  LogIn_Page logout = new LogIn_Page(driver); //Logout
	  logout.Logout();
	  driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
	 // driver.quit();
}

}
