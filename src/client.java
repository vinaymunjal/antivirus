import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Vector;


public class client 
{ 
	static Vector<String> vctr=new Vector<String>();
		public static void main(String[] args){

		try {
		Socket skt=new Socket("localhost",8500);
		
		InputStream is=skt.getInputStream();
		DataInputStream dis=new DataInputStream(is);
		
		
		String strname=dis.readUTF();
		String stremailid=dis.readUTF();
		String strmsg=dis.readUTF();
		
		vctr.add(strname);
		vctr.add(stremailid);
		vctr.add(strmsg);
		
		System.out.println("Message from : "+strname);
		System.out.println("Email id : "+ stremailid);
		System.out.println(strname+" says : "+strmsg);
	//	System.out.println("msg receied at client");
		dis.close();
		is.close();
		skt.close();
		
	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}

