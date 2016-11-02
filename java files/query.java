import javax.swing.*;
public class query extends JPanel
{
JTabbedPane jtp;
public query()
{
	jtp=new JTabbedPane();
	jtp.addTab("Branch-wise Query", new stuque());
	jtp.addTab("Sector-wise Query", new cmpque());
	add(jtp);
}
}
