
public class PrimitiveTypeArrayStudentMain 
{
	public static void main(String[] args)  
	{
		System.out.println("--학생데이타를 저장하기위한 배열객체의생성 초기화--");
		int noArray[] = {1,2,3,4,5,6,7,8,9,10};
		String nameArray[] = {"KIM","LEE","PAR","CHO","SIM","GOO","PIM","MIN","AIM","LIM"};
		int korArray[] = {34,56,12,89,91,67,88,93,67,99};
		int engArray[] = {44,57,21,83,93,76,81,67,12,39};
		int mathArray[] = {90,56,34,67,23,88,99,78,55,80};
		int totalArray[] = {0,0,0,0,0,0,0,0,0,0};
		double avgArray[] = {0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0};
		char gradeArray[] = new char[10];
		int rankArray[] = {1,1,1,1,1,1,1,1,1,1};
		
		//총점,평균,평점
		for (int i = 0; i < noArray.length; i++) 
		{
			totalArray[i] = korArray[i] + engArray[i] + mathArray[i];
			avgArray[i] = totalArray[i] / 3.0;
		
			if(avgArray[i]>=90) {
				gradeArray[i]='A';
			}else if(avgArray[i]>=80) {
				gradeArray[i]='B';
			}else if(avgArray[i]>=70) {
				gradeArray[i]='C';
			}else if(avgArray[i]>=60) {
				gradeArray[i]='D';
			}else {
				gradeArray[i]='F';
			}
		}
		for (int i = 0; i < noArray.length; i++)
		{
			for (int j = 1; j < rankArray.length; j++) 
			{
				if(totalArray[i] < totalArray[j])
				{
					rankArray[i]++;
				}
			}
		}			
		System.out.println(">>> 3번학생찾아서 1명정보출력");
		for (int i = 0; i < noArray.length; i++) 
		{
			if(noArray[i]==3) 
			{
				System.out.printf("%3d %5s %4d %4d %4d %5d %5.1f %2c %3d\n", noArray[i],nameArray[i],korArray[i],engArray[i],mathArray[i],totalArray[i],avgArray[i],gradeArray[i],rankArray[i]);
				break;
			}
		}
		System.out.println(">>> 학점이F인 학생들 찾아서 출력");
		for (int i = 0; i < gradeArray.length; i++) 
		{
			if(gradeArray[i]=='F') 
			{
				System.out.printf("%3d %5s %4d %4d %4d %5d %5.1f %2c %3d\n", noArray[i],nameArray[i],korArray[i],engArray[i],mathArray[i],totalArray[i],avgArray[i],gradeArray[i],rankArray[i]);
			}
		}
		System.out.println(">>총점순 오름차순 정렬");
		
		for(int i = 0; i <totalArray.length; i++)	
		{
			for (int j = 0; j < totalArray.length - 1; j++) 
			{
				if(totalArray[j] > totalArray[j+1])
				{
					int tempTotal = totalArray[j];
					totalArray[j] = totalArray[j + 1];
					totalArray[j+1] = tempTotal;
				}
			}
		}
	
		
		
		
		
		
		System.out.println("---------------학생 성적출력------------------");
		System.out.printf("%s %s %s %s %s %s %s %s %s\n","학번","이름","국어","영어","수학","총점","평균","평점","석차");
		System.out.println("----------------------------------------------");

		for (int i = 0; i < noArray.length; i++) 
		{
			System.out.printf("%3d %5s %4d %4d %4d %5d %5.1f %2c %3d\n",noArray[i],nameArray[i], korArray[i], engArray[i],mathArray[i],totalArray[i],avgArray[i],gradeArray[i],rankArray[i]);
		}
		System.out.println("----------------------------------------------");
	
	}
}
