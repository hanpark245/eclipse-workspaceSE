package bookcafe.sales;

import java.util.ArrayList;

	

public class SalesService {
	
	private SalesDao salesDao;
	/*
	 * sales service �޼ҵ� ����
	 */
	
	
	private ArrayList<Sales> salesList = new ArrayList<Sales>();
	
	public SalesService() throws Exception {
		salesDao = new SalesDao(); 
		
		/*
		salesList.add(new Sales("2016/09/14", 980000, 780000, 200000));
		salesList.add(new Sales("2016/09/15", 1340000, 990000, 350000));
		salesList.add(new Sales("2016/09/16", 900000, 640000, 260000));
		salesList.add(new Sales("2016/09/17", 1490000, 1130000, 360000));
		salesList.add(new Sales("2016/09/18", 1250000, 850000, 400000));
		salesList.add(new Sales("2016/09/19", 1180000, 960000, 220000));
		salesList.add(new Sales("2016/09/20", 1280000, 880000, 400000));
		salesList.add(new Sales("2016/09/21", 1530000, 1050000, 480000));
		salesList.add(new Sales("2016/09/22", 1660000, 1180000, 480000));
		salesList.add(new Sales("2016/09/23", 1360000, 980000, 380000));
		salesList.add(new Sales("2016/09/24", 2000000, 1420000, 580000));
		salesList.add(new Sales("2016/09/25", 1900000, 1500000, 400000));
		salesList.add(new Sales("2016/09/26", 1410000, 990000, 420000));
		salesList.add(new Sales("2016/09/27", 1580000, 1280000, 300000));
		salesList.add(new Sales("2016/10/02", 1780000, 1320000, 460000));
		salesList.add(new Sales("2016/10/03", 2480000, 2060000, 420000));
		*/
		
	}
	
	//��ü���� ���
	public ArrayList<Sales> searchListAll() throws Exception{
		ArrayList<Sales> tempAll = salesDao.selectAll();
		
		return tempAll;
	}
	
	
	
	//��¥���� ���
	public Sales searchByDate(String date)throws Exception{
		
		Sales tempDate = salesDao.selectByDate(date);
		
		return tempDate;
	}
	
	
	//���� �����ϴ� �޼ҵ�
	public void saveDate(Sales addSales)throws Exception{
		salesDao.insert(addSales);
		
	}
	
	
	/*
	
	//���� �޾Ƽ� update�ϴ� �޼ҵ�
	public void saveUpdate(Sales updateSales)throws Exception{
		salesDao.update(updateSales);
		
	}
	*/
	
	// ����ư ������ ��� ���� �� ���� ����, ���ϸ���(�ߺ���¥ ��ħ)
		public void insert2(String outTime,int foodTot,int timeTot,int totalFT) throws Exception{
			Sales a = new Sales(outTime,foodTot,timeTot,totalFT);
			salesDao.insert2(a);		
		}
		
	public ArrayList<Sales> searchMonth(String sales_Month) throws Exception{
		ArrayList<Sales> temp = salesDao.selectByMonth(sales_Month);
		return temp;
	}
			
}
