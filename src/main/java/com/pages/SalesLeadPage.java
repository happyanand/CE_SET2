package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.BasePackage.Base_Class;

import Utility.ExcelHelper;

public class SalesLeadPage extends BasePage {
	public SalesLeadPage(WebDriver driver) {
		super(driver);
	}

	JavascriptExecutor js = (JavascriptExecutor) driver;
	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	WebElement element;
	ExcelHelper _excelObj = new ExcelHelper();
	XSSFSheet tcTestData = _excelObj.readExcelSheet("TestData", "URLs");
	
	public String NoteText;
	private By TaskInc = By.xpath("(//u[@class='ng-binding'])[1]");

	By SalesButton = By.xpath("//span[text()='Sales ']");
	By Leads = By.xpath("(//a[text()='Leads'])[2]");
	By NewLead = By.xpath("//button[@name='newLeadBtn' and @id='newLeadBtn'] ");
	By NewLeadFirstName = By.xpath("//input[@id='LeadFirstName']");
	By NewLeadLastName = By.xpath("//input[@id='LeadLastName']");
	By DOB = By.xpath("//input[@id='Dob']");
	By Gender = By.xpath("//label[text()='Gender ']");
	By Male = By.xpath("//div[text()='Male']");
	By Phnum = By.xpath("//input[@name='LeadMobile']");
	By Email = By.xpath("//input[@id='LeadEmail']");
	By LeadInformation = By.xpath("//div[@id='formFlag2']");
	By HomeorPrincipals = By.xpath("//div[@id='formFlag3']");
	By HomeZipCode = By.xpath("//input[@name='ZipCode']");
	By Adress = By.xpath("//input[@id='AddressLine1'and @name ='AddressLine1']");
	By OtheInformation = By.xpath("//div[@id='formFlag5']");
	By Submit = By.xpath("(//button[text()='Submit'])[7]");
	By ClickLead = By.xpath("//a[@class='edit-list-anchor ng-binding']");
	By LeadAssign = By.xpath("//button[@id='Assign']");
	By EditIcon = By.xpath("//button[@id='editLeadsBtn']");
	By StatusSelect = By.xpath("//select[@class='md-visually-hidden']");
	By ButtonSave = By.xpath("//button[text()='Save']");

	By LeadQualify = By.xpath("//button[@id='Qualify']");
	By LeadReject = By.xpath("//button[@id='Reject']");
	By LeadDispose = By.xpath("//button[@id='Call']");
	By Convert = By.xpath("//button[@id='Convert']");
	By MedicalDropdown = By.xpath("//md-select[@id='select_331']");
	By Medical = By.xpath("(//div[text()='Medical']/parent::md-option)[2]");
	By ConvertSubmit = By.xpath("//button[text()='Submit']");
	By SalesLeadNotes = By.xpath("//textarea[@name='desc']");
	By SaveNote = By.xpath("//button[@type='submit']/child::i");
	By SalesEmail = By.xpath("//i[@class='fa fa-envelope']/parent::a");
	// By SalesEmailID = By.xpath("//input[@placeholder='Add email address']");

	By SalesEmailID = By.xpath("//md-chips[@placeholder='Add email address']");
	By EmailSubject = By.xpath("//input[@placeholder='Add a subject']");
	By SaveEmail = By.xpath("//i[@class='fa fa-check yellow green']/parent::button");
	By SalesTask = By.xpath("//i[@class='fa fa-calendar']/parent::a");
	By TaskSave = By.xpath("//i[@class='fa fa-check yellow green']");
	By AttachFile = By.xpath("//i[@class='fa fa-paperclip']/parent::a");
	By AttachDropDown = By.xpath("//div[@class='form-group ng-isolate-scope']/child::select");
	By AddressSave = By.xpath("//i[@class='fa fa-check yellow green']");
	By StatusLead = By.xpath("(//div[@class='accordion-container grid-style-height']/child::h5)[7]");
	By StausUnqualified = By.xpath("//span[text()='Unqualified']");
	By StatusAccepted = By.xpath("//span[text()='Accepted']");
	By StatusConverted = By.xpath("//span[text()='Converted']");
	By StatusQualified = By.xpath("//span[text()='Qualified']");
	By AdvancedSearch = By.xpath("//button[@id='advancedSearchBtn']");
	By AdvancedLeadStatus = By.xpath("//md-select[@id='LeadStatus']");
	By SelectAccepted = By.xpath("//md-option[@value='Accepted']");
	By SelectUnqualified = By.xpath("//md-option[@value='Unqualified']");
	By SelectConverted = By.xpath("//md-option[@value='Converted']");
	By SelectQualified = By.xpath("//md-option[@value='Qualified']");
	By SelectReject = By.xpath("//md-option[@value='Rejected']");
	By AdvanceSubmit = By.xpath("//button[@id='advancedSearchSubmitBtn']");
	By SalesOpportunities = By.xpath("(//a[text()='Opportunities'])[2]");
	By NewOpportunity = By.xpath("//button[@id='newOpportunityBtn']");
	By OpportunityName = By.xpath("(//input[@name='CustomerName'])[2]");
	By SalesSearchIcon = By.xpath("(//button[@class='btn btn-default green'])[4]");
	By RadioButtonSelect = By.xpath("//input[@type='radio']");
	By ButtonOk = By.xpath("//button[text()='OK']");
	By SubmitOk = By.xpath("(//button[contains(text(),'Submit')])[5]");
	By OpportunityQuote = By.xpath("(//button[@class='btn btn-default pull-right ng-binding ng-scope'])[2]");
	By OpportunityEffectiveDate = By.xpath("//input[@name='EffectiveDate']");
	By OptZipCode = By.xpath("//input[@name='Zip']");
	By OPtStatus = By.xpath("//md-select[@name='CRMNewQuoteStatus']");
	By OptSubStaus = By.xpath("//md-option[@value='Created']");
	By Optsubmit = By.xpath("(//button[@class='btn btn-default green'])[3]");
	By Optqualify = By.xpath("(//button[@class='btn btn-default pull-right ng-binding ng-scope'])[3]");
	By Optsubmit2 = By.xpath("//button[text()='Submit']");
	By CloseDeal = By.xpath("(//button[@class='btn btn-default pull-right ng-binding ng-scope'])[1]");
	By CloseDealStatus = By.xpath("//md-select[@name='CloseDealStatus']");
	By CloseOption = By.xpath("//md-option[@value='Close as Won']");
	By OpportunityStatus = By.xpath("//md-select[@id='CRMOpportunityStatus']");
	By OpportunityOpen = By.xpath("//md-option[@value='Open']");
	By OpportunityCloseAsLost = By.xpath("//md-option[@value='Closed as Lost']");
	By OpportunityCloseWon = By.xpath("//md-option[@value='Closed as Won']");
	By OppQualify = By.xpath("//md-option[@value='Qualified']");
	By OppRenewal = By.xpath("//md-option[@value='Renewed']");
	By OppCancel = By.xpath("//md-option[@value='Cancelled']");
	By OppSearch = By.xpath("//button[@id='applyadvancedSearchBtn']");
	By Oppstatus = By.xpath("(//div[@class='accordion-container grid-style-height']/child::h5)[3]");
	By OppCancel2 = By.xpath("//md-checkbox[@value='Cancelled']");
	By OppCloseW = By.xpath("//md-checkbox[@value='Closed as Lost']");
	By OppOpen = By.xpath("//md-checkbox[@value='Open']");
	By OppQualified = By.xpath("//md-checkbox[@value='Qualified']");
	By SalesQuote = By.xpath("(//a[text()='Quotes'])[2]");
	By InstallPolicy = By.xpath("(//button[@ng-repeat='normal in normalActions | reverse'])[1]");
	By AorSearch = By.xpath("//button[@class='btn btn-default green']");
	By AorText = By.xpath("//input[@ng-model='searchText']");
	By SearchIcon = By.xpath("//button[@title='Search Agent Name']");
	By AorRadioButton = By.xpath("//input[@name='selectedAgent']");
	By Okbutton = By.xpath("//button[text()='OK']");
	By SubmitQuote = By.xpath("//button[text()='Submit']");
	By CancelQuote = By.xpath("(//button[@ng-repeat='normal in normalActions | reverse'])[2]");
	By SelectStatus = By.xpath("//md-select[@name='TerminateQuoteStatus']");
	By SelectCancel = By.xpath("//md-option[@value='Terminated']");
	By ActualRevenu = By.xpath("//input[@name='ActualRevenue']");
	By Textarea = By.xpath("//textarea[@name='Reason']");
	By CancelSubmit = By.xpath("//button[text()='Submit']");
	By QuoteStatus = By.xpath("(//div[@class='accordion-container grid-style-height']/child::h5)[3]");
	By QuoteCancel = By.xpath("//md-checkbox[@value='Cancelled']");
	By QuoteCreated = By.xpath("//md-checkbox[@value='Created']");
	By QuoteDeclined = By.xpath("//md-checkbox[@value='Declined']");
	By QuoteExpire = By.xpath("//md-checkbox[@value='Expired']");
	By QuoteInprogress = By.xpath("//md-checkbox[@value='In Progress']");
	By QuoteInactive = By.xpath("//md-checkbox[@value='Inactive']");
	By QuoteInstallinprogress = By.xpath("//md-checkbox[@value='Install In Progress']");
	By QuoteInstall = By.xpath("//md-checkbox[@value='Installed']");
	By QuoteTerminated = By.xpath("//md-checkbox[@value='Terminated']");
	By QuoteAdStatusDD = By.xpath("//md-select[@name='QuoteStatus']");
	private By AgentEmailInc = By.xpath("(//u[@class='ng-binding'])[1]");
	private By AttachmentInc = By.xpath("(//u[@class='ng-binding'])[1]");


	By QuoteAdCancel = By.xpath("//md-option[@value='Cancelled']");
	By QuoteAdCreated = By.xpath("//md-option[@value='Created']");
	By QuoteAdDeclined = By.xpath("//md-option[@value='Declined']");
	By QuoteAdExpired = By.xpath("//md-option[@value='Expired']");
	By QuoteAdInActive = By.xpath("//md-option[@value='Inactive']");
	By QuoteAdInProgress = By.xpath("//md-option[@value='In Progress']");
	By QuoteAdInstalled = By.xpath("//md-option[@value='Installed']");
	By QuoteAdInstallInProgress = By.xpath("//md-option[@value='Install In Progress']");
	By QuoteAdTerminated = By.xpath("//md-option[@value='Terminated']");
	By QuoteAdSearch = By.xpath("//button[@id='applyadvancedSearchBtn']");
	By SalesPolicy = By.xpath("(//a[text()='Policies'])[2]");
	By CreatePolicy = By.xpath("//button[@class='btn btn-default pull-left btn-yellow']");
	By PolicySearchIcon = By.xpath("//i[@class='glyphicon glyphicon-search']");
	By PolicySearchText = By.xpath("//input[@ng-model='searchText']");
	By PolicyCustmerSearchIcon = By.xpath("//button[@title='Search Customer']");
	By SelectCustmer = By.xpath("//input[@ng-model='data.selectedCustomer']");
	By CustomerOk = By.xpath("//button[text()='OK']");
	By ProductCategory = By.xpath("(//md-select[@id='CRMProductCategory'])[2]");
	By MedicalLOB = By.xpath("(//md-option[@value='Medical'])[3]");
	By Carrier = By.xpath("//md-select[@id='Carrier']");
	By SelectCarrier = By.xpath("(//md-option[@value='Aetna'])[2]");
	By SalesType = By.xpath("//md-select[@id='salesType']");
	By SalesNew = By.xpath("(//md-option[@value='New'])[2]");
	private By AgentActionNoteInc = By.xpath("//u[@class='item_to_highlight ng-binding']");

