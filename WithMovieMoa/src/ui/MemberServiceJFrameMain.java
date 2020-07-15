package ui;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import admin.AdminVo;
import member.MemberVo;
import movie.MovieService;
import theater.TheaterService;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MemberServiceJFrameMain extends JFrame {

	MovieService movieService;
	TheaterService theaterService;
	MemberVo loginMember;
	public MemberVo getLoginMember() {
		return loginMember;
	}


	AdminVo loginAdmin;
	private JPanel contentPane;
	private JMenuItem loginMenuItem;
	private JMenuItem logoutMenuItem;
	private JMenuItem gaipMenuItem;
	private JMenuItem exitMenuItem;
	private JPanel parentPanel;
	private CardLayout cardLayout = new CardLayout(0, 0);
	private JTabbedPane tabbedPane;
	private MemberGaipPanel memberGaipPanel;
	private AdminGaipPanel adminGaipPanel;
	private AdminManegementPanel adminManegementPanel;
	private MemberPaymentDialog memberPaymentDialog;
	private String selectedMovieName;
	private String selectedCity;
	private String selectedTheater;
	private String selectedDate;
	private int selectedScreenNum;
	private int selectedScreenTime = -1;
	private boolean[] selectedReserve;

	public JButton getReserveButton() {
		return ReserveButton;
	}

	public JButton getPayButton() {
		return payButton;
	}

	private int selectedSeatTotNum;
	private JButton ReserveButton;
	private JButton nextButton;
	private JButton payButton;
	
	public boolean[] getSelectedReserve() {
		return selectedReserve;
	}

	public int getSelectedSeatTotNum() {
		return selectedSeatTotNum;
	}

	public void setSelectedSeatTotNum(int selectedSeatTotNum) {
		this.selectedSeatTotNum = selectedSeatTotNum;
	}

	public void setSelectedReserve(boolean[] selectedReserve) {
		this.selectedReserve = selectedReserve;
	}

	MemberScreenNumTimePanel memberScreenNumTimePanel;
	private MemberSelectSeatsPanel memberSelectSeatsPanel;
	private JMenu reserveConfirmMenu;
	private JMenuItem reserveConfirmMenuItem;
	private MemberReserveConfirmPanel memberReserveConfirmPanel;
	
	public int getSelectedScreenTime() {
		return selectedScreenTime;
	}

	public void setSelectedScreenTime(int selectedScreenTime) {
		this.selectedScreenTime = selectedScreenTime;
	}

	public int getSelectedScreenNum() {
		return selectedScreenNum;
	}

	public void setSelectedScreenNum(int selectedScreenNum) {
		this.selectedScreenNum = selectedScreenNum;
	}

	public String getSelectedMovieName() {
		return selectedMovieName;
	}

	public void setSelectedMovieName(String selectedMovieName) {
		this.selectedMovieName = selectedMovieName;
	}

	public String getSelectedCity() {
		return selectedCity;
	}

	public void setSelectedCity(String selectedCity) {
		this.selectedCity = selectedCity;
	}

	public String getSelectedTheater() {
		return selectedTheater;
	}

	public void setSelectedTheater(String selectedTheater) {
		this.selectedTheater = selectedTheater;
	}

	public String getSelectedDate() {
		return selectedDate;
	}

	public void setSelectedDate(String selectedDate) {
		this.selectedDate = selectedDate;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberServiceJFrameMain frame = new MemberServiceJFrameMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public MemberServiceJFrameMain() throws Exception {
		movieService = new MovieService();
		theaterService = new TheaterService();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 800);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\uBA54\uB274");
		menuBar.add(menu);
		
		loginMenuItem = new JMenuItem("\uB85C\uADF8\uC778");
		loginMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * login
				 */
				MemberLoginDialog loginDialog=new MemberLoginDialog(MemberServiceJFrameMain.this);
				
				loginDialog.setModal(true);
				loginDialog.setVisible(true);
				
			}
		});
		menu.add(loginMenuItem);
		
		logoutMenuItem = new JMenuItem("\uB85C\uADF8\uC544\uC6C3");
		logoutMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logoutProcess();
			}
		});
		menu.add(logoutMenuItem);
		
		gaipMenuItem = new JMenuItem("\uD68C\uC6D0\uAC00\uC785");
		gaipMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.remove(ReserveButton);
				changePanel("memberGaip");
			}
		});
		menu.add(gaipMenuItem);
		
		JMenuItem adminGaipMenuItem = new JMenuItem("\uAD00\uB9AC\uC790\uD68C\uC6D0\uAC00\uC785");
		adminGaipMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.remove(ReserveButton);
				changePanel("adminGaip");
			}
		});
		menu.add(adminGaipMenuItem);
		
		JMenuItem adminloginMenuItem = new JMenuItem("\uAD00\uB9AC\uC790\uB85C\uADF8\uC778");
		adminloginMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminLoginDialog adminLoginDialog=new AdminLoginDialog(MemberServiceJFrameMain.this);
				adminLoginDialog.setModal(true);
				adminLoginDialog.setVisible(true);
			}
		});
		menu.add(adminloginMenuItem);
		
		exitMenuItem = new JMenuItem("\uC885\uB8CC");
		exitMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menu.add(exitMenuItem);
		
		reserveConfirmMenu = new JMenu("\uC608\uB9E4");
		menuBar.add(reserveConfirmMenu);
		
		reserveConfirmMenuItem = new JMenuItem("\uC608\uB9E4\uD655\uC778");
		reserveConfirmMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(loginMember==null) {
					JOptionPane.showMessageDialog(null, "로그인이 필요한 서비스입니다.", "", JOptionPane.INFORMATION_MESSAGE);
					MemberLoginDialog loginDialog=new MemberLoginDialog(MemberServiceJFrameMain.this);
					loginDialog.setModal(true);
					loginDialog.setVisible(true);
				}
				else {
					contentPane.remove(ReserveButton);
					cardLayout.show(parentPanel,"reserveConfirm");
				}
			}
		});
		reserveConfirmMenu.add(reserveConfirmMenuItem);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		parentPanel = new JPanel();
		contentPane.add(parentPanel, BorderLayout.CENTER);
		parentPanel.setLayout(cardLayout);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		parentPanel.add(tabbedPane, "main");
		
		MemberMovieFirstPanel memberMovieFirstPanel = new MemberMovieFirstPanel(this);
		tabbedPane.addTab("\uC601\uD654\uBA3C\uC800", null, memberMovieFirstPanel, null);
		tabbedPane.setBackgroundAt(0, new Color(135, 206, 235));
		
		MemberTheaterFirstPanel memberTheaterFirstPanel = new MemberTheaterFirstPanel(this);
		tabbedPane.addTab("\uADF9\uC7A5\uBA3C\uC800", null, memberTheaterFirstPanel, null);
		tabbedPane.setBackgroundAt(1, new Color(64, 224, 208));
		
		MemberDateFirstPanel memberDateFirstPanel = new MemberDateFirstPanel(this);
		tabbedPane.addTab("\uB0A0\uC9DC\uBA3C\uC800", null, memberDateFirstPanel, null);
		tabbedPane.setBackgroundAt(2, new Color(222, 184, 135));
		
		memberGaipPanel = new MemberGaipPanel(this);
		parentPanel.add(memberGaipPanel, "memberGaip");
		
		adminGaipPanel = new AdminGaipPanel(this);
		parentPanel.add(adminGaipPanel, "adminGaip");
		
		adminManegementPanel = new AdminManegementPanel(this);
		parentPanel.add(adminManegementPanel, "adminManagement");
		CardLayout cardLayout_parentPanel = (CardLayout)parentPanel.getLayout();
		cardLayout_parentPanel.first(parentPanel);
		
		memberReserveConfirmPanel = new MemberReserveConfirmPanel(this);
		parentPanel.add(memberReserveConfirmPanel, "reserveConfirm");
		
		
		ReserveButton = new JButton("예매하기");
		nextButton = new JButton("다음");
		payButton = new JButton("결제");
		contentPane.add(ReserveButton, BorderLayout.SOUTH);
		ReserveButton.setBackground(SystemColor.textHighlight);
		ReserveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
						if(loginMember==null) {
							JOptionPane.showMessageDialog(null, "로그인이 필요한 서비스입니다.", "", JOptionPane.INFORMATION_MESSAGE);
							MemberLoginDialog loginDialog=new MemberLoginDialog(MemberServiceJFrameMain.this);
							loginDialog.setModal(true);
							loginDialog.setVisible(true);
						}
						else if(MemberServiceJFrameMain.this.getSelectedMovieName()==null) {
							JOptionPane.showMessageDialog(null, "영화를 선택해주세요.", "", JOptionPane.INFORMATION_MESSAGE);
						}
						else if(MemberServiceJFrameMain.this.getSelectedTheater()==null) {
							JOptionPane.showMessageDialog(null, "극장을 선택해주세요.", "", JOptionPane.INFORMATION_MESSAGE);
						}
						else if(MemberServiceJFrameMain.this.getSelectedDate()==null) {
							JOptionPane.showMessageDialog(null, "날짜를 선택해주세요.", "", JOptionPane.INFORMATION_MESSAGE);
						}
						else {
						memberScreenNumTimePanel = new MemberScreenNumTimePanel(MemberServiceJFrameMain.this);
						parentPanel.add(memberScreenNumTimePanel, "screenNumTime");
						cardLayout.show(parentPanel, "screenNumTime");
						contentPane.remove(ReserveButton);
						contentPane.add(nextButton,BorderLayout.SOUTH);
						nextButton.setBackground(SystemColor.textHighlight);
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
			}
		});
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				try {
					if(MemberServiceJFrameMain.this.getSelectedScreenTime()==-1) {
						JOptionPane.showMessageDialog(null, "시간을 선택해주세요.", "", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
					memberSelectSeatsPanel = new MemberSelectSeatsPanel(MemberServiceJFrameMain.this);
					parentPanel.add(memberSelectSeatsPanel, "selectSeats");
					cardLayout.show(parentPanel, "selectSeats");
					contentPane.remove(nextButton);
					contentPane.add(payButton, BorderLayout.SOUTH);
					payButton.setBackground(SystemColor.textHighlight);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		payButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(MemberServiceJFrameMain.this.getSelectedSeatTotNum()==0) {
						JOptionPane.showMessageDialog(null, "좌석을 1개 이상 선택해주세요.", "", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
					memberPaymentDialog = new MemberPaymentDialog(MemberServiceJFrameMain.this);
					memberPaymentDialog.setModal(true);
					memberPaymentDialog.setVisible(true);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		
		
	}
	
	public void changePanel(String panelName) {
		CardLayout cardLayout = (CardLayout)parentPanel.getLayout();
		cardLayout.show(parentPanel, panelName);
	}
	public void changePanel(JButton removeButton, JButton addButton, String panelName) {
		CardLayout cardLayout = (CardLayout)parentPanel.getLayout();
		contentPane.remove(removeButton);
		contentPane.add(addButton,BorderLayout.SOUTH);
		cardLayout.show(parentPanel, panelName);
	}
	public void changePanel(JButton addButton, String panelName) {
		CardLayout cardLayout = (CardLayout)parentPanel.getLayout();
		contentPane.add(addButton,BorderLayout.SOUTH);
		cardLayout.show(parentPanel, panelName);
	}
	
	public void loginProcess(MemberVo loginMember) {
		this.loginMember = loginMember;
		setTitle(loginMember.getName() + "님 로그인중");
		loginMenuItem.setEnabled(false);
		logoutMenuItem.setEnabled(true);

	}

	public void loginProcess(AdminVo loginAdmin) {
		this.loginAdmin = loginAdmin;
		setTitle(loginAdmin.getName() + "님 로그인중");
		loginMenuItem.setEnabled(false);
		logoutMenuItem.setEnabled(true);
	}

	public void logoutProcess() {
		if(loginAdmin!=null)
		      dispose();
		loginMember = null;
		loginAdmin = null;
		setTitle("");
		this.changePanel("main");
		loginMenuItem.setEnabled(true);
		logoutMenuItem.setEnabled(false);
	}
}
