package GlobalKinetic.saucedemo;

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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {

	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {

		

		prop = new Properties();
	
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") +"\\src\\main\\java\\GlobalKinetic\\saucedemo\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");


		System.out.println(browserName);
     
		ChromeOptions option = new ChromeOptions();
		
		if (browserName.contains("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") +"\\Driver\\chromedriver.exe");
			if(browserName.contains("headless")) {
			option.addArguments("headless");
			}
			
			driver = new ChromeDriver(option);
		} else if (browserName.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") +"\\Driver\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browserName.equals("InternetExplorer")) {

			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") +"\\Driver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
		
	}
	
	  public String getScreenShot(String testCaseName, WebDriver driver) throws
	  IOException {
	  
	  
	  File src =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); String
	  destinationFile = System.getProperty("user.dir") +
	  "\\reports\\" + testCaseName + ".png"; FileUtils.copyFile(src, new
	  File(destinationFile)); return destinationFile;
	  
	  }
	 

}
