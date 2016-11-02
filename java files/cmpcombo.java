import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.sql.*;

public class cmpcombo extends JApplet implements ItemListener
{
	JLabel lbc;
JComboBox cmc;
Container pane;
public void init()
{
	
	pane=getContentPane();
	cmc=new JComboBox();
	pane.setLayout(new FlowLayout());
	cmc.addItem("select company");
	Connection con=null;
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","");
	try{
	//	Statement st=con.createStatement();
		//BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		//System.out.println("enter table name");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("Select company_name from company");
		while(rs.next())
		{
			String cmpn=rs.getString("company_name");
			cmc.addItem(cmpn);
		}
		System.out.println("table insertion successful");
		
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
	lbc=new JLabel("Name of Company");
	
	cmc.addItemListener(this);
	pane.add(lbc);
	pane.add(cmc);
}
public void itemStateChanged(ItemEvent ie)
{
	Object src=ie.getSource();
	if(src==cmc)
	{
		
	}
}
}
