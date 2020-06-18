package notes;
	
public class CarMemberFieldMain 
{

	public static void main(String[] args) {
		/*
		 * 1.입차 1234번 차량 12시  
		 *   - 차객체생성
		 */
		int i=89;
		
		//차객체의 주소를 저장할 변수선언(참조형,객체형,클래스형)
		Car car1=null;
		//차객체를 생성후반환되는 주소값이 car1변수에 대입
		car1 = new Car();
		//차객체의 no멤버변수에 "1234" 대입
		car1.no="1234";
		//차객체의 inTime멤버변수에 12 대입
		car1.inTime=12;
		
		
		/*
		Car car2=new Car(); 
		car2.no="5678";
		car2.inTime=13;
		System.out.println();
		*/
		
		/*
		 * 2. 14시에 1234번차량 출차
		 */
		//car1객체의 outTime멤버변수에 출차시간대입
		car1.outTime = 14;
		//car1객체의 주차요금계산후 car1.fee에대입
		car1.fee = (car1.outTime-car1.inTime)*1000;
		//car1객체의 영수증출력
		System.out.println("-------------------------------------");
		System.out.printf("%s %s %s %s%n","차량번호","입차시간","출차시간","주차요금");
		System.out.println("-------------------------------------");
		System.out.printf("%8s %6d %8d %10d %n",car1.no,car1.inTime,car1.outTime,car1.fee);
		
		
		
		
	}

}
