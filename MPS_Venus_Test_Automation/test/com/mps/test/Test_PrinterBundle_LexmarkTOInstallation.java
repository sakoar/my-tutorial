package com.mps.test;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.lexmark.automation.test.PageObject.helper.LogIn_Page;
import com.lexmark.automation.test.PageObject.helper.PageObject_PrinterBundle_LexmarkTOInstallation;
import com.lexmark.automation.test.PageObject.helper.PageObject_PortalAdmin_HomePageNotification;

public class Test_PrinterBundle_LexmarkTOInstallation {
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
signin.Login("perftest_amica11@customer.com", "Lexmark01");
Thread.sleep(8000);
	 }	

@Test
public void homePageNotification()throws Exception{
PageObject_PrinterBundle_LexmarkTOInstallation printer_installation= new PageObject_PrinterBundle_LexmarkTOInstallation(driver);
driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
driver.manage().deleteAllCookies();
printer_installation.order_tab.click();
printer_installation.order_device_button.click();
Thread.sleep(2000);
printer_installation.selectContract();
WebDriverWait wait1 =new WebDriverWait(driver,30);
WebElement e1= wait1.until(ExpectedConditions.elementToBeClickable(By.id("pay-later")));
e1.click();
logger.info("Pay Later Option Selected & Navigating to the next page");
printer_installation.add_to_order.click();
printer_installation.review_button.click();
logger.info("Added to Order");
driver.findElement(By.id("lexmark-install-question-yes")).click();
logger.info("Installation by Lexmark Selected");
driver.findElement(By.linkText("Please select installation address >")).click();
printer_installation.install_address_search_field.sendKeys("PHARMACY: 1866");
printer_installation.search_icon2.click();
//printer_installation.search_key1.click();
driver.findElement(By.xpath("//button[text()='CHANGE DEVICE INSTALL ADDRESS']")).click();
Thread.sleep(5000);
printer_installation.shipping_select.click();
Thread.sleep(5000);
printer_installation.shipping_select.click();
Thread.sleep(5000);
printer_installation.shippingAddress();
Thread.sleep(5000);
driver.manage().deleteAllCookies();
driver.findElement(By.name("purchaseOrderNumber")).sendKeys("1234567");
//printer_installation.pu_order1.sendKeys("1234567");
String order_createdby1=printer_installation.order_createdby_block1.getAttribute("value");
String contact1=printer_installation.contact_block1.getAttribute("value");
driver.findElement(By.name("internalReferenceId")).sendKeys("987654321");
//printer_installation.refId.sendKeys("987654321");
printer_installation.cost_centre.sendKeys("Lexmark Lexington");
printer_installation.user_comments.sendKeys("This is for Testing");
//Thread.sleep(5000);
//driver.findElement(By.xpath("//button[@type='submit']")).click();
//driver.findElement(By.xpath("//*[text()='SUBMIT HARDWARE ORDER']")).click();

/**********************************************************************
logger.info("Clicking on Final Submit button");
System.out.println("going to click on the button");
System.out.println("clicked on the button");
//printer_installation.submit_hardware_order.click(); 
/*
driver.findElement(By.xpath("//button[@type='submit']")).click();
driver.findElement(By.xpath("//*[text()='SUBMIT HARDWARE ORDER']")).click();
Thread.sleep(10000);
*/
/*
WebElement e3=driver.findElement(By.xpath("//*[text()='SUBMIT HARDWARE ORDER']"));
JavascriptExecutor js3 = (JavascriptExecutor) driver;
js3.executeScript("document.getElementById('Email').style.border='2px groove green';");
*/

Actions a =new Actions(driver);
/*a.sendKeys(Keys.TAB).build().perform();
Thread.sleep(2000);
a.sendKeys(Keys.TAB).build().perform();
Thread.sleep(2000);
a.sendKeys(Keys.TAB).build().perform();
Thread.sleep(5000);
//a.sendKeys(Keys.ENTER).build().perform();*/
a.moveToElement(driver.findElement(By.xpath("//button[@type='submit']"))).click().build().perform();
Thread.sleep(2000);


//driver.navigate().to(arg0);
/*
WebElement element = driver.findElement(By.xpath("//button[@type='submit']"));
JavascriptExecutor executor = (JavascriptExecutor)driver;
executor.executeScript("arguments[0].click();", element);
*/
logger.info("Details filled & Navigating to Final Submission Page");

//String strAct=driver.findElement(By.cssSelector("div.col-lg-2-3.col-md-1-1 > h1.ng-scope")).getText();

//Assert.assertEquals(strAct, "Submitted | Device Order request");



/*
String order_createdby2=printer_installation.order_createdby_block2.getAttribute("value");
String contact2=printer_installation.contact_block2.getAttribute("value");
String part2=printer_installation.part_no2.getAttribute("value");
String shipping_address2=printer_installation.shipping_address_block2.getAttribute("value");
String bill_address2=printer_installation.billing_address_block2.getAttribute("value");
*/

//driver.close();

//#######performing Validation############################
/*
Assert.assertEquals(order_createdby1, order_createdby2);
System.out.println("Order_createdby Address are same");
Assert.assertEquals(contact1, contact2);
System.out.println("Contact Address are same");
//Assert.assertEquals(part1, part2);
/*System.out.println("Part numbers are same");
Assert.assertEquals(shipping_address1, shipping_address2);
System.out.println("Shipping Address Details are same");
Assert.assertEquals(bill_address1, bill_address2);
System.out.println("Billing Address Details are same");
System.out.println("Order Device Validated Completely");
*/
}
}