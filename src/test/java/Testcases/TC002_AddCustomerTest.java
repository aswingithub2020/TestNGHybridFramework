package Testcases;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.AddNewCustomerPage;
import PageObjects.LoginPage;

public class TC002_AddCustomerTest extends BaseClass {

	@Test(dataProvider = "Testdata")
	public void getdata(String CustomerName, String Gender, String DOB_MM, String DOB_DD, String DOB_YYYY,
			String Address, String City, String State, String PIN, String MobileNumber, String Email, String Password)
			throws InterruptedException {

		logger.info("*************Add Customer Testcase Started***************");
		test = extent.createTest("TC002_AddCustomerTest");

		lp.setusername(username);
		lp.setpassword(password);
		lp.clicksubmit();

		AddNewCustomerPage addCustomer = new AddNewCustomerPage(driver);
		Thread.sleep(5000);

		addCustomer.clikNewCustomerLink();
		addCustomer.setCustomerName(CustomerName);
		addCustomer.clickRadioBtn(Gender);
		addCustomer.setDateOfBirth(DOB_MM, DOB_DD, DOB_YYYY);
		addCustomer.setAddress(Address);
		addCustomer.setCity(City);
		addCustomer.setState(State);
		addCustomer.setPinNumber(PIN);
		addCustomer.setPhoneNumber(MobileNumber);
		addCustomer.setEmail(Email);
		addCustomer.setPassword(Password);
		addCustomer.clickSubmit();

		Alert alert = driver.switchTo().alert();
		alert.accept();
		test.pass("TC002_AddCustomerTest");
		logger.info("*****************Customer Details Entered****************************");
		
	}
	

	@DataProvider(name = "Testdata")
	public String[][] getdatafromDataProvider() throws IOException {
		String Data[][]=null;
		int rowcount = xlutils.getRowcount(
				"C:\\Users\\asuvanam.ORADEV\\eclipse-workspace\\TestNGHybridFramework\\src\\test\\java\\TestData\\AddCustomer.xlsx",
				"CustomerDetails");
		int colcount = xlutils.getcolcount(
				"C:\\Users\\asuvanam.ORADEV\\eclipse-workspace\\TestNGHybridFramework\\src\\test\\java\\TestData\\AddCustomer.xlsx",
				"CustomerDetails");

		System.out.println("Rowcount is " + rowcount);
		System.out.println("ColumnCount is " + colcount);
									
		Data= new String[rowcount + 1][colcount];
		
		
		for (int i = 0; i <=rowcount; i++)
		{
				
			for (int j = 0; j < colcount; j++) {
				Data[i][j] = xlutils.getCellData(
						"C:\\Users\\asuvanam.ORADEV\\eclipse-workspace\\TestNGHybridFramework\\src\\test\\java\\TestData\\AddCustomer.xlsx",
						"CustomerDetails", i, j);
			}
			
			
		}
		return Data;
	}
}
