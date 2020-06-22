
public class LocalVariableInitializationMain 
{

	public static void main(String[] args) 
	{
		
		int a = 9;
		int b = 10;
		
		int t = a;
		a = b;
		b = t;
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		
		int tot;
		/*
		<< The local variable tot may not have been initialized >>
		tot = tot + 1;
		*/
		tot = 0;
		tot = tot + 1;
		
		int a1 = a;
		int b1 = b;
		
		LocalVariableInitialization m1 = new LocalVariableInitialization(1, "KIM");
		m1.print();
		LocalVariableInitialization m2 = null;
		/*
		 * null : 객체주소리터럴
		 *     - 참조변수초기화의 용도로사용
		 *     - 주소값이 없다라는 값이다
		 */
		if(m2 == null) 
		{
			m2 = new LocalVariableInitialization(2,"LEE");
			m2.print();
		}
		else 
		{
			m2.print();
		}
		
		System.out.println("-----------------------------------------");
		LocalVariableInitialization m3 = new LocalVariableInitialization(3, "SAM");
		LocalVariableInitialization m4 = null;
		m4 = m3;
		m3.print();
		m4.print();
		if(m3 == m4) 
		{
			System.out.println("m3와 m4의 주소값이 동일하다.");
		}
		else 
		{
			System.out.println("m3와 m4의 주소값이 동일하지않다.");
		}
		
		LocalVariableInitialization firstMember = new LocalVariableInitialization(1111,"FIRST");
		LocalVariableInitialization secondMember = new LocalVariableInitialization(2222,"SECOND");
		firstMember.print();
		secondMember.print();
		
		LocalVariableInitialization tempMember=firstMember;
		firstMember = secondMember;
		secondMember=tempMember;
		
		firstMember.print();
		secondMember.print();
		
	}

}








