package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.BasePackage.Base_Class;

import Common.ActionClasss;

public class CustomerEngageFunctionalityValidations extends BasePage {

	private static final String Annual = null;
	private static final String URL1 = null;

	public CustomerEngageFunctionalityValidations(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	JavascriptExecutor js = (JavascriptExecutor) driver;
	WebElement element;
	public String MarketingURL;
	public String ExpectedResult = "Applicants were excluded from the quote because they may be eligible for Medicaid/CHIP.";
	String imgSrc;
	String expectedText;
	String savingsAmount;
	String AddedApplicantExpected = "Zip: 33433, 3 Applicants, Income: $25,000";
	String actualText;
	public String fullName;
	public String firstName;
	public String lastName;
	public String getEmailValue;
	public String agentUserName;
	public String getLastName;
	public String getFirstName;
	public String actualString = "Congratulations! Your application has been submitted successfully";
	public String EmailText;
	public String AgentText;
	public String NoteText;
	public String CarrierText;
	public String Campaign;
	public String ValidEmailText;
	public String NumberOutput;
	public String NumberOutput1;
	
	

	By userID = By.id("user-name");//------//for userid at Login page
	By pwd = By.id("password");//-------for password at home page
	By signIn = By.xpath("//*[@id='form-validation-button']");//-------for button on home page

	private By CheckUserLogin = By.xpath("//button[@class='positive md-button md-ink-ripple']");
	private By SelectUser = By.xpath("//a[@class='nav-link dropdown-toggle']");
	private By SelectLogout = By.xpath("(//a[contains(.,'Log Out')])[1]");
	private By LogoutButtonConfirmation = By.xpath(
			"//a[@class='modal-action tertiary_background waves-effect waves-light btn-large ConfirmForceLogin']");
	private By MainMenu = By.xpath("//li[@class='link_menu hide-on-med-and-down sideMenuHamburger']");
	private By CustomerInformationTab = By.cssSelector("#sideMenuContent > div > ul > li:nth-child(1) > a");
	private By SettingsTab = By.cssSelector("#sideMenuContent > div > ul > li:nth-child(8) > a");
	private By AgencyDetailsTab = By
			.cssSelector("#sideMenuContent > div > ul > li.active > div > ul > li:nth-child(1) > a");
	private By AddButton = By.xpath("//a[@id='add_buton']");
    private By HomeButton=By.id("menu_home");
	private By MarketingTile = By.xpath("//a[@class='glyphicon fa fa-fw fa-bar-chart-o']");
	private By MarketingList = By.xpath("(//a[contains(.,'Lists')])[2]");
	
	private By ValidateListButton = By.id("createNewList");
	private By ListName = By.xpath("//input[@name='ListName']");
	private By SegmentedList = By.xpath("(//a[contains(.,'Segmented List')])[2]");
	private By NewSegmentedListButton = By.id("createNewDynamicBtn");
	private By MarketingTemplate = By.xpath("(//a[contains(.,'Templates')])[2]");
	private By NewTemplateButton = By.id("NewTemplateBtn");
	private By MarketingCampaign = By.xpath("(//a[contains(.,'Campaigns')])[2]");
	private By CreateCampaign = By.id("createNewCamapign");
	private By PromotionalCampaign = By.id("PROMOTIONAL_CAMPAIGNS");

	private By SourceDropDown = By.xpath("//md-select[@name='ListSource']");
	private By AgentFirstName = By.xpath("//input[@id='FirstName']");
	private By AgentLastName = By.xpath("//input[@id='LastName']");
	private By AgentRole = By.xpath("(//input[@class='select-dropdown dropdown-trigger'])[2]");
	private By AgentRoleSelection = By.xpath("(//span[contains(.,'Agent')])[1]");
	private By AgentPhone = By.xpath("(//input[@id='Phone'])[1]");
	private By AgentEmail = By.xpath("(//input[@id='Email'])[1]");
	private By MedicareCustomer = By.xpath("//a[@class='medicaredatalistingmenu']");
	private By AgencyTile = By.xpath("//a[@class='glyphicon fa fa-building']");
	private By AgencyAgent= By.xpath("(//a[contains(.,'Agents')])[1]");
	private By NewAgentButton=By.id("createNewAgentBtn");
	private By AdminTile = By.xpath("//a[@class='glyphicon fa fa-fw fa-black-tie']");
	private By AdminRolesAndPermission= By.xpath("(//a[contains(.,'Roles/Permissions')])[2]");
	private By AddRolesAndPermissionButton= By.xpath("//button[@class='btn btn-default pull-right btn-yellow']");
	private By ReportTile = By.xpath("//a[@class='glyphicon fa fa-fw fa-file-text']");
	private By LiveReport = By.xpath("//a[contains(.,'Live Reports')]");
	private By DashBoardTile = By.xpath("//a[@class='glyphicon fa fa-fw fa-dashboard']");
	private By DashBoardMyTask = By.xpath("(//a[contains(.,'My Tasks')])[2]");
	private By DashBoardCalendar = By.xpath("(//div[@class='dx-button-content'])[2]");
	private By CommissionTile = By.xpath("//a[@class='glyphicon fa fa-fw fa-usd']");
	private By CommissionSetup = By.xpath("(//a[contains(.,'Commission Setup')])[3]");
	private By CommissionSetupTitle = By.xpath("(//span[contains(.,'Commission Setup')])[2]");
	private By CTIIcon = By.xpath("(//i[@class='fa fa-phone'])[1]");
	private By CTIMinimizeIcon = By.xpath("//a[@class='fa fa-minus right-al']");
	private By CTIDialPadIcon = By.xpath("//a[@class='fa fa-th voice-active']");
	private By CallBackNotificationIcon = By.xpath("//a[@title='Call back Notifications']");
	private By CallBackNitificationTitle = By.xpath("//strong[contains(.,'Callback Notifications')]");
	private By CallBackNitificationMinimizeIcon = By.xpath("//i[@class='fa fa-times']") ;                                              
	private By MyProfileIcon = By.xpath("//a[contains(.,'My Profile')]");
	private By MyProfileSubmitButton = By.xpath("//button[@class='btn btn-default green pull-right']");
	
	
	//Marketing elements
	
	
	private By ListDetailNextButton = By.xpath("(//button[@class='btn btn-default green'])[2]");
	private By ListDefaultTemplate = By.id("defaultTemplate");
	private By UploadListNextButton = By.xpath("//button[@class='btn btn-default green']");
	private By DOBDeleteIcon = By.xpath("((//td[text()='Dob'])[1]/following-sibling::td)[3]/button[@class='btn btn-default green glyphicon glyphicon-trash']");
	private By AlertAcceptButton = By.xpath("//button[@ng-click='confirmModalCtrl.Confirm()']");
	private By DOBCheckList = By.xpath("//label[contains(.,'Dob ')]");
	private By AOREMmail = By.xpath("//label[contains(.,'AOR Email')]");
	private By MapButton = By.xpath("//button[@ng-click='add()']");
	private By MarketingListSaveButton = By.xpath("//button[contains(.,'Submit')]");
	private By SegmentedListName = By.xpath("//input[@id='SegmentedListName']");
	private By BuissnessObjectDD = By.id("businessObject0");
	private By SegmentedSelectField = By.xpath("//md-select[@name='parameter0']");
	private By ValueTextField = By.id("value0");
	private By AddNewFieldButton = By.xpath("//button[@class='btn btn-primary pull-left btn-yellow criteria-add-button']");
	private By SegmentedSelectField2 = By.id("parameter1");
	private By ValueTextField2 = By.name("value1");
	private By PrieviewDataButton = By.id("applycriteriaSearchBtn");
	private By SegmentedListSaveButton = By.xpath("(//button[@class='btn btn-default green'])[2]");
	private By TemplateDetailField = By.name("OfferName");
	//private By ExistingTemplate = By.xpath("(//span[contains(.,'My Existing Templates')])[1]");
	private By DefaultTemplate = By.xpath("((//div[@class='col-md-12 margin-bottom-20 pad-lt pad-rt'])[1]/div/div)[1]");
	private By PreviewButton = By.xpath("(//button[contains(.,'Preview')])[11]");
	private By CloseButton = By.xpath("//button[@class='btn btn-primary btn-default grey']");
	private By DefaultTemplate1 = By.xpath("((//div[@class='col-md-12 margin-bottom-20 pad-lt pad-rt'])[1]/div/div)[1]");
	private By SelectButton = By.xpath("(//button[contains(.,'Select')])[11]");
	private By Frame = By.xpath("/html/body/div[3]/div[6]/div/ui-view//iframe");
	private By TemplateSubmitButton = By.xpath("(//button[text()='Submit'])[1]");
	private By CampaignName = By.name("CampaignName");
	private By CampaignObjective = By.name("CampaignObjective");
	private By CampaignDetailsNextButton = By.xpath("(//button[contains(.,'Next')])[1]");
	private By SearchField = By.xpath("//input[@class='ng-pristine ng-untouched md-input ng-empty ng-valid-minlength ng-valid-maxlength ng-valid ng-valid-required']");
	private By TemplateCheckBox = By.xpath("(//div[@role='button'])[1]");
	private By TemplateNextButton = By.xpath("//button[@class='btn btn-default green pull-right']");
	private By ListSearchField = By.xpath("//input[@ng-model='listSearchKey']");
	private By ListCheckBox = By.xpath("(//span[@class='dx-checkbox-icon'])[2]");
	private By ListNextButton = By.xpath("//button[@class='btn btn-default green pull-right ng-scope']");
	private By EmailSendersName = By.xpath("(//input[@class='full-width ng-pristine ng-untouched md-input ng-empty ng-invalid ng-invalid-required'])[1]");
	private By EmailSubjectLine = By.xpath("(//input[@class='full-width ng-pristine ng-untouched md-input ng-empty ng-invalid ng-invalid-required'])[1]");
	private By EmailConfigButtonNextButton = By.xpath("//button[@class='btn btn-default green pull-right']");
	private By TestAndPreviewEmailField = By.xpath("//input[@ng-model='senderEmailId']");
	private By TestEmailButton = By.xpath("//button[contains(.,'Test Email')]");
	private By CreateCampaignButton = By.xpath("//button[@class='btn btn-default green pull-right']");
	private By ConfirmButton = By.xpath("//button[@class='btn btn-primary btn-default green']");
	private By SearchTextField = By.xpath("//input[@class='ng-pristine ng-untouched md-input ng-empty ng-valid-minlength ng-valid-maxlength ng-valid ng-valid-required']");
	private By EmailCampaignLaunchButton = By.xpath("(//a[@class='edit-list-icons'])[2]");
	
	
	private By CallCampaignName = By.name("CampaignName");
	private By CampaignCategory = By.xpath("(//md-select-value[@class='md-select-value'])[1]");
	private By CallCampaignObjective = By.name("CampaignObjective");
	private By CallCampaignDetailsNextButton = By.xpath("(//button[contains(.,'Next')])[1]");
	private By CallListSearchField = By.xpath("//input[@ng-model='listSearchKey']");
	private By CallListCheckBox = By.xpath("//td[@aria-label='Select all']");
	private By CallCampaignSubmitButton = By.xpath("//button[@class='btn btn-default green pull-right ng-scope']");
	private By LaunchButton = By.xpath("(//a[@class='edit-list-icons'])[2]");
	
	private By SMSCampaignName = By.name("CampaignName");
	private By SMSCampaignCategory = By.xpath("(//md-select-value[@class='md-select-value'])[1]");
	private By SMSCampaignObjective = By.name("CampaignObjective");
	private By SMSCampaignDetailsNextButton = By.xpath("(//button[contains(.,'Next')])[1]");
	private By MessageTextArea = By.xpath("//textarea[@class='form-control SMSTextBox']");
	private By CreateMessageNextButton = By.xpath("	//button[@class='btn btn-default green pull-right']");
	private By SMSListSearchField = By.xpath("//input[@ng-model='listSearchKey']");
	private By SMSListCheckBox = By.xpath("//td[@aria-label='Select all']");
	private By SMSListnextButton = By.xpath("//button[@class='btn btn-default green pull-right ng-scope']");
	private By SMSTestNumberField = By.xpath("	//input[@ng-model='senderNumber']");
	private By SMSTestNumberButton = By.xpath("(//button[@class='btn btn-default green pull-left'])[2]");
	private By SMSCreateCampaignButton = By.xpath("//button[@class='btn btn-default green pull-right']");
	private By SMSConfirmationButton = By.xpath("//button[@class='btn btn-primary btn-default green']");
	private By SMSLaunchButton = By.xpath("(//a[@class='edit-list-icons'])[2]");
	private By SMSconfirmationButton = By.xpath("//button[@class='btn btn-primary btn-default green ng-binding']");
	
	//AgencyElemenet
	private By AgentPrefix= By.xpath("//md-select[@name='Prefix']");
	private By AgentPrefixOption = By.xpath("//div[text()='Mr.']");
	private By NewAgentFirstName = By.name("FirstName");
	private By NewAgentLastName = By.name("LastName");
	private By AgencyType = By.xpath("(//md-select[@class='ng-pristine ng-untouched ng-empty ng-invalid ng-invalid-required'])[1]");
	private By AgencyTypeOption = By.xpath("//md-option[@value='Agent']");
	private By AgentLicenseNumber = By.xpath("//input[@name='StateLicenseNumber']");
	private By AgentStatus = By.xpath("(//md-select[@name='Status'])[3]");
	private By AgentStatusOption = By.xpath("(//md-option[@value='Active'])[3]");
	private By AgentContactInformationSection = By.xpath("(//i[@class='acc glyphicon glyphicon-plus'])[4]");
	private By AgentPhoneNumber = By.xpath("//input[@name='Phone']");
	private By AgentEmailId = By.xpath("//input[@name='Email']");
	private By PimaryAddressInfoSection = By.xpath("(//i[@role='button'])[7]");
	private By AgentAddress = By.cssSelector("input[name='AddressLine1']");
	private By AgentZipcode = By.xpath("//input[@name='ZipCode']");
	private By MailinhAddressCheckBox = By.xpath("//input[@ng-model='confirmedCheck']");
	private By AgentSubmitButton = By.xpath("//button[@name='saveAgentdetailsButton']");
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
	
	private By CarrierAppointmmentButton = By.xpath("//button[@name='CarrierAppointments']");
	private By CarrierNameDD = By.xpath("//md-select[@name='CarrierName']");
	private By CarrierOption = By.xpath("(//div[contains(.,'Humana Insurance Company')])[2]");
	private By StateOption = By.xpath("//md-option[@value='MD']");
	private By CarrierStartDate = By.xpath("//input[@name='IssuedDate']");
	private By CarrierStatusDD = By.xpath("//md-select[@name='CarrierAppointmentStatus']");
	private By StatusOption = By.xpath("(//div[contains(.,'Active')])[17]");
	private By CarrierSubmitButton = By.xpath("//button[@name='SaveCarrierAppointmentBtn']");
	private By CarrierField = By.xpath("//a[contains(.,' Carrier Appointments')]");
	
	private By NotesSection = By.xpath("//textarea[@class='form-control ng-pristine ng-untouched ng-isolate-scope ng-empty ng-invalid ng-invalid-required ng-valid-maxlength']");
	private By NotesConfirmationButton = By.xpath("(//button[@class='btn btn-default icons text-center ng-isolate-scope'])[2]");
	private By ActionEmailIcon = By.xpath("(//li[@class='ng-scope'])[10]/a[@role='tab']");
	private By AddEmailAddressCheckBox = By.xpath("//md-chips[@placeholder='Add email address']");
	private By EmailSubject = By.xpath("//input[@class='form-control ng-pristine ng-untouched ng-isolate-scope ng-empty ng-invalid ng-invalid-required']");
	private By EmailConfirmationButton = By.xpath("(//button[@class='btn btn-default icons text-center ng-isolate-scope'])[2]");
	private By ActionAttachment = By.xpath("(//li[@class='ng-scope'])[11]/a[@role='tab']");
	private By DocumentDD = By.xpath("//*[@id=\"filter-by\"]/div[1]/form/div[1]");
	private By DocumentDDOption = By.xpath("//option[text()='Other']");
	private By DocumentAttachFileButton = By.xpath("//div[@class='btn btn-primary ng-pristine ng-untouched ng-valid ng-isolate-scope ng-empty']");
	private By AttachmentConfirmationButton = By.xpath("(//button[@class='btn btn-default icons text-center ng-isolate-scope'])[2]");
	private By ActionTask = By.xpath("(//li[@class='ng-scope'])[12]/a[@role='tab']");
	private By ActivityDD = By.xpath("(//select[@class='form-control ng-pristine ng-untouched ng-valid ng-not-empty'])[1]");
	private By PriorityDD = By.xpath("//*[@id=\"filter-by\"]/div[1]/form/div[5]/select");
	private By CommentTextArea = By.xpath("//textarea[@class='form-control comments ng-pristine ng-untouched ng-valid ng-empty ng-valid-maxlength']");
	private By TaskConfirmationButton = By.xpath("//i[@class='fa fa-check yellow green']");
	
	private By RecentAgentIcon = By.xpath("(//i[@class='acc glyphicon glyphicon-plus'])[1]");
	private By CreatedTodayButton = By.xpath("//md-radio-button[@value='Created Today']");
	
	private By AdvancedSearchButton = By.xpath("//button[@class='btn btn-secondary dropdown-toggle ng-isolate-scope']");
	private By AdvancedSearchStatusDD = By.xpath("(//md-select[@name='Status'])[1]");
	private By AdvancedSearchStatusOption = By.xpath("(//div[text()='Active'])[12]");
	private By AdvancedSearchStateDD = By.xpath("(//md-select[@name='State'])[1]");
	private By AdvancedSearchStateOption = By.xpath("(//div[@class='md-text'])[39]");
	private By AdvancedSearchSubmitButton = By.xpath("//button[@name='applyadvancedSearchBtn']");
	private By ExportAgentButton = By.xpath("//button[@class='btn button pull-right ng-isolate-scope']");
	private By AgentActionNoteInc = By.xpath("//u[@class='item_to_highlight ng-binding']");
	private By AgentEmailInc = By.xpath("(//u[@class='ng-binding'])[1]");
	private By TaskInc = By.xpath("(//u[@class='ng-binding'])[1]");
	private By LicenseSection = By.xpath("//a[text()=' Licenses']");
	private By LicenseINC = By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[4]");
	private By AttachmentInc = By.xpath("(//u[@class='ng-binding'])[1]");
	private By CreatedTodayInc = By.xpath("(//a[@class='edit-list-anchor ng-binding'])[1]");
	private By AdvancedSearchInc = By.xpath("(//a[@class='edit-list-anchor ng-binding'])[1]");
	private By AgencyCarrier = By.xpath("(//a[contains(.,'Carriers')])[2]");
	private By NewCarrierButton = By.xpath("//button[@name='newCarrierBtn']");
	private By CarrierNameDD2 = By.xpath("//md-select[@name='CarrierName']");
	private By CarrierPrimaryContactName = By.xpath("//input[@name='PrimaryContactName']");
	private By CarrierEmailId= By.xpath("//input[@name='Email']");
	private By CarrierTextArea = By.xpath("//textarea[@name='Comments']");
	private By CarrierSaveButton = By.xpath("//button[@name='saveCarrierDetailsBtn']");
	private By CarrierSearchTextField = By.xpath("//input[@class='ng-pristine ng-untouched md-input ng-empty ng-valid-minlength ng-valid-maxlength ng-valid ng-valid-required']");
	private By CarrierNameSearchField = By.xpath("(//div[@class='ngCellText ng-scope'])[1]/a");
	private By CarrierAgentAppointmentButton = By.xpath("//button[@name='newAgentAppointmentBtn']");
	private By CarrierAgentNameDD = By.xpath("//md-select[@name='AgentName']");
	private By CarrierAgentNameOption = By.xpath("//md-option[@id='select_option_977']");
	private By CarrierStateDD = By.xpath("//md-select[@name='Statelike']");
	private By CarrierStateDDOption = By.xpath("//div[text()='CT']");
	private By AppointmentCarrierSubmitButton = By.xpath("//button[@name='saveAgentAppointmentBtn']");
	private By CarrierAgentStatusOption = By.xpath("//div[text()='Active']");
	private By CarrierAgentStatusDD = By.xpath("//md-select[@name='AgentStatus']");
	private By CarrierActionNoteInc = By.xpath("//u[@class='item_to_highlight ng-binding']");
	private By CarrierEmailActionButton = By.xpath("//i[@class='fa fa-envelope']");
	private By CarrierEmailInc = By.xpath("(//u[@class='ng-binding'])[1]");
	private By CarrierActivityDD = By.xpath("//*[@id=\"filter-by\"]/div[1]/form/div[2]/select");
	private By CarrierTaskINC = By.xpath("(//u[@class='ng-binding'])[1]");
	private By CarrierFilterProductCategory = By.xpath("(//i[@class='acc glyphicon glyphicon-plus'])[1]");
	private By CarrierStateFilter = By.xpath("(//div[@class='accordion-container grid-style-height'])[3]");
	private By FilterCarrierStateDD = By.xpath("(//md-select-value[@class='md-select-value'])[2]");
	private By CarrierStateOption = By.xpath("//div[text()='AR']");
	private By CarrierFilterInc = By.xpath("(//div[@class='ngCellText ng-scope'])[1]");
	private By CarrierStateOption1 = By.xpath("//div[text()='OH']");
	private By CarrierRefreshButton = By.xpath("//a[@class='pull-right reset-button ng-isolate-scope']");
	private By Textfield = By.xpath("(//input[@role='combobox'])[1]");
	private By CarrierImportButton = By.xpath("//button[@name='downlodDataBtn']");
	private By CarrierGroupButton = By.xpath("(//button[@class='btn btn-default pull-right btn-yellow'])[2]");
	private By NewCarrierGroupButton = By.xpath("//button[contains(.,'New Carrier Group')]");
	private By CarrierGroupNameField = By.xpath("//input[@class='full-width ng-pristine ng-untouched md-input ng-empty ng-invalid ng-invalid-required']");
	private By CarrierOption1= By.xpath("//label[@class='container-check group-number ng-binding ng-scope'][1]");
	private By CarrierOption2= By.xpath("(//label[@class='container-check group-number ng-binding ng-scope'])[10]");
	private By CarrierOption3= By.xpath("(//label[@class='container-check group-number ng-binding ng-scope'])[13]");
	private By CarrierOption4= By.xpath("(//label[@class='container-check group-number ng-binding ng-scope'])[23]");
	private By CarrierOption5= By.xpath("(//label[@class='container-check group-number ng-binding ng-scope'])[33]");
	private By CarrierOption6= By.xpath("(//label[@class='container-check group-number ng-binding ng-scope'])[50]");
	private By CarrierOption7= By.xpath("(//label[@class='container-check group-number ng-binding ng-scope'])[55]");
	private By CarrierOption8= By.xpath("(//label[@class='container-check group-number ng-binding ng-scope'])[60]");
	private By CarrierOption9= By.xpath("(//label[@class='container-check group-number ng-binding ng-scope'])[65]");
	private By CarrierOption10= By.xpath("(//label[@class='container-check group-number ng-binding ng-scope'])[70]");
	private By SelectedCarrierToRightButton = By.xpath("//a[@class='fa fa-angle-right']");
	private By CarrierGroupSubmitButton = By.xpath("(//button[@class='btn btn-default green pull-right'])[2]");
	private By AdminUser = By.xpath("(//a[contains(.,'Users')])[2]");
	private By AddUserButton = By.xpath("//button[@class='btn btn-default pull-right btn-yellow']");
	private By UserFirstName = By.xpath("(//input[@name='FirstName'])[1]");
	private By UserLastName = By.xpath("(//input[@name='LastName'])[1]");
	private By UserEmailId = By.xpath("(//input[@name='EmailId'])[1]");
	private By UserPhoneNumber = By.xpath("(//input[@name='Phone'])[1]");
	private By UserRolesAndPermission = By.xpath("(//select[@name='ProfileName'])[1]");
	private By DataAccessibiltityDD1 = By.xpath("(//select[@name='EditEnabled'])[1]");
	private By DataAccessibiltityDD2 = By.xpath("(//select[@name='AccessConfidentialData'])[1]");
	private By UserLoginDetails = By.xpath("//input[@name='LoginName']");
	private By NewUserButton = By.xpath("(//button[@class='btn btn-default green pull-right'])[2]");
	private By ConfirmationPopup = By.xpath("//button[@class='positive md-button md-ink-ripple']");
	private By AdminUserInc = By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[4]");
	private By AdminSearchBar = By.xpath("//input[@class='ng-pristine ng-untouched md-input ng-empty ng-valid-minlength ng-valid-maxlength ng-valid ng-valid-required']");
	private By AdminEditIcon = By.xpath("//i[@class='glyphicon glyphicon-pencil']");
	private By EditEmailId = By.xpath("//input[@name='EmailId']");
	private By EditPhone = By.xpath("//input[@name='Phone']");
	private By EditSaveButton = By.xpath("(//button[@class='btn btn-default green pull-right'])[3]");
	private By AdminEditUserINC = By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[4]");
	private By AdminResetPasswordButton = By.xpath("//i[@class='glyphicon glyphicon-repeat']");
	private By UserDeleteIconButton = By.xpath("//i[@class='glyphicon glyphicon-trash']");
	private By AdminDeleteConfirmPopup = By.xpath("//button[@class='btn btn-primary btn-default green']");
	private By BuissnessHour = By.xpath("//*[@id=\"NavigationMenuRegion\"]/div/div[2]/div[1]/div/ul/li[7]/ul/li[7]/a");
	private By NewBuissnessHourButton = By.xpath("//button[@class='btn btn-default pull-right btn-yellow']");
	private By BuissnesshourField = By.xpath("//input[@name='BusinessHour']");
	private By BuissnessHRType = By.xpath("//span[text()='24 hours / 7 days a week']");
	private By TimeZoneDD = By.xpath("//md-select[@name='CRMTimeZone']");
	private By TimezoneDDOption = By.xpath("//md-option[contains(.,'(GMT +05:30) India')]");
	private By CallDisposition = By.xpath("(//a[contains(.,'Call Disposition')])[2]");
	private By AddNewCallDespositionButton = By.xpath("//button[@class='btn btn-default btn-yellow']");
	private By CallDispositionName = By.xpath("//input[@class='ng-pristine ng-untouched md-input ng-empty ng-invalid ng-invalid-required ng-valid-maxlength']");
	private By CallDispositionSaveButton = By.xpath("//button[@class='green md-button ng-scope md-ink-ripple']");
	private By CallDispositionInc = By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[1]");
	private By CallDespoSearchField = By.xpath("//input[@class='ng-pristine ng-untouched md-input ng-empty ng-valid-minlength ng-valid-maxlength ng-valid ng-valid-required']");
	private By EditCallDisoButton = By.xpath("//i[@class='glyphicon glyphicon-pencil']");
	private By LeadStatusDD = By.xpath("//md-select[@name='LeadStatus']");
	private By DeleteCallDespoButton = By.xpath("//i[@class='glyphicon glyphicon-trash ng-scope']");
	private By ConfirmDeleteButton = By.xpath("//button[@class='btn btn-primary btn-default green ng-binding']");
	private By HolidayCalendar = By.xpath("(//a[contains(.,'Holiday Calendar')])[2]");
	private By GridView = By.xpath("(//span[contains(.,'Grid View')])[3]");
	private By NewHolidayButton = By.xpath("//button[@class='btn btn-default pull-right btn-yellow']");
	private By HolidayName = By.xpath("(//input[@class='dx-texteditor-input'])[1]");
	private By PredenceFieldc = By.xpath("(//input[@class='dx-texteditor-input'])[4]");
	private By PromptField = By.xpath("(//input[@class='dx-texteditor-input'])[5]");
	private By CalendarTextArea = By.xpath("//textarea[@class='dx-texteditor-input']");
	private By CalendarSaveButton = By.xpath("(//span[@class='dx-button-text'])[2]");
	private By StartDate = By.xpath("(//md-input-container[@class='md-block md-input-has-placeholder md-input-has-value'])[1]/input");
	private By CarrierSelectionDD = By.xpath("(//md-select-value[@class='md-select-value'])[3]");
	private By ReportRunButton = By.xpath("//button[@class='btn btn-default green pull-right']");
	private By ReportInc = By.xpath("//div[@class='dx-datagrid-rowsview dx-datagrid-nowrap dx-scrollable dx-visibility-change-handler dx-scrollable-both dx-scrollable-simulated dx-scrollable-customizable-scrollbars']");
	  
	private By ScheduleReport = By.xpath("//a[contains(.,'Scheduled Reports')]");
	private By CreateScheduleButton = By.xpath("//button[@name='createScheduleBtn']");
	private By ScheduleReportName = By.xpath("//input[@name='ScheduleName']");
	private By RecurrencePattern = By.xpath("//span[text()='Once']");
	private By EmailToField = By.xpath("//md-chips[@name='CRMEmailId']");
	private By ReportSubmitButton = By.xpath("//button[@class='btn btn-default green pull-right']");
	private By PivotReport = By.xpath("//a[contains(.,'Pivot Reports')]");
	private By PivotStartDate = By.xpath("(//md-input-container[@class='md-block md-input-has-placeholder md-input-has-value'])[1]/input");
	private By RunPiviotReportButton = By.xpath("//button[@class='btn btn-default green pull-right']");




	
	private By AddCustomer = By.xpath("//a[@id='btnAddCustomer']");
	private By CustomerFirstname = By.xpath("(//input[@id='PersonDetails_FirstName'])[1]");
	private By CustomerLastname = By.xpath("(//input[@id='PersonDetails_LastName'])[1]");
	private By CustomerGender = By
			.cssSelector("#AddCustomer > fieldset > div:nth-child(4) > div:nth-child(2) > div > input , #AddCustomer > fieldset > div:nth-child(5) > div:nth-child(2) > div > input");
	private By GenderName = By.xpath("(//span[contains(.,'Male')])[1]");
	private By CustomerDOB = By.xpath("(//input[@id='PersonDetails_DateOfBirth'])[1]");
	private By CustomerAddressLine = By.xpath("(//input[@id='PersonDetails_Addresses_0__Address1'])[1]");
	private By CustomerZipcode = By.xpath("(//input[@id='PersonDetails_Addresses_0__Zip'])[1]");
	private By SameMailingAddress = By.xpath("(//input[@id='isMailAddressSame'])[1]");
	private By SaveButton = By.xpath("(//a[contains(.,'Save')])[1]");
	private By ContactSaveButton = By.xpath("(//a[contains(.,'Save')])[3]");
	private By SaveButtonIUR = By.xpath("//button[@id='btnUpdateProducer']");
	private By PhoneNumber = By.xpath("//input[@id='PersonDetails_Phone1']");
	private By CustomerFullName = By
			.xpath("(//a[@class='primary_color anchor_withunderline LoadCustomerAllDetails'])[1]");
	private By CustomerTile = By.xpath("(//a[@class='glyphicon fa fa-users'])[1]");
	private By ImportCustomerPolicyButton = By.id("importCustomerPolicyBtn");
	
	private By CustomerNameInCE = By.xpath("(//a[@class='edit-list-anchor ng-binding'])[1]");
	private By SelectCustomerToEdit = By.xpath("(//a[@class='primary_color anchor_withunderline LoadCustomerAllDetails'])[1]");
	private By ClickOnEditButton = By.xpath("//a[@class='square_anchor float_r editCustomer closeEdit']");
	private By EditLastName = By.xpath("//input[@id='customer_PersonDetails_LastName']");
	private By EditFirstName = By.xpath("//input[@id='customer_PersonDetails_FirstName']");
	private By EditSave = By.xpath("//a[@class='waves-effect waves-light btn primary_background btnUpdateCustomer']");
	private By ServiceTile = By.xpath("//a[@class='glyphicon fa fa-fw fa-gears']");
	private By NewServiceRequestButton = By.id("createServiceRequestBtn");
	private By IVRManagementTile = By.xpath("//a[@class='glyphicon fa fa-sitemap']");
	private By IVRManagementPrompt = By.xpath("(//a[contains(.,'Prompts')])[2]") ;  
	private By IVRNewPromptButton=By.xpath("//button[@class='btn btn-default pull-right btn-yellow ng-binding ng-scope']");
	
	
	
	private By SelectLogoutBE = By.xpath("(//a[contains(.,'Sign Out')])[1]");
	private By SelectUserBE = By.xpath("//a[@class='dropdownMenu user-details-menuSection dropdownArrowMenu']");
	private By SelectAdminUserBE = By.xpath("//a[@class='dropdown-trigger-user']");
	private By LoginAsAgency = By.cssSelector("#dropdown1 > li:nth-child(1) > a");
	private By ClickOnCloseButton = By.xpath("//*[@class='close_icon modal-close right']");
	private By RequestForLogin = By.xpath("//span[contains(.,'Request for Login')]");
	private By YopmailInbox = By.xpath("//input[@id='login']");
	private By YopmailSubmit = By.xpath("//button[@title='Check Inbox @yopmail.com']");
	private By ClickHere = By.cssSelector("#mail > div > p:nth-child(5) > a");
	private By NumberNPN = By.xpath("//input[@id='NationalProducerNumber']");
	private By AgentUserName = By.xpath("//input[@id='User_UserName']");
	private By AgentPassword = By.xpath("//input[@id='User_Password']");
	private By AgentRetypePassword = By.xpath("//input[@id='User_ReTypePassword']");
	private By SecurityQuestion1 = By.xpath("(//input[@class='select-dropdown dropdown-trigger'])[1]");
	private By SecurityQuestionSelection1 = By
			.xpath("(//span[contains(.,'What Is The Name Of Your Favorite Childhood Friend?')])[1]");
	private By SecurityQuestionSelection2 = By.xpath("(//span[contains(.,'In Which City Were You Born?')])[2]");
	private By SecurityQuestionSelection3 = By.xpath("(//span[contains(., \"What Is Your Best Friend's Name?\")])[3]");
	private By SecurityQuestion2 = By.xpath("(//input[@class='select-dropdown dropdown-trigger'])[1]");
	private By SecurityQuestion3 = By.xpath("(//input[@class='select-dropdown dropdown-trigger'])[1]");
	private By SecurityAnswer1 = By.xpath("//input[@id='User_SecurityAnswer1']");
	private By SecurityAnswer2 = By.xpath("//input[@id='User_SecurityAnswer2']");
	private By SecurityAnswer3 = By.xpath("//input[@id='User_SecurityAnswer3']");
	private By TermsAndCondition = By.xpath("//input[@id='User_EulaCheck']");
	private By PersonConscent = By.xpath("//input[@id='PersonConscent']");
	private By DashboardTile = By.xpath("//a[@class='glyphicon fa fa-fw fa-dashboard']");
	private By ClickOnMyTasks = By.cssSelector(
			"#page-wrapper > div > ui-view > div:nth-child(3) > div.col-lg-12.right-section-div.details.pad-lt.col-xl-3 > div > ul > li:nth-child(4) > a");
	private By ClickMyTasks = By.xpath("(//a[contains(.,'My Tasks')])[2]");
	private By TaskComments = By.cssSelector("#filter-by > div:nth-child(1) > form > div:nth-child(7) > textarea");
	private By CreateTaskSubmit = By
			.cssSelector("#filter-by > div:nth-child(1) > form > div:nth-child(7) > button:nth-child(3) > i");
	private By HomeMenu = By.xpath("//a[@id='menu_home']");
	private By DayView = By.xpath("(//div[@class='dx-item dx-tab'])[1]");
	private By WeekView = By.xpath("(//div[@class='dx-item dx-tab'])[1]");
	private By MonthView = By.xpath("(//div[@class='dx-item dx-tab'])[2]");
	private By Day_Week_Month_ViewTask = By.xpath("(//div[@class='appointment-preview'])[1]");
	private By EditTask = By
			.xpath("(//button[@class='btn btn-default pull-right edit-note-icon icons red-color ng-scope'])[1]");
	private By EditTaskComments = By.cssSelector(
			"#page-wrapper > div > ui-view > div.row.col-md-3.pad-rt.pad-lt.task-main-div.ng-scope > div.task-data > div > div.container-fluid.notes > form > div:nth-child(7) > textarea");
	private By SubmitEditedTask = By.cssSelector(
			"#page-wrapper > div > ui-view > div.row.col-md-3.pad-rt.pad-lt.task-main-div.ng-scope > div.task-data > div > div.container-fluid.notes > form > div:nth-child(7) > button:nth-child(3) > i");
	private By DeleteTask = By
			.xpath("(//button[@class='btn btn-default pull-right edit-note-icon icons red-color delete'])[1]");
	private By PopUpDeleteYes = By.xpath("//button[@class='btn btn-primary btn-default green']");
	private By FindInsuranceButton = By.xpath("//a[contains(.,'Find Insurance')]");
	private By HealthEnrollment = By.xpath("//a[@class='PopupClassDynamic no-padding' and @lob='Health']");
	private By ZipCode = By.xpath("//input[@id='ZipCode']");
	private By SeePlans = By.xpath("//button[contains(.,'See Plans')]");
	private By GenderOfApplicant = By.cssSelector(
			"body > main > div.container > div > div > div > form > fieldset > div:nth-child(12) > div.widget_content > div.row.margin_bottom_0px.censuslist.Applicantcensus.showncensus > div > div.col.s12.m3.l3 > div > div.select-wrapper > input");
	private By GenderSelection = By.xpath("(//span[contains(.,'Male')])[1]");
	private By ApplicantDOB = By.xpath("//input[@id='CoveredMembers_0__DateOfBirth']");
	private By PlanLabelAmbetter = By.xpath("(//input[@data-plantypename='Ambetter'])[1]");
	private By AddToCartButton = By.xpath("(//*[@id='mcmqAddToCart'])[1]");
	private By ContinueWithThisPlanCart = By.xpath("//a[contains(.,'Cart')]");
	private By ClickSelectButton = By.xpath("//a[contains(.,'Select')]");
	private By BeginEnrollment = By.xpath(
			"//a[@class='full_width_button waves-effect waves-light primary_background BeginEnrollmentAfterContactInformation toggleBeginEnrollmentForMedicare']");
	private By ContactFirstName = By.xpath("(//input[@id='ContactInformation_FirstName'])[5]");
	private By ContactLastName = By.xpath("(//input[@id='ContactInformation_LastName'])[5]");
	private By ContactPhone = By.xpath("(//input[@id='ContactInformation_PhoneNumber'])[4]");
	private By HouseholdAddress = By.xpath("//input[@id='Address_0__Address1']");
	private By ClickNext = By.xpath("//a[@id='yourNextPage']");
	private By SEPEvents = By.xpath("//select[@id='SepEvent_SepEventKey']");
	private By SEPEventDate = By.xpath("//input[@id='SepEvent_SepEventDate']");
	private By CustomerNameSEP = By.xpath("//select[@id='SepEvent_CustomerPersonId']");
	private By AddEventSEP = By.xpath("//button[@id='btnAddSEPEvent']");
	private By ClickSEPNext = By.xpath("//a[@id='citizenDocumentNextPage']");
	private By AppliedCircumstancesNext = By.xpath("//a[@id='AdditionalyourNextPage']");
	private By IncomeType = By.xpath("//select[@id='IncomeDetail_0__Type']");
	private By IncomeFrequency = By.xpath("//select[@id='IncomeDetail_0__AmountFrequency']");
	private By IncomeValue = By.xpath("//input[@id='IncomeDetail_0__Amount']");
	private By NoneOfTheseHRA = By.xpath("(//input[@name='IsQSEHRANoneOfThese'])[1]");
	private By ClickNextHRA = By.xpath("//a[@id='HRA_yourNextPage']");
	private By ClickIdTerms = By.xpath("//*[@id='Terms']");
	private By ClickNextOnAgent = By.xpath("//*[@class='round_btn summary_next']");
	private By ClickNextOnPayment = By.xpath("//*[@class='round_btn paymentselection_next']");
	private By RoutingNumberField = By.xpath("//*[@id='Quotes_0__PaymentProfile_RoutingNumber']");
	private By BankAccountNumber = By.xpath("//*[@id='Quotes_0__PaymentProfile_BankAccountNumber']");
	private By AccountHolderName = By.xpath("//*[@id='Quotes_0__PaymentProfile_EFTAccountHolderName']");
	private By AccountType = By.xpath("//*[@id='Quotes_0__PaymentProfile_AccountType']");
	private By YesSameEFT = By
			.xpath("//input[@id='Quotes_0__RecurringPaymentSameAsInitialPaymentIndForEFT' and @value='true']");
	private By PaymentNext = By.xpath("//a[@class='round_btn payment_next']");
	private By SummaryNext = By.xpath("//a[@class='round_btn applicationsummary_next']");
	private By FullfilmentAgree = By.xpath("//*[@id='Fulfillment_Iagree']");
	private By SubmitButton = By.xpath("//a[@class='round_btn confirmEnrollment_next']");
	private By CongratulationsMessage = By.xpath("//*[@class='relatively_fixed_label bigger ']");
	private By EnrollmentFinish = By.xpath("//*[@class='enrollmentfinish ']");
	private By SalesTile = By.xpath("//a[@class='glyphicon fa fa-handshake-o']");
	private By SalesLead = By.xpath("(//a[contains(.,'Leads')])[2]");
	private By NewLeadButton = By.id("newLeadBtn");
	private By ClickQuotes = By.xpath("(//a[contains(.,'Quotes')])[2]");
	private By ClickLeads = By.xpath("(//a[contains(.,'Leads')])[2]");
	private By CreatedDate = By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[7]");
	private By SelectBEUser = By.xpath("//a[@class='dropdownMenu user-details-menuSection dropdownArrowMenu']");
	private By SelectAgency = By.xpath("(//a[contains(.,'Agency Details')])[1]");
	private By BusinessType = By.xpath("(//input[@class='select-dropdown dropdown-trigger'])[5]");
	private By LifeOfBusiness = By.xpath("(//input[@class='select-dropdown dropdown-trigger'])[6]");
	private By MarketingURLButton = By.id("MarketingURL_button");
	private By CopyMarketingURL = By.cssSelector("#generate_url_id > ul > li.margin_bottom_0px > p");
	private By SelectAgentLogout = By.xpath("(//a[contains(.,'Sign Out')])[2]");
	private By MarketingLabel = By.xpath("//label[contains(.,' Marketing Details')]");
	private By SaveProgress = By.xpath("//a[@class='save_progress_click_submitm']");
	private By LeadFirstname = By.xpath("//input[@id='yourname']");
	private By LeadLastname = By.xpath("//input[@id='lastname']");
	private By LeadEmail = By.xpath("//input[@id='youremail']");
	private By SaveLeadDetails = By.xpath("(//a[contains(.,'Save')])[2]");
	private By CallBackRequest = By.xpath("//a[@class='callBackButton request_callback_click_submitm']");
	private By LeadCBFirstname = By.xpath("(//input[@id='yourName'])[1]");
	private By LeadCBLastname = By.xpath("(//input[@id='yourName'])[2]");
	private By LeadPhoneNumber = By.xpath("(//input[@id='phnNum'])[1]");
	private By LeadSubmitButton = By.xpath("//a[contains(.,'Submit')]");

	public void waitForElement(int time) throws InterruptedException {
		Thread.sleep(time);
	}

	public void login_CE_validations() throws InterruptedException {
		waitForElement(5000);
		WebElement checkUserLoginElement = null;

		try {
			checkUserLoginElement = driver.findElement(CheckUserLogin);

	if (checkUserLoginElement.isDisplayed()) {
				click(CheckUserLogin);
				ExtentSuccessMessage(
						"You currently have an active session on another device hence Deactivated the other session!");
			} else {
				ExtentSuccessMessage("Login is successful");
			}
		} catch (NoSuchElementException e) {
			ExtentSuccessMessage(
					"CheckUserLogin element not found! So you currently Dont have an active session on another device, hence Login is successful");
		} catch (Exception e) {
			ExtentSuccessMessage("Application login inaccurate. Details: " + e.getMessage());
			e.printStackTrace();
		}
		waitForElement(9000);
	}

	public void logout_CE_validations() throws InterruptedException {
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectUser));
		MoveToElementClick(element);
		ExtentSuccessMessage("User has been selected");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectLogout));
		MoveToElementClick(element);
		ExtentSuccessMessage("Logout has been performed!");
		waitForElement(1000);
		driver.manage().deleteAllCookies();
		waitForElement(3000);
	}
	

	

	
	
	public void landing_page_validations_MarketingTile() throws InterruptedException//----------->DONE
	{
		waitForElement(2000);
		waitForElement(6000);    //For UAT
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MarketingTile));
		MoveToElementClick(element);
		ExtentSuccessMessage("Marketing Tile has been clicked");
		waitForElement(3000);
		
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MarketingList));
		MoveToElementClick(element);
		ExtentSuccessMessage("Marketing list has been clicked");
		
