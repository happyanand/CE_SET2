package com.test;

import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import com.pages.Agent360Page;
import com.pages.CensusInfo;
import com.pages.CustomerEngageFunctionalityValidations;


import Utility.ExcelHelper;

public class AG_TS_001_TC_004_validate_the_existing_agents_AOR_displayed_on_agent_grid extends AllScenarios_EG_TC {
	CensusInfo ApplicantInfo = new CensusInfo();
	CensusInfo SpouseInfo = new CensusInfo();
	CensusInfo DomesticPartner = new CensusInfo();
	

	ArrayList<CensusInfo> DependentsInfo = new ArrayList<CensusInfo>();
	CensusInfo DependentInfo = new CensusInfo();
	public void CE_TC_Agent_360_validate_the_existing_agents_AOR_are_getting_displayed_on_the_agent_grid(CensusInfo ApplicantInfo)	throws ClassNotFoundException, Exception {
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

		System.out.println("******* Customer Engage Login Logout Validation AG_TS_001_TC_004_validate_the_existing_agents_AOR_displayed_on_agent_grid ***************");		  
		consumerpage.login_CE_validations();
		Agent360Page.Validate_existing_agents_AOR_are_getting_displayed_on_the_agent_grid(ApplicantInfo);
		consumerpage.logout_CE_validations();
		
	}

}