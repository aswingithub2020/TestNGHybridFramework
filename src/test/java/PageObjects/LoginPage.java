package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Testcases.BaseClass;
import Utilities.ReadConfiguration;

public class LoginPage extends BaseClass{

	WebDriver ldriver;
	

	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(name = "uid" )
	WebElement txtusername;

	@FindBy(name = "password")
	WebElement txtpassword;

	@FindBy(name = "btnLogin")
	WebElement btnLogin;

	public void setusername(String uname) {
		txtusername.sendKeys(uname);
	}

	public void setpassword(String pwd)
	{
		txtpassword.sendKeys(pwd);
	}
	
	public void clicksubmit()
	{
		btnLogin.click();
	}
}