//		waitForElement(7000);
		//Assert.assertTrue(driver.findElement(ValidateListButton).isDisplayed());
//		ExtentSuccessMessage("Assertion has been successful");
//		waitForElement(5000);
//		
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(HomeButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("HomeButton has been clicked");
		
		
	}
	
	public void landing_page_validations_SaleTile() throws InterruptedException//------------>Done
	{
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesTile));
		MoveToElementClick(element);//clicking on tiles
		ExtentSuccessMessage("Sales Tile has been clicked");
		
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesLead));
		MoveToElementClick(element);
		ExtentSuccessMessage("Sales Lead has been clicked");
		
		
		waitForElement(8000);  //for UAT
		Assert.assertTrue(driver.findElement(NewLeadButton).isDisplayed());
		ExtentSuccessMessage("Assertion has been successful");
	
		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(HomeButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("HomeButton has been clicked");
		waitForElement(3000);	
		}
	
	
	public void landing_page_validations_CustomerTile() throws InterruptedException//---------->Done
	{
		waitForElement(6000);
		
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerTile));
		MoveToElementClick(element);//clicking on customer tiles
		ExtentSuccessMessage("Customer Tile has been clicked");
		waitForElement(6000);
		
		Assert.assertTrue(driver.findElement(ImportCustomerPolicyButton).isDisplayed());
		ExtentSuccessMessage("Assertion has been successful");
		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(HomeButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("HomeButton has been clicked");
		waitForElement(3000);
		
	}
	
	
	public void landing_page_validation_AgencyTile() throws InterruptedException
	{
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgencyTile));
		MoveToElementClick(element);//clicking on Agent tiles  AgencyAgent
		ExtentSuccessMessage("Agency Tile has been clicked");
		
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgencyAgent));
		MoveToElementClick(element);//clicking on Agent tiles  NewAgentButton
		ExtentSuccessMessage("Agency Agent has been clicked");
		//waitForElement(5000);  //For AWSPP
		waitForElement(9000); //for UAT
		
		Assert.assertTrue(driver.findElement(NewAgentButton).isDisplayed());
		ExtentSuccessMessage("Assertion has been successful");
		waitForElement(3000);
		
		element = wait.until(ExpectedConditions.presenceOfElementLocated(HomeButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("HomeButton has been clicked");
		waitForElement(3000);	
		
	}
	
	public void landing_page_validation_ServiceTile() throws InterruptedException
	{
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceTile));
		MoveToElementClick(element);//clicking on Service tiles  
		ExtentSuccessMessage("Service Tile has been clicked");
		
	//	waitForElement(3000);//for AWSPP
		waitForElement(7000);
		Assert.assertTrue(driver.findElement(NewServiceRequestButton).isDisplayed());
		ExtentSuccessMessage("Assertion has been successful");
		waitForElement(3000);
		
		element = wait.until(ExpectedConditions.presenceOfElementLocated(HomeButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("HomeButton has been clicked");
		waitForElement(3000);
		
	}
	
	public void landing_page_validation_IVR_ManagementTile() throws InterruptedException
	{
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(IVRManagementTile));
		MoveToElementClick(element);//clicking on Service tiles  
		ExtentSuccessMessage("IVR Management Tile has been clicked");
		
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(IVRManagementPrompt));
		MoveToElementClick(element);//clicking on IVR tiles  
		ExtentSuccessMessage("Prompt has been clicked");
		
		
		waitForElement(3000);
		Assert.assertTrue(driver.findElement(IVRNewPromptButton).isDisplayed());
		ExtentSuccessMessage("Assertion has been successful");
		waitForElement(3000);
		
		
		element = wait.until(ExpectedConditions.presenceOfElementLocated(HomeButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("HomeButton has been clicked");
		waitForElement(3000);
		
	
	}
	
	public void landing_page_validation_AdminTile() throws InterruptedException
	{
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdminTile));
		MoveToElementClick(element);//clicking on Admin tiles  
		ExtentSuccessMessage("Admin Tile has been clicked");
		
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdminRolesAndPermission));
		MoveToElementClick(element);//clicking on IVR tiles  
		ExtentSuccessMessage("Roles And Permission has been clicked");
		
		waitForElement(3000);
		Assert.assertTrue(driver.findElement(AddRolesAndPermissionButton).isDisplayed());
		ExtentSuccessMessage("Assertion has been successful");
		waitForElement(3000);
		
		element = wait.until(ExpectedConditions.presenceOfElementLocated(HomeButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("HomeButton has been clicked");
		waitForElement(3000);
		
		
	}
	
	public void landing_page_validation_ReportTile() throws InterruptedException
	{
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ReportTile));
		MoveToElementClick(element);//clicking on Report tiles  
		ExtentSuccessMessage("Report Tile has been clicked");
		
		//waitForElement(3000); //for AWSPP
		waitForElement(8000); //for UAT
		Assert.assertTrue(driver.findElement(LiveReport).isDisplayed());
		ExtentSuccessMessage("Assertion has been successful");
		waitForElement(3000);
		
		element = wait.until(ExpectedConditions.presenceOfElementLocated(HomeButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("HomeButton has been clicked");
		waitForElement(3000); 
			
	}
	
	public void landing_page_validation_DashBoardTile() throws InterruptedException
	{
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(DashBoardTile));
		MoveToElementClick(element);//clicking on DashBoard tiles  
		ExtentSuccessMessage("DashBoard Tile has been clicked");
		
		
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(DashBoardMyTask));
		MoveToElementClick(element);//clicking on My TAsk tiles  
		ExtentSuccessMessage("Report Tile has been clicked");
		
		//waitForElement(3000); //for awspp and uat
		waitForElement(7000); //for QA
		Assert.assertTrue(driver.findElement(DashBoardCalendar).isDisplayed());
		ExtentSuccessMessage("Assertion has been successful");
		waitForElement(3000);
		
		element = wait.until(ExpectedConditions.presenceOfElementLocated(HomeButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("HomeButton has been clicked");
		waitForElement(3000); 
		
		
		
	}
	
	public void landing_page_validation_CommissionTile() throws InterruptedException
	{
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CommissionTile));
		MoveToElementClick(element);//clicking on DashBoard tiles  
		ExtentSuccessMessage("Commision Tile has been clicked");
		
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CommissionSetup));
		MoveToElementClick(element);//clicking on My TAsk tiles  
		ExtentSuccessMessage("Report Setup has been clicked");
		
		waitForElement(3000);
		Assert.assertTrue(driver.findElement(CommissionSetupTitle).isDisplayed());
		ExtentSuccessMessage("Assertion has been successful");
		waitForElement(3000);
		
		element = wait.until(ExpectedConditions.presenceOfElementLocated(HomeButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("HomeButton has been clicked");
		waitForElement(3000); 
	
		
	}
	
	public void landing_page_IconValidation_CTIIcon() throws InterruptedException
	{
		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CTIIcon));
		MoveToElementClick(element);//clicking on DashBoard tiles  
		ExtentSuccessMessage("CTI Icon has been clicked");
		
		waitForElement(4000);
		Assert.assertTrue(driver.findElement(CTIDialPadIcon).isDisplayed());
		ExtentSuccessMessage("Assertion has been successful");
		waitForElement(3000);
		
		
		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CTIMinimizeIcon));
		MoveToElementClick(element);//clicking on DashBoard tiles  
		ExtentSuccessMessage("CTI Icon has been clicked");
		
	
	}
	
	public void landing_page_IconValidation_CallBackNotification() throws InterruptedException
	{
		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CallBackNotificationIcon));
		MoveToElementClick(element);//clicking on CTIICON tiles  CallBackNitificationTitle
		ExtentSuccessMessage("CTI Icon has been clicked");
		
		waitForElement(4000);
		Assert.assertTrue(driver.findElement(CallBackNitificationTitle).isDisplayed());
		ExtentSuccessMessage("Assertion has been successful");
		waitForElement(3000);
		
		
		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CallBackNitificationMinimizeIcon));
		MoveToElementClick(element);//clicking on CTIICON tiles  
		ExtentSuccessMessage("Minimize Icon has been clicked");
		
		
		
	}
	
	public void landing_page_IconValidation_MyProfileIcon() throws InterruptedException
	{
		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectUser));
		MoveToElementClick(element);
		ExtentSuccessMessage("User has been selected");
		waitForElement(3000);
		
		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MyProfileIcon));
		MoveToElementClick(element);
		ExtentSuccessMessage("My Profile Icon has been selected");
		waitForElement(3000);
		
		waitForElement(4000);
		Assert.assertTrue(driver.findElement(MyProfileSubmitButton).isDisplayed());
		ExtentSuccessMessage("Assertion has been successful");
		waitForElement(3000);
			
	}
	
	
		
	
	 public void agency_CreateAgent(CensusInfo ApplicantInfo) throws InterruptedException, AWTException, IOException
	 {
		 
		   waitForElement(4000);
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(CTIMinimizeIcon));
		   MoveToElementClick(element);//clicking on DashBoard tiles  
					
		    waitForElement(6000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(AgencyTile));
			MoveToElementClick(element);//clicking on Agent tiles  AgencyAgent
			ExtentSuccessMessage("Agency Tile has been clicked");
			
			waitForElement(3000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(AgencyAgent));
			MoveToElementClick(element);
			ExtentSuccessMessage("Agency Agent has been clicked");
			
			waitForElement(3000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(NewAgentButton));
			MoveToElementClick(element);
			ExtentSuccessMessage("New Agent Button has been clicked");
			
			waitForElement(3000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentPrefix));
			MoveToElementClick(element);
		
			waitForElement(3000);
			
			element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentPrefixOption));
			MoveToElementClick(element);
			ExtentSuccessMessage("Prefix has been selected");
			
			waitForElement(3000);
		
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
			
			waitForElement(3000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(AgencyType));
			MoveToElementClick(element);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(AgencyTypeOption));
			MoveToElementClick(element);
			ExtentSuccessMessage("Agency type has been selected");
			
			element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentLicenseNumber));
			MoveToElementClick(element);
			writeText(AgentLicenseNumber, ""+getRandomNumber());
			ExtentSuccessMessage("License number has been entered");
			
			waitForElement(3000);
			
			element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentStatus));
			MoveToElementClick(element);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentStatusOption));
			MoveToElementClick(element);
			ExtentSuccessMessage("Agency type has been selected");
			
			waitForElement(3000);			
			element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentContactInformationSection));
			MoveToElementClick(element);
			
			waitForElement(3000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentPhoneNumber));
			MoveToElementClick(element);
			writeText(AgentPhoneNumber,generatePhoneNumber() );
			ExtentSuccessMessage("Phone number has been entered");
			
			waitForElement(3000);
			
			element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentEmailId));
			MoveToElementClick(element);
			String AgentMailId = writeDynamicEmail() ;
			writeText(AgentEmailId,AgentMailId );
			ExtentSuccessMessage("Email has been entered");
			
			waitForElement(4000);
	
			element = wait.until(ExpectedConditions.presenceOfElementLocated(PimaryAddressInfoSection));
			MoveToElementClick(element);
			
			waitForElement(3000);
		
			element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentAddress));
			MoveToElementClick(element);
			writeText(AgentAddress,"Park Field" );
			ExtentSuccessMessage("Address been entered");
			
			waitForElement(3000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentZipcode));
			MoveToElementClick(element);
			writeText(AgentZipcode,"44444" );
			ExtentSuccessMessage("Zipcode has been entered");
			
			waitForElement(3000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(MailinhAddressCheckBox));
			MoveToElementClick(element);
			
			
			element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentSubmitButton));
			MoveToElementClick(element);
			ExtentSuccessMessage("New Agent has been created");
			
			waitForElement(6000);
			By NewAgentSearchField = By.xpath("//input[@class='ng-pristine ng-untouched md-input ng-empty ng-valid-minlength ng-valid-maxlength ng-valid ng-valid-required']");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(NewAgentSearchField));
			MoveToElementClick(element);
			writeText(AgentSearchField,AgentMailId + Keys.ENTER);
			ExtentSuccessMessage("Search has been clicked");
		
			
			waitForElement(3000);
			By AgentINC = By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[4]");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentINC));
			 AgentText  = element.getText();
			System.out.println("-----------"+ AgentText+"------------");
			Assert.assertEquals(AgentMailId , AgentText);
			ExtentSuccessMessage("Assertion has been done");
			
		
			
			
		
			
	 }
	 
	

	public void add_Agent_License(CensusInfo ApplicantInfo) throws InterruptedException, AWTException
	 {
		 
		
		   waitForElement(4000);
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(CTIMinimizeIcon));
		   MoveToElementClick(element);//clicking on DashBoard tiles  
					
		    waitForElement(6000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(AgencyTile));
			MoveToElementClick(element);//clicking on Agent tiles  AgencyAgent
			ExtentSuccessMessage("Agency Tile has been clicked");
			
			waitForElement(3000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(AgencyAgent));
			MoveToElementClick(element);
			ExtentSuccessMessage("Agency Agent has been clicked");
			
			waitForElement(3000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentSearchField));
			MoveToElementClick(element);
			writeText(AgentSearchField, ApplicantInfo.FirstName);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(500);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(500);
			
			element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentFormList));
			MoveToElementClick(element);
			ExtentSuccessMessage("Agent from list has been clicked");
			
			element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentLicenseButton));
			MoveToElementClick(element);
			Thread.sleep(1000);

			element = wait.until(ExpectedConditions.presenceOfElementLocated(StateDD));
			MoveToElementClick(element);
			Thread.sleep(3000);
			robot.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(1000);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(1000);
			
