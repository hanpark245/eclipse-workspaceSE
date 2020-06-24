
public class OverridingChild extends Overriding
{
	/*
	
	public void method1() 
	{
		System.out.println("Overriding.method1()");
	}
	public void method2()
	{
		System.out.println("Overriding.method2()");
	}
	
	 */
	public void method2()
	{
		System.out.println("----------재정의 method2() start---------");
		System.out.println("Overriding.method2()를 OverridingChild 에서 재정의");
		System.out.println("----------재정의 method2() end---------");
	}
	public void method3()
	{
		System.out.println("OverridingChild.method3()");
	}
}
