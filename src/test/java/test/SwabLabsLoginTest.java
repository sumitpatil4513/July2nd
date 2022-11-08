package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.Browser;
import pom.SwabLabsLoginPage;
import utility.BaseClass;
import utility.Parametrization;
import utility.Reports;
@Listeners(utility.Listeners.class)

public class SwabLabsLoginTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	@BeforeTest
	public void configureReports() {
		reports =Reports.createReport();
	}
	@BeforeMethod
	public void lunchBrowser() {
		driver =Browser.openBrowser();
	}
	@DataProvider(name = "LoginData")
	public Object [][] data() throws EncryptedDocumentException, IOException{
		String pass  = Parametrization.getDate("credentials", 1, 1);
		String user1 = Parametrization.getDate("credentials", 1, 0);
		String user2 = Parametrization.getDate("credentials", 2, 0);
		String user3 = Parametrization.getDate("credentials", 3, 0);
		String user4 = Parametrization.getDate("credentials", 4, 0);
		return new Object [][] {{user1,pass},{user2,pass},{user3,pass},{user4,pass}};
	}
	@Test(dataProvider ="LoginData")
	public void swabLabLoginTestWithValidCredentials(String user, String pass) {
		test = reports.createTest("swabLabLoginTestWithValidCredentials");
		SwabLabsLoginPage swabLabLoginPage = new SwabLabsLoginPage(driver);
		swabLabLoginPage.EnterUserName(user);
		swabLabLoginPage.EnterPassword(pass);
		swabLabLoginPage.ClickOnLogin();
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
	}
	@AfterMethod
	public void getTestResult(ITestResult result) {
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, result.getName());
		}
		else if (result.getStatus()==ITestResult.FAILURE)
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
		reports.flush();
	}
		
	
	
	
	
	
	

}
