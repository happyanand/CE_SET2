package com.pages;
import static org.testng.Assert.assertEquals;

import org.apache.batik.swing.JSVGCanvas.ScrollDownAction;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.RenderingHints.Key;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.BasePackage.Base_Class;

import Utility.Logs.Log;

public class Commission_Page extends BasePage {

	public Commission_Page(WebDriver driver) {
		super(driver);
	}

	public String LoginUsername;
	WebElement element;
	CustomerPage CustomerPage =new CustomerPage(driver);
	Carrier360 Carrier360 =new Carrier360(driver);
	HomePage HomePage =new HomePage(driver);
	private By CTIMinimizeIcon = By.xpath("//a[@class='fa fa-minus right-al']");
	private By AddCommission = By.xpath("//*[@title='Add a row']");
	private By Commissionpageload =By.xpath("//*[@style='margin: 0px 100.938px 0px 0px; float: right;'] | //*[@style='margin: 0px 227.703px 0px 0px; float: right;']");
	private By CommissionSetUp = By.xpath("//*[contains(@href,'commissions/commissionSetup')]");
	private By CommissionSetUpPageValidation = By.xpath("//*[@class='page-header']//*[text()='Commission Setup']");
	private By CommissionManagement = By.xpath("//*[contains(@href,'commissions/commissionManagement')]");
	private By CommissionManagementPageValidation = By.xpath("//*[@class='page-header']//*[text()='Commission Management']");
	private By CommissionModule =By.xpath("//*[@class='box animate-box fade-in'][contains(@ng-show,\"isAccessible('Commissions\")] | //*[@class='box animate-box fade-in'][contains(@ng-show,'Commissions')]");
	private By PeriodDropdown =By.xpath("(//*[contains(@class,'dx-dropdowneditor-button dx-button-normal')])[1]");
	private By Product_CategoryDropdown =By.xpath("(//*[contains(@class,'dx-dropdowneditor-button dx-button-normal')])[2]");
	private By CommissionMethod= By.xpath("(//*[contains(@class,'dx-dropdowneditor-button dx-button-normal')])[7]");
	private By carrierDropdown =By.xpath("(//*[contains(@class,'dx-dropdowneditor-button dx-button-normal')])[3]");
	private By AgentDropdown =By.xpath("(//*[contains(@class,'dx-dropdowneditor-button dx-button-normal')])[4]");
	private By CommissionRate = By.xpath("//*[contains(@class,'dx-textbox dx-texteditor dx-editor-outlined dx-widget dx-texteditor-empty')]//input | //*[contains(@class,'dx-row dx-data-row dx-column-lines dx-edit-row')]//*[@aria-colindex='9']//input");
	private By CommissionPercentage =By.xpath("(//*[contains(@class,'dx-numberbox dx-texteditor dx-editor-outlined dx-widget dx-texteditor-empty')]//input[@role='spinbutton'])[1]");
	private By SaveCommission =By.xpath("//a[@title='Save']");
	private By Successmsg = By.xpath("//*[text()='Commission recalculated successfully.']");
	private By SuccessOk =By.xpath("//*[@ng-click='infoModalCtrl.Close()']");
	private By CRMReportYear=By.name("CRMReportYear");
	private By CommissionPeriodDropdown=By.name("CRMCommissionPeriod");
	private By ProductCategoryDropdown=By.name("CRMProductCategory");
	private By carrierNameDropdown=By.name("CRMCommissionCarrierName");
	private By SearchCommission=By.xpath("//*[@ng-click='searchCommissionRates()']");
	private By DeleteCommission =By.xpath("//a[@title='Delete']");
	private By Deleteyes =By.xpath("//*[@aria-label='Yes']");
	private By Edit =By.xpath("//a[@title='Edit']");
	private By ClearFilter = By.xpath("//*[contains(@ng-click,'clearCommissionSearch')]");
	private By RecalculateCommission =By.xpath("//*[@ng-click='showRecalculateSection()']");
	private By Policy_Created_Date =By.xpath("//*[@aria-label='Policy Created Date']");
	private By Policy_Created_Start_Date =By.xpath("//*[@id='asset-start-date']//input");
	private By Policy_Created_end_Date =By.xpath("//*[@id='asset-end-date']//input");
	private By Run =By.xpath("//*[@ng-click='saveRecalculateCommission(assetDate.assetStartDate,assetDate.assetEndDate)']");
	private By ReportTab =By.name("menu_reports");
	private By Report =By.xpath("//span[normalize-space()='Reports']");
	private By CommissiionReportunderreport =By.xpath("//*[@aria-label='Commission Reports']");
	private By Agent_Projections =By.xpath("//*[@aria-label='Agent Projections']");
	private By CRMReportCarrierNameMulti =By.name("CRMReportCarrierNameMulti");
	private By runReportBtn =By.name("runReportBtn");
	private By File_Action = By.xpath("//button[@id='com-setup-file-action-btn']");
	private By Import_Commission_Setup = By.xpath("//button[@id='import-commission-btn']");
	private By File_Upload= By.xpath("//div[@class='button select-btn ng-pristine ng-untouched ng-valid ng-empty'] | //div[@class='button select-btn ng-pristine ng-untouched ng-valid ng-not-empty'] | //*[@id='carrierFile']");
	private By CarrierFileUpload = By.xpath("//div[@class='button select-btn ng-pristine ng-untouched ng-valid ng-not-empty'] | //*[@id='carrierFile']");
	private By Submit = By.xpath("(//button[normalize-space()='Submit'])[1]");
	private By Success_Message = By.xpath("//div[@id='divSuccess']");
	private By ReportAgent =By.name("CRMReportAgencyAgentMulti");
	private By menu_bar = By.xpath("//i[@class='fa fa-bars']");

	/////////////////////////////////////////////////////////////////////////////////
	private By RefreshDashboard = By.name("refreshListDashboard");
	private By SplitCommissionSetup =By.xpath("//*[contains(@href,'commissions/splitCommissionSetup')]");
	private By SplitCommissionpageValidate =By.xpath("//*[@class='page-header']//*[text()='Split Commission Setup']");
	private By AddSplitCommission=By.xpath("//*[@ng-click='newSplitCommissionCriteria()']");
	private By Enterstartdate =By.xpath("(//*[@class='dx-texteditor-input'][@aria-haspopup='true'])[1]");
	private By EnterEndDate =By.xpath("(//*[@class='dx-texteditor-input'][@aria-haspopup='true'])[2]");
	private By Split =By.xpath("//*[@aria-colindex='14']//*[@class='dx-texteditor-input']");
	private By CarrierDropDown =By.xpath("//*[@aria-colindex='5']//div[@class='dx-selectbox dx-textbox dx-texteditor dx-editor-outlined dx-widget dx-dropdowneditor-button-visible dx-dropdowneditor dx-dropdowneditor-field-clickable']");
	private By AORDropdown =By.xpath("//*[@aria-colindex='11']//div[@class='dx-dropdowneditor-icon']");
	private By AORDropdown1 =By.xpath("//*[@aria-colindex='13']//div[@class='dx-dropdowneditor-icon']");
	private By AORDropdown2 =By.xpath("//*[@aria-colindex='15']//div[@class='dx-dropdowneditor-icon']");
	private By SaletypeDropDown =By.xpath("//*[@aria-colindex='6']//div[@class='dx-selectbox dx-textbox dx-texteditor dx-editor-outlined dx-widget dx-dropdowneditor-button-visible dx-dropdowneditor dx-dropdowneditor-field-clickable']");
	private By ProducatTypeDropDown =By.xpath("//*[@aria-colindex='8']//div[@class='dx-selectbox dx-textbox dx-texteditor dx-editor-outlined dx-widget dx-dropdowneditor-button-visible dx-dropdowneditor dx-dropdowneditor-field-clickable']");
	private By ClickONsearchCustomer= By.xpath("//*[@title='Search Customer']");
	private By SelectTheCustomer =By.xpath("(//*[@id='splitCommCustomerDataGrid']//*[@class='dx-select-checkbox dx-datagrid-checkbox-size dx-checkbox dx-widget'])[1]//parent::td");
	private By SelectedTheCustomername =By.xpath("//*[@aria-selected='true']//*[@aria-colindex='2']");
	private By ClickonContinue =By.xpath("//button[normalize-space()='Continue']");
	private By SplitMethod =By.xpath("//*[@aria-colindex='12']//*[@class='dx-texteditor-input']");
	private By SaveSplitCommission=By.xpath("//*[@title='Save']");
	private By Savepopupmsg =By.xpath("//*[@class='message ng-binding']");
	private By Deletepopupmsg =By.xpath("//*[@class='dx-dialog-message']");
	private By ConfirmSave = By.xpath("//*[@data-ng-click='vm.data.onPositiveTextClicked();vm.closeDialog();']"); 
	private By EditSplitCommission =By.xpath("(//*[@title='Edit'])[1]");
	private By DeleteSplitCommission = By.xpath("(//*[@title='Delete'])[1]");
	private By CloneSplitCommission = By.xpath("(//*[@title='Clone'])[1]");
	private By RefreshList =By.name("refreshListDashboard");
	private By downlodDataBtn = By.name("downlodDataBtn");
	private By Cancel =By.xpath("//*[@title='Cancel']");
	private By ConfirmDeleteYes=By.xpath("//*[@aria-label='Yes']");
	private By Error_Message = By.id("divError");
	/////////////////////////////////////////////////////
	private By CarrierGroup = By.name("AssetCarrierGroup");
	private By Carrier = By.name("AssetCarrier");
	private By StatementDate = By.name("AssetNewBillDate");
	private By UploadCarrierStatement = By.xpath("//*[text()='Upload Carrier Statement']");
	private By SelectedDropdown = By.xpath("//*[contains(@class,'dropDown md-active md-clickable')]//*[@selected='selected']");
	private By SubmitFile = By.xpath("//*[text()='Next'][@class='btn btn-default green pull-right']");	
	private By SubscriberNameDropdown = By.xpath("//*[contains(text(),'Subscriber Name')]//parent::tr//td//select");
	private By CommissionRateDropdown = By.xpath("//*[contains(text(),'Commission Received ($)')]//parent::tr//td//select");
	private By EffectiveDateDropdown = By.xpath("//*[contains(text(),'Effective Date')]//parent::tr//td//select");
	private By PaidThroughDateDropdown = By.xpath("//*[contains(text(),'Paid Through Date')]//parent::tr//td//select");
	private By AgentNameDropdown = By.xpath("//td[contains(text(),'Agent Name')]//parent::tr//td//select");
	private By AgentNameDropdown1 = By.xpath("//td[contains(text(),'Agent Name')]");
	private By SaveCarrierStatementMapping = By.xpath("(//*[@ng-change='toggleMapperSaver()']//div)[1]");
	private By EnterMapname = By.xpath("//*[@ng-model='mapper.mapperSetName']");
	private By SaveMapperName = By.xpath("//*[contains(@ng-click,'saveCommissionMapping')]");
	private By NextExcelcolumn = By.xpath("//*[@ng-click='uploadAndPreProcessCommissionStatementExcel()']");
	private By SaveParagraph = By.xpath("//p[@class='message ng-binding']");
	private By ConfirmParagraph =By.xpath("//*[@data-ng-click='vm.data.onPositiveTextClicked();vm.closeDialog();']");
	private By PendingUploadFile =By.xpath("//*[@ng-click='fetchPendingUploadDetails()']");
	private By LoginuserName= By.xpath("//*[@class='user']//b");
	private By SaveCarrierStatement =By.xpath("//*[text()='Saved Carrier Statement Mappings']//parent::div//parent::div[@class='custom-select']");
	private By RefreshGrid = By.xpath("//*[@title='Refresh']");
	private By GridStatus = By.xpath("(//*[@class='dx-row dx-data-row dx-column-lines'])[1]//td[@role='gridcell'][@aria-colindex='5']");
	private By Downloadexportfile =By.xpath("//*[@ng-click='exportReconciliationGridData()']");
	private By Reviewexcel =By.xpath("//*[@title='Review']");
	private By BacktomappingSection =By.xpath("//*[@ng-click='backToMappingSection()']");
	private By DeleteTheRow =By.xpath("//*[@title='Discard']");
	private By Deletemsg =By.xpath("//p[@ng-bind-html='vm.data.popupMessage']");
	private By Deleteconfirmation = By.xpath("//*[@data-ng-click='vm.data.onPositiveTextClicked();vm.closeDialog();']");
	private By ValidationStatus =By.xpath("//*[text()='Validation Status']//parent::td//div//span[@class='dx-header-filter dx-header-filter-empty']");
	private By FailedStatus =By.xpath("//*[@class='dx-overlay-content dx-popup-normal dx-resizable dx-dropdowneditor-overlay']//*[text()='Failure']");
	private By StatusOkButton =By.xpath("//*[@class='dx-overlay-content dx-popup-normal dx-resizable dx-dropdowneditor-overlay']//*[text()='OK']//parent::div//parent::div[@role='button']");
	private By FailedReasons = By.xpath("(//tbody//tr[@class='dx-row dx-data-row dx-column-lines'])[1]//td[@role='gridcell'][@aria-colindex='']");
	private By FailedCount =By.xpath("//h5[@class='map-head']//i");
	private By DefaultTemplate =By.xpath("//*[@ng-click='downloadDefaultCarrierStatementTemplate()']");
	private By BackToUploadSection =By.xpath("//*[@ng-click='backToUploadSection()']");

	public void ClickOnEditCommission() throws InterruptedException {		
		if (ElementDisplayed(Edit)) {
			ExtentSuccessMessage("Successfully user able to See 'Edit Commission Icon' ");
			click(Edit);
			ExtentSuccessMessage("Successfully user Clicked on 'Edit Commission Icon' ");
		} else {
//			ExtentErrorMessage("Unsuccessfully 'Edit Commission icon' Not visible");
			Base_Class.ScrollUntilElementVisible(Edit);
			if (ElementDisplayed(Edit)) {
				ExtentSuccessMessage("Successfully user able to See 'Edit Commission Icon' ");
				click(Edit);
				ExtentSuccessMessage("Successfully user Clicked on 'Edit Commission Icon' ");
			} else {
				ExtentErrorMessage("Unsuccessfully 'Edit Commission icon' Not visible");
			}
		}
	}
	public void ClickONReportTab() throws InterruptedException, AWTException {		
		Thread.sleep(3000);
		if (ElementDisplayed(ReportTab)) {
			ExtentSuccessMessage("Successfully user able to See 'Report Tab' ");
			click(ReportTab);
			ExtentSuccessMessage("Successfully user Clicked on 'Report Tab' ");
			Thread.sleep(4000);
		} else {
			By menu_bar = By.xpath("//i[@class='fa fa-bars']");
			if (ElementDisplayed(menu_bar)) {
				click(menu_bar);
				ExtentSuccessMessage("Successfully user Clicked on 'Menu bar' ");
			}
			Thread.sleep(3000);
			if (ElementDisplayed(ReportTab)) {
				ExtentSuccessMessage("Successfully user able to See 'Report Tab' ");
				click(ReportTab);
				ExtentSuccessMessage("Successfully user Clicked on 'Report Tab' ");
				Thread.sleep(5000);
			} else {
				ExtentErrorMessage("Unsuccessfully 'Report Tab' Not visible");
			}
			RefreshPage();
			Thread.sleep(5000);
		}
	}
	public void ClickONCommissiionReportunderreportTab() throws InterruptedException {	
		Thread.sleep(4000);
		waitVisibility(CommissiionReportunderreport);
		Base_Class.ScrollUntilElementVisible(CommissiionReportunderreport);
		if (ElementDisplayed(CommissiionReportunderreport)) {
			ExtentSuccessMessage("Successfully user able to See 'CommissiionReport under report Tab' ");
			click(CommissiionReportunderreport);
			ExtentSuccessMessage("Successfully user Clicked on 'CommissiionReport under report Tab' ");

		} else {
			ExtentErrorMessage("Unsuccessfully 'CommissiionReport under report Tab' Not visible");
		}
	}

	public void ClickONrunReportBtnunderreportTab() throws InterruptedException {	
		Thread.sleep(2000);
		if (ElementDisplayed(runReportBtn)) {
			ExtentSuccessMessage("Successfully user able to See 'runReportBtn under report Tab' ");
			click(runReportBtn);
			ExtentSuccessMessage("Successfully user Clicked on 'runReportBtn under report Tab' ");
			Thread.sleep(23000);
		} else {
			ExtentErrorMessage("Unsuccessfully 'runReportBtn under report Tab' Not visible");
		}
		WaitUntillPAgeLoad();
	}

	public void ClickONCRMReportCarrierNameMultiunderreportTab() throws InterruptedException {	
		Thread.sleep(2000);
		if (ElementDisplayed(CRMReportCarrierNameMulti)) {
			ExtentSuccessMessage("Successfully user able to See 'CRMReportCarrierNameMulti under report Tab' ");
			click(CRMReportCarrierNameMulti);
			ExtentSuccessMessage("Successfully user Clicked on 'CRMReportCarrierNameMulti under report Tab' ");

		} else {
			ExtentErrorMessage("Unsuccessfully 'CRMReportCarrierNameMulti under report Tab' Not visible");
		}
	}


	public void ClickONAgent_ProjectionsunderreportTab() throws InterruptedException {	
		Thread.sleep(2000);
		if (ElementDisplayed(Agent_Projections)) {
			ExtentSuccessMessage("Successfully user able to See 'Agent_Projections under report Tab' ");
			click(Agent_Projections);
			ExtentSuccessMessage("Successfully user Clicked on 'Agent_Projections under report Tab' ");
			Thread.sleep(15000);
			//			WaitUntillPAgeLoad();
		} else {
			ExtentErrorMessage("Unsuccessfully 'Agent_Projections under report Tab' Not visible");
		}
	}



