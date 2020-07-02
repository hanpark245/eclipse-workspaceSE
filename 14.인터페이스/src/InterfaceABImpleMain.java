
public class InterfaceABImpleMain 
{
	public static void main(String[] args) 
	{
		System.out.println("---------------------InterfaceABImpl----------------------");
		InterfaceABImpl abImpl = new InterfaceABImpl();
		abImpl.method1();
		abImpl.method2();
		abImpl.method3();
		abImpl.method4();
	
		System.out.println("---------------------InterfaceA----------------------");
		InterfaceA ia = abImpl;
		ia.method1();
		ia.method2();
		
		System.out.println("---------------------InterfaceB----------------------");
		InterfaceB ib = abImpl; 
		ib.method3();
		ib.method4();
		
		System.out.println("---------------------Object----------------------");
		/*
		o.method1();
		o.method2();
		o.method3();
		o.method4();
		*/
		
		
		System.out.println("---------------------InterfaceA<-->InterfaceB----------------------");
		InterfaceA ia2 = new InterfaceABImpl();
		ia2.method1();
		ia2.method2();
		InterfaceB ib2 = (InterfaceB)ia2;
		ib2.method3();
		ib2.method4();

		
	}
}
