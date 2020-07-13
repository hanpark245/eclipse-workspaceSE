package wb.basic;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChildJFrame extends JFrame {

	private JPanel contentPane;
	private JButton btn1;
	private JButton btn2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		ChildJFrame frame = new ChildJFrame();
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public ChildJFrame() {
		setTitle(" 상속에의한프레임생성");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 153, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btn1 = new JButton("확인");
		btn1.setBounds(24, 92, 104, 33);
		contentPane.add(btn1);
		
		btn2 = new JButton("취소");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn2.setBounds(154, 92, 97, 33);
		contentPane.add(btn2);
	}
}
