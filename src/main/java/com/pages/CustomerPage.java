package com.pages;
import static org.testng.AssertJUnit.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.BasePackage.Base_Class;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Common.Main;
import Common.WaitWrapper;
import Utility.Logs.Log;

public class CustomerPage extends BasePage {

	public CustomerPage(WebDriver driver) {
		super(driver);
	}
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	WebElement element;
	public String carrier_Name=null;
	public String Premium_Date=null;
	String FirstName =null;
	String Fullname =null;
	String Lastname = null;
	private By CTIMinimizeIcon = By.xpath("//a[@class='fa fa-minus right-al']");
	private By Create_Policy = By.xpath("//button[normalize-space()='Create Policy']");
	private By CText = By.xpath("(//span[@class='md-select-icon'])[2]");
	private By Premium_Amount =  By.xpath("(//input[@name='TotalResAmount'])[1]");
	private By AOR_Search = By.xpath("//button[@ng-click=\"$parent.aorSearchLookup('AgentName', 'CreateAssetForm')\"]//i[@class='glyphicon glyphicon-search']");
	private By AOR_Text = By.xpath("//input[contains(@class,'pull-right ng-pristine ng-untouched ng-valid ')]");
	private By search = By.xpath("(//i[@class='glyphicon glyphicon-search'])[5]");
	private By Select_Agent = By.xpath("(//input[@name='selectedAgent'])[1]");
	private By click_ok = By.xpath("//button[normalize-space()='OK']");
	private By AOR_Textsearch = By.xpath("(//i[@class='glyphicon glyphicon-search'])[5]");

	By Customerdropdown = By.xpath("//a[@id='menu_customers']");
	By ClickLead = By.xpath("//a[@class='edit-list-anchor ng-binding']");
	By Policies= By.xpath("(//a[@role='tab'][normalize-space()='Policies'])[1]");
	By Customers = By.xpath("//a[@class='glyphicon fa fa-users']");
	By NewCustomer = By.xpath("//button[@id='newCustomerBtn']");
	By CustFName = By.xpath("(//input[@id='LeadFirstName'])[1]");
	By CustLName = By.xpath("(//input[@id='LeadLastName'])[1]");
	//    By ContactInfo = By.xpath("(//div[@class='accordion-container'])[2]");
	By ContactInfo = By.xpath("//*[@id=\"page-wrapper\"]/div/ui-view/div[8]/ng-include/div[3]/div/div[2]/div/div[1]/div[5]/i");
	By Cellphone = By.xpath("(//input[@name='CellPhone'])[1]");
	By CustMail = By.xpath("(//input[@name='Email'])[1]");
	By PolicySubmit = By.xpath("//button[@ng-show=\"accountType !=='Group'\"]");
	By ProductCategory1 = By.xpath("(//md-select[@id='CRMProductCategory'])[1]");
	By AccidentLOB = By.xpath("(//md-option[@value='Medical'])[2]");
	By Carrier = By.xpath("//md-select[@id='Carrier']");
	By SelectCarrier = By.xpath("(//md-option[@value='NLG'])[2]");
	By SalesType = By.xpath("//md-select[@id='salesType']");
	By SalesNew = By.xpath("(//md-option[@value='New'])[2]");
	By PolicyStatus = By.xpath("(//md-select[@id='AssetStatus'])[1]");
	//	By PolicyStatus = By.xpath("//md-select[@id='AssetStatus']");
	By PolicyActive = By.xpath("(//div[@class='md-text'][normalize-space()='Active'])[3]");
	By PolicyEFDate = By.xpath("//input[@id='EffectiveDate']");
	By PolicyAOR = By.xpath("(//button[@class='btn btn-default green']/child::i)[3]");
	By AoRSearchText = By.xpath("//input[@ng-model='searchText']");
	By AORSearchIcon = By.xpath("//button[@title='Search Agent Name']");
	By SelectAOR = By.xpath("//input[@name='selectedAgent']");
	By AorOk = By.xpath("//button[text()='OK']");
	By PrincipalAdress = By.xpath("//*[@id=\"page-wrapper\"]/div/ui-view/div[8]/ng-include/div[3]/div/div[2]/div/div[1]/div[8]/i");
	By PricipalAD1 = By.xpath("//input[@id='AddressLine1']");
	By PrincipalZipCode = By.xpath("//input[@name='ZipCode']");
	By MailingAddress = By.xpath("(//input[@type='checkbox'])[2]");
	By CustSubmit = By.xpath("(//button[text()='Submit'])[3]");
	By CustcreateOpp = By.xpath("(//button[@class='btn btn-default pull-right ng-binding ng-scope'])[2]");
	By CustOppSubmit = By.xpath("(//button[@class='btn btn-default green'])[3]");
	By CreateServiceRequest = By.xpath("(//button[@class='btn btn-default pull-right ng-binding ng-scope'])[1]");
	By RequestType = By.xpath("//md-select[@name='SrType']");
	By RequestStatus = By.xpath("//md-option[@value='New Enrollment']");
	By RequestSubType = By.xpath("//md-select[@name='SRActivitySubType']");
	By RequestSubStatus = By.xpath("//md-option[@value='Referral']");
	By RequestSubmit = By.xpath("(//button[text()='Submit'])[5]");
	By CustomerFilterStatus = By.xpath("(//div[@class='accordion-container grid-style-height']/child::h5)[4]");
	By CustomerFilActive = By.xpath("//md-checkbox[@value='Active']");
	By CustomerInActive = By.xpath("//md-checkbox[@value='Inactive']");
	By Search =By.xpath("//*[@type='search']");
	By FirstCustomer =By.xpath("(//*[@ng-click='grid.appScope.navigateToDetails(row.entity)'])[1]");
	By LeadDOB = By.name("LeadDob");
	By menu_bar = By.xpath("//i[@class='fa fa-bars']");

