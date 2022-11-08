package test;

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
import pom.SwabLabsCheckoutYourInformation;
import pom.SwabLabsHomePage;
import pom.SwabLabsLoginPage;
import utility.BaseClass;
import utility.Reports;

@Listeners(utility.Listeners.class)
public class SwabLabsCartTest extends BaseClass implements ITestListener{
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
		public void verifyFunctinalityOfContinueShippingOnCartPage() 
	{
		test =report.createTest("SwabLabsCartTest");
		SwabLabsLoginPage swabLabsLoginPage = new SwabLabsLoginPage(driver);
		swabLabsLoginPage.EnterUserName("standard_user");
		swabLabsLoginPage.EnterPassword("secret_sauce");
		swabLabsLoginPage.ClickOnLogin();
			
		SwabLabsHomePage swabLabsHomePage = new SwabLabsHomePage(driver);
		swabLabsHomePage.clickOnCartLogo();
			
		SwabLabsCart swabLabsCart = new SwabLabsCart(driver);
		swabLabsCart.clickOnContinueShipping();
			
		Assert.assertTrue(swabLabsHomePage.isProductPageIsDisplayed());
	}
	@Test
		public void verifyFunctionalityOfRemovebuttonOnCartPage() throws InterruptedException 
	{
		SwabLabsLoginPage swabLabsLoginPage = new SwabLabsLoginPage(driver);
		swabLabsLoginPage.EnterUserName("standard_user");
		swabLabsLoginPage.EnterPassword("secret_sauce");
		swabLabsLoginPage.ClickOnLogin();
		
		Thread.sleep(1000);
		SwabLabsHomePage swabLabsHomePage = new SwabLabsHomePage(driver);
		swabLabsHomePage.clickOnAddToCart(0);
		swabLabsHomePage.clickOnCartLogo();
		Thread.sleep(1000);
		
		SwabLabsCart swabLabsCart = new SwabLabsCart(driver);
		swabLabsCart.clickOnRemove();
		
		Assert.assertFalse(swabLabsCart.isRemoveButtonDisplayed());
	}
	@Test
		public void verifyFunctionalityOfCheckOutButton() 
	{

		SwabLabsLoginPage swabLabsLoginPage = new SwabLabsLoginPage(driver);
		swabLabsLoginPage.EnterUserName("standard_user");
		swabLabsLoginPage.EnterPassword("secret_sauce");
		swabLabsLoginPage.ClickOnLogin();
		
		SwabLabsHomePage swabLabsHomePage = new SwabLabsHomePage(driver);
		swabLabsHomePage.clickOnAddToCart(0);
		swabLabsHomePage.clickOnCartLogo();
		
		SwabLabsCart swabLabsCart = new SwabLabsCart(driver);
		swabLabsCart.clickOnCheckout();
		
		SwabLabsCheckoutYourInformation swabLabsCheckoutYourInformation = new SwabLabsCheckoutYourInformation(driver);
		Assert.assertTrue(swabLabsCheckoutYourInformation.isCheckoutYourInformationPageDisplayed());
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
	public void publishResult() {
		report.flush();
	}
}
