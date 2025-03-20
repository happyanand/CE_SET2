package com.test;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePackage.Base_Class;
import com.Utility.Log;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;
import com.pages.CensusInfo;

import Common.TriggerEmail;

public class AllScenarios_EG_TC extends Base_Class {
	TestListener TestListener;
	Base_Class Base_Class;
	//	public static com.pages.HomePage homepage;
	// HomePage homepage;
	Log log;
	com.Utility.ScreenShot screenShot;
	com.Utility.ExcelReader ExcelReader;

	// NavigateNewClaim NewClaim = new NavigateNewClaim();
	@Override
	public WebDriver getDriver() {
		//		homepage = new com.pages.HomePage(driver);
		return driver;
	}
	CAM_TS_001_TC_001_TC_002_TC_003_TC_004_TC_006_TC_007_TC_008_TC_009_TC_010 CAM_TS_001_TC_001_TC_002_TC_003_TC_004_TC_006_TC_007_TC_008_TC_009_TC_010;
	CM_TS_002_TC_001_TC_003_verify_the_Commission_set_up_Commission_method_Any_And_PMPM CM_TS_002_TC_001_TC_003_verify_the_Commission_set_up_Commission_method_Any_And_PMPM;
	SCM_TS_001_TC_001_TC_002_TC_004_TC_005_TC_006_TC_010_Create_Duplicate_Download_Edit_Delete_Clone SCM_TS_001_TC_001_TC_002_TC_004_TC_005_TC_006_TC_010_Create_Duplicate_Download_Edit_Delete_Clone;
	CM_TS_001_TC_004_search_the_criterias_based_on_the_selected_fields CM_TS_001_TC_004_search_the_criterias_based_on_the_selected_fields;
	CM_TS_001_TC_005_validate_user_edit__the_existing_criterias CM_TS_001_TC_005_validate_user_edit__the_existing_criterias;
	CM_TS_004_TC_001_002_Import_Commission_Criteria CM_TS_004_TC_001_002_Import_Commission_Criteria;
	CM_TS_004_TC_008_validate_imported_criteria_commission_method_as_PPPY CM_TS_004_TC_008_validate_imported_criteria_commission_method_as_PPPY;
	CM_TS_004_TC_007_validate_imported_criteria_commission_method_as_PPPM CM_TS_004_TC_007_validate_imported_criteria_commission_method_as_PPPM;
	CM_TS_001_TC_007_validate_user_clear_the_newly_entered_criterias CM_TS_001_TC_007_validate_user_clear_the_newly_entered_criterias;
	CM_TS_001_TC_008_validate_the_recalculate_functionality CM_TS_001_TC_008_validate_the_recalculate_functionality;
	CM_TS_001_TC_008_TS_002_TC_001_TC_002_TC_003_TC_005_TC_006_Validate_recalculate_Commission_set_up_with_the_following_options CM_TS_001_TC_008_TS_002_TC_001_TC_002_TC_003_TC_005_TC_006_Validate_recalculate_Commission_set_up_with_the_following_options;
	CM_TS_001_TC_001_TC_004_TC_005_TC_007_Validate_Create_Search_Edit_Clear CM_TS_001_TC_001_TC_004_TC_005_TC_007_Validate_Create_Search_Edit_Clear;
	CM_TS_004_TC_006_validate_imported_criteria_commission_method_as_PMPY CM_TS_004_TC_006_validate_imported_criteria_commission_method_as_PMPY;
	CM_TS_004_TC_003_004_005_Import_criteria_Percentage_PMPM_PCPM CM_TS_004_TC_003_004_005_Import_criteria_Percentage_PMPM_PCPM;
	CM_TS_004_TC_001_TC_002_TC004_verify_the_imported_criteria_of_Commission_set_up_Commission_method_Any_And_PMPM CM_TS_004_TC_001_TC_002_TC004_verify_the_imported_criteria_of_Commission_set_up_Commission_method_Any_And_PMPM;

	////Agent Module ////

	AG_TS_001_TC_001_Navigate_To_Agent_Screen AG_TS_001_TC_001_Navigate_To_Agent_Screen;	
	AG_TS_001_TC_002_validate_the_fields_in_agent_grid_page AG_TS_001_TC_002_validate_the_fields_in_agent_grid_page;	
	AG_TS_001_TC_003_validate_the_click_on_agent_name_State AG_TS_001_TC_003_validate_the_click_on_agent_name_State;
	AG_TS_001_TC_004_validate_the_existing_agents_AOR_displayed_on_agent_grid AG_TS_001_TC_004_validate_the_existing_agents_AOR_displayed_on_agent_grid;
	AGTS001TC001TC002TC003TC004TC005TS005TC001TS004TC001TS004TC003TS006TC001CreateEditStateLicenseCarrierAppointmentGeneralinformationtab AGTS001TC001TC002TC003TC004TC005TS005TC001TS004TC001TS004TC003TS006TC001CreateEditStateLicenseCarrierAppointmentGeneralinformationtab;
	AG_TS_001_TC_006_validate_the_updating_without_entering_mandatory_fields_entering_invalid_details AG_TS_001_TC_006_validate_the_updating_without_entering_mandatory_fields_entering_invalid_details;


