//인터페이스는 클래스 혹은 프로그램이 제공하는 기능을 명시적으로 선언하는 역할을 합니다.
//인터페이스는 추상 메쏘드와 상수로만 이루어져있습니다.


public interface Calc
{
	//인터페이스에서 선언한 변수들은 컴파일 과정에서 값이 변하지 않는 상수로 변환됨.
	double PI = 3.14;
	int ERROR = -999999999;
	
	
	//public abstract 생략 가능. Compile 할때 자동으로 변환됨.
	//인터페이스에 선언한 변수는 모두 컴파일 과정에서 값이 변하지 않는 상수로 자동 변환.
	public abstract int add(int num1, int num2);
	int substract(int num1, int num2);
	int times(int num1, int num2);
	double divide(int num1, int num2);
}



