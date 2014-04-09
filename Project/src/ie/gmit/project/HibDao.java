package ie.gmit.project;





import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;




public class HibDao{
	public static List<Person> getAllPeople() {
		List<Person> people = new ArrayList<Person>();
		Transaction trns = null;
		Session session = HibUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			people = session.createQuery("from Person").list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return people;

	}
	public static void addPerson(Person person) {
		//Working and tested
		Transaction trns = null;
		Session session = HibUtil.getSessionFactory().openSession();
		try {

			trns = session.beginTransaction();
			
			session.save(person);
			
			session.getTransaction().commit();
		
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
	}




	public static List<Person> getSomePeople(int i) {

		List<Person> people = new ArrayList<Person>();
		Transaction trns = null;
		Session session = HibUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();

			String queryString = "from Person where id = :id";
			Query q	 = session.createQuery(queryString);
			q.setInteger("id", i);
//			Query q = session.createQuery("FROM Person");
//			q.setFirstResult(i);
//			q.setMaxResults(1);
			people = q.list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return people;

	}
	
//	public static List<Person> getPerson(int i){
//		//Working and tested
//		Person member = null;
//		Transaction trns = null;
//		Session session = HibUtil.getSessionFactory().openSession();
//		try {
//			trns = session.beginTransaction();
//			
//			String queryString = "from Person where id = :memId";
//			Query query = session.createQuery(queryString);
//			query.setInteger("memId", memId);
//			member = (Member) query.uniqueResult();
//			
//		} catch (RuntimeException e) {
//			e.printStackTrace();
//		} finally {
//			session.flush();
//			session.close();
//		}
//		return member;
	
	public static List<Student> getStudents() {
		List<Student> students = new LinkedList<Student>();
		Transaction trns = null;
		Session session = HibUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			students = session.createQuery("from Student").list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return students;
	}
	public static void store(Student student) {
		//Working and tested
		Transaction trns = null;
		Session session = HibUtil.getSessionFactory().openSession();
		try {

			trns = session.beginTransaction();
			session.save(student);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
	}

	}