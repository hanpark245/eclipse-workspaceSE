/*
 배열:  
      - 같은데이타형을 가진 기억장소여러개의 모음 
      - 배열변수의 선언형식
           데이타타입[] 이름; 
	  - 사용: 
	       1.배열객체의생성	
		   2.배열객체의 초기화 
      -특징   
		  1.모든 배열형의 변수는 참조변수이다.
		    (배열은 객체다.)
		  2.같은타입만 정의가가능하다 
		  3.길이가 고정되어있다. 
		 
 */
public class PrimitiveTypeMain 
{
public static void main(String[] args) {
		
		int pi=34;
		int[] ia = new int[5];
		
		ia[0] = 11;
		ia[1] = 22;
		ia[2] = 33;
		ia[3] = 44;
		ia[4] = 55;
		
		System.out.println("----------------------");
		System.out.println(ia[0]);
		System.out.println(ia[1]);
		System.out.println(ia[2]);
		System.out.println(ia[3]);
		System.out.println(ia[4]);
		
		System.out.println("---------for loop------");
		System.out.println("배열의크기:"+ia.length);
		for(int i=0;i<ia.length;i++) {
			System.out.println(ia[i]);
		}
		System.out.println("-------------기본형 1차원배열--------------");
		int[] korArray=new int[10];
		korArray[0]=80;
		korArray[1]=56;
		korArray[2]=78;
		korArray[3]=99;
		korArray[4]=88;
		korArray[5]=34;
		korArray[6]=78;
		korArray[7]=93;
		korArray[8]=12;
		korArray[9]=98;
		
		int korTot=0;
		for (int i = 0; i < korArray.length; i++) {
			korTot+=korArray[i];
		}
		System.out.println("반전체 국어총점");
		System.out.println(korTot);
		System.out.println("국어 반평균:"+korTot / korArray.length);
		
		char[] ca=new char[6];
		ca[0]='H';
		ca[1]='e';
		ca[2]='l';
		ca[3]='l';
		ca[4]='o';
		ca[5]='!';
		for (int i = 0; i < ca.length; i++) {
			System.out.print(ca[i]);
		}
		System.out.println();
		System.out.println("-----------배열객체생성초기화---------------");
		int[] scoreArray = {56,77,23,88,92,61,93,43,57,99};
		char[] gradeArray= {'A','B','F','D','B','C','A','A','F','B'};
		boolean[] marriedArray= {true,true,false,true,false,true,false,false,false,false};
		String[] nameArray = {"Kim", "Lee" , "Park", "Choi", "Sim", "Hong", "Kang", "Kwon", "Jung"};
		for (int i = 0; i < nameArray.length; i++) 
		{
			System.out.printf("%d %c %b %s %n", scoreArray[i], gradeArray[i], marriedArray[i], nameArray[i]);
		}
		int[] ia2;
		int ia3[];
		
		
	}


}
