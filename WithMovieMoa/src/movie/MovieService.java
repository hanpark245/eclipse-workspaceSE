package movie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;



public class MovieService {
	
	/****************** Dao객체멤버변수선언 ********************/
	MovieDao movieDao;
	/***********************************************************/
	
	
	/****************** Dao객체멤버변수객체생성********************/
	public MovieService() throws Exception{
		movieDao = new MovieDao();
	}
	/**************************************************************/
	/*
	 * movie register
	 * 영화이름 & 극장지역 & 극장이름 & 상영날짜 & 상영관넘버 & 상영시간이 겹치면 생성불가
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
	 * 해당 영화를 방영하는 극장이 있는 도시리스트 찾기
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
	 * 해당 영화를 방영하는 극장이 있는 도시리스트 찾기
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
	 * 해당 영화를 방영하는 극장을 해당영화를 방영하는 도시를 매개변수로 하여  
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
	 * 선택한 영화,극장지역,극장이름을 기반으로 한 날짜리스트 검색
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
	 * 선택한 날짜와 동일한 영화리스트 검색
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
	 * 선택한 날짜와 영화이름을 인자로 한 극장이 있는 도시 찾기
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
	 * 선택한 날짜와 영화이름, 도시를 인자로 한 극장찾기
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
	 * 선택한 영화이름, 극장이있는도시, 극장이름, 날짜를 인자로 한 상영관 리스트 찾기
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
	 * 영화이름으로 제목이 같은 영화 무작위 1개 찾기
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
