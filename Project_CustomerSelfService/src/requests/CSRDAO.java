package requests;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dbconnect.DBConnection;

public class CSRDAO {
	public ArrayList<CSR> getRequests(int type,String username) throws ClassNotFoundException, SQLException
	{
		ArrayList<CSR> list=new ArrayList<CSR>();
		Connection connection=DBConnection.getConnection();
		Statement stmt=connection.createStatement();
		ResultSet rs=null;
		if(type!=0)
		{
			rs=stmt.executeQuery("select * from customer_service_request where username='"+username+"' and csr_type="+type+" order by request_date desc");
		}
		else
		{
			rs=stmt.executeQuery("select * from customer_service_request where username='"+username+"' order by request_date desc");
		}
		while(rs.next())
		{
			CSR ac=new CSR();
			ac.setRequest_date(rs.getDate(1));
			ac.setType(rs.getInt(2));
			ac.setDetail(rs.getString(3));
			ac.setResponse(rs.getString(4));
			ac.setStatus(rs.getString(5));
			ac.setUsername(rs.getString(6));
			ac.setRequest_id(rs.getInt(7));
			list.add(ac);
		}
		connection.close();
		return list;
	}
}
