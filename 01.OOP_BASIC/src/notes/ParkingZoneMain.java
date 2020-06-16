package notes;
	
public class ParkingZoneMain 
{
	//1. 입차 1234번 차량 12시
	//	-차객체 생성
	public static void main(String[] args)
	{
		//차 객체의 주소를 저장할 변수를 선언(참조형, 객체형, 클래스형)
		Car car1 = null;
		
		//차 객체를 생성후 반환되는 주소값을 car1 변수에 대입
		car1 = new Car();
		//차 객체의 no 멤버변수에 "1234" 대입 (heap 메모리에서)
		car1.no = "1234";
		//차 객체의 inTime 멤버변수에 12 대입 (heap 메모리에서)
		car1.inTime = 12;

		/*
		Car car2 = new Car();
		car2.no = "5678";
		car2.inTime = 13;
		
		System.out.println();
 		*/	
		
		//2. 14시에 1234차량 출차
		
		//car1의 outTime 멤버변수에 출차시간 대입
		car1.outTime = 14;
		//car1 객체의 주차요금계산후 car1.fee 멤버변수에 대입
		car1.fee = (car1.outTime - car1.inTime) * 1000;
		//car1 객체의 영수증출력
		System.out.printf("고객님의 %s번차량은 %d시에 입차하셔서 %d시에 출차하였습니다.", car1.no, car1.inTime, car1.outTime);
		System.out.printf("\n총금액은 %d원입니다\n\n", car1.fee);
		System.out.println("-------------------------------------");
		System.out.printf("%s %s %s %s\n", "차량번호", "입차시간", "출차시간", "주차요금");
		System.out.printf("%6s %7d %8d %9d\n", car1.no, car1.inTime, car1.outTime, car1.fee);
		System.out.println("-------------------------------------");	
	}
}
