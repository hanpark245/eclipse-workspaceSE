package event;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ActionEventColorChangeFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ActionEventColorChangeFrame frame = new ActionEventColorChangeFrame();
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
	public ActionEventColorChangeFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 425, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel southMenuPanel = new JPanel();
		southMenuPanel.setBackground(SystemColor.activeCaption);
		contentPane.add(southMenuPanel, BorderLayout.SOUTH);
		
		JButton redB = new JButton("RED");
		redB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setBackground(Color.RED);
			}
		});
		southMenuPanel.add(redB);
		
		JButton blueB = new JButton("BLUE");
		blueB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setBackground(Color.BLUE);
			}
		});
		southMenuPanel.add(blueB);
		
		JButton greenB = new JButton("GREEN");
		greenB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setBackground(Color.GREEN);
			}
		});
		southMenuPanel.add(greenB);
	}

}
