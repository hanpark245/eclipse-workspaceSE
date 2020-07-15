package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import member.MemberService;
import member.MemberVo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MemberLoginDialog extends JDialog {

	MemberService memberService;
	private final JPanel contentPanel = new JPanel();
	private JTextField idTF;
	private JPasswordField passwordTF;
	private JLabel idMsgL;
	private JLabel pwMsgL;
	MemberServiceJFrameMain mainFrame;

	/**
	 * Create the dialog.
	 */
	public MemberLoginDialog(MemberServiceJFrameMain mainFrame) {
		this.mainFrame = mainFrame;
		try {
			memberService = new MemberService();
		} catch (Exception e) {

			e.printStackTrace();
		}

		setBounds(100, 100, 450, 304);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		{
			JLabel idLabel = new JLabel("\uC544\uC774\uB514");
			idLabel.setBounds(80, 70, 57, 15);
			contentPanel.add(idLabel);
		}
		{
			JLabel passwordLabel = new JLabel("\uBE44\uBC00\uBC88\uD638");
			passwordLabel.setBounds(80, 120, 57, 15);
			contentPanel.add(passwordLabel);
		}

		idTF = new JTextField();
		idTF.setBounds(160, 67, 116, 21);
		contentPanel.add(idTF);
		idTF.setColumns(10);

		passwordTF = new JPasswordField();
		passwordTF.setBounds(160, 117, 116, 21);
		contentPanel.add(passwordTF);

		JButton loginB = new JButton("\uB85C\uADF8\uC778");
		loginB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = idTF.getText();
				char[] passChar = passwordTF.getPassword();
				String pw = new String(passChar);
				if (id.trim().equals("")) {
					idMsgL.setText("아이디를 입력하세요");
					return;
				}
				if (pw.trim().equals("")) {
					pwMsgL.setText("패스워드를 입력하세요");
					return;
				}

				try {
					int result = memberService.login(id, pw);
					switch (result) {
					case 0:
                        MemberVo loginMember = memberService.findMemberById(id);
                        mainFrame.loginProcess(loginMember);
                        dispose();
						break;
					case 1:
                         int resultType = JOptionPane.showConfirmDialog(null, "아이디가 없습니다.", "오류", JOptionPane.OK_CANCEL_OPTION);
                         if (resultType==JOptionPane.OK_OPTION) {
                        		idTF.requestFocus();
								idTF.selectAll();
						}else if(resultType==JOptionPane.CANCEL_OPTION){
							//MemberGaipPanel memberGaipPanel = new MemberGaipPanel(mainFrame);
							
							//memberGaipPanel.setVisible(true);
							dispose();
						}
						break;
					case 2:
						JOptionPane.showMessageDialog(
								null, "패쓰워드불일치.",
								"패쓰워드불일치", 
								JOptionPane.INFORMATION_MESSAGE);
						passwordTF.requestFocus();
						passwordTF.selectAll();
						break;

					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		loginB.setBounds(80, 175, 97, 23);
		contentPanel.add(loginB);

		JButton cancelB = new JButton("\uCDE8\uC18C");
		cancelB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelB.setBounds(196, 175, 97, 23);
		contentPanel.add(cancelB);

		idMsgL = new JLabel("");
		idMsgL.setForeground(Color.RED);
		idMsgL.setBackground(Color.BLACK);
		idMsgL.setBounds(277, 70, 145, 15);
		contentPanel.add(idMsgL);

		pwMsgL = new JLabel("");
		pwMsgL.setForeground(Color.RED);
		pwMsgL.setBackground(Color.BLACK);
		pwMsgL.setBounds(277, 120, 145, 15);
		contentPanel.add(pwMsgL);
	}
}
