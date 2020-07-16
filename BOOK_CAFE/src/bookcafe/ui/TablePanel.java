package bookcafe.ui;

import javax.swing.*;

import bookcafe.table.TableService;
import bookcafe.table.Table;
import bookcafe.menu.MenuService;
import bookcafe.menu.Menu;
import bookcafe.sales.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class TablePanel extends JPanel implements ActionListener{
	ToggleButton tableB[] = new ToggleButton[9];		//테이블버튼 9개
	CardLayout cardLayout;					// 메뉴리스트가뜨는 CardLayout
	JPanel card_Panel;						// 메뉴리스트가뜨는 Card_Panel
	JButton serviceB[] = new JButton[4];
	String serviceS[] = {"손님입장", "음식주문", "음식수정", "계산"};
	JTextArea printTA;
	OrderPanel orderPanel;

	TableService tableSv = new TableService();
	MenuService menuSv = new MenuService();
	SalesService salesSv = new SalesService();
	int tableNo;
	String orderInfo;
	String orderList[] = new String[9];
	int guestNo;
	Table outTable;
	int foodTot;
	int timeTot;
	ArrayList tableMenuCount = new ArrayList<>();
	
	
	public TablePanel() throws Exception {
		setLayout(null);
		//왼쪽위패널(테이블버튼)
		JPanel panel1 = new JPanel();
		panel1.setBounds(0, 0, 405, 330);
		add(panel1);
		panel1.setLayout(null);
		
		for (int i = 0; i < tableB.length; i++) {
			tableB[i] = new ToggleButton(Integer.toString(i+1));
			int xPos = 15 + (i%3) * 138;
			int yPos = 15 +  (i/3)* 105;
			tableB[i].setBounds(xPos, yPos, 100, 90);
			tableB[i].setEnabled(false);
			panel1.add(tableB[i]);
			tableB[i].addActionListener(this);
		}
		ArrayList<Integer> usingTablesNo = tableSv.allUsingTablesNo();
		if(usingTablesNo != null){
			for (Integer tableNo : usingTablesNo) {
				tableB[tableNo-1].setEnabled(true);
			}
		}

		//오른쪽위패널(메뉴리스트)
		card_Panel = new JPanel();
		card_Panel.setBounds(405, 5, 415, 410);
		add(card_Panel);
		cardLayout = new CardLayout();
		card_Panel.setLayout(cardLayout);
		
		JLabel mImageLabel = new JLabel(new ImageIcon("images/table.png"));
		mImageLabel.setBounds(0, 15, 400, 356);
		card_Panel.add(mImageLabel, "name_5283952374065");
	
		orderPanel = new OrderPanel();
		card_Panel.add(orderPanel, "name_5556214918992");
				
		
		//왼쪽아래패널(TextArea)
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(15, 330, 379, 130);
		add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		printTA = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(printTA);
		printTA.setBackground(Color.LIGHT_GRAY);
		printTA.setEditable(false);
		panel_3.add(scrollPane, BorderLayout.CENTER);
		
		//오른쪽아래패널(손님입장,퇴장 메뉴주문,수정 버튼)
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(405, 420, 800, 112);
		add(panel_4);
		panel_4.setLayout(null);
		//panel_4.setLayout(new GridLayout(0, 2, 10, 10));
		
		for (int i = 0; i < serviceB.length; i++) {
			serviceB[i] = new JButton(serviceS[i]);
			int xPos;
			if (i == 0) {
				xPos = 7 + (i%4) * 100;
			} else {
				xPos = 27 + (i%4) * 97;
			}
			int yPos = 0;
			serviceB[i].setBounds(xPos, yPos, 87, 30);
			panel_4.add(serviceB[i]);
			serviceB[i].addActionListener(this);
		}
		serviceB[1].setEnabled(false);
		serviceB[2].setEnabled(false);
		if(!tableSv.isUsingTableAll()){
			serviceB[3].setEnabled(false);
		}
		

	}
	@Override
	public void actionPerformed(ActionEvent e){
		//테이블버튼클릭
		for (int i = 0; i < tableB.length; i++) {
			//테이블버튼 9개 선택시
			if(e.getSource() == tableB[i]){
				//해당테이블번호 가져오기
				tableNo = Integer.parseInt(e.getActionCommand());
				//주문패널에 있는 Label에 테이블번호 넘겨주기 
				orderPanel.setTableNo(tableNo);
				
				
				//클릭한 테이블버튼의 주문목록에값이있는지 확인하고 없으면 주문수정버튼비활성화
				try {
					if(tableSv.isOrderOKTable(tableNo)){
						serviceB[2].setEnabled(true);
					}
					else
						serviceB[2].setEnabled(false);
						
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				//클릭한버튼 버튼색반전
				tableB[i].status= !tableB[i].status;	//색상반전
				//클릭한 버튼제외한나머지버튼색 초기화
				for (int j = 0; j < tableB.length; j++) {
					if(i != j){
						tableB[j].status = false;
						tableB[j].setBackground(Color.LIGHT_GRAY);
					}
				}
				//테이블버튼을 한번클릭했을때 메뉴목록보여주기, 주문하기버튼활성화
				if(tableB[i].status == true){
					cardLayout.last(card_Panel);
					serviceB[1].setEnabled(true);
					/* sm add */
					if(orderList[i] != null)
						printTA.setText(orderList[i]);
					else
						printTA.setText("메뉴를주문하세요.");
					/* sm add end */
				}
				//테이블버튼을 두번클릭했을때 사진보여주기, 주문하기버튼비활성화
				else{
					cardLayout.first(card_Panel);
					serviceB[1].setEnabled(false);
				}
				//주문패널에 선택되있는 모든 체크박스, 콤보박스 초기화
				orderPanel.setOrderComplete();
			}
		}
		
		if(e.getSource() == serviceB[0]){		//손님입장
			//다이얼로그띄움
			GuestInDialog guistInD = new GuestInDialog();
			guistInD.setModal(true);
			guistInD.setResizable(false);
			guistInD.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
			guistInD.setVisible(true);
			//다이얼로그에서 테이블번호 불러옴
			tableNo = guistInD.getTableNo();
			//Cancle누르면 0이 리턴되고 이벤트메소드밖으로빠져나가서 손님입장기능수행안됨
			if(tableNo == 0)
				return;
			try {
				//입장할 테이블번호 입력이 데이터에들어있으면 현재사용중인테이블이라고 다이얼로그띄움
				boolean isUsingTable = tableSv.isUsingTable(tableNo);
				if(isUsingTable){
					JOptionPane.showMessageDialog(null, "현재사용중인 테이블입니다.");
					return;
				}
				//다이얼로그에서 손님수받아오기
				guestNo = guistInD.getguestNo();
				//테이블번호, 입장시간, 손님인원수 데이터에넣어주기
				tableSv.ipJang(new Table(tableNo, getRealTime() , guestNo));
				//해당테이블버튼 활성화
				tableB[tableNo-1].setEnabled(true);
				//입장완료시 TextArea에 메세지출력
				printTA.setText(tableNo + "번 테이블에 "+ guestNo + "명 입장하였습니다.");
				//현재사용중인테이블이면 계산버튼활성화
				if(tableSv.isUsingTableAll()){
					serviceB[3].setEnabled(true);
				}
				
				//다초기화
				cardLayout.first(card_Panel);
				serviceB[1].setEnabled(false);
				serviceB[2].setEnabled(false);
				orderPanel.setOrderComplete();
				for (int i = 0; i < tableB.length; i++) {
					tableB[i].status = false;
					tableB[i].setBackground(Color.LIGHT_GRAY);
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
		//주문하기
		if(e.getSource() == serviceB[1]){
			//주문패널에 있는 Label의 테이블번호 가져오기
			tableNo = orderPanel.getTableNo();
			
			//주문패널에 있는 주문정보 가져오기
			orderInfo = orderPanel.getSelectedItem();
			
			//주문패널에있는 선택된 모든 메뉴이름, 수량가져오기
			orderList[tableNo-1] = orderPanel.getOrderList();
			
			try {
				//주문시 메뉴수량이 테이블인원수보다작을때 1인1메뉴주문하라고 다이얼로그띄움
				if(tableSv.getGuestCount(tableNo) > orderPanel.getMenuCountTot()){
					JOptionPane.showMessageDialog(null, "인원수 : "+tableSv.getGuestCount(tableNo)+" (1인 1메뉴이상시키세요.)");
					return;
				}
				//각각메뉴들 수량을가져옴 ex) 0,0,1,2,3,0,0,0,......(18개)
				ArrayList<Integer> order = orderPanel.getMenuCounts();
				//테이블번호로찾아서 주문메뉴데이터넣어줌 ex) 1/1/2...
				tableSv.orderMenu(tableNo, orderInfo);
				cardLayout.first(card_Panel);	//주문완료시 사진으로초기화
				serviceB[1].setEnabled(false);	//주문완료시 주문하기버튼 비활성화
				serviceB[2].setEnabled(false);	//주문완료시 주문수정버튼 비활성화
				orderPanel.setOrderComplete();	//주문완료시 체크박스, 콤보박스 초기화
				//주문완료시 테이블버튼 색상 초기화
				for (int i = 0; i < tableB.length; i++) {	
					tableB[i].status = false;
					tableB[i].setBackground(Color.LIGHT_GRAY);
				}
				//TextArea에 주문정보출력
				if(!orderInfo.equals("")){
					printTA.setText("테이블번호 : "+tableNo+ "\n메뉴목록 : \n" + orderList[tableNo-1]);
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		//주문수정
		if(e.getSource() == serviceB[2]){
			//메뉴패널의 Label에서 테이블번호받아오기
			tableNo = orderPanel.getTableNo();
			
			//주문패널에 있는 주문정보 가져오기
			orderInfo = orderPanel.getSelectedItem();
			
			//주문패널에있는 선택된 모든 메뉴이름, 수량가져오기
			orderList[tableNo-1] = orderPanel.getOrderList();
			try {
				//주문시 메뉴수량이 테이블인원수보다작을때 1인1메뉴주문하라고 다이얼로그띄움
				if(tableSv.getGuestCount(tableNo) > orderPanel.getMenuCountTot()){
					JOptionPane.showMessageDialog(null, "인원수 : "+tableSv.getGuestCount(tableNo)+" (1인 1메뉴이상시키세요.)");
					return;
				}
				//기존에주문한메뉴를지우고 새로운주문정보가들어감
				tableSv.orderMenuUpdate(tableNo, orderInfo);
				//주문수정완료시 사진패널로교체
				cardLayout.first(card_Panel);
				//주문수정완료시 주문하기버튼 비활성화
				serviceB[1].setEnabled(false);
				//주문수정완료시 주문수정버튼 비활성화
				serviceB[2].setEnabled(false);
				//주문수정완료시 테이블버튼 색상초기화
				for (int i = 0; i < tableB.length; i++) {
					tableB[i].status = false;
					tableB[i].setBackground(Color.LIGHT_GRAY);
				}
				//TextArea에 주문정보출력
				if(!orderInfo.equals("")){
					printTA.setText("테이블번호 : "+tableNo+ "\n메뉴목록 : \n" + orderList[tableNo-1]);
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		
		//계산버튼
		if(e.getSource() == serviceB[3]){
			GuestOutDialog guistOutD = new GuestOutDialog(tableNo);
			guistOutD.setModal(true);
			guistOutD.setResizable(false);
			guistOutD.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
			guistOutD.setVisible(true);
			
			tableNo = guistOutD.getTableNo();
			if(tableNo == 0)
				return;
			try {
				//계산시 테이블에 정보가있는지확인
				boolean isUsingTable = tableSv.isUsingTable(tableNo);
				if(!isUsingTable){
					JOptionPane.showMessageDialog(null, "현재사용중인 테이블이아닙니다.");
					return;
				}
				//계산시 메뉴주문했나확인
				boolean isOrderOKTable = tableSv.isOrderOKTable(tableNo);
				if(!isOrderOKTable){
					JOptionPane.showMessageDialog(null, "메뉴를 주문하셔야합니다.");
					return;
				}
				//테이블번호로검색해 퇴장시간입력하고 퇴장객체뽑아옴
				outTable = tableSv.toiJang(tableNo, getRealTime());
				//퇴장한손님의 메뉴정보로 가격들가져옴
				ArrayList<Menu> menuList = menuSv.getMenuInfo(outTable.getOrder_no());
				//퇴장한손님의 음식총액계산
				foodTot = menuSv.foodSales(menuList);
				//퇴장한손님의 시간총액계산
				timeTot = tableSv.timeSales(outTable);
				//퇴장한손님의 날짜에서 시간제외하고 2016/10/05 형식으로 데이터저장
				String outTime = outTable.getOutTime();
				String[] time_split = outTime.split("/");
				outTime = time_split[0] + "/" + time_split[1] + "/" + time_split[2];
				//SalesService에 퇴장한손님의 퇴장시간, 음식총액, 시간총액, 총액 정보를 넘겨줌
				salesSv.insert2(outTime, foodTot, timeTot, foodTot+timeTot);
				
				//전체초기화
				tableB[tableNo-1].setEnabled(false);
				printTA.setText("테이블번호 : "+Integer.toString(outTable.getTable_no())+
						"\n입장시간 : "+outTable.getInTime()+ "\n퇴장시간 : "+outTable.getOutTime()+
						"\n인원수 : "+outTable.getGuest_no() + "\n음식총액 : "+Integer.toString(foodTot)+ 
						"\n시간총액 : "+Integer.toString(timeTot));
				if(!tableSv.isUsingTableAll()){
					serviceB[3].setEnabled(false);
				}
				cardLayout.first(card_Panel);
				serviceB[1].setEnabled(false);
				serviceB[2].setEnabled(false);
				orderPanel.setOrderComplete();
				for (int i = 0; i < tableB.length; i++) {
					tableB[i].status = false;
					tableB[i].setBackground(Color.LIGHT_GRAY);
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
		
	}
	//현재시간받아오는메소드
	public String getRealTime(){
		Calendar today = Calendar.getInstance();
		String year = Integer.toString(today.get(Calendar.YEAR));
		String month = Integer.toString(today.get(Calendar.MONTH) + 1);
		if(month.length() == 1){
			month = "0" + month;
		}
		String date = Integer.toString(today.get(Calendar.DAY_OF_MONTH));
		if(date.length() == 1){
			date = "0" + date;
		}
		String hour = Integer.toString(today.get(Calendar.HOUR_OF_DAY));
		if(hour.length() == 1){
			hour = "0" + hour;
		}
		return year + "/" + month + "/" + date + "/" + hour;
	}
}