	private By confirmlead = By.xpath("//button[contains(text(),'Proceed with Customer creation')]");
	private By ManageCustomer =By.name("manageCustomerBtn");
	private By deleteCustomerBtn =By.name("deleteCustomerBtn");
	private By ConfirmDelete =By.xpath("//*[@ng-click='confirmModalCtrl.Confirm()']");
	private By Success_Message = By.xpath("//div[@id='divSuccess']");
	private By SelectBoxfirst =By.xpath("(//*[contains(@ng-click,'selectButtonClick(row')])[1]");
	private By BacktoCustomer =By.xpath("//*[@href='#/customers']");


	public void waitForElement(int time) throws InterruptedException {
		Thread.sleep(time);
	}

	public void ClickOnMinimizeCallwindow() throws InterruptedException {
		Thread.sleep(10000);
		if (ElementDisplayed(CTIMinimizeIcon)) {
			ExtentSuccessMessage("Successfully user able to See 'Minimize Icon' ");
			click(CTIMinimizeIcon);
			ExtentSuccessMessage("Successfully user Clicked on 'Minimize Icon' ");
		} else {
			ExtentSuccessMessage("Unsuccessfully 'Minimize' Not visible");
		}
	}

	public void DeleteCustomer() throws InterruptedException {
		Thread.sleep(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectBoxfirst));
		click(SelectBoxfirst);
		ExtentSuccessMessage("Clicked on Select Box first Customer");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ManageCustomer));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Manage Customer");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(deleteCustomerBtn));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Delete Customer");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ConfirmDelete));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Confirm Delete Customer");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Success_Message));

		String msg =GetElementText(Success_Message);
		Assert.assertEquals(msg, "Selected customer(s) has been deleted successfully.");
		WaitUntillPAgeLoad();


	}
	public void NavigateToCustomer() throws InterruptedException {
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Customers));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customers");
	}

	public void SearchCustomer() throws InterruptedException {
		Thread.sleep(5000);
		writeText(Search,Fullname+Keys.ENTER);
		Thread.sleep(5000);

	}

	public void NavigateCustomerModule() throws InterruptedException {
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Customers));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customers");
		waitVisibility(FirstCustomer);
	}

	public void createNewCustomer() throws InterruptedException {
		//		ClickOnMinimizeCallwindow();
		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Customers));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customers");

		element = wait.until(ExpectedConditions.presenceOfElementLocated(NewCustomer));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on New Customers");
		//		waitForElement(6000);
