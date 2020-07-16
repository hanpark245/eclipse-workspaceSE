package bookcafe.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import bookcafe.book.Book;
import bookcafe.sales.Sales;
import bookcafe.sales.SalesService;
import bookcafe.table.Table;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SalesPanel extends JPanel {
	private JTable table;
	private JButton listViewBTN;
	private JButton monthlyBTN;
	public String[][] dataStr;
	private DefaultTableModel tableModel;
	public JTextField searchTF = new JTextField();		// 월매출검색창;
	
	
	SalesService salesSV = new SalesService();	
	String header[] = {"날짜","음식 매출","시간 매출","총 매출"};
	JScrollPane scrollPane;
	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public SalesPanel() throws Exception {
		setLayout(null);
		
		// data 관련 처리
		scrollPane = new JScrollPane();
		scrollPane.setBounds(73, 70, 680, 347);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		reset();				

		table.setAutoCreateRowSorter(true);
		TableRowSorter Tsorter = new TableRowSorter(table.getModel());
		table.setRowSorter(Tsorter);
		
		
		
		
		
		
		
		JLabel lblNewLabel = new JLabel("\uD56D\uBAA9\uC744 \uD074\uB9AD\uD558\uC5EC \uC815\uB82C\uD558\uC138\uC694.");
		lblNewLabel.setBounds(73, 40, 199, 15);
		add(lblNewLabel);
		
		
		listViewBTN = new JButton("전체보기");	// 전체보기
		listViewBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					reset();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
				
			}
		});
		listViewBTN.setBounds(73, 438, 97, 23);
		add(listViewBTN);
		
		
		searchTF.setBounds(524, 437, 116, 21);
		add(searchTF);
		searchTF.setColumns(10);
		
		/*******************두번쨰 테이블**************************/
		monthlyBTN = new JButton("월매출검색");	// 월매출검색
		monthlyBTN.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String selectMonth = searchTF.getText();
					if(selectMonth.equals("")){
						JOptionPane.showMessageDialog(null, "값을입력해주세요.");
						return;
					}
					for (int i = 0; i < selectMonth.length(); i++) {
						char tempChar=selectMonth.charAt(i);
						if(tempChar <'0' || tempChar>'9'){
							JOptionPane.showMessageDialog(null, "숫자를입력하세요.");
							return;
						}
					}
					selectMonth = itostr(selectMonth);
					//String selectMonth = itostr(searchTF.getText());
					ArrayList<Sales> tempMonth = new ArrayList<Sales>();
	
					switch (selectMonth){
					case "01":
							tempMonth = salesSV.searchMonth(selectMonth);
							break;
					case "02":
						tempMonth = salesSV.searchMonth(selectMonth);
						break;
					case "03":
						tempMonth = salesSV.searchMonth(selectMonth);
						break;
					case "04":
						tempMonth = salesSV.searchMonth(selectMonth);
						break;
					case "05":
						tempMonth = salesSV.searchMonth(selectMonth);
						break;
					case "06":
						tempMonth = salesSV.searchMonth(selectMonth);
						break;
					case "07":
						tempMonth = salesSV.searchMonth(selectMonth);
						break;
					case "08":
						tempMonth = salesSV.searchMonth(selectMonth);
						break;
					case "09":
						tempMonth = salesSV.searchMonth(selectMonth);
						break;
					case "10":
						tempMonth = salesSV.searchMonth(selectMonth);
						break;
					case "11":
						tempMonth = salesSV.searchMonth(selectMonth);
						break;
					case "12":
						tempMonth = salesSV.searchMonth(selectMonth);
						break;
					default : 
						JOptionPane.showMessageDialog(null, "1 ~ 12월 사이의 값을 입력하세요.");
						return;
					}
					dataStr = new String[tempMonth.size()][4];
					
					for (int i = 0; i < tempMonth.size(); i++) {
						Sales salesA = tempMonth.get(i);
						dataStr[i][0] = salesA.getSales_date() + "";
						dataStr[i][1] = salesA.getSales_food() + "";
						dataStr[i][2] = salesA.getSales_tm() + "";						
						dataStr[i][3] = salesA.getSales_tot() + "";
					}
					
					tableModel = new DefaultTableModel(dataStr, header);
					table.setModel(tableModel);
					table.getColumnModel().getColumn(1).setPreferredWidth(288);
					table.getColumnModel().getColumn(2).setPreferredWidth(114);
		
				} catch (Exception e2) {
					e2.printStackTrace();
				}				
			}

			private String itostr(String text) {
				String tempString = new String();
				if (Integer.parseInt(text) < 10) {
					tempString = "0" + text;
				}else{
					tempString = text;
				}
				return tempString;
			}
		});
		monthlyBTN.setBounds(644, 436, 110, 23);
		add(monthlyBTN);		
	
	}
	public void reset() throws Exception{
		ArrayList<Sales> tempSales = salesSV.searchListAll();
		searchTF.setText("");
		dataStr = new String[tempSales.size()][4];
		
		for (int i = 0; i < tempSales.size(); i++) {
			Sales tSales = tempSales.get(i);
			dataStr[i][0] = tSales.getSales_date();
			dataStr[i][1] = tSales.getSales_food() + "";
			dataStr[i][2] = tSales.getSales_tm() + "";
			dataStr[i][3] = tSales.getSales_tot() + "";	
		}
		table.setModel(new DefaultTableModel(dataStr, header));
		table.getColumnModel().getColumn(1).setPreferredWidth(288);
		table.getColumnModel().getColumn(2).setPreferredWidth(114);
		table.getColumnModel().getColumn(2).setResizable(false);
		
	}
}
