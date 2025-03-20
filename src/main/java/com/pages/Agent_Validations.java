package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Agent_Validations extends BasePage {

	public Agent_Validations(WebDriver driver) {
		super(driver);
	}

	JavascriptExecutor js = (JavascriptExecutor) driver;
	WebElement element;
	Agent360Page Agent360Page =new Agent360Page(driver);
	public String AgentText;
	public String AgentMailId;
	public String GetLicense_Number;
	public String Iss_Date;
	public String LicenseExpiryDate;
	public String NoteText;

	//	public void (int time) throws InterruptedException {
	//		(time);
	//	}


	private By AgentPrefix= By.xpath("//md-select[@name='Prefix']");
	private By CTIMinimizeIcon = By.xpath("//a[@class='fa fa-minus right-al']");
	private By AgentPrefixOption = By.xpath("//div[text()='Mr.']");
	private By NewAgentFirstName = By.name("FirstName");
	private By NewAgentLastName = By.name("LastName");
	private By AgencyType = By.xpath("//md-select[@name='AgencyType']");
	private By AgencyTypeOption = By.xpath("//md-option[@value='Agent']");
	private By AgentLicenseNumber = By.xpath("//input[@name='StateLicenseNumber']");
	private By AgentStatus = By.xpath("(//md-select[@name='Status'])[3]");
	private By AgentStatusOption = By.xpath("(//md-option[@value='Active'])[3]");
	private By AgentContactInformationSection = By.xpath("(//i[@class='acc glyphicon glyphicon-plus'])[4]");
	private By AgentPhoneNumber = By.xpath("//input[@name='Phone']");
	private By AgentEmailId = By.xpath("//input[@name='Email']");
	private	By AgentType = By.xpath("(//span[normalize-space()='Internal'])[1]");
	private By PimaryAddressInfoSection = By.xpath("(//i[@role='button'])[7]");
	private By AgentAddress = By.cssSelector("input[name='AddressLine1']");
	private By AgentZipcode = By.xpath("//input[@name='ZipCode']");
	private By MailinhAddressCheckBox = By.xpath("//input[@ng-model='confirmedCheck']");
	private By AgentSearchBar = By.xpath("//*[@aria-label='Search your text']");

	private By AgentSubmitButton = By.xpath("//button[@name='saveAgentdetailsButton']");
	private By AgentSearchField = By.xpath("//input[@role='combobox']");
	private By AgentFormList = By.xpath("//a[@class='edit-list-anchor ng-binding']");
	private By AgentLicenseButton = By.xpath("(//button[@class='btn btn-default pull-right ng-binding ng-scope'])[2]");
	private By StateDD = By.xpath("//md-select[@name='State']");
	private By DDValue = By.xpath("//md-option[@value='AK']");
	private By IssuedDate = By.xpath("//input[@name='IssuedDate']");
	private By ExpiryDate = By.xpath("//input[@name='ExpirationDate']");
	private By AgencyTile = By.xpath("//a[@class='glyphicon fa fa-building']");
	private By AgencyAgent= By.xpath("(//a[contains(.,'Agents')])[1]");
	private By NewAgentButton=By.id("createNewAgentBtn");
	private By License_Tab = By.xpath("(//a[normalize-space()='Licenses'])[1]//parent::li | (//a[normalize-space()='Licenses'])[1]");
	private By Click_Agent = By.xpath("//a[@class='edit-list-anchor ng-binding']");
	private By Create_License = By.id("StateLicenses");

	private By StatusDD = By.xpath("(//md-select[@role='listbox'])[3]");
	private By StatusDDOption = By.xpath("(//div[@class='md-text ng-binding'][normalize-space()='Active'])[1]");
	private By SubmitLicenseButton = By.xpath("//button[@name='SaveStateLicenseBtn']");
	private By LicenseSection = By.xpath("//a[text()=' Licenses']");

	private By CarrierAgentAppointmentButton = By.xpath("//button[@name='newAgentAppointmentBtn'] | //button[@name='CarrierAppointments']");
	private By CarrierAgentNameDD = By.xpath("//md-select[@name='AgentName']");
	private By CarrierAgentNameOption = By.xpath("(//div[contains(.,'CEUser one')])[15]");

	private By CarrierStateDDOption = By.xpath("//div[text()='CT']");
	private By AppointmentCarrierSubmitButton = By.xpath("//button[@name='saveAgentAppointmentBtn']");
	private By CarrierAgentStatusOption = By.xpath("//div[text()='Active']");
	private By CarrierAgentStatusDD = By.xpath("//md-select[@name='AgentStatus']");
	private By State = By.xpath("(//div[@title='AK'])[1]");
	private By Product_Category = By.xpath("(//div[@title='All'])[1]");
	private By Recent_Agents = By.xpath("(//i[@role='button'])[1]");
	private By Agent_Type = By.xpath("(//i[@role='button'])[2]");
	private By Status = By.xpath("(//i[@role='button'])[3]");
	private By States = By.xpath("(//i[@role='button'])[4]");
	private By Agency_Type = By.xpath("(//i[@role='button'])[5]");

	private By NotesSection = By.xpath("//textarea[@class='form-control ng-pristine ng-untouched ng-isolate-scope ng-empty ng-invalid ng-invalid-required ng-valid-maxlength']");
	private By NotesConfirmationButton = By.xpath("(//button[@class='btn btn-default icons text-center ng-isolate-scope'])[2]");
	private By ActionEmailIcon = By.xpath("(//i[@class='fa fa-envelope'])[2]");
	private By AddEmailAddressCheckBox = By.xpath("//md-chips[@placeholder='Add email address']");
	private By AgentActionNoteInc = By.xpath("//u[@class='item_to_highlight ng-binding']");
	private By AgentEmailInc = By.xpath("(//u[@class='ng-binding'])[1]");
	private By DocumentAttachFileButton = By.xpath("//div[@class='btn btn-primary ng-pristine ng-untouched ng-valid ng-isolate-scope ng-empty']");
	private By AttachmentConfirmationButton = By.xpath("(//button[@class='btn btn-default icons text-center ng-isolate-scope'])[2]");
	private By ActionTask = By.xpath("(//i[contains(@class,'fa fa-calendar')])[1]");
	private By ActivityDD = By.xpath("(//select[@class='form-control ng-pristine ng-untouched ng-valid ng-not-empty'])[1]");
	private By PriorityDD = By.xpath("//*[@id=\"filter-by\"]/div[1]/form/div[5]/select");
	private By CommentTextArea = By.xpath("//textarea[@class='form-control comments ng-pristine ng-untouched ng-valid ng-empty ng-valid-maxlength']");
	private By TaskConfirmationButton = By.xpath("//i[@class='fa fa-check yellow green']");
	private By AttachmentInc = By.xpath("(//u[@class='ng-binding'])[1]");
	private By RecentAgentIcon = By.xpath("(//i[@class='acc glyphicon glyphicon-plus'])[1]");
	private By CreatedTodayButton = By.xpath("//md-radio-button[@value='Created Today']");
	private By Options = By.xpath("(//i[@aria-label='Grid Menu'])[2]");
	private By EmailSubject = By.xpath("//input[@class='form-control ng-pristine ng-untouched ng-isolate-scope ng-empty ng-invalid ng-invalid-required']");
	private By EmailConfirmationButton = By.xpath("(//button[@class='btn btn-default icons text-center ng-isolate-scope'])[2]");
	private By ActionAttachment = By.xpath("//a[@role='tab']//i[@class='fa fa-paperclip']");
	private By TaskInc = By.xpath("(//u[@class='ng-binding'])[1]");
	private By EmailAddressDD = By.xpath("//md-select[@role='listbox'] | //md-select[@ng-model='collaborationSenderEmailId']");
	private By EmailAddressDDOPtion = By.xpath("//md-option[@value='salessupport@truecoverage.com'] | (//*[@ng-repeat='item in registeredEmailIds'])[2]//div");
	private By Internal_Agent = By.xpath("//md-checkbox[@name='Internal']//div[@class='md-container md-ink-ripple']");
	private By L_GotoHomePage1 =By.xpath("//*[@name='menu_home']");
	private By DocumentDD1 =  By.cssSelector(".form-control.ng-pristine.ng-untouched.ng-valid.ng-not-empty");
	private By Advancesearch =By.name("advancedSearchBtn");




	public String employerName() {
		String allowedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String ssn = "";
		String temp = RandomStringUtils.random(10, allowedChars);
		ssn = temp.substring(0, temp.length() - 5);
		return ssn;
	}

	public int getRandomNumber()
	{
		Random r = new Random();
		int ran = r.nextInt(1000);
		return ran;
	}
	public void ClickOnMinimizeCallwindow() throws InterruptedException {		
		if (ElementDisplayed(CTIMinimizeIcon)) {
			ExtentSuccessMessage("Successfully user able to See 'Minimize Icon' ");
			click(CTIMinimizeIcon);
			ExtentSuccessMessage("Successfully user Clicked on 'Minimize Icon' ");
		} else {
			ExtentSuccessMessage("Unsuccessfully 'Minimize' Not visible");
		}
	}

	public String writenameToExcel(String nameText, String sheetname) throws IOException {
		String excelFilePath = ".\\src\\test\\resources\\TestData.xlsx";
		FileInputStream inputStream = new FileInputStream(excelFilePath);
		Workbook workbook = new XSSFWorkbook(inputStream);
		String sheetName_update = sheetname;
		Sheet sheet = workbook.getSheet(sheetname);
		int rowIndex = 1;  
		int columnIndex = 6;
		Row row = sheet.getRow(rowIndex);
		Cell cell = row.createCell(columnIndex);
		cell.setCellValue(nameText);  
		inputStream.close();
		FileOutputStream outputStream = new FileOutputStream(excelFilePath);
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();
		return null;		
	}




	public void agency_CreateAgent(CensusInfo ApplicantInfo) throws InterruptedException, AWTException, IOException
	{			
		//		    
		//			element = wait.until(ExpectedConditions.presenceOfElementLocated(AgencyTile));
		//			MoveToElementClick(element);//clicking on Agent tiles  AgencyAgent
		//			ExtentSuccessMessage("Agency Tile has been clicked");
		//			
		//			
		//			element = wait.until(ExpectedConditions.presenceOfElementLocated(AgencyAgent));
		//			MoveToElementClick(element);
		//			ExtentSuccessMessage("Agency Agent has been clicked");

		Agent360Page.NavigatetoAgentTab();

		element = wait.until(ExpectedConditions.presenceOfElementLocated(NewAgentButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("New Agent Button has been clicked");


		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentPrefix));
		MoveToElementClick(element);



		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentPrefixOption));
		MoveToElementClick(element);
		ExtentSuccessMessage("Prefix has been selected");



		element = wait.until(ExpectedConditions.presenceOfElementLocated(NewAgentFirstName));
		MoveToElementClick(element);
		String AgentFirstName = "AutoAgent"+employerName();
		writeText(NewAgentFirstName, AgentFirstName );
		writenameToExcel(AgentFirstName,"TC CE2");



		element = wait.until(ExpectedConditions.presenceOfElementLocated(NewAgentLastName));
		MoveToElementClick(element);
		String AgentLastName = employerName();
		writeText(NewAgentLastName,AgentLastName );
		ExtentSuccessMessage("Last name has been entered");


		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgencyType));
		MoveToElementClick(element);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgencyTypeOption));
		MoveToElementClick(element);
		ExtentSuccessMessage("Agency type has been selected");

		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentLicenseNumber));
		MoveToElementClick(element);
		GetLicense_Number =""+getRandomNumber();
		writeText(AgentLicenseNumber,GetLicense_Number);
		ExtentSuccessMessage("License number has been entered");



		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentStatus));
		MoveToElementClick(element);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentStatusOption));
		MoveToElementClick(element);
		ExtentSuccessMessage("Agency type has been selected");


		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentContactInformationSection));
		MoveToElementClick(element);


		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentPhoneNumber));
		MoveToElementClick(element);
		writeText(AgentPhoneNumber,generatePhoneNumber() );
		ExtentSuccessMessage("Phone number has been entered");



		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentEmailId));
		MoveToElementClick(element);
		AgentMailId = writeDynamicEmail() ;
		writeText(AgentEmailId,AgentMailId );
		ExtentSuccessMessage("Email has been entered");



		element = wait.until(ExpectedConditions.presenceOfElementLocated(PimaryAddressInfoSection));
		MoveToElementClick(element);



		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentAddress));
		MoveToElementClick(element);
		writeText(AgentAddress,"Park Field" );
		ExtentSuccessMessage("Address been entered");


		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentZipcode));
		MoveToElementClick(element);
		writeText(AgentZipcode,"44444" );
		ExtentSuccessMessage("Zipcode has been entered");


		element = wait.until(ExpectedConditions.presenceOfElementLocated(MailinhAddressCheckBox));
		MoveToElementClick(element);


		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentSubmitButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("New Agent has been created");

		Thread.sleep(5000);
		By NewAgentSearchField = By.xpath("//input[@class='ng-pristine ng-untouched md-input ng-empty ng-valid-minlength ng-valid-maxlength ng-valid ng-valid-required']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NewAgentSearchField));
		MoveToElementClick(element);
		writeText(AgentSearchField,AgentMailId + Keys.ENTER);
		ExtentSuccessMessage("Search has been clicked");



		By AgentINC = By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[4]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentINC));
		AgentText  = element.getText();
		System.out.println("-----------"+ AgentText+"------------");
		Assert.assertEquals(AgentMailId , AgentText);
		ExtentSuccessMessage("Assertion has been done");



		element = wait.until(ExpectedConditions.presenceOfElementLocated(Click_Agent));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked the created agent");



	}

	public void Create_Licenses() throws InterruptedException, AWTException
	{
//		Agent360Page.NavigatetoAgentTab();
		
//		element = wait.until(ExpectedConditions.presenceOfElementLocated(Click_Agent));
//		MoveToElementClick(element);
//		ExtentSuccessMessage("Clicked the created agent");
		
		Thread.sleep(5000);        
		click(License_Tab);

		//Create_License

		element = wait.until(ExpectedConditions.presenceOfElementLocated(Create_License));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked On Create License");
		Robot robot = new Robot();

		element = wait.until(ExpectedConditions.presenceOfElementLocated(StateDD));
		MoveToElementClick(element);

//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);


		element = wait.until(ExpectedConditions.presenceOfElementLocated(DDValue));
		MoveToElementClick(element);
		ExtentSuccessMessage("State has been selected");


		element = wait.until(ExpectedConditions.presenceOfElementLocated(IssuedDate));
		MoveToElementClick(element);
		Iss_Date = "04/10/2024";
		writeText(IssuedDate, Iss_Date+Keys.ENTER);

		ExtentSuccessMessage("Issue Date has been Entered");


		element = wait.until(ExpectedConditions.presenceOfElementLocated(ExpiryDate));
		MoveToElementClick(element);
		LicenseExpiryDate = "10/10/2025";
		writeText(ExpiryDate, LicenseExpiryDate+Keys.ENTER);
		ExtentSuccessMessage("Expiry Date has been Entered");

		element = wait.until(ExpectedConditions.presenceOfElementLocated(StatusDD));
		MoveToElementClick(element);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(StatusDDOption));
		MoveToElementClick(element);
		ExtentSuccessMessage("Status Has been Clicked");

		element = wait.until(ExpectedConditions.presenceOfElementLocated(SubmitLicenseButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("License Has been created");
		System.out.println("page:-"+driver.getTitle());
		Thread.sleep(5000);
		System.out.println("page2:-"+driver.getTitle());
		element = wait.until(ExpectedConditions.presenceOfElementLocated(License_Tab));
		MoveToElementClick(element);
		ExtentSuccessMessage("License Section has been clicked");

	}

	public void license_Fields_Validation() throws InterruptedException
	{
		element = wait.until(ExpectedConditions.presenceOfElementLocated(State));
		ExtentSuccessMessage("State data has been validated");

		element = wait.until(ExpectedConditions.presenceOfElementLocated(Product_Category));
		ExtentSuccessMessage("Product Category  data has been validated");

		By Issued_date = By.xpath("(//div[@title='"+Iss_Date +"'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Issued_date));
		ExtentSuccessMessage("Issued date data has been validated");

		By Exp_date = By.xpath("(//div[@title='"+LicenseExpiryDate +"'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Exp_date));
		ExtentSuccessMessage("Expiry date  data has been validated");

		By Status= By.xpath("//div[@title='Active']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Status));
		ExtentSuccessMessage("Status data has been validated");

		By More = By.xpath("(//i[@aria-label='Grid Menu'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(More));
		MoveToElementClick(element);

		ExtentSuccessMessage("Clciked on more options");

		By Check_Id = By.xpath("(//i[@class='ui-grid-icon-ok'])[7]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Check_Id));
		MoveToElementClick(element);


		//		 
		//		 By ID = By.xpath("(//div[@title='"+GetLicense_Number+"'])[1]");
		//		 element = wait.until(ExpectedConditions.presenceOfElementLocated(ID));
		//		// Assert.assertTrue(driver.findElement(ID).isDisplayed());
		ExtentSuccessMessage("Validated ID data");

		//Assert.assertTrue(driver.findElement(Carrierspage).isDisplayed());

	}

	public void Carrier_Appointments() throws InterruptedException{

		element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierAgentAppointmentButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Appointment Button has been clicked");


		element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierAgentNameDD));
		MoveToElementClick(element);


		element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierAgentNameOption));
		MoveToElementClick(element);
		ExtentSuccessMessage("Agent name has been selected");


		By CarrierStateDD  = By.xpath("//md-select[@name='State']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierStateDD));
		MoveToElementClick(element);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierStateDDOption));
		MoveToElementClick(element);
		ExtentSuccessMessage("State has been clicked");

		element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierAgentStatusDD));
		MoveToElementClick(element);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierAgentStatusOption));
		MoveToElementClick(element);
		ExtentSuccessMessage("Agent has been clicked");

		Assert.assertTrue(driver.findElement(AppointmentCarrierSubmitButton).isEnabled());
		ExtentSuccessMessage("Assertion has been done");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AppointmentCarrierSubmitButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Submit Button has been clicked");


	}

	public void Collaboration_Validations(CensusInfo ApplicantInfo) throws InterruptedException, AWTException, IOException{

		ExtentSuccessMessage("Start AG_TS_007_TC_001_Collaborations");
		Agent360Page.NavigatetoAgentTab();
		
		

		element = wait.until(ExpectedConditions.presenceOfElementLocated(Click_Agent));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked the created agent");
		
		ExtentSuccessMessage("Start AG_TS_007_TC_001_Collaborations");

		element = wait.until(ExpectedConditions.presenceOfElementLocated(NotesSection));
		MoveToElementClick(element);
		String Note = "This is created Via Automation";
		writeText(NotesSection, Note);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NotesConfirmationButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Note has been added");

		Thread.sleep(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentActionNoteInc));
		NoteText  = element.getText();
		System.out.println("-----------"+ NoteText+"------------");
		Assert.assertEquals(Note, NoteText);
		ExtentSuccessMessage("Assertion has been done");


