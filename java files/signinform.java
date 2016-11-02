import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.sql.*;
public class signinform extends JApplet
{
JTabbedPane jtp;
Container pane;
public void init()
{
	pane=getContentPane();
	jtp=new JTabbedPane();
	jtp.addTab("Admin Section", new admsign());
	jtp.addTab("Student Section", new stusign());
	pane.add(jtp,BorderLayout.CENTER);
}

}
