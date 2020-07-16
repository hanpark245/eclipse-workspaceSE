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
import javax.swing.DefaultListModel;
import javax.swing.AbstractListModel;
import javax.swing.table.DefaultTableModel;

import com.itwill.member.Member;
import com.itwill.member.MemberService;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.ListSelectionModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class MemberMainPanel extends JPanel {
	/*******************/
	MemberService memberService;
	/*******************/
	
	
	JTabbedPane memberTapPane;
	private JTable memberTBL;
	private JList memberListL;
	private JComboBox memberCB;
	private JTextField idTF;
	private JTextField nameTF;
	private JTextField addressTF;
	private JTextField ageTF;
	private JCheckBox marriedCHK;
	private JButton deleteBtn;
	private JButton updateBtn;

	/**
	 * Create the panel.
	 */
	public MemberMainPanel() {
		setLayout(new BorderLayout(0, 0));
		
		memberTapPane = new JTabbedPane(JTabbedPane.TOP);
		
		add(memberTapPane, BorderLayout.CENTER);
		
		JPanel logoP = new JPanel();
		memberTapPane.addTab("로고", null, logoP, null);
		logoP.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\JAVA_PYTHON\\99.image\\album.jpg"));
		logoP.add(lblNewLabel, BorderLayout.CENTER);
		
		JPanel memberListP = new JPanel();
		memberListP.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				try {
					getMemberList();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		memberListP.setBackground(Color.ORANGE);
		memberTapPane.addTab("회원리스트", null, memberListP, null);
		memberListP.setLayout(null);
		
		memberCB = new JComboBox();
		memberCB.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					String selectId = (String)e.getItem();
					try {
						displayMember(selectId);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		//memberCB.setModel(new DefaultComboBoxModel(new String[] {"xxx", "yyy", "aaa", "bbb", "ccc"}));
		memberCB.setBounds(12, 10, 94, 21);
		memberListP.add(memberCB);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 41, 94, 164);
		memberListP.add(scrollPane);
		
		memberListL = new JList();
		
		memberListL.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(e.getValueIsAdjusting()) {
					String selectId=(String)memberListL.getSelectedValue();
					//System.out.println(selectId);
					try {
						displayMember(selectId);
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		/*
		memberListL.setModel(new AbstractListModel() {
			String[] values = new String[] {"xxx", "bbb", "ccc", "yyy", "zzz"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		*/
		scrollPane.setViewportView(memberListL);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(118, 12, 303, 143);
		memberListP.add(scrollPane_1);
		
		memberTBL = new JTable();
		memberTBL.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		memberTBL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectRow = memberTBL.getSelectedRow();
				if(selectRow==-1) {
					return;
				}
				String selectedId=
						(String)memberTBL.getModel().getValueAt(selectRow, 0);
				try {
					displayMember(selectedId);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		/*
		memberTBL.setModel(new DefaultTableModel(
			new Object[][] {
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
		*/
		scrollPane_1.setViewportView(memberTBL);
		
		JButton btnNewButton = new JButton("멤버리스트");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					getMemberList();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(12, 215, 104, 23);
		memberListP.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("아이디");
		lblNewLabel_1.setBounds(178, 187, 57, 15);
		memberListP.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("이름");
		lblNewLabel_2.setBounds(178, 219, 57, 15);
		memberListP.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("주소");
		lblNewLabel_3.setBounds(178, 254, 57, 15);
		memberListP.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("나이");
		lblNewLabel_4.setBounds(178, 289, 57, 15);
		memberListP.add(lblNewLabel_4);
		
		idTF = new JTextField();
		idTF.setEditable(false);
		idTF.setEnabled(false);
		idTF.setBounds(246, 184, 116, 21);
		memberListP.add(idTF);
		idTF.setColumns(10);
		
		nameTF = new JTextField();
		nameTF.setEditable(false);
		nameTF.setBounds(246, 216, 116, 21);
		memberListP.add(nameTF);
		nameTF.setColumns(10);
		
		addressTF = new JTextField();
		addressTF.setEditable(false);
		addressTF.setBounds(246, 254, 116, 21);
		memberListP.add(addressTF);
		addressTF.setColumns(10);
		
		ageTF = new JTextField();
		ageTF.setEditable(false);
		ageTF.setBounds(246, 286, 116, 21);
		memberListP.add(ageTF);
		ageTF.setColumns(10);
		
		marriedCHK = new JCheckBox("결혼여부");
		marriedCHK.setEnabled(false);
		marriedCHK.setHorizontalAlignment(SwingConstants.LEFT);
		marriedCHK.setBounds(246, 313, 116, 23);
		memberListP.add(marriedCHK);
		
		deleteBtn = new JButton("삭제");
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					deleteMember();
					getMemberList();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		deleteBtn.setEnabled(false);
		deleteBtn.setBounds(275, 342, 87, 23);
		memberListP.add(deleteBtn);
		
		updateBtn = new JButton("수정");
		updateBtn.setEnabled(false);
		updateBtn.setBounds(178, 342, 81, 23);
		memberListP.add(updateBtn);
		
		try {
			memberService=new MemberService();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	protected void deleteMember() {
		try {
			String deleteId = idTF.getText();
			if(deleteId==null|| deleteId.equals("")) return;
			memberService.memberUnRegister(deleteId);
			
			
			/*************************************/
			idTF.setText("");
			nameTF.setText("");
			addressTF.setText("");
			ageTF.setText("");
			marriedCHK.setSelected(false);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			/************************************/
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void displayMember(String selectId) throws Exception{
		Member findMember=
				memberService.findById(selectId);
		idTF.setText(findMember.getId());
		nameTF.setText(findMember.getName());
		addressTF.setText(findMember.getAddress());
		ageTF.setText(findMember.getAge()+"");
		if(findMember.isMarried()) {
			marriedCHK.setSelected(true);
		}else {
			marriedCHK.setSelected(false);
		}
		updateBtn.setEnabled(true);
		deleteBtn.setEnabled(true);
		
	}

	protected void getMemberList() throws Exception {
		ArrayList<Member> memberList=memberService.memberList();
		/*
		 * JList Model
		 */
		DefaultListModel listModel=new DefaultListModel();
		/*
		 * JComboBox Model
		 */
		DefaultComboBoxModel comboBoxModel=new DefaultComboBoxModel();
		/*
		 * JTable Model
		 */
		DefaultTableModel tableModel=new DefaultTableModel();
		Vector columnVector=new Vector();
		columnVector.add("아이디");
		columnVector.add("이름");
		columnVector.add("주소");
		columnVector.add("나이");
		columnVector.add("결혼여부");
		tableModel.setColumnIdentifiers(columnVector);
		
		for (Member member : memberList) {
			listModel.addElement(member.getId());
			comboBoxModel.addElement(member.getId());
			Vector rowVector=new Vector();
			rowVector.add(member.getId());
			rowVector.add(member.getName());
			rowVector.add(member.getAddress());
			rowVector.add(member.getAge());
			rowVector.add(member.isMarried());
			tableModel.addRow(rowVector);
		}
		
		memberListL.setModel(listModel);
		memberCB.setModel(comboBoxModel);
		memberTBL.setModel(tableModel);
		
		
	}
}





