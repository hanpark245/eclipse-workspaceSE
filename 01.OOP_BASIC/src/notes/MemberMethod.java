package notes;

public class MemberMethod 
{
	//멤버변수(인스턴스변수)
	int member1;
	
	//멤버메소드(인스턴스메쏘드)
	void method1()
	{
		System.out.println("MemberMethod.method1() 실행");
		/*
		 * 	모든메쏘드의 마지막에는 항상 실행흐름 호출한곳으로 반환 => return;
		 * 	반환타입(return type)이 void 는 생략가능
		 */
		return;
	}
	
	
	void method2(int count)
	{
		System.out.println("MemberMethod.method2(int count) count: " + count);
		return;
	}
	
	void method3(String msg, int count)
	{	
		for(int i = 0; i < count; i++)
		{
			System.out.println("MebmerMethod.method3(String msg, int count)" + msg);
		}
	}
	
	void method4(String name, String msg, int count)
	{
		String result;
		result = name + "님 " + msg;
		for(int i = 0; i < count; i++)
		{
			System.out.println("MebmerMethod.method4(String msg, String msg, int count)" + result);
		}
	}
	
}
/*
 * class 선언
 *  - 형식
 *       접근제한자  class  클래스이름{
 *       	- 접근제한자:public,protected,없는거
 *       
 *       } 
 *       ex> public class Car{
 *           }
 *           
 *  -구성요소
 *     1.멤버변수선언(속성)
 *        접근제한자(public,proected,없는거,private) 타입 indentifier;
 *        ex> public String carName;
 *        
 *     2.멤버메쏘드 선언(행위)    
 *        접근제한자 리턴타입 메쏘드이름(인자){
 *           -인자: 나를 호출한놈이 데이타를 넣어줄 통로
 *        	 -리턴타입: 나를 호출한놈에게 줄 데이타타입 
 *                     void --> 줄데이타가 없는경우
 *        }
 *        ex> public int test(int a){
 *        	  	
 *            }
 */
