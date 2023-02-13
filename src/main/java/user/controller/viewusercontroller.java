package user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import user.bo.AddUserBO;
import user.dao.UserDAO;

/**
 * Servlet implementation class viewusercontroller
 */
@WebServlet("/viewusercontroller")
public class viewusercontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewusercontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		 pw.println("<a href='homepage.html'>Back</a>");  
	        pw.println("<h1>User List</h1>");  
	          
	        List<AddUserBO> list=UserDAO.getallusers();  
	          
	        pw.print("<link rel='stylesheet' href='css/table.css'>");
	        
	        pw.print("<table border='1px solid dark' width='100%'");  
	        pw.print("<tr><th>Id</th><th>Name</th><th>Email</th><th>Phone-No</th><th>City</th>  <th>Gender</th><th>DOD</th><th>Edit</th><th>Delete</th></tr>");  
	        
	        for(AddUserBO au:list)
	        {  
	         pw.print("<tr><td>"+au.getId()+"</td><td>"+au.getName()+"</td><td>"+au.getEmail()+"</td><td>"+au.getPhone()+"</td><td>"+au.getCity()+"</td><td>"+au.getGender()+"</td><td>"+au.getDob()+"</td><td><a href='edirusercontrol?id="+au.getId()+"'>edit</a></td>   <td><a href='deleteusercontrol?id="+au.getId()+"'>delete</a></td></tr>");  
	        }  
	        
	        pw.print("</table>");        
	        pw.close();  	
	}
}
