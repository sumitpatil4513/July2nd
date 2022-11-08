package utility;


import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
public class Listeners extends BaseClass implements ITestListener{
	
	public void onTestStart(ITestResult result)
	{
		System.out.println("Test is started" + result.getName());
	}
	public void onTestFailure(ITestResult result)
	{
		//System.out.println("Test is fail "+result.getName());
		try {
			ScreenShot.takeScreenshot1(result.getName(), driver);
		} catch (IOException e) {
		   e.printStackTrace();
		}
	}
	public void onTestSkipped(ITestResult result) 
	{
		System.out.println("Test is skipped "+result.getName());
	}
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("Test is passed "+result.getName());
	}
}
