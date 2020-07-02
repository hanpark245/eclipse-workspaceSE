package prince;

import korea.president.Ys;

public class YsChild extends Ys
{
	/*
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
	*/
	
	public void access2()
	{
		this.a = 1;
		this.b = 2;
		//this.c = 3;	에러 	package
		//this.d = 4;	에러	private
		this.method1();
		this.method2();
		//this.method3();	에러 	package
		//this.method4();	에러	private
	}
}