	public void ClickOnClearFilter() throws InterruptedException {		
		if (ElementDisplayed(ClearFilter)) {
			ExtentSuccessMessage("Successfully user able to See 'Clear Commission Icon' ");
			click(ClearFilter);
			ExtentSuccessMessage("Successfully user Clicked on 'Clear Commission Icon' ");
			//			Thread.sleep(5000);
		} else {
			ExtentErrorMessage("Unsuccessfully 'Clear Commission icon' Not visible");
		}
	}

	public void ClickOnMinimizeCallwindow() throws InterruptedException {
		//		Thread.sleep(10000);
		if (ElementDisplayed(CTIMinimizeIcon)) {
			ExtentSuccessMessage("Successfully user able to See 'Minimize Icon' ");
			click(CTIMinimizeIcon);
			ExtentSuccessMessage("Successfully user Clicked on 'Minimize Icon' ");
		} else {
			ExtentSuccessMessage("Unsuccessfully 'Minimize' Not visible");
		}
	}


	public void ClickOnSaveCommission() throws InterruptedException {		
		if (ElementDisplayed(SaveCommission)) {
			ExtentSuccessMessage("Successfully user able to See 'Save Commission Icon' ");
			click(SaveCommission);
			ExtentSuccessMessage("Successfully user Clicked on 'Save Commission Icon' ");
			CheckSuccessPopup();
		} else {
			Base_Class.ScrollUntilElementVisible(SaveCommission);
			if (ElementDisplayed(SaveCommission)) {
				ExtentSuccessMessage("Successfully user able to See 'Save Commission Icon' ");
				click(SaveCommission);
				ExtentSuccessMessage("Successfully user Clicked on 'Save Commission Icon' ");
				CheckSuccessPopup();
			} else {
				ExtentErrorMessage("Unsuccessfully 'Save Commission icon' Not visible");
			}
		}
	}



	public void ClickOnRecalculationCommission() throws InterruptedException {		
		Thread.sleep(3000);
		if (ElementDisplayed(RecalculateCommission)) {
			ExtentSuccessMessage("Successfully user able to See 'Recalculation Commission Icon' ");
			click(RecalculateCommission);
			ExtentSuccessMessage("Successfully user Clicked on 'Recalculation Commission Icon' ");
			Thread.sleep(4000);
			ClickOnPolicy_Created_Date();
		} else {
			ExtentErrorMessage("Unsuccessfully 'Recalculation Commission icon' Not visible");
		}
	}

	public void ClickOnRun() throws InterruptedException {		
		if (ElementDisplayed(Run)) {
			ExtentSuccessMessage("Successfully user able to See 'Run ' ");
			click(Run);
			ExtentSuccessMessage("Successfully user Clicked on 'Run ' ");
		} else {
			ExtentErrorMessage("Unsuccessfully 'Run' Not visible");
		}
	}
	public void ClickOnPolicy_Created_Date() throws InterruptedException {		
		if (ElementDisplayed(Policy_Created_Date)) {
			ExtentSuccessMessage("Successfully user able to See 'Policy_Created_Date ' ");
			click(Policy_Created_Date);
			ExtentSuccessMessage("Successfully user Clicked on 'Policy_Created_Date ' ");
		} else {
			ExtentErrorMessage("Unsuccessfully 'Policy_Created_Date' Not visible");
		}
	}



