package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.BasePackage.Base_Class;

public class Commision_Validations extends BasePage {

	public Commision_Validations(WebDriver driver) {
		super(driver);
	}
	WebElement element;
	public String Premium_Date;
	public String carrier_Name;
	public String Customer_Fname;
	public String Customer_Lname;
	public String Customer_Name;
	Commission_Page Commission_Page=new Commission_Page(driver);

	//WebElement element;
	private By CTIMinimizeIcon = By.xpath("//a[@class='fa fa-minus right-al']");
	private By AddCommission = By.xpath("//*[@title='Add a row']");
	private By CommissionSetUp = By.xpath("//*[contains(@href,'commissions/commissionSetup')]");
	private By CommissionSetUpPageValidation = By.xpath("//*[@class='page-header']//*[text()='Commission Setup']");
	private By CommissionModule =By.xpath("//*[@class='box animate-box fade-in'][contains(@ng-show,\"isAccessible('Commissions\")]");
	private By PeriodDropdown =By.xpath("(//*[contains(@class,'dx-dropdowneditor-button dx-button-normal')])[1]");
	private By Product_CategoryDropdown =By.xpath("(//*[contains(@class,'dx-dropdowneditor-button dx-button-normal')])[2]");
	private By CommissionMethod= By.xpath("(//*[contains(@class,'dx-dropdowneditor-button dx-button-normal')])[7]");
	private By carrierDropdown =By.xpath("(//*[contains(@class,'dx-dropdowneditor-button dx-button-normal')])[3]");
	private By CommissionRate = By.xpath("//*[contains(@class,'dx-textbox dx-texteditor dx-editor-outlined dx-widget dx-texteditor-empty')]//input");
	private By SaveCommission =By.xpath("//a[@title='Save']");
	private By SuccessPopup = By.id("InfoDialogModal");
	private By SuccessOk =By.xpath("//*[@ng-click='infoModalCtrl.Close()']");
	private By CommissionPeriodDropdown=By.name("CRMCommissionPeriod");
	private By ProductCategoryDropdown=By.name("CRMProductCategory");
	private By carrierNameDropdown=By.name("CRMCommissionCarrierName");
	private By SearchCommission=By.xpath("//*[@ng-click='searchCommissionRates()']");
	private By DeleteCommission =By.xpath("//a[@title='Delete']");
	private By Deleteyes =By.xpath("//*[@aria-label='Yes']");
	private By Edit =By.xpath("//a[@title='Edit']");
	private By File_Action = By.xpath("//button[@id='com-setup-file-action-btn']");
	private By Import_Commission_Setup = By.xpath("//button[@id='import-commission-btn']");
	private By File_Upload= By.xpath("//div[@class='button select-btn ng-pristine ng-untouched ng-valid ng-empty']");
	private By Submit = By.xpath("(//button[normalize-space()='Submit'])[1]");
	private By Success_Message = By.xpath("//div[@id='divSuccess']");
	private By Create_Policy = By.xpath("//button[normalize-space()='Create Policy']");
	private By CText = By.xpath("(//span[@class='md-select-icon'])[2]");
	private By Premium_Amount =  By.xpath("(//input[@name='TotalResAmount'])[1]");
	

	By Customers = By.xpath("//a[@class='glyphicon fa fa-users']");
	By NewCustomer = By.xpath("//button[@id='newCustomerBtn']");
	By CustFName = By.xpath("(//input[@id='LeadFirstName'])[1]");
	By CustLName = By.xpath("(//input[@id='LeadLastName'])[1]");
	//    By ContactInfo = By.xpath("(//div[@class='accordion-container'])[2]");
	By ContactInfo = By.xpath("//*[@id=\"page-wrapper\"]/div/ui-view/div[8]/ng-include/div[3]/div/div[2]/div/div[1]/div[5]/i");
	By Cellphone = By.xpath("(//input[@name='CellPhone'])[1]");
	By CustMail = By.xpath("(//input[@name='Email'])[1]");

	By Policies= By.xpath("(//a[@role='tab'][normalize-space()='Policies'])[1]");


	By PrincipalAdress = By.xpath("//*[@id=\"page-wrapper\"]/div/ui-view/div[8]/ng-include/div[3]/div/div[2]/div/div[1]/div[8]/i");
	By PricipalAD1 = By.xpath("//input[@id='AddressLine1']");
	By PrincipalZipCode = By.xpath("//input[@name='ZipCode']");
	By MailingAddress = By.xpath("(//input[@type='checkbox'])[2]");
	By CustSubmit = By.xpath("(//button[text()='Submit'])[3]");


