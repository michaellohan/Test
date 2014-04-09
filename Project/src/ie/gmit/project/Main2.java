package ie.gmit.project;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import ch.qos.logback.classic.Logger;


public class Main2 {

	public static void main() throws InvalidFormatException, FileNotFoundException, IOException{
		//		Logger logger = new Logger(null, logger, null);
		
		//create one more person
		for (int i = 0; i < 1; i++) {
			generateData.generate();
	//		HibMethods.rowsBackFromStudent();
			MyStuffMethods.rowsBackFromStudent();
			
			Long free = Runtime.getRuntime().freeMemory();
			Long total = Runtime.getRuntime().totalMemory();
			Long used =(total - free);
			System.out.println("Bytes Used is " + used);

		}	
	}
}

