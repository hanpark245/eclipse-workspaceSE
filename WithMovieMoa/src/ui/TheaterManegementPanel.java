package ui;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

public class TheaterManegementPanel extends JPanel {
	private JPanel cardParentPanel;
	private TheaterListPanel theaterListPanel;
	private JPanel theaterButtonPanel;
	private JButton theaterAddB;
	private TheaterAddPanel theaterAddPanel;
	private JButton theaterUpdateB;
	private TheaterUpdatePanel theaterUpdatePanel;
	private JButton theaterDeleteB;
	private TheaterDeletePanel theaterDeletePanel;

	/**
	 * Create the panel.
	 */
	public TheaterManegementPanel() {
		setLayout(new GridLayout(1, 0, 0, 0));
		
		cardParentPanel = new JPanel();
		add(cardParentPanel);
		cardParentPanel.setLayout(new CardLayout(0, 0));
		
		theaterButtonPanel = new JPanel();
		cardParentPanel.add(theaterButtonPanel, "theaterButtonP");
		theaterButtonPanel.setLayout(new GridLayout(4, 0, 0, 0));
		
		JButton theaterListB = new JButton("\uADF9\uC7A5\uB9AC\uC2A4\uD2B8");
		theaterListB.setFont(new Font("³ª´®°íµñÄÚµù", Font.BOLD, 14));
		theaterListB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					theaterListPanel.theaterJTable();
					CardLayout cl = (CardLayout)cardParentPanel.getLayout();
					cl.show(cardParentPanel, "theaterList");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			
		});
		theaterButtonPanel.add(theaterListB);
		
		theaterAddB = new JButton("\uADF9\uC7A5\uCD94\uAC00");
		theaterAddB.setFont(new Font("³ª´®°íµñÄÚµù", Font.BOLD, 14));
		theaterAddB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)cardParentPanel.getLayout();
				cl.show(cardParentPanel, "theaterAdd");
			}
		});
		theaterButtonPanel.add(theaterAddB);
		
		theaterUpdateB = new JButton("\uADF9\uC7A5\uC218\uC815");
		theaterUpdateB.setFont(new Font("³ª´®°íµñÄÚµù", Font.BOLD, 14));
		theaterUpdateB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)cardParentPanel.getLayout();
				cl.show(cardParentPanel, "theaterUpdate");
			}
		});
		theaterButtonPanel.add(theaterUpdateB);
		
		theaterDeleteB = new JButton("\uADF9\uC7A5\uC0AD\uC81C");
		theaterDeleteB.setFont(new Font("³ª´®°íµñÄÚµù", Font.BOLD, 14));
		theaterDeleteB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CardLayout cl = (CardLayout)cardParentPanel.getLayout();
					cl.show(cardParentPanel, "theaterDelete");
					theaterListPanel.theaterJTable();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		theaterButtonPanel.add(theaterDeleteB);
		
		theaterListPanel = new TheaterListPanel();
		theaterListPanel.setTheaterPanel(this);
		cardParentPanel.add(theaterListPanel, "theaterList");
		
		theaterAddPanel = new TheaterAddPanel();
		theaterAddPanel.setTheaterPanel(this);
		cardParentPanel.add(theaterAddPanel, "theaterAdd");
		
		theaterUpdatePanel = new TheaterUpdatePanel();
		theaterUpdatePanel.setTheaterPanel(this);
		cardParentPanel.add(theaterUpdatePanel, "theaterUpdate");
		
		theaterDeletePanel = new TheaterDeletePanel();
		theaterDeletePanel.setTheaterPanel(this);
		cardParentPanel.add(theaterDeletePanel, "theaterDelete");

	}
	
	public void changePanel(String string) {
		CardLayout cl = (CardLayout)cardParentPanel.getLayout();
		cl.show(cardParentPanel, string);
	}
	

}//end class


