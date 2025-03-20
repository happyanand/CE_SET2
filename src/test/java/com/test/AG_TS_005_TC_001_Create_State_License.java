package com.test;

import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import com.pages.Agent360Page;
import com.pages.Agent_Validations;
import com.pages.CensusInfo;
import com.pages.CustomerEngageFunctionalityValidations;

import Utility.ExcelHelper;

public class AG_TS_005_TC_001_Create_State_License extends AllScenarios_EG_TC {
	CensusInfo ApplicantInfo = new CensusInfo();
	CensusInfo SpouseInfo = new CensusInfo();
	CensusInfo DomesticPartner = new CensusInfo();
	

	ArrayList<CensusInfo> DependentsInfo = new ArrayList<CensusInfo>();
	CensusInfo DependentInfo = new CensusInfo();
	public void Create_State_Licenses(CensusInfo ApplicantInfo)	throws ClassNotFoundException, Exception {
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

		System.out.println("******* AG_TS_005_TC_001_Create_State_License ***************");		  
		consumerpage.login_CE_validations();
		Agent_Validations.ClickOnMinimizeCallwindow();
		//Agent360Page.Validate_updating_without_entering_mandatory_fields_entering_invalid_details(ApplicantInfo);
		Agent_Validations.agency_CreateAgent(ApplicantInfo);
		Agent_Validations.Create_Licenses();
		consumerpage.logout_CE_validations();
}
}