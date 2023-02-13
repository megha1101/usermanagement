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
 * Servlet implementation class editcontroller2
 */
@WebServlet("/editcontroller2")
public class editcontroller2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editcontroller2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

        response.setContentType("text/html");  
        PrintWriter pw=response.getWriter();  
          
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        String name=request.getParameter("name");  
        String email=request.getParameter("email");  
        String phone=request.getParameter("phone");  
        String city=request.getParameter("city");  
        String gender=request.getParameter("gender");  
        String dob=request.getParameter("dob");  
          
        AddUserBO e=new AddUserBO();  
        e.setId(id);  
        e.setName(name); 
        e.setEmail(email); 
        e.setPhone(phone);
        e.setCity(city);
        e.setGender(gender);
        e.setDob(dob);
          
        int status=UserDAO.update(e);  
        if(status>0)
        {  
        	RequestDispatcher rd = request.getRequestDispatcher("viewusercontroller");
			rd.forward(request, response); 
        }
       
		
	}

}
