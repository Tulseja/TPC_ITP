import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class compupdate extends JPanel implements ItemListener,ActionListener
{
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	JTextField txn,txc,txt,txa,txh;
	JCheckBox cs,it,mec,civ,ele,ece;
	JLabel lbn,lbc,lbt,lbca,lbd,lba,lbadd,lbh,lbp;
	JTextArea tad;
	JComboBox jcc;
	String str;
	JTextArea jt;
	JButton btu,btd,bta;
	String company;
JComboBox jb;
JPanel p01;

//Container pane;
public compupdate()
{
	
	//pane=getContentPane();
	jb=new JComboBox();
	JPanel p=new JPanel();
	btu=new JButton("Update data");
	btd=new JButton("delete data");
	txh=new JTextField(20);
	lbh=new JLabel("Helpline");

	setLayout(new GridLayout(10,2));
	//setBorder(BorderFactory.createEtchedBorder());
	//setLayout(new FlowLayout());
	jb.addItem("select company");
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
			jb.addItem(cmpn);
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
	lbc=new JLabel("Name of Company:");
	
	jb.addItemListener(this);
	
	JPanel phead=new JPanel();
	lbp=new JLabel(new ImageIcon("cmpupd.gif"));
	lbp.setPreferredSize(new Dimension(350,50));
	  lbp.setBorder(BorderFactory.createRaisedBevelBorder());
	  	 phead.add(lbp);
	
	 add(phead);
	p.add(lbc);
	p.add(jb);
	add(p);

	
	 JPanel p1=new JPanel();
	 //p1.setPreferredSize(new Dimension(80,50));
	 JPanel p2=new JPanel();
	 JPanel p3=new JPanel();
	 JPanel p4=new JPanel();
	 JPanel p5=new JPanel();
	 JPanel p6=new JPanel();
	 JPanel p7=new JPanel();
	 JPanel p8=new JPanel();
	 JPanel p9=new JPanel();
	txn=new JTextField(20);
	txc=new JTextField(20);
	txt=new JTextField(20);
	jcc=new JComboBox();
	jt=new JTextArea("add more descriptions about company"); 
	txa=new JTextField(20);
	cs=new JCheckBox("CSE");
	it=new JCheckBox("IT");
	mec=new JCheckBox("Mechanical");
	civ=new JCheckBox("Civil");
	ele=new JCheckBox("Electrical");
	ece=new JCheckBox("ECE");
	lbn=new JLabel("*Name:");
	lbc=new JLabel("*City:");
	lbt=new JLabel("Company Type:");
	//lbca=new JLabel("*Courses :");
	lbd=new JLabel("Description:");
	
	lba=new JLabel("Address:");
	lbh=new JLabel("Helpline");
	
	jcc.addItemListener(this);	
	p1.add(lbn);
	p1.add(txn);
	add(p1);
	
	p2.add(lbc);
	p2.add(txc);
	add(p2);
	
	p6.add(lba);
	p6.add(txa);
	add(p6);
	
	p3.add(lbt);
	p3.add(cs);
	p3.add(it);
	p3.add(mec);
	p3.add(civ);
	p3.add(ele);
	p3.add(ece);
	add(p3);
	
	
	
	p5.add(lbd);
	p5.add(jt);
	add(p5);
	p8.add(lbh);
	p8.add(txh);
	add(p8);

	btu.addActionListener(this);
	btd.addActionListener(this);
	p7.add(btu);
	p7.add(btd);
	add(p7);

	
}
public void itemStateChanged(ItemEvent ie)
{
	//ie.SELECTED
	Object src=ie.getSource();
	 company=(String) jb.getSelectedItem();
	 
	if(src==jb)
	{
		if(jb.getSelectedIndex()!=0)
		{
			
			Connection con=null;
		try
		{	//add(p9);
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","");
		try{
		PreparedStatement pstmt=con.prepareStatement("select * from company where company_name=?");
		pstmt.setString(1, company);
		ResultSet rs=pstmt.executeQuery();
		
		while(rs.next())
		{
			civ.setSelected(false);
			mec.setSelected(false);
			cs.setSelected(false);
			ele.setSelected(false);
			ece.setSelected(false);
			it.setSelected(false);
			
			String nm=rs.getString("company_name");
			String desc=rs.getString("company_description");
			String city=rs.getString("company_city");
			String add=rs.getString("company_address");
			String type=rs.getString("company_type");
			
			int hpl=rs.getInt("company_helpline");
			txn.setText(nm);
			jt.setText(desc);
			txc.setText(city);
			txa.setText(add);
			txh.setText(Integer.toString(hpl));
			
			
			if(type.contains("Civil Engineering"))
			civ.setSelected(true);
		
			if(type.contains("Computer Science & Engineering"))
			cs.setSelected(true);
			
			if(type.contains("Electronics & Communication Engineering"))
			ece.setSelected(true);
			
			if(type.contains("Mechanical"))
			mec.setSelected(true);
			
			if(type.contains("Information Technology"))
			it.setSelected(true);
			
			if(type.contains("Electrical & Electronics Engineering"))
			ele.setSelected(true);
			
			txh.setText(Integer.toString(hpl));
				
		}
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
public void actionPerformed(ActionEvent ae)
{
	Object src=ae.getSource();
	if(src==btu)
	{
		if(txn.getText().equals(""))
		JOptionPane.showMessageDialog(null, "Select a Company First!!");
		else
		{
		Connection con=null;
		try
		{	//add(p9);
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","");
		try{
//		String company=(String) jb.getSelectedItem();
		PreparedStatement pstmt=con.prepareStatement("update company set company_name=?,company_description=?,company_city=?,company_address=?,company_type=?,company_helpline=? where company_name=?");
		String nm=txn.getText();
		String desc=jt.getText();
		String city=txc.getText();
		String add=txa.getText();
		int c=0;
		str="";
		if(cs.isSelected())
		{
			str="Computer Science & Engineering";
			c++;
		}
		
		if(ece.isSelected())
		{
			if(c==0)
			{
				str="Electronics & Communication Engineering ";
				c++;
			}
			else
				str+=",Electronics & Communication Engineering";
		}
		if(mec.isSelected())
		{	if(c==0)
			{
				str+="Mechanical";
				c++;
			}
			else
			str+=",Mechanical";
		}
		if(civ.isSelected())
		{
			if(c==0)
				{
				str+="Civil Engineering";
				c++;
				}
			else
			str+=",Civil Engineering";
		}
			if(it.isSelected())
			{
				if(c==0)
				{
				str+="Information Technology";
				c++;
				}
				else
					str+=",Information Technology";
			}
		if(ele.isSelected())
		{
			if(c==0)
			{
				str+="Electrical & Electronics Engineering";
				c++;
			}
			else
				str+=",Electrical & Electronics Engineering";
		}

String type=str;
		Double hpl=Double.parseDouble(txh.getText());
		
		pstmt.setString(1, nm);
		pstmt.setString(2, desc);
		pstmt.setString(3, city);
		pstmt.setString(4, add);
		pstmt.setString(5, type);
		pstmt.setDouble(6, hpl);
		
		pstmt.setString(7, company);
		
		pstmt.executeUpdate();
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
		p01=new JPanel ();
		
		removeAll();
		p01.add(new JLabel("Updated successfully!! Check your DATABASE :)"));
		add(p01);
		}
	}
	
	if(src==btd)
	{
		if(txn.getText().equals(""))
			JOptionPane.showMessageDialog(null, "Select a company");
		else
		{
		Connection con=null;
		try
		{	//add(p9);
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","");
		try{
//		String company=(String) jb.getSelectedItem();
		PreparedStatement pstmt=con.prepareStatement("delete from company where company_name=?");
		String nm=txn.getText();
		
		pstmt.setString(1, nm);
		
		
		pstmt.executeUpdate();
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
		System.exit(-1);
		}
	}
		
	}
}




