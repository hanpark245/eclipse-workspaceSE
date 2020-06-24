
public class Child extends Parent
{
	
	public Child() 
	{
		/*
		 *  - 클래스의 생성자 첫번째 라인에서는 
		 *    반드시 부모클래스의 기본(디폴트)생성자가 호출되어야한다.
		 *  - 부모클래스의 생성자를 호출하지 않을시에는 
		 *    부모의 기본생성자를 자동으로 호출한다. --> super();
		 *  - 부모클래스 기본생성자호출은                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             생략이 가능하다.
		 */
		super();
		System.out.println("Child()디폴트 생성자");
	}
	public Child(int member1, int member2, int member3) 
	{
		super(member1, member2);
		System.out.println("Child(int member1, int member2, int member3) 호출");
		this.member1 = member1;
		this.member2 = member2;
		this.member3 = member3;
	}
	


	public int member3;
	public void method3() 
	{
		System.out.println("Child.method3()");
	}
}
