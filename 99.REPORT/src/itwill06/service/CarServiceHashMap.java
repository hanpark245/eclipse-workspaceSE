package com.itwill07.collection;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class CarServiceHashMap {
	private HashMap<String,Car> carMap;
	private int count;// 주차장 구획수

	public CarServiceHashMap() {
		carMap = new HashMap<String,Car>();
		count = 10;
	}

	public CarServiceHashMap(int count) {
		carMap = new HashMap<String,Car>();
		this.count = count;
	}

	/*
	 * 0. 차객체인자로받아서 입차후 성공실패여부반환 
	 *   - 주차장이 만차이면 입차실패
	 */
	public boolean ipCha(Car inCar) {
		boolean isSuccess = false;
		if (carMap.size() < count) {
			carMap.put(inCar.getNo(), inCar);
			isSuccess = true;
		} else if (carMap.size() >= count) {
			
		}
		return isSuccess;
	}

	/*
	 * 1. 전체차량출력(X)
	 */
	public void print() {
		Set<String> keySet = carMap.keySet();
		Iterator<String> keyIter = keySet.iterator();
		while (keyIter.hasNext()) {
			String key = keyIter.next();
			carMap.get(key).print();
			
		}
	}

	/*
	 * 5. 차량번호(4567번) 인자받아서 차객체한대 참조변수반환
	 */
	public Car findByNo(String no) {
		Car findCar =null;
		findCar = carMap.get(no);
		return findCar;
	}

	/*
	 * 6. 입차시간(8시이후)인자받아서 ArrayList(차객체배열) 참조변수반환(X)
	 */
	public ArrayList<Car> findByInTime(int inTime) {
		ArrayList<Car> findCars = new ArrayList<Car>();
		Set<String> KeySet = carMap.keySet();
		Iterator<String> KeyIter = KeySet.iterator();
		while (KeyIter.hasNext()) {
			String key = KeyIter.next();
			if (carMap.get(key).getInTime() > inTime) {
				findCars.add(carMap.get(key));
			}
		}
		return findCars;
	}

	/*
	 * 7. 차량번호(7891번),출차시간(12시)인자로 받아서 출차");
	 */
	public Car chulCha(String no, int outTime) {
		Car removeCar= null;
		removeCar = carMap.get(no);
		if (removeCar.getNo().equalsIgnoreCase(no)) {
			removeCar.setOutTime(outTime);
			removeCar.calculateFee();
			carMap.remove(no);
		}
		return removeCar;
	}
	/*
	 * 2. 주차전체구획수반환 
	 */
	public int getParkingLotCount() {
		return this.count;
	}
	
	/*
	  3. 주차가능주차구획수반환 
	 */
	public int getAvailableParkingLotCount() {
		return count-carMap.size();
	} 
	
}
