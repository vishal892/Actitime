package com.actitime.GenericLib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLib6 {  //Concept of use only ExcelLib+Constants+Driver+WebDriverCommonLib+POR
	
	public String getExcelData(String SheetName,int RowNum,int ColNum) throws EncryptedDocumentException, InvalidFormatException, IOException{
		//Note: in void there is no return type , so i have used string to get return the DATA and DATA will be String
		FileInputStream fis=new FileInputStream(Constants.FilePath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(SheetName);
		Row row=sh.getRow(RowNum);
		String DATA=row.getCell(ColNum).getStringCellValue();
		System.out.println(DATA);
		return DATA;
	}
	
	public int getRowCount(String SheetName) throws EncryptedDocumentException, InvalidFormatException, IOException{
		FileInputStream fis=new FileInputStream(Constants.FilePath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(SheetName);
		int RowCount=sh.getLastRowNum();
		System.out.println(RowCount);
		return RowCount;
	}
	
	
	public void setExcelData(String SheetName,int RowNum,int ColNum,String DATA) throws EncryptedDocumentException, InvalidFormatException, IOException{
		//Note:here i don't require to get/use Return Data so, i m using void 
		FileInputStream fis=new FileInputStream(Constants.FilePath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(SheetName);
		Row row=sh.getRow(RowNum);
		Cell cl=row.createCell(ColNum);
		cl.setCellType(cl.CELL_TYPE_STRING);
		FileOutputStream fos=new FileOutputStream(Constants.FilePath);
		cl.setCellValue(DATA);
		System.out.println(cl);
		wb.write(fos);
		wb.close();
	}
	
	
	
	
	
	

}
