import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.sql.*;
public class projecto extends JApplet implements ChangeListener {
Container pane;
JLabel lbp,logo,l1;
static public JTabbedPane jtp;
static boolean status1=false;
static boolean status2=false;
Graphics g;
public void init()
{
	pane=getContentPane();
	//setContentPane(new JLabel(new ImageIcon("uiet.jpg")));
	//setLayout(new FlowLayout());
	//l1=new JLabel("Here is a button"); 
	JPanel p0=new JPanel();
	logo=new JLabel(new ImageIcon("uiet logo.jpg"));
	logo.setPreferredSize(new Dimension(200,120));
	//logo.setBorder(BorderFactory.createLineBorder(Color.orange));
	//logo.setBorder(BorderFactory.createTitledBorder(""));
	lbp=new JLabel(new ImageIcon("traing.gif"));
	
	JPanel p1=new JPanel();
	JPanel p3=new JPanel();
	p1.setLayout(new FlowLayout(FlowLayout.LEFT));
	p1.add(logo);
	p1.setBorder(BorderFactory.createEmptyBorder());
	JPanel p2=new JPanel();
	lbp.setPreferredSize(new Dimension(650,60));
	p2.setLayout(new FlowLayout(FlowLayout.RIGHT));
	p2.add(lbp);
	p2.setBackground(Color.orange);
	p2.setBorder(BorderFactory.createRaisedBevelBorder());
	//p3.add(new Label("UIET""));
	JPanel pN=new JPanel();
	pN.setLayout(new FlowLayout(FlowLayout.LEFT));
	pN.add(p1);
	pN.add(new JLabel(""));pN.add(new JLabel(""));pN.add(new JLabel(""));pN.add(new JLabel(""));pN.add(new JLabel(""));pN.add(new JLabel(""));
	pN.add(new JLabel(""));pN.add(new JLabel(""));pN.add(new JLabel(""));pN.add(new JLabel(""));pN.add(new JLabel(""));pN.add(new JLabel(""));
	pN.add(new JLabel(""));pN.add(new JLabel(""));pN.add(new JLabel(""));pN.add(new JLabel(""));pN.add(new JLabel(""));pN.add(new JLabel(""));
	pN.add(new JLabel(""));pN.add(new JLabel(""));pN.add(new JLabel(""));pN.add(new JLabel(""));pN.add(new JLabel(""));pN.add(new JLabel(""));
	pN.add(new JLabel(""));pN.add(new JLabel(""));pN.add(new JLabel(""));pN.add(new JLabel(""));pN.add(new JLabel(""));pN.add(new JLabel(""));pN.add(new JLabel(""));
	pN.add(p2);
	pN.setPreferredSize(new Dimension(200,130));
	pN.setBackground(Color.orange);
	pane.setBackground(Color.WHITE);
	pane.setLayout(new BorderLayout());
	pane.add(pN,BorderLayout.NORTH);
	

	//p0.setPreferredSize(new Dimension(10,10));
	p0.setLayout(new BorderLayout());
	
	//pane.add(p0,BorderLayout.WEST);
	//JPanel p2=new JPanel();
	
	
	jtp=new JTabbedPane();
	jtp.setBackground(Color.WHITE);
	jtp.addTab("Home", new home());
	jtp.addTab("Admin", new admin());
	jtp.addTab("Student", new student());
	jtp.addTab("Apply Form", new applyform());
	jtp.setEnabledAt(3, false);
	jtp.addTab("Help", new help());
	jtp.addTab("Queries", new query());
	jtp.addChangeListener(this);
	jtp.setBorder(BorderFactory.createRaisedBevelBorder());

	pane.add(jtp,BorderLayout.CENTER);
	
}

@Override
public void stateChanged(ChangeEvent arg0) {
	// TODO Auto-generated method stub
	if(jtp.getSelectedIndex()!=1)
	{
		admsign.lbmsg.setText("");
		if(status1==true)
		{
				JOptionPane.showMessageDialog(null, "PLEASE LOGOUT!!");
				jtp.setSelectedIndex(1);
		}
	}
	 if(jtp.getSelectedIndex()!=3)
	{
		if(status2==true)
		{
			JOptionPane.showMessageDialog(null, "PLEASE LOGOUT from your id!!");
			jtp.setSelectedIndex(3);
		}
	}
	 if(student.jtp.getSelectedIndex()==1)
		{
			JOptionPane.showMessageDialog(null, "ghnb");
		}
		}	
}
