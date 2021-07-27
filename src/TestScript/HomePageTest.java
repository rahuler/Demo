package TestScript;

import org.testng.annotations.Test;

import Generic.Base;
import POM.HomePage;

public class HomePageTest extends Base{
	public HomePage h ;

	@Test (priority=1)
	public void VrifyWelcomeMessage() {
		
		h = new HomePage(driver);
		h.VerifyWelcomeMsg();
		h.VerifyMagnetoIconalongwithImage();
		
	}
	
	@Test(priority=2)
	public void verifyMobileAndTVLink() {
		h = new HomePage(driver);
		h.verifyMobileLink();
		h.verifyTVLink();
		h.verifyBackgrouOnMouseOvering(driver);
				
	}
	
	
	
	
	
	

}
