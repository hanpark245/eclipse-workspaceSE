/*
 * 오버라이딩(재정의)
 *   1. 상속관계에서 발생하는 메쏘드의 재정의 기법이다
 *   2. 자바의 다형성 기법중의하나이다.
 *   
 *   -형태 : 부모클래스에정의 된 메쏘드의 이름,리턴타입,인자가
 *          동일한 메쏘드를 자식클래스에 정의(재정의)하는것
 * 
 *   - ex> public class Super{
 *   			public void print(){
 *   			}		
 *   		}
 *        
 *        public class Sub extends Super{
 *        		public void print(){
 *        		}
 *        }
 * 
 */

public class OverridingMain 
{
	public static void main(String[] args) 
	{
		OverridingChild oc = new OverridingChild();
		oc.method1();
		oc.method2();
		oc.method3();
		/*
		 *  상속받은 method2()는 은폐되고 재정의된 메쏘드만 호출됨
		 */
	}
}
