package com.netBankingApp.Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils
{
	
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	
	public static int getRowCount(String xlfile ,String xlsheet) throws IOException
	{
		fis=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fis);
		sh=wb.getSheet(xlsheet);
		int rowcount=sh.getLastRowNum();
		System.out.println(rowcount);
		wb.close();
		fis.close();
		return rowcount;	
	}
	
	public static int getCellCount(String xlfile ,String xlsheet ,int rownum) throws IOException
	{
		fis=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fis);
		sh=wb.getSheet(xlsheet);
		row=sh.getRow(rownum);
		int cellcount=row.getLastCellNum(); 
		wb.close();
		fis.close();
		return cellcount;	
	}
	
	public static String getCellData(String xlfile, String xlsheet, int rownum , int colnum) throws IOException
	{
		fis=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fis);
		sh=wb.getSheet(xlsheet); 
		row=sh.getRow(rownum);
	    cell=row.getCell(colnum);
		String data;
		
		try
		{
			DataFormatter formatter = new DataFormatter();
			String cellData = formatter.formatCellValue(cell);
			return cellData;
		}
		catch(Exception e)
		{
			data="";
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		
		wb.close();
		fis.close();
		return data;
	}
	
	public static void setCellData(String xlfile,String xlsheet,int rownum,int colnum,String data) throws IOException
	{
		fis=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fis);
		sh=wb.getSheet(xlsheet);
		row=sh.getRow(rownum);
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		fos=new FileOutputStream(xlfile);
		wb.write(fos);
		wb.close();
		fis.close();
		fos.close();	
	}

	
}