	By PolicyStatus = By.xpath("//md-select[@id='AssetStatus']");
	By PolicyActive = By.xpath("(//md-option[@value='Active'])[4]");
	By PolicyEFDate = By.xpath("//input[@id='EffectiveDate']");
	By PolicyAOR = By.xpath("(//button[@class='btn btn-default green']/child::i)[3]");
	By AoRSearchText = By.xpath("//input[@ng-model='searchText']");
	By AORSearchIcon = By.xpath("//button[@title='Search Agent Name']");
	By SelectAOR = By.xpath("//input[@name='selectedAgent']");
	By AorOk = By.xpath("//button[text()='OK']");
	By PolicySubmit = By.xpath("(//button[text()='Submit'])[5]");
	By PolicyCancel = By.xpath("//button[@class='btn btn-default pull-right ng-binding ng-scope']");
	By PolicyCancelDD = By.xpath("//md-select[@name='TerminateAssetStatus']");
	By PolicyDDStatus = By.xpath("//md-option[@value='Terminated']");
	By PolicyCancelSubmit = By.xpath("//button[text()='Submit']");
	By PolicyFilterStatus = By.xpath("(//div[@class='accordion-container grid-style-height']/child::h5)[3]");
	By PolicyStatusCancel = By.xpath("//md-checkbox[@value='Cancelled']");
	By PolicyStatusEnrolled = By.xpath("//md-checkbox[@value='Enrolled']");
	By PolicyEnrolledPlaylater = By.xpath("//md-checkbox[@value='Enrolled-Paylater']");
	By PolicyStatusFullfill = By.xpath("//md-checkbox[@value='Fulfilled']");
	By PolicyStatusInProgress = By.xpath("//md-checkbox[@value='In Progress']");
	By PolicyStatusInActive = By.xpath("//md-checkbox[@value='Inactive']");
	By PolicyInComplete = By.xpath("//md-checkbox[@value='Incomplete']");
	By PolicyLockEligibility = By.xpath("//md-checkbox[@value='Locked-Eligibility']");
	By PolicyLockPayment = By.xpath("//md-checkbox[@value='Locked-Payment']");
	By PolicyLockEnrollment = By.xpath("//md-checkbox[@value='Locked-Enrollment']");
	By PolicyLockFullfillment = By.xpath("//md-checkbox[@value='Locked-Fulfillment']");
	By PolicyNeedinfo = By.xpath("//md-checkbox[@value='Need-More-Information']");
	By PolicyPending = By.xpath("//md-checkbox[@value='Pending Cancellation']");
	By PendingDE = By.xpath("//md-checkbox[@value='Pending-DE-Automation']");
	By PremiumPaid = By.xpath("//md-checkbox[@value='PremiumPaid']");
	By PolicystatusSubmit = By.xpath("//md-checkbox[@value='Submitted']");
	By PolicyTerminated = By.xpath("//md-checkbox[@value='Terminated']");
	By PolicyADDropdown = By.xpath("//md-select[@id='CRMPolicyStatus']");
	By PolicyADCancel = By.xpath("//md-option[@value='Cancelled']");
	By PolicyTestMM = By.xpath("//md-option[@value='TestMM status']");
	By PolicyEnrolled = By.xpath("//md-option[@value='Enrolled']");
	By PolicyEnrollPaylater = By.xpath("//md-option[@value='Enrolled-Paylater']");
	By PolicyFullfill = By.xpath("//md-option[@value='Fulfilled']");
	By PolicyInProgress = By.xpath("//md-option[@value='In Progress']");
	By PolicyAdInActive = By.xpath("//md-option[@value='Inactive']");
	By PolicyAdIncomplete = By.xpath("//md-option[@value='Incomplete']");
	By PolicyLockedEligibility = By.xpath("//md-option[@value='Locked-Eligibility']");
	By PolicyAdLockedEnrollment = By.xpath("//md-option[@value='Locked-Enrollment']");
	By PolicyAdLockedFullfillment = By.xpath("//md-option[@value='Locked-Fulfillment']");
	By PolicyNeedmoreInfo = By.xpath("//md-option[@value='Need-More-Information']");
	By PolicyAdPending = By.xpath("//md-option[@value='Pending']");
	By PolicyAdPendeningCancellation = By.xpath("//md-option[@value='Pending Cancellation']");
	By PolicyAdPendingDEAutomation = By.xpath("//md-option[@value='Pending-DE-Automation']");
	By PolicyAdPremiumPaid = By.xpath("//md-option[@value='PremiumPaid']");
	By PolicyAdSubmitted = By.xpath("//md-option[@value='Submitted']");
	By PolicyAdTerminated = By.xpath("//md-option[@value='Terminated']");
	By ImportCustmerPolicies = By.xpath("//button[@class='btn btn-yellow dropdown-toggle pull-right']");
	By BulkImport = By.xpath("//button[@id='bulkImportBtn']");
	By SelectFile = By.xpath("(//div[text()='Select File'])[1]");
	By FileSubmit = By.xpath("//button[@id='importPolicySubmitBtn']");
	By FileSubmitOk = By.xpath("//button[text()='OK']");
	By Customers = By.xpath("//a[@class='glyphicon fa fa-users']");
	By NewCustomer = By.xpath("//button[@id='newCustomerBtn']");
	By CustFName = By.xpath("(//input[@id='LeadFirstName'])[1]");
	By CustLName = By.xpath("(//input[@id='LeadLastName'])[1]");
	// By ContactInfo = By.xpath("(//div[@class='accordion-container'])[2]");
	By ContactInfo = By
			.xpath("//*[@id=\"page-wrapper\"]/div/ui-view/div[8]/ng-include/div[3]/div/div[2]/div/div[1]/div[5]/i");
	By Cellphone = By.xpath("(//input[@name='CellPhone'])[1]");
	By CustMail = By.xpath("(//input[@name='Email'])[1]");

	By PrincipalAdress = By
			.xpath("//*[@id=\"page-wrapper\"]/div/ui-view/div[8]/ng-include/div[3]/div/div[2]/div/div[1]/div[8]/i");
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
	By CustomerFilProspet = By.xpath("//md-checkbox[@value='Prospect']");
	By CustomerFilDecesed = By.xpath("//md-checkbox[@value='Deceased']");
	By CustomerADSearchDD = By.xpath("//md-select[@id='Status']");
	By CustomerAdActive = By.xpath("//md-option[@value='Active']");
	By CustomerAdInActive = By.xpath("//md-option[@value='Inactive']");
	By CustomerAdprospect = By.xpath("//md-option[@value='Prospect']");
	By CustomerAdDecesed = By.xpath("//md-option[@value='Deceased']");
	By CustomerImport = By.xpath("//button[@id='importCustomerPolicyBtn']");
	By CustomerBulkImport = By.xpath("//button[@name='bulkImportBtn']");
	By CustomerImportSubmit = By.xpath("//button[@id='uploadBobImportBtn']");
	By CustomerContact = By.xpath("//a[@class='edit-list-anchor ng-binding']");
	By CustomerSendContactCard = By.xpath("//button[@title='Send Contact Card']");
	By CustomerContactSend = By.xpath("//button[text()='Send']");
	By Service = By.xpath("//a[@class='glyphicon fa fa-fw fa-gears']");
	By NewServiceReq = By.xpath("//button[@id='createServiceRequestBtn']");
	By SearchTextCustomer = By.xpath("//input[@name='Customer']");
	By CustomerSearchIcon = By.xpath("//button[@class='btn btn-default green']/child::i");
	By SelectCustomer = By.xpath("//input[@name='selCustomer']");

	By ServiceCustomerOk = By.xpath("//button[text()='OK']");
	By ServiceRqtypeDD = By.xpath("//md-select[@name='SrType']");
	By SelectRq = By.xpath("(//md-option[@value='New Enrollment'])[3]");
	By ServiceRqSubtypeDD = By.xpath("//md-select[@name='SRActivitySubType']");
	By ServiceRqSubStstus = By.xpath("//md-option[@value='Referral']");
	By ServiceProductDD = By.xpath("(//md-select[@name='SRProduct'])[2]");
	By ServiceProductCE = By.xpath("(//md-option[@value='CE'])[2]");
	By ServiceActionByDD = By.xpath("//md-select[@name='SRActionedBy']");
	By SelectActionByQA = By.xpath("//md-option[@value='QA']");
	By SelectSubmit = By.xpath("(//button[text()='Submit'])[2]");
	By SelectService = By.xpath("//a[@class='edit-list-anchor ng-binding']");
	By AddActivity = By.xpath("//button[@name='AddActivity']");
	By ActivityTypeDD = By.xpath("//select[@class='ng-pristine ng-empty ng-invalid ng-invalid-required ng-touched']");
	By SaveAct = By.xpath("//button[text()='Save']");
	By ServiceFilter = By.xpath("(//div[@class='accordion-container grid-style-height']/child::h5)[4]");
	By ServiceNew = By.xpath("//md-checkbox[@value='New']");
	By ServiceAssigned = By.xpath("//md-checkbox[@value='Assigned']");
	By ServiceInProgress = By.xpath("//md-checkbox[@value='In Progress']");
	By Servicehold = By.xpath("//md-checkbox[@value='On Hold']");
	By ServiceReopen = By.xpath("//md-checkbox[@value='Re-open']");
	By ServiceRejected = By.xpath("//md-checkbox[@value='Rejected']");
	By ServiceClosed = By.xpath("//md-checkbox[@value='Closed']");
	By ServicePending = By.xpath("//md-checkbox[@value='Pending']");
	By ServiceADDD = By.xpath("//md-select[@name='SRStatus']");
	By ServiceADNew = By.xpath("//md-option[@value='New']");
	By ServiceADAssign = By.xpath("//md-option[@value='Assigned']");
	By ServiceADInProgress = By.xpath("//md-option[@value='In Progress']");
	By ServiceADInHold = By.xpath("//md-option[@value='On Hold']");
	By ServiceADReopen = By.xpath("//md-option[@value='Re-open']");
	By ServiceADReject = By.xpath("//md-option[@value='Rejected']");
	By ServiceADClose = By.xpath("//md-option[@value='Closed']");
	By ServiceADPending = By.xpath("//md-option[@value='Pending']");
	By ServiceExport = By.xpath("//button[@name='downlodDataBtn']");
	By ServieCloseSR = By.xpath("//button[@name='editServiceRequestBtn']");

	By CTIMinimizeIcon = By.xpath("//a[@class='fa fa-minus right-al']");
	
	private By AgentSearchField = By.xpath("//input[@role='combobox']");
	private By AgentFormList = By.xpath("//a[@class='edit-list-anchor ng-binding']");
	private By AgentLicenseButton = By.xpath("(//button[@class='btn btn-default pull-right ng-binding ng-scope'])[2]");
	private By StateDD = By.xpath("//md-select[@name='State']");
	private By DDValue = By.xpath("//md-option[@id='select_option_1259']");
	private By IssuedDate = By.xpath("//input[@name='IssuedDate']");
	private By ExpiryDate = By.xpath("//input[@name='ExpirationDate']");
	private By StatusDD = By.xpath("(//md-select[@role='listbox'])[3]");
	private By StatusDDOption = By.xpath("(//div[contains(.,'Active')])[17]");
	private By SubmitLicenseButton = By.xpath("//button[@name='SaveStateLicenseBtn']");
	private By NotesSection = By.xpath("//textarea[@class='form-control ng-pristine ng-untouched ng-isolate-scope ng-empty ng-invalid ng-invalid-required ng-valid-maxlength']");
	private By NotesConfirmationButton = By.xpath("(//button[@class='btn btn-default icons text-center ng-isolate-scope'])[2]");
	private By ActionEmailIcon = By.cssSelector("#page-wrapper > div > ui-view > div:nth-child(2) > div.col-lg-12.right-section-div.details.pad-lt.col-xl-3 > div > ul > li:nth-child(2) > a");
	private By AddEmailAddressCheckBox = By.xpath("//md-chips[@placeholder='Add email address']");
//	private By EmailSubject = By.xpath("//input[@class='form-control ng-pristine ng-untouched ng-isolate-scope ng-empty ng-invalid ng-invalid-required']");
	private By EmailConfirmationButton = By.xpath("(//button[@class='btn btn-default icons text-center ng-isolate-scope'])[2]");
	private By ActionAttachment = By.cssSelector("#page-wrapper > div > ui-view > div:nth-child(2) > div.col-lg-12.right-section-div.details.pad-lt.col-xl-3 > div > ul > li:nth-child(3) > a > i");
	private By DocumentDD = By.xpath("//*[@id=\"filter-by\"]/div[1]/form/div[1]");
	private By DocumentDDOption = By.xpath("//option[text()='Other']");
	private By DocumentAttachFileButton = By.xpath("//div[@class='btn btn-primary ng-pristine ng-untouched ng-valid ng-isolate-scope ng-empty']");
	private By AttachmentConfirmationButton = By.xpath("(//button[@class='btn btn-default icons text-center ng-isolate-scope'])[2]");
	private By ActionTask = By.cssSelector("#page-wrapper > div > ui-view > div:nth-child(2) > div.col-lg-12.right-section-div.details.pad-lt.col-xl-3 > div > ul > li:nth-child(4) > a > i");
	private By ActivityDD = By.xpath("(//select[@class='form-control ng-pristine ng-untouched ng-valid ng-not-empty'])[1]");
	private By PriorityDD = By.cssSelector("#filter-by > div:nth-child(1) > form > div.form-group.w-47.custom-label > select");
	private By CommentTextArea = By.xpath("//textarea[@class='form-control comments ng-pristine ng-untouched ng-valid ng-empty ng-valid-maxlength']");
	private By TaskConfirmationButton = By.xpath("//i[@class='fa fa-check yellow green']");
	

	
	

	public String randomName() {
		String allowedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String ssn = "";
		String temp = RandomStringUtils.random(10, allowedChars);
		ssn = temp.substring(0, temp.length() - 5);
		return ssn;
	}

