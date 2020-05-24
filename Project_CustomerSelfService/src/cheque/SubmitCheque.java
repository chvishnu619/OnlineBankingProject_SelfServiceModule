package cheque;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dbconnect.DBConnection;
import java.sql.*;
import java.util.Calendar;
import java.util.Locale;

/**
 * Servlet implementation class SubmitCheque
 */
@WebServlet("/SubmitCheque")
public class SubmitCheque extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitCheque() {
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
		String acc=(String)request.getParameter("accountnumber");
		Integer leaves=Integer.parseInt(request.getParameter("leaves"));
		String username=request.getParameter("username");
		//System.out.println("username is "+username);
		String detail="Cheque book request for account "+acc+" of "+leaves.toString()+" leaves";
		//System.out.println("detail is "+detail);
		PrintWriter out=response.getWriter();
		Connection conn=null;
		Calendar c=Calendar.getInstance();
		Integer td=c.get(Calendar.DAY_OF_MONTH);
		String tm=c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
		Integer ty=c.get(Calendar.YEAR);
		String date=(td+"-"+tm.substring(0,3)+"-"+ty);
		try {
			conn=DBConnection.getConnection();
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select count(*)+1 from customer_service_request");
			Long r_id = null;
			while(rs.next())
			{
				r_id=(rs.getLong(1));
				//System.out.println("r id is "+r_id.toString());
			}
			int r=Integer.parseInt(r_id.toString());
			stmt.executeUpdate("insert into customer_service_request(request_date,csr_type,detail,username,request_id) values"
					+ "('"+date+"' , 1 , '"+detail+"' , '"+username+"' ,"+r+" )");
			stmt.executeUpdate("insert into cheque_requests values('"+acc+"' ,"+r+","+leaves+")");
			out.println("Request placed!");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			out.println("Error occurred "+e);
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
		RequestDispatcher rs=request.getRequestDispatcher("/ChequeBook.jsp");
		rs.include(request, response);
	}

}
