package com.mps.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;

import com.lexmark.automation.test.PageObject.helper.LogIn_Page;
import com.lexmark.automation.test.PageObject.helper.PageObject_BreakFix;
import com.lexmark.automation.test.PageObject.helper.dateCalculations;

public class Test_PageCountUpdate {
	
	
	WebDriver driver;
	String baseUrl= "https://managedservices.qa.lexmark.com";
	String operationKey = "REQUEST SERVICE";
	String deviceNumber = "406347990LZ9N";
	
	PageObject_BreakFix device;
	SoftAssert s_assert =new SoftAssert(); 
	Logger logger = Logger.getLogger(CreateServiceRequestBF.class); 
@BeforeClass
public void SetUP() throws InterruptedException{
	logger.info("################# This is PageCount Update Test ####################");
	System.out.println("################# This is PageCount Update Test ####################");
	System.setProperty("webdriver.firefox.bin", "C:\\Users\\sanoaoa\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
    driver = new FirefoxDriver();
	driver.get(baseUrl);
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	Thread.sleep(5000);
	driver.manage().window().maximize();
	logger.info("Browser Launched & navigated to BaseURL");
	 	LogIn_Page signin = new LogIn_Page(driver);
		signin.Login("perftest_amica11@customer.com", "Lexmark01");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		logger.info("Login successful");
	  }
  @Test
  public void UpdatePageCount() throws InterruptedException {
	  
	  device= new PageObject_BreakFix(driver);
	  device.searchDevice(deviceNumber);
	  Thread.sleep(2000);
	  driver.findElement(By.linkText(deviceNumber)).click();
	  Thread.sleep(3000);
	  
	  driver.findElement(By.linkText("Page Counts")).click();
	  Thread.sleep(6000);
	  
//Get the LTPC Cpunt & Input Claculated value
	  String LTPC_Org = driver.findElement(By.xpath("//div[@id='pageCountTab']/div/form/table/tbody/tr[3]/td[2]/div")).getText();
	  System.out.println("The String is: "+LTPC_Org);

//Convert the String to Integer & back to String	  
	  String TrimValue = LTPC_Org.replaceAll(",", "");
	  System.out.println("Trim Value: "+TrimValue);
	  
	  int LTPC_value = Integer.parseInt(TrimValue)+300;
	  System.out.println("LTPC_value"+LTPC_value);
	  
	  driver.findElement(By.xpath("(//input[@type='number'])[2]")).sendKeys(Integer.toString(LTPC_value));

//Date Calculation & Send Keys	  
	  dateCalculations date = new dateCalculations();
	  driver.findElement(By.xpath("(//input[@id='page-count-date'])[2]")).sendKeys(date.datenTimeCalculate());
//COLOR Page
	  String Color_Orgi = driver.findElement(By.xpath("//div[@id='pageCountTab']/div/form/table/tbody/tr[2]/td[2]/div")).getText();
	  String ColorTrim = Color_Orgi.replaceAll(",", "");
	  
	  int ColorValue = Integer.parseInt(ColorTrim)+100;
	  System.out.println("ColorValue"+ColorValue);
	  driver.findElement(By.xpath("//input[@type='number']")).sendKeys(Integer.toString(ColorValue));
	  Thread.sleep(4000);
//Clcik on SUBMIT PAGE COUNT BUTTON
	  driver.findElement(By.xpath("//div[@id='pageCountTab']/div/form/div/button")).click();
	  Thread.sleep(4000);
	  
//MONO count	
	  String Mono = driver.findElement(By.cssSelector("div.ng-binding")).getText();
	 
	  String MonoTrim = Mono.replace(",", "");
	  int MonoCalculated = Integer.parseInt(MonoTrim);
	  System.out.println("Actual Mono Count: "+MonoCalculated);
	  int MonoExpected = LTPC_value-ColorValue;
	  System.out.println("Mono Count Expected is: "+MonoExpected );
	  
	  Assert.assertEquals(MonoExpected, MonoCalculated);
	  System.out.println("Assertion is right, test passed");
	  
  	}

@AfterTest
public void tearDown() throws Exception{
	  LogIn_Page logout = new LogIn_Page(driver); //Logout
	  logout.Logout();
	  driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
	  driver.quit();
}
}