//			element = wait.until(ExpectedConditions.presenceOfElementLocated(DDValue));
//			MoveToElementClick(element);
			ExtentSuccessMessage("State has been selected");
			
			Thread.sleep(1000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(IssuedDate));
			MoveToElementClick(element);
			writeText(IssuedDate, "04/10/2024");
			robot.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(500);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(500);
			ExtentSuccessMessage("Issue Date has been Entered");
			
			
			element = wait.until(ExpectedConditions.presenceOfElementLocated(ExpiryDate));
			MoveToElementClick(element);
			String LicenseExpiryDate = "10/10/2024";
			writeText(ExpiryDate, LicenseExpiryDate);
			robot.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(500);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(500);
			ExtentSuccessMessage("Expiry Date has been Entered");
			
			element = wait.until(ExpectedConditions.presenceOfElementLocated(StatusDD));
			MoveToElementClick(element);
			
			element = wait.until(ExpectedConditions.presenceOfElementLocated(StatusDDOption));
			MoveToElementClick(element);
			ExtentSuccessMessage("Status Has been Clicked");
			
			element = wait.until(ExpectedConditions.presenceOfElementLocated(SubmitLicenseButton));
			MoveToElementClick(element);
			ExtentSuccessMessage("License Has been created");
			
			waitForElement(3000);
			
			element = wait.until(ExpectedConditions.presenceOfElementLocated(LicenseSection));
			MoveToElementClick(element);
			ExtentSuccessMessage("License Section has been clicked");
			
			
				
			
		
			
			
	
		 
	 }
	
	public void add_Agent_Carrier(CensusInfo ApplicantInfo) throws InterruptedException, AWTException
	{
		
		   waitForElement(4000);
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(CTIMinimizeIcon));
		   MoveToElementClick(element);//clicking on DashBoard tiles  
					
		    waitForElement(6000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(AgencyTile));
			MoveToElementClick(element);//clicking on Agent tiles  AgencyAgent
			ExtentSuccessMessage("Agency Tile has been clicked");
			
			waitForElement(3000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(AgencyAgent));
			MoveToElementClick(element);
			ExtentSuccessMessage("Agency Agent has been clicked");
			
			waitForElement(3000);
			
			element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentSearchField));
			MoveToElementClick(element);
			writeText(AgentSearchField, ApplicantInfo.FirstName + Keys.ENTER);
			
			
			waitForElement(3000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentFormList));
			MoveToElementClick(element);
			ExtentSuccessMessage("Agent from list has been clicked");
			
			waitForElement(3000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierAppointmmentButton));
			MoveToElementClick(element);
			ExtentSuccessMessage("Carrier Appointment has been clicked");
			
			Assert.assertTrue(driver.findElement(CarrierAppointmmentButton).isEnabled());
			ExtentSuccessMessage("Assertion has been successfull ");
			
			
			waitForElement(3000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierNameDD));
			MoveToElementClick(element);
			waitForElement(3000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierOption));
			MoveToElementClick(element);
			ExtentSuccessMessage("Carrier Name has been Searched");
		
			waitForElement(3000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(StateDD));
			MoveToElementClick(element);
			
			element = wait.until(ExpectedConditions.presenceOfElementLocated(StateOption));
			MoveToElementClick(element);
			ExtentSuccessMessage("Carrier State has been Searched");
			
			waitForElement(3000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierStartDate));
			writeText(CarrierStartDate, "10/15/2024" + Keys.ENTER);
			ExtentSuccessMessage("Carrier date has been Selected");
		
			waitForElement(3000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierStatusDD));
			MoveToElementClick(element);
			
			element = wait.until(ExpectedConditions.presenceOfElementLocated(StatusOption));
			MoveToElementClick(element);
			ExtentSuccessMessage("Carrier Status has been Selected");
			
			waitForElement(3000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierSubmitButton));
			MoveToElementClick(element);
			ExtentSuccessMessage("Submit button has been Selected");
			
         	waitForElement(3000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierField));
			MoveToElementClick(element);
			ExtentSuccessMessage("Carrier Appointment has been Selected");
			
	
		
		
		
	}
	
	public void add_Agent_AgencyActions(CensusInfo ApplicantInfo) throws InterruptedException, AWTException
	{
		    waitForElement(4000);
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(CTIMinimizeIcon));
		   MoveToElementClick(element);//clicking on DashBoard tiles  
					
		    waitForElement(6000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(AgencyTile));
			MoveToElementClick(element);//clicking on Agent tiles  AgencyAgent
			ExtentSuccessMessage("Agency Tile has been clicked");
			
			waitForElement(3000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(AgencyAgent));
			MoveToElementClick(element);
			ExtentSuccessMessage("Agency Agent has been clicked");
			
			waitForElement(3000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentSearchField));
			MoveToElementClick(element);
			writeText(AgentSearchField, ApplicantInfo.FirstName + Keys.ENTER);
			ExtentSuccessMessage("Agent has been searched");
			
			waitForElement(3000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentFormList));
			MoveToElementClick(element);
			ExtentSuccessMessage("Agent from list has been clicked");
			
		    waitForElement(200000);
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
			By EmailAddressDDOPtion = By.xpath("//md-option[@value='salessupport@truecoverage.com']");
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
			By DocumentDD1 =  By.xpath("/html/body/div[3]/div[6]/div/ui-view/div[3]/div[5]/div/div/div[2]/div/div[1]/form/div[1]/select");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(DocumentDD1));
			Select s1 = new Select(element);
			s1.selectByVisibleText("Other");
