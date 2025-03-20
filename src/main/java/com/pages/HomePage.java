package com.pages;

import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.BasePackage.Base_Class;

import Common.WaitWrapper;
import Utility.ExcelHelper;
import Utility.Logs.Log;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	ExcelHelper _excelObj = new ExcelHelper();
	XSSFSheet tcTestData = _excelObj.readExcelSheet("TestData", "URLs");

	private	By signInButtonClass = By.className("btnSignIn");
	private	By signout = By.xpath("//a[@class=\"dropdownMenu user-details-menuSection dropdownArrowMenu\"]");
	private	By signoutbtn = By.xpath("//*[@id='dropdownMenuListSec']//a[contains(text(),'Sign Out')]");
	private	By signoutInshura = By.xpath("//div[@class=\"signoutsec\"]");
	private By CTIMinimizeIcon = By.xpath("//a[@class='fa fa-minus right-al']");
	private By L_ProfileStatus = By.xpath("//*[@class='profile']//span");
	private By L_ContactIcon = By.xpath("//*[@title='Users']");
	private By L_Profile_Settings = By.xpath("//*[@title='Profile Settings']");
	private By L_Dial_Pad = By.xpath("//*[@title='Dial Pad']");
	private By L_EnterPhoneNumber = By.xpath("//*[@placeholder='Enter Phone Number']");
	private By L_CallButton = By.xpath("//*[@ng-click='CTICtrl.makeOutboundCall()']");
	private By L_RecordingPage = By.xpath("//*[@title='Recordings']");
	private By L_GotoHomePage =By.xpath("//*[@name='menu_home'] | //*[@href='/#/home']");
	private By L_GotoHomePage1 =By.xpath("//*[@name='menu_home']");



	//	// Go to Homepage
	//	public HomePage goToInshura() {
	//
	//		String InshuraUrl = tcTestData.getRow(1).getCell(1).toString();
	//		Log.info("Opening Inshura Website.");
	//		driver.get(InshuraUrl);
	//		return this;
	//	}
	//
	//	public HomePage goToBE() {
	//		String BEURL = tcTestData.getRow(2).getCell(1).toString();
	//		Log.info("Opening BE Website.");
	//		driver.get(BEURL);
	//		return this;
	//	}

	public HomePage goToTC() {
		String TCURL = tcTestData.getRow(1).getCell(1).toString();
		Log.info("Opening Truecoverage Website.");
		driver.get(TCURL);
		return this;
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
	public void GotoHomepage() throws InterruptedException {
		if (ElementDisplayed(L_GotoHomePage)) {
			ExtentSuccessMessage("Successfully user able to See 'Home page' ");
			click(L_GotoHomePage);
			ExtentSuccessMessage("Successfully user Clicked on 'Homw Page' ");
		} else {
			ExtentSuccessMessage("Unsuccessfully 'Homw Page' Not visible");
		}
		Thread.sleep(5000);
		ClickOnMinimizeCallwindow();
	}
	
	public void GotoHomepage1() throws InterruptedException {
		Thread.sleep(5000);
		if (ElementDisplayed(L_GotoHomePage1)) {
			ExtentSuccessMessage("Successfully user able to See 'Home page' ");
			click(L_GotoHomePage1);
			ExtentSuccessMessage("Successfully user Clicked on 'Home Page' ");
		} else {
			Thread.sleep(9000);
			By menu_bar = By.xpath("//i[@class='fa fa-bars']");
			waitVisibility(menu_bar);
			if (ElementDisplayed(menu_bar)) {
				wait.until(ExpectedConditions.presenceOfElementLocated(menu_bar));
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
		Thread.sleep(3000);
		RefreshPage();
		Thread.sleep(5000);
		ClickOnMinimizeCallwindow();
	}

	public HomePage Logout() throws InterruptedException {
		Log.info("Logging out");
		WaitWrapper.waiter(3000, "Sign out", driver);
		click(signout);

		try {
			click(signoutbtn);

		} catch (Exception e) {
			click(signoutInshura);
		}
		WaitWrapper.waiter(3000, "Sign out", driver);
		driver.close();
		return this;
	}

	// Go to LoginPage
	public LoginPage goToLoginPage() {
		Log.info("Going to Login Page..");
		// click(signInButtonClass);
		// driver.findElement(By.xpath("//a[@id='login']")).click();// required for UAT
		// ture cov only
		return new LoginPage(driver);
	}

	//	// Go to Quote and Enroll
	//	public QuoteEnroll goToClientCreation() {
	//		Log.info("Going to Quote and Enroll");
	//		// click(signInButtonClass);
	//		return new QuoteEnroll(driver);
	//	}
	//
	//	// Enrollment
	//	public NewApplication goToNewApplicationFlow() {
	//		Log.info("Going to Quote and Enroll");
	//		// click(signInButtonClass);
	//		return new NewApplication(driver);
	//	}
	//
	//	public UpdateApplication goToUpdateApplicationFlow() {
	//		Log.info("Going to Quote and Enroll");
	//		// click(signInButtonClass);
	//		return new UpdateApplication(driver);
	//	}

//	public AddCarriers goToAddCarriersFlow() {
//		Log.info("Going to Carrier Appointments");
//		// click(signInButtonClass);
//		return new AddCarriers(driver);
//	}

	public Object doQuotingFlow(String className) throws ClassNotFoundException, InterruptedException {
		Log.info("Going to Quote and Enroll");
		Thread.sleep(2000);
		By QuoteandEnroll = By
				.xpath("/html/body/app-root/app-dashboard-router/div[1]/app-portal-header/div/div/ul/li[1]/a/label");
		By QuoteNow = By.xpath("//*[text()=\"Quote Now\"]");
		By Medical = By.xpath("//*[@id=\"dropdownMenuListSec\"]/div/div[1]/div/div[1]/div[1]/a/bdo");
		click(QuoteNow);
		click(Medical);
		Thread.sleep(4000);
		return PageFactory.initElements(driver, Class.forName(className));
	}

	public Object doMarketplaceFlow_Inshra(String className) throws ClassNotFoundException, InterruptedException {
		Log.info("Going to Marketplace");
		Thread.sleep(4000);
		By Marketplace = By.xpath("//div[@class='nav-wrapper']//span[contains(text(),'Marketplace')]");
		click(Marketplace);
		return PageFactory.initElements(driver, Class.forName(className));
	}

	public Object doFindInsurance(String className) throws ClassNotFoundException, InterruptedException {
		Log.info("Going to Quote and Enroll");
		Thread.sleep(4000);
		By QuoteNow = By.xpath("//a[contains(text(),'Find Insurance')]");
		By Medical = By.xpath("//div[@class='dropdownMenuList']//a[contains(text(),'Health')]");
		click(QuoteNow);
		click(QuoteNow);
		click(Medical);
		Thread.sleep(5000);
		return PageFactory.initElements(driver, Class.forName(className));
	}

	public Object doMarketplaceFlow(String className) throws ClassNotFoundException, InterruptedException {
		Log.info("Going to Marketplace");
		Thread.sleep(4000);
		By Marketplace = By.xpath("//div[@class='nav-wrapper']//span[contains(text(),'Marketplace')]");
		click(Marketplace);
		Thread.sleep(4000);
		return PageFactory.initElements(driver, Class.forName(className));
	}

	public Object doBEMarketplaceFlow(String className) throws ClassNotFoundException, InterruptedException {
		Log.info("Going to Marketplace");
		Thread.sleep(4000);
		By Marketplace = By.xpath("//a[@class='AccessGoToFFMss']");	
		click(Marketplace);
		Thread.sleep(3000);
		Log.info("clicked Marketplace");
		return PageFactory.initElements(driver, Class.forName(className));
	}

	public static void main(String[] args) {
		// homepage.Logout();
	}


	public void validate_the_CTI_profile_section() throws InterruptedException {

		CheckProfileStatus();
		CheckContactIconIsvisible();
		CheckCallButtonIsvisible();
		CheckProfile_SettingsIsvisible();
		CheckDial_PadIsvisible();
		CheckEnterPhoneNumberIsvisible();
		CheckCallButtonIsvisible();

	}
	public void CheckProfileStatus() throws InterruptedException {
		waitVisibility(L_ProfileStatus);
		if(ElementDisplayed(L_ProfileStatus)) {
			WebElement checkboElement = driver.findElement(L_ProfileStatus);
			String GetStatus = checkboElement.getAttribute("class");
			Assert.assertEquals(GetStatus, "status AVAILABLE");
			ExtentSuccessMessage("Assertion has been done");
			ExtentSuccessMessage("Successfully user able to See 'Profile Status AS :- ' "+GetStatus);
		}else {
			ExtentErrorMessage(" Profile Status Not visible");
		}
	}

	public void CheckContactIconIsvisible() throws InterruptedException {
		waitVisibility(L_ContactIcon);
		if(ElementDisplayed(L_ContactIcon)) {
			ExtentSuccessMessage("Successfully user able to See 'Contact Icon' ");
		}else {
			ExtentErrorMessage("Unsuccessfully 'Contact Icon' Not visible");
		}
	}

	public void CheckProfile_SettingsIsvisible() throws InterruptedException {
		waitVisibility(L_Profile_Settings);
		if(ElementDisplayed(L_Profile_Settings)) {
			ExtentSuccessMessage("Successfully user able to See 'Profile_Settings ' ");
		}else {
			ExtentErrorMessage("Unsuccessfully 'Profile_Settings' Not visible");
		}
	}

	public void CheckDial_PadIsvisible() throws InterruptedException {
		waitVisibility(L_Dial_Pad);
		if(ElementDisplayed(L_Dial_Pad)) {
			ExtentSuccessMessage("Successfully user able to See 'Dial_Pad ' ");
		}else {
			ExtentErrorMessage("Unsuccessfully 'Dial_Pad' Not visible");
		}
	}

	public void CheckEnterPhoneNumberIsvisible() throws InterruptedException {
		waitVisibility(L_EnterPhoneNumber);
		if(ElementDisplayed(L_EnterPhoneNumber)) {
			ExtentSuccessMessage("Successfully user able to See 'EnterPhoneNumber ' ");
		}else {
			ExtentErrorMessage("Unsuccessfully 'EnterPhoneNumber' Not visible");
		}
	}

	public void CheckCallButtonIsvisible() throws InterruptedException {
		waitVisibility(L_CallButton);
		if(ElementDisplayed(L_CallButton)) {
			ExtentSuccessMessage("Successfully user able to See 'CallButton ' ");
		}else {
			ExtentErrorMessage("Unsuccessfully 'CallButton' Not visible");
		}
	}

	public void validate_Default_Login_CTI_profile() throws InterruptedException {

		CheckProfileStatus();
		CheckCallButtonIsvisible();
		CheckDial_PadIsvisible();
		CheckCallButtonIsvisible();
		
	}
	
	public void ClickedOnRecordingPage() throws InterruptedException {
		waitVisibility(L_RecordingPage);
		if(ElementDisplayed(L_RecordingPage)) {
			ExtentSuccessMessage("Successfully user able to See 'RecordingPage ' ");
			click(L_RecordingPage);
			ExtentSuccessMessage("Successfully user Clicked on 'Recording Page ' ");
		}else {
			ExtentErrorMessage("Unsuccessfully 'L_RecordingPage' Not visible");
		}
	}
	public void ClickedOnForwarding() throws InterruptedException {
		waitVisibility(L_RecordingPage);
		if(ElementDisplayed(L_RecordingPage)) {
			ExtentSuccessMessage("Successfully user able to See 'forwarding ' ");
			click(L_RecordingPage);
			ExtentSuccessMessage("Successfully user Clicked on 'forwarding  ' ");
		}else {
			ExtentErrorMessage("Unsuccessfully 'forwarding' Not visible");
		}
	}
	

}