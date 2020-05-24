package loginPage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import dbconnect.DBConnection;

public class UserDAO {
	public ArrayList<User> getUserList() throws ClassNotFoundException, SQLException
	{
		Connection conn=DBConnection.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet resultSet=stmt.executeQuery("select * from customer");
		//	private String username,password,name,dob,phoneno,
		//address,city,pincode,country,panno,email;
		ArrayList<User> userList=new ArrayList<User>();
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
			userList.add(user);
		}
		conn.close();
		return userList;
	}
}
