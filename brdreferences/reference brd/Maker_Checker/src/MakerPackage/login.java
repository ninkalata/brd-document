package MakerPackage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login
 */
@WebServlet("/Login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String UserNameValue= request.getParameter("user");
	String PasswordValue= request.getParameter("password");
	String authorityValue = request.getParameter("authority");
System.out.println(UserNameValue + PasswordValue + authorityValue);
//response.sendRedirect("makerPage.html");
//System.out.println("hai");
//	databaseConnection.validateLogin(UserNameValue, PasswordValue);
//	if(databaseConnection.validateLogin(UserNameValue, PasswordValue)== true)
//	{
//
//response.sendRedirect("makerPage.html");
//System.out.println("hai");
//	}
//	else if(databaseConnection.validateLogin(UserNameValue, PasswordValue) ==false)
//	{
//	
//
//		response.sendRedirect("login.html");
//		System.out.println("bye");
//	}
	
	
	databaseConnection.validateLogin(UserNameValue, PasswordValue,authorityValue);
	if(databaseConnection.validateLogin(UserNameValue, PasswordValue,authorityValue)== true)
	{
response.sendRedirect("makerPage.html");
System.out.println("hai");
	}
	else if(databaseConnection.validateLogin(UserNameValue, PasswordValue,authorityValue) ==false)
	{
		response.sendRedirect("login.html");
		System.out.println("bye");
	}
	

	}
}
