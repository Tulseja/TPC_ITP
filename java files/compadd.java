import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
//import java.io.*;
import java.sql.*;

public class compadd extends JPanel implements ItemListener,ActionListener
{
	JTextField txn,txc,txa,txh;
	JLabel lbn,lbc,lbt,lbca,lbd,lba,lbadd,lbh,lbsb,lbv,lbp;
	//TextArea tad;
	//JComboBox jctype;
	JTextArea jt;
	JButton bts,btc;
	JCheckBox cs,it,mec,civ,ele,ece;
	JPanel p1,p2,p,p7,p4,p5,p6,p8,p9;
	//JColorChooser jcc;
	//Container pane;
	Icon ic;
	
	String str;
	public compadd()
	{ 	//pane=getContentPane();
		//setPreferredSize(new Dimension(450,400));
		setLayout(new GridLayout(9,1));
		p=new JPanel();
		p1=new JPanel();
		 //p1.
		p2=new JPanel();
		p4=new JPanel();
		p5=new JPanel();
		p6=new JPanel();
		p7=new JPanel();
		p8=new JPanel();
		  p9=new JPanel();
		  lbp=new JLabel(new ImageIcon("cmpa.gif"));
		  lbp.setPreferredSize(new Dimension(300,50));
		  lbp.setBorder(BorderFactory.createRaisedBevelBorder());
		  p.add(lbp);
		txn=new JTextField(20);
		txc=new JTextField(20);
		txh=new JTextField(20);
		//jctype=new JComboBox();
		lbd=new JLabel("Description:");
		jt=new JTextArea();
		jt.setText("add more descriptions about company");
		//jt.setColumns(100);
		txa=new JTextField(20);
		bts=new JButton("Submit");
		btc=new JButton("Cancel");
		lbsb=new JLabel("Submitted Successfully!! check your database.");
		
		cs=new JCheckBox("CSE");
		it=new JCheckBox("IT");
		
		mec=new JCheckBox("Mechanical");
		civ=new JCheckBox("Civil");
		ele=new JCheckBox("Electrical");
		ece=new JCheckBox("ECE");

		cs.addItemListener(this);
		it.addItemListener(this);
		mec.addItemListener(this);
		civ.addItemListener(this);
		ele.addItemListener(this);
		ece.addItemListener(this);
		
		lbn=new JLabel("*Name:");
		lbc=new JLabel("*City:");
		lbt=new JLabel("Company Type:");
		
		//setBorder(BorderFactory.createEtchedBorder());
		
		lba=new JLabel("Address:");
		lbh=new JLabel("Helpline");
		
		
		//jctype.addItemListener(this);	
		add(p);
		p1.add(lbn);
		p1.add(txn);
		add(p1);
		
		p2.add(lbc);
		p2.add(txc);
		add(p2);
		
		p6.add(lba);
		p6.add(txa);
		add(p6);
		
		p4.add(lbt);
		p4.add(cs);
		p4.add(it);
		p4.add(mec);
		p4.add(civ);
		p4.add(ele);
		p4.add(ece);

		add(p4);
		
		//JPanel p51=new JPanel();
		//p51.add(lbd);
		
		//p5.setLayout(new GridLayout());
	//	p5.setPreferredSize(new Dimension(200,100));
		p5.add(lbd);
		p5.add(jt);
		add(p5);

		p8.add(lbh);
		p8.add(txh);
		add(p8);
	
		p7.add(bts);
		p7.add(btc);
		add(p7);
		
		
		p9.add(lbsb);
		bts.addActionListener(this);
		btc.addActionListener(this);
	}
	public void itemStateChanged(ItemEvent ie)
	{
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
	}
	public void actionPerformed(ActionEvent ae)
	{
		Object src=ae.getSource();
		if(src==bts)
		{
			boolean status=true;
			if(txn.getText().equals(""))
			{
				p1.add(new JLabel("**"));
				p1.validate();
				status=false;
			}
			if(txc.getText().equals(""))
				{
				p2.add(new JLabel("**"));
				p2.validate();
				status=false;}
			if(txa.getText().equals(""))
				{p6.add(new JLabel("**"));
				p6.validate();
				status=false;
				}
			if(txh.getText().equals(""))
				{
					p8.add(new JLabel("**"));
					p8.validate();
					status=false;
				}
			if(jt.getText().equals("add more descriptions about company"))
				{
				p5.add(new JLabel("**"));
				p5.validate();
				status=false;
				}
			if(!(cs.isSelected()||it.isSelected()||mec.isSelected()||civ.isSelected()||ele.isSelected()||ece.isSelected()))
			{
				p4.add(new JLabel("**"));
				p4.validate();
				status=false;
			}
			if(status)
			{
			try
			{	//add(p9);
				
				Class.forName("com.mysql.jdbc.Driver");	//loads driver
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","");	//makes connection
			
			try{
				//BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
				//System.out.println("enter table name")
				Statement st=con.createStatement();
				String table="CREATE TABLE if not exists company (company_name Varchar(40),company_description Varchar(40) ,company_city Varchar(40),company_address Varchar(40),company_type Varchar(255),company_helpline integer)";
				st.executeUpdate(table);
				System.out.println("table creation successful");
				String nm=txn.getText();
				String city=txc.getText();
				String add=txa.getText();
				String type=str;
				String des=jt.getText();
				int hpl=Integer.parseInt(txh.getText());
				String ins_sql="Insert into company values(?,?,?,?,?,?)";
				PreparedStatement pstmt=con.prepareStatement(ins_sql);
				pstmt.setString(1, nm);
				pstmt.setString(2, des);
				pstmt.setString(3,city);
				pstmt.setString(4, add);
				pstmt.setString(5, type);
				pstmt.setInt(6, hpl);
				pstmt.executeUpdate();
				System.out.println("table insertion successful");
				add(p9);
				validate();
				projecto.jtp.setSelectedIndex(0);
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
			else
			{
				JOptionPane.showMessageDialog(null, "Fill All Fields");
			}
		}
		else if(src==btc)
		{
			projecto.jtp.setSelectedIndex(0);
		}
	}
}
