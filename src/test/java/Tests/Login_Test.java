package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Basic.BasicTestPack;
import PageObjects.Account_Page;
import PageObjects.Landing_Page;
import PageObjects.Login_Page;

public class Login_Test extends BasicTestPack{
	public WebDriver driver = null;
	public boolean loginSuccess;
	
	@Parameters({"browserName","environment"})
	@BeforeTest
	public void openApplication(String browserName, String environment) {
		driver = openBrowser(browserName, readDataFromProperty(environment));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@BeforeMethod
	public void openLoginPage() {
		Landing_Page landPage = new Landing_Page(driver);
		landPage.getMyAccountDropdown().click();
		landPage.getLoginButton().click();
	}
	
	Login_Page loginPage;
	@Test(priority = 2)
	public void verifyLoginWithValidCredentials() {
		loginPage = new Login_Page(driver);
		loginPage.getEmailTextBox().sendKeys("mlparihar.vegatva6@gmail.com");
		loginPage.getPasswordTextBox().sendKeys("One2345");
		loginPage.getLoginButton().click();
		if(driver.getTitle().equalsIgnoreCase("My Account")) {
			loginSuccess = true;
		} else loginSuccess = false;
	}
	
	@Test(priority = 1)
	public void verifyLoginWithInvalidCredentials() {
		loginPage = new Login_Page(driver);
		loginPage.getEmailTextBox().sendKeys("mlparihar.vegatva7@gmail.com");
		loginPage.getPasswordTextBox().sendKeys("One2345");
		loginPage.getLoginButton().click();
		if(driver.getTitle().equalsIgnoreCase("My Account")) {
			loginSuccess = true;
		} else loginSuccess = false;
	}
	
	@Test(priority = 3)
	public void verifyLoginWithInvalidEmail() {
		loginPage = new Login_Page(driver);
		loginPage.getEmailTextBox().sendKeys("mlparihar.vegatva6");
		loginPage.getPasswordTextBox().sendKeys("One2345");
		loginPage.getLoginButton().click();
		if(driver.getTitle().equalsIgnoreCase("My Account")) {
			loginSuccess = true;
		} else loginSuccess = false;
	}
	
	@Test(priority = 4)
	public void verifyLoginWithInvalidPassword() {
		loginPage = new Login_Page(driver);
		loginPage.getEmailTextBox().sendKeys("mlparihar.vegatva6@gmail.com");
		loginPage.getPasswordTextBox().sendKeys("11111111");
		loginPage.getLoginButton().click();
		if(driver.getTitle().equalsIgnoreCase("My Account")) {
			loginSuccess = true;
		} else loginSuccess = false;
	}
	
	@Test(priority = 5)
	public void verifyLoginWithWrongEmail() {
		loginPage = new Login_Page(driver);
		loginPage.getEmailTextBox().sendKeys("mlparihar.vegatva7@gmail.com");
		loginPage.getPasswordTextBox().sendKeys("One2345");
		loginPage.getLoginButton().click();
		if(driver.getTitle().equalsIgnoreCase("My Account")) {
			loginSuccess = true;
		} else loginSuccess = false;
	}
	
	@Test(priority = 6)
	public void verifyLoginWithWrongPassword() {
		loginPage = new Login_Page(driver);
		loginPage.getEmailTextBox().sendKeys("mlparihar.vegatva6@gmail.com");
		loginPage.getPasswordTextBox().sendKeys("One234");
		loginPage.getLoginButton().click();
		if(driver.getTitle().equalsIgnoreCase("My Account")) {
			loginSuccess = true;
		} else loginSuccess = false;
	}
	
	@AfterMethod
	public void logout() {
		if(loginSuccess) {
			Account_Page accountPage = new Account_Page(driver);
			accountPage.getMyAccountDropdown().click();
			accountPage.getLogoutOption().click();
		}
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
}
