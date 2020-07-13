package com.itwill.account;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AccountMainFrame extends JFrame {
	/******Sevice객체선언************/
	private AccountService accountService;
	
	
	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JTextField noTF;
	private JTextField ownerTF;
	private JTextField balanceTF;
	private JTextField iyulTF;
	private JTextArea accountListTA;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountMainFrame frame = new AccountMainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AccountMainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 411, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel addP = new JPanel();
		addP.setBackground(Color.PINK);
		tabbedPane.addTab("계좌추가", null, addP, null);
		addP.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("계좌번호");
		lblNewLabel.setBounds(67, 82, 57, 15);
		addP.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("계좌이름");
		lblNewLabel_1.setBounds(67, 117, 57, 15);
		addP.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("계좌잔고");
		lblNewLabel_2.setBounds(67, 155, 57, 15);
		addP.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("계좌이율");
		lblNewLabel_3.setBounds(67, 186, 57, 15);
		addP.add(lblNewLabel_3);
		
		noTF = new JTextField();
		noTF.setBounds(163, 76, 116, 21);
		addP.add(noTF);
		noTF.setColumns(10);
		
		ownerTF = new JTextField();
		ownerTF.setBounds(163, 111, 116, 21);
		addP.add(ownerTF);
		ownerTF.setColumns(10);
		
		balanceTF = new JTextField();
		balanceTF.setBounds(163, 149, 116, 21);
		addP.add(balanceTF);
		balanceTF.setColumns(10);
		
		iyulTF = new JTextField();
		iyulTF.setBounds(163, 180, 116, 21);
		addP.add(iyulTF);
		iyulTF.setColumns(10);
		
		JButton addB = new JButton("추가");
		addB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/******************************************/
				String noStr=noTF.getText();
				String ownerStr=ownerTF.getText();
				String balanceStr=balanceTF.getText();
				String iyulStr=iyulTF.getText();
				if(noStr.equals("")|| 
				   ownerStr.equals("")||
				   balanceStr.equals("")||
				   iyulStr.equals("")) {
					JOptionPane.showMessageDialog(null, "모든필드를 입력하세요!!");
					noTF.requestFocus();
					return;
				}
				
				int no = new Integer(noStr);
				int balance=new Integer(balanceStr);
				double iyul=new Double(iyulStr);
				
				Account newAccount=new Account(no, ownerStr, balance, iyul);
				boolean isAdd=accountService.addAccount(newAccount);
				
				if(isAdd) {
					JOptionPane.showMessageDialog(null, "계좌추가성공");
					noTF.setText("");
					ownerTF.setText("");
					balanceTF.setText("");
					iyulTF.setText("");
					noTF.requestFocus();
				}else {
					JOptionPane.showMessageDialog(null, no+" 는 이미존재하는 번호입니다" );
					noTF.requestFocus();
				}
				
				/***********************************/
			}
		});
		addB.setBounds(67, 241, 97, 23);
		addP.add(addB);
		
		JButton cancleB = new JButton("취소");
		cancleB.setBounds(182, 241, 97, 23);
		addP.add(cancleB);
		
		JPanel listP = new JPanel();
		listP.setBackground(Color.ORANGE);
		tabbedPane.addTab("계좌리스트", null, listP, null);
		listP.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 23, 356, 239);
		listP.add(scrollPane);
		
		accountListTA = new JTextArea();
		scrollPane.setViewportView(accountListTA);
		
		JButton listB = new JButton("계좌리스트");
		listB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*********************************/
				 ArrayList<Account> accountList=
						 accountService.getAccountList();
				 String accountListStr="";
				 for (Account account : accountList) {
					accountListStr+=account.toString()+"\n";
				}
				//System.out.println(accountListStr);
				accountListTA.setText(accountListStr);
				/********************************/ 
			}
		});
		listB.setBounds(129, 279, 125, 23);
		listP.add(listB);
		
		
		
		/******Sevice객체생성************/
		accountService=new AccountService();
		
		
		
	}
	
	
}
