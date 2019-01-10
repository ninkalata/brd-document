package MakerPackage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Newmaker
 */
@WebServlet("/MakerOptions")
public class MakerOption extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("makerAction").equals("NewUser"))
		{
			response.sendRedirect("Newuser.html");
		}
		else if(request.getParameter("makerAction").equals("UploadFile"))
		{
			response.sendRedirect("fileupload.html");
		}
	}

}


