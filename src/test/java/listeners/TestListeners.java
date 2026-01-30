package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import drivers.DriverFactory;
import reports.ExtentManager;
import utils.ScreenshotUtils;

public class TestListeners implements ITestListener{

    
    private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        test.set(extent.createTest(result.getMethod().getMethodName()));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().fail(result.getThrowable());
        String screenshot = ScreenshotUtils.takeScreenshots(DriverFactory.getDriver());
        test.get().addScreenCaptureFromPath(screenshot);
    }

    @Override
    public void onFinish(ITestContext context){
        extent.flush();
    }

}