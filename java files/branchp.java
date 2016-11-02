import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.sql.*;

public class branchp extends JPanel implements ActionListener
{
	JTextField txn,txs;
	JLabel lbn,lbs,lbp;
	
	JPanel p1,p2,p3;
	JButton bts,btc;
	public branchp()
	{
		p3=new JPanel();
	//	pane=getContentPane();
		setLayout(new GridLayout(4,2));
		
		bts=new JButton("Submit");
		btc=new JButton("Cancel");
		bts.addActionListener(this);
		btc.addActionListener(this);
		lbp=new JLabel(new ImageIcon("brnch.gif"));
		lbp.setBorder(BorderFactory.createRaisedBevelBorder());
		lbn=new JLabel("Name of Branch");
		txn=new JTextField(25);
		lbs=new JLabel("Short name");
		txs=new JTextField(25);
		p1=new JPanel();
		p2=new JPanel();
		JPanel p4=new JPanel();
		p3.add(lbp);
		p1.add(lbn);
		p1.add(txn);
		p2.add(lbs);
		p2.add(txs);
		p4.add(bts);
		p4.add(btc);
		//setBorder(BorderFactory.createEtchedBorder());	
		add(p3);
		add(p1);
		add(p2);
		add(p4);
	}
public void actionPerformed(ActionEvent ae)
{
	Object src=ae.getSource();
	if(src==bts)
	{
		if(txn.getText().equals(""))
			JOptionPane.showMessageDialog(null, "Fill Branch name!!");
		else if(txs.getText().equals(""))
			JOptionPane.showMessageDialog(null, "Fill Branch Short name!!");
		else
		{
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","");
			try
			{
				Statement st=con.createStatement();
				String table="CREATE TABLE if not exists brtable(brh_name Varchar(40),brh_shortname Varchar(10))";
				st.executeUpdate(table);
				System.out.print("table created");
				String jhg="Insert into brtable values(?,?)";
				PreparedStatement pstmt=con.prepareStatement(jhg);
				String nm=txn.getText();
				String snm=txs.getText();
				pstmt.setString(1, nm);
				pstmt.setString(2, snm);
				pstmt.executeUpdate();
				System.out.println("insertion successfull");
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
else 
	if(src==btc)
{
	projecto.jtp.setSelectedIndex(0);
}
	
}
}
