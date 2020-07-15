package ui;


import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class MemberManegementPanel extends JPanel {
	private JPanel parentPanel;
	private MemberSearchPanel memberSearchPanel;
	private MemberListPanel memberListPanel;
	private MemberDeletePanel memberDeletePanel;
	private MemberUpdatePanel memberUpdatePanel;
	private JButton memberListB;
	private JButton memberSearchB;
	private JButton memberUpdateB;
	private JButton memberDeleteB;

	/**
	 * Create the panel.
	 */
	public MemberManegementPanel() {
		setLayout(new GridLayout(0,1));
		
		parentPanel = new JPanel();
		add(parentPanel);
		parentPanel.setLayout(new CardLayout(0, 0));
		
		JPanel buttonPanel = new JPanel();
		parentPanel.add(buttonPanel, "MemberManager");
		
		memberListB = new JButton("\uD68C\uC6D0\uB9AC\uC2A4\uD2B8");
		memberListB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)parentPanel.getLayout();
				cl.show(parentPanel, "name_131823342538210");
				
			}
		});
		buttonPanel.setLayout(new GridLayout(0, 1, 0, 0));
		buttonPanel.add(memberListB);
		
		memberUpdateB = new JButton("\uD68C\uC6D0\uC218\uC815");
		memberUpdateB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)parentPanel.getLayout();
				cl.show(parentPanel, "name_132918561867527");
				
			}
		});
		
		memberSearchB = new JButton("\uD68C\uC6D0\uAC80\uC0C9");
		memberSearchB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)parentPanel.getLayout();
				cl.show(parentPanel, "name_131783274103720");

			}
		});
		buttonPanel.add(memberSearchB);
		buttonPanel.add(memberUpdateB);
		
		memberDeleteB = new JButton("\uD68C\uC6D0\uC0AD\uC81C");
		memberDeleteB.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				
				try {
					memberListPanel.memberJTable();	
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			
		
				
			}
		});
		memberDeleteB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)parentPanel.getLayout();
				cl.show(parentPanel, "name_132927159807579");
			
			}
		});
		buttonPanel.add(memberDeleteB);
		
		memberSearchPanel = new MemberSearchPanel();
		memberSearchPanel.setMemberMPanel(this);
		parentPanel.add(memberSearchPanel, "name_131783274103720");
		
		memberListPanel = new MemberListPanel();
		memberListPanel.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				try {
					memberListPanel.memberJTable();	
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		
		});
		memberListPanel.setMemberMPanel(this);
		parentPanel.add(memberListPanel, "name_131823342538210");
		
		memberUpdatePanel = new MemberUpdatePanel();
		memberUpdatePanel.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				try {
					memberUpdatePanel.memberJTable();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		
		
		memberUpdatePanel.setMemberMPanel(this);
		parentPanel.add(memberUpdatePanel, "name_132918561867527");
		
		memberDeletePanel = new MemberDeletePanel();
		memberDeletePanel.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				try {
					memberDeletePanel.memberJTable();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		memberDeletePanel.setMemberMPanel(this);
		parentPanel.add(memberDeletePanel, "name_132927159807579");
		
		
		
		CardLayout cl = (CardLayout)parentPanel.getLayout();
		cl.show(parentPanel, "name_131862213015503");
		cl.first(parentPanel);
		
		
		
	

	}

	public void changePanel(String string) {
		CardLayout cl = (CardLayout)parentPanel.getLayout();
		cl.show(parentPanel, string);
		
	}
}
