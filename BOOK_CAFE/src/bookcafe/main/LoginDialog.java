package bookcafe.main;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPasswordField passTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	}

	// login 실패시 계속 할건지 묻는 경고창 추가
	/**
	 * Create the dialog.
	 */
	public LoginDialog(Frame owner) {
		super(owner);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setTitle("Admin Login");
		setBounds(100, 100, 300, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uAD00\uB9AC\uC790 \uB85C\uADF8\uC778\uC774 \uD544\uC694\uD569\uB2C8\uB2E4.");
		lblNewLabel.setBounds(12, 10, 163, 15);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(58, 61, 67, 15);
		contentPanel.add(lblNewLabel_1);
		
		passTF = new JPasswordField();
		passTF.setBounds(129, 58, 100, 21);
		contentPanel.add(passTF);
		{
			JPanel buttonPane = new JPanel();
			FlowLayout fl_buttonPane = new FlowLayout(FlowLayout.CENTER);
			buttonPane.setLayout(fl_buttonPane);
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				// Login 버튼
				JButton okButton = new JButton("Login");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String pass = new String(passTF.getPassword());
						
						BookcafeMain bm = (BookcafeMain)getOwner();
						System.out.println(bm.toString());
						
						boolean isSuccess = false;
						try {
							isSuccess = login(pass);
							if (isSuccess) {
								System.out.println("로그인성공");
								JOptionPane.showMessageDialog(null, "로그인성공");
								dispose();
							} else {
								int result = JOptionPane.showConfirmDialog(null, "로그인실패 계속할래요");
								
								switch (result) {
								case JOptionPane.OK_OPTION:
									passTF.setText("");
									passTF.requestFocus();
									break;
								case JOptionPane.NO_OPTION:
									JOptionPane.showMessageDialog(null, "애플리케이션을 종료합니다");
									System.exit(0);
									break;
								case JOptionPane.CANCEL_OPTION:
									break;
								}								
							}
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			
			JButton btnNewButton = new JButton("Cancle");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			buttonPane.add(btnNewButton);
		}
	}
	
	// 로그인 함수
	public boolean login(String pass) throws Exception {
		System.out.println("main login");
		boolean isSuccess = false;
		
		if (matchPassword(pass)) {
			isSuccess = true;
		} else {
			isSuccess = false;				
		}
		return isSuccess;		
	}

	// 패스워드 함수
	public boolean matchPassword(String password) throws Exception {
		BookcafeMain bm = new BookcafeMain();
		System.out.println(bm.getAdminPW());
		if(bm.getAdminPW().equals(password)) {
			return true;
		} else {
			return false;
		}
	}
}
