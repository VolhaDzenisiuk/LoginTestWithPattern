package tests;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

	@Attachment(value = "Screenshot", type = "image/png")
	private byte[] captureScreenshot() {
		return ((TakesScreenshot) BasePage.driver).getScreenshotAs(OutputType.BYTES);
	}

	@Override
	public void onTestStart(ITestResult iTestResult) {

	}

	@Override
	public void onTestSuccess(ITestResult iTestResult) {

	}

	@Override
	public void onTestFailure(ITestResult iTestResult) {
		captureScreenshot();
	}

	@Override
	public void onTestSkipped(ITestResult iTestResult) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

	}

	@Override
	public void onStart(ITestContext iTestContext) {

	}

	@Override
	public void onFinish(ITestContext iTestContext) {

	}
}
