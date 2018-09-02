package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import TestBase.Base;

public class Excel_Class extends Base{
	
	public static String folderpath = read_testdata("excelfolderpath");
	
	static Sheet sh;
	static Workbook wb;
	 static WritableWorkbook wwb;
	 static WritableSheet wsh;
	public static void excelconnection(String filename,String sheetname) 
	{
		try {
			File f=new File(folderpath+filename);
			
			 wb=Workbook.getWorkbook(f);
			
			 sh=wb.getSheet(sheetname);
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
	}
	
	
	public static  int   rcount()
	{
		int i=sh.getRows();
		return i;
	}
	public static  int   ccount()
	{
		int i=sh.getColumns();
		return i;
	}
	public static String  readdata(int col,int row)
	{
		String x=sh.getCell(col, row).getContents();
		return x;
	}
	
	
	
	public static void outputexcelconnection(String ifilename,String ofilename,String sheetname)
	{
		
		try {
			FileInputStream fis=new FileInputStream(folderpath+ifilename);
			
			 wb=Workbook.getWorkbook(fis);
				
			 sh=wb.getSheet(sheetname);
			 
			 FileOutputStream fos=new FileOutputStream(folderpath+ofilename);
			 
			wwb=Workbook.createWorkbook(fos, wb);
			 
			 wsh=wwb.getSheet(sheetname);
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
		
	}
	
	public static void writedata(int col,int row,String data)
	{
		try {
			Label l=new Label(col, row, data);
			wsh.addCell(l);
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
	}
	
	public static void saveworkbook()
	{
		try {
			wwb.write();
			
			wwb.close();
			wb.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
	}
}
