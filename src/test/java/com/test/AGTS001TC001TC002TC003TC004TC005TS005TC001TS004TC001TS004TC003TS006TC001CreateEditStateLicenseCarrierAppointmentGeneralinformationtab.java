package com.test;

import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import com.pages.Agent360Page;
import com.pages.CensusInfo;
import com.pages.CustomerEngageFunctionalityValidations;


import Utility.ExcelHelper;

public class AGTS001TC001TC002TC003TC004TC005TS005TC001TS004TC001TS004TC003TS006TC001CreateEditStateLicenseCarrierAppointmentGeneralinformationtab extends AllScenarios_EG_TC {
	CensusInfo ApplicantInfo = new CensusInfo();
	CensusInfo SpouseInfo = new CensusInfo();
	CensusInfo DomesticPartner = new CensusInfo();
	

	ArrayList<CensusInfo> DependentsInfo = new ArrayList<CensusInfo>();
	CensusInfo DependentInfo = new CensusInfo();
	public void CE_TC_Agent_360_validate_the_edit_agent_details_and_save_the_changes(CensusInfo ApplicantInfo)	throws ClassNotFoundException, Exception {
		Agent360Page Agent360Page =new Agent360Page(driver);
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

		System.out.println("******* Customer Engage Login Logout Validation AG_TS_001_TC_005_validate_the_edit_agent_details_and_save_the_changes ***************");		  
		consumerpage.login_CE_validations();
		Agent360Page.Validate_edit_agent_details_and_save_the_changes1(ApplicantInfo);
		consumerpage.logout_CE_validations();
		
	}

}