package ie.gmit.project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;





	public class DatabaseCaller {
		private Connection connection=  null;
		private Statement statement = null;
		private ResultSet resultSet = null;

		static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		static final String DB_URL = "jdbc:mysql://localhost/test";

		//  Database credentials
		static final String USER = "root";
		static final String PASS = "";


		public DatabaseCaller(){
			// TODO get properties for properties file
		}

		public void closeAll(){
			try {
				if (resultSet!= null){
					resultSet.close();
					resultSet = null;
				}
				if (statement!= null){
					statement.close();
					statement = null;
				}
				if (connection!= null){
					connection.close();
					connection = null;
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		private void createStatement() throws ClassNotFoundException, SQLException{
			if (statement == null){
				Class.forName(JDBC_DRIVER);
				connection = DriverManager.getConnection(DB_URL,USER,PASS);
				//System.out.println("Creating statement...");
				statement = connection.createStatement();
			}

		}
		public void executeUpdate(String sql){
//			System.out.println("executing :"+sql);
			try {
				createStatement();
				statement.executeUpdate(sql);
			} catch (ClassNotFoundException | SQLException e) {

				e.printStackTrace();
			}


		}
		public ResultSet executeQuery(String sql){
//			System.out.println("executing :"+sql);

			try {
				createStatement();
				resultSet = statement.executeQuery(sql);
			} catch (ClassNotFoundException | SQLException e) {

				e.printStackTrace();
			}
			return resultSet;
		}
		

	}


