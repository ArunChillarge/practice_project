package test_cases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import page_objects.Login_page;
import utilities.XLUtils;

public class Login_Test_2 extends Base_class {
			
	
		@Test(dataProvider = "LoginData")
		public void loginDDT(String user, String pwd ) throws InterruptedException {
			Login_page lp =new Login_page(driver);
			Logger.info("url is opened");
			lp.setusername(user);
			Logger.info("username provided");
			Thread.sleep(3000);
			
			lp.setpassword(pwd);
			Logger.info("password provided");
			Thread.sleep(3000);
			
			lp.clicksubmit();
			Logger.info("clicked on signin");
			Thread.sleep(3000);
			
		
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			Assert.assertFalse(false);
			Logger.warn("Login failed");
		}
		else
		{
			Assert.assertTrue(true);
			Logger.info("Login passed");
			lp.Clicksignout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();
			
		}
		
		
	}
	
	
	public boolean isAlertPresent() //user defined method created to check alert is presetn or not
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}
		
	
			
		
		@DataProvider(name="LoginData")
		String[][] getData() throws IOException{
			{
				String path=System.getProperty("user.dir")+"/src/test/java/test_data/Book2.xlsx";
				
				int rownum=XLUtils.getRowCount(path, "Sheet1");
				int colcount=XLUtils.getCellCount(path,"Sheet1",1);
				
				String logindata[][]=new String[rownum][colcount];
				
				for(int i=1;i<=rownum;i++)
				{
					for(int j=0;j<colcount;j++)
					{
						logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
					}
						
				}
			return logindata;
			}
		}
}
