import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Vector;

import oracle.jdbc.pool.*;

public class Dbhandler 
{
//	static String str[]=new String[25];
	static Vector<String> vctr=new Vector<String>();	
public Connection getdbconnectionwithoracle(){
	
	
	Connection con=null;
	try {
		OracleDataSource ods=new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
		con = ods.getConnection("j1112","icsd");
		System.out.println("connectin established");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return con;
}

public void deletefilefromextension(){
	
	
}

public void readextensions(){

	
	
	Connection con=getdbconnectionwithoracle();
	try {
		PreparedStatement stmt=con.prepareStatement("select * from extension");
		
		ResultSet rset=stmt.executeQuery();
	
		while(rset.next())
		{
		
		vctr.add(rset.getString("extname"));
		
		}
	//	for (String string : vctr) {
	//		System.out.println(string);
	//	}
		
		
		
		con.close();
		stmt.close();
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}	
public int updateintotbllogin(String unm,String pwd){
	int res=0;
	Connection con=getdbconnectionwithoracle();
    try {
    
 //   	System.out.println("fun working");
		PreparedStatement stmt=con.prepareStatement("update login set pwd=? where unm=?");
		stmt.setString(2, unm);
		stmt.setString(1, pwd);
//		System.out.println(unm+" "+pwd);
		int i=stmt.executeUpdate();
//		System.out.println("i=="+i);
		if(i==1)
		{
			res=1;
		}
		stmt.close();
		con.close();
		System.out.println("fun closed");
	} catch (SQLException e) {

		e.printStackTrace();
	}	
return res;


}

public boolean isvaliduser(String unm,String pwd) {
	
	boolean validuser=false;
	Connection con=getdbconnectionwithoracle();
	try {
		PreparedStatement stmt=con.prepareStatement("select * from login where unm=? and pwd=?");
		stmt.setString(1, unm);
		stmt.setString(2, pwd);
		ResultSet rset=stmt.executeQuery();
		if(rset.next()){
			validuser=true;
		}

	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return validuser;
}

public void insertintotbllogin(String strnm, String stremailid,String strcountry, String strunm, String strpwd)
{
	Connection con =getdbconnectionwithoracle();
	try {
//		System.out.println("fun working");
		PreparedStatement stmt=con.prepareStatement("insert into login values(?,?,?,?,?)");
		stmt.setString(1, strnm);
		stmt.setString(2, stremailid);
		stmt.setString(3, strcountry);
		stmt.setString(4, strunm);
		stmt.setString(5, strpwd);
		stmt.executeUpdate();
		stmt.close();
		con.close();
//		System.out.println("fun closed");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


}
