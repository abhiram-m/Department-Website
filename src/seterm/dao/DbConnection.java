package seterm.dao;
import java.sql.*;
public class DbConnection {

	

		
		 int count;
		 java.sql.Connection conn = null;
		 Statement stmt = null;
		
		public Connection createCon(){
		try
		{
			
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		String connectionUrl = "jdbc:mysql://localhost:3306/seterm";
		String connectionUser = "root";
		String connectionPassword = "manager";
		conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
		
		}catch (Exception e) {
			e.printStackTrace();}
		
		return conn;
		}
		
		
		
		
		
		

	
	
}
