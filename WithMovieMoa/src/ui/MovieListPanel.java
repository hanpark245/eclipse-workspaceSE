package ui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import movie.MovieService;
import movie.MovieVo;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;

public class MovieListPanel extends JPanel {
	/****** Movie Service 멤버변수선언 ********/
	MovieService movieService;
	/****************************************/
	private JTable movieTB;
	DefaultTableModel tableModel;
	MovieManegementPanel mmpn;
	private JTable movieSearchTB;

	/**
	 * Create the panel.
	 */
	public MovieListPanel() {

		/****** MovieService 멤버객체생성 ********/
		try {
			movieService = new MovieService();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		JButton btnNewButton1 = new JButton("\uB4F1\uB85D");
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton1.setBounds(87, 240, 97, 23);
		setLayout(new BorderLayout(0, 0));
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);

		movieTB = new JTable();
		movieTB.setBounds(0, 0, 1, 1);
		scrollPane.setViewportView(movieTB);

		JScrollPane scrollPane_1 = new JScrollPane();
		add(scrollPane_1, BorderLayout.WEST);

		movieSearchTB = new JTable();
		add(movieSearchTB, BorderLayout.EAST);

		JPanel titleP = new JPanel();
		add(titleP, BorderLayout.NORTH);
		titleP.setLayout(new BorderLayout(0, 0));

		JLabel label = new JLabel("\uC601\uD654\uB9AC\uC2A4\uD2B8");
		titleP.add(label, BorderLayout.WEST);
		label.setFont(new Font("Dialog", Font.PLAIN, 30));
		
		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton insertB = new JButton("\uC601\uD654\uB4F1\uB85D");
		insertB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mmpn.changePannel("movieinsert");
			}
		});
		panel_2.add(insertB);
		
		JButton deleteB = new JButton("\uC601\uD654\uC0AD\uC81C");
		deleteB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mmpn.changePannel("moviedelete");
			}
		});
		panel_2.add(deleteB);
		
		JButton cancelB = new JButton("\uCDE8\uC18C");
		cancelB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mmpn.changePannel("moviemanager");
			}
		});
		panel_2.add(cancelB);

		btnNewButton1.setBounds(167, 268, 149, 23);
	}

	/**********************************/
	public void movieJTable() throws Exception {
		Vector columnNames = new Vector();
		columnNames.add("번호");
		columnNames.add("제목");
		columnNames.add("장르");
		columnNames.add("관람등급");
		columnNames.add("극장지역");
		columnNames.add("극장이름");
		columnNames.add("상영관");
		columnNames.add("상영날짜");
		columnNames.add("상영시간");
		columnNames.add("영화가격");

		Vector data = new Vector();

		ArrayList<MovieVo> movieList = movieService.findMovieByAll();
		for (MovieVo movie : movieList) {
			Vector rowVector = new Vector();
			rowVector.add(movie.getMovieNumber());
			rowVector.add(movie.getMovieName());
			rowVector.add(movie.getMovieGenre());
			rowVector.add(movie.getLimitAge());
			rowVector.add(movie.getTheaterName());
			rowVector.add(movie.getTheaterCity());
			rowVector.add(movie.getScreenAreaNum());
			rowVector.add(movie.getScreenDate());
			rowVector.add(movie.getScreenTime());
			rowVector.add(movie.getFee());

			data.add(rowVector);
		}

		tableModel = new DefaultTableModel(data, columnNames);
		movieTB.setModel(tableModel);
	}

	public void setmovieMPanel(MovieManegementPanel moviemanagementPanel) {
		this.mmpn = moviemanagementPanel;

	}

}
