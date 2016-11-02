import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;

import javax.swing.*;
public class home extends JPanel
{
JLabel lb,lbo,lbw;
JPanel p,p1,p2;
JColorChooser jcc;
Label lbp;
public home()
{	jcc=new JColorChooser();
// Color c=jcc.showDialog(null, "Background color", Color.BLUE);
	setBackground(Color.white);
	
	p=new JPanel();
	p.setLayout(new BorderLayout());
	lb=new JLabel(new ImageIcon("home.gif"));
	
	lbo=new JLabel(new ImageIcon("uiet.jpg"));
	//lbw=new JLabel("UIET,Panjab University");
	p1=new JPanel();
	p2=new JPanel();
	lb.setPreferredSize(new Dimension(150,60));
    	lbo.setPreferredSize(new Dimension(1400,600));
	//lb.setBorder(BorderFactory.createRaisedBevelBorder());
	//p1.setPreferredSize(new Dimension(400,500));
	p1.add(lbo);
	
//	p2.add(lbw);
	p.setPreferredSize(new Dimension(1400,600));
	
	p.add(p1);
	add(p);
}
}
