package accountStatement;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

import dbconnect.DBConnection;

public class TransactionDAO {
	public ArrayList<Transaction> getTransactions(String acc) throws ClassNotFoundException, SQLException
	{
		Connection conn=DBConnection.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("select * from transactions where acc_number='"+acc+"'");
		ArrayList<Transaction> list=new ArrayList<Transaction>();
		while(rs.next())
		{
			Transaction t=new Transaction();
			t.setAcc_number(rs.getString(1));
			t.setTransaction_date((String)(new SimpleDateFormat("dd-MMM-yyyy").format(rs.getDate(2))));
			t.setDescription(rs.getString(3));
			t.setAmount(rs.getInt(4));
			t.setBalance(rs.getInt(5));
			list.add(t);
		}
		return list;
	}
}
