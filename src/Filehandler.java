import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import javax.sound.midi.SysexMessage;


public class Filehandler
{
	static Vector<String> vctrinfectedfiles=new Vector<String>();
	static Vector<String> vctrresult=new Vector<String>();
	static Vector<String> vctrfiletobedeleted=	new Vector<String>();
int i=0;
public void readfile(){
	
vctrinfectedfiles.clear();
vctrresult.clear();
vctrfiletobedeleted.clear();
	
//	File file=new File("e:\\");
	
//	String str[]=file.list();
//	for (String string : str) {
//		System.out.println(string);
//	}

	
	
Dbhandler dbhandler=new Dbhandler();
//dbhandler.getdbconnectionwithoracle();
	dbhandler.readextensions();

	
	//praveeenhrahne
	
	for(String str :Welcomeframe.vctr){
		int flag=0;	
	String strfullfilenames=Welcomeframe.strfullfilenames[i];
	i++;
	for (String extension : dbhandler.vctr) {
		if(str.equals(extension)){
    		 flag=1;
                		 
//		System.out.println("eeeeeeeeeeeeee"+extension);
		break;
		}
		
	}	
	
	
		
if(flag==0){
	System.out.println("File :"+str);
	System.out.println("file is clean");
	vctrinfectedfiles.add(strfullfilenames);
	
	vctrresult.add("File is clean");
}
if(flag==1){
	System.out.println(str);
	System.out.println("File :"+str );
	System.out.println("error in file");
	vctrinfectedfiles.add(strfullfilenames);
	vctrresult.add("Error in file");
	vctrfiletobedeleted.add(strfullfilenames);

}
	}
	
new lastframe();
}

	}

	