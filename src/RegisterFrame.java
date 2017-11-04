
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.MenuBar;
import java.awt.PopupMenu;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JTextField;


public class RegisterFrame  extends JFrame
{
	JTextField txtname=new JTextField();
	JTextField txtemailid=new JTextField();
	JTextField txtcountry=new JTextField();
	JTextField txtunm=new JTextField();
	JTextField txtpwd=new JTextField();

public RegisterFrame()
{

	Container c=null;	
//===================================================================
	c=getContentPane();
	ImageIcon image=new ImageIcon("new register1.jpg");
	JLabel lbl=new JLabel(image);
    lbl.setSize(Toolkit.getDefaultToolkit().getScreenSize());
	c.add(lbl);
//====================================================================
	JLabel NAME=new JLabel(" NAME ");
	NAME.setBounds(100,50,100, 25);
	NAME.setFont(new Font("Calibri", Font.ITALIC, 25));
	lbl.add(NAME);

    txtname.setBounds(220, 50,200,25);
    lbl.add(txtname);

	JLabel emailid=new JLabel(" Email id ");
	emailid.setBounds(100,80,100, 20);
	emailid.setFont(new Font("Calibri", Font.ITALIC, 25));
	lbl.add(emailid);	

    txtemailid.setBounds(220, 80,200,25);
    lbl.add(txtemailid);

    JLabel country=new JLabel("Country ");
	country.setBounds(100,105,100, 30);
	country.setFont(new Font("Calibri`", Font.ITALIC, 25));
	lbl.add(country);	

    txtcountry.setBounds(220, 110,200,25);
    lbl.add(txtcountry);
	
    
    
    JLabel unm=new JLabel("username");
	unm.setBounds(100,140,150,20);
	unm.setFont(new Font("Calibri", Font.ITALIC, 25));
	lbl.add(unm);	

    txtunm.setBounds(220, 140,200,25);
    lbl.add(txtunm);

	JLabel pwd=new JLabel("Password");
	pwd.setBounds(100, 170, 100, 20);
	pwd.setFont(new Font("Calibri", Font.ITALIC, 25));
	lbl.add(pwd);
	
    txtpwd.setBounds(220, 170,200,25);
    lbl.add(txtpwd);


    Menugen objmenugen=new Menugen();
    JMenuBar mbar=objmenugen.getmenubar(this);
    setJMenuBar(mbar);
    
    ImageIcon imgbtn=new ImageIcon("registerpage.png");
    JButton register=new JButton(imgbtn);
    register.setBounds(140, 220, 200, 50);
    lbl.add(register);
    
    register.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("working");
		          String strnm,stremailid,strcountry,strunm,strpwd;
		          strnm=txtname.getText();
		          stremailid=txtemailid.getText();
		          strcountry=txtcountry.getText();
		          strunm=txtunm.getText();
		          strpwd=txtpwd.getText();
		          System.out.println("working");
		          
		          Dbhandler objdb=new Dbhandler();
		          objdb.insertintotbllogin(strnm, stremailid, strcountry, strunm, strpwd);
		          
		          dispose();
		          new Mainframe();
		          
		          
		}
	});
    
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
    setLayout(null);
	setTitle("REGISTER PAGE");
	setVisible(true);
	setDefaultCloseOperation(2);
    setSize(Toolkit.getDefaultToolkit().getScreenSize());

}
}
