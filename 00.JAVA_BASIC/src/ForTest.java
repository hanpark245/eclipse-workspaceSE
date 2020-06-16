/*
	for문
	     -형식:
	       	       
	       for(1;2;3)
	       {
	       	//1.반복변수(선언,초기화가능)
	       	//2.반복변수의 조건검사(논리형데이타)
	       	//3.반복변수증,감(++,--)
	       }
	       
	       ex>
	       for(int i=0;i<10;i++)
	       {
	       	 stmt1;
	       }
	       ex>무한루프
	       for(;;){
	       }
	*/
public class ForTest 
{
	public static void main(String[] args)
	{
		System.out.println("--------------while------------");
		int k = 0;
		while(k < 10)
		{
			System.out.println("k = " + k);
			k++;
		}
		System.out.println("--------------for i 증가------------");
		for(int i = 0; i < 10; i++)
		{
			System.out.println("i = " + i);
		} 
		
		/*주석단축키
			1줄주석 ctrl + /
			여러줄주석 ctrl + shift + /
			<<i cannot be resolved to a variable>>
			System.out.println(i);
		*/
		System.out.println("--------for i 감소--------");
		for(int i = 0; i < 10 ; i++)
		{
			System.out.println("i = " + i);
		}
		System.out.println("--------홀수출력[1~10]--------");
		for(int i = 1; i <= 10; i++)
		{
			if(i % 2 == 1)
			{
				System.out.printf("i = %d", i);
			}
		}//9972 5242 4230 0885 2445 568 Koegler Kaitlyn Denise
		System.out.println("--------홀수출력[1~10] continue--------");
		for(int i = 1; i <=10; i++)
		{
			if(i % 2 == 0)
			{
				continue;
			}
			System.out.printf("%d, ", i);		
		}
		System.out.println("--------3과 4의 공배수--------");
		for(int i = 1; i <= 100; i++)
		{
			if(i % 3 == 0 && i % 4 == 0)
			{
				System.out.println("i = " + i);
				//반복문을 빠져나옴
				break;
			}
		}
		System.out.println("--------3과 4의 공배수--------");
		int tot = 0;
		int evenTot = 0;
		int oddTot = 0;
		for(int i = 1; i <= 100; i++)
		{
			if(i % 2 == 0)
			{
				evenTot += i;
			}
			else
			{
				oddTot += i;
			}
			tot =+ i;
		}
		System.out.println("홀수합:" + oddTot);	
		System.out.println("짝수합:" + evenTot);	
		System.out.println("전체합:" + tot);	
		System.out.println("--------문자출력--------");
		for(char c = 'a'; c <= 'z'; c++)
		{
			System.out.print(c);
			if(c == 'z')
			{	
				continue;			//조건문으로 다시 돌아감
			}
			System.out.print(",");
		}
		System.out.println();
		System.out.println();		
		for(int c = 'a', count = 1; c <= 'z'; c++)
		{
			System.out.print((char)c + " ");
			if(count % 5 == 0)
			{
				System.out.println();
			}
			count++;
		}
		System.out.println();
	}
}
