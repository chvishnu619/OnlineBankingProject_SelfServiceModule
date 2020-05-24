package accountPage;

import dbconnect.DBConnection;
import java.util.*;
import java.sql.*;

public class AccountDAO {
	public ArrayList<Account> getAccounts(String username) throws ClassNotFoundException, SQLException
	{
		ArrayList<Account> list=new ArrayList<Account>();
		Connection connection=DBConnection.getConnection();
		Statement stmt=connection.createStatement();
		ResultSet rs=stmt.executeQuery("select * from accounts where username='"+username+"'");
		while(rs.next())
		{
			Account ac=new Account();
			ac.setAccount_number(rs.getString(1));
			ac.setUsername(rs.getString(2));
			ac.setType(rs.getString(3));
			ac.setBalance(rs.getString(4));
			list.add(ac);
		}
		connection.close();
		return list;
	}
}
