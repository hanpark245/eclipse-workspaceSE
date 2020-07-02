package korea.president;

import america.president.Trump;

public class Ys {
	
	public int a;
	protected int b;
	int c;
	private int d;
	
	public void method1(){
		System.out.println("Ys.public_method1()");
	}

	protected void method2(){
		System.out.println("Ys.protected_method2()");
	}

	void method3(){
		System.out.println("Ys.package_method3()");
	}

	private void method4(){
		System.out.println("Ys.private_method4()");
	}
	public void accss()
	{
		//Ys와 같은 패키지 
		Dj dj = new Dj();
		dj.a = 1;
		dj.b = 2;
		dj.c = 3;
		//dj.d = 4;		에러
		dj.method1();
		dj.method2();
		dj.method3();
		//dj.method4();	에러
		
		
		//Ys와 다른 패키지
		Trump trump = new Trump();
		trump.a = 1;
		//trump.b = 2;		에러
		//trump.c = 3;		에러
		//trump.d = 4;		에러
			
		trump.method1();
		//trump.method2();	에러
		//trump.method3();	에러
		//trump.method4();	에러
	}

}
