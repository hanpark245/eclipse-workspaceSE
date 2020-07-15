package ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import member.MemberService;
import theater.TheaterService;
import theater.TheaterVo;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class TheaterAddPanel extends JPanel {
	private JTextField nameTF;
	private JTextField locationTF;
	private JTextField screenNumTF;
	private JTextField seatNumTF;
	
	TheaterService theaterService;
	private TheaterManegementPanel tmPanel;

	/**
	 * Create the panel.
	 */
	public TheaterAddPanel() {
		try {
			theaterService = new TheaterService();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		
		
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uADF9\uC7A5\uC9C0\uC5ED");
		lblNewLabel.setFont(new Font("나눔고딕코딩", Font.PLAIN, 12));
		lblNewLabel.setBounds(126, 51, 57, 15);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uADF9\uC7A5\uC774\uB984");
		lblNewLabel_1.setFont(new Font("나눔고딕코딩", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(126, 76, 57, 15);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uC0C1\uC601\uAD00 \uC218");
		lblNewLabel_2.setFont(new Font("나눔고딕코딩", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(126, 101, 57, 15);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\uC88C\uC11D \uC218");
		lblNewLabel_3.setFont(new Font("나눔고딕코딩", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(126, 126, 57, 15);
		add(lblNewLabel_3);
		
		locationTF = new JTextField();
		locationTF.setFont(new Font("나눔고딕코딩", Font.PLAIN, 12));
		locationTF.setBounds(195, 48, 116, 21);
		add(locationTF);
		locationTF.setColumns(10);

		nameTF = new JTextField();
		nameTF.setFont(new Font("나눔고딕코딩", Font.PLAIN, 12));
		nameTF.setBounds(195, 73, 116, 21);
		add(nameTF);
		nameTF.setColumns(10);
		
		
		screenNumTF = new JTextField();
		screenNumTF.setFont(new Font("나눔고딕코딩", Font.PLAIN, 12));
		screenNumTF.setBounds(195, 98, 116, 21);
		add(screenNumTF);
		screenNumTF.setColumns(10);
		
		seatNumTF = new JTextField();
		seatNumTF.setFont(new Font("나눔고딕코딩", Font.PLAIN, 12));
		seatNumTF.setBounds(195, 123, 116, 21);
		add(seatNumTF);
		seatNumTF.setColumns(10);
		
		JButton btnNewButton = new JButton("\uB4F1\uB85D");
		btnNewButton.setFont(new Font("나눔고딕코딩", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				theaterRegister();
			}

			
		});
		btnNewButton.setBounds(126, 208, 97, 23);
		add(btnNewButton);
		
		JButton cancelB = new JButton("\uCDE8\uC18C");
		cancelB.setFont(new Font("나눔고딕코딩", Font.PLAIN, 12));
		cancelB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetForm();
				tmPanel.changePanel("theaterButtonP");
			}
		});
		cancelB.setBounds(235, 208, 97, 23);
		add(cancelB);

	}
	/*
	 * 극장등록 메소드
	 */
	private void theaterRegister() {
		String location = locationTF.getText();
		String name = nameTF.getText();
		String screenNumStr = screenNumTF.getText();
		String seatNumStr = seatNumTF.getText();
		/*
		 * 공백 검사
		 */
		if (name.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "극장이름을 입력하세요.", "극장명 입력", JOptionPane.INFORMATION_MESSAGE);
			nameTF.requestFocus();
			return;
		} if (location.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "극장지역을 입력하세요.", "극장지역 입력", JOptionPane.INFORMATION_MESSAGE);
			locationTF.requestFocus();
			return;
		} if (screenNumStr.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "상영관 수를 입력하세요.", "상영관 수 입력", JOptionPane.INFORMATION_MESSAGE);
			screenNumTF.requestFocus();
			return;
		} if (seatNumStr.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "좌석 수를 입력하세요.", "좌석 수 입력", JOptionPane.INFORMATION_MESSAGE);
			seatNumTF.requestFocus();
			return;
		}
		
		/*
		 * 극장 중복 검사
		 */
		
		
		
		
		TheaterVo addTheater = new TheaterVo(location, name, Integer.parseInt(screenNumStr), Integer.parseInt(seatNumStr));
		try {
			theaterService.theaterRegister(addTheater);
			JOptionPane.showMessageDialog(null, "극장이 등록되었습니다.", "등록 성공", JOptionPane.INFORMATION_MESSAGE);
			resetForm();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"극장등록 실패", "등록 실패", JOptionPane.ERROR_MESSAGE);
		}
		
	}// end theaterRegister()
	
	private void resetForm() {
		nameTF.setText("");
		locationTF.setText("");
		screenNumTF.setText("");
		seatNumTF.setText("");
	}
	/*
	public void changePanel(String string) {
		CardLayout cl = (CardLayout)cardParentPanel.getLayout();
		cl.show(cardParentPanel, string);
	}
	*/
	public void setTheaterPanel(TheaterManegementPanel theaterManegementPanel) {
		this.tmPanel = theaterManegementPanel;
	}
	
	
	
	
	

}