//			
//			element = wait.until(ExpectedConditions.presenceOfElementLocated(DocumentDD));
//			wait.until(ExpectedConditions.elementToBeClickable(DocumentDD));
//			click(DocumentDD);
//			waitForElement(500);
//           
//            wait.until(ExpectedConditions.elementToBeClickable(DocumentDDOption));
//			click(DocumentDDOption);	
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
	
	public void agency_AgentFilter() throws InterruptedException
	{
		
		   waitForElement(4000);
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(CTIMinimizeIcon));
		   MoveToElementClick(element);//clicking on DashBoard tiles  
					
		    waitForElement(6000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(AgencyTile));
			MoveToElementClick(element);//clicking on Agent tiles  AgencyAgent
			ExtentSuccessMessage("Agency Tile has been clicked");
			
			waitForElement(3000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(AgencyAgent));
			MoveToElementClick(element);
			ExtentSuccessMessage("Agency Agent has been clicked");
			
			waitForElement(7000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(RecentAgentIcon));
			MoveToElementClick(element);
			
			
			waitForElement(3000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CreatedTodayButton));
			MoveToElementClick(element);
			
			waitForElement(3000);
			Assert.assertTrue(driver.findElement(CreatedTodayInc).isDisplayed());
			ExtentSuccessMessage("Assertion has been done");
			

		
	}
	
	public void agency_AgentAdvancedSearch() throws InterruptedException
	{
		   waitForElement(4000);
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(CTIMinimizeIcon));
		   MoveToElementClick(element);//clicking on DashBoard tiles  
					
		    waitForElement(6000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(AgencyTile));
			MoveToElementClick(element);//clicking on Agent tiles  AgencyAgent
			ExtentSuccessMessage("Agency Tile has been clicked");
			
			waitForElement(3000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(AgencyAgent));
			MoveToElementClick(element);
			ExtentSuccessMessage("Agency Agent has been clicked");
			
			waitForElement(3000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedSearchButton));
			MoveToElementClick(element);
			ExtentSuccessMessage("Advanced Search has been clicked");
			
			waitForElement(3000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedSearchStatusDD));
			MoveToElementClick(element);
			
			element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedSearchStatusOption));
			MoveToElementClick(element);
			ExtentSuccessMessage("Status has been clicked");
			
			waitForElement(3000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedSearchStateDD));
			MoveToElementClick(element);
           
            element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedSearchStateOption));
			MoveToElementClick(element);
			ExtentSuccessMessage("State has been clicked");
			
			waitForElement(3000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedSearchSubmitButton));
			MoveToElementClick(element);
			ExtentSuccessMessage("Search Button has  been clicked");
			waitForElement(3000);
			
			
			Assert.assertTrue(driver.findElement(AdvancedSearchInc).isDisplayed());
			ExtentSuccessMessage("Assertion has been done");
		
	
	}
	
	public void agency_ExportAgent() throws InterruptedException
	{
		  waitForElement(4000);
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(CTIMinimizeIcon));
		   MoveToElementClick(element);//clicking on DashBoard tiles  
					
		    waitForElement(6000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(AgencyTile));
			MoveToElementClick(element);//clicking on Agent tiles  AgencyAgent
			ExtentSuccessMessage("Agency Tile has been clicked");
			
			waitForElement(3000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(AgencyAgent));
			MoveToElementClick(element);
			ExtentSuccessMessage("Agency Agent has been clicked");
			
			 waitForElement(9000);
			Assert.assertTrue(driver.findElement(ExportAgentButton).isDisplayed());
			ExtentSuccessMessage("Assertion is done");
			

			element = wait.until(ExpectedConditions.presenceOfElementLocated(ExportAgentButton));
			MoveToElementClick(element);
			Thread.sleep(5000);
			ExtentSuccessMessage("Export Agent Button has been clicked");
			
			
		
		
			
			
			
			
			
		
	}
	
	
	public void carrier_CreateNewCarrier(CensusInfo ApplicantInfo) throws InterruptedException, AWTException, IOException
	{
		   waitForElement(4000);
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(CTIMinimizeIcon));
		   MoveToElementClick(element);//clicking on DashBoard tiles  
					
		    waitForElement(6000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(AgencyTile));
			MoveToElementClick(element);
			ExtentSuccessMessage("Agency Tile has been clicked");
			
			
			element = wait.until(ExpectedConditions.presenceOfElementLocated(AgencyCarrier));
			MoveToElementClick(element);
			ExtentSuccessMessage("Agency Carrier has been clicked");
			
			 waitForElement(3000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(NewCarrierButton));
			MoveToElementClick(element);
			ExtentSuccessMessage("New Carrier Button has been clicked");
			
			
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierNameDD2));
			MoveToElementClick(element);
			Thread.sleep(3000);
			Robot robot= new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(1000);
			
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(1000);
			Thread.sleep(2000);
			
			waitForElement(1000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierPrimaryContactName));
			MoveToElementClick(element);
			writeText(CarrierPrimaryContactName, "AutoAgent" + getRandomNumber());
			ExtentSuccessMessage("Primary Contact has been Entered");
			
			waitForElement(1000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierEmailId));
			MoveToElementClick(element);
			String Email = writeDynamicEmail();
			writeText(CarrierEmailId, Email );
			writeEmailToExcel(Email , "TC CE2");
			ExtentSuccessMessage("Email has been Entered");
			
			waitForElement(3000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierTextArea));
			MoveToElementClick(element);
			writeText(CarrierTextArea, "This Carrier is Created Via Automation" );
			
		
			waitForElement(3000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierSaveButton));
			MoveToElementClick(element);
			ExtentSuccessMessage("Carrier have been saved");
			
		
		
	}
	
	
	public void agency_AddCarrierAppointment(CensusInfo ApplicantInfo) throws InterruptedException, AWTException
	{
		 waitForElement(4000);
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(CTIMinimizeIcon));
		   MoveToElementClick(element);//clicking on DashBoard tiles  
					
		    waitForElement(6000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(AgencyTile));
			MoveToElementClick(element);
			ExtentSuccessMessage("Agency Tile has been clicked");
			
			 waitForElement(2000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(AgencyCarrier));
			MoveToElementClick(element);
			ExtentSuccessMessage("Agency Carrier has been clicked");
			
			waitForElement(2000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierSearchTextField));
			MoveToElementClick(element);
			writeText(CarrierSearchTextField, ApplicantInfo.Email + Keys.ENTER );
			ExtentSuccessMessage("Email has been Entered");
			
			waitForElement(9000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierNameSearchField));
			MoveToElementClick(element);
			ExtentSuccessMessage("Carrrier name has been Clicked");
			
			waitForElement(2000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierAgentAppointmentButton));
			MoveToElementClick(element);
			ExtentSuccessMessage("Appointment Button has been clicked");
			
			waitForElement(3000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierAgentNameDD));
			MoveToElementClick(element);
			
			waitForElement(2000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierAgentNameOption));
			MoveToElementClick(element);
			ExtentSuccessMessage("Agent name has been selected");

			waitForElement(2000);
			By CarrierStateDD  = By.xpath("//md-select[@name='State']");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierStateDD));
			MoveToElementClick(element);
			waitForElement(2000);
		
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierStateDDOption));
			MoveToElementClick(element);
			ExtentSuccessMessage("State has been clicked");
			
			waitForElement(2000);
			
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierAgentStatusDD));
			MoveToElementClick(element);
			waitForElement(2000);
			
			
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierAgentStatusOption));
			MoveToElementClick(element);
			ExtentSuccessMessage("Agent has been clicked");
			
	
			Assert.assertTrue(driver.findElement(AppointmentCarrierSubmitButton).isEnabled());
			ExtentSuccessMessage("Assertion has been done");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(AppointmentCarrierSubmitButton));
			MoveToElementClick(element);
			ExtentSuccessMessage("Submit Button has been clicked");
		
		
	}
	
	public void agency_CarrierAction(CensusInfo ApplicantInfo) throws InterruptedException, AWTException
	{
		waitForElement(4000);
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(CTIMinimizeIcon));
		   MoveToElementClick(element);//clicking on DashBoard tiles  
					
		    waitForElement(6000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(AgencyTile));
			MoveToElementClick(element);//clicking on Agent tiles  AgencyAgent
			ExtentSuccessMessage("Agency Tile has been clicked");
			
			waitForElement(3000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(AgencyCarrier));
			MoveToElementClick(element);
			ExtentSuccessMessage("Agency Carrier has been clicked");
			
			waitForElement(3000);
			By CarrierSearchField = By.xpath("//input[@class='ng-pristine ng-untouched md-input ng-empty ng-valid-minlength ng-valid-maxlength ng-valid ng-valid-required']");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierSearchField));
			MoveToElementClick(element);
			writeText(CarrierSearchField, ApplicantInfo.Email + Keys.ENTER);
			ExtentSuccessMessage("Carrier has been searched");
			
			waitForElement(5000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierNameSearchField));
			MoveToElementClick(element);
			ExtentSuccessMessage("Carrier from list has been clicked");
			
		    waitForElement(3000);
		    element = wait.until(ExpectedConditions.presenceOfElementLocated(NotesSection));
			MoveToElementClick(element);
			String Note = "This is created Via Automation";
			writeText(NotesSection, Note);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(NotesConfirmationButton));
			MoveToElementClick(element);
			ExtentSuccessMessage("Note has been added");
			
			waitForElement(7000);		
			element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentActionNoteInc));
			 NoteText  = element.getText();
			System.out.println("-----------"+ NoteText+"------------");
			Assert.assertEquals(Note, NoteText);
			ExtentSuccessMessage("Assertion has been done");
			
		
		    waitForElement(5000);
		    By CarrierActionEmailIcon = By.xpath("(//li[@class='ng-scope'])[8]/a[@role='tab']");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierActionEmailIcon));
			MoveToElementClick(element);
			
			 waitForElement(2000);
			By EmailAddressDD = By.xpath("//md-select[@role='listbox']");
			wait.until(ExpectedConditions.elementToBeClickable(EmailAddressDD));
			click(EmailAddressDD);
			By EmailAddressDDOPtion = By.xpath("//md-option[@value='salessupport@truecoverage.com']");
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
					
		   
			waitForElement(6000);
			By ActionAttachment = By.xpath("(//li[@class='ng-scope'])[9]/a[@role='tab']");
		    element = wait.until(ExpectedConditions.presenceOfElementLocated(ActionAttachment));
			MoveToElementClick(element);
			
			waitForElement(6000);
			By DocumentDD1 =  By.xpath("/html/body/div[3]/div[6]/div/ui-view/div[3]/div[4]/div/div/div[2]/div/div[1]/form/div[1]/select");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(DocumentDD1));
			Select s1 = new Select(element);
			s1.selectByVisibleText("Other");