	public void waitForElement(int time) throws InterruptedException {
		Thread.sleep(time);
	}

	public void cttMinimize() throws InterruptedException {		
		if (ElementDisplayed(CTIMinimizeIcon)) {
			ExtentSuccessMessage("Successfully user able to See 'Minimize Icon' ");
			click(CTIMinimizeIcon);
			ExtentSuccessMessage("Successfully user Clicked on 'Minimize Icon' ");
		} else {
			ExtentSuccessMessage("Unsuccessfully 'Minimize' Not visible");
		}
	}

	public void serviceClosingRequest() throws InterruptedException {

		element = wait.until(ExpectedConditions.presenceOfElementLocated(Service));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Service");

		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServieCloseSR));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on close");
		waitForElement(8000);
		WebElement SelectSR = driver.findElement(By.xpath("//select[@ng-model='selectedsalesteam']"));
//		 Select select = new Select(SelectSR);
		// select.selectByVisibleText("TeamSR");
		MoveToElementClick(SelectSR);
		By dropdownvalue = By.xpath("//option[@label='TeamSR'] | //option[@label='THIS IS TEST TEAM']");
		click(dropdownvalue);
//		 select.selectByVisibleText("THIS IS TEST TEAM");
//		 waitForElement(8000);
		ExtentSuccessMessage("Selected THIS IS TEST TEAM");
		WebElement Ok = driver.findElement(By.xpath("//button[text()='OK']"));
		MoveToElementClick(Ok);
		ExtentSuccessMessage("Cliked on Ok");
		waitForElement(8000);
	}

	public void serviceExportRequest() throws InterruptedException {
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Service));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Service");
		waitForElement(10000);
		waitForElement(50000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceExport));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Service Export");

	}

	public void serviceAdvancedSearch2() throws InterruptedException {
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Service));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Service");
		waitForElement(10000);
		waitForElement(50000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedSearch));
		MoveToElementClick(element);
		ExtentSuccessMessage("Advanced search has been clicked");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADNew));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected New");
		waitForElement(9000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		MoveToElementClick(element);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADAssign));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Assign");
		waitForElement(9000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		MoveToElementClick(element);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADInProgress));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected InProgress");
		waitForElement(9000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		MoveToElementClick(element);
		waitForElement(9000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADInHold));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected InHold");
		waitForElement(9000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		MoveToElementClick(element);

		waitForElement(9000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADReopen));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Reopen");
		waitForElement(9000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		MoveToElementClick(element);

		waitForElement(9000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADReject));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Reject");
		waitForElement(9000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		MoveToElementClick(element);
		waitForElement(9000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADClose));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Close");
		waitForElement(9000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		MoveToElementClick(element);
		/*
		 * waitForElement(9000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(8000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADPending));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Pending");
		 * waitForElement(9000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		 * MoveToElementClick(element); waitForElement(9000);
		 */
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceExport));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Export");
		waitForElement(9000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		MoveToElementClick(element);
		waitForElement(9000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServieCloseSR));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected CloseSR");
		waitForElement(9000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		MoveToElementClick(element);
	}

	public void serviceAdvancedSearch() throws InterruptedException {
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Service));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Service");
		waitForElement(10000);
		waitForElement(50000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedSearch));
		MoveToElementClick(element);
		ExtentSuccessMessage("Advanced search has been clicked");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADNew));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected New");
		waitForElement(9000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		MoveToElementClick(element);
		waitForElement(8000);
		/*
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(8000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADAssign));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Assign");
		 * waitForElement(9000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		 * MoveToElementClick(element); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(8000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADInProgress));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected InProgress");
		 * waitForElement(9000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		 * MoveToElementClick(element); waitForElement(9000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(8000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADInHold));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected InHold");
		 * waitForElement(9000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		 * MoveToElementClick(element);
		 * 
		 * waitForElement(9000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(8000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADReopen));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Reopen");
		 * waitForElement(9000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		 * MoveToElementClick(element);
		 * 
		 * waitForElement(9000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(8000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADReject));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Reject");
		 * waitForElement(9000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		 * MoveToElementClick(element); waitForElement(9000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(8000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADClose));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Close");
		 * waitForElement(9000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		 * MoveToElementClick(element); /* waitForElement(9000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(8000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADPending));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Pending");
		 * waitForElement(9000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		 * MoveToElementClick(element); waitForElement(9000);
		 */
		/*
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(8000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceExport));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Export");
		 * waitForElement(9000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		 * MoveToElementClick(element); waitForElement(9000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(8000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServieCloseSR));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected CloseSR");
		 * waitForElement(9000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		 * MoveToElementClick(element);
		 */
	}

	public void serviceFilter2() throws InterruptedException {
//	waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Service));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Service");
//	 waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceFilter));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on ServiceFilter");
//		 waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceNew));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected New");
//			 waitForElement(8000);	 
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceNew));
		MoveToElementClick(element);
//			 waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceAssigned));
		MoveToElementClick(element);
		ExtentSuccessMessage("Seleted Assigned");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceAssigned));
		MoveToElementClick(element);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceInProgress));
		MoveToElementClick(element);
		ExtentSuccessMessage("Seleted Assigned");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceInProgress));
		MoveToElementClick(element);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Servicehold));
		MoveToElementClick(element);
		ExtentSuccessMessage("Seleted Hold");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Servicehold));
		MoveToElementClick(element);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceReopen));
		MoveToElementClick(element);
		ExtentSuccessMessage("Seleted Reopen");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceReopen));
		MoveToElementClick(element);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceRejected));
		MoveToElementClick(element);
		ExtentSuccessMessage("Seleted Rejected");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceRejected));
		MoveToElementClick(element);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceClosed));
		MoveToElementClick(element);
		ExtentSuccessMessage("Seleted Closed");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceClosed));
		MoveToElementClick(element);
		waitForElement(10000);
