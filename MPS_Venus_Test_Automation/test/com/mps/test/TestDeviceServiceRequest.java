package com.mps.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.lexmark.automation.test.PageObject.helper.LogIn_Page;
import com.lexmark.automation.test.PageObject.helper.PageObjectDeviceServiceRequest;


public class TestDeviceServiceRequest {
	
WebDriver driver;
String baseUrl = "https://managedservices.qa.lexmark.com";//"Launching url 
String contactFirstName="TEST13";

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
signin.Login("perftest_amica11@customer.com", "Lexmark01");
driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
Thread.sleep(12000);
 }	
		
@Test
public void deviceOverview()throws Exception{
PageObjectDeviceServiceRequest dev_req= new PageObjectDeviceServiceRequest(driver);
dev_req.devices_tab.click();
driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
dev_req.search_field.sendKeys("4021013000787");
dev_req.search_icon.click();
//dev_req.selected_item.click();
Thread.sleep(2000);
dev_req.request_service_button.click();
Thread.sleep(5000);
dev_req.building.sendKeys("Tower 8");
dev_req.floor.sendKeys("8th");
dev_req.office.sendKeys("Lexmark Inc.");
dev_req.desc.sendKeys("This is for Test");
dev_req.review_button.click();

//###Performing Operation on Additional Detail Page details#####################

dev_req.refId.sendKeys("987654321");
Thread.sleep(3000);
dev_req.submit_request_button.click();
Thread.sleep(8000);

//############Performing Operation on Request No Generation Page########

String sr_no1=dev_req.request_no.getText().trim().substring(13,27);
System.out.println(sr_no1);
String serial1=dev_req.serial_no1.getAttribute("value");

//#####Searching through Service request Tab###########
dev_req.devices_tab.click();
dev_req.search_field.sendKeys("4021013000787");
dev_req.search_icon.click();
//dev_req.selected_item.click();
Thread.sleep(5000);
dev_req.service_req_tab.click();
dev_req.req_no_search_field.sendKeys(sr_no1);
Thread.sleep(5000);
String date_field1=dev_req.date1.getText().trim();
//String date_field2=dev_req.date2.getText().trim();
Thread.sleep(2000);
String serial2=dev_req.serial_no2.getText().trim();


/*
String req_crby1=dev_req.req_createdby1.getAttribute("value");
String contdetail1=dev_req.contact1.getAttribute("value");
String ref1=dev_req.reqfno1.getAttribute("value");
String serial1=dev_req.serial_no1.getAttribute("value");
String ip1=dev_req.ip_address1.getAttribute("value");
//String saddress1=dev_req.service_address1.getAttribute("value");
String probdesc1=dev_req.desc_msg1.getAttribute("value");
Thread.sleep(10000);


//Searching Operation through Request  Tab
dev_req.request_tab.click();
Thread.sleep(3000);
dev_req.reqno_search_field.sendKeys(message1);
dev_req.req_search_icon2.click();
dev_req.selected_item2.click();


//###########Validation#####################
String req_crby2=dev_req.req_createdby2.getAttribute("value");
String contdetail2=dev_req.contact2.getAttribute("value");
String ref2=dev_req.reqfno2.getAttribute("value");
String serial2=dev_req.serial_no2.getAttribute("value");
String ip2=dev_req.ip_address2.getAttribute("value");
String saddress2=dev_req.service_address2.getAttribute("value");
String probdesc2=dev_req.desc_msg2.getAttribute("value");


Assert.assertEquals(req_crby1,req_crby2);
Assert.assertEquals(contdetail1,contdetail2);
Assert.assertEquals(ref1,ref2);
Assert.assertEquals(ip1,ip2);
Assert.assertEquals(serial1,serial2);
//Assert.assertEquals(saddress1,saddress2);
Assert.assertEquals(probdesc1,probdesc2);
*/


//Assert.assertEquals(date_field1,date_field2);
Assert.assertEquals(serial1,serial2);
System.out.println("All Details Verified");


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
