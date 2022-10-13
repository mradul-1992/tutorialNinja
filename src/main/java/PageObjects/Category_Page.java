package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Basic.BasicTestPack;

public class Category_Page extends BasicTestPack{

	WebDriver driver = null;
	
	public Category_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='caption']/h4/a")
	private List<WebElement> allProductNames;
	
		public List<WebElement> getAllProductsName(){
			return allProductNames;
		}
		
	@FindBy(xpath="//div[@class='button-group']/button[1]")
	private List<WebElement> addToCartButtons;
	
	@FindBy(xpath="//div[@class='button-group']/button[2]")
	private List<WebElement> addToWishlistButtons;
	
	@FindBy(xpath="//div[@class='button-group']/button[3]")
	private List<WebElement> compareThisProductButton;
	

}
