package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Basic.BasicTestPack;

public class Login_Page extends BasicTestPack{
	WebDriver driver = null;
	
	public Login_Page(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "input-email")
	private WebElement emailTextBox;
	
		public WebElement getEmailTextBox() {
			return emailTextBox;
		}
	
	@FindBy(id = "input-password")
	private WebElement passwordTextBox;
	
		public WebElement getPasswordTextBox() {
			return passwordTextBox;
		}
	
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginButton;
	
		public WebElement getLoginButton() {
			return loginButton;
		}
	
	@FindBy(xpath = "//a[text()='Forgotten Password'][1]")
	private WebElement forgotPasswordLink;
	
		public WebElement getForgotPasswordLink() {
			return forgotPasswordLink;
		}
}
