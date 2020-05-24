package changePass;

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

import dbconnect.DBConnection;
import loginPage.User;

/**
 * Servlet implementation class PasswordSubmit
 */
@WebServlet("/PasswordSubmit")
public class PasswordSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PasswordSubmit() {
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
		String o=request.getParameter("oldpassword");
		String n=request.getParameter("newpassword");
		String r=request.getParameter("reenterpassword");
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		HttpSession session=request.getSession();
		Connection conn = null;
		try {
			conn = DBConnection.getConnection();
			User u=(User)session.getAttribute("customer");
			Statement stmt=conn.createStatement();
			String dbo = null;
			ResultSet rs=stmt.executeQuery("select password from customer where username='"+u.getPassword()+"'");
			while(rs.next())
			{
				dbo=rs.getString(1);
			}
			if(o.equals(dbo))
			{
				if(n.equals(r))
				{
					stmt.executeUpdate("update customer set password='"+n+"' where username='"+u.getUsername()+"'");
				}
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
			
			out.println("<h3>Password changed!<h3>");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			out.println("<h3>Sorry, an error occured.<br>"+e+"</h3>");
			e.printStackTrace();
		} 
		finally
		{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		request.getRequestDispatcher("ChangePassword.jsp").include(request, response);
	}

}
