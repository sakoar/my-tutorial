package com.mps.test;

import java.util.concurrent.TimeUnit;

import org.jboss.netty.handler.codec.spdy.SpdyProtocolException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.lexmark.automation.test.PageObject.helper.LogIn_Page;
import com.lexmark.automation.test.PageObject.helper.Users_PageObject;

public class Test_PA_UpdateOthersDoc {
	
	private static final String String = null;
	WebDriver driver;
	String baseUrl = "https://managedservices.qa.lexmark.com";//"Launching url 
	String fileName = "amicas_doc.xlsx";
	
  @BeforeClass
	public void setUp() throws InterruptedException{
	
	/*  System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
	  ChromeOptions chromeOptions = new ChromeOptions();
	chromeOptions.addArguments("--start-maximized");
	driver = new ChromeDriver(chromeOptions); */
	//driver=new ChromeDriver();
	  System.setProperty("webdriver.firefox.bin", "C:\\Users\\sanoaoa\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
	    driver = new FirefoxDriver();
    driver.manage().window().maximize();
	driver.get(baseUrl);
	Thread.sleep(8000);
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
	 Thread.sleep(6000);
	 
//Create Search for a Doc
	 driver.findElement(By.xpath("//div[2]/div/div/div/div/div/div/div/div[2]/div/i")).click();
	 System.out.println("clickon on the drop down, now selecting the value File");
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/div[2]/div[1]/div/div/div[1]/div[1]/div/div/div[3]/ul/li[2]")).click();
	 Thread.sleep(4000);
	 System.out.println("Now enter the search input for the file");
	 driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys(fileName);
	 System.out.println("search inout entered now going to click on search icon");
	 driver.findElement(By.cssSelector("button.search")).click();
	 Thread.sleep(3000);
	 System.out.println("searched completed");
	 Thread.sleep(3000);
	 driver.findElement(By.linkText(fileName)).click();
	 Thread.sleep(6000);
	 Assert.assertEquals(driver.findElement(By.xpath("//h2[2]")).getText(), "Viewing Document | amicas_doc");
	 Assert.assertEquals(driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div/div[4]/div[1]/div/ul/li[8]/div[2]")).getText(), "perftest_amica11@customer.com");
	 System.out.println("The doc is uploaded by other user");
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//button[@type='button']")).click();
	 Thread.sleep(4000);
	 driver.findElement(By.name("description")).clear();
	 driver.findElement(By.name("description")).sendKeys("This comment is from sumand user");
	 driver.findElement(By.name("accountName")).sendKeys("Sears Holdings Corporation");
	 Thread.sleep(3000);
	 Assert.assertEquals(driver.findElement(By.xpath("//div[2]/label")).getText(), "Sears Holdings Corporation [191222244]");
	 driver.findElement(By.id("191222244")).click();
	 Thread.sleep(3000);
	 Assert.assertEquals(driver.findElement(By.xpath("//tr[2]/td")).getText(), "Sears Holdings Corporation");
	 Assert.assertEquals(driver.findElement(By.xpath("//tr[2]/td[2]")).getText(), "Can see");
	 Assert.assertEquals(driver.findElement(By.xpath("//tr[2]/td[3]")).getText(), "Remove from list");
	
//click on publish 
	 driver.findElement(By.name("submit")).click();
	 Thread.sleep(4000);
	 Assert.assertEquals(driver.findElement(By.xpath("//div[3]/p")).getText(), "Changes to amicas_doc have been saved.");
//Now reset the account selection from the doc
		 driver.findElement(By.xpath("//tr[2]/td[3]")).click();
	 Thread.sleep(2000);
		//click on publish 
		 driver.findElement(By.name("submit")).click();
		 Thread.sleep(4000);	 
		 Assert.assertEquals(driver.findElement(By.xpath("//div[3]/p")).getText(), "Changes to amicas_doc have been saved.");
	 
 }
 
@AfterTest
public void tearDown() throws Exception{
	  LogIn_Page logout = new LogIn_Page(driver); //Logout
	  logout.Logout();
	  driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
	  driver.close();

}
}






//System.setProperty("webdriver.gecko.driver", "C:\\Users\\sanoaoa\\workspace\\MPS_Venus_Test_Automation\\drivers\\geckodriver.exe");
//driver = new FirefoxDriver();
