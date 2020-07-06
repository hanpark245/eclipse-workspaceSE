
public class CreateCustomThreadMain {

	public static void main(String[] args) {
		System.out.println("1.main");
		//3. Thread 객체를 생성한다.
		CreateCustomThread cct=new CreateCustomThread();
		System.out.println("2.main");
		//4. Thread 객체를통해서 Thread를 시작시킨다.
		cct.setName("myThread");
		cct.start();
		/*
		<< Thread >>
			public void start(	);
				- Causes this thread to begin execution; 
				  the Java Virtual Machine calls the run method of this thread.
				- The result is that two threads are running concurrently:
				  the current thread (which returns from the call to the start method) 
				  and the other thread (which executes its run method). 
		*/
		while (true) {
			System.out.println("3.main");
		}
		

	}

}