	//AG_TS_002_TC_001_create_a_new_agent_or_salesman AG_TS_002_TC_001_create_a_new_agent_or_salesman;
	AG_TS_005_TC_001_TS_004_TC_004_Create_Validate_State_Licenses AG_TS_005_TC_001_TS_004_TC_004_Create_Validate_State_Licenses;
	AG_TS_005_TC_001_Create_State_License AG_TS_005_TC_001_Create_State_License;
	AG_TS_004_TC_003_TS_004_TC_001_TS_006_TC_001_Agent_details_page_Create_Validation_Carrier_Appointment_Tab AG_TS_004_TC_003_TS_004_TC_001_TS_006_TC_001_Agent_details_page_Create_Validation_Carrier_Appointment_Tab;
	AG_TS_007_TC_001_Collaborations_TS_008_TC_001_Filter_Validations AG_TS_007_TC_001_Collaborations_TS_008_TC_001_Filter_Validations;
	AG_TS_008_TC_001_002_Filter_Validations AG_TS_008_TC_001_002_Filter_Validations;

	AGTS002TC001TS004TC006TS004TC007TS007TC001TS008TC001TC002createsalesmanfieldsinquotes_policystabCollaborationsFilterAdvanceSearch AGTS002TC001TS004TC006TS004TC007TS007TC001TS008TC001TC002createsalesmanfieldsinquotes_policystabCollaborationsFilterAdvanceSearch;
	AG_TS_004_TC_001_validate_the_folders_tabs_in_agent_detail_page AG_TS_004_TC_001_validate_the_folders_tabs_in_agent_detail_page;
	AG_TS_004_TC001_TC_002_Validate_The_Folder_Tab_fields_in_General_information_tab AG_TS_004_TC001_TC_002_Validate_The_Folder_Tab_fields_in_General_information_tab;
	AG_TS_004_TC_003_validate_the_fields_in_carrier_appointments_tabs AG_TS_004_TC_003_validate_the_fields_in_carrier_appointments_tabs;
	AG_TS_004_TC_006_TC_007_validate_the_fields_in_quotes_tab_Policys_tab AG_TS_004_TC_006_TC_007_validate_the_fields_in_quotes_tab_Policys_tab;
	AG_TS_004_TC_007_validate_the_fields_in_Policys_tab AG_TS_004_TC_007_validate_the_fields_in_Policys_tab;

	
	
	///////Service module///////

	TC_CE_059_060_061_ServiceRequest_Activity_Actions TC_CE_059_060_061_ServiceRequest_Activity_Actions;
	TC_CE_062_063_064_065_ServiceFilter_AdvanceSearch_Export_ClosingRequest TC_CE_062_063_064_065_ServiceFilter_AdvanceSearch_Export_ClosingRequest;
	
	
	

	// private static By L_Logout =
	// By.xpath("//body/div[@id='banner']/div[@id='rightMenu']/ul[1]/li[3]/i[1]");
	By signInButtonClass = By.className("btnSignIn");
	By signout = By.xpath("//a[@class=\"dropdownMenu user-details-menuSection dropdownArrowMenu\"]");
	By signoutbtn = By.xpath("//*[@id='dropdownMenuListSec']//a[contains(text(),'Sign Out')]");
	By signoutInshura = By.xpath("//div[@class=\"signoutsec\"]");

	@BeforeSuite
	public void reference() {
		ExcelReader = new com.Utility.ExcelReader("PLCA");
		log = new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);
		Base_Class = new Base_Class();





