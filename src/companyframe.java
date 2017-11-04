import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;


public class companyframe extends JFrame
{
public companyframe() {
setLayout(null);
Container c=getContentPane();
ImageIcon img=new ImageIcon("companyphoto1.jpg");
 JLabel lbl=new JLabel(img);
lbl.setBounds(0, 0, 1400, 400);
c.add(lbl);

JLabel vision=new JLabel("Vision :");
vision.setBounds(20, 410, 500, 30);
vision.setFont(new Font("Serial",Font.ITALIC, 40));
vision.setForeground(Color.BLACK);
add(vision);

JLabel txtvision=new JLabel("To be one of the most trusted and premium brands through fast paced innovation and " +
		"our leadership ability to deliver the best of products and services");
txtvision.setFont(new Font("arial", Font.ITALIC, 20));
txtvision.setBounds(20, 445, 1400, 20);
add(txtvision);

JLabel txtvision1=new JLabel(" to our customers and delighting our stakeholders while being mindful of our overall responsibilities.");
txtvision1.setFont(new Font("arial", Font.ITALIC, 20));
txtvision1.setBounds(20, 465, 1400, 20);
add(txtvision1);

JLabel mission=new JLabel("Mission :");
mission.setBounds(20, 500, 500, 30);
mission.setFont(new Font("Serial",Font.ITALIC, 40));
mission.setForeground(Color.BLACK);
add(mission);

JLabel txtmission=new JLabel(" To solidify our leadership position globally in an ever-evolving security products" +
		" and services industry, across a range of growing market segments,");
txtmission.setFont(new Font("arial", Font.ITALIC, 20));
txtmission.setBounds(20, 535, 1400, 20);
add(txtmission);

JLabel txtmission1=new JLabel("including computers, mobiles, tablets" +
		" and Next Gen Networks (NGNs) and to forge strong customer and partner relationships.");
txtmission1.setFont(new Font("arial", Font.ITALIC, 20));
txtmission1.setBounds(20, 555, 1400, 20);
add(txtmission1);

JLabel investors=new JLabel("Investors :");
investors.setBounds(20, 590, 500, 30);
investors.setFont(new Font("Serial",Font.ITALIC, 40));
investors.setForeground(Color.BLACK);
add(investors);

JLabel txtinvestors=new JLabel("In 2015, Killer Web Technologies partnered with Venture Capital firm, Sequoia" +
		" Capital to boost its novel technology and business model. This");
txtinvestors.setFont(new Font("arial", Font.ITALIC, 20));
txtinvestors.setBounds(20, 625, 1400, 20);
add(txtinvestors);

JLabel txtinvestors1=new JLabel("resulted in an investment of 12 Million" +
		" USD from Sequoia Capital.");
txtinvestors1.setFont(new Font("arial", Font.ITALIC, 20));
txtinvestors1.setBounds(20, 645, 1400, 20);
add(txtinvestors1);

ImageIcon imgback=new ImageIcon("backbtn.png");
JButton backbtn=new JButton(imgback);
backbtn.setBounds(0, 0, 90, 40);
lbl.add(backbtn);
backbtn.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent arg0) {
	
		dispose();
		new Mainframe();
	}
});

Menugen objmenugen=new Menugen();
JMenuBar mbar=objmenugen.getmenubar(this);
setJMenuBar(mbar);

setTitle("Company overview");
setSize(Toolkit.getDefaultToolkit().getScreenSize());
setVisible(true);
setDefaultCloseOperation(2);
}
}
