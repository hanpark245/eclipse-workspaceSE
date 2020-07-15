package com.itwill.member.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MemberServiceFrameMain extends JFrame {

	private JPanel contentPane;
	MemberMainPanel memberMainPanel;
	String loginId="";
	private JMenuItem loginMI;
	private JMenuItem logoutMI;
	private JMenuItem gaipMI;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberServiceFrameMain frame = new MemberServiceFrameMain();
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
	public MemberServiceFrameMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 415);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("회원");
		menuBar.add(mnNewMenu);
		
		loginMI = new JMenuItem("로그인");
		loginMI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginProcess();
			}

			
		});
		mnNewMenu.add(loginMI);
		
		logoutMI = new JMenuItem("로그아웃");
		logoutMI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logoutUI();
			}
		});
		mnNewMenu.add(logoutMI);
		
		gaipMI = new JMenuItem("가입");
		mnNewMenu.add(gaipMI);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("종료");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * JVM terminate
				 */
				System.exit(0);

			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		memberMainPanel = new MemberMainPanel();
		contentPane.add(memberMainPanel, BorderLayout.CENTER);
		
		
	}
	
	

	protected void loginProcess() {
		/*
		 * 로그인다이알로그 띄우기
		 */
		 LoginDialog loginDialog=new LoginDialog();
		 loginDialog.setFrame(this);
		 
		 loginDialog.setModal(true);
		 loginDialog.setVisible(true);
	}
	
	public void loginUI(String id) {
		this.loginId=id;
		setTitle(this.loginId+" 님로그인");
		memberMainPanel.memberTapPane.setEnabledAt(0, true);
		loginMI.setEnabled(false);
		logoutMI.setEnabled(true);
		gaipMI.setEnabled(false);
	}
	protected void logoutUI() {
		this.loginId="";
		setTitle(loginId);
		memberMainPanel.memberTapPane.setEnabledAt(0, false);
		
		loginMI.setEnabled(true);
		logoutMI.setEnabled(false);
		gaipMI.setEnabled(true);
	}

}
