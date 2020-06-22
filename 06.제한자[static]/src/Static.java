/*
 * static 제한자(제어자,modifier)
 *   1.멤버변수나,메쏘드 앞에 부칠수있다
 * 	 2.static 제한자가 붙어있는 변수나메쏘드는
 *     객체생성 없이도 사용이가능하다.
 *   3.클래스가 가지고있는 변수나메쏘드이다.
 *     -->클래스변수,클래스메쏘드라고도한다.
 *   4.클래스로부터 생성되는 객체들이 공유하는
 *     변수(메쏘드)이다.      
 *     -->공용변수(메쏘드)라고도한다.
 *     
 *  -형식: 
 *  	멤버변수: public static int i;
 * 		멤버메쏘드:public static void print(){}
 * 
 * 
 * 	변수
 * 		1.지역변수
 * 		2.멤버변수
 * 			2.1 인스턴스변수(객체변수)
 * 			2.2 클래스변수(스태틱, 정적, 공용변수)
 *	
 *	메쏘드
 *		1.1 객체 메쏘드 (인스턴스)
 *		1.2 클래스 메쏘드(정적, 공용)
 *
 */
	
public class Static 
{
	public int instance_member_field = 100;
	public static int static_member_field = 200;
	public void instance_method()
	{
		System.out.println("난 인스턴스 메쏘드");
	}
	public static void static_method()
	{
		System.out.println("난 정적(스태틱) 메쏘드");
	}
}