//		Thread.sleep(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ActionEmailIcon));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Action Email Icon");

		Thread.sleep(5000);
		element =wait.until(ExpectedConditions.elementToBeClickable(EmailAddressDD));
//		click(EmailAddressDD);
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Email Address DD");

		element = wait.until(ExpectedConditions.presenceOfElementLocated(EmailAddressDDOPtion));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Email Address DD Option");
		
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AddEmailAddressCheckBox));
		MoveToElementClick(element);
		String AgentEmailAction = "leoagent@yopmail.com";
		writeText(AddEmailAddressCheckBox,AgentEmailAction + Keys.ENTER);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EmailSubject));
		MoveToElementClick(element);
		String AgentEmailSubject = "This Mail is Via Automation for Healthcare";
		writeText(EmailSubject,  AgentEmailSubject);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EmailConfirmationButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Email has been added");
		Thread.sleep(9000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentEmailInc));
		NoteText  = GetElementText(AgentEmailInc);
		System.out.println("-----------"+ NoteText+"------------");
		Assert.assertEquals(AgentEmailAction, NoteText);
		ExtentSuccessMessage("Assertion has been done");



		element = wait.until(ExpectedConditions.presenceOfElementLocated(ActionAttachment));
		MoveToElementClick(element);
		

		Thread.sleep(9000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(DocumentDD1));
		Select s1 = new Select(element);
		s1.selectByVisibleText("Other");
		//				
		//				element = wait.until(ExpectedConditions.presenceOfElementLocated(DocumentDD));
		//				wait.until(ExpectedConditions.elementToBeClickable(DocumentDD));
		//				click(DocumentDD);
		//				(500);
		//	           
		//	            wait.until(ExpectedConditions.elementToBeClickable(DocumentDDOption));
		//				click(DocumentDDOption);	
		wait.until(ExpectedConditions.elementToBeClickable(DocumentAttachFileButton));
		click(DocumentAttachFileButton);
		Thread.sleep(8000);
		Robot robot = new Robot();
		String filePath = System.getProperty("user.dir") + "\\Upload\\AgentAttachment.txt";
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
		Thread.sleep(8000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(AttachmentConfirmationButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Attachment has been added");

		Thread.sleep(5000);
		waitVisibility(AttachmentInc);
		Assert.assertTrue(driver.findElement(AttachmentInc).isDisplayed());
		ExtentSuccessMessage("Assertion has been done");




		element = wait.until(ExpectedConditions.presenceOfElementLocated(ActionTask));
		MoveToElementClick(element);
		
		Thread.sleep(9000);
//		element = wait.until(ExpectedConditions.presenceOfElementLocated(ActivityDD));
////		element.click();
//
//		Select select = new Select(element);
//		select.selectByVisibleText("Send Email");
//
//
//
//		element = wait.until(ExpectedConditions.presenceOfElementLocated(PriorityDD));
//		element.click();
//
//		Select s = new Select(element);
//		s.selectByVisibleText("Low");


		element = wait.until(ExpectedConditions.presenceOfElementLocated(CommentTextArea));
		MoveToElementClick(element);
		writeText(CommentTextArea, "This Task is created VIA Automation" );


		element = wait.until(ExpectedConditions.presenceOfElementLocated(TaskConfirmationButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Task has been added");


//		Thread.sleep(5000);
		waitVisibility(TaskInc);
		Assert.assertTrue(driver.findElement(TaskInc).isDisplayed());
		ExtentSuccessMessage("Assertion has been done");
		
		ExtentSuccessMessage("End AG_TS_007_TC_001_Collaborations");
		
		ExtentSuccessMessage("*******************************************************");
		GotoHomepage1();
		
		ExtentSuccessMessage("Started AG_TS_008_TC_001_002_Filter_Validations");
		
		Filter_Validations();
		
		Apply_Filter();
		ExtentSuccessMessage("End AG_TS_008_TC_001_002_Filter_Validations");


	}

	public void Filter_Validations() throws InterruptedException
	{
		Agent360Page.NavigatetoAgentTab();

//		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgencyTile));
//		MoveToElementClick(element);//clicking on Agent tiles  AgencyAgent
//		ExtentSuccessMessage("Agency Tile has been clicked");
//
//
//		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgencyAgent));
//		MoveToElementClick(element);
//		ExtentSuccessMessage("Agency Agent has been clicked");


		element = wait.until(ExpectedConditions.presenceOfElementLocated(Recent_Agents));
		ExtentSuccessMessage("Recent Agents has been validated"); 



		element = wait.until(ExpectedConditions.presenceOfElementLocated(Agent_Type));
		ExtentSuccessMessage("Agent_Type has been validated"); 



		element = wait.until(ExpectedConditions.presenceOfElementLocated(Status));
		ExtentSuccessMessage("Status has been validated"); 



		element = wait.until(ExpectedConditions.presenceOfElementLocated(States));
		ExtentSuccessMessage("State has been validated"); 



		element = wait.until(ExpectedConditions.presenceOfElementLocated(Agency_Type));
		ExtentSuccessMessage("Agency_Type has been validated"); 


	}

	public void Apply_Filter() throws InterruptedException
	{		
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Agent_Type));
		MoveToElementClick(element);
		ExtentSuccessMessage("Agent_Type has been validated"); 
//		Thread.sleep(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Internal_Agent));
		MoveToElementClick(element);
		ExtentSuccessMessage("Internal Agent has been checked"); 

//		Thread.sleep(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Click_Agent));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked the created agent");
//		Thread.sleep(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentType));
		String Agent_Type1 = element.getText();
		Assert.assertTrue(Agent_Type1.contains("Internal"));
		ExtentSuccessMessage("Filter has been applied and validated");
	}

	public void GotoHomepage1() throws InterruptedException {
		if (ElementDisplayed(L_GotoHomePage1)) {
			ExtentSuccessMessage("Successfully user able to See 'Home page' ");
			click(L_GotoHomePage1);
			ExtentSuccessMessage("Successfully user Clicked on 'Homw Page' ");
		} else {
			ExtentSuccessMessage("Unsuccessfully 'Homw Page' Not visible");
		}
		Thread.sleep(5000);
		ClickOnMinimizeCallwindow();
	}
	
	
}