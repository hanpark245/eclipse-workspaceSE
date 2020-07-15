package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import seat.SeatService;

public class MemberSelectSeatsPanel extends JPanel {
	
	MemberServiceJFrameMain mainFrame;
	SeatService seatService;
	int count = 0;
	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public MemberSelectSeatsPanel(MemberServiceJFrameMain mainFrame) throws Exception {
		this.mainFrame = mainFrame;
		seatService = new SeatService();
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 1));
		
		JLabel screenNumTimeLabel = new JLabel(
				mainFrame.getSelectedScreenNum()+"상영관 " 
		+ mainFrame.getSelectedScreenTime() + " : 00 좌석 현황" );
		panel.add(screenNumTimeLabel);
		
		JButton screenButton = new JButton("S C R E E N");
		screenButton.setEnabled(false);
		screenButton.setForeground(Color.WHITE);
		screenButton.setBackground(Color.BLUE);
		screenButton.setFont(new Font("굴림", Font.BOLD, 20));
		panel.add(screenButton);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("        ");
		panel_1.add(lblNewLabel, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("        ");
		panel_1.add(lblNewLabel_1, BorderLayout.WEST);
		
		JLabel lblNewLabel_2 = new JLabel("        ");
		panel_1.add(lblNewLabel_2, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_3 = new JLabel("        ");
		panel_1.add(lblNewLabel_3, BorderLayout.EAST);
		
		JPanel seatPanel = new JPanel();
		panel_1.add(seatPanel, BorderLayout.CENTER);
		seatPanel.setLayout(new GridLayout(6,5));
		JCheckBox[] resSeatList = new JCheckBox[30];
		
		/*
		 * 좌석정보불러와서
		 * 좌석정보의 boolean값 false인것 resSeatList에서 setEnable false해주기
		 */
		
		
		
		boolean[] isReserve = seatService.findSeatInfoByCityAndTheaterAndDateAndScreenNumAndTime(
				mainFrame.getSelectedCity(), 
				mainFrame.getSelectedTheater(),
				mainFrame.getSelectedDate(),
				mainFrame.getSelectedScreenNum(),
				mainFrame.getSelectedScreenTime()).getIsReserve();
		for (int i = 0; i < resSeatList.length; i++) {
			isReserve[i] = true;
			resSeatList[i] = new JCheckBox((i+1)+"번좌석");
			seatPanel.add(resSeatList[i]);
			resSeatList[i].setEnabled(isReserve[i]);
		}
		
		for (int i = 0; i < resSeatList.length; i++) {
			final int indexReserve = i;
			resSeatList[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(isReserve[indexReserve]) {
						isReserve[indexReserve] = false;
						count++;
						mainFrame.setSelectedSeatTotNum(count);
					}
					else {
						isReserve[indexReserve] = true;
						count--;
						mainFrame.setSelectedSeatTotNum(count);
					}
					mainFrame.setSelectedReserve(isReserve);
					//System.out.println(mainFrame.getSelectedSeatTotNum());
					for (int j = 0; j < isReserve.length; j++) {
						//if(j%5==0) System.out.println();
						//System.out.print(isReserve[j]+" ");
					}
				}
			});
		}
		
		

	}
}
