
public class CreateCustomThreadMain {

	public static void main(String[] args) {
		System.out.println("1.main");
		CreateCustomThread cct=new CreateCustomThread();
		System.out.println("2.main");
		cct.start();
		System.out.println("3.main");
		cct.setName("myThread");
		while (true) 
		{
			System.out.println();	
		}

	}

}
