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

public class GuestOutDialog extends JDialog {

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
	public GuestOutDialog(int tbNo) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setTitle("Guest Out");
		setBounds(100, 100, 300, 250);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uD14C\uC774\uBE14\uBC88\uD638");
		lblNewLabel.setBounds(50, 80, 80, 15);
		contentPanel.add(lblNewLabel);
		
		JComboBox tableNoCB = new JComboBox();
		tableNoCB.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		tableNoCB.setSelectedIndex(tbNo-1);
		tableNoCB.setBounds(154, 77, 45, 21);
		contentPanel.add(tableNoCB);
		
		JLabel lblNewLabel_1 = new JLabel("\uACC4\uC0B0\uD558\uC2E4 \uD14C\uC774\uBE14\uBC88\uD638\uB97C \uC785\uB825\uD574\uC8FC\uC138\uC694.");
		lblNewLabel_1.setBounds(15, 15, 231, 15);
		contentPanel.add(lblNewLabel_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						tableNo = (String)tableNoCB.getSelectedItem();
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
}
