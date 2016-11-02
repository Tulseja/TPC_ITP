import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.sql.*;
public class stusign extends JPanel implements ActionListener
{
JLabel lbu,lbp,lbpas;
static JLabel lbmsg;
static JTextField txu;
static JPasswordField lbpa;
JButton bts,btc,btlog;
JTabbedPane jtp;
JPanel p1,p2,p3,p4,p5;
public stusign()
{
	setLayout(new GridLayout(5,2));
	lbu=new JLabel("User ID (Roll Number):");
	txu=new JTextField(15);
	lbp=new JLabel(new ImageIcon("signin.gif"));
	lbp.setPreferredSize(new Dimension(170,50));
	lbp.setBorder(BorderFactory.createRaisedBevelBorder());
	lbpas=new JLabel("Enter your password:");
	lbmsg=new JLabel();
	lbpa=new JPasswordField(10);
	bts=new JButton("Sign in");
	btc=new JButton("Cancel");
	p1=new JPanel();
	p2=new JPanel();
	p3=new JPanel();
	p4=new JPanel();
	p5=new JPanel();
	p1.add(lbp);
	p2.add(lbu);
	p2.add(txu);
	p3.add(lbpas);
	p3.add(lbpa);
	bts.addActionListener(this);
	btc.addActionListener(this);
	p4.add(bts);
	p4.add(btc);
	p5.add(lbmsg);
	p1.validate();
	add(p1);
	add(p2);
	p3.validate();
	add(p3);
	add(p4);
	add(p5);
	
}
public void actionPerformed(ActionEvent ae)
{
Object src=ae.getSource();
if(src==bts)
{
	
	Connection con=null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","");
			PreparedStatement pstmt=con.prepareStatement("select count(*) stu_pass from sttable where stu_rollnu=? and stu_pass=?");
			String roll=txu.getText();
			pstmt.setString(1, roll);
			String pass=lbpa.getText();
			pstmt.setString(2, pass);
			
			ResultSet rs=pstmt.executeQuery();
			int c=0;
			
			while(rs.next())
			{
				c=rs.getInt(1);
			
			}
			if(c==0)
			{
				lbmsg.setText("Wrong Username");
				txu.setText("");
				lbpa.setText("");
				validate();
				
			}
				else
			{
				lbmsg.setText("Welcome");
				projecto.jtp.setEnabledAt(3, true);
				projecto.jtp.setSelectedIndex(3);
				projecto.status2=true;
			}
			}
		
		
		catch(SQLException  s)
		{
			System.out.println(s);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
}	else
	if(src==btc)
{
	projecto.jtp.setSelectedIndex(0);
}
//p3.validate();
//p1.validate();
}
}
