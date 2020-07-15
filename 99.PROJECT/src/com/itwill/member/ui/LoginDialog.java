package com.itwill.member.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.member.MemberService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginDialog extends JDialog {
	/***********************************/
	private MemberService memberService;
	private MemberServiceFrameMain frame;
	/************************************/
	private final JPanel contentPanel = new JPanel();
	private JTextField idTF;
	private JPasswordField passTF;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public LoginDialog() {
		setBounds(100, 100, 416, 207);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("아이디");
		lblNewLabel.setBounds(64, 33, 57, 15);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("패쓰워드");
		lblNewLabel_1.setBounds(64, 74, 57, 15);
		contentPanel.add(lblNewLabel_1);
		
		idTF = new JTextField();
		idTF.setBounds(161, 30, 116, 21);
		contentPanel.add(idTF);
		idTF.setColumns(10);
		
		passTF = new JPasswordField();
		passTF.setBounds(161, 71, 116, 21);
		contentPanel.add(passTF);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							String id = idTF.getText();
							String password=String.valueOf(passTF.getPassword());
							int result = memberService.login(id, password);
							if(result==0) {
								//로그인성공
								frame.loginUI(id);
								dispose();
							}else if(result==1) {
								//아이디존재안함
								JOptionPane.showMessageDialog(null, "아이디존재안함 다시해봐요");
								idTF.requestFocus();
								idTF.setSelectionStart(0);
								idTF.setSelectionEnd(id.length());
								
							}else if(result==2) {
								//비밀번호불일치
								JOptionPane.showMessageDialog(null, "비밀번호불일치 다시해봐요");
								passTF.requestFocus();
								passTF.setSelectionStart(0);
								passTF.setSelectionEnd(password.length());
							}
						}catch (Exception e1) {
							e1.printStackTrace();
						}
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		try {
			
			memberService=new MemberService();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//end constructor

	public void setFrame(MemberServiceFrameMain memberServiceFrameMain) {
		this.frame=memberServiceFrameMain;
	}
	
}//end class













