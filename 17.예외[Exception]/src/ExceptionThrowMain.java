import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ExceptionThrowMain {
	/*
	public static void main(String[] args) 
			throws 	ClassNotFoundException,
					SQLException, 
					UnknownHostException, 
					IOException {
		System.out.println("stmt1");
		Class.forName("First");
		System.out.println("stmt2");
		//DriverManager.getConnection("");
		System.out.println("stmt3");
		Socket socket=new Socket("www.ddfsdfum.net",80);
		System.out.println(socket);
		System.out.println("stmt4");

	}
	*/
	public static void main(String[] args) throws Exception {
		System.out.println("stmt1");
		Class.forName("First");
		System.out.println("stmt2");
		//DriverManager.getConnection("");
		System.out.println("stmt3");
		Socket socket=new Socket("www.ddfsdfum.net",80);
		System.out.println(socket);
		System.out.println("stmt4");

	}
	
}
