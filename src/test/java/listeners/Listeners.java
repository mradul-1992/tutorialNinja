package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Basic.BasicTestPack;

public class Listeners extends BasicTestPack implements ITestListener{
	WebDriver driver = null;
	ExtentReports report = getExtentReport();
	ExtentTest extentTest;
	//ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<ExtentTest>;
	
	@Override
	public void onTestStart(ITestResult result) {
		String testName = result.getName();
		extentTest = report.createTest(testName);
		//extentTestThread.set(extentTest);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.PASS, "Test Passed successfully");
		//extentTestThread.get().log(Status.PASS, "Test Passed successfully");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getName();
		extentTest.fail(result.getThrowable());
		//extentTestThread.get().fail(result.getThrowable());
		
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			
			e.printStackTrace();
		}
		String screenshotFilePath = takeScreenshot(testName, driver);
		extentTest.addScreenCaptureFromPath(screenshotFilePath, testName);
	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

}
