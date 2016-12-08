package com.lexmark.automation.test.PageObject.helper;

	import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.CacheLookup;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

	public class PageObject_OrderSupplies {
			public PageObject_OrderSupplies(WebDriver driver) { //Constructor of Class
				PageFactory.initElements(driver,this);
				}

//#############Details of 1st Page#########################

@FindBy(linkText="Devices")
public WebElement DevicesTab;
			
//See if default search option is Serial no or not
@FindBy(xpath="//*[@id='deviceListTab']/div[3]/div[1]/div/div/div[1]/div[1]/div/div/div[2]/span")
public WebElement DefaultSerialNoSelection;

//Search box
@FindBy(xpath="(//input[@type='text'])[3]")  
public WebElement SearchInput;
//Search Button
@FindBy(css="button.search")
public WebElement SearchButton; //These completes device search

public void searchDevice(String deviceNo) throws InterruptedException{
DevicesTab.click();
Thread.sleep(3000);
SearchInput.sendKeys(deviceNo);
SearchButton.click();
Thread.sleep(4000);
}

//############ Device Details Page
@FindBy(xpath="//div[@id='device']/div[4]/div[2]/p/span[4]")  //serial no
public WebElement serialNumber;
@FindBy(css="p.info-list > span.ng-binding")   //product model
public WebElement productModel;
@FindBy(css="div.info-list__item-value > span.ng-binding")   //Install Address
public WebElement installAddress;
@FindBy(xpath="//div[@id='deviceInfoTab']/div/ul[3]/li/div[2]")   //ip address
public WebElement ipAddress;
@FindBy(xpath="//div[@id='deviceInfoTab']/div/ul[4]/li/div[2]")   //Primary contact
public WebElement primaryContact;

//################# Order process

@FindBy(xpath="//button[text()='ORDER SUPPLIES']")
public WebElement order_supply_button;
//@FindBy(css="span.form__field__current-option")
//public WebElement serial_no;
@FindBy(xpath="(//input[@type='text'])[2]")
public WebElement search_field;
@FindBy(xpath="//button")
public WebElement search_icon;
@FindBy(xpath="//div[contains(@id,'-uiGrid-')]")
public WebElement search_key;
@FindBy(xpath="//button[2]")
public WebElement order_supplies_button1;


//##########Details of 2nd Page##########################
@FindBy(xpath="(//button[@type='button'])[4]")
public WebElement add_order1;
@FindBy(xpath="(//button[@type='button'])[5])")
public WebElement add_order2;
@FindBy(xpath="(//button[@type='button'])[6])")
public WebElement add_order3;
@FindBy(xpath="//*[contains(.,'-cell')]")
public WebElement partno1;
@FindBy(xpath="//button[text()='REVIEW AND SUBMIT']")
public WebElement review_and_submit;		


//##########Details of 3rd Page########################
@FindBy(css="div.col-1-3.ng-binding")
public WebElement account_detail;
//@FindBy(css="p.vertical-margin-24.ng-binding")
//public WebElement Shipping_address1;
@FindBy(xpath="(//input[@name='office'])[1]")
public WebElement buiding;
@FindBy(xpath="(//input[@name='office'])[2]")
public WebElement floor;
@FindBy(xpath="(//input[@name='office'])[3]")
public WebElement office;
@FindBy(name="specialHandlingInstructions")
public WebElement delivery_instructions;
@FindBy(name="purchaseOrderNumber")
public WebElement po_number;
@FindBy(css="div.well.well--no-shadow")
public WebElement order_createdby_block1;
@FindBy(xpath="//div[2]/div/div[2]/div/p")
public WebElement contact_block1;
@FindBy(name="internalReferenceId")
public WebElement refId;
@FindBy(name="requestCostCenter")
public WebElement cost_centre;
@FindBy(name="comments")
public WebElement user_comments;
@FindBy(xpath="//button[@type='submit']")
public WebElement  submit_button2;

//###########Details of Final Submitted Page###############
@FindBy(css="div.well.well--no-shadow")
public WebElement order_createdby_block2;
@FindBy(xpath="//div[6]/div/div/p")
public WebElement Shipping_address2;
@FindBy(xpath="//div[2]/div/p")
public WebElement contact_block2;
@FindBy(css="span.ng-binding.ng-scope")
public WebElement partno2;

//####################Submit Page Confirmation Messages
@FindBy(css="div.col-lg-2-3.col-md-1-1 > h1.ng-scope")  
public WebElement submitPageMessage;
@FindBy(css="span.ng-scope > span.ng-scope")  
public WebElement submitPageMessage2;
@FindBy(xpath="//h2")  
public WebElement readSRNumber;

	}
