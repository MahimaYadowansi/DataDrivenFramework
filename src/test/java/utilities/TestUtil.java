package utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import base.TestBase;

public class TestUtil extends TestBase {
	public static String screenshotPath;
	public static String screenshotName;

	public static void captureScreenshot() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		FileUtils.copyFile(scrFile,
				new File(System.getProperty("user.dir") + "\\test-output\\html\\" + screenshotName));
	}

	@DataProvider(name="dp")
	public Object[][] getData(Method m) {
		String sheetName = m.getName();
		int rows = excel.getRowCount(sheetName);  // 4
		int cols = excel.getColumnCount(sheetName);  // 4
		
		System.out.println(rows+" --- "+cols+" ___ "+sheetName);
		Object[][] data = new Object[rows - 1][cols];
		for (int rowNum = 1; rowNum < rows; rowNum++) {
			for (int colNum = 0; colNum < cols; colNum++) {
				// data[0][0]
				System.out.println("rowNum"+rowNum+"colNum"+colNum);
				data[rowNum-1][colNum] = excel.getCellData(sheetName, colNum, rowNum);
				
			}
		
		}
		//to see output
		System.out.println("-----");
		for (int i=0; i<rows-1;i++ ) {
			for(int j=0; j< cols;j++) {
				System.out.print(data[i][j]+" ");
			}
			System.out.println();
		}
		
		
		return data;
	}

/*
	public static boolean isTestRunnable(String testName,ExcelReader excel)
	{
		String SheetName="TestSuite";
		int rows=excel.getRowCount(SheetName);
		int cols=excel.getColumnCount(SheetName);
		System.out.println(rows+ " "+cols+"------"+SheetName);
		
		for(int rNum=1;rNum<rows;rNum++)
		{
			
			String testcase=(String) excel.getCellData(SheetName, "TCID", rNum);
			if(testcase.equalsIgnoreCase(testcase))
			{
				String RunMode=(String) excel.getCellData(SheetName, "RunMode", rNum);
				if(RunMode.equalsIgnoreCase("y"))
				{
					return true;
				}
				else
				{
					return false;
				}
			}
		}
		
	return false;
	
}*/
}