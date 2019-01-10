package MakerPackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Newuser")
public class Newuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Customer_ID = request.getParameter("Customer ID");
		String Customer_code= request.getParameter("Customer Code");
		String Customer_Name= request.getParameter("Customer Name");
		String Customer_Address_1= request.getParameter("Customer Address 1");
		String Customer_Address_2= request.getParameter("Customer Address 2");
		String Customer_PinCode= request.getParameter("Customer Pin Code");
		String Email_address= request.getParameter("E-mail address");
		String Contact_Number= request.getParameter("Contact Number");
		String Primary_ContactPerson= request.getParameter("Primary Contact Person");
		String Record_Status= request.getParameter("Record Status");
		String ActiveorInactive_Flag= request.getParameter("Active/Inactive Flag");
		String Create_Date= request.getParameter("Create Date");
		String Created_By= request.getParameter("Created By");
		String Modified_Date= request.getParameter("Modified Date");
		String Modified_By= request.getParameter("Modified by");
		String Authorized_Date= request.getParameter("Authorized Date");
		String Authorized_By= request.getParameter("Authorized by");
		
	
getConnection(Customer_ID,Customer_code, Customer_Name, Customer_Address_1, Customer_Address_2, Customer_PinCode, Email_address, 
		Contact_Number, Primary_ContactPerson, Record_Status, ActiveorInactive_Flag, Create_Date,
		Created_By, Modified_Date,Modified_By, Authorized_Date, Authorized_By);
	}
	public static void getConnection(String Customer_ID, String Customer_code, String Customer_Name,
			String Customer_Address_1, String Customer_Address_2, String Customer_PinCode, String Email_address,
			String Contact_Number, String Primary_ContactPerson, String Record_Status, String ActiveorInactive_Flag,
			String Create_Date, String Created_By, String Modified_Date, String Modified_By, String Authorized_Date,
			String Authorized_By)
	{
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
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
		catch (ClassNotFoundException e) {
			System.out.println(e);
		}
	}

}
