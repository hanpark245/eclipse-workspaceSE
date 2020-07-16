package bookcafe.sales;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import bookcafe.table.Table;

/*
 * DAO(Data(File,DB,....) Access Object)
 *   - �������Ÿ�� �����ϰ��ִ� ����(���̺�)��
 *     CRUD(Create,Read,Update,Delete) �����۾��� �ϴ� �޼ҵ�
 *     �����޽�带 �������ִ� Ŭ����
 *   - MemberService�� ��û���޾Ƽ� Data Accessing��
 *     ���õ� �������(Insert,select,update,delete �޽��)�� �����ϴ� ��ü
 */
public class SalesDao {
private File salesFile;
	
	public SalesDao()throws Exception {
		salesFile = new File("sales.dat"); //������ ������̺�
		if(!salesFile.exists()){
			salesFile.createNewFile(); //������������������� ������� �����
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(salesFile));
			oos.writeObject(new ArrayList<Sales>());
			oos.close();
		}
	}


/*
 * �����б�(����) 
 */
private ArrayList<Sales> readData() throws Exception{
	ObjectInputStream ois = new ObjectInputStream(new FileInputStream(salesFile));
	
	ArrayList<Sales> salesList = (ArrayList<Sales>)ois.readObject();
	return salesList;
}

/*
 * ���Ͼ���(��������)
 */
private void saveData (ArrayList<Sales> salesList) throws Exception{
	 ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(salesFile));
	 
	 oos.writeObject(salesList);
	 oos.flush();
	 oos.close();
	 
}


/*
 * insert(create)
 */
public void insert(Sales addSales) throws Exception{    //��ü�� ���ڷι޾Ƽ� insert�� �޼ҵ�
	System.out.println("3.SalesDao insert");
	ArrayList<Sales> salesList =(ArrayList<Sales>) this.readData();  //�о�µ����͸� salesList�� ��´�
	salesList.add(addSales);  //salesList�� �߰�
	saveData(salesList);  
}
/*
 * select(read): ��� �Ѱ� select
 */

public Sales selectByDate(String date) throws Exception{  //��¥�� ���ڷι޾Ƽ� ��ü�ϳ� ������ �޼ҵ�
	System.out.println("3.SalesDao selectByDate");
	ArrayList<Sales> salesList = this.readData();  //�о�ͼ� salesList�� ����
	
	Sales findSales = null;    //��ȯ���� �ӽú���
	for (Sales sales : salesList) {
		if(sales.getSales_date().equals(date)){
			findSales = sales;   
			break;
		}
	}
	return findSales;
}

/*
 * select(read): ��� ������ select
 */

public ArrayList<Sales> selectAll() throws Exception{ 
	System.out.println("3.salesDao selectAll");	// sm edit
	ArrayList<Sales> salesList = this.readData();	// sm edit
	
	return salesList;	// sm edit
	/*System.out.println("3.salesDao selectAll");	// sm del
	ArrayList<Sales> salesList = readData();  //�о�µ����͸� salesList�� ����
	for (Sales sales : salesList) {   
		sales.toString();   //tostring�޼ҵ� ����ؼ� ����ϱ�����
	}
	return salesList;*/
}

public ArrayList<Sales> selectByMonth(String sales_date) throws Exception{
	ArrayList<Sales> salesList = readData();
	ArrayList<Sales> tempDate = new ArrayList<Sales>();
	for (Sales sales : salesList) {	// sm edit
		String tMonth = sales.getSales_date().split("/")[1];
		if(tMonth.equals(sales_date)){
			tempDate.add(sales);
		}
	}
	return tempDate;
}


/*
 * update 
 */
public void update(Sales updatesales) throws Exception{
	System.out.println("3.salesDao update"); 
	ArrayList<Sales> salesList=this.readData();  
 	for (Sales sales : salesList) {
		if(sales.getSales_date()==updatesales.getSales_date()){  //������Ʈ�� ��ü�� ��¥�� ������ ������Ʈ �Ѵ�
			
			sales.setSales_tot(updatesales.getSales_tot());  //�Ѹ��� ������Ʈ
			sales.setSales_food(updatesales.getSales_food());  //�����Ѹ��� ������Ʈ
			sales.setSales_tm(updatesales.getSales_tm());  //�ð��Ѹ��� ������Ʈ
		    break;
		}
	}
	this.saveData(salesList);  //����Ʈ�� ����
}
/*
 * delete
 */
public void deleteByDate(String date) throws Exception{  //������ �޼ҵ� ��ȯŸ��void
	ArrayList<Sales> salesList = (ArrayList<Sales>)readData(); 
	for (Sales sales : salesList) {
		if(sales.getSales_date().equals(date)){   //���ڷο� ��¥�� ���� ��¥�� ��ü�� ����
			salesList.remove(sales);
			break;
		}
	}
	saveData(salesList); //����������
	
}
// ���ϸ��� ��ϸ޼���
public void insert2(Sales addTotSales) throws Exception{
	ArrayList<Sales> salesList = (ArrayList<Sales>)this.readData();
	
	if(salesList.size() == 0){	// Arraylist���� �ȿ� ���� ���°����� ����� 0�̴�!!!
		this.insert(addTotSales);
	}else{	
	loop:
	for (int i = 0; i < salesList.size(); i++) {
		for (int j = 0; j < salesList.size(); j++) {
			if(salesList.get(j).getSales_date().equals(addTotSales.getSales_date())){
				salesList.get(j).setSales_food(salesList.get(j).getSales_food()+addTotSales.getSales_food());
				salesList.get(j).setSales_tm(salesList.get(j).getSales_tm()+addTotSales.getSales_tm());
				salesList.get(j).setSales_tot(salesList.get(j).getSales_tot()+addTotSales.getSales_tot());
				break loop;
			}
		}
		salesList.add(addTotSales);
		break;
	}	
	saveData(salesList);	
	}
}


}
