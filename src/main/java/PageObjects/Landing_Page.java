package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Basic.BasicTestPack;

public class Landing_Page extends BasicTestPack{
	
	WebDriver driver = null;
	
	public Landing_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@title='My Account']")
	private WebElement myAccountDropdown;
	
		public WebElement getMyAccountDropdown() {
			return myAccountDropdown;
		}
		
		@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']/li[1]/a")
		private WebElement registerButton;
		
			public WebElement getRegisterButton() {
				return registerButton;
			}
		
		@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']/li[2]/a")
		private WebElement loginButton;
		
			public WebElement getLoginButton() {
				return loginButton;
			}
	
	@FindBy(xpath="")
	private WebElement wishListButton;
	
		public WebElement getWishListButton() {
			return wishListButton;
		}
	
	@FindBy(xpath="")
	private WebElement shoppingCartButton;
	
		public WebElement getShoppingCartButton() {
			return shoppingCartButton;
		}
		
	@FindBy(xpath="")
	private WebElement checkOutButton;
	
		public WebElement getCheckOutButton() {
			return checkOutButton;
		}
	
	@FindBy(xpath="")
	private WebElement currencyDropdown;
	
		public WebElement getCurrencyDropdown() {
			return currencyDropdown;
		}
		
		@FindBy(xpath="")
		private WebElement euroButton;
		
			public WebElement getEuroButton() {
				return euroButton;
			}
			
		@FindBy(xpath="")
		private WebElement poundButton;
		
			public WebElement getPoundButton() {
				return poundButton;
			}
		
		@FindBy(xpath="")
		private WebElement dollarButton;
		
			public WebElement getDollarButton() {
				return dollarButton;
			}
			
	@FindBy(xpath="")
	private WebElement searchBox;
		
	@FindBy(xpath="")
	private WebElement searchButton;
}
