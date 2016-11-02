import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.sql.*;

public class jmenu extends JPanel implements ActionListener
{
	 JLabel lb;
	   JMenuBar mb;
	   JMenu mcomp,mbrn;
	   JMenuItem addb,upb,delb,addc,upc,delc;
	   JPanel p1,p2,p3;
	   public jmenu()
	   {
		   p1=new JPanel();
		   //lb.setFont(new Font("Constantia",20,11));
		   lb=new JLabel("Select any field to edit:");
		   mb=new JMenuBar();
		   mcomp=new JMenu("Company");
		   mbrn=new JMenu("Branch");
		   addb=new JMenuItem("Add");
		   upb=new JMenuItem("Update");
		   delb=new JMenuItem("Delete");
		   addc=new JMenuItem("Add");
		   upc=new JMenuItem("Update");
		   delc=new JMenuItem("Delete");

		   //p1.setLayout(new GridLayout(1,2));
		   p3=new JPanel();
		   mcomp.add(addc);
		   mcomp.add(upc);
		   mcomp.add(delc);
		   
		   mbrn.add(addb);
		   mbrn.add(upb);
		   mbrn.add(delb);
		   addc.addActionListener(this);
		   upc.addActionListener(this);
		   delc.addActionListener(this);
		   addb.addActionListener(this);
		   upb.addActionListener(this);
		   delb.addActionListener(this);
		   mb.add(mcomp);
		   mb.add(mbrn);
		   mb.setBorder(BorderFactory.createEtchedBorder());
		  
		   
		   //p3.add(new JLabel("fgchvhc"));
		  // p3.setBorder(BorderFactory.createEtchedBorder());
		   JPanel pmb=new JPanel();
		//pmb.setPreferredSize(new Dimension(600,90));
		 pmb.setBorder(BorderFactory.createEtchedBorder());
		pmb.add(mb);
		setLayout(new GridLayout(3,1));
		  add(pmb);
		
		   add(p1);
	   
		   //setBorder(BorderFactory.createEtchedBorder());
	   //add(p3);
	   
	   }
	   public void actionPerformed(ActionEvent ae)
	   {
		   Object src=ae.getSource();
		   remove(p1);
		   validate();

		   if(src==addc)
		   {
			   remove(p3);
			   //validate();
			   p1=new compadd();
			   add(p1,BorderLayout.CENTER);
			   //validate();			   
		   }
		   else if(src==upc)
		   {
			   remove(p3);
			   //validate();	
			   p1=new compupdate();
			   add(p1);
			   //validate();			   
		   }
		   else if(src==delc)
		   {
			   remove(p3);
			   //validate();	
			   p1=new compupdate();
			   add(p1);
			   //validate();			   
		   }
		   else if(src==addb)
		   {
			   remove(p3);
			   //validate();	
			   p1=new branchp();
			   add(p1);
			   //validate();			   
		   }
		   else if(src==upb)
		   {
			   remove(p3);
			   //validate();	
			   p1=new brupdate();
			   add(p1);
			   //validate();			   
		   }
		   else if(src==delb)
		   {
			   remove(p3);
			 //  validate();	
			   p1=new brupdate();
			   add(p1);
			 }
		   p1.setPreferredSize(new Dimension(550,500));
		   p1.validate();
		   validate();
		   revalidate();

	   }
	   
}
