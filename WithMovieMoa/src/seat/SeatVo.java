package seat;

import java.io.Serializable;


public class SeatVo implements Serializable{

	/*
	 * �¼�
	 * ��������
	 * �����̸�
	 * �󿵰��ѹ�
	 * �󿵳�¥
	 * �󿵽ð�
	 * boolean �¼��迭
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
		return "\n" + screenDate + " " + theaterCity + " " + theaterName + " " + screenAreaNum + "�󿵰� " + screenTime + "�� �¼���ġ��Ȳ\n"
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
