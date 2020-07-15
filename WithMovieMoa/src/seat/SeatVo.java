package seat;

import java.io.Serializable;


public class SeatVo implements Serializable{

	/*
	 * 좌석
	 * 극장지역
	 * 극장이름
	 * 상영관넘버
	 * 상영날짜
	 * 상영시간
	 * boolean 좌석배열
	 */
	
	private int seatNumber;
	private String theaterCity;
	private String theaterName;
	private String screenDate;
	private int screenAreaNum;
	private int screenTime;
	private boolean[] isReserve;
	
	public SeatVo(String theaterCity, String theaterName, String screenDate, int screenAreaNum, int screenTime, boolean[] isReserve) {
		this.theaterCity = theaterCity;
		this.theaterName = theaterName;
		this.screenAreaNum = screenAreaNum;
		this.screenDate = screenDate;
		this.screenTime = screenTime;
		this.isReserve = isReserve;
	}

	public String toString() {
		return "\n" + screenDate + " " + theaterCity + " " + theaterName + " " + screenAreaNum + "상영관 " + screenTime + "시 좌석배치현황\n"
	+ isReserve;
	}
	public int getSeatNumber() {
		return seatNumber;
	}


	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}


	public String getTheaterCity() {
		return theaterCity;
	}

	public void setTheaterCity(String theaterCity) {
		this.theaterCity = theaterCity;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public int getScreenAreaNum() {
		return screenAreaNum;
	}

	public void setScreenAreaNum(int screenAreaNum) {
		this.screenAreaNum = screenAreaNum;
	}

	public String getScreenDate() {
		return screenDate;
	}

	public void setScreenDate(String screenDate) {
		this.screenDate = screenDate;
	}

	public int getScreenTime() {
		return screenTime;
	}

	public void setScreenTime(int screenTime) {
		this.screenTime = screenTime;
	}

	public boolean[] getIsReserve() {
		return isReserve;
	}

	public void setIsReserve(boolean[] isReserve) {
		this.isReserve = isReserve;
	}
	
	
	
}
