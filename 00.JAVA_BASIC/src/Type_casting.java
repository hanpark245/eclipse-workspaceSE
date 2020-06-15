/* 
 * 	------형변환(casting) --> 숫자형데이터간에만 가능
 * 
 * 		-형식: (데이터타입)변수 or 숫자형리터럴;
 * 		
 * 		-자동(묵시적)형변환(작은데이타 --> 큰데이터) up-casting
 * 			byte > short > int > long > float > double
 * 		
 * 		-강제(명시적)형변환(큰데이터 > 작은데이터) down-casting
 * 			double > float > long > int > short > byte
 */


public class Type_casting 
{
	public static void main(String[] args)
	{
		byte b = 127;
		short s = 32767;
		char c = 'A';
		int i = 2147483647;
		long l = 2147483648l;    			//TODO ask Default 값이 4byte 아님 아예 안잡힘?
		//float f = (float)3.14;
		float f = 3.14f;
		double d = 3.14;
		
	
		//-----------------자동형변환----------------
		double dr = b; 		//내부적으로 (double)b 사용하여 확장
		dr = s;
		dr = c;
		dr = i;
		dr = l;
		dr = f;
		dr = d;
		System.out.println("dr =" + dr);
		//-----------------강제(명시적)형변환----------------
		int iResult = (int)l;
		System.out.println("long -> int casting: " + iResult);
		iResult = (int)d;
		System.out.println("double -> int casting: " + iResult);
		iResult = (int)f;
		System.out.println("float -> int casting: " + iResult);
		
		double davg = 85.665;
		System.out.println(davg);
		int iavg = (int)davg;
		System.out.println(iavg);
		
		//-----------연산시의 형변환--------------------
		/* 	
		/* 연산항들중에 가장큰타입으로 모든항이 형변환된다.
		/*
		/* 
		/---------------------------------------------*/
		
		double dResult =  23 + 0.1 + 90 + 's';		//0.1 이 double 이기 때문에 연산을 double 형으로 계산한다.
		int tot = 67 + 42 + 81;
		System.out.println("total: " + tot);
		double avg = tot / 3.0;
		System.out.println("average: " + avg);
		System.out.println("----------------연산시의 형변환예외-----------");
		byte bb = 90;
		short ss = 89;
		int ii = 78;
		long ll = 90;
		System.out.println("dResult = " + dResult);
		long llResult = bb + ss + ii + ll;
		System.out.println("llResult = " + llResult);
		
		int ssResult = bb + ss;				//Short와 byte 연산은 int 로 진행된다.
		System.out.println("byte, short의 연산은 모든항이 int로 형변환후 연산된다");
		System.out.println("ssResult = " + ssResult + "\nllResult = " + llResult);
	}
}
