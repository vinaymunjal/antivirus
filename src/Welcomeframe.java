import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;


public class Welcomeframe extends JFrame
{
	int folder=1;
	static Vector<String> vctr=new Vector<String>();
static String strfullfilenames[]=new String[9999999];
int i=0;

public Welcomeframe(){

	vctr.clear();
		Container c=null;
        c=getContentPane();
ImageIcon img= new ImageIcon("welcomepage1.jpg");
JLabel lbl=new JLabel(img);
lbl.setSize(Toolkit.getDefaultToolkit().getScreenSize());
c.add(lbl);

JLabel lblwelcomepage=new JLabel("Scan your PCs & mobiles and make it free from malware.");
lblwelcomepage.setBounds(100, 100, 1400, 50);
lblwelcomepage.setFont(new Font("Calbri", Font.ITALIC, 45));
lblwelcomepage.setForeground(Color.white);
lbl.add(lblwelcomepage);

JLabel lblwel=new JLabel("One of the most trusted Antivirus ");
lblwel.setBounds(300, 160, 1400, 50);
lblwel.setFont(new Font("Calbri", Font.ITALIC, 45));
lblwel.setForeground(Color.white);
lbl.add(lblwel);

JLabel lblwelm=new JLabel("THE KILLER");
lblwelm.setBounds(400, 240, 1400, 60);
lblwelm.setFont(new Font("Calbri", Font.ITALIC, 70));
lblwelm.setForeground(Color.red);
lbl.add(lblwelm);

  ImageIcon imgbtn=new ImageIcon("scanyourpc.png");
  JButton scanbtn=new JButton(imgbtn);
  scanbtn.setBounds(150, 500, 250, 60);
  lbl.add(scanbtn);
  
   scanbtn.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent e) {
               	
	//	dispose();
		
        JFileChooser fc=new JFileChooser();
		fc.setDialogTitle("Scan Files");
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fc.setAcceptAllFileFilterUsed(false);
		int ret=fc.showDialog(fc, "scan");
		System.out.println(ret+ " kkkkkkk");
		
		if(ret==JFileChooser.APPROVE_OPTION){
			
			File str=fc.getSelectedFile();
			String s=str.getPath();
	//		System.out.println("strfile path"+s);             
			File currentdirectory=new File(s);
			System.out.println("current directory -"+currentdirectory);    //it gives same path as string s above
			display(currentdirectory);
			Filehandler filehandler=new Filehandler();
			filehandler.readfile();
		}
		
		
	}
	public void display(File f) {
		
		File files[]=f.listFiles();
		try{
		for (File file : files) {
			if(file.isDirectory()){
	//			folder++;
			
	//		System.out.println("folder numbered"+folder);
			
	//			System.out.println("Folder :"+file.getCanonicalPath());
					
				display(file);
			}
				else{
		//	   int fill=1;
			//	   fill++;
			//	   System.out.println(file.getName());
			//		System.out.println("File :"+file.getCanonicalPath());
			//		System.out.println("file numbered"+fill);
                  vctr.add(file.getName().toString());
 
                  strfullfilenames[i]=file.toString();
				i++;
				}
		
		}
		}
		 catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
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

   Menugen objmenugen=new Menugen();
   JMenuBar mbar=objmenugen.getmenubar(this);
   setJMenuBar(mbar);

setLayout(null);
setTitle("Welcome to the killer");
setVisible(true);
setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
setSize(Toolkit.getDefaultToolkit().getScreenSize());
	}

}
//JFileChooser fileChooser = new JFileChooser();
//fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
//int result = fileChooser.showOpenDialog(this);
//if (result == JFileChooser.APPROVE_OPTION) {
//    File selectedFile = fileChooser.getSelectedFile();
//    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
//}
