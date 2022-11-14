package test_cases;

import org.testng.annotations.Test;

import page_objects.Login_page;

public class Login_Test extends Base_class {
	
	@Test
	public void logintest() throws InterruptedException {
		
		Logger.info("Url is opened");
		
				
		Login_page lp =new Login_page(driver);
		Thread.sleep(6000);
		lp.setusername(username);
		Logger.info("entered username");
		Thread.sleep(3000);
		
		lp.setpassword(password);
		Logger.info("entered password");
		Thread.sleep(3000);
		
		lp.clicksubmit();
		Logger.info("clicked on submit");
		Thread.sleep(3000);
		
		
	/*	lp.Clicksignout();
		Logger.info("signout");
		*/
		
		
	}
	}
		

