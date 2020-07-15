package movie;

import java.io.Serializable;

public class MovieVo implements Serializable{

	private int movieNumber;
	private String movieName;
	private String movieGenre;
	private int limitAge;
	private String theaterCity;
	private String theaterName;
	private String screenDate;
	private int screenAreaNum;
	private int screenTime;
	private int fee;
	
	public MovieVo(String movieName, String movieGenre, int limitAge, String theaterCity, String theaterName, String screenDate, int screenAreaNum, int screenTime, int fee) {
		this.movieName = movieName;
		this.movieGenre = movieGenre;
		this.limitAge = limitAge;
		this.theaterCity = theaterCity;
		this.theaterName = theaterName;
		this.screenDate = screenDate;
		this.screenAreaNum = screenAreaNum;
		this.screenTime = screenTime;
		this.fee = fee;
	}

	public String toString() {
		return "\n- " + movieNumber + "번 " + movieName + " - 의 영화정보\n"+"\n"+movieName+"\n"+movieGenre+"\n"+limitAge+"세미만시청불가"
				+"\n"+theaterCity+"의 "+theaterName+" " + screenDate + " " + screenAreaNum + "상영관에서 " + screenTime + "시에 시청가능\n" + "요금 : " + fee+"\n";
	}


	public int getMovieNumber() {
		return movieNumber;
	}

	public void setMovieNumber(int movieNumber) {
		this.movieNumber = movieNumber;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieGenre() {
		return movieGenre;
	}

	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}

	public int getLimitAge() {
		return limitAge;
	}

	public void setLimitAge(int limitAge) {
		this.limitAge = limitAge;
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

	public int getScreenAreaNum() {
		return screenAreaNum;
	}

	public void setScreenAreaNum(int screenAreaNum) {
		this.screenAreaNum = screenAreaNum;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}
	
	
	
	
}
