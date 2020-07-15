package ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;


import theater.TheaterService;
import theater.TheaterVo;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TheaterDeletePanel extends JPanel {
	private JTextField theaterNameTF;
	private JTable theaterTB;
	DefaultTableModel tableModel;
	
	ArrayList<TheaterVo> theaterList;
	TheaterService theaterService;
	TheaterVo selectedTheater;
	
	private TheaterManegementPanel tmPanel;
	private JButton exitB;
	private JButton searchB;
	private JButton deleteB;
	

	/**
	 * Create the panel.
	 */
	public TheaterDeletePanel() {
		try {
			theaterService = new TheaterService();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		setLayout(new BorderLayout(0, 0));
		
		JPanel titlePanel = new JPanel();
		add(titlePanel, BorderLayout.NORTH);
		titlePanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel = new JLabel("\uADF9\uC7A5\uC0AD\uC81C");
		lblNewLabel.setFont(new Font("��������ڵ�", Font.PLAIN, 24));
		titlePanel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		theaterTB = new JTable();
		
		theaterTB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = theaterTB.getSelectedRow();
				TheaterVo selectedTheater = theaterList.get(selectedRow);
				TheaterDeletePanel.this.selectedTheater = selectedTheater;
				System.out.println("���õ� ����:"+selectedTheater);
				
			}
		});
		scrollPane.setViewportView(theaterTB);
		
		JPanel southPanel = new JPanel();
		add(southPanel, BorderLayout.SOUTH);
		southPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel leftPanel = new JPanel();
		southPanel.add(leftPanel, BorderLayout.CENTER);
		leftPanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\uADF9\uC7A5\uC774\uB984");
		lblNewLabel_1.setBounds(5, 8, 82, 15);
		leftPanel.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		theaterNameTF = new JTextField();
		theaterNameTF.setBounds(99, 5, 137, 21);
		leftPanel.add(theaterNameTF);
		theaterNameTF.setHorizontalAlignment(SwingConstants.LEFT);
		theaterNameTF.setColumns(10);
		
		JPanel rightPanel = new JPanel();
		southPanel.add(rightPanel, BorderLayout.EAST);
		
		searchB = new JButton("\uAC80\uC0C9");
		searchB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					theaterJTable(theaterNameTF.getText());
					if (theaterNameTF.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "�����̸��� �Է��ϼ���.", "����� �Է�", JOptionPane.WARNING_MESSAGE);
						theaterNameTF.requestFocus();
						return;
					}
					JOptionPane.showMessageDialog(null, "������ �˻��Ǿ����ϴ�.", "�˻� ����", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "�˻��� �����Ͽ����ϴ�.", "�˻� ����", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		rightPanel.add(searchB);
		
		deleteB = new JButton("\uC0AD\uC81C");
		deleteB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (theaterNameTF.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "�����̸��� �Է��ϼ���.", "����� �Է�", JOptionPane.WARNING_MESSAGE);
					theaterNameTF.requestFocus();
					return;
				}
				try {
					removeTheater(selectedTheater);
					theaterJTable(theaterNameTF.getText());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		rightPanel.add(deleteB);
		
		exitB = new JButton("\uB098\uAC00\uAE30");
		exitB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tmPanel.changePanel("theaterButtonP");
			}
		});
		rightPanel.add(exitB);

	}
	/*
	 * ���� ����
	 */
	private void removeTheater(TheaterVo deleteTheater) throws Exception {
		theaterService.theaterDelete(deleteTheater.getTheaterNumber());
		JOptionPane.showMessageDialog(null, "�ش� ������ �����Ǿ����ϴ�.", "���� ����", JOptionPane.INFORMATION_MESSAGE);
		
	}
	/*
	 * �����̸����� ���� �˻�
	 */
	private void theaterJTable(String theaterName) throws Exception {
		Vector columnNames = new Vector();
		columnNames.add("��ȣ");
		columnNames.add("�����̸�");
		columnNames.add("��������");
		columnNames.add("�󿵰� ��");
		columnNames.add("�¼� ��");

		Vector data = new Vector();
		this.theaterList = theaterService.findTheaterByName(theaterName);
		for (TheaterVo theater : theaterList) {
			Vector rowVector = new Vector();
			rowVector.add(theater.getTheaterNumber());
			rowVector.add(theater.getTheaterName());
			rowVector.add(theater.getTheaterCity());
			rowVector.add(theater.getScreenAreaNum());
			rowVector.add(theater.getSeatTotNum());

			data.add(rowVector);

		}
		tableModel = new DefaultTableModel(data, columnNames);

		theaterTB.setModel(tableModel);
		
	

	}//end theaterJTable()
	
	/*
	 * �������̺� �ֽ�ȭ
	 */
	private void theaterJTable() throws Exception {
		Vector columnNames = new Vector();
		columnNames.add("��ȣ");
		columnNames.add("�����̸�");
		columnNames.add("��������");
		columnNames.add("�󿵰� ��");
		columnNames.add("�¼� ��");

		Vector data = new Vector();
		this.theaterList = theaterService.findAllTheater();
		for (TheaterVo theater : theaterList) {
			Vector rowVector = new Vector();
			rowVector.add(theater.getTheaterNumber());
			rowVector.add(theater.getTheaterName());
			rowVector.add(theater.getTheaterCity());
			rowVector.add(theater.getScreenAreaNum());
			rowVector.add(theater.getSeatTotNum());

			data.add(rowVector);

		}
		tableModel = new DefaultTableModel(data, columnNames);

		theaterTB.setModel(tableModel);

	}
	
	public void setTheaterPanel(TheaterManegementPanel theaterManegementPanel) {
		this.tmPanel = theaterManegementPanel;
	}
	
	
	
	
}//end class
