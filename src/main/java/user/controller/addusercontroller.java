package user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import user.bo.AddUserBO;
import user.dao.UserDAO;

/**
 * Servlet implementation class addusercontroller
 */
@WebServlet("/addusercontroller")
public class addusercontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addusercontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String city = request.getParameter("city");
		String gender = request.getParameter("gender");
		String dob = request.getParameter("dob");

		AddUserBO au = new AddUserBO(name,email, phone,city,gender,dob);

		int status = UserDAO.adduser(au);
		if(status>0) 
		{
			pw.print("You have successfully added user");
			RequestDispatcher rd = request.getRequestDispatcher("viewusercontroller");
			rd.forward(request, response);
			}
			else 
			{
			pw.print("Adding user not successful");
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.include(request, response);
			}
	}
}
