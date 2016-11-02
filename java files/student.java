import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.io.*;
import java.sql.*;
public class student extends JPanel implements ChangeListener
{
JLabel lb;

public static JTabbedPane jtp;
public student()
{
	//setPreferredSize(new Dimension(600,5000));
	jtp=new JTabbedPane();
	jtp.addTab("sign in", new stusign() );
	jtp.addTab("Register", new register());
	jtp.setPreferredSize(new Dimension(500,500));
	jtp.addChangeListener(this);
	
	add(jtp);
	
}
public void stateChanged(ChangeEvent arg0) {
	// TODO Auto-generated method stub
 if(jtp.getSelectedIndex()==1)
 {
	 stusign.lbmsg.setText("");
 }
}
}
