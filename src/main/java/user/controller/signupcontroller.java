package user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;


import javax.servlet.http.HttpServletResponse;
import user.bo.UserBO;
import user.dao.UserDAO;

/**
 * Servlet implementation class signupcontroller
 */
@WebServlet("/signupcontroller")
public class signupcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signupcontroller() {
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
		String pwd = request.getParameter("pwd");
		
		UserBO u=new UserBO();
		u.setName(name);
		u.setEmail(email);
		u.setPhone(phone);
		u.setPassword(pwd);
		
		
		int status = UserDAO.signup(u);
		if(status>0) 
		{
			
			pw.print("<h1 style='color:#4040a1;text-align:center; width: 50%; border: 10px solid #80ced6; background-color:#d5f4e6;  margin: 200px 450px 0 250px; padding: 120px;'>Sign-up successful!!!! Please continue to the Login page</h1>");
			 
			}
		else {
			pw.print("Error while signing up, try again!");
		}
		// TODO Auto-generated method stub
	}

}




























