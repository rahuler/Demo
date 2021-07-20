package Generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Base {
	public	WebDriver driver ;
	//@BeforeSuite
	
@Test
		
public void LaunchBrowser() throws InterruptedException{
	

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\eclipse-workspace\\Selenium1\\Exe\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver ();
		driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://live.demoguru99.com/index.php");
		
		Thread.sleep(2000);
		
	//	return driver;
		
		driver.close();
		

	
		
	
}
	
	

}
