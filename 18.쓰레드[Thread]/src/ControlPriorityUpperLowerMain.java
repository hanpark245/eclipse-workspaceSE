
public class ControlPriorityUpperLowerMain {

	public static void main(String[] args) {
		System.out.println("1.main");
		ControlPriorityUpperThread ut=new ControlPriorityUpperThread();
		ControlPriotiryLowerThread lt=new ControlPriotiryLowerThread();
		/*
		 * priority설정 
		 *   - CPU 의 점유권을얻을수있는 우선순위설정
		 *   - 1~10 까지의 우선순위를 가짐 
		 */
		ut.setPriority(8);
		lt.setPriority(3);
		ut.start(); 
		lt.start();
		System.out.println("99.main return");
		

	}

}
