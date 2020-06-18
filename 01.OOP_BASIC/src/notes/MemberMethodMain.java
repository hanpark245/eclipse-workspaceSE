package notes;

public class MemberMethodMain 
{
	public static void main(String[] args)
	{
		MemberMethod mm = new MemberMethod();
		/*
		 * 멤버필드접근
		 * 참조변수.멤버필드이름
		 */
		mm.member1 = 45645;

		System.out.println("main 흐름 start");
		/*
		 *	멤버메쏘드 실행(호출)
		 * 	-형식 : 참조변수.메쏘드이름()
		 *	-mm객체의 method1메쏘드 블록을 실행하기위해
		 *	main 실행흐름을 method1블록으로 보낸다
		 */	
		System.out.println("main 흐름 1");
		mm.method1();
		
		System.out.println("main 흐름 2");
		mm.method2(3);
		
		System.out.println("main 흐름 3");
		
		mm.method3("박강한은 잘생겼다", 10);
		mm.method3("박강한은 좀생겼다", 2);
		
		System.out.println("main 흐름 4");
		mm.method4("박강한", "안녕하세요", 3);
		mm.method4("페이커", "사랑해요", 3);
		System.out.println("main 흐름 end");
		return;
	}

}
