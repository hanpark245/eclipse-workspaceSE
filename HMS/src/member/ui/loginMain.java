package member.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.TextField;
import java.awt.Font;
import java.awt.Label;
import java.awt.Color;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class loginMain extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginMain frame = new loginMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public loginMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 687, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		TextField textField = new TextField();
		textField.setBounds(429, 176, 192, 23);
		contentPane.add(textField);
		
		TextField textField_1 = new TextField();
		textField_1.setBounds(429, 234, 192, 23);
		contentPane.add(textField_1);
		
		Button memberLoginBtn = new Button("회원 로그인");
		memberLoginBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		memberLoginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		memberLoginBtn.setBounds(524, 300, 97, 23);
		contentPane.add(memberLoginBtn);
		
		Label idLabel = new Label("아이디");
		idLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		idLabel.setBounds(347, 176, 69, 23);
		contentPane.add(idLabel);
		
		Label idTF = new Label("패스워드");
		idTF.setBounds(347, 234, 69, 23);
		contentPane.add(idTF);
		
		Button adminLoginBtn = new Button("관리자 로그인");
		adminLoginBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		adminLoginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		adminLoginBtn.setBounds(429, 300, 89, 23);
		contentPane.add(adminLoginBtn);
		JLabel HSMSign = new JLabel("Health Management System");
		HSMSign.setForeground(new Color(244, 164, 96));
		HSMSign.setFont(new Font("Impact", Font.PLAIN, 25));
		HSMSign.setBounds(32, 38, 301, 50);
		contentPane.add(HSMSign);
/////////////////////*
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(5, 5, 661, 423);
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("C:\\\\Users\\\\stu05\\\\eclipse-workspace\\\\HMS\\\\HSM 사진\\\\eric-mills-6ysUHAgX8tY-unsplash.jpg"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		Image dimg = img.getScaledInstance(687, 472, Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(dimg);
		contentPane.setLayout(null);
		lblNewLabel.setIcon(imageIcon);
		
		contentPane.add(lblNewLabel);
	//////////////////////////////////*
		contentPane.setLayout(null);
		
		
	
	}
}
