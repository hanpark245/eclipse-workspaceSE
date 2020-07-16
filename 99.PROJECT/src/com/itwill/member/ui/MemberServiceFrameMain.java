package com.itwill.member.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MemberServiceFrameMain extends JFrame {

	private JPanel contentPane;
	MemberMainPanel memberMainPanel;
	String loginId="";
	private JMenuItem loginMI;
	private JMenuItem logoutMI;
	private JMenuItem gaipMI;
	/**********************************************/
	public static void showSplashWindow() {
		JWindow window = new JWindow();
		window.getContentPane().add(
		    new JLabel("", new ImageIcon("splash.gif"), SwingConstants.CENTER));
		window.setBounds(300, 150, 500, 500);
		window.setVisible(true);
		
		try {
		    Thread.sleep(3000);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		window.setVisible(false);
	}
	/**********************************************/
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//EventQueue.invokeLater(new Runnable() {
		//	public void run() {
		//		try {
					MemberServiceFrameMain frame = new MemberServiceFrameMain();
					showSplashWindow();
					frame.setVisible(true);
		//		} catch (Exception e) {
		//			e.printStackTrace();
		//		}
		//	}
		//});
	}

	/**
	 * Create the frame.
	 */
	public MemberServiceFrameMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 520);
		
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
		gaipMI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JoinDialog joinDialog=new JoinDialog();
				joinDialog.setVisible(true);
				
			}
		});
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
		logoutUI();
		//loginProcess();
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
		memberMainPanel.memberTapPane.setSelectedIndex(1);
		memberMainPanel.memberTapPane.setEnabledAt(1, true);
		
		loginMI.setEnabled(false);
		logoutMI.setEnabled(true);
		gaipMI.setEnabled(false);
		
		
	}
	protected void logoutUI() {
		this.loginId="";
		setTitle(loginId);
		memberMainPanel.memberTapPane.setSelectedIndex(0);
		memberMainPanel.memberTapPane.setEnabledAt(0, false);
		memberMainPanel.memberTapPane.setEnabledAt(1, false);
		
		loginMI.setEnabled(true);
		logoutMI.setEnabled(false);
		gaipMI.setEnabled(true);
		
	
	}
	

}
