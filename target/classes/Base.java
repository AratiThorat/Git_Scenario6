package resources;

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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	
	protected WebDriver driver;
	protected Properties pop;
	
	public WebDriver initializeDriver() throws IOException
	{
		
		pop=new Properties();
		FileInputStream fis=new FileInputStream("D:\\selenium\\Scenario6\\src\\main\\java\\resources\\data.properties");
		
		pop.load(fis);
		
		String browsername=pop.getProperty("browser");
		
		if(browsername.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\selenium\\Scenario6\\src\\main\\java\\resources\\chromedriver.exe");
			driver =new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "D:\\selenium\\Scenario6\\src\\main\\java\\resources\\geckodriver.exe");
			driver =new FirefoxDriver();
		}
		else if(browsername.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", "D:\\selenium\\Scenario6\\src\\main\\java\\resources\\IEDriverServer.exe");
			driver =new InternetExplorerDriver();
		}
			
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		return driver;
	}
	
	
	public String getScreenShotPath(String testMethodName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String destinationfile=System.getProperty("user.dir")+"\\reports\\"+testMethodName+".png";
		FileUtils.copyFile(source,new File(destinationfile));
		
		return destinationfile;
				
	}
	

}
