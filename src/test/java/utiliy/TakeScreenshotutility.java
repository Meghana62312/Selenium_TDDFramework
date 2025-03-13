package utiliy;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import test.BaseClass;

public class TakeScreenshotutility extends BaseClass{


	public String getScrrenshot(String testcaseName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		
		File dest_file=new File(System.getProperty("user.dir")+ "//reports" + testcaseName + ".png");
		FileUtils.copyFile(src, dest_file);
		return System.getProperty("user.dir")+ "//reports" + testcaseName + ".png";
	}
}
