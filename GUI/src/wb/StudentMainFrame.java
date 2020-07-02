package wb;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.BoxLayout;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JCheckBox;

public class StudentMainFrame extends JFrame {
	private JTextField txtGg;
	private JTextField txtWp;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentMainFrame frame = new StudentMainFrame();
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
	public StudentMainFrame() {
		getContentPane().setForeground(Color.BLACK);
		getContentPane().setBackground(Color.PINK);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\stu05\\Desktop\\불좀꺼줄래.jpg"));
		setBackground(Color.BLACK);
		setTitle("학생관리프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 336, 429);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("학생등록");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(45, 252, 97, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("등록취소");
		btnNewButton_1.setBounds(178, 252, 97, 23);
		getContentPane().add(btnNewButton_1);
		
		txtGg = new JTextField();
		txtGg.setText("gg");
		txtGg.setBounds(96, 71, 116, 21);
		getContentPane().add(txtGg);
		txtGg.setColumns(10);
		
		txtWp = new JTextField();
		txtWp.setText("wp");
		txtWp.setBounds(96, 112, 116, 21);
		getContentPane().add(txtWp);
		txtWp.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("주소");
		lblNewLabel.setBounds(33, 115, 57, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("이름");
		lblNewLabel_1.setBounds(33, 74, 57, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("전화번호");
		lblNewLabel_2.setBounds(33, 157, 57, 15);
		getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(96, 154, 116, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("이메일 수신여부");
		chckbxNewCheckBox.setBounds(27, 208, 121, 23);
		getContentPane().add(chckbxNewCheckBox);
	}
}
