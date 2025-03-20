package com.pages;
import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.RenderingHints.Key;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.lang.ref.Reference;
import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

import org.apache.poi.ss.formula.functions.Today;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.BasePackage.Base_Class;

public class Agent360Page extends BasePage {

	public Agent360Page(WebDriver driver) {
		super(driver);
	}
	//	Agent_Validations Agent_Validations =new Agent_Validations(driver);
	WebElement element;

	public String Iss_Date;
	public String LicenseExpiryDate;
	public String CarrierAgentNameOptionvalue;
	public String CarrierStateDDOptionvalue;
	public String Currentdate;
	public String CarrierAgentStatusOptionvalue;
	public String CarrierAgentStatusOptionvalue1;
	public String LicenseStatus;
	public String LicenseStates;
	public String LicenseStates1;
	public String LoginUsername;
	public String CurretDate;
	public String NoteText;
	public String Fullname;
	

	private By License_Tab = By.xpath("(//a[normalize-space()='Licenses'])[1]//parent::li | (//a[normalize-space()='Licenses'])[1]");
	private By Create_License = By.id("StateLicenses");
	private By StateDD = By.xpath("//md-select[@name='State']");

	private By DDValue = By.xpath("//md-option[@value='AK']");
	private By DDValue1 = By.xpath("//md-option[@value='AL']");
	private By IssuedDate = By.xpath("//input[@name='IssuedDate']");
	private By ExpiryDate = By.xpath("//input[@name='ExpirationDate']");
	private By State = By.xpath("(//div[@title='AK'])[1]");
	private By Product_Category = By.xpath("(//div[@title='All'])[1]");
//	private By Success_Message = By.xpath("//div[@id='divSuccess']");
	private By SaveAppointmenteditbtn =By.xpath("//*[@name='submitAppointmenteditbtn'] | //*[@name='saveLicenseEditBtn']");
	private By SaveAppointmenteditbtn1 =By.name("submitAppointmenteditbtn");
	private By LoginuserName= By.xpath("//*[@class='user']//b");


	private By CTIMinimizeIcon = By.xpath("//a[@class='fa fa-minus right-al']");
	private By Agencymodule = By.xpath("//*[@class='box animate-box fade-in'][@ng-show=\"isAccessible('Agency')\"]");
	private By AgentTab = By.xpath("//*[contains(@ng-show,'Agent')]");
	private By AddAgent = By.id("createNewAgentBtn");
	private By FirstName = By.name("FirstName");//*[@id='input_566']//parent::md-input-container
	private By LastName = By.name("LastName");
	private By AgencyTypeDropdown = By.name("AgencyType");
	private By LicenceNumber = By.name("StateLicenseNumber");
	private By Status = By.name("Status");
	private By Phonenumber = By.name("Phone");
	private By Agentsubmitbtn = By.id("saveAgentdetailsButton");
	private By Email = By.name("Email");
	private By AgentTabValidate = By.xpath("//*[@class='page-header']//*[text()='All Agents']");
	private By Agentcontactinfo = By.xpath("(//h5[text()='Agent Contact Information']//parent::div//i)[2]");
	private By AgentSearchBar = By.xpath("//*[@aria-label='Search your text']");
	private By AgentEditbtn =By.id("editAgentBtn");
	private By AgentLicenceNumber =By.xpath("//*[text()='License Number:']//parent::span//span");
	private By AgentLicencenumberfield = By.name("StateLicenseNumber");
	private By InvalidMessage = By.id("divError");
	private By MoreTab = By.xpath("(//*[@ng-show='hasMoreTabs()']//a)[1]");
	//private By MoreTab = By.xpath("//*[@ng-show='hasMoreTabs()']//a");
	private By QuotesTab = By.xpath("(//*[contains(@ng-repeat,'tab in detailsFolder')]//a[@class='ng-binding'])[text()='Quotes']");
	private By PoliciesTab = By.xpath("(//*[contains(@ng-repeat,'tab in detailsFolder')]//a[@class='ng-binding'])[text()='Policies']");
	private By EditagentSave =By.xpath("//*[contains(@ng-click,'updateAgent(editAgentFormAccountHolder')][text()='Save']");
	private By AgentTypeField = By.xpath("//*[text()='Agency Type:']");
	private By AgencyTypeField = By.xpath("//*[text()='Agency Type:']");
	private By CompanyNameField = By.xpath("//*[text()='Company Name:']");
	private By AgentStatus = By.xpath("(//md-select[@name='Status'])[3] | (//md-select[@name='Status'])[@required='required']");
	private By AgentStatusOption = By.xpath("(//md-option[@value='Active'])[3]");
	private By CarrierAppointments = By.xpath("//*[text()=' Carrier Appointments']//parent::li");
	private By ChangelogsTab =By.xpath("//*[text()=' Change Log']//parent::li");
	private By TaskComment =By.xpath("//textarea[@placeholder='Comments']");
	private By StatusDD = By.xpath("(//md-select[@role='listbox'])[3]");
	private By StatusDDOption = By.xpath("(//div[@class='md-text ng-binding'][normalize-space()='Active'])[1]");
	private By SubmitLicenseButton = By.xpath("//button[@name='SaveStateLicenseBtn']");
	private By LicenseSection = By.xpath("//a[text()=' Licenses']");
	private By CarrierTextArea = By.xpath("//textarea[@name='Comments']");
	private By CarrierSaveButton = By.xpath("//button[@name='saveCarrierDetailsBtn']");
	private By CarrierSearchTextField = By.xpath("//input[@class='ng-pristine ng-untouched md-input ng-empty ng-valid-minlength ng-valid-maxlength ng-valid ng-valid-required']");
	private By CarrierNameSearchField = By.xpath("(//div[@class='ngCellText ng-scope'])[1]/a");
	private By CarrierAgentAppointmentButton = By.xpath("//button[@name='newAgentAppointmentBtn'] | //button[@name='CarrierAppointments']");
	private By CarrierAgentNameDD = By.xpath("//md-select[@name='AgentName'] | //md-select[@name='CarrierName']");
	private By CarrierAgentNameOption = By.xpath("(//div[contains(.,'CEUser one')])[15] | (//*[contains(@class,'dropDown md-active md-clickable')]//md-option[@ng-repeat='opt in fieldVal.options | filter: searchTerm'])[1]");
	private By CarrierStateDD = By.xpath("//md-select[@name='Statelike'] | //md-select[@name='State']");
	private By CarrierStateDDOption = By.xpath("//div[text()='CT']");
	private By AppointmentCarrierSubmitButton = By.xpath("//button[@name='saveAgentAppointmentBtn'] | //button[@name='SaveCarrierAppointmentBtn']");
	private By CarrierAgentStatusOption = By.xpath("//div[text()='Active']");
	private By CarrierAgentStatusOption1 = By.xpath("//div[text()='Terminated']");
	private By CarrierAgentStatusDD = By.xpath("//md-select[@name='AgentStatus'] | //md-select[@name='CarrierAppointmentStatus']");
	private By CarrierAppoinmentstartdate =By.xpath("//*[@name='IssuedDate']");
	private By nameelement=By.xpath("//*[text()='Agent Name:']//parent::span//span");
	private	By AgentType = By.xpath("(//span[normalize-space()='Internal'])[1]");
	private By Click_Agent = By.xpath("//a[@class='edit-list-anchor ng-binding']");
	private By EditGrid = By.xpath("//*[text()='Edit']");
	private By Success_Message = By.xpath("//div[@id='divSuccess']");
	
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
	private By Agent_Type = By.xpath("(//i[@role='button'])[2]");
	private By Recent_Agents = By.xpath("(//i[@role='button'])[1]");
	private By States = By.xpath("(//i[@role='button'])[4]");
	private By Agency_Type = By.xpath("(//i[@role='button'])[5]");
	private By Advancesearch =By.name("advancedSearchBtn");
	private By AdvancesearchStatus = By.name("Status");
	private By ApplyadvancedSearchBtn = By.name("applyadvancedSearchBtn");
	private By downlodDataBtn =By.name("downlodDataBtn");
	private By BacktoAgentModule =By.xpath("//*[@href='#/agency/agents']");
	private By SubmitTask =By.xpath("//i[@class='fa fa-check yellow green']");
	private By DashboardMenu =By.name("menu_Dashboard");
	private By submenu_MyTasks =By.name("submenu_MyTasks");
	private By DeleteTask =By.xpath("(//i[@ng-click='deleteTask(activity, false)'])[1]");
	private By DeleteTaskOK =By.xpath("//button[@class='positive md-button md-ink-ripple']");
	private By Tasktab =By.xpath("//a[@role='tab']//i[@class='fa fa-calendar'] | //a[@role='tab']//i[@class='fa fa-calendar']//parent::a");
	
	


