package ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.table.DefaultTableModel;

import theater.TheaterService;
import theater.TheaterVo;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

public class TheaterListPanel extends JPanel {
	TheaterService theaterService;

	ArrayList<TheaterVo> theaterList;

	private TheaterManegementPanel tmPanel;

	private JTable table;
	public JTable getTable() {
		return table;
	}

	DefaultTableModel tableModel;

	/**
	 * Create the panel.
	 */
	public TheaterListPanel() {
		try {
			theaterService = new TheaterService();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		setLayout(new BorderLayout(0, 0));

		JPanel titlePanel = new JPanel();
		add(titlePanel, BorderLayout.NORTH);
		titlePanel.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblNewLabel = new JLabel("\uADF9\uC7A5\uB9AC\uC2A4\uD2B8");
		lblNewLabel.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 24));
		titlePanel.add(lblNewLabel);

		JPanel buttonPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) buttonPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		add(buttonPanel, BorderLayout.SOUTH);

		

		JButton cancelB = new JButton("\uCDE8\uC18C");
		cancelB.setFont(new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 12));
		cancelB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tmPanel.changePanel("theaterButtonP");
			}
		});
		buttonPanel.add(cancelB);

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		scrollPane.setViewportView(table);

	}

	public void theaterJTable() throws Exception {
		Vector columnNames = new Vector();
		columnNames.add("¹øÈ£");
		columnNames.add("±ØÀåÀÌ¸§");
		columnNames.add("±ØÀåÁö¿ª");
		columnNames.add("»ó¿µ°ü ¼ö");
		columnNames.add("ÁÂ¼® ¼ö");

		Vector data = new Vector();
		this.theaterList = theaterService.findAllTheater();
		for (TheaterVo theater : theaterList) {
			Vector rowVector = new Vector();
			rowVector.add(theater.getTheaterNumber());
			rowVector.add(theater.getTheaterName());
			rowVector.add(theater.getTheaterCity());
			rowVector.add(theater.getScreenAreaNum());
			rowVector.add(theater.getSeatTotNum());

			data.add(rowVector);

		}
		tableModel = new DefaultTableModel(data, columnNames);
		
		table.setModel(tableModel);

	}

	public void setTheaterPanel(TheaterManegementPanel theaterManegementPanel) {
		this.tmPanel = theaterManegementPanel;
	}
	
	
	
}