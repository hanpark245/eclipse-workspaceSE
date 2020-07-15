package ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import member.MemberService;
import member.MemberVo;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class MemberListPanel extends JPanel {
	MemberService memberService;
	
	private JTable memberTB;
	DefaultTableModel tableModel;
	
	private MemberManegementPanel mmPanel;
	private JButton searchB;
	private JButton changeB;
	private JButton deleteB;
	private JButton mainB;
	private JButton listB;
	ArrayList<MemberVo> memberList;
	private JPanel buttonP;
	private JPanel titleP;

	/**
	 * Create the panel.
	 */
	public MemberListPanel() {
		try {
			memberService = new MemberService();
		} catch (Exception e) {
			e.printStackTrace();
		}
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		memberTB = new JTable();
		memberTB.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		scrollPane.setViewportView(memberTB);
		
		buttonP = new JPanel();
		add(buttonP, BorderLayout.SOUTH);
		buttonP.setLayout(new GridLayout(0, 4, 0, 0));
		
		searchB = new JButton("\uD68C\uC6D0\uAC80\uC0C9");
		buttonP.add(searchB);
		
		changeB = new JButton("\uD68C\uC6D0\uC218\uC815");
		buttonP.add(changeB);
		changeB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mmPanel.changePanel("name_132918561867527");
			}
		});
		
		deleteB = new JButton("\uD68C\uC6D0\uC0AD\uC81C");
		buttonP.add(deleteB);
		deleteB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mmPanel.changePanel("name_132927159807579");
			}
		});
		
		mainB = new JButton("\uCDE8\uC18C");
		buttonP.add(mainB);
		
		titleP = new JPanel();
		add(titleP, BorderLayout.NORTH);
		titleP.setLayout(new BorderLayout(0, 0));
		
		JLabel title = new JLabel("\uD68C\uC6D0\uB9AC\uC2A4\uD2B8");
		titleP.add(title, BorderLayout.WEST);
		title.setFont(new Font("나눔고딕코딩", Font.PLAIN, 30));
		
		listB = new JButton("\uC0C8\uB85C\uACE0\uCE68");
		titleP.add(listB, BorderLayout.EAST);
		listB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					memberJTable();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "에러발생", "에러", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		mainB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mmPanel.changePanel("MemberManager");
			}
		});
		searchB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mmPanel.changePanel("name_131783274103720");
			}
		});

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
		ArrayList<MemberVo> memberList=memberService.findMemberByAll();
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
		memberTB.setModel(tableModel);
		
	}
	
	public void setMemberMPanel(MemberManegementPanel memberManegementPanel) {
		this.mmPanel=memberManegementPanel;
		
	}

}
