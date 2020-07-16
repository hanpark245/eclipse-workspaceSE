package bookcafe.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuestInDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private String tableNo;
	private String guestNo;

	/**
	 * Launch the application.
	 */
	
//	public static void main(String[] args) {
//		try {
//			GuestInDialog dialog = new GuestInDialog();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public GuestInDialog() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setTitle("\uC190\uB2D8 \uC785\uC7A5");
		setBounds(100, 100, 300, 250);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uD14C\uC774\uBE14\uBC88\uD638");
		lblNewLabel.setBounds(50, 60, 80, 15);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uC778\uC6D0\uC218");
		lblNewLabel_1.setBounds(50, 117, 80, 15);
		contentPanel.add(lblNewLabel_1);
		
		JComboBox tableNoCB = new JComboBox();
		tableNoCB.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		tableNoCB.setBounds(150, 57, 60, 21);
		contentPanel.add(tableNoCB);
		
		JComboBox guestNoCB = new JComboBox();
		guestNoCB.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		guestNoCB.setBounds(150, 117, 60, 21);
		contentPanel.add(guestNoCB);
		
		JLabel lblNewLabel_2 = new JLabel("1\uC778 1\uBA54\uB274 \uC774\uC0C1 \uC8FC\uBB38 \uAC00\uB2A5\uD569\uB2C8\uB2E4.");
		lblNewLabel_2.setBounds(15, 15, 231, 15);
		contentPanel.add(lblNewLabel_2);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						tableNo = (String)tableNoCB.getSelectedItem();
						guestNo = (String)guestNoCB.getSelectedItem();
						System.out.println("테이블번호"+tableNo + " " + "인원수"+guestNo);
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//System.exit(0);
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public int getTableNo(){
		if(tableNo != null)
			return Integer.parseInt(tableNo);
		else
			return 0;
	}
	public int getguestNo(){
		if(tableNo != null)
			return Integer.parseInt(guestNo);
		else
			return 0;
	}
}
