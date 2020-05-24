package dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBConnection {
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		ResourceBundle rb=ResourceBundle.getBundle("mydb");
		String username=rb.getString("db.username");
		String url=rb.getString("db.url");
		String password=rb.getString("db.password");
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn=DriverManager.getConnection(url,username,password);
		return conn;
	}
}
