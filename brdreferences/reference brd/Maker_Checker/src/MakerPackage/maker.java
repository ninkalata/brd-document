package MakerPackage;

import brd.filehandling.*;

import java.io.IOException;
import java.io.InputStream;

import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/NewFileUpload")
//to handle multipart/form-data requests and configure various upload settings.
@MultipartConfig
public class maker extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
	
		Part filePart = request.getPart("file");
		String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); 

		InputStream fileContent = filePart.getInputStream();
//		Gets the content of this part as an InputStream
//		BufferedReader reader = new BufferedReader(new InputStreamReader(fileContent));
		String Selector = request.getParameter("RejectionControl");
//		System.out.println(reader.readLine());
try {
	if(Selector.equals("record"))
	{
			ReadFromFile.mains(fileContent, fileName);
			System.out.println("Record Level");
	}
else
{
	FileLevelRejection.mains(fileContent, fileName);
	System.out.println("File Level");
}
}
catch (Exception exception) {
		
		System.out.println(exception);
	}
	}
}
