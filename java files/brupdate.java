import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.sql.*;

public class brupdate extends JPanel implements ItemListener,ActionListener
{
	String brnch;
JComboBox brb;
JButton bru,brd;
JTextField txn,txs;
JLabel lbn,lbs,lbp,lbb;
Container pane;
JPanel p1,p2,p3,p,p0;
public brupdate()
{
	//pane=getContentPane();
	setLayout(new GridLayout(5,2));
	bru=new JButton("Update data");
	brd=new JButton("Delete data");
	brb=new JComboBox();
	brb.addItemListener(this);
	bru.addActionListener(this);
	brd.addActionListener(this);
	
	brb.addItem("Select a Branch");
	setBorder(BorderFactory.createEtchedBorder());
	Connection con=null;
	try{
		
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","");
		try
		{
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select brh_name from brtable");
		while(rs.next())
		{
			String name=rs.getString("brh_name");
			brb.addItem(name);
		}
		}
		catch(SQLException s)
		{
			System.out.println(s);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	
	
	lbp=new JLabel(new ImageIcon("updbr.gif"));
	lbp.setBorder(BorderFactory.createRaisedBevelBorder());
	lbn=new JLabel("Name of Branch");
	txn=new JTextField(25);
	lbs=new JLabel("Short name");
	txs=new JTextField(25);
	lbb=new JLabel("NAME OF BRANCH:");
	p1=new JPanel();
	p2=new JPanel();
	p3=new JPanel();
	p=new JPanel();
	p0=new JPanel();
	//JPanel p4=new JPanel();
	p0.add(lbp);
	p.add(lbb);
	p.add(brb);
	p1.add(lbn);
	p1.add(txn);
	p2.add(lbs);
	p2.add(txs);
	p3.add(bru);
	p3.add(brd);
	
	add(p0);
	add(p);
	add(p1);
	add(p2);
	add(p3);
}
public void itemStateChanged(ItemEvent ie)
{
	Object src=ie.getSource();
	if(src==brb)
	{
		brnch=(String) brb.getSelectedItem();
		if(brb.getSelectedIndex()!=0)
		{
			try{
			Connection con=null;
			Class.forName("com.mysql.jdbc.Driver");
			try
			{
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","");
				PreparedStatement pstmt=con.prepareStatement("select * from brtable where brh_name=?");
				pstmt.setString(1, brnch);
				ResultSet rs=pstmt.executeQuery();
				while(rs.next())
				{
					String nm=rs.getString("brh_name");
					String snm=rs.getString("brh_shortname");
					txn.setText(nm);
					txs.setText(snm);
				}
			}
			catch(SQLException  s)
			{
				System.out.println(s);
			}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
public void actionPerformed(ActionEvent ae)
{
Object src=ae.getSource();
brnch=(String) brb.getSelectedItem();
if(src==bru)
{
	if(txn.getText().equals(""))
		JOptionPane.showMessageDialog(null, "Select a Branch");
	else
	{
	try{
	Connection con=null;
	Class.forName("com.mysql.jdbc.Driver");
	try
	{
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","");
		PreparedStatement pstmt=con.prepareStatement("Update brtable set brh_name=?,brh_shortname=? where brh_name=?");
			String nm=txn.getText();
			String snm=txs.getText();
			pstmt.setString(1, nm);
			pstmt.setString(2, snm);
			pstmt.setString(3, brnch);
			pstmt.executeUpdate();
			System.out.println("updated successfully!!");
			System.exit(-1);
	}
		catch(SQLException s)
		{
			System.out.println(s);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}
}
if(src==brd)
{
	if(txn.getText().equals(""))
		JOptionPane.showMessageDialog(null, "Select a Company");
	else
	{
	Connection con=null;
	try
	{	
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","");
	try{

	PreparedStatement pstmt=con.prepareStatement("delete from brtable where brh_name=?");
	String nm=txn.getText();
	
	pstmt.setString(1, nm);
	pstmt.executeUpdate();
	System.out.println("deleted successfully!!");
	System.exit(-1);
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
	
}

}
			


