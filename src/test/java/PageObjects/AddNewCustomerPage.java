package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author asuvanam
 *
 */
public class AddNewCustomerPage {
	WebDriver ldriver;
	
	public AddNewCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[text()='New Customer']")
	WebElement NewCustLink;
	
	@FindBy(name="name")
	WebElement txtCustomername;
	
	@FindBy(xpath="//input[@value='f']")
	WebElement fRadioBtn;
	
	@FindBy(xpath="//input[@value='m']")
	WebElement mRadioBtn;
	
	@FindBy(name="dob")
	WebElement txtDate;
	
	@FindBy(xpath="//textarea[@name='addr']")
	WebElement txtaddress;
	
	@FindBy(xpath="//input[@name='city']")
	WebElement txtCity;
	
	@FindBy(xpath="//input[@name='state']")
	WebElement txtState;
	
	@FindBy(xpath="//input[@name='pinno']")
	WebElement txtPinNumber;
	
	@FindBy(xpath="//input[@name='telephoneno']")
	WebElement txtphoneNumber;
	
	@FindBy(xpath="//input[@name='emailid']")
	WebElement txtEmailId;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement txtPassword;
	
	@FindBy(name="sub")
	WebElement btnSubmit;
	
	public void clikNewCustomerLink()
	{
		NewCustLink.click();
	}
	
	public void setCustomerName(String Cname)
	{
		txtCustomername.sendKeys(Cname);
	}
	
	public void clickRadioBtn(String Gender)
	{

		if(Gender.equals("M"))
		{
			mRadioBtn.click();
		}
		else if(Gender.equals("F"))
		{
			fRadioBtn.click();
		}
	}
	
	public void setDateOfBirth(String mm,String dd,String yyyy)
	{
		txtDate.sendKeys(mm);
		txtDate.sendKeys(dd);
		txtDate.sendKeys(yyyy);
	}
	
	public void setAddress(String Address)
	{
		txtaddress.sendKeys(Address);
	}
	
	public void setCity(String City)
	{
		txtCity.sendKeys(City);
	}
	
	public void setState(String State)
	{
		txtState.sendKeys(State);
	}
	
	public void setPinNumber(String PIN)
	{
		txtPinNumber.sendKeys(PIN);
	}
	
	public void setPhoneNumber(String PhoneNumber)
	{
		txtphoneNumber.sendKeys(PhoneNumber);
	}
	
	public void setEmail(String Email)
	{
		txtEmailId.sendKeys(Email);
	}
	
	public void setPassword(String Password)
	{
		txtPassword.sendKeys(Password);
	}
	
	public void clickSubmit()
	{
		btnSubmit.click();
	}
	
	
	
	
	
	
	
	

}
