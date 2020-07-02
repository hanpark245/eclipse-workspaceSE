package america.president;

public class Trump {
	public int a;
	protected int b;
	int c;
	private int d;
	
	public void method1(){
		System.out.println("Trump.public_method1()");
	}

	protected void method2(){
		System.out.println("Trump.protected_method2()");
	}

	void method3(){
		System.out.println("Trump.package_method3()");
	}

	private void method4(){
		System.out.println("Trump.private_method4()");
	}
}
