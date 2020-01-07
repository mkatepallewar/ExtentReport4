package extentReports;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentManager {
	
	static ExtentReports extent;
	static Date d=new Date();
	static String fileName="Extent_"+d.toString().replace(":", "_").replace(" ", "_")+".html";
	public static ExtentReports createInstance(String fileName) {
		if (extent==null) {
			ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter(fileName);
			htmlReporter.config().setTheme(Theme.STANDARD);
			htmlReporter.config().setDocumentTitle(fileName);
			htmlReporter.config().setEncoding("utf-8");
			htmlReporter.config().setReportName(fileName);
			
			extent=new ExtentReports();
			extent.attachReporter(htmlReporter);
			extent.setSystemInfo("Automation Tester", "MK");
			extent.setSystemInfo("Organisation","ESS");
			extent.setSystemInfo("Build No","100");
		}
		return extent;
	}
	
	/*
	 * static int i=0; static String screenshotName ;
	 * 
	 * public static void captureScreenShot() { i=i+1; File
	 * scrFile=((TakesScreenshot)BaseSteps.getDriver()).getScreenshotAs(OutputType.
	 * FILE);
	 * 
	 * Date d=new Date(); screenshotName = d.toString().replace(":",
	 * "_").replace(" ", "_")+"_"+i+".jpg";
	 * 
	 * try { FileUtils.copyFile(scrFile, new
	 * File(System.getProperty("user.dir")+"reports/"+screenshotName)); } catch
	 * (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }
	 * 
	 * 
	 * }
	 */
	

}
