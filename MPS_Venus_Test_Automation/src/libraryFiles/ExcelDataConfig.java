package libraryFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {

	XSSFWorkbook wb;
	XSSFSheet sh1, sh2;
	public ExcelDataConfig(String excelPath) throws Exception{  //Constructor
		File file = new File(excelPath);
		FileInputStream fis = new FileInputStream(file);

		 wb = new XSSFWorkbook(fis);

		}
	
	public int getRowCount(int sheet){
		sh2 = wb.getSheetAt(sheet);
		int rowNum = sh2.getLastRowNum();
		int colNum = sh2.getRow(0).getLastCellNum();
		//System.out.println("No of Rows: "+rowNum );
		return rowNum;
	}
		
	
	public String getData(int sheetNumner, int row, int column){
		sh1 = wb.getSheetAt(sheetNumner);
		String data = sh1.getRow(row).getCell(column).getStringCellValue();
		return data;
		
	}

	
}
