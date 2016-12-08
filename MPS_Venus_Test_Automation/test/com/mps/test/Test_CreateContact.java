package com.mps.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.lexmark.automation.test.PageObject.helper.LogIn_Page;
import com.lexmark.automation.test.PageObject.helper.PageObject_CreateAddress;
import com.lexmark.automation.test.PageObject.helper.PageObject_CreateContact;

public class Test_CreateContact {
		WebDriver driver;
		String baseUrl = "https://managedservices.qa.lexmark.com";//"Launching url 
			
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
public void contactCreation()throws Exception{
PageObject_CreateContact addcontact = new PageObject_CreateContact(driver);
addcontact.createNewContact();
//addcontact.add_new_contact_button.click();//To open Create New CONTACT FORM
	}
/*
@Test(priority=2)
public void captureDetails()throws Exception{
PageObject_CreateContact addcontact = new PageObject_CreateContact(driver);
addcontact.captureContactDetails();
}

/*
@Test(priority=2)
public void createNewContact()throws Exception{
PageObject_CreateContact addcontact = new PageObject_CreateContact(driver);
addcontact.create_contact.click();//To open Create New CONTACT FORM
	}
	*/

}
