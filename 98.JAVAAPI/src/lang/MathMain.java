package lang;

public class MathMain {

	public static void main(String[] args) {
		/*
		 * Math 클래스
		 *    - 수학함수를 가지고있는클래스
		 *    - 모든메쏘드 static 이다.
		 *    - 객체생성이 불가능
		 *       (생성자 접근제한자 private)
		 */
		
		//Math m=new Math();
		
		int r = Math.abs(-3468732);
		System.out.println(r);
		System.out.println(Math.max(56, 89));
		System.out.println(Math.min(56, 89));
		System.out.println(Math.round(33.5555));
		System.out.println(Math.round(33.5555*10)/10.0);
		System.out.println(Math.pow(2, 10));
		System.out.println(Math.sqrt(2));
		
		/*
		 public static double random()
					Returns a double value with a positive sign, 
					greater than or equal to 0.0 and less than 1.0. 
		 */
		System.out.println(Math.random());
		System.out.println("1~10사이의정수랜덤생성");
		System.out.println((int)(Math.random()*10)+1);
		System.out.println((int)(Math.random()*10)+1);
		System.out.println((int)(Math.random()*10)+1);
		System.out.println((int)(Math.random()*10)+1);
		System.out.println("1~45사이의로또번호생성");
		System.out.println((int)(Math.random()*45)+1);
		System.out.println((int)(Math.random()*45)+1);
		System.out.println((int)(Math.random()*45)+1);
		System.out.println((int)(Math.random()*45)+1);
		System.out.println((int)(Math.random()*45)+1);
		System.out.println((int)(Math.random()*45)+1);
	}

}
