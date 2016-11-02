import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class cmpque extends JPanel implements ItemListener,ActionListener
{
JLabel lbt,lbc,lbci,lbn,lbns,lbp;
JComboBox jct,jcc,jcci;
JTextField txns;
JButton btbck;

JPanel p1,p2,p3,p4,p5,p6;
public cmpque()
{
	
	setPreferredSize(new Dimension(600,500));
	lbp=new JLabel(new ImageIcon("tque.gif"));
	lbp.setPreferredSize(new Dimension(350,60));
	lbp.setBorder(BorderFactory.createRaisedBevelBorder());
	lbt=new JLabel("Type of Company:");
	lbc=new JLabel("Companies:");
	lbci=new JLabel("Select city:");
	jct=new JComboBox();
	jct.addItem("Select type");
	jct.addItemListener(this);
	jcc=new JComboBox();
	jcc.addItem("Select Company:");
	jcc.addItemListener(this);
	jcci=new JComboBox();
	jcci.addItem("Select city:");
	jcci.addItemListener(this);
	lbns=new JLabel("Number of Students:");
	txns=new JTextField(15);
	btbck=new JButton("Back");
	
	setLayout(new GridLayout(6,1));
	p1=new JPanel();
	p2=new JPanel();
	p3=new JPanel();
	p4=new JPanel();
	p5=new JPanel();
	p6=new JPanel();
	
	Connection con=null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","");
		try{
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("Select brh_name from brtable");
		while(rs.next())
		{
			String cmt=rs.getString("brh_name");
			jct.addItem(cmt);
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
	p1.add(lbp);
	p2.add(lbt);
	p2.add(jct);
	p3.add(lbc);
	p3.add(jcc);
	p4.add(lbci);
	p4.add(jcci);
	p5.add(lbns);
	p5.add(txns);
	p6.add(btbck);
		btbck.addActionListener(this);
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
		if(src==jct)
		{
	//	String type=(String) jct.getSelectedItem();
		
			try
			{
					Class.forName("com.mysql.jdbc.Driver");
					Connection		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","");
					try{
							PreparedStatement st=con.prepareStatement("Select company_name from company where company_type=?");// where company_type like '%brh_name%'");
							String type=(String) jct.getSelectedItem();
							st.setString(1, type);
							ResultSet rs=st.executeQuery();
		
							while(rs.next())
							{
								String cnm=rs.getString("company_name");
								jcc.addItem(cnm);
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
		else
		if(src==jcc)
		{
		if(jcci.getItemCount()>1)
		{
			jcci.removeAllItems();
			jcci.addItem("Select City");
			/*int c=jcci.getItemCount();
			for(int i=1;i<c;i++)
				jcci.remove(i);*/
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
		else
	if(src==jcci)
	{
		
		String cmpn=(String) jcc.getSelectedItem();
		String city=(String) jcci.getSelectedItem();
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
Connection		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","");
	try{
		PreparedStatement st=con.prepareStatement("Select count(*) from aptable where company_name =? and company_city=?");
		st.setString(1, cmpn);
		st.setString(2, city);
		ResultSet rs=st.executeQuery();
	    int c=0;
		while(rs.next())
		{
			c=rs.getInt(1);
		
		}
		//	JOptionshowMessageDialog(null, rs.getInt(1));
		txns.setText(Integer.toString(c));
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

	}//end of jcci
	}//end of selected
}
//end of selected


public void actionPerformed(ActionEvent ae)
{
	Object src=ae.getSource();
	if(src==btbck)
		projecto.jtp.setSelectedIndex(0);
}
}