	By ClickLead = By.xpath("//a[@class='edit-list-anchor ng-binding']");
	By SalesButton  = By.xpath("//a[@id='menu_Sales']");
	By SalesQuote = By.xpath("(//a[text()='Quotes'])[2]");

	By CustcreateOpp = By.xpath("(//button[@class='btn btn-default pull-right ng-binding ng-scope'])[2]");
	By CustOppSubmit = By.xpath("(//button[@class='btn btn-default green'])[3]");
	By SalesOpportunities =By.xpath("//a[@id='submenu_salesopportunities']");
	By Customerdropdown = By.xpath("//a[@id='menu_customers']");


	By PolicySubmit = By.xpath("//button[@ng-show=\"accountType !=='Group'\"]");
	By ProductCategory1 = By.xpath("(//md-select[@id='CRMProductCategory'])[1]");//(//div[@class='md-text'] [contains(text(),'Cancer/Critical Illness')])[2]
	By AccidentLOB = By.xpath("(//div[@class='md-text'] [contains(text(),'Cancer/Critical Illness')])[2]"); 
	By Carrier = By.xpath("//md-select[@id='Carrier']");
	By SelectCarrier = By.xpath("(//div[@class='md-text'][normalize-space()='ADVANTICA'])[2]");
	By SalesType = By.xpath("//md-select[@id='salesType']");
	By SalesNew = By.xpath("(//md-option[@value='New'])[2]");
	By PolicyStatus = By.xpath("//md-select[@id='AssetStatus']");
	By PolicyActive = By.xpath("(//div[@class='md-text'][normalize-space()='Active'])[3]");
	By PolicyEFDate = By.xpath("//input[@id='EffectiveDate']");
	By PolicyAOR = By.xpath("(//button[@class='btn btn-default green']/child::i)[3]");
	By AoRSearchText = By.xpath("//input[@ng-model='searchText']");
	By AORSearchIcon = By.xpath("//button[@title='Search Agent Name']");
	By SelectAOR = By.xpath("//input[@name='selectedAgent']");
	By AorOk = By.xpath("//button[text()='OK']");

	public void ClickOnMinimizeCallwindow() throws InterruptedException {
		Thread.sleep(2000);
		if (ElementDisplayed(CTIMinimizeIcon)) {
			ExtentSuccessMessage("Successfully user able to See 'Minimize Icon' ");
			click(CTIMinimizeIcon);
			ExtentSuccessMessage("Successfully user Clicked on 'Minimize Icon' ");
		} else {
			ExtentSuccessMessage("Unsuccessfully 'Minimize' Not visible");
		}
	}

	public void hoverOnCommissionModule() throws InterruptedException {
		Thread.sleep(15000);
		ClickOnMinimizeCallwindow();
		MouseHoverOnElement(CommissionModule);
		//		if (ElementDisplayed(CommissionModule)) {
		//			ExtentSuccessMessage("Successfully user able to See 'Commission module Icon' ");
		//			MouseHoverOnElement(CommissionModule);
		ExtentSuccessMessage("Successfully user Hover on 'Commission module Icon' ");
		//		} else {
		////			ExtentErrorMessage("Unsuccessfully 'Commission module Icon' Not visible");
		//			RefreshPage();
		//			Thread.sleep(15000);
		//			waitVisibility(CommissionModule);
		//			if (ElementDisplayed(CommissionModule)) {
		//				ExtentSuccessMessage("Successfully user able to See 'Commission module Icon' ");
		//				MouseHoverOnElement(CommissionModule);
		//				ExtentSuccessMessage("Successfully user Hover on 'Commission module Icon' ");
		//			} else {
		//				ExtentErrorMessage("Unsuccessfully 'Commission module Icon' Not visible");
		//			}
		//		}
	}


	public String randomName() {
		String allowedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String ssn = "";
		String temp = RandomStringUtils.random(10, allowedChars);
		ssn = temp.substring(0, temp.length() - 5);
		return ssn;
	}