		CM_TS_004_TC_001_TC_002_TC004_verify_the_imported_criteria_of_Commission_set_up_Commission_method_Any_And_PMPM = new CM_TS_004_TC_001_TC_002_TC004_verify_the_imported_criteria_of_Commission_set_up_Commission_method_Any_And_PMPM();
		SCM_TS_001_TC_001_TC_002_TC_004_TC_005_TC_006_TC_010_Create_Duplicate_Download_Edit_Delete_Clone = new SCM_TS_001_TC_001_TC_002_TC_004_TC_005_TC_006_TC_010_Create_Duplicate_Download_Edit_Delete_Clone();
		CM_TS_001_TC_004_search_the_criterias_based_on_the_selected_fields =new CM_TS_001_TC_004_search_the_criterias_based_on_the_selected_fields();
		CM_TS_001_TC_005_validate_user_edit__the_existing_criterias =new CM_TS_001_TC_005_validate_user_edit__the_existing_criterias();
		CM_TS_004_TC_001_002_Import_Commission_Criteria = new CM_TS_004_TC_001_002_Import_Commission_Criteria();
		CM_TS_001_TC_007_validate_user_clear_the_newly_entered_criterias = new CM_TS_001_TC_007_validate_user_clear_the_newly_entered_criterias();	
		CM_TS_001_TC_008_validate_the_recalculate_functionality =new CM_TS_001_TC_008_validate_the_recalculate_functionality();
		CM_TS_001_TC_008_TS_002_TC_001_TC_002_TC_003_TC_005_TC_006_Validate_recalculate_Commission_set_up_with_the_following_options =new CM_TS_001_TC_008_TS_002_TC_001_TC_002_TC_003_TC_005_TC_006_Validate_recalculate_Commission_set_up_with_the_following_options();
		CM_TS_004_TC_006_validate_imported_criteria_commission_method_as_PMPY =new CM_TS_004_TC_006_validate_imported_criteria_commission_method_as_PMPY();
		CM_TS_001_TC_001_TC_004_TC_005_TC_007_Validate_Create_Search_Edit_Clear = new CM_TS_001_TC_001_TC_004_TC_005_TC_007_Validate_Create_Search_Edit_Clear();
		CM_TS_004_TC_007_validate_imported_criteria_commission_method_as_PPPM = new CM_TS_004_TC_007_validate_imported_criteria_commission_method_as_PPPM();
		CM_TS_004_TC_003_004_005_Import_criteria_Percentage_PMPM_PCPM = new CM_TS_004_TC_003_004_005_Import_criteria_Percentage_PMPM_PCPM();
		CM_TS_004_TC_008_validate_imported_criteria_commission_method_as_PPPY = new CM_TS_004_TC_008_validate_imported_criteria_commission_method_as_PPPY();
		CM_TS_002_TC_001_TC_003_verify_the_Commission_set_up_Commission_method_Any_And_PMPM = new CM_TS_002_TC_001_TC_003_verify_the_Commission_set_up_Commission_method_Any_And_PMPM();
		CAM_TS_001_TC_001_TC_002_TC_003_TC_004_TC_006_TC_007_TC_008_TC_009_TC_010 =new CAM_TS_001_TC_001_TC_002_TC_003_TC_004_TC_006_TC_007_TC_008_TC_009_TC_010();

		////////Agent Module /////////
		AG_TS_001_TC_001_Navigate_To_Agent_Screen = new AG_TS_001_TC_001_Navigate_To_Agent_Screen();
		AG_TS_001_TC_002_validate_the_fields_in_agent_grid_page = new AG_TS_001_TC_002_validate_the_fields_in_agent_grid_page();
		AG_TS_001_TC_003_validate_the_click_on_agent_name_State = new AG_TS_001_TC_003_validate_the_click_on_agent_name_State();
		AG_TS_001_TC_004_validate_the_existing_agents_AOR_displayed_on_agent_grid = new AG_TS_001_TC_004_validate_the_existing_agents_AOR_displayed_on_agent_grid();
		AGTS001TC001TC002TC003TC004TC005TS005TC001TS004TC001TS004TC003TS006TC001CreateEditStateLicenseCarrierAppointmentGeneralinformationtab = new AGTS001TC001TC002TC003TC004TC005TS005TC001TS004TC001TS004TC003TS006TC001CreateEditStateLicenseCarrierAppointmentGeneralinformationtab();
		AG_TS_001_TC_006_validate_the_updating_without_entering_mandatory_fields_entering_invalid_details = new AG_TS_001_TC_006_validate_the_updating_without_entering_mandatory_fields_entering_invalid_details();
		AG_TS_005_TC_001_TS_004_TC_004_Create_Validate_State_Licenses = new AG_TS_005_TC_001_TS_004_TC_004_Create_Validate_State_Licenses();
		AG_TS_005_TC_001_Create_State_License = new AG_TS_005_TC_001_Create_State_License();
		AG_TS_004_TC_003_TS_004_TC_001_TS_006_TC_001_Agent_details_page_Create_Validation_Carrier_Appointment_Tab = new AG_TS_004_TC_003_TS_004_TC_001_TS_006_TC_001_Agent_details_page_Create_Validation_Carrier_Appointment_Tab();
		AG_TS_007_TC_001_Collaborations_TS_008_TC_001_Filter_Validations = new AG_TS_007_TC_001_Collaborations_TS_008_TC_001_Filter_Validations();
		AG_TS_008_TC_001_002_Filter_Validations = new AG_TS_008_TC_001_002_Filter_Validations();
		AGTS002TC001TS004TC006TS004TC007TS007TC001TS008TC001TC002createsalesmanfieldsinquotes_policystabCollaborationsFilterAdvanceSearch = new AGTS002TC001TS004TC006TS004TC007TS007TC001TS008TC001TC002createsalesmanfieldsinquotes_policystabCollaborationsFilterAdvanceSearch();
		AG_TS_004_TC_001_validate_the_folders_tabs_in_agent_detail_page =new AG_TS_004_TC_001_validate_the_folders_tabs_in_agent_detail_page();
		AG_TS_004_TC001_TC_002_Validate_The_Folder_Tab_fields_in_General_information_tab =new AG_TS_004_TC001_TC_002_Validate_The_Folder_Tab_fields_in_General_information_tab();
		AG_TS_004_TC_003_validate_the_fields_in_carrier_appointments_tabs =new AG_TS_004_TC_003_validate_the_fields_in_carrier_appointments_tabs();
		AG_TS_004_TC_006_TC_007_validate_the_fields_in_quotes_tab_Policys_tab = new AG_TS_004_TC_006_TC_007_validate_the_fields_in_quotes_tab_Policys_tab();
		AG_TS_004_TC_007_validate_the_fields_in_Policys_tab = new AG_TS_004_TC_007_validate_the_fields_in_Policys_tab();

