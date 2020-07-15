package ui;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import member.MemberService;
import member.MemberVo;
import javax.swing.JToggleButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.FlowLayout;

public class MemberUpdatePanel extends JPanel {
	private JTextField idTF;
	private JTextField nameTF;
	private JTextField passTF;
	private JTextField ageTF;
	private JTextField addressTF;
	private JTextField phoneNoTF;
	private JTextField emailTF;
	private JTable table;
	DefaultTableModel tableModel;
	
	private MemberManegementPanel mmPanel;
	private MemberService memberService;
	private JButton listB;
	private JButton cancelB;
	private JButton updateB;
	private ArrayList<MemberVo> memberList;
	/**
	 * Create the panel.
	 */
	public MemberUpdatePanel() {
		try {
			memberService = new MemberService();
		} catch (Exception e) {
			e.printStackTrace();
		}
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int selectedRow=table.getSelectedRow();
				MemberVo member=(MemberVo)memberList.get(selectedRow);
				 idTF.setText(member.getId());
				 passTF.setText(member.getPassword());
				 nameTF.setText(member.getName());
				 String ageStr = String.valueOf(member.getAge());
				 ageTF.setText(ageStr);
				 addressTF.setText(member.getAddress());
				 phoneNoTF.setText(member.getPhoneNumber());
				 emailTF.setText(member.getEmail());
		
			}
		});
		table.setBounds(0, 0, 1, 1);
		scrollPane.setViewportView(table);
		
		JPanel updateP = new JPanel();
		panel.add(updateP);
		updateP.setLayout(new GridLayout(8, 2, 0, 0));
		
		
		JLabel idLabel = new JLabel("\uC544\uC774\uB514");
		updateP.add(idLabel);
		
		idTF = new JTextField();
		updateP.add(idTF);
		idTF.setEnabled(false);
		idTF.setColumns(10);
		
		JLabel nameLabel = new JLabel("\uC774\uB984");
		updateP.add(nameLabel);
		
		nameTF = new JTextField();
		updateP.add(nameTF);
		nameTF.setColumns(10);
		
		JLabel passLabel = new JLabel("\uBE44\uBC00\uBC88\uD638");
		updateP.add(passLabel);
		
		passTF = new JTextField();
		updateP.add(passTF);
		passTF.setColumns(10);
		
		JLabel ageLabel = new JLabel("\uB098\uC774");
		updateP.add(ageLabel);
		
		ageTF = new JTextField();
		updateP.add(ageTF);
		ageTF.setColumns(10);
		
		JLabel addressLabel = new JLabel("\uC8FC\uC18C");
		updateP.add(addressLabel);
		
		addressTF = new JTextField();
		updateP.add(addressTF);
		addressTF.setColumns(10);
		
		JLabel phoneNoLabel = new JLabel("\uC804\uD654\uBC88\uD638");
		updateP.add(phoneNoLabel);
		
		phoneNoTF = new JTextField();
		updateP.add(phoneNoTF);
		phoneNoTF.setColumns(10);
		
		JLabel emailLabel = new JLabel("\uC774\uBA54\uC77C");
		updateP.add(emailLabel);
		
		emailTF = new JTextField();
		updateP.add(emailTF);
		emailTF.setColumns(10);
		
		JPanel titleP = new JPanel();
		add(titleP, BorderLayout.NORTH);
		titleP.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel title = new JLabel("\uD68C\uC6D0\uC218\uC815");
		titleP.add(title);
		title.setFont(new Font("나눔고딕코딩", Font.PLAIN, 24));
		
		JPanel buttonP = new JPanel();
		add(buttonP, BorderLayout.SOUTH);
		buttonP.setLayout(new GridLayout(0, 3, 0, 0));
		
		updateB = new JButton("\uC218\uC815");
		buttonP.add(updateB);
		
		listB = new JButton("\uC0C8\uB85C\uACE0\uCE68");
		buttonP.add(listB);
		listB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					memberJTable();
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "에러발생", "에러", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		cancelB = new JButton("\uCDE8\uC18C");
		buttonP.add(cancelB);
		cancelB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mmPanel.changePanel("MemberManager");
			}
		});
		updateB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
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
		
		Vector data = new Vector();
		this.memberList=memberService.findMemberByAll();
		for (MemberVo memberVo : memberList) {
			Vector rowVector = new Vector();
			rowVector.add(memberVo.getId());
			rowVector.add(memberVo.getName());
			rowVector.add(memberVo.getAge());
			rowVector.add(memberVo.getAddress());
			rowVector.add(memberVo.getPhoneNumber());
			rowVector.add(memberVo.getEmail());
			data.add(rowVector);
			
		}
		tableModel = new DefaultTableModel(data, columnNames);
		table.setModel(tableModel);
		
	}
	public void update() {
		String id = idTF.getText();
		String name = nameTF.getText();
		String password = passTF.getText();
		String age = ageTF.getText();
		String address = addressTF.getText();
		String phoneNumber = phoneNoTF.getText();
		String email = emailTF.getText();
		JOptionPane.showMessageDialog(null, "수정 완료", "", JOptionPane.INFORMATION_MESSAGE);
		
		try {
			MemberVo updateMember=new MemberVo(id, password, name, Integer.parseInt(age), address, phoneNumber, email);
			memberService.memberUpdate(updateMember);
			memberJTable();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}	
	public void setMemberMPanel(MemberManegementPanel memberManegementPanel) {
		this.mmPanel=memberManegementPanel;
		
	}
}
