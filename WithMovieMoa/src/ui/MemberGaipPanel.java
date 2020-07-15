package ui;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import member.MemberService;
import member.MemberVo;

public class MemberGaipPanel extends JPanel {
	private JTextField idTF;
	private JTextField nameTF;
	private JTextField ageTF;
	private JTextField addressTF;
	private JTextField phoneNumberTF;
	private JTextField emailTF;
	private JPasswordField passTF;
	private JButton gaipCancelB;
	MemberServiceJFrameMain mainFrame;
	MemberService memberService;

	public JButton getGaipCancleB() {
		return gaipCancelB;
	}

	/**
	 * Create the panel.
	 */
	public MemberGaipPanel(MemberServiceJFrameMain mainFrame) {
		try {
			memberService = new MemberService();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		this.mainFrame = mainFrame;
		setLayout(null);

		JLabel lblNewLabel = new JLabel("\uC544\uC774\uB514");
		lblNewLabel.setBounds(269, 33, 57, 15);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\uD328\uC4F0\uC6CC\uB4DC");
		lblNewLabel_1.setBounds(269, 72, 57, 15);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\uC774\uB984");
		lblNewLabel_2.setBounds(269, 110, 57, 15);
		add(lblNewLabel_2);

		JLabel label = new JLabel("\uB098\uC774");
		label.setBounds(269, 149, 57, 15);
		add(label);

		JLabel label_1 = new JLabel("\uC8FC\uC18C");
		label_1.setBounds(269, 193, 57, 15);
		add(label_1);

		JLabel lblNewLabel_3 = new JLabel("\uC804\uD654\uBC88\uD638");
		lblNewLabel_3.setBounds(269, 235, 57, 15);
		add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("\uC774\uBA54\uC77C");
		lblNewLabel_4.setBounds(269, 275, 57, 15);
		add(lblNewLabel_4);

		JCheckBox adAgreeCB = new JCheckBox("\uAD11\uACE0\uC218\uC2E0\uB3D9\uC758");
		adAgreeCB.setBounds(307, 319, 115, 23);
		add(adAgreeCB);

		idTF = new JTextField();
		idTF.setBounds(379, 30, 116, 21);
		add(idTF);
		idTF.setColumns(10);

		passTF = new JPasswordField();
		passTF.setBounds(379, 69, 115, 18);
		add(passTF);

		nameTF = new JTextField();
		nameTF.setColumns(10);
		nameTF.setBounds(379, 107, 116, 21);
		add(nameTF);

		ageTF = new JTextField();
		ageTF.setColumns(10);
		ageTF.setBounds(379, 146, 116, 21);
		add(ageTF);

		addressTF = new JTextField();
		addressTF.setColumns(10);
		addressTF.setBounds(379, 190, 116, 21);
		add(addressTF);

		phoneNumberTF = new JTextField();
		phoneNumberTF.setColumns(10);
		phoneNumberTF.setBounds(379, 235, 116, 21);
		add(phoneNumberTF);

		emailTF = new JTextField();
		emailTF.setColumns(10);
		emailTF.setBounds(379, 272, 116, 21);
		add(emailTF);

		JButton gaipB = new JButton("\uD68C\uC6D0\uAC00\uC785");
		gaipB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memberGaip();

			}
			private void resetForm() {
				idTF.setText("");
				passTF.setText("");
				nameTF.setText("");
                ageTF.setText("");
                addressTF.setText("");
                phoneNumberTF.setText("");
                emailTF.setText("");
                adAgreeCB.setSelected(true);
			}
			private void memberGaip() {
				String id = idTF.getText();
				char[] pass = passTF.getPassword();
				String passStr = new String(pass);
				String name = nameTF.getText();
				String age = ageTF.getText();
				String address = addressTF.getText();
				String phoneNumber = phoneNumberTF.getText();
				String email = emailTF.getText();
				boolean adAgree = false;
				if (adAgreeCB.isSelected()) {
					adAgree = true;
				}
				if (id.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "아이디를 입력하세요.", "경고", JOptionPane.WARNING_MESSAGE);
					idTF.requestFocus();
					return;
				} if(passStr.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요.", "경고", JOptionPane.WARNING_MESSAGE);
					passTF.requestFocus();
					return;
				} if(name.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "이름을 입력하세요.", "경고", JOptionPane.WARNING_MESSAGE);
					nameTF.requestFocus();
					return;
				} if (age.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "나이를 입력하세요.", "경고", JOptionPane.WARNING_MESSAGE);
					ageTF.requestFocus();
					return;
				} if (address.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "주소를 입력하세요.", "경고", JOptionPane.WARNING_MESSAGE);
					addressTF.requestFocus();
					return;
				} if (phoneNumber.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "전화번호를 입력하세요.", "경고", JOptionPane.WARNING_MESSAGE);
					phoneNumberTF.requestFocus();
					return;
				} if (email.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "이메일을 입력하세요.", "경고", JOptionPane.WARNING_MESSAGE);
					emailTF.requestFocus();
					return;
				}
				MemberVo addMember = new MemberVo(id, passStr, name, Integer.parseInt(age), address, phoneNumber, email,
						adAgree);
				
				try {
					boolean isSuccess = memberService.memberRegister(addMember);
					if (isSuccess) {
						JOptionPane.showMessageDialog(null, "회원가입 성공", "성공", JOptionPane.INFORMATION_MESSAGE);
						mainFrame.changePanel(mainFrame.getReserveButton(),"main");
						resetForm();
					} else {
						JOptionPane.showMessageDialog(null, "아이디가 중복되었습니다.", "중복", JOptionPane.INFORMATION_MESSAGE);
						idTF.requestFocus();
						idTF.setSelectionStart(0);
						idTF.setSelectionEnd(idTF.getText().length());
					}
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "회원가입 실패", "실패", JOptionPane.WARNING_MESSAGE);
				}
				
				

			}

			
		});
		gaipB.setBounds(248, 348, 97, 23);
		add(gaipB);

		gaipCancelB = new JButton("\uCDE8\uC18C");
		gaipCancelB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.changePanel(mainFrame.getReserveButton(),"main");
			}
		});
		gaipCancelB.setBounds(396, 348, 97, 23);
		add(gaipCancelB);

	}
}
