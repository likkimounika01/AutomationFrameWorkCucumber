package com.automation.accelerators;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.automation.utilities.ConfigUtilities;
import com.automation.utilities.ExcelUtilities;
import com.automation.utilities.JsonUtilities;

public class BaseTest {

	protected WebDriver driver;
	public static ConfigUtilities cu;
	public JsonUtilities jsonUtilities;
	public ExcelUtilities excelUtilities;
	
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite");
		cu=new ConfigUtilities();
		jsonUtilities = new JsonUtilities();
		excelUtilities = new ExcelUtilities("Sheet1");
	}
	
	@BeforeTest
	@Parameters({"browserName"})
	public void setup(String browser) {
		switch (browser) {
		case "chrome":
			ChromeOptions options = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<>();
			prefs.put("download.default_directory", System.getProperty("user.dir")+"\\TestData");
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--remote-allow-origins=*");
			options.setAcceptInsecureCerts(true);
			driver = new ChromeDriver(options);
			break;
		case "edge":
			driver = new EdgeDriver();
			break;		
		  case "ie": 
			  driver = new InternetExplorerDriver();
		  break;			
		case "firefox":
			 driver=new FirefoxDriver();
			break;
		default:
			break;
		}
		String appURL = cu.readProperty("baseURL");
		
		//appURL = "https://admin:admin@"+cu.readProperty("baseURL");For Authentication Popup
		
		driver.get(appURL);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //selenium 3
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //selenium 4
		//System.out.println(jsonUtilities.readJson("userName"));
		driver.manage().window().maximize();
	}
	@AfterTest
	public void closeSetup() {
		driver.quit();
	}
	
	
	
}
