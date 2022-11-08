package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {
	public static ExtentReports createReport() {
		ExtentSparkReporter html = new ExtentSparkReporter("extentreport.html");
		ExtentReports report = new ExtentReports();
		report.attachReporter(html);
		report.setSystemInfo("Created By", "Sumit Patil");
		report.setSystemInfo("Type", "Functional Testing");
		return report;
	}

}
