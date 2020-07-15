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

import admin.AdminService;
import admin.AdminVo;
import member.MemberService;

public class AdminGaipPanel extends JPanel {
	AdminService adminService;
	private JTextField idTF;
	private JPasswordField passTF;
	private JTextField nameTF;
	private JButton gaipCancleB;
	MemberServiceJFrameMain mainFrame;
	
	/**
	 * Create the panel.
	 */
	public AdminGaipPanel(MemberServiceJFrameMain mainFrame) {
		this.mainFrame = mainFrame;
		try {
			adminService = new AdminService();
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		
		setLayout(null);

		JLabel lblNewLabel = new JLabel("\uC544\uC774\uB514");
		lblNewLabel.setBounds(227, 129, 57, 15);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\uD328\uC4F0\uC6CC\uB4DC");
		lblNewLabel_1.setBounds(227, 168, 57, 15);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\uC774\uB984");
		lblNewLabel_2.setBounds(227, 206, 57, 15);
		add(lblNewLabel_2);

		idTF = new JTextField();
		idTF.setBounds(337, 126, 116, 21);
		add(idTF);
		idTF.setColumns(10);

		passTF = new JPasswordField();
		passTF.setBounds(337, 165, 115, 18);
		add(passTF);

		nameTF = new JTextField();
		nameTF.setColumns(10);
		nameTF.setBounds(337, 203, 116, 21);
		add(nameTF);

		JButton gaipB = new JButton("\uAD00\uB9AC\uC790\uCD94\uAC00");
		gaipB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminGaip();
			}

		});
		gaipB.setBounds(229, 259, 97, 23);
		add(gaipB);

		gaipCancleB = new JButton("\uCDE8\uC18C");
		gaipCancleB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.changePanel(mainFrame.getReserveButton(),"main");
			}

		});
		gaipCancleB.setBounds(349, 259, 97, 23);
		add(gaipCancleB);

	}

	private void adminGaip() {
		String id = idTF.getText();
		char[] passChar = passTF.getPassword();
		String password = new String(passChar);
		String name = nameTF.getText();
		if (id.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "아이디를 입력하세요", "경고", JOptionPane.ERROR_MESSAGE);
			idTF.requestFocus();
			return;
		}if (password.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요", "경고", JOptionPane.ERROR_MESSAGE);
			passTF.requestFocus();
			return;
		}if (name.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "이름을 입력하세요", "경고", JOptionPane.ERROR_MESSAGE);
			nameTF.requestFocus();
			return;
		}
		AdminVo addAdmin = new AdminVo(id, password, name);
		System.out.println(addAdmin);
		
		try {
			boolean isSuccess = adminService.memberRegister(addAdmin);
			if (isSuccess) {
				JOptionPane.showMessageDialog(this, "관리자가 되신것을 환영합니다", "성공", JOptionPane.INFORMATION_MESSAGE);
				mainFrame.changePanel(mainFrame.getReserveButton(),"main");
				/*
				 * 로그인 패널(Dialog)로 이동
				 */
				resetForm();
			}else {
				JOptionPane.showMessageDialog(this, "아이디가 중복되었습니다", "오류", JOptionPane.WARNING_MESSAGE);
				idTF.requestFocus();
				idTF.setSelectionStart(0);
				idTF.setSelectionEnd(idTF.getText().length());
						
			}
			
		} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(this, "회원가입실패","실패", JOptionPane.WARNING_MESSAGE);
		}
		
	}

	private void resetForm() {
		idTF.setText("");
        passTF.setText("");
        nameTF.setText("");        
	}
}
