package com.pages;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.BasePackage.Base_Class;

public class PhoneNumberValidations extends BasePage {

	public PhoneNumberValidations(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	CustomerEngageFunctionalityValidations cfv = new CustomerEngageFunctionalityValidations(driver);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	WebElement element;

	private By EnterPhoneNumberField = By.xpath("//input[@placeholder='Enter Phone Number']");
	private By CallButton = By.xpath("(//button[@class='voice-call-green-button-small fa fa-phone'])[1]");
	private By lead_details = By.xpath("//div[@class='voice-call-ongoing-call']//li[1]//span[2]//a[1]");
	private By keypad_dial = By.xpath("//a[@ng-click='CTICtrl.showDialPad(true)']//i[contains(@class,'fa')]");
	private By CTIMinimizeIcon = By.xpath("//a[@class='fa fa-minus right-al']");
	private By SalesButton  = By.xpath("//span[text()='Sales ']");
	private By Leads = By.xpath("(//a[text()='Leads'])[2]");
	private By Num = By.xpath("(//div[@ng-show='!CTICtrl.CTIContext.primarayPhoneFlags.minimized']//span[@class='drag-not-allowed ng-binding'])[2]");

	private By CallDeclineButton = By.xpath("//button[@class=' voice-call-green-button-small fa fa-phone voice-decline ']");
	private By VoiceMail = By.xpath("//a[@title='Voice Mails']");
	private By CallRecordings = By.xpath("//a[@title='Recordings']");
	private By confirmation = By.xpath("//h3[normalize-space()='Confirm']");
	private By clickYes = By.xpath("//button[normalize-space()='Yes']");
	private By succesmessage = By.xpath("//div[@id='divSuccess']");
	private By Missedcalls = By.xpath("//span[@class='fa fa-phone']");
	private By voicenumber = By.xpath("//u[@title='Voice Number']");


	private By SMSIcon = By.xpath("//a[@class='fa fa-commenting-o count-info ng-scope']");
	private By NEWMessage = By.xpath("//span[@class='message-new-icon']");
	private By InputNumber = By.xpath("//div[@class='new-message-forms']/input[@class='ng-pristine ng-untouched ng-valid ng-empty']");
	private By MessageTextArea = By.xpath("(//textarea[@class='new-message-textarea ng-pristine ng-untouched ng-valid ng-empty'])[2]");
	private By SendButton = By.xpath("(//a[@class='fa icon-btns send'])[2]");
	private By QASMSSection = By.xpath("//a[@class='fa fa-commenting-o count-info ng-scope']");
	private By MessageReceived = By.xpath("(//ul[@class='message-list'])[1]/li[1]");
	private By Messagecontent = By.xpath("//div[@class='message-content']");

	private By Call_Logs = By.xpath("//a[@title='Call Logs']");
	private By Input_Num = By.xpath("(//input[@type='text'])[9]");
	private By Send_Message_Logs = By.xpath("//li[1]//span[1]//span[4]//i[1]");
	private By Send_Message_call = By.xpath("//*[@id='missedcallsection']/ul/li/a/span/i[2]");
	private By Dialpad = By.xpath("//a[@title='Dial Pad']");

	private By Messageplaceholder = By.xpath("//textarea[@placeholder='Enter your message here..']");
	private By SendSmsButton = By.xpath("//a[@ng-click='CTICtrl.sendNewMessage()']");
	private By YopmailInbox = By.xpath("//input[@id='login']");
	private By YopmailSubmit = By.xpath("//button[@title='Check Inbox @yopmail.com']");
	private By CheckUserLogin = By.xpath("//button[@class='positive md-button md-ink-ripple']");
	private By Qualatia1Number = By.xpath("//u[@title='Voice Number']");
	By userID = By.id("user-name");//------//for userid at Login page
	By pwd = By.id("password");//-------for password at home page
	By signIn = By.xpath("//*[@id='form-validation-button']");//-------for button on home page





	public void waitForElement(int time) throws InterruptedException {
		Thread.sleep(time);
	}


	public void EnterInvalidPhoneNumber() throws InterruptedException, IOException, AWTException
	{	
		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EnterPhoneNumberField));
		MoveToElementClick(element);//clicking on PhoneNumber Field
		writeText(EnterPhoneNumberField, "234264465");
		ExtentSuccessMessage("Invalid Phone Number has been entered");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CallButton));
		MoveToElementClick(element);//clicking on Call Button
		ExtentSuccessMessage("clicked on Call Button");
		waitForElement(2000);
		By Textmsg = By.xpath("//div[@id='divError']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Textmsg));
		String altmsg  = element.getText();
		String Altmsg = "Invalid Phone Number Format";
		ExtentSuccessMessage("-----------"+ altmsg +"------------");
		Assert.assertEquals(Altmsg, altmsg);
		ExtentSuccessMessage("Assertion has been done");			
	}

	public void DirectlyCallNumber() throws InterruptedException, IOException, AWTException
	{	
		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EnterPhoneNumberField));
		MoveToElementClick(element);//clicking on PhoneNumber Field
		String Number = "(386) 703-3867";
		writeText(EnterPhoneNumberField, Number);
		ExtentSuccessMessage("Phone Number has been entered");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CallButton));
		MoveToElementClick(element);//clicking on Call Button
		ExtentSuccessMessage("clicked on Call Button");
		waitForElement(5000);	
		By num = By.xpath("//div[@ng-show='!CTICtrl.CTIContext.primarayPhoneFlags.minimized']//span[@class='drag-not-allowed ng-binding'][normalize-space()='"+Number+"']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(num));
		String number  = element.getText();
		ExtentSuccessMessage("-----------"+ number +"------------");
		Assert.assertEquals(Number, number);
		ExtentSuccessMessage("Assertion has been done");
		String Name = "Daniel P";
		By name = By.xpath("//ul[@class='voice-call-incoming-user-lists-ul ng-scope']//span[@class='drag-not-allowed ng-binding'][normalize-space()='"+Name+"']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(name));
		String ContactName  = element.getText();
		ExtentSuccessMessage("-----------"+ ContactName +"------------");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(lead_details));
		MoveToElementClick(element);//clicking on Lead details
		waitForElement(5000);
		ExtentSuccessMessage("clicked on Lead Details");			
	}

	public void CallDisconnected() throws InterruptedException, IOException, AWTException
	{	
		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EnterPhoneNumberField));
		MoveToElementClick(element);//clicking on PhoneNumber Field
		writeText(EnterPhoneNumberField, "(479) 333-1769");
		ExtentSuccessMessage("Phone Number has been entered");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CallButton));
		MoveToElementClick(element);//clicking on Call Button
		ExtentSuccessMessage("clicked on Call Button");
		waitForElement(17000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(keypad_dial));
		MoveToElementClick(element);//clicking on Keypad and Star Button
		ExtentSuccessMessage("clicked on Keypad and * Button");

	}
	public void calllogs() throws InterruptedException
	{
		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EnterPhoneNumberField));
		MoveToElementClick(element);//clicking on PhoneNumber Field
		String Number = "(886) 713-3867";
		writeText(EnterPhoneNumberField, Number);
		ExtentSuccessMessage("Phone Number has been entered");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CallButton));
		MoveToElementClick(element);//clicking on Call Button
		ExtentSuccessMessage("clicked on Call Button");
		waitForElement(5000);	
		By num = By.xpath("//div[@ng-show='!CTICtrl.CTIContext.primarayPhoneFlags.minimized']//span[@class='drag-not-allowed ng-binding'][normalize-space()='"+Number+"']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(num));
		String number  = element.getText();
		ExtentSuccessMessage("-----------"+ number +"------------");
		Assert.assertEquals(Number, number);
		ExtentSuccessMessage("Assertion has been done");

		Thread.sleep(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CallDeclineButton));
		MoveToElementClick(element);
		System.out.println("<--------------------------Clicked on end call button--------------------------->");
		Thread.sleep(2000);
		By CalLogs = By.xpath("//a[@title='Call Logs']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CalLogs));
		MoveToElementClick(element);
		ExtentSuccessMessage("Call logs has been opened");
		Thread.sleep(2000);
		System.out.println("<--------------------------Clicked on calllogs button--------------------------->");
		By phnum = By.xpath("(//span[@class='drag-not-allowed ng-binding'][normalize-space()='"+Number+"'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(phnum));
		String phno  = element.getText();
		System.out.println(phno);
		Assert.assertEquals(Number, phno);
		System.out.println("<--------------------------Validated the latest outgoing call--------------------------->");
		ExtentSuccessMessage("Call log has been validated");



	}

	public void Validate_Call_Triggered_Hyperlink() throws InterruptedException 
	{
		Thread.sleep(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CTIMinimizeIcon));
		MoveToElementClick(element);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Leads));
		MoveToElementClick(element);
		ExtentSuccessMessage("Sales Lead has been clicked");
		Thread.sleep(8000);
		validateHyperLink();	
	}


	public void validateHyperLink() throws InterruptedException 
	{	
		List<WebElement> links = driver.findElements(By.xpath("//a[@class='ng-binding']"));
		System.out.println(links.size());
		if(links!=null) {
			Thread.sleep(8000);
			By PhNum = By.xpath("(//div/a/cti-call-btn)[1]");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(PhNum));
			String ph_num  = element.getText();
			System.out.println(ph_num);
			By num = By.xpath("(//cti-call-btn[@class='ng-binding'][normalize-space()='"+ph_num+"'])[1]");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(num));
			MoveToElementClick(element);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Num));
			String Ph_Number  = element.getText();
			ExtentSuccessMessage("-----------"+ Ph_Number +"------------");
			Assert.assertEquals(ph_num, Ph_Number);
			ExtentSuccessMessage("Assertion has been done");
		}

	}

	public void Dismissals() throws InterruptedException
	{
		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EnterPhoneNumberField));
		Thread.sleep(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Missedcalls));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on missed calls");
		Thread.sleep(2000);
		By removecall = By.xpath("//div[@id='missedcallsection']//li[1]//a[1]//span[1]//i[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(removecall));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on remove call");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(confirmation));
		element = wait.until(ExpectedConditions.presenceOfElementLocated(clickYes));
		MoveToElementClick(element);
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(succesmessage));
		ExtentSuccessMessage("Validated the success message");

		//Voice mail dismissal

		Thread.sleep(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(VoiceMail));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Voice mail");
		By deleteicon = By.xpath("(//*[@class='voice-call-green-button-small fa fa-trash'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(deleteicon));
		MoveToElementClick(element);
		ExtentSuccessMessage("Deleted the voice mail");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(confirmation));
		element = wait.until(ExpectedConditions.presenceOfElementLocated(clickYes));
		MoveToElementClick(element);
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(succesmessage));
		ExtentSuccessMessage("Validated the success messageof voice mail");

		//call recordings dismissal
		Thread.sleep(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CallRecordings));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on CallRecordings");
		waitForElement(2000);
		By Trashicon = By.xpath("//li[1]//button[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Trashicon));
		MoveToElementClick(element);
		ExtentSuccessMessage("Deleted the callRecordings");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(confirmation));
		element = wait.until(ExpectedConditions.presenceOfElementLocated(clickYes));
		MoveToElementClick(element);
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(succesmessage));
		ExtentSuccessMessage("Validated the success messageof Call Recordings");

	}


	public void validate_Outbound_SMS() throws InterruptedException
	{
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SMSIcon));
		MoveToElementClick(element);
		ExtentSuccessMessage("SMS icon has been clicked");
		WebElement SenderNumber = driver.findElement(By.xpath("//*[@title='Voice Number']"));
		String NumberOutput=SenderNumber.getText();
		System.out.println(NumberOutput);
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NEWMessage));
		MoveToElementClick(element);
		ExtentSuccessMessage("New Message Button has been clicked");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(InputNumber));
		MoveToElementClick(element);
		driver.switchTo().window(tabs.get(1));
		WebElement ReceiveNumber = driver.findElement(By.xpath("//*[@title='Voice Number']"));
		String Number=ReceiveNumber.getText();
		driver.switchTo().window(tabs.get(0));
		writeText(InputNumber,Number );
		ExtentSuccessMessage("Sender Number has been Entered");
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MessageTextArea));
		MoveToElementClick(element);
		String Text = "Hello, These is Automated Text!!!";
		writeText(MessageTextArea,Text );
		ExtentSuccessMessage("Message has been Entered");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SendButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Send Button has been Clicked");
		Thread.sleep(3000);	
		driver.switchTo().window(tabs.get(1));
		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QASMSSection));
		MoveToElementClick(element);
		ExtentSuccessMessage("SMS section has been opened ");
		wait.until(ExpectedConditions.elementToBeClickable(MessageReceived));
		click(MessageReceived);
		Thread.sleep(2000);	

	}
	public void Create_Sms() throws InterruptedException
	{
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SMSIcon));
		MoveToElementClick(element);
		ExtentSuccessMessage("SMS icon has been clicked");
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NEWMessage));
		MoveToElementClick(element);
		ExtentSuccessMessage("New Message Button has been clicked");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(InputNumber));
		MoveToElementClick(element);
	}

	public void new_Tab() throws InterruptedException
	{

		Thread.sleep(3000);
		driver.switchTo().newWindow(WindowType.TAB);
		Thread.sleep(3000);
		ExtentSuccessMessage("New Tab has been Opened");



	}
	public void yopmail_validation(String mail) throws InterruptedException
	{
		new_Tab();
		waitForElement(3000);

		driver.get("https://yopmail.com/wm");
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(YopmailInbox));
		MoveToElementClick(element);
		String CEuseroneMail = mail;
		writeText(YopmailInbox, CEuseroneMail);
		ExtentSuccessMessage("Navigated to mailbox");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(YopmailSubmit));
		MoveToElementClick(element);
		ExtentSuccessMessage("Navigated to inbox of agent email");
		waitForElement(15000);

		driver.switchTo().frame("ifmail");
		waitForElement(1000);
		By NewSmsTitle = By.xpath("//div[@class='ellipsis nw b f18']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NewSmsTitle));
		String expectedProduct =element.getText();
		System.out.println(expectedProduct);
		Assert.assertTrue(expectedProduct.contains("New SMS From"));
		ExtentSuccessMessage("Assertion for new sms mail has been done");
		By Phonedetails = By.xpath("(//div[@class='ellipsis nw b f18'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Phonedetails));
	}
	public void Email_Notification_On_Sms() throws InterruptedException, IOException
	{

		String currentSystemURL = driver.getCurrentUrl();
		if (currentSystemURL.contains("https://mme.brokerengage.net/mme/#/home"))
		{

			Create_Sms();
			waitForElement(4000);
			By voicenumber = By.xpath("//u[@title='Voice Number']");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(voicenumber));
			String ppenvnumber = element.getText();
			System.out.println(ppenvnumber);
			if(ppenvnumber=="(334) 810-0846")
			{
				String Number = "(938) 300-3794";//aws user2
				writeText(InputNumber,Number);
				element = wait.until(ExpectedConditions.presenceOfElementLocated(Messageplaceholder));
				MoveToElementClick(element);
				String TestSms = "This is  an automated test sms";
				writeText(Messageplaceholder,TestSms);
				waitForElement(6000);
				element = wait.until(ExpectedConditions.presenceOfElementLocated(SendSmsButton));
				MoveToElementClick(element);
				ExtentSuccessMessage("Message has been sent");
				waitForElement(1000);
				element = wait.until(ExpectedConditions.presenceOfElementLocated(succesmessage));
				ExtentSuccessMessage("Validated the success message");

				//yopmail validation
				yopmail_validation("awsuser@yopmail.com");
				String expecteddetails =element.getText();
				System.out.println(expecteddetails);
				Assert.assertTrue(expecteddetails.contains("New SMS From: (334) 810-0846 To: (938) 300-3794 on yourCustomerEngage Dialer"));
				TabSwitchToParent();

			}
			else
			{

				String Number = "(334) 810-0846";
				writeText(InputNumber,Number);
				element = wait.until(ExpectedConditions.presenceOfElementLocated(Messageplaceholder));
				MoveToElementClick(element);
				String TestSms = "This is  an automated test sms";
				writeText(Messageplaceholder,TestSms);
				waitForElement(6000);
				element = wait.until(ExpectedConditions.presenceOfElementLocated(SendSmsButton));
				MoveToElementClick(element);
				ExtentSuccessMessage("Message has been sent");
				waitForElement(1000);
				element = wait.until(ExpectedConditions.presenceOfElementLocated(succesmessage));
				ExtentSuccessMessage("Validated the success message");

				//yopmail validation
				yopmail_validation("awsuser1@yopmail.com");
				String expecteddetails =element.getText();
				System.out.println(expecteddetails);
				Assert.assertTrue(expecteddetails.contains("New SMS From"));
				TabSwitchToParent();

			}


		}

		else if (currentSystemURL.contains("https://ce-qa.benefitalign.com/")) {

			Create_Sms();
			waitForElement(4000);
			// By voicenumber = By.xpath("//u[@title='Voice Number']");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(voicenumber));
			String qaenvnumber = element.getText();
			System.out.println(qaenvnumber);
			if(qaenvnumber=="(386) 703-3867")
			{
				String Number = "(479) 333-1769"; //Qualitia test1
				writeText(InputNumber,Number);
				element = wait.until(ExpectedConditions.presenceOfElementLocated(Messageplaceholder));
				MoveToElementClick(element);
				String TestSms = "This is  an automated test sms";
				writeText(Messageplaceholder,TestSms);

				waitForElement(6000);
				element = wait.until(ExpectedConditions.presenceOfElementLocated(SendSmsButton));
				MoveToElementClick(element);
				ExtentSuccessMessage("Message has been sent");
				waitForElement(1000);
				element = wait.until(ExpectedConditions.presenceOfElementLocated(succesmessage));
				ExtentSuccessMessage("Validated the success message");

				//yopmail validation


				yopmail_validation("qualitia@yopmail.com");
				String expecteddetails =element.getText();
				System.out.println(expecteddetails);
				Assert.assertTrue(expecteddetails.contains("New SMS From:"));

				TabSwitchToParent();

			}
			else
			{

				String Number = "(386) 703-3867";
				writeText(InputNumber,Number);
				element = wait.until(ExpectedConditions.presenceOfElementLocated(Messageplaceholder));
				MoveToElementClick(element);
				String TestSms = "This is  an automated test sms";
				writeText(Messageplaceholder,TestSms);

				waitForElement(6000);
				element = wait.until(ExpectedConditions.presenceOfElementLocated(SendSmsButton));
				MoveToElementClick(element);
				ExtentSuccessMessage("Message has been sent");
				waitForElement(1000);
				element = wait.until(ExpectedConditions.presenceOfElementLocated(succesmessage));
				ExtentSuccessMessage("Validated the success message");

				//yopmail validation

				yopmail_validation("qualitia2@yopmail.com");
				String expecteddetails =element.getText();
				System.out.println(expecteddetails);
				Assert.assertTrue(expecteddetails.contains("New SMS From:"));

				TabSwitchToParent();

			}

		}

		else {

			System.out.println("DEV ENV");

		}

		Thread.sleep(3000);


	}

	public void validate_Outbound_SMS_SENT() throws InterruptedException
	{
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SMSIcon));
		MoveToElementClick(element);
		ExtentSuccessMessage("SMS icon has been clicked");
		WebElement SenderNumber = driver.findElement(By.xpath("//*[@title='Voice Number']"));
		String NumberOutput=SenderNumber.getText();
		System.out.println(NumberOutput);
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NEWMessage));
		MoveToElementClick(element);
		ExtentSuccessMessage("New Message Button has been clicked");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(InputNumber));
		MoveToElementClick(element);
		driver.switchTo().window(tabs.get(1));
		WebElement ReceiveNumber = driver.findElement(By.xpath("//*[@title='Voice Number']"));
		String Number=ReceiveNumber.getText();
		driver.switchTo().window(tabs.get(0));
		writeText(InputNumber,Number );
		ExtentSuccessMessage("Sender Number has been Entered");
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MessageTextArea));
		MoveToElementClick(element);
		String Text = "Hello, These is Automated Text!!!";
		writeText(MessageTextArea,Text );
		ExtentSuccessMessage("Message has been Entered");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SendButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Send Button has been Clicked");
		Thread.sleep(5000);	
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Messagecontent));
		MoveToElementClick(element);
		Thread.sleep(5000);	
		List<WebElement> links = driver.findElements(By.xpath("//*[@class='ng-scope outbound']"));
		System.out.println(links.size());
		if(links!=null) {
			for(int i=0; i< links.size(); i++)
			{
				ExtentSuccessMessage(links.get(i).getText());
			}
		}
	}

	public void validate_Receive_Inbound_SMS() throws InterruptedException
	{
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SMSIcon));
		MoveToElementClick(element);
		ExtentSuccessMessage("SMS icon has been clicked");
		WebElement SenderNumber = driver.findElement(By.xpath("//*[@title='Voice Number']"));
		String NumberOutput=SenderNumber.getText();
		System.out.println(NumberOutput);
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NEWMessage));
		MoveToElementClick(element);
		ExtentSuccessMessage("New Message Button has been clicked");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(InputNumber));
		MoveToElementClick(element);
		driver.switchTo().window(tabs.get(1));
		WebElement ReceiveNumber = driver.findElement(By.xpath("//*[@title='Voice Number']"));
		String Number=ReceiveNumber.getText();
		driver.switchTo().window(tabs.get(0));
		writeText(InputNumber,Number );
		ExtentSuccessMessage("Sender Number has been Entered");
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MessageTextArea));
		MoveToElementClick(element);
		String Text = "Hello, These is Automated Text!!!";
		writeText(MessageTextArea,Text );
		ExtentSuccessMessage("Message has been Entered");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SendButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Send Button has been Clicked");
		Thread.sleep(5000);	
		driver.switchTo().window(tabs.get(1));
		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QASMSSection));
		MoveToElementClick(element);
		ExtentSuccessMessage("SMS section has been opened ");
		wait.until(ExpectedConditions.elementToBeClickable(MessageReceived));
		click(MessageReceived);
		Thread.sleep(2000);	
	}


	public void validate_Outbound_SMS_Missed_Call_Call_Logs() throws InterruptedException
	{
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Call_Logs));
		MoveToElementClick(element);
		ExtentSuccessMessage("Call Logs icon has been clicked");
		driver.switchTo().window(tabs.get(1));
		WebElement ReceiveNumber = driver.findElement(By.xpath("//*[@title='Voice Number']"));
		String Number=ReceiveNumber.getText();
		driver.switchTo().window(tabs.get(0));
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Input_Num));
		MoveToElementClick(element);
		writeText(Input_Num,Number + Keys.ENTER);
		waitForElement(2000);
		if(ElementDisplayed(Send_Message_Logs)) {
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Send_Message_Logs));
			MoveToElementClick(element);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(MessageTextArea));
			MoveToElementClick(element);
			String Text = "Hello, These is Automated Text!!!";
			writeText(MessageTextArea,Text );
			ExtentSuccessMessage("Message has been Entered");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(SendButton));
			MoveToElementClick(element);
			ExtentSuccessMessage("Send Button has been Clicked");
			waitForElement(2000);
			driver.switchTo().window(tabs.get(1));
			waitForElement(2000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(QASMSSection));
			MoveToElementClick(element);
			ExtentSuccessMessage("SMS section has been opened ");
			wait.until(ExpectedConditions.elementToBeClickable(MessageReceived));
			click(MessageReceived);
			waitForElement(2000);
		}else {
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Dialpad));
			MoveToElementClick(element);	
			waitForElement(2000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(EnterPhoneNumberField));
			MoveToElementClick(element);	
			writeText(EnterPhoneNumberField,Number );
			ExtentSuccessMessage("Invalid Phone Number has been entered");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CallButton));
			MoveToElementClick(element);//clicking on Call Button
			ExtentSuccessMessage("clicked on Call Button");
			waitForElement(28000);
			driver.switchTo().window(tabs.get(1));
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Missedcalls));
			MoveToElementClick(element);//clicking on Missed Call Button
			ExtentSuccessMessage("clicked on Missed Call Button");
			waitForElement(2000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Send_Message_call));
			MoveToElementClick(element);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(MessageTextArea));
			MoveToElementClick(element);
			String Text = "Hello, These is Automated Text!!!";
			writeText(MessageTextArea,Text );
			ExtentSuccessMessage("Message has been Entered");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(SendButton));
			MoveToElementClick(element);
			ExtentSuccessMessage("Send Button has been Clicked");
			waitForElement(2000);
			driver.switchTo().window(tabs.get(0));
			waitForElement(2000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(QASMSSection));
			MoveToElementClick(element);
			ExtentSuccessMessage("SMS section has been opened ");
			wait.until(ExpectedConditions.elementToBeClickable(MessageReceived));
			click(MessageReceived);
			waitForElement(2000);
		}
	}

	public void TabSwitchToParent() throws InterruptedException
	{
		Thread.sleep(2000);
		ArrayList<String> Tabs = new ArrayList<>(driver.getWindowHandles());
		System.out.println(Tabs.size());
		driver.switchTo().window(Tabs.get(0));
		ExtentSuccessMessage("Tab Switched from child to parent");

		Thread.sleep(5000);
	}

}