		//////////Service module///////
		TC_CE_059_060_061_ServiceRequest_Activity_Actions = new TC_CE_059_060_061_ServiceRequest_Activity_Actions();
		TC_CE_062_063_064_065_ServiceFilter_AdvanceSearch_Export_ClosingRequest = new TC_CE_062_063_064_065_ServiceFilter_AdvanceSearch_Export_ClosingRequest();
		
		
		


	}

	//	public void Login() throws InterruptedException {
	//		String ReferenceLogin = "PLCA";
	//		try {
	//			Base_Class.SetUp(ReferenceLogin);
	//			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
	//			Log.info("Login successful !");
	//			// ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
	//			// Application URL ");
	//			
	//		} catch (IOException e) {
	//			e.printStackTrace();
	//		} catch (InterruptedException e) {
	//			e.printStackTrace();
	//		}
	//	}

	public void LoginCustomerEngage() throws InterruptedException {
		String ReferenceLogin = "PLCA";
		try {
			Base_Class.SetUpRegression(ReferenceLogin);
			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
			Log.info("Login successful !");
			// ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
			// Application URL ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void LoginCEUserTwo() throws InterruptedException {
		String ReferenceLogin = "PLCA";
		try {
			Base_Class.SetUpCEUsertwo(ReferenceLogin);
			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
			Log.info("Login successful !");
			// ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
			// Application URL ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void SetUpRegressionForCall() throws InterruptedException {
		String ReferenceLogin = "PLCA";
		try {
			Base_Class.SetUpRegressionForCall(ReferenceLogin);
			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
			Log.info("Login successful !");
			// ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
			// Application URL ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}



	public void SetUpRegressionForCTI() throws InterruptedException {//sunpreet
		String ReferenceLogin = "PLCA";
		try {
			Base_Class.SetUpRegressionForCTI(ReferenceLogin);
			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
			Log.info("Login successful !");
			// ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
			// Application URL ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void LoginCEUserFiveCognito() throws InterruptedException {
        String ReferenceLogin = "PLCA";
        try {
               Base_Class.SetUpCEUserfiveCognito(ReferenceLogin);
               ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
               Log.info("Login successful !");
               // ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
               // Application URL ");
        } catch (IOException e) {
               e.printStackTrace();
        } catch (InterruptedException e) {
               e.printStackTrace();
        }
 }

	public void LoginCEUserFiveHeadless() throws InterruptedException {
		String ReferenceLogin = "PLCA";
		try {
			Base_Class.SetUpCEUserfiveHeadless(ReferenceLogin);
			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
			Log.info("Login successful !");
			// ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
			// Application URL ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	} 
	
	//Theses is SSO logins for QA
	public void SetUpRegressionForCTISSo() throws InterruptedException {//sunpreet
		String ReferenceLogin = "PLCA";
		try {
			Base_Class.SetUpRegressionForCTISSO(ReferenceLogin);
			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
			Log.info("Login successful !");
			// ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
			// Application URL ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void LoginUser_1() throws InterruptedException {//sunpreet
		String ReferenceLogin = "PLCA";
		try {
			Base_Class.Loginuser_1(ReferenceLogin);
			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
			Log.info("Login successful !");
			// ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
			// Application URL ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void SetUpRegressionForPratice() throws InterruptedException {//sunpreet
		String ReferenceLogin = "PLCA";
		try {
			Base_Class.SetUpRegressionForCTIPratice(ReferenceLogin);
			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
			Log.info("Login successful !");
			// ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
			// Application URL ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}






	public void SetUpRegressionForCTIConfrence() throws InterruptedException {
		String ReferenceLogin = "PLCA";
		try {
			Base_Class.SetUpRegressionForCTIConfrence(ReferenceLogin);
			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
			Log.info("Login successful !");
			// ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
			// Application URL ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void LoginSanity() throws InterruptedException {
		String ReferenceLogin = "PLCA";
		try {
			Base_Class.SetUpSanity(ReferenceLogin);
			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
			Log.info("Login successful !");
			// ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
			// Application URL ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	//	public void LoginBrokerEngage() throws InterruptedException {
	//		String ReferenceLogin = "PLCA";
	//		try {
	//			Base_Class.SetUpP2Regression(ReferenceLogin);
	//			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
	//			Log.info("Login successful !");
	//			// ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
	//			// Application URL ");
	//		} catch (IOException e) {
	//			e.printStackTrace();
	//		} catch (InterruptedException e) {
	//			e.printStackTrace();
	//		}
	//	}

	//	public void AdminAgentLoginBE() throws InterruptedException {
	//		String ReferenceLogin = "PLCA";
	//		try {
	//			Base_Class.LoginAdminAgent(ReferenceLogin);
	//			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
	//			Log.info("Login successful !");
	//			// ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
	//			// Application URL ");
	//		} catch (IOException e) {
	//			e.printStackTrace();
	//		} catch (InterruptedException e) {
	//			e.printStackTrace();
	//		}
	//	}

	public void Logout() throws InterruptedException, AWTException {

		driver.quit();

	}

	public void LoginBrokerEngage() throws InterruptedException {
		String ReferenceLogin = "PLCA";
		try {
			Base_Class.SetUpP2Regression(ReferenceLogin);
			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
			Log.info("Login successful !");
			// ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
			// Application URL ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void Loginuser_1() throws InterruptedException {
		String ReferenceLogin = "PLCA";
		try {
			Base_Class.Loginuser_1(ReferenceLogin);
			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
			Log.info("Login successful !");
			// ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
			// Application URL ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void Loginuser_1SSO() throws InterruptedException {
		String ReferenceLogin = "PLCA";
		try {
			Base_Class.Loginuser_1SSO(ReferenceLogin);
			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
			Log.info("Login successful !");
			// ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
			// Application URL ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void LoginBrokerEngageSync() throws InterruptedException {
		String ReferenceLogin = "PLCA";
		try {
			Base_Class.SetUpBeCeSync(ReferenceLogin);
			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
			Log.info("Login successful !");
			// ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
			// Application URL ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	public void LoginCEUserOne() throws InterruptedException {
		String ReferenceLogin = "PLCA";
		try {
			Base_Class.SetUpCEUserone(ReferenceLogin);
			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
			Log.info("Login successful !");
			// ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
			// Application URL ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}





	public void AdminAgentLoginBE() throws InterruptedException {
		String ReferenceLogin = "PLCA";
		try {
			Base_Class.LoginAdminAgent(ReferenceLogin);
			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
			Log.info("Login successful !");
			// ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
			// Application URL ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "TestData")
	public void RUNALL(Map<Object, Object> testdata, ITestContext context) throws Throwable {

		CensusInfo ApplicantInfo = new CensusInfo();
		CensusInfo spCensusInfo = new CensusInfo();
		CensusInfo SpouseInfo = new CensusInfo();
		new CensusInfo();
		CensusInfo DependentsInfo = new CensusInfo();
		//		ArrayList<CensusInfo> DependentsInfo = new ArrayList<CensusInfo>();
		new CensusInfo();

		try {
			testdata.get("TestScenario").toString();

			if (testdata.get("Run").toString().equalsIgnoreCase("Yes")) {
				ExtentTestManager.startTest(testdata.get("TestScenario").toString());
				System.out.println("\n");
				System.out.println(
						"<--------------------------------------- START NEW TESTCASE --------------------------------------------------------->");
				Log.info("*** Running test method " + testdata.get("TestScenario").toString() + "...");

				switch (testdata.get("TestScenario").toString()) {


				case "SCM_TS_001_TC_001_TC_002_TC_004_TC_005_TC_006_TC_010_Create_Duplicate_Download_Edit_Delete_Clone":
					context.setAttribute("fileName", "Login");
//					SetUpRegressionForCTISSo();
					LoginCEUserFiveCognito();
					SCM_TS_001_TC_001_TC_002_TC_004_TC_005_TC_006_TC_010_Create_Duplicate_Download_Edit_Delete_Clone.CE_TC_Split_Commission_validate_the_Create_Duplicate_Download_Edit_Delete_Clone(ApplicantInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
					
				case "CAM_TS_001_TC_001_TC_002_TC_003_TC_004_TC_006_TC_007_TC_008_TC_009_TC_010":
					context.setAttribute("fileName", "Login");
//					SetUpRegressionForCTISSo();
					LoginCEUserFiveCognito();
					CAM_TS_001_TC_001_TC_002_TC_003_TC_004_TC_006_TC_007_TC_008_TC_009_TC_010.CE_TC_Commission_Validate_CAM_TS_001_TC_001_TC_002_TC_003_TC_004_TC_006_TC_007_TC_008_TC_009(ApplicantInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;

					
					
				case "CM_TS_001_TC_004_search_the_criterias_based_on_the_selected_fields":
					context.setAttribute("fileName", "Login");
					SetUpRegressionForCTISSo();
					CM_TS_001_TC_004_search_the_criterias_based_on_the_selected_fields.CE_TC_Commission_validate_search_the_criterias_based_on_the_selected_fields(ApplicantInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;

				case "CM_TS_001_TC_005_validate_user_edit__the_existing_criterias":
					context.setAttribute("fileName", "Login");
					SetUpRegressionForCTISSo();
					CM_TS_001_TC_005_validate_user_edit__the_existing_criterias.CE_TC_Commission_validate_user_edit__the_existing_criterias(ApplicantInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;

					//CM_TS_004_TC_001_002_Import_Commission_Criteria
				case "CM_TS_004_TC_001_002_Import_Commission_Criteria":
					context.setAttribute("fileName", "Login");
					Loginuser_1SSO();
					CM_TS_004_TC_001_002_Import_Commission_Criteria.CE_TC_Commission_Criteria_Validation(ApplicantInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;





				case "CM_TS_001_TC_007_validate_user_clear_the_newly_entered_criterias":
					context.setAttribute("fileName", "Login");
					SetUpRegressionForCTISSo();
					CM_TS_001_TC_007_validate_user_clear_the_newly_entered_criterias.CE_TC_Commission_validate_user_clear_the_newly_entered_criterias(ApplicantInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;

				case "CM_TS_001_TC_008_validate_the_recalculate_functionality":
					context.setAttribute("fileName", "Login");
					SetUpRegressionForCTISSo();
					CM_TS_001_TC_008_validate_the_recalculate_functionality.CE_TC_Commission_validate_the_recalculate_functionality(ApplicantInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;

				case "CM_TS_001_TC_008_TS_002_TC_001_TC_002_TC_003_TC_005_TC_006_Validate_recalculate_Commission_set_up_with_the_following_options":
					context.setAttribute("fileName", "Login");
//					SetUpRegressionForCTISSo();
					LoginCEUserFiveCognito();
					CM_TS_001_TC_008_TS_002_TC_001_TC_002_TC_003_TC_005_TC_006_Validate_recalculate_Commission_set_up_with_the_following_options.CE_TC_Commission_validate_Commission_set_up_with_the_following_options(ApplicantInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;

				case "CM_TS_002_TC_001_TC_003_verify_the_Commission_set_up_Commission_method_Any_And_PMPM":
					context.setAttribute("fileName", "Login");
//					SetUpRegressionForCTISSo();
					LoginCEUserFiveHeadless();
					CM_TS_002_TC_001_TC_003_verify_the_Commission_set_up_Commission_method_Any_And_PMPM.CE_TC_Commission_verify_the_Commission_set_up_Commission_method_Any_And_PMPM(ApplicantInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
					


				case "CM_TS_004_TC_001_TC_002_TC004_verify_the_imported_criteria_of_Commission_set_up_Commission_method_Any_And_PMPM":
					context.setAttribute("fileName", "Login");
//					SetUpRegressionForCTISSo();
					LoginCEUserFiveCognito();
					CM_TS_004_TC_001_TC_002_TC004_verify_the_imported_criteria_of_Commission_set_up_Commission_method_Any_And_PMPM.CE_TC_Commission_validate_imported_criteria_commission_method_as_PMPM(ApplicantInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
					
					
					

				case "CM_TS_001_TC_001_TC_004_TC_005_TC_007_Validate_Create_Search_Edit_Clear":
					context.setAttribute("fileName", "Login");
//					SetUpRegressionForCTISSo();
					LoginCEUserFiveCognito();
					
					CM_TS_001_TC_001_TC_004_TC_005_TC_007_Validate_Create_Search_Edit_Clear.CE_TC_Commission_Validate_Create_Search_Edit_Clear(ApplicantInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;

					//CM_TS_004_TC_003_004_005_Import_criteria_Percentage_PMPM_PCPM
				case "CM_TS_004_TC_003_004_005_Import_criteria_Percentage_PMPM_PCPM":
					context.setAttribute("fileName", "Login");
					Loginuser_1SSO();
					CM_TS_004_TC_003_004_005_Import_criteria_Percentage_PMPM_PCPM.CE_TC_Commission_Criteria_Methods_Validation(ApplicantInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;


				case "CM_TS_004_TC_006_validate_imported_criteria_commission_method_as_PMPY":
					context.setAttribute("fileName", "Login");
					SetUpRegressionForCTISSo();
					CM_TS_004_TC_006_validate_imported_criteria_commission_method_as_PMPY.CE_TC_Commission_validate_imported_criteria_commission_method_as_PMPY(ApplicantInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;


				case "CM_TS_004_TC_007_validate_imported_criteria_commission_method_as_PPPM":
					context.setAttribute("fileName", "Login");
					SetUpRegressionForCTISSo();
					CM_TS_004_TC_007_validate_imported_criteria_commission_method_as_PPPM.CE_TC_Commission_validate_imported_criteria_commission_method_as_PPPM(ApplicantInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;


				case "CM_TS_004_TC_008_validate_imported_criteria_commission_method_as_PPPY":
					context.setAttribute("fileName", "Login");
					SetUpRegressionForCTISSo();
					CM_TS_004_TC_008_validate_imported_criteria_commission_method_as_PPPY.CE_TC_Commission_validate_imported_criteria_commission_method_as_PPPY(ApplicantInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;

					////////////////////////////////////////////////////////////////////////////////////////////////Agent Module////////////////////////////////////////////

				case "AG_TS_001_TC_001_Navigate_To_Agent_Screen":
					context.setAttribute("fileName", "Login");
					SetUpRegressionForCTISSo();
					AG_TS_001_TC_001_Navigate_To_Agent_Screen.CE_TC_Agent_360_validate_Navigate_To_Agent_Screen(ApplicantInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;


				case "AG_TS_001_TC_002_validate_the_fields_in_agent_grid_page":
					context.setAttribute("fileName", "Login");
					SetUpRegressionForCTISSo();
					AG_TS_001_TC_002_validate_the_fields_in_agent_grid_page.CE_TC_Agent_360_validate_the_fields_in_agent_grid_page(ApplicantInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;


				case "AG_TS_001_TC_003_validate_the_click_on_agent_name_State":
					context.setAttribute("fileName", "Login");
					SetUpRegressionForCTISSo();
					AG_TS_001_TC_003_validate_the_click_on_agent_name_State.CE_TC_Agent_360_validate_the_click_on_agent_name_State(ApplicantInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;


				case "AG_TS_001_TC_004_validate_the_existing_agents_AOR_displayed_on_agent_grid":
					context.setAttribute("fileName", "Login");
					SetUpRegressionForCTISSo();
					AG_TS_001_TC_004_validate_the_existing_agents_AOR_displayed_on_agent_grid.CE_TC_Agent_360_validate_the_existing_agents_AOR_are_getting_displayed_on_the_agent_grid(ApplicantInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;


				case "AGTS001TC001TC002TC003TC004TC005TS005TC001TS004TC001TS004TC003TS006TC001CreateEditStateLicenseCarrierAppointmentGeneralinformationtab":
					context.setAttribute("fileName", "Login");
//					SetUpRegressionForCTISSo();
					LoginCEUserFiveCognito();
					AGTS001TC001TC002TC003TC004TC005TS005TC001TS004TC001TS004TC003TS006TC001CreateEditStateLicenseCarrierAppointmentGeneralinformationtab.CE_TC_Agent_360_validate_the_edit_agent_details_and_save_the_changes(ApplicantInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;


				case "AG_TS_001_TC_006_validate_the_updating_without_entering_mandatory_fields_entering_invalid_details":
					context.setAttribute("fileName", "Login");
					SetUpRegressionForCTISSo();
					AG_TS_001_TC_006_validate_the_updating_without_entering_mandatory_fields_entering_invalid_details.CE_TC_Agent_360_validate_the_updating_without_entering_mandatory_fields_entering_invalid_details(ApplicantInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;

					//AG_TS_005_TC_001_TS_004_TC_004_Create_Validate_State_Licenses

				case "AG_TS_005_TC_001_TS_004_TC_004_Create_Validate_State_Licenses":
					context.setAttribute("fileName", "Login");
					Loginuser_1SSO();
					AG_TS_005_TC_001_TS_004_TC_004_Create_Validate_State_Licenses.State_Licenses(ApplicantInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;

					//AG_TS_005_TC_001_Create_State_License	
				case "AG_TS_005_TC_001_Create_State_License":
					context.setAttribute("fileName", "Login");
					Loginuser_1SSO();
					AG_TS_005_TC_001_Create_State_License.Create_State_Licenses(ApplicantInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
					//AG_TS_004_TC_003_TS_004_TC_001_TS_006_TC_001_Agent_details_page_Create_Validation_Carrier_Appointment_Tab	
				case "AG_TS_004_TC_003_TS_004_TC_001_TS_006_TC_001_Agent_details_page_Create_Validation_Carrier_Appointment_Tab":
					context.setAttribute("fileName", "Login");
					Loginuser_1SSO();
					AG_TS_004_TC_003_TS_004_TC_001_TS_006_TC_001_Agent_details_page_Create_Validation_Carrier_Appointment_Tab.Create_Carrier_Appointment(ApplicantInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;

					//AG_TS_007_TC_001_Collaborations_TS_008_TC_001_Filter_Validations

				case "AG_TS_007_TC_001_Collaborations_TS_008_TC_001_Filter_Validations":
					context.setAttribute("fileName", "Login");
					Loginuser_1SSO();
					AG_TS_007_TC_001_Collaborations_TS_008_TC_001_Filter_Validations.Agent_Collaborations(ApplicantInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;



				case "AGTS002TC001TS004TC006TS004TC007TS007TC001TS008TC001TC002createsalesmanfieldsinquotes_policystabCollaborationsFilterAdvanceSearch":
					context.setAttribute("fileName", "Login");
//					SetUpRegressionForCTISSo();
					LoginCEUserFiveCognito();
					AGTS002TC001TS004TC006TS004TC007TS007TC001TS008TC001TC002createsalesmanfieldsinquotes_policystabCollaborationsFilterAdvanceSearch.CE_TC_Agent_360_validate_the_create_a_new_agent_or_salesman(ApplicantInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;


				case "AG_TS_004_TC_001_validate_the_folders_tabs_in_agent_detail_page":
					context.setAttribute("fileName", "Login");
					SetUpRegressionForCTISSo();
					AG_TS_004_TC_001_validate_the_folders_tabs_in_agent_detail_page.CE_TC_Agent_360_validate_the_folders_tabs_in_agent_detail_page(ApplicantInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;


				case "AG_TS_004_TC001_TC_002_Validate_The_Folder_Tab_fields_in_General_information_tab":
					context.setAttribute("fileName", "Login");
					SetUpRegressionForCTISSo();
					AG_TS_004_TC001_TC_002_Validate_The_Folder_Tab_fields_in_General_information_tab.CE_TC_Agent_360_validate_the_fields_in_General_information_tab(ApplicantInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;


				case "AG_TS_004_TC_003_validate_the_fields_in_carrier_appointments_tabs":
					context.setAttribute("fileName", "Login");
					SetUpRegressionForCTISSo();
					AG_TS_004_TC_003_validate_the_fields_in_carrier_appointments_tabs.CE_TC_Agent_360_validate_the_fields_in_carrier_appointments_tabs(ApplicantInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;


				case "AG_TS_004_TC_006_TC_007_validate_the_fields_in_quotes_tab_Policys_tab":
					context.setAttribute("fileName", "Login");
					SetUpRegressionForCTISSo();
					AG_TS_004_TC_006_TC_007_validate_the_fields_in_quotes_tab_Policys_tab.CE_TC_Agent_360_validate_the_fields_in_quotes_tab(ApplicantInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;


				case "AG_TS_004_TC_007_validate_the_fields_in_Policys_tab":
					context.setAttribute("fileName", "Login");
					SetUpRegressionForCTISSo();
					AG_TS_004_TC_007_validate_the_fields_in_Policys_tab.CE_TC_Agent_360_validate_the_fields_in_Policys_tab(ApplicantInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;



				case "AG_TS_008_TC_001_002_Filter_Validations":
					context.setAttribute("fileName", "Login");
					Loginuser_1SSO();
					AG_TS_008_TC_001_002_Filter_Validations.Agent_Filter_Validations(ApplicantInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
					
					
					
					
				
					
				case "TC_CE_059_060_061_ServiceRequest_Activity_Actions":
					context.setAttribute("fileName", "Login");
					LoginCEUserTwo();
					TC_CE_059_060_061_ServiceRequest_Activity_Actions.serviceCreateNewServiceRequest();
					Logout();
					context.setAttribute("fileName", "Logout");
						break;	
							
			
						
				case "TC_CE_062_063_064_065_ServiceFilter_AdvanceSearch_Export_ClosingRequest":
					context.setAttribute("fileName", "Login");
					LoginCEUserTwo();
					TC_CE_062_063_064_065_ServiceFilter_AdvanceSearch_Export_ClosingRequest.serviceFilter();
					Logout();
					context.setAttribute("fileName", "Logout");
						break;	
							


				default:
					break;

				}

				// EndTest
				System.out.println(("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***"));
				ExtentTestManager.endTest();
				ExtentManager.getInstance().flush();
				Log.info("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***");

			}

		} catch (Exception e) {

			System.out.println("<----------------Failed--- Test execution " + testdata.get("TestScenario").toString()
					+ " ---Failed ---------------->");
			Log.error("" + e.getMessage());
			String fileName = (String) context.getAttribute("fileName");

			try {
				File file = new com.Utility.ScreenShot(driver).takeScreenShot(fileName,
						testdata.get("TestScenario").toString());
				ExtentTestManager.getTest().fail(e.getMessage(),
						MediaEntityBuilder.createScreenCaptureFromPath(file.toString()).build());
			} catch (Exception NoSuchWindowException) {
				System.out.println("Catch File not found error");
			}
			ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");

			// EndTest
			System.out.println(("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***"));
			ExtentTestManager.endTest();
			ExtentManager.getInstance().flush();
			Log.info("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***");
		} catch (AssertionError e) {
			System.out.println("*** Test execution " + testdata.get("TestScenario").toString() + " failed...");
			Log.error("*** Test execution " + testdata.get("TestScenario").toString() + " failed...");
			Log.error("" + e.getMessage());
			String fileName = (String) context.getAttribute("fileName");

			try {
				File file = new com.Utility.ScreenShot(driver).takeScreenShot(fileName,
						testdata.get("TestScenario").toString());
				ExtentTestManager.getTest().fail(e.getMessage(),
						MediaEntityBuilder.createScreenCaptureFromPath(file.toString()).build());
			} catch (Exception NoSuchWindowException) {
				System.out.println("File not found error");
			}
			ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");

			// EndTest
			ExtentTestManager.endTest();
			ExtentManager.getInstance().flush();
			Log.info("************************ Test Suite " + testdata.get("TestScenario").toString()
					+ " ending ****************************");

		} finally {
			if (driver != null)
				driver.quit();
		}
	}

	@DataProvider(name = "TestData")
	public static Object[][] gettestdate() throws IOException {

		Object[][] objectarry = null;
		java.util.List<Map<String, String>> completedata = com.Utility.ExcelReader.getdata();

		objectarry = new Object[completedata.size()][1];

		for (int i = 0; i < completedata.size(); i++) {
			objectarry[i][0] = completedata.get(i);
		}
		return objectarry;
	}
	@AfterSuite
	public void sharingReport() throws IOException {

		//extent.flush();
		// driver.quit();
		if(	configloader().getProperty("triggermail").equalsIgnoreCase("Yes")){
			try {
				TriggerEmail.sendReport();
			} catch (Exception e) {
				// TODO Auto-generated catch blockdfghj
				e.printStackTrace();
			}

		}

	}
	public String writenameToExcel(String nameText, String sheetname) throws IOException {
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
	public static String generateUsername() {
		int length = 6; // Set the desired length of the username
		String characters = "abcdefghijklmnopqrstuvwxyz";
		Random random = new Random();
		StringBuilder username = new StringBuilder();
		for (int i = 0; i < length; i++) {
			char randomChar = characters.charAt(random.nextInt(characters.length()));
			username.append(randomChar);
		}
		return username.toString();
	}


} 
