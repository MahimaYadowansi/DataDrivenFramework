package testCases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;

@Test(dataProvider="getData")
public class AddCustomerTest extends TestBase {
public void addCustomer(String FirstName, String LastName,String PostCode)
	{ 
	 
	
	driver.findElement(By.xpath(Or.getProperty("addCustBtns"))).click();	
	
	driver.findElement(By.xpath(Or.getProperty("firstName"))).sendKeys(FirstName);
	driver.findElement(By.xpath(Or.getProperty("lastName"))).sendKeys( LastName);
	driver.findElement(By.xpath(Or.getProperty("postCode"))).sendKeys( PostCode);
	driver.findElement(By.xpath(Or.getProperty("addCustomer"))).click();	
	}


	
@DataProvider
public Object[][] getData()
{
	String sheetName="AddCustomerTest";
	int rows=excel.getRowCount(sheetName);
	int cols=excel.getColumnCount(sheetName);
	Object[][] data=new Object[rows-1][cols];
	for(int rowNum=2;rowNum<=rows;rowNum++)
	{
		for(int colNum=0;colNum<cols;colNum++)
		{
			//data[0][0]
			data[rowNum-2][colNum]=excel.getCellData(sheetName,colNum,rowNum);
		}
	}
	return data;
}
}
