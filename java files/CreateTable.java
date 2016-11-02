import java.io.*;
import java.sql.*;

public class CreateTable
{
public static void main(String [] args)
{
	System.out.println("Table creation example!");
	Connection con=null;
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","");
	try{
		Statement st=con.createStatement();
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		//System.out.println("enter table name");
		String table="CREATE TABLE if not exists company (company_name Varchar(40),company_city Varchar(40),company_address Varchar(40),company_type Varchar(255),company_helpline integer)";
		st.executeUpdate(table);
		System.out.println("table ceation successful");
		
		}
	catch(SQLException s)
	{
		System.out.println("not executed");
	}
	}
	catch(Exception E)
	{
		E.printStackTrace();
	}
}
}

