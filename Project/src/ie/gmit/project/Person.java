package ie.gmit.project;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person {
String id;
String firstName;
String lastName;
public Person() {
	super();
	// TODO Auto-generated constructor stub
}
public Person(String id, String firstName, String lastName) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
}
@Override
public String toString() {
	return "Person [id=" + id + ", firstName=" + firstName + ", lastName="
			+ lastName + "]";
}
@Id
@GeneratedValue
public String getId() {
	return id;
}
public void setId(String string) {
	this.id = string;
}
@Column(name = "firstName")
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
@Column(name = "lastName")
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
}
