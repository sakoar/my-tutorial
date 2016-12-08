package com.my.basic.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.my.basic.pageObject.ThisIsPageObject;

public class ThisIsTest {
  @Test
  public void test2() {
	  ThisIsPageObject accessPO = new ThisIsPageObject();
	  accessPO.test1();
	  System.out.println("This is Test 2. How are you??");
  }
  @Test
  public void browserTest(){
	 //System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
	 System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
	 WebDriver driver = new ChromeDriver();
	 
	 driver.get("https://www.google.com");
  }
}