	public void ClickOnMinimizeCallwindow() throws InterruptedException {		
		if (ElementDisplayed(CTIMinimizeIcon)) {
			ExtentSuccessMessage("Successfully user able to See 'Minimize Icon' ");
			click(CTIMinimizeIcon);
			ExtentSuccessMessage("Successfully user Clicked on 'Minimize Icon' ");
		} else {
			ExtentSuccessMessage("Unsuccessfully 'Minimize' Not visible");
		}
	}
	
	public void GOBacktoAgentModule() throws InterruptedException {		
		if (ElementDisplayed(BacktoAgentModule)) {
			ExtentSuccessMessage("Successfully user able to See 'Back to Agent Module ' ");
			click(BacktoAgentModule);
			ExtentSuccessMessage("Successfully user Clicked on 'Back to Agent Module ' ");
		} else {
			ExtentSuccessMessage("Unsuccessfully 'Back to Agent Module ' Not visible");
		}
	}
	
//	BacktoAgentModule
	public void ClickOnSaveAppointmenteditbtn() throws InterruptedException {		
		if (ElementDisplayed(SaveAppointmenteditbtn)) {
			ExtentSuccessMessage("Successfully user able to See 'Save Appointment edit btn ' ");
			click(SaveAppointmenteditbtn);
			ExtentSuccessMessage("Successfully user Clicked on 'Save Appointment edit btn ' ");
			String msg=GetElementText(Success_Message);
			Assert.assertEquals(msg, "Records Updated Successfully");			
		} else {
			ExtentSuccessMessage("Unsuccessfully 'Save Appointment edit btn ' Not visible");
		}
	}
	
	public void ClickOnSaveAppointmenteditbtn1() throws InterruptedException {		
		if (ElementDisplayed(SaveAppointmenteditbtn1)) {
			ExtentSuccessMessage("Successfully user able to See 'Save Appointment edit btn ' ");
			click(SaveAppointmenteditbtn1);
			ExtentSuccessMessage("Successfully user Clicked on 'Save Appointment edit btn ' ");
			String msg=GetElementText(Success_Message);
			Assert.assertEquals(msg, "Records Updated Successfully");			
		} else {
			ExtentSuccessMessage("Unsuccessfully 'Save Appointment edit btn ' Not visible");
		}
	}
	
	public void ClickOnEditButton() throws InterruptedException {		
		if (ElementDisplayed(EditGrid)) {
			ExtentSuccessMessage("Successfully user able to See 'Edit Icon' ");
			click(EditGrid);
			ExtentSuccessMessage("Successfully user Clicked on 'Edit Icon' ");
		} else {
			ExtentSuccessMessage("Unsuccessfully 'Edit' Not visible");
		}
	}
	
	public void ClickOnMoreTab() throws InterruptedException {	
		Thread.sleep(2000);
		if (ElementDisplayed(MoreTab)) {
			ExtentSuccessMessage("Successfully user able to See 'More Tab' ");
			click(MoreTab);
			ExtentSuccessMessage("Successfully user Clicked on 'More Tab' ");
		} else {
			ExtentSuccessMessage("Unsuccessfully 'More Tab' Not visible");
		}
	}

	public void NavigatetoPoliciesTab() throws InterruptedException {
		ClickOnMoreTab();
		ClickOnPoliciesTab();
	}

	public void NavigatetoQuotesTab() throws InterruptedException {
		ClickOnMoreTab();
		ClickOnQuotesTab();
	}

	public void ClickOnPoliciesTab() throws InterruptedException {	
		Thread.sleep(2000);
		if (ElementDisplayed(PoliciesTab)) {
			ExtentSuccessMessage("Successfully user able to See 'Policies Tab' ");
			click(PoliciesTab);
			ExtentSuccessMessage("Successfully user Clicked on 'Policies Tab' ");
		} else {
			ExtentSuccessMessage("Unsuccessfully 'Policies Tab' Not visible");
		}
	}
	public void ClickOnQuotesTab() throws InterruptedException {	
		Thread.sleep(2000);
		if (ElementDisplayed(QuotesTab)) {
			ExtentSuccessMessage("Successfully user able to See 'Quotes Tab' ");
			click(QuotesTab);
			ExtentSuccessMessage("Successfully user Clicked on 'Quotes Tab' ");
		} else {
			ExtentSuccessMessage("Unsuccessfully 'Quotes Tab' Not visible");
		}
	}
	public void ClickOnAgentEditbutton() throws InterruptedException {		
		Thread.sleep(5000);
		if (ElementDisplayed(AgentEditbtn)) {
			ExtentSuccessMessage("Successfully user able to See 'AgentEditbtn Icon' ");
			click(AgentEditbtn);
			ExtentSuccessMessage("Successfully user Clicked on 'AgentEditbtn Icon' ");
		} else {
			ExtentSuccessMessage("Unsuccessfully 'AgentEditbtn' Not visible");
		}
	}
	public void ClickOnEditagentSavebutton() throws InterruptedException {		
		//		Thread.sleep(5000);
		if (ElementDisplayed(EditagentSave)) {
			ExtentSuccessMessage("Successfully user able to See 'EditagentSave Icon' ");
			click(EditagentSave);
			ExtentSuccessMessage("Successfully user Clicked on 'EditagentSave Icon' ");
		} else {
			ExtentSuccessMessage("Unsuccessfully 'EditagentSave' Not visible");
		}
	}

	public void hoverOnAgencyModule() throws InterruptedException {
		ClickOnMinimizeCallwindow();
		Thread.sleep(5000);
		if (ElementDisplayed(Agencymodule)) {
			ExtentSuccessMessage("Successfully user able to See 'Agency module Icon' ");
			MouseHoverOnElement(Agencymodule);
			ExtentSuccessMessage("Successfully user Hover on 'Agency module Icon' ");
		} else {
			RefreshPage();
			Thread.sleep(15000);
			ClickOnMinimizeCallwindow();
			//			ExtentErrorMessage("Unsuccessfully 'Agency module Icon' Not visible");
			if (ElementDisplayed(Agencymodule)) {
				ExtentSuccessMessage("Successfully user able to See 'Agency module Icon' ");
				MouseHoverOnElement(Agencymodule);
				ExtentSuccessMessage("Successfully user Hover on 'Agency module Icon' ");
			} else {
				ExtentErrorMessage("Unsuccessfully 'Agency module Icon' Not visible");
			}
		}
	}

	public void ClickOnAgentTab() throws InterruptedException {
		Thread.sleep(1000);
		LoginUsername=GetElementText(LoginuserName);
		if (ElementDisplayed(AgentTab)) {
			ExtentSuccessMessage("Successfully user able to See 'AgentTab ' ");
			click(AgentTab);
			ExtentSuccessMessage("Successfully user Clicked on 'AgentTab' ");
			ValidateAgentTab();
		} else {
			ExtentErrorMessage("Unsuccessfully 'AgentTab ' Not visible");
		}
	}
	public void ClickOnAgentcontactinfo() throws InterruptedException {
		Thread.sleep(3000);
		if (ElementDisplayed(Agentcontactinfo)) {
			ExtentSuccessMessage("Successfully user able to See 'Agentcontactinfo ' ");
			click(Agentcontactinfo);
			ExtentSuccessMessage("Successfully user Clicked on 'Agentcontactinfo' ");
		} else {
			ExtentErrorMessage("Unsuccessfully 'Agentcontactinfo ' Not visible");
		}
	}
	public void ClickOnAgentsubmitbtn() throws InterruptedException {
		//		Thread.sleep(3000);
		//		waitVisibility(Agentsubmitbtn);
		if (ElementDisplayed(Agentsubmitbtn)) {
			ExtentSuccessMessage("Successfully user able to See 'Agentsubmitbtn ' ");
			click(Agentsubmitbtn);
			ExtentSuccessMessage("Successfully user Clicked on 'Agentsubmitbtn' ");
		} else {
			ExtentErrorMessage("Unsuccessfully 'Agentsubmitbtn ' Not visible");
		}
	}

