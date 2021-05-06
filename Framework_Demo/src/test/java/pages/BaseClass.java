package pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import utilities.Browser_Factory;
import utilities.ExcelDataProvider;
import utilities.Helper;
import utilities.configDataProvider;
public class BaseClass {
	public WebDriver ldriver;

	public ExcelDataProvider excel;
	
	public configDataProvider config;
	
	public ExtentReports report;
	
	public ExtentTest logger;
	
	@BeforeSuite
	public void setupSuite()
	{		
		 Reporter.log("Setting up reports and Test is getting started", true);
		 excel=new ExcelDataProvider();
		 config=new configDataProvider();
		 ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/Report1_"+Helper.getCurrentDateTime()+".html"));
		 report=new ExtentReports();
		 report.attachReporter(extent);
		 Reporter.log("Setting  done and Test get Started", true);
	}
	@BeforeClass
	public void setup()
		{
		 Reporter.log("Setting up Browsers and app url", true);
		ldriver=Browser_Factory.startApplication(ldriver,config.getBrowser(),config.getStartUpURL());
		 Reporter.log("Setting done and Browser has launched and Application is strat", true);
		}
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException
	{
		 Reporter.log("Test is about to end and creating report internally", true);
		if(result.getStatus()==ITestResult.FAILURE)
		{
			//Helper.CaptureScreenshot(ldriver);
			logger.fail("TestFail",MediaEntityBuilder.createScreenCaptureFromPath(Helper.CaptureScreenshot(ldriver)).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test Pass",MediaEntityBuilder.createScreenCaptureFromPath(Helper.CaptureScreenshot(ldriver)).build());
		}
		report.flush();
		 Reporter.log(" Test Completed >>>Reports Generated", true);
	}
	@AfterClass
	public void tearDown() 
		{
	Browser_Factory.quit_Browser(ldriver);
	 Reporter.log("Browser has closed", true);
		}
}
