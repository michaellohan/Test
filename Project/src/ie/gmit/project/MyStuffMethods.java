package ie.gmit.project;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class MyStuffMethods {
	public static void rowsBack(int i) throws InvalidFormatException, FileNotFoundException, IOException{
		long startTime = System.nanoTime();
		List<Person> personList = Dao.listSome(i);;
		long endTime = System.nanoTime();
		long rowCount = personList.size();
		long time = (endTime - startTime);
		String name = "myStuff";

		Info info = new Info(name, time, rowCount);
		ExcelStuff.addToExcel(info);
		System.out.println(info + "from Main");
	}
//	public static void genericList(String string) throws InvalidFormatException, FileNotFoundException, IOException{
//		
//		long startTime = System.nanoTime();
//		List<Person> personList = Dao.listSome();;
//		long endTime = System.nanoTime();
//		long rowCount = personList.size();
//		long time = (endTime - startTime);
//		String name = "myStuff";
//		Info info = new Info(name, time, rowCount);
//		ExcelStuff.addToExcel(info);
//		System.out.println(info + "from Main");
//	}
	public static void rowsBackFromStudent() throws InvalidFormatException, FileNotFoundException, IOException{
		long startTime = System.nanoTime();
		List<Student> studentList = Dao.listStudents();;
		long endTime = System.nanoTime();
		long rowCount = studentList.size();
		long time = (endTime - startTime);
		String name = "myStuff";

		Info info = new Info(name, time, rowCount);
//		ExcelStuff.addToExcel(info);
		System.out.println(info.getTime());
	}
}



