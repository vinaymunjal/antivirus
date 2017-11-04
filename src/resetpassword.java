import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class resetpassword extends JFrame
{
	JTextField txtunm=new JTextField();
	JTextField txtpwd=new JTextField();

public resetpassword() {

	//===========================set image==================
Container c=getContentPane();
ImageIcon img=new ImageIcon("virus scan5-.jpg");
JLabel lbl=new JLabel(img);
lbl.setSize(Toolkit.getDefaultToolkit().getScreenSize());
c.add(lbl);


ImageIcon img1=new ImageIcon("virus scan.jpg");
JLabel lblimg=new JLabel(img1);
lblimg.setBounds(900, 350, 500, 400);
lbl.add(lblimg);
//============================label======================
JLabel unm=new JLabel("Username");
unm.setBounds(520, 230, 300, 40);
unm.setFont(new Font("Calibri", Font.ITALIC,30 ));
unm.setForeground(Color.black);
lbl.add(unm);

txtunm.setBounds(660, 235, 300, 30);
lbl.add(txtunm);
	
JLabel pwd=new JLabel("New Password");
pwd.setBounds(470, 285, 300, 40);
pwd.setFont(new Font("Calibri", Font.ITALIC, 30));
pwd.setForeground(Color.black);
lbl.add(pwd);

txtpwd.setBounds(660, 285, 300, 30);
lbl.add(txtpwd);

ImageIcon reset=new ImageIcon("reset.png");
JButton btnreset=new JButton(reset);
btnreset.setBounds(580, 340, 150, 40);
lbl.add(btnreset);

btnreset.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent arg0) {
	
		String unm,pwd;
		unm=txtunm.getText();
        pwd=txtpwd.getText();
    
        
        Dbhandler obj=new Dbhandler();
        int res=obj.updateintotbllogin(unm, pwd);
        if(res==1){    
        dispose();
        new Mainframe();
        }
        
        else
        {
        JOptionPane.showMessageDialog(null,"Please enter a valid username");
        txtunm.setText(null);
        txtpwd.setText(null);
        }
	}
});

//====================================label========================

JLabel lbltext=new JLabel("FORGET PASSWORD ??");
lbltext.setBounds(300, 30, 1000, 70);
lbltext.setFont(new Font("Arial", Font.BOLD, 65));
lbltext.setForeground(Color.black);
lbl.add(lbltext);

JLabel lbltext1=new JLabel("Don't worry, we are here to help you out. Reset your password here ");
lbltext1.setBounds(150, 110, 1500, 40);
lbltext1.setFont(new Font("Arial", Font.BOLD, 35));
lbltext1.setForeground(Color.black);
lbl.add(lbltext1);


JLabel lbltext2=new JLabel("THE KILLER");
lbltext2.setBounds(80, 550, 500, 60);
lbltext2.setFont(new Font("Arial", Font.BOLD, 70));
lbltext2.setForeground(Color.BLACK);
lbl.add(lbltext2);

JLabel lbltext3=new JLabel("Kills the virus from its Root......");
lbltext3.setBounds(600, 600, 500, 40);
lbltext3.setFont(new Font("Arial", Font.BOLD, 30));
lbltext3.setForeground(Color.red);
lbl.add(lbltext3);

JLabel lbltext4=new JLabel("RECOMMENDED :");
lbltext4.setBounds(50, 200, 900, 30);
lbltext4.setFont(new Font("Arial", Font.BOLD, 30));
lbltext4.setForeground(Color.red);
lbl.add(lbltext4);

JLabel lbltext6=new JLabel("Please don't share your ");
lbltext6.setBounds(50, 240, 900, 35);
lbltext6.setFont(new Font("Arial", Font.BOLD, 30));
lbltext6.setForeground(Color.red);
lbl.add(lbltext6);

JLabel lbltext7=new JLabel("username and password");
lbltext7.setBounds(50, 270, 900, 35);
lbltext7.setFont(new Font("Arial", Font.BOLD, 30));
lbltext7.setForeground(Color.red);
lbl.add(lbltext7);

JLabel lbltext5=new JLabel("with anyone else.");
lbltext5.setBounds(50, 300, 900, 30);
lbltext5.setFont(new Font("Arial", Font.BOLD, 30));
lbltext5.setForeground(Color.red);
lbl.add(lbltext5);

setLayout(null);
setTitle("Reset Password");
setVisible(true);
setDefaultCloseOperation(2);
setSize(Toolkit.getDefaultToolkit().getScreenSize());
}
}
