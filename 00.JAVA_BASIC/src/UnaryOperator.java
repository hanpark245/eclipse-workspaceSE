
public class UnaryOperator 
{

	public static void main(String[] args) 
	{
		/*
		 단항연산자
		 	1. 산술연산자
		 	  	- 증가,감소연산자
			   	  ex> i++ , i-- , ++i , --i 
                - 자기자신의값을 정수 1만큼 증가시키거나 감소시키는연산자
			2. 논리(NOT)연산자
			    - true-->false, false-->true
			      ex> !(true) --> false
			3. 부호연산자
			    - 부호를결정함
			      ex> +4, +no ,-9,-no        
         */
		int a = -1;
		int b = 2;
		
		a = -a;
		b = +b;
		System.out.println(a);
		System.out.println(b);
		
		int i=5;
		int j=5;
		
		//i=i+1;
		++i;
		//j=j+1;
		++j;
		System.out.println("--------<++i,++j>---------");	
		System.out.println("++i --> "+i);
		System.out.println("++j --> "+j);
		
		System.out.println("--------<i++,j++>---------");	
		i=5;
		j=5;
		i++;
		j++;
		System.out.println("i++ --> "+i);
		System.out.println("j++ --> "+j);
		
		System.out.println("--------<--i,--j>---------");	
		i=5;
		j=5;
		--i;// i=i-1;
		--j;// j=j-1;
		System.out.println("--i --> "+i);
		System.out.println("--j --> "+j);
		
		System.out.println("--------< i--,j-- >---------");	
		i=5;
		j=5;
		i--;
		j--;
		System.out.println("i-- ==> "+i);
		System.out.println("j-- ==> "+j);
		
		System.out.println("*****************************");	
		
		i=5;
		j=5;
		int ir;
		int jr;
		
		ir = ++i; 
		jr = j++;
		
		System.out.println("++i ==> " + i);
		System.out.println("++j ==> " + j);
		System.out.println("ir = ++i ==> "+ ir);
		System.out.println("ir = ++j ==> "+ jr);
		int count1 = 99;
		int count2 = 99;
		
		System.out.println(++count1 + "번째 방문입니다");
		System.out.println(count2++ + "번째 방문입니다");
		System.out.println("count1-->" + count1);
		System.out.println("count2-->" + count2);	
	}

}
