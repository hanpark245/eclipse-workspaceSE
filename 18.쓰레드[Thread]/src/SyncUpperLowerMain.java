
public class SyncUpperLowerMain {

	public static void main(String[] args) {
		Object monitor=new Object();
		SyncUpperThread ut=new SyncUpperThread(monitor);
		ut.setPriority(8);
		SyncLowerThread lt=new SyncLowerThread(monitor);
		lt.setPriority(2);
		
		ut.start();
		lt.start();
	}

}
