package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface JSExecutorUtility {

	public void flash(WebDriver driver, WebElement element);
	public void drawBorder(WebDriver driver, WebElement element);
	public void changeColor(WebDriver driver, WebElement element, String color);
	public void clickByJS(WebDriver driver, WebElement element);
	public void generateAlert(WebDriver driver, String message);
}