//		if (ElementDisplayed(menu_bar)) {
//			click(menu_bar);
//			ExtentSuccessMessage("Successfully user Clicked on 'Menu bar' ");
//		}
		Thread.sleep(3000);
		FirstName ="lohith";
		Lastname = randomName();
		writeText(CustFName,FirstName);
		//		waitForElement(4000);
		writeText(CustLName,Lastname);		
		waitForElement(1000);
		if(ElementDisplayed(LeadDOB)) {
			writeText(LeadDOB, "01/01/2000"+Keys.ENTER);
		}
		waitForElement(2000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(ContactInfo));
		MoveToElementClick(element);


		ExtentSuccessMessage("Clicked on Contact Information");
		//		waitForElement(6000);
		writeText(Cellphone,"9876789678");
		//		waitForElement(6000);
		writeText(CustMail,"lohi.11@yopmail.com");
		//		waitForElement(6000);
		//		element = wait.until(ExpectedConditions.presenceOfElementLocated(PrincipalAdress));
		//		MoveToElementClick(element);
		////		waitForElement(6000);
		//		ExtentSuccessMessage("Clicked on PrincipalAddress");
		//		writeText(PricipalAD1,"Testing");
		//		ExtentSuccessMessage("Entered the Address");
		////		waitForElement(6000);
		//		writeText(PrincipalZipCode,"33233");
		////		waitForElement(6000);
		//		ExtentSuccessMessage("Entered the ZipCode");  
		//		element = wait.until(ExpectedConditions.presenceOfElementLocated(MailingAddress));
		//		MoveToElementClick(element);
		//		waitForElement(6000);	
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustSubmit));
		MoveToElementClick(element);
		waitForElement(6000);
		ExtentSuccessMessage("Clicked on Submit");	
		waitForElement(15000);
