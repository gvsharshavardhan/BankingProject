package util;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.*;

public class ListenerManager implements ITestListener, ISuiteListener {
    @Override
    public void onStart(ISuite suite) {
        ReportManager.initReport();
    }

    @Override
    public void onFinish(ISuite suite) {
        ReportManager.closeReport();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ReportManager.createExtentTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ReportManager.getExtentTest().pass(result.getMethod().getMethodName() + " PASSED!!");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
        ReportManager.getExtentTest().info(MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build());
        ReportManager.getExtentTest().fail(result.getMethod().getMethodName() + " FAILED!");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ReportManager.getExtentTest().skip(result.getMethod().getMethodName() + " SKIPPED!");
    }

}