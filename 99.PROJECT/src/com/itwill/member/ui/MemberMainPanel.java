package com.itwill.member.ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.AbstractListModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;

public class MemberMainPanel extends JPanel {
	JTabbedPane memberTapPane;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public MemberMainPanel() {
		setLayout(new BorderLayout(0, 0));
		
		memberTapPane = new JTabbedPane(JTabbedPane.TOP);
		add(memberTapPane, BorderLayout.CENTER);
		
		JPanel memberDetailP = new JPanel();
		memberTapPane.addTab("회원상세보기", null, memberDetailP, null);
		
		JPanel memberListP = new JPanel();
		memberListP.setBackground(Color.ORANGE);
		memberTapPane.addTab("회원리스트", null, memberListP, null);
		memberTapPane.setEnabledAt(1, false);
		memberListP.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"xxx", "yyy", "aaa", "bbb", "ccc"}));
		comboBox.setBounds(40, 59, 83, 21);
		memberListP.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(137, 59, 296, 176);
		memberListP.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"\uC544\uC774\uB514", "\uC774\uB984", "\uB098\uC774", "\uC8FC\uC18C", "\uACB0\uD63C\uC5EC\uBD80"
			}
		));
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(40, 90, 83, 145);
		memberListP.add(scrollPane_1);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"xxx", "bbb", "ccc", "yyy", "zzz"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane_1.setViewportView(list);

	}
}
