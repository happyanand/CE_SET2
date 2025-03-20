package com.test;

import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import com.pages.Agent360Page;
import com.pages.CensusInfo;
import com.pages.CustomerEngageFunctionalityValidations;


import Utility.ExcelHelper;

public class AGTS002TC001TS004TC006TS004TC007TS007TC001TS008TC001TC002createsalesmanfieldsinquotes_policystabCollaborationsFilterAdvanceSearch extends AllScenarios_EG_TC {
	CensusInfo ApplicantInfo = new CensusInfo();
	CensusInfo SpouseInfo = new CensusInfo();
	CensusInfo DomesticPartner = new CensusInfo();
	

	ArrayList<CensusInfo> DependentsInfo = new ArrayList<CensusInfo>();
	CensusInfo DependentInfo = new CensusInfo();
	public void CE_TC_Agent_360_validate_the_create_a_new_agent_or_salesman(CensusInfo ApplicantInfo)	throws ClassNotFoundException, Exception {
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

		System.out.println("******* Customer Engage Login Logout Validation AG_TS_002_TC_001_create_a_new_agent_or_salesman ***************");		  
		consumerpage.login_CE_validations();
		Agent360Page.ValidateCreateAgentorSalesmen(ApplicantInfo);
		consumerpage.logout_CE_validations();
		
	}

}