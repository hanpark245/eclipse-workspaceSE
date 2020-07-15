package theater;

import java.io.Serializable;

public class TheaterVo implements Serializable{
	
	private int theaterNumber;	
	private String theaterCity;
	private String theaterName;
	private int screenAreaTotNum;
	private int seatTotNum;
	
	public TheaterVo(String theaterCity, String theaterName, int screenAreaNum, int seatTotNum) {
		this.theaterCity = theaterCity;
		this.theaterName = theaterName;
		this.screenAreaTotNum = screenAreaNum;
		this.seatTotNum = seatTotNum;
	}
	
	public int getTheaterNumber() {
		return theaterNumber;
	}

	public void setTheaterNumber(int theaterNumber) {
		this.theaterNumber = theaterNumber;
	}



	public String toString() {
		return "\n- " + theaterNumber + "번 상영관정보 - \n"+theaterCity+"\n"+theaterName+"\n"+"상영관숫자 : " + screenAreaTotNum + "\n좌석 총 숫자 : " + seatTotNum+"\n";
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
		return screenAreaTotNum;
	}

	public void setScreenAreaNum(int screenAreaNum) {
		this.screenAreaTotNum = screenAreaNum;
	}

	public int getSeatTotNum() {
		return seatTotNum;
	}

	public void setSeatTotNum(int seatTotNum) {
		this.seatTotNum = seatTotNum;
	}
	
	
	
}
