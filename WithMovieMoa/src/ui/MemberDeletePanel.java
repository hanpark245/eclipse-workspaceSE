package ui;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import member.MemberService;
import member.MemberVo;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MemberDeletePanel extends JPanel {
	private JTable table;
	DefaultTableModel tableModel;
	private JTextField idTF;
	private JTextField phoneNumberTF;

	private MemberManegementPanel mmPanel;
	private JButton listB;
	private JButton cancelB;
	private JButton deleteB;


	MemberService memberService;
	private JPanel titleP;

	/**
	 * Create the panel.
	 */
	public MemberDeletePanel() {
		try {
			memberService = new MemberService();
		} catch (Exception e) {
			e.printStackTrace();
		}
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(0, 3, 0, 0));

		JLabel idL = new JLabel("\uC544\uC774\uB514");
		panel.add(idL);

		idTF = new JTextField();
		panel.add(idTF);
		idTF.setColumns(10);
		idTF.setEditable(false);

		deleteB = new JButton("\uC0AD\uC81C");
		deleteB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				delete();
			}
		});
		panel.add(deleteB);

		cancelB = new JButton("\uCDE8\uC18C");
		cancelB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetForm();
				mmPanel.changePanel("MemberManager");
			}
		});

		JLabel phoneNumberL = new JLabel("\uC804\uD654\uBC88\uD638");
		panel.add(phoneNumberL);

		phoneNumberTF = new JTextField();
		panel.add(phoneNumberTF);
		phoneNumberTF.setEditable(false);
		phoneNumberTF.setColumns(10);
		panel.add(cancelB);

		titleP = new JPanel();
		add(titleP, BorderLayout.NORTH);
		titleP.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel title = new JLabel("\uD68C\uC6D0\uC0AD\uC81C");
		titleP.add(title);
		title.setFont(new Font("나눔고딕코딩", Font.PLAIN, 24));

		listB = new JButton("\uC0C8\uB85C\uACE0\uCE68");
		titleP.add(listB);
		listB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					memberJTable();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "에러발생", "에러", JOptionPane.ERROR_MESSAGE);
				}
			}

		});

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
				int selectedRow=table.getSelectedRow();
				ArrayList<MemberVo> memberList = memberService.findMemberByAll();
				MemberVo member=(MemberVo)memberList.get(selectedRow);
				 idTF.setText(member.getId());
				 phoneNumberTF.setText(member.getPhoneNumber());
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		scrollPane.setViewportView(table);

	}

	public void memberJTable() throws Exception {
		Vector columnNames = new Vector();
		columnNames.add("아이디");
		columnNames.add("이름");
		columnNames.add("나이");
		columnNames.add("주소");
		columnNames.add("전화번호");
		columnNames.add("이메일");
		columnNames.add("마케팅 수신 동의");

		Vector data = new Vector();
		ArrayList<MemberVo> memberList = memberService.findMemberByAll();
		for (MemberVo memberVo : memberList) {
			Vector rowVector = new Vector();
			rowVector.add(memberVo.getId());
			rowVector.add(memberVo.getName());
			rowVector.add(memberVo.getAge());
			rowVector.add(memberVo.getAddress());
			rowVector.add(memberVo.getPhoneNumber());
			rowVector.add(memberVo.getEmail());
			rowVector.add(memberVo.isAdAgree());
			data.add(rowVector);

		}
		tableModel = new DefaultTableModel(data, columnNames);
		table.setModel(tableModel);

	}

	public void delete() {
		String id = idTF.getText();
		String phoneNumber = phoneNumberTF.getText();
		if(id.equals("") && phoneNumber.equals("")) {
			JOptionPane.showMessageDialog(null, "삭제할 아이디를 선택해주세요.", "", JOptionPane.INFORMATION_MESSAGE);
		}
		try {
			memberService.memberDeRegister(id, phoneNumber);
			resetForm();
			memberJTable();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void resetForm() {
		idTF.setText("");
		phoneNumberTF.setText("");
		
	}

	public void setMemberMPanel(MemberManegementPanel memberManegementPanel) {
		this.mmPanel = memberManegementPanel;

	}

}
