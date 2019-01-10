package MakerPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class databaseConnection {
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		} catch (Exception exception) {
			System.out.println(exception);
		}
		return connection;
	}

	public static boolean validateLogin(String  UserName, String Password, String authority) 
	{

		try {
			Connection connection = getConnection();
			Statement statement = connection.createStatement();
			String query = 	"SELECT * FROM logindatabase where username ='"+ UserName + "' and password = '"+ Password + "' and authority = '"+ authority +"'";
//		String query = 	"SELECT * FROM logindatabase where username = '"+UserName+"' and password = '"+Password+"' and authority = '"+authority"'";
			
//	String query =  "select * from logindatabase where UserName='"+  UserName + "' and Password ='"+ Password + "'" ;
			ResultSet resultSet = statement.executeQuery(query);
		
			while(resultSet.next())
			{
				return true;
			}	
			
			System.out.println(resultSet.toString());
		} catch (Exception e) {
			System.out.println("Error validating in db : " + e);
		}
		return false;
	}

}

