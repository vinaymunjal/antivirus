import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Mainframe extends JFrame
{
	JTextField usertxt=new JTextField();
	JPasswordField pwdtxt=new JPasswordField();

public Mainframe()
{
	Container c=null;	

//====================================================================

c=getContentPane();
ImageIcon image=new ImageIcon("loginpage2.jpg");
JLabel lbl=new JLabel(image);
lbl.setSize(Toolkit.getDefaultToolkit().getScreenSize());
c.add(lbl);
//==========================================================================
JLabel lbluser=new JLabel(" USERNAME ");
lbluser.setFont(new Font("Calibri", Font.ITALIC, 25));
lbluser.setBounds(850,100,200, 25);
lbl.add(lbluser);

JLabel lblpass=new JLabel(" PASSWORD ");
lblpass.setFont(new Font("Calibri", Font.ITALIC, 25));
lblpass.setBounds(850,150,200, 25);
lbl.add(lblpass);
//=====================================================================
usertxt.setBounds(1000, 100, 150, 25);

pwdtxt.setBounds(1000, 150, 150, 25);
lbl.add(usertxt);
lbl.add(pwdtxt);


//============================================================================
ImageIcon imglogin=new ImageIcon("loginbtn.png");
JButton loginbtn=new JButton(imglogin);
loginbtn.setBounds(950,200,160,55);
lbl.add(loginbtn);

loginbtn.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent arg0) {
	
		Dbhandler objdb=new Dbhandler();
		String unm,pwd;
		unm=usertxt.getText();
		pwd=pwdtxt.getText();
		boolean res=objdb.isvaliduser(unm,pwd);
		if(res==true){
		dispose();
	    new Welcomeframe();}
		else{
			JOptionPane.showMessageDialog(null, "INVALID USER");
			usertxt.setText(null);
			pwdtxt.setText(null);
		}
	}
});

//===========================register===================
JLabel lblregister=new JLabel("Haven't register yet ?...");
lblregister.setFont(new Font("Calbri", Font.ITALIC, 20));
lblregister.setBounds(950, 10, 300, 25);
lbl.add(lblregister);

ImageIcon imgregister=new ImageIcon("registerbtn.png");
JButton regbtn=new JButton(imgregister);
regbtn.setBounds(1170,10,150,45);
lbl.add(regbtn);

regbtn.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent arg)
{
dispose();	
new RegisterFrame();	
}});


//=========================forget password==================
ImageIcon forget=new ImageIcon("forget.png");
JButton btnforgetpassword=new JButton(forget);
btnforgetpassword.setBounds(1120, 200, 200, 55);
lbl.add(btnforgetpassword);

btnforgetpassword.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent arg0) {
	
		dispose();
		new resetpassword();
		
	}
});

 //==========================MENUBAR================================================
Menugen objmenugen=new Menugen();

JMenuBar mbar=objmenugen.getmenubar(this);
setJMenuBar(mbar);


JLabel lblcenter=new JLabel("The lighest Killer Antivirus yet");
lblcenter.setFont(new Font("arial", Font.BOLD, 70));
lblcenter.setBounds(200, 400, 1000, 80);
lblcenter.setForeground(Color.black);
lbl.add(lblcenter);

JLabel lblcenter1=new JLabel("Don't waste a minute.Scan fast,lightweight protection that won't slow you down.");
lblcenter1.setFont(new Font("arial", Font.PLAIN, 25));
lblcenter1.setBounds(200, 490, 1000, 30);
lblcenter1.setForeground(Color.black);
lbl.add(lblcenter1);

JLabel lblsidelower=new JLabel("Windows 8.1,10 compatible");
lblsidelower.setFont(new Font("arial", Font.BOLD, 25));
lblsidelower.setBounds(1000, 600, 400, 40);
lblsidelower.setForeground(Color.black);
lbl.add(lblsidelower);


setLayout(null);
setTitle("ANTIVIRUS");
setVisible(true);
setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
setSize(Toolkit.getDefaultToolkit().getScreenSize());
}
}
