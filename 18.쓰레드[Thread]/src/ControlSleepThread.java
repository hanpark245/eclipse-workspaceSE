import java.util.Date;

public class ControlSleepThread extends Thread{

	public void run(){
		while (true) {
			try {
				//System.out.println("가."+Thread.currentThread().getName());
				/*
				 * 현재실행쓰레드를 1000ms동안 sleep시킨다.(실행중지)
				 */
				Date now=new Date();
				String nowTimeStr = now.toLocaleString();
				System.out.println(nowTimeStr);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
		}
	}
}