//		 element = wait.until(ExpectedConditions.presenceOfElementLocated(ServicePending));
//		 MoveToElementClick(element);
//		 ExtentSuccessMessage("Seleted Pending");
//		 waitForElement(10000);	
//	 element = wait.until(ExpectedConditions.presenceOfElementLocated(ServicePending));
//	 MoveToElementClick(element);	
//	 waitForElement(10000);				 

	}

	public void serviceFilter(CensusInfo ApplicantInfo) throws InterruptedException {

		waitForElement(2000);
		By ServiceOption = By.xpath("//a[@id='menu_service']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceOption));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Service Tile");
		
		waitForElement(5000);
		By RecentServiceReq = By.xpath("(//div[@class='accordion-container grid-style-height'])[1]/i");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(RecentServiceReq));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Recent Service Request Option");
		
		waitForElement(2000);
		By CreatedToday = By.xpath("//md-radio-button[@value='Created Today']"); 
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CreatedToday));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Created today Option");
		
		waitForElement(4000);
		By CustomerName = By.xpath("//a[@class='edit-list-anchor ng-binding ng-scope']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerName));
        String name =element.getText();
        System.out.println(name);
        String nameString = StringUtils.substringAfter(name," ");
        System.out.println(nameString);
        System.out.println(ApplicantInfo.CustomerName);
        
		waitForElement(2000);
        Assert.assertTrue(ApplicantInfo.CustomerName.contains(nameString));
		ExtentSuccessMessage("Newly Created Service Request is Present in Created Today Filter");
 
		waitForElement(2000);
        driver.navigate().refresh();
		ExtentSuccessMessage("Page has been refreshed");
		
		By AdvanceSearch = By.xpath("//button[@name='advancedSearchBtn']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvanceSearch));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Advance Option Button ");
		
		By Status = By.xpath("//md-select[@name='SRStatus']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Status));
		MoveToElementClick(element);
		By Assigned = By.xpath("//md-option[@value='Assigned']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Assigned));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status Dropdown ");

		
		By Requesttype = By.xpath("(//md-select[@name='RequestType'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Requesttype));
		MoveToElementClick(element);
		By New = By.xpath("(//md-option[@value='New Enrollment'])[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(New));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Request Type Dropdown");
		
		
		By Product = By.xpath("//md-select[@name='SRProduct']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Product));
		MoveToElementClick(element);
		By CE = By.xpath("//md-option[@value='CE']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CE));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Product Dropdown");
		
		By SearchButton = By.xpath("//button[@name='applyadvancedSearchBtn']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SearchButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Search Button");
		
		By CustName = By.xpath("(//a[@class='edit-list-anchor ng-binding ng-scope'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustName));
		String custname = element.getText();
		System.out.println(custname);
		
		String custnameString = StringUtils.substringAfter(name," ");
        System.out.println(custnameString);
        System.out.println(ApplicantInfo.CustomerName);
        
        Assert.assertTrue(ApplicantInfo.CustomerName.contains(custnameString));
		ExtentSuccessMessage("Newly Created SR is visible after advance Search");

		waitForElement(2000);
        driver.navigate().refresh();
		ExtentSuccessMessage("Page has been refreshed");
		
		waitForElement(2000);
		By ExportSRButton = By.xpath("//button[@name='downlodDataBtn']")	;
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ExportSRButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Export SR Button");
		
		waitForElement(1000);
		By ExportPopup = By.xpath("//div[@id='divSuccess']");
		Assert.assertTrue(driver.findElement(ExportPopup).isDisplayed());
		ExtentSuccessMessage("Export Popup is visible");
		
		By SearchText = By.xpath("//input[@class='ng-pristine ng-untouched md-input ng-empty ng-valid-minlength ng-valid-maxlength ng-valid ng-valid-required']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SearchText));
		MoveToElementClick(element);
		String custnameString1 = StringUtils.substringAfter(ApplicantInfo.CustomerName," ");
		System.out.println(custnameString1);
		writeText(SearchText,custnameString1 + Keys.ENTER);
		ExtentSuccessMessage("Customer name has been Searched");

		waitForElement(3000);
		By ReqNumber = By.xpath("(//a[@class='edit-list-anchor ng-binding'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ReqNumber));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked On SR Number");
		
		waitForElement(3000);
		By Activities = By.cssSelector("#page-wrapper > div > ui-view > div:nth-child(2) > div.col-xl-9.col-lg-6.left-section.details > div > div > ul > li:nth-child(3) > a");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Activities));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked On Acivities Section");
		
		waitForElement(4000);
		By EditAcivity = By.xpath("(//button[@title='Edit Activity'])[1]");
		wait.until(ExpectedConditions.elementToBeClickable(EditAcivity));
		click(EditAcivity);
		ExtentSuccessMessage("Clicked On Edit Acivities Button");
		
		waitForElement(4000);
        WebElement StatusDD=driver.findElement(By.xpath("(//select[@class='ng-pristine ng-untouched ng-valid ng-not-empty ng-valid-required'])[3]"));		
		Select s = new Select(StatusDD);
		s.selectByVisibleText("Closed");
		ExtentSuccessMessage("Status is been changed to close");
		
		By SaveButton = By.xpath("//button[@class='btn btn-default green']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SaveButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked On Save Acivities Button");
		
		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Activities));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked On Acivities Section");
		
		waitForElement(3000);
		By FirstStatus = By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[3]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(FirstStatus));
        String firststatus=element.getText();
		System.out.println(firststatus);
		
		Assert.assertEquals(firststatus, "Closed");
		ExtentSuccessMessage("Closed Status is visible in Grid");
		
		waitForElement(3000);
		wait.until(ExpectedConditions.elementToBeClickable(EditAcivity));
		click(EditAcivity);
		ExtentSuccessMessage("Clicked On Edit Acivities Button");
		
		waitForElement(5000);
		WebElement StatusDD1=driver.findElement(By.xpath("(//select[@class='ng-pristine ng-untouched ng-valid ng-not-empty ng-valid-required'])[3]"));
		Select s1 = new Select(StatusDD1);
		s1.selectByVisibleText("Closed");
		ExtentSuccessMessage("Status is been changed to close");
		
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SaveButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked On Save Acivities Button");
		
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Activities));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked On Acivities Section");
		
		By SecondStatus = By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[13]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SecondStatus));
		String secondtext=element.getText();
		System.out.println(secondtext);
		
		Assert.assertEquals(secondtext, "Closed");
		ExtentSuccessMessage("Status is been chamged to close for Second Activity");

		waitForElement(2000);
		By BasicInfo = By.cssSelector("#page-wrapper > div > ui-view > div:nth-child(2) > div.col-xl-9.col-lg-6.left-section.details > div > div > ul > li:nth-child(2) > a");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(BasicInfo));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked On Basic Info Section");
		

		waitForElement(3000);
        By EditButton = By.xpath("//button[@name='editServiceRequestBtn']");
        element = wait.until(ExpectedConditions.presenceOfElementLocated(EditButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked On Edit Button");
		
		By SRStatus = By.xpath("(//md-select-value[@class='md-select-value'])[6]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SRStatus));
		MoveToElementClick(element);
		By ClosedStatus = By.xpath("//md-option[@value='Closed']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClosedStatus));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked Staus as Close");

		By SRSaveButton = By.xpath("//button[@name='saveEditServiceRequestBtn']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SRSaveButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Save Button");

		waitForElement(8000);
		By StatusonTop = By.cssSelector("#page-wrapper > div > ui-view > div:nth-child(1) > div > h1 > ul > li:nth-child(3) > span");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(StatusonTop));
        String status =element.getText();
        System.out.println(status);
        
		waitForElement(5000);
        Assert.assertEquals(status, "Closed");
		ExtentSuccessMessage("Status has been changed to close on Top");
		
		By Statuss = By.xpath("//*[text()='Status:']//parent::span[@class='form-group view-page ng-scope']/span"); //Old Xpath :- (//span[@class='form-group view-page ng-scope'])[8]/span
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Statuss));
        String status1 =element.getText();
        System.out.println(status1);
        
        Assert.assertEquals(status1, "Closed");
		ExtentSuccessMessage("Status has been changed to close in UI");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	public String writeCustomernameToExcel(String nameText, String sheetname) throws IOException {
		String excelFilePath = ".\\src\\test\\resources\\TestData.xlsx";
        FileInputStream inputStream = new FileInputStream(excelFilePath);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        String sheetName_update = sheetname;
        Sheet sheet = workbook.getSheet(sheetname);
        int rowIndex = 1;  
        int columnIndex = 5;
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
	
	
	public void serviceCreateNewService(CensusInfo ApplicantInfo) throws InterruptedException, IOException, AWTException {

		
		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Customers));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customers");
		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NewCustomer));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on New Customers");
		String Firstname ="AutoServiceReq";
		writeText(CustFName,Firstname);
		waitForElement(1000);
		String Lastname =randomName();
		writeText(CustLName,Lastname);
		String name = Firstname+Lastname;
		writeCustomernameToExcel(name,"TC CE2");
		System.out.println(name);
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ContactInfo));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Contact Information");
		waitForElement(2000); 
		writeText(Cellphone,generatePhoneNumber());
		waitForElement(2000);
		String email = Firstname+Lastname+"@yopmail.com";
		System.out.println(email);
		writeText(CustMail,email);
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PrincipalAdress));
		MoveToElementClick(element);
		waitForElement(2000);
		ExtentSuccessMessage("Clicked on PrincipalAddress");
		writeText(PricipalAD1,"Testing");
		ExtentSuccessMessage("Entered the Address"); 
		waitForElement(2000);  
		writeText(PrincipalZipCode,"33233"); 
		waitForElement(2000);
		ExtentSuccessMessage("Entered the ZipCode");  
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MailingAddress));
		MoveToElementClick(element);
		waitForElement(3000);	 
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustSubmit));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Submit");	

		waitForElement(11000);
		By ServiceOption = By.xpath("//a[@id='menu_service']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceOption));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Service Tile");
		
	    waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NewServiceReq));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on NewServiceRequest Button"); 
		
	    waitForElement(5000); 
		By SearchCustomer = By.xpath("//input[@name='Customer']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SearchCustomer));
		MoveToElementClick(element);
		String customer = Firstname + " "+Lastname ;
		System.out.println(customer);
		writeText(SearchCustomer,customer);
		ExtentSuccessMessage("Customer name has been entered"); 
		
		By SearchButton = By.xpath("(//i[@class='glyphicon glyphicon-search'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SearchButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Search Button"); 
		
	    waitForElement(5000);
		if(driver.findElement(By.xpath("//h5[@class='modal-title']")).isDisplayed())
		{
			By SelectOption = By.xpath("//input[@name='selCustomer']");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectOption));
			MoveToElementClick(element);
			ExtentSuccessMessage("Clicked on customer after search"); 
			
			By OkButton = By.xpath("(//button[@class='btn btn-default green pull-right'])[3]");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(OkButton));
			MoveToElementClick(element);
			ExtentSuccessMessage("Clicked on OK Button"); 
			
		}
		else {	ExtentSuccessMessage("Customer is not available"); } 
		
		By RequestType = By.xpath("//md-select[@name='SrType']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(RequestType));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Request Type Dropdown");
		By NewEnrollment = By.xpath("(//md-option[@value='New Enrollment'])[3]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NewEnrollment));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Request Type as New Enrollment");
		
		By RequestSubType = By.xpath("//md-select[@name='SRActivitySubType']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(RequestSubType));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Request SubType");
		By NewEnrollment1 = By.xpath("(//md-option[@value='New Enrollment'])[4]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NewEnrollment1));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Request Type as New Enrollment");
		
		
		By Product = By.xpath("(//md-select[@name='SRProduct'])[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Product));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Product Dropdown");
		By CE = By.xpath("(//md-option[@value='CE'])[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CE));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on CE Option");
		
		By ActionedBy = By.xpath("//md-select[@name='SRActionedBy']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ActionedBy));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Actioned By");
        By QA = By.xpath("//md-option[@value='QA']");
        element = wait.until(ExpectedConditions.presenceOfElementLocated(QA));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on QA option");
		
		By TextArea = By.xpath("(//textarea[@class='form-control ng-pristine ng-untouched md-input ng-empty ng-valid ng-valid-required'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(TextArea));
		MoveToElementClick(element);
		String text = "Hello ! These SR is created via Automation";
		writeText(TextArea,text);
		ExtentSuccessMessage("Eneterd the message in TextArea");
		
		By SubmitButton = By.xpath("(//button[@class='btn btn-default green'])[4]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SubmitButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Submit Button");
		
	    waitForElement(5000);
	    By SearchField = By.xpath("//input[@class='ng-pristine ng-untouched md-input ng-empty ng-valid-minlength ng-valid-maxlength ng-valid ng-valid-required']");
	    element = wait.until(ExpectedConditions.presenceOfElementLocated(SearchField));
		MoveToElementClick(element);
		writeText(SearchField,customer + Keys.ENTER);
		ExtentSuccessMessage("Customer name has been serached");
		
		By CustomerName = By.xpath("(//a[@class='edit-list-anchor ng-binding'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerName));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on ServiceReq after creating SR");
		
	    waitForElement(4000);
		By Requesttype = By.xpath("(//span[@class='form-group view-page ng-scope'])[3]/span");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Requesttype));
        String type =element.getText();
        System.out.println(type);
        Assert.assertEquals(type, "New Enrollment");
		ExtentSuccessMessage("Assertion for Request Type is done");

		By Email = By.xpath("//li[@class='nav-item user-details ng-binding']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Email));
        String emailtext =element.getText();
        System.out.println(emailtext);
        Assert.assertEquals(emailtext, email);
		ExtentSuccessMessage("Assertion for email is done");
		
	    waitForElement(2000);
		By AddActivity = By.xpath("//button[@id='AddActivity']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AddActivity));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Add Activity Button");
		 
	    waitForElement(4000);
        if(driver.findElement(By.xpath("//h5[@class='modal-title']")).isDisplayed())
        {
        	WebElement SelectSR = driver.findElement(By.xpath("(//select[@ng-selected='item'])[1]"));
    		Select select = new Select(SelectSR);
    		select.selectByVisibleText("Others");
    		ExtentSuccessMessage("Selected Activity Type");

        	
        	By SaveButton = By.xpath("//button[@class='btn btn-default green']");
        	element = wait.until(ExpectedConditions.presenceOfElementLocated(SaveButton));
    		MoveToElementClick(element); 
    		ExtentSuccessMessage("Clicked on Save Button");

        	
        }
        
        Thread.sleep(5000);
        By Activities = By.cssSelector("#page-wrapper > div > ui-view > div:nth-child(2) > div.col-xl-9.col-lg-6.left-section.details > div > div > ul > li:nth-child(3) > a");
        element = wait.until(ExpectedConditions.presenceOfElementLocated(Activities));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Actitvities Section");
		
        Thread.sleep(5000);
		By ActivityGrid = By.xpath("//div[@class='ui-grid-row ng-scope']");
		Assert.assertTrue(driver.findElement(ActivityGrid).isDisplayed());
		ExtentSuccessMessage("Activity is been displayed in the grid");
		
		actions();	
		
		
	}
	
	public void actions() throws InterruptedException, AWTException
	{
		
		waitForElement(2000);
	    element = wait.until(ExpectedConditions.presenceOfElementLocated(NotesSection));
		MoveToElementClick(element);
		String Note = "This is created Via Automation";
		writeText(NotesSection, Note);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NotesConfirmationButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Note has been added");
		
		waitForElement(8000);		
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentActionNoteInc));
		 NoteText  = element.getText();
		System.out.println("-----------"+ NoteText+"------------");
		Assert.assertEquals(Note, NoteText);
		ExtentSuccessMessage("Assertion has been done");
		
	
	    waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ActionEmailIcon));
		MoveToElementClick(element);
		
		waitForElement(2000);
		By EmailAddressDD = By.xpath("//md-select[@role='listbox']");
		wait.until(ExpectedConditions.elementToBeClickable(EmailAddressDD));
		click(EmailAddressDD);
		By EmailAddressDDOPtion = By.xpath("//md-option[@value='customerengage@benefitalign.com']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EmailAddressDDOPtion));
		MoveToElementClick(element);
		
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
	
	    waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentEmailInc));
		NoteText  = element.getText();
		System.out.println("-----------"+ NoteText+"------------");
		Assert.assertEquals(AgentEmailAction, NoteText);
		ExtentSuccessMessage("Assertion has been done");
				
	   
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ActionAttachment));
		MoveToElementClick(element);
		
		waitForElement(3000);
		By DocumentDD1 =  By.cssSelector("#filter-by > div:nth-child(1) > form > div.form-group.ng-isolate-scope > select");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(DocumentDD1));
		Select s1 = new Select(element);
		s1.selectByVisibleText("Other");
