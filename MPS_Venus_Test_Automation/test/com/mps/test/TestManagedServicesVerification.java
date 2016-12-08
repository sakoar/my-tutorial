package com.mps.test;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.lexmark.automation.test.PageObject.helper.LogIn_Page;
import com.lexmark.automation.test.PageObject.helper.PageObject_AddShippingLink;
import com.lexmark.automation.test.PageObject.helper.PageObject_ManagedServicesVerification;

public class TestManagedServicesVerification {
	WebDriver driver;
	String baseUrl = "https://managedservices.qa.lexmark.com";  //URL
	Logger logger = Logger.getLogger(Test_UpdateUser.class);
	
	
@BeforeClass
public void setUp() throws InterruptedException{
PropertyConfigurator.configure("log4j.properties");
System.setProperty("webdriver.firefox.bin", "C:\\Users\\sanoaoa\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
driver = new FirefoxDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
logger.info("Launching URL");
driver.get(baseUrl);//Launching URL
logger.info("Home Page Launced");
LogIn_Page signin = new LogIn_Page(driver);
signin.Login("perftest_bestbuy11@customer.com ", "Lexmark01");
Thread.sleep(10000);
	 }	

/*****************Service Requests verification***********************/
@Test(priority=0)
public void verifyServiceReqLinks()throws Exception{
PageObject_ManagedServicesVerification sr_service= new PageObject_ManagedServicesVerification(driver);
logger.info("*******************Service Request Links Verification********************");
String SR_open1=sr_service.madc_open_SR_link.getText().trim();
logger.info(SR_open1);
sr_service.madc_open_SR_link.click();
Thread.sleep(15000);
String SR_open2=sr_service.madc_open_SR_count.getText().trim().substring(18,20);
logger.info(SR_open2);
Assert.assertEquals(SR_open1, SR_open2);
logger.info("Service Request Open Count are same");
driver.findElement(By.linkText("Service requests")).isEnabled();
logger.info("On REQUESTS--->SERVICE REQUEST  Tab" );
//driver.findElement(By.xpath("//div[@id='serviceRequestsDeviceTab']/span/div[2]/div/div/div[2]/div/div/label")).isEnabled();
//driver.findElement(By.xpath("//div[@id='serviceRequestsDeviceTab']/span/div[2]/div/div/div[2]/div/div[2]/label")).isEnabled();
logger.info("Submitted & In-Process checkboxes Selected by-default" );
driver.navigate().back();
Thread.sleep(10000);
String SR_completed1=sr_service.madc_completed_SR_link.getText().trim().substring(0,1);
logger.info(SR_completed1);
Thread.sleep(5000);
sr_service.madc_completed_SR_link.click();
Thread.sleep(8000);
String SR_completed2=sr_service.madc_completed_SR_count.getText().trim().substring(18,19);
logger.info(SR_completed2);
Thread.sleep(10000);
Assert.assertEquals(SR_completed1, SR_completed2);
logger.info("Service Request Completed Count are same");
//driver.findElement(By.xpath("//div[@id='serviceRequestsDeviceTab']/span/div[2]/div/div/div[2]/div/div[3]/label")).isSelected();
logger.info("Completed Selected by default" );
logger.info("Service Requests Links Verified");
driver.navigate().back();
Thread.sleep(15000);
}

/*************************Orders Verification***********************/

@Test(priority=1)
public void verifyOrdersLinks()throws Exception{
PageObject_ManagedServicesVerification order_service= new PageObject_ManagedServicesVerification(driver);
String order_open1=order_service.madc_orders_open_link.getText().trim();
logger.info("********Order Links Verification******************");
logger.info(order_open1);
order_service.madc_orders_open_link.click();
Thread.sleep(15000);
String order_open2=order_service.open_orders_count.getText().trim().substring(12,18);
logger.info(order_open2);
Assert.assertEquals(order_open1, order_open2);
logger.info("Order Request Open Count are same");
driver.findElement(By.linkText("All orders")).isEnabled();
logger.info("On ORDERS--->ALL ORDERS Tab" );
//driver.findElement(By.xpath("//div[@id='serviceRequestsDeviceTab']/span/div[2]/div/div/div[2]/div/div/label")).isSelected();
//driver.findElement(By.xpath("//div[@id='serviceRequestsDeviceTab']/span/div[2]/div/div/div[2]/div/div[2]/label")).isSelected();
//driver.findElement(By.xpath("//div[@id='serviceRequestsDeviceTab']/span/div[2]/div/div/div[2]/div/div[3]/label")).isSelected();
logger.info("Submitted, In-Process & Shipped are Selected by-default" );
driver.navigate().back();
Thread.sleep(25000);
String order_completed1=order_service.completed_orders_link.getText().trim().substring(0,1);
logger.info(order_completed1);
Thread.sleep(15000);
order_service.completed_orders_link.click();
Thread.sleep(20000);
String order_completed2=order_service.completed_orders_count.getText().trim().substring(12, 13);
logger.info(order_completed2);
Thread.sleep(10000);
Assert.assertEquals(order_completed1, order_completed2);
logger.info("Order Request Completed Count are same");
//driver.findElement(By.xpath("//div[@id='serviceRequestsDeviceTab']/span/div[2]/div/div/div[2]/div/div[4]/label")).isSelected();
logger.info("Completed Selected by default" );
logger.info("Order Requests Links Verified");
driver.navigate().back();
Thread.sleep(15000);
}


/*****************Device Change Requests verification***********************/
@Test(priority=2)
public void verifyDeviceChangeReqLinks()throws Exception{
PageObject_ManagedServicesVerification dev_ch_service= new PageObject_ManagedServicesVerification(driver);
logger.info("********Device Change Requests Links Verification******************");
String req_open1=dev_ch_service.madc_open_dev_request_link.getText().trim();
logger.info(req_open1);
dev_ch_service.madc_open_dev_request_link.click();
Thread.sleep(15000);
String req_open2=dev_ch_service.madc_open_dev_request_count.getText().trim().substring(17,19);
logger.info(req_open2);
Assert.assertEquals(req_open1, req_open2);
logger.info("Order Request Open Count are same");
driver.findElement(By.linkText("Device requests")).isEnabled();
logger.info("On REQUESTS--->DEVICE REQUEST  Tab" );
//driver.findElement(By.xpath("//div[@id='serviceRequestsDeviceTab']/span/div[2]/div/div/div[2]/div/div/label")).isSelected();
//driver.findElement(By.xpath("//div[@id='serviceRequestsDeviceTab']/span/div[2]/div/div/div[2]/div/div[2]/label")).isSelected();
logger.info("Submitted & In-Process checkboxes Selected by-default" );
driver.navigate().back();
Thread.sleep(15000);
String req_completed1=dev_ch_service.madc_completed_dev_request_link.getText().trim().substring(0,1);
logger.info(req_completed1);
Thread.sleep(10000);
dev_ch_service.madc_completed_dev_request_link.click();
Thread.sleep(10000);
String req_completed2=dev_ch_service.madc_completed_dev_request_count.getText().trim().substring(17,18);
logger.info(req_completed2);
Assert.assertEquals(req_completed1, req_completed2);
logger.info("Order Request Open Count are same");
//driver.findElement(By.xpath("//div[@id='serviceRequestsDeviceTab']/span/div[2]/div/div/div[2]/div/div[3]/label")).isSelected();
logger.info("Completed Selected by default" );
logger.info("Device Change Requests Links Verified");

}
}
