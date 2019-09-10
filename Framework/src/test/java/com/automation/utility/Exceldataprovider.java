package com.automation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exceldataprovider 
{
     XSSFWorkbook wb;
	public Exceldataprovider() throws IOException 
	{
		File src =new File("./TestData/Data.xlsx");
		FileInputStream fis=new FileInputStream(src);
		wb=new XSSFWorkbook(fis);
		
	}
	public String getstringData(int sheetindex,int row,int column) 
	{
		return wb.getSheetAt(sheetindex).getRow(row).getCell(column).getStringCellValue();
		
	}
	public String getstringData(String sheetname,int row,int column) 
	{
		return wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
		
	}
	public double getnumericdata(String sheetname,int row,int column) 
	{
		return wb.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();
		
	}
}