//		
//		element = wait.until(ExpectedConditions.presenceOfElementLocated(DocumentDD));
//		wait.until(ExpectedConditions.elementToBeClickable(DocumentDD));
//		click(DocumentDD);
//		waitForElement(500);
//       
//        wait.until(ExpectedConditions.elementToBeClickable(DocumentDDOption));
//		click(DocumentDDOption);	
		wait.until(ExpectedConditions.elementToBeClickable(DocumentAttachFileButton));
		click(DocumentAttachFileButton);
		
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
		Thread.sleep(1000);
	
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AttachmentConfirmationButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Attachment has been added");
		
	    Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(AttachmentInc).isDisplayed());
		ExtentSuccessMessage("Assertion has been done");
		

		
		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ActionTask));
		MoveToElementClick(element);
		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ActivityDD));
		//element.click();
		Thread.sleep(600);
		Select select = new Select(element);
		select.selectByVisibleText("Send Email");
		Thread.sleep(1000);
		
		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PriorityDD));
		element.click();
		Thread.sleep(500);
		Select s = new Select(element);
		s.selectByVisibleText("Low");
		Thread.sleep(1000);
		
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CommentTextArea));
		MoveToElementClick(element);
		writeText(CommentTextArea, "This Task is created VIA Automation" );
		Thread.sleep(1000);
		
		element = wait.until(ExpectedConditions.presenceOfElementLocated(TaskConfirmationButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Task has been added");
		
		waitForElement(4000);
		
		Assert.assertTrue(driver.findElement(TaskInc).isDisplayed());
		ExtentSuccessMessage("Assertion has been done");
		
		
		
		
		
		
		
	}
	
	
	

	public void customerContactCard() throws InterruptedException {
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Customers));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customers");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
		MoveToElementClick(element);
		ExtentSuccessMessage("Customer has been clicked");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerSendContactCard));
		MoveToElementClick(element);
		ExtentSuccessMessage("Customer Contact has been clicked");
		waitForElement(6000);
		// writeText(CustomerSendContactCard,);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerContactSend));
		MoveToElementClick(element);
		ExtentSuccessMessage("Customer send the contact");
		waitForElement(6000);
	}

	public void customerImportCustomerAndPolicies() throws InterruptedException, AWTException {
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Customers));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customers");
		waitForElement(8000);
		// click(CustomerImport);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerImport));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Import Customers and Policies");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerBulkImport));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Bulk Import");
		waitForElement(6000);
		// element = wait.until(ExpectedConditions.elementToBeClickable(SelectFile));
		// MoveToElementClick(element);
		Base_Class.MouseClick(SelectFile);
		ExtentSuccessMessage("File has been selected");
		waitForElement(6000);

		Robot robot1 = new Robot();
		String filePath = System.getProperty("user.dir") + "\\Upload\\Default_Template (1).xlsx";
		StringSelection stringSelection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		robot1.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);

		robot1.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);

		robot1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		ExtentSuccessMessage("File is been Uploaded");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerImportSubmit));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Submit");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(FileSubmitOk));
		MoveToElementClick(element);
		Thread.sleep(3000);

	}

	public void customerAdvancedSearch2() throws InterruptedException {
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Customers));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customers");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedSearch));
		MoveToElementClick(element);
		ExtentSuccessMessage("Advanced search has been clicked");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerADSearchDD));
		MoveToElementClick(element);
		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerAdActive));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Open");
		waitForElement(7000);
		click(OppSearch);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerADSearchDD));
		MoveToElementClick(element);
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerAdActive));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Active");
		waitForElement(7000);
		click(OppSearch);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerADSearchDD));
		MoveToElementClick(element);
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerAdInActive));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected InActive");
		waitForElement(7000);
		click(OppSearch);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerADSearchDD));
		MoveToElementClick(element);
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerAdprospect));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Prospect");
		waitForElement(7000);
		click(OppSearch);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerADSearchDD));
		MoveToElementClick(element);
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerAdDecesed));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Deceased");
		waitForElement(7000);
		click(OppSearch);

	}

	public void customerAdvancedSearch() throws InterruptedException {
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Customers));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customers");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedSearch));
		MoveToElementClick(element);
		ExtentSuccessMessage("Advanced search has been clicked");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerADSearchDD));
		MoveToElementClick(element);
		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerAdActive));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Open");
		waitForElement(7000);
		click(OppSearch);
		waitForElement(10000);
		/*
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(CustomerADSearchDD));
		 * MoveToElementClick(element); waitForElement(3000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(CustomerAdActive));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Active");
		 * waitForElement(7000); click(OppSearch); waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(CustomerADSearchDD));
		 * MoveToElementClick(element); waitForElement(3000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(CustomerAdInActive));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected InActive");
		 * waitForElement(7000); click(OppSearch); waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(CustomerADSearchDD));
		 * MoveToElementClick(element); waitForElement(3000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(CustomerAdprospect));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Prospect");
		 * waitForElement(7000); click(OppSearch); waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(CustomerADSearchDD));
		 * MoveToElementClick(element); waitForElement(3000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(CustomerAdDecesed));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Deceased");
		 * waitForElement(7000); click(OppSearch);
		 */

	}

	public void customerFilter2() throws InterruptedException {
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Customers));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customers");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerFilterStatus));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customer Filter Status");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerFilActive));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected the Active Status");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerFilActive));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerInActive));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected the In Active Status");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerInActive));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerFilProspet));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected the Prospect Status");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerFilProspet));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerFilDecesed));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected the Deceded Status");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerFilDecesed));
		MoveToElementClick(element);
		waitForElement(6000);

	}

	public void customerFilter() throws InterruptedException {
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Customers));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customers");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerFilterStatus));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customer Filter Status");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerFilActive));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected the Active Status");
		waitForElement(10000);
		/*
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(CustomerFilActive));
		 * MoveToElementClick(element); waitForElement(6000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(CustomerInActive));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Selected the In Active Status"); waitForElement(10000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(CustomerInActive));
		 * MoveToElementClick(element); waitForElement(6000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(CustomerFilProspet));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Selected the Prospect Status"); waitForElement(10000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(CustomerFilProspet));
		 * MoveToElementClick(element); waitForElement(6000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(CustomerFilDecesed));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Selected the Deceded Status"); waitForElement(10000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(CustomerFilDecesed));
		 * MoveToElementClick(element); waitForElement(6000);
		 */

	}

	public void customerActions() throws InterruptedException, AWTException {
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Customers));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customers");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
		MoveToElementClick(element);
		ExtentSuccessMessage("Customer has been clicked");
		waitForElement(6000);
		writeText(SalesLeadNotes, "abcdefghij");
		ExtentSuccessMessage("Note text is entered");
		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SaveNote));
		MoveToElementClick(element);
		ExtentSuccessMessage("Note is saved");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesEmail));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked  on Sales Email");
		Thread.sleep(6000);
		writeText(SalesEmailID, randomName() + "@" + "yopmail.com");
		Thread.sleep(6000);
		writeText(EmailSubject, "Testing");
		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SaveEmail));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on save Email");
		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesTask));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on sales task");
		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(TaskSave));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Task Save");

		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AttachFile));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Attach File");
		Thread.sleep(9000);
		WebElement dropdown = driver.findElement(AttachDropDown);

		String optionValue = "string:Application";

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = arguments[1];", dropdown, optionValue);
		js.executeScript("arguments[0].dispatchEvent(new Event('change'))", dropdown);
		waitForElement(4000);
		Base_Class.MouseClick(By.xpath("//div[@ng-model='myFiles']"));
		ExtentSuccessMessage("Select File has been Clicked");
		waitForElement(5000);

		Robot robot1 = new Robot();
		String filePath = System.getProperty("user.dir") + "\\Upload\\Default_Template (1).xlsx";
		StringSelection stringSelection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		robot1.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);

		robot1.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);

		robot1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		ExtentSuccessMessage("File is been Uploaded");
		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(AddressSave));
		MoveToElementClick(element);

	}

	public void customerCreateServiceRequest() throws InterruptedException {
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Customers));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customers");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
		MoveToElementClick(element);
		ExtentSuccessMessage("Customer has been clicked");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CreateServiceRequest));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Create Service Request ");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(RequestType));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(RequestStatus));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected the Request type Status");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(RequestSubType));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(RequestSubStatus));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected the Request type Sub Status");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(RequestSubmit));
		MoveToElementClick(element);
		ExtentSuccessMessage("Cliked on submit");
		waitForElement(6000);
	}

	public void customerCreateOpportunity() throws InterruptedException {
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Customers));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customers");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
		MoveToElementClick(element);
		ExtentSuccessMessage("Customer has been clicked");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustcreateOpp));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on create opportunity");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustOppSubmit));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on submit");
		waitForElement(6000);

	}

	public void createNewCustomer() throws InterruptedException {
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Customers));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customers");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NewCustomer));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on New Customers");
		writeText(CustFName, "lohith");
		waitForElement(4000);
		writeText(CustLName, randomName());
		waitForElement(6000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(ContactInfo));
		MoveToElementClick(element);

		ExtentSuccessMessage("Clicked on Contact Information");
		waitForElement(6000);
		writeText(Cellphone, "9876789678");
		waitForElement(6000);
		writeText(CustMail, "lohi.11@yopmail.com");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PrincipalAdress));
		MoveToElementClick(element);
		waitForElement(6000);
		ExtentSuccessMessage("Clicked on PrincipalAddress");
		writeText(PricipalAD1, "Testing");
		ExtentSuccessMessage("Entered the Address");
		waitForElement(6000);
		writeText(PrincipalZipCode, "33233");
		waitForElement(6000);
		ExtentSuccessMessage("Entered the ZipCode");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MailingAddress));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustSubmit));
		MoveToElementClick(element);
		waitForElement(6000);
		ExtentSuccessMessage("Clicked on Submit");
		WebElement element = driver
				.findElement(By.xpath("//button[contains(text(),'Proceed with Customer creation')]"));

		// Check if the element is displayed
		if (element.isDisplayed()) {
			// Click on the element
			element.click();
		} else {
			System.out.println("Element is not displayed, so cannot click.");
		}
		Thread.sleep(8000);
	}

	public void salespolicyImport() throws InterruptedException, AWTException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales button");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesPolicy));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Policy");
		waitForElement(10000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(ImportCustmerPolicies));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Import Customers and Policies");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(BulkImport));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Bulk Import");
		waitForElement(6000);

		Base_Class.MouseClick(SelectFile);
		ExtentSuccessMessage("File has been selected");
		waitForElement(6000);

		Robot robot1 = new Robot();
		String filePath = System.getProperty("user.dir") + "\\Upload\\Default_Template (1).xlsx";
		StringSelection stringSelection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		robot1.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);

		robot1.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);

		robot1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		ExtentSuccessMessage("File is been Uploaded");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(FileSubmit));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Submit");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(FileSubmitOk));
		MoveToElementClick(element);
		Thread.sleep(3000);

	}

	public void salesPolicyAdvancedSearch2() throws InterruptedException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales button");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesPolicy));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Policy");
		waitForElement(6000);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedSearch));
		MoveToElementClick(element);
		ExtentSuccessMessage("Advanced search has been clicked");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADCancel));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Cancel");
		waitForElement(9000);
		click(QuoteAdSearch);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyTestMM));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Status TestMM");
		waitForElement(9000);
		click(QuoteAdSearch);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyEnrolled));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Enrolled");
		waitForElement(9000);
		click(QuoteAdSearch);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyEnrollPaylater));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected EnrollPaylater");
		waitForElement(9000);
		click(QuoteAdSearch);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyFullfill));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Fullfill");
		waitForElement(9000);
		click(QuoteAdSearch);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyInProgress));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected InProgress");
		waitForElement(9000);
		click(QuoteAdSearch);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyAdInActive));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected InActive");
		waitForElement(9000);
		click(QuoteAdSearch);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyAdIncomplete));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Incomplete");
		waitForElement(9000);
		click(QuoteAdSearch);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyLockedEligibility));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Locked Eligibility");
		waitForElement(9000);
		click(QuoteAdSearch);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyAdLockedEnrollment));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Locked Enrollment");
		waitForElement(9000);
		click(QuoteAdSearch);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyAdLockedFullfillment));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Locked Fullfillment");
		waitForElement(9000);
		click(QuoteAdSearch);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		MoveToElementClick(element);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyNeedmoreInfo));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Need More Information");
		waitForElement(9000);
		click(QuoteAdSearch);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		MoveToElementClick(element);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyAdPending));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Pending");
		waitForElement(9000);
		click(QuoteAdSearch);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		MoveToElementClick(element);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyAdPendeningCancellation));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Pendening Cancellation");
		waitForElement(9000);
		click(QuoteAdSearch);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		MoveToElementClick(element);
		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyAdPendeningCancellation));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Pendening Cancellation");
		waitForElement(9000);
		click(QuoteAdSearch);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		MoveToElementClick(element);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyAdPendingDEAutomation));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Pending DE Automation");
		waitForElement(9000);
		click(QuoteAdSearch);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		MoveToElementClick(element);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyAdPremiumPaid));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected PremiumPaid");
		waitForElement(9000);
		click(QuoteAdSearch);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		MoveToElementClick(element);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyAdSubmitted));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Submitted");
		waitForElement(9000);
		click(QuoteAdSearch);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		MoveToElementClick(element);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyAdTerminated));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Terminated");
		waitForElement(9000);
		click(QuoteAdSearch);
		waitForElement(8000);

	}

	public void salesPolicyAdvancedSearch() throws InterruptedException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales button");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesPolicy));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Policy");
		waitForElement(6000);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedSearch));
		MoveToElementClick(element);
		ExtentSuccessMessage("Advanced search has been clicked");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADCancel));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Cancel");
		waitForElement(9000);
		click(QuoteAdSearch);
		waitForElement(8000);
		/*
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(8000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyTestMM));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Status TestMM");
		 * waitForElement(9000); click(QuoteAdSearch); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(8000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyEnrolled));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Enrolled");
		 * waitForElement(9000); click(QuoteAdSearch); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(8000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyEnrollPaylater))
		 * ; MoveToElementClick(element);
		 * ExtentSuccessMessage("Selected EnrollPaylater"); waitForElement(9000);
		 * click(QuoteAdSearch); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(8000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyFullfill));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Fullfill");
		 * waitForElement(9000); click(QuoteAdSearch); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(8000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyInProgress));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected InProgress");
		 * waitForElement(9000); click(QuoteAdSearch); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(8000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyAdInActive));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected InActive");
		 * waitForElement(9000); click(QuoteAdSearch); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(8000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyAdIncomplete));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Incomplete");
		 * waitForElement(9000); click(QuoteAdSearch); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(8000);
		 * element = wait.until(ExpectedConditions.presenceOfElementLocated(
		 * PolicyLockedEligibility)); MoveToElementClick(element);
		 * ExtentSuccessMessage("Selected Locked Eligibility"); waitForElement(9000);
		 * click(QuoteAdSearch); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(8000);
		 * element = wait.until(ExpectedConditions.presenceOfElementLocated(
		 * PolicyAdLockedEnrollment)); MoveToElementClick(element);
		 * ExtentSuccessMessage("Selected Locked Enrollment"); waitForElement(9000);
		 * click(QuoteAdSearch); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(8000);
		 * element = wait.until(ExpectedConditions.presenceOfElementLocated(
		 * PolicyAdLockedFullfillment)); MoveToElementClick(element);
		 * ExtentSuccessMessage("Selected Locked Fullfillment"); waitForElement(9000);
		 * click(QuoteAdSearch); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		 * MoveToElementClick(element); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyNeedmoreInfo));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Selected Need More Information"); waitForElement(9000);
		 * click(QuoteAdSearch); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		 * MoveToElementClick(element); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyAdPending));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Pending");
		 * waitForElement(9000); click(QuoteAdSearch); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		 * MoveToElementClick(element); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(
		 * PolicyAdPendeningCancellation)); MoveToElementClick(element);
		 * ExtentSuccessMessage("Selected Pendening Cancellation");
		 * waitForElement(9000); click(QuoteAdSearch); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		 * MoveToElementClick(element); waitForElement(5000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(
		 * PolicyAdPendeningCancellation)); MoveToElementClick(element);
		 * ExtentSuccessMessage("Selected Pendening Cancellation");
		 * waitForElement(9000); click(QuoteAdSearch); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		 * MoveToElementClick(element); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(
		 * PolicyAdPendingDEAutomation)); MoveToElementClick(element);
		 * ExtentSuccessMessage("Selected Pending DE Automation"); waitForElement(9000);
		 * click(QuoteAdSearch); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		 * MoveToElementClick(element); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyAdPremiumPaid));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected PremiumPaid");
		 * waitForElement(9000); click(QuoteAdSearch); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		 * MoveToElementClick(element); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyAdSubmitted));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Submitted");
		 * waitForElement(9000); click(QuoteAdSearch); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		 * MoveToElementClick(element); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyAdTerminated));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Terminated");
		 * waitForElement(9000); click(QuoteAdSearch); waitForElement(8000);
		 */

	}

	public void salesPolicyFilter2() throws InterruptedException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales button");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesPolicy));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Policy");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyFilterStatus));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked Policy Filter Status");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyStatusCancel));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the Cancel status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyStatusCancel));
		MoveToElementClick(element);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyStatusEnrolled));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the Enrolled status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyStatusEnrolled));
		MoveToElementClick(element);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyEnrolledPlaylater));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the EnrolledPlaylater status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyEnrolledPlaylater));
		MoveToElementClick(element);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyStatusFullfill));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the Fullfill status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyStatusFullfill));
		MoveToElementClick(element);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyStatusInProgress));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the In progress status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyStatusInProgress));
		MoveToElementClick(element);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyStatusInActive));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the In Active status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyStatusInActive));
		MoveToElementClick(element);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyInComplete));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the InComplete status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyInComplete));
		MoveToElementClick(element);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyLockEligibility));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the LockEligibility status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyLockEligibility));
		MoveToElementClick(element);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyLockPayment));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the LockPayment status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyLockPayment));
		MoveToElementClick(element);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyLockEnrollment));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the LockEnrollment status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyLockEnrollment));
		MoveToElementClick(element);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyLockFullfillment));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the LockFullfillment status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyLockFullfillment));
		MoveToElementClick(element);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyNeedinfo));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the  Need information status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyNeedinfo));
		MoveToElementClick(element);
		waitForElement(10000);
		/*
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyPending));
		 * MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the  Pending status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyPending));
		 * MoveToElementClick(element); waitForElement(10000);
		 */
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PendingDE));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the Pending DE Automation status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PendingDE));
		MoveToElementClick(element);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PremiumPaid));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the Premium Paid status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PremiumPaid));
		MoveToElementClick(element);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicystatusSubmit));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the submitted status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicystatusSubmit));
		MoveToElementClick(element);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyTerminated));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the Policy Terminated status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyTerminated));
		MoveToElementClick(element);

	}

	public void salesPolicyFilter() throws InterruptedException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales button");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesPolicy));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Policy");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyFilterStatus));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked Policy Filter Status");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyStatusCancel));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the Cancel status");
		/*
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyStatusCancel));
		 * MoveToElementClick(element); waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyStatusEnrolled))
		 * ; MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the Enrolled status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyStatusEnrolled))
		 * ; MoveToElementClick(element); waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(
		 * PolicyEnrolledPlaylater)); MoveToElementClick(element);
		 * waitForElement(10000);
		 * ExtentSuccessMessage("Selected the EnrolledPlaylater status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(
		 * PolicyEnrolledPlaylater)); MoveToElementClick(element);
		 * waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyStatusFullfill))
		 * ; MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the Fullfill status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyStatusFullfill))
		 * ; MoveToElementClick(element); waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyStatusInProgress
		 * )); MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the In progress status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyStatusInProgress
		 * )); MoveToElementClick(element); waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyStatusInActive))
		 * ; MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the In Active status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyStatusInActive))
		 * ; MoveToElementClick(element); waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyInComplete));
		 * MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the InComplete status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyInComplete));
		 * MoveToElementClick(element); waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyLockEligibility)
		 * ); MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the LockEligibility status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyLockEligibility)
		 * ); MoveToElementClick(element); waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyLockPayment));
		 * MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the LockPayment status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyLockPayment));
		 * MoveToElementClick(element); waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyLockEnrollment))
		 * ; MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the LockEnrollment status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyLockEnrollment))
		 * ; MoveToElementClick(element); waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyLockFullfillment
		 * )); MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the LockFullfillment status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyLockFullfillment
		 * )); MoveToElementClick(element); waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyNeedinfo));
		 * MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the  Need information status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyNeedinfo));
		 * MoveToElementClick(element); waitForElement(10000); /* element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyPending));
		 * MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the  Pending status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyPending));
		 * MoveToElementClick(element); waitForElement(10000);
		 */
		/*
		 * element = wait.until(ExpectedConditions.presenceOfElementLocated(PendingDE));
		 * MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the Pending DE Automation status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PendingDE));
		 * MoveToElementClick(element); waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PremiumPaid));
		 * MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the Premium Paid status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PremiumPaid));
		 * MoveToElementClick(element); waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicystatusSubmit));
		 * MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the submitted status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicystatusSubmit));
		 * MoveToElementClick(element); waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyTerminated));
		 * MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the Policy Terminated status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyTerminated));
		 * MoveToElementClick(element);
		 */

	}

	public void salesPolicyActions() throws InterruptedException, AWTException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales button");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesPolicy));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Policy");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
		MoveToElementClick(element);
		ExtentSuccessMessage(" Lead has been clicked");
		waitForElement(8000);
		/*
		 * writeText(SalesLeadNotes,"abcdefghij");
		 * ExtentSuccessMessage("Note text is entered"); Thread.sleep(6000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(SaveNote));
		 * MoveToElementClick(element); ExtentSuccessMessage("Note is saved");
		 */
		WebElement element = driver.findElement(SalesLeadNotes);
		((JavascriptExecutor) driver).executeScript("arguments[0].value = 'Your text';", element);

		ExtentSuccessMessage("Note text is entered");
		Thread.sleep(6000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(SaveNote));
		MoveToElementClick(element);
		ExtentSuccessMessage("Note is saved");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesEmail));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked  on Sales Email");
		Thread.sleep(6000);
		writeText(SalesEmailID, randomName() + "@" + "yopmail.com" + Keys.ENTER);
		Thread.sleep(6000);
		writeText(EmailSubject, "Testing");
		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SaveEmail));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on save Email");
		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesTask));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on sales task");
		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(TaskSave));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Task Save");

		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AttachFile));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Attach File");
		Thread.sleep(9000);

		WebElement dropdown = driver.findElement(AttachDropDown);

		String optionValue = "string:Application";

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = arguments[1];", dropdown, optionValue);

		waitForElement(4000);
		Base_Class.MouseClick(By.xpath("//div[@ng-model='myFiles']"));
		ExtentSuccessMessage("Select File has been Clicked");
		waitForElement(3000);

		Robot robot1 = new Robot();
		String filePath = System.getProperty("user.dir") + "\\Upload\\Default_Template (1).xlsx";
		StringSelection stringSelection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		robot1.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);

		robot1.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);

		robot1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		ExtentSuccessMessage("File is been Uploaded");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AddressSave));
		MoveToElementClick(element);
		Thread.sleep(1000);

	}

	public void salesTerminatePolicy() throws InterruptedException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales button");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesPolicy));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Policy");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
		MoveToElementClick(element);
		ExtentSuccessMessage(" Lead has been clicked");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyCancel));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Cancel");
		waitForElement(9000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyCancelDD));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyDDStatus));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected the Terminated");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyCancelSubmit));
		MoveToElementClick(element);
		ExtentSuccessMessage("Cliked on submit");
		waitForElement(6000);

	}

	public void salesPolicyCreateNewPolicy() throws InterruptedException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales button");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesPolicy));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Policy");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CreatePolicy));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Create Policy");
		waitForElement(9000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicySearchIcon));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Policy Search Icon");

		waitForElement(8000);
		WebElement ele = driver.findElement(PolicySearchText);
		ele.clear();
		ele.sendKeys("Automation");
		waitForElement(9000);
		// writeText(PolicySearchText,"Automation");
		ExtentSuccessMessage("Searched the Custmer");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyCustmerSearchIcon));
		MoveToElementClick(element);
		waitForElement(9000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectCustmer));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected the Customer");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerOk));
		MoveToElementClick(element);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ProductCategory));
		MoveToElementClick(element);

		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(MedicalLOB));
		MoveToElementClick(element);
		ExtentSuccessMessage("Medical has been selected");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Carrier));
		MoveToElementClick(element);
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectCarrier));
		MoveToElementClick(element);
		ExtentSuccessMessage("Carrier has been selected");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesType));
		MoveToElementClick(element);
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesNew));
		MoveToElementClick(element);
		ExtentSuccessMessage("SalesType has been selected");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyStatus));
		MoveToElementClick(element);
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyActive));
		MoveToElementClick(element);
		ExtentSuccessMessage("PolicyStatus has been selected");
		waitForElement(8000);
		writeText(PolicyEFDate, "12/12/2024" + Keys.ENTER);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyAOR));
		MoveToElementClick(element);
		waitForElement(8000);

		WebElement elep = driver.findElement(AoRSearchText);
		elep.clear();
		elep.sendKeys("Automation");
		waitForElement(9000);

		// writeText(AoRSearchText,"Automation");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AORSearchIcon));
		MoveToElementClick(element);

		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectAOR));
		MoveToElementClick(element);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AorOk));
		MoveToElementClick(element);
		ExtentSuccessMessage("AOR has been selected");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicySubmit));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Policy submit");
	}

	public void salesQuoteAdvancedSearch2() throws InterruptedException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales button");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesQuote));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Quote");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedSearch));
		MoveToElementClick(element);
		ExtentSuccessMessage("Advanced search has been clicked");
		waitForElement(8000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdStatusDD));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdCancel));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Cancel");
		waitForElement(9000);
		click(QuoteAdSearch);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdStatusDD));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdCreated));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Created");
		waitForElement(10000);
		click(QuoteAdSearch);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdStatusDD));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdDeclined));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Declined");
		waitForElement(10000);
		click(QuoteAdSearch);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdStatusDD));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdExpired));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Expired");
		waitForElement(10000);
		click(QuoteAdSearch);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdStatusDD));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdInActive));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Active");
		waitForElement(10000);
		click(QuoteAdSearch);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdStatusDD));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdInProgress));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected InProgress");
		waitForElement(10000);
		click(QuoteAdSearch);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdStatusDD));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdInstalled));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Installed");
		waitForElement(10000);
		click(QuoteAdSearch);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdStatusDD));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdInstallInProgress));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Install In Progress");
		waitForElement(10000);
		click(QuoteAdSearch);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdStatusDD));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdTerminated));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Terminated");
		waitForElement(10000);
		click(QuoteAdSearch);

	}

	public void salesQuoteAdvancedSearch() throws InterruptedException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales button");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesQuote));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Quote");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedSearch));
		MoveToElementClick(element);
		ExtentSuccessMessage("Advanced search has been clicked");
		waitForElement(8000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdStatusDD));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdCancel));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Cancel");
		waitForElement(9000);
		click(QuoteAdSearch);
		waitForElement(8000);
		/*
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdStatusDD));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(10000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdCreated));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Created");
		 * waitForElement(10000); click(QuoteAdSearch); waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdStatusDD));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(10000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdDeclined));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Declined");
		 * waitForElement(10000); click(QuoteAdSearch); waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdStatusDD));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(10000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdExpired));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Expired");
		 * waitForElement(10000); click(QuoteAdSearch); waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdStatusDD));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(10000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdInActive));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Active");
		 * waitForElement(10000); click(QuoteAdSearch); waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdStatusDD));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(10000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdInProgress));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected InProgress");
		 * waitForElement(10000); click(QuoteAdSearch); waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdStatusDD));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(10000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdInstalled));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Installed");
		 * waitForElement(10000); click(QuoteAdSearch); waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdStatusDD));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(10000);
		 * element = wait.until(ExpectedConditions.presenceOfElementLocated(
		 * QuoteAdInstallInProgress)); MoveToElementClick(element);
		 * ExtentSuccessMessage("Selected Install In Progress"); waitForElement(10000);
		 * click(QuoteAdSearch); waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdStatusDD));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(10000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdTerminated));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Terminated");
		 * waitForElement(10000); click(QuoteAdSearch);
		 */

	}

	public void SalesQuotesFilters2() throws InterruptedException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales button");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesQuote));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Quote");
		waitForElement(10000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteStatus));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Quote status");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteCancel));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the cancel status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteCancel));
		MoveToElementClick(element);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteCreated));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the Created status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteCreated));
		MoveToElementClick(element);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteDeclined));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the Declined status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteDeclined));
		MoveToElementClick(element);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteExpire));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the Expire status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteExpire));
		MoveToElementClick(element);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteInprogress));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected theIn progress status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteInprogress));
		MoveToElementClick(element);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteInactive));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the Inactive status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteInactive));
		MoveToElementClick(element);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteInstallinprogress));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the Install Inprogress status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteInstallinprogress));
		MoveToElementClick(element);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteInstall));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the Install status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteInstall));
		MoveToElementClick(element);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteTerminated));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the Terminated status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteTerminated));
		MoveToElementClick(element);
	}

	public void SalesQuotesFilters() throws InterruptedException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales button");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesQuote));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Quote");
		waitForElement(8000);
