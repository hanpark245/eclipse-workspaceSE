/*
 * 주차장프로그램 에서 차객체(instance)를 생성하기위한위한클래스
 */
public class Car {
	/*<< 속성 >>
	 * 멤버필드(변수)
	 * 인스턴스변수
	 */
	
	private String no;//차량번호
	private int inTime;//입차시간
	private int outTime;//출차시간
	private int fee;//주차요금
	public Car() {
	
	}
	
	
	
	public Car(String no, int inTime) {
		
		this.no = no;
		this.inTime = inTime;
	}



	public Car(String no, int inTime, int outTime, int fee) {
		this.no = no;
		this.inTime = inTime;
		this.outTime = outTime;
		this.fee = fee;
	}

	

	/*
	 * << 행위 >>
	 * 멤버메쏘드
	 * 인스턴스메쏘드
	 */
	//입차
	public void ipCha(String no,int inTime) {
		this.no=no;
		this.inTime=inTime;
	}
	/*
	public void chulCha(int outTime) {
		this.setOutTime(outTime);
		this.calculateFee();
		this.headerPrint();
		this.print();
	}
	*/
	//출차시간set
	public void setOutTime(int outTime) {
		this.outTime=outTime;
	}
	//주차요금계산
	public void calculateFee() {
		this.fee=(this.outTime-this.inTime)*1000;
	}
	public static void headerPrint() {
		System.out.println("-------------------------------------");
		System.out.printf("%s %s %s %s%n","차량번호","입차시간","출차시간","주차요금");
		System.out.println("-------------------------------------");
	}
	/*
	@Override
	public String toString() {
		return "Car [no=" + no + ", inTime=" + inTime + ", outTime=" + outTime + ", fee=" + fee + "]";
	}
	*/
	//영수증출력
	public void print() {
		
		System.out.printf("%8s %6d %8d %10d %n",this.no,this.inTime,this.outTime,this.fee);
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public int getInTime() {
		return inTime;
	}
	public void setInTime(int inTime) {
		this.inTime = inTime;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public int getOutTime() {
		return outTime;
	}




	
	
	
	
	
	
	
	
}
