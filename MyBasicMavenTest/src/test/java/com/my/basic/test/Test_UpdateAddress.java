package com.my.basic.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.lexmark.automation.test.PageObject.helper.LogIn_Page;
import com.lexmark.automation.test.PageObject.helper.PageObject_RemoveAddress;
import com.lexmark.automation.test.PageObject.helper.PageObject_UpdateAddress;

	public class Test_UpdateAddress {
		WebDriver driver;
		String baseUrl = "https://managedservices.qa.lexmark.com";//"Launching url 
			String addressName = "Dallas Regional Office";

@BeforeTest
public void setUp() throws InterruptedException{
System.setProperty("webdriver.firefox.bin", "C:\\Users\\sanoaoa\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
//System.setProperty("webdriver.gecko.driver", "C:\\Users\\sanoaoa\\workspace\\MPS_Venus_Test_Automation\\drivers\\geckodriver.exe");
//driver=new ChromeDriver();*/
driver = new FirefoxDriver();
driver.manage().window().maximize();
driver.get(baseUrl);
Thread.sleep(3000);
	LogIn_Page signin = new LogIn_Page(driver);
	signin.Login("perftest_amica11@customer.com", "Lexmark01");
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	Thread.sleep(4000);
			}

@Test(priority=1)
public void addressClick() throws Exception {
PageObject_UpdateAddress update_addrs = new PageObject_UpdateAddress(driver);
update_addrs.addressSearchAndClickUpdate(addressName);
Thread.sleep(3000);
update_addrs.captureAddressLocation();
update_addrs.reviewReviewBtn.click(); //is on recommended address page
//######################   Review Page
String rpAddressBlock = update_addrs.rpAddressBlock.getText();
String rpRqstCreatedBy = update_addrs.rpReqstCreatedBy.getText();
String rpPramContact = update_addrs.rpPramContact.getText();

update_addrs.reviewReviewBtn.click(); 
//######################   Final Page
Assert.assertEquals(update_addrs.spAddressBlock.getText(), rpAddressBlock);
Assert.assertEquals(update_addrs.spReqstCreatedBy.getText(), rpRqstCreatedBy);
Assert.assertEquals(update_addrs.spPramContact.getText(), rpPramContact);

}
	}
