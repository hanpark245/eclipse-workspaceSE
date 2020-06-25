
public class AbstractClassMain 
{
	public static void main(String[] args) 
	{
		//Cannot instantiate the type AbstractClass
		//AbstractClass ac1 = new AbstractClass();
		AbstractClassChild acc1 = new AbstractClassChild();
		acc1.method1();
		acc1.method2();
		
		AbstractClass ac2 = new AbstractClassChild();
		ac2.method1();
		ac2.method2();
	}
}
