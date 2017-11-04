import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;


public class Menuhandler implements ActionListener {
       JFrame frm;
	public Menuhandler(JFrame frm){
		this.frm=frm;
	}
	public void actionPerformed(ActionEvent e) {
	
		String stractioncmd=e.getActionCommand();
	//	System.out.println("hello");
		if(stractioncmd.equals("Submit a query")){
			frm.dispose();
			new Chatframe();
		}
		if(stractioncmd.equals("Contact us")){
			frm.dispose();
			new contactframe();
		}
		if(stractioncmd.equals("Company Overview")){
	//		System.out.println("about us");
			frm.dispose();
			new companyframe();
		}
		
		
		
	}

}
