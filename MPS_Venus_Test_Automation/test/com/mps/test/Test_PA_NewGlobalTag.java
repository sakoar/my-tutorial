package com.mps.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.lexmark.automation.test.PageObject.helper.LogIn_Page;
import com.lexmark.automation.test.PageObject.helper.Users_PageObject;

public class Test_PA_NewGlobalTag {
	
	private static final String String = null;
	WebDriver driver;
	String baseUrl = "https://managedservices.qa.lexmark.com";//"Launching url 
	String createTagName = "123TestAuto";
	
  @BeforeClass
	public void setUp() throws InterruptedException{
	
	  //System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
	
/*	ChromeOptions chromeOptions = new ChromeOptions();
	chromeOptions.addArguments("--start-maximized");
	driver = new ChromeDriver(chromeOptions); */
	//driver=new ChromeDriver();
	  System.setProperty("webdriver.firefox.bin", "C:\\Users\\sanoaoa\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
	    driver = new FirefoxDriver();
   driver.manage().window().maximize();
	driver.get(baseUrl);
	Thread.sleep(10000);
	LogIn_Page signin = new LogIn_Page(driver);
	signin.Login("sumand", "Welcome!123"); //Login Test
	Thread.sleep(8000);
	
	}
 
 @Test
  public void createTag() throws InterruptedException {
	 System.out.println("Test Hello");
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//html/body/div[1]/div/aside/nav/ul/li[3]/a")).click();
	 Thread.sleep(2000);
	 driver.findElement(By.linkText("Document Management")).click();
	 Thread.sleep(4000);
	 
//Create TAG	 
	 driver.findElement(By.xpath("//button[text()='MANAGE TAGS']")).click();
	 Thread.sleep(6000);
	 driver.findElement(By.xpath("//button[text()='CREATE NEW TAG']")).click();
	 Thread.sleep(2000);
	driver.findElement(By.name("name")).sendKeys(createTagName);
	driver.findElement(By.name("submit")).click();
	 Thread.sleep(8000);
	 String actualMesage = driver.findElement(By.cssSelector("div.well.ng-scope > p.ng-scope")).getText();
	 String expectedAdd = "Tag Added | "+createTagName;
	 String expectedDeleted = "Tag Deleted | "+createTagName;
	 System.out.println("String actual: "+actualMesage);
	 System.out.println("String expected: "+expectedAdd);
	 Assert.assertEquals(actualMesage, expectedAdd);
	 System.out.println("Tag Created");
//Search for the TAG Crteated
	 driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(createTagName);
	 driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(Keys.ENTER);
	 Thread.sleep(6000);
	// System.out.println(driver.findElement(By.cssSelector("div.ng-binding.ng-scope")).getText());
	 System.out.println("Searched the TAG");
//Delete the TAG created
	 driver.findElement(By.xpath("//div/i[2]")).click();
	 System.out.println("clicked on the delete button");
	 Thread.sleep(4000);
	
	 driver.findElement(By.cssSelector("form[name=\"deleteTag\"] > div.row > div.col-1 > button[name=\"submit\"]")).click();
	 System.out.println("clicked on the another delete button");
	 Thread.sleep(6000);
	 System.out.println("going to read the text");
	 String deleteMesage= driver.findElement(By.xpath("//div[2]/p")).getText();
	 Assert.assertEquals(deleteMesage, expectedDeleted);
	 System.out.println("assert passed");
	 System.out.println("delete tag passed");
	 
	 //Search for the TAG again	 
	 System.out.println("search for the tag again");
driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(createTagName);
driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(Keys.ENTER);
Thread.sleep(4000);
Assert.assertEquals(driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/div[1]/div/div[2]")).getText(), "No records found");

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






//System.setProperty("webdriver.gecko.driver", "C:\\Users\\sanoaoa\\workspace\\MPS_Venus_Test_Automation\\drivers\\geckodriver.exe");
//driver = new FirefoxDriver();
