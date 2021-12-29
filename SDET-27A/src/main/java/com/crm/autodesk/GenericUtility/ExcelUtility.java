package com.crm.autodesk.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * its developed using Apache Poi libraries , which used to handle Microsoft Excel sheet
 * @author 91917
 *
 */

public class ExcelUtility {
	/**
	 * it is used to read the data from excel base don below arguments
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param Data
	 * @throws Throwable
	 * 
	 */
	public String getDataFromExcel(String sheetName,int rowNum,int cellNum)throws Throwable{
		FileInputStream fis= new FileInputStream("./data/testdata1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		String data = row.getCell(cellNum).getStringCellValue();
		wb.close();
		return data;
	}
	/**
	 * used to get the last used row number on specified sheet
	 * @param sheetName
	 * @return
	 * @throws Throwable 
	 * @throws Throwable
	 */
	public int getRowCount(String sheetName) throws Throwable {
		FileInputStream fis=new FileInputStream("./data/testdata1.xlsx");
		Workbook wb = WorkbookFactory.create(fis) ;
		Sheet sh = wb.getSheet(sheetName);
		wb.close();
		return sh.getLastRowNum();


	}
	public void setDataExcel(String sheetName,int rowNum,int cellNum,String data) throws Throwable {
		FileInputStream fis=new FileInputStream("./data/testdata1.xlsx");
		Workbook wb = WorkbookFactory.create(fis) ;
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cell = row.createCell(cellNum);
		cell.setCellValue(data);
		FileOutputStream fos=new FileOutputStream("./data/testdata1.xlsx");
		wb.write(fos);
		wb.close();

	}



}
