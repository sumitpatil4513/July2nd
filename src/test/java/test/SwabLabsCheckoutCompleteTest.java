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
import pom.SwabLabsCheckoutComplete;
import pom.SwabLabsCheckoutOverview;
import pom.SwabLabsCheckoutYourInformation;
import pom.SwabLabsHomePage;
import pom.SwabLabsLoginPage;
import utility.BaseClass;
import utility.Parametrization;
import utility.Reports;

@Listeners(utility.Listeners.class)
public class SwabLabsCheckoutCompleteTest extends BaseClass implements ITestListener{
	ExtentReports report;
	ExtentTest test;
	@BeforeTest
	public void configureReport() 
	{
		report = Reports.createReport();
	}
	@BeforeMethod
	public void launchChromre() {
		driver = Browser.openBrowser();
	}
	@Test
	public void verifyBackHomeButton() throws EncryptedDocumentException, IOException 
	{
		report.createTest("SwabLabsCheckoutCompleteTest");
		SwabLabsLoginPage swabLabsLoginPage = new SwabLabsLoginPage(driver);
		swabLabsLoginPage.EnterUserName(Parametrization.getDate("credentials", 1, 0));
		swabLabsLoginPage.EnterPassword(Parametrization.getDate("credentials", 1, 1));
		swabLabsLoginPage.ClickOnLogin();
		
		SwabLabsHomePage swabLabsHomePage = new SwabLabsHomePage(driver);
		swabLabsHomePage.clickOnAddToCart(0);
		swabLabsHomePage.clickOnCartLogo();
		
		SwabLabsCart swabLabsCart = new SwabLabsCart(driver);
		swabLabsCart.clickOnCheckout();
		
		SwabLabsCheckoutYourInformation swabLabsCheckoutYourInformation = new SwabLabsCheckoutYourInformation(driver);
		swabLabsCheckoutYourInformation.enterFirstName(Parametrization.getDate("YourInfo", 1, 0));
		swabLabsCheckoutYourInformation.enterLastName(Parametrization.getDate("YourInfo", 1, 1));
		swabLabsCheckoutYourInformation.enterZipCode(Parametrization.getDate("YourInfo", 1, 2));
		swabLabsCheckoutYourInformation.clickOnContinue();
		
		SwabLabsCheckoutOverview swabLabsCheckoutOverview = new SwabLabsCheckoutOverview(driver);
		swabLabsCheckoutOverview.clickOnFinish();
		
		SwabLabsCheckoutComplete swabLabsCheckoutComplete = new SwabLabsCheckoutComplete(driver);
		swabLabsCheckoutComplete.clickOnBackHome();
		
		Assert.assertTrue(swabLabsHomePage.isProductPageIsDisplayed());
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
