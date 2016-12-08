package com.my.basic.test;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.lexmark.automation.test.PageObject.helper.LogIn_Page;
import com.lexmark.automation.test.PageObject.helper.PageObject_Devicelist;

public class Test_DeviceList {
WebDriver driver;
String baseUrl = "https://managedservices.qa.lexmark.com";//"Launching url 
String contactFirstName="TEST13";


String siebel_date="04/01/2015";
String pages_siebel="629607 Pages";
String cust_device_tag_siebel="ma620w840-1";
String ip_siebel="10.12.4.19";
String chl_siebel="620";
String name_siebel="Norsek, Heather";
String install_address_siebel="Amica Mutual Insurance Company\n596 Paramount Dr\nRaynham, MA 02767-1085\nUSA";
String host_siebel="Hostess";


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
PageObject_Devicelist device= new PageObject_Devicelist(driver);
device.devices_tab.click();
driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
device.search_field.sendKeys("4021013000787");
device.search_icon.click();
device.selected_item.click();
//#######Performing Operation on Managing Device######
device.product_model.getText().trim();
device.serial_no.getText().trim();
device.device_cust_tag.getText().trim();

//######Page count summary##########
String pages_appln=device.total_pages.getText();
//String mono1=device.mono.getText().trim();

//########Device information#############
String appln_date=device.install_date.getAttribute("value");
String install_address_appln=device.address_detail.getAttribute("value");


//#############Network configuration#########
String ip_appln=device.ip_address.getText();
String host_appln=device.hostname.getText().trim();


//#############Contact  Details#########
String name_appln=device.name.getText();
String address1=device.address_block1.getText();
String email1=device.email.getText();
String phone1=device.phone.getText();


//#####################Device billing and tracking####################
String cc1=device.cost_centre.getText();
String chl_appln=device.chl_detail.getText();
String cust_device_tag_appln=device.cust_device_tag.getText();


//##################Validation################################

Assert.assertEquals(pages_siebel,pages_appln);
Assert.assertEquals(name_siebel,name_appln);
Assert.assertEquals(host_siebel,host_appln);
Assert.assertEquals(cust_device_tag_siebel,cust_device_tag_appln);
Assert.assertEquals(ip_siebel,ip_appln);
//Assert.assertEquals(chl_siebel,chl_appln);
//Assert.assertEquals(install_address_siebel,install_address_appln);
System.out.println(" Siebel data & Application data are same");
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

/*
Amica Mutual Insurance Company\n596 Paramount Dr\nRaynham, MA 02767-1085\nUSA
*/