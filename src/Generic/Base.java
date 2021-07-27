package Generic;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class Base {
	
	public WebDriver driver;
	static ExtentReports report;
	static ExtentTest Test1;
	
	@BeforeMethod
	@Parameters(value="browser")
	public void precondition(String browserName){
		
		if(browserName.equalsIgnoreCase("Firefox")){
			driver=new FirefoxDriver();
			Reporter.log("Firefoxlaunch",true);
		}
		else if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver","D:\\Demo\\ExeFiles\\chromedriver.exe");
			driver=new ChromeDriver();
			Reporter.log("chromelaunch",true);
		//	Test1.log(LogStatus.PASS, "chromelaunch");
			
		}
		if(browserName.equalsIgnoreCase("ie")){
			
			System.setProperty("webdriver.ie.driver","./exefiles/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			Reporter.log("InternetExplorerlaunch",true);
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://live.demoguru99.com/index.php");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		Reporter.log("Navigating to url",true);
	//	Test1.log(LogStatus.PASS, "Navigated to Url");
		
	}
		
	@AfterMethod 
	public void postcondition(ITestResult result ) throws IOException{
		if (result.isSuccess()){
		}
		else {
			
			Screenshotlib lib = new Screenshotlib();
		
			String filename = result.getMethod().getMethodName();
			lib.getscreenshot(driver, filename);
			Reporter.log("screenshot has been taken",true);
			//Extended Report	
		//	Test1.log(LogStatus.FAIL, "Test Failed");
		}
		driver.close();
		Reporter.log("Browser closed",true);
	}
	
	/*
	@BeforeClass
    public static void startTest()throws ClassNotFoundException{
		
		report = new ExtentReports("D:/Demo/ExtendReport/"+"ExtentReportResults.html", true);
		
	  Test1 = report.startTest("Demo");
	}
	
	@AfterClass
	public void endTest() {
		
		report.endTest(Test1);
		report.flush();
	}
	
	@AfterClass(dependsOnMethods="endTest")
	public void closeBrowser() {
		
		driver.quit();	
	}
	*/


}
