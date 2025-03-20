package com.test;

import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import com.pages.Agent360Page;
import com.pages.Agent_Validations;
import com.pages.CensusInfo;
import com.pages.CustomerEngageFunctionalityValidations;

import Utility.ExcelHelper;

public class AG_TS_005_TC_001_TS_004_TC_004_Create_Validate_State_Licenses extends AllScenarios_EG_TC {
	CensusInfo ApplicantInfo = new CensusInfo();
	CensusInfo SpouseInfo = new CensusInfo();
	CensusInfo DomesticPartner = new CensusInfo();
	

	ArrayList<CensusInfo> DependentsInfo = new ArrayList<CensusInfo>();
	CensusInfo DependentInfo = new CensusInfo();
	public void State_Licenses(CensusInfo ApplicantInfo)	throws ClassNotFoundException, Exception {
		Agent360Page Agent360Page =new Agent360Page(driver);
		Agent_Validations Agent_Validations = new Agent_Validations(driver);
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

		System.out.println("******* Validation of AG_TS_004_TC_004_State_Licenses ***************");		  
		consumerpage.login_CE_validations();
		Agent_Validations.ClickOnMinimizeCallwindow();
//		Agent_Validations.agency_CreateAgent(ApplicantInfo);
		ExtentSuccessMessage("Start AG_TS_005_TC_001_Create_State_License");
		Agent_Validations.Create_Licenses();
		ExtentSuccessMessage("End AG_TS_005_TC_001_Create_State_License");
		ExtentSuccessMessage("*******************************************");
		ExtentSuccessMessage("Start AG_TS_004_TC_004_State_Licenses");
		Agent_Validations.license_Fields_Validation();
		ExtentSuccessMessage("End AG_TS_004_TC_004_State_Licenses");
		ExtentSuccessMessage("*******************************************");		
		consumerpage.logout_CE_validations();
		
	}

}
