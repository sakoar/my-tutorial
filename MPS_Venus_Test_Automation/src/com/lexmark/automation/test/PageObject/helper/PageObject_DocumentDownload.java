package com.lexmark.automation.test.PageObject.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObject_DocumentDownload {
	   public PageObject_DocumentDownload(WebDriver driver) {
		PageFactory.initElements(driver,this);
				}

		//##########Home Page Details#######
		@FindBy(linkText="Documents")
		public WebElement documents_tab; 
		@FindBy(xpath="//button[@type='button']")
		public WebElement add_doc_button; 
}
