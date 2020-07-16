package bookcafe.sales;

import java.util.ArrayList;

public class SalesDaoTestMain {

	public static void main(String[] args) throws Exception {

		SalesDao salesDao = new SalesDao();
		
		
		salesDao.insert(new Sales("2016/10/01", 16000, 8000, 8000));
		salesDao.insert(new Sales("2016/09/30", 27000, 19000, 8000));
		salesDao.insert(new Sales("2016/09/29", 16000, 8000, 8000));
		salesDao.insert(new Sales("2016/09/28", 33000, 27000, 6000));
		
		
		
		System.out.println("-------selectByDate-------");
		Sales tempSelect = salesDao.selectByDate("2016/09/28");
		System.out.println(tempSelect);
		
		
		
		
		System.out.println("----------selectAll-------------");
		ArrayList<Sales> tempAll = salesDao.selectAll();
		for (Sales sales : tempAll) {			
			System.out.println(sales);
		}
		
	

		
		
		System.out.println("------------update-----------------");
		Sales updateSales = new Sales("2016/09/28", 37000, 31000, 6000);
		salesDao.update(updateSales);
		System.out.println(updateSales);
		
		
		
		System.out.println("-------------delete----------------");
		salesDao.deleteByDate("2016/09/30");
		
		ArrayList<Sales> tempAll2 = salesDao.selectAll();
		for (Sales sales : tempAll2) {			
			System.out.println(sales);
		}
		

		
		System.out.println("----------monthly------------");
		System.out.println("09¿ù ÃÑ¸ÅÃâ");
		//salesDao.monthly("09");
		//System.out.println("10¿ù ÃÑ¸ÅÃâ");
		//salesDao.monthly("10");
	
		
		
	}

}
