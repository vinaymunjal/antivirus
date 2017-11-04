import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Label;
import java.awt.ScrollPane;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.FileHandler;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;


public class lastframe extends JFrame 
{
	int noofthreat=0;
public lastframe(){
	
	Container c=getContentPane();
	
	ImageIcon img=new ImageIcon("dontpanic22.jpg");
	JLabel lbl=new JLabel(img);
	lbl.setSize(700, 400);
	c.add(lbl);
	
	
	JScrollBar infectedfiles1=new JScrollBar();
	JTextField infectedfiles[]=new JTextField[Filehandler.vctrinfectedfiles.capacity()];
	int ypos=75,i=0;
	for(String str:Filehandler.vctrinfectedfiles){
		{
	infectedfiles[i]=new JTextField(str);
	infectedfiles[i].setBounds(0,ypos, 700, 20);
	lbl.add(infectedfiles[i]);
	ypos=ypos+20;
	i++;
	}
	

		
}	
	JTextField resultoffiles[]=new JTextField[Filehandler.vctrresult.capacity()];
	int lpos=75,j=0;

	for(String stresult:Filehandler.vctrresult){
		
		if(stresult=="Error in file"){
			resultoffiles[j]=new JTextField(stresult);	
			resultoffiles[j].setBounds(820, lpos, 300, 20);
			resultoffiles[j].setForeground(Color.red);
			lbl.add(resultoffiles[j]);
			lpos=lpos+20;
			j++;
		noofthreat++;
		}
		else{
	resultoffiles[j]=new JTextField(stresult);	
	resultoffiles[j].setBounds(820, lpos, 300, 20);
	resultoffiles[j].setForeground(Color.GREEN);
	lbl.add(resultoffiles[j]);
	lpos=lpos+20;
	j++;
		}
	
	}

	JLabel lblinfectedfiles=new JLabel("File Names");
	lblinfectedfiles.setBounds(100, 20, 500, 50);
	lblinfectedfiles.setFont(new Font("serial", Font.BOLD, 50));
	lblinfectedfiles.setForeground(Color.red);
	lbl.add(lblinfectedfiles);

	JLabel lblresult=new JLabel("Status");
	lblresult.setBounds(890, 20, 300, 50);
	lblresult.setFont(new Font("serial", Font.BOLD, 50));
	lblresult.setForeground(Color.red);
	lbl.add(lblresult);
	
    JLabel noofthreat=new JLabel("Threat Found");
    noofthreat.setBounds(1130, 250, 500, 45);
    noofthreat.setForeground(Color.red);
    noofthreat.setFont(new Font("Calibri", Font.BOLD, 35));
    lbl.add(noofthreat);
	
	JTextField txtnoofthreat=new JTextField();
	txtnoofthreat.setBounds(1130, 290, 150, 25);
	lbl.add(txtnoofthreat);
	
	txtnoofthreat.setText(String.valueOf(this.noofthreat));
	
	ImageIcon imgdeletebtn=new ImageIcon("deletebtn.png");
	JButton deletebtn=new JButton(imgdeletebtn);
	deletebtn.setBounds(1130, 350, 190, 40);
	lbl.add(deletebtn);
	deletebtn.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent arg0) {
		
			for(String str:Filehandler.vctrfiletobedeleted){
		try{
			
				  Path path=Paths.get(str);
		           	
					Files.delete(path);
					  JOptionPane.showMessageDialog(null, "Infected Files deleted");
			   
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    }
			JOptionPane.showMessageDialog(null, "No threat found");
		
		}
	});
	
	ImageIcon imgscanagain=new ImageIcon("scanagain2.png");
	JButton btnscanagain=new JButton(imgscanagain);
	btnscanagain.setBounds(1130, 410, 180, 57);
	lbl.add(btnscanagain);
	btnscanagain.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent arg0) {
		dispose();
		new Welcomeframe();
			
		}
	});
	
	setTitle("Resulted Files");
	setVisible(true);
	setSize(Toolkit.getDefaultToolkit().getScreenSize());
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


}
}
