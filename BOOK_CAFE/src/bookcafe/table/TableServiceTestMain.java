package bookcafe.table;

import java.util.ArrayList;

public class TableServiceTestMain {

	public static void main(String[] args) throws Exception{
		TableService tableService = new TableService();
		
		System.out.println("-----���̺� �մ�����-----");
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
		
		System.out.println("-----������� ���̺����� �˻�-----");
		boolean isUsingTable = tableService.isUsingTable(1);
		if(isUsingTable){
			System.out.println("���� ����������̺��Դϴ�");
		}
		
		
		System.out.println("-----���̺� �ֹ�-----");
		tableService.orderMenu(1, "1/1/2/3/");
		tableService.orderMenu(2, "11/8/6/3/");
		tableService.orderMenu(3, "15/11/12/9/");
		tableService.orderMenu(4, "2/7/12/1/");

		
		tableList = tableService.allTableInfo();
		for (Table table : tableList) {
			System.out.println(table);
		}
		
		
		System.out.println("-----���̺� �ֹ�����-----");
		tableService.orderMenuUpdate(1, "1/2/3");
		tableService.orderMenuUpdate(2, "1/2/3");
		tableService.orderMenuUpdate(3, "1/2/3");
		tableService.orderMenuUpdate(4, "1/2/3");

		
		
		System.out.println("-----���̺� ����-----");
		Table outTable;
		outTable = tableService.toiJang(1, "2016-10-02-24");
		//���������̺��� ��ü�� UI���� �޾ƿͼ� MenuService���� �����ֹ���ȣ �Ѱ��ְ�
		//�ֹ���ȣ�鿡���� ��ü�������� ArrayList�� ��ȯ�޴´�
		//ArrayList<Menu> menuInfo = menuService.getMenuInfo(outTable.getOrder_no());
		
		//���������̺��� �ð��ݾ� ���
		int timeSales = tableService.timeSales(outTable);
		System.out.println("�ð���ݾ� : "+timeSales);
		//�ð��Ǹűݾ��� Sales.dat�� ������������
	}

}
