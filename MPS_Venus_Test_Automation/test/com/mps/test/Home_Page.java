	package com.mps.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lexmark.automation.test.PageObject.helper.HomePage_PageObjects;
import com.lexmark.automation.test.PageObject.helper.LogIn_Page;
import com.lexmark.automation.test.PageObject.helper.dateCalculations;

import libraryFiles.ExcelDataConfig;

public class Home_Page {

	
	WebDriver driver;
//Creating object of classes
	LogIn_Page UserLogin;
	HomePage_PageObjects homePageTest;
	
	String baseUrl = "https://venus-dev.lexmark.com";
//	private String UserID = "testamica@customer.com";
//	private String Password = "Lexmark15";
	private SoftAssert softAssert = new SoftAssert();
	
@BeforeTest
public void SetUp() throws InterruptedException {
	  //System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
	  //driver=new ChromeDriver();
	System.setProperty("webdriver.firefox.bin", "C:\\Users\\sanoaoa\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
    driver = new FirefoxDriver();
	  //driver = new FirefoxDriver();
	  driver.manage().window().maximize();	
}
@Test
  public void Login() throws Exception {
	
	File file = new File("data/InputTestData.xls");
	FileInputStream fis = new FileInputStream(file);
	HSSFWorkbook wb = new HSSFWorkbook(fis);
	HSSFSheet sh = wb.getSheetAt(0);
	String UID = sh.getRow(1).getCell(0).getStringCellValue();
	String PASSWD = sh.getRow(1).getCell(1).getStringCellValue();
	System.out.println(UID);
	 
	 	 driver.get(baseUrl);
	 	 driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
	 	 
	 	 UserLogin = new LogIn_Page(driver);
		 UserLogin.Login(UID, PASSWD);
		 System.out.println("Login Success");
		 driver.manage().timeouts().implicitlyWait(16, TimeUnit.SECONDS);
		 homePageTest = new HomePage_PageObjects(driver);
		 
		 WebDriverWait wait = new WebDriverWait(driver, 15);
				 wait.until(ExpectedConditions.elementToBeClickable(homePageTest.OpenServiceCount));
		 
		 
		 //homePageTest.HomePageDeviceSearch(sh.getRow(1).getCell(4).getStringCellValue());
		 }
@Test (dependsOnMethods ={"Login"})
public void HomePage() throws Exception{
	homePageTest= new HomePage_PageObjects(driver);
	homePageTest.BF_RollUP_Verification();
	softAssert.assertTrue(homePageTest.BF_Tab.isEnabled());
	softAssert.assertFalse(homePageTest.Address_Tab.isEnabled());
}

@AfterTest()
public void TearDown() throws Exception{
	UserLogin.Logout();
	driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
	driver.quit();
	
	}
 }