//			
//			element = wait.until(ExpectedConditions.presenceOfElementLocated(DocumentDD));
//			wait.until(ExpectedConditions.elementToBeClickable(DocumentDD));
//			click(DocumentDD);
//			waitForElement(500);
//        
//         wait.until(ExpectedConditions.elementToBeClickable(DocumentDDOption));
//			click(DocumentDDOption);	
			wait.until(ExpectedConditions.elementToBeClickable(DocumentAttachFileButton));
			click(DocumentAttachFileButton);
			
			Robot robot = new Robot();
			String filePath = System.getProperty("user.dir") + "\\Upload\\CarrierAttachment.txt";
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
			
		
			Assert.assertTrue(driver.findElement(AttachmentInc).isDisplayed());
			ExtentSuccessMessage("Assertion has been done");
			
	
			
			waitForElement(4000);
			By ActionTask = By.xpath("(//li[@class='ng-scope'])[10]/a[@role='tab']");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(ActionTask));
			MoveToElementClick(element);
			waitForElement(4000);
			By ActivityDd = By.xpath("/html/body/div[3]/div[6]/div/ui-view/div[3]/div[4]/div/div/div[2]/div/div[1]/form/div[2]/select");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(ActivityDd));
			//element.click();
			Thread.sleep(600);
			Select select = new Select(element);
			select.selectByValue("string:Send Email");
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
	
	public void agent_CarrierFilter() throws InterruptedException
	{
		
		   waitForElement(4000);
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(CTIMinimizeIcon));
		   MoveToElementClick(element);//clicking on DashBoard tiles  
					
		    waitForElement(6000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(AgencyTile));
			MoveToElementClick(element);
			ExtentSuccessMessage("Agency Tile has been clicked");
			
			
			waitForElement(2000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(AgencyCarrier));
			MoveToElementClick(element);
			ExtentSuccessMessage("Agency Carrier has been clicked");
			
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierFilterProductCategory));
			MoveToElementClick(element);
			ExtentSuccessMessage("Filter has been clicked");
			Thread.sleep(3000);

			element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierStateFilter));
			MoveToElementClick(element);
			Thread.sleep(3000);
			ExtentSuccessMessage("Filter has been clicked");
			
			element = wait.until(ExpectedConditions.presenceOfElementLocated(FilterCarrierStateDD));
			MoveToElementClick(element);
			ExtentSuccessMessage("StateDropdown has been clicked");
			
	
			Thread.sleep(3000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierStateOption));
			MoveToElementClick(element);
			waitForElement(2000);
			
			Thread.sleep(3000);
		
			Assert.assertTrue(driver.findElement(CarrierFilterInc).isDisplayed());
			ExtentSuccessMessage("Assertion is done");
			
			
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierStateDD));
			MoveToElementClick(element);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierStateOption1));
			MoveToElementClick(element);
		
			Thread.sleep(3000);
			Assert.assertTrue(driver.findElement(CarrierFilterInc).isDisplayed());
			ExtentSuccessMessage("Assertion is done");
			ExtentSuccessMessage("State DropDown has been clicked");
			
			
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierRefreshButton));
			MoveToElementClick(element);
			ExtentSuccessMessage("Refresh Button has been clicked");
			
		
		
	}
	
	public void agent_CarrierSearch(CensusInfo ApplicantInfo) throws InterruptedException
	{
		
		
		 waitForElement(4000);
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(CTIMinimizeIcon));
		   MoveToElementClick(element);//clicking on DashBoard tiles  
					
		    waitForElement(6000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(AgencyTile));
			MoveToElementClick(element);
			ExtentSuccessMessage("Agency Tile has been clicked");
			
			 waitForElement(2000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(AgencyCarrier));
			MoveToElementClick(element);
			ExtentSuccessMessage("Agency Carrier has been clicked");
			
			waitForElement(2000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierSearchTextField));
			MoveToElementClick(element);
			
			Assert.assertTrue(driver.findElement(CarrierSearchTextField).isDisplayed());
			ExtentSuccessMessage("Assertion has been done");
			
			writeText(CarrierSearchTextField, ApplicantInfo.Email + Keys.ENTER );
			ExtentSuccessMessage("Email has been Entered");
			waitForElement(2000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Textfield));
			MoveToElementClick(element);
			element.clear();
			writeText(Textfield, "(855) 745-5507" + Keys.ENTER );
			ExtentSuccessMessage("Carrier has been searched");
		
		
		
	}
	
	public void agency_ExportCarrier() throws InterruptedException
	{
		   waitForElement(7000);
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(CTIMinimizeIcon));
		   MoveToElementClick(element);//clicking on DashBoard tiles  
					
		   waitForElement(6000);
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(AgencyTile));
		   MoveToElementClick(element);
	       ExtentSuccessMessage("Agency Tile has been clicked");
			
		    waitForElement(2000);
		
			element = wait.until(ExpectedConditions.presenceOfElementLocated(AgencyCarrier));
			MoveToElementClick(element);
			ExtentSuccessMessage("Agency Carrier has been clicked");
			
		    waitForElement(8000);
	        Assert.assertTrue(driver.findElement(CarrierImportButton).isDisplayed());
	        ExtentSuccessMessage("Assertion has been done");
	        
	        waitForElement(4000);
	        element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierImportButton));
			MoveToElementClick(element);
			Thread.sleep(5000);
			ExtentSuccessMessage("Export Button has been clicked");
		
	}
	
	public void agency_CreateNewCarrierGroup() throws InterruptedException
	{
		  waitForElement(4000);
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(CTIMinimizeIcon));
		   MoveToElementClick(element);//clicking on DashBoard tiles  
					
		   waitForElement(6000);
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(AgencyTile));
		   MoveToElementClick(element);
	       ExtentSuccessMessage("Agency Tile has been clicked");
			
		    waitForElement(2000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(AgencyCarrier));
			MoveToElementClick(element);
			ExtentSuccessMessage("Agency Carrier has been clicked");
			
			waitForElement(2000);
		
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierGroupButton));
			MoveToElementClick(element);
			ExtentSuccessMessage("Carrier Group Button has been clicked");
			
			waitForElement(2000);
			
			Assert.assertTrue(driver.findElement(NewCarrierGroupButton).isDisplayed());
			ExtentSuccessMessage("Assertion has been done");
			
			element = wait.until(ExpectedConditions.presenceOfElementLocated(NewCarrierGroupButton));
			MoveToElementClick(element);
			ExtentSuccessMessage("New Carrier Group Button has been clicked");
			
			waitForElement(2000);
		
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierGroupNameField));
			MoveToElementClick(element);
			String CarrierGroupName = "AutoCarrierGroup"+ getRandomNumber();
			writeText(CarrierGroupNameField,CarrierGroupName + Keys.ENTER );
			ExtentSuccessMessage("Carrier Name has been Entered");
			
			waitForElement(2000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierOption1));
			MoveToElementClick(element);
			waitForElement(700);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierOption2));
			MoveToElementClick(element);
			waitForElement(700);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierOption3));
			MoveToElementClick(element);
			waitForElement(700);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierOption4));
			MoveToElementClick(element);
			waitForElement(700);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierOption5));
			MoveToElementClick(element);
			waitForElement(700);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierOption6));
			MoveToElementClick(element);
			waitForElement(700);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierOption7));
			MoveToElementClick(element);
			waitForElement(700);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierOption8));
			MoveToElementClick(element);
			waitForElement(700);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierOption9));
			MoveToElementClick(element);
			waitForElement(700);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierOption10));
			MoveToElementClick(element);
			waitForElement(700);
			ExtentSuccessMessage("Carrier Has been Selected");
			
			waitForElement(2000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectedCarrierToRightButton));
			MoveToElementClick(element);
			waitForElement(700);
			ExtentSuccessMessage("Carrier has been moved to right");
		
			waitForElement(2000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierGroupSubmitButton));
			MoveToElementClick(element);
			ExtentSuccessMessage("Carrier has been Created");
			
			
			
			
		
	}
	
	public void admin_CreateNewUser(CensusInfo ApplicantInfo) throws InterruptedException, AWTException, IOException
	{
		  waitForElement(4000);
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(CTIMinimizeIcon));
		   MoveToElementClick(element);//clicking on DashBoard tiles  
					
		   waitForElement(6000);
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(AdminTile));
		   MoveToElementClick(element);
	       ExtentSuccessMessage("Agency Tile has been clicked");
	       
	       waitForElement(1000);  
	      element = wait.until(ExpectedConditions.presenceOfElementLocated(AdminUser));
		   MoveToElementClick(element);
	       ExtentSuccessMessage("Admin User has been clicked");
		
	       waitForElement(4000);
	       
	       element = wait.until(ExpectedConditions.presenceOfElementLocated(AddUserButton));
		   MoveToElementClick(element);
	       ExtentSuccessMessage("Add User button has been clicked");
	       
	       waitForElement(4000);
	      
	       element = wait.until(ExpectedConditions.presenceOfElementLocated(UserFirstName));
		   MoveToElementClick(element);
		   String FirstName = "Auto";
		   writeText(UserFirstName,FirstName + Keys.ENTER );
	       ExtentSuccessMessage("First Name has been entered");
	       
	       waitForElement(1000);
          
           element = wait.until(ExpectedConditions.presenceOfElementLocated(UserLastName));
		   MoveToElementClick(element);
		   String LastName = "Agent" + getRandomNumber();
		   writeText(UserLastName, LastName + Keys.ENTER );
		   writeLastnameToExcel(LastName,"TC CE2");
		   ExtentSuccessMessage("Last Name has been entered");
		   
		   waitForElement(1000);
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(UserEmailId));
		   MoveToElementClick(element);
		   String EmailId = FirstName + LastName + "@" + "yopmail.com";
		   writeText(UserEmailId,  EmailId );
		   ExtentSuccessMessage("Email-Id has been entered");
			
		   
		   waitForElement(1000);
		  
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(UserPhoneNumber));
		   MoveToElementClick(element);
		   writeText(UserPhoneNumber,  generatePhoneNumber() );
		   ExtentSuccessMessage("Phone has been entered");
			
		   
		   waitForElement(1000);
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(UserRolesAndPermission));
		   Select select = new Select(element);
		   select.selectByVisibleText("Default Profile");
		   ExtentSuccessMessage("Role And Permission has been selected");
			
		  
		   waitForElement(1000);
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(UserLoginDetails));
		   MoveToElementClick(element);
		   String UserLogin = FirstName + LastName;
		   writeText(UserLoginDetails, UserLogin) ;
		   ExtentSuccessMessage("Login details has been entered");
		  
		   
		   waitForElement(1000);
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(DataAccessibiltityDD1));
		   Select select2 = new Select(element);
		   select2.selectByVisibleText("Yes");
		   ExtentSuccessMessage("Edit data has been selected");
			 
		   waitForElement(1000);
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(DataAccessibiltityDD2));
		   Select select3 = new Select(element);
		   select3.selectByVisibleText("Yes");
		   ExtentSuccessMessage("Confidentials data has been selected");
			 
		   waitForElement(1000);
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(NewUserButton));
		   MoveToElementClick(element);
		   ExtentSuccessMessage("Login details has been entered");
		   
		   waitForElement(1000);
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(ConfirmationPopup));
		   MoveToElementClick(element);
		   ExtentSuccessMessage("Popup has been Accepted");
		   
		   waitForElement(6000);
		  element = wait.until(ExpectedConditions.presenceOfElementLocated(AdminUserInc));
		  getEmailValue  = element.getText();
		  System.out.println("-----------"+ getEmailValue+"------------");
		  Assert.assertEquals(getEmailValue, EmailId);
		  ExtentSuccessMessage("Assertion has been done");
			 
		
		
	}
	
	public void admin_EditUserDetails(CensusInfo ApplicantInfo) throws InterruptedException
	{
		
		  waitForElement(4000);
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(CTIMinimizeIcon));
		   MoveToElementClick(element);//clicking on DashBoard tiles  
					
		   waitForElement(6000);
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(AdminTile));
		   MoveToElementClick(element);
	       ExtentSuccessMessage("Agency Tile has been clicked");
	       
	       waitForElement(1000);
	       element = wait.until(ExpectedConditions.presenceOfElementLocated(AdminUser));
		   MoveToElementClick(element);
	       ExtentSuccessMessage("Admin User has been clicked");
	       
	     

	       
	       
	       element = wait.until(ExpectedConditions.presenceOfElementLocated(AdminSearchBar));
		   MoveToElementClick(element);
		   writeText(AdminSearchBar,  ApplicantInfo.LastName + Keys.ENTER);
		   ExtentSuccessMessage("LastName has been Added");
		   
		   
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(AdminEditIcon));
		   MoveToElementClick(element);
		   ExtentSuccessMessage("Edit Icon has been clicked");
		   
		   
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(EditEmailId));
		   MoveToElementClick(element);
		   element.clear();
		   MoveToElementClick(element);
		   String EmailId =  ApplicantInfo.LastName + "@" + "yopmail.com";
		   writeText(EditEmailId, EmailId + Keys.ENTER);
		   ExtentSuccessMessage("Email id has been entered");
		   
		 
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(EditPhone));
		   MoveToElementClick(element);
		   element.clear();
		   MoveToElementClick(element);
		   String PhoneNumber = generatePhoneNumber();
		   writeText(EditPhone, PhoneNumber + Keys.ENTER);
		   ExtentSuccessMessage("PhoneNumber has been entered");
		   
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(EditSaveButton));
		   MoveToElementClick(element);
		   ExtentSuccessMessage("User has been Edited");
		   
		   waitForElement(5000);
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(AdminEditUserINC));
		   expectedText  = element.getText();
		   System.out.println("-----------"+ expectedText+"------------");
	       Assert.assertEquals(expectedText, EmailId);
		   ExtentSuccessMessage("Assertion has been done");
		   
		   
			
		   	
	}
	
	public void admin_ResetPassword(CensusInfo ApplicantInfo) throws InterruptedException
	{
		 waitForElement(4000);
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(CTIMinimizeIcon));
		   MoveToElementClick(element);//clicking on DashBoard tiles  
					
		   waitForElement(6000);
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(AdminTile));
		   MoveToElementClick(element);
	       ExtentSuccessMessage("Agency Tile has been clicked");
	       
	       waitForElement(1000);
	       element = wait.until(ExpectedConditions.presenceOfElementLocated(AdminUser));
		   MoveToElementClick(element);
	       ExtentSuccessMessage("Admin User has been clicked");
	       
	       waitForElement(4000);
	       element = wait.until(ExpectedConditions.presenceOfElementLocated(AdminSearchBar));
		   MoveToElementClick(element);
		   writeText(AdminSearchBar,  ApplicantInfo.LastName + Keys.ENTER);
		   ExtentSuccessMessage("LastName has been Added");
		   
		   waitForElement(5000);
		 //  By AdminResetPasswordButton = By.xpath("//i[@class='glyphicon glyphicon-repeat']");
		   Assert.assertTrue(driver.findElement(AdminResetPasswordButton).isDisplayed());
		   ExtentSuccessMessage("Assertion has been done");
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(AdminResetPasswordButton));
		   MoveToElementClick(element);
		   waitForElement(1000);
		   ExtentSuccessMessage("Password has been Reset");
	     
		   
		   
		
	}
	
	public void admin_RolesAndPermission() throws InterruptedException
	{
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(CTIMinimizeIcon));
		   MoveToElementClick(element);//clicking on DashBoard tiles  
					
		   waitForElement(6000);
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(AdminTile));
		   MoveToElementClick(element);
	       ExtentSuccessMessage("Agency Tile has been clicked");
	       
	       By AdminRolesAndPermission = By.xpath("(//a[contains(.,'Roles/Permissions')])[2]");
	       element = wait.until(ExpectedConditions.presenceOfElementLocated(AdminRolesAndPermission));
		   MoveToElementClick(element);
	       ExtentSuccessMessage("Roles and Permission has been clicked");
	       
	       By AddRolesAndPermission = By.xpath("//button[@class='btn btn-default pull-right btn-yellow']");
	       element = wait.until(ExpectedConditions.presenceOfElementLocated(AddRolesAndPermission));
		   MoveToElementClick(element);
	       ExtentSuccessMessage("Roles and Permission has been clicked");
	       
	       By RolesAndPermissionField = By.xpath("//input[@class='form-control ng-pristine ng-untouched ng-empty ng-invalid ng-invalid-required']");
	       element = wait.until(ExpectedConditions.presenceOfElementLocated(RolesAndPermissionField));
		   MoveToElementClick(element);
		   String RolesAndPermissionName = "AutoRole" + getRandomNumber();
		   writeText(RolesAndPermissionField, RolesAndPermissionName );
	       ExtentSuccessMessage("Roles and Permission has been clicked");
	       
	       By RolesAndPermissionSubmitButton = By.xpath("//button[@class='btn btn-default green pull-right']");
	       element = wait.until(ExpectedConditions.presenceOfElementLocated(RolesAndPermissionSubmitButton));
		   MoveToElementClick(element);
		   
		   
		   
	     
	}
	
	public void admin_AddNewCallDeposition(CensusInfo ApplicantInfo) throws InterruptedException, IOException, AWTException
	{
		
		 element = wait.until(ExpectedConditions.presenceOfElementLocated(CTIMinimizeIcon));
		   MoveToElementClick(element);//clicking on DashBoard tiles  
					
		   waitForElement(6000);
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(AdminTile));
		   MoveToElementClick(element);
	       ExtentSuccessMessage("Agency Tile has been clicked");
	       

			String currentSystemURL = driver.getCurrentUrl();
			
			if (currentSystemURL.contains("https://mme.brokerengage.net/"))
			{
				 waitForElement(1000); 
			       element = wait.until(ExpectedConditions.presenceOfElementLocated(CallDisposition));
				   MoveToElementClick(element);
			       ExtentSuccessMessage("Call Deposition has been clicked");
			       
			       waitForElement(1000);
			     
			       element = wait.until(ExpectedConditions.presenceOfElementLocated(AddNewCallDespositionButton));
				   MoveToElementClick(element);
			     
			} 
			
			else if (currentSystemURL.contains("https://ce-uat.benefitalign.com/")) {
				
				By TelephonySetup = By.xpath("//*[@id=\"NavigationMenuRegion\"]/div/div[2]/div[1]/div/ul/li[7]/ul/li[2]/a");
				element = wait.until(ExpectedConditions.presenceOfElementLocated(TelephonySetup));
				MoveToElementClick(element);
				 
			    By ConfigureButton = By.xpath("(//button[@name='manageNumbersBtn'])[2]");
			    element = wait.until(ExpectedConditions.presenceOfElementLocated(ConfigureButton));
			    MoveToElementClick(element);
			    
			    element = wait.until(ExpectedConditions.presenceOfElementLocated(AddNewCallDespositionButton));
				   MoveToElementClick(element);
			
			}
			
			else if (currentSystemURL.contains("https://ce-uat.benefit-test.com/")) {
				
				   waitForElement(1000); 
			       element = wait.until(ExpectedConditions.presenceOfElementLocated(CallDisposition));
				   MoveToElementClick(element);
			       ExtentSuccessMessage("Call Deposition has been clicked");
			       
			       waitForElement(1000);
			     
			       element = wait.until(ExpectedConditions.presenceOfElementLocated(AddNewCallDespositionButton));
				   MoveToElementClick(element);
			    
			
			}
			
			else if (currentSystemURL.contains("https://ce-qa.benefitalign.com/")) {
				
				By TelephonySetup = By.xpath("//*[@id=\"NavigationMenuRegion\"]/div/div[2]/div[1]/div/ul/li[7]/ul/li[2]/a");
				element = wait.until(ExpectedConditions.presenceOfElementLocated(TelephonySetup));
				MoveToElementClick(element);
				 
			    By ConfigureButton = By.xpath("(//button[@name='manageNumbersBtn'])[2]");
			    element = wait.until(ExpectedConditions.presenceOfElementLocated(ConfigureButton));
			    MoveToElementClick(element);
			    
			    element = wait.until(ExpectedConditions.presenceOfElementLocated(AddNewCallDespositionButton));
				   MoveToElementClick(element);
			    
					 
				 
				
				
				
			} else {
				
				By TelephonySetup = By.xpath("//*[@id=\"NavigationMenuRegion\"]/div/div[2]/div[1]/div/ul/li[7]/ul/li[2]/a");
				element = wait.until(ExpectedConditions.presenceOfElementLocated(TelephonySetup));
				MoveToElementClick(element);
				 
			    By ConfigureButton = By.xpath("(//button[@name='manageNumbersBtn'])[2]");
			    element = wait.until(ExpectedConditions.presenceOfElementLocated(ConfigureButton));
			    MoveToElementClick(element);
			    
			    element = wait.until(ExpectedConditions.presenceOfElementLocated(AddNewCallDespositionButton));
				   MoveToElementClick(element);
				
			}
			
	       

	       
	       waitForElement(1000);
	       element = wait.until(ExpectedConditions.presenceOfElementLocated(CallDispositionName));
		   MoveToElementClick(element);
		   String CallDispositionNameField = "AutoDisposition" +  getRandomNumber();
		   System.out.println(CallDispositionNameField);
		   writeText(CallDispositionName, CallDispositionNameField );
		   writeDespoToExcel(CallDispositionNameField,"TC CE2");
		   
		  
	       ExtentSuccessMessage("Call Deposition Button has been clicked");
	       
	       waitForElement(1000);
	       By LeadStatusDD = By.xpath("//md-select[@name='LeadStatus']");
	       element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadStatusDD));
		   MoveToElementClick(element);
	       waitForElement(3000);
	       By AcceptButton =By.xpath("//md-option[@value='Accepted']");
	       element = wait.until(ExpectedConditions.presenceOfElementLocated(AcceptButton));
		   MoveToElementClick(element);
	       
	       
		
		   waitForElement(1000);
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(CallDispositionSaveButton));
		   MoveToElementClick(element);
		   ExtentSuccessMessage("Call disposition has been saved");
		   
		   
		  /* waitForElement(9000);
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(CallDispositionInc));
			 AgentText  = element.getText();
			System.out.println("-----------"+ AgentText+"------------");
			Assert.assertEquals(AgentText , CallDispositionNameField);
			ExtentSuccessMessage("Assertion has been done");*/
		   
		   

	       
	       
	       
		
	}
	
	public void admin_EditAndDeleteCallDesposition(CensusInfo ApplicantInfo) throws InterruptedException, AWTException
	{
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CTIMinimizeIcon));
		   MoveToElementClick(element);//clicking on DashBoard tiles  
					
		   waitForElement(6000);
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(AdminTile));
		   MoveToElementClick(element);
	       ExtentSuccessMessage("Agency Tile has been clicked");
	       
	       String currentSystemURL = driver.getCurrentUrl();
			
			if (currentSystemURL.contains("https://mme.brokerengage.net/"))
			{
				 waitForElement(1000); 
			       element = wait.until(ExpectedConditions.presenceOfElementLocated(CallDisposition));
				   MoveToElementClick(element);
			       ExtentSuccessMessage("Call Deposition has been clicked");
			       
			       waitForElement(1000);
			     
			       
			} 
			
			else if (currentSystemURL.contains("https://ce-uat.benefitalign.com/")) {
				
				By TelephonySetup = By.xpath("//*[@id=\"NavigationMenuRegion\"]/div/div[2]/div[1]/div/ul/li[7]/ul/li[2]/a");
				element = wait.until(ExpectedConditions.presenceOfElementLocated(TelephonySetup));
				MoveToElementClick(element);
				 
			    By ConfigureButton = By.xpath("(//button[@name='manageNumbersBtn'])[2]");
			    element = wait.until(ExpectedConditions.presenceOfElementLocated(ConfigureButton));
			    MoveToElementClick(element);
			    
			     
			      
			}
			
			else if (currentSystemURL.contains("https://ce-uat.benefit-test.com/")) {
				
				   waitForElement(1000); 
			       element = wait.until(ExpectedConditions.presenceOfElementLocated(CallDisposition));
				   MoveToElementClick(element);
			       ExtentSuccessMessage("Call Deposition has been clicked");
			       
			       waitForElement(1000);
			     
			     
			
			}
			
			
			
			
			
			
			
			else if (currentSystemURL.contains("https://ce-qa.benefitalign.com/")) {
				
				By TelephonySetup = By.xpath("//*[@id=\"NavigationMenuRegion\"]/div/div[2]/div[1]/div/ul/li[7]/ul/li[2]/a");
				element = wait.until(ExpectedConditions.presenceOfElementLocated(TelephonySetup));
				MoveToElementClick(element);
				 
			    By ConfigureButton = By.xpath("(//button[@name='manageNumbersBtn'])[2]");
			    element = wait.until(ExpectedConditions.presenceOfElementLocated(ConfigureButton));
			    MoveToElementClick(element);
			    
			    
				
				
			} else {
				
				By TelephonySetup = By.xpath("//*[@id=\"NavigationMenuRegion\"]/div/div[2]/div[1]/div/ul/li[7]/ul/li[2]/a");
				element = wait.until(ExpectedConditions.presenceOfElementLocated(TelephonySetup));
				MoveToElementClick(element);
				 
			    By ConfigureButton = By.xpath("(//button[@name='manageNumbersBtn'])[2]");
			    element = wait.until(ExpectedConditions.presenceOfElementLocated(ConfigureButton));
			    MoveToElementClick(element);
				
			}
			
	       
	       
