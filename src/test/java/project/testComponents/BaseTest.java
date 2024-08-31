package project.testComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class BaseTest {
	public WebDriver driver;
	public WebDriver WebDriverManager() throws IOException {

		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//project//resource//global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("QAUrl");
		String browser_properties = prop.getProperty("browser");
		String browser_maven=System.getProperty("browser");
		// result = testCondition ? value1 : value2
		//doubt 
		String browser = browser_maven!=null ? browser_maven : browser_properties;
		
		
		
		if(driver == null)
		{
			if(browser.equalsIgnoreCase("chrome"))
			{
				WebDriverManager.chromedriver().setup();
			    driver = new ChromeDriver();
			}
			if(browser.equalsIgnoreCase("firefox"))
			{
//				System.setProperty("webdriver.gecko.driver","//Users//rahulshetty//Downloads//geckodriver 5");
//				driver = new FirefoxDriver();
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(url);
		}
		
		return driver;
	}


}