	public static String getFutureDate(int daysInFuture) {

		LocalDate currentDate = LocalDate.now();
		LocalDate futureDate = currentDate.plusDays(daysInFuture);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");


		return futureDate.format(formatter);
	}
	public void waitForElement(int time) throws InterruptedException {
		Thread.sleep(time);
	}

	public static String getCurrentDateFormatted() {
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		return currentDate.format(formatter);
	}

	public void ValidateCommissionSetupTab() throws InterruptedException {
		//		Thread.sleep(25000);
		WaitUntillPAgeLoad();
		click(CommissionSetUpPageValidation);
		if (ElementDisplayed(CommissionSetUpPageValidation)) {
			ExtentSuccessMessage("Successfully user Landed on 'Commission Set up ' ");			
		} else {
			ExtentSuccessMessage("Unsuccessfully user Not Loanded on 'Commission Set up '' ");
		}
	}

	public void ClickOnDeleteCommission() throws InterruptedException {		
		if (ElementDisplayed(DeleteCommission)) {
			ExtentSuccessMessage("Successfully user able to See 'Delete Commission Icon' ");
			click(DeleteCommission);
			ExtentSuccessMessage("Successfully user Clicked on 'Delete Commission Icon' ");
			click(Deleteyes);
			ExtentSuccessMessage("Successfully user Clicked on 'Delete Commission Yes Icon' ");	
			
		} else {
			ExtentErrorMessage("Unsuccessfully 'Delete Commission icon' Not visible");
		}
	}
	public void ClickOnDeleteCommission1() throws InterruptedException {
		Thread.sleep(5000);
		if (ElementDisplayed(DeleteCommission)) {
			ExtentSuccessMessage("Successfully user able to See 'Delete Commission Icon' ");
			Thread.sleep(2000);
			click(DeleteCommission);
			ExtentSuccessMessage("Successfully user Clicked on 'Delete Commission Icon' ");
			Thread.sleep(2000);
			click(Deleteyes);
			ExtentSuccessMessage("Successfully user Clicked on 'Delete Commission Yes Icon' ");			
		} else {
			ExtentSuccessMessage("Unsuccessfully 'Delete Commission icon' Not visible");
		}
		Thread.sleep(5000);
		
	}

	public void ClickOnCommissionSetUp() throws InterruptedException {
		//		Thread.sleep(25000);
		click(CommissionSetUp);
		//		if (ElementDisplayed(CommissionSetUp)) {
		//			ExtentSuccessMessage("Successfully user able to See 'Commission Set Up' ");
		//			click(CommissionSetUp);
		ExtentSuccessMessage("Successfully user Clicked on 'Commission Set Up' ");
		ValidateCommissionSetupTab();
		//		} else {
		//			ExtentSuccessMessage("Unsuccessfully 'Commission Set Up' Not visible");
		//		}
	}

	public void NavvigateToCommissionSetUp() throws InterruptedException {
		hoverOnCommissionModule();
		ClickOnCommissionSetUp();
	}
	public void SelectActiveDropdown (By by, String value) throws InterruptedException {
		if(ElementDisplayed(by)) {
			click(by);
			Thread.sleep(2000);
			By options = By.xpath("//*[contains(@class,'dropDown md-active md-clickable')]//*[@value='"+value+"']");
			if(ElementDisplayed(options)) {
				click(options);
				ExtentSuccessMessage("Successfully user found and clicked on the "+value+" value inside the dropdown ");
			}
		}else {
			ExtentErrorMessage("UnSuccessfully user not found and clicked on the "+value+" value inside the dropdown ");
		}

	}

	public void ClickOnSearchCommission() throws InterruptedException {		
		if (ElementDisplayed(SearchCommission)) {
			ExtentSuccessMessage("Successfully user able to See 'Search Commission Icon' ");
			click(SearchCommission);
			ExtentSuccessMessage("Successfully user Clicked on 'Search Commission Icon' ");
		} else {
			ExtentErrorMessage("Unsuccessfully 'Save Commission icon' Not visible");
		}
		Thread.sleep(5000);
	}




