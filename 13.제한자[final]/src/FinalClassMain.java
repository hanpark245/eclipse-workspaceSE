/*
제한자(final)
	1. 클래스앞에 붙일경우
	   상속금지 
       ex> public final class Test{}
    2. 멤버메쏘드앞에 붙일경우 
       오버라이딩 금지
       ex> public final void print(){}
    3. 멤버변수 앞에붙일경우 --> 상수
       ex> public final int PORT_NUMBER=80;
       상수화된다.    
       변경금지
*/
public class FinalClassMain 
{
	public static void main(String[] args) 
	{
		FinalClass fc1 = new FinalClass();
		System.out.println(fc1.INCENTIVE_RATE);
		System.out.println(fc1.PORT_NUMBER);
		FinalClass fc2 = new FinalClass();
		System.out.println(fc2.INCENTIVE_RATE);
		System.out.println(fc2.PORT_NUMBER);
		
		System.out.println(FinalClass.EAST);
		System.out.println(FinalClass.WEST);
		System.out.println(FinalClass.NORTH);
		System.out.println(FinalClass.SOUTH);
		System.out.println("----------------FinalClassChild-------------");
		FinalClassChild fcc1 = new FinalClassChild();
		fcc1.method1();
		fcc1.method2();
		/*
		fcc1.INCENTIVE_RATE = 90;
		fcc1.PORT_NUMBER = 8080;
		*/
		System.out.println(fcc1.INCENTIVE_RATE);
		System.out.println(fcc1.PORT_NUMBER);
		System.out.println("------------Parent static member-----------");
		System.out.println(FinalClass.EAST);
		System.out.println(FinalClass.WEST);
		System.out.println(FinalClass.NORTH);
		System.out.println(FinalClass.SOUTH);
		System.out.println("------------Child static member-----------");
		System.out.println(FinalClassChild.EAST);
		System.out.println(FinalClassChild.WEST);
		System.out.println(FinalClassChild.NORTH);
		System.out.println(FinalClassChild.SOUTH);
		
	}
}
