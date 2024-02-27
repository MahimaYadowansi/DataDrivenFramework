package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import base.TestBase;

public class BankManagerLoginTest extends TestBase {
@Test
	public void loginAsBankManager() throws InterruptedException
	{
	
	System.setProperty("org.uncommons.reportng.escape-output","false"); //to convert plain text of link to real link in reportng
	log.debug("Inside login test");
	driver.findElement(By.xpath(Or.getProperty("bmlBtn"))).click();
	Thread.sleep(4000);
	Assert.assertTrue(isElementPresent(By.xpath(Or.getProperty("addCustBtn"))),"login is not successfull");
		Thread.sleep(3000);
		log.debug("Login successfully executed");
		//adding customize message to reportNG
		Reporter.log("Login successfully executed");
		Reporter.log("<a target=\"blank\" href=\"file://C:/Users/AMIT/eclipse-workspace/DataDrivenFramework/src/test/resources/ScreenshotImage/Failed.jpg\">Screenshot</a>");
	//target=\"blank\" this open screenshot image in another page
		
		Reporter.log("<br>");
		Reporter.log("<br>");
		//to print the image just below the link
		Reporter.log("<a target=\"blank\" href=\"file://C:/Users/AMIT/eclipse-workspace/DataDrivenFramework/src/test/resources/ScreenshotImage/Failed.jpg\"><img height=200 width=200 src=\"file://C:/Users/AMIT/eclipse-workspace/DataDrivenFramework/src/test/resources/ScreenshotImage/Failed.jpg \"></img></a>");
		
	}
}
