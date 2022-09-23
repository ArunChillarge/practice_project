package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Login_page {

	
		WebDriver ldriver;
		public Login_page(WebDriver rdriver)
		{
			ldriver=rdriver;
			PageFactory.initElements(rdriver,this);
		}

		@FindBy(name = "uid")
		WebElement username;
		@CacheLookup
		
		@FindBy(name="password")
		WebElement password;
		
		@FindBy(name="btnLogin")
		WebElement btnlogin;
		
		@FindBy(xpath = "/html/body/div[3]/div/ul/li[3]/a")
		WebElement signout;
		
		
		
		public void setusername(String uname) {
			username.sendKeys(uname);
		}
		
		public void setpassword(String pwd) {
			password.sendKeys(pwd);
		}
		
		public void clicksubmit() {
			btnlogin.click();
		}
		
		public void Clicksignout() {
			signout.click();
		}
		
		
}
		
	
