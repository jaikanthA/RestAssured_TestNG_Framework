package com.employeeapi.utilities;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listeners extends TestListenerAdapter {
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	public void onStart(ITestContext testContext)
	{
		htmlReporter = new ExtentHtmlReporter("F:/RestAssured/RestAssured Workspace/RestAssuredAutomationFramework/Reports/myReport.html");

		  htmlReporter.config().setDocumentTitle("Automation Report"); // Tile of report
		  htmlReporter.config().setReportName("Rest API Testing Report"); // Name of the report
		  htmlReporter.config().setTheme(Theme.DARK);
		  
		  extent = new ExtentReports();
		  extent.attachReporter(htmlReporter);
		  
		  // Passing General information
		  extent.setSystemInfo("Host name", "localhost");
		  extent.setSystemInfo("Environemnt", "QA");
		  extent.setSystemInfo("user", "Jaikanth");
	}
	
	public void onTestSuccess(ITestResult result)
	{
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "Test case PASSED is "+result.getName());
		
	}
	
	public void onTestFailure(ITestResult result)
	{
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test case FAILED is "+result.getName());
		test.log(Status.FAIL, "Test case FAILED is "+result.getThrowable());
		
	}
	public void onTestSkipped(ITestResult result)
	{
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test case SKIPPED is "+result.getName());
	}
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}
}
