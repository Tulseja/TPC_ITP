import java.io.*; 
import java.sql.*;

public class Database 
{
public static void main(String [] args)
{
	System.out.println("database creation example!");
	Connection con=null;
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","");
	try{
		Statement st=con.createStatement();
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter database name");
		String database=bf.readLine();
		st.executeUpdate("CREATE DATABASE " +database);
		System.out.println("1 row(s) affected");
		}
	catch(SQLException s)
	{
		System.out.println(s);
	}
	}
	catch(Exception E)
	{
		E.printStackTrace();
	}
}
}
