package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.Browser;
import pom.SwabLabsCart;
import pom.SwabLabsCheckoutOverview;
import pom.SwabLabsCheckoutYourInformation;
import pom.SwabLabsHomePage;
import pom.SwabLabsLoginPage;
import utility.BaseClass;
import utility.Parametrization;
import utility.Reports;

@Listeners(utility.Listeners.class)
public class SwabLabsCheckoutYourInformationTest extends BaseClass implements ITestListener{
	ExtentReports report;
	ExtentTest test;
	@BeforeTest
	public void configureReport() {
		report = Reports.createReport();
	}
	@BeforeMethod
	public void launchChrome() {
		driver = Browser.openBrowser();
	}
	@Test
		public void checkTabValidationAndContinueButton() throws EncryptedDocumentException, IOException 
	{
		test = report.createTest("SwabLabsCheckoutYourInformationTest");
		
		SwabLabsLoginPage swabLoginPage = new SwabLabsLoginPage(driver);
		swabLoginPage.EnterUserName(Parametrization.getDate("credentials", 1, 0));
		swabLoginPage.EnterPassword(Parametrization.getDate("credentials", 1, 1));
		swabLoginPage.ClickOnLogin();
		
		SwabLabsHomePage swabHomePage = new SwabLabsHomePage(driver);
		swabHomePage.clickOnAddToCart(0);
		swabHomePage.clickOnCartLogo();
		
		SwabLabsCart swabLabsCart = new SwabLabsCart(driver);
		swabLabsCart.clickOnCheckout();
		
		SwabLabsCheckoutYourInformation swabLabsCheckoutYourInformation = new SwabLabsCheckoutYourInformation(driver);
		swabLabsCheckoutYourInformation.enterFirstName(Parametrization.getDate("YourInfo", 1, 0));
		swabLabsCheckoutYourInformation.enterLastName(Parametrization.getDate("YourInfo", 1, 1));
		swabLabsCheckoutYourInformation.enterZipCode(Parametrization.getDate("YourInfo", 1, 2));
		swabLabsCheckoutYourInformation.clickOnContinue();
		
		SwabLabsCheckoutOverview swabLabsCheckoutOverview = new SwabLabsCheckoutOverview(driver);
		 Assert.assertTrue(swabLabsCheckoutOverview.isOverviewDisplayed());
	}
	@Test
		public void verifyWorkingOfCancleButton() throws EncryptedDocumentException, IOException, InterruptedException 
	{
		SwabLabsLoginPage swabLoginPage = new SwabLabsLoginPage(driver);
		swabLoginPage.EnterUserName(Parametrization.getDate("credentials", 1, 0));
		swabLoginPage.EnterPassword(Parametrization.getDate("credentials", 1, 1));
		swabLoginPage.ClickOnLogin();
		Thread.sleep(1000);
		SwabLabsHomePage swabHomePage = new SwabLabsHomePage(driver);
		swabHomePage.clickOnAddToCart(0);
		swabHomePage.clickOnCartLogo();
		Thread.sleep(1000);
		SwabLabsCart swabLabsCart = new SwabLabsCart(driver);
		swabLabsCart.clickOnCheckout();
		Thread.sleep(1000);
		SwabLabsCheckoutYourInformation swabLabsCheckoutYourInformation = new SwabLabsCheckoutYourInformation(driver);
		swabLabsCheckoutYourInformation.clickOnCancle();
		Assert.assertTrue(swabLabsCart.isCartpageDisplayed());
		 
	}
	@AfterMethod
	public void getTestResult(ITestResult result) 
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, result.getName());
		}
		else if(result.getStatus()==ITestResult.FAILURE) 
		{
			test.log(Status.FAIL, result.getName());
		}
		else
		{
			test.log(Status.SKIP, result.getName());
		}
	}
	@AfterTest 
	public void publishReport()
	{
		report.flush();
	}
	
	
}
