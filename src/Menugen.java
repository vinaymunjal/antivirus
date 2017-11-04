import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class Menugen
{
	JMenuBar mbar;
    JMenu support;
    JMenu aboutus;
    JMenuItem contact,query,company;
	public JMenuBar getmenubar(JFrame frm) {
	mbar=new JMenuBar();
	
		support=new JMenu("Support");
		aboutus=new JMenu("About us");
		
		contact=new JMenuItem("Contact us");
		query=new JMenuItem("Submit a query");
		company=new JMenuItem("Company Overview");
		support.add(contact);
		support.add(query);
		aboutus.add(company);
		
		query.addActionListener(new Menuhandler(frm));
		contact.addActionListener(new Menuhandler(frm));
		company.addActionListener(new Menuhandler(frm));
	    
		mbar.add(support);
		mbar.add(aboutus);
		
		
		return mbar;
	}
   
}
