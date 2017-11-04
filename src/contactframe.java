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
import javax.swing.JMenuBar;


public class contactframe extends JFrame
{
public contactframe(){
	setLayout(null);
	
	Container c=null;
	c=getContentPane();
	ImageIcon img=new ImageIcon("contactpage.jpg");
	JLabel lbl=new JLabel(img);
	lbl.setSize(Toolkit.getDefaultToolkit().getScreenSize());
	c.add(lbl);
	
	JLabel lblcontact=new JLabel("For Technical Support :");
	lblcontact.setFont(new Font("Serial", Font.BOLD	, 50));
	lblcontact.setForeground(Color.white);
    lblcontact.setBounds(50, 100, 1000, 80);
	lbl.add(lblcontact);

	String lblinfo[]={"Vinay Munjal","DCRUST,Murthal","9999999999","mail me:","vinaymunjal6723@gmail.com"};
	JLabel[] lblnames=new JLabel[lblinfo.length];
	int ypos[]={200,250,300,400,450,500};
	for(int i=0;i<lblinfo.length;i++){
	lblnames[i]=new JLabel(lblinfo[i]);
	lblnames[i].setFont(new Font("Calibri",Font.ITALIC, 40));
	lblnames[i].setForeground(Color.white);
	lblnames[i].setBounds(50,ypos[i],500,45);
	lbl.add(lblnames[i]);
	}
	
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

    setTitle("Contact us");
	setVisible(true);
	setSize(Toolkit.getDefaultToolkit().getScreenSize());
	setDefaultCloseOperation(2);
	
}
}
