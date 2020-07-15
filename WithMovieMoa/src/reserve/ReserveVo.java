package reserve;

import java.io.Serializable;

public class ReserveVo implements Serializable{
	
	private String resID;
	private String resName;
	private String resMovie;
	private String resCity;
	private String resTheater;
	private String resDate;
	private int resScreenAreaNum;
	private int resTime;
	private int fee;
	
	public ReserveVo(String resID, String resName, String resMovie, String resCity, String resTheater, String resDate,
			int resScreenAreaNum, int resTime, int fee) {
		this.resID = resID;
		this.resName = resName;
		this.resMovie = resMovie;
		this.resCity = resCity;
		this.resTheater = resTheater;
		this.resDate = resDate;
		this.resScreenAreaNum = resScreenAreaNum;
		this.resTime = resTime;
		this.fee = fee;
	}

	public String getResID() {
		return resID;
	}

	public void setResID(String resID) {
		this.resID = resID;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public String getResName() {
		return resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	public String getResMovie() {
		return resMovie;
	}

	public void setResMovie(String resMovie) {
		this.resMovie = resMovie;
	}

	public String getResCity() {
		return resCity;
	}

	public void setResCity(String resCity) {
		this.resCity = resCity;
	}

	public String getResTheater() {
		return resTheater;
	}

	public void setResTheater(String resTheater) {
		this.resTheater = resTheater;
	}

	public String getResDate() {
		return resDate;
	}

	public void setResDate(String resDate) {
		this.resDate = resDate;
	}

	public int getResScreenAreaNum() {
		return resScreenAreaNum;
	}

	public void setResScreenAreaNum(int resScreenAreaNum) {
		this.resScreenAreaNum = resScreenAreaNum;
	}

	public int getResTime() {
		return resTime;
	}

	public void setResTime(int resTime) {
		this.resTime = resTime;
	}


}