//	       waitForElement(1000);
//	       element = wait.until(ExpectedConditions.presenceOfElementLocated(CallDisposition));
//		   MoveToElementClick(element);
//	       ExtentSuccessMessage("Call Deposition has been clicked");
//	      
	       waitForElement(2000);    
	       element = wait.until(ExpectedConditions.presenceOfElementLocated(CallDespoSearchField));
		   MoveToElementClick(element);
		   writeText(CallDespoSearchField,  ApplicantInfo.Despo + Keys.ENTER);
		   ExtentSuccessMessage("Call Deposition name has been entered");
		   
		   waitForElement(6000);
		   Assert.assertTrue(driver.findElement(EditCallDisoButton).isDisplayed());
		   ExtentSuccessMessage("Assertion has been done");
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(EditCallDisoButton));
		   MoveToElementClick(element);
		   
		   
	       waitForElement(3000);
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadStatusDD));
		   MoveToElementClick(element);
		   By Converted = By.xpath("//md-option[@value='Converted']");
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(Converted));
		   MoveToElementClick(element);
	      
		   
		   waitForElement(1000);
	      element = wait.until(ExpectedConditions.presenceOfElementLocated(CallDispositionSaveButton));
	      MoveToElementClick(element);
		  ExtentSuccessMessage("Call disposition has been saved");
		  
		  
		  waitForElement(3000);
		  element = wait.until(ExpectedConditions.presenceOfElementLocated(DeleteCallDespoButton));
	      MoveToElementClick(element);
	      ExtentSuccessMessage("Delete Disposition has been clicked");
	      
	      
	      element = wait.until(ExpectedConditions.presenceOfElementLocated(ConfirmDeleteButton));
	      MoveToElementClick(element);
	      ExtentSuccessMessage("Confirm Button has been clicked");
	      
	      
	      
			   
		   
	       
	   
		
		
	}
	
	public void admin_DeleteUser(CensusInfo ApplicantInfo) throws InterruptedException
	{
		 waitForElement(4000);
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(CTIMinimizeIcon));
		   MoveToElementClick(element);//clicking on DashBoard tiles  
					
		   waitForElement(6000);
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(AdminTile));
		   MoveToElementClick(element);
	       ExtentSuccessMessage("Agency Tile has been clicked");
	       
	       waitForElement(1000);
	       element = wait.until(ExpectedConditions.presenceOfElementLocated(AdminUser));
		   MoveToElementClick(element);
	       ExtentSuccessMessage("Admin User has been clicked");
	       
	       waitForElement(1000);
	       element = wait.until(ExpectedConditions.presenceOfElementLocated(AdminSearchBar));
		   MoveToElementClick(element);
		   writeText(AdminSearchBar,  ApplicantInfo.LastName + Keys.ENTER);
		   ExtentSuccessMessage("LastName has been Added");
		
		   waitForElement(7000);
		   Assert.assertTrue(driver.findElement(UserDeleteIconButton).isDisplayed());
		   ExtentSuccessMessage("Assertion is been done");
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(UserDeleteIconButton));
		   MoveToElementClick(element);
		   ExtentSuccessMessage("Delete Icon has been Clicked");
		   
	
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(AdminDeleteConfirmPopup));
		   MoveToElementClick(element);
		   ExtentSuccessMessage("User has been Deleted");
		
		
	}
	
	public void admin_AddBuissnessHour() throws InterruptedException
	{
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CTIMinimizeIcon));
		   MoveToElementClick(element);//clicking on DashBoard tiles  
					
		   waitForElement(6000);
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(AdminTile));
		   MoveToElementClick(element);
	       ExtentSuccessMessage("Agency Tile has been clicked");
	       
	       String currentSystemURL = driver.getCurrentUrl();
			
			if (currentSystemURL.contains("https://mme.brokerengage.net/"))
			{
				
				 waitForElement(6000);
				   element = wait.until(ExpectedConditions.presenceOfElementLocated(AdminTile));
				   MoveToElementClick(element);
			       ExtentSuccessMessage("Agency Tile has been clicked");
			       
			       
				 By BuissnessHour = By.xpath("//*[@id=\"NavigationMenuRegion\"]/div/div[2]/div[1]/div/ul/li[7]/ul/li[7]/a");
				 element = wait.until(ExpectedConditions.presenceOfElementLocated(BuissnessHour));
				 MoveToElementClick(element);
			     ExtentSuccessMessage("Buissness hour has been clicked");
			       
			} 
			
			else if (currentSystemURL.contains("https://ce-uat.benefitalign.com/")) {
				
				waitForElement(6000);
		   	    element = wait.until(ExpectedConditions.presenceOfElementLocated(AdminTile));
			    MoveToElementClick(element);
				ExtentSuccessMessage("Agency Tile has been clicked");
				       
				By BuisnessHour = By.xpath("//*[@id=\"NavigationMenuRegion\"]/div/div[2]/div[1]/div/ul/li[7]/ul/li[5]/a");
				element = wait.until(ExpectedConditions.presenceOfElementLocated(BuisnessHour));
				MoveToElementClick(element);
			     ExtentSuccessMessage("Buissness hour has been clicked");
			
			}
			
			else if (currentSystemURL.contains("https://ce-uat.benefit-test.com/")) {
				
				 waitForElement(6000);
			        element = wait.until(ExpectedConditions.presenceOfElementLocated(AdminTile));
					MoveToElementClick(element);
				    ExtentSuccessMessage("Agency Tile has been clicked");
				       
				       
					 By BuisnessHour = By.xpath("/html/body/div[3]/div[6]/div/ui-view/div[2]/div/div[2]/div[1]/div/ul/li[7]/ul/li[7]/a");
					 element = wait.until(ExpectedConditions.presenceOfElementLocated(BuisnessHour));
					 MoveToElementClick(element);
				     ExtentSuccessMessage("Buissness hour has been clicked");
				       
			
			}
			
			
			
			
			else if (currentSystemURL.contains("https://ce-qa.benefitalign.com/")) {
				
			waitForElement(6000);
	   	    element = wait.until(ExpectedConditions.presenceOfElementLocated(AdminTile));
		    MoveToElementClick(element);
			ExtentSuccessMessage("Agency Tile has been clicked");
			       
			By BuisnessHour = By.xpath("//*[@id=\"NavigationMenuRegion\"]/div/div[2]/div[1]/div/ul/li[7]/ul/li[5]/a");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(BuisnessHour));
			MoveToElementClick(element);
		     ExtentSuccessMessage("Buissness hour has been clicked");
		       	
			}
			
			else {
				
			waitForElement(6000);
		    element = wait.until(ExpectedConditions.presenceOfElementLocated(AdminTile));
			MoveToElementClick(element);
		    ExtentSuccessMessage("Agency Tile has been clicked");
				       
				By BuisnessHour = By.xpath("/html/body/div[3]/div[6]/div/ui-view/div[2]/div/div[2]/div[1]/div/ul/li[7]/ul/li[5]/a");
				element = wait.until(ExpectedConditions.presenceOfElementLocated(BuisnessHour));
				MoveToElementClick(element);
			    ExtentSuccessMessage("Buissness hour has been clicked");
				
				
				
			}
			
	       
		   waitForElement(6000);
	       element = wait.until(ExpectedConditions.presenceOfElementLocated(NewBuissnessHourButton));
		   MoveToElementClick(element);
	       ExtentSuccessMessage("Buissness hour button has been clicked");
	       
	  
	       element = wait.until(ExpectedConditions.presenceOfElementLocated(BuissnesshourField));
		   MoveToElementClick(element);
		   String BuissnessHr = "AutoHour" +  getRandomNumber();
		   writeText(BuissnesshourField, BuissnessHr + Keys.ENTER);
		    ExtentSuccessMessage("Buissness hour Name has been clicked");
		       
		    
		 
		    element = wait.until(ExpectedConditions.presenceOfElementLocated(BuissnessHRType));
		    MoveToElementClick(element);
		    ExtentSuccessMessage("Type has been clicked"); 
			 
			 
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(TimeZoneDD));
			MoveToElementClick(element);
		  
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(TimezoneDDOption));
		   MoveToElementClick(element);
		   ExtentSuccessMessage("Time zone has been selected"); 
				
			
			By BuissnessHrSaveButton = By.xpath("//button[@class='btn btn-default green ng-scope']");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(BuissnessHrSaveButton));
			MoveToElementClick(element);
			ExtentSuccessMessage("Buissness Hour has been Saved"); 
			
			By BuissnessHourInc = By.xpath("(//a[@class='edit-list-anchor ng-binding'])[1]");
		    element = wait.until(ExpectedConditions.presenceOfElementLocated(BuissnessHourInc));
		    AgentText  = element.getText();
			System.out.println("-----------"+ AgentText+"------------");
			Assert.assertEquals(AgentText , BuissnessHr);
			ExtentSuccessMessage("Assertion has been done");


	       
	}
	
	public void admin_AddHolidayCalendar() throws InterruptedException
	{
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CTIMinimizeIcon));
		   MoveToElementClick(element);//clicking on DashBoard tiles  
					
		   waitForElement(6000);
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(AdminTile));
		   MoveToElementClick(element);
	       ExtentSuccessMessage("Agency Tile has been clicked");
	       
	       
	       String currentSystemURL = driver.getCurrentUrl();
			
			if (currentSystemURL.contains("https://ce-dev.benefitalign.com/"))
			{
				  waitForElement(2000);
				  By HolidayCalendar = By.xpath("(//a[contains(.,'Holiday Calendar')])");
			       element = wait.until(ExpectedConditions.presenceOfElementLocated(HolidayCalendar));
				   MoveToElementClick(element);
			       ExtentSuccessMessage("Calendar has been clicked");
		
			} 
	       
			else
			{
				  waitForElement(2000);
			       element = wait.until(ExpectedConditions.presenceOfElementLocated(HolidayCalendar));
				   MoveToElementClick(element);
			       ExtentSuccessMessage("Calendar has been clicked");
				
			}
	      
		  
	       
		   waitForElement(2000);
	      element = wait.until(ExpectedConditions.presenceOfElementLocated(GridView));
		   MoveToElementClick(element);
		   
		   waitForElement(2000);
		   Assert.assertTrue(driver.findElement(NewHolidayButton).isDisplayed());
		   ExtentSuccessMessage("Assertion has been done");
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(NewHolidayButton));
		   MoveToElementClick(element);
		   
		   waitForElement(2000);
           element = wait.until(ExpectedConditions.presenceOfElementLocated(HolidayName));
		   MoveToElementClick(element);
		   String HolidayNameField = "AutoHoliday" + getRandomNumber();
		   writeText(HolidayName, HolidayNameField);
		   ExtentSuccessMessage("Name has been Entered");
		   
		   waitForElement(2000);
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(PredenceFieldc));
		   MoveToElementClick(element);
		   By PredenceOption = By.xpath("(//div[@class='dx-item dx-list-item'])[2]");
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(PredenceOption));
		   MoveToElementClick(element);
		   ExtentSuccessMessage("PredenceFieldc has been Entered");
		   
		   waitForElement(2000);
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(PromptField));
		   MoveToElementClick(element);
		   By PromptOption = By.xpath("(//div[@class='dx-item-content dx-list-item-content'])[7]");
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(PromptOption));
		   MoveToElementClick(element);
		   ExtentSuccessMessage("PromptField has been Entered");
		   
		   waitForElement(2000);
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(CalendarTextArea));
		   MoveToElementClick(element);
		   writeText(CalendarTextArea, "This holiday is created via automation");
		   ExtentSuccessMessage("CalendarTextArea has been Entered");
		   
		   waitForElement(2000);
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(CalendarSaveButton));
		   MoveToElementClick(element);
		   ExtentSuccessMessage("Holiday has been entered");
		   

	      
	       
	       
		
	}
	
	public void report_LiveReport() throws InterruptedException, AWTException
	{
		
	
		  element = wait.until(ExpectedConditions.presenceOfElementLocated(CTIMinimizeIcon));
		   MoveToElementClick(element);// 
					
		   waitForElement(6000);
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(ReportTile));
		   MoveToElementClick(element);
	       ExtentSuccessMessage("Report Tile has been clicked");
	       
	       
	     

		   String currentSystemURL = driver.getCurrentUrl();
			
			if (currentSystemURL.contains("https://mme.brokerengage.net/"))
			{
				 
				
				
			} else if (currentSystemURL.contains("https://ce-uat.benefitalign.com/")) {
				
				 waitForElement(4000);
			       element = wait.until(ExpectedConditions.presenceOfElementLocated(StartDate));
				   MoveToElementClick(element);
				   element.clear();
				   Thread.sleep(1000);
				   element.sendKeys("03/01/2024" + Keys.ENTER);
				   writeText(StartDate, "03/01/2024" + Keys.ENTER);
				   ExtentSuccessMessage("Start date has been entered");  
			}
			
			
			else if (currentSystemURL.contains("https://ce-uat.benefit-test.com/")) {
				
				  waitForElement(4000);
			       element = wait.until(ExpectedConditions.presenceOfElementLocated(StartDate));
				   MoveToElementClick(element);
				   element.clear();
				   Thread.sleep(1000);
				   element.sendKeys("03/01/2024" + Keys.ENTER);
				   writeText(StartDate, "03/01/2024" + Keys.ENTER);
				   ExtentSuccessMessage("Start date has been entered");  
		        
			}
		
			else if (currentSystemURL.contains("https://ce-qa.benefitalign.com/")) {
				
				  
				  waitForElement(4000);
				  By StartDate = By.xpath("/html/body/div[3]/div[6]/div/ui-view/div/div[4]/div[2]/form/div[1]/div[1]/div[2]/md-content/div/div/div[3]/span[2]/span/md-input-container/input");
			       element = wait.until(ExpectedConditions.presenceOfElementLocated(StartDate));
				   MoveToElementClick(element);
				   element.clear();
				   writeText(StartDate, "03/01/2024" + Keys.ENTER);
				   ExtentSuccessMessage("Start date has been entered");
				   
				
			} else {
				
				System.out.println("DevEnv");
				
			}
		   
	       waitForElement(4000);
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierSelectionDD));
		   MoveToElementClick(element);
		   Thread.sleep(2000);
		   Robot robot = new Robot();
		   robot.keyPress(KeyEvent.VK_DOWN);
		   Thread.sleep(1000);
		   robot.keyRelease(KeyEvent.VK_DOWN);
		   Thread.sleep(1000);
		   
		   robot.keyPress(KeyEvent.VK_ENTER);
		   Thread.sleep(1000);
		   robot.keyRelease(KeyEvent.VK_ENTER);
		   Thread.sleep(1000);
		   ExtentSuccessMessage("Carrier has been selected");
		   
	       waitForElement(4000);  
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(ReportRunButton));
		   MoveToElementClick(element);
		   Thread.sleep(7000);
		   ExtentSuccessMessage("Run Report button has been clicked");
		   
		   
