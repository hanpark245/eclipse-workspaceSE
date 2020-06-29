
public class FinalClass 
{
	public final int PORT_NUMBER = 80;
	public final int INCENTIVE_RATE;
	public final static int NORTH = 0;
	public final static int SOUTH = 1;
	public final static int EAST = 2;
	public final static int WEST = 3;
	
	public FinalClass()
	{
		this.INCENTIVE_RATE = 10;
		//this.INCENTIVE_RATE = 15;
		//this.PORT_NUMBER = 8080;
		System.out.println(this.INCENTIVE_RATE);
		System.out.println(this.PORT_NUMBER);
		System.out.println(FinalClass.EAST);
		System.out.println(FinalClass.WEST);
		System.out.println(FinalClass.NORTH);
		System.out.println(FinalClass.SOUTH);

	}
		
	public void method1()
	{
		System.out.println("FinalClass.method1()");
	}
	public final void method2()
	{
		System.out.println("FinalClass.method2() 난 final 매쏘드 재정의 금지");
	}
	
	public void move(int direction)
	{
		switch(direction)
		{
			case FinalClass.NORTH:
				System.out.println("move North");
				break;
			case FinalClass.SOUTH:
				System.out.println("move South");
				break;
			case FinalClass.EAST:
				System.out.println("move East");
				break;
			case FinalClass.WEST:
				System.out.println("move West");
				break;
		}
	}
}
