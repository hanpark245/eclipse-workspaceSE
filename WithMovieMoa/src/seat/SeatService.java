package seat;

import java.util.ArrayList;

public class SeatService {
	
	SeatDao seatDao;
	
	public SeatService() throws Exception {
		seatDao = new SeatDao();
	}

	public boolean seatListInfoRegister(SeatVo newSeatInfo) throws Exception {
		boolean isSuccess = false;
		ArrayList<SeatVo> seatInfoList = seatDao.readAll();
		for (int i = 0; i < seatInfoList.size(); i++) {
			if(seatInfoList.get(i).getTheaterCity().equals(newSeatInfo.getTheaterCity())
					&&seatInfoList.get(i).getTheaterName().equals(newSeatInfo.getTheaterName())
					&&seatInfoList.get(i).getScreenDate().equals(newSeatInfo.getScreenDate())
					&&seatInfoList.get(i).getScreenAreaNum() == newSeatInfo.getScreenAreaNum()
					&&seatInfoList.get(i).getScreenTime() == newSeatInfo.getScreenTime()
					&&seatInfoList.get(i).getIsReserve().equals(newSeatInfo.getIsReserve())) {
				return isSuccess;
			}
		}		
		isSuccess = true;
		seatDao.create(newSeatInfo);
		return isSuccess;
	}
	
	public void seatInfoUpdate(int seatNumber, SeatVo updateSeatInfo) throws Exception {
		ArrayList<SeatVo> seatInfoList = seatDao.readAll();
		for (int i = 0; i < seatInfoList.size(); i++) {
			if(seatInfoList.get(i).getSeatNumber() == seatNumber)
				seatInfoList.set(i, updateSeatInfo);
		}
	}
	
	/*
	 * 극장지역, 극장이름, 상영날짜, 상영관넘버, 상영시간을 인자로 한 좌석정보 찾기
	 */
	public SeatVo findSeatInfoByCityAndTheaterAndDateAndScreenNumAndTime(
			String theaterCity,
			String theaterName,
			String screenDate,
			int screenAreaNum,
			int screenTime) throws Exception {
		ArrayList<SeatVo> seatInfoList = seatDao.readAll();
		SeatVo seatInfo = null;
		for (int i = 0; i < seatInfoList.size(); i++) {
			if(seatInfoList.get(i).getTheaterCity().equals(theaterCity)
					&&seatInfoList.get(i).getTheaterName().equals(theaterName)
					&&seatInfoList.get(i).getScreenDate().equals(screenDate)
					&&seatInfoList.get(i).getScreenAreaNum() == screenAreaNum
					&&seatInfoList.get(i).getScreenTime() == screenTime) {
				seatInfo = seatInfoList.get(i);
			}
		}
		return seatInfo;
	}
	
	
	
}
