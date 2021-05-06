package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	WebDriver driver;
	 public LoginPage(WebDriver ldriver)
	 {
		 this.driver=ldriver;
		 
	 }
	 
	 @FindBy(css="a[class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']") WebElement loginorange;
	
	 @FindBy(name="email") WebElement emailid;
	 
	 @FindBy(name="password") WebElement paswrd;
	 
	 @FindBy(css="div[class='ui fluid large blue submit button']") WebElement loginbluebutton;
	 
	 public void loginToCRM(String email_app,String pasword_app)
	 {
		 try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
		}
		 loginorange.click();
		 
		 emailid.sendKeys(email_app);
		 
		 paswrd.sendKeys(pasword_app);
		 
		 loginbluebutton.click();
	 }
}
