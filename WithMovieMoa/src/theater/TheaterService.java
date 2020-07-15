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
	 * ������ �� �ߺ��˻�
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
	 * �����̸����� ����� �˻�
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
	 * �����ȣ�� �˻�
	 */
	public TheaterVo findTheaterByNo(int theaterNumber) throws Exception {
		return theaterDao.readOne(theaterNumber);
		
	}
	
	/*
	 * ������ �ִ� ���� ����Ʈ ã��
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
	 * ������ �Ű������� �� �ش������� ���� ����Ʈ ã��
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
	 * ����,�̸��� �Ű������� �ش���� ��ȣ�� �޾� �ش� ������ �� �¼��� ���ϱ�
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
	 * ��� ���� �˻�
	 */

	public ArrayList<TheaterVo> findAllTheater() throws Exception {
		return theaterDao.readAll();
	}

	/*
	 * �������
	 */

	public void theaterUpdate(TheaterVo updateTheater) throws Exception {
		theaterDao.update(updateTheater);
	}

	/*
	 ������� 
	 - ��ϵ� ���������� �˻��Ͽ� ������ �� �ִ�. 
	 - ��������� ����no�� ã�� �����Ѵ�.
	 */
	public void theaterDelete(int theaterNumber) throws Exception {
		theaterDao.delete(theaterNumber);
	}


	/*
	 * �����̸�, �������� ����
	 */
	public void theaterDelete(String theaterName, String theaterCity) throws Exception {
		theaterDao.delete(theaterName, theaterCity);
	}
	
}
