import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.sql.*;

public class applyform extends JPanel implements ItemListener,ActionListener 
{
	JLabel lbp,lbc,lbb,lbr,lbci,lbco;
 JButton bts,btc,btlog;
JTextField txn,txb,txr; 
 JComboBox jcb,jcc,jcci;
  public applyform()
 {
	 	 setLayout(new GridLayout(7,2));
	 lbp=new JLabel(new ImageIcon("aform.gif"));
	 lbc=new JLabel("Candidate Name:");
	 lbb=new JLabel("Branch:");
	 jcb=new JComboBox();
	 jcb.addItem("Select Branch");
	 lbp.setPreferredSize(new Dimension(220,50));
	 lbp.setBorder(BorderFactory.createRaisedBevelBorder());
	 Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","");
			try{
				
			
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("Select brh_name from brtable");
					while(rs.next())
			{
				String brh=rs.getString("brh_name");
				jcb.addItem(brh);
			}
			System.out.println("branch insertion successful");
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
	 jcb.addItemListener(this);	
	 
	btlog=new JButton("Logout");
	btlog.setMnemonic(KeyEvent.VK_A);
	btlog.addActionListener(this);
	txn=new JTextField(10);
	 lbco=new JLabel("Company:");
	 lbci=new JLabel("City:");
	 jcc=new JComboBox();
	 jcc.addItem("Select a Company");
	 jcc.addItemListener(this);
	 jcci=new JComboBox();
	 jcci.addItem("Select city");
	 
	/*	try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","");
		try{
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("Select company_name from company where company_type like '%Computer Science & Engineering%'");
			while(rs.next())
			{
				String cmpn=rs.getString("company_name");
				jcc.addItem(cmpn);
			}
			System.out.println("table insertion successful");
			
			}
		catch(SQLException s)
		{
			System.out.println(s);
		}
		}
		catch(Exception E)
		{
			E.printStackTrace();
		}*/
		
	 
	 bts=new JButton("Apply");
	 btc=new JButton("Cancel");
	 bts.addActionListener(this);
	 btc.addActionListener(this);
	 JPanel p1=new JPanel();
	 JPanel p2=new JPanel();
	 JPanel p3=new JPanel();
	 JPanel p4=new JPanel();
	 JPanel p5=new JPanel();
	 JPanel p6=new JPanel();
	 JPanel p7=new JPanel();
	 p1.add(lbp);
	 p2.add(lbc);
	 p2.add(txn);
	 p3.add(lbb);
	 p3.add(jcb);
	 p4.add(lbco);
	 p4.add(jcc);
	 p5.add(lbci);
	 p5.add(jcci);	 
	 p6.add(bts);
	 p6.add(btc);
	 p7.add(btlog);
	 btlog.setBorderPainted(false);
	 add(p1);
	 add(p2);
	 add(p3);
	 add(p4);
	 add(p5);
	 add(p6);
	 add(p7);
 }
 public void itemStateChanged(ItemEvent ie)
 {
	 Object src=ie.getSource();
		if(ie.getStateChange()==ItemEvent.SELECTED)
		{
		if(src==jcb)
		{
			String brh=(String)jcb.getSelectedItem();
			if(jcc.getItemCount()>1)
				{
				jcc.removeAllItems();
				jcc.addItem("Select Company");
				}
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","");
		try{
			PreparedStatement st=con.prepareStatement("Select company_name,company_type from company");// where company_type like '%brh%'");
			ResultSet rs=st.executeQuery();
			//String ctype=rs.getString("company_type");
			//st.setString(1, brh);
			while(rs.next())
			{
				String type=rs.getString("company_type");
				if(type.contains(brh))
				{
				String cmpn=rs.getString("company_name");
				jcc.addItem(cmpn);
				}
			
			}
			System.out.println("table insertion successful");
			
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

		}//end of jcb
		}//end of selected
		if(ie.getStateChange()==ItemEvent.SELECTED)
		{
		if(src==jcc)
		{
			if(jcci.getItemCount()>1)
			{
				jcci.removeAllItems();
				jcci.addItem("Select City");
			}
			String cmpn=(String) jcc.getSelectedItem();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
	Connection		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","");
		try{
			PreparedStatement st=con.prepareStatement("Select company_city from company where company_name =?");
			st.setString(1, cmpn);
			ResultSet rs=st.executeQuery();
		
			while(rs.next())
			{
				String city=rs.getString("company_city");
				
				jcci.addItem(city);
				}
			//	JOptionshowMessageDialog(null, rs.getInt(1));
			
			System.out.println("table insertion successful");
			
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

		}//end of jcb
		}//end of selected

 }
 public void actionPerformed(ActionEvent ae)
 {
	 Object src=ae.getSource();
	 if(src==bts)
	 {
		
		 try
			{
			 Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","");
			
			try{
				//BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
				//System.out.println("enter table name")
				Statement st=con.createStatement();
				String table="CREATE TABLE if not exists aptable(company_name Varchar(40),company_city Varchar(40),stu_name Varchar(40),stu_branch varchar(40))";
				st.executeUpdate(table);
				System.out.println("table creation successful");
				String nm=(String) jcc.getSelectedItem();
				String city=(String) jcci.getSelectedItem();
				String snm=txn.getText();
				String stbrnch=(String) jcb.getSelectedItem();
				String ins_sql="Insert into aptable values(?,?,?,?)";
				PreparedStatement pstmt=con.prepareStatement(ins_sql);
				pstmt.setString(1, nm);
				pstmt.setString(2, city);
				pstmt.setString(3,snm);
				pstmt.setString(4, stbrnch);
				pstmt.executeUpdate();
				System.out.println("table insertion successful");
				System.exit(-1);
				validate();
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
	 if(src==btc)
	 {
		 projecto.jtp.setSelectedIndex(0);
	 }
	 if(src==btlog)
	 {
		 projecto.status2=false;
		 projecto.jtp.setSelectedIndex(0);
		 projecto.jtp.setEnabledAt(3, false);
		 stusign.txu.setText("");
		 stusign.lbpa.setText("");
		 stusign.lbmsg.setText("");
	 }
 }
}
