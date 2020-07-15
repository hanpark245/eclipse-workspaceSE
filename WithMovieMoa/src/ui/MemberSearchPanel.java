package ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import member.MemberService;
import member.MemberVo;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.GridLayout;

public class MemberSearchPanel extends JPanel {
	MemberService memberService;

	private JTextField nameSearchTF;
	private JTextField addressSearchTF;
	private JTextField phoneNumberSearchTF;
	private JButton cancelB;

	private MemberManegementPanel mmPanel;
	private JPanel buttonP;
	private JPanel panel;
	private JButton nameSearchB;
	private JButton addressSearchB;
	private JButton phoneNumberSearchB;
	private JScrollPane scrollPane;
	private JTable table;
	DefaultTableModel tableModel;
	private JPanel searchP;

	/**
	 * Create the panel.
	 * 
	 * @throws Exception
	 */
	public MemberSearchPanel() {
		try {
			memberService = new MemberService();
		} catch (Exception e) {
			e.printStackTrace();
		}
		setLayout(new BorderLayout(0, 0));

		JLabel title = new JLabel("\uD68C\uC6D0\uAC80\uC0C9");
		title.setFont(new Font("나눔고딕코딩", Font.PLAIN, 30));
		add(title, BorderLayout.NORTH);

		buttonP = new JPanel();
		add(buttonP, BorderLayout.SOUTH);
		buttonP.setLayout(new GridLayout(0, 3, 0, 0));

		JButton memberListB = new JButton("\uD68C\uC6D0\uB9AC\uC2A4\uD2B8");
		buttonP.add(memberListB);
		memberListB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetForm();
				mmPanel.changePanel("name_131823342538210");
			}
		});

		JButton resetB = new JButton("\uB2E4\uC2DC\uAC80\uC0C9");
		buttonP.add(resetB);
		resetB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetForm();
			}
		});

		cancelB = new JButton("\uCDE8\uC18C");
		buttonP.add(cancelB);

		panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		scrollPane.setViewportView(table);

		searchP = new JPanel();
		panel.add(searchP, BorderLayout.NORTH);
		searchP.setLayout(new GridLayout(0, 3, 0, 0));

		JLabel nameSearchL = new JLabel("\uC774\uB984\uC73C\uB85C \uAC80\uC0C9");
		searchP.add(nameSearchL);
		
				JLabel addressSearchL = new JLabel("\uC8FC\uC18C\uB85C \uAC80\uC0C9");
				searchP.add(addressSearchL);

		JLabel phoneNumberSearchL = new JLabel("\uC804\uD654\uBC88\uD638\uB85C \uAC80\uC0C9");
		searchP.add(phoneNumberSearchL);

		nameSearchTF = new JTextField();
		searchP.add(nameSearchTF);
		nameSearchTF.setColumns(10);

		addressSearchTF = new JTextField();
		searchP.add(addressSearchTF);
		addressSearchTF.setColumns(10);

		phoneNumberSearchTF = new JTextField();
		searchP.add(phoneNumberSearchTF);
		phoneNumberSearchTF.setColumns(10);

		nameSearchB = new JButton("\uAC80\uC0C9");
		searchP.add(nameSearchB);

		addressSearchB = new JButton("\uAC80\uC0C9");
		searchP.add(addressSearchB);

		phoneNumberSearchB = new JButton("\uAC80\uC0C9");
		searchP.add(phoneNumberSearchB);
		phoneNumberSearchB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String phoneNumber = phoneNumberSearchTF.getText();
				if (phoneNumber.trim().equals("")) {
				JOptionPane.showMessageDialog(null, "전화번호를 입력하세요", "Error", JOptionPane.WARNING_MESSAGE);
				phoneNumberSearchTF.requestFocus();	
				return;
				}
				try {
					ArrayList<MemberVo> memberList = memberService.findMemberByAll();
					for (int i = 0; i < memberList.size(); i++) {
						if (memberList.get(i).getPhoneNumber().equals(phoneNumber)) {
							try {
								memberPhoneNumberJTable(phoneNumber);
							} catch (Exception e2) {
								JOptionPane.showMessageDialog(null, "에러발생", "에러", JOptionPane.ERROR_MESSAGE);
							}
						} 
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}

			}

			public void memberPhoneNumberJTable(String phoneNumber) throws Exception {
				Vector columnNames = new Vector();
				columnNames.add("아이디");
				columnNames.add("이름");
				columnNames.add("나이");
				columnNames.add("주소");
				columnNames.add("전화번호");
				columnNames.add("이메일");
				columnNames.add("마케팅 수신 동의");

				Vector data = new Vector();
				MemberVo findMember1 = memberService.findMemberByPhoneNo(phoneNumber);
				Vector rowVector = new Vector();
				rowVector.add(findMember1.getId());
				rowVector.add(findMember1.getName());
				rowVector.add(findMember1.getAge());
				rowVector.add(findMember1.getAddress());
				rowVector.add(findMember1.getPhoneNumber());
				rowVector.add(findMember1.getEmail());
				rowVector.add(findMember1.isAdAgree());
				data.add(rowVector);

				tableModel = new DefaultTableModel(data, columnNames);
				table.setModel(tableModel);

			}

		});
		addressSearchB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String address = addressSearchTF.getText();
				if (address.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "주소를 입력하세요", "Error", JOptionPane.WARNING_MESSAGE);
					addressSearchTF.requestFocus();
					return;
				}
				try {
					ArrayList<MemberVo> memberList = memberService.findMemberByAll();
					for (int i = 0; i < memberList.size(); i++) {
						if (memberList.get(i).getAddress().equals(address)) {
							try {
								memberAddressJTable(address);
							} catch (Exception e2) {
								JOptionPane.showMessageDialog(null, "에러발생", "에러", JOptionPane.ERROR_MESSAGE);
							}
						}
					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

			public void memberAddressJTable(String address) throws Exception {
				Vector columnNames = new Vector();
				columnNames.add("아이디");
				columnNames.add("이름");
				columnNames.add("나이");
				columnNames.add("주소");
				columnNames.add("전화번호");
				columnNames.add("이메일");
				columnNames.add("마케팅 수신 동의");

				Vector data = new Vector();
				MemberVo findMember1 = memberService.findMemberByAddress(address);
				Vector rowVector = new Vector();
				rowVector.add(findMember1.getId());
				rowVector.add(findMember1.getName());
				rowVector.add(findMember1.getAge());
				rowVector.add(findMember1.getAddress());
				rowVector.add(findMember1.getPhoneNumber());
				rowVector.add(findMember1.getEmail());
				rowVector.add(findMember1.isAdAgree());
				data.add(rowVector);

				tableModel = new DefaultTableModel(data, columnNames);
				table.setModel(tableModel);

			}

		});
		nameSearchB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = nameSearchTF.getText();
				if (name.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "이름을 입력하세요", "Error", JOptionPane.WARNING_MESSAGE);
					nameSearchTF.requestFocus();
					return;
				}
				try {
					ArrayList<MemberVo> memberList = memberService.findMemberByAll();
					for (int i = 0; i < memberList.size(); i++) {
						if (memberList.get(i).getName().equals(name)) {
							try {
								memberNameJTable(name);
							} catch (Exception e2) {
								JOptionPane.showMessageDialog(null, "에러발생", "에러", JOptionPane.ERROR_MESSAGE);
							}
						}
					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}

			public void memberNameJTable(String name) throws Exception {
				Vector columnNames = new Vector();
				columnNames.add("아이디");
				columnNames.add("이름");
				columnNames.add("나이");
				columnNames.add("주소");
				columnNames.add("전화번호");
				columnNames.add("이메일");
				columnNames.add("마케팅 수신 동의");

				Vector data = new Vector();
				MemberVo findMember1 = memberService.findMemberByName(name);
				Vector rowVector = new Vector();
				rowVector.add(findMember1.getId());
				rowVector.add(findMember1.getName());
				rowVector.add(findMember1.getAge());
				rowVector.add(findMember1.getAddress());
				rowVector.add(findMember1.getPhoneNumber());
				rowVector.add(findMember1.getEmail());
				rowVector.add(findMember1.isAdAgree());
				data.add(rowVector);

				tableModel = new DefaultTableModel(data, columnNames);
				table.setModel(tableModel);

			}

		});

		cancelB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableModel = new DefaultTableModel();
				resetForm();
				mmPanel.changePanel("MemberManager");
			}

		});

	}

	private void resetForm() {
		tableModel = new DefaultTableModel();
		table.setModel(tableModel);
		nameSearchTF.setText("");
		addressSearchTF.setText("");
		phoneNumberSearchTF.setText("");
	}

	public void setMemberMPanel(MemberManegementPanel memberManegementPanel) {
		this.mmPanel = memberManegementPanel;

	}
}
