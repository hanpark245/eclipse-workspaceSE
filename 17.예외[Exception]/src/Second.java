import java.io.IOException;
import java.net.Socket;

public class Second {
	public void method2() throws IOException,ClassNotFoundException{
		System.out.println("\t\t Second.method2() 실행");
		/********* case1 ***********/
		/*
		 * 1.JVM이 예외상황을 감지하고 예외객체를 생성 
		 * 2.생성한 예외객체를 반환방향으로 던진다(throw) 
		 * 3.이때 실행중인쓰레드는 실행을
		 *   멈추고 예외의 기작(메카니즘)이 시작된다.
		 */
		String str = "";
		int length = str.length();
		/********* case2 ***********/
		/*
		 * 1. 예외객체생성 \
		 * 2. 예외객체를 던진다. 
		 * 3. 이때 실행중인쓰레드는 실행을 멈추고 예외의 기작(메카니즘)이 시작된다.
		 */
		boolean b = true;
		if (b) {
			NullPointerException exception = new NullPointerException("널애로사항발생");
			throw exception;
		}
		/********* case3 ***********/
		/*
		 * 예외발생시키는 코드가있는 메쏘드(생성자)를 호출했을 경우
		 */
		Socket socket = new Socket("www.naver.com",80);
		socket.getInputStream();
		
		Class.forName("xxx");
		
		System.out.println("\t\t Second.method2() 반환");
	}
}
