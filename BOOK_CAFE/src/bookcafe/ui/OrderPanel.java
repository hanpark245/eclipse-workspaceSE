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
	String menuS[] = {"�Ƹ޸�ī��(4000)", "����������(4000)", "ī��Ḷ���ƶ�(6000)", "ī���ī(6000)",
			"ī���(6000)", "�ٴҶ��(5500)", "������(5500)", "Ǫ��Ǫġ��(6000)", "�ݶ�(2000)",
			"��ī��(4000)", "ġ������ũ(5000)", "Ƽ��̽�(4000)", "������ġ(4000)", "��Ϻ귡��(6000)",
			"���(3000)", "���İ�Ƽ(7000)", "���(7000)", "ī��(7000)"};
	JComboBox menuCombo[] = new JComboBox[18];
	String[] comboS = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"};
	int[] yMargin =	{25,25,25,25,25,25,25,25,25,35,35,35,35,35,45,45,45,45};	// sm add
	JLabel tableNoLA;

	public OrderPanel() {
		setLayout(null);
		
		tableNoLA = new JLabel("");
		tableNoLA.setBounds(241, 10, 77, 15);
		add(tableNoLA);
		
		JLabel menuLA1 = new JLabel("����");
		menuLA1.setBounds(85, 30, 57, 15);
		add(menuLA1);
		
		JLabel menuLA2 = new JLabel("����");
		menuLA2.setBounds(85, 220, 57, 15);
		add(menuLA2);
		
		JLabel menuLA3 = new JLabel("�Ļ�");
		menuLA3.setBounds(85, 330, 57, 15);
		add(menuLA3);
		
		JLabel label = new JLabel("���̺��ȣ");
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
					orderList += menuCB[i].getActionCommand() + "\t���� : " + Integer.toString(menuCombo[i].getSelectedIndex())+"\n";
				else
					orderList += menuCB[i].getActionCommand() + "\t\t���� : " + Integer.toString(menuCombo[i].getSelectedIndex())+"\n";

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
