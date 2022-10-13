package Utility;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface ApplicationUtility {
	public void doubleClick(WebElement element, WebDriver driver);
	public void rightClick(WebElement element, WebDriver driver);
	public void singleClick(WebElement element, WebDriver driver);
	
	public void switchToTab(WebDriver driver, int tabIndex);
	public String getCurrentWindowHandle(WebDriver driver);
	public ArrayList<String> getAllWindowHandles(WebDriver driver);
}
