package Generic;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class Screenshotlib{
	
public void getscreenshot(WebDriver driver,String filename){
		
		EventFiringWebDriver efw=new EventFiringWebDriver(driver); 
		
		File srcfile = efw.getScreenshotAs(OutputType.FILE);
		 File destfile = new File("D:/Demo/Screenshots/"+filename+".png");
		try{
			FileUtils.copyFile(srcfile, destfile);
		}
		catch(IOException e){
			
			e.printStackTrace();
		}
}
	
	

}
