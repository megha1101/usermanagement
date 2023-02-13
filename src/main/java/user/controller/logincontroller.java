package user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import user.bo.UserBO;
import user.dao.UserDAO;

/**
 * Servlet implementation class logincontroller
 */
@WebServlet("/logincontroller")
public class logincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logincontroller() {
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
		
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");

		if(UserDAO.userlogin(email, pass)) 
		{
			pw.print("You have successfully logged in");
		RequestDispatcher rd = request.getRequestDispatcher("homepage.html");
		rd.forward(request, response);
		}
		else 
		{
		pw.print("Login not successful");
		RequestDispatcher rd = request.getRequestDispatcher("login.html");
		rd.include(request, response);
		}
}

}