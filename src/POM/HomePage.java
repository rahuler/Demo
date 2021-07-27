package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Generic.Base;

public class HomePage extends Base{
	@FindBy(xpath="//a[text()='Mobile']")
	private WebElement  Mobile;
	
	@FindBy(xpath="//a[text()='TV']")
	private WebElement  TV;
		
	@FindBy(xpath="//p[contains(text(),'Default welcome msg!')]")
	private WebElement  WelcomeMSg;
	@FindBy(xpath="//div[@class='page-header-container']/a/img[@class='large']")
	private WebElement  MagnetoIcon;
	
	
	
	
	
	
	
	
	public HomePage(WebDriver driver){
		
		PageFactory.initElements(driver, this);	
	}
	
  public void verifyMobileLink() {
		String Mobileattribute = Mobile.getAttribute("href");
		if(Mobileattribute.equals("http://live.demoguru99.com/index.php/mobile.html")) {
			System.out.println("Mobile Link is availabl:="+Mobileattribute);	
		}	}
  
  public void verifyTVLink() {
		String TVattribute = TV.getAttribute("href");
		if(TVattribute.equals("http://live.demoguru99.com/index.php/tv.html")) {
			System.out.println("TV Link is avaiable"+TVattribute);	
		}}
  
   public void verifyBackgrouOnMouseOvering(WebDriver driver) {
	 //  background-color
	   
	 String Mobilegetcss = Mobile.getCssValue("color");
	 
	 System.out.println("Mobile background clour verfied before hover : ="+Mobilegetcss);
	   
	   Actions a = new Actions(driver);
	   
	   a.moveToElement(Mobile).perform();
	   String Mobilebackground = Mobile.getCssValue("color");
	   System.out.println("Mobile background clour verfied After hover : =" + Mobilebackground );
   }
			
  public void  VerifyWelcomeMsg() {	
	    String text = WelcomeMSg.getText();
	    System.out.println("Welcome Message verifyed:"+text);
	    Assert.assertEquals(text, "DEFAULT WELCOME MSG!");
	}
  
  public void VerifyMagnetoIconalongwithImage() {
	    String hrefvalue = MagnetoIcon.getAttribute("src");
	   
	    System.out.println(hrefvalue);
	    if(hrefvalue.equals("https://live.demoguru99.com/skin/frontend/rwd/default/images/logo.gif")) {
		System.out.println("Magnetoicon verified"+hrefvalue);
		
	}
	
	
}

	
	
	
	
	
	

}
