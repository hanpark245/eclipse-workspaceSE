package bookcafe.table;

import java.util.ArrayList;

public class TableServiceTestMain {

	public static void main(String[] args) throws Exception{
		TableService tableService = new TableService();
		
		System.out.println("-----테이블 손님입장-----");
		tableService.ipJang(new Table(1, "2016-10-01-12", 3));
		tableService.ipJang(new Table(2, "2016-10-01-13", 1));
		tableService.ipJang(new Table(3, "2016-10-01-14", 4));
		tableService.ipJang(new Table(4, "2016-10-01-15", 2));
		tableService.ipJang(new Table(5, "2016-10-01-16", 3));
		tableService.ipJang(new Table(6, "2016-10-01-17", 1));
		tableService.ipJang(new Table(7, "2016-10-01-18", 4));
		tableService.ipJang(new Table(8, "2016-10-01-19", 2));
		
		ArrayList<Table> tableList = tableService.allTableInfo();
		for (Table table : tableList) {
			System.out.println(table);
		}
		
		System.out.println("-----사용중인 테이블인지 검사-----");
		boolean isUsingTable = tableService.isUsingTable(1);
		if(isUsingTable){
			System.out.println("현재 사용중인테이블입니다");
		}
		
		
		System.out.println("-----테이블 주문-----");
		tableService.orderMenu(1, "1/1/2/3/");
		tableService.orderMenu(2, "11/8/6/3/");
		tableService.orderMenu(3, "15/11/12/9/");
		tableService.orderMenu(4, "2/7/12/1/");

		
		tableList = tableService.allTableInfo();
		for (Table table : tableList) {
			System.out.println(table);
		}
		
		
		System.out.println("-----테이블 주문수정-----");
		tableService.orderMenuUpdate(1, "1/2/3");
		tableService.orderMenuUpdate(2, "1/2/3");
		tableService.orderMenuUpdate(3, "1/2/3");
		tableService.orderMenuUpdate(4, "1/2/3");

		
		
		System.out.println("-----테이블 퇴장-----");
		Table outTable;
		outTable = tableService.toiJang(1, "2016-10-02-24");
		//퇴장한테이블의 객체를 UI에서 받아와서 MenuService에게 누적주문번호 넘겨주고
		//주문번호들에대한 객체정보들을 ArrayList로 반환받는다
		//ArrayList<Menu> menuInfo = menuService.getMenuInfo(outTable.getOrder_no());
		
		//퇴장한테이블의 시간금액 계산
		int timeSales = tableService.timeSales(outTable);
		System.out.println("시간당금액 : "+timeSales);
		//시간판매금액을 Sales.dat에 저장시켜줘야함
	}

}
