package layout;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class JPanelJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JPanelJFrame frame = new JPanelJFrame();
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
	public JPanelJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 537, 348);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(233, 150, 122));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(10);
		flowLayout.setHgap(20);
		flowLayout.setAlignOnBaseline(true);
		panel.setBackground(new Color(102, 205, 170));
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("추 가");
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("리스트");
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("수정");
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("삭제");
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_3 = new JButton("찾기");
		panel.add(btnNewButton_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(30, 144, 255));
		contentPane.add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("접속자리스트");
		panel_1.add(lblNewLabel, BorderLayout.NORTH);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"김경호", "신명숙", "김태희", "고소영", "이소라", "이효리"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		panel_1.add(list, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(173, 255, 47));
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("이름");
		lblNewLabel_1.setBounds(48, 41, 57, 15);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("전화번호");
		lblNewLabel_2.setBounds(48, 80, 57, 15);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("주소");
		lblNewLabel_3.setBounds(48, 120, 57, 15);
		panel_2.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(174, 38, 116, 21);
		panel_2.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(174, 77, 116, 21);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(174, 117, 116, 21);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("자기소개");
		lblNewLabel_4.setBounds(48, 161, 57, 15);
		panel_2.add(lblNewLabel_4);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(174, 157, 116, 89);
		panel_2.add(textArea);
	}
}