	public void Commission_Import() throws InterruptedException, AWTException
	{
		NavvigateToCommissionSetUp();
		Thread.sleep(2000);
		String Carrier = "ADVANTICA";
		String Product_Category ="Cancer/Critical Illness";
		String CurrentYear = "2018";
		SelectActiveDropdown(CommissionPeriodDropdown,CurrentYear);
		SelectActiveDropdown(ProductCategoryDropdown, Product_Category);
		SelectActiveDropdown(carrierNameDropdown, Carrier);
		ClickOnSearchCommission();
		ClickOnDeleteCommission1();

//waitVisibility(File_Action);
		click(File_Action);
		click(Import_Commission_Setup);
		ExtentSuccessMessage("Clicked on Import Commission setup dropdown");
		waitForElement(2000);
		click(File_Upload);

		Robot robot = new Robot();
		String filePath = System.getProperty("user.dir") + "\\Upload\\Commission-Setup-Criteria-07122024.xlsx";
		StringSelection stringSelection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		robot.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);

		robot.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);

		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		ExtentSuccessMessage("File is been Uploaded");
		waitForElement(10000);

		click(Submit);
		ExtentSuccessMessage("Clicked on submit button");

		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Success_Message));
		ExtentSuccessMessage("Success Mesage has been validated ");
		waitForElement(10000);






	}
	public void ValidatetheGrid(String Values) throws InterruptedException {

		String[] ExpectedColnumname =Values.split(",");
		for(int i=0;i<=7;i++) {
			int j = i+2;
			Thread.sleep(2000);
			By Elements =By.xpath("//td[@role='gridcell'][@aria-colindex='"+j+"']");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Elements));
			String ActualColunmName =element.getText();



			if (ActualColunmName.isBlank()) {
				System.out.println("Actual Column Name is blank.");
				Base_Class.ScrollUntilElementVisible(Elements);
				element = wait.until(ExpectedConditions.presenceOfElementLocated(Elements));
				Thread.sleep(3000);
				String ColunmName =element.getText();
				Assert.assertEquals(ExpectedColnumname[i], ColunmName);
				ExtentSuccessMessage("Successfully user found the expected Colunm name:- Expected "+ExpectedColnumname[i]+" Actual "+ColunmName+"");
			} else {
				if(ActualColunmName.contains("PMPM")){
					ActualColunmName = "Per Member Per Month";
					System.out.println("Actual Column Name: " + ActualColunmName);
					System.out.println("ActualColunmName"+j+""+ActualColunmName);
					Assert.assertEquals(ExpectedColnumname[i], ActualColunmName);
					ExtentSuccessMessage("Successfully user found the expected Colunm name:- Expected "+ExpectedColnumname[i]+" Actual "+ActualColunmName+"");

				}else {
					System.out.println("Actual Column Name: " + ActualColunmName);
					System.out.println("ActualColunmName"+j+""+ActualColunmName);
					Assert.assertEquals(ExpectedColnumname[i], ActualColunmName);
					ExtentSuccessMessage("Successfully user found the expected Colunm name:- Expected "+ExpectedColnumname[i]+" Actual "+ActualColunmName+"");

				}
			}


		}

	}


	public void Import_Validation() throws InterruptedException
	{
		waitForElement(10000);
		String Carrier = "ADVANTICA";
		String Product_Category ="Cancer/Critical Illness";
		String CurrentYear = "2018";
		String CommissionRate ="150.00";
		String Commissionmethod = "Per Member Per Month";
		SelectActiveDropdown(CommissionPeriodDropdown,CurrentYear);
		SelectActiveDropdown(ProductCategoryDropdown, Product_Category);
		SelectActiveDropdown(carrierNameDropdown, Carrier);
		ClickOnSearchCommission();
		String Values = (CurrentYear+","+Product_Category+","+Carrier+","+"All"+","+"All"+","+"All"+","+Commissionmethod+","+CommissionRate);
		ValidatetheGrid(Values);
		ClickOnDeleteCommission();	

	}

	public void createNewCustomer() throws InterruptedException {
		waitForElement(20000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Customers));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customers");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NewCustomer));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on New Customers");
		Customer_Fname ="Rohith";
		writeText(CustFName,Customer_Fname);
//		waitForElement(4000);

		Customer_Lname = randomName();

		writeText(CustLName,Customer_Lname );
		Customer_Name = Customer_Fname +" "+ Customer_Lname;
		System.out.println(Customer_Name);

//		waitForElement(6000);
		//		 By dob = By.xpath("(//input[@id='LeadDob'])[1]");
		//		 
		//		
		//		 writeText(dob,"12/12/2001" +Keys.ENTER);

