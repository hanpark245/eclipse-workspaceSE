package lang;

public class MathMain 
{
	public MathMain() 
	{
		/*
		 * 	Math 클래스
		 * 
		 * 		-수학함수를 가지고 있는 클래스
		 * 		-모든메쏘드 static이다
		 * 		-객체생성이 불가능
		 * 			(생성자 접근제한자 private)
		 */
		
		
		
		//Math m = new Math();
		
		int r = Math.abs(-347682);
		System.out.println(r);
		System.out.println(Math.max(34, 2642));
		System.out.println(Math.round(3.14));
		
		
		System.out.println("1부터 10사이의 정수랜덤");
		System.out.println(Math.random());
		System.out.println(Math.random());
		System.out.println(Math.random());
		System.out.println(Math.random());
		System.out.println("1부터 10사이의 로또번호생ㅅ어");

	}
}
