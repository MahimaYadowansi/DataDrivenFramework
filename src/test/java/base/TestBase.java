package base;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ExcelReader;
import utilities.ExtentManager;
public class TestBase {

	/* initilizing
	 * webdriver --->done
	 * properties --->done
	 * logs (req: log4j jar, .log, log4j.properties(contains all appender),logger class) --->
	 * ExtentReports
	 * DB
	 * Excel
	 * Mail
	 * ReportNG, ExtentReport
	 * execution from jenkins
	 */
	public static WebDriver driver;
	public static Properties config=new Properties();
	public static Properties Or=new Properties();
	public static FileInputStream fis;
	public static FileInputStream fis1;
	public static org.apache.logging.log4j.Logger log= LogManager.getLogger("devpinoyLogger");
	public static ExcelReader excel=new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\testdata.xlsx");
	public static WebDriverWait wait;
	public ExtentReports report=ExtentManager.getInstance();
	public static ExtentTest test;
	
	
	@BeforeSuite
	public void setup() throws IOException, InterruptedException {
	if(driver==null)
	{
		// geting data from config
		 fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
		config.load(fis);
		// logger
		log.debug("config file loaded!!!");
		
		//geting data from Or
		 fis1=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Or.properties");
		Or.load(fis1);
		log.debug("Or file loaded!!!");
		
	}
	if(config.getProperty("browser").equals("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		log.debug("chrome launched!!!");
	}
	else if(config.getProperty("browser").equals("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		driver =new FirefoxDriver();
	}
	  else if(config.getProperty("browser").equals("edge"))
	{
		WebDriverManager.edgedriver().setup();
		driver =new EdgeDriver();
	}
	  driver.get(config.getProperty("testsiteurl"));
	  driver.manage().window().maximize();
	  wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	  log.debug("navigated to : "+config.getProperty("testsuiteurl"));
	  //driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
	  wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	}
public boolean isElementPresent(By by)
{
	try
	{
		
		driver.findElement(by);
		return true;
	}catch(NoSuchElementException e)
	{
		return false;
	}
}
	
	
	@AfterSuite
	public void tearDown() {
	if(driver!=null)
	{
		driver.quit();	
	}
	log.debug("test execution completed");	
		
	}
	}
