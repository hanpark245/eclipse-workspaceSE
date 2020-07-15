package movie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;



public class MovieService {
	
	/****************** Dao��ü����������� ********************/
	MovieDao movieDao;
	/***********************************************************/
	
	
	/****************** Dao��ü���������ü����********************/
	public MovieService() throws Exception{
		movieDao = new MovieDao();
	}
	/**************************************************************/
	/*
	 * movie register
	 * ��ȭ�̸� & �������� & �����̸� & �󿵳�¥ & �󿵰��ѹ� & �󿵽ð��� ��ġ�� �����Ұ�
	 * 
	 */
	public boolean movieRegister(MovieVo newMovie) throws Exception {
		boolean isRegister = false;
		ArrayList<MovieVo> movieList = movieDao.readAll();
		for (int i = 0; i < movieList.size(); i++) {
			if(movieList.get(i).getMovieName().equals(newMovie.getMovieName())
					&&movieList.get(i).getTheaterCity().equals(newMovie.getTheaterCity())
					&&movieList.get(i).getTheaterName().equals(newMovie.getTheaterName())
					&&movieList.get(i).getScreenDate().equals(newMovie.getScreenDate())
					&&movieList.get(i).getScreenAreaNum() == newMovie.getScreenAreaNum()
					&&movieList.get(i).getScreenTime() == newMovie.getScreenTime()) {
				return isRegister;
			}
		}
		isRegister = true;
		movieDao.create(newMovie);
		return isRegister;
		
		
	}
	
	/*
	 * movie delete
	 */
	public void movieDelete(int movieNumber) throws Exception {
		movieDao.delete(movieNumber);
	}
	
	/*
	 * movie update
	 */
	public void movieUpdate(MovieVo updateMovie) throws Exception {
		movieDao.update(updateMovie);
	}
	
	/*
	 * movie list
	 */
	public ArrayList<MovieVo> findMovieByAll() throws Exception{
		return movieDao.readAll();
	}
	
	/*
	 * movie search by movie number
	 */
	public MovieVo findMovieByNumber(int movieNumber) throws Exception {
		MovieVo findMovie = null;
		findMovie = movieDao.readOne(movieNumber);
		return findMovie;
		
	}

	public String[] findMovieListByName() throws Exception{
		ArrayList<MovieVo> tempList = movieDao.readAll();
		HashSet<String> movieList = new HashSet<String>();
		for (int i = 0; i < tempList.size(); i++) {
			movieList.add(tempList.get(i).getMovieName());
		}
		String[] movieNameList = new String[movieList.size()];
		int count=0;
		Iterator<String> movieIter = movieList.iterator();
		while (movieIter.hasNext()) {
			String movieStr = movieIter.next();
			movieNameList[count] = movieStr;
			count++;
		}
		return movieNameList;
	}
	
	/*
	 * �ش� ��ȭ�� �濵�ϴ� ������ �ִ� ���ø���Ʈ ã��
	 */
	public String[] findCityListByMovieName(String movieName) throws Exception{
		ArrayList<MovieVo> tempList = movieDao.readAll();
		HashSet<String> cityList = new HashSet<String>();
		for (int i = 0; i < tempList.size(); i++) {
			if(tempList.get(i).getMovieName().equals(movieName))
				cityList.add(tempList.get(i).getTheaterCity());
		}
		String[] cityNameList = new String[cityList.size()];
		int count=0;
		Iterator<String> cityIter = cityList.iterator();
		while (cityIter.hasNext()) {
			String movieStr = cityIter.next();
			cityNameList[count] = movieStr;
			count++;
		}
		return cityNameList;
	}
	