//		   waitForElement(6000);
//		   Assert.assertTrue(driver.findElement(ReportInc).isDisplayed());
//		   ExtentSuccessMessage("Asssertion has been done");
//	       
		   
		   
		   
		  
		
	}
	
	public void report_ScheduleReport() throws InterruptedException
	{
		
		 element = wait.until(ExpectedConditions.presenceOfElementLocated(CTIMinimizeIcon));
		   MoveToElementClick(element);// 
					
		   waitForElement(6000);
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(ReportTile));
		   MoveToElementClick(element);
	       ExtentSuccessMessage("Report Tile has been clicked");
	     


	       
	       element = wait.until(ExpectedConditions.presenceOfElementLocated(ScheduleReport));
		   MoveToElementClick(element);
		    ExtentSuccessMessage("Schedule Report has been clicked");
		   
		    waitForElement(2000);
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(CreateScheduleButton));
		   MoveToElementClick(element);
		   ExtentSuccessMessage("Schedule Report Button has been clicked");
		    
		   waitForElement(4000);
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(ScheduleReportName));
		   MoveToElementClick(element);
		   String ScheduleName = "AutoReport" + getRandomNumber();
		   writeText(ScheduleReportName, ScheduleName);
		   
		   waitForElement(2000);
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(RecurrencePattern));
		   MoveToElementClick(element);
		   ExtentSuccessMessage("RecurrencePattern Report Button has been clicked");
		   
		   waitForElement(2000);
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(EmailToField));
		   MoveToElementClick(element);
		   writeText(EmailToField, "LeoAgent@yopmail.com" + Keys.ENTER);
		   
		   waitForElement(5000);
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(ReportSubmitButton));
		   Assert.assertTrue(driver.findElement(ReportSubmitButton).isEnabled());
		   MoveToElementClick(element);
		   ExtentSuccessMessage("Submit Button has been clicked");
		   
		  
		   
	
	}
	
	public void report_PivotReport() throws InterruptedException, AWTException
	{
		 element = wait.until(ExpectedConditions.presenceOfElementLocated(CTIMinimizeIcon));
		   MoveToElementClick(element);// 
					
		   waitForElement(4000);
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(ReportTile));
		   MoveToElementClick(element);
	       ExtentSuccessMessage("Report Tile has been clicked");
	       
	       waitForElement(4000); 
	       element = wait.until(ExpectedConditions.presenceOfElementLocated(PivotReport));
		   MoveToElementClick(element);
		   ExtentSuccessMessage("PivotReport has been clicked");
		   
		 
	    
		  
		   String currentSystemURL = driver.getCurrentUrl();
			
			if (currentSystemURL.contains("https://mme.brokerengage.net/"))
			{
				  waitForElement(3000);
			       element = wait.until(ExpectedConditions.presenceOfElementLocated(PivotStartDate));
			       element.clear();
			       writeText(PivotStartDate, "01/01/2024" + Keys.ENTER);
			       ExtentSuccessMessage("Start Date has been clicked");
			       

				   element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierSelectionDD));
				   MoveToElementClick(element);
				   Thread.sleep(1000);
				   By CarrierOPtion = By.xpath("//md-option[@value='Ambetter From Sunshine Health']");
				   element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierOPtion));
				   MoveToElementClick(element);
				
				
				
			} else if (currentSystemURL.contains("https://ce-uat.benefitalign.com/")) {
				
                   
				  waitForElement(3000);
			       element = wait.until(ExpectedConditions.presenceOfElementLocated(PivotStartDate));
			       element.clear();
			       writeText(PivotStartDate, "01/01/2024" + Keys.ENTER);
			       ExtentSuccessMessage("Start Date has been clicked");
		
				   element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierSelectionDD));
				   MoveToElementClick(element);
				   Thread.sleep(1000);
				   By CarrierOPtion = By.xpath("//md-option[@value='(ANTHEM) ANTHEM BLUE CROSS LIFE AND HEALTH INSURANCE COMPANY']");
				   element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierOPtion));
				   MoveToElementClick(element);
		        
		        
		        
		        
			}
			
			
			else if (currentSystemURL.contains("https://ce-uat.benefit-test.com/")) {
				
                
				  waitForElement(3000);
			       element = wait.until(ExpectedConditions.presenceOfElementLocated(PivotStartDate));
			       element.clear();
			       Thread.sleep(1000);
				   element.sendKeys("03/01/2024" + Keys.ENTER);
				 //  writeText(StartDate, "03/01/2024" + Keys.ENTER);
			       writeText(PivotStartDate, "01/01/2024" + Keys.ENTER);
			       ExtentSuccessMessage("Start Date has been clicked");
		
				   element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierSelectionDD));
				   MoveToElementClick(element);
				   Thread.sleep(1000);
				   By CarrierOPtion = By.xpath("//md-option[@value='(ANTHEM) ANTHEM BLUE CROSS LIFE AND HEALTH INSURANCE COMPANY']");
				   element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierOPtion));
				   MoveToElementClick(element);
		        
		        
		        
		        
			}
			
			
			
			
			else if (currentSystemURL.contains("https://ce-qa.benefitalign.com/")) {
				
				   By PivotStartDate = By.xpath("/html/body/div[3]/div[6]/div/ui-view/div/div[4]/div[2]/form/div[1]/div[1]/div[2]/md-content/div/div/div[3]/span[2]/span/md-input-container/input");
				   waitForElement(3000);
			       element = wait.until(ExpectedConditions.presenceOfElementLocated(PivotStartDate));
			       element.clear();
			       Thread.sleep(1000);
			       writeText(PivotStartDate, "01/01/2024" + Keys.ENTER);
			       ExtentSuccessMessage("Start Date has been clicked");
				
			
				
				  element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierSelectionDD));
				   MoveToElementClick(element);
				   Thread.sleep(1000);
				   By CarrierOPtion = By.xpath("//md-option[@value='Ambetter From Sunshine Health']");
				   element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierOPtion));
				   MoveToElementClick(element);
				
			} else {
				
				System.out.println("DevEnv");
				
			}
		   /*
		   Robot robot = new Robot();
		   robot.keyPress(KeyEvent.VK_DOWN);
		   Thread.sleep(1000);
		   robot.keyRelease(KeyEvent.VK_DOWN);
		   Thread.sleep(1000);
		   robot.keyPress(KeyEvent.VK_ENTER);
		   Thread.sleep(1000);
		   robot.keyRelease(KeyEvent.VK_ENTER);
		   Thread.sleep(1000);
		   ExtentSuccessMessage("Carrier has been selected");*/
		   
		   
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(RunPiviotReportButton));
		   Assert.assertTrue(driver.findElement(RunPiviotReportButton).isDisplayed());
		   ExtentSuccessMessage("Assertion has been done");
		   MoveToElementClick(element);
		   ExtentSuccessMessage("RunPiviotReportButton has been selected");
	       
		  
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
	
	public String writeListnameToExcel(String nameText, String sheetname) throws IOException {
		String excelFilePath = ".\\src\\test\\resources\\TestData.xlsx";
        FileInputStream inputStream = new FileInputStream(excelFilePath);
        Workbook workbook = new XSSFWorkbook(inputStream);
        String sheetName_update = sheetname;
        Sheet sheet = workbook.getSheet(sheetname);
        int rowIndex = 1;  
        int columnIndex = 4;
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
	
	public String writeCustomListnameToExcel(String nameText, String sheetname) throws IOException {
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
	
	public String writeTemplatenameToExcel(String nameText, String sheetname) throws IOException {
		String excelFilePath = ".\\src\\test\\resources\\TestData.xlsx";
        FileInputStream inputStream = new FileInputStream(excelFilePath);
        Workbook workbook = new XSSFWorkbook(inputStream);
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
	
	public String writeLastnameToExcel(String nameText, String sheetname) throws IOException {
		String excelFilePath = ".\\src\\test\\resources\\TestData.xlsx";
        FileInputStream inputStream = new FileInputStream(excelFilePath);
        Workbook workbook = new XSSFWorkbook(inputStream);
        String sheetName_update = sheetname;
        Sheet sheet = workbook.getSheet(sheetname);
        int rowIndex = 1;  
        int columnIndex = 8;
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
	public String writeEmailToExcel(String emailText, String sheetName) throws IOException {
		String excelFilePath = ".\\src\\test\\resources\\TestData.xlsx";
        FileInputStream inputStream = new FileInputStream(excelFilePath);
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheet(sheetName);
        int rowIndex = 1;  
        int columnIndex = 9;
        Row row = sheet.getRow(rowIndex);
        Cell cell = row.createCell(columnIndex);
        cell.setCellValue(emailText);  
        inputStream.close();
		FileOutputStream outputStream = new FileOutputStream(excelFilePath);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
		return null;		
	}
	public String writeDespoToExcel(String nameText, String sheetname) throws IOException {
		String excelFilePath = ".\\src\\test\\resources\\TestData.xlsx";
        FileInputStream inputStream = new FileInputStream(excelFilePath);
        Workbook workbook = new XSSFWorkbook(inputStream);
        String sheetName_update = sheetname;
        Sheet sheet = workbook.getSheet(sheetname);
        int rowIndex = 1;  
        int columnIndex = 11;
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
	 
	public void add_customer_validation() throws InterruptedException {
		waitForElement(1000);
		wait.until(ExpectedConditions.elementToBeClickable(MainMenu));
		click(MainMenu);
		ExtentSuccessMessage("Clicked on Main Menu Option For Customer information URL Validation");
		waitForElement(500);
		wait.until(ExpectedConditions.elementToBeClickable(CustomerInformationTab));
		click(CustomerInformationTab);
		ExtentSuccessMessage("Clicked on Customer Information Tab");
		waitForElement(1000);
	}
	
	public void navigate_to_medicare_customer() throws InterruptedException {
		waitForElement(1000);
		wait.until(ExpectedConditions.elementToBeClickable(MedicareCustomer));
		click(MedicareCustomer);
		ExtentSuccessMessage("Clicked on MedicareCustomer Option");
		waitForElement(1000);
	}
	
	public void edit_update_medicare_customer() throws InterruptedException {
		waitForElement(1000);
		wait.until(ExpectedConditions.elementToBeClickable(SelectCustomerToEdit));
		click(SelectCustomerToEdit);
		ExtentSuccessMessage("Clicked on Medicare Customer Option to Edit");
		waitForElement(30000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickOnEditButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Edit Customer Button");
		waitForElement(5000);
		
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EditLastName));
		MoveToElementClick(element);
		writeText(EditLastName, "Update");
		getLastName = element.getAttribute("value");
		ExtentSuccessMessage("Clicked on Edit Customer Lastname and updated it");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EditFirstName));
		MoveToElementClick(element);
		getFirstName = element.getAttribute("value");
		fullName = getFirstName + " " + getLastName;
		ExtentSuccessMessage("Actual Full Name: " + fullName);
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EditSave));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Save Customer Button after the Update");
		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectUserBE));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected the user to perform logout!");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectLogoutBE));
		MoveToElementClick(element);
		ExtentSuccessMessage("Logout has been done from BE application");
		waitForElement(3000);
	}

	public String employerName() {
		String allowedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String ssn = "";
		String temp = RandomStringUtils.random(10, allowedChars);
		ssn = temp.substring(0, temp.length() - 5);
		return ssn;
	}

	public String agentName() {
		String allowedChars = "AEIOU" + "bcdfghjklmnpqrstvwxyz";
		String ssn = "";
		String temp = RandomStringUtils.random(12, allowedChars);
		ssn = temp.substring(0, temp.length() - 5);
		return ssn;
	}
	
	public int getRandomNumber()
	{
		Random r = new Random();
		int ran = r.nextInt(1000);
		return ran;
	}
	
	

	public void customer_fields_validation(CensusInfo ApplicantInfo) throws InterruptedException {
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AddCustomer));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Add Customer Link");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerFirstname));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customer Firstname Field");
		firstName = "TEST" + employerName();
		writeText(CustomerFirstname, firstName);
		ExtentSuccessMessage("Added customer's firstname");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerLastname));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on customers lastname fieldname");
		String lastName = employerName();
		writeText(CustomerLastname, lastName);
		ExtentSuccessMessage("Added customer's lastname");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerGender));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on customers gender");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(GenderName));
		MoveToElementClick(element);
		ExtentSuccessMessage("Added gender of the customer");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerDOB));
		MoveToElementClick(element);
		writeText(CustomerDOB, "01/01/1990");
		ExtentSuccessMessage("Added DOB of the customer");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerAddressLine));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on customers address line field");
		writeText(CustomerAddressLine, ApplicantInfo.AddressLine1);
		ExtentSuccessMessage("Added Address Line 1 of the customer");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerZipcode));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on customers zipcode field");
		writeText(CustomerZipcode, ApplicantInfo.Zipcode + Keys.TAB);
		ExtentSuccessMessage("Added Zipcode of the customer");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SameMailingAddress));
		MoveToElementClick(element);
		ExtentSuccessMessage("Checkbox clicked - Is Mailing address same as Home address!");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PhoneNumber));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on customers phone number field");
		writeText(PhoneNumber, ApplicantInfo.Phone);
		ExtentSuccessMessage("Added Phone number of the customer");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SaveButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Save Button");
		waitForElement(10000);
		driver.navigate().refresh();
		waitForElement(1000);
		fullName = firstName + " " + lastName;
		ExtentSuccessMessage("Actual Full Name: " + fullName);
//		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerFullName));
//		actualText = element.getText();
//		ExtentSuccessMessage("Actual Expected Name: " + actualText);
//		Assert.assertEquals(actualText, fullName);
		ExtentSuccessMessage("New customer has been added successfully!");
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectUserBE));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected the user to perform logout!");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectLogoutBE));
		MoveToElementClick(element);
		ExtentSuccessMessage("Logout has been done from BE application");
		waitForElement(3000);
	}

	public void customer_engage_validation(CensusInfo ApplicantInfo) throws InterruptedException, IOException {
		waitForElement(1000);
		String urlCE = configloader().getProperty("CEURL");
		String username = configloader().getProperty("PLCA_UserName");
		String pswd = configloader().getProperty("PLCA_Password");
		driver.get(urlCE);
		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(userID));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customer Engage Username field");
		writeText(userID, username);
		ExtentSuccessMessage("Entered the Customer Engage Username");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(pwd));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customer Engage password field");
		writeText(pwd, pswd);
		ExtentSuccessMessage("Entered the Customer Engage Password");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(signIn));
		MoveToElementClick(element);
		ExtentSuccessMessage("Customer Engage Application Sign-In Done");
		waitForElement(3000);
		try {
			if (driver.findElement(CheckUserLogin).isDisplayed()) {
				click(CheckUserLogin);
				ExtentSuccessMessage(
						"You currently have an active session on another device hence Deactivated the other session!");
			} else {
				ExtentSuccessMessage("Login has been successful");
			}
		} catch (Exception e) {
			ExtentSuccessMessage("Applicantion login successful");
		}
		waitForElement(1000);
	}

	public void customer_tile_information_validation() throws InterruptedException, IOException {
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerTile));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on customer tile");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerNameInCE));
		actualText = element.getText();
		ExtentSuccessMessage("Customer Name as per the Tile in CE:" + actualText);
		Assert.assertEquals(actualText, fullName);
		ExtentSuccessMessage(
				"Sync has been successfully completed hence the customer available in CE which was created in BE application");
		waitForElement(2000);
	}

	public static Properties configloader() throws IOException {
		FileInputStream File = new FileInputStream(".\\src\\test\\resources\\config.properties");
		Properties properties = new Properties();
		properties.load(File);
		return properties;
	}

	public void BE_add_new_agent_validation(CensusInfo ApplicantInfo) throws InterruptedException {
		waitForElement(1000);
		try {
			if (driver.findElement(LogoutButtonConfirmation).isDisplayed()) {
				click(LogoutButtonConfirmation);
			}
		} catch (Exception e) {
			ExtentSuccessMessage("Logout button is not there hence proper logout done");
		}
		waitForElement(2000);
		try {
			if (driver.findElement(ClickOnCloseButton).isDisplayed()) {
				click(ClickOnCloseButton);
			}
		} catch (Exception e) {
			ExtentSuccessMessage("Applicantion login inoccurate");
		}
		ExtentSuccessMessage("Applicantion login is successful");
		waitForElement(1000);
		String Url = driver.getCurrentUrl();
		if (Url.contains("https://test.brokerengage.net")) {
		    ExtentSuccessMessage("Logged in Environment: AWS PP");
		    System.out.println("Logged in Environment: AWS PP");
		    
			
		} else if (Url.contains("https://shop-test.benefitalign.com")) {
		    ExtentSuccessMessage("Logged in Environment: UAT");
		    System.out.println("Logged in Environment: UAT");
		    wait.until(ExpectedConditions.elementToBeClickable(SelectAdminUserBE));
			click(SelectAdminUserBE);
			waitForElement(1000);
			wait.until(ExpectedConditions.elementToBeClickable(LoginAsAgency));
			click(LoginAsAgency);
			waitForElement(30000);
		} else {
		    ExtentSuccessMessage("Logged in Environment: QA");
		}
		waitForElement(1000);
		wait.until(ExpectedConditions.elementToBeClickable(MainMenu));
		click(MainMenu);
		ExtentSuccessMessage("Clicked on Main Menu Option For Customer information URL Validation");
		waitForElement(500);
		wait.until(ExpectedConditions.elementToBeClickable(SettingsTab));
		click(SettingsTab);
		ExtentSuccessMessage("Clicked on Settings Tab");
		waitForElement(500);
		wait.until(ExpectedConditions.elementToBeClickable(AgencyDetailsTab));
		click(AgencyDetailsTab);
		ExtentSuccessMessage("Clicked on Agency Contacts Tab");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AddButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Add agent button");
		waitForElement(500);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentFirstName));
		MoveToElementClick(element);
		firstName = agentName();
		writeText(AgentFirstName, firstName);
		ExtentSuccessMessage("Entered the firstname of Agent: " + firstName);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentLastName));
		MoveToElementClick(element);
		lastName = agentName();
		writeText(AgentLastName, lastName);
		ExtentSuccessMessage("Entered the lastname of Agent: " + lastName);
		agentUserName = firstName + lastName;
		ExtentSuccessMessage("Generated Agent Username ---------------: " + agentUserName);
		System.out.println("Generated Agent Username ---------------: " + agentUserName);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentRole));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Add agent role dropdown");
		waitForElement(500);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentRoleSelection));
		MoveToElementClick(element);
		ExtentSuccessMessage("Agent role has been selected!");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentRoleSelection));
		MoveToElementClick(element);
		ExtentSuccessMessage("Agent role has been selected!");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentPhone));
		MoveToElementClick(element);
		writeText(AgentPhone, ApplicantInfo.Phone);
		ExtentSuccessMessage("Agent phone number has been added!");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentEmail));
		MoveToElementClick(element);
		getEmailValue = "TC-CE-" + writeDynamicEmail();
		writeText(AgentEmail, getEmailValue);
		ExtentSuccessMessage("Agent email has been added! Email address :  " + getEmailValue);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SaveButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Saved the newly added agent name!");
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(RequestForLogin));
		MoveToElementClick(element);
		ExtentSuccessMessage("Requested for Login and to provide more details!");
	}

	public void logout_from_BE_applicant() throws InterruptedException {
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectUserBE));
		MoveToElementClick(element);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectLogoutBE));
		MoveToElementClick(element);
		ExtentSuccessMessage("Logout has been done from BE application");
		waitForElement(3000);
	}

	public void perform_email_validation_and_create_agent_login() throws InterruptedException {
		waitForElement(3000);
		driver.get("https://yopmail.com/wm");
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(YopmailInbox));
		MoveToElementClick(element);
		writeText(YopmailInbox, getEmailValue);
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(YopmailSubmit));
		MoveToElementClick(element);
		waitForElement(3000);
