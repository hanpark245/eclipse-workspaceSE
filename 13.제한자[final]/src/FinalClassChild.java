
public class FinalClassChild extends FinalClass
{
	@Override
	public void method1()
	{
		System.out.println("FinalClassChild에서 FinalClass.method1()재정의");
	}
	/*
	 * <<Cannot override the final method from FinalClass>>
	private void method2() 
	{
		
	}
	*/
}

