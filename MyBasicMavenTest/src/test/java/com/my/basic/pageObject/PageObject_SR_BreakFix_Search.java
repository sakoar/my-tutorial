package com.my.basic.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObject_SR_BreakFix_Search {
public PageObject_SR_BreakFix_Search(WebDriver driver) {
PageFactory.initElements(driver,this);
}

//##########Home Page Details#######
@FindBy(linkText="Requests")
public WebElement request_tab; 
@FindBy(linkText="Service requests")
public WebElement service_request;

@FindBy(xpath="//*[@id='serviceRequestsServiceTab']/span/div[3]/div[1]/div/div/div[1]/div[1]/div/div/div[2]/div")
public WebElement dropDown;
//Search dropdown
@FindBy(xpath="//div[@id='serviceRequestsServiceTab']/span/div[3]/div/div/div/div/div/div/div/div[3]/ul/li[1]")
public WebElement ReqstNumber_option;
@FindBy(xpath="//div[@id='serviceRequestsServiceTab']/span/div[3]/div/div/div/div/div/div/div/div[3]/ul/li[2]")
public WebElement cust_device_tag_option;
@FindBy(xpath="//div[@id='serviceRequestsServiceTab']/span/div[3]/div/div/div/div/div/div/div/div[3]/ul/li[3]")
public WebElement hostname_option;
@FindBy(xpath="//div[@id='serviceRequestsServiceTab']/span/div[3]/div/div/div/div/div/div/div/div[3]/ul/li[4]")
public WebElement ipv4address_option;
@FindBy(css="div.selectricWrapper.selectricOpen > div.selectricItems > ul > li.selected")
public WebElement ipv4address_option2;

@FindBy(xpath="//div[@id='serviceRequestsServiceTab']/span/div[3]/div/div/div/div/div/div/div/div[3]/ul/li[5]")
public WebElement serial_option;
@FindBy(xpath="//div[@id='serviceRequestsServiceTab']/span/div[3]/div/div/div/div/div/div/div/div[3]/ul/li[6]")
public WebElement product_model_option;


@FindBy(xpath="(//input[@type='text'])[3]")
public WebElement input_field;


//Search functions
public void searchRequest(String SR) throws InterruptedException{
	request_tab.click();
	Thread.sleep(4000);
	service_request.click();
	Thread.sleep(3000);
	input_field.sendKeys(SR);
	System.out.println("entered the sr num");
	input_field.sendKeys(Keys.ENTER);
	System.out.println("clicked on search button");
	Thread.sleep(5000);
	}




@FindBy(linkText="1-167029552521")
public WebElement req_no;
@FindBy(xpath="/html/body/div[1]/div/div/div/div/div[2]/div/div[2]/div[3]/span/div[4]/div[1]/div/div[2]/div[2]/div/div/div/div[3]/div")
public WebElement device_tag;
@FindBy(xpath="/html/body/div[1]/div/div/div/div/div[2]/div/div[2]/div[3]/span/div[4]/div[1]/div/div[2]/div[2]/div/div/div/div[4]/div")
public WebElement hostname;
@FindBy(xpath="/html/body/div[1]/div/div/div/div/div[2]/div/div[2]/div[3]/span/div[4]/div[1]/div/div[2]/div[2]/div/div/div/div[5]/div")
public WebElement ip_address_table;
@FindBy(xpath="/html/body/div[1]/div/div/div/div/div[2]/div/div[2]/div[3]/span/div[4]/div[1]/div/div[2]/div[2]/div/div/div/div[6]/div")
public WebElement serial_no;
@FindBy(xpath="/html/body/div[1]/div/div/div/div/div[2]/div/div[2]/div[3]/span/div[4]/div[1]/div/div[2]/div[2]/div/div/div/div[7]/div")
public WebElement product_model;
@FindBy(xpath="//h2")
public WebElement message1;
@FindBy(xpath="//div[7]/div/div/ul/li[2]/div[2]")
public WebElement ip_address_finalpage;
@FindBy(css="li.info-list__item.ng-scope > div.info-list__item-value.ng-binding")
public WebElement serial_no_final;


public void searchThroughOtherOptions() throws InterruptedException{
request_tab.click();
Thread.sleep(6000);
service_request.click();
Thread.sleep(5000);
dropDown.click();
System.out.println("clicked on the drop down");
Thread.sleep(4000);
ipv4address_option.click();
Thread.sleep(2000);
input_field.sendKeys("10.141.27.242");
input_field.sendKeys(Keys.ENTER);
System.out.println("clicked on search button");
Thread.sleep(5000);
	


request_tab.click();
Thread.sleep(4000);
service_request.click();
Thread.sleep(3000);
dropDown.click();
System.out.println("clicked on the drop down");
Thread.sleep(3000);
hostname_option.click();
Thread.sleep(2000);
input_field.sendKeys("Hostess");
input_field.sendKeys(Keys.ENTER);
System.out.println("clicked on search button");
Thread.sleep(5000);

request_tab.click();
Thread.sleep(4000);
service_request.click();
Thread.sleep(3000);
dropDown.click();
System.out.println("clicked on the drop down");
Thread.sleep(3000);
ipv4address_option.click();
Thread.sleep(2000);
input_field.sendKeys("10.12.4.19");
input_field.sendKeys(Keys.ENTER);
System.out.println("clicked on search button");
Thread.sleep(5000);

request_tab.click();
Thread.sleep(4000);
service_request.click();
Thread.sleep(3000);
dropDown.click();
System.out.println("clicked on the drop down");
Thread.sleep(3000);
serial_option.click();
Thread.sleep(2000);
input_field.sendKeys("4021013000787");
input_field.sendKeys(Keys.ENTER);
System.out.println("clicked on search button");
Thread.sleep(5000);


request_tab.click();
Thread.sleep(4000);
service_request.click();
Thread.sleep(3000);
dropDown.click();
System.out.println("clicked on the drop down");
Thread.sleep(3000);
product_model_option.click();
Thread.sleep(2000);
input_field.sendKeys("Lexmark MS911de");
input_field.sendKeys(Keys.ENTER);
System.out.println("clicked on search button");
Thread.sleep(5000);
}
}


