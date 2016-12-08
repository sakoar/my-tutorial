package com.lexmark.automation.test.PageObject.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


		
public class PageObject_OrderDevice {
	public PageObject_OrderDevice(WebDriver driver) {
		PageFactory.initElements(driver,this);
	
	}

//#############Details of Agreement Page#########################
@FindBy(linkText="Orders")
public WebElement order_tab;
@FindBy(xpath="//button[text()='ORDER DEVICE']")
public WebElement order_device_button;
//select document.srForm.elements[1] 
@FindBy(xpath="/html/body/div[1]/div/div/div/div/div[2]/form/div[3]/div/select")
//(className="ng-pristine ng-invalid ng-invalid-required ng-touched")
public WebElement contract_select;
@FindBy(id="pay-now")
public WebElement pay_now;
@FindBy(id="device-catalog")
public WebElement device_catalog;
@FindBy(xpath="//button[@type='submit']") 
//@FindBy(xpath="//button[text()='CONTINUE']")
public WebElement continue_button;

public void selectContract() throws InterruptedException{
new Select(contract_select).selectByValue("0");//Contract Selection from Dropdown
}
//#############Details of Account Page#########################
//@FindBy(xpath="//input[@type='text'])[2]")
@FindBy(xpath="/html/body/div[1]/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/div[1]/div[1]/div[2]/div/div/div[1]/input")
public WebElement search_field; //send keys
@FindBy(css="button.search")
public WebElement search_icon1;
//@FindBy(name="cancel")
//public WebElement abondon_request;
//@FindBy(xpath="//button[@type='button']")
//button[@type='button']
@FindBy(xpath="//button[text()='ADD TO ORDER']")
public WebElement add_to_order;
@FindBy(xpath="//button[@type='button'])[2]")
public WebElement add_to_order2;
@FindBy(xpath="//button[@type='button'])[3]")
public WebElement add_to_order3;
@FindBy(xpath="//div[contains(@id,'-uiGrid-')]")
public WebElement part_no1;
@FindBy(xpath="//button[@type='submit']")
public WebElement review_button;

//#############Details of Review | Hardware order Page#########################
@FindBy(linkText="Please select a shipping address for this order >")
public WebElement shipping_select;

@FindBy(xpath="(//input[@type='text'])[2]")
public WebElement address_search_field; //sendkeys
@FindBy(xpath="//button")
public WebElement search_icon2;
@FindBy(xpath="//div[contains(@id,'-uiGrid-')]")
public WebElement select_key;
@FindBy(xpath="//button[2]")
public WebElement address_selection_button;

//#############  SHIPPING ADDRESS ################################
public String searchShippingAddress(String addressName) throws InterruptedException{
	shipping_select.click();
	Thread.sleep(3000);
	address_search_field.sendKeys(addressName);
	Thread.sleep(2000);
	search_icon2.click();
	Thread.sleep(2000);
	select_key.click();
	address_selection_button.click();
	
	return addressName;
}

//#############  BILLING ADDRESS ################################
@FindBy(linkText="Please select a bill to address for this order >")
public WebElement billing_select;

public String searchBillingAddress(String addressName) throws InterruptedException{
	billing_select.click();
	billing_select.click();
	billing_select.click(); // need to click on this 3 times
	Thread.sleep(3000);
	address_search_field.sendKeys(addressName);
	Thread.sleep(2000);
	search_icon2.click();
	Thread.sleep(2000);
	select_key.click();
	address_selection_button.click();
	
	return addressName;
}

//#############  Capturing all other details like PO Number, Bldg, Floor, Ofce etc ################################
@FindBy(xpath="(//input[@name='office'])[4]")
public WebElement building;
@FindBy(xpath="(//input[@name='office'])[5]")
public WebElement floor;
@FindBy(xpath="(//input[@name='office'])[6]")
public WebElement office;
@FindBy(name="specialHandlingInstructions")
public WebElement delivery_instruction1;
@FindBy(name="purchaseOrderNumber")
public WebElement PO_number;
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
public WebElement submit_hardware_order;

public void fillingUpOtherDetails() throws InterruptedException{
	building.sendKeys("Travel");
	floor.sendKeys("Far East");
	office.sendKeys("Global Transport");
	delivery_instruction1.sendKeys("Not after 5 pm");
	PO_number.sendKeys("1234567");
	refId.sendKeys("this is ref id");
	cost_centre.sendKeys("this is cost center");
	user_comments.sendKeys("this is coment section");
	Thread.sleep(2000);
	
}

//###############  	SUBMIT PAGE MESSAGE
@FindBy(xpath="//*[text()='Submitted | Device Order request']")
public WebElement submitMessage;

@FindBy(css="css=p.ng-binding.firepath-matching-node")
public WebElement SPOrderCreatedBy;
@FindBy(xpath="//div[2]/div/p")
public WebElement SPPrimaryContact;



//Confirmation page SR DETAILS
//	@FindBy(css="div.col-lg-2-3.col-md-1-1 > h1.ng-scope")  
//	public WebElement submitPageMessage;
	@FindBy(css="css=span.ng-scope > span.ng-scope")  
	public WebElement submitPageMessage2;
	@FindBy(xpath="//h2")  
	public WebElement readSRNumber;






/*
//#############Details of Review | Hardware order Page#########################
@FindBy(linkText="Please select a shipping address for this order >")
public WebElement shipping_select;
@FindBy(css="div.col-1 > p.vertical-margin-24.ng-binding")
public WebElement shipping_address_block1;
@FindBy(xpath="//html/body/div[1]/div/div/div/div/div[2]/div[3]/div/div/div/div/div[3]/a")
public WebElement bill_address_select;
@FindBy(css="div.ng-scope > p.vertical-margin-24.ng-binding")
public WebElement billing_address_block1;

//@FindBy(xpath="//input[@name='office'])[4]") "THIS IS WHAT YOU CAPYURED SUSHMA"
@FindBy(xpath="(//input[@name='office'])[4]")
public WebElement building;
@FindBy(xpath="(//input[@name='office'])[5]")
public WebElement floor;
@FindBy(xpath="(//input[@name='office'])[6]")
public WebElement office;
@FindBy(name="specialHandlingInstructions")
public WebElement delivery_instruction1;
@FindBy(name="purchaseOrderNumber")
public WebElement PO_number;
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
@FindBy(xpath="//button[text()='SUBMIT HARDWARE ORDER']")
public WebElement submit_hardware_order;


//#############Address selection Page##############################
//@FindBy(xpath="//input[@type='text'])[2]")
@FindBy(xpath="(//input[@type='text'])[2]")
public WebElement address_search_field; //sendkeys
@FindBy(xpath="//button")
public WebElement search_icon2;
@FindBy(xpath="//div[contains(@id,'-uiGrid-')]")
public WebElement search_key1;
@FindBy(xpath="//button[2]")
public WebElement address_selection_button;


public void shippingAddress() throws InterruptedException{
shipping_select.click();
Thread.sleep(3000);
address_search_field.sendKeys("Dallas Regional Office, Frisco, TX");
Thread.sleep(3000);
search_icon2.click();
Thread.sleep(2000);
search_key1.click();
Thread.sleep(2000);
address_selection_button.click();
Thread.sleep(4000);
//String shipping_address1=shipping_address_block1.getAttribute("value");
}


//###########Bill Address selection Page##############
//@FindBy(xpath="/html/body/div[1]/div/div/div/div/div/div/div[2]/div[3]/div[1]/div/div/div[1]/div[2]/div/div/div[1]/input")
//@FindBy(xpath="//*[text()='']")
//@FindBy(xpath="//*[@type='text'])[2]")
//@FindBy(className="search-box ng-pristine ng-valid ng-touched")
//@FindBy(xpath="//*[text()='value']")
@FindBy(xpath="(//input[@type='text'])[2]")
public WebElement bill_address_search_field;
@FindBy(xpath="//button")
public WebElement search_icon3;
@FindBy(xpath="//div[contains(@id,'-uiGrid-')]")
public WebElement select_key2;
@FindBy(xpath="//button[text()='Apply Selection']")
public WebElement bill_address_selection_button;

public void billingAddress() throws InterruptedException{
bill_address_select.click();
Thread.sleep(4000);
bill_address_search_field.sendKeys("PO BOX 6008");
search_icon3.click();
Thread.sleep(3000);
select_key2.click();
Thread.sleep(2000);
bill_address_selection_button.click();
Thread.sleep(2000);
//String bill_address1=billing_address_block1.getAttribute("value");
}

//##############Submitted | Device Order request Page###########
@FindBy(css="p.ng-binding")
public WebElement order_createdby_block2;
@FindBy(xpath="//div[2]/div/p")
public WebElement contact_block2;
@FindBy(xpath="//div[contains(@id,'-uiGrid-')]")
public WebElement part_no2;
@FindBy(xpath="//div[6]/div/div/p")
public WebElement shipping_address_block2; 
@FindBy(xpath="//div[6]/div[2]/div/p")
public WebElement billing_address_block2;    
@FindBy(xpath="//div[3]/ul/li/div[2]")
public WebElement pu_order2;  
@FindBy(css="div.ng-scope > p.ng-binding")
public WebElement delivery_instrucytion2;

*/

}
