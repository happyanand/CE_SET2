package com.test;

import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import com.pages.CensusInfo;
import com.pages.Commision_Validations;
import com.pages.Commission_Page;
import com.pages.CustomerEngageFunctionalityValidations;
import com.pages.CustomerPage;

import Utility.ExcelHelper;

public class CM_TS_004_TC_003_004_005_Import_criteria_Percentage_PMPM_PCPM extends AllScenarios_EG_TC {
	CensusInfo ApplicantInfo = new CensusInfo();
	CensusInfo SpouseInfo = new CensusInfo();
	CensusInfo DomesticPartner = new CensusInfo();
	

	ArrayList<CensusInfo> DependentsInfo = new ArrayList<CensusInfo>();
	CensusInfo DependentInfo = new CensusInfo();
	public void CE_TC_Commission_Criteria_Methods_Validation(CensusInfo ApplicantInfo)	throws ClassNotFoundException, Exception {
		Commission_Page Commission_Page =new Commission_Page(driver);
		CustomerPage CustomerPage =new CustomerPage(driver);
		Commision_Validations Commision_Validations = new Commision_Validations(driver);
		CustomerEngageFunctionalityValidations consumerpage = new CustomerEngageFunctionalityValidations(driver);
		ExcelHelper _excelObj = new ExcelHelper();
		XSSFSheet tcTestData = _excelObj.readExcelSheet("TestData", "TC CE1");
		int rowCount = tcTestData.getLastRowNum() - tcTestData.getFirstRowNum();

		if (tcTestData != null) {

			ApplicantInfo.Zipcode = tcTestData.getRow(1).getCell(1).getStringCellValue().toString();
			ApplicantInfo.Email=tcTestData.getRow(1).getCell(9).getStringCellValue().toString();
			ApplicantInfo.DOB = tcTestData.getRow(1).getCell(3).getStringCellValue().toString();
			ApplicantInfo.Gender = tcTestData.getRow(1).getCell(2).getStringCellValue().toString();     

		}

		System.out.println("******* CM_TS_004_TC_003_004_005_Import_criteria_Percentage_PMPM_PCPM ***************");		  
		consumerpage.login_CE_validations();
		Commission_Page.ClickOnMinimizeCallwindow();
		Commision_Validations.Import_Commision_Percentage();
		Commision_Validations.Home_Page_Redirection();
		Commision_Validations.createNewCustomer();
		Commision_Validations.Create_Policy();
		Commision_Validations.Home_Page_Redirection();
		
		Commision_Validations.recaluculate();
		Commision_Validations.Reports_Validation();
		consumerpage.logout_CE_validations();
		
	}




}
