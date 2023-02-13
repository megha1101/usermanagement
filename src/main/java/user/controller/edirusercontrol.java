package user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.bo.AddUserBO;
import user.dao.UserDAO;

/**
 * Servlet implementation class edirusercontrol
 */
@WebServlet("/edirusercontrol")
public class edirusercontrol extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public edirusercontrol() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 response.setContentType("text/html");  
	        PrintWriter pw=response.getWriter();  
	        pw.println("<h1>Update User</h1>");  
	        String sid=request.getParameter("id");  
	        int id=Integer.parseInt(sid);  
	          
	        AddUserBO e=UserDAO.getuserbyid(id);  
	        
	        pw.print("<link rel='stylesheet' href='css/table.css'>");
	        
	        pw.print("<form action='editcontroller2' method='get'>");  
	        pw.print("<table>");  
	        pw.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");  
	        pw.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+e.getName()+"'/></td></tr>"); 
	        pw.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+e.getEmail()+"'/></td></tr>"); 
	        pw.print("<tr><td>Phone:</td><td><input type='text' name='phone' value='"+e.getPhone()+"'/>  </td></tr>");  
	        pw.print("<tr><td>City:</td><td><input type='text' name='city' value='"+e.getCity()+"'/></td></tr>"); 
	        pw.print("<tr><td>Gender:</td><td><input type='text' name='gender' value='"+e.getGender()+"'/></td></tr>"); 
	        pw.print("<tr><td>Dob:</td><td><input type='text' name='dob' value='"+e.getDob()+"'/></td></tr>"); 
	        pw.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
	        pw.print("</table>");  
	        pw.print("</form>");  
	          
	        pw.close();  
	    }  
	 	
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

}
