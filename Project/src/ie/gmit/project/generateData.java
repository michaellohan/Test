package ie.gmit.project;
import org.fluttercode.datafactory.impl.DataFactory;


public class generateData {

	public static void generate() {

		DataFactory df = new DataFactory();
		for (int i = 0; i < 1; i++) {
			String firstName = df.getFirstName();
			String lastName =  df.getLastName();
//			Person person = new Person("0", firstName, lastName);
//			HibDao.addPerson(person);
		Student student = new Student("0", firstName, lastName);
			HibDao.store(student);
		
		}

	}

}

