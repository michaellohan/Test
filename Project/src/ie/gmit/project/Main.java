package ie.gmit.project;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	//	create the logger
	static Logger logger = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) throws InvalidFormatException, FileNotFoundException, IOException {

		//logger.info(("Hibernate Took "+(time) + " nanoseconds " + " returning " + rowCount + " rows "), name); 	


//		for (int i = 0; i < 997; i++) {
//		HibMethods.rowsBack(i);
//		Long free = Runtime.getRuntime().freeMemory();
//		Long total = Runtime.getRuntime().totalMemory();
//		Long used =(total - free);
//		System.out.println(used);
//		}
		
		for (int i = 0; i < 997; i++) {
		MyStuffMethods.rowsBack(i);
		Long free = Runtime.getRuntime().freeMemory();
		Long total = Runtime.getRuntime().totalMemory();
		Long used =(total - free);
		System.out.println(used);
		}
//		generateData.generate();

	}


}
