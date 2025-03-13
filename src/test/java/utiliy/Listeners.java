package utiliy;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import test.BaseClass;

public class Listeners extends BaseClass implements ITestListener
{
	ExtentTest test;
	ExtentReports extent=ExtentReport.getReportObject();
	public void OnTestStart(ITestResult result)
	{
    test=extent.createTest(result.getMethod().getMethodName());

	}
	public void OnTestSuccess(ITestResult result)
	{
		test.log(Status.PASS, "Test Passed");
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
       String filepath=null;
       try {
    	   filepath=getScrrenshot(result.getMethod().getMethodName(), driver);
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();

	}
	}
	public void OnTestFailure(ITestResult result)
	{
		test.fail(result.getThrowable());

	}
	public void OnTestSkipped(ITestResult result)
	{

	}
	public void OnTestFinished(ITestResult result)
	{
     extent.flush();
	}
}