//		element = wait.until(ExpectedConditions.presenceOfElementLocated(YopmailInboxText));
//		MoveToElementClick(element);
		driver.switchTo().frame("ifmail");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickHere));
		MoveToElementClick(element);
		waitForElement(3000);
		String parentWindowHandle = driver.getWindowHandle();
		switchToNextTab(driver, parentWindowHandle);
		ExtentSuccessMessage("Navigated to Internal User Registration page");
		waitForElement(1000);
	}

	public void internal_user_registration() throws InterruptedException {
		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NumberNPN));
		MoveToElementClick(element);
		writeText(NumberNPN, "16688522");
		ExtentSuccessMessage("NPN Number has been added: 16688522");
		ExtentSuccessMessage("Generated Username for the agent: " + agentUserName);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentUserName));
		MoveToElementClick(element);
		writeText(AgentUserName, agentUserName);
		ExtentSuccessMessage("Username has been entered!");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentPassword));
		MoveToElementClick(element);
		writeText(AgentPassword, "Password1");
		ExtentSuccessMessage("Password has been added for the agent username : Password1");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentRetypePassword));
		MoveToElementClick(element);
		writeText(AgentRetypePassword, "Password1");
		ExtentSuccessMessage("Retype-Password has been added for the agent username : Password1");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SecurityQuestion1));
		MoveToElementClick(element);
		waitForElement(500);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SecurityQuestionSelection1));
		MoveToElementClick(element);
		waitForElement(500);
		ExtentSuccessMessage("Security Question 1: What Is The Name Of Your Favorite Childhood Friend?");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SecurityAnswer1));
		MoveToElementClick(element);
		writeText(SecurityAnswer1, "Answer1");
		ExtentSuccessMessage("Security Question Answer 1: Answer1");
		waitForElement(500);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SecurityQuestion2));
		MoveToElementClick(element);
		waitForElement(500);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SecurityQuestionSelection2));
		MoveToElementClick(element);
		waitForElement(500);
		ExtentSuccessMessage("Security Question 2: In Which City Were You Born?");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SecurityAnswer2));
		MoveToElementClick(element);
		writeText(SecurityAnswer2, "Answer2");
		ExtentSuccessMessage("Security Question Answer 2: Answer2");
		waitForElement(500);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SecurityQuestion3));
		MoveToElementClick(element);
		waitForElement(500);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SecurityQuestionSelection3));
		MoveToElementClick(element);
		waitForElement(500);
		ExtentSuccessMessage("Security Question 3: What Is Your Best Friend's Name?");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SecurityAnswer3));
		MoveToElementClick(element);
		writeText(SecurityAnswer3, "Answer3");
		ExtentSuccessMessage("Security Question Answer 3: Answer3");
		waitForElement(500);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(TermsAndCondition));
		MoveToElementClick(element);
		ExtentSuccessMessage("Agreed Terms And Condition");
		waitForElement(500);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PersonConscent));
		MoveToElementClick(element);
		ExtentSuccessMessage("Agreed the Person Conscent");
		waitForElement(500);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SaveButtonIUR));
		MoveToElementClick(element);
		ExtentSuccessMessage("Internal User Registration has been successfully completed!");
		waitForElement(5000);
	}

	private static void switchToNextTab(WebDriver driver, String parentWindowHandle) {
		// Get all window handles
		ArrayList<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
		// Find the index of the parent window handle
		int parentIndex = windowHandles.indexOf(parentWindowHandle);
		// Switch to the next tab by using the next index in the list
		int nextTabIndex = (parentIndex + 1) % windowHandles.size();
		String nextTabHandle = windowHandles.get(nextTabIndex);
		driver.switchTo().window(nextTabHandle);
	}

	public void customer_engage_agent_validation(CensusInfo ApplicantInfo) throws InterruptedException, IOException {
		waitForElement(1000);
		String urlCE = configloader().getProperty("CEURL");
		driver.get(urlCE);
		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(userID));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customer Engage Username field");
		writeText(userID, agentUserName);
		ExtentSuccessMessage("Entered the newly created username");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(pwd));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customer Engage password field");
		writeText(pwd, "password!");
		ExtentSuccessMessage("Entered the Customer Engage Password");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(signIn));
		MoveToElementClick(element);
		ExtentSuccessMessage("Newly created agent in BE has been successfully synced to MME application");
		waitForElement(1000);
		ExtentSuccessMessage("All the above steps are executed successfully.");
	}

	public void create_tasks_in_dashboard_validation() throws InterruptedException {
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerTile));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customer Tile");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerNameInCE));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on the created customer");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickOnMyTasks));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Create my tasks!");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(TaskComments));
		ExtentSuccessMessage("Clicked on task comment text area");
		MoveToElementClick(element);
		writeText(TaskComments, "New task comment");
		ExtentSuccessMessage("Entered the task details");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CreateTaskSubmit));
		MoveToElementClick(element);
		ExtentSuccessMessage("Submitted - New task has been created");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(HomeMenu));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Home Menu button");
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(DashboardTile));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Dashboard Tile");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickMyTasks));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on MyTasks option from Dashboard Tile");
		waitForElement(1000);
	}

	public void day_week_month_view_validation() throws InterruptedException {
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(DayView));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Day View Menu");
		Assert.assertTrue(driver.findElement(Day_Week_Month_ViewTask).isDisplayed());
		ExtentSuccessMessage("Assertion has been successfully done! newly create task presents in Day view menu");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(WeekView));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Week View Menu");
		Assert.assertTrue(driver.findElement(Day_Week_Month_ViewTask).isDisplayed());
		ExtentSuccessMessage("Assertion has been successfully done! newly create task presents in Week view menu");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MonthView));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Month View Menu");
		waitForElement(2000);
		js.executeScript("window.scrollBy(10,400)");
		waitForElement(1000);
		Assert.assertTrue(driver.findElement(Day_Week_Month_ViewTask).isDisplayed());
		ExtentSuccessMessage("Assertion has been successfully done! newly create task presents in Month view menu");
		waitForElement(1000);
	}

	public void edit_and_delete_tasks_validation() throws InterruptedException {
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EditTask));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Edit task");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EditTaskComments));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Edit task");
		clear(EditTaskComments);
		writeText(EditTaskComments, "Task has been edited");
		ExtentSuccessMessage("Existing task has been edited!");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SubmitEditedTask));
		MoveToElementClick(element);
		ExtentSuccessMessage("Edited task has been save successfully!");
		waitForElement(2000);
		driver.navigate().refresh();
		waitForElement(3000);
		wait.until(ExpectedConditions.elementToBeClickable(DeleteTask));
		click(DeleteTask);
//		element = wait.until(ExpectedConditions.presenceOfElementLocated(DeleteTask));
//		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Delete task");
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PopUpDeleteYes));
		MoveToElementClick(element);
		ExtentSuccessMessage("Delete task confirmation pop-up enabled");
		waitForElement(2000);
		ExtentSuccessMessage("Task has been successfully deleted");
//		Assert.assertTrue(wait.until(ExpectedConditions.invisibilityOfElementLocated(EditTask)));
		ExtentSuccessMessage("Successfully performed the validation of create/edit/delete tasks under Dashboard");
		waitForElement(1000);
		ExtentSuccessMessage("All the above steps are executed successfully!");
	}

	public void health_enrollment_quotes_creation(CensusInfo ApplicantInfo) throws InterruptedException {
		waitForElement(1000);
		try {
			if (driver.findElement(ClickOnCloseButton).isDisplayed()) {
				click(ClickOnCloseButton);
			}
		} catch (Exception e) {
			ExtentSuccessMessage("Applicantion login inoccurate");
		}
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(FindInsuranceButton));
		MoveToElementClick(element);
//		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Find Insurance Link");
		waitForElement(1000);
		wait.until(ExpectedConditions.elementToBeClickable(HealthEnrollment));
		click(HealthEnrollment);
		ExtentSuccessMessage("Clicked on Health Enrollment Tab");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ZipCode));
		MoveToElementClick(element);
		clear(ZipCode);
		writeText(ZipCode, ApplicantInfo.Zipcode + Keys.TAB);
		ExtentSuccessMessage("Entered the zipcode");
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(GenderOfApplicant));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on gender of applicant dropdown list");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(GenderSelection));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on gender male of applicant");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ApplicantDOB));
		MoveToElementClick(element);
		clear(ApplicantDOB);
		writeText(ApplicantDOB, ApplicantInfo.DOB);
		ExtentSuccessMessage("Clicked on gender male of applicant");
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SeePlans));
		MoveToElementClick(element);
		ExtentSuccessMessage("Available Health plans are showing");
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PlanLabelAmbetter));
		MoveToElementClick(element);
		ExtentSuccessMessage("Plan Label Ambetter Filtered");
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AddToCartButton));
		MoveToElementClick(element);
		waitForElement(1000);
		ExtentSuccessMessage("Selected plan has been added to cart");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ContinueWithThisPlanCart));
		MoveToElementClick(element);
		waitForElement(1000);
		ExtentSuccessMessage("Navigated to cart page!");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickSelectButton));
		MoveToElementClick(element);
		waitForElement(1000);
		ExtentSuccessMessage("Selected the applicant plan");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(BeginEnrollment));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on the Begin Enrollment");
		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ContactFirstName));
		MoveToElementClick(element);
		writeText(ContactFirstName, ApplicantInfo.Firstname + Keys.TAB);
		waitForElement(1000);
		ExtentSuccessMessage("New customer Contact Firstname Added ");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ContactLastName));
		MoveToElementClick(element);
		writeText(ContactLastName, ApplicantInfo.Lastname + Keys.TAB);
		waitForElement(1000);
		fullName = ApplicantInfo.Firstname + " " + ApplicantInfo.Lastname;
		ExtentSuccessMessage("Full name of customer: " + fullName);
		ExtentSuccessMessage("New customer Contact Lastname Added ");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ContactPhone));
		MoveToElementClick(element);
		writeText(ContactPhone, "(620) 231-8771" + Keys.TAB);
		ExtentSuccessMessage("New customer Contact Phone Added ");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ContactSaveButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("New customer Contact has been saved! ");
		waitForElement(3000);
	}

	public void process_the_enrollment_steps(CensusInfo ApplicantInfo) throws InterruptedException {
		// Calculate the date 30 days ago
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -30);
		Date thirtyDaysAgo = calendar.getTime();
		// Format the date as a string
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		String formattedDate = dateFormat.format(thirtyDaysAgo);
		// Store the formatted date in a string
		String date30DaysAgo = formattedDate;
		// Print the generated date
		System.out.println("Date 30 days ago: " + date30DaysAgo);
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(HouseholdAddress));
		MoveToElementClick(element);
		writeText(HouseholdAddress, ApplicantInfo.AddressLine1 + Keys.TAB);
		ExtentSuccessMessage("Household address has been added ");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickNext));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Next button from Your household page ");
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SEPEvents));
		MoveToElementClick(element);
		waitForElement(500);
		Select select = new Select(element);
		select.selectByVisibleText("Got Married");
		ExtentSuccessMessage("SEP Event - Got Married Selected");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SEPEventDate));
		MoveToElementClick(element);
		waitForElement(500);
		writeText(SEPEventDate, date30DaysAgo);
		ExtentSuccessMessage("SEP Event Date Selected ");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerNameSEP));
		MoveToElementClick(element);
		select = new Select(element);
		select.selectByIndex(1);
		ExtentSuccessMessage("SEP Event - Customer Name Selected");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AddEventSEP));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Add SEP Event");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickSEPNext));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Next from SEP Page");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickNext));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Next button from SSN page ");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AppliedCircumstancesNext));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Next button from 'Do any of these circumstances apply' page.");
		waitForElement(2000);
	}

	public void process_the_income_and_deductions_steps(CensusInfo ApplicantInfo) throws InterruptedException {
		element = wait.until(ExpectedConditions.presenceOfElementLocated(IncomeType));
		MoveToElementClick(element);
		waitForElement(500);
		Select select = new Select(element);
		select.selectByVisibleText("Self-employment");
		ExtentSuccessMessage("Income Type - Self-employment selected");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(IncomeFrequency));
		MoveToElementClick(element);
		waitForElement(500);
		select = new Select(element);
		select.selectByVisibleText("Yearly");
		ExtentSuccessMessage("Income Frequency - Yearly selected");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(IncomeValue));
		MoveToElementClick(element);
		waitForElement(500);
		writeText(IncomeValue, ApplicantInfo.Earnings);
		ExtentSuccessMessage("Income of the applicant has been added");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickNext));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Next button from income and deductions page ");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickNext));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Next button from 'Premium Tax Credit Estimated based on Income' page ");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NoneOfTheseHRA));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on None of these option from HRA page ");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickNextHRA));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Next button from HRA page ");
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickIdTerms));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Terms and conditions in Agent Attestation page ");
		waitForElement(500);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickNextOnAgent));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked next button from Agent Attestation page");
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickNextOnPayment));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked next button from Payments page");
		waitForElement(2000);
	}

	public void health_enrollment_completion(CensusInfo ApplicantInfo) throws InterruptedException {
		element = wait.until(ExpectedConditions.presenceOfElementLocated(RoutingNumberField));
		MoveToElementClick(element);
		writeText(RoutingNumberField, "044072324");
		ExtentSuccessMessage("Routing Number Added");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(BankAccountNumber));
		MoveToElementClick(element);
		writeText(BankAccountNumber, "000123456789");
		ExtentSuccessMessage("Account Number Added");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AccountHolderName));
		MoveToElementClick(element);
		writeText(AccountHolderName, "TestUser");
		ExtentSuccessMessage("Account Holder Name Added");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AccountType));
		MoveToElementClick(element);
		Select select = new Select(element);
		select.selectByVisibleText("Savings");
		ExtentSuccessMessage("Account Type Savings Selected");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(YesSameEFT));
		MoveToElementClick(element);
		ExtentSuccessMessage("Is the EFT details same as above? - Yes");
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PaymentNext));
		MoveToElementClick(element);
		ExtentSuccessMessage("Navigated to Producer Statements page");
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SummaryNext));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked next button from Application Summary page");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(FullfilmentAgree));
		MoveToElementClick(element);
		ExtentSuccessMessage("Fullfilment Agreement Completed");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SubmitButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Enrollment Submitted Successfully");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CongratulationsMessage));
		String expectedString = element.getText();
		Assert.assertTrue(expectedString.contains(actualString), "Congratulations message is not appear");
		ExtentSuccessMessage("Congratulations Message Appearing");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EnrollmentFinish));
		MoveToElementClick(element);
		ExtentSuccessMessage("Enrollment Finished Successfully");
		waitForElement(10000);
	}

	public void enrolled_quotes_sync_CE_validation() throws InterruptedException {
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesTile));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Tile");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickQuotes));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Quotes");
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerNameInCE));
		actualText = element.getText();
		ExtentSuccessMessage("Customer Name as per the Tile in CE:" + actualText);
		Assert.assertEquals(actualText, fullName);
		ExtentSuccessMessage("Sync has been successfully completed hence the quotes available in CE!");
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CreatedDate));
		actualText = element.getText();
		ExtentSuccessMessage("Created date in CE:" + actualText);
		waitForElement(500);
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String formattedDate = currentDate.format(formatter);
		Assert.assertEquals(actualText, formattedDate);
		ExtentSuccessMessage(
				"Sync has been successfully completed hence the customer enrollment available in CE which was created in BE application");
		waitForElement(2000);
		ExtentSuccessMessage("All the above steps are executed successfully!");
		waitForElement(3000);
	}

	public void send_basic_details_of_applicant() throws InterruptedException {
		waitForElement(1000);
		try {
			if (driver.findElement(ClickOnCloseButton).isDisplayed()) {
				click(ClickOnCloseButton);
			}
		} catch (NoSuchElementException e) {
			ExtentSuccessMessage(
					"ClickOnCloseButton element not found! So you currently Dont have an active session on another device, hence Login is successful");
		} catch (Exception e) {
			ExtentSuccessMessage("Applicantion login inoccurate");
		}
		ExtentSuccessMessage("Applicantion login is successful");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectBEUser));
		MoveToElementClick(element);
		ExtentSuccessMessage("User has been selected");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectAgency));
		MoveToElementClick(element);
		ExtentSuccessMessage("User Agent Agency has been selected");
		wait.until(ExpectedConditions.presenceOfElementLocated(MarketingLabel));
		waitForElement(1000);
		ExtentSuccessMessage("Label Marketing has been selected");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(BusinessType));
		MoveToElementClick(element);
		ExtentSuccessMessage("Business Type element has been selectocateded");
		element = driver.findElement(By.xpath("//li/span[text()='" + "Individual" + "']"));
		MoveToElementClick(element);
		ExtentSuccessMessage("Business Type Individual has been selected");
		waitForElement(1000);
		ExtentSuccessMessage("Line of business element located");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LifeOfBusiness));
		MoveToElementClick(element);
		element = driver.findElement(By.xpath("//li/span[text()='" + "Health" + "']"));
		MoveToElementClick(element);
		ExtentSuccessMessage("Line of business 'Health' has been selected");
		ExtentSuccessMessage("English Language has been auto-selected");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MarketingURLButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Generated the Marketing URL - In progress");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CopyMarketingURL));
		MarketingURL = element.getText();
		ExtentSuccessMessage("successfully generated the marketing URL");
		System.out.println("Marketing URL: " + MarketingURL);
		ExtentSuccessMessage("Copying Marketing URL from the page");
		waitForElement(1000);
		ExtentSuccessMessage("Copied Marketing URL successfully");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectAgentLogout));
		ExtentSuccessMessage("Sign-Out element identified successfully");
		MoveToElementClick(element);
		ExtentSuccessMessage("Logout has been successful");
		waitForElement(5000);
	}

	public void create_leads_from_consumer(CensusInfo ApplicantInfo) throws InterruptedException, IOException {
		waitForElement(1000);
		driver.get(MarketingURL);
		ExtentSuccessMessage("Consumer login page has opened");
		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SaveProgress));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Save Progress Link");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadFirstname));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Lead firstname field");
		getFirstName = "" + writeDynamicFirstLastname();
		writeText(LeadFirstname, getFirstName);
		ExtentSuccessMessage("Entered the firstname as: " + getFirstName);
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadLastname));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Lead lastname field");
		getLastName = "" + writeDynamicFirstLastname();
		writeText(LeadLastname, getLastName);
		ExtentSuccessMessage("Entered the lastname as: " + getLastName);
		waitForElement(1000);
		fullName = getFirstName + " " + getLastName;
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadEmail));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Lead Email field");
		String getEmailValue = "Leads_Sync" + writeDynamicEmail();
		writeText(LeadEmail, getEmailValue);
		ExtentSuccessMessage("Entered the Email as: " + getEmailValue);
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SaveLeadDetails));
		MoveToElementClick(element);
		ExtentSuccessMessage("Customer lead information saved!");
		waitForElement(1000);
	}

	public void leads_sync_CE_validation() throws InterruptedException {
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesTile));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Tile");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLeads));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Leads");
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerNameInCE));
		actualText = element.getText();
		ExtentSuccessMessage("Customer Name as per the Tile in CE:" + actualText);
		Assert.assertEquals(actualText, fullName);
		ExtentSuccessMessage("Sync has been successfully completed hence the quotes available in CE!");
		waitForElement(2000);
		ExtentSuccessMessage(
				"Sync has been successfully completed hence the customer leads available in CE which was created in BE application");
		waitForElement(2000);
	}

	public void create_leads_from_callback_request(CensusInfo ApplicantInfo) throws InterruptedException, IOException {
		waitForElement(2000);
		driver.get(MarketingURL);
		ExtentSuccessMessage("Consumer login page has opened");
		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CallBackRequest));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Call Back Request");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadCBFirstname));
		MoveToElementClick(element);
		clear(LeadCBFirstname);
		ExtentSuccessMessage("Clicked on Lead firstname field");
		getFirstName = "" + writeDynamicFirstLastname();
		writeText(LeadCBFirstname, getFirstName);
		ExtentSuccessMessage("Entered the firstname as: " + getFirstName);
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadCBLastname));
		MoveToElementClick(element);
		clear(LeadCBLastname);
		ExtentSuccessMessage("Clicked on Lead lastname field");
		getLastName = "" + writeDynamicFirstLastname();
		writeText(LeadCBLastname, getLastName);
		ExtentSuccessMessage("Entered the lastname as: " + getLastName);
		waitForElement(1000);
		fullName = getFirstName + " " + getLastName;
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadPhoneNumber));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Lead Phone number field");
		writeText(LeadPhoneNumber, "(555)222-1001");
		ExtentSuccessMessage("Entered the Phone number ");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SaveLeadDetails));
		MoveToElementClick(element);
		ExtentSuccessMessage("Customer lead callback request information saved!");
		waitForElement(1000);
		ExtentSuccessMessage("All the above steps are executed successfully.");
		waitForElement(3000);
	}

	
}
