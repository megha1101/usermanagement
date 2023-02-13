package user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dao.UserDAO;

/**
 * Servlet implementation class deleteusercontrol
 */
@WebServlet("/deleteusercontrol")
public class deleteusercontrol extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteusercontrol() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{  
        response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		int id = Integer.parseInt(request.getParameter("id"));

		int status = UserDAO.delete(id);  
		if(status>0)
		{
			RequestDispatcher rd = request.getRequestDispatcher("viewusercontroller");
			rd.forward(request, response);
		}
		else {
			pw.write("Record not deleted");
			RequestDispatcher rd = request.getRequestDispatcher("viewusercontroller");
			rd.include(request, response);
		}
        
        
        
        
        
        
	}
		
		
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

}
