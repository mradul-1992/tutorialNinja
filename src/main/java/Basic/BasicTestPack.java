package Basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Utility.ApplicationUtility;
import Utility.ExcelUtility;
import Utility.JSExecutorUtility;
import Utility.PropertyUtility;
import Utility.ReportsUtility;
import Utility.ScreenshotUtility;
import Utility.WaitUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicTestPack implements ApplicationUtility, ScreenshotUtility, ExcelUtility, PropertyUtility, ReportsUtility, WaitUtility, JSExecutorUtility
{
	
	public WebDriver openBrowser(String browserName, String URL) {
		WebDriver driver = null;
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);

		return driver;
	}
	
//--------------------------------------------------------------------------------------------------------------------//
	
// ++++++++------ Application Utilities ------++++++++
	
	// ++++++++------ Action Utilities ------++++++++
	public Actions action;
	
		@Override
		public void doubleClick(WebElement element, WebDriver driver) {
			action = new Actions(driver);
			action.doubleClick(element);
		}
	
		@Override
		public void rightClick(WebElement element, WebDriver driver) {
			action = new Actions(driver);
			action.contextClick(element);
		}
	
		@Override
		public void singleClick(WebElement element, WebDriver driver) {
			action = new Actions(driver);
			action.click(element);
		}

	// ++++++++------ Window Utilities ------++++++++
	
		@Override
		public void switchToTab(WebDriver driver, int tabIndex) {
			driver.switchTo().window(getAllWindowHandles(driver).get(tabIndex));
		}


		@Override
		public String getCurrentWindowHandle(WebDriver driver) {
			String handle = driver.getWindowHandle();
			return handle;
		}


		@Override
		public ArrayList<String> getAllWindowHandles(WebDriver driver) {
			Set<String> handleSet = driver.getWindowHandles();
			ArrayList<String> handleList = new ArrayList<String>(handleSet);
			return handleList;
		}

//--------------------------------------------------------------------------------------------------------------------//
		
// ++++++++------ Screenshot Utilities ------++++++++
	
	
	@Override
	public String takeScreenshot(String testName, WebDriver driver) {
		
		 File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 String destinationFile = System.getProperty("user.dir")+"\\screenshots\\"+testName+".png";
		 
		 try {
			FileUtils.copyFile(sourceFile, new File(destinationFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		 return destinationFile;
	}
	
	
// ++++++++------ Excel Utilities ------++++++++
	public FileInputStream fis;
	public String excelPath = System.getProperty("user.dir")+"\\testData\\data.properties";

	// ++++++++------ Read String Data from Excel ------++++++++
		@Override
		public String readStringDataFromExcel(int sheetNo, int rowNo, int colNo) {
			String value = "";
			try{
				fis = new FileInputStream(excelPath);
				XSSFWorkbook wb = new XSSFWorkbook(fis);
				XSSFSheet sheet = wb.getSheetAt(sheetNo);
				value = sheet.getRow(rowNo).getCell(colNo).getStringCellValue();
				wb.close();
			} catch(Exception e) {
				e.getMessage();
			}
			return value;
		}
	
	// ++++++++------ Read Integer Data from Excel ------++++++++
		@Override
		public double readIntegerDataFromExcel(int sheetNo, int rowNo, int colNo) {
			double value = 0;
			try{
				fis = new FileInputStream(excelPath);
				XSSFWorkbook wb = new XSSFWorkbook(fis);
				XSSFSheet sheet = wb.getSheetAt(sheetNo);
				value = sheet.getRow(rowNo).getCell(colNo).getNumericCellValue();
				wb.close();
			} catch(Exception e) {
				e.getMessage();
			}
			return value;
		}

	
// ++++++++------ Property Utilities ------++++++++
	public String propertyPath = System.getProperty("user.dir")+"\\testData\\data.properties";
	
	// ++++++++------ read Data From Property File ------++++++++
		@Override
		public String readDataFromProperty(String key) {
			String value = "";
			try {
				fis = new FileInputStream(propertyPath);
				Properties prop = new Properties();
				prop.load(fis);
				value = prop.getProperty(key);
				
			} catch (Exception e) {
				e.getMessage();
			}
			return value;
		}

	
// ++++++++------ Report Utilities ------++++++++
	public String reportPath = System.getProperty("user.dir")+"\\reports\\report.html";
	
	// ++++++++------ Get Extent Report ------++++++++
		@Override
		public ExtentReports getExtentReport() {
			ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
			reporter.config().setDocumentTitle("Extent Report");
			reporter.config().setReportName("Tutorial's Ninja");
			
			ExtentReports report = new ExtentReports();
			report.attachReporter(reporter);
			report.setSystemInfo("Operating System", "Windows 11");
			report.setSystemInfo("Developer Name", "Developer");
			report.setSystemInfo("Tester Name", "Mradul Parihar");
			
			return report;
		}
	
	
// ++++++++------ Wait Utilities ------++++++++

	
	@Override
	public void waitForElementToBeClickable(WebDriver driver, WebElement element, int time) {
		// TODO wait for element to be click-able
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	@Override
	public void waitForElementToBePresent(WebDriver driver, WebElement element, int time) {
		// TODO wait for an web element to be present
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	@Override
	public void waitForPageToLoad(WebDriver driver, int time) {
		// TODO wait for the page to get fully loaded
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	@Override
	public void waitForAlertToBePresent(WebDriver driver, WebElement element, int time) {
		// TODO wait for the alert to pop-up
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.alertIsPresent());
		
	}

	
// ++++++++------ JScript Utilities ------++++++++
	JavascriptExecutor jse;

		@Override
		public void flash(WebDriver driver, WebElement element) {
			// TODO flash a web element to highlight its appearance
			String bgColor = element.getCssValue("background-color");
			drawBorder(driver, element);
			for (int i = 0; i < 100; i++) {
				changeColor(driver, element, "#000000");
				changeColor(driver, element, bgColor);
			}
		}
	
	
		@Override
		public void drawBorder(WebDriver driver, WebElement element) {
			// TODO draw border around a web element
			jse = ((JavascriptExecutor)driver);
			jse.executeScript("arguments[0].style.border='3px solid red'",element);
		}
	
		@Override
		public void changeColor(WebDriver driver, WebElement element, String color) {
			// TODO change the background color of a web element
			jse = ((JavascriptExecutor)driver);
			jse.executeScript("arguments[0].style.background='"+color+"'", element);
		}
	
		@Override
		public void clickByJS(WebDriver driver, WebElement element) {
			// TODO Auto-generated method stub
			jse = ((JavascriptExecutor)driver);
			jse.executeScript("arguments[0].click();", element);
		}
	
		@Override
		public void generateAlert(WebDriver driver, String message) {
			// TODO Auto-generated method stub
			jse = ((JavascriptExecutor)driver);
			jse.executeScript("alert('"+message+"')");
		}


	

}
