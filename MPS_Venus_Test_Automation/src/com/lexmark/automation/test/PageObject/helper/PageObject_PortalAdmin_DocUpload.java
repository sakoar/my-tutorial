package com.lexmark.automation.test.PageObject.helper;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObject_PortalAdmin_DocUpload {
	public PageObject_PortalAdmin_DocUpload(WebDriver driver) { //Constructor of Class
		PageFactory.initElements(driver,this);
		}

/***********************HomePage Details after Login*************/	
@FindBy(xpath="//li[3]/a/span[2]")
public WebElement portal_admin;
@FindBy(linkText="Document Management")
public WebElement doc_mgmt_link;
@FindBy(xpath="//*[text()='ADD A NEW DOCUMENT']")
public WebElement add_doc_button;
@FindBy(name="file")
public WebElement browse; 

/**** Uploading Files by clicking on Browse Button********************/
public void uploadFile() throws AWTException, InterruptedException{
browse.click();
	
StringSelection s =new StringSelection("C:\\Users\\sanoaoa\\workspace\\MPS_Venus_Test_Automation\\data\\Customer Portal3.pdf");
Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
Robot r =new Robot();
if(System.getProperty("os.name").toLowerCase().contains("windows"))
{
	r.keyPress(KeyEvent.VK_CONTROL);
	r.keyPress(KeyEvent.VK_V);
	r.keyRelease(KeyEvent.VK_V);
	r.keyRelease(KeyEvent.VK_CONTROL);
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);
	Thread.sleep(30000);
}
else if(System.getProperty("os.name").toLowerCase().contains("mac"))
{
	r.keyPress(KeyEvent.VK_META);
	r.keyPress(KeyEvent.VK_V);
	r.keyRelease(KeyEvent.VK_V);
	r.keyRelease(KeyEvent.VK_META);
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);
	Thread.sleep(30000);
}
else if(System.getProperty("os.name").toLowerCase().contains("linux"))
{
	r.keyPress(KeyEvent.VK_CONTROL);
	r.keyPress(KeyEvent.VK_SHIFT);
	r.keyPress(KeyEvent.VK_V);
	r.keyRelease(KeyEvent.VK_V);
	r.keyRelease(KeyEvent.VK_SHIFT);
	r.keyRelease(KeyEvent.VK_CONTROL);
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);
	Thread.sleep(30000);
}
else
{
	System.exit(0);
}
Thread.sleep(5000);
}
 
@FindBy(name="name")
public WebElement doc_name; 
@FindBy(name="description")
public WebElement description; 
@FindBy(xpath="(//input[@type='text'])[2]")
public WebElement tagging; 
@FindBy(id="dateLeft")
public WebElement publish_from; 
@FindBy(id="dateRight")
public WebElement publish_to;  
@FindBy(name="submit")
public WebElement publish_button; 
@FindBy(xpath="//div[2]/p")
public WebElement message; 
@FindBy(className="selectricButton")
public WebElement arrow; 
@FindBy(xpath="(//input[@type='text'])[3]")
public WebElement input_field;

	
}
