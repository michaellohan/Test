package ie.gmit.project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;




public class Dao {
	public static void store(Person person){
		String sql = "insert into person (firstName, lastName) " +
				"values ('"+person.getFirstName()+"'," + " '"+person.getLastName()+"' );";

		DatabaseCaller dbc = new DatabaseCaller();

		dbc.executeUpdate(sql);
		dbc.closeAll();
	}

	public static List<Person> listAll(){
		List<Person> list = new LinkedList<Person>();
		String sql = "select * from person;";
		DatabaseCaller dbc = new DatabaseCaller();
		ResultSet rs = dbc.executeQuery(sql);

		try {
			while (rs.next()){
				Person person= new Person();
				person.setFirstName(rs.getString("firstName"));
				person.setLastName(rs.getString("lastName"));
				person.setId(rs.getString("id"));
				list.add(person);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		dbc.closeAll();



		return list;
	}
	public static List<Person> listSome(int i){
		List<Person> list = new LinkedList<Person>();
		
		String sql = "SELECT * FROM `person` WHERE id = "+i+";";
		DatabaseCaller dbc = new DatabaseCaller();
		ResultSet rs = dbc.executeQuery(sql);

		try {
			while (rs.next()){
				Person person= new Person();
				person.setFirstName(rs.getString("firstName"));
				person.setLastName(rs.getString("lastName"));
				person.setId(rs.getString("id"));
				list.add(person);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		dbc.closeAll();



		return list;
	}
	public static void storeStudent(Student student){
		String sql = "insert into student (firstName, lastName) " +
				"values ('"+student.getFirstName()+"'," + " '"+student.getLastName()+"' );";

		DatabaseCaller dbc = new DatabaseCaller();

		dbc.executeUpdate(sql);
		dbc.closeAll();
		System.out.println("1 student added to DB");
	}
	public static List<Student> listStudents(){
		List<Student> list = new LinkedList<Student>();
		String sql = "select * from student;";
		DatabaseCaller dbc = new DatabaseCaller();
		ResultSet rs = dbc.executeQuery(sql);

		try {
			while (rs.next()){
				Student student = new Student();
				student.setFirstName(rs.getString("firstName"));
				student.setLastName(rs.getString("lastName"));
				student.setId(rs.getString("id"));
				list.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		dbc.closeAll();
		return list;
	}	
}