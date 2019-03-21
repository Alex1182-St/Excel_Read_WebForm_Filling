package WebFormFillingFromExcel;

import java.io.File;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelDataReadingInTestFolder
	{
	Workbook wb;

	public ExcelDataReadingInTestFolder(String excelPath) throws IOException {

		 wb = WorkbookFactory.create(new File(excelPath));
	}

	public String getData(int sheetNumber, int row, int column)
	{

		String data = wb.getSheetAt(sheetNumber).getRow(row).getCell(column).getStringCellValue();
			
		return data;
	}

	public int getRowCount(int sheetIndex)
	{
		int rowCount = wb.getSheetAt(sheetIndex).getLastRowNum();
		
		rowCount = rowCount+1;
		
		return rowCount;
	}
	}
		
	
