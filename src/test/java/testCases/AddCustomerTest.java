package testCases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.TestUtil;

@Test(dataProviderClass=TestUtil.class,dataProvider="dp")
public class AddCustomerTest extends TestBase {
public void addCustomerTest(String FirstName, String LastName,String PostCode, String alertText)
	{ 
	 try
	 {
	 //WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	// driver.findElement(By.xpath(Or.getProperty("addCustBtn"))).click();
		 click("addCustBtn");
	 
	 WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(20));
	//driver.findElement(By.xpath(Or.getProperty("firstName"))).sendKeys(FirstName);
	 type("firstName",FirstName);
	 
	//driver.findElement(By.xpath(Or.getProperty("lastName"))).sendKeys( LastName);
	 type("lastName",LastName);
	 
	//driver.findElement(By.xpath(Or.getProperty("postCode"))).sendKeys( PostCode);
	 type("postCode",PostCode);
	 
	Thread.sleep(10000);
	//driver.findElement(By.xpath(Or.getProperty("addCustomer"))).click();
	click("addCustomer");
	
	Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	Assert.assertTrue(alert.getText().contains(alertText));
	Thread.sleep(5000);
	alert.accept();
	
	}catch (Exception e) {
        e.printStackTrace();
	}
	}

	



}
