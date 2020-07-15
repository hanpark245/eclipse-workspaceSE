package theater;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;




public class TheaterService {

	TheaterDao theaterDao;
	
	public TheaterService() throws Exception {
		theaterDao = new TheaterDao();
	}
	

	/*
	 * 극장등록 및 중복검사
	 */
	public boolean theaterRegister(TheaterVo newTheater) throws Exception {
		boolean isSuccess = false;
		ArrayList<TheaterVo> theaterList = theaterDao.readAll();
		for (int i = 0; i < theaterList.size(); i++) {
			if (theaterList.get(i).getTheaterName().equals(newTheater.getTheaterName())
				&& theaterList.get(i).getTheaterCity().equals(newTheater.getTheaterCity())) {
					return isSuccess;
				}
		}
		
		isSuccess = true;
		theaterDao.create(newTheater);
		return isSuccess;
	}
	
	/*
	 * 극장이름으로 극장들 검색
	 */
	public ArrayList<TheaterVo> findTheaterByName(String theaterName) throws Exception{
		ArrayList<TheaterVo> tempList = theaterDao.readAll();
		ArrayList<TheaterVo> theaterList = new ArrayList<TheaterVo>();
		for (int i = 0; i < tempList.size(); i++) {
			TheaterVo findTheater = tempList.get(i);
			if (findTheater.getTheaterName().equals(theaterName)) {
				theaterList.add(findTheater);
			}
		}
		return theaterList;
	}
	
	/*
	 * 극장번호로 검색
	 */
	public TheaterVo findTheaterByNo(int theaterNumber) throws Exception {
		return theaterDao.readOne(theaterNumber);
		
	}
	
	/*
	 * 극장이 있는 도시 리스트 찾기
	 */
	public String[] findCityList() throws Exception{
		ArrayList<TheaterVo> tempList = theaterDao.readAll();
		HashSet<String> cityList = new HashSet<String>();
		for (int i = 0; i < tempList.size(); i++) {
			cityList.add(tempList.get(i).getTheaterCity());
		}
		String[] cityNameList = new String[cityList.size()];
		int count=0;
		Iterator<String> movieIter = cityList.iterator();
		while (movieIter.hasNext()) {
			String movieStr = movieIter.next();
			cityNameList[count] = movieStr;
			count++;
		}
		return cityNameList;
	}
	
	
	
	/*
	 * 지역을 매개변수로 한 해당지역의 극장 리스트 찾기
	 */
	public String[] findTheaterListByCity(String theaterCity) throws Exception {
		ArrayList<TheaterVo> tempList = theaterDao.readAll();
		HashSet<String> theaterList = new HashSet<String>();
		for (int i = 0; i < tempList.size(); i++) {
			if(tempList.get(i).getTheaterCity().equals(theaterCity)) {
			theaterList.add(tempList.get(i).getTheaterName());
			}
		}
		String[] theaterNameList = new String[theaterList.size()];
		int count=0;
		Iterator<String> movieIter = theaterList.iterator();
		while (movieIter.hasNext()) {
			String movieStr = movieIter.next();
			theaterNameList[count] = movieStr;
			count++;
		}
		return theaterNameList;
	}
	
	/*
	 * 지역,이름을 매개변수로 해당극장 번호를 받아 해당 극장의 총 좌석수 구하기
	 */
	
	public int findTheaterNumberByCityTheater(String theaterCity, String theaterName) throws Exception {
		ArrayList<TheaterVo> theaterList = theaterDao.readAll();
		int theaterNumber=-1;
		for (int i = 0; i < theaterList.size(); i++) {
			if(theaterList.get(i).getTheaterCity().equals(theaterCity)
					&&theaterList.get(i).getTheaterName().equals(theaterName)) {
				theaterNumber = theaterList.get(i).getTheaterNumber();
			}				
		}
		return theaterNumber;
	}
	
	public int findSeatTotNumByTheaterNumber(int theaterNumber) throws Exception {
		return theaterDao.readOne(theaterNumber).getSeatTotNum();
	}
	
	/*
	 * 모든 극장 검색
	 */

	public ArrayList<TheaterVo> findAllTheater() throws Exception {
		return theaterDao.readAll();
	}

	/*
	 * 극장수정
	 */

	public void theaterUpdate(TheaterVo updateTheater) throws Exception {
		theaterDao.update(updateTheater);
	}

	/*
	 극장삭제 
	 - 등록된 극장정보를 검색하여 삭제할 수 있다. 
	 - 극장삭제는 극장no를 찾아 삭제한다.
	 */
	public void theaterDelete(int theaterNumber) throws Exception {
		theaterDao.delete(theaterNumber);
	}


	/*
	 * 극장이름, 지역으로 삭제
	 */
	public void theaterDelete(String theaterName, String theaterCity) throws Exception {
		theaterDao.delete(theaterName, theaterCity);
	}
	
}
