package bookcafe.sales;

import java.util.ArrayList;

public class SalesServiceTestMain {

	public static void main(String[] args) throws Exception {

		SalesService ser = new SalesService();
		
	
		
		
		System.out.println("---------------전체보기test----------------------");
		ArrayList<Sales> tempSearchAll = ser.searchListAll();
		for (Sales sales : tempSearchAll) {
			
			System.out.println(sales);
		}
		
		
		System.out.println("--------------날짜보기test---------------");
		Sales tempSearch =ser.searchByDate("2016/09/19");
		System.out.println(tempSearch);
		
		
		
		System.out.println("----------------insert Test--------------------------");
		ser.saveDate(new Sales("2016/09/14", 980000, 780000, 200000));
		ser.saveDate(new Sales("2016/09/15", 1340000, 990000, 350000));
		ser.saveDate(new Sales("2016/09/16", 900000, 640000, 260000));
		
		
		/*
		System.out.println("-----------------update test----------------------------");
		ser.saveUpdate("2016/09/28", 35000, 27000, 8000);
		*/
		

		
		System.out.println("-----------------updateTot test---------------------------");
		//ser.dateTot("2016/09/15", 1350000, 1000000, 350000);
		//ser.dateTot("15", 30000, 20000, 50000);
		ArrayList<Sales> s = ser.searchListAll();
		System.out.println(s);
		
		/*
		for (Sales sales : tempSearchAll) {
			System.out.println(sales);
		}
		*/
		
	}

}
