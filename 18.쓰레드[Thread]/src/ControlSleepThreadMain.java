
public class ControlSleepThreadMain {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("1.main");
		System.out.println("2.main 쓰레드 3초간 sleep");
		Thread.sleep(3000);
		
		ControlSleepThread controlSleepThread=new ControlSleepThread();
		controlSleepThread.setName("sleep thread");
		controlSleepThread.start();
		
		System.out.println("3.main 쓰레드 10초간 sleep");
		Thread.sleep(10000);
		System.out.println("99.main thread 10초후 깨어나서 실행 return --> JVM ");
		return;
	}

}
