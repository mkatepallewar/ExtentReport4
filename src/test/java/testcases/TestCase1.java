package testcases;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;


import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class TestCase1 {
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	@BeforeTest
	public void setReport() {
		htmlReporter =new ExtentHtmlReporter("./reports/extent.html");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("W2A Automation Reports");
		htmlReporter.config().setReportName("Automation Test Results");
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("Automation Tester", "Manish K");
		extent.setSystemInfo("Organisation", "ESS");
		extent.setSystemInfo("Build No", "W2A1234");
		
		
	}
	
	@AfterTest
	public void endReport() {
		extent.flush();
	}
	
	/*
	 * 
	 * Pass, fail, skip
	 * 
	 */
	@Test
	public void doLogin() {
		test=extent.createTest("Login Test");
		System.out.println("Executing Logging Test");
	}
	
	@Test
	public void doUserReg() {
		test=extent.createTest("User Reg Test");
		System.out.println("Executing User Reg Test");
		
		Assert.fail("User Registration test failed");
		
	}
	
	@Test
	public void isSkip() {
		test=extent.createTest("Skip Test");
		System.out.println("Skippin  Test");
		
		throw new SkipException("Skipping the test cases");
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		if(result.getStatus()== ITestResult.FAILURE) {
			
			String exceptionMessage=Arrays.toString(result.getThrowable().getStackTrace());
			test.fail("<details>"+"<summary>"+"<b>"+"<font color=" +"red>"+ "Exception Occured: Click to see"
						+ "</font>"+"</b>"+"</summary>"+exceptionMessage.replaceAll(",", "<br>") +"</details>"
						+ "\n");
			
			/*
			 * try {
			 * 
			 * ExtentManager.captureScreenshot(); testReport.get().fail("<b>" +
			 * "<font color=" + "red>" + "Screenshot of failure" + "</font>" + "</b>",
			 * MediaEntityBuilder.createScreenCaptureFromPath(ExtentManager.screenshotName)
			 * .build()); } catch (IOException e) {
			 * 
			 * }
			 */
			
			String failureLogg= "TEST CASE FAILED";		
			Markup m=MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
			test.log(Status.FAIL, m);
			
		}else if(result.getStatus()== ITestResult.SKIP) {
			String methodName= result.getMethod().getMethodName();
			
			String logText="<b>"+"Test Case: - "+methodName.toUpperCase()+"  SKIPPED"+"</b>";
			
			Markup m=MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
			test.skip(m);
		}else if(result.getStatus()== ITestResult.SUCCESS) {
			String methodName= result.getMethod().getMethodName();
			
			String logText="<b>"+"Test Case: - "+methodName.toUpperCase()+"  PASSED"+"</b>";
			
			Markup m=MarkupHelper.createLabel(logText, ExtentColor.GREEN);
			test.pass(m);
		}
	}
	
//	 public static String screenshotPath;
//	 public static String screenshotName;
//		
//	public static void captureScreenshot() {
//
//		File scrFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
//		Date d = new Date();
//		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
//		try {
//			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "\\reports\\" + screenshotName));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	
//	}

}
