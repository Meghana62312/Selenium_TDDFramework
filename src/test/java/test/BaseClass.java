package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	@SuppressWarnings("deprecation")
	@BeforeMethod
	public static void setup() throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fs=new FileInputStream("C:\\Users\\asus\\eclipse-workspace\\TDDFramework\\src\\test\\resources\\resources\\GlobalData.properties");

		//load file
		prop.load(fs);
		String browsername=prop.getProperty("browser");
		if(browsername.equalsIgnoreCase("chrome"))
		{


			WebDriverManager.chromedriver().setup();
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver=new ChromeDriver(options);

			//implicite wait
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			//oprn url
			driver.get("https://rahulshettyacademy.com/client");

			//maximize window
			driver.manage().window().maximize();

		}
		else if(browsername.equalsIgnoreCase("firefox"))
		{

		}
		else if(browsername.equalsIgnoreCase("edge"))
		{

		}
	}
	@Test
	public void b()
	{

	}

	public String getScrrenshot(String testcaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		
		File dest_file=new File(System.getProperty("user.dir")+ "//reports" + testcaseName + ".png");
		FileUtils.copyFile(src, dest_file);
		return System.getProperty("user.dir")+ "//reports" + testcaseName + ".png";
	}
}
