package com.my.basic.test;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.swing.plaf.basic.BasicBorders.SplitPaneBorder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.my.basic.pageObject.LogIn_Page;
/*
import com.lexmark.automation.test.PageObject.helper.LogIn_Page;
import com.lexmark.automation.test.PageObject.helper.Users_PageObject;
*/
import com.my.basic.pageObject.Users_PageObject;

public class Test_DA_CreateNewExternalUserTest {
	
	WebDriver driver;
	String baseUrl = "https://managedservices.qa.lexmark.com";//"https://managedservices.qa.lexmark.com";
	LogIn_Page login;
	String emailID;
	String lastName;
	Users_PageObject createUsr;
	//Logger logger = Logger.getLogger(Test_DA_CreateNewExternalUserTest.class);
	
@BeforeClass
	public void setUp() throws InterruptedException{
	
//	PropertyConfigurator.configure("log4j.properties");
//	logger.info("################# This is User Creation Test from DA ####################");
	System.out.println("################# This is User Creation Test from DA ####################");
		//System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		//driver=new ChromeDriver();
	//System.setProperty("webdriver.firefox.bin", "C:\\Users\\sanoaoa\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
    driver = new FirefoxDriver();
//System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
//driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		driver.get(baseUrl);
//		logger.info("Browser opened & navigated to URL");
		login = new LogIn_Page(driver);
		login.Login("perftest_amica11@customer.com", "Lexmark01"); //Login Test
//		logger.info("Login successful");
		}

@Test 
  public void CreateNewUserTest() throws Exception {
	WebDriverWait wait= new WebDriverWait(driver,40);
	
	createUsr = new Users_PageObject(driver);
	createUsr.users.click();
	createUsr.createUserButton.click();
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	
	
//Look for account
	System.out.println("This is the account selection part");
	
	
//	SECTION-Who would you like to add as a user?	
	createUsr.firstName.sendKeys("selenium"); //first name
	Map <String, String> userMap = createUsr.generateEmai(); //declare the email
	
	createUsr.lastName.sendKeys(userMap.get("lastName")); //type last name
	createUsr.workPhone.sendKeys("1234567890"); //phone
	new Select(createUsr.language).selectByVisibleText("English"); //language
	
	createUsr.email.sendKeys(userMap.get("email")); //type email id
	
//	SECTION -Where are they located?
	Thread.sleep(2000);
	new Select(createUsr.country).selectByVisibleText("USA");
	createUsr.addressLine1.sendKeys("3351 Cove Lake Drive");
	createUsr.city.sendKeys("Lexington");
	new Select(createUsr.state).selectByVisibleText("Kentucky");
	createUsr.zip.sendKeys("40515");

//	SECTION - Portal login & Account Access	
	//Assert.assertEquals(createUsr.autoPopulatesEmail.getText(), email);
	createUsr.password.sendKeys("Lexmark01");
	createUsr.passwordConfirm.sendKeys("Lexmark01");

//Selection of account
	driver.findElement(By.id("062320692")).click();
	//Thread.sleep(2000);
	
// 	SECTION- COMPANY ASSOCIATION	
	/*
	WebElement accntSelect = wait.until(ExpectedConditions.elementToBeClickable(createUsr.searchResults4Accnt));
	Thread.sleep(6000);
	String str = createUsr.searchResults4Accnt.getText();
	Thread.sleep(3000);
	String accountName = str.split("\\[")[1].split("\\]")[0];
	System.out.println(accountName);
	Thread.sleep(2000);
	WebElement accntID = wait.until(ExpectedConditions.elementToBeClickable(By.id(accountName)));
	driver.findElement(By.id(accountName)).click();  //*[@id='062320692']
	*/
//SECTION - User role selection
	createUsr.clickRoleDropDown.click();
	//Thread.sleep(2000);
	createUsr.ViewOnly_Strategic.click();
	
//SECTION - Permissions
	createUsr.select_allPermission();
	//Thread.sleep(2000);
	
//Click on Create User button
	createUsr.createUser.click();
	//Thread.sleep(3000);

//Confirmation Message
	WebElement confirmMessage = wait.until(ExpectedConditions.elementToBeClickable(createUsr.confMesage));
	
	Assert.assertEquals(createUsr.confMesage.getText(), "User has been successfully created.");
	String expected = "Manage User Profile for "+userMap.get("lastName")+", "+"selenium"; 
	Assert.assertEquals(createUsr.userLink.getText(), expected);
	
//Search for user & Assert
	
	WebElement searchBox1 = wait.until(ExpectedConditions.elementToBeClickable(createUsr.searchBox));

	createUsr.searchBox.sendKeys(userMap.get("email"));
	Thread.sleep(2000);
	System.out.println("Clicking on Email Search Icon");
	createUsr.searchIcon.click();
	//Thread.sleep(3000);
	String emailCreated = driver.findElement(By.linkText(userMap.get("email"))).getText();
	Assert.assertEquals(emailCreated, userMap.get("email"));
//	logger.info("Test Passed for DA_CreateNewExternalUser");
	
//Tear Down
	LogIn_Page logout = new LogIn_Page(driver); //Logout
	  logout.Logout();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.quit();
	
  }

/*
@AfterTest
public void logout() throws Exception{
	Thread.sleep(3000);
	  LogIn_Page logout = new LogIn_Page(driver); //Logout
	  logout.Logout();
	  driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
	  driver.close();
	  logger.info("& browser close");
	}
	*/

}
