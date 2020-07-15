package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import admin.AdminService;
import admin.AdminVo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AdminLoginDialog extends JDialog {

	AdminService adminService;
	private final JPanel contentPanel = new JPanel();
	private JTextField idTF;
	private JPasswordField passwordTF;
	MemberServiceJFrameMain mainFrame;
	/**
	 * Create the frame.
	 */
	public AdminLoginDialog(MemberServiceJFrameMain mainFrame) {
        this.mainFrame = mainFrame;
        try {
			adminService = new AdminService();
		} catch (Exception e2) {
		
			e2.printStackTrace();
		}
        
		setBounds(100, 100, 450, 304);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel idLabel = new JLabel("\uAD00\uB9AC\uC790 \uC544\uC774\uB514");
		idLabel.setBounds(54, 89, 81, 15);
		contentPanel.add(idLabel);
		
		JLabel passwordLabel = new JLabel("\uBE44\uBC00\uBC88\uD638");
		passwordLabel.setBounds(78, 135, 57, 15);
		contentPanel.add(passwordLabel);
		
		idTF = new JTextField();
		idTF.setBounds(149, 86, 116, 21);
		contentPanel.add(idTF);
		idTF.setColumns(10);
		
		passwordTF = new JPasswordField();
		passwordTF.setBounds(147, 132, 116, 21);
		contentPanel.add(passwordTF);
		passwordTF.setColumns(10);
		
		JLabel idMsgL = new JLabel("");
		idMsgL.setForeground(Color.RED);
		idMsgL.setBounds(277, 89, 145, 15);
		contentPanel.add(idMsgL);
		
		JLabel pwMsgL = new JLabel("");
		pwMsgL.setForeground(Color.RED);
		pwMsgL.setBounds(275, 135, 147, 15);
		contentPanel.add(pwMsgL);
		
		JButton loginB = new JButton("\uB85C\uADF8\uC778");
		loginB.setForeground(Color.BLACK);
		loginB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = idTF.getText();
				char[] passChar = passwordTF.getPassword();
				String password = new String(passChar);
				
				if (id.trim().equals("")) {
					idMsgL.setText("아이디를 입력하세요");
					return;
				}
				if (password.trim().equals("")) {
					pwMsgL.setText("비밀번호를 입력하세요");
					return;
				}
				try {
					int result = adminService.login(id, password);
					switch (result) {
					case 1:
						AdminVo loginAdmin = adminService.findAdminById(id); 
						mainFrame.loginProcess(loginAdmin);
						dispose();
						mainFrame.remove(mainFrame.getReserveButton());
						mainFrame.changePanel("adminManagement");
						break;
					case 2:
						JOptionPane.showMessageDialog(
								null, "패쓰워드불일치.",
								"패쓰워드불일치", 
								JOptionPane.INFORMATION_MESSAGE);
						passwordTF.requestFocus();
						passwordTF.selectAll();
						break;
					case 3:
						int resultType = JOptionPane.showConfirmDialog(null, "아이디가 없습니다.", "오류", JOptionPane.OK_CANCEL_OPTION);
                        if (resultType==JOptionPane.OK_OPTION) {
                       		idTF.requestFocus();
								idTF.selectAll();
						}else if(resultType==JOptionPane.CANCEL_OPTION){
						
							dispose();
						}
						break;
					}
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
			}
		});
		loginB.setBounds(110, 187, 97, 23);
		contentPanel.add(loginB);
		
		JButton cancelB = new JButton("\uCDE8\uC18C");
		cancelB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelB.setBounds(210, 188, 97, 23);
		contentPanel.add(cancelB);
		
		
		
	}

}