	/*
	 * �ش� ��ȭ�� �濵�ϴ� ������ �ִ� ���ø���Ʈ ã��
	 */
	public String[] findMovieListByTheaterAndCity(String selectedCity, String selectedTheater) throws Exception{
		ArrayList<MovieVo> tempList = movieDao.readAll();
		HashSet<String> movieList = new HashSet<String>();
		for (int i = 0; i < tempList.size(); i++) {
			if(tempList.get(i).getTheaterCity().equals(selectedCity)
					&&tempList.get(i).getTheaterName().equals(selectedTheater))
				movieList.add(tempList.get(i).getMovieName());
		}
		String[] movieNameList = new String[movieList.size()];
		int count=0;
		Iterator<String> movieIter = movieList.iterator();
		while (movieIter.hasNext()) {
			String movieStr = movieIter.next();
			movieNameList[count] = movieStr;
			count++;
		}
		return movieNameList;
	}
	
	/*
	 * �ش� ��ȭ�� �濵�ϴ� ������ �ش翵ȭ�� �濵�ϴ� ���ø� �Ű������� �Ͽ�  
	 */
	public String[] findTheaterListByCityAndMovieName(String selectedMovieName, String theaterCity) throws Exception {
		ArrayList<MovieVo> tempList = movieDao.readAll();
		HashSet<String> theaterList = new HashSet<String>();
		for (int i = 0; i < tempList.size(); i++) {
			if(tempList.get(i).getTheaterCity().equals(theaterCity)
					&&tempList.get(i).getMovieName().equals(selectedMovieName)) {
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
	 * ������ ��ȭ,��������,�����̸��� ������� �� ��¥����Ʈ �˻�
	 */
	public String[] screenDateListByMovieAndCityAndTheater(String selectedMovieName, String selectedCity, String selectedTheater) throws Exception {
		ArrayList<MovieVo> tempList = movieDao.readAll();
		ArrayList<String> dateList = new ArrayList<String>();
		for (int i = 0; i < tempList.size(); i++) {
			if(tempList.get(i).getTheaterCity().equals(selectedCity)
					&&tempList.get(i).getMovieName().equals(selectedMovieName)
					&&tempList.get(i).getTheaterName().equals(selectedTheater)) {
			dateList.add(tempList.get(i).getScreenDate());
			}
		}
		String[] screenDateList = new String[dateList.size()];
		for (int i = 0; i < dateList.size(); i++) {
			screenDateList[i] = dateList.get(i);
		}
		return screenDateList;
	}
	
	/*
	 * ������ ��¥�� ������ ��ȭ����Ʈ �˻�
	 */
	
	public String[] findMovieListByDate(String selectedDate) throws Exception{
		ArrayList<MovieVo> tempList = movieDao.readAll();
		HashSet<String> movieList = new HashSet<String>();
		for (int i = 0; i < tempList.size(); i++) {
			if(tempList.get(i).getScreenDate().equals(selectedDate))
				movieList.add(tempList.get(i).getMovieName());
		}
		String[] movieNameList = new String[movieList.size()];
		int count=0;
		Iterator<String> movieIter = movieList.iterator();
		while (movieIter.hasNext()) {
			String movieStr = movieIter.next();
			movieNameList[count] = movieStr;
			count++;
		}
		return movieNameList;
	}
	/*
	 * ������ ��¥�� ��ȭ�̸��� ���ڷ� �� ������ �ִ� ���� ã��
	 */
	
	public String[] findCityListByDateAndMovie(String selectedDate, String selectedMovieName) throws Exception{
		ArrayList<MovieVo> tempList = movieDao.readAll();
		HashSet<String> cityList = new HashSet<String>();
		for (int i = 0; i < tempList.size(); i++) {
			if(tempList.get(i).getScreenDate().equals(selectedDate)
					&&tempList.get(i).getMovieName().equals(selectedMovieName))
				cityList.add(tempList.get(i).getTheaterCity());
		}
		String[] cityNameList = new String[cityList.size()];
		int count=0;
		Iterator<String> cityIter = cityList.iterator();
		while (cityIter.hasNext()) {
			String cityStr = cityIter.next();
			cityNameList[count] = cityStr;
			count++;
		}
		return cityNameList;
	}
	/*
	 * ������ ��¥�� ��ȭ�̸�, ���ø� ���ڷ� �� ����ã��
	 */
	
	public String[] findTheaterListByDateAndMovieAndCity(String selectedDate,String selectedMovieName, String selectedCity) throws Exception{
		ArrayList<MovieVo> tempList = movieDao.readAll();
		HashSet<String> theaterList = new HashSet<String>();
		for (int i = 0; i < tempList.size(); i++) {
			if(tempList.get(i).getScreenDate().equals(selectedDate)
					&&tempList.get(i).getMovieName().equals(selectedMovieName)
					&&tempList.get(i).getTheaterCity().equals(selectedCity))
				theaterList.add(tempList.get(i).getTheaterName());
		}
		String[] theaterNameList = new String[theaterList.size()];
		int count=0;
		Iterator<String> theaterIter = theaterList.iterator();
		while (theaterIter.hasNext()) {
			String theaterStr = theaterIter.next();
			theaterNameList[count] = theaterStr;
			count++;
		}
		return theaterNameList;
	}
	
	/*
	 * ������ ��ȭ�̸�, �������ִµ���, �����̸�, ��¥�� ���ڷ� �� �󿵰� ����Ʈ ã��
	 */
	
	public int[] findscreenNumListByMovieAndCityAndTheaterAndDate(
			String selectedMovieName,
			String selectedCity,
			String selectedTheater,
			String selectedDate) throws Exception{
		ArrayList<MovieVo> tempList = movieDao.readAll();
		HashSet<Integer> screenList = new HashSet<Integer>();
		for (int i = 0; i < tempList.size(); i++) {
			if(tempList.get(i).getMovieName().equals(selectedMovieName)
					&&tempList.get(i).getTheaterCity().equals(selectedCity)
					&&tempList.get(i).getTheaterName().equals(selectedTheater)
					&&tempList.get(i).getScreenDate().equals(selectedDate))
				screenList.add(tempList.get(i).getScreenAreaNum());
		}
		int[] screenNumList = new int[screenList.size()];
		int count=0;
		Iterator<Integer> screenIter = screenList.iterator();
		while (screenIter.hasNext()) {
			int screenStr = screenIter.next();
			screenNumList[count] = screenStr;
			count++;
		}
		Arrays.sort(screenNumList);
		return screenNumList;
	}

	public int[] findscreenTimeListByMovieAndCityAndTheaterAndDateAndScreenNum(
			String selectedMovieName,
			String selectedCity,
			String selectedTheater,
			String selectedDate,
			int selectedScreenNumber) throws Exception{
		ArrayList<MovieVo> tempList = movieDao.readAll();
		HashSet<Integer> timeList = new HashSet<Integer>();
		for (int i = 0; i < tempList.size(); i++) {
			if(tempList.get(i).getMovieName().equals(selectedMovieName)
					&&tempList.get(i).getTheaterCity().equals(selectedCity)
					&&tempList.get(i).getTheaterName().equals(selectedTheater)
					&&tempList.get(i).getScreenDate().equals(selectedDate)
					&&tempList.get(i).getScreenAreaNum() == selectedScreenNumber)
				timeList.add(tempList.get(i).getScreenTime());
		}
		int[] screenTimeList = new int[timeList.size()];
		int count=0;
		Iterator<Integer> timeIter = timeList.iterator();
		while (timeIter.hasNext()) {
			int timeInt = timeIter.next();
			screenTimeList[count] = timeInt;
			count++;
		}
		Arrays.sort(screenTimeList);
		return screenTimeList;
	}
	
	/*
	 * ��ȭ�̸����� ������ ���� ��ȭ ������ 1�� ã��
	 */
	
	public MovieVo findMovieByMovieName(String movieName) throws Exception{
		ArrayList<MovieVo> movieList = movieDao.readAll();
		MovieVo movie = null;
		for (int i = 0; i < movieList.size(); i++) {
			if(movieList.get(i).getMovieName().equals(movieName))
				movie = movieList.get(i);
		}
		
		return movie;
	}
}
