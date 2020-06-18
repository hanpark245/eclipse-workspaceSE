package notes;
//주차장프로그램에서 차 객체(instance)를 생성하기위한 클래스




public class Car 
{
	/*<< 속성 >>
	 * 멤버필드(변수)
	 * 인스턴스변수
	 */
	
	String no;//차량번호
	int inTime;//입차시간
	int outTime;//출차시간
	int fee;//주차요금
	/*
	 * << 행위 >>
	 * 멤버메쏘드
	 * 인스턴스메쏘드
	 */
	//입차
	void ipCha(String no,int inTime) {
		this.no=no;
		this.inTime=inTime;
	}
	//출차시간set
	void setOutTime(int outTime) {
		this.outTime=outTime;
	}
	//주차요금계산
	void calculateFee() {
		this.fee=(this.outTime-this.inTime)*1000;
	}
	
	//영수증출력
	void print() {
		System.out.println("-------------------------------------");
		System.out.printf("%s %s %s %s%n","차량번호","입차시간","출차시간","주차요금");
		System.out.println("-------------------------------------");
		System.out.printf("%8s %6d %8d %10d %n",this.no,this.inTime,this.outTime,this.fee);
	}
	
	
	
	
	
	
	
	
}
