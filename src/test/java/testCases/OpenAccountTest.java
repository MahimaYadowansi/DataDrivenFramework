package testCases;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.TestUtil;

@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
public class OpenAccountTest extends TestBase  {
	public void openAccountTest(String Customer, String Currency) throws InterruptedException {
		try
		{
		click("openAccBtn_xpath");
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));	
		
		select("customer_xpath",Customer);
		Thread.sleep(2000);
		select("currency_xpath",Currency );
		 WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(10));	
		click("processBtn_xpath");
		
		WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(30));	
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		
		alert.accept();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

}

	
}
