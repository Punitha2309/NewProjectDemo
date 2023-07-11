package Com.Maven_Project;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestWriting {
	
	
	public static void dataWriting() throws IOException {
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		XSSFSheet sheet = workbook.createSheet("Student record");
		
		Object student[][] = {{"Id","Name","Age"},
				{"1","John","8"},
				{"2","Steven","10"},
				{"3","Dande","11"}
		};
		int rows= student.length;
		int cols=student[0].length;
		
		System.out.println(rows);
		System.out.println(cols);
		
		for(int r=0;r<rows;r++)
		{
			XSSFRow row= sheet.createRow(r);
			for(int c =0;c<cols;c++)
			{
				XSSFCell cell= row.createCell(c);
				Object value=student[r][c];
				if(value instanceof String)
					cell.setCellValue((String)value);
				if(value instanceof Integer)
					cell.setCellValue((Integer)value);
				if(value instanceof Boolean)
					cell.setCellValue((Boolean)value);
			
			}
		}
		String path = ".\\dataFiles\\student.xlxs";
		FileOutputStream fis = new FileOutputStream(path);
		workbook.write(fis);
		fis.close();
		
		System.out.println("File got added");

	}

	public static void main(String[] args) throws IOException {

dataWriting();

	}

}
