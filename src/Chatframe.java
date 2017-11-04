import java.awt.Container;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Chatframe extends JFrame 
{
    JTextField txtname=new JTextField();
    JTextField txtemailid=new JTextField();
    JTextArea txtmsg=new JTextArea();
	public Chatframe(){

		Container c;
		c=getContentPane();
		ImageIcon img=new ImageIcon("img1.jpg");
		JLabel lbl=new JLabel(img);
		lbl.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		c.add(lbl);
		
		JLabel name=new JLabel("Name");
		name.setFont(new Font("Calibri", Font.ITALIC, 25));
		name.setBounds(200, 50, 100, 25);
		lbl.add(name);
		
	
	    txtname.setBounds(200, 80, 500, 25);
	    lbl.add(txtname);
		
	    JLabel emailid=new JLabel("Email id");
	    emailid.setFont(new Font("Calibri", Font.ITALIC, 25));
		emailid.setBounds(200, 110, 100, 25);
		lbl.add(emailid);
		
	
	    txtemailid.setBounds(200, 140, 500, 25);
	    lbl.add(txtemailid);
	    
	    JLabel query=new JLabel("Your Query");
	    query.setFont(new Font("Calibri", Font.ITALIC, 25));
		query.setBounds(200, 170, 300, 30);
		lbl.add(query);
		
	    
	    txtmsg.setBounds(200, 200, 1000, 150);
	    lbl.add(txtmsg);
	    
	    JButton btnsend=new JButton("SEND");
	    btnsend.setFont(new Font("Calibri", Font.ITALIC, 25));
	    btnsend.setBounds(200, 370, 100, 40);
	    lbl.add(btnsend);
	    
	    btnsend.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent we) {
				try{
		
				ServerSocket server=null;
				server=new ServerSocket(8500);
		//		System.out.println("waiting for client");
				
		
		
			
				Socket sktclient=new Socket("localhost",8500);
			//    System.out.println("hey baby");
				OutputStream os=sktclient.getOutputStream();
			    DataOutputStream dos=new DataOutputStream(os);
			   
			   dos.writeUTF(txtname.getText());
			   dos.writeUTF(txtemailid.getText());
			   dos.writeUTF(txtmsg.getText());
			   JOptionPane.showMessageDialog(null, "Your Query submitted succesfully");	
			   
			   os.close();
			   dos.close();
			   sktclient.close();
		     
		
				
				
				
				
				Socket skt=server.accept();
				InputStream is=skt.getInputStream();
				DataInputStream dis=new DataInputStream(is);
				String strname=dis.readUTF();
				String stremailid=dis.readUTF();
				String strmsg=dis.readUTF();
		//		System.out.println(skt.getRemoteSocketAddress());			
				System.out.println("Message from : "+strname);
				System.out.println("Email id : "+ stremailid);
				System.out.println(strname+" says : "+strmsg);
			//	System.out.println("msg receied at client");
				dis.close();
				is.close();
				
				skt.close();			
			  server.close();
			  }
			catch(IOException e){
				e.printStackTrace();
			}
			
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
		setTitle("Chat");
		setVisible(true);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
	    setDefaultCloseOperation(2);

	}
}
