package com.my.basic.pageObject;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Users_PageObject {

	String emailID;
	public Users_PageObject(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText="Users")
	public WebElement users; 
	
	@FindBy(xpath="//button[@type='button']")
	public WebElement createUserButton; 

//	SECTION-Who would you like to add as a user?	
	@FindBy(name="firstName")
	public WebElement firstName; 
	
	@FindBy(name="lastName")
	public WebElement lastName; 
	
	@FindBy(name="workPhone")
	public WebElement workPhone; 
	
	@FindBy(name="email")
	public WebElement email; 
	
	@FindBy(name="language")
	public WebElement language; 

//	SECTION -Where are they located?
	@FindBy(name="country")
	public WebElement country; 
	
	@FindBy(name="addressLine1")
	public WebElement addressLine1; 
	
	@FindBy(name="city")
	public WebElement city; 
	
	@FindBy(name="state")
	public WebElement state; 
	
	@FindBy(name="zipCode")
	public WebElement zip; 

	public void captureAddress(String Ad1, String City, String State, String ZIP) throws InterruptedException{
		Thread.sleep(3000);
		addressLine1.clear();
		addressLine1.sendKeys(Ad1);
		city.clear();
		city.sendKeys(City);
		new Select(state).selectByVisibleText(State);
		Thread.sleep(2000);
		zip.clear();
		zip.sendKeys(ZIP);
			
	}
	
//	SECTION - Portal login & Account Access
	@FindBy(xpath="//html/body/div[1]/div/div/div/div/div[2]/div/div/form/div[1]/div[3]/div[1]/input")
	public WebElement autoPopulatesEmail; 

	@FindBy(name="password")
	public WebElement password; 

	@FindBy(name="passwordConfirm")
	public WebElement passwordConfirm; 

// 	SECTION- COMPANY ASSOCIATION   #######>>>>>>>>>>>>> This is for Portal Admin		
	@FindBy(name="accountName") 
	public WebElement findAccount; 


	@FindBy(xpath="//html/body/div[1]/div/div/div/div/div[2]/div/div/form/div[1]/div[4]/div[3]/div/div/ul/li/div[2]/label")
	public WebElement searchResults4Accnt;

//SECTION - User role 	
	@FindBy(xpath="//i")
	public WebElement clickRoleDropDown;
	
	@FindBy(xpath="//div[3]/ul/li[2]")
	public WebElement ViewOnly_Options;
	
	@FindBy(xpath="//html/body/div[1]/div/div/div/div/div[2]/div/div/form/div[1]/div[5]/div[1]/div/div/div[3]/ul/li[3]")
	public WebElement ViewOnly_Strategic;

//Permission	
	@FindBy(id="3")
	public WebElement reqstBF;

	@FindBy(id="4")
	public WebElement orderHW;

	@FindBy(id="5")
	public WebElement orderCatalog;

	@FindBy(id="6")
	public WebElement orderAsset;

	@FindBy(id="7")
	public WebElement reqstBasicMADC;
	
	@FindBy(id="8")
	public WebElement reqstAdvnceMADC;
	
	@FindBy(id="9")
	public WebElement manageDocs;
	
	@FindBy(id="10")
	public WebElement viewBilling;
	
	@FindBy(id="11")
	public WebElement manageUsers;

//Create User button
	@FindBy(xpath="//span[text()='CREATE USER']")
	public WebElement createUser;
	
//Confirmation Message
	@FindBy(css="div.alert > span.ng-scope")
	public WebElement confMesage;
	
	@FindBy(xpath="//html/body/div[1]/div/div/div/div/div[1]/div[3]/a")
	public WebElement userLink;
	
//Search user in Grid
	@FindBy(xpath="(//input[@type='text'])[3]")
	public WebElement searchBox;
	
	@FindBy(css="button.search")
	public WebElement searchIcon;

//########################### Search for Email	###################################	
public void searchEmail(String emailID) throws InterruptedException{
	users.click();  
	Thread.sleep(6000);
	searchBox.sendKeys(emailID);
	Thread.sleep(4000);
	searchIcon.click();
}
	
public Map generateEmai(){  //This will generate random email ID which is going to be Unique
	Map <String, String> userMap = new HashMap<>();
	long random = Math.round(Math.random()*1357);
	String email="selenium." + random + "@domain.com";
	System.out.println(email); //this will create random email
	userMap.put("email", email);
	userMap.put("lastName", String.valueOf(random));
	return userMap;
	
}

public String generateLastName(String lastName){ //This will generate Last name which is splited from emil id.
	long random = Math.round(Math.random()*1357);
	String lastNameStr = Long.toString(random); //convert last name to string
	System.out.println(lastNameStr);
	return lastNameStr;
	
}

public void select_allPermission(){
	reqstBF.click();
	orderHW.click();
	orderCatalog.click();
	orderAsset.click();
	reqstBasicMADC.click();
	reqstAdvnceMADC.click();
	manageDocs.click();
	viewBilling.click();
	manageUsers.click();
	}

}