	public void ClickOnDeleteCommission() throws InterruptedException {		
		if (ElementDisplayed(DeleteCommission)) {
			ExtentSuccessMessage("Successfully user able to See 'Delete Commission Icon' ");
			click(DeleteCommission);
			ExtentSuccessMessage("Successfully user Clicked on 'Delete Commission Icon' ");
			click(Deleteyes);
			ExtentSuccessMessage("Successfully user Clicked on 'Delete Commission Yes Icon' ");	
			String msg =GetElementText(Success_Message);
			Assert.assertEquals(msg, "Commission rate has deleted successfully");
		} else {
			ExtentErrorMessage("Unsuccessfully 'Delete Commission icon' Not visible");
		}
		//		waitVisibility(File_Action);
		//				WaitUntillPAgeLoad();
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

	public void CheckSuccessPopup() throws InterruptedException {
		Thread.sleep(8000);
		//		waitVisibility(SuccessOk);
		//		if (ElementDisplayed(SuccessOk)) {
		//			ExtentSuccessMessage("Successfully user able to See 'Success Popup' ");
		//			String Message = GetElementText(SuccessPopup);
		//			System.out.println("SuccessPopup:"+SuccessPopup);
		click(SuccessOk);
		ExtentSuccessMessage("Successfully user Clicked on 'Success Ok' ");
		//		} else {
		//			ExtentErrorMessage("Unsuccessfully 'Success Popup' Not visible");
		//		}
	}
	public void CheckSuccessmsg() throws InterruptedException {
		waitVisibility(Successmsg);
		if (ElementDisplayed(Successmsg)) {
			ExtentSuccessMessage("Successfully user able to See 'Commission recalculated successfully.' ");

		} else {
			ExtentErrorMessage("Unsuccessfully 'Success Popup' Not visible");
		}
	}


	public void ClickOnAddCommission() throws InterruptedException {		
		if (ElementDisplayed(AddCommission)) {
			ExtentSuccessMessage("Successfully user able to See 'AddCommission Icon' ");
			//			element = wait.until(ExpectedConditions.presenceOfElementLocated(File_Action));
			//			Commissionpageload

			System.out.println("Debug");
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
	public void ClickOnCommissionMethod() throws InterruptedException {	
		Thread.sleep(10000);
		Dimension Size = driver.manage().window().getSize();
		System.out.println("Width:- "+Size.getWidth());
		System.out.println("Height:- "+Size.getHeight());
		if (ElementDisplayed(CommissionMethod)) {
			ExtentSuccessMessage("Successfully user able to See 'CommissionMethod Dropdown' ");
			click(CommissionMethod);
			ExtentSuccessMessage("Successfully user Clicked on 'CommissionMethod Dropdown' ");
		} else {
//			ExtentSuccessMessage("Unsuccessfully 'CommissionMethod dropdown' Not visible");
			Base_Class.ScrollUntilElementVisible(CommissionMethod);
			Thread.sleep(3000);
			if (ElementDisplayed(CommissionMethod)) {
				ExtentSuccessMessage("Successfully user able to See 'CommissionMethod Dropdown' ");
				click(CommissionMethod);
				ExtentSuccessMessage("Successfully user Clicked on 'CommissionMethod Dropdown' ");
			} else {
				ExtentSuccessMessage("Unsuccessfully 'CommissionMethod dropdown' Not visible");
			}
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
	public void ClickOnAgentDropdown() throws InterruptedException {		
		if (ElementDisplayed(AgentDropdown)) {
			ExtentSuccessMessage("Successfully user able to See 'Agent Dropdown' ");
			click(AgentDropdown);
			ExtentSuccessMessage("Successfully user Clicked on 'Agent Dropdown' ");
		} else {
			ExtentSuccessMessage("Unsuccessfully 'Agent Dropdown' Not visible");
		}
	}


	public void UpdateRowData(String Year) {

		By options =By.xpath("//*[contains(@class,'dx-item dx-list-item')][@aria-selected='false']//*[@title='"+Year+"'] | //*[contains(@class,'dx-item dx-list-item')][@aria-selected='false']//*[text()='"+Year+"']");



	}

	public void SelectThedropdown1(String Year) throws InterruptedException {
		By Elementsdd=By.xpath("(//*[contains(@class,'dx-item dx-list-item')][@aria-selected='true']//*[@aria-checked='true'])[1]");
		//		By Elementsdd=By.xpath("//*[@class='dx-overlay-content dx-popup-normal dx-resizable dx-dropdowneditor-overlay-flipped']//*[contains(@class,'dx-item dx-list-item')][@aria-selected='true']//div[2]//div");
		By ElementsAgent =By.xpath("//*[@class='dx-overlay-content dx-popup-normal dx-resizable dx-dropdowneditor-overlay-flipped']//*[text()='All']//ancestor::div[@aria-selected='true']//*[@role='checkbox']");
		By Elements=By.xpath("//*[contains(@class,'dx-item dx-list-item')][@aria-selected='true']//*[@title='All']");
		By SearchinDD = By.xpath("//*[@class='dx-popup-content']//input[@role='textbox'][@spellcheck='false']");
		By SearchAgent =By.xpath("//*[@class='dx-overlay-content dx-popup-normal dx-resizable dx-dropdowneditor-overlay-flipped']//*[@class='dx-popup-content']//input[@role='textbox'][@spellcheck='false']//parent::div//parent::div[@class='dx-list-search dx-textbox dx-texteditor dx-editor-outlined dx-searchbox dx-show-clear-button dx-widget dx-texteditor-empty']");
		By options =By.xpath("//*[contains(@class,'dx-item dx-list-item')][@aria-selected='true']//*[@title='"+Year+"'] | //*[contains(@class,'dx-item dx-list-item')][@aria-selected='false']//*[@title='"+Year+"'] | //*[contains(@class,'dx-item dx-list-item')][@aria-selected='false']//*[text()='"+Year+"']");
		if(ElementDisplayed(Elements)) {
			click(Elements);
			ExtentSuccessMessage("Successfully user unchecked the existing value from dropdow");
			if(ElementDisplayed(options)) {
				click(options);
				ExtentSuccessMessage("Successfully user Checked the new "+Year+" value from dropdow");
			}else {
				click(SearchinDD);
				input(SearchinDD,Year);
				click(options);
				ExtentSuccessMessage("Successfully user Checked the new "+Year+" value from dropdow");
			}

		}else {
			//			if(ElementDisplayed(Elementsdd)) {
			//				click(Elementsdd);
			//			}

			if(ElementDisplayed(ElementsAgent)) {
				click(ElementsAgent);
				//				click(SearchAgent);
				//				input(SearchAgent,Year);
				//				click(options);
				//				ExtentSuccessMessage("Successfully user Checked the new "+Year+" value from dropdow");
			}

			click(options);
			ExtentSuccessMessage("Successfully user Checked the new "+Year+" value from dropdow");

		}


	}

	public void SelectThedropdown(String Year) throws InterruptedException {
		By Elementsdd=By.xpath("(//*[contains(@class,'dx-item dx-list-item')][@aria-selected='true']//*[@aria-checked='true'])[1]");
		//		By Elementsdd=By.xpath("//*[@class='dx-overlay-content dx-popup-normal dx-resizable dx-dropdowneditor-overlay-flipped']//*[contains(@class,'dx-item dx-list-item')][@aria-selected='true']//div[2]//div");
		By ElementsAgent =By.xpath("//*[@class='dx-overlay-content dx-popup-normal dx-resizable dx-dropdowneditor-overlay-flipped']//*[text()='All']//ancestor::div[@aria-selected='true']//*[@role='checkbox'] | //*[@class='dx-overlay-content dx-popup-normal dx-resizable dx-dropdowneditor-overlay-flipped']//div[@class='dx-agent-list']");
//		By ElementsAgent =By.xpath("//div[@class='dx-agent-list']");
		By Elements=By.xpath("//*[contains(@class,'dx-item dx-list-item')][@aria-selected='true']//*[@title='All']");
		By SearchinDD = By.xpath("//*[@class='dx-popup-content']//input[@role='textbox'][@spellcheck='false']");
		By SearchAgent =By.xpath("//*[@class='dx-overlay-content dx-popup-normal dx-resizable dx-dropdowneditor-overlay-flipped']//*[@class='dx-popup-content']//input[@role='textbox'][@spellcheck='false']//parent::div//parent::div[@class='dx-list-search dx-textbox dx-texteditor dx-editor-outlined dx-searchbox dx-show-clear-button dx-widget dx-texteditor-empty']");
		By options =By.xpath("//*[contains(@class,'dx-item dx-list-item')][@aria-selected='false']//*[@title='"+Year+"'] | //*[contains(@class,'dx-item dx-list-item')][@aria-selected='false']//*[text()='"+Year+"']");
		if(ElementDisplayed(Elements)) {
			click(Elements);
			ExtentSuccessMessage("Successfully user unchecked the existing value from dropdow");
			if(ElementDisplayed(options)) {
				click(options);
				ExtentSuccessMessage("Successfully user Checked the new "+Year+" value from dropdow");
			}else {
				click(SearchinDD);
				input(SearchinDD,Year);
				click(options);
				ExtentSuccessMessage("Successfully user Checked the new "+Year+" value from dropdow");
			}

		}else {
			if(ElementDisplayed(Elementsdd)) {
				click(Elementsdd);
			}
			if(ElementDisplayed(ElementsAgent)) {
				click(ElementsAgent);
				//				click(SearchAgent);
				//				input(SearchAgent,Year);
				//				click(options);
				//				ExtentSuccessMessage("Successfully user Checked the new "+Year+" value from dropdow");
			}

			click(options);
			ExtentSuccessMessage("Successfully user Checked the new "+Year+" value from dropdow");

		}


	}
	
	public void SelectThedropdownAgent(String Year) throws InterruptedException {
		By Elementsdd=By.xpath("(//*[contains(@class,'dx-item dx-list-item')][@aria-selected='true']//*[@aria-checked='true'])[1]");
//		By Elementsdd=By.xpath("//*[@class='dx-overlay-content dx-popup-normal dx-resizable dx-dropdowneditor-overlay-flipped']//*[contains(@class,'dx-item dx-list-item')][@aria-selected='true']//div[2]//div");
//		By ElementsAgent =By.xpath("//*[@class='dx-overlay-content dx-popup-normal dx-resizable dx-dropdowneditor-overlay-flipped']//*[text()='All']//ancestor::div[@aria-selected='true']//*[@role='checkbox'] | //*[@class='dx-overlay-content dx-popup-normal dx-resizable dx-dropdowneditor-overlay-flipped']//div[@class='dx-agent-list']");
		By ElementsAgent =By.xpath("//div[@class='dx-agent-list']");
		By Elements=By.xpath("//*[contains(@class,'dx-item dx-list-item')][@aria-selected='true']//*[@title='All']");
		By SearchinDD = By.xpath("//*[@class='dx-popup-content']//input[@role='textbox'][@spellcheck='false']");
		By SearchAgent =By.xpath("//*[@class='dx-overlay-content dx-popup-normal dx-resizable dx-dropdowneditor-overlay-flipped']//*[@class='dx-popup-content']//input[@role='textbox'][@spellcheck='false']//parent::div//parent::div[@class='dx-list-search dx-textbox dx-texteditor dx-editor-outlined dx-searchbox dx-show-clear-button dx-widget dx-texteditor-empty']");
		By options =By.xpath("//*[contains(@class,'dx-item dx-list-item')][@aria-selected='false']//*[@title='"+Year+"'] | //*[contains(@class,'dx-item dx-list-item')][@aria-selected='false']//*[text()='"+Year+"']");
		if(ElementDisplayed(Elements)) {
			click(Elements);
			ExtentSuccessMessage("Successfully user unchecked the existing value from dropdow");
			if(ElementDisplayed(options)) {
				click(options);
				ExtentSuccessMessage("Successfully user Checked the new "+Year+" value from dropdow");
			}else {
				click(SearchinDD);
				input(SearchinDD,Year);
				click(options);
				ExtentSuccessMessage("Successfully user Checked the new "+Year+" value from dropdow");
			}

		}else {
			if(ElementDisplayed(Elementsdd)) {
				click(Elementsdd);
			}
			if(ElementDisplayed(ElementsAgent)) {
				click(ElementsAgent);
				//				click(SearchAgent);
				//				input(SearchAgent,Year);
				//				click(options);
				//				ExtentSuccessMessage("Successfully user Checked the new "+Year+" value from dropdow");
			}

			click(options);
			ExtentSuccessMessage("Successfully user Checked the new "+Year+" value from dropdow");

		}


	}


	public void ValidateCommissionManagementTab() throws InterruptedException {	
		ClickOnMinimizeCallwindow();
		WaitUntillPAgeLoad();		
		click(CommissionManagementPageValidation);
		if (ElementDisplayed(CommissionManagementPageValidation)) {
			ExtentSuccessMessage("Successfully user Landed on 'Commission Management ' ");			
		} else {
			ExtentErrorMessage("Unsuccessfully user Not Loanded on 'Commission Management '' ");
		}
		ClickOnMinimizeCallwindow();
	}

	public void ValidateCommissionSetupTab() throws InterruptedException {	
		ClickOnMinimizeCallwindow();
		//		waitVisibility(File_Action);
		//		element = wait.until(ExpectedConditions.visibilityOfElementLocated(Commissionpageload));
		WaitUntillPAgeLoad();
		//		Thread.sleep(25000);
		click(CommissionSetUpPageValidation);
		if (ElementDisplayed(CommissionSetUpPageValidation)) {
			ExtentSuccessMessage("Successfully user Landed on 'Commission Set up ' ");			
		} else {
			ExtentErrorMessage("Unsuccessfully user Not Loanded on 'Commission Set up '' ");
		}
		ClickOnMinimizeCallwindow();
	}
	public void ClickOnCommissionSetUp() throws InterruptedException {
		Thread.sleep(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CommissionSetUp));
		MoveToElementClick(element);
		//click(CommissionSetUp);
		//		if (ElementDisplayed(CommissionSetUp)) {
		//			ExtentSuccessMessage("Successfully user able to See 'Commission Set Up' ");
		//			click(CommissionSetUp);
		ExtentSuccessMessage("Successfully user Clicked on 'Commission Set Up' ");
		//			RefreshPage();
		ValidateCommissionSetupTab();
		//		} else {
		//			ExtentSuccessMessage("Unsuccessfully 'Commission Set Up' Not visible");
		//		}
	}

	public void ClickOnCommissionManagement() throws InterruptedException {

		click(CommissionManagement);

		ExtentSuccessMessage("Successfully user Clicked on 'Commission Management' ");

		ValidateCommissionManagementTab();
	}
	public void NavvigateToCommissionSetUp() throws InterruptedException {
		hoverOnCommissionModule();
		ClickOnCommissionSetUp();
	}

	public void NavvigateToCommissionManagement() throws InterruptedException {
		hoverOnCommissionModule();
		ClickOnCommissionManagement();

	}



	public void validate_the_recalculate_functionality() throws InterruptedException {
		NavvigateToCommissionSetUp();
		ClickOnAddCommission();
		int Years=CurrentYear();
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
		ClickOnRecalculationCommission();
		String StartDate = "01/01/2024";
		String EndDate = "01/31/2024";
		EnterPolicy_Created_Start_Date(StartDate);
		EnterPolicy_Created_end_Date(EndDate);
		ClickOnRun();
		CheckSuccessmsg();
		ClickOnDeleteCommission();

	}

	public void verify_the_Commission_set_up_Commission_method_Any_And_PMPM() throws InterruptedException, AWTException, IOException {

		ExtentSuccessMessage("Start CM_TS_002_TC_001_verify_the_Commission_set_up_Commission_method_Any");
		String Carrier3 = "Aetna Health Inc. (a PA corp.)";
		String Agent31 = "1Agent M16";
		String Agent3 = null;
		String URL = configloader().getProperty("URL");
		if (URL.contains("https://mme.brokerengage.net/mme/")) {
			Agent3 = "1Agent  M16";
		}else {
			Agent3 = "1Agent M16";
		}
		System.out.println("Agent3:-"+Agent3);
		
		int CurrentYear = CurrentYear();
		String  CurrentYear3 = Integer.toString(CurrentYear);

		String CommissionRate3 ="20";
		String Product_Category3 ="Commercial SG";
		NavvigateToCommissionSetUp();
		ClickOnAddCommission();
		////		int Years3=2018;
		ClickOnPeriodDropdown();
		SelectThedropdown(CurrentYear3);
		ClickOnProduct_CategoryDropdown();
		SelectThedropdown(Product_Category3);		
		ClickOncarrierDropdown();
		SelectThedropdown(Carrier3);
		ClickOnAgentDropdown();
		By Value =By.xpath("//*[contains(@class,'dx-item dx-list-item')][@aria-selected='false']//*[@title='"+Agent3+"'] | //*[contains(@class,'dx-item dx-list-item')][@aria-selected='false']//*[text()='"+Agent3+"']");
		if(ElementDisplayed(Value)) {
			SelectThedropdownAgent(Agent3);
		}else{
			SelectThedropdownAgent(Agent31);
		}

		String Commissionmethod3 = "Per Member Per Month";
		ClickOnCommissionMethod();
		SelectThedropdown(Commissionmethod3);
		EnterCommissionRate(CommissionRate3);
		ClickOnSaveCommission();
		Thread.sleep(5000);
		SelectActiveDropdown(CommissionPeriodDropdown,CurrentYear3);
		SelectActiveDropdown(ProductCategoryDropdown, Product_Category3);
		SelectActiveDropdown(carrierNameDropdown, Carrier3);
		ClickOnSearchCommission();
		String Values3 = (CurrentYear3+","+Product_Category3+","+Carrier3+","+Agent31+","+"All"+","+"All"+","+"PMPM"+","+"20.00");
		ValidatetheGrid(Values3);
		ExtentSuccessMessage("End CM_TS_002_TC_001_verify_the_Commission_set_up_Commission_method_Any");
		ExtentSuccessMessage("***************************************************************");
		ExtentSuccessMessage("Start CM_TS_002_TC_003_verify_the_Commission_set_up_Commission_method_PMPM");
		HomePage.GotoHomepage1();
		CustomerPage.createNewCustomer();
		CustomerPage.createapolicy(Carrier3,Product_Category3,CurrentYear3,Agent3);
		//		int CurrentMonthNumber = CurrentMonth();
		String CurrentMonthNum = CurrentMonth();
		HomePage.GotoHomepage1();
		Thread.sleep(6000);
		
		NavvigateToCommissionSetUp();
		SelectActiveDropdown(CommissionPeriodDropdown,CurrentYear3);
		ClickOnSearchCommission();
		ExtentSuccessMessage("Start CM_TS_001_TC_008_validate_the_recalculate_functionality");
		ClickOnRecalculationCommission();
		int CurrentYearNumber =CurrentYear();
		String CurrentYearNumberNum = Integer.toString(CurrentYearNumber);

		String StartDate = CurrentMonthNum+"/01/"+CurrentYearNumberNum;
		String EndDate = CurrentMonthNum+"/28/"+CurrentYearNumberNum;
		EnterPolicy_Created_Start_Date(StartDate);
		EnterPolicy_Created_end_Date(EndDate);
		ClickOnRun();
		CheckSuccessmsg();
        
		ClickONReportTab();
		ClickONCommissiionReportunderreportTab();
		ClickONAgent_ProjectionsunderreportTab();
		ClickOnMinimizeCallwindow();
		SelectActiveDropdowns(CRMReportCarrierNameMulti,Carrier3);
		Base_Class.KeyOperation("TAB");
		Base_Class.KeyOperation("TAB");
		SelectActiveDropdowns(CRMReportYear,CurrentYear3);
		Base_Class.KeyOperation("TAB");	
		Base_Class.KeyOperation("TAB");	
//		Base_Class.RobotKeyOperation("TAB");
		SelectActiveDropdowns(ReportAgent,Agent3);
		Base_Class.KeyOperation("TAB");
		Base_Class.KeyOperation("TAB");	
//		click(MyReportsText);
		Thread.sleep(3000);
		ClickONrunReportBtnunderreportTab();
		Thread.sleep(15000);
		ValidatingthereportTable(Carrier3, Product_Category3, Agent3);
		ValidateAmount(CommissionRate3);
		
		HomePage.GotoHomepage1();
		CustomerPage.NavigateToCustomer();
		CustomerPage.SearchCustomer();
		CustomerPage.DeleteCustomer();
		HomePage.GotoHomepage1();
		NavvigateToCommissionSetUp();
		SelectActiveDropdown(CommissionPeriodDropdown,CurrentYear3);
		SelectActiveDropdown(ProductCategoryDropdown, Product_Category3);
		SelectActiveDropdown(carrierNameDropdown, Carrier3);
		ClickOnSearchCommission();
		ClickOnDeleteCommission();
		ExtentSuccessMessage("End CM_TS_002_TC_003_verify_the_Commission_set_up_Commission_method_PMPM");

	}

	public void validate_Commission_set_up_with_the_following_options1() throws InterruptedException, AWTException {
		ExtentSuccessMessage("Start CM_TS_002_TC_006_Commission_set_up_with_the_following_options");
		String Carrier3 = "Aetna Health Inc. (a PA corp.)";
		String Agent3 = "1Agent M16";
		String CurrentYear3 = "2024";
		String CommissionRate3 ="20";
		String Product_Category3 ="Commercial SG";
		NavvigateToCommissionSetUp();
		ClickOnAddCommission();
		////		int Years3=2018;
		ClickOnPeriodDropdown();
		SelectThedropdown(CurrentYear3);
		ClickOnProduct_CategoryDropdown();
		SelectThedropdown(Product_Category3);		
		ClickOncarrierDropdown();
		SelectThedropdown(Carrier3);
		ClickOnAgentDropdown();
		SelectThedropdown(Agent3);
		String Commissionmethod3 = "Per Member Per Month";
		ClickOnCommissionMethod();
		SelectThedropdown(Commissionmethod3);
		EnterCommissionRate(CommissionRate3);
		ClickOnSaveCommission();
		SelectActiveDropdown(CommissionPeriodDropdown,CurrentYear3);
		SelectActiveDropdown(ProductCategoryDropdown, Product_Category3);
		SelectActiveDropdown(carrierNameDropdown, Carrier3);
		ClickOnSearchCommission();
		String Values3 = (CurrentYear3+","+Product_Category3+","+Carrier3+","+Agent3+","+"All"+","+"All"+","+"PMPM"+","+"20.00");
		ValidatetheGrid(Values3);
		ExtentSuccessMessage("End CM_TS_002_TC_006_Commission_set_up_with_the_following_options");
		ExtentSuccessMessage("***************************************************************");
		HomePage.GotoHomepage1();
		CustomerPage.createNewCustomer();
		CustomerPage.createapolicy(Carrier3,Product_Category3,CurrentYear3,Agent3);
		//		int CurrentMonthNumber = CurrentMonth();
		String CurrentMonthNum = CurrentMonth();
		HomePage.GotoHomepage1();
		NavvigateToCommissionSetUp();
		SelectActiveDropdown(CommissionPeriodDropdown,CurrentYear3);
		ClickOnSearchCommission();
		ExtentSuccessMessage("Start CM_TS_001_TC_008_validate_the_recalculate_functionality");
		ClickOnRecalculationCommission();

		String StartDate = CurrentMonthNum+"/01/2024";
		String EndDate = CurrentMonthNum+"/31/2024";
		EnterPolicy_Created_Start_Date(StartDate);
		EnterPolicy_Created_end_Date(EndDate);
		ClickOnRun();
		CheckSuccessmsg();
		ExtentSuccessMessage("End CM_TS_001_TC_008_validate_the_recalculate_functionality");
		ExtentSuccessMessage("************************************************************");
		ClickONReportTab();
		ClickONCommissiionReportunderreportTab();
		ClickONAgent_ProjectionsunderreportTab();
		ClickOnMinimizeCallwindow();
		SelectActiveDropdowns(CRMReportCarrierNameMulti,Carrier3);
		Base_Class.RobotKeyOperation("TAB");
		Base_Class.RobotKeyOperation("TAB");
		Base_Class.RobotKeyOperation("TAB");
		SelectActiveDropdowns(CRMReportYear,CurrentYear3);
		Base_Class.RobotKeyOperation("TAB");	
		Base_Class.RobotKeyOperation("TAB");
		SelectActiveDropdowns(ReportAgent,Agent3);
		Base_Class.RobotKeyOperation("TAB");
		Thread.sleep(3000);
		ClickONrunReportBtnunderreportTab();
		Thread.sleep(15000);
		//		ClickONrunReportBtnunderreportTab();
		//		Thread.sleep(5000);
		ValidatingthereportTable( Carrier3, Product_Category3, Agent3);
		ValidateAmount(CommissionRate3);
		ExtentSuccessMessage("************************************************************");
		HomePage.GotoHomepage1();
		CustomerPage.NavigateToCustomer();
		CustomerPage.SearchCustomer();
		CustomerPage.DeleteCustomer();
		HomePage.GotoHomepage1();
		NavvigateToCommissionSetUp();
		SelectActiveDropdown(CommissionPeriodDropdown,CurrentYear3);
		SelectActiveDropdown(ProductCategoryDropdown, Product_Category3);
		SelectActiveDropdown(carrierNameDropdown, Carrier3);
		ClickOnSearchCommission();
		ClickOnDeleteCommission();
	}
	public void validate_Commission_set_up_with_the_following_options() throws InterruptedException, AWTException {
		//		ExtentSuccessMessage("Start CM_TS_002_TC_001_TC_005_Commission_set_up_with_the_following_options");
		NavvigateToCommissionSetUp();
		//		ClickOnAddCommission();
		//		int Years=2018;
		//		String CurrentYear = Integer.toString(Years);
		//		ClickOnPeriodDropdown();
		//		SelectThedropdown(CurrentYear);
		//		ClickOnProduct_CategoryDropdown();
		//		String Product_Category ="Dental";
		//		SelectThedropdown(Product_Category);
		//		String Carrier = "Aetna";
		//		String Agent = "1Agent M13";
		//		ClickOncarrierDropdown();
		//		SelectThedropdown(Carrier);
		//		ClickOnAgentDropdown();
		//		SelectThedropdown(Agent);
		//		String Commissionmethod = "Per Member Per Year";
		//		ClickOnCommissionMethod();
		//		SelectThedropdown(Commissionmethod);
		//		String CommissionRate ="96.00";
		//		EnterCommissionRate(CommissionRate);
		//		ClickOnSaveCommission();
		//		SelectActiveDropdown(CommissionPeriodDropdown,CurrentYear);
		//		SelectActiveDropdown(ProductCategoryDropdown, Product_Category);
		//		SelectActiveDropdown(carrierNameDropdown, Carrier);
		//		ClickOnSearchCommission();
		//		String Values = (CurrentYear+","+Product_Category+","+Carrier+","+Agent+","+"All"+","+"All"+","+Commissionmethod+","+CommissionRate);
		//		ValidatetheGrid(Values);
		//		//		ClickOnDeleteCommission();
		//		WaitUntillPAgeLoad();
		//		ExtentSuccessMessage("End CM_TS_002_TC_001_TC_005_Commission_set_up_with_the_following_options");
		//		ExtentSuccessMessage("***************************************************************");
		//		ExtentSuccessMessage("Start CM_TS_002_TC_002_Commission_set_up_with_the_following_options");
		//		ClickOnAddCommission();
		//		int Years1=2018;
		//		String CurrentYear1 = Integer.toString(Years1);
		//		ClickOnPeriodDropdown();
		//		SelectThedropdown(CurrentYear1);
		//		ClickOnProduct_CategoryDropdown();
		//		String Product_Category1 ="Accidental Insurance";
		//		SelectThedropdown(Product_Category1);
		//		String Carrier1 = "Absolute Total Care";
		//		String Agent1 = "1Agent M14";
		//		ClickOncarrierDropdown();
		//		SelectThedropdown(Carrier1);
		//		ClickOnAgentDropdown();
		//		SelectThedropdown(Agent1);
		//		String Commissionmethod1 = "Percentage";
		//		ClickOnCommissionMethod();
		//		SelectThedropdown(Commissionmethod1);
		//		String CommissionPercentage ="10";
		//		EnterCommissionPercentage(CommissionPercentage);
		//		ClickOnSaveCommission();
		//		SelectActiveDropdown(CommissionPeriodDropdown,CurrentYear1);
		//		SelectActiveDropdown(ProductCategoryDropdown, Product_Category1);
		//		SelectActiveDropdown(carrierNameDropdown, Carrier1);
		//		ClickOnSearchCommission();
		//		String Values1 = (CurrentYear1+","+Product_Category1+","+Carrier1+","+Agent1+","+"All"+","+"All"+","+Commissionmethod1+","+" "+","+CommissionPercentage);
		//		ValidatetheGrid(Values1);
		//		//		ClickOnDeleteCommission();	
		//		WaitUntillPAgeLoad();
		//		ExtentSuccessMessage("End CM_TS_002_TC_002_Commission_set_up_with_the_following_options");
		//		ExtentSuccessMessage("***************************************************************");
		//		ExtentSuccessMessage("Start CM_TS_002_TC_003_Commission_set_up_with_the_following_options");
		//		ClickOnAddCommission();
		//		int Years2=2018;
		//		String CurrentYear2 = Integer.toString(Years2);
		//		ClickOnPeriodDropdown();
		//		SelectThedropdown(CurrentYear2);
		//		ClickOnProduct_CategoryDropdown();
		//		String Product_Category2 ="Cancer/Critical Illness";
		//		SelectThedropdown(Product_Category2);
		//		String Carrier2 = "AARP - UNITEDHEALTHCARE OF ARIZONA";
		//		String Agent2 = "1Agent M15";
		//		ClickOncarrierDropdown();
		//		SelectThedropdown(Carrier2);
		//		ClickOnAgentDropdown();
		//		SelectThedropdown(Agent2);
		//		String Commissionmethod2 = "Per Member Per Month";
		//		ClickOnCommissionMethod();
		//		SelectThedropdown(Commissionmethod2);
		//		String CommissionRate2 ="20.00";
		//		EnterCommissionRate(CommissionRate2);
		//		ClickOnSaveCommission();
		//		SelectActiveDropdown(CommissionPeriodDropdown,CurrentYear2);
		//		SelectActiveDropdown(ProductCategoryDropdown, Product_Category2);
		//		SelectActiveDropdown(carrierNameDropdown, Carrier2);
		//		ClickOnSearchCommission();
		//		String Values2 = (CurrentYear2+","+Product_Category2+","+Carrier2+","+Agent2+","+"All"+","+"All"+","+"PMPM"+","+CommissionRate2);
		//		ValidatetheGrid(Values2);
		//		//		ClickOnDeleteCommission();
		//		WaitUntillPAgeLoad();		
		//		ExtentSuccessMessage("End CM_TS_002_TC_003_Commission_set_up_with_the_following_options");
		//		ExtentSuccessMessage("***************************************************************");
		ExtentSuccessMessage("Start CM_TS_002_TC_006_Commission_set_up_with_the_following_options");
		ClickOnAddCommission();
		//		int Years3=2018;
		String CurrentYear3 = "2024";
		ClickOnPeriodDropdown();
		SelectThedropdown(CurrentYear3);
		ClickOnProduct_CategoryDropdown();
		String Product_Category3 ="Commercial SG";
		SelectThedropdown(Product_Category3);
		String Carrier3 = "Aetna Health Inc. (a PA corp.)";
		String Agent3 = "1Agent M16";
		ClickOncarrierDropdown();
		SelectThedropdown(Carrier3);
		ClickOnAgentDropdown();
		SelectThedropdown(Agent3);
		String Commissionmethod3 = "Per Member Per Month";
		ClickOnCommissionMethod();
		SelectThedropdown(Commissionmethod3);
		String CommissionRate3 ="20";
		EnterCommissionRate(CommissionRate3);
		ClickOnSaveCommission();
		SelectActiveDropdown(CommissionPeriodDropdown,CurrentYear3);
		SelectActiveDropdown(ProductCategoryDropdown, Product_Category3);
		SelectActiveDropdown(carrierNameDropdown, Carrier3);
		ClickOnSearchCommission();
		String Values3 = (CurrentYear3+","+Product_Category3+","+Carrier3+","+Agent3+","+"All"+","+"All"+","+"PMPM"+","+"20.00");
		ValidatetheGrid(Values3);

		ExtentSuccessMessage("End CM_TS_002_TC_006_Commission_set_up_with_the_following_options");
		ExtentSuccessMessage("***************************************************************");



		HomePage.GotoHomepage1();
		CustomerPage.createNewCustomer();
		//		CustomerPage.createapolicy(Carrier,Product_Category,CurrentYear,Agent);
		//		CustomerPage.createapolicy(Carrier1,Product_Category1,CurrentYear1,Agent1);
		//		CustomerPage.createapolicy(Carrier2,Product_Category2,CurrentYear2,Agent2);
		CustomerPage.createapolicy(Carrier3,Product_Category3,CurrentYear3,Agent3);
		//		int CurrentMonthNumber = CurrentMonth();
		String CurrentMonthNum = CurrentMonth();
		HomePage.GotoHomepage1();
		NavvigateToCommissionSetUp();
		SelectActiveDropdown(CommissionPeriodDropdown,CurrentYear3);
		ClickOnSearchCommission();
		ExtentSuccessMessage("Start CM_TS_001_TC_008_validate_the_recalculate_functionality");
		ClickOnRecalculationCommission();

		String StartDate = CurrentMonthNum+"/01/2024";
		String EndDate = CurrentMonthNum+"/31/2024";
		EnterPolicy_Created_Start_Date(StartDate);
		EnterPolicy_Created_end_Date(EndDate);
		ClickOnRun();
		CheckSuccessmsg();
		ExtentSuccessMessage("End CM_TS_001_TC_008_validate_the_recalculate_functionality");
		ExtentSuccessMessage("************************************************************");

		//		ClickONReportTab();
		//		ClickONCommissiionReportunderreportTab();
		//		ClickONAgent_ProjectionsunderreportTab();
		//		SelectActiveDropdowns(CRMReportCarrierNameMulti,Carrier);
		//		Base_Class.RobotKeyOperation("TAB");
		//		Base_Class.RobotKeyOperation("TAB");
		//		SelectActiveDropdowns(CRMReportYear,CurrentYear);
		//		Base_Class.RobotKeyOperation("TAB");	
		//		Base_Class.RobotKeyOperation("TAB");
		//		SelectActiveDropdowns(ReportAgent,Agent);
		//		Base_Class.RobotKeyOperation("TAB");
		//		Base_Class.RobotKeyOperation("TAB");
		//		Thread.sleep(3000);
		//		ClickONrunReportBtnunderreportTab();
		//		Thread.sleep(5000);
		//		String j =ValidatingthereportTable( Carrier, Product_Category, Agent);
		//		ValidateTheAmount("96");
		//		ExtentSuccessMessage("************************************************************");
		//		//		RefreshPage();
		//		//		Thread.sleep(5000);
		//		//		ClickOnMinimizeCallwindow();
		//
		//		//		ClickONReportTab();
		//		//		ClickONCommissiionReportunderreportTab();
		//		//		ClickONAgent_ProjectionsunderreportTab();
		//		//		ClickOnMinimizeCallwindow();
		//		//		SelectActiveDropdowns(CRMReportCarrierNameMulti,Carrier3);
		//		//		Base_Class.RobotKeyOperation("TAB");
		//		//		Base_Class.RobotKeyOperation("TAB");
		//		//		SelectActiveDropdowns(CRMReportYear,CurrentYear3);
		//		//		Base_Class.RobotKeyOperation("TAB");		
		//		//		SelectActiveDropdowns(ReportAgent,Agent3);
		//		//		Base_Class.RobotKeyOperation("TAB");
		//		//		Thread.sleep(3000);
		//		//		ClickONrunReportBtnunderreportTab();
		//		//		Thread.sleep(5000);
		//		//		ValidatingthereportTable( Carrier3, Product_Category3, Agent3);
		//		//		int CommissionRates =20;
		//		//		int total = CommissionRates*12;
		//		//		String GrandTotal = Integer.toString(total);
		//		//		ValidateTheAmount(GrandTotal);
		//		//		ExtentSuccessMessage("************************************************************");
		//
		//		RefreshPage();
		//		Thread.sleep(5000);
		//		ClickOnMinimizeCallwindow();
		//
		//		ClickONReportTab();
		//		ClickONCommissiionReportunderreportTab();
		//		ClickONAgent_ProjectionsunderreportTab();
		//		ClickOnMinimizeCallwindow();
		//		SelectActiveDropdowns(CRMReportCarrierNameMulti,Carrier2);
		//		Base_Class.RobotKeyOperation("TAB");
		//		Base_Class.RobotKeyOperation("TAB");
		//		Base_Class.RobotKeyOperation("TAB");
		//		SelectActiveDropdowns(CRMReportYear,CurrentYear2);
		//		Base_Class.RobotKeyOperation("TAB");
		//		Base_Class.RobotKeyOperation("TAB");
		//		SelectActiveDropdowns(ReportAgent,Agent2);
		//		Base_Class.RobotKeyOperation("TAB");
		//		Thread.sleep(3000);
		//		ClickONrunReportBtnunderreportTab();
		//		Thread.sleep(5000);
		//		ValidatingthereportTable( Carrier2, Product_Category2, Agent2);
		//		int CommissionRates2 = 20;
		//		int totals = CommissionRates2*12;
		//		String GrandTotals = Integer.toString(totals);
		//		ValidateTheAmount(GrandTotals);
		//		ExtentSuccessMessage("************************************************************");
		//
		//		RefreshPage();
		//		Thread.sleep(5000);
		//		ClickOnMinimizeCallwindow();

		ClickONReportTab();
		ClickONCommissiionReportunderreportTab();
		ClickONAgent_ProjectionsunderreportTab();
		ClickOnMinimizeCallwindow();
		SelectActiveDropdowns(CRMReportCarrierNameMulti,Carrier3);
		Base_Class.RobotKeyOperation("TAB");
		Base_Class.RobotKeyOperation("TAB");
		Base_Class.RobotKeyOperation("TAB");
		SelectActiveDropdowns(CRMReportYear,CurrentYear3);
		Base_Class.RobotKeyOperation("TAB");	
		Base_Class.RobotKeyOperation("TAB");
		SelectActiveDropdowns(ReportAgent,Agent3);
		Base_Class.RobotKeyOperation("TAB");
		Thread.sleep(3000);
		ClickONrunReportBtnunderreportTab();
		Thread.sleep(5000);
		ClickONrunReportBtnunderreportTab();
		Thread.sleep(5000);
		ValidatingthereportTable( Carrier3, Product_Category3, Agent3);
		ValidateAmount(CommissionRate3);
		ExtentSuccessMessage("************************************************************");
		HomePage.GotoHomepage1();
		CustomerPage.NavigateToCustomer();
		CustomerPage.SearchCustomer();
		CustomerPage.DeleteCustomer();
		//		ClickOnDeleteCommission();

	}
	public void validate_user_clear_the_newly_entered_criterias() throws InterruptedException {
		NavvigateToCommissionSetUp();
		ClickOnAddCommission();
		//		int Years=CurrentYear();
		//		String CurrentYear = Integer.toString(Years);
		int Year=CurrentYear();
		int previousyear=Year-1;
		String previousyears = Integer.toString(previousyear);
		ClickOnPeriodDropdown();
		SelectThedropdown(previousyears);
		ClickOnProduct_CategoryDropdown();
		String Product_Category ="Medicare Advantage";
		SelectThedropdown(Product_Category);
		String Carrier = "Aetna Better Health of Virginia";
		ClickOncarrierDropdown();
		SelectThedropdown(Carrier);
		String Commissionmethod = "Per Member Per Year";
		ClickOnCommissionMethod();
		SelectThedropdown(Commissionmethod);
		String CommissionRate ="99.00";
		EnterCommissionRate(CommissionRate);
		ClickOnSaveCommission();
		SelectActiveDropdown(CommissionPeriodDropdown,previousyears);
		SelectActiveDropdown(ProductCategoryDropdown, Product_Category);
		SelectActiveDropdown(carrierNameDropdown, Carrier);
		ClickOnSearchCommission();
		String Values = (previousyears+","+Product_Category+","+Carrier+","+"All"+","+"All"+","+"All"+","+Commissionmethod+","+CommissionRate);
		ValidatetheGrid(Values);

		ClickOnClearFilter();
		NegativeValidatetheGrid(previousyears);
		SelectActiveDropdown(CommissionPeriodDropdown,previousyears);
		SelectActiveDropdown(ProductCategoryDropdown, Product_Category);
		SelectActiveDropdown(carrierNameDropdown, Carrier);
		ClickOnSearchCommission();
		ClickOnDeleteCommission();
	}
	public void SelectDropdownss(String Year) throws InterruptedException {
        By options2 =By.xpath("//*[contains(@class,'dx-item dx-list-item')][@aria-selected='false']//*[@title='"+Year+"']");
//      Base_Class.ScrollUntilElementVisible(options2);
        By SearchinDD = By.xpath("//*[@class='dx-popup-content']//input[@role='textbox'][@spellcheck='false']");
        click(SearchinDD);
        input(SearchinDD,Year);
        click(options2);
        ExtentSuccessMessage("Successfully user Checked the new "+Year+" value from dropdow");
 }

	public void Validate_Create_Search_Edit_Clear() throws InterruptedException {
		ExtentSuccessMessage("Start CM_TS_001_TC_001_validate_user_can_set_criteria_commission_rate Test case");
		System.out.println("Start CM_TS_001_TC_001_validate_user_can_set_criteria_commission_rate Test case");
		NavvigateToCommissionSetUp();
		ClickOnAddCommission();
		int Years=CurrentYear();
		String CurrentYear = Integer.toString(Years);
		ClickOnPeriodDropdown();
		SelectThedropdown(CurrentYear);
		ClickOnProduct_CategoryDropdown();
		String Product_Category ="Accident";
		SelectThedropdown(Product_Category);
		String Carrier1 = "Absolute Total Care";
		String Carrier = "Aetna Better Health of Virginia";
		ClickOncarrierDropdown();
		SelectThedropdown(Carrier1);
		String Commissionmethod = "Per Member Per Year";
		ClickOnCommissionMethod();
		SelectThedropdown1(Commissionmethod);
		String CommissionRate ="99.00";
		EnterCommissionRate(CommissionRate);
		ClickOnSaveCommission();
		System.out.println("End CM_TS_001_TC_001_validate_user_can_set_criteria_commission_rate Test case");
		System.out.println("****************************************************************************************************************");		
		System.out.println("Start CM_TS_001_TC_004_search_the_criterias_based_on_the_selected_fields");
		ExtentSuccessMessage("End CM_TS_001_TC_001_validate_user_can_set_criteria_commission_rate Test case");
		ExtentSuccessMessage("****************************************************************************************************************");		
		ExtentSuccessMessage("Start CM_TS_001_TC_004_search_the_criterias_based_on_the_selected_fields");
		SelectActiveDropdown(CommissionPeriodDropdown,CurrentYear);
		SelectActiveDropdown(ProductCategoryDropdown, Product_Category);
		SelectActiveDropdown(carrierNameDropdown, Carrier1);
		ClickOnSearchCommission();
		String Values = (CurrentYear+","+Product_Category+","+Carrier1+","+"All"+","+"All"+","+"All"+","+Commissionmethod+","+CommissionRate);
		ValidatetheGrid(Values);		
		System.out.println("End CM_TS_001_TC_004_search_the_criterias_based_on_the_selected_fields");
		System.out.println("*****************************************************************************************************************");	
		System.out.println("Start CM_TS_001_TC_005_validate_user_edit__the_existing_criterias");
		ExtentSuccessMessage("End CM_TS_001_TC_004_search_the_criterias_based_on_the_selected_fields");
		ExtentSuccessMessage("*****************************************************************************************************************");	
		ExtentSuccessMessage("Start CM_TS_001_TC_005_validate_user_edit__the_existing_criterias");
		ClickOnEditCommission();
		int Year=CurrentYear();
		int previousyear=Year-1;
		String previousyears = Integer.toString(previousyear);
		ClickOnPeriodDropdown();
		SelectThedropdown(previousyears);
		ClickOnProduct_CategoryDropdown();
		String Product_Category1 ="Accidental Insurance";
		SelectThedropdown1(Product_Category);
		SelectThedropdown1(Product_Category1);
		ClickOncarrierDropdown();
		SelectThedropdown1(Carrier1);
//		SelectThedropdown1(Carrier);
		SelectDropdownss(Carrier);
		String Commissionmethod1 = "Per Member Per Month";
		ClickOnCommissionMethod();
		SelectThedropdown1(Commissionmethod1);
		String CommissionRate1 ="96.00";
		EnterCommissionRate(CommissionRate1);
		ClickOnSaveCommission();
		SelectActiveDropdown(CommissionPeriodDropdown,previousyears);
		SelectActiveDropdown(ProductCategoryDropdown, Product_Category1);
		SelectActiveDropdown(carrierNameDropdown, Carrier);
		ClickOnSearchCommission();
		String EditValues = (previousyears+","+Product_Category1+","+Carrier+","+"All"+","+"All"+","+"All"+","+"PMPM"+","+CommissionRate1);
		ValidatetheGrid(EditValues);		
		System.out.println("End CM_TS_001_TC_005_validate_user_edit__the_existing_criterias");
		System.out.println("*****************************************************************************************************************");	
		System.out.println("Start CM_TS_001_TC_007_validate_user_clear_the_newly_entered_criterias");
		ExtentSuccessMessage("End CM_TS_001_TC_005_validate_user_edit__the_existing_criterias");
		ExtentSuccessMessage("*****************************************************************************************************************");	
		ExtentSuccessMessage("Start CM_TS_001_TC_007_validate_user_clear_the_newly_entered_criterias");
		ClickOnClearFilter();
		NegativeValidatetheGrid(CurrentYear);
		RefreshPage();
		Thread.sleep(10000);
		ClickOnMinimizeCallwindow();
		Thread.sleep(5000);
		SelectActiveDropdown(CommissionPeriodDropdown,previousyears);
		SelectActiveDropdown(ProductCategoryDropdown, Product_Category1);
		SelectActiveDropdown(carrierNameDropdown, Carrier);
		ClickOnSearchCommission();
		ClickOnDeleteCommission();
		System.out.println("End CM_TS_001_TC_007_validate_user_clear_the_newly_entered_criterias");
		ExtentSuccessMessage("End CM_TS_001_TC_007_validate_user_clear_the_newly_entered_criterias");
		ExtentSuccessMessage("*****************************************************************************************************************");	
		ExtentSuccessMessage("Start CM_TS_001_TC_008_validate_the_recalculate_functionality");
		ClickOnRecalculationCommission();
		String StartDate = "01/01/"+previousyears;
		String EndDate = "01/31/"+previousyears;
		EnterPolicy_Created_Start_Date(StartDate);
		EnterPolicy_Created_end_Date(EndDate);
		ClickOnRun();
		CheckSuccessmsg();
		ExtentSuccessMessage("END CM_TS_001_TC_008_validate_the_recalculate_functionality");
		ExtentSuccessMessage("*****************************************************************************************************************");			
	}
	public void validate_user_edit_the_existing_criterias() throws InterruptedException {
		NavvigateToCommissionSetUp();
		ClickOnAddCommission();
		int Years=CurrentYear();
		String CurrentYear = Integer.toString(Years);
		ClickOnPeriodDropdown();
		SelectThedropdown(CurrentYear);
		ClickOnProduct_CategoryDropdown();
		String Product_Category ="Medicare Advantage";
		SelectThedropdown(Product_Category);
		String Carrier = "Aetna Better Health of Virginia";
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
		ClickOnEditCommission();
		int Year=CurrentYear();
		int previousyear=Year-1;
		String previousyears = Integer.toString(previousyear);
		ClickOnPeriodDropdown();
		SelectThedropdown(previousyears);
		ClickOnSaveCommission();
		SelectActiveDropdown(CommissionPeriodDropdown,previousyears);
		SelectActiveDropdown(ProductCategoryDropdown, Product_Category);
		SelectActiveDropdown(carrierNameDropdown, Carrier);
		ClickOnSearchCommission();
		String Values = (previousyears+","+Product_Category+","+Carrier+","+"All"+","+"All"+","+"All"+","+Commissionmethod+","+CommissionRate);
		ValidatetheGrid(Values);
		ClickOnDeleteCommission();
	}
	public void validate_search_the_criterias_based_on_the_selected_fields() throws InterruptedException {
		NavvigateToCommissionSetUp();
		ClickOnAddCommission();
		int Years=CurrentYear();
		String CurrentYear = Integer.toString(Years);
		ClickOnPeriodDropdown();
		SelectThedropdown(CurrentYear);
		ClickOnProduct_CategoryDropdown();
		String Product_Category ="Medicare Advantage";
		SelectThedropdown(Product_Category);
		String Carrier = "Aetna Better Health of Virginia";
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

	public void validate_user_can_set_criteria_commission_rate() throws InterruptedException {
		NavvigateToCommissionSetUp();
		ClickOnAddCommission();
		int Years=CurrentYear();
		String CurrentYear = Integer.toString(Years);
		ClickOnPeriodDropdown();
		SelectThedropdown(CurrentYear);
		ClickOnProduct_CategoryDropdown();
		String Product_Category ="Medicare Advantage";
		SelectThedropdown(Product_Category);
		String Carrier = "Aetna Better Health of Virginia";
		ClickOncarrierDropdown();
		SelectThedropdown(Carrier);
		String Commissionmethod = "Per Member Per Year";
		ClickOnCommissionMethod();
		SelectThedropdown(Commissionmethod);
		String CommissionRate ="99.00";
		EnterCommissionRate(CommissionRate);
		ClickOnSaveCommission();
	}


	public void ValidateCommissionManagement() throws InterruptedException, AWTException, InvalidFormatException {
		LoginUsername=Base_Class.LoginUserName;
		String CarrierName = "Commission Management";
		String CurrentDate =Currentdate();
		String Mappername = "CommissionManagementMapper";
		ExtentSuccessMessage("Started PreCondition");
		Carrier360.CreatingCarrierGroup();
		HomePage.GotoHomepage1();
		CustomerPage.NavigateCustomerModule();
		CustomerPage.SearchCustomer(CarrierName+"1");
		CustomerPage.SearchCustomer(CarrierName+"2");
		CustomerPage.SearchCustomer(CarrierName+"3");
		CustomerPage.SearchCustomer(CarrierName+"4");
		CustomerPage.SearchCustomer(CarrierName+"5");
		HomePage.GotoHomepage1();
		ExtentSuccessMessage("END PreCondition");
		ExtentSuccessMessage("**********************************************");
		ExtentSuccessMessage("Started CAM_TS_001_TC_001_select_Carrier_Group");
		NavvigateToCommissionManagement();
		SelectActiveDropdown(CarrierGroup, CarrierName);
		ExtentSuccessMessage("Carrier Group has been clicked and selected "+CarrierName);
		ExtentSuccessMessage("End CAM_TS_001_TC_001_select_Carrier_Group");
		ExtentSuccessMessage("**********************************************");
		ExtentSuccessMessage("Started CAM_TS_001_TC_002_carrier_group_displaying_under_carrier_dropdown");

		Thread.sleep(5000);
		waitVisibility(Carrier);
		click(Carrier);		
		ExtentSuccessMessage("Carrier Button has been clicked");
		String Value = GetElementText(SelectedDropdown);
		System.out.println("Selected Dropdown :-"+Value);
		Thread.sleep(1000);
		Base_Class.RobotKeyOperation("TAB");
		Thread.sleep(1000);
		Base_Class.RobotKeyOperation("TAB");
		Thread.sleep(1000);
		Base_Class.RobotKeyOperation("TAB");
		ExtentSuccessMessage("End CAM_TS_001_TC_002_carrier_group_displaying_under_carrier_dropdown");
		ExtentSuccessMessage("**********************************************");
		ExtentSuccessMessage("Start CAM_TS_001_TC_003_Carrier_statement_file_upload");

		element = wait.until(ExpectedConditions.presenceOfElementLocated(StatementDate));
		writeText(StatementDate,CurrentDate+ Keys.ENTER ); 
		Thread.sleep(1000);
		Base_Class.RobotKeyOperation("TAB");
		Thread.sleep(1000);
		ExtentSuccessMessage("Successfully user entered the 'Statement_Date in text field' "+CurrentDate);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(UploadCarrierStatement));
		MoveToElementClick(element);
		ExtentSuccessMessage("Upload Carrier Statement Button has been clicked");
		//		Thread.sleep(6000);
		//		element = wait.until(ExpectedConditions.presenceOfElementLocated(DefaultTemplate));
		//		MoveToElementClick(element);
		//		ExtentSuccessMessage("Download Default Template Button has been clicked");

		element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierFileUpload));
		MoveToElementClick(element);
		ExtentSuccessMessage("Upload File Button has been clicked");

		Thread.sleep(6000);
		Robot robot = new Robot();
		//		String filepaths = System.getProperty("user.dir") + 
		String filePath = System.getProperty("user.dir") + "\\Upload\\Default_Carrier_Statement_Template (1).xlsx";
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
		Thread.sleep(8000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(SubmitFile));
		MoveToElementClick(element);
		ExtentSuccessMessage("NEXT BUTTON (Submit File) Button has been clicked");
		ExtentSuccessMessage("End CAM_TS_001_TC_003_Carrier_statement_file_upload");
		ExtentSuccessMessage("**********************************************");

		ExtentSuccessMessage("Start CAM_TS_001_TC_004_map_uploaded_save_the_template");

		waitVisibility(SaveCarrierStatement);
		Thread.sleep(5000);
		click(SaveCarrierStatement);
		Thread.sleep(2000);

		By options = By.xpath("//*[@class='custom-select open']//span[contains(text(),'"+Mappername+"')]//parent::li//a");
		if(ElementDisplayed(options)) {
			click(options);
			ExtentSuccessMessage("Successfully user found and clicked on the "+Mappername+" value inside the dropdown ");
			String msgs = GetElementText(Deletemsg);
			System.out.println("msgs:-"+msgs);
			Assert.assertEquals(msgs, "Are you sure you want to delete carrier statement mapping?");
			ExtentSuccessMessage("Are you sure you want to delete carrier statement mapping?");
			click(Deleteconfirmation);
		}else {

		}





		//		By options = By.xpath("//*[@class='custom-select open']//span[contains(text(),'"+Mappername+"')]");
		//		if(ElementDisplayed(options)) {
		//			click(options);
		//			ExtentSuccessMessage("Successfully user found and clicked on the "+Mappername+" value inside the dropdown ");
		//		}else {		
		String SubscriberNameDropdownvalue ="Customer Name";
		String CommissionRateDropdownvalue ="Commission Received";
		String EffectiveDateDropdownvalue ="Effective Date";
		String PaidThroughDateDropdownvalue ="Paid Through Date";
		String AgentNameDropdownvalue ="Agent Name";
		waitVisibility(SubscriberNameDropdown);

		By L_SubscriberNameDropdown = By.xpath("//*[contains(text(),'Subscriber Name')]//parent::tr//td//select//*[@label='"+SubscriberNameDropdownvalue+"']");
		By L_CommissionRateDropdown = By.xpath("//*[contains(text(),'Commission Received ($)')]//parent::tr//td//select//*[@label='"+CommissionRateDropdownvalue+"']");
		By L_EffectiveDateDropdown = By.xpath("//*[contains(text(),'Effective Date')]//parent::tr//td//select//*[@label='"+EffectiveDateDropdownvalue+"']");
		By L_PaidThroughDateDropdown = By.xpath("//*[contains(text(),'Paid Through Date')]//parent::tr//td//select//*[@label='"+PaidThroughDateDropdownvalue+"']");
		By L_AgentNameDropdown = By.xpath("//*[contains(text(),'Agent Name')]//parent::tr//td//select//*[@label='"+AgentNameDropdownvalue+"']");
		Thread.sleep(5000);
		click(SubscriberNameDropdown);
		Thread.sleep(2000);
		click(L_SubscriberNameDropdown);
		//		Base_Class.RobotKeyOperation("TAB");
		//		SelectActiveDropdown1(SubscriberNameDropdown, SubscriberNameDropdownvalue);
		ExtentSuccessMessage("Subscriber Name has been clicked and selected "+SubscriberNameDropdownvalue);
		click(CommissionRateDropdown);
		Thread.sleep(2000);
		//		SelectActiveDropdown1(CommissionRateDropdown, CommissionRateDropdownvalue);
		click(L_CommissionRateDropdown);
		//		Base_Class.RobotKeyOperation("ENTER");
		ExtentSuccessMessage("Commission Rate has been clicked and selected "+CommissionRateDropdownvalue);
		click(EffectiveDateDropdown);
		Thread.sleep(2000);
		click(L_EffectiveDateDropdown);
		//		Base_Class.RobotKeyOperation("ENTER");
		//		SelectActiveDropdown1(EffectiveDateDropdown, EffectiveDateDropdownvalue);
		ExtentSuccessMessage("Effective Date has been clicked and selected "+EffectiveDateDropdownvalue);
		click(PaidThroughDateDropdown);
		Thread.sleep(2000);
		click(L_PaidThroughDateDropdown);
		//		Base_Class.RobotKeyOperation("TAB");
		//		SelectActiveDropdown1(PaidThroughDateDropdown, PaidThroughDateDropdownvalue);
		ExtentSuccessMessage("Paid Through Date has been clicked and selected "+PaidThroughDateDropdownvalue);
		Thread.sleep(2000);
		Base_Class.ScrollUntilElementVisible(NextExcelcolumn);
		Thread.sleep(2000);
		click(AgentNameDropdown1);
		Thread.sleep(2000);
		click(AgentNameDropdown);
		Thread.sleep(2000);
		click(L_AgentNameDropdown);
		Thread.sleep(2000);
		click(AgentNameDropdown1);
		//		Base_Class.RobotKeyOperation("TAB");
		//		SelectActiveDropdown1(AgentNameDropdown, AgentNameDropdownvalue);
		ExtentSuccessMessage("Agent Name has been clicked and selected "+AgentNameDropdownvalue);
		if(ElementDisplayed(SaveCarrierStatementMapping)) {
			System.out.println("dEBUG:-1");
			click(SaveCarrierStatementMapping);		
			ExtentSuccessMessage("Save Carrier Statement Mapping Check Box has been clicked");
		}else {
			System.out.println("dEBUG:-2");
			Base_Class.ScrollUntilElementVisible(SaveCarrierStatementMapping);
			click(SaveCarrierStatementMapping);		
			ExtentSuccessMessage("Save Carrier Statement Mapping Check Box has been clicked");
		}
		waitVisibility(EnterMapname);
		writeText(EnterMapname,Mappername); 
		ExtentSuccessMessage("Successfully user entered the 'Mapper name in text field' "+Mappername);
		Thread.sleep(2000);
		SaveMapper();
		BackToUploadSection();
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SubmitFile));
		MoveToElementClick(element);
		ExtentSuccessMessage("NEXT BUTTON (Submit File) Button has been clicked");
		waitVisibility(SaveCarrierStatement);
		Thread.sleep(5000);

		SelectActiveDropdown1(SaveCarrierStatement, Mappername);
		//		}
		Thread.sleep(5000);
		ExtentSuccessMessage("End CAM_TS_001_TC_004_map_uploaded_save_the_template");
		ExtentSuccessMessage("**********************************************");
		ExtentSuccessMessage("Start CAM_TS_001_TC_006_Submit_carrier_statement_file");
		waitVisibility(NextExcelcolumn);
		click(NextExcelcolumn);		
		ExtentSuccessMessage("Next Excel Column field  has been clicked");
		String Paragraphmsg = GetElementText(SaveParagraph);
		System.out.println("Paragraphmsg:"+Paragraphmsg);
		//		Assert.assertEquals(Paragraphmsg, "Carrier statement is being processed. You will receive an email notification once the file is uploaded. Alternately, you can check the status under 'Pending Upload.'");
		if(Paragraphmsg.contains("Carrier statement is being processed. You will receive an email notification once the file is uploaded.")) {
			ExtentSuccessMessage("User Carrier statement is being processed. You will receive an email notification once the file is uploaded.");

		}
		click(ConfirmParagraph);		
		ExtentSuccessMessage("Confirm Paragraph  has been clicked");
		ExtentSuccessMessage("End CAM_TS_001_TC_006_Submit_carrier_statement_file");
		ExtentSuccessMessage("**********************************************");
		Thread.sleep(2000);
		ExtentSuccessMessage("Start CAM_TS_001_TC_007_Validaion_status_in_Pending_Upload_UI");
		waitVisibility(PendingUploadFile);
		click(PendingUploadFile);		
		ExtentSuccessMessage("Pending Upload File  has been clicked");
		String msg="";
		try {
			do {
				waitVisibility(RefreshGrid);
				Thread.sleep(3000);
				click(RefreshGrid);
				Thread.sleep(3000);
				msg=GetElementText(GridStatus);
				System.out.println("msg:"+msg);
			}
			while(!msg.contains("Ready For Review"));
		} catch (org.openqa.selenium.StaleElementReferenceException e) {
			System.out.println("State element");
			do {
				waitVisibility(RefreshGrid);
				Thread.sleep(3000);
				click(RefreshGrid);
				Thread.sleep(3000);
				msg=GetElementText(GridStatus);
				System.out.println("msg:"+msg);
			}
			while(!msg.contains("Ready For Review"));
		}
		waitVisibility(RefreshGrid);
		click(RefreshGrid);
		Thread.sleep(3000);
		waitVisibility(RefreshGrid);
		click(RefreshGrid);
		Thread.sleep(3000);
		waitVisibility(RefreshGrid);
		click(RefreshGrid);
		Thread.sleep(3000);
		waitVisibility(RefreshGrid);
		click(RefreshGrid);
		Thread.sleep(3000);

		String Values = (","+Value+":"+CurrentDate+":"+"5"+":"+"4"+":"+msg+":"+Mappername+":"+LoginUsername);
		ValidateCommissionmanagementgridRow(Values);
		ExtentSuccessMessage("End CAM_TS_001_TC_007_Validaion_status_in_Pending_Upload_UI");
		ExtentSuccessMessage("**********************************************");
		ExtentSuccessMessage("Start CAM_TS_001_TC_008_view_Completed_validation_by_clicking_View_Icon_Download_the_file");

		ReviewExportFile();

		By CoulnmHeader = By.xpath("//*[@aria-colindex='7'][@role='columnheader'][contains(@style,'text-align: left; min')]");
		By Elementsa = By.xpath("(//*[@aria-colindex='7'][@role='gridcell'][contains(@style,'text-align: left; min')])[2]");
		String Firstrowvalue = GetElementText(Elementsa);
		System.out.println("Firstrowvalue:"+Firstrowvalue);
		do {
			waitVisibility(CoulnmHeader);
			Thread.sleep(3000);
			click(CoulnmHeader);
			Thread.sleep(3000);
			Firstrowvalue=GetElementText(Elementsa);
			System.out.println("Firstrowvalue1:"+Firstrowvalue);
		}
		while(!Firstrowvalue.contains(CarrierName+"1"));


		DownloadExportFile();
		ValidationStatus();
		File Failesname =Base_Class.getLatestFileFromFolder(Base_Class.DownloadDirectory, "xlsx");
		System.out.println("Failesnaem:-"+Failesname);
		// Convert the File object to a String (get the file path)
		String filePaths = Failesname.getAbsolutePath();

		// Print the file path as a String
		System.out.println("File Path as String: " + filePaths);
		FailedStatus();
		StatusOk();
		String Size = GetElementText(FailedCount);
		ExtentSuccessMessage("Failed Row Count:-"+Size);
		int num = Integer.parseInt(Size);
		for(int i=1;i<=num;i++) {
			Thread.sleep(2000);
			By Elements =By.xpath("(//tbody//tr[@class='dx-row dx-data-row dx-column-lines'])["+1+"]//td[@role='gridcell'][@aria-colindex='3']");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Elements));
			String ActualColunmName =element.getText();
			if(i<1) {
			}else {
				ExtentSuccessMessage("Successfully user found the Failed reason :-"+ActualColunmName);	
			}
			//			ExtentSuccessMessage("Successfully user found the Failed reason :-"+ActualColunmName);
			//			ExtentSuccessMessage("Row Count:-"+i);
		}
		ExtentSuccessMessage("End CAM_TS_001_TC_008_view_Completed_validation_by_clicking_View_Icon_Download_the_file");
		ExtentSuccessMessage("**********************************************");
		BacktomappingSection();
		ExtentSuccessMessage("Start CAM_TS_001_TC_009_Delete_Pending_Uploads_UI");		
		DeleteTheRow();
		ExtentSuccessMessage("End CAM_TS_001_TC_009_Delete_Pending_Uploads_UI");
		ExtentSuccessMessage("**********************************************");
		ExtentSuccessMessage("Start CAM_TS_001_TC_010_Validate_whether_the_user_is_able_to_view_data_in_downloaded_excel");	
		for (int i = 1; i <= 5; i++) {
			String readexcelsheet=Readexcel1(filePath,i);
			String Readexcelsheet=Readexcel(filePaths,i);
			//			System.out.println("readexcelsheet"+i+":-"+readexcelsheet.trim());
			// Trim the input and split it by ":"
			String[] uploadedExcelSheet = readexcelsheet.trim().split(":");

			int j=0;
			// Iterate over the array and print the individual elements
			for (String data : uploadedExcelSheet) {
				// Use trim to remove leading/trailing spaces from each element
				//	            System.out.println(data.trim());
				//	        	if(j==4) {
				//	        		uploadedExcelSheet[j]=uploadedExcelSheet[j]+"0";
				//	        	}
				if(Readexcelsheet.contains(uploadedExcelSheet[j])) {
					System.out.println("Contains in sheet"+j);
					ExtentSuccessMessage("Successfully user is able to view data in downloaded excel."+uploadedExcelSheet[j]);
				}else {
					ExtentErrorMessage("Unsuccessfully user is Not able to view data in downloaded excel."+uploadedExcelSheet[j]);
				}
				j++;
			}
		}

		ExtentSuccessMessage("End CAM_TS_001_TC_010_Validate_whether_the_user_is_able_to_view_data_in_downloaded_excel.");
		ExtentSuccessMessage("**********************************************");
	}


	public void StatusOk() throws InterruptedException {
		if (ElementDisplayed(StatusOkButton)) {
			ExtentSuccessMessage("Successfully user able to See 'Okay button  ' ");
			click(StatusOkButton);
			ExtentSuccessMessage("Successfully user clicked on the 'Okay button  ' ");
		} else {
			ExtentErrorMessage("Unsuccessfully 'Okay button ' Not visible");
		}

	}
	public void FailedStatus() throws InterruptedException {
		if (ElementDisplayed(FailedStatus)) {
			ExtentSuccessMessage("Successfully user able to See 'Failed Status ' ");
			click(FailedStatus);
			ExtentSuccessMessage("Successfully user clicked on the 'Failed Status ' ");
		} else {
			ExtentErrorMessage("Unsuccessfully 'Failed Status' Not visible");
		}

	}
	public void ValidationStatus() throws InterruptedException {
		if (ElementDisplayed(ValidationStatus)) {
			ExtentSuccessMessage("Successfully user able to See 'Validation Status ' ");
			click(ValidationStatus);
			ExtentSuccessMessage("Successfully user clicked on the 'Validation Status ' ");
		} else {
			ExtentErrorMessage("Unsuccessfully 'ValidationStatus' Not visible");
		}

	}

	public void SaveMapper() throws InterruptedException {
		click(SaveMapperName);		
		ExtentSuccessMessage("Save Mapping Text field  has been clicked");
		String Msgs=GetElementText(Success_Message);
		Assert.assertEquals(Msgs, "Mapping has been saved successfully.");
		ExtentSuccessMessage("Mapping has been saved successfully.");
	}


	public void SelectActiveDropdown1 (By by, String value) throws InterruptedException {
		if(ElementDisplayed(by)) {
			click(by);
			Thread.sleep(2000);
			By options = By.xpath("//*[@class='custom-select open']//span[contains(text(),'"+value+"')]");
			if(ElementDisplayed(options)) {
				click(options);
				ExtentSuccessMessage("Successfully user found and clicked on the "+value+" value inside the dropdown ");
			}else {
				Base_Class.ScrollUntilElementVisible(options);
				click(options);
				ExtentSuccessMessage("Successfully user found and clicked on the "+value+" value inside the dropdown ");				
			}
		}else {
			ExtentErrorMessage("UnSuccessfully user not found and clicked on the "+value+" value inside the dropdown ");
		}
	}

	public void SelectActiveDropdown (By by, String value) throws InterruptedException {
		Thread.sleep(2000);
		if(ElementDisplayed(by)) {
			click(by);
			Thread.sleep(2000);
			By options = By.xpath("//*[contains(@class,'dropDown md-active md-clickable')]//*[@value='"+value+"']");
			By optionsj = By.xpath("//*[contains(@class,'dropDown md-active md-clickable')]//*[@label='"+value+"']");
			if(ElementDisplayed(options)) {
				click(options);
				ExtentSuccessMessage("Successfully user found and clicked on the "+value+" value inside the dropdown ");
			}else {
				Base_Class.ScrollUntilElementVisible(options);
				click(options);
				ExtentSuccessMessage("Successfully user found and clicked on the "+value+" value inside the dropdown ");				
			}
		}else {
			ExtentErrorMessage("UnSuccessfully user not found and clicked on the "+value+" value inside the dropdown ");
		}

	}
	public void SelectActiveDropdowns (By by, String value) throws InterruptedException {
		//		Base_Class.ScrollUntilElementVisible(by);
		if(ElementDisplayed(by)) {
			click(by);
			Thread.sleep(2000);
			By options = By.xpath("//*[contains(@class,'dropDown md-active md-clickable')]//*[@value='"+value+"']");
			By option = By.xpath("//*[contains(@class,'dropDown md-active md-clickable')]//*[@value='All'][@selected='selected']");
			By optionj = By.xpath("//*[contains(@class,'dropDown md-active md-clickable')]//*[@value='All']");

			if(ElementDisplayed(option)) {
				//				Base_Class.ScrollUntilElementVisible(option);
				click(option);
			}else {
				if(ElementDisplayed(optionj)) {
					click(optionj);
				}
				if(ElementDisplayed(option)) {
					//				Base_Class.ScrollUntilElementVisible(option);
					click(option);
				}
			}

			if(ElementDisplayed(options)) {
				click(options);
				ExtentSuccessMessage("Successfully user found and clicked on the "+value+" value inside the dropdown ");
			}
		}else {
			ExtentErrorMessage("UnSuccessfully user not found and clicked on the "+value+" value inside the dropdown ");
		}

	}

	public void hoverOnCommissionModule() throws InterruptedException {
		//		Thread.sleep(15000);
		waitVisibility(CommissionModule);
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
	public void ValidatetheGrid(String Values) throws InterruptedException {

		String[] ExpectedColnumname =Values.split(",");
		for(int i=0;i<=7;i++) {
			int j = i+2;
			Thread.sleep(2000);
			By Elements =By.xpath("//td[@role='gridcell'][@aria-colindex='"+j+"']");
			Base_Class.ScrollUntilElementVisible(Elements);
			Thread.sleep(2000);
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
				if(ActualColunmName.contains("PMPY")){
					ActualColunmName = "Per Member Per Year";
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
	public void NegativeValidatetheGrid(String Values) throws InterruptedException {
		By Elements =By.xpath("//*[@name='CRMCommissionPeriod'][contains(@aria-label,'Commission Period  :')]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Elements));
		String ActualColunmName =element.getAttribute("aria-label");
		//				element.getText();
		System.out.println("Actual Column Name: " + ActualColunmName);
		Assert.assertNotEquals(Values, ActualColunmName);
		ExtentSuccessMessage("Successfully user found the expected Colunm name:- Expected:- "+Values+" | Actual:- "+ActualColunmName+"");
	}

	public void EnterCommissionRate(String value) throws InterruptedException {		
		if (ElementDisplayed(CommissionRate)) {
			ExtentSuccessMessage("Successfully user able to See 'CommissionRate ' ");
			clear(CommissionRate);
			writeText(CommissionRate,value);
			ExtentSuccessMessage("Successfully user entered the 'CommissionRate in text field' "+value);
		} else {
//			ExtentErrorMessage("Unsuccessfully 'CommissionRate' Not visible");
			Base_Class.ScrollUntilElementVisible(CommissionRate);
			if (ElementDisplayed(CommissionRate)) {
				ExtentSuccessMessage("Successfully user able to See 'CommissionRate ' ");
				clear(CommissionRate);
				writeText(CommissionRate,value);
				ExtentSuccessMessage("Successfully user entered the 'CommissionRate in text field' "+value);
			} else {
				ExtentErrorMessage("Unsuccessfully 'CommissionRate' Not visible");
			}
		}
	}

	public void EnterCommissionPercentage(String value) throws InterruptedException {		
		if (ElementDisplayed(CommissionPercentage)) {
			ExtentSuccessMessage("Successfully user able to See 'CommissionPercentage ' ");
			writeText(CommissionPercentage,value);
			ExtentSuccessMessage("Successfully user entered the 'CommissionPercentage in text field' "+value);
		} else {
			ExtentErrorMessage("Unsuccessfully 'CommissionPercentage' Not visible");
		}
	}

	public void EnterPolicy_Created_Start_Date(String value) throws InterruptedException {		
		if (ElementDisplayed(Policy_Created_Start_Date)) {
			ExtentSuccessMessage("Successfully user able to See 'Policy_Created_Start_Date ' ");
			writeText(Policy_Created_Start_Date,value+Keys.ENTER);
			ExtentSuccessMessage("Successfully user entered the 'Policy_Created_Start_Date in text field' "+value);
		} else {
			ExtentErrorMessage("Unsuccessfully 'Policy_Created_Start_Date' Not visible");
		}
	}
	public void EnterPolicy_Created_end_Date(String value) throws InterruptedException {		
		if (ElementDisplayed(Policy_Created_end_Date)) {
			ExtentSuccessMessage("Successfully user able to See 'Policy_Created_end_Date ' ");
			writeText(Policy_Created_end_Date,value+Keys.ENTER);
			ExtentSuccessMessage("Successfully user entered the 'Policy_Created_end_Date in text field' "+value);
		} else {
			ExtentErrorMessage("Unsuccessfully 'Policy_Created_end_Date' Not visible");
		}
	}

	public void ValiCommisssionOnpolicyTab() throws InterruptedException, AWTException {
		ClickOnMinimizeCallwindow();
		NavvigateToCommissionSetUp();
		ClickOnAddCommission();
		int Years=2018;
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
		String CommissionRate ="99";
		EnterCommissionRate(CommissionRate);
		ClickOnSaveCommission();
		HomePage.GotoHomepage();
		CustomerPage.createNewCustomer();
		CustomerPage.createapolicy(Carrier,Product_Category,CurrentYear,"");
		HomePage.GotoHomepage();
		NavvigateToCommissionSetUp();
		SelectActiveDropdown(CommissionPeriodDropdown,CurrentYear);
		SelectActiveDropdown(ProductCategoryDropdown, Product_Category);
		SelectActiveDropdown(carrierNameDropdown, Carrier);
		ClickOnSearchCommission();
		ClickOnRecalculationCommission();
		String StartDate = "01/01/2018";
		String EndDate = "12/31/2018";
		EnterPolicy_Created_Start_Date(StartDate);
		EnterPolicy_Created_end_Date(EndDate);
		ClickOnRun();
		CheckSuccessmsg();
		ClickONReportTab();
		ClickONCommissiionReportunderreportTab();
		ClickONAgent_ProjectionsunderreportTab();
		SelectActiveDropdowns(CRMReportCarrierNameMulti,Carrier);
		Base_Class.RobotKeyOperation("TAB");
		Base_Class.RobotKeyOperation("TAB");
		SelectActiveDropdowns(CRMReportYear,CurrentYear);
		Base_Class.RobotKeyOperation("TAB");
		Base_Class.RobotKeyOperation("TAB");
		Thread.sleep(3000);
		ClickONrunReportBtnunderreportTab();
		Thread.sleep(25000);
		ValidateTheAmount(CommissionRate);
		System.out.println("");
	}
	public void Commission_Import(String filepaths) throws InterruptedException, AWTException
	{
		NavvigateToCommissionSetUp();
		Thread.sleep(2000);
		click(File_Action);
		click(Import_Commission_Setup);
		ExtentSuccessMessage("Clicked on Import Commission setup dropdown");
		Thread.sleep(2000);
		click(File_Upload);
		Thread.sleep(6000);
		Robot robot = new Robot();
		String filePath = System.getProperty("user.dir") + ""+filepaths+"";
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
		Thread.sleep(10000);

		click(Submit);
		ExtentSuccessMessage("Clicked on submit button");

		Thread.sleep(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Success_Message));
		ExtentSuccessMessage("Success Mesage has been validated ");






	}
	public void validate_imported_criteria_commission_method_as_PMPM() throws InterruptedException, AWTException, IOException {
		String CommissionRate3 ="20";
		String Commissionmethod = "Per Member Per Month";
		String Product_Category3 ="Accident";
		String Carrier3 = "(ANTHEM) ANTHEM BLUE CROSS LIFE AND HEALTH INSURANCE COMPANY";
//		String Agent3 ="1Agent M15";
//		String Agent3 ="1Agent  M15";
		String Agent3 = null;
		String URL = configloader().getProperty("URL");
		if (URL.contains("https://mme.brokerengage.net/mme/")) {
			Agent3 = "1Agent  M15";
		}else {
			Agent3 = "1Agent M15";
		}
		System.out.println("Agent3:-"+Agent3);
		
		int Years=2018;
		String CurrentYear3 = Integer.toString(Years);
		String Filelocation = "\\Upload\\Commission-Setup-Criteria-07152024PMPM.xlsx";
		Commission_Import(Filelocation);
		HomePage.GotoHomepage1();
		CustomerPage.createNewCustomer();
		CustomerPage.createapolicy(Carrier3,Product_Category3,CurrentYear3,Agent3);
		//int CurrentMonthNumber = CurrentMonth();
		String CurrentMonthNum = CurrentMonth();
		HomePage.GotoHomepage1();
		NavvigateToCommissionSetUp();
		SelectActiveDropdown(CommissionPeriodDropdown,CurrentYear3);
		ClickOnSearchCommission();
		ExtentSuccessMessage("Start CM_TS_001_TC_008_validate_the_recalculate_functionality");
		ClickOnRecalculationCommission();
		String StartDate = CurrentMonthNum+"/01/2018";
		String EndDate = CurrentMonthNum+"/28/2018";
		EnterPolicy_Created_Start_Date(StartDate);
		EnterPolicy_Created_end_Date(EndDate);
		ClickOnRun();
		CheckSuccessmsg();
		ClickONReportTab();
		ClickONCommissiionReportunderreportTab();
		ClickONAgent_ProjectionsunderreportTab();
		ClickOnMinimizeCallwindow();
		SelectActiveDropdowns(CRMReportCarrierNameMulti,Carrier3);
		Base_Class.RobotKeyOperation("TAB");
		Base_Class.RobotKeyOperation("TAB");
		Base_Class.RobotKeyOperation("TAB");
		SelectActiveDropdowns(CRMReportYear,CurrentYear3);
		Base_Class.RobotKeyOperation("TAB");	
		Base_Class.RobotKeyOperation("TAB");
		SelectActiveDropdowns(ReportAgent,Agent3);
		Base_Class.RobotKeyOperation("TAB");
		Thread.sleep(3000);
		ClickONrunReportBtnunderreportTab();
		Thread.sleep(30000);
		ValidatingthereportTable( Carrier3, Product_Category3, Agent3);
		ValidateAmount(CommissionRate3);
		HomePage.GotoHomepage1();
		CustomerPage.NavigateToCustomer();
		CustomerPage.SearchCustomer();
		CustomerPage.DeleteCustomer();
		HomePage.GotoHomepage1();
		NavvigateToCommissionSetUp();
		SelectActiveDropdown(CommissionPeriodDropdown,CurrentYear3);
		SelectActiveDropdown(ProductCategoryDropdown, Product_Category3);
		SelectActiveDropdown(carrierNameDropdown, Carrier3);
		ClickOnSearchCommission();
		ClickOnDeleteCommission();

	}
	public void validate_imported_criteria_commission_method_as_PPPY() throws InterruptedException, AWTException {
		String CommissionRate ="12";
		String Commissionmethod = "Per Policy Per Year";
		String Product_Category ="Accidental Insurance";
		String Carrier = "(ANTHEM) ANTHEM INSURANCE COMPANIES, INC.";
		String Agent ="Agent M11";
		int Years=2018;
		String CurrentYear = Integer.toString(Years);
		String Filelocation = "\\Upload\\Commission-Setup-Criteria-07152024PPPY.xlsx";
		Commission_Import(Filelocation);
		Thread.sleep(3000);
		HomePage.GotoHomepage1();
		CustomerPage.createNewCustomer();
		CustomerPage.createapolicy(Carrier,Product_Category,CurrentYear,Agent);
		HomePage.GotoHomepage1();
		NavvigateToCommissionSetUp();
		SelectActiveDropdown(CommissionPeriodDropdown,CurrentYear);
		SelectActiveDropdown(ProductCategoryDropdown, Product_Category);
		SelectActiveDropdown(carrierNameDropdown, Carrier);
		ClickOnSearchCommission();
		ClickOnRecalculationCommission();
		String StartDate = "01/01/2018";
		String EndDate = "12/31/2018";
		EnterPolicy_Created_Start_Date(StartDate);
		EnterPolicy_Created_end_Date(EndDate);
		ClickOnRun();
		CheckSuccessmsg();
		ClickONReportTab();
		ClickONCommissiionReportunderreportTab();
		ClickONAgent_ProjectionsunderreportTab();
		SelectActiveDropdowns(CRMReportCarrierNameMulti,Carrier);
		Base_Class.RobotKeyOperation("TAB");
		SelectActiveDropdowns(CRMReportYear,CurrentYear);
		Base_Class.RobotKeyOperation("TAB");		
		SelectActiveDropdowns(ReportAgent,Agent);
		Base_Class.RobotKeyOperation("TAB");
		Thread.sleep(3000);
		ClickONrunReportBtnunderreportTab();
		Thread.sleep(5000);
		String j =ValidatingthereportTable( Carrier, Product_Category, Agent);
		int CommissionRates = Integer.parseInt(CommissionRate);
		int total = CommissionRates*12;
		String GrandTotal = Integer.toString(total);
		ValidateTheAmount(CommissionRate);
		HomePage.GotoHomepage1();	
		NavvigateToCommissionSetUp();
		SelectActiveDropdown(CommissionPeriodDropdown,CurrentYear);
		SelectActiveDropdown(ProductCategoryDropdown, Product_Category);
		SelectActiveDropdown(carrierNameDropdown, Carrier);
		Thread.sleep(3000);
		ClickOnSearchCommission();
		Thread.sleep(3000);
		ClickOnDeleteCommission();
		Thread.sleep(3000);
	}

	public void validate_imported_criteria_commission_method_as_PMPY() throws InterruptedException, AWTException {
		String CommissionRate ="96";
		String Commissionmethod = "Per Member Per Year";
		String Product_Category ="Cancer/Critical Illness";
		String Carrier = "ADVANTICA";
		//		String Agent ="Agent M12";
		String Agent ="Agent M11";
		int Years=2018;
		String CurrentYear = Integer.toString(Years);
		String Filelocation = "\\Upload\\Commission-Setup-Criteria-07152024PMPY.xlsx";
		Commission_Import(Filelocation);
		HomePage.GotoHomepage1();
		CustomerPage.createNewCustomer();
		CustomerPage.createapolicy(Carrier,Product_Category,CurrentYear,Agent);
		Thread.sleep(3000);
		HomePage.GotoHomepage1();
		NavvigateToCommissionSetUp();
		SelectActiveDropdown(CommissionPeriodDropdown,CurrentYear);
		SelectActiveDropdown(ProductCategoryDropdown, Product_Category);
		SelectActiveDropdown(carrierNameDropdown, Carrier);
		ClickOnSearchCommission();
		ClickOnRecalculationCommission();
		String StartDate = "01/01/2018";
		String EndDate = "12/31/2018";
		EnterPolicy_Created_Start_Date(StartDate);
		EnterPolicy_Created_end_Date(EndDate);
		ClickOnRun();
		CheckSuccessmsg();
		ClickONReportTab();
		ClickONCommissiionReportunderreportTab();
		ClickONAgent_ProjectionsunderreportTab();
		SelectActiveDropdowns(CRMReportCarrierNameMulti,Carrier);
		Base_Class.RobotKeyOperation("TAB");
		SelectActiveDropdowns(CRMReportYear,CurrentYear);
		Base_Class.RobotKeyOperation("TAB");		
		SelectActiveDropdowns(ReportAgent,Agent);
		Base_Class.RobotKeyOperation("TAB");
		//		Thread.sleep(3000);
		//		ClickONrunReportBtnunderreportTab();
		//		Thread.sleep(5000);
		//		String j =ValidatingthereportTable( Carrier, Product_Category, Agent);
		//		ValidateTheAmount("96");
		Thread.sleep(2000);
		ClickONrunReportBtnunderreportTab();
		//		Thread.sleep(5000);
		//		String j =ValidatingthereportTable( Carrier, Product_Category, Agent);
		//		ValidateTheAmount("96");
		HomePage.GotoHomepage1();	
		NavvigateToCommissionSetUp();
		SelectActiveDropdown(CommissionPeriodDropdown,CurrentYear);
		SelectActiveDropdown(ProductCategoryDropdown, Product_Category);
		SelectActiveDropdown(carrierNameDropdown, Carrier);
		Thread.sleep(3000);
		ClickOnSearchCommission();
		Thread.sleep(3000);
		ClickOnDeleteCommission();
		Thread.sleep(3000);
	}
	public void ValidateTheAmount(String Value) throws InterruptedException {

		By Option = By.xpath("(//*[@class='dx-grandtotal']//span[contains(text(),'$"+Value+"')])[1]");
		Base_Class.ScrollUntilElementVisible(Option);
		if(ElementDisplayed(Option)) {
			ExtentSuccessMessage("Successfully user able to See 'The Amount inside the web Table' ");
		}else {
			ExtentErrorMessage("UnSuccessfully user not able to See 'The Amount inside the web Table' ");
		}
	}

	public void ValidateAmount (String Amount) throws InterruptedException {
		int CurrentMonthNumber = CurrentMonths();
		int loopSize =13-CurrentMonthNumber;
		//		int loopSize =loopSiz+1;
		//		System.out.println("loopSiz:-"+loopSiz);
		System.out.println("loopSize:-"+loopSize);
		//		By locator = By.xpath("//tbody//td[@class='dx-grandtotal']//span[contains(text(),'$"+Amount+"')]");
		//		List<WebElement> elements = driver.findElements(locator);
		//		// Get the size of the list of elements
		//        int sizeOfElements = elements.size();
		//        
		//        System.out.println("Number of elements found: " + sizeOfElements);
		int convertedAmount = Integer.parseInt(Amount);
		int grandTotal =  loopSize * convertedAmount;
		String grandTotal1 = String.valueOf(grandTotal);
		for (int i = 1; i <= loopSize; i++)  {
			System.out.println("Gebug1");
			By locators = By.xpath("(//table[not(@class) or @class = '']//tbody//td[@class='dx-grandtotal']//span[contains(text(),'$"+Amount+"')])["+i+"]");
			Base_Class.ScrollUntilElementVisible(locators);
			Thread.sleep(2000);
			System.out.println("Gebug2");
			int mountnubmer = 0;
			if(i==1) {
				mountnubmer=CurrentMonthNumber;
			}else {
				mountnubmer=CurrentMonthNumber+i-1;
			}
			System.out.println("mountnubmer:-"+mountnubmer);
			if(ElementDisplayed(locators)) {
				ExtentSuccessMessage("Successfully user able to See 'The Amount inside the web Table for the month number ="+mountnubmer+"' ");
			}else {
				ExtentErrorMessage("UnSuccessfully user not able to See 'The Amount inside the web Table' ");
			}
		}
		Thread.sleep(2000);
		By grandtotal = By.xpath("(//table[not(@class) or @class = '']//tbody//td[@class='dx-grandtotal']//span[contains(text(),'$"+grandTotal1+"')])[1]");
		Base_Class.ScrollUntilElementVisible(grandtotal);
		Thread.sleep(4000);
		if(ElementDisplayed(grandtotal)) {
			ExtentSuccessMessage("Successfully user able to See 'The Grand Total Amount inside the web Table ="+grandTotal1+"' ");
		}else {
			ExtentErrorMessage("UnSuccessfully user not able to See 'The Grand Total Amount inside the web Table' ");
		}
	}
	public String ValidatingthereportTable(String carrior,String product,String AGent) throws InterruptedException {
		String value =",";
		for(int i=1; i<=6;i++) {
			int j=i*2;
			By gridoptions = By.xpath("(//table[not(@class) or @class = '']//tbody[@class='dx-pivotgrid-vertical-headers']//tr[@class='dx-expand-border']//td//span)["+j+"]");
			Base_Class.ScrollUntilElementVisible(gridoptions);
			value =value+GetElementText(gridoptions);

		}
		System.out.println("Value:- "+value);
		if(value.contains(carrior)) {
			ExtentSuccessMessage("Successfully user able to find the carrior:- '"+carrior+"' ");
		}else {
			ExtentErrorMessage("UnSuccessfully user not able to find the carrior:- '"+carrior+"' ");
		}
		if(value.contains(product)) {
			ExtentSuccessMessage("Successfully user able to find the product:- '"+product+"' ");
		}else {
			ExtentErrorMessage("UnSuccessfully user not able to find the product:- '"+product+"' ");
		}
		if(value.contains(AGent)) {
			ExtentSuccessMessage("Successfully user able to find the AGent:- '"+AGent+"' ");
		}else {
			ExtentErrorMessage("UnSuccessfully user not able to find the AGent:- '"+AGent+"' ");
		}
		return value;

	}



	/////////////////////Split Commission////////////////////////

	public void ClickonSplitCommissionSetup() throws InterruptedException {
		click(SplitCommissionSetup);
		ExtentSuccessMessage("Successfully user Clicked on 'Commission Set Up' ");
		ValidateSplitCommissionSetupTab();

	}
	public void ClickonAddSplitCommissionSetup() throws InterruptedException {
		click(AddSplitCommission);
		ExtentSuccessMessage("Successfully user Clicked on 'Add Split Commission' ");
		//		ValidateSplitCommissionSetupTab();

	}
	public void EnterStartDate(String value) throws InterruptedException {
		if(ElementDisplayed(Enterstartdate)) {
			ExtentSuccessMessage("Successfully user able to See 'Start_Date ' ");
			writeText(Enterstartdate,value);
			ExtentSuccessMessage("Successfully user entered the '_Start_Date in text field' "+value);

		}else {
			ExtentErrorMessage("UNSuccessfully user not able to See 'Start_Date ' ");
		}
	}
	public void ClickONsearchCustomer() throws InterruptedException {
		Base_Class.ScrollUntilElementVisible(ClickONsearchCustomer);
		click(ClickONsearchCustomer);
		ExtentSuccessMessage("Successfully user Clicked on 'search Customer' ");
	}

	public String SelectTheCustomer() throws InterruptedException {
		waitVisibility(SelectTheCustomer);
		click(SelectTheCustomer);
		ExtentSuccessMessage("Successfully user Clicked on 'search Customer' ");
		String GetSelectedCustomerName =GetElementText(SelectedTheCustomername);
		System.out.println("GetSelectedCustomerName:-"+GetSelectedCustomerName);
		return GetSelectedCustomerName;

	}
	public void clickonContinue() throws InterruptedException {
		click(ClickonContinue);
		ExtentSuccessMessage("Successfully user Clicked on 'Continue' ");
	}



	public void EnterEndDate(String value) throws InterruptedException {
		if(ElementDisplayed(EnterEndDate)) {
			ExtentSuccessMessage("Successfully user able to See 'End_Date ' ");
			clear(EnterEndDate);
			writeText(EnterEndDate,value);
			ExtentSuccessMessage("Successfully user entered the 'End_Date in text field' "+value);

		}else {
			ExtentErrorMessage("UNSuccessfully user not able to See 'End_Date ' ");
		}
	}
	public void EnterSplit(String value) throws InterruptedException {
		if(ElementDisplayed(Split)) {
			ExtentSuccessMessage("Successfully user able to See 'Split ' ");
			clear(Split);
			writeText(Split,value);
			ExtentSuccessMessage("Successfully user entered the 'Split in text field' "+value);

		}else {
			ExtentErrorMessage("UNSuccessfully user not able to See 'End_Date ' ");
		}
	}

	public void NavvigateToSplitCommissionSetUp() throws InterruptedException {
		hoverOnCommissionModule();
		ClickonSplitCommissionSetup();
	}
	public void ValidateSplitCommissionSetupTab() throws InterruptedException {	
		//RefreshPage();
		//Thread.sleep(9000);
		ClickOnMinimizeCallwindow();
		WaitUntillPAgeLoad1();
		waitVisibility(RefreshDashboard);
		if (ElementDisplayed(AddSplitCommission)) {
			ExtentSuccessMessage("Successfully user Landed on 'Split Commission Set up ' ");			
		} else {
			ExtentErrorMessage("Unsuccessfully user Not Loanded on 'Split bCommission Set up '' ");
		}
	}

	public void SelectAORFromDropdown(By Locators,String value) throws InterruptedException {

		Base_Class.ScrollUntilElementVisible(Locators);
		click(Locators);
		ExtentSuccessMessage("Successfully user Clicked on 'AOR DropDown' ");
		Thread.sleep(2000);
		By Elements=By.xpath("//*[@class='dx-agent-list Active'][@title='Active'][contains(text(),'"+value+"')]");
		Base_Class.ScrollUntilElementVisible(Elements);
		click(Elements);
		ExtentSuccessMessage("Successfully user Clicked on 'AOR DropDown Value :-' "+value);
	}

	public void Split_Commission_validate_the_Create_Duplicate_Download_Edit_Delete_Clone() throws InterruptedException, AWTException {
		String CarrierValue ="(ANTHEM) ANTHEM BLUE CROSS LIFE AND HEALTH INSURANCE COMPANY";
		String SaleTypeValue ="New";
		String ProductValue ="Accident";
		String CarrierValue1 ="AARP - UNITEDHEALTHCARE INSURANCE COMPANY";
		String SaleTypeValue1 ="Special Event Plan (SEP)";
		String ProductValue1 ="Accidental Insurance";
		String AORNAME= "1Agent  M13";
		String AORNAME1= "1Agent  M14";
		String AORNAME2= "1Agent  M15";
		String AORNAME3= "1Agent  M16";
		String AORNAME01= "1Agent M13";
		String AORNAME11= "1Agent M14";
		String AORNAME21= "1Agent M15";
		String AORNAME31= "1Agent M16";
		String SplitValue ="2";
		String SplitValue1 ="3";
		String SplitValue2 ="4";
		String SplitMethodValue = "Fixed Rate ($)";	
		int CurrentMonthNumber = CurrentMonths();
		int CurrentYearNumber =CurrentYear();
		int NewxtMonthNumber=0;
		int NextyearNumber=0;	
		String CurrentMonthNum= null;
		if(CurrentMonthNumber==12) {
			NewxtMonthNumber =1;
			NextyearNumber = CurrentYearNumber+1;
		}else {
			NewxtMonthNumber =CurrentMonthNumber+1;
			NextyearNumber = CurrentYearNumber;
		}
		if(CurrentMonthNumber<10) {
			CurrentMonthNum = Integer.toString(CurrentMonthNumber);
			CurrentMonthNum="0"+CurrentMonthNumber;
		}else {
			CurrentMonthNum = Integer.toString(CurrentMonthNumber);
		}
		String NextYearNum = Integer.toString(NextyearNumber);
		String NextMonthNum = Integer.toString(NewxtMonthNumber);

		String CurrentYearNumberNum = Integer.toString(CurrentYearNumber);
		String StartDate = CurrentMonthNum+"/01/"+CurrentYearNumberNum;
		String EndDate = CurrentMonthNum+"/28/"+CurrentYearNumberNum;
		System.out.println("EndDate:-"+EndDate);
		String NextMonthEndDate = "0"+NextMonthNum+"/01/"+NextYearNum;
		System.out.println("NextMonthEndDate:-"+NextMonthEndDate);
		ExtentSuccessMessage("***********************************************************************************");
		ExtentSuccessMessage("Start SCM_TS_001_TC_001_To_validate_whether_user_is_able_to_set_the_criteria_on_split_commission_rate_under");
		NavvigateToSplitCommissionSetUp();
		ClickonAddSplitCommissionSetup();
		EnterStartDate(StartDate);
		EnterEndDate(EndDate);		
		SelectDropdown(CarrierDropDown,CarrierValue);
		SelectDropdown(SaletypeDropDown,SaleTypeValue);
		SelectDropdown(ProducatTypeDropDown,ProductValue);
		ClickONsearchCustomer();
		String CustomerName =SelectTheCustomer();
		clickonContinue();
		Base_Class.ScrollUntilElementVisible(AORDropdown);
		click(AORDropdown);
		Thread.sleep(3000);
		By Valuesj=By.xpath("//*[@class='dx-agent-list Active'][@title='Active'][contains(text(),'"+AORNAME+"')]");
		if(ElementDisplayed(Valuesj)) {
			click(AORDropdown);
			SelectAORFromDropdown(AORDropdown,AORNAME);
			Base_Class.ScrollUntilElementVisible(SplitMethod);
			SelectDropdown(SplitMethod,SplitMethodValue);
			SelectAORFromDropdown(AORDropdown1,AORNAME);		
			SelectAORFromDropdown(AORDropdown2,AORNAME1);
		}else {
			click(AORDropdown);
			SelectAORFromDropdown(AORDropdown,AORNAME01);
			Base_Class.ScrollUntilElementVisible(SplitMethod);
			SelectDropdown(SplitMethod,SplitMethodValue);
			SelectAORFromDropdown(AORDropdown1,AORNAME01);		
			SelectAORFromDropdown(AORDropdown2,AORNAME11);
		}

//		SelectAORFromDropdown(AORDropdown,AORNAME);
//		Base_Class.ScrollUntilElementVisible(SplitMethod);
//		SelectDropdown(SplitMethod,SplitMethodValue);
//		SelectAORFromDropdown(AORDropdown1,AORNAME);		
//		SelectAORFromDropdown(AORDropdown2,AORNAME1);
		
		EnterSplit(SplitValue);
		clickonSaveSplitCommission();
		String Values = (StartDate+","+EndDate+","+CarrierValue+","+SaleTypeValue+","+"All"+","+ProductValue+","+"All"+","+CustomerName+","+AORNAME01+","+SplitMethodValue+","+AORNAME01+","+SplitValue+","+AORNAME11);
		ValidateRow(Values);
		ExtentSuccessMessage("END SCM_TS_001_TC_001_To_validate_whether_user_is_able_to_set_the_criteria_on_split_commission_rate_under");
		ExtentSuccessMessage("*************************************************************");
		ExtentSuccessMessage("Start SCM_TS_001_TC_005_To_validate_whether_user_is_able_to_edit__the_existing_criterias");

		clickonEditSplitCommission();
		SelectDropdown(CarrierDropDown,CarrierValue1);
		SelectDropdown(SaletypeDropDown,SaleTypeValue1);
		SelectDropdown(ProducatTypeDropDown,ProductValue1);
		Base_Class.ScrollUntilElementVisible(AORDropdown);
		click(AORDropdown);
		By Valuesk=By.xpath("//*[@class='dx-agent-list Active'][@title='Active'][contains(text(),'"+AORNAME21+"')]");
		Base_Class.ScrollUntilElementVisible(Valuesk);
		if(ElementDisplayed(Valuesk)) {
			click(AORDropdown);
			SelectAORFromDropdown(AORDropdown,AORNAME21);
			SelectAORFromDropdown(AORDropdown1,AORNAME21);		
			SelectAORFromDropdown(AORDropdown2,AORNAME31);
		}else {
			click(AORDropdown);
			SelectAORFromDropdown(AORDropdown,AORNAME2);
			SelectAORFromDropdown(AORDropdown1,AORNAME2);		
			SelectAORFromDropdown(AORDropdown2,AORNAME3);
		}		

//		SelectAORFromDropdown(AORDropdown,AORNAME2);
//		Base_Class.ScrollUntilElementVisible(SplitMethod);
//		SelectDropdown(SplitMethod,SplitMethodValue);
//		SelectAORFromDropdown(AORDropdown1,AORNAME2);		
//		SelectAORFromDropdown(AORDropdown2,AORNAME3);
		EnterSplit(SplitValue1);
		clickonEDITSaveSplitCommission();
		String Values1 = (StartDate+","+EndDate+","+CarrierValue1+","+SaleTypeValue1+","+"All"+","+ProductValue1+","+"All"+","+CustomerName+","+AORNAME21+","+SplitMethodValue+","+AORNAME21+","+SplitValue1+","+AORNAME31);
		ValidateRow(Values1);
		ExtentSuccessMessage("End SCM_TS_001_TC_005_To_validate_whether_user_is_able_to_edit__the_existing_criterias");
		ExtentSuccessMessage("*************************************************************");
		ExtentSuccessMessage("Start SCM_TS_001_TC_004_To_validate_whether_user_is_able_download_splitcommission_setup");
		ClickOndownlodbtn();
		ExtentSuccessMessage("End SCM_TS_001_TC_004_To_validate_whether_user_is_able_download_splitcommission_setup");
		ExtentSuccessMessage("*************************************************************");
		//Application issue
//		ExtentSuccessMessage("Start SCM_TS_001_TC_010_To_verify_the_Split_Commission_Clone_Functionality");// Jenkins Issue
//		ClickonCloneSplitCommission();
//		EnterEndDate(NextMonthEndDate);	
//		clickonSaveSplitCommission();
//		ExtentSuccessMessage("End SCM_TS_001_TC_010_To_verify_the_Split_Commission_Clone_Functionality");
//		ExtentSuccessMessage("*************************************************************");
//		ExtentSuccessMessage("Start SCM_TS_001_TC_006_To_validate_whether_user_is_able_to_delete__the_existing_criterias");
//		ClickonDeleteSplitCommission();
//		ExtentSuccessMessage("End SCM_TS_001_TC_006_To_validate_whether_user_is_able_to_delete__the_existing_criterias");
//		ExtentSuccessMessage("*************************************************************");

		ExtentSuccessMessage("Start SCM_TS_001_TC_002_To_validate_whether_user_is_able_to_add_a_duplicate_criteria");

		ClickonCloneSplitCommission();
		clickonSaveSplitCommissionFailed();
		ClickonCancelSplitCommission();
		ClickonDeleteSplitCommission();
		ExtentSuccessMessage("End SCM_TS_001_TC_002_To_validate_whether_user_is_able_to_add_a_duplicate_criteria");
		ExtentSuccessMessage("*************************************************************");



	}
	public void ClickOndownlodbtn() throws InterruptedException {
		click(downlodDataBtn);
		ExtentSuccessMessage("Successfully user Clicked on 'Download Split Commission' ");
		Thread.sleep(9000);
	}

	public void ValidateCommissionmanagementgridRow(String Values) throws InterruptedException {
		String[] ExpectedColnumname =Values.split(":");
		for(int i=0;i<=6;i++) {
			int j = i+1;
			Thread.sleep(2000);
			By Elements =By.xpath("(//tbody//tr[@class='dx-row dx-data-row dx-column-lines'])[1]//td[@role='gridcell'][@aria-colindex='"+j+"']");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Elements));
			String ActualColunmName =element.getText();
			if(j ==4) {

			}else {
				if (ActualColunmName.contains(ExpectedColnumname[i])) {
					Assert.assertEquals(ExpectedColnumname[i], ActualColunmName);
					ExtentSuccessMessage("Successfully user found the expected Colunm name:- Expected "+ExpectedColnumname[i]+" Actual "+ActualColunmName+"");	
				}else{
					if(j==7) {
						System.out.println("J="+j);
						String actualvalu=ActualColunmName.toUpperCase().trim();
						String Expectedvalu=ExpectedColnumname[i].toUpperCase().trim();
						System.out.println("actual:-"+actualvalu);
						System.out.println("Expected:-"+Expectedvalu);
						if (actualvalu.equals(Expectedvalu)) {
							System.out.println("DEBUG1");
							Assert.assertEquals(Expectedvalu, actualvalu);
							ExtentSuccessMessage("Successfully user found the expected Colunm name:- Expected "+ExpectedColnumname[i].toUpperCase()+" Actual "+ActualColunmName.toUpperCase()+"");	
						}else {
							System.out.println("DEBUG2");
							ExtentErrorMessage("UNSuccessfully user Not found the expected Colunm name:- Expected "+ExpectedColnumname[i].toUpperCase()+" Actual "+ActualColunmName.toUpperCase()+"");	
						}
					}else {
						ExtentErrorMessage("UNSuccessfully user Not found the expected Colunm name:- Expected "+ExpectedColnumname[i]+" Actual "+ActualColunmName+"");	
					}
				}
			}
		}
	}

	public void DownloadExportFile() throws InterruptedException {
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Downloadexportfile));
		if (ElementDisplayed(Downloadexportfile)) {
			ExtentSuccessMessage("Successfully user able to See 'Download Commission Icon (File)' ");
			click(Downloadexportfile);
			ExtentSuccessMessage("Successfully user Clicked on 'Download Commission Icon (File)' ");
		} else {
			//			ExtentErrorMessage("Unsuccessfully 'Download Commission icon (File)' Not visible");
			waitVisibility(Downloadexportfile);
			if (ElementDisplayed(Downloadexportfile)) {
				ExtentSuccessMessage("Successfully user able to See 'Download Commission Icon (File)' ");
				click(Downloadexportfile);
				ExtentSuccessMessage("Successfully user Clicked on 'Download Commission Icon (File)' ");
			} else {
				ExtentErrorMessage("Unsuccessfully 'Download Commission icon (File)' Not visible");
			}
		}
		Thread.sleep(8000);
	}

	public void ReviewExportFile() throws InterruptedException {
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Reviewexcel));
		if (ElementDisplayed(Reviewexcel)) {
			ExtentSuccessMessage("Successfully user able to See 'Review Commission Icon' ");
			click(Reviewexcel);
			ExtentSuccessMessage("Successfully user Clicked on 'Review Commission Icon' ");
		} else {
			ExtentErrorMessage("Unsuccessfully 'Review Commission icon' Not visible");
		}
		Thread.sleep(8000);

	}


	public void BackToUploadSection() throws InterruptedException {
		element = wait.until(ExpectedConditions.presenceOfElementLocated(BackToUploadSection));
		if (ElementDisplayed(BackToUploadSection)) {
			ExtentSuccessMessage("Successfully user able to See 'Back to Upload Section' ");
			click(BackToUploadSection);
			ExtentSuccessMessage("Successfully user Clicked on 'Back to Upload Section' ");
		} else {
			ExtentErrorMessage("Unsuccessfully 'Back to Upload Section' Not visible");
		}
		Thread.sleep(8000);

	}

	public void BacktomappingSection() throws InterruptedException {
		element = wait.until(ExpectedConditions.presenceOfElementLocated(BacktomappingSection));
		if (ElementDisplayed(BacktomappingSection)) {
			ExtentSuccessMessage("Successfully user able to See 'Back to mapping Section' ");
			click(BacktomappingSection);
			ExtentSuccessMessage("Successfully user Clicked on 'Back to mapping Section' ");
		} else {
			ExtentErrorMessage("Unsuccessfully 'Back to mapping Section' Not visible");
		}
		Thread.sleep(8000);

	}

	public void DeleteTheRow() throws InterruptedException {
		element = wait.until(ExpectedConditions.presenceOfElementLocated(DeleteTheRow));
		if (ElementDisplayed(DeleteTheRow)) {
			ExtentSuccessMessage("Successfully user able to See 'Delete The Row' ");
			click(DeleteTheRow);
			ExtentSuccessMessage("Successfully user Clicked on 'Delete The Row' ");
			String msgs = GetElementText(Deletemsg);
			System.out.println("msgs:-"+msgs);
			Assert.assertEquals(msgs, "Are you sure you want to discard the carrier statement?");
			ExtentSuccessMessage("Are you sure you want to discard the carrier statement?");
			click(Deleteconfirmation);
			ExtentSuccessMessage("Successfully user Clicked on 'Delete Confirmation The Row' ");
			waitVisibility(Success_Message);
			String Deletemsgs = GetElementText(Success_Message);
			System.out.println("msgs:-"+Deletemsgs);
			Assert.assertEquals(Deletemsgs, "Carrier statement discarded successfully.");
			ExtentSuccessMessage("Carrier statement discarded successfully.");

		} else {
			ExtentErrorMessage("Unsuccessfully 'Delete The Row' Not visible");
		}
		//			Thread.sleep(8000);

	}

	public void ValidateRow(String Values) throws InterruptedException {
		String[] ExpectedColnumname =Values.split(",");
		for(int i=0;i<=12;i++) {
			int j = i+3;
			Thread.sleep(2000);
			By Elements =By.xpath("//tr[@class='dx-row dx-data-row dx-column-lines']//td[@role='gridcell'][@aria-colindex='"+j+"']");
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
				if(ActualColunmName.contains("PMPY")){
					ActualColunmName = "Per Member Per Year";
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


	public void clickonEditSplitCommission() throws InterruptedException {
		Base_Class.ScrollUntilElementVisible(EditSplitCommission);
		click(EditSplitCommission);
		ExtentSuccessMessage("Successfully user Clicked on 'Edit Split Commission' ");
	}

	public void clickonSaveSplitCommission() throws InterruptedException {
		int currentMonth =CurrentMonths();
		int CurrentYears=CurrentYear();
//		int nextmonth =currentMonth+1;
//		String formattedMonth = String.format("%02d", nextmonth);

		
		int NextyearNumber= 0;
		int NewxtMonthNumber=0;
		String formattedMonth =null;
		
		if(currentMonth==12) {
			NewxtMonthNumber =1;
			NextyearNumber = CurrentYears+1;
			formattedMonth = String.format("%02d", NewxtMonthNumber);
		}else {
			NewxtMonthNumber =currentMonth+1;
			NextyearNumber = CurrentYears;
			formattedMonth = String.format("%02d", NewxtMonthNumber);
		}
		
		
		String NextMonthEndDate=formattedMonth+"/28/"+NextyearNumber;
		System.out.println("NextMonthEndDate:-"+NextMonthEndDate);
		Base_Class.ScrollUntilElementVisible(SaveSplitCommission);
		click(SaveSplitCommission);
		ExtentSuccessMessage("Successfully user Clicked on 'Save Split Commission' ");
		String Savemsg=GetElementText(Savepopupmsg);
		System.out.println("Savemsg:-"+Savemsg);
		Assert.assertEquals(Savemsg, "Are you sure you want to submit the changes?");
		click(ConfirmSave);
		ExtentSuccessMessage("Successfully user Clicked on 'Save Split Commission Confirmation 'Yes Button'' ");
		Thread.sleep(4000);
		if(ElementDisplayed(Success_Message)) {
			System.out.println("IF");
			String confirmationMsg = GetElementText(Success_Message);
			System.out.println("confirmationMsg:-"+confirmationMsg);
			Assert.assertEquals(confirmationMsg, "Split Commission criteria saved successfully.");

		}else {
			System.out.println("ELSE");
			ClickonRefreshList();
			Thread.sleep(5000);
			ClickonCloneSplitCommission();
			System.out.println("NextMonthEndDate:-"+NextMonthEndDate);
			EnterEndDate(NextMonthEndDate);

			Base_Class.ScrollUntilElementVisible(SaveSplitCommission);
			click(SaveSplitCommission);
			ExtentSuccessMessage("Successfully user Clicked on 'Save Split Commission' ");
			String Savemsg1=GetElementText(Savepopupmsg);
			System.out.println("Savemsg:-"+Savemsg1);
			Assert.assertEquals(Savemsg1, "Are you sure you want to submit the changes?");
			click(ConfirmSave);
			ExtentSuccessMessage("Successfully user Clicked on 'Save Split Commission Confirmation 'Yes Button'' ");
			String confirmationMsg1 = GetElementText(Success_Message);
			System.out.println("confirmationMsg:-"+confirmationMsg1);
			Assert.assertEquals(confirmationMsg1, "Split Commission criteria saved successfully.");

		}


		//		String confirmationMsg = GetElementText(Success_Message);
		//		System.out.println("confirmationMsg:-"+confirmationMsg);
		//		Assert.assertEquals(confirmationMsg, "Split Commission criteria saved successfully.");
		Thread.sleep(5000);
	}
	public void clickonSaveSplitCommissionFailed() throws InterruptedException {
		Base_Class.ScrollUntilElementVisible(SaveSplitCommission);
		click(SaveSplitCommission);
		ExtentSuccessMessage("Successfully user Clicked on 'Save Split Commission' ");
		String Savemsg=GetElementText(Savepopupmsg);
		System.out.println("Savemsg:-"+Savemsg);
		Assert.assertEquals(Savemsg, "Are you sure you want to submit the changes?");
		click(ConfirmSave);
		ExtentSuccessMessage("Successfully user Clicked on 'Save Split Commission Confirmation 'Yes Button'' ");
		String confirmationMsg = GetElementText(Error_Message);
		System.out.println("confirmationMsg:-"+confirmationMsg);
		Assert.assertEquals(confirmationMsg, "Split Commission with the same criteria already exists.");
		Thread.sleep(5000);
	}

	public void clickonEDITSaveSplitCommission() throws InterruptedException {
		Base_Class.ScrollUntilElementVisible(SaveSplitCommission);
		click(SaveSplitCommission);
		ExtentSuccessMessage("Successfully user Clicked on 'Save Split Commission' ");
		String Savemsg=GetElementText(Savepopupmsg);
		System.out.println("Savemsg:-"+Savemsg);
		Assert.assertEquals(Savemsg, "Are you sure you want to submit the changes?");
		click(ConfirmSave);
		ExtentSuccessMessage("Successfully user Clicked on 'Save Split Commission Confirmation 'Yes Button'' ");
		String confirmationMsg = GetElementText(Success_Message);
		System.out.println("confirmationMsg:-"+confirmationMsg);
		Assert.assertEquals(confirmationMsg, "Split Commission criteria updated successfully.");
		Thread.sleep(5000);
	}


	public void SelectDropdown(By Locator, String Value) throws InterruptedException {
		//Base_Class.ScrollUntilElementVisible(Locator);
		if (ElementDisplayed(Locator)) {
			click(Locator);
			ExtentSuccessMessage("Successfully click On Dropdown ");
			Thread.sleep(1000);
			By i = By.xpath("//*[@role='option']//*[contains(text(),'"+ Value+"')]");
			if(ElementDisplayed(i)) {
				click(i);
				ExtentSuccessMessage("Successfully clicked and select value from dropdown : " + Value);
			}else {
				Base_Class.ScrollUntilElementVisible(i);
				click(i);
				ExtentSuccessMessage("Successfully clicked and select value from dropdown : " + Value);
			}

		} else {
			ExtentErrorMessage("Dropdown element not able to select dropdown value : " + Value);
			Log.error("Dropdown element not able to select dropdown value : " + Value);
		}	
	}

	public void ClickonDeleteSplitCommission() throws InterruptedException {		
		Base_Class.ScrollUntilElementVisible(DeleteSplitCommission);
		click(DeleteSplitCommission);
		ExtentSuccessMessage("Successfully user Clicked on 'Delete Split Commission' ");
		String Deletemsg=GetElementText(Deletepopupmsg);
		System.out.println("Savemsg:-"+Deletemsg);
		click(ConfirmDeleteYes);
		String confirmationMsg = GetElementText(Success_Message);
		System.out.println("confirmationMsg:-"+confirmationMsg);
		Thread.sleep(5000);
	}

	public void ClickonCloneSplitCommission() throws InterruptedException {		
		Base_Class.ScrollUntilElementVisible(CloneSplitCommission);
		click(CloneSplitCommission);
		ExtentSuccessMessage("Successfully user Clicked on 'Clone Split Commission' ");

	}
	public void ClickonRefreshList() throws InterruptedException {		
		Base_Class.ScrollUntilElementVisible(RefreshList);
		click(RefreshList);
		ExtentSuccessMessage("Successfully user Clicked on 'RefreshList Split Commission' ");

	}


	public void ClickonCancelSplitCommission() throws InterruptedException {		
		Base_Class.ScrollUntilElementVisible(Cancel);

		click(Cancel);
		ExtentSuccessMessage("Successfully user Clicked on 'Cancel Split Commission' ");

	}
	public static String Readexcel1(String Filename,int rownumber) throws InvalidFormatException {
		// Path to the Excel file
		String filePath = Filename; // Replace with your file path
		String result="";
		try {
			// Load the Excel file
			FileInputStream fis = new FileInputStream(new File(filePath));

			// Create a Workbook instance for the Excel file
			Workbook workbook = new XSSFWorkbook(fis);

			// Get the first sheet (you can change this if you want to read other sheets)
			Sheet sheet = workbook.getSheetAt(0);

			// Get the first row (index 0)
			Row firstRow = sheet.getRow(rownumber);

			// Concatenate cell values into a single string
			result = getRowAsString1(firstRow);

			// Print the result
			System.out.println("result:-"+result);

			// Close the workbook and file input stream
			workbook.close();
			fis.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String Readexcel(String Filename,int rownumber) throws InvalidFormatException {
		// Path to the Excel file
		String filePath = Filename; // Replace with your file path
		String result="";
		try {
			// Load the Excel file
			FileInputStream fis = new FileInputStream(new File(filePath));

			// Create a Workbook instance for the Excel file
			Workbook workbook = new XSSFWorkbook(fis);

			// Get the first sheet (you can change this if you want to read other sheets)
			Sheet sheet = workbook.getSheetAt(0);

			// Get the first row (index 0)
			Row firstRow = sheet.getRow(rownumber);

			// Concatenate cell values into a single string
			result = getRowAsString(firstRow);

			// Print the result
			System.out.println("result:-"+result);

			// Close the workbook and file input stream
			workbook.close();
			fis.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	// Method to handle different types of cell data, including dates, and return a concatenated string
	private static String getRowAsString(Row row) {
		StringBuilder rowString = new StringBuilder();

		if (row != null) {
			for (Cell cell : row) {
				// Get the cell value and handle different types, including dates
				String cellValue = getCellValue(cell);

				// Append the cell value followed by a tab or other delimiter
				rowString.append(cellValue).append("\t");
			}
		}

		// Return the concatenated string, removing the last delimiter (if any)
		return rowString.toString().trim();
	}

	private static String getRowAsString1(Row row) {
		StringBuilder rowString = new StringBuilder();

		if (row != null) {
			for (Cell cell : row) {
				// Get the cell value and handle different types, including dates
				String cellValue = getCellValue(cell);

				// Append the cell value followed by a tab or other delimiter
				rowString.append(cellValue.trim()+":").append("\t");
			}
		}

		// Return the concatenated string, removing the last delimiter (if any)
		return rowString.toString().trim();
	}


	// Method to handle different types of cell data, including dates


	private static String getCellValue(Cell cell) {
		String value = "";

		switch (cell.getCellType()) {
		case STRING:
			value = cell.getStringCellValue();
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date date = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
				value = dateFormat.format(date);
			} else {
				value = String.valueOf(cell.getNumericCellValue());
			}
			break;
		case BOOLEAN:
			value = String.valueOf(cell.getBooleanCellValue());
			break;
		case FORMULA:
			value = cell.getCellFormula();
			break;
		default:
			value = "";
			break;
		}

		// Check if the value contains a '$' and print it
		if (value.contains("$")) {
			System.out.println("Found dollar sign in value: " + value);
		}

		return value;
	}



	//	    private static String getCellValue(Cell cell) {
	//	        switch (cell.getCellType()) {
	//	            case STRING:
	//	                return cell.getStringCellValue();
	//	            case NUMERIC:
	//	                // If the cell contains a date, return the formatted date
	//	                if (DateUtil.isCellDateFormatted(cell)) {
	//	                    Date date = cell.getDateCellValue();
	//	                    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy"); // Adjust the format as needed
	//	                    return dateFormat.format(date);
	//	                } else {
	//	                    return String.valueOf(cell.getNumericCellValue());
	//	                }
	//	            case BOOLEAN:
	//	                return String.valueOf(cell.getBooleanCellValue());
	//	            case FORMULA:
	//	                return cell.getCellFormula();
	//	            default:
	//	                return "";
	//	        }
	//	    }




}