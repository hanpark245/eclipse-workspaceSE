package event;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class ChattingFrame extends JFrame {

	private JPanel contentPane;
	private JTextField chatTF;
	private JTextArea chatTA;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChattingFrame frame = new ChattingFrame();
					frame.setVisible(true);
					frame.chatTF.requestFocus();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ChattingFrame() {
		setFont(new Font("맑은 고딕", Font.BOLD, 15));
		setTitle("채팅");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 459, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		chatTF = new JTextField();
		chatTF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendMsg();
			}
		});
		chatTF.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		panel.add(chatTF);
		chatTF.setColumns(25);
		
		JButton sendB = new JButton("전송");
		sendB.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		sendB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendMsg();
			}
		});
		panel.add(sendB);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		chatTA = new JTextArea();
		chatTA.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		chatTA.setEditable(false);
		scrollPane.setViewportView(chatTA);
		
	}
	/**********************************************/
	public void sendMsg() {
		String chatStr = chatTF.getText();
		if(chatStr.equals("")) {
			chatTF.requestFocus();
			return;
		}
		chatTA.append("경호:"+chatStr+"\n");
		chatTF.setText("");
		chatTF.requestFocus();
	}

}
