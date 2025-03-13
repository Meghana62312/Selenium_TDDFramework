package utiliy;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	
	public static ExtentReports getReportObject()
	{
		String path=System.getProperty("user.dir")+ "//reports//index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Meghana Ingale");
		reporter.config().setDocumentTitle("Capstone Project");
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Test", "MI");
		return extent;
		
	}

}
