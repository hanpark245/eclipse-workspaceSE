package generic;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapMain {

	public static void main(String[] args) {
		
		HashMap<String,Car> carMap=new HashMap<String,Car>();
		System.out.println("#size:"+carMap.size());
		System.out.println("**************** 1.put ****************");
		Car c1=new Car("1111", 10);
		carMap.put("1111", c1);
		carMap.put("2222",new Car("2222", 11));
		carMap.put(new String("3333"),new Car("3333",12));
		carMap.put("4444",new Car("4444", 13));
		carMap.put("5555",new Car("5555", 13));
		System.out.println("#size:"+carMap.size());
		System.out.println(carMap);
		/*
		 * 키객체(값)가 동일하면 값객체가바뀐다.
		 */
		carMap.put("5555",new Car("FIVE",14));
		System.out.println("#size:"+carMap.size());
		System.out.println(carMap);
		System.out.println("************** 2.get **************");
		Car getCar =carMap.get("3333");
		getCar.setOutTime(17);
		getCar.calculateFee();
		getCar.print();
		System.out.println("************** 3.remove **************");
		Car removeCar = carMap.remove("3333");
		removeCar.print();
		System.out.println("#size:"+carMap.size());
		System.out.println(carMap);
		removeCar = carMap.remove("7878");
		System.out.println("removeCar(7878):"+removeCar);
		if(carMap.containsKey("7878")) {
			carMap.remove("7878");
		}
		//Object[] oa = carMap.values().toArray();
		
		System.out.println("*************4. clear***************");
		//carMap.clear();
		System.out.println("#size:"+carMap.size());
		//carMap=null;
		/********************iteration*********************/
		System.out.println("############### iteration ###############");
		Set<String> keySet = carMap.keySet();
		Iterator<String> keyIter = keySet.iterator();
		while (keyIter.hasNext()) {
			String key =  keyIter.next();
			Car tempCar=carMap.get(key);
			tempCar.print();
		}
		
	}

}
