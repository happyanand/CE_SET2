package com.test;

import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import com.pages.Agent360Page;
import com.pages.CensusInfo;
import com.pages.Commission_Page;
import com.pages.CustomerEngageFunctionalityValidations;

import Utility.ExcelHelper;

public class CAM_TS_001_TC_001_TC_002_TC_003_TC_004_TC_006_TC_007_TC_008_TC_009_TC_010 extends AllScenarios_EG_TC {
	CensusInfo ApplicantInfo = new CensusInfo();
	CensusInfo SpouseInfo = new CensusInfo();
	CensusInfo DomesticPartner = new CensusInfo();
	

	ArrayList<CensusInfo> DependentsInfo = new ArrayList<CensusInfo>();
	CensusInfo DependentInfo = new CensusInfo();
	public void CE_TC_Commission_Validate_CAM_TS_001_TC_001_TC_002_TC_003_TC_004_TC_006_TC_007_TC_008_TC_009(CensusInfo ApplicantInfo)	throws ClassNotFoundException, Exception {
		Commission_Page Commission_Page =new Commission_Page(driver);
		
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

		System.out.println("******* Customer Engage Login Logout Validation CAM_TS_001_TC_001_TC_002_TC_003_TC_004_TC_006_TC_007_TC_008_TC_009_TC_010 ***************");		  
		consumerpage.login_CE_validations();
		Commission_Page.ValidateCommissionManagement();
		consumerpage.logout_CE_validations();
		
	}

}