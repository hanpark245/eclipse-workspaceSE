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
	ToggleButton tableB[] = new ToggleButton[9];		//���̺��ư 9��
	CardLayout cardLayout;					// �޴�����Ʈ���ߴ� CardLayout
	JPanel card_Panel;						// �޴�����Ʈ���ߴ� Card_Panel
	JButton serviceB[] = new JButton[4];
	String serviceS[] = {"�մ�����", "�����ֹ�", "���ļ���", "���"};
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
		//�������г�(���̺��ư)
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

		//���������г�(�޴�����Ʈ)
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
				
		
		//���ʾƷ��г�(TextArea)
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(15, 330, 379, 130);
		add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		printTA = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(printTA);
		printTA.setBackground(Color.LIGHT_GRAY);
		printTA.setEditable(false);
		panel_3.add(scrollPane, BorderLayout.CENTER);
		
		//�����ʾƷ��г�(�մ�����,���� �޴��ֹ�,���� ��ư)
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
		//���̺��ưŬ��
		for (int i = 0; i < tableB.length; i++) {
			//���̺��ư 9�� ���ý�
			if(e.getSource() == tableB[i]){
				//�ش����̺��ȣ ��������
				tableNo = Integer.parseInt(e.getActionCommand());
				//�ֹ��гο� �ִ� Label�� ���̺��ȣ �Ѱ��ֱ� 
				orderPanel.setTableNo(tableNo);
				
				
				//Ŭ���� ���̺��ư�� �ֹ���Ͽ������ִ��� Ȯ���ϰ� ������ �ֹ�������ư��Ȱ��ȭ
				try {
					if(tableSv.isOrderOKTable(tableNo)){
						serviceB[2].setEnabled(true);
					}
					else
						serviceB[2].setEnabled(false);
						
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				//Ŭ���ѹ�ư ��ư������
				tableB[i].status= !tableB[i].status;	//�������
				//Ŭ���� ��ư�����ѳ�������ư�� �ʱ�ȭ
				for (int j = 0; j < tableB.length; j++) {
					if(i != j){
						tableB[j].status = false;
						tableB[j].setBackground(Color.LIGHT_GRAY);
					}
				}
				//���̺��ư�� �ѹ�Ŭ�������� �޴���Ϻ����ֱ�, �ֹ��ϱ��ưȰ��ȭ
				if(tableB[i].status == true){
					cardLayout.last(card_Panel);
					serviceB[1].setEnabled(true);
					/* sm add */
					if(orderList[i] != null)
						printTA.setText(orderList[i]);
					else
						printTA.setText("�޴����ֹ��ϼ���.");
					/* sm add end */
				}
				//���̺��ư�� �ι�Ŭ�������� ���������ֱ�, �ֹ��ϱ��ư��Ȱ��ȭ
				else{
					cardLayout.first(card_Panel);
					serviceB[1].setEnabled(false);
				}
				//�ֹ��гο� ���õ��ִ� ��� üũ�ڽ�, �޺��ڽ� �ʱ�ȭ
				orderPanel.setOrderComplete();
			}
		}
		
		if(e.getSource() == serviceB[0]){		//�մ�����
			//���̾�α׶��
			GuestInDialog guistInD = new GuestInDialog();
			guistInD.setModal(true);
			guistInD.setResizable(false);
			guistInD.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
			guistInD.setVisible(true);
			//���̾�α׿��� ���̺��ȣ �ҷ���
			tableNo = guistInD.getTableNo();
			//Cancle������ 0�� ���ϵǰ� �̺�Ʈ�޼ҵ�����κ��������� �մ������ɼ���ȵ�
			if(tableNo == 0)
				return;
			try {
				//������ ���̺��ȣ �Է��� �����Ϳ���������� �������������̺��̶�� ���̾�α׶��
				boolean isUsingTable = tableSv.isUsingTable(tableNo);
				if(isUsingTable){
					JOptionPane.showMessageDialog(null, "���������� ���̺��Դϴ�.");
					return;
				}
				//���̾�α׿��� �մԼ��޾ƿ���
				guestNo = guistInD.getguestNo();
				//���̺��ȣ, ����ð�, �մ��ο��� �����Ϳ��־��ֱ�
				tableSv.ipJang(new Table(tableNo, getRealTime() , guestNo));
				//�ش����̺��ư Ȱ��ȭ
				tableB[tableNo-1].setEnabled(true);
				//����Ϸ�� TextArea�� �޼������
				printTA.setText(tableNo + "�� ���̺� "+ guestNo + "�� �����Ͽ����ϴ�.");
				//�������������̺��̸� ����ưȰ��ȭ
				if(tableSv.isUsingTableAll()){
					serviceB[3].setEnabled(true);
				}
				
				//���ʱ�ȭ
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
		
		//�ֹ��ϱ�
		if(e.getSource() == serviceB[1]){
			//�ֹ��гο� �ִ� Label�� ���̺��ȣ ��������
			tableNo = orderPanel.getTableNo();
			
			//�ֹ��гο� �ִ� �ֹ����� ��������
			orderInfo = orderPanel.getSelectedItem();
			
			//�ֹ��гο��ִ� ���õ� ��� �޴��̸�, ������������
			orderList[tableNo-1] = orderPanel.getOrderList();
			
			try {
				//�ֹ��� �޴������� ���̺��ο������������� 1��1�޴��ֹ��϶�� ���̾�α׶��
				if(tableSv.getGuestCount(tableNo) > orderPanel.getMenuCountTot()){
					JOptionPane.showMessageDialog(null, "�ο��� : "+tableSv.getGuestCount(tableNo)+" (1�� 1�޴��̻��Ű����.)");
					return;
				}
				//�����޴��� ������������ ex) 0,0,1,2,3,0,0,0,......(18��)
				ArrayList<Integer> order = orderPanel.getMenuCounts();
				//���̺��ȣ��ã�Ƽ� �ֹ��޴������ͳ־��� ex) 1/1/2...
				tableSv.orderMenu(tableNo, orderInfo);
				cardLayout.first(card_Panel);	//�ֹ��Ϸ�� ���������ʱ�ȭ
				serviceB[1].setEnabled(false);	//�ֹ��Ϸ�� �ֹ��ϱ��ư ��Ȱ��ȭ
				serviceB[2].setEnabled(false);	//�ֹ��Ϸ�� �ֹ�������ư ��Ȱ��ȭ
				orderPanel.setOrderComplete();	//�ֹ��Ϸ�� üũ�ڽ�, �޺��ڽ� �ʱ�ȭ
				//�ֹ��Ϸ�� ���̺��ư ���� �ʱ�ȭ
				for (int i = 0; i < tableB.length; i++) {	
					tableB[i].status = false;
					tableB[i].setBackground(Color.LIGHT_GRAY);
				}
				//TextArea�� �ֹ��������
				if(!orderInfo.equals("")){
					printTA.setText("���̺��ȣ : "+tableNo+ "\n�޴���� : \n" + orderList[tableNo-1]);
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		//�ֹ�����
		if(e.getSource() == serviceB[2]){
			//�޴��г��� Label���� ���̺��ȣ�޾ƿ���
			tableNo = orderPanel.getTableNo();
			
			//�ֹ��гο� �ִ� �ֹ����� ��������
			orderInfo = orderPanel.getSelectedItem();
			
			//�ֹ��гο��ִ� ���õ� ��� �޴��̸�, ������������
			orderList[tableNo-1] = orderPanel.getOrderList();
			try {
				//�ֹ��� �޴������� ���̺��ο������������� 1��1�޴��ֹ��϶�� ���̾�α׶��
				if(tableSv.getGuestCount(tableNo) > orderPanel.getMenuCountTot()){
					JOptionPane.showMessageDialog(null, "�ο��� : "+tableSv.getGuestCount(tableNo)+" (1�� 1�޴��̻��Ű����.)");
					return;
				}
				//�������ֹ��Ѹ޴�������� ���ο��ֹ���������
				tableSv.orderMenuUpdate(tableNo, orderInfo);
				//�ֹ������Ϸ�� �����гηα�ü
				cardLayout.first(card_Panel);
				//�ֹ������Ϸ�� �ֹ��ϱ��ư ��Ȱ��ȭ
				serviceB[1].setEnabled(false);
				//�ֹ������Ϸ�� �ֹ�������ư ��Ȱ��ȭ
				serviceB[2].setEnabled(false);
				//�ֹ������Ϸ�� ���̺��ư �����ʱ�ȭ
				for (int i = 0; i < tableB.length; i++) {
					tableB[i].status = false;
					tableB[i].setBackground(Color.LIGHT_GRAY);
				}
				//TextArea�� �ֹ��������
				if(!orderInfo.equals("")){
					printTA.setText("���̺��ȣ : "+tableNo+ "\n�޴���� : \n" + orderList[tableNo-1]);
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		
		//����ư
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
				//���� ���̺� �������ִ���Ȯ��
				boolean isUsingTable = tableSv.isUsingTable(tableNo);
				if(!isUsingTable){
					JOptionPane.showMessageDialog(null, "���������� ���̺��̾ƴմϴ�.");
					return;
				}
				//���� �޴��ֹ��߳�Ȯ��
				boolean isOrderOKTable = tableSv.isOrderOKTable(tableNo);
				if(!isOrderOKTable){
					JOptionPane.showMessageDialog(null, "�޴��� �ֹ��ϼž��մϴ�.");
					return;
				}
				//���̺��ȣ�ΰ˻��� ����ð��Է��ϰ� ���尴ü�̾ƿ�
				outTable = tableSv.toiJang(tableNo, getRealTime());
				//�����Ѽմ��� �޴������� ���ݵ鰡����
				ArrayList<Menu> menuList = menuSv.getMenuInfo(outTable.getOrder_no());
				//�����Ѽմ��� �����Ѿװ��
				foodTot = menuSv.foodSales(menuList);
				//�����Ѽմ��� �ð��Ѿװ��
				timeTot = tableSv.timeSales(outTable);
				//�����Ѽմ��� ��¥���� �ð������ϰ� 2016/10/05 �������� ����������
				String outTime = outTable.getOutTime();
				String[] time_split = outTime.split("/");
				outTime = time_split[0] + "/" + time_split[1] + "/" + time_split[2];
				//SalesService�� �����Ѽմ��� ����ð�, �����Ѿ�, �ð��Ѿ�, �Ѿ� ������ �Ѱ���
				salesSv.insert2(outTime, foodTot, timeTot, foodTot+timeTot);
				
				//��ü�ʱ�ȭ
				tableB[tableNo-1].setEnabled(false);
				printTA.setText("���̺��ȣ : "+Integer.toString(outTable.getTable_no())+
						"\n����ð� : "+outTable.getInTime()+ "\n����ð� : "+outTable.getOutTime()+
						"\n�ο��� : "+outTable.getGuest_no() + "\n�����Ѿ� : "+Integer.toString(foodTot)+ 
						"\n�ð��Ѿ� : "+Integer.toString(timeTot));
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
	//����ð��޾ƿ��¸޼ҵ�
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
