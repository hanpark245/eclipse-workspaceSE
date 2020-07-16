package bookcafe.ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

public class OrderPanel extends JPanel implements ItemListener{
	JCheckBox menuCB[] = new JCheckBox[18];
	String menuS[] = {"아메리카노(4000)", "에스프레소(4000)", "카라멜마끼아또(6000)", "카페모카(6000)",
			"카페라떼(6000)", "바닐라라떼(5500)", "녹차라떼(5500)", "푸라푸치노(6000)", "콜라(2000)",
			"모카번(4000)", "치즈케이크(5000)", "티라미슈(4000)", "샌드위치(4000)", "허니브래드(6000)",
			"라면(3000)", "스파게티(7000)", "돈까스(7000)", "카레(7000)"};
	JComboBox menuCombo[] = new JComboBox[18];
	String[] comboS = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"};
	int[] yMargin =	{25,25,25,25,25,25,25,25,25,35,35,35,35,35,45,45,45,45};	// sm add
	JLabel tableNoLA;

	public OrderPanel() {
		setLayout(null);
		
		tableNoLA = new JLabel("");
		tableNoLA.setBounds(241, 10, 77, 15);
		add(tableNoLA);
		
		JLabel menuLA1 = new JLabel("음료");
		menuLA1.setBounds(85, 30, 57, 15);
		add(menuLA1);
		
		JLabel menuLA2 = new JLabel("간식");
		menuLA2.setBounds(85, 220, 57, 15);
		add(menuLA2);
		
		JLabel menuLA3 = new JLabel("식사");
		menuLA3.setBounds(85, 330, 57, 15);
		add(menuLA3);
		
		JLabel label = new JLabel("테이블번호");
		label.setBounds(156, 10, 77, 15);
		add(label);

		for (int i = 0; i < menuCB.length; i++) {
			menuCB[i] = new JCheckBox(menuS[i]);
			int mPos = yMargin[i] + i*20;
			menuCB[i].setBounds(135, mPos, 160, 20);
			add(menuCB[i]);
		}
		
		for (int i = 0; i < menuCombo.length; i++) {
			menuCombo[i] = new JComboBox();
			menuCombo[i].setModel(new DefaultComboBoxModel(comboS));
			int mPos = yMargin[i] + i*20;
			menuCombo[i].setBounds(318, mPos, 40, 20);
			add(menuCombo[i]);
			menuCombo[i].addItemListener(this);
		}
	}
	
	public String getSelectedItem(){
		String selectedMenu = "";
		for (int i = 0; i < menuCB.length; i++) {
			if(menuCB[i].isSelected() && !menuCombo[i].getSelectedItem().equals("0")){
				int menuCount = Integer.parseInt((String)menuCombo[i].getSelectedItem());
				for (int j = 0; j <menuCount ; j++) {
					selectedMenu += i+1 + "/";
				}
			}
		}
		return selectedMenu;
	}
	
	public void setTableNo(int tableNo){
		tableNoLA.setText(Integer.toString(tableNo));
	}
	
	public int getTableNo(){
		return Integer.parseInt(tableNoLA.getText());
	}
	
	public String getOrderList(){
		String orderList="";
		for (int i = 0; i < menuCB.length; i++) {
			if(menuCB[i].isSelected() && !menuCombo[i].getSelectedItem().equals("0")){
				String menuCount = (String)menuCombo[i].getSelectedItem();
				if(menuCB[i].getActionCommand().length() > 10)
					orderList += menuCB[i].getActionCommand() + "\t수량 : " + Integer.toString(menuCombo[i].getSelectedIndex())+"\n";
				else
					orderList += menuCB[i].getActionCommand() + "\t\t수량 : " + Integer.toString(menuCombo[i].getSelectedIndex())+"\n";

			}
		}
		return orderList;
	}
	
	public void setOrderComplete(){
		for (int i = 0; i < menuCombo.length; i++) {
			menuCombo[i].setSelectedIndex(0);
			menuCB[i].setSelected(false);
		}
	}
	
	public int getMenuCountTot(){
		int count = 0;
		for (int i = 0; i < menuCombo.length; i++) {
			count += Integer.parseInt((String)menuCombo[i].getSelectedItem());
		}
		return count;
	}
	
	public ArrayList<Integer> getMenuCounts(){
		ArrayList<Integer> menuCounts = new ArrayList<Integer>();
		for (int i = 0; i < menuCombo.length; i++) {
			menuCounts.add(Integer.parseInt((String)menuCombo[i].getSelectedItem()));
			System.out.println(menuCounts.get(i));
		}
		return menuCounts;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		for (int i = 0; i < menuCombo.length; i++) {
			if(e.getSource() == menuCombo[i]){
				int state=e.getStateChange();
				if(state==ItemEvent.SELECTED){
					if(menuCombo[i].getSelectedIndex() != 0)
						menuCB[i].setSelected(true);
					else
						menuCB[i].setSelected(false);
				}
			}
		}
		
		
	}

}
