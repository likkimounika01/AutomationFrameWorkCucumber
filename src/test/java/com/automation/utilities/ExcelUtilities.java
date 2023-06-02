package com.automation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;

public class ExcelUtilities {
	FileInputStream fip;
	HSSFWorkbook workbook;
	HSSFSheet worksheet;
	
	
	public ExcelUtilities(String sheetName) {
		try {
			fip = new FileInputStream(new File(System.getProperty("user.dir")+"/TestData/TestExcel.xls"));
			workbook =new HSSFWorkbook(fip);
			worksheet=workbook.getSheet(sheetName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void getCellValues() {
	FormulaEvaluator formulaEvaluator = workbook.getCreationHelper().createFormulaEvaluator();
	for(Row row:worksheet) {
		for(Cell cell:row) {
			switch (formulaEvaluator.evaluateInCell(cell).getCellType()) {
			case NUMERIC:
				System.out.println(cell.getNumericCellValue());
				break;
			case STRING:
				System.out.println(cell.getStringCellValue());
				break;
			default:
				break;
			}
		}
	}
		
		
		
	}

}
