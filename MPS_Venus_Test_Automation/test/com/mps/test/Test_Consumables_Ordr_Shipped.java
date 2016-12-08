package com.mps.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lexmark.automation.test.PageObject.helper.LogIn_Page;

public class Test_Consumables_Ordr_Shipped {
	WebDriver driver;
	String baseUrl = "https://managedservices.qa.lexmark.com";//"Launching url 
	SoftAssert s_assert;
	

	@BeforeClass
	public void setUp() throws InterruptedException{
	
		//driver=new ChromeDriver();
		System.setProperty("webdriver.firefox.bin", "C:\\Users\\sanoaoa\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
	    driver = new FirefoxDriver();
		driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get(baseUrl);
	//Thread.sleep(5000);
	LogIn_Page signin = new LogIn_Page(driver);
	signin.Login("perftest_amica11@customer.com", "Lexmark01");
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	//Thread.sleep(12000);
	 }	

  @Test
  public void OrderShippedStatus() throws InterruptedException {
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.findElement(By.linkText("Orders")).click(); //click on Orders tab
	  driver.findElement(By.linkText("Supplies orders")).click(); //click on supplies order tab
	  
	  driver.findElement(By.linkText("Supplies orders")).click();
	    driver.findElement(By.cssSelector("div.selectricButton")).click();
	    driver.findElement(By.xpath("//div[@id='supplyOrderTab']/span/div[2]/div/div/div/div/div[3]/ul/li[2]")).click();
	    driver.findElement(By.xpath("(//input[@type='text'])[2]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("12/01/2015");
	    driver.findElement(By.xpath("(//input[@type='text'])[3]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("01/31/2016");
	    driver.findElement(By.xpath("(//input[@type='text'])[5]")).clear();
	    Thread.sleep(6000);
	    driver.findElement(By.xpath("(//input[@type='text'])[5]")).sendKeys("1-112040209466");
	    Thread.sleep(4000);
	    driver.findElement(By.xpath("(//input[@type='text'])[5]")).sendKeys(Keys.ENTER);
	    driver.findElement(By.linkText("1-112040209466")).click();
	    driver.findElement(By.linkText("SHIPMENTS")).click();
	    Assert.assertEquals(driver.findElement(By.xpath("//div[@id='srDetailAssociateRequestsTab']/span/div/div/div/span[3]")).getText(), "DELIVERED");
	    driver.findElement(By.linkText("Show Shipment Details")).click();
	    
	    	Assert.assertEquals(driver.findElement(By.cssSelector("div.info-list__item-value.ng-binding")).getText(), "12/16/2015");
	    	Assert.assertEquals(driver.findElement(By.xpath("//div[@id='srDetailAssociateRequestsTab']/span/div/div/div[2]/div/div/ul/li[2]/div[2]")).getText(), "12/18/2015");
	    	Assert.assertEquals(driver.findElement(By.xpath("//div[@id='srDetailAssociateRequestsTab']/span/div/div/div[2]/div/div/ul/li[3]/div[2]")).getText(), "UPS");
	    	Assert.assertEquals(driver.findElement(By.xpath("//div[@id='srDetailAssociateRequestsTab']/span/div/div/div[2]/div/div/ul/li[4]/div[2]")).getText(), "1Z78E26E0325614894");
	    	Assert.assertEquals(driver.findElement(By.xpath("//div[@id='srDetailAssociateRequestsTab']/span/div/div/div[2]/div/div/ul/li[5]/div[2]")).getText(), "330 Whitney Ave\n01040-2751\nUSA");
	  
  }
  

@AfterTest
public void tearDown() throws Exception{
	  LogIn_Page logout = new LogIn_Page(driver); //Logout
	  logout.Logout();
	  driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
	  driver.quit();
}
}
