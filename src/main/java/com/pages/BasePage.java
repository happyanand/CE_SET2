package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.text.RandomStringGenerator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class BasePage {
	private static final By WebElement = null;
	public static WebDriver driver;
	public  WebDriverWait wait;
	public static String NewApplicantName;
	private By CTIMinimizeIcon = By.xpath("//a[@class='fa fa-minus right-al']");



	public void ClickOnMinimizeCallwindow() throws InterruptedException {		
		if (ElementDisplayed(CTIMinimizeIcon)) {
			ExtentSuccessMessage("Successfully user able to See 'Minimize Icon' ");
			click(CTIMinimizeIcon);
			ExtentSuccessMessage("Successfully user Clicked on 'Minimize Icon' ");
		} else {
			ExtentSuccessMessage("Unsuccessfully 'Minimize' Not visible");
		}
	}


	// Constructor
	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofMinutes(2));
	}

	//	public String writeDynamicLastname() {
	//		String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "AEIOU";
	//		String lastname = "";
	//		String lastnameDomain = "";
	//		String temp = RandomStringUtils.random(25, allowedChars);
	//		lastnameDomain = temp.substring(0, temp.length() - 15);
	//		lastname = temp.substring(0, temp.length() - 9);
	//		return lastname;		
	//	}

	public String writeDynamicFirstLastname() {
		String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "AEIOU";
		String temp = RandomStringUtils.random(25, allowedChars);

		// Adjust the substring lengths based on your requirements
		String lowercaseLastname = temp.substring(0, temp.length() - 9);

		// Make the first character uppercase
		String capitalizedLastname = Character.toUpperCase(lowercaseLastname.charAt(0)) + lowercaseLastname.substring(1);

		return capitalizedLastname;
	}


	// Click Method
	public void click(By element) throws InterruptedException {	
		//		Thread.sleep(1100);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.presenceOfElementLocated(element));
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		//		Thread.sleep(1100);
	}

	public void select(By by, String text) throws InterruptedException {
		// waitVisibility(by).click();
		Thread.sleep(1000);
		click(By.xpath("//span[text()='"+text+"']"));
		Thread.sleep(1000);
	}

	public Select selectVal(By by) throws InterruptedException {
		waitVisibility(by).click();
		// click(By.xpath("//div[@class='row margin_bottom_0px censuslist
		// Applicantcensus showncensus']//span[text()='"+text+"']"));
		return null;

	}

	public void clear(By by) {
		WebDriverWait wait2=new WebDriverWait(driver, Duration.ofMinutes(1));
		wait2.until(ExpectedConditions.presenceOfElementLocated(by)).clear();
	}

	public void submit(By by) {
		waitVisibility(by).submit();
	}

	// Write Text
	public void writeText(By by, String text) throws InterruptedException {
		//		Thread.sleep(1000);
		//        waitVisibility(WebElement).sendKeys(text);
		//    	Thread.sleep(1000);
		//		Thread.sleep(800);
		//	WebDriverWait wait2 = new WebDriverWait(driver, 30);
		WebDriverWait wait2=new WebDriverWait(driver, Duration.ofMinutes(2));
		wait2.until(ExpectedConditions.presenceOfElementLocated(by)).sendKeys(text);
		//		Thread.sleep(800);
	}

	public String writeDynamicEmail() {
		String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890";
		String email = "";
		String emailDomain = "";
		String temp = RandomStringUtils.random(25, allowedChars);
		emailDomain = temp.substring(0, temp.length() - 15);
		email = temp.substring(0, temp.length() - 9) + "@" + "yopmail.com";
		return email;		
	}

	public static String generatePhoneNumber() {
		Random rand = new Random();


		String phoneNumber = "7"; 
		for (int i = 0; i < 9; i++)
		{
			phoneNumber += rand.nextInt(10); 

		}

		return phoneNumber;
	}

	public String writeEmailToExcel(String emailText) throws IOException {
		String excelFilePath = ".\\src\\test\\resources\\TestData.xlsx";
		FileInputStream inputStream = new FileInputStream(excelFilePath);
		Workbook workbook = new XSSFWorkbook(inputStream);
		String sheetName = "TestCase Regression 8";
		Sheet sheet = workbook.getSheet(sheetName);
		int rowIndex = 1;  
		int columnIndex = 9; 
		Row row = sheet.getRow(rowIndex);
		Cell cell = row.createCell(columnIndex);
		cell.setCellValue(emailText);  
		inputStream.close();
		FileOutputStream outputStream = new FileOutputStream(excelFilePath);
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();
		return null;		
	}

	public void writetext(WebElement txt, String text) {
		waitVisibility(WebElement).sendKeys(text);
	}

	// Read Text
	public String readText(By by) {
		return waitVisibility(by).getText();
	}

	// Wait
	public WebElement waitVisibility(By by) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public static void JavascriptClick(By by, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", by);
	}

	public static void ExtentSuccessMessage(String strPassSuccessMessage) {
		ExtentTestManager.getTest().log(Status.PASS, strPassSuccessMessage);
	}

	public static void ExtentErrorMessage(String strPassErrorMessage) {
		ExtentTestManager.getTest().log(Status.FAIL, strPassErrorMessage);
	}

	public void HandleDropDown(WebElement ele, String ele2)
	{
		Select s=new Select(ele);
		s.selectByValue(ele2);
	}

	public void ActionClick(WebElement ele) throws InterruptedException
	{
		Thread.sleep(1000);
		Actions act=new Actions(driver);
		act.click(ele).perform();
		Thread.sleep(1000);

	}

	public void MoveToElementClick(WebElement element) throws InterruptedException {    
		Thread.sleep(1500);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		// Use JavaScript Executor to move to the element
		jsExecutor.executeScript("arguments[0].scrollIntoView({behavior: 'auto', block: 'center', inline: 'center'});", element);
		// Click the element using JavaScript Executor
		jsExecutor.executeScript("arguments[0].click();", element);
	}


	public static Properties configloader() throws IOException {
		FileInputStream File = new FileInputStream(".\\src\\test\\resources\\config.properties");
		Properties properties = new Properties();
		properties.load(File);
		return properties;
	}

	public static boolean ElementDisplayed(By locator) throws InterruptedException {

		Boolean flag = false;
		try {
			WebElement element = driver.findElement(locator);
			flag = element.isDisplayed();

		} catch (Exception e) {
			// TODO: handle exception
		}
		if (flag) {
			ExtentSuccessMessage("Successfully System able to found the element :" + locator);
			return flag;
		} else {
			ExtentSuccessMessage("System not able to found the element :" + locator);
			System.out.println("System not able to found the element :" + locator);
			flag = false;
		}
		return flag;
	}
	public static boolean ElementDisplayeds(By locator) throws InterruptedException {

		Boolean flag = false;
		try {
			WebElement element = driver.findElement(locator);
			flag = element.isDisplayed();

		} catch (Exception e) {
			// TODO: handle exception
		}
		if (flag) {
			System.out.println("Successfully System able to found the element :" + locator);
			return flag;
		} else {
			System.out.println("System not able to found the element :" + locator);
			flag = false;
		}
		return flag;
	}

	//Asif Alam (splitthewindowscreen)
	// To split the windows in the left and right positions 

	public void splitthewindowscreen(String position) {
		// Get the screen dimensions
		Dimension screenSize = driver.manage().window().getSize();
		// Calculate the dimensions for each split
		int width = screenSize.getWidth() / 2;
		int height = screenSize.getHeight();

		if(position.toUpperCase().contains("RIGHT")) {
			//    	 Set the window position and size for the second split
			driver.manage().window().setPosition(new Point(0, 0));
			driver.manage().window().setSize(new Dimension(width, height));
		}if(position.toUpperCase().contains("LEFT")) {
			// Set the window position and size for the first split
			driver.manage().window().setPosition(new Point(680, 0));
			driver.manage().window().setSize(new Dimension(width, height));
		}    
	}
	public void RefreshPage() {
		driver.navigate().refresh();
	}
	public String CurrentTime() {
		// Set the time zone to USA Eastern Time (New York)
		ZoneId zoneId = ZoneId.of("America/New_York");
		// Get current time in the specified time zone
		LocalTime currentTime = LocalTime.now(zoneId);
		// Define a time formatter to format the time as needed
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
		// Format the current time
		String formattedTime = currentTime.format(formatter);
		// Print the formatted time
		System.out.println("Current time in USA (Eastern Time - New York): " + formattedTime);
		return formattedTime;
	}
	public String Currentdate() {
		// Set the time zone to USA Eastern Time (New York)
		ZoneId zoneId = ZoneId.of("America/New_York");
		// Get current date
		LocalDate currentDate = LocalDate.now(zoneId);

		// Define a date formatter to format the date as needed
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

		// Format the current date
		String formattedDate = currentDate.format(formatter);

		// Print the formatted date
		System.out.println("Current date in USA format: " + formattedDate);
		return formattedDate;
	}
	public String Currentdate1() {
		// Set the time zone to USA Eastern Time (New York)
		ZoneId zoneId = ZoneId.of("America/New_York");
		// Get current date
		LocalDate currentDate = LocalDate.now(zoneId);

		// Define a date formatter to format the date as needed
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");

		// Format the current date
		String formattedDate = currentDate.format(formatter);

		// Print the formatted date
		System.out.println("Current date in USA format: " + formattedDate);
		return formattedDate;
	}
	public int CurrentYear() {
		// Set the time zone to "America/New_York"
		ZoneId zoneId = ZoneId.of("America/New_York");

		// Get the current date and time in the specified time zone
		ZonedDateTime currentDateTime = ZonedDateTime.now(zoneId);

		// Get the current year from the ZonedDateTime object
		int currentYear = currentDateTime.getYear();

		// Print the current year
		System.out.println("Current year in America/New_York timezone: " + currentYear);
		return currentYear;
	}

	public String CurrentMonth() {
		// Set the time zone to "America/New_York"
		ZoneId zoneId = ZoneId.of("America/New_York");

		// Get the current date and time in the specified time zone
		ZonedDateTime currentDateTime = ZonedDateTime.now(zoneId);

		// Get the current month as a number (1-12)

		int monthNumber = currentDateTime.getMonthValue();
		// Format the month to always display two digits (e.g., 01, 02, 03, etc.)
		String formattedMonth = String.format("%02d", monthNumber);

		// Print the formatted current month
		System.out.println("Current month number in New York (formatted): " + formattedMonth);

		//        int monthInt = Integer.parseInt(formattedMonth);
		//
		//        // Print the integer value of the month
		//        System.out.println("Converted current month as integer: " + monthInt);

		// Return the integer value of the month
		return formattedMonth;
	}

	public int CurrentMonths() {
		// Set the time zone to "America/New_York"
		ZoneId zoneId = ZoneId.of("America/New_York");

		// Get the current date and time in the specified time zone
		ZonedDateTime currentDateTime = ZonedDateTime.now(zoneId);

		// Get the current month as a number (1-12)

		int monthNumber = currentDateTime.getMonthValue();

		// Format the month to always display two digits (e.g., 01, 02, 03, etc.)
		String formattedMonth = String.format("%02d", monthNumber);

		// Print the formatted current month
		System.out.println("Current month number in New York (formatted): " + formattedMonth);

		int monthInt = Integer.parseInt(formattedMonth);

		// Print the integer value of the month
		System.out.println("Converted current month as integer: " + monthInt);

		// Return the integer value of the month
		return monthInt;
	}


	public static String SevendaysagoDate() {
		// Get today's date
		// Set the time zone to USA Eastern Time (New York)
		ZoneId zoneId = ZoneId.of("America/New_York");
		// Get current date
		LocalDate currentDate = LocalDate.now(zoneId);
		// Get yesterday's date
		LocalDate yesterday = currentDate.minusDays(6);
		// Define a date formatter to format the date as needed
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

		// Format the current date
		String formattedDate = yesterday.format(formatter);

		// Print yesterday's date
		System.out.println("Yesterday's date: " + formattedDate);
		return formattedDate;
	}
	public static String YesterdayDate() {
		// Get today's date
		// Set the time zone to USA Eastern Time (New York)
		ZoneId zoneId = ZoneId.of("America/New_York");
		// Get current date
		LocalDate currentDate = LocalDate.now(zoneId);
		// Get yesterday's date
		LocalDate yesterday = currentDate.minusDays(1);
		// Define a date formatter to format the date as needed
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

		// Format the current date
		String formattedDate = yesterday.format(formatter);

		// Print yesterday's date
		System.out.println("Yesterday's date: " + formattedDate);
		return formattedDate;
	}
	public static void MouseHoverOnElement(By element) throws InterruptedException {
		WebDriverWait wait2=new WebDriverWait(driver, Duration.ofMinutes(2));
		wait2.until(ExpectedConditions.presenceOfElementLocated(element));
		WebElement ele = driver.findElement(element);
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
	}
	public static void input(By element, String Value) throws InterruptedException {
		//WebDriverWait wait2 = new WebDriverWait(driver, 30);
		WebDriverWait wait2=new WebDriverWait(driver, Duration.ofMinutes(1));
		wait2.until(ExpectedConditions.presenceOfElementLocated(element)).sendKeys(Value);
	}
	public String generateRandomText() {
		// Create a generator using Apache Commons Text
		RandomStringGenerator generator = new RandomStringGenerator.Builder()
				.withinRange('a', 'z')
				.build();
		// Generate a random word of length 8
		String randomWord = generator.generate(8);
		System.out.println("Random Word: " + randomWord);
		return randomWord;
	}
	public String generateRandomText4() {
		// Create a generator using Apache Commons Text
		RandomStringGenerator generator = new RandomStringGenerator.Builder()
				.withinRange('a', 'z')
				.build();
		// Generate a random word of length 8
		String randomWord = generator.generate(4);
		System.out.println("Random Word: " + randomWord);
		return randomWord;
	}
	public String GetElementText(By locator) throws InterruptedException {

		String stxt = null;
		waitVisibility(locator);
		WebElement element = driver.findElement(locator);
		if (element.isDisplayed()) {
			stxt = element.getText();
			ExtentSuccessMessage("System able to found the element :" + locator);
		} else {
			ExtentSuccessMessage("System not able to found the element :" + locator);
		}
		return stxt;
	}
	public void SelectActiveDropdown (By by, String value) throws InterruptedException {
		if(ElementDisplayed(by)) {
			click(by);
			Thread.sleep(3000);
			By options = By.xpath("//*[contains(@class,'dropDown md-active md-clickable')]//*[@value='"+value+"']");
			if(ElementDisplayed(options)) {				
				click(options);
				ExtentSuccessMessage("Successfully user found and clicked on the "+value+" value inside the dropdown ");
			} else {
				Thread.sleep(4000);
				waitVisibility(options);			
				click(options);
				ExtentSuccessMessage("Successfully user found and clicked on the "+value+" value inside the dropdown ");
		} }else {
			ExtentErrorMessage("UnSuccessfully user not found and clicked on the "+value+" value inside the dropdown ");
		}

	}
	public void UserSelectThedropdownValue(String value) throws InterruptedException {
		By options = By.xpath("//*[contains(@class,'dropDown md-active md-clickable')]//*[@value='"+value+"']");
		if(ElementDisplayed(options)) {
			click(options);
			ExtentSuccessMessage("Successfully user found and clicked on the "+value+" value inside the dropdown ");

		}else {
			ExtentErrorMessage("UnSuccessfully user not found and clicked on the "+value+" value inside the dropdown ");
		}
	}
	public void WaitUntillPAgeLoad() throws InterruptedException {
		int count =0;
		By Element = By.xpath("//*[@class='loader small-custom  ng-show']");
		do {
			count++;
			Thread.sleep(15000);
			System.out.println("Wait for page load");
			System.out.println("Count"+count);
			if (count== 4) {
				RefreshPage();
				Thread.sleep(15000);
				ClickOnMinimizeCallwindow();
				break;
			}			 
		}
		while (ElementDisplayed(Element));
	}
	public void WaitUntillPAgeLoad1() throws InterruptedException {
		int count =0;
		By Element = By.xpath("//*[@class='loader small-custom  ng-show']");
		do {
			count++;
			Thread.sleep(25000);
			System.out.println("Wait for page load");
			System.out.println("Count"+count);
			if (count== 4) {
				RefreshPage();
				Thread.sleep(15000);
				ClickOnMinimizeCallwindow();
				break;
			}			 
		}
		while (ElementDisplayed(Element));
	}
	
	public void Zoomout() throws AWTException {
		Robot robot = new Robot(); 
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_0);
		robot.delay(1000);
		robot.keyRelease(KeyEvent.VK_0);
		robot.delay(1000);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.delay(1000);         
	}

	public void Zoomin(int value) throws AWTException {
		Robot robot = new Robot();
		for (int i = 0; i < value; i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.delay(1000);
			robot.keyPress(KeyEvent.VK_SUBTRACT);
			robot.delay(1000);
			robot.keyRelease(KeyEvent.VK_SUBTRACT);
			robot.delay(1000);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.delay(1000);
		}
	}


}