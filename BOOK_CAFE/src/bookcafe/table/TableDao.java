package bookcafe.table;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/*
 * DAO(Data(File,DB,....) Access Object)
 *   - �������Ÿ�� �����ϰ��ִ� ����(���̺�)��
 *     CRUD(Create,Read,Update,Delete) �����۾��� �ϴ� �޼ҵ�
 *     �����޽�带 �������ִ� Ŭ����
 *   - MemberService�� ��û���޾Ƽ� Data Accessing��
 *     ���õ� �������(Insert,select,update,delete �޽��)�� �����ϴ� ��ü
 */
public class TableDao {
	File file;
	public TableDao() throws Exception{ //ȣ���Ѱ����� Exception������ -> TableService
		init();
	}
	
	public void init() throws Exception{
		file = new File("table.dat");
		if(!file.exists()){
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(new ArrayList<Table>());
			oos.close();
		}
	}
	
	/*
	 * �����б�(����)
	 */
	private ArrayList<Table> readData() throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		ArrayList<Table> tableList = (ArrayList<Table>) ois.readObject();
		return tableList;
	}

	/*
	 * ���Ͼ���(��������)
	 */
	private void saveData(ArrayList<Table> tableList) throws Exception {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(tableList);
		oos.flush();
		oos.close();
	}
	/************************INSERT**************************/
	//�޾ƿ� Table��ü����(���̺��ȣ,����ð�,�ο����� ���̵�) �ֹ���ȣ�� �ֹ���, ����ð��� ���ð����־���
	public void insert(Table table)throws Exception{
		ArrayList<Table> tableList = this.readData();
		tableList.add(table);
		this.saveData(tableList);
	}
	
	//������ ->  outTime������ ArrayList���� ����, �����Ѱ�ü�� ��������κ��� �ڷ�� �ѱ������ return���� 
	public Table insertOfOutTime(int table_no, String outTime) throws Exception{	
		ArrayList<Table> tableList = this.readData();
		Table calculatedTable = null;
		for (Table table : tableList) {
			if(table.getTable_no() == table_no){
				table.setOutTime(outTime);
				calculatedTable = table;
				tableList.remove(table);
				break;
			}
		}
		this.saveData(tableList);
		return calculatedTable;
	}
	
	/************************UPDATE**************************/
	//���ļ������ -> ����������� �ֹ���ȣ�� ���ο��ֹ���ȣ ����� (��ü�������ֹ���ȣ����)
	public void updateOfOrderNoByChange(int table_no, String order_no) throws Exception{
		ArrayList<Table> tableList = this.readData();
		for (Table table : tableList) {
			if(table.getTable_no() == table_no){
				table.setOrder_no(order_no);	//�ֹ���ȣ �缳��
			}
		}
		saveData(tableList);
	}
	
	//�ֹ��ϱ� -> �ֹ���ȣ�� ����, /�� �ֹ���ȣ����  (�߰��������ֹ���ȣ����)
	public void updateOfOrderNoByAdd(int table_no, String order_no) throws Exception{
		ArrayList<Table> tableList = this.readData();
		for (Table table : tableList) {
			if(table.getTable_no() == table_no){
				table.setOrder_no(table.getOrder_no() + order_no);	//�����ֹ������Ϳ� ���ο��ֹ������ʹ���
			}
		}
		saveData(tableList);
	}
	
	/************************SELECT**************************/
	//����������̺����� �˻�
	public boolean selectUsingTable(int table_no) throws Exception{
		ArrayList<Table> tableList = this.readData();
		boolean isUsingTable = false;
		for (Table table : tableList) {
			if(table.getTable_no() == table_no){
				isUsingTable = true;
			}
		}
		return isUsingTable;
	}
	
	//����������̺��� �ϳ����ִ��� �˻�
	public boolean selectUsingTableAll() throws Exception{
		boolean isUsingTableAll = false;
		ArrayList<Table> tableList = this.readData();
		if(tableList.size() != 0){
			isUsingTableAll = true;
		}
		return isUsingTableAll;
	}
	
	//�ش����̺� �޴����ֹ��ߴ����˻�
	public boolean selectOrderOKTable(int table_no) throws Exception{
		boolean isOrderOKTable = false;
		ArrayList<Table> tableList = this.readData();
		for (Table table : tableList) {
			if(table.getTable_no() == table_no && !table.getOrder_no().equals("")){
				System.out.println(table.getOrder_no());
				isOrderOKTable = true;
			}
		}
		
		return isOrderOKTable;
	}
	
	//�ش����̺��� �ο��� ������� ã��
	public int selectGuestNoByTableNo(int table_no) throws Exception{
		int guestCount = 0;
		ArrayList<Table> tableList = this.readData();
		for (Table table : tableList) {
			if(table.getTable_no() == table_no){
				guestCount = table.getGuest_no();
			}
		}
		return guestCount;
	}
	
	//���̺� ��ü��������� (����������� �׳ɸ�������)
	public ArrayList<Table> selectAll() throws Exception{
		ArrayList<Table> tableList = this.readData();
		
		return tableList;
	}
	
	//�������Ͽ���������̺���ȣ����(��ư��Ȱ��ȭ,��Ȱ��ȭ���ػ��)
	public ArrayList<Integer> selectUsingTablesNo() throws Exception{
		ArrayList<Integer> usingTablesNo = new ArrayList<Integer>();
		ArrayList<Table> tableList = this.readData();
		for (Table table : tableList) {
			usingTablesNo.add(table.getTable_no());
		}
		return usingTablesNo;
	}
	
	/************************DELETE**************************/
	
	
	
	
	
	
	
	
	
	
	
	
	
}