//		waitForElement(6000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(ContactInfo));
		MoveToElementClick(element);


		ExtentSuccessMessage("Clicked on Contact Information");
//		waitForElement(6000);
		writeText(Cellphone,generatePhoneNumber());
//		waitForElement(6000);
		writeText(CustMail,"lohi.11@yopmail.com");
//		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PrincipalAdress));
		MoveToElementClick(element);
//		waitForElement(6000);
		ExtentSuccessMessage("Clicked on PrincipalAddress");
		writeText(PricipalAD1,"Testing");
		ExtentSuccessMessage("Entered the Address"); 
//		waitForElement(6000);
		writeText(PrincipalZipCode,"33233");
//		waitForElement(6000);
		ExtentSuccessMessage("Entered the ZipCode");  
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MailingAddress));
		MoveToElementClick(element);
//		waitForElement(6000);	 
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustSubmit));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Submit");
		waitForElement(18000);	
		WebElement element = driver.findElement(By.xpath("//button[contains(text(),'Proceed with Customer creation')]"));

		// Check if the element is displayed
		if(element.isDisplayed()) {
			// Click on the element
			element.click();
		} else {
			System.out.println("Element is not displayed, so cannot click.");
		}

	}

	public void CheckSuccessPopup() throws InterruptedException {
		Thread.sleep(3000);
		if (ElementDisplayed(SuccessOk)) {
			ExtentSuccessMessage("Successfully user able to See 'Success Popup' ");
			//			String Message = GetElementText(SuccessPopup);
			//			System.out.println("SuccessPopup:"+SuccessPopup);
			click(SuccessOk);
			ExtentSuccessMessage("Successfully user Clicked on 'Success Ok' ");
		} else {
			ExtentErrorMessage("Unsuccessfully 'Success Popup' Not visible");
		}
	}
	public void ClickOnSaveCommission() throws InterruptedException {		
		if (ElementDisplayed(SaveCommission)) {
			ExtentSuccessMessage("Successfully user able to See 'Save Commission Icon' ");
			click(SaveCommission);
			ExtentSuccessMessage("Successfully user Clicked on 'Save Commission Icon' ");
			CheckSuccessPopup();
		} else {
			ExtentErrorMessage("Unsuccessfully 'Save Commission icon' Not visible");
		}
	}

	public void ClickOnAddCommission() throws InterruptedException {		
		if (ElementDisplayed(AddCommission)) {
			ExtentSuccessMessage("Successfully user able to See 'AddCommission Icon' ");
			click(AddCommission);
			ExtentSuccessMessage("Successfully user Clicked on 'AddCommission Icon' ");
		} else {
			ExtentSuccessMessage("Unsuccessfully 'AddCommission' Not visible");
		}
	}
	public void ClickOnPeriodDropdown() throws InterruptedException {		
		if (ElementDisplayed(PeriodDropdown)) {
			ExtentSuccessMessage("Successfully user able to See 'Period Dropdown' ");
			click(PeriodDropdown);
			ExtentSuccessMessage("Successfully user Clicked on 'Period Dropdown' ");
		} else {
			ExtentSuccessMessage("Unsuccessfully 'PeriodDropdown' Not visible");
		}
	}

	public void SelectThedropdown(String Year) throws InterruptedException {

		By Elements=By.xpath("//*[contains(@class,'dx-item dx-list-item')][@aria-selected='true']//*[@title='All']");

		By options =By.xpath("//*[contains(@class,'dx-item dx-list-item')][@aria-selected='false']//*[@title='"+Year+"']");
		if(ElementDisplayed(Elements)) {
			click(Elements);
			ExtentSuccessMessage("Successfully user unchecked the existing value from dropdow");
			click(options);
			ExtentSuccessMessage("Successfully user Checked the new "+Year+" value from dropdow");
		}else {
			By Elementsdd=By.xpath("(//*[contains(@class,'dx-item dx-list-item')][@aria-selected='true'])[1]");
			if(ElementDisplayed(Elementsdd)) {
				click(Elementsdd);
			}

			click(options);
			ExtentSuccessMessage("Successfully user Checked the new "+Year+" value from dropdow");
		}

	}

	public void ClickOnProduct_CategoryDropdown() throws InterruptedException {		
		if (ElementDisplayed(Product_CategoryDropdown)) {
			ExtentSuccessMessage("Successfully user able to See 'Product_Category Dropdown' ");
			click(Product_CategoryDropdown);
			ExtentSuccessMessage("Successfully user Clicked on 'Product_Category Dropdown' ");
		} else {
			ExtentSuccessMessage("Unsuccessfully 'Product_Category Dropdown' Not visible");
		}
	}

	public void ClickOncarrierDropdown() throws InterruptedException {		
		if (ElementDisplayed(carrierDropdown)) {
			ExtentSuccessMessage("Successfully user able to See 'Carrier Dropdown' ");
			click(carrierDropdown);
			ExtentSuccessMessage("Successfully user Clicked on 'Carrier Dropdown' ");
		} else {
			ExtentSuccessMessage("Unsuccessfully 'Carrier Dropdown' Not visible");
		}
	}

	public void ClickOnCommissionMethod() throws InterruptedException {		
		if (ElementDisplayed(CommissionMethod)) {
			ExtentSuccessMessage("Successfully user able to See 'CommissionMethod Dropdown' ");
			click(CommissionMethod);
			ExtentSuccessMessage("Successfully user Clicked on 'CommissionMethod Dropdown' ");
		} else {
			ExtentSuccessMessage("Unsuccessfully 'CommissionMethod dropdown' Not visible");
		}
	}

	public void EnterCommissionRate(String value) throws InterruptedException {		
		if (ElementDisplayed(CommissionRate)) {
			ExtentSuccessMessage("Successfully user able to See 'CommissionRate ' ");
			writeText(CommissionRate,value);
			ExtentSuccessMessage("Successfully user entered the 'CommissionRate in text field' "+value);
		} else {
			ExtentErrorMessage("Unsuccessfully 'CommissionRate' Not visible");
		}
	}
	public void validate_Commission_set_up_with_the_following_options() throws InterruptedException {
		NavvigateToCommissionSetUp();
		ClickOnAddCommission();
		int Years=2024;
		String CurrentYear = Integer.toString(Years);
		ClickOnPeriodDropdown();
		SelectThedropdown(CurrentYear);
		ClickOnProduct_CategoryDropdown();
		String Product_Category ="Dental";
		SelectThedropdown(Product_Category);
		String Carrier = "Aetna";
		ClickOncarrierDropdown();
		SelectThedropdown(Carrier);
		String Commissionmethod = "Per Member Per Year";
		ClickOnCommissionMethod();
		SelectThedropdown(Commissionmethod);
		String CommissionRate ="99.00";
		EnterCommissionRate(CommissionRate);
		ClickOnSaveCommission();
		SelectActiveDropdown(CommissionPeriodDropdown,CurrentYear);
		SelectActiveDropdown(ProductCategoryDropdown, Product_Category);
		SelectActiveDropdown(carrierNameDropdown, Carrier);
		ClickOnSearchCommission();
		String Values = (CurrentYear+","+Product_Category+","+Carrier+","+"All"+","+"All"+","+"All"+","+Commissionmethod+","+CommissionRate);
		ValidatetheGrid(Values);
		ClickOnDeleteCommission();
		System.out.println("");

	}

	public void Import_Commision_Percentage() throws InterruptedException, AWTException
	{
		NavvigateToCommissionSetUp();
		Thread.sleep(2000);
		click(File_Action);
		click(Import_Commission_Setup);
		ExtentSuccessMessage("Clicked on Import Commission setup dropdown");
		waitForElement(2000);
		click(File_Upload);

		Robot robot = new Robot();
		String filePath = System.getProperty("user.dir") + "\\Upload\\Commission-Setup-Criteria-Percentage.xlsx";//Upload/Commission-Setup-Criteria-Percentage.xlsx
		StringSelection stringSelection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		robot.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);

		robot.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);

		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		ExtentSuccessMessage("File is been Uploaded");
		waitForElement(10000);

		click(Submit);
		ExtentSuccessMessage("Clicked on submit button");

		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Success_Message));
		ExtentSuccessMessage("Success Mesage has been validated ");

	}

	public void Home_Page_Redirection() throws InterruptedException
	{
		waitForElement(1000);
		By Home_Page = By.xpath("(//a[@id='menu_home'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Home_Page));
		MoveToElementClick(element);
		ExtentSuccessMessage("Redirected to home page");
	}

	public void Create_Policy() throws InterruptedException, AWTException
	{
//		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Customerdropdown));
		MoveToElementClick(element);
//		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
		MoveToElementClick(element);
		ExtentSuccessMessage(" Lead has been clicked");
		RefreshPage();
		waitForElement(10000);
		ClickOnMinimizeCallwindow();
		element = wait.until(ExpectedConditions.presenceOfElementLocated( Policies));
		MoveToElementClick(element);
		ClickOnMinimizeCallwindow();
//		waitForElement(8000);

//		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated( Create_Policy));
		MoveToElementClick(element);
		ExtentSuccessMessage(" Create Policy has been clicked");
//		waitForElement(6000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(ProductCategory1));
		MoveToElementClick(element);

//		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(AccidentLOB));
		MoveToElementClick(element);
		ExtentSuccessMessage("Medical has been selected");
//		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Carrier));
		MoveToElementClick(element);	
		waitForElement(1000);		
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectCarrier));
		MoveToElementClick(element);
		ExtentSuccessMessage("Carrier has been selected");

	
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CText));
		carrier_Name = element.getText();
		System.out.println(carrier_Name);



