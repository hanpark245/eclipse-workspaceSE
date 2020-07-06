
public class SyncLowerThread extends Thread{
	private Object monitor;
	public SyncLowerThread(Object monitor) {
		this.monitor=monitor;
	}
	@Override
	public void run() {
		while(true) {
			/*
			 * 동기화 블록
			 */
			synchronized (this.monitor) {
				System.out.print("a");
				System.out.print("b");
				System.out.print("c");
				System.out.print("d");
				System.out.print("e");
				System.out.print("f");
				System.out.print("g");
				System.out.print("h");
				System.out.print("i");
				System.out.print("j");
				System.out.print("k");
				System.out.print("l");
				System.out.print("m");
				System.out.print("n");
				System.out.print("o");
				System.out.print("p");
				System.out.print("q");
				System.out.print("r");
				System.out.print("s");
				System.out.print("t");
				System.out.print("u");
				System.out.print("v");
				System.out.print("w");
				System.out.print("x");
				System.out.print("y");
				System.out.print("z");
			}//end sychronized
			
		}//end while
		
	}// end run
}
