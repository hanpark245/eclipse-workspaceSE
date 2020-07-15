package ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import theater.TheaterService;
import theater.TheaterVo;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class TheaterUpdatePanel extends JPanel {
	private JTextField nameTF;
	private JTextField cityTF;
	private JTextField screenNumTF;
	private JTextField seatNumTF;
	private JTextField numberTF;
	private JButton findTheaterB;
	private JButton updateB;
	private JButton cancelB;

	TheaterService theaterService;
	private TheaterManegementPanel tmPanel;

	/**
	 * Create the panel.
	 */
	public TheaterUpdatePanel() {
		try {
			theaterService = new TheaterService();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		setLayout(null);

		JLabel label = new JLabel("\uADF9\uC7A5\uC774\uB984");
		label.setFont(new Font("나눔고딕코딩", Font.PLAIN, 12));
		label.setBounds(117, 87, 57, 15);
		add(label);

		JLabel label_1 = new JLabel("\uADF9\uC7A5\uC9C0\uC5ED");
		label_1.setFont(new Font("나눔고딕코딩", Font.PLAIN, 12));
		label_1.setBounds(117, 112, 57, 15);
		add(label_1);

		JLabel label_2 = new JLabel("\uC0C1\uC601\uAD00 \uC218");
		label_2.setFont(new Font("나눔고딕코딩", Font.PLAIN, 12));
		label_2.setBounds(117, 137, 57, 15);
		add(label_2);

		JLabel label_3 = new JLabel("\uC88C\uC11D \uC218");
		label_3.setFont(new Font("나눔고딕코딩", Font.PLAIN, 12));
		label_3.setBounds(117, 162, 57, 15);
		add(label_3);

		nameTF = new JTextField();
		nameTF.setColumns(10);
		nameTF.setBounds(186, 84, 116, 21);
		add(nameTF);

		cityTF = new JTextField();
		cityTF.setColumns(10);
		cityTF.setBounds(186, 109, 116, 21);
		add(cityTF);

		screenNumTF = new JTextField();
		screenNumTF.setColumns(10);
		screenNumTF.setBounds(186, 134, 116, 21);
		add(screenNumTF);

		seatNumTF = new JTextField();
		seatNumTF.setColumns(10);
		seatNumTF.setBounds(186, 159, 116, 21);
		add(seatNumTF);

		updateB = new JButton("\uC218\uC815");
		updateB.setFont(new Font("나눔고딕코딩", Font.PLAIN, 12));
		updateB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTheater();
			}

		});
		updateB.setBounds(117, 244, 97, 23);
		add(updateB);

		cancelB = new JButton("\uCDE8\uC18C");
		cancelB.setFont(new Font("나눔고딕코딩", Font.PLAIN, 12));
		cancelB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tmPanel.changePanel("theaterButtonP");
			}
		});
		cancelB.setBounds(226, 244, 97, 23);
		add(cancelB);

		JLabel lblNewLabel = new JLabel("\uAC80\uC0C9\uD560 \uADF9\uC7A5\uBC88\uD638");
		lblNewLabel.setFont(new Font("나눔고딕코딩", Font.PLAIN, 12));
		lblNewLabel.setBounds(77, 62, 97, 15);
		add(lblNewLabel);

		numberTF = new JTextField();
		numberTF.setBounds(186, 59, 116, 21);
		add(numberTF);
		numberTF.setColumns(10);

		findTheaterB = new JButton("\uADF9\uC7A5\uAC80\uC0C9");
		findTheaterB.setFont(new Font("나눔고딕코딩", Font.PLAIN, 12));
		findTheaterB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numberStr = numberTF.getText();
				if(!numberStr.equals("")) {
					findByTheaterNum(Integer.parseInt(numberStr));
				} else {
					JOptionPane.showMessageDialog(null, "검색할 번호를 입력하세요.", "검색 오류", JOptionPane.WARNING_MESSAGE);
				}
			}

		});
		findTheaterB.setBounds(314, 58, 97, 23);
		add(findTheaterB);

	}

	private void findByTheaterNum(int theaterNumber) {
		if (numberTF.getText().equals("")) {

			JOptionPane.showMessageDialog(null, "검색할 극장번호를 입력하세요.", "극장번호 입력", JOptionPane.WARNING_MESSAGE);
			return;

		}

		try {
			TheaterVo findTheater = theaterService.findTheaterByNo(theaterNumber);
			nameTF.setText(findTheater.getTheaterName());
			cityTF.setText(findTheater.getTheaterCity());
			screenNumTF.setText(findTheater.getScreenAreaNum() + "");
			seatNumTF.setText(findTheater.getSeatTotNum() + "");
			JOptionPane.showMessageDialog(null, "극장이 검색되었습니다.", "검색 성공", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "검색을 실패했습니다.", "검색 실패", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void updateTheater() {
		String number = numberTF.getText();
		String name = nameTF.getText();
		String city = cityTF.getText();
		String screenNum = screenNumTF.getText();
		String seatNum = seatNumTF.getText();

		try {
			TheaterVo updateTheater = new TheaterVo(name, city, Integer.parseInt(screenNum), Integer.parseInt(seatNum));
			updateTheater.setTheaterNumber(Integer.parseInt(number));
			theaterService.theaterUpdate(updateTheater);
			
			JOptionPane.showMessageDialog(null, "극장이 수정되었습니다.", "수정 성공", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "수정을 실패했습니다.", "수정 실패", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void setTheaterPanel(TheaterManegementPanel theaterManegementPanel) {
		this.tmPanel = theaterManegementPanel;
	}

}
