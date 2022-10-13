package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Basic.BasicTestPack;

public class Profile_Panel extends BasicTestPack{

	WebDriver driver = null;
	public Profile_Panel(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//aside[@id=\"column-right\"]/div/a[text()='Login']")
	private WebElement loginOption;
	
		public WebElement getloginOption() {
			return loginOption;
		}
	
	@FindBy(xpath="//aside[@id=\\\"column-right\\\"]/div/a[text()='Register']")
	private WebElement registerOption;
	
		public WebElement getRegisterOption() {
			return registerOption;
		}
	
	@FindBy(xpath="//aside[@id=\\\"column-right\\\"]/div/a[text()='Forgotten Password']")
	private WebElement forgottenPasswordOption;
	
		public WebElement getForgottenPasswordOption() {
			return forgottenPasswordOption;
		}
	
	@FindBy(xpath="//aside[@id=\\\"column-right\\\"]/div/a[text()='My Account']")
	private WebElement myAccountOption;
	
		public WebElement getMyAccountOption() {
			return myAccountOption;
		}
	
	@FindBy(xpath="//aside[@id=\\\"column-right\\\"]/div/a[text()='Address Book']")
	private WebElement addressBookOption;
	
		public WebElement getAddressBookOption() {
			return addressBookOption;
		}
	
	@FindBy(xpath="//aside[@id=\\\"column-right\\\"]/div/a[text()='Wish List']")
	private WebElement wishlistOption;
	
		public WebElement getWishlistOption() {
			return wishlistOption;
		}
	
	@FindBy(xpath="//aside[@id=\\\"column-right\\\"]/div/a[text()='Order History']")
	private WebElement orderHistoryOption;
	
		public WebElement getOrderHistoryOption() {
			return orderHistoryOption;
		}
	
	@FindBy(xpath="//aside[@id=\\\"column-right\\\"]/div/a[text()='Downloads']")
	private WebElement downloadsOption;
	
		public WebElement getDownloadsOption() {
			return downloadsOption;
		}
	
	@FindBy(xpath="//aside[@id=\\\"column-right\\\"]/div/a[text()='Recurring payments']")
	private WebElement recurringPaymentsOption;
	
		public WebElement getRecurringPaymentsOption() {
			return recurringPaymentsOption;
		}
	
	@FindBy(xpath="//aside[@id=\\\"column-right\\\"]/div/a[text()='Reward Points']")
	private WebElement rewardPointsOption;
	
		public WebElement getRewardPointsOption() {
			return rewardPointsOption;
		}
	
	@FindBy(xpath="//aside[@id=\\\"column-right\\\"]/div/a[text()='Returns']")
	private WebElement returnsOption;
	
		public WebElement getReturnsOption() {
			return returnsOption;
		}
		
	@FindBy(xpath="//aside[@id=\\\"column-right\\\"]/div/a[text()='Transactions']")
	private WebElement transactionsOption;
	
		public WebElement getTransactionsOption() {
			return transactionsOption;
		}
	
	@FindBy(xpath="//aside[@id=\\\"column-right\\\"]/div/a[text()='Newsletter']")
	private WebElement newsLetterOption;
	
		public WebElement getNewsLetterOption() {
			return newsLetterOption;
		}
	
	
}
