package ie.gmit.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelStuff{

	public  void create(String[] args) 
	{
		//Blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook(); 

		//Create a blank sheet
		XSSFSheet sheet = workbook.createSheet("Employee Data");

		//This data needs to be written (Object[])
		Map<String, Object[]> data = new TreeMap<String, Object[]>();
		data.put("1", new Object[] {"ID", "NAME", "LASTNAME"});
		data.put("2", new Object[] {1, "Amit", "Shukla"});
		data.put("3", new Object[] {2, "Lokesh", "Gupta"});
		data.put("4", new Object[] {3, "John", "Adwards"});
		data.put("5", new Object[] {4, "Brian", "Schultz"});

		//Iterate over data and write to sheet
		Set<String> keyset = data.keySet();
		int rownum = 0;
		for (String key : keyset)
		{
			Row row = sheet.createRow(rownum++);
			Object [] objArr = data.get(key);
			int cellnum = 0;
			for (Object obj : objArr)
			{
				Cell cell = row.createCell(cellnum++);
				if(obj instanceof String)
					cell.setCellValue((String)obj);
				else if(obj instanceof Integer)
					cell.setCellValue((Integer)obj);
			}
		}
		try
		{
			//Write the workbook in file system
			FileOutputStream out = new FileOutputStream(new File("C:/Users/Michael/workspace/Project/book1.xlsx"));
			workbook.write(out);
			out.close();
			System.out.println("written successfully on disk.");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	public static void addToExcel (Info info) throws InvalidFormatException, FileNotFoundException, IOException {

		// Need to convert long to string
		String rowCount = Long.toString(info.getRowCount());
		String time = Long.toString(info.getTime());
		String name = info.getName();
		String sheetName;
		
		//go to correct tab
		if (name == "myStuff"){
			sheetName =	"Test data";
			}	else {sheetName = "Sheet1";}; 
				
		//Blank workbook
		//		XSSFWorkbook workbook = new XSSFWorkbook(); 

		//Create a blank sheet
		//		XSSFSheet sheet = workbook.createSheet("Test data");

		//need to find row number 
		
		Workbook workbook = WorkbookFactory.create(new FileInputStream("Book1.xlsx"));
		Sheet sheet = workbook.getSheet(sheetName);  


		//This data needs to be written (Object[])
		Map<String, Object[]> data = new TreeMap<String, Object[]>();


		data.put("4", new Object[] {name, rowCount, time});
//		System.out.println(info + "this is from excelStuff");


		//Iterate over data and write to sheet
		Set<String> keyset = data.keySet();
		int rownum = sheet.getLastRowNum();
		
		for (String key : keyset)
		{
			Row row = sheet.createRow(rownum+1);
			Object [] objArr = data.get(key);
			int cellnum = 0;
			for (Object obj : objArr)
			{
				Cell cell = row.createCell(cellnum++);
				if(obj instanceof String)
					cell.setCellValue((String)obj);
				else if(obj instanceof Integer)
					cell.setCellValue((Integer)obj);
			}
		}
		try
		{
			//Write the workbook in file system
			FileOutputStream out = new FileOutputStream(new File("C:/Users/Michael/workspace/Project/book1.xlsx"));
			workbook.write(out);
			out.close();
			System.out.println("the next line is written to the excel file");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}

