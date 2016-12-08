package com.lexmark.automation.test.PageObject.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObject_ManagedServicesVerification {
	public PageObject_ManagedServicesVerification(WebDriver driver) { //Constructor of Class
		PageFactory.initElements(driver,this);
		}
	
	
	
/*************************Service Requests Verification***********************/
@FindBy(css="h1.blue.text--bold > span.ng-binding")
public WebElement madc_open_SR_link;
@FindBy(linkText="Service requests")
public WebElement service_request_tab;
@FindBy(xpath="//div[@id='serviceRequestsServiceTab']/span/div/div[2]/div/h2")
public WebElement madc_open_SR_count;
//div[@id='serviceRequestsServiceTab']/span/div[2]/div/div/div[2]/div/div/label
@FindBy(css="p > span.ng-scope")
public WebElement madc_completed_SR_link;
@FindBy(xpath="//div[@id='serviceRequestsServiceTab']/span/div/div[2]/div/h2")
public WebElement madc_completed_SR_count;
		
/****************************************Orders Verification********************/
@FindBy(xpath="//div[2]/div/div[2]/a/h1/span")
public WebElement madc_orders_open_link;
@FindBy(linkText="All orders")
public WebElement all_orderstab;
@FindBy(xpath="//div[@id='orderAllTab']/span/div/div[2]/div/h2")
public WebElement open_orders_count;
@FindBy(xpath="//div[@id='orderAllTab']/span/div[2]/div/div/div[2]/div/div/label")
public WebElement submitted_orders_checkbox;
@FindBy(xpath="//div[@id='orderAllTab']/span/div[2]/div/div/div[2]/div/div[2]/label")
public WebElement in_process_orders_checkbox;
@FindBy(xpath="//div[@id='orderAllTab']/span/div[2]/div/div/div[2]/div/div[3]/label")
public WebElement shipped_orders_checkbox;
@FindBy(xpath="//div[@id='orderAllTab']/span/div[2]/div/div/div[2]/div/div[4]/label")
public WebElement completed_orders_checkbox;
//@FindBy(css="p > span.ng-scope")
@FindBy(xpath="//div[2]/div/div[3]/a/p/span")
public WebElement completed_orders_link;
@FindBy(xpath="//div[@id='orderAllTab']/span/div/div[2]/div/h2")
public WebElement completed_orders_count;

	
/*****************Device Change Requests Verification***********************/
@FindBy(xpath="//div[3]/div/div[2]/a/h1/span")
public WebElement madc_open_dev_request_link;
@FindBy(xpath="/html/body/div[1]/div/div/div/div/div/div[1]/div[2]/div[3]/div/div[3]/a/p")
//@FindBy(xpath="//div[3]/div/div[3]/a/p/span")
public WebElement madc_completed_dev_request_link;
@FindBy(linkText="Device requests")
public WebElement device_request_tab;
@FindBy(xpath="//div[@id='serviceRequestsDeviceTab']/span/div[2]/div/div/div[2]/div/div[2]/label")
public WebElement in_process_checkbox;
@FindBy(xpath="//div[@id='serviceRequestsDeviceTab']/span/div[2]/div/div/div[2]/div/div/label")
public WebElement submitted_checkbox;
@FindBy(xpath="//div[@id='serviceRequestsDeviceTab']/span/div/div[2]/div/h2")
public WebElement madc_open_dev_request_count;
@FindBy(xpath="//div[@id='serviceRequestsDeviceTab']/span/div[2]/div/div/div[2]/div/div[3]/label")
public WebElement completed_checkbox;
@FindBy(xpath="//div[@id='serviceRequestsDeviceTab']/span/div/div[2]/div/h2")
public WebElement madc_completed_dev_request_count;


}
