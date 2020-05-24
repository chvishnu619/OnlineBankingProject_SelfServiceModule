package requestDetails;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbconnect.DBConnection;

/**
 * Servlet implementation class RequestFetch
 */
@WebServlet("/RequestFetch")
public class RequestFetch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestFetch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int rid=Integer.parseInt(request.getParameter("r_id"));
		int r=0;
		Connection connection=null;
		Statement stmt=null;
		ResultSet rs=null;
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		try {
			connection=DBConnection.getConnection();
			stmt=connection.createStatement();
			rs=stmt.executeQuery("select csr_type from customer_service_request where request_id="+rid);
			HttpSession session=request.getSession();
			while(rs.next())
			{
				r=rs.getInt(1);
			}
			if(r==1)
			{
				rs=stmt.executeQuery("select * from cheque_requests where request_id="+rid);
				String acc=null;
				int leaves=0;
				while(rs.next())
				{
				acc=rs.getString(1);
				leaves=rs.getInt(3);
				}
				session.setAttribute("rview",("<table border=1>"
						+ "<tr><b><td>Request ID</b></td><td><b>Account Number</b></td><td><b>No. of Leaves</b></td></tr>"
						+ "<tr><td>"+rid+"</td><td>"+acc+"</td><td>"+leaves+"</td></tr>"
						+ "</table>"));
			}
			else if(r==3)
			{
				rs=stmt.executeQuery("select * from stolen_card_requests where request_id="+rid);
				String acc="",date="";
				while(rs.next())
				{
				 acc=rs.getString(1);
				 date=(String)(new SimpleDateFormat("dd-MMM-yyyy").format(rs.getDate(3)));
				}
				session.setAttribute("rview",("<table border=1>"
						+ "<tr><b><td>Request ID</b></td><td><b>Account Number</b></td><td><b>Stolen/Lost Date</b></td></tr>"
						+ "<tr><td>"+rid+"</td><td>"+acc+"</td><td>"+date+"</td></tr>"
						+ "</table>"));
			}
			else if(r==7)
			{
				rs=stmt.executeQuery("select * from query_requests where request_id="+rid);
				String content=null;
				while(rs.next())
				{
				 content=rs.getString(2);
				}
				session.setAttribute("rview",("<table border=1>"
						+ "<tr><b><td>Request ID</b></td><td><b>Query</b></td></tr>"
						+ "<tr><td>"+rid+"</td><td>"+content+"</td></tr>"
						+ "</table>"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			out.println("Error Occurred. Sorry.\n"+e);
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
		RequestDispatcher rd=request.getRequestDispatcher("/FinalRequestStatus.jsp");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
