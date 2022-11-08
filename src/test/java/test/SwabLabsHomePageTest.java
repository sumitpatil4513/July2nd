package test;

import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
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
import pom.SwabLabsHomePage;
import pom.SwabLabsLoginPage;
import pom.SwabLabsToFaceBook;
import pom.SwabLabsToLinkedIn;
import pom.SwabLabsToTwitterPage;
import utility.BaseClass;
import utility.Parametrization;
import utility.Reports;

@Listeners(utility.Listeners.class)

public class SwabLabsHomePageTest extends BaseClass 
{
	ExtentReports reports;
	ExtentTest test;
	@BeforeTest
	public void configureReport() 
	{
		reports = Reports.createReport();
	}
	
	@BeforeMethod
	public void lunchChrome() 
	{
		driver =Browser.openBrowser();
	}
	@Test
		public void verifyAddToCartButton() throws EncryptedDocumentException, IOException 
	{
			test = reports.createTest("verifyAddToCartButton");
			SwabLabsLoginPage swabLabsLoginPage = new SwabLabsLoginPage(driver);
			swabLabsLoginPage.EnterUserName(Parametrization.getDate("credentials", 1, 0));
			swabLabsLoginPage.EnterPassword(Parametrization.getDate("credentials", 1, 1));
			swabLabsLoginPage.ClickOnLogin();
			
			SwabLabsHomePage swabLabsHomePage = new SwabLabsHomePage(driver);
			swabLabsHomePage.clickOnAddToCart(0);
			
			Assert.assertTrue(swabLabsHomePage.isRemovedButtonDisplayed(0));
	}
	@Test
		public void verifyAddingMultipleProductsToCart() throws EncryptedDocumentException, IOException 
	{
		SwabLabsLoginPage swabLabsLoginPage = new SwabLabsLoginPage(driver);
		swabLabsLoginPage.EnterUserName(Parametrization.getDate("credentials", 1, 0));
		swabLabsLoginPage.EnterPassword(Parametrization.getDate("credentials", 1, 1));
		swabLabsLoginPage.ClickOnLogin();
		
		SwabLabsHomePage swabLabsHomePage = new SwabLabsHomePage(driver);
		int addToCart=swabLabsHomePage.getNumberOfAddToCartButton();
		swabLabsHomePage.addMultipaleProductsToCart(addToCart);
		
		Assert.assertEquals(swabLabsHomePage.getNumberOfRemoveButton(), addToCart);
	}
	@Test
		public void verifyToRemoveProductFromCartFromHomePage() throws EncryptedDocumentException, IOException 
	{
		SwabLabsLoginPage swabLabsLoginPage = new SwabLabsLoginPage(driver);
		swabLabsLoginPage.EnterUserName(Parametrization.getDate("credentials", 1, 0));
		swabLabsLoginPage.EnterPassword(Parametrization.getDate("credentials", 1, 1));
		swabLabsLoginPage.ClickOnLogin();
		
		SwabLabsHomePage swabLabsHomePage = new SwabLabsHomePage(driver);
		swabLabsHomePage.clickOnAddToCart(0);
		swabLabsHomePage.clickOnRemove(0);
		Assert.assertTrue(swabLabsHomePage.isAddToCartButtonDisplayed(0));
	}
	@Test
		public void verifyToRemoveMultipleProductsInCartFromHomePage() throws EncryptedDocumentException, IOException, InterruptedException 
	{
		SwabLabsLoginPage swabLabsLoginPage = new SwabLabsLoginPage(driver);
		swabLabsLoginPage.EnterUserName(Parametrization.getDate("credentials", 1, 0));
		swabLabsLoginPage.EnterPassword(Parametrization.getDate("credentials", 1, 1));
		swabLabsLoginPage.ClickOnLogin();
		
		SwabLabsHomePage swabLabsHomePage = new SwabLabsHomePage(driver);
		int addToCart = swabLabsHomePage.getNumberOfAddToCartButton();
		swabLabsHomePage.addMultipaleProductsToCart(addToCart);
		
		Thread.sleep(1000);
		
		int remove = swabLabsHomePage.getNumberOfRemoveButton();
		swabLabsHomePage.removeMultipleProductsFromCart(remove);
		
		Assert.assertEquals(swabLabsHomePage.getNumberOfAddToCartButton(), remove);
		
	}
	@Test
		public void verifyProductIsDisplayedUnderCart() throws EncryptedDocumentException, IOException 
	{
		SwabLabsLoginPage swabLabsLoginPage = new SwabLabsLoginPage(driver);
		swabLabsLoginPage.EnterUserName(Parametrization.getDate("credentials", 1, 0));
		swabLabsLoginPage.EnterPassword(Parametrization.getDate("credentials", 1, 1));
		swabLabsLoginPage.ClickOnLogin();
		
		SwabLabsHomePage swabLabsHomePage = new SwabLabsHomePage(driver);
		swabLabsHomePage.selectProduct();
		swabLabsHomePage.addProductToCart();
		swabLabsHomePage.clickOnCartLogo();
		
		SwabLabsCart swabLabsCart = new SwabLabsCart(driver);
		swabLabsCart.isProductDisplayedUnderCart();
		
		Assert.assertTrue(swabLabsCart.isProductDisplayedUnderCart());
		
	}
	@Test
		public void verifyListOfOptionsDisplayedUnderOption() throws EncryptedDocumentException, IOException 
	{
		SwabLabsLoginPage swabLabsLoginPage = new SwabLabsLoginPage(driver);
		swabLabsLoginPage.EnterUserName(Parametrization.getDate("credentials", 1, 0));
		swabLabsLoginPage.EnterPassword(Parametrization.getDate("credentials", 1, 1));
		swabLabsLoginPage.ClickOnLogin();
		
		SwabLabsHomePage swabLabsHomePage = new SwabLabsHomePage(driver);
		swabLabsHomePage.clickOnOptions();
		Assert.assertTrue(swabLabsHomePage.isListOfOptionDisplayed());
	}
	@Test
		public void verifyFunctinalityOfFilters() throws EncryptedDocumentException, IOException 
	{
		SwabLabsLoginPage swabLabsLoginPage = new SwabLabsLoginPage(driver);
		swabLabsLoginPage.EnterUserName(Parametrization.getDate("credentials", 1, 0));
		swabLabsLoginPage.EnterPassword(Parametrization.getDate("credentials", 1, 1));
		swabLabsLoginPage.ClickOnLogin();
		
		SwabLabsHomePage swabLabsHomePage = new SwabLabsHomePage(driver);
		swabLabsHomePage.selectFilter1By1();
		Assert.assertTrue(swabLabsHomePage.isHighToLowPriceInventoryListDisplayed());
	}
	@Test
		public void verifyTwitterIsOpening() throws EncryptedDocumentException, IOException {
		SwabLabsLoginPage swabLabsLoginPage = new SwabLabsLoginPage(driver);
		swabLabsLoginPage.EnterUserName(Parametrization.getDate("credentials", 1, 0));
		swabLabsLoginPage.EnterPassword(Parametrization.getDate("credentials", 1, 1));
		swabLabsLoginPage.ClickOnLogin();
		
		SwabLabsHomePage swabLabsHomePage = new SwabLabsHomePage(driver);
		swabLabsHomePage.openTwitterPage();
		
		SwabLabsToTwitterPage swabLabsToTwitterPage = new SwabLabsToTwitterPage(driver);
		
		Assert.assertTrue(swabLabsToTwitterPage.isTwitterPageDisplayed(driver, true));
	}
	@Test
		public void verifyFacebookIsOpening() throws EncryptedDocumentException, IOException {
		SwabLabsLoginPage swabLabsLoginPage = new SwabLabsLoginPage(driver);
		swabLabsLoginPage.EnterUserName(Parametrization.getDate("credentials", 1, 0));
		swabLabsLoginPage.EnterPassword(Parametrization.getDate("credentials", 1, 1));
		swabLabsLoginPage.ClickOnLogin();
		
		SwabLabsHomePage swabLabsHomePage = new SwabLabsHomePage(driver);
		swabLabsHomePage.openFacebookPage();
		
		SwabLabsToFaceBook swabLabsToFaceBook = new SwabLabsToFaceBook(driver);
		
		Assert.assertTrue(swabLabsToFaceBook.isFacebookPageIsDisplayed(driver, true));
	}
	@Test
		public void verifyLinkedInIsOpening() throws EncryptedDocumentException, IOException {
		SwabLabsLoginPage swabLabsLoginPage = new SwabLabsLoginPage(driver);
		swabLabsLoginPage.EnterUserName(Parametrization.getDate("credentials", 1, 0));
		swabLabsLoginPage.EnterPassword(Parametrization.getDate("credentials", 1, 1));
		swabLabsLoginPage.ClickOnLogin();
		
		SwabLabsHomePage swabLabsHomePage = new SwabLabsHomePage(driver);
		swabLabsHomePage.openLinkedInPage();;
		
		SwabLabsToLinkedIn swabToLinkedIn = new SwabLabsToLinkedIn(driver);
		
		Assert.assertTrue(swabToLinkedIn.isLinkedInLoginPageDisplayed(driver, true));
	}
	@AfterMethod
	public void getTestResults(ITestResult result) 
	{
		if(result.getStatus()== ITestResult.SUCCESS)
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
	public void publishResult() 
	{
		reports.flush();
	}

}
