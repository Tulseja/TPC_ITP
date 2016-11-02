import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class stuque extends JPanel implements ActionListener,ItemListener
{
	JComboBox jcb,jcs;
JButton btbck;
JLabel lbb,lbs,lbc,lbci,lbp,lbmsg;
JTextField txc,txci;
JPanel p1,p2,p3,p4,p5,p6;
public stuque()
{
	
	jcb=new JComboBox();
	jcs=new JComboBox();
	jcb.addItem("Select Branch");
	jcb.addItemListener(this);
	jcs.addItem("Select a Student");
	
	txc=new JTextField(15);
	txci=new JTextField(15);
	lbp=new JLabel(new ImageIcon("bque.gif"));
	lbp.setPreferredSize(new Dimension(350,60));
	lbp.setBorder(BorderFactory.createRaisedBevelBorder());
	lbb=new JLabel("Select a Branch");
	btbck=new JButton("Back");
		lbs=new JLabel("Name of Student:");
	lbc=new JLabel("Company:");
	lbci=new JLabel("City:");
	setLayout(new GridLayout(6,1));
	p1=new JPanel();
	p2=new JPanel();
	p3=new JPanel();
	p4=new JPanel();
	p5=new JPanel();
	p6=new JPanel();
	jcs.addItemListener(this);
	p1.add(lbp);
	p2.add(lbb);
	p2.add(jcb);
	p3.add(lbs);
	p3.add(jcs);
	p4.add(lbc);
	p4.add(txc);
	p5.add(lbci);
	p5.add(txci);
	p6.add(btbck);
	
	btbck.addActionListener(this);
		lbmsg=new JLabel("no student in this branch");
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
	/*	try{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","");
		try{
			PreparedStatement pstmt=con.prepareStatement("select count(*)stu_name from sttable where stu_name=? type like brh_name");
			ResultSet rs=pstmt.executeQuery();
			int c=0;
			String stu;
			while(rs.next())
			{
				c=rs.getInt(1);
				stu=rs.getString("stu_name");
			}
						

			if(c==0)
				p2.add(lbmsg);
			else
			{
				jcs.addItem(stu);
					
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
		}*/
	
			
		
	add(p1);
	add(p2);
	add(p3);
	add(p4);
	add(p5);
	add(p6);
	
	}
public void itemStateChanged(ItemEvent ie)
{
	Object src=ie.getSource();
	if(ie.getStateChange()==ItemEvent.SELECTED)
	{
	if(src==jcb)
	{
		String brh_name=(String) jcb.getSelectedItem();
		//JOptionshowMessageDialog(null, brh_name);
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
Connection		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","");
	try{
		PreparedStatement st=con.prepareStatement("Select stu_name from sttable where stu_branch = ?");
		st.setString(1, brh_name);
		ResultSet rs=st.executeQuery();
	
		while(rs.next())
		{
			String cmpn=rs.getString("stu_name");
			jcs.addItem(cmpn);
			//JOptionshowMessageDialog(null, rs.getInt(1));
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
	else
	if(src==jcs)
	{
		String stn=(String) jcs.getSelectedItem();
		//JOptionPane.showMessageDialog(null, stn);
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
Connection		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","");
	try{
		PreparedStatement st=con.prepareStatement("Select company_name from aptable where stu_name=?");
		st.setString(1, stn);
		ResultSet rs=st.executeQuery();
	//	JOptionPane.showMessageDialog(null, stn);
		while(rs.next())
		{
			String cmpn=rs.getString("company_name");
			txc.setText(cmpn);
	//		JOptionPane.showMessageDialog(null, cmpn);
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
	try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","");
			try{
				PreparedStatement st=con.prepareStatement("Select company_city from aptable where stu_name=?");
				st.setString(1, stn);
				ResultSet rs=st.executeQuery();
			//	JOptionPane.showMessageDialog(null, stn);
				while(rs.next())
				{
					String cmpn=rs.getString("company_city");
					txci.setText(cmpn);
//					JOptionPane.showMessageDialog(null, cmpn);
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
			
	}
	}//end of jcb
	}//end of selected



public void actionPerformed(ActionEvent ae)
{
	Object src=ae.getSource();
	if(src==btbck)
	{
		projecto.jtp.setSelectedIndex(0);
	}
	
}
}
