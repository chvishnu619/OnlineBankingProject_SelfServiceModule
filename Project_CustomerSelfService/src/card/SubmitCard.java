package card;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbconnect.DBConnection;

/**
 * Servlet implementation class SubmitCard
 */
@WebServlet("/SubmitCard")
public class SubmitCard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitCard() {
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
		String sdate=(request.getParameter("stolendate"));
		String username=request.getParameter("username");
		String detail="Stolen/Lost card request for account "+acc+" on "+sdate;
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		Connection conn=null;
		Calendar c=Calendar.getInstance();
		Integer td=c.get(Calendar.DAY_OF_MONTH);
		String tm=c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
		Integer ty=c.get(Calendar.YEAR);
		String date=(td+"-"+tm.substring(0,3)+"-"+ty);
//		System.out.println("username is "+username);
//		System.out.println("detail is "+detail);

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
			//System.out.println("insert into customer_service_request(request_date,csr_type,detail,username,request_id) values"
			//		+ "('"+date+"' , 3 , '"+detail+"' , '"+username+"' ,"+r+" )");
			stmt.executeUpdate("insert into customer_service_request(request_date,csr_type,detail,username,request_id) values"
					+ "('"+date+"' , 3 , '"+detail+"' , '"+username+"' ,"+r+" )");
			//System.out.println("insert into stolen_card_requests values('"+acc+"' ,"+r+", '"+date+"')");
			stmt.executeUpdate("insert into stolen_card_requests values('"+acc+"' ,"+r+", '"+sdate+"')");
			out.println("<h3>Request placed!</h3>");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			out.println("<h3>Error occurred </h3>"+e);
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
		RequestDispatcher rs=request.getRequestDispatcher("/Card.jsp");
		rs.include(request, response);
	}

}
