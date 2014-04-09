package ie.gmit.project;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class HibMethods {
public static void rowsBack(int i) throws InvalidFormatException, FileNotFoundException, IOException{
	long HibstartTime = System.nanoTime();
	List<Person> peopleList = HibDao.getSomePeople(i);
	long HibendTime = System.nanoTime();
	long rowCount = peopleList.size();
	long time = (HibendTime - HibstartTime);
	String name ="hibStuff";
	

	Info info = new Info(name, time, rowCount);
//	ExcelStuff.addToExcel(info);
//	System.out.println(info + "  from Main " + peopleList);

	
}

public static void rowsBackFromStudent() throws InvalidFormatException, FileNotFoundException, IOException{
	long HibstartTime = System.nanoTime();
	List<Student> studentList = HibDao.getStudents();
	long HibendTime = System.nanoTime();
	long rowCount = studentList.size();
	
	
	long time = (HibendTime - HibstartTime);
	String name ="hibStuff";
	

	Info info = new Info(name, time, rowCount);
	ExcelStuff.addToExcel(info);
	System.out.println(info.getTime());

	
}
}
