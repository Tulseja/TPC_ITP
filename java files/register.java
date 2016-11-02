import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.sql.*;
public class register extends JPanel implements ActionListener
{
	JButton bts,btc;
	JLabel lbn,lbb,lbs,lbr,lbp,lbc,lbpa,lbps,lbpm;
	JTextField txn,txr,txp;
	JComboBox jbb,jbsn,jbc,jbco;
	
	JPanel p6,p5,p4,p3,p2,p1,p7,p8,p71;
	JPasswordField jp;
	
	public register()
	{
		lbpm=new JLabel("**");
		lbpm.setVisible(false);
		lbps=new JLabel("password must be 6-10 Characters long!! ");
		jp=new JPasswordField(10);
	
		setLayout(new GridLayout(8,3));
		bts=new JButton("Submit");
		btc=new JButton("Cancel");
		bts.addActionListener(this);
		btc.addActionListener(this);
		lbc=new JLabel("Name of Company:");
		jbc=new JComboBox();
		jbc.addItem("Select company");
		lbp=new JLabel(new ImageIcon("regstr.gif"));
		lbp.setBorder(BorderFactory.createRaisedBevelBorder());
		lbn=new JLabel("Name Of Student:  ");
		lbb=new JLabel("Branch: ");
		lbs=new JLabel("Semester: ");
		lbr=new JLabel("Roll no.: ");
		txn=new JTextField(20);
		txr=new JTextField(20);
		jbb=new JComboBox();
		jbsn=new JComboBox();
		//txp=new JTextField(20);
		
		
		jbb.addItem("Select a Branch");
		jbsn.addItem("Select Semester");
		jbsn.addItem("First");
		jbsn.addItem("Second");
		jbsn.addItem("Third");
		jbsn.addItem("Fourth");
		jbsn.addItem("Fifth");
		jbsn.addItem("Sixth");
		jbsn.addItem("Seventh");
		jbsn.addItem("Eighth");
		lbpa=new JLabel("Enter new Password:");
		
		 p1=new JPanel();
		 p2=new JPanel();
		 p3=new JPanel();
		 p4=new JPanel();
		 p5=new JPanel();
		 p6=new JPanel();
		 p7=new JPanel();
		 //p8=new JPanel();
		 
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
					jbb.addItem(name);
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
			 

		p1.add(lbp);
		//p4.setPreferredSize(new Dimension(2000,4000));
		p2.add(lbn);
		p2.add(txn);
		p3.add(lbb);
		p3.add(jbb);
		p4.add(lbs);
		p4.add(jbsn);
		p5.add(lbr);
		p5.add(txr);
		p6.add(bts);
		p6.add(btc);
		
		p71=new JPanel();
		p71.add(lbpa);
		p71.add(jp);
		p7.add(p71);
		lbps.setFont(new Font("Arial",Font.BOLD,11));
		lbps.setAlignmentX(JLabel.RIGHT_ALIGNMENT);
		JPanel p72=new JPanel();
		p72.add(lbps);
		p7.add(p72);
		//p7.setBorder(BorderFactory.createEtchedBorder());
		//jbco.addItem("Select Course");
		
		add(p1);
		add(p2);
		add(p3);
		add(p4);
		add(p5);
		p7.setLayout(new GridLayout(2,1));
		add(p7);
		//add(p8);
		add(p6);
	}
	public void actionPerformed(ActionEvent ae)
	{
		Object src=ae.getSource();
		if(src==bts)
		{
			boolean status=true; 
				if(txn.getText().equals(""))
							{
					p2.add(new JLabel("**"));
					p2.validate();
					status=false;
							}
				
				if(jbb.getSelectedIndex()==0)
				{
						p3.add(new JLabel("**"));
						p3.validate();
						status=false;
				}
						
				if(jbsn.getSelectedIndex()==0)
				{
					p4.add(new JLabel("**"));
					p4.validate();
					status=false;
				}
				if(txr.getText().equals(""))
				{
					p5.add(new JLabel("**"));
					p5.validate();
					status=false;
				}
				if(jp.getText().equals(""))
				{
					p71.add(new JLabel("**"));
					p71.validate();
					status=false;
				}
				
				if(status)
				{
				Connection con=null;
				try{
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","");
				Class.forName("com.mysql.jdbc.Driver");
				try{
					Statement st=con.createStatement();
					String table="CREATE TABLE if not exists sttable (stu_name Varchar(10),stu_branch Varchar(10),stu_sem Varchar(10),stu_rollnu varchar(30),stu_pass varchar(10))";
					st.executeUpdate(table);
					System.out.println("table created");
					String ins_sql="insert into sttable values(?,?,?,?,?)";
					String nm=txn.getText();
					String brnchn=(String) jbb.getSelectedItem();
					String sem=(String) jbsn.getSelectedItem();
					String roll=txr.getText();
					String pass=jp.getText();
					PreparedStatement pstmt=con.prepareStatement(ins_sql);
					pstmt.setString(1, nm);
					pstmt.setString(2, brnchn);
					pstmt.setString(3, sem);
					pstmt.setString(4, roll);
					pstmt.setString(5, pass);
					pstmt.executeUpdate();
					//Buffered
					System.out.println("Insertion successful!!");
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
				else
					JOptionPane.showMessageDialog(null,"Fill all fields!!");
		}
		else if(src==btc)
		{
		projecto.jtp.setSelectedIndex(0);
		}
		}
	}

