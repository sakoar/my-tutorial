package com.lexmark.automation.test.PageObject.helper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObject_PortalAdmin_HomePageNotification {
	public PageObject_PortalAdmin_HomePageNotification(WebDriver driver) { //Constructor of Class
		PageFactory.initElements(driver,this);
		}

/************************Details of Home page**********************/
@FindBy(xpath="//li[3]/a/span[2]")
public WebElement portal_admin_link;
@FindBy(xpath="//li[3]/ul/li[2]/a/span")
public WebElement homepage_notification_tab;
@FindBy(xpath="//button[@type='button']")
public WebElement create_notification_button;
@FindBy(xpath="//input[@type='text']")
public WebElement from_date;
@FindBy(xpath="(//input[@type='text'])[2]")
public WebElement to_date;
@FindBy(name="title")
public WebElement title;
@FindBy(name="message")
public WebElement message_display;
@FindBy(name="url")
public WebElement url;
@FindBy(name="submit")
public WebElement save_notification_button;
@FindBy(linkText="TestAuto")
public WebElement title_link;
@FindBy(linkText="Log out")
public WebElement log_out;
@FindBy(css="div.alert__body > span.ng-scope")
public WebElement msg;
@FindBy(xpath="//div[2]/div/span")
public WebElement link2;//title link
@FindBy(css="button.btn.btn--default")
public WebElement delete_notification_button;

@FindBy(xpath="(//a[contains(text(),'Delete value')])[2]")
public WebElement delete_value_link;

@FindBy(linkText="TestAuto")
public WebElement link_to_delete;
@FindBy(css="div.alert__body > span.ng-scope")
public WebElement msg3;



WebDriver driver;
public void createAdminNotification()throws Exception{
driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
//create_notification_button.click();
from_date.sendKeys("12/01/2016 01:00");
to_date.sendKeys("12/31/2016 23:00");
title.sendKeys("TestAuto");
message_display.sendKeys("Hello user!  you are getting this notification as part of Test Automation. please don't worry.");
String message1=message_display.getText().trim();
System.out.println(message1);
//System.out.println();
//logger.info(message1);
url.sendKeys("http://www.seleniumhq.org");
//url.sendKeys("http://www.google.co.in");
save_notification_button.click();
//homepage_notify.title_link.click();

//logger.info("Portal Admin Log Out from the Application");
//logger.info("Different User logging in to the Application");
}
public void deleteAdminNotification()throws Exception{
driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
portal_admin_link.click();
homepage_notification_tab.click();
link2.click();
delete_notification_button.click();

}
}
