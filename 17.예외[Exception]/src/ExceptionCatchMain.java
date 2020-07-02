import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ExceptionCatchMain {

	public static void main(String[] args) {
		
		System.out.println("stmt1-1");
		
		try {
			System.out.println("stmt1-2");
			Class.forName("Firstsdfsdfsd");
			System.out.println("stmt1-3");
		} catch (ClassNotFoundException e) {
			System.out.println("catch start stmt1-4 ");
			System.out.println("catch msg:"+e.getMessage());
			System.out.println("catch end   stmt1-5 ");
		}
		
		System.out.println("stmt2");
		
		try {
			System.out.println("stmt2-1");
			DriverManager.getConnection("");
			System.out.println("stmt2-2");
		} catch (SQLException e) {
			System.out.println("catch start stmt2-3");
			System.out.println("catch msg:"+e.getMessage());
			System.out.println("catch start stmt2-4");
		}
		
		System.out.println("stmt3");
		
		try {
			System.out.println("stmt3-1");
			Socket socket=new Socket("www.cvccvcv.net",80);
			System.out.println(socket);
			System.out.println("stmt3-2");
		} catch (IOException e) {
			System.out.println("catch start stmt3-3");
			System.out.println("catch msg:"+e.getMessage());
			System.out.println("catch end stmt3-4");
		}
		
		System.out.println("stmt4");

	}

}
