package Testcases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import PageObjects.LoginPage;
import Utilities.ReadConfiguration;
import Utilities.XLUtility;

public class BaseClass 
{
	ReadConfiguration readconfig = new ReadConfiguration();		
	XLUtility xlutils=new XLUtility();	
	public static WebDriver driver;
	public String baseurl = readconfig.getAppURL();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();
	public static Logger logger;
	ExtentHtmlReporter htmlreporter;
	ExtentTest test;
	ExtentReports extent;
	LoginPage lp;
	
	

	
	@BeforeTest
	@Parameters("browser")
	public void setup(String br)
	{
		
		htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\test-output\\myoutput.html");
		htmlreporter.config().setDocumentTitle("Automation report");
		htmlreporter.config().setTheme(Theme.DARK);
		extent = new ExtentReports();
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("Envionment", "QA");
		extent.setSystemInfo("Tester", "Aswin");
		extent.setSystemInfo("OS", "WIN 10");
		extent.setSystemInfo("Browser", "Chrome");
		logger=Logger.getLogger("Login test");
		PropertyConfigurator.configure(System.getProperty("user.dir")+"\\ConfigFiles\\Log4j.Properties");
		logger.info("--------------->Execution Started<----------------");
		if(br.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver=new ChromeDriver();
			
		}
		else if(br.equals("FireFox"))
		{
			System.setProperty("webdriver.gecko.driver", readconfig.getFireFoxPath());
			driver=new FirefoxDriver();
		}			
		    lp=new LoginPage(driver);
			driver.get(baseurl);	
			driver.manage().window().maximize();
			logger.info("---------------->Application Opened<---------------");		
	}

	@AfterTest
	public void teardown() {
		extent.flush();
		driver.quit();
		logger.info("Execution Completed<----------> Browser is closed");
	}
	
	@AfterMethod
	public void aftermethod(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "haha is FAILED", ExtentColor.RED));
			test.fail(result.getThrowable());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "oho is PASSED", ExtentColor.GREEN));
						
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + "yaaa is Skipped", ExtentColor.YELLOW));
		}
	}

}
