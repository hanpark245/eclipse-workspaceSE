package korea.president;

public class Dj 
{
	public int a;
	protected int b;
	int c;
	private int d;
	
	public void method1(){
		System.out.println("Dj.public_method1()");
	}

	protected void method2(){
		System.out.println("Dj.protected_method2()");
	}

	void method3(){
		System.out.println("Dj.package_method3()");
	}

	private void method4(){
		System.out.println("Dj.private_method4()");
	}
}
