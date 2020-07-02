import java.io.IOException;
import java.net.Socket;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ExceptionMultiCatchMain {

	public static void main(String[] args)throws RuntimeException {
		System.out.println("stmt0");
		try {
			int[] ia=new int[3];
			ia[3]=90;
			System.out.println("stmt1");
			Class.forName("Firstdfgsdfh");
			System.out.println("stmt2");
			DriverManager.getConnection("");
			System.out.println("stmt3");
			Socket socket=new Socket("www.daum.net",80);
			System.out.println(socket);
			System.out.println("stmt4");
		}catch (ClassNotFoundException e) {
			System.out.println("catch ClassNotFoundException start");
			System.out.println("catch msg:"+e.getMessage());
			System.out.println("catch ClassNotFoundException end");
		}catch (SQLException e) {
			System.out.println("catch SQLException start");
			System.out.println("catch msg:"+e.getMessage());
			System.out.println("catch SQLException end");
		}catch (IOException e) {
			System.out.println("catch IOException start");
			System.out.println("catch msg:"+e.getMessage());
			System.out.println("catch IOException end");
		}catch (Exception e) {
			System.out.println("catch Exception start");
			System.out.println("catch class:"+e.getClass().getName());
			System.out.println("catch msg:"+e.getMessage());
			System.out.println("catch Exception end");
		}
		System.out.println("stmt99");
		System.out.println("****************************************");
		
		System.out.println("stmt0");
		try {
			int[] ia=new int[3];
			ia[2]=90;
			System.out.println("stmt1");
			Class.forName("First");
			System.out.println("stmt2");
			DriverManager.getConnection("");
			System.out.println("stmt3");
			Socket socket=new Socket("www.daum.net",80);
			System.out.println(socket);
			System.out.println("stmt4");
		}catch (Exception e) {
			System.out.println("catch Exception start");
			System.out.println("catch class:"+e.getClass().getName());
			System.out.println("catch msg:"+e.getMessage());
			System.out.println("catch Exception end");
		}
		System.out.println("stmt99");
		
		
	}

}
