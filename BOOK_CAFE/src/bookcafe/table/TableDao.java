package bookcafe.table;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/*
 * DAO(Data(File,DB,....) Access Object)
 *   - 멤버데이타를 저장하고있는 파일(테이블)에
 *     CRUD(Create,Read,Update,Delete) 단위작업을 하는 메소드
 *     단위메쏘드를 가지고있는 클래스
 *   - MemberService의 요청을받아서 Data Accessing에
 *     관련된 단위기능(Insert,select,update,delete 메쏘드)을 수행하는 객체
 */
public class TableDao {
	File file;
	public TableDao() throws Exception{ //호출한곳으로 Exception을던짐 -> TableService
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
	 * 파일읽기(연결)
	 */
	private ArrayList<Table> readData() throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		ArrayList<Table> tableList = (ArrayList<Table>) ois.readObject();
		return tableList;
	}

	/*
	 * 파일쓰기(연결해제)
	 */
	private void saveData(ArrayList<Table> tableList) throws Exception {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(tableList);
		oos.flush();
		oos.close();
	}
	/************************INSERT**************************/
	//받아온 Table객체저장(테이블번호,입장시간,인원수만 값이들어감) 주문번호는 주문시, 퇴장시간은 계산시값을넣어줌
	public void insert(Table table)throws Exception{
		ArrayList<Table> tableList = this.readData();
		tableList.add(table);
		this.saveData(tableList);
	}
	
	//퇴장기능 ->  outTime설정후 ArrayList에서 삭제, 퇴장한객체는 매출관리부분의 자료로 넘기기위해 return해줌 
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
	//음식수정기능 -> 기존에저장된 주문번호에 새로운주문번호 덮어쓰기 (교체에의한주문번호수정)
	public void updateOfOrderNoByChange(int table_no, String order_no) throws Exception{
		ArrayList<Table> tableList = this.readData();
		for (Table table : tableList) {
			if(table.getTable_no() == table_no){
				table.setOrder_no(order_no);	//주문번호 재설정
			}
		}
		saveData(tableList);
	}
	
	//주문하기 -> 주문번호는 누적, /로 주문번호구분  (추가에의한주문번호수정)
	public void updateOfOrderNoByAdd(int table_no, String order_no) throws Exception{
		ArrayList<Table> tableList = this.readData();
		for (Table table : tableList) {
			if(table.getTable_no() == table_no){
				table.setOrder_no(table.getOrder_no() + order_no);	//기존주문데이터에 새로운주문데이터누적
			}
		}
		saveData(tableList);
	}
	
	/************************SELECT**************************/
	//사용중인테이블인지 검색
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
	
	//사용중인테이블이 하나라도있는지 검사
	public boolean selectUsingTableAll() throws Exception{
		boolean isUsingTableAll = false;
		ArrayList<Table> tableList = this.readData();
		if(tableList.size() != 0){
			isUsingTableAll = true;
		}
		return isUsingTableAll;
	}
	
	//해당테이블에 메뉴를주문했는지검사
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
	
	//해당테이블의 인원수 몇명인지 찾기
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
	
	//테이블 전체데이터출력 (기능은없지만 그냥만들어놓음)
	public ArrayList<Table> selectAll() throws Exception{
		ArrayList<Table> tableList = this.readData();
		
		return tableList;
	}
	
	//현재파일에저장된테이블들번호리턴(버튼의활성화,비활성화위해사용)
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
