package rough;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

	public static void main(String[] args) throws IOException
	{
		System.out.println(System.getProperty("user.dir"));
		Properties config=new Properties();
		Properties Or=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
		config.load(fis);
		
		FileInputStream fis1=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Or.properties");
		Or.load(fis1);
		System.out.println(config.getProperty("browser"));
		//driver.findElement(By.cssSelector(Or.getProperty("bmlBtn")).click();
		System.out.println(Or.getProperty("bmlBtn"));
	}
}
