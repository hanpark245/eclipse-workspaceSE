package layout;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GridLayoutJFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GridLayoutJFrame frame = new GridLayoutJFrame();
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
	public GridLayoutJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 0, 0, 0));
		
		JButton btnNewButton = new JButton("1");
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("2");
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("3");
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("+");
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_1 = new JButton("4");
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_6 = new JButton("5");
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_5 = new JButton("6");
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_9 = new JButton("-");
		contentPane.add(btnNewButton_9);
		
		JButton btnNewButton_8 = new JButton("7");
		contentPane.add(btnNewButton_8);
		
		JButton btnNewButton_7 = new JButton("8");
		contentPane.add(btnNewButton_7);
		
		JButton btnNewButton_12 = new JButton("9");
		contentPane.add(btnNewButton_12);
		
		JButton btnNewButton_10 = new JButton("/");
		contentPane.add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("0");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnNewButton_11);
		
		JButton btnNewButton_13 = new JButton("c");
		contentPane.add(btnNewButton_13);
		
		JButton btnNewButton_14 = new JButton(".");
		contentPane.add(btnNewButton_14);
		
		JButton btnNewButton_15 = new JButton("=");
		contentPane.add(btnNewButton_15);
	}

}
