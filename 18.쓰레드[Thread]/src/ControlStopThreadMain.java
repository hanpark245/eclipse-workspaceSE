
public class ControlStopThreadMain {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("1.main");
		ControlStopThread cst=new ControlStopThread();
		cst.setName("stop쓰레드");
		cst.start();
		System.out.println("2.main sleep ");
		Thread.sleep(321);
		/*
		 * case1 :  Thread.stop()
		 *  	- 호출한순간종료
		 *  	- Deprecated. This method is inherently unsafe. 
		 */
		//cst.stop();
		
		/*
		 * case2 :  isPlay변수-->false
		 *   - 조건변경으로 종료시킴
		 */
		cst.setPlay(false);
		/*
		 * case3 :  쓰레드가 할일을다하면 스스로 종료
		 */
		
		/*
		 * main 쓰레드는 cst쓰레드가 죽을때까지 대기
		 */
		cst.join();
		System.out.println();
		System.out.println("99.main return");

	}

}
