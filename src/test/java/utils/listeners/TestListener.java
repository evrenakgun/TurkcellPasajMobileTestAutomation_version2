package utils.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    ExtentReports extent = new ExtentReports();
    ExtentTest test = extent.createTest("Test");

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }



    /*public String saveScreenshot(AppiumDriver driver) throws IOException {

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        File Dest = new File("Reports/Screenshots", + System.currentTimeMillis() + ".png");

        String errflpath = Dest.getAbsolutePath();
        FileUtils.copyFile(scrFile, Dest);

        return errflpath;
    }*/


    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("I am on " + getTestMethodName(iTestResult) + "method.");
        /*try {
            test.log(Status.FAIL, test.addScreenCaptureFromPath(saveScreenshot(driver)) + "Test Failed");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
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
        extent.flush();
    }
}
