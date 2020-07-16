package com.itwill.member.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.member.Member;
import com.itwill.member.MemberService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JoinDialog extends JDialog {
	/*****************/
	MemberService memberService;
	boolean isIdCheck=false;
	/*****************/
	private final JPanel contentPanel = new JPanel();
	private JTextField idTF;
	private JTextField nameTF;
	private JTextField addressTF;
	private JTextField ageTF;
	private JCheckBox marriedChk;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public JoinDialog() {
		setBounds(100, 100, 358, 293);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("아이디");
			lblNewLabel.setBounds(27, 41, 57, 15);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("이름");
			lblNewLabel_1.setBounds(26, 69, 57, 15);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("주소");
			lblNewLabel_2.setBounds(26, 97, 57, 15);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("나이");
			lblNewLabel_3.setBounds(27, 126, 57, 15);
			contentPanel.add(lblNewLabel_3);
		}
		{
			marriedChk = new JCheckBox("결혼여부");
			marriedChk.setBounds(97, 163, 115, 23);
			contentPanel.add(marriedChk);
		}
		{
			idTF = new JTextField();
			idTF.setBounds(95, 37, 116, 21);
			contentPanel.add(idTF);
			idTF.setColumns(10);
		}
		{
			nameTF = new JTextField();
			nameTF.setBounds(96, 66, 116, 21);
			contentPanel.add(nameTF);
			nameTF.setColumns(10);
		}
		{
			addressTF = new JTextField();
			addressTF.setBounds(97, 93, 116, 21);
			contentPanel.add(addressTF);
			addressTF.setColumns(10);
		}
		{
			ageTF = new JTextField();
			ageTF.setBounds(98, 124, 116, 21);
			contentPanel.add(ageTF);
			ageTF.setColumns(10);
		}
		{
			JButton idCheckBtn = new JButton("중복확인");
			idCheckBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					/****************아이디중복체크*************/
					try {
						String id = idTF.getText();
						if(id==null|| id.equals("")) {
							JOptionPane.showMessageDialog(null, "아이디를 입력해주세요");
							idTF.requestFocus();
							return;
						}
						
						boolean isDuplicate = 
								memberService.isDuplicateId(id);
						if(isDuplicate) {
							JOptionPane.showMessageDialog(null, id+ " 는 이미사용중인아이디입니다.");
							idTF.requestFocus();
							idTF.setSelectionStart(0);
							idTF.setSelectionEnd(id.length());
							isIdCheck=false;
						}else {
							isIdCheck=true;
							nameTF.requestFocus();
							
						}
					}catch (Exception e1) {
						e1.printStackTrace();
					}
					
					/******************************************/
				}
			});
			idCheckBtn.setBounds(218, 37, 88, 23);
			contentPanel.add(idCheckBtn);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("가입");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						/***********회원가입***************/
						try {
							String id=idTF.getText();
							String name=nameTF.getText();
							String address=addressTF.getText();
							String ageStr=ageTF.getText();
							boolean married=marriedChk.isSelected();
							if(id.equals("")||name.equals("")||address.equals("")||ageStr.equals("")) {
								JOptionPane.showMessageDialog(null, "모든항목을 입력하세요");
								return;
							}
							if(!isIdCheck) {
								JOptionPane.showMessageDialog(null, "아이디중복체크를 하세요");
								return;
							}
							
							memberService.memberRegister(
									new Member(id, id, name, address, Integer.parseInt(ageStr), married));
							dispose();
						}catch (Exception e1) {
							e1.printStackTrace();
						}
						/**********************************/
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("취소");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		/*********************************/
		try {
			
			memberService=new MemberService();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/***********************************/
	}//end constructor

}//end class
