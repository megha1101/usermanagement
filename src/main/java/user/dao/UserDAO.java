package user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import user.bo.AddUserBO;
import user.bo.UserBO;

//for connection
public class UserDAO 
{
public static Connection getConnection()
	{  
	Connection con=null;
	    try
	    {  
	        Class.forName("com.mysql.cj.jdbc.Driver");  
	        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/megha","root","megha@1997");    
	    } 
		    catch(Exception e)
		    {
		    	System.out.println(e);
		    }  
		     return con;  
}

//for admin signup
public static int signup(UserBO u) 
{
	int status=0;

	try 
		{
		Connection con = UserDAO.getConnection();
		String sql = "INSERT INTO usersignup(name,email,phone,password) values (?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setNString(1, u.getName());
		ps.setNString(2, u.getEmail());
		ps.setNString(3, u.getPhone());
		ps.setNString(4, u.getPassword());
		status = ps.executeUpdate();
	} 
	catch (SQLException e) 
	{
		e.printStackTrace();
	}
return status;
}


//to login
public static boolean userlogin(String email,String pass)
{
	boolean status=false;
	
	try 
	{
		Connection con=UserDAO.getConnection();
		String sql="select * from usersignup where email=? and password=?";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, email);
		ps.setString(2, pass);
		
		ResultSet rs=ps.executeQuery();
		status=rs.next();
	} 
	
	catch (SQLException e) 
	{
		e.printStackTrace();
	}
return status;
}


//to add user
public static int adduser(AddUserBO au) 
{
	int status=0;

	try {
		Connection con = UserDAO.getConnection();
		String sql = "INSERT INTO adduser(name,email,phone,city,gender,dob) VALUES (?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setNString(1, au.getName());
		ps.setNString(2, au.getEmail());
		ps.setNString(3, au.getPhone());
		ps.setNString(4, au.getCity());
		ps.setNString(5, au.getGender());
		ps.setNString(6, au.getDob());
		
		status = ps.executeUpdate();
	} 
	catch (SQLException e)
	{
		e.printStackTrace();
	}
return status;
}




//view all users
public static List getallusers()
{  
	 List<AddUserBO> list=new ArrayList<AddUserBO>(); 
	try {
	
        Connection con=UserDAO.getConnection();  
        PreparedStatement ps=con.prepareStatement("select * from adduser");  
        ResultSet rs=ps.executeQuery();  
        while(rs.next()){  
            AddUserBO au=new AddUserBO();  
            au.setId(rs.getInt(1));
            au.setName(rs.getString(2));  
            au.setEmail(rs.getString(3));
            au.setPhone(rs.getString(4));
            au.setCity(rs.getString(5));
            au.setGender(rs.getString(6));
            au.setDob(rs.getString(7));
   
            list.add(au);  
        }  
       
	}
	catch(Exception e)
	{
	}
	
    return list;  
	}



//=============Editing by id==================	

public static AddUserBO getuserbyid(int id) 
{
	AddUserBO au=new AddUserBO();
	try{  
	      Connection con=UserDAO.getConnection();  
	      PreparedStatement ps=con.prepareStatement("select * from adduser where id=?");  
	      ps.setInt(1,id);  
	      ResultSet rs=ps.executeQuery();  
	      if(rs.next()){  
	          au.setId(rs.getInt(1));  
	          au.setName(rs.getString(2));  
	          au.setEmail(rs.getString(3));  
	          au.setPhone(rs.getString(4));  
	          au.setCity(rs.getString(5)); 
	          au.setGender(rs.getString(6));
	          au.setDob(rs.getString(7));
	      }  
	      con.close();  
	  }
	catch(Exception ex)
	{
		ex.printStackTrace();
	 }  
	  return au;  
}


//------------updating record----------

public static int update(AddUserBO au){  
int status=0;  
try{  
  Connection con=UserDAO.getConnection();  
  PreparedStatement ps=con.prepareStatement(  
               "update adduser set name=?,email=?,phone=?,city=?,gender=?,dob=? where id=?");  
  
  ps.setString(1,au.getName());    
  ps.setString(2,au.getEmail()); 
  ps.setString(3,au.getPhone());  
  ps.setString(4,au.getCity()); 
  ps.setString(5,au.getGender());  
  ps.setString(6,au.getDob()); 
  ps.setInt(7,au.getId());  

  status=ps.executeUpdate();  
    
  con.close();  
}
catch(Exception ex)
{
	ex.printStackTrace();
}  

return status;  
}


//==============  Deleting The Record ============================  
public static int delete(int id){  
  int status=0;  
  try{  
      Connection con=UserDAO.getConnection();  
      PreparedStatement ps=con.prepareStatement("delete from adduser where id=?");  
      ps.setInt(1,id);  
      status=ps.executeUpdate();  
        
      con.close();  
  }
  catch(Exception e)
  {
	  e.printStackTrace();
  }  
    
  return status;  
}






}