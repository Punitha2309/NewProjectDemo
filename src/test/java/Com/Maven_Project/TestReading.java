package Com.Maven_Project;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestReading {
	
	public static void dataRead() throws IOException
	{
		File f = new File("C:\\Users\\punit\\eclipse-workspace\\Maven-Project\\dataFiles\\Countries.xlsx");
		
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Sheet1");	
//		Iterator it = sheet.iterator();	
//		while(it.hasNext())
//		{
//			XSSFRow row = (XSSFRow)it.next();
//			Iterator cellIterator = row.cellIterator();
//			while(cellIterator.hasNext())
//			{
//				XSSFCell cell = (XSSFCell)cellIterator.next();
//				switch(cell.getCellType())
//				{
//				case STRING:
//					System.out.println(cell.getStringCellValue());
//					break;
//				case NUMERIC:
//					System.out.println(cell.getNumericCellValue());
//					break;
//				case BOOLEAN:
//					System.out.println(cell.getBooleanCellValue());
//					break;
//				}
//				System.out.println(" | ");
//			}
//			System.out.println();
//		}
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(1).getLastCellNum();
		
		for(int r =0;r<=rows;r++)
		{
			XSSFRow row = sheet.getRow(r);
			for(int c=0;c<cols;c++)
			{
				XSSFCell cell = row.getCell(c);
				switch(cell.getCellType())
				{
				case STRING:
					System.out.println(cell.getStringCellValue());
					break;
				case NUMERIC:
					System.out.println(cell.getNumericCellValue());
					break;
				case BOOLEAN:
					System.out.println(cell.getBooleanCellValue());
					break;
				}
				System.out.println(" | ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws IOException {
		dataRead();
		

	}

}
