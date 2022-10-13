package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface WaitUtility {
	public void waitForElementToBeClickable(WebDriver driver, WebElement element, int time);
	public void waitForElementToBePresent(WebDriver driver, WebElement element, int time);
	public void waitForAlertToBePresent(WebDriver driver, WebElement element, int time);
	public void waitForPageToLoad(WebDriver driver, int time);
}
