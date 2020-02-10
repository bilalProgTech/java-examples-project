package code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect 
{
	public static String dbFacultyProject = "addprojectbyfaculty";
	public static String dbStudentProject = "addprojectbystudent";
	public static String dbFacultyInfo = "faculty";
	public static String dbStudentInfo = "student";
	public static String dbQuery = "query";
	public static String dbReservationOfProject = "reservation";
	
	public static Connection initializeDatabase() throws SQLException, ClassNotFoundException
	{
		String dbDriver = "com.mysql.jdbc.Driver";
		String dbURL = "jdbc:mysql://localhost:3306/";
		String dbName = "ProjectMgmt";
		String dbUsername = "root";
		String dbPassword = "root";
		
		Class.forName(dbDriver);
		Connection con = DriverManager.getConnection(dbURL+dbName,dbUsername,dbPassword);
		return con;
	}
	
}
