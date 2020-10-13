package Testcases;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.LoginPage;


public class TC001_LoginTest extends BaseClass
{
	@Test
	public void LoginTest()
	{
		test=extent.createTest("TC001_LoginTest");
		lp=new LoginPage(driver);	
		System.out.println("User name " +username);
		System.out.println("Password "+password);
		lp.setusername(username);
		logger.info("Username entered");
		lp.setpassword(password);
		logger.info("Password entered");
		lp.clicksubmit();
		logger.info("Submit button is clicked");
		Alert alert=driver.switchTo().alert();
		alert.accept();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true, "Login Success");
			logger.info("Login Successfull");
		}
		else
		{
			Assert.assertFalse(true, "Login Failed");
			logger.info("Login Failed");
		}
	}
}
