package brd.filehandling;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
public class database {
	static Connection connection = null;
	static {
		// Load the driver
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	public static void getConnection(String Customer_ID, String Customer_code, String Customer_Name,
			String Customer_Address_1, String Customer_Address_2, String Customer_PinCode, String Email_address,
			String Contact_Number, String Primary_ContactPerson, String Record_Status, String ActiveorInactive_Flag,
			String Create_Date, String Created_By, String Modified_Date, String Modified_By, String Authorized_Date,
			String Authorized_By) {
		try {
			Statement state = connection.createStatement();
			PreparedStatement pre = connection
					.prepareStatement("insert into LANA_DB values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pre.setString(1, Customer_ID);
			pre.setString(2, Customer_code);
			pre.setString(3, Customer_Name);
			pre.setString(4, Customer_Address_1);
			pre.setString(5, Customer_Address_2);
			pre.setString(6, Customer_PinCode);
			pre.setString(7, Email_address);
			pre.setString(8, Contact_Number);
			pre.setString(9, Primary_ContactPerson);
			pre.setString(10, Record_Status);
			pre.setString(11, ActiveorInactive_Flag);
			pre.setString(12, Create_Date);
			pre.setString(13, Created_By);
			pre.setString(14, Modified_Date);
			pre.setString(15, Modified_By);
			pre.setString(16, Authorized_Date);
			pre.setString(17, Authorized_By);
			pre.executeUpdate();
		}

		catch (SQLException exception) {
			System.out.println(exception);
		}
	}

}
