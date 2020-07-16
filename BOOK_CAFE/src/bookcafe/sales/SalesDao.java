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
 *   - 멤버데이타를 저장하고있는 파일(테이블)에
 *     CRUD(Create,Read,Update,Delete) 단위작업을 하는 메소드
 *     단위메쏘드를 가지고있는 클래스
 *   - MemberService의 요청을받아서 Data Accessing에
 *     관련된 단위기능(Insert,select,update,delete 메쏘드)을 수행하는 객체
 */
public class SalesDao {
private File salesFile;
	
	public SalesDao()throws Exception {
		salesFile = new File("sales.dat"); //파일은 멤버테이블
		if(!salesFile.exists()){
			salesFile.createNewFile(); //파일존재하지않을경우 멤버파일 만든다
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(salesFile));
			oos.writeObject(new ArrayList<Sales>());
			oos.close();
		}
	}


/*
 * 파일읽기(연결) 
 */
private ArrayList<Sales> readData() throws Exception{
	ObjectInputStream ois = new ObjectInputStream(new FileInputStream(salesFile));
	
	ArrayList<Sales> salesList = (ArrayList<Sales>)ois.readObject();
	return salesList;
}

/*
 * 파일쓰기(연결해제)
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
public void insert(Sales addSales) throws Exception{    //객체를 인자로받아서 insert할 메소드
	System.out.println("3.SalesDao insert");
	ArrayList<Sales> salesList =(ArrayList<Sales>) this.readData();  //읽어온데이터를 salesList에 담는다
	salesList.add(addSales);  //salesList에 추가
	saveData(salesList);  
}
/*
 * select(read): 멤버 한개 select
 */

public Sales selectByDate(String date) throws Exception{  //날짜를 인자로받아서 객체하나 선택할 메소드
	System.out.println("3.SalesDao selectByDate");
	ArrayList<Sales> salesList = this.readData();  //읽어와서 salesList에 대입
	
	Sales findSales = null;    //반환해줄 임시변수
	for (Sales sales : salesList) {
		if(sales.getSales_date().equals(date)){
			findSales = sales;   
			break;
		}
	}
	return findSales;
}

/*
 * select(read): 멤버 여러개 select
 */

public ArrayList<Sales> selectAll() throws Exception{ 
	System.out.println("3.salesDao selectAll");	// sm edit
	ArrayList<Sales> salesList = this.readData();	// sm edit
	
	return salesList;	// sm edit
	/*System.out.println("3.salesDao selectAll");	// sm del
	ArrayList<Sales> salesList = readData();  //읽어온데이터를 salesList에 대입
	for (Sales sales : salesList) {   
		sales.toString();   //tostring메소드 사용해서 출력하기위함
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
		if(sales.getSales_date()==updatesales.getSales_date()){  //업데이트할 객체의 날짜가 같으면 업데이트 한다
			
			sales.setSales_tot(updatesales.getSales_tot());  //총매출 업데이트
			sales.setSales_food(updatesales.getSales_food());  //음식총매출 업데이트
			sales.setSales_tm(updatesales.getSales_tm());  //시간총매출 업데이트
		    break;
		}
	}
	this.saveData(salesList);  //리스트에 저장
}
/*
 * delete
 */
public void deleteByDate(String date) throws Exception{  //삭제할 메소드 반환타입void
	ArrayList<Sales> salesList = (ArrayList<Sales>)readData(); 
	for (Sales sales : salesList) {
		if(sales.getSales_date().equals(date)){   //인자로온 날짜와 같은 날짜의 객체를 삭제
			salesList.remove(sales);
			break;
		}
	}
	saveData(salesList); //삭제후저장
	
}
// 일일매출 등록메서드
public void insert2(Sales addTotSales) throws Exception{
	ArrayList<Sales> salesList = (ArrayList<Sales>)this.readData();
	
	if(salesList.size() == 0){	// Arraylist형은 안에 값이 없는것이지 사이즈가 0이다!!!
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
