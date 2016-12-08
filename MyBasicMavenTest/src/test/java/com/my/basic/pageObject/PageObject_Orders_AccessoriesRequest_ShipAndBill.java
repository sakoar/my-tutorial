package com.my.basic.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObject_Orders_AccessoriesRequest_ShipAndBill {
	public PageObject_Orders_AccessoriesRequest_ShipAndBill(WebDriver driver) { //Constructor of Class
		PageFactory.initElements(driver,this);
		}
	
	
	
/*************************Service Requests Verification***********************/
@FindBy(css="h1.blue.text--bold > span.ng-binding")
public WebElement madc_open_SR_link;
}