//		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesType));
		MoveToElementClick(element);	
//		waitForElement(3000);		
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesNew));
		MoveToElementClick(element);
		ExtentSuccessMessage("SalesType has been selected");
//		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyStatus));
		MoveToElementClick(element);	
//		waitForElement(2000);		
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyActive));
		MoveToElementClick(element);
		ExtentSuccessMessage("PolicyStatus has been selected");
//		waitForElement(8000);

		Premium_Date = getCurrentDateFormatted();
		writeText(PolicyEFDate,Premium_Date +Keys.ENTER);
//		waitForElement(8000);
		
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Premium_Amount));
		MoveToElementClick(element);
		String Amount = "2000";
		writeText(Premium_Amount,Amount);
		String AgentNAme="Agent M12";

		By AOR_Search = By.xpath("//button[@ng-click=\"$parent.aorSearchLookup('AgentName', 'CreateAssetForm')\"]//i[@class='glyphicon glyphicon-search']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated( AOR_Search));
		MoveToElementClick(element);
		waitForElement(8000);
		By AOR_Text = By.xpath("//input[contains(@class,'pull-right ng-pristine ng-untouched ng-valid ')]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated( AOR_Search));
		waitForElement(8000);
		click(AOR_Text);
		Base_Class.RobotKeyOperation("CONTROL");
		Base_Class.RobotKeyOperation("A");
		Base_Class.RobotKeyOperation("BACKSPACE");
		//			clear(AOR_Text);
		//			Robot robot = new Robot();
		//			String filePath = System.getProperty("user.dir") + ""+filepaths+"";
		StringSelection stringSelection = new StringSelection(AgentNAme);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		Base_Class.Paste();
		waitForElement(5000);
		//			element = wait.until(ExpectedConditions.presenceOfElementLocated( AOR_Search));
		//			MoveToElementClick(element);
		//			writeText(AOR_Text,AgentNAme);
		By AOR_Textsearch = By.xpath("(//i[@class='glyphicon glyphicon-search'])[5]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AOR_Textsearch));
		MoveToElementClick(element);
		waitForElement(5000);
		By Select_Agent = By.xpath("(//input[@name='selectedAgent'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Select_Agent));
		MoveToElementClick(element);
		waitForElement(1000);
		By click_ok = By.xpath("//button[normalize-space()='OK']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(click_ok));
		MoveToElementClick(element);

		//			By AOR_Search = By.xpath("//button[@ng-click=\"$parent.aorSearchLookup('AgentName', 'CreateAssetForm')\"]//i[@class='glyphicon glyphicon-search']");
		//			element = wait.until(ExpectedConditions.presenceOfElementLocated( AOR_Search));
		//			MoveToElementClick(element);
		//			waitForElement(8000);
		//			By AOR_Text = By.xpath("//input[@class='pull-right ng-pristine ng-untouched ng-valid ng-empty']");
		//			element = wait.until(ExpectedConditions.presenceOfElementLocated( AOR_Search));
		//			writeText(AOR_Text,"Agent M12");
		//			By AOR_Textsearch = By.xpath("(//i[@class='glyphicon glyphicon-search'])[5]");
		//			element = wait.until(ExpectedConditions.presenceOfElementLocated(AOR_Textsearch));
		//			MoveToElementClick(element);
		//			waitForElement(8000);
		//			By Select_Agent = By.xpath("(//input[@name='selectedAgent'])[1]");
		//			element = wait.until(ExpectedConditions.presenceOfElementLocated(Select_Agent));
		//			MoveToElementClick(element);
		//			waitForElement(1000);
		//			By click_ok = By.xpath("//button[normalize-space()='OK']");
		//			element = wait.until(ExpectedConditions.presenceOfElementLocated(click_ok));
		//			MoveToElementClick(element);


		ExtentSuccessMessage("AOR has been selected");			
		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicySubmit));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Policy submit");
		waitForElement(2000);
		By Success_msg = By.xpath("//div[@id='divSuccesss']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Success_msg));
		ExtentSuccessMessage("New policy has been created and validated the success message");

	}

	public void recaluculate() throws InterruptedException
	{
		NavvigateToCommissionSetUp();

		By Caluculate = By.xpath("(//button[normalize-space()='Recalculate'])[1]");
		click(Caluculate);

		waitForElement(1000);
		By Policy_created_checkbox = By.xpath("(//div[@class='md-off'])[1]");
		click(Policy_created_checkbox);

		By Startdate = By.xpath("//input[@ng-model='assetDate.assetStartDate']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Startdate));
		writeText(Startdate,getCurrentDateFormatted());

		By EndDate = By.xpath("//input[@ng-model='assetDate.assetEndDate']");
		//getFutureDate
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EndDate));
		String Futuredate = ""+getFutureDate(30);
		writeText(EndDate,Futuredate);

		By Run = By.xpath("(//button[normalize-space()='Run'])[1]");
		click(Run);

		ExtentSuccessMessage("Recaluculated the commission");

	}

	public void Reports_Validation() throws InterruptedException, AWTException
	{
		//		By Report = By.xpath("//a[@id='menu_reports']");
		//		click(Report);
		//		Thread.sleep(5000);
		//		By Commission_Report = By.xpath("//*[@aria-label='Commission Reports']");
		//		element = wait.until(ExpectedConditions.presenceOfElementLocated((Commission_Report)));
		//		MoveToElementClick(element);
		//		ExtentSuccessMessage("Clicked on commission reports");
		//		Thread.sleep(5000);
		//		
		//		
		//		//
		//		
		//		
		//		By Agent_Projections = By.xpath("//*[@aria-label='Agent Projections']");
		//		element = wait.until(ExpectedConditions.presenceOfElementLocated((Agent_Projections)));
		//		MoveToElementClick(element);
		//		ExtentSuccessMessage("Clicked on Agent projections");
		Commission_Page.ClickONReportTab();
		Commission_Page.ClickONCommissiionReportunderreportTab();
		Commission_Page.ClickONAgent_ProjectionsunderreportTab();
		Thread.sleep(5000);

		By Carrier_DD = By.xpath("(//span[@class='md-select-icon'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated((Carrier_DD)));
		MoveToElementClick(element);

		By Uncheck_ALL = By.xpath("(//div[@class='md-text ng-binding'][normalize-space()='All'])[4]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated((Uncheck_ALL)));
		MoveToElementClick(element);

		By Check_Carrier = By.xpath("(//div[normalize-space()='ADVANTICA'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated((Check_Carrier)));
		MoveToElementClick(element);

		By click_year= By.xpath("(//span[@class='md-select-icon'])[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated((click_year)));
		MoveToElementClick(element);

		By Select_Year = By.xpath("(//div[@class='md-text ng-binding'][normalize-space()='2024'])[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated((Select_Year)));
		MoveToElementClick(element);

		By Click_Agent= By.xpath("(//div[@class='md-text ng-binding'][normalize-space()='2024'])[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated((Click_Agent)));
		MoveToElementClick(element);

		By UnselectAll_Agent = By.xpath("(//div[@class='md-text ng-binding'][normalize-space()='All'])[3]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated((UnselectAll_Agent)));
		MoveToElementClick(element);


		By select_Agent = By.xpath("(//div[normalize-space()='Agent M12'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated((select_Agent)));
		MoveToElementClick(element);
		ExtentSuccessMessage("Filter criteria has been set");


		By run = By.xpath("(//button[@id='runReportBtn'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated((run)));
		MoveToElementClick(element);
		ExtentSuccessMessage("Report is running");


	}
}
