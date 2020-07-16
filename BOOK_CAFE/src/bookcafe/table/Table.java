package bookcafe.table;

import java.io.Serializable;

public class Table implements Serializable {
	/*
	 * 1. 멤버 변수
	 */
	private int table_no;		//테이블번호
	private String inTime;		//입장시간
	private String outTime;		//퇴장시간
	private int guest_no;		//손님인원수
	private String order_no;	//주문번호
	
	
	/*
	 * 2. 생성자 3개
	 */
	public Table(){
		//Default constructor
	}
	
	public Table(int table_no, String inTime, int guest_no){	//table객체 생성시(손님입장) 테이블번호,입장시간,인원수만 입력
		super();
		this.table_no = table_no;
		this.inTime = inTime;
		this.guest_no = guest_no;
		this.outTime = "";		//이거안해주면 누적할때 null도 들어가있음
		this.order_no = "";
	}
	
	public Table(int table_no, String inTime, String outTime, int guest_no, String order_no) {	//그냥넣어놨어요
		super();
		this.table_no = table_no;
		this.inTime = inTime;
		this.outTime = outTime;
		this.guest_no = guest_no;
		this.order_no = order_no;
	}

	/*
	 * 3. getter/setter
	 */
	public int getTable_no() {
		return table_no;
	}

	public void setTable_no(int table_no) {
		this.table_no = table_no;
	}

	public String getInTime() {
		return inTime;
	}

	public void setInTime(String inTime) {
		this.inTime = inTime;
	}

	public String getOutTime() {
		return outTime;
	}

	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}

	public int getGuest_no() {
		return guest_no;
	}

	public void setGuest_no(int guest_no) {
		this.guest_no = guest_no;
	}

	public String getOrder_no() {
		return order_no;
	}

	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}
	
	@Override
	public String toString() {
		return table_no + "\t" + inTime + "\t" + outTime + "\t" + guest_no + "\t" + order_no;
	}
}
