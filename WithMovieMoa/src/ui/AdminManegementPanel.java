package ui;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.lang.reflect.Member;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class AdminManegementPanel extends JPanel {

	MemberServiceJFrameMain mainFrame;
	
	/**
	 * Create the panel.
	 */
	public AdminManegementPanel(MemberServiceJFrameMain mainFrame) {
		this.mainFrame = mainFrame;
		setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		add(tabbedPane, BorderLayout.CENTER);
		
		MemberManegementPanel memberManegementPanel = new MemberManegementPanel();
		tabbedPane.addTab("\uD68C\uC6D0\uAD00\uB9AC", null, memberManegementPanel, null);
		
		MovieManegementPanel movieManegementPanel = new MovieManegementPanel();
		tabbedPane.addTab("\uC601\uD654\uAD00\uB9AC", null, movieManegementPanel, null);
		
		TheaterManegementPanel theaterManegementPanel = new TheaterManegementPanel();
		tabbedPane.addTab("\uADF9\uC7A5\uAD00\uB9AC", null, theaterManegementPanel, null);
		
		

	}

}
