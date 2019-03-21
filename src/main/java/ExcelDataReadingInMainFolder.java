import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;


public class ExcelDataReadingInMainFolder
	{
	Workbook wb;

	public ExcelDataReadingInMainFolder(String excelPath) throws IOException {

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

	public int getColumnCount(int sheetIndex, int row)
	{
		int columnCount = wb.getSheetAt(sheetIndex).getRow(row).getLastCellNum();

		columnCount = columnCount+1;

		return columnCount;
	}

	}
		
	