//	 driver.navigate().refresh();
//	 waitForElement(7000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteStatus));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Quote status");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteCancel));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the cancel status");
		/*
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteCancel));
		 * MoveToElementClick(element); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteCreated));
		 * MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the Created status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteCreated));
		 * MoveToElementClick(element); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteDeclined));
		 * MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the Declined status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteDeclined));
		 * MoveToElementClick(element); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteExpire));
		 * MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the Expire status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteExpire));
		 * MoveToElementClick(element); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteInprogress));
		 * MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected theIn progress status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteInprogress));
		 * MoveToElementClick(element); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteInactive));
		 * MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the Inactive status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteInactive));
		 * MoveToElementClick(element); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteInstallinprogress
		 * )); MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the Install Inprogress status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteInstallinprogress
		 * )); MoveToElementClick(element); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteInstall));
		 * MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the Install status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteInstall));
		 * MoveToElementClick(element); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteTerminated));
		 * MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the Terminated status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteTerminated));
		 * MoveToElementClick(element);
		 */

	}

	public void Sales_Quotes_QuotesActions() throws InterruptedException, AWTException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales button");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesQuote));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Quote");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
		MoveToElementClick(element);
		ExtentSuccessMessage(" Lead has been clicked");
		waitForElement(8000);

		/*
		 * writeText(SalesLeadNotes,"abcdefghij");
		 * ExtentSuccessMessage("Note text is entered"); Thread.sleep(6000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(SaveNote));
		 * MoveToElementClick(element);
		 */
		WebElement element = driver.findElement(SalesLeadNotes);
		((JavascriptExecutor) driver).executeScript("arguments[0].value = 'Your text';", element);

		ExtentSuccessMessage("Note text is entered");
		Thread.sleep(6000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(SaveNote));
		MoveToElementClick(element);
		ExtentSuccessMessage("Note is saved");
		Thread.sleep(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesEmail));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked  on Sales Email");
		Thread.sleep(6000);
		writeText(SalesEmailID, randomName() + "@" + "yopmail.com" + Keys.ENTER);
		Thread.sleep(6000);
		writeText(EmailSubject, "Testing");
		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SaveEmail));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on save Email");
		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesTask));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on sales task");
		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(TaskSave));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Task Save");

		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AttachFile));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Attach File");
		Thread.sleep(9000);

		WebElement dropdown = driver.findElement(AttachDropDown);

		String optionValue = "string:Application";

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = arguments[1];", dropdown, optionValue);

		waitForElement(4000);
		Base_Class.MouseClick(By.xpath("//div[@ng-model='myFiles']"));
		ExtentSuccessMessage("Select File has been Clicked");
		waitForElement(3000);

		Robot robot1 = new Robot();
		String filePath = System.getProperty("user.dir") + "\\Upload\\Default_Template (1).xlsx";
		StringSelection stringSelection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		robot1.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);

		robot1.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);

		robot1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		ExtentSuccessMessage("File is been Uploaded");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AddressSave));
		MoveToElementClick(element);
		Thread.sleep(1000);

	}

	public void salesQuotesCreateQuoteFromOpportunity() throws InterruptedException {
		waitForElement(6000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales button");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesQuote));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Quote");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
		MoveToElementClick(element);
		ExtentSuccessMessage(" Lead has been clicked");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CancelQuote));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Cancel Quote");
		waitForElement(6000);

		/*
		 * WebElement textField = driver.findElement(ActualRevenu);
		 * 
		 * textField.click(); textField.sendKeys("30");
		 */
		waitForElement(4000);
		// writeText(Textarea,"Expired");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(Textarea);
		js.executeScript("arguments[0].value='Expired text';", element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CancelSubmit));
		MoveToElementClick(element);
		wait.until(ExpectedConditions.presenceOfElementLocated(SelectStatus));
		MoveToElementClick(element);

		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectCancel));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected the Cancel");
		waitForElement(6000);
		ExtentSuccessMessage("Clicked on submit");
		waitForElement(6000);
	}

	public void salesQuotesCreateOpportunityFromLead() throws InterruptedException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales button");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesQuote));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Quote");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
		MoveToElementClick(element);
		ExtentSuccessMessage(" Lead has been clicked");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(InstallPolicy));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Install Policy");
		waitForElement(15000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AorSearch));
		MoveToElementClick(element);

		waitForElement(8000);
		WebElement ele = driver.findElement(AorText);
		ele.clear();
		// writeText(ele,"siva");
		ele.sendKeys("siva");
		waitForElement(9000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(SearchIcon));
		MoveToElementClick(element);
		waitForElement(9000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AorRadioButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Select the AOR");
		waitForElement(9000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Okbutton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on ok ");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SubmitQuote));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Submit");
		waitForElement(6000);

	}

	public void salesOpportunityFilterOpportunity2() throws InterruptedException {

		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesOpportunities));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Opportunity");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Oppstatus));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status ");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OppCancel2));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the Cancel status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OppCancel2));
		MoveToElementClick(element);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OppCloseW));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the Closed as won status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OppCloseW));
		MoveToElementClick(element);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OppOpen));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the Open status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OppOpen));
		MoveToElementClick(element);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OppQualified));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the Qualified status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OppQualified));
		MoveToElementClick(element);

	}

	public void salesOpportunityFilterOpportunity() throws InterruptedException {

		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesOpportunities));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Opportunity");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Oppstatus));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status ");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OppCancel2));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the Cancel status");
		/*
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(OppCancel2));
		 * MoveToElementClick(element); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(OppCloseW));
		 * MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the Closed as won status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(OppCloseW));
		 * MoveToElementClick(element); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(OppOpen));
		 * MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the Open status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(OppOpen));
		 * MoveToElementClick(element); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(OppQualified));
		 * MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the Qualified status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(OppQualified));
		 * MoveToElementClick(element);
		 */

	}

	public void opportunityActions() throws InterruptedException, AWTException {

		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesOpportunities));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Opportunity");
		Thread.sleep(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
		MoveToElementClick(element);
		ExtentSuccessMessage(" Lead has been clicked");
		waitForElement(8000);

		/*
		 * writeText(SalesLeadNotes,"abcdefghij");
		 * ExtentSuccessMessage("Note text is entered"); Thread.sleep(6000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(SaveNote));
		 * MoveToElementClick(element); ExtentSuccessMessage("Note is saved");
		 */
		WebElement element = driver.findElement(SalesLeadNotes);
		((JavascriptExecutor) driver).executeScript("arguments[0].value = 'Your text';", element);

		ExtentSuccessMessage("Note text is entered");
		Thread.sleep(6000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(SaveNote));
		MoveToElementClick(element);
		ExtentSuccessMessage("Note is saved");
		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesEmail));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked  on Sales Email");
		Thread.sleep(6000);
		writeText(SalesEmailID, randomName() + "@" + "yopmail.com" + Keys.ENTER);
		Thread.sleep(6000);
		writeText(EmailSubject, "Testing");
		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SaveEmail));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on save Email");
		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesTask));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on sales task");
		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(TaskSave));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Task Save");

		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AttachFile));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Attach File");
		Thread.sleep(9000);

		WebElement dropdown = driver.findElement(AttachDropDown);

		String optionValue = "string:Application";

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = arguments[1];", dropdown, optionValue);

		waitForElement(4000);
		Base_Class.MouseClick(By.xpath("//div[@ng-model='myFiles']"));
		ExtentSuccessMessage("Select File has been Clicked");
		waitForElement(3000);

		Robot robot1 = new Robot();
		String filePath = System.getProperty("user.dir") + "\\Upload\\Default_Template (1).xlsx";
		StringSelection stringSelection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		robot1.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);

		robot1.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);

		robot1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		ExtentSuccessMessage("File is been Uploaded");
		waitForElement(6000);

	}

	public void opportunityChangeLeadStatus() throws InterruptedException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesOpportunities));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Opportunity");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
		MoveToElementClick(element);
		ExtentSuccessMessage(" Lead has been clicked");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Optqualify));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Qualify");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Optsubmit2));
		MoveToElementClick(element);
		ExtentSuccessMessage("Cliked on Submit button");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CloseDeal));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CloseDealStatus));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CloseOption));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected CloseDeal");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Optsubmit2));
		MoveToElementClick(element);
		ExtentSuccessMessage("Cliked on Submit button");
	}

	public void createOpportunityQuote() throws InterruptedException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesOpportunities));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Opportunity");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
		MoveToElementClick(element);
		ExtentSuccessMessage(" Lead has been clicked");
		waitForElement(6000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityQuote));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Create quote");
		waitForElement(6000);
		writeText(OpportunityEffectiveDate, "12/12/2024" + Keys.ENTER);
		waitForElement(6000);
		writeText(OptZipCode, "33233");
		ExtentSuccessMessage("Entered the Zipcode 33233");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OPtStatus));
		MoveToElementClick(element);
		waitForElement(7000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OptSubStaus));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected the status");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Optsubmit));
		MoveToElementClick(element);

	}

	public void newOpportunity() throws InterruptedException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesOpportunities));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Opportunity");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NewOpportunity));
		MoveToElementClick(element);
		ExtentSuccessMessage("clicked on new New Opportunity");
		waitForElement(6000);
		writeText(OpportunityName, "siva");
		waitForElement(6000);
		ExtentSuccessMessage("Enter the custmer name");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesSearchIcon));
		MoveToElementClick(element);
		waitForElement(6000);
		ExtentSuccessMessage("Clicked on search  ");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(RadioButtonSelect));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ButtonOk));
		MoveToElementClick(element);

		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SubmitOk));
		MoveToElementClick(element);
		ExtentSuccessMessage("Cliked on submit button");
	}

	public void leadAdvancedSearch2() throws InterruptedException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Leads));
		MoveToElementClick(element);
		ExtentSuccessMessage("Sales Lead has been clicked");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedSearch));
		MoveToElementClick(element);
		ExtentSuccessMessage("Advanced search has been clicked");

		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedLeadStatus));
		MoveToElementClick(element);
		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectAccepted));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Accepted");
		waitForElement(9000);
		click(AdvanceSubmit);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedLeadStatus));
		MoveToElementClick(element);

		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectUnqualified));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Unqualified");
		waitForElement(9000);
		click(AdvanceSubmit);
		waitForElement(6000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedLeadStatus));
		MoveToElementClick(element);

		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectConverted));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Converted");
		waitForElement(9000);
		click(AdvanceSubmit);
		waitForElement(6000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedLeadStatus));
		MoveToElementClick(element);

		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectQualified));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Qualified");
		waitForElement(9000);
		click(AdvanceSubmit);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedLeadStatus));
		MoveToElementClick(element);

		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectReject));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Reject");
		waitForElement(9000);
		click(AdvanceSubmit);

	}

	public void leadAdvancedSearch() throws InterruptedException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Leads));
		MoveToElementClick(element);
		ExtentSuccessMessage("Sales Lead has been clicked");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedSearch));
		MoveToElementClick(element);
		ExtentSuccessMessage("Advanced search has been clicked");

		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedLeadStatus));
		MoveToElementClick(element);
		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectAccepted));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Accepted");
		waitForElement(9000);
		click(AdvanceSubmit);
		waitForElement(6000);
		/*
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedLeadStatus));
		 * MoveToElementClick(element);
		 * 
		 * waitForElement(3000);
		 * 
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(SelectUnqualified));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Unqualified");
		 * waitForElement(9000); click(AdvanceSubmit); waitForElement(6000);
		 * 
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedLeadStatus));
		 * MoveToElementClick(element);
		 * 
		 * waitForElement(3000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(SelectConverted));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Converted");
		 * waitForElement(9000); click(AdvanceSubmit); waitForElement(6000);
		 * 
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedLeadStatus));
		 * MoveToElementClick(element);
		 * 
		 * waitForElement(3000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(SelectQualified));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Qualified");
		 * waitForElement(9000); click(AdvanceSubmit); waitForElement(6000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedLeadStatus));
		 * MoveToElementClick(element);
		 * 
		 * waitForElement(4000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(SelectReject));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Reject");
		 * waitForElement(9000); click(AdvanceSubmit);
		 */

	}

	public void salesLeadFilterLead2() throws InterruptedException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Leads));
		MoveToElementClick(element);
		ExtentSuccessMessage("Sales Lead has been clicked");

		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(StatusLead));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status Lead");
		waitForElement(7000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(StausUnqualified));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the UnQualified status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(StausUnqualified));
		MoveToElementClick(element);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(StatusAccepted));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the Accepted status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(StatusAccepted));
		MoveToElementClick(element);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(StatusConverted));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the Converted status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(StatusConverted));
		MoveToElementClick(element);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(StatusQualified));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the Qualified status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(StatusQualified));
		MoveToElementClick(element);

	}

	public void salesLeadFilterLead() throws InterruptedException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Leads));
		MoveToElementClick(element);
		ExtentSuccessMessage("Sales Lead has been clicked");
		waitForElement(4000);
		driver.navigate().refresh();
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(StatusLead));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status Lead");
		waitForElement(7000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(StausUnqualified));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the UnQualified status");
		/*
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(StausUnqualified));
		 * MoveToElementClick(element); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(StatusAccepted));
		 * MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the Accepted status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(StatusAccepted));
		 * MoveToElementClick(element); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(StatusConverted));
		 * MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the Converted status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(StatusConverted));
		 * MoveToElementClick(element); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(StatusQualified));
		 * MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the Qualified status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(StatusQualified));
		 * MoveToElementClick(element);
		 */
	}

	public void leadConvert() throws InterruptedException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Leads));
		MoveToElementClick(element);
		ExtentSuccessMessage("Sales Lead has been clicked");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
		MoveToElementClick(element);
		ExtentSuccessMessage(" Lead has been clicked");
		waitForElement(6000);
		click(Convert);
		ExtentSuccessMessage("Clicked on Convert button");
		// waitForElement(6000);
		// click(MedicalDropdown);
		waitForElement(8000);
		// click(Medical);
		// click(ConvertSubmit);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ConvertSubmit));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Convert Submit");

	}

	public void salesLeadActions() throws InterruptedException, AWTException {
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Leads));
		MoveToElementClick(element);
		ExtentSuccessMessage("Sales Lead has been clicked");
		Thread.sleep(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
		MoveToElementClick(element);
		ExtentSuccessMessage(" Lead has been clicked");
		Thread.sleep(10000);

		/*
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(SalesLeadNotes));
		 * MoveToElementClick(element); String Note = "Rajeswari Automation";
		 * writeText(SalesLeadNotes, Note);
		 */
		// writeText(SalesLeadNotes,"abcdefghij");
		WebElement element = driver.findElement(SalesLeadNotes);
		((JavascriptExecutor) driver).executeScript("arguments[0].value = 'Your text';", element);

		ExtentSuccessMessage("Note text is entered");
		Thread.sleep(6000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(SaveNote));
		MoveToElementClick(element);
		ExtentSuccessMessage("Note is saved");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesEmail));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked  on Sales Email");
		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesEmailID));
		MoveToElementClick(element);
		writeText(SalesEmailID, randomName() + "@" + "yopmail.com" + Keys.ENTER);
		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EmailSubject));
		MoveToElementClick(element);
		writeText(EmailSubject, "Testing");
		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SaveEmail));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on save Email");
		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesTask));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on sales task");
		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(TaskSave));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Task Save");

		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AttachFile));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Attach File");
		Thread.sleep(9000);
		// WebElement dropdown = driver.findElement(AttachDropDown);

		/*
		 * String optionValue = "string:Application";
		 * 
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("arguments[0].value = arguments[1];", dropdown,
		 * optionValue);
		 * js.executeScript("arguments[0].dispatchEvent(new Event('change'))",
		 * dropdown); waitForElement(4000);
		 */

		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AttachDropDown));
		wait.until(ExpectedConditions.elementToBeClickable(AttachDropDown));
		click(AttachDropDown);
		waitForElement(3000);
		By DocumentDDOption = By.xpath("//option[text()='Annual Income']");
		wait.until(ExpectedConditions.elementToBeClickable(DocumentDDOption));
		click(DocumentDDOption);

		Base_Class.MouseClick(By.xpath("//div[@ng-model='myFiles']"));
		ExtentSuccessMessage("Select File has been Clicked");
		Robot robot1 = new Robot();
		String filePath = System.getProperty("user.dir") + "\\Upload\\Default_Template (1).xlsx";
		StringSelection stringSelection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		robot1.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);

		robot1.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);

		robot1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		ExtentSuccessMessage("File is been Uploaded");
		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(AddressSave));
		MoveToElementClick(element);

	}

	public void leadStatus() throws InterruptedException {
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Leads));
		MoveToElementClick(element);
		ExtentSuccessMessage("Sales Lead has been clicked");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
		MoveToElementClick(element);
		ExtentSuccessMessage(" Lead has been clicked");
		waitForElement(6000);
		click(LeadAssign);
		waitForElement(6000);
		click(EditIcon);
		waitForElement(6000);
		// js.executeScript("window.scrollBy(0,500)");
		/*
		 * Actions actions = new Actions(driver);
		 * 
		 * // Scroll down using Actions class
		 * actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		 */

		waitForElement(6000);
		/*
		 * WebElement StausSel = driver.findElement(StatusSelect); Select select = new
		 * Select(StausSel); select.selectByIndex(5);
		 */
		/*
		 * element = wait.until(ExpectedConditions. presenceOfElementLocated
		 * (StatusSelect)); MoveToElementClick(element); Select select = new
		 * Select(element); select.selectByVisibleText("Qualified");
		 * ExtentSuccessMessage("Qualified Selected"); //
		 * js.executeScript("window.scrollBy(0,300)");
		 * 
		 * 
		 * // Scroll down using Actions class //
		 * actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		 * 
		 * click(ButtonSave);
		 */
		click(LeadQualify);
		ExtentSuccessMessage("Clicked on Qualify");
		waitForElement(6000);
		click(LeadReject);
		ExtentSuccessMessage("Clicked on Reject");
		waitForElement(6000);
		click(LeadDispose);
		ExtentSuccessMessage("Clicked on Lead Dispose");

	}

	public void salesLead() throws InterruptedException {

		Thread.sleep(20000);
		// click(SalesButton);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Leads));
		MoveToElementClick(element);
		ExtentSuccessMessage("Sales Lead has been clicked");
		Thread.sleep(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NewLead));
		MoveToElementClick(element);

		Thread.sleep(8000);
		// click(NewLead);
		ExtentSuccessMessage("Clicked on NewLead");
		writeText(NewLeadFirstName, "Automation");
		// writeText(NewLeadLastName,"testing");

		writeText(NewLeadLastName, randomName());
		waitForElement(6000);
		writeText(DOB, "03/03/1990" + Keys.ENTER);
		Thread.sleep(8000);
		// click(Gender);

		// click(Male);

		/*
		 * WebElement ele=driver.findElement(Gender); MoveToElementClick(ele);
		 * 
		 * WebElement Male1 = driver.findElement(Male); MoveToElementClick(Male1);
		 * ExtentSuccessMessage("Gender is selected");
		 */

		Thread.sleep(8000);
		writeText(Phnum, "9878996557");
		Thread.sleep(8000);
		writeText(Email, "as@yopmail.com");
		Thread.sleep(8000);
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(8000);
		// click(LeadInformation);
		WebElement Lead = driver.findElement(LeadInformation);
		MoveToElementClick(Lead);

		ExtentSuccessMessage("Clicked on Lead Information");
		Thread.sleep(8000);
		// click(HomeorPrincipals);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(HomeorPrincipals));
		MoveToElementClick(element);

		ExtentSuccessMessage("Clicked on Home/Principals");
		Thread.sleep(10000);
		/*
		 * element = wait.until(ExpectedConditions.presenceOfElementLocated(Adress));
		 * MoveToElementClick(element); String Note = "Rajeswari Automation";
		 * writeText(Adress, Note); // writeText(Adress,"testing");
		 */
		WebElement element = driver.findElement(Adress);
		((JavascriptExecutor) driver).executeScript("arguments[0].value = 'Your text';", element);

		Thread.sleep(4000);
		WebElement element3 = driver.findElement(HomeZipCode);
		((JavascriptExecutor) driver).executeScript("arguments[0].value = '33233';", element3);

		// writeText(HomeZipCode,"33233");
		ExtentSuccessMessage("Entered the Zipcode 33233");

		Thread.sleep(8000);
		// click(OtheInformation);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OtheInformation));
		MoveToElementClick(element);

		ExtentSuccessMessage("Clicked on Other Information");
		Thread.sleep(8000);
		// click(Submit);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Submit));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Submit button");
		Thread.sleep(8000);
		By element2 = By.xpath("//button[contains(text(),'Proceed with Lead creation')]");

		/*
		 * // Check if the element is displayed if(element.isDisplayed()) { // Click on
		 * the element element.click(); } else {
		 * System.out.println("Element is not displayed, so cannot click."); }
		 * Thread.sleep(6000); }
		 */
		try {
			if (driver.findElement(element2).isDisplayed()) {
				click(element2);

			}
		} catch (NoSuchElementException e) {
		} catch (Exception e) {
			ExtentSuccessMessage("Lead Created");
		}
		Thread.sleep(6000);
	}

	public void salesOpportunityAdvancedSearch2() throws InterruptedException {

		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesOpportunities));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Opportunity");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedSearch));
		MoveToElementClick(element);
		ExtentSuccessMessage("Advanced search has been clicked");

		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityStatus));
		MoveToElementClick(element);
		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityOpen));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Open");
		waitForElement(9000);
		click(OppSearch);
		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityStatus));
		MoveToElementClick(element);

		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityCloseAsLost));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Opportunity Close As Lost");
		waitForElement(9000);
		click(OppSearch);
		waitForElement(6000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityStatus));
		MoveToElementClick(element);

		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityCloseWon));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Opportunity Close As Won");
		waitForElement(9000);
		click(OppSearch);
		waitForElement(6000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityStatus));
		MoveToElementClick(element);

		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OppQualify));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Qualified");
		waitForElement(9000);
		click(OppSearch);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityStatus));
		MoveToElementClick(element);

		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OppRenewal));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Renewal");
		waitForElement(9000);
		click(OppSearch);

		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityStatus));
		MoveToElementClick(element);

		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OppCancel));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Cancel");
		waitForElement(9000);
		click(OppSearch);

	}

	public void salesOpportunityAdvancedSearch() throws InterruptedException {

		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesOpportunities));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Opportunity");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedSearch));
		MoveToElementClick(element);
		ExtentSuccessMessage("Advanced search has been clicked");

		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityStatus));
		MoveToElementClick(element);
		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityOpen));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Open");
		waitForElement(9000);
		click(OppSearch);
		waitForElement(5000);
		/*
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityStatus));
		 * MoveToElementClick(element);
		 * 
		 * waitForElement(3000);
		 * 
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityCloseAsLost
		 * )); MoveToElementClick(element);
		 * ExtentSuccessMessage("Selected Opportunity Close As Lost");
		 * waitForElement(9000); click(OppSearch); waitForElement(6000);
		 * 
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityStatus));
		 * MoveToElementClick(element);
		 * 
		 * waitForElement(3000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityCloseWon));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Selected Opportunity Close As Won");
		 * waitForElement(9000); click(OppSearch); waitForElement(6000);
		 * 
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityStatus));
		 * MoveToElementClick(element);
		 * 
		 * waitForElement(3000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(OppQualify));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Qualified");
		 * waitForElement(9000); click(OppSearch); waitForElement(6000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityStatus));
		 * MoveToElementClick(element);
		 * 
		 * waitForElement(4000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(OppRenewal));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Renewal");
		 * waitForElement(9000); click(OppSearch);
		 * 
		 * waitForElement(6000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityStatus));
		 * MoveToElementClick(element);
		 * 
		 * waitForElement(4000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(OppCancel));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Cancel");
		 * waitForElement(9000); click(OppSearch);
		 */

	}

}
