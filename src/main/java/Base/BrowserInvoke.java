package Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserInvoke {
	
	public static WebDriver driver;
	
	public void launchBrowser() throws IOException  {
		
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(".\\src\\main\\resources\\config.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		String url=prop.getProperty("url");
		String chromePath=prop.getProperty("chromeDriverPath");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			
			//WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver", chromePath);
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();;
			driver=new FirefoxDriver();

		}
		
		else if(browserName.equalsIgnoreCase("edge")){
			
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		
		driver.get(url);
		driver.manage().window().maximize();
	
	}
	
}
