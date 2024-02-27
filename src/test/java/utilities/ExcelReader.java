package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public String path;
	public FileInputStream fis = null;
	public FileOutputStream fileOut = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row = null;
	private XSSFCell cell = null;

public ExcelReader(String path)
{
	this.path=path;
	try
	{
		fis=new FileInputStream(path);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheetAt(0);
		fis.close();
	}catch(Exception e)
	{
		System.out.println(e);
	}

}

public int getRowCount(String sheetName) {
	 sheet = workbook.getSheet(sheetName);
     return sheet.getPhysicalNumberOfRows();
}

public int getColumnCount(String sheetName) {
	 sheet = workbook.getSheet(sheetName);
	 Row firstRow = sheet.getRow(0);
     return (firstRow == null) ? 0 : firstRow.getPhysicalNumberOfCells();
	
}

public Object getCellData(String sheetName, int colNum, int rowNum) {
	 sheet = workbook.getSheet(sheetName);
	 Row row = sheet.getRow(rowNum - 2); // Adjust row index (assuming 1-based index)
	 Cell cell = row.getCell(colNum - 1); // Adjust column index (assuming 1-based index)

     if (cell != null) {
         switch (cell.getCellType()) {
             case STRING:
                 return cell.getStringCellValue();

             case NUMERIC:
                 if (DateUtil.isCellDateFormatted(cell)) {
                     return cell.getDateCellValue();
                 } else {
                     return cell.getNumericCellValue();
                 }

             case BOOLEAN:
                 return cell.getBooleanCellValue();

             case FORMULA:
                 return cell.getCellFormula();

             default:
                 return null;
         }
     } else {
         return null;
     }
}
}
