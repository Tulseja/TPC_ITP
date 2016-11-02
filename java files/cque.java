import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class cque extends JApplet implements ItemListener
{
JLabel lbp,lbci,lbc,lbns;
JTextField txns;
JButton btbck;
JComboBox jcc,jcci;
Container pane;
JPanel p1,p2,p3,p4,p5;
public void init()
{
	pane=getContentPane();
	pane.setLayout(new GridLayout(5,1));
	lbp=new JLabel(new ImageIcon("cque.gif"));
	lbci=new JLabel("City:");
	lbc=new JLabel("Company:");
	lbns=new JLabel("Number of Students:");
	txns=new JTextField(15);
	jcc=new JComboBox();
	jcci=new JComboBox();
	jcc.addItem("Select Company");
	jcc.addItemListener(this);
	jcci.addItem("Select City");
	jcci.addItemListener(this);
	btbck=new JButton("Back");

	p1=new JPanel();
	p2=new JPanel();
	p3=new JPanel();
	p4=new JPanel();
	p5=new JPanel();
	
	Connection con=null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","");
		try{
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("Select company_city from company");
		while(rs.next())
		{
			String cmc=rs.getString("company_city");
			jcci.addItem(cmc);
		}
		System.out.println("insertion successful");
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
	p2.add(lbci);
	p2.add(jcci);
	p3.add(lbc);
	p3.add(jcc);
	p4.add(lbns);
	p4.add(txns);
	p5.add(bto);
	p5.add(btc);
	pane.add(p1);
	pane.add(p2);
	pane.add(p3);
	pane.add(p4);
	pane.add(p5);
	//pane.add(p6);



}
/*public void itemStateChanged(ItemEvent ie)
{
	Object src=ie.getSource();
	if(ie.getStateChange()==ItemEvent.SELECTED)
	{
	if(src==jcci)
	{
		String cnm=(String) jcci.getSelectedItem();
		
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
Connection		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","");
	try{
		PreparedStatement st=con.prepareStatement("Select company_name,company_type from company");// where company_type like '%brh_name%'");
		ResultSet rs=st.executeQuery();
	
		while(rs.next())
		{
			String type=rs.getString("company_type");
			if(type.contains(brh_name))
			{
			String cmpn=rs.getString("company_name");
			jcc.addItem(cmpn);
			}
		//	JOptionPane.showMessageDialog(null, rs.getInt(1));
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

}*/
public void actionPerformed(ActionEvent ae)
{
	Object src=ae.getSource();
	if(src==btbck)
		projecto.jtp.setSelectedIndex(0);
	
}

}
