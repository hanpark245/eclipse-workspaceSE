package bookcafe.table;

import java.util.ArrayList;

public class TableDaoTestMain {

	public static void main(String[] args) throws Exception{
		TableDao tableDao=new TableDao();
		System.out.println("-----insert--------");
		
		tableDao.insert(new Table(1, "2016-09-30", 4));
		tableDao.insert(new Table(2, "2016-09-29", 1));
		tableDao.insert(new Table(3, "2016-09-28", 3));

		
		System.out.println("-----selectAll--------");
		ArrayList<Table> tableList = tableDao.selectAll();
		for (Table table : tableList) {
			System.out.println(table);
		}
		
		System.out.println("-----select usingTable-----");
		boolean isUsingTable = tableDao.selectUsingTable(1);
		if(isUsingTable){
			System.out.println("현재사용중인테이블입니다.");
		}
		
		
		//System.out.println("-----delete--------");

		System.out.println("-----updateOfOrderNoByAdd--------");
		tableDao.updateOfOrderNoByAdd(1, "1/2/3/");
		tableList = tableDao.selectAll();
		for (Table table : tableList) {
			System.out.println(table);
		}
		
		System.out.println("-----updateOfOrderNoByAdd--------");
		tableDao.updateOfOrderNoByAdd(1, "4/5/6/");
		tableList = tableDao.selectAll();
		for (Table table : tableList) {
			System.out.println(table);
		}
		
		System.out.println("-----updateOfOrderNoByChange--------");
		tableDao.updateOfOrderNoByChange(1, "4/5/6/");
		tableList = tableDao.selectAll();
		for (Table table : tableList) {
			System.out.println(table);
		}
		
		System.out.println("-----insertOfOutTime-----");
		Table outTable = tableDao.insertOfOutTime(1, "2016-10-01");
		System.out.println(outTable);
		tableList = tableDao.selectAll();
		for (Table table : tableList) {
			System.out.println(table);
		}
	}
}
