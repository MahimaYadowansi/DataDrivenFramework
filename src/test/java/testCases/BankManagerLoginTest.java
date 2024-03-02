package testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import base.TestBase;

public class BankManagerLoginTest extends TestBase {
@Test
public void bankManagerLoginTest() throws InterruptedException, IOException
	{
	
   // verifyEquals("abc","xyz");;
	log.debug("Inside login test");
	click("bmlBtn");
	//driver.findElement(By.xpath(Or.getProperty("bmlBtn"))).click();
	Thread.sleep(4000);
	Assert.assertTrue(isElementPresent(By.xpath(Or.getProperty("addCustBtn"))),"login is not successfull");
		Thread.sleep(3000);
		log.debug("Login successfully executed");
	
		
		//adding customize message to reportNG
		Reporter.log("Login successfully executed");
		
		//forcefully failed test, to check listeners
		//Assert.fail("login not successful");
		
	}



}
