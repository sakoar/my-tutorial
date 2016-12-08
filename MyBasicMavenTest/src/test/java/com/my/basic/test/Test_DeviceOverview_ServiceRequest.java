package com.my.basic.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
import com.lexmark.automation.test.PageObject.helper.PageObjectDeviceServiceRequest;
import com.lexmark.automation.test.PageObject.helper.dateCalculations;


public class Test_DeviceOverview_ServiceRequest {
	
WebDriver driver;
String baseUrl = "https://managedservices.qa.lexmark.com";//"Launching url 
String contactFirstName="TEST13";
String DeviceNo="3505MV0";
dateCalculations date = new dateCalculations();
SoftAssert s_assert = new SoftAssert();

@BeforeClass
public void setUp() throws InterruptedException{
System.setProperty("webdriver.firefox.bin", "C:\\Users\\sanoaoa\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
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
dev_req.searchDevice(DeviceNo);
Thread.sleep(3000);
driver.findElement(By.linkText(DeviceNo)).click();
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
dev_req.searchDevice(DeviceNo);
driver.findElement(By.linkText(DeviceNo)).click();

Thread.sleep(5000);
dev_req.service_req_tab.click();
Thread.sleep(8000);
WebDriverWait wait = new WebDriverWait(driver,30);
wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id='requestTab']/div/div[1]/div/div[1]/div[1]/a"))));

s_assert.assertEquals(driver.findElement(By.xpath("//*[@id='requestTab']/div/div[1]/div/div[1]/div[1]/a")).getText(), sr_no1);
Assert.assertEquals(driver.findElement(By.xpath("//*[@id='requestTab']/div/div[1]/div/div[1]/div[2]/div/div[1]/div[2]/div[1]")).getText(), "Submitted");
Assert.assertEquals(driver.findElement(By.cssSelector("div.status-state-date.ng-binding")).getText(), date.dateCalculate());

}

@AfterTest
public void Logout() throws Exception{
	Thread.sleep(3000);
	  LogIn_Page logout = new LogIn_Page(driver); //Logout
	  logout.Logout();
	  driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
	  driver.close();
}
/*
@AfterClass
public void quitBrowser(){
	  driver.quit();
}*/
}



