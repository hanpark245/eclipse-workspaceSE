package ui;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class MovieManegementPanel extends JPanel {

	private MovieInsertPanel movieinsertpanel;
	private MovieDeletePanel moviedeletepanel;
	
	private MovieListPanel movielistpanel;
	private JPanel parentpanel;
	private JPanel panel;
	private MovieListPanel movieListPanel;

	/**
	 * Create the panel.
	 */
	public MovieManegementPanel() {
		setLayout(new GridLayout(0, 1));

		parentpanel = new JPanel();
		add(parentpanel);
		parentpanel.setLayout(new CardLayout(0, 0));

		panel = new JPanel();
		parentpanel.add(panel, "moviemanager");
		panel.setLayout(new GridLayout(3, 0, 0, 0));

		movielistpanel = new MovieListPanel();
		movielistpanel.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				try {
					movielistpanel.movieJTable();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			@Override
			public void componentHidden(ComponentEvent arg0) {
			}
		});
		movielistpanel.setmovieMPanel(this);
		parentpanel.add(movielistpanel, "movielist");
		
		movieinsertpanel = new MovieInsertPanel();
		movieinsertpanel.setmovieMPanel(this);
		parentpanel.add(movieinsertpanel, "movieinsert");
		
		moviedeletepanel = new MovieDeletePanel();
		moviedeletepanel.setmovieMPanel(this);
		parentpanel.add(moviedeletepanel, "moviedelete");
		
	
		
	
		
	
		CardLayout cl = (CardLayout)parentpanel.getLayout();
		cl.show(parentpanel, "moviemanager");
		cl.first(parentpanel);
		

		JButton button = new JButton("\uC601\uD654\uB9AC\uC2A4\uD2B8");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) parentpanel.getLayout();
				cl.show(parentpanel, "movielist");

			}
		});
		panel.add(button);

		JButton button_1 = new JButton("\uC601\uD654\uCD94\uAC00");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CardLayout cl = (CardLayout) parentpanel.getLayout();
				cl.show(parentpanel, "movieinsert");
			}
		});
		panel.add(button_1);

		JButton button_2 = new JButton("\uC601\uD654\uC0AD\uC81C");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) parentpanel.getLayout();
				cl.show(parentpanel, "moviedelete");
			}
		});
		panel.add(button_2);
		
		
		movieListPanel = new MovieListPanel();
		parentpanel.add(movieListPanel, "movieList");

 
	}
	public void changePannel(String string) {
		CardLayout cl = (CardLayout) parentpanel.getLayout();
		cl.show(parentpanel, string);
	}

}
