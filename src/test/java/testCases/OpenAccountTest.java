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
		click("openAccBtn_xpath");
		Thread.sleep(2000);	
		
		select("customer_xpath",Customer);
		
		select("currency_xpath",Currency );
		click("processBtn_xpath");
		
		Thread.sleep(3000);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		
		alert.accept();

}

	
}
