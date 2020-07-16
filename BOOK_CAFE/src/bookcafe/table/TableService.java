package bookcafe.table;

import java.util.ArrayList;

// ** 개발시 주의점 **
// outTime시에 SalesService쪽에 값을 보내주고 Sales data에 누적된 값이 저장되도록 한다.
public class TableService {
	private TableDao tableDao;
	public TableService() throws Exception{
		tableDao = new TableDao();
	}
	/* 
	 * table service 메소드 구현
	 */
	//테이블리스트전체출력
	public ArrayList<Table> tableList() throws Exception{
		ArrayList<Table> tableList = tableDao.selectAll();
		return tableList;
	}
	//손님입장
	public void ipJang(Table table) throws Exception{
		tableDao.insert(table);
	}
	//손님퇴장
	public Table toiJang(int table_no, String outTime) throws Exception{
		Table outTable = tableDao.insertOfOutTime(table_no, outTime);
		return outTable;
	}
	
	//메뉴주문
	public void orderMenu(int table_no, String order_no) throws Exception{
		tableDao.updateOfOrderNoByAdd(table_no, order_no);
	}
	
	//메뉴수정
	public void orderMenuUpdate(int table_no, String order_no) throws Exception{
		tableDao.updateOfOrderNoByChange(table_no, order_no);
	}
	
	//사용중인테이블 검사
	public boolean isUsingTable(int table_no) throws Exception{
		boolean isUsingTable = tableDao.selectUsingTable(table_no);
		return isUsingTable;
	}
	
	//하나라도 사용중인테이블이있는지검사
	public boolean isUsingTableAll() throws Exception{
		boolean isUsingTableAll = tableDao.selectUsingTableAll();
		return isUsingTableAll;
	}
	
	//해당테이블에 메뉴를주문했는지검사
	public boolean isOrderOKTable(int table_no) throws Exception{
		boolean isOrderOKTable = tableDao.selectOrderOKTable(table_no);
		return isOrderOKTable;
	}
	
	//현재 모든테이블정보 리턴
	public ArrayList<Table> allTableInfo() throws Exception{
		return tableDao.selectAll();
	}
	
	//테이블번호로 테이블인원수 리턴
	public int getGuestCount(int table_no) throws Exception{
		return tableDao.selectGuestNoByTableNo(table_no);
	}
	
	//사용중인테이블들 번호 리턴
	public ArrayList<Integer> allUsingTablesNo() throws Exception{
		return tableDao.selectUsingTablesNo();
	}
	
	public int timeSales(Table table) throws Exception{
		String inTime = table.getInTime();
		String outTime = table.getOutTime();
		int timeSales = 0;
		
		String[] ipJang = inTime.split("/");
		String[] toiJang = outTime.split("/");
		int inDay = Integer.parseInt(ipJang[2]);
		int outDay = Integer.parseInt(toiJang[2]);
		int inHour = Integer.parseInt(ipJang[3]);
		int outHour = Integer.parseInt(toiJang[3]);
		if(inDay == outDay)
			timeSales = ( (outHour - inHour) * 2000 + 2000 ) * table.getGuest_no();	//기본료2000원임
		else
			timeSales = ( ( (outHour + 24 * (outDay - inDay) ) - inHour ) * 2000 + 2000 ) * table.getGuest_no();
		// ( outTime - inTime ) * 2000 계산
		
		return timeSales;
	}
}
