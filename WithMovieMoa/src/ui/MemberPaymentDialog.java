package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import movie.MovieService;
import reserve.ReserveService;
import reserve.ReserveVo;

public class MemberPaymentDialog extends JDialog {

	JButton tempButton = new JButton();
	MemberServiceJFrameMain mainFrame;
	MovieService movieService;
	ReserveService reserveService;
	private final JPanel contentPanel = new JPanel();
	private int fee;

	/**
	 * Create the dialog.
	 */
	public MemberPaymentDialog(MemberServiceJFrameMain mainFrame) throws Exception{
		this.mainFrame = mainFrame;
		movieService = new MovieService();
		reserveService = new ReserveService();
		fee = movieService.findMovieByMovieName(mainFrame.getSelectedMovieName()).getFee();
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel cardSelectLabel = new JLabel("\uCE74\uB4DC\uC120\uD0DD");
			cardSelectLabel.setBounds(68, 45, 57, 15);
			contentPanel.add(cardSelectLabel);
		}
		{
			JLabel paymentFeeLabel = new JLabel("\uACB0\uC81C\uAE08\uC561");
			paymentFeeLabel.setBounds(68, 95, 57, 15);
			contentPanel.add(paymentFeeLabel);
		}
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\uB86F\uB370\uCE74\uB4DC", "\uBE44\uC528\uCE74\uB4DC", "\uC0BC\uC131\uCE74\uB4DC", "\uC2E0\uD55C\uCE74\uB4DC", "\uC6B0\uB9AC\uCE74\uB4DC", "\uD558\uB098\uCE74\uB4DC", "\uD604\uB300\uCE74\uB4DC", "KB\uAD6D\uBBFC\uCE74\uB4DC"}));
		comboBox.setBounds(137, 42, 130, 21);
		contentPanel.add(comboBox);
		
		JLabel paymentFeeCalculateLabel = new JLabel(fee + " * " + mainFrame.getSelectedSeatTotNum() + " = " + fee*mainFrame.getSelectedSeatTotNum());
		paymentFeeCalculateLabel.setBounds(137, 95, 285, 15);
		contentPanel.add(paymentFeeCalculateLabel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("\uACB0\uC81C");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							ReserveVo newReserve = new ReserveVo(
									mainFrame.getLoginMember().getId(),
									mainFrame.getLoginMember().getName(),
									mainFrame.getSelectedMovieName(),
									mainFrame.getSelectedCity(),
									mainFrame.getSelectedTheater(),
									mainFrame.getSelectedDate(),
									mainFrame.getSelectedScreenNum(),
									mainFrame.getSelectedScreenTime(),
									(fee*mainFrame.getSelectedSeatTotNum()));
							reserveService.reserveRegister(newReserve);
							JOptionPane.showMessageDialog(null, "결제완료.", "결제", JOptionPane.INFORMATION_MESSAGE);
							dispose();
							mainFrame.changePanel(mainFrame.getPayButton(),mainFrame.getReserveButton(),"main");
							mainFrame.validate();
							mainFrame.repaint();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("\uCDE8\uC18C");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						mainFrame.changePanel(mainFrame.getPayButton(),mainFrame.getReserveButton(),"main");
						mainFrame.validate();
						mainFrame.repaint();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
