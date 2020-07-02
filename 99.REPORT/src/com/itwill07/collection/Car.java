package com.itwill07.collection;


public class Car {
	private String no;
	private int inTime;	//입차시간
	private int outTime;//출차시간
	private int fee;	//주차요금
	public Car() {
		// TODO Auto-generated constructor stub
	}
	public Car(String no, int inTime) {
		this.no = no;
		this.inTime = inTime;
	}



	public void ipCha(String no,int intTime) {
		this.no=no;
		this.inTime=intTime;
	}
	
	public void setOutTime(int outTime) {
		this.outTime=outTime;
	}

	public void calculateFee() {
		this.fee = (this.outTime-this.inTime)*1000;
	}
	public static void headerPrint() {
		System.out.println("------------------------------------");
		System.out.println("차량번호  입차시간 출차시간 주차요금 ");
		System.out.println("------------------------------------");
	}
	public void print() {
		System.out.println(this.no+"\t\t"+this.inTime+"\t"+this.outTime+"\t"+this.fee);
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









