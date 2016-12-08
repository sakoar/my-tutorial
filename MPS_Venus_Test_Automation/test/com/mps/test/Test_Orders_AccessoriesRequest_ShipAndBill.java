package com.mps.test;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lexmark.automation.test.PageObject.helper.LogIn_Page;
import com.lexmark.automation.test.PageObject.helper.PageObject_OrderDevice_Accessiories;

public class Test_Orders_AccessoriesRequest_ShipAndBill {
	WebDriver driver;
	String baseUrl = "https://managedservices.qa.lexmark.com";  //URL
	Logger logger = Logger.getLogger(Test_UpdateUser.class);
	SoftAssert s_assert = new SoftAssert();
	
@BeforeClass
public void setUp() throws InterruptedException{
	System.out.println("################# THis is Order Device Test ####################");
PropertyConfigurator.configure("log4j.properties");
System.setProperty("webdriver.firefox.bin", "C:\\Users\\sanoaoa\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
driver = new FirefoxDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
logger.info("Launching URL");
driver.get(baseUrl);//Launching URL
logger.info("Home Page Launced");
LogIn_Page signin = new LogIn_Page(driver);
//signin.Login("perftest_bestbuy11@customer.com ", "Lexmark01");
signin.Login("perftest_amica11@customer.com  ", "Lexmark01");
Thread.sleep(10000);
	 }	


@Test
public void accessoriesRequest()throws Exception{
	
PageObject_OrderDevice_Accessiories acc_ship_and_bill= new PageObject_OrderDevice_Accessiories(driver);
logger.info("*******************Navigating to Home Page********************");

acc_ship_and_bill.order_tab.click();
Thread.sleep(2000);
acc_ship_and_bill.order_device_button.click();
Thread.sleep(10000);
acc_ship_and_bill.selectContract();
logger.info("*******************label=Amica_US_DP/Exist_RC UC_36 Non Co Selected*******************");
WebDriverWait wait1 =new WebDriverWait(driver,60);
WebElement e1= wait1.until(ExpectedConditions.elementToBeClickable(By.id("pay-now")));
e1.click();
WebDriverWait wait2 =new WebDriverWait(driver,60);
WebElement e2= wait2.until(ExpectedConditions.elementToBeClickable(By.id("accessorie-catalog")));
e2.click();
acc_ship_and_bill.continue_button.click();
Thread.sleep(2000);
logger.info("*******************Navigating to Next Page*******");
acc_ship_and_bill.add_to_order.click();
logger.info("*******************Accessories added to Cart*******");
Thread.sleep(2000);
acc_ship_and_bill.review_button.click();
Thread.sleep(3000);
logger.info("*******************Selecting Shipping Address*******");
acc_ship_and_bill.shippingAddress();
Thread.sleep(2000);
String shipping_address1=acc_ship_and_bill.shipping_address_block1.getAttribute("value");
logger.info("Shipping Address Details Captured");
logger.info("*******************Selecting Billing Address*******");
acc_ship_and_bill.billingAddress();
Thread.sleep(8000);

String bill_address1=acc_ship_and_bill.billing_address_block1.getAttribute("value");
Thread.sleep(2000);
logger.info("Billing Address Details Captured");
Thread.sleep(5000);
//acc_ship_and_bill.building.sendKeys("Tower V");
//acc_ship_and_bill.floor.sendKeys("10th");
//acc_ship_and_bill.office.sendKeys("Lexmark Inc.");
//acc_ship_and_bill.delivery_instruction1.sendKeys("Before 7 pm");
Thread.sleep(2000);
acc_ship_and_bill.pu_order1.sendKeys("1234567");
String order_createdby1=acc_ship_and_bill.order_createdby_block1.getAttribute("value");
String contact1=acc_ship_and_bill.contact_block1.getAttribute("value");
acc_ship_and_bill.refId.sendKeys("987654321");
acc_ship_and_bill.cost_centre.sendKeys("Lexmark Lexington");
acc_ship_and_bill.user_comments.sendKeys("This is for Testing");
acc_ship_and_bill.submit_hardware_order.click();
logger.info("Details filled & Navigating to Final Submission Page");
Thread.sleep(8000);
/*************Confirmaton on SR on Submission Page*************************/
//Submit Page Confirmation message
String message1 = "Your Data Asset Deregister request is being submitted";
String message2= "Your request ( generating request number... ) is being submitted.";
logger.info("message 2 is set as: "+message2);
	if(message1.equalsIgnoreCase(acc_ship_and_bill.submitPageMessage.getText())){
		System.out.println("in Queue/IF block");
		logger.info("in Queue/IF block");
		Assert.assertEquals(message2, acc_ship_and_bill.submitPageMessage2.getText());
		} else {
			System.out.println("in else block/SR generation block");
			logger.info("in else block/SR generation block");
			String successSR_message="Submitted | Device Order request";
			
			s_assert.assertEquals(acc_ship_and_bill.submitPageMessage.getText(),successSR_message);
		
			String str = acc_ship_and_bill.readSRNumber.getText();
			//String SR = str.split("\\:")[1];
			
			//Assert.assertEquals(SRConfirmationMessage,str);
			System.out.println("SR number generated is: "+str);
			logger.info("SR number generated is: "+str);
		}

/*************Performing Operations on Submission Page*************************/
String order_createdby2=acc_ship_and_bill.order_createdby_block2.getAttribute("value");
String contact2=acc_ship_and_bill.contact_block2.getAttribute("value");
String shipping_address2=acc_ship_and_bill.shipping_address_block2.getAttribute("value");
String bill_address2=acc_ship_and_bill.billing_address_block2.getAttribute("value");

/******************Performing Validations*********************************/
Assert.assertEquals(order_createdby1, order_createdby2);
logger.info("Order_createdby Address are same");
Assert.assertEquals(contact1, contact2);
logger.info("Contact Address are same");
Assert.assertEquals(shipping_address1, shipping_address2);
logger.info("Shipping Address Details are same");
Assert.assertEquals(bill_address1, bill_address2);
logger.info("Billing Address Details are same");
logger.info("Order Device Accessories Ship & Bill Requests Validated");
}

@AfterTest
public void tearDown() throws Exception{
	Thread.sleep(4000);
	  LogIn_Page logout = new LogIn_Page(driver); //Logout
	  logout.Logout();
	  driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
	  driver.close();

}

}
