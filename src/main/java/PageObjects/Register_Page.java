package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Basic.BasicTestPack;

public class Register_Page extends BasicTestPack{
	
	WebDriver driver = null;
	public Register_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//input[@id='input-firstname']")
	private WebElement firstNameTextBox;
	
		public WebElement getFirstNameTextBox() {
			return firstNameTextBox;
		}
	
	@FindBy (xpath = "//input[@id='input-lastname']")
	private WebElement lastNameTextBox;
	
		public WebElement getLastNameTextBox() {
			return lastNameTextBox;
		}
	
	@FindBy (xpath = "//input[@id='input-email']")
	private WebElement emailTextBox;
	
		public WebElement getEmailTextBox() {
			return emailTextBox;
		}
		
	@FindBy (xpath = "//input[@id='input-telephone']")
	private WebElement telephoneTextBox;
	
		public WebElement getTelephoneTextBox() {
			return telephoneTextBox;
		}
	
	@FindBy (xpath = "//input[@id='input-password']")
	private WebElement passwordTextBox;
	
		public WebElement getPasswordTextBox() {
			return passwordTextBox;
		}
	
	@FindBy (xpath = "//input[@id='input-confirm']")
	private WebElement confirmPasswordTextBox;
	
		public WebElement getConfirmPasswordTextBox() {
			return confirmPasswordTextBox;
		}

	@FindBy (xpath = "//input[@name='newsletter'and@value='1']")
	private WebElement subscribeYesRadio;
	
		public WebElement getSubscribeYesRadio() {
			return subscribeYesRadio;
		}
	
	@FindBy (xpath = "//input[@name='newsletter'and@value='0']")
	private WebElement subscribeNoRadio;
	
		public WebElement getSubscribeNoRadio() {
			return subscribeNoRadio;
		}
	
	@FindBy (xpath = "//input[@name='agree'and@value='1']")
	private WebElement privacyPolicyCheckBox;
	
		public WebElement getPrivacyPolicyCheckBox() {
			return privacyPolicyCheckBox;
		}

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;
	
		public WebElement getContinueButton() {
			return continueButton;
		}


}
