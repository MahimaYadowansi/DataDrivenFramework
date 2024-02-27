package testCases;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;

public class AddCustomerTest extends TestBase {
@Test(dataProvider="getData")
	public void addCustomer(String FirstName, String LastName,String PostCode)
	{
	driver.findElement(By.xpath(Or.getProperty("addCustBtn"))).click();	
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
