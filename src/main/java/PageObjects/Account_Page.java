package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Basic.BasicTestPack;

public class Account_Page extends BasicTestPack{
	
	WebDriver driver = null;
	
	public Account_Page (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath ="//span[text()='My Account']")
	private WebElement myAccountDropdown;
	
		public WebElement getMyAccountDropdown() {
			return myAccountDropdown;
		}
		
		@FindBy(xpath ="//a[text()='My Account'][1]")
		private WebElement myAccountOption;
		
			public WebElement getMyAccountOption() {
				return myAccountOption;
			}
		
		@FindBy(xpath ="//a[text()='Order History'][1]")
		private WebElement orderHistoryOption;
		
			public WebElement getOrderHistoryOption() {
				return orderHistoryOption;
			}
		
		@FindBy(xpath ="//a[text()='Transactions'][1]")
		private WebElement transactionOption;
		
			public WebElement getTransactionOption() {
				return transactionOption;
			}
		
		@FindBy(xpath ="//a[text()='Downloads'][1]")
		private WebElement downloadsOption;
		
			public WebElement getDownloadsOption() {
				return downloadsOption;
			}
		
		@FindBy(xpath ="//a[text()='Logout'][1]")
		private WebElement logoutOption;
		
			public WebElement getLogoutOption() {
				return logoutOption;
			}
}
