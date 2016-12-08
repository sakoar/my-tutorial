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

public class PageObject_DocumentUpload {
public PageObject_DocumentUpload(WebDriver driver) {
PageFactory.initElements(driver,this);
		}

//##########Home Page Details#######
@FindBy(linkText="Documents")
public WebElement documents_tab; 
@FindBy(xpath="//button[@type='button']")
public WebElement add_doc_button; 
@FindBy(name="file")
public WebElement browse; 

//@FindBy(name="img")
//public WebElement file_upload; 

/**** Uploading Files by clicking on Browse Button********************/
 
public void uploadFile() throws AWTException, InterruptedException{
//file_upload.click();
browse.click();


StringSelection s =new StringSelection("\\data\\InputData.xlsx");
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
	Thread.sleep(5000);
}
else if(System.getProperty("os.name").toLowerCase().contains("mac"))
{
	r.keyPress(KeyEvent.VK_META);
	r.keyPress(KeyEvent.VK_V);
	r.keyRelease(KeyEvent.VK_V);
	r.keyRelease(KeyEvent.VK_META);
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);
	Thread.sleep(5000);
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
	Thread.sleep(5000);
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
@FindBy(name="submits")
public WebElement publish_button; 
@FindBy(xpath="//div[2]/p")
public WebElement message; 
@FindBy(xpath="(//input[@type='text'])[3]")
public WebElement input_field;

}
