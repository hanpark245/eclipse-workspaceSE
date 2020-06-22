
public class Calculator 
{
	public int add()
	{
		System.out.println("add()");
		return 2 + 2;
	}
	public int add(int a)
	{
		System.out.println("add(int a)");
		return a + 2;
	}
	public int add(int a, int b)
	{
		System.out.println("add(int a, int b)");
		return a + b;
	}
	public int add(int a, int b, int c)
	{
		System.out.println("add(int a, int b, int c)");
		return a + b + c;
	}
}