//		waitVisibility(confirmlead);


		//		WebElement element = driver.findElement();
		//
		//		// Check if the element is displayed
		if(ElementDisplayed(confirmlead)) {
			// Click on the element
			click(confirmlead);
		} else {
			System.out.println("Element is not displayed, so cannot click.");
		}
		Thread.sleep(8000);
		Fullname = FirstName+" "+Lastname;
		System.out.println("Fullname"+Fullname);
		//		writeText(Search,Fullname+Keys.ENTER);
		//		waitForElement(20000);		
		element = wait.until(ExpectedConditions.presenceOfElementLocated(FirstCustomer));
		MoveToElementClick(element);
		waitForElement(6000);
	}
	public void SearchCustomer(String Value) throws InterruptedException, AWTException {
		String Carriers="ADVANTICA";
		String Product="Medical";
		String CurrentYear="2018"; 
		String AgentNAme ="1Agent M13";
		waitVisibility(Search);
		clear(Search);
		writeText(Search,Value+Keys.ENTER);
		String[] ExpectedColnumname =Value.split(" ");
		Thread.sleep(7000);	
		if(ElementDisplayed(FirstCustomer)) {
			element = wait.until(ExpectedConditions.presenceOfElementLocated(FirstCustomer));
		}else {
			Thread.sleep(7000);	
		}
		if(ElementDisplayed(FirstCustomer)) {
			element = wait.until(ExpectedConditions.presenceOfElementLocated(FirstCustomer));
		}else {
			element = wait.until(ExpectedConditions.presenceOfElementLocated(NewCustomer));
			MoveToElementClick(element);
			ExtentSuccessMessage("Clicked on New Customers");
			FirstName =ExpectedColnumname[0];
			Lastname = ExpectedColnumname[1];
			writeText(CustFName,FirstName);
			writeText(CustLName,Lastname);		
			waitForElement(1000);
			if(ElementDisplayed(LeadDOB)) {
				writeText(LeadDOB, "01/01/2000"+Keys.ENTER);
			}
			waitForElement(2000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(ContactInfo));
			MoveToElementClick(element);
			ExtentSuccessMessage("Clicked on Contact Information");
			writeText(Cellphone,"9876789678");
//			writeText(CustMail,"lohi.11@yopmail.com");				
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CustSubmit));
			MoveToElementClick(element);
			waitForElement(6000);
			ExtentSuccessMessage("Clicked on Submit");
			waitVisibility(confirmlead);			
			if(ElementDisplayed(confirmlead)) {
				// Click on the element
				click(confirmlead);
			} else {
				System.out.println("Element is not displayed, so cannot click.");
			}
			Thread.sleep(8000);
			Fullname = FirstName+" "+Lastname;
			System.out.println("Fullname"+Fullname);
			clear(Search);
			writeText(Search,Fullname+Keys.ENTER);
			waitVisibility(FirstCustomer);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(FirstCustomer));
			MoveToElementClick(element);
			waitForElement(6000);
			createapolicy(Carriers,Product,CurrentYear,AgentNAme);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(BacktoCustomer));
			MoveToElementClick(element);
			waitForElement(6000);
			
		}
		
	}
	
	public String randomName() {
		String allowedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String ssn = "";
		String temp = RandomStringUtils.random(10, allowedChars);
		ssn = temp.substring(0, temp.length() - 5);
		return ssn;
	}
	public static String getCurrentDateFormatted() {
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		return currentDate.format(formatter);
	}
	public void createapolicy(String Carriers, String Product,String CurrentYear, String AgentNAme) throws InterruptedException, AWTException {    	
		//		waitForElement(4000);
		//		element = wait.until(ExpectedConditions.presenceOfElementLocated(Customerdropdown));
		//		MoveToElementClick(element);
		//		waitForElement(6000);
		//		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
		//		MoveToElementClick(element);
		//		ExtentSuccessMessage(" Lead has been clicked");

		RefreshPage();
		waitForElement(10000);
		ClickOnMinimizeCallwindow();
		element = wait.until(ExpectedConditions.presenceOfElementLocated( Policies));
		MoveToElementClick(element);
		ClickOnMinimizeCallwindow();
		element = wait.until(ExpectedConditions.presenceOfElementLocated( Create_Policy));
		MoveToElementClick(element);
		ExtentSuccessMessage(" Create Policy has been clicked");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ProductCategory1));
		MoveToElementClick(element);
		waitForElement(2000);
		SeleccteDropdown(Product);
		ExtentSuccessMessage("Product Category has been selected");
		String CurrentMonthNum = CurrentMonth();
		String Date = CurrentMonthNum+"/01/"+CurrentYear;
		System.out.println("Date:-"+Date);
		Premium_Date = getCurrentDateFormatted();
		waitForElement(3000);
		writeText(PolicyEFDate,Date);
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Carrier));
		MoveToElementClick(element);	
		waitForElement(1000);
		SeleccteDropdown(Carriers);
		ExtentSuccessMessage("Carrier has been selected");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CText));
		carrier_Name = element.getText();
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesType));
		MoveToElementClick(element);	
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesNew));
		MoveToElementClick(element);
		ExtentSuccessMessage("SalesType has been selected");
		Base_Class.RobotKeyOperation("TAB");	
		waitForElement(3000);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		By Status = By.xpath("(//md-select[@name='AssetStatus'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Status));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status");
		Thread.sleep(2000);
		By Active = By.xpath("(//md-option[@value='Active'])[3]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Active));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Active");
		//SelectActiveDropdown(PolicyStatus,"Active");
		ExtentSuccessMessage("PolicyStatus has been selected");
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Premium_Amount));
		MoveToElementClick(element);
		String Amount = "2000";
		writeText(Premium_Amount,Amount);
		element = wait.until(ExpectedConditions.presenceOfElementLocated( AOR_Search));
		MoveToElementClick(element);
		waitForElement(7000);
		click(AOR_Text);
		waitForElement(5000);
		Base_Class.RobotKeyOperation("CONTROL");
		waitForElement(3000);
		Base_Class.RobotKeyOperation("A");
		waitForElement(3000);
		Base_Class.RobotKeyOperation("BACKSPACE");
		StringSelection stringSelection = new StringSelection(AgentNAme);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		Base_Class.Paste();
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AOR_Textsearch));
		MoveToElementClick(element);
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Select_Agent));
		MoveToElementClick(element);
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(click_ok));
		MoveToElementClick(element);
		ExtentSuccessMessage("AOR has been selected");			
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicySubmit));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Policy submit");
		/*By Success_msg = By.xpath("//div[@id='divSuccesss']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Success_msg));
		String msg =GetElementText(Success_msg);
		Assert.assertEquals(msg, "Policy created successfully.");*/
		ExtentSuccessMessage("New policy has been created and validated");
		Thread.sleep(5000);



	}
	public void SeleccteDropdown(String Value) throws InterruptedException {
		By options = By.xpath("//*[contains(@class,'md-select-menu-container dropDown md-active md-clickable')]//*[contains(@class,'md-ink-ripple')][@aria-selected='false']//*[contains(text(),'"+Value+"')]");
		if (ElementDisplayed(options)) {
			click(options);
		}


	}


}