	public void ClickOnAddAgent() throws InterruptedException {
		Thread.sleep(9000);
		if (ElementDisplayed(AddAgent)) {
			ExtentSuccessMessage("Successfully user able to See 'AddAgent ' ");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(AddAgent));
			MoveToElementClick(element);
			//click(AddAgent);
			ExtentSuccessMessage("Successfully user Clicked on 'AddAgent' ");
			Thread.sleep(7000);
		} else {
			ExtentErrorMessage("Unsuccessfully 'AddAgent ' Not visible");
		}
	}

	public void ValidateAgentTab() throws InterruptedException {
		//		Thread.sleep(25000);
		WaitUntillPAgeLoad();
		//		if (ElementDisplayed(AgentTabValidate)) {
		//			ExtentSuccessMessage("Successfully user Landed on 'AgentTab ' ");	
		//			
		//		} else {
		//			ExtentErrorMessage("Unsuccessfully user Not Loanded on 'AgentTab ' ");
		//		}
		//		ClickOnMinimizeCallwindow();

	}

	public void NavigatetoAgentTab() throws InterruptedException {
		hoverOnAgencyModule();
		ClickOnAgentTab();
	}

	public void validate_the_fields_in_agent_grid_page() throws InterruptedException {
		NavigatetoAgentTab();
		ValidatetheGrid();
	}
	public void Validate_existing_agents_AOR_are_getting_displayed_on_the_agent_grid(CensusInfo ApplicantInfo) throws InterruptedException, AWTException {

		ExtentSuccessMessage("Start_AG_TS_001_TC_001_Navigate_To_Agent_Screen");
		NavigatetoAgentTab();
		ExtentSuccessMessage("End_AG_TS_001_TC_001_Navigate_To_Agent_Screen");
		ExtentSuccessMessage("*****************************************");
		ExtentSuccessMessage("Start_ AG_TS_001_TC_002_validate_the_fields_in_agent_grid_page");
		ValidatetheGrid();
		ExtentSuccessMessage("End AG_TS_001_TC_002_validate_the_fields_in_agent_grid_page");
		ExtentSuccessMessage("*****************************************");
		String Agentname =CreateAgent(ApplicantInfo);
		waitForElement(10000);
		EnterAgentSearchBar(Agentname);
		ValidateAgentDetails(Agentname);
	}
	public void Validate_edit_agent_details_and_save_the_changes(CensusInfo ApplicantInfo) throws InterruptedException, AWTException {
		ExtentSuccessMessage("Start_AG_TS_001_TC_001_Navigate_To_Agent_Screen");
		NavigatetoAgentTab();
		ExtentSuccessMessage("End_AG_TS_001_TC_001_Navigate_To_Agent_Screen");
		ExtentSuccessMessage("*****************************************");
		ExtentSuccessMessage("Start_ AG_TS_001_TC_002_validate_the_fields_in_agent_grid_page");
		ValidatetheGrid();
		ExtentSuccessMessage("End AG_TS_001_TC_002_validate_the_fields_in_agent_grid_page");
		ExtentSuccessMessage("*****************************************");
		ExtentSuccessMessage("Start_ AG_TS_001_TC_003_TC004_validate_the_click_on_agent_name_State");
		String Agentname =CreateAgent(ApplicantInfo);
		EnterAgentSearchBar(Agentname);
		ValidateAgentDetails(Agentname);
		ExtentSuccessMessage("End_ AG_TS_001_TC_003_TC004_validate_the_click_on_agent_name_State");
		ExtentSuccessMessage("*****************************************");
		ExtentSuccessMessage("Start_AG_TS_001_TC_005_validate_the_edit_agent_details_and_save_the_changes");
		String AgentLicencenumber=FetchAgentLicenceNumber();
		ClickOnAgentEditbutton();
		String newlincenceno =generatePhoneNumber();
		EnterAgentLicencenumberfield(newlincenceno);
		ClickOnEditagentSavebutton();
		String NewAgentLicencenumber=FetchAgentLicenceNumber();
		Assert.assertNotEquals(AgentLicencenumber, NewAgentLicencenumber);
		ExtentSuccessMessage("Successfully edited the Licence no : Old licence no "+AgentLicencenumber+" new licence no "+NewAgentLicencenumber+" ");
		Assert.assertEquals(NewAgentLicencenumber, newlincenceno);
		ExtentSuccessMessage("Successfully edited the Licence no : Acctual licence no "+NewAgentLicencenumber+" Expected licence no "+newlincenceno+" ");
		ExtentSuccessMessage("End_AG_TS_001_TC_005_validate_the_edit_agent_details_and_save_the_changes");
	}


	public void Validate_edit_agent_details_and_save_the_changes1(CensusInfo ApplicantInfo) throws InterruptedException, AWTException {
		ExtentSuccessMessage("Start_AG_TS_001_TC_001_Navigate_To_Agent_Screen");
		NavigatetoAgentTab();
		ExtentSuccessMessage("End_AG_TS_001_TC_001_Navigate_To_Agent_Screen");
		ExtentSuccessMessage("******************************************************************");
		ExtentSuccessMessage("Start_ AG_TS_001_TC_002_validate_the_fields_in_agent_grid_page");
		ValidatetheGrid();
		ExtentSuccessMessage("End AG_TS_001_TC_002_validate_the_fields_in_agent_grid_page");
		ExtentSuccessMessage("******************************************************************");
		ExtentSuccessMessage("Start_ AG_TS_001_TC_003_TC004_validate_the_click_on_agent_name_State");
		String Agentname =CreateAgent(ApplicantInfo);
		EnterAgentSearchBar(Agentname);
		ValidateAgentDetails(Agentname);
		ExtentSuccessMessage("End_ AG_TS_001_TC_003_TC004_validate_the_click_on_agent_name_State");
		ExtentSuccessMessage("******************************************************************");
		ExtentSuccessMessage("Start_AG_TS_001_TC_005_validate_the_edit_agent_details_and_save_the_changes");
		
		String AgentLicencenumber=FetchAgentLicenceNumber();
		ClickOnAgentEditbutton();
		String newlincenceno =generatePhoneNumber();
		EnterAgentLicencenumberfield(newlincenceno);
		ClickOnEditagentSavebutton();
		String NewAgentLicencenumber=FetchAgentLicenceNumber();
		Assert.assertNotEquals(AgentLicencenumber, NewAgentLicencenumber);
		ExtentSuccessMessage("Successfully edited the Licence no : Old licence no "+AgentLicencenumber+" new licence no "+NewAgentLicencenumber+" ");
		Assert.assertEquals(NewAgentLicencenumber, newlincenceno);
		ExtentSuccessMessage("Successfully edited the Licence no : Acctual licence no "+NewAgentLicencenumber+" Expected licence no "+newlincenceno+" ");
		ExtentSuccessMessage("End_AG_TS_001_TC_005_validate_the_edit_agent_details_and_save_the_changes");
		ExtentSuccessMessage("******************************************************************");
		ExtentSuccessMessage("Start AG_TS_004_TC_001_validate_the_folders_tabs_in_agent_detail_page");
		ValidateAgentDetailsTab();
		ExtentSuccessMessage("End AG_TS_004_TC_001_validate_the_folders_tabs_in_agent_detail_page");
		ExtentSuccessMessage("******************************************************************");
		ExtentSuccessMessage("Start_AG_TS_004_TC_002_validate_the_fields_in_General_information_tab");
		Validate_General_Information_Tab_Fields();
		ExtentSuccessMessage("End_AG_TS_004_TC_002_validate_the_fields_in_General_information_tab");
		ExtentSuccessMessage("******************************************************************");
		ExtentSuccessMessage("Start AG_TS_005_TC_001_Create_State_License");
		Create_Licenses();
		ExtentSuccessMessage("End AG_TS_005_TC_001_Create_State_License");
		ExtentSuccessMessage("******************************************************************");
		ExtentSuccessMessage("Start AG_TS_004_TC_004_State_Licenses");
		license_Fields_Validation();
		ExtentSuccessMessage("End AG_TS_004_TC_004_State_Licenses");
		ExtentSuccessMessage("******************************************************************");

		ExtentSuccessMessage("Start AG_TS_006_TC_001_Create_Carrier_Appointment");
		ClickOnCarrierAppointmentsTab();
		Carrier_Appointments();
		
		
		
	}


	public void Validate_updating_without_entering_mandatory_fields_entering_invalid_details(CensusInfo ApplicantInfo) throws InterruptedException, AWTException {
		NavigatetoAgentTab();
		String Agentname =CreateAgent(ApplicantInfo);
		EnterAgentSearchBar(Agentname);
		ValidateAgentDetails(Agentname);
		String AgentLicencenumber=FetchAgentLicenceNumber();
		ClickOnAgentEditbutton();
		EnterAgentLicencenumberfield("");
		ClickOnEditagentSavebutton();
		String InvalidMessage=FetchInvalidMessage();
		String Mandatoryfield="Please enter mandatory fields.";
		Assert.assertEquals(InvalidMessage,Mandatoryfield );
		ExtentSuccessMessage("Successfully edited the Licence no : Acctual Invalid Message:-  "+InvalidMessage+" Expected Invalid Message:-  "+Mandatoryfield+" ");
	}


	public void ValidateCreateAgentorSalesmen(CensusInfo ApplicantInfo) throws InterruptedException, AWTException {
		NavigatetoAgentTab();
		String Agentname =CreateAgent(ApplicantInfo);
		EnterAgentSearchBar(Agentname);
		ValidateAgentDetails(Agentname);
		ExtentSuccessMessage("********************************************************");
		ExtentSuccessMessage("Start_AG_TS_004_TC_006_validate_the_fields_in_quotes_tab");
		NavigatetoQuotesTab();
		ValidatetheQuoteTabGrid();
		ExtentSuccessMessage("End_AG_TS_004_TC_006_validate_the_fields_in_quotes_tab");
		ExtentSuccessMessage("********************************************************");
		ExtentSuccessMessage("Start_AG_TS_004_TC_007_validate_the_fields_in_Policys_tab");
		NavigatetoPoliciesTab();
		ValidatethePolicyTabGrid();
		ExtentSuccessMessage("End_AG_TS_004_TC_007_validate_the_fields_in_Policys_tab");
		ExtentSuccessMessage("********************************************************");
		
		ExtentSuccessMessage("Start AG_TS_007_TC_001_Collaborations");
		Thread.sleep(5000);
		By maximize = By.xpath("//span[@class='collpase-leftt glyphicon glyphicon-triangle-right']");
		if(ElementDisplayed(maximize))
		{
			element = wait.until(ExpectedConditions.presenceOfElementLocated(maximize));
			MoveToElementClick(element);
			ExtentSuccessMessage("Clicked on Maximize");
		}
		Thread.sleep(5000);
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

		element = wait.until(ExpectedConditions.presenceOfElementLocated(ActionEmailIcon));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Action Email Icon");

		Thread.sleep(5000);
		element =wait.until(ExpectedConditions.elementToBeClickable(EmailAddressDD));
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
//		Base_Class.ScrollUntilElementVisible(AttachmentInc);
//		waitVisibility(AttachmentInc);
//		Assert.assertTrue(driver.findElement(AttachmentInc).isDisplayed());
		ExtentSuccessMessage("Assertion has been done");

		element = wait.until(ExpectedConditions.presenceOfElementLocated(ActionTask));
		MoveToElementClick(element);
		
		Thread.sleep(9000);
		String LeadTaskComment ="Automation Customer Task comment for testing";
		writeText(TaskComment,LeadTaskComment);
		ClickOnSubmitTask();
		ClickOnDashboardMenu();
		ClickOnsubmenu_MyTasks();
		RefreshPage();
		Thread.sleep(9000);
		By TodayTask =By.xpath("(//*[text()='To Do']//parent::div//parent::div[@ng-click='getDataToLoadParticularSection(task)'])[1]");
		Thread.sleep(3000);
		if(ElementDisplayed(TodayTask)) {			
			ExtentSuccessMessage("Successfully user able to See 'TodayTask ' ");
			//click(TodayTask);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(TodayTask));
			MoveToElementClick(element);
			ExtentSuccessMessage("Successfully user Clicked on 'TodayTask' ");
		}else {
			ExtentErrorMessage("Unsuccessfully user not able to see TodayTask");
		}

		Thread.sleep(10000);
		if(ElementDisplayed(maximize))
		{
			element = wait.until(ExpectedConditions.presenceOfElementLocated(maximize));
			MoveToElementClick(element);
			ExtentSuccessMessage("Clicked on Maximize");
		}
		Thread.sleep(5000);
		ClickOnTasktab();
		ClickOnDeleteTask();
		
		ExtentSuccessMessage("End AG_TS_007_TC_001_Collaborations");
		
		ExtentSuccessMessage("*******************************************************");
		Thread.sleep(8000);
		GotoHomepage1();		
		ExtentSuccessMessage("Started AG_TS_008_TC_001_002_Filter_Validations");
		Filter_Validations();		
		Apply_Filter();
		ExtentSuccessMessage("End AG_TS_008_TC_001_002_Filter_Validations");
		ExtentSuccessMessage("*******************************************************");
		Thread.sleep(8000);
		GOBacktoAgentModule();
		ExtentSuccessMessage("********************************************************");
		ExtentSuccessMessage("Start Advance search Flow");
		ClickOnAdvancesearch();
		waitVisibility(AdvancesearchStatus);
		Thread.sleep(2000);
		SelectActiveDropdown(AdvancesearchStatus,"Active");
		ClickOnApplyadvancedSearchBtn();
		Thread.sleep(2000);
		By Status = By.xpath("(//*[@title='Active'])[1]");
		waitVisibility(Status);
		String status=GetElementText(Status);
		Assert.assertEquals(status, "Active");
		Thread.sleep(2000);
		SelectActiveDropdown(AdvancesearchStatus,"Inactive");
		ClickOnApplyadvancedSearchBtn();
		Thread.sleep(2000);
		By Status1 = By.xpath("(//*[@title='Inactive'])[1]");
		waitVisibility(Status1);
		String status1=GetElementText(Status1);
		Assert.assertEquals(status1, "Inactive");
		ExtentSuccessMessage("END Advance search Flow");
		ExtentSuccessMessage("*******************************************************");
		ExtentSuccessMessage("Start Export Flow");
		ClickOndownlodDataBtn();
		ExtentSuccessMessage("End Export Flow");
		ExtentSuccessMessage("********************************************************");
		
	}
	


	public void ClickOnDeleteTask() throws InterruptedException {
		Thread.sleep(3000);
		if (ElementDisplayed(DeleteTask)) {
			ExtentSuccessMessage("Successfully user able to See 'DeleteTask ' ");
			click(DeleteTask);
			ExtentSuccessMessage("Successfully user Clicked on 'DeleteTask' ");
			waitVisibility(DeleteTaskOK);
			if (ElementDisplayed(DeleteTaskOK)) {
				ExtentSuccessMessage("Successfully user able to See 'DeleteTaskOK ' ");
				click(DeleteTaskOK);
				ExtentSuccessMessage("Successfully user Clicked on 'DeleteTaskOK' ");				
			} else {
				ExtentErrorMessage("Unsuccessfully 'DeleteTaskOK ' Not visible");
			}
			By Successmsg =By.id("divSuccess");
			waitVisibility(Successmsg);
			if(ElementDisplayed(Successmsg)) {
				ExtentSuccessMessage("Successfully user able to See 'Success msg ' ");
				String msg =GetElementText(Successmsg);
				assertEquals(msg, "Task deleted successfully.");
			}else {
				ExtentErrorMessage("Unsuccessfully 'Success msg ' Not visible");
			}
		} else {
			ExtentErrorMessage("Unsuccessfully 'DeleteTask ' Not visible");
		}
	}

	public void ClickOnTasktab() throws InterruptedException {
		Thread.sleep(10000);
		if (ElementDisplayed(Tasktab)) {
			ExtentSuccessMessage("Successfully user able to See 'Tasktab ' ");
			click(Tasktab);
			ExtentSuccessMessage("Successfully user Clicked on 'Tasktab' ");
		} else {
			Thread.sleep(40000);
			System.out.println("Unsuccessfully 'Tasktab ' Not visible");
			waitVisibility(Tasktab);
			if (ElementDisplayed(Tasktab)) {
				ExtentSuccessMessage("Successfully user able to See 'Tasktab ' ");
				click(Tasktab);
				ExtentSuccessMessage("Successfully user Clicked on 'Tasktab' ");
			} else {
				ExtentErrorMessage("Unsuccessfully 'Tasktab ' Not visible");
			}
		}
	}
	
	
	public void ClickOnDashboardMenu() throws InterruptedException {
		Thread.sleep(3000);
		if (ElementDisplayed(DashboardMenu)) {
			ExtentSuccessMessage("Successfully user able to See 'DashboardMenu ' ");
			click(DashboardMenu);
			ExtentSuccessMessage("Successfully user Clicked on 'DashboardMenu' ");
		} else {
			Thread.sleep(3000);
			By menu_bar = By.xpath("//i[@class='fa fa-bars']");
			if (ElementDisplayed(menu_bar)) {
				click(menu_bar);
				ExtentSuccessMessage("Successfully user Clicked on 'Menu bar' ");
			}
			Thread.sleep(3000);
			if (ElementDisplayed(DashboardMenu)) {
				ExtentSuccessMessage("Successfully user able to See 'DashboardMenu ' ");
				click(DashboardMenu);
				ExtentSuccessMessage("Successfully user Clicked on 'DashboardMenu' ");
			} else {
				ExtentErrorMessage("Unsuccessfully 'DashboardMenu ' Not visible");
			}
		}
	}
	
	public void ClickOnsubmenu_MyTasks() throws InterruptedException {
		Thread.sleep(3000);
		if (ElementDisplayed(submenu_MyTasks)) {
			ExtentSuccessMessage("Successfully user able to See 'submenu_MyTasks ' ");
			click(submenu_MyTasks);
			ExtentSuccessMessage("Successfully user Clicked on 'submenu_MyTasks' ");
		} else {
			ExtentErrorMessage("Unsuccessfully 'submenu_MyTasks ' Not visible");
		}
		Thread.sleep(8000);
	}

	
	public void ClickOnSubmitTask() throws InterruptedException {
		Thread.sleep(3000);
		Base_Class.ScrollUntilElementVisible(SubmitTask);
		if (ElementDisplayed(SubmitTask)) {
			ExtentSuccessMessage("Successfully user able to See 'SubmitTask ' ");
			click(SubmitTask);
			ExtentSuccessMessage("Successfully user Clicked on 'SubmitTask' ");
			By Successmsg =By.id("divSuccess");
			waitVisibility(Successmsg);
			if(ElementDisplayed(Successmsg)) {
				ExtentSuccessMessage("Successfully user able to See 'Success msg ' ");
				String msg =GetElementText(Successmsg);
				assertEquals(msg, "Task created successfully.");
			}else {
				ExtentErrorMessage("Unsuccessfully 'Success msg ' Not visible");
			}
		} else {
			ExtentErrorMessage("Unsuccessfully 'SubmitTask ' Not visible");
		}
	}
	public void Filter_Validations() throws InterruptedException
	{
		NavigatetoAgentTab();

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
			By menu_bar = By.xpath("//i[@class='fa fa-bars']");
			Thread.sleep(3000);
			if (ElementDisplayed(menu_bar)) {
				click(menu_bar);
				ExtentSuccessMessage("Successfully user Clicked on 'Menu bar' ");
			}
			Thread.sleep(3000);
			if (ElementDisplayed(L_GotoHomePage1)) {
				ExtentSuccessMessage("Successfully user able to See 'Home page' ");
				click(L_GotoHomePage1);
				ExtentSuccessMessage("Successfully user Clicked on 'Homw Page' ");
			} else {
				ExtentSuccessMessage("Unsuccessfully 'Homw Page' Not visible");
			}
		}
		RefreshPage();
		Thread.sleep(5000);
		ClickOnMinimizeCallwindow();
	}

	public void Validate_folders_tabs_in_agent_detail_page(CensusInfo ApplicantInfo) throws InterruptedException, AWTException {
		NavigatetoAgentTab();		
		//		String Agentname =CreateAgent(ApplicantInfo);
		//		EnterAgentSearchBar(Agentname);
		//		ValidateAgentDetails(Agentname);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Click_Agent));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked the created agent");
		ValidateAgentDetailsTab();
	}

	public void Validate_fields_in_General_information_tab(CensusInfo ApplicantInfo) throws InterruptedException, AWTException {
		NavigatetoAgentTab();		
		String Agentname =CreateAgent(ApplicantInfo);
		EnterAgentSearchBar(Agentname);
		ValidateAgentDetails(Agentname);
		ExtentSuccessMessage("Start_AG_TS_004_TC_002_validate_the_fields_in_General_information_tab");
		Validate_General_Information_Tab_Fields();
		ExtentSuccessMessage("End_AG_TS_004_TC_002_validate_the_fields_in_General_information_tab");
		ExtentSuccessMessage("****************************************************");
		ExtentSuccessMessage("Start_AG_TS_004_TC_001_validate_the_folders_tabs_in_agent_detail_page");
		ValidateAgentDetailsTab();
		ExtentSuccessMessage("END_AG_TS_004_TC_001_validate_the_folders_tabs_in_agent_detail_page");
		ExtentSuccessMessage("****************************************************");
	}

	public void validate_the_fields_in_carrier_appointments_tabs(CensusInfo ApplicantInfo) throws InterruptedException, AWTException {
		NavigatetoAgentTab();		
		String Agentname =CreateAgent(ApplicantInfo);
		EnterAgentSearchBar(Agentname);
		ValidateAgentDetails(Agentname);
		ExtentSuccessMessage("Start AG_TS_004_TC_001_validate_the_folders_tabs_in_agent_detail_page");
		ValidateAgentDetailsTab();
		ExtentSuccessMessage("End AG_TS_004_TC_001_validate_the_folders_tabs_in_agent_detail_page");
		ExtentSuccessMessage("******************************************************************");
		ExtentSuccessMessage("Start AG_TS_006_TC_001_Create_Carrier_Appointment");
		ClickOnCarrierAppointmentsTab();
		Carrier_Appointments();
		ClickOnCarrierAppointmentsTab();
		ExtentSuccessMessage("End AG_TS_006_TC_001_Create_Carrier_Appointment");
		ExtentSuccessMessage("******************************************************************");
		ExtentSuccessMessage("Start AG_TS_004_TC_003_validate_the_fields_in_carrier_appointments_tabs");
		ValidatetheCarrierTabGrid();
		ExtentSuccessMessage("End AG_TS_004_TC_003_validate_the_fields_in_carrier_appointments_tabs");
		ExtentSuccessMessage("*************************************************");
	}

	public void validate_the_fields_in_quotes_tab(CensusInfo ApplicantInfo) throws InterruptedException, AWTException {
		ExtentSuccessMessage("Start_AG_TS_004_TC_006_validate_the_fields_in_quotes_tab");
		NavigatetoAgentTab();		
		String Agentname =CreateAgent(ApplicantInfo);
		EnterAgentSearchBar(Agentname);
		ValidateAgentDetails(Agentname);
		ExtentSuccessMessage("********************************************************");
		ExtentSuccessMessage("Start_AG_TS_004_TC_006_validate_the_fields_in_quotes_tab");
		NavigatetoQuotesTab();
		ValidatetheQuoteTabGrid();
		ExtentSuccessMessage("End_AG_TS_004_TC_006_validate_the_fields_in_quotes_tab");
		ExtentSuccessMessage("********************************************************");
		ExtentSuccessMessage("Start_AG_TS_004_TC_007_validate_the_fields_in_Policys_tab");
		NavigatetoPoliciesTab();
		ValidatethePolicyTabGrid();
		ExtentSuccessMessage("End_AG_TS_004_TC_007_validate_the_fields_in_Policys_tab");
		ExtentSuccessMessage("********************************************************");
	}

	public void validate_the_fields_in_Policys_tab(CensusInfo ApplicantInfo) throws InterruptedException, AWTException {
		NavigatetoAgentTab();		
		String Agentname =CreateAgent(ApplicantInfo);
		EnterAgentSearchBar(Agentname);
		ValidateAgentDetails(Agentname);		
		NavigatetoPoliciesTab();
		ValidatethePolicyTabGrid();
	}



	public void validate_the_click_on_agent_name_State(CensusInfo ApplicantInfo) throws InterruptedException, AWTException {
		NavigatetoAgentTab();
		validateagent();		
	}
	public String CreateAgent(CensusInfo ApplicantInfo) throws InterruptedException, AWTException {
		ClickOnMinimizeCallwindow();
		ClickOnAddAgent();
		String FirstName ="First"+generateRandomText();
		EnterFirstName(FirstName);
		String LastName ="AutomationQA"+generateRandomText();
		EnterLastName(LastName);
		 Fullname = FirstName+" "+LastName;
		String LicenceNo = "76"+generatePhoneNumber();
		EnterLicenceNumber(LicenceNo);
		SelectActiveDropdown(AgencyTypeDropdown,"Agent");

		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentStatus));
		MoveToElementClick(element);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentStatusOption));
		MoveToElementClick(element);
		ExtentSuccessMessage("Agency type has been selected");
		ClickOnAgentcontactinfo();
		String phonenumbe = generatePhoneNumber();
		EnterPhonenumber(phonenumbe);
		EnterEmail(FirstName+LastName+"email@yopmail.com");
		ClickOnAgentsubmitbtn();
		Thread.sleep(3000);	
		System.out.println("Fullname:- "+Fullname);
		return Fullname;
	}

	public void ValidatetheGrid() throws InterruptedException {
		String Values = ("Name,Agency Type,Agent Type,Company Name,Cell Phone,Email,State,Status");
		String[] ExpectedColnumname =Values.split(",");
		for(int i=0;i<=7;i++) {
			int j = i+1;
			Thread.sleep(2000);
			By Elements =By.xpath("(//*[@role='columnheader']//*[@ui-grid-one-bind-id-grid=\"col.uid + '-header-text'\"])["+j+"]");
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
				System.out.println("Actual Column Name: " + ActualColunmName);
				System.out.println("ActualColunmName"+j+""+ActualColunmName);
				Assert.assertEquals(ExpectedColnumname[i], ActualColunmName);
				ExtentSuccessMessage("Successfully user found the expected Colunm name:- Expected "+ExpectedColnumname[i]+" Actual "+ActualColunmName+"");
			}


		}

	}

	public void ValidatetheCarrierTabGrid() throws InterruptedException {
		String Values = ("Carrier Name,State,Product Category/Business Segment,Start Date,Status,Action");
		String[] ExpectedColnumname =Values.split(",");
		for(int i=0;i<=5;i++) {
			int j = i+1;
			Thread.sleep(2000);
			By Elements =By.xpath("(//*[@role='columnheader']//*[@ui-grid-one-bind-id-grid=\"col.uid + '-header-text'\"])["+j+"]");
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
				System.out.println("Actual Column Name: " + ActualColunmName);
				System.out.println("ActualColunmName"+j+""+ActualColunmName);
				Assert.assertEquals(ExpectedColnumname[i], ActualColunmName);
				ExtentSuccessMessage("Successfully user found the expected Colunm name:- Expected "+ExpectedColnumname[i]+" Actual "+ActualColunmName+"");
			}


		}

	}
	public void ValidatetheQuoteTabGrid() throws InterruptedException {
		String Values = ("Quote ID,Created Date,Product Category,Status,Phone,Email");
		String[] ExpectedColnumname =Values.split(",");
		for(int i=0;i<=5;i++) {
			int j = i+1;
			//			Thread.sleep(2000);
			By Elements =By.xpath("(//*[@role='columnheader']//*[@ui-grid-one-bind-id-grid=\"col.uid + '-header-text'\"])["+j+"]");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Elements));
			String ActualColunmName =element.getText();
			if (ActualColunmName.isBlank()) {
				System.out.println("Actual Column Name is blank.");
				Base_Class.ScrollUntilElementVisible(Elements);
				element = wait.until(ExpectedConditions.presenceOfElementLocated(Elements));
				//				Thread.sleep(3000);
				String ColunmName =element.getText();
				Assert.assertEquals(ExpectedColnumname[i], ColunmName);
				ExtentSuccessMessage("Successfully user found the expected Colunm name:- Expected "+ExpectedColnumname[i]+" Actual "+ColunmName+"");
			} else {
				System.out.println("Actual Column Name: " + ActualColunmName);
				System.out.println("ActualColunmName"+j+""+ActualColunmName);
				Assert.assertEquals(ExpectedColnumname[i], ActualColunmName);
				ExtentSuccessMessage("Successfully user found the expected Colunm name:- Expected "+ExpectedColnumname[i]+" Actual "+ActualColunmName+"");
			}
		}
	}
	public void ValidatethePolicyTabGrid() throws InterruptedException {
		String Values = ("Policy ID,Applicant,Created Date,Product Category,Status,Phone,Email");
		String[] ExpectedColnumname =Values.split(",");
		for(int i=0;i<=5;i++) {
			int j = i+1;
			//			Thread.sleep(2000);
			By Elements =By.xpath("(//*[@role='columnheader']//*[@ui-grid-one-bind-id-grid=\"col.uid + '-header-text'\"])["+j+"]");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Elements));
			String ActualColunmName =element.getText();
			if (ActualColunmName.isBlank()) {
				System.out.println("Actual Column Name is blank.");
				Base_Class.ScrollUntilElementVisible(Elements);
				element = wait.until(ExpectedConditions.presenceOfElementLocated(Elements));
				//				Thread.sleep(3000);
				String ColunmName =element.getText();
				Assert.assertEquals(ExpectedColnumname[i], ColunmName);
				ExtentSuccessMessage("Successfully user found the expected Colunm name:- Expected "+ExpectedColnumname[i]+" Actual "+ColunmName+"");
			} else {
				System.out.println("Actual Column Name: " + ActualColunmName);
				System.out.println("ActualColunmName"+j+""+ActualColunmName);
				Assert.assertEquals(ExpectedColnumname[i], ActualColunmName);
				ExtentSuccessMessage("Successfully user found the expected Colunm name:- Expected "+ExpectedColnumname[i]+" Actual "+ActualColunmName+"");
			}
		}
	}


	public void EnterFirstName(String value) throws InterruptedException {		
		//		if (ElementDisplayed(FirstName)) {
		//			ExtentSuccessMessage("Successfully user able to See 'FirstName ' ");
		writeText(FirstName,value+Keys.ENTER);
		ExtentSuccessMessage("Successfully user entered the 'FirstName in text field' "+value);
		//		} else {
		//			ExtentErrorMessage("Unsuccessfully 'FirstName' Not visible");
		//		}
	}
	public void EnterLastName(String value) throws InterruptedException {		
		if (ElementDisplayed(LastName)) {
			ExtentSuccessMessage("Successfully user able to See 'LastName ' ");
			writeText(LastName,value+Keys.ENTER);
			ExtentSuccessMessage("Successfully user entered the 'LastName in text field' "+value);
		} else {
			ExtentErrorMessage("Unsuccessfully 'LastName' Not visible");
		}
	}

	public void EnterLicenceNumber(String value) throws InterruptedException {		
		if (ElementDisplayed(LicenceNumber)) {
			ExtentSuccessMessage("Successfully user able to See 'LicenceNumber ' ");
			writeText(LicenceNumber,value);
			ExtentSuccessMessage("Successfully user entered the 'LicenceNumber in text field' "+value);
		} else {
			ExtentErrorMessage("Unsuccessfully 'LicenceNumber' Not visible");
		}
	}
	public void EnterPhonenumber(String value) throws InterruptedException {		
		if (ElementDisplayed(Phonenumber)) {
			ExtentSuccessMessage("Successfully user able to See 'Phonenumber ' ");
			writeText(Phonenumber,value);
			ExtentSuccessMessage("Successfully user entered the 'Phonenumber in text field' "+value);
		} else {
			ExtentErrorMessage("Unsuccessfully 'Phonenumber' Not visible");
		}
	}
	public void EnterEmail(String value) throws InterruptedException {		
		if (ElementDisplayed(Email)) {
			ExtentSuccessMessage("Successfully user able to See 'Email ' ");
			writeText(Email,value);
			ExtentSuccessMessage("Successfully user entered the 'Email in text field' "+value);
		} else {
			ExtentErrorMessage("Unsuccessfully 'Email' Not visible");
		}
	}
	public void EnterAgentSearchBar(String value) throws InterruptedException {		
		Thread.sleep(5000);
		if (ElementDisplayed(AgentSearchBar)) {
			ExtentSuccessMessage("Successfully user able to See 'AgentSearchBar ' ");
			//			clear(AgentSearchBar);
			writeText(AgentSearchBar,value+Keys.ENTER);
			ExtentSuccessMessage("Successfully user entered the 'AgentSearchBar in text field' "+value);
		} else {
			ExtentErrorMessage("Unsuccessfully 'AgentSearchBar' Not visible");
		}
	}
	public void EnterAgentLicencenumberfield(String value) throws InterruptedException {
		Thread.sleep(3000);
		waitVisibility(AgentLicencenumberfield);
		if (ElementDisplayed(AgentLicencenumberfield)) {
			ExtentSuccessMessage("Successfully user able to See 'AgentLicencenumberfield ' ");
			clear(AgentLicencenumberfield);
			writeText(AgentLicencenumberfield,value);
			ExtentSuccessMessage("Successfully user entered the 'AgentLicencenumberfield in text field' "+value);
		} else {
			ExtentErrorMessage("Unsuccessfully 'AgentLicencenumberfield' Not visible");
		}
	}


	public String FetchFirstAgentnamefromgrid() throws InterruptedException {
		//		Thread.sleep(15000);
		By Elements = By.xpath("(//*[contains(@ng-click,'agentDetails(row.entity)')])[1]");
		//		Thread.sleep(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Elements));
		String agentname =element.getAttribute("title");
		System.out.println("Agent name :- "+agentname);
		return agentname;
	}
	public String FetchAgentLicenceNumber() throws InterruptedException {
		//		Thread.sleep(8000);		
		//		Thread.sleep(3000);
		//		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentLicenceNumber));
		WebDriverWait wait2=new WebDriverWait(driver, Duration.ofMinutes(1));
		wait2.until(ExpectedConditions.presenceOfElementLocated(AgentLicenceNumber));
		//		String AgentLicenceNumber =element.getText();
		String AgentLicenceNumbers =GetElementText(AgentLicenceNumber);
		System.out.println("Agent Licence Number :- "+AgentLicenceNumbers);
		return AgentLicenceNumbers;
	}

	public String FetchInvalidMessage() throws InterruptedException {
		String InvalidMessages =GetElementText(InvalidMessage);
		System.out.println("InvalidMessage :- "+InvalidMessages);
		ExtentSuccessMessage("InvalidMessage :- "+InvalidMessages);
		return InvalidMessages;
	}


	public void validateagent() throws InterruptedException {
		//		Thread.sleep(8000);
		By Elements = By.xpath("(//*[contains(@ng-click,'agentDetails(row.entity)')])[1]");
		//		Thread.sleep(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Elements));
		String rns =element.getAttribute("title");
		System.out.println("rns :- "+rns);
		if(ElementDisplayed(Elements)) {
			click(Elements);
			//			Thread.sleep(10000);
			//			By nameelement=By.xpath("//*[text()='Agent Name:']//parent::span//span");
			String Validatename=GetElementText(nameelement);
			System.out.println("Validatename :- "+Validatename);
			Assert.assertEquals(rns, Validatename);
		}else {
			System.out.println();
		}

	}
	public void ValidateAgentDetails(String Value) throws InterruptedException {
		//		Thread.sleep(5000);

		By Elements = By.xpath("(//*[contains(@ng-click,'agentDetails(row.entity)')])[1]");
		waitVisibility(Elements);
		if(ElementDisplayed(Elements)) {
			click(Elements);
			Thread.sleep(5000);			
			String Validatename=GetElementText(nameelement);
			System.out.println("Validatename :- "+Validatename);
			Assert.assertEquals(Value, Validatename);
			ExtentSuccessMessage("Successfully Assert pass validate the agent name acctual "+Validatename+" As Expected "+Value+"");
		}else {
			ExtentErrorMessage("Unsuccessfully record not found agent not available.");
		}
		WaitUntillPAgeLoad();
	}
	public void ValidateAgentDetailsTab() throws InterruptedException {
		Thread.sleep(2000);
		String Values = ("General Information,Licenses,Carrier Appointments,Customer,Commissions,Change Log,Quotes,Policies");
		String[] ExpectedColnumname =Values.split(",");
		for(int i=0;i<=7;i++) {
			int j = i+1;
			//			Thread.sleep(2000);
			By Elements =By.xpath("(//*[contains(@ng-repeat,'tab in detailsFolder')]//a[@class='ng-binding'])["+j+"]");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Elements));
			String ActualColunmName =element.getText();
			System.out.println("From application:-"+ActualColunmName);
			if (ActualColunmName.isBlank()) {
				System.out.println("Actual Column Name is blank.");
				//click(MoreTab);
				Thread.sleep(3000);
				element = wait.until(ExpectedConditions.presenceOfElementLocated(MoreTab));
				MoveToElementClick(element);
				element = wait.until(ExpectedConditions.presenceOfElementLocated(Elements));
				String ColunmName =element.getText();
				System.out.println("From application2:-"+ColunmName);
				Assert.assertEquals(ExpectedColnumname[i], ColunmName);
				ExtentSuccessMessage("Successfully user found the expected Colunm name:- Expected "+ExpectedColnumname[i]+" Actual "+ColunmName+"");
			} else {
				System.out.println("Actual Column Name:" + ActualColunmName);
				System.out.println("ActualColunmName"+j+""+ActualColunmName);
				Assert.assertEquals(ExpectedColnumname[i], ActualColunmName);
				ExtentSuccessMessage("Successfully user found the expected Colunm name:- Expected "+ExpectedColnumname[i]+" Actual "+ActualColunmName+"");
			}

		}

	}
	public void Debug() throws InterruptedException {
		String ActualColunmName=null;	
		for(int i=0;i<=6;i++) {
			int j = i+1;
			//			Thread.sleep(2000);
			//			By Elements =By.xpath("(//*[@role='columnheader']//*[@ui-grid-one-bind-id-grid=\"col.uid + '-header-text'\"])["+j+"]");
			By Elements =By.xpath("(//*[@role='columnheader']//*[@ui-grid-one-bind-id-grid=\"col.uid + '-header-text'\"])["+j+"]");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Elements));
			ActualColunmName =ActualColunmName+","+element.getText();
			System.out.println("From application:-"+ActualColunmName);
		}
	}
	public void Validate_General_Information_Tab_Fields() throws InterruptedException {
		String Values = ("Agent Name:,Agency Type:,Agent Type:,Company Name:,Gender:,Phone:,Email:,Fax:,Company Phone:,Company Phone Ext:,License Number:,NPN:,Status:,User Profile:,Address Of Correspondence:");
		String[] ExpectedFieldname =Values.split(",");
		for(int i=0;i<=14;i++) {
			int j = i+1;
			Thread.sleep(1000);
			By Elements =By.xpath("(//*[@ng-repeat='fieldVal in fieldTupleVal']//label[@aria-hidden='false'])["+j+"]");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Elements));
			String ActualFieldName =element.getText();
			System.out.println("From application:-"+ActualFieldName);
			System.out.println("ExpectedColnumname:"+j+"" + ExpectedFieldname[i]);
			System.out.println("ActualColunmName"+j+""+ActualFieldName);
			Assert.assertEquals(ExpectedFieldname[i], ActualFieldName);
			ExtentSuccessMessage("Successfully user found the expected Field name:- Expected "+ExpectedFieldname[i]+" Actual Field name"+ActualFieldName+"");
			By xpaths = By.xpath("//*[contains(text(),'"+ActualFieldName+"')]");
			if (ElementDisplayed(xpaths)) {
				ExtentSuccessMessage("Successfully user able to See '"+ActualFieldName+" Field ' ");
			} else {
				Base_Class.ScrollUntilElementVisible(xpaths);
				if (ElementDisplayed(xpaths)) {
					ExtentSuccessMessage("Successfully user able to See '"+ActualFieldName+" Field ' ");
				} else {
					ExtentErrorMessage("Unsuccessfully '"+ActualFieldName+" Field ' Not visible");
				}
				
			}
		}
	}

	public void Carrier_Appointments() throws InterruptedException
	{


		element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierAgentAppointmentButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Appointment Button has been clicked");


		element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierAgentNameDD));
		MoveToElementClick(element);


		element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierAgentNameOption));
		CarrierAgentNameOptionvalue =element.getAttribute("value");
		System.out.println("CarrierAgentNameOptionvalue:-"+CarrierAgentNameOptionvalue);
		MoveToElementClick(element);
		ExtentSuccessMessage("Agent name has been selected");


		By CarrierStateDD  = By.xpath("//md-select[@name='State']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierStateDD));
		MoveToElementClick(element);


		element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierStateDDOption));
		CarrierStateDDOptionvalue =GetElementText(CarrierStateDDOption);
		 System.out.println("CarrierStateDDOptionvalue:-"+CarrierStateDDOptionvalue);
		MoveToElementClick(element);
		
		ExtentSuccessMessage("State has been clicked");
		

		Thread.sleep(2000);
		 Currentdate=Currentdate();
		 System.out.println("Currentdate:-"+Currentdate);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierAppoinmentstartdate));
		writeText(CarrierAppoinmentstartdate,Currentdate+Keys.ENTER);
		ExtentSuccessMessage("Agent has been clicked");
		Thread.sleep(2000);


		element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierAgentStatusDD));
		MoveToElementClick(element);



		element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierAgentStatusOption));
		CarrierAgentStatusOptionvalue ="Active";
		System.out.println("CarrierAgentStatusOptionvalue:-"+CarrierAgentStatusOptionvalue);
		MoveToElementClick(element);
		ExtentSuccessMessage("Agent has been clicked");


		Assert.assertTrue(driver.findElement(AppointmentCarrierSubmitButton).isEnabled());
		ExtentSuccessMessage("Assertion has been done");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AppointmentCarrierSubmitButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Submit Button has been clicked");
		String msg =GetElementText(Success_Message);
		
		
		
		
		ClickOnCarrierAppointmentsTab();
		ExtentSuccessMessage("End AG_TS_006_TC_001_Create_Carrier_Appointment");
		ExtentSuccessMessage("******************************************************************");
		ExtentSuccessMessage("Start AG_TS_004_TC_003_validate_the_fields_in_carrier_appointments_tabs");
		ValidatetheCarrierTabGrid();
		ExtentSuccessMessage("End AG_TS_004_TC_003_validate_the_fields_in_carrier_appointments_tabs");
		ExtentSuccessMessage("*************************************************");
		String Value=(CarrierAgentNameOptionvalue+";"+CarrierStateDDOptionvalue+";"+"All"+";"+Currentdate+";"+CarrierAgentStatusOptionvalue);
		ValidateGrid(Value);
		ClickOnEditButton();
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierAgentStatusDD));
		MoveToElementClick(element);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierAgentStatusOption1));
		MoveToElementClick(element);
		CarrierAgentStatusOptionvalue1 ="Terminated";
		System.out.println("CarrierAgentStatusOptionvalue:-"+CarrierAgentStatusOptionvalue1);
		ClickOnSaveAppointmenteditbtn1();
		ClickOnCarrierAppointmentsTab();
		String Value1=(CarrierAgentNameOptionvalue+";"+CarrierStateDDOptionvalue+";"+"All,Accident,Accidental Insurance,Cancer/Critical Illness,Commercial LG,Commercial SG,Critical Illness,Dental,Final Expense,Hospital Indemnity,Life,Medicaid,Medical,Medicare Advantage,Medicare-Supplement,Other Ancillary – accident and disability,Pocket protector plan,Prescription Part D,Short Term Medical,Supplemental Health,Term Life,Term Life With Critical Illness,Vision"+";"+Currentdate+";"+CarrierAgentStatusOptionvalue1);
		ValidateGrid(Value1);
		ExtentSuccessMessage("*************************************************");
		ExtentSuccessMessage("Start Change Logs Tab Validation");
		ClickOnChangelogsTab();
		String ChangelogsValue=("Carrier Appointment Updated"+";"+"Updated"+";"+CarrierAgentNameOptionvalue+";"+CurretDate+";"+LoginUsername);
		ValidateGrid(ChangelogsValue);
		String ChangelogsValue1=("Carrier Appointment Created"+";"+"Created"+";"+CarrierAgentNameOptionvalue+";"+CurretDate+";"+LoginUsername);
		ValidateGrid1(ChangelogsValue1);
		ExtentSuccessMessage("END Change Logs Tab Validation");
		ExtentSuccessMessage("*************************************************");


	}

	public void waitForElement(int time) throws InterruptedException {
		Thread.sleep(time);
	}

	public void ClickOnCarrierAppointmentsTab() throws InterruptedException {
		Thread.sleep(9000);
		waitVisibility(CarrierAppointments);
		if (ElementDisplayed(CarrierAppointments)) {
			ExtentSuccessMessage("Successfully user able to See 'CarrierAppointments ' ");
			click(CarrierAppointments);
			ExtentSuccessMessage("Successfully user Clicked on 'CarrierAppointments' ");
			Thread.sleep(5000);
		} else {
			ExtentErrorMessage("Unsuccessfully 'CarrierAppointments ' Not visible");
		}
	}
	
	public void ClickOnChangelogsTab() throws InterruptedException {
		Thread.sleep(9000);
		waitVisibility(ChangelogsTab);
		if (ElementDisplayed(ChangelogsTab)) {
			ExtentSuccessMessage("Successfully user able to See 'ChangelogsTab ' ");
			click(ChangelogsTab);
			ExtentSuccessMessage("Successfully user Clicked on 'ChangelogsTab' ");
			Thread.sleep(5000);
		} else {
			ExtentErrorMessage("Unsuccessfully 'ChangelogsTab ' Not visible");
		}
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

		element = wait.until(ExpectedConditions.presenceOfElementLocated(StateDD));
		MoveToElementClick(element);


		element = wait.until(ExpectedConditions.presenceOfElementLocated(DDValue));
		LicenseStates = GetElementText(DDValue);
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
		LicenseStatus = GetElementText(StatusDDOption);
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

	public void license_Fields_Validation() throws InterruptedException	{
		CurretDate =Currentdate();
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
		ExtentSuccessMessage("Validated ID data");
//		By More = By.xpath("(//i[@aria-label='Grid Menu'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(More));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clciked on more options");
		
		String Value=(LicenseStates+";"+"All"+";"+Iss_Date+";"+LicenseExpiryDate+";"+LicenseStatus);
		ValidateGrid(Value);
		
		ClickOnEditButton();
		element = wait.until(ExpectedConditions.presenceOfElementLocated(StateDD));
		MoveToElementClick(element);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(DDValue1));
		LicenseStates1 = GetElementText(DDValue1);
		MoveToElementClick(element);
		ExtentSuccessMessage("State has been selected");
		System.out.println("LicenseStates1:-"+LicenseStates1);
		ClickOnSaveAppointmenteditbtn();
		click(License_Tab);
		String Value1=(LicenseStates1+";"+"All,Accident,Accidental Insurance,Cancer/Critical Illness,Commercial LG,Commercial SG,Critical Illness,Dental,Final Expense,Hospital Indemnity,Life,Medicaid,Medical,Medicare Advantage,Medicare-Supplement,Other Ancillary – accident and disability,Pocket protector plan,Prescription Part D,Short Term Medical,Supplemental Health,Term Life,Term Life With Critical Illness,Vision"+";"+Iss_Date+";"+LicenseExpiryDate+";"+LicenseStatus);
		ValidateGrid(Value1);
		ExtentSuccessMessage("*************************************************");
		ExtentSuccessMessage("Start Change logs Tab validation");
		ClickOnChangelogsTab();
		System.out.println("CurretDate:-"+CurretDate);
		String ChangelogsValue=("License Updated"+";"+"Updated"+";"+""+";"+CurretDate+";"+LoginUsername);
		ValidateGrid(ChangelogsValue);
		String ChangelogsValue1=("License Created"+";"+"Created"+";"+""+";"+CurretDate+";"+LoginUsername);
		ValidateGrid1(ChangelogsValue1);
		ExtentSuccessMessage("End Change logs Tab validation");
		ExtentSuccessMessage("*************************************************");

	}

	public void ValidateGrid(String Values) throws InterruptedException {
		String[] ExpectedColnumname =Values.split(";");
		int ValuesSize =ExpectedColnumname.length;
		System.out.println("ValuesSize:-"+ValuesSize);
		for(int i=1;i<=5;i++) {
			int j=i-1;
			System.out.println("i:-"+i);
			System.out.println("j:-"+j);
			Thread.sleep(2000);
			By Elements =By.xpath("(//*[@role='row'][@ui-grid-row='row']//*[@role='gridcell']//div)["+i+"]");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Elements));
			String ActualColunmName =element.getText();
			if(ActualColunmName.contains("All")) {
				ExtentSuccessMessage("Successfully user found the expected Colunm Value:- Expected:-  "+"All"+" Actual:-  "+"All"+"");
			}else {

			System.out.println("Debug:-"+ActualColunmName);
			System.out.println("ExpectedColnumname: " + ExpectedColnumname[j]);
			Assert.assertEquals(ActualColunmName,ExpectedColnumname[j]);
			ExtentSuccessMessage("Successfully user found the expected Colunm name:- Expected:-  "+ExpectedColnumname[j]+" Actual:-  "+ActualColunmName+"");
		}
		}
	}
	
	public void ValidateGrid1(String Values) throws InterruptedException {
		String[] ExpectedColnumname =Values.split(";");
		int ValuesSize =ExpectedColnumname.length;
		System.out.println("ValuesSize:-"+ValuesSize);
		for(int i=1;i<=10;i++) {
			int j=i-6;
			System.out.println("i:-"+i);
			System.out.println("j:-"+j);
			if(i<6) {
//				System.out.println("Debug"+i);
			}else  {
			Thread.sleep(2000);
			By Elements =By.xpath("(//*[@role='row'][@ui-grid-row='row']//*[@role='gridcell']//div)["+i+"]");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Elements));
			String ActualColunmName =element.getText();

			System.out.println("Debug:-"+ActualColunmName);
			System.out.println("ExpectedColnumname: " + ExpectedColnumname[j]);
			Assert.assertEquals(ActualColunmName,ExpectedColnumname[j]);
			ExtentSuccessMessage("Successfully user found the expected Colunm name:- Expected:-  "+ExpectedColnumname[j]+" Actual:-  "+ActualColunmName+"");
		}
		}
	}

	
	public void ClickOnAdvancesearch() throws InterruptedException {
		Thread.sleep(5000);
		waitVisibility(Advancesearch);
		if (ElementDisplayed(Advancesearch)) {
			ExtentSuccessMessage("Successfully user able to See 'Advance search Button' ");
			click(Advancesearch);
			ExtentSuccessMessage("Successfully user Clicked on 'Advance search Button' ");
			waitVisibility(ApplyadvancedSearchBtn);
		} else {
			ExtentSuccessMessage("Unsuccessfully 'Advance search Button' Not visible");
		}
	}
	public void ClickOnApplyadvancedSearchBtn() throws InterruptedException {
		Thread.sleep(5000);
		if (ElementDisplayed(ApplyadvancedSearchBtn)) {
			ExtentSuccessMessage("Successfully user able to See 'Applyed Advance search Button' ");
			click(ApplyadvancedSearchBtn);
			ExtentSuccessMessage("Successfully user Clicked on 'Applyed Advance search Button' ");
		} else {
			ExtentSuccessMessage("Unsuccessfully 'Applyed Advance search Button' Not visible");
		}
	}
	
	public void ClickOndownlodDataBtn() throws InterruptedException {
		if (ElementDisplayed(downlodDataBtn)) {
			ExtentSuccessMessage("Successfully user able to See 'downlodData Button' ");
			click(downlodDataBtn);
			ExtentSuccessMessage("Successfully user Clicked on 'downlodData Button' ");
//			Thread.sleep(5000);
			String msg =GetElementText(Success_Message);
			Assert.assertEquals(msg, "The file will be downloaded shortly.");
			
		} else {
			ExtentSuccessMessage("Unsuccessfully 'downlodData Button' Not visible");
		}
	}
	

}
