package bookcafe.main;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import bookcafe.ui.BookPanel;
import bookcafe.ui.SalesPanel;
import bookcafe.ui.TablePanel;

public class BookcafeMain extends JFrame {

	public static boolean testmode = false;
	private String adminPW = "admin";	// 패스워드

	mainDataSet mds = new mainDataSet();
	// 프레임 변수
	/*TableFrame tFR	= new TableFrame();
	BookFrame bFR	= new BookFrame();
	SalesFrame sFR	= new SalesFrame();*/
	
	public String getAdminPW() {
		return adminPW;
	}
	
	/************ Action Performer **********************/

	
	/************ JFRAME 관련 **************************/
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookcafeMain frame = new BookcafeMain();
					frame.setVisible(true);
					
					//mainDataSet MD = new mainDataSet();
					
					if (testmode == false) {
						LoginDialog loginD = new LoginDialog(frame);
						loginD.setModal(true);
						loginD.setResizable(false);
						loginD.setLocation(frame.getWidth()/2-50, frame.getHeight()/2);
						loginD.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
						loginD.setVisible(true);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public BookcafeMain() throws Exception {
		setTitle("\uCC3D\uB82C BOOK CAFE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBookCafe = new JLabel("\uCC3D\uB82C BOOK CAFE");
		lblBookCafe.setFont(new Font("궁서체", Font.PLAIN, 50));
		lblBookCafe.setBounds(308, 24, 362, 77);
		contentPane.add(lblBookCafe);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(50, 130, 830, 507);
		contentPane.add(tabbedPane);
		JLabel mImageLabel = new JLabel(new ImageIcon("images/main.png"));
		tabbedPane.addTab("북카페 메인", null, mImageLabel, null);
		mImageLabel.setText("");
		
		TablePanel tPanel = new TablePanel();
		tabbedPane.addTab("테이블 관리", null, tPanel, null);
		
		BookPanel bPanel = new BookPanel();
		tabbedPane.addTab("도서 관리", null, bPanel, null);
		
		SalesPanel sPanel = new SalesPanel();
		tabbedPane.addTab("매출 관리", null, sPanel, null);
		
		tabbedPane.addChangeListener(new ChangeListener() {			
			@Override
			public void stateChanged(ChangeEvent e) {
				if (tabbedPane.getSelectedIndex() == 3) {
						try {
							sPanel.reset();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}
			}
		});
	}
}
