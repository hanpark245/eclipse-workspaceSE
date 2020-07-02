import java.io.IOException;

public class ExceptionThrowMechanismMain {

	public static void main(String[] args) throws IOException,ClassNotFoundException{
		System.out.println("1.main 흐름 start");
		First first=new First();
		System.out.println("2.main 흐름 first.method1() 호출");
		first.method1();
		System.out.println("3.main 흐름 first.method1() 반환");
		

	}

}
