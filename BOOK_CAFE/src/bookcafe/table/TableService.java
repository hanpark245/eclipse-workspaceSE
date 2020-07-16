package bookcafe.table;

import java.util.ArrayList;

// ** ���߽� ������ **
// outTime�ÿ� SalesService�ʿ� ���� �����ְ� Sales data�� ������ ���� ����ǵ��� �Ѵ�.
public class TableService {
	private TableDao tableDao;
	public TableService() throws Exception{
		tableDao = new TableDao();
	}
	/* 
	 * table service �޼ҵ� ����
	 */
	//���̺���Ʈ��ü���
	public ArrayList<Table> tableList() throws Exception{
		ArrayList<Table> tableList = tableDao.selectAll();
		return tableList;
	}
	//�մ�����
	public void ipJang(Table table) throws Exception{
		tableDao.insert(table);
	}
	//�մ�����
	public Table toiJang(int table_no, String outTime) throws Exception{
		Table outTable = tableDao.insertOfOutTime(table_no, outTime);
		return outTable;
	}
	
	//�޴��ֹ�
	public void orderMenu(int table_no, String order_no) throws Exception{
		tableDao.updateOfOrderNoByAdd(table_no, order_no);
	}
	
	//�޴�����
	public void orderMenuUpdate(int table_no, String order_no) throws Exception{
		tableDao.updateOfOrderNoByChange(table_no, order_no);
	}
	
	//����������̺� �˻�
	public boolean isUsingTable(int table_no) throws Exception{
		boolean isUsingTable = tableDao.selectUsingTable(table_no);
		return isUsingTable;
	}
	
	//�ϳ��� ����������̺����ִ����˻�
	public boolean isUsingTableAll() throws Exception{
		boolean isUsingTableAll = tableDao.selectUsingTableAll();
		return isUsingTableAll;
	}
	
	//�ش����̺� �޴����ֹ��ߴ����˻�
	public boolean isOrderOKTable(int table_no) throws Exception{
		boolean isOrderOKTable = tableDao.selectOrderOKTable(table_no);
		return isOrderOKTable;
	}
	
	//���� ������̺����� ����
	public ArrayList<Table> allTableInfo() throws Exception{
		return tableDao.selectAll();
	}
	
	//���̺��ȣ�� ���̺��ο��� ����
	public int getGuestCount(int table_no) throws Exception{
		return tableDao.selectGuestNoByTableNo(table_no);
	}
	
	//����������̺�� ��ȣ ����
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
			timeSales = ( (outHour - inHour) * 2000 + 2000 ) * table.getGuest_no();	//�⺻��2000����
		else
			timeSales = ( ( (outHour + 24 * (outDay - inDay) ) - inHour ) * 2000 + 2000 ) * table.getGuest_no();
		// ( outTime - inTime ) * 2000 ���
		
		return timeSales;
	}
}
