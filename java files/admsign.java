import javax.swing.*; 
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.sql.*;
public class admsign extends JPanel implements ActionListener,ChangeListener
{
JLabel lbu,lbp,lbpas,lbpm;
static JLabel lbmsg;
JPasswordField lbpa;
JButton bts,btc,btlogout;
JTextField txu;
JPanel p1,p2,p3,p4,p41,p5;
//Container pane;
public admsign()
{
	lbmsg=new JLabel("");
	lbpm=new JLabel("**");
	lbpm.setVisible(false);
	lbu=new JLabel("User ID :");
	txu=new JTextField(15);
	lbp=new JLabel(new ImageIcon("signin.gif"));
	lbp.setPreferredSize(new Dimension(170,50));
    lbp.setBorder(BorderFactory.createRaisedBevelBorder());
	lbpas=new JLabel("Enter your password:");
	lbpa=new JPasswordField(10);
	bts=new JButton("Sign in");
	btc=new JButton("Cancel");
	btlogout=new JButton("Logout");
	btlogout.setBorderPainted(false);
	
	p1=new JPanel();
	p2=new JPanel();
	p3=new JPanel();
	p4=new JPanel();
	p41=new JPanel();
	p5=new JPanel();
	
	p1.add(lbp);
	p2.add(lbu);
	p2.add(txu);
	p3.add(lbpas);
	p3.add(lbpa);
	bts.addActionListener(this);
	btc.addActionListener(this);
	btlogout.addActionListener(this);
	System.out.print(btlogout.getMnemonic());
	
	p4.add(bts);
	p4.add(btc);
	//p5.add(new jmenu());
	p5.add(p1);
	p5.add(p2);
	p5.add(p3);
	p4.validate();
	p5.add(p4);
	p41.add(lbmsg);
	p5.add(p41);
	add(p5);
	p5.setLayout(new GridLayout(5,1));
	//p5.setBorder(BorderFactory.createEtchedBorder());
	p5.setPreferredSize(new Dimension(500,500));
}
public void actionPerformed(ActionEvent ae)
{
	Object src=ae.getSource();
	if(src==bts)
	{
		
		
		if(txu.getText().equals(""))
		{
			p2.add(new JLabel("**"));
			p2.validate();
		
		}
		if(lbpa.getText().equals(""))
		{
			p3.add(new JLabel("**"));
			p3.validate();
		
		}
		if(txu.getText().equalsIgnoreCase("admin"))
		{
			if(lbpa.getText().equalsIgnoreCase("hello"))
			{
				p5.remove(p1);
				p5.remove(p2);
				p5.remove(p3);
				p5.remove(p4);
				p5.remove(p41);
				p5.validate();
				remove(p5);
				p5=new jmenu();
				p5.setLayout(new FlowLayout());
				p5.setPreferredSize(new Dimension(500,900));
			
				projecto.status1=true;
				add(p5);
				add(btlogout);
				revalidate();
			}
			else
			{
				lbmsg.setText("wrong username");
				p41.validate();
				lbpa.setText("");
				txu.setText("");

			}//hello
		}
		else
		{
			lbmsg.setText("wrong username");
			p41.validate();
			lbpa.setText("");
			txu.setText("");
		}	
		}
	if(src==btc)
	{
		projecto.jtp.setSelectedIndex(0);
	}
	if(src==btlogout)
	{
		projecto.status1=false;
		remove(p5);
		remove(btlogout);
		txu.setText("");
		lbpa.setText("");
		p5=new JPanel();
		p5.add(p1);
		p5.add(p2);
		p5.add(p3);
		p5.add(p4);
		p5.add(p41);
		add(p5);
		p5.setLayout(new GridLayout(5,1));
		//p5.setBorder(BorderFactory.createEtchedBorder());
		p5.setPreferredSize(new Dimension(500,500));
		
		validate();
		revalidate();
		projecto.jtp.setSelectedIndex(0);
		
	}
		
}
public void stateChanged(ChangeEvent arg0) {
	// TODO Auto-generated method stub
 if(projecto.jtp.getSelectedIndex()!=1)
 {
	 lbmsg.setText("");
 }
}
}

