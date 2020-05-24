package myProfileData;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbconnect.*;
import loginPage.User;

/**
 * Servlet implementation class MyProfileSubmit
 */
@WebServlet("/MyProfileSubmit")
public class MyProfileSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyProfileSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String address= request.getParameter("addressupdate");
		String city= request.getParameter("cityupdate");
		String pincode= request.getParameter("pincodeupdate");
		String country= request.getParameter("countryupdate");
		String email;
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		User u=(User)session.getAttribute("customer");
		try
		{
			email= request.getParameter("emailupdate");
		}
		catch(Exception ne)
		{
			email= "false";
		}
		Connection connection=null;
//		RequestDispatcher rd=request.getRequestDispatcher("/MyProfileSubmit2");
//		rd.forward(request, response);
		try {
			connection=DBConnection.getConnection();
			Statement stmt=connection.createStatement();
			if(email.equals("false"))
			{
				stmt.executeUpdate("update customer set address='"+address+"' ,city='"+city
						+ "' ,pincode='"+pincode+"' ,country='"+country+"' where username='"+u.getUsername()+"'");
			}
			else
			{
			stmt.executeUpdate("update customer set address='"+address+"' ,city='"+city
					+ "' ,pincode='"+pincode+"' ,country='"+country+"' ,email='"+email+"' where username='"+u.getUsername()+"'");
			}
			ResultSet resultSet=stmt.executeQuery("select * from customer where username='"+u.getUsername()+"'");
			while(resultSet.next())
			{
			User user=new User();
			user.setUsername(resultSet.getString(1));
			user.setPassword(resultSet.getString(2));
			user.setName(resultSet.getString(3));
			user.setDob((String)(new SimpleDateFormat("dd-MMM-yyyy").format(resultSet.getDate(4))));
			user.setPhoneno(resultSet.getString(5));
			user.setAddress(resultSet.getString(6));
			user.setCity(resultSet.getString(7));
			user.setPincode(resultSet.getString(8));
			user.setCountry(resultSet.getString(9));
			user.setPanno(resultSet.getString(10));
			user.setEmail(resultSet.getString(11));
			session.setAttribute("customer", user);
			}
			out.println("Updated Successfully!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			out.println("Sorry, an error occured.<br>"+e);
		}
		finally
		{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		request.getRequestDispatcher("MyProfile.jsp").include(request, response);
	}

}
