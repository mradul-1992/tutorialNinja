package Tests;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//import com.aventstack.extentreports.util.Assert;

import Basic.BasicTestPack;
import PageObjects.Landing_Page;
import PageObjects.Register_Page;

public class UserRegistration_Test extends BasicTestPack{
	
	Logger logger;
	Landing_Page landPage;
	public WebDriver driver;
	
	@Parameters({"browserName","environment"})
	@BeforeTest
	public void openApplication(String browserName, String environment) {
		logger = LogManager.getLogger(UserRegistration_Test.class.getName());
		driver = openBrowser(browserName, readDataFromProperty(environment));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@BeforeMethod
	public void openRegistrationPage() {
		landPage = new Landing_Page(driver);

		logger.debug("Landing Page Has been Opened");
		landPage.getMyAccountDropdown().click();
		logger.debug("My Account Dropdown opened");
		landPage.getRegisterButton().click();
		logger.debug("Registration Button Clicked");
	}
	Register_Page regPage;
	@Test
	public void registerNewUser() {
		regPage = new Register_Page(driver);
		regPage.getFirstNameTextBox().sendKeys("Mradul");
		logger.debug("First Name Entered");
		regPage.getLastNameTextBox().sendKeys("Parihar");
		logger.debug("Last Name Entered");
		regPage.getEmailTextBox().sendKeys("mlparihar.vegatva6@gmail.com");
		logger.debug("E mail Entered");
		regPage.getTelephoneTextBox().sendKeys("1234567890");
		logger.debug("Phone Number Entered");
		regPage.getPasswordTextBox().sendKeys("One2345");
		logger.debug("Password Entered");
		regPage.getConfirmPasswordTextBox().sendKeys("One2345");
		logger.debug("Confirm Password Entered");
		regPage.getSubscribeYesRadio().click();
		logger.debug("yes to newsletter clicked");
		regPage.getPrivacyPolicyCheckBox().click();
		logger.debug("privacy policy accepted");
		regPage.getContinueButton().click();
		logger.debug("Continue Button Clicked");
		logger.info("Login Success");
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
	

}
