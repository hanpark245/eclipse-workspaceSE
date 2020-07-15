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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MovieDeletePanel extends JPanel {
	/****** Movie Service 멤버변수선언 ********/
	MovieService movieService;
	/****************************************/
	private JTable movieTB;
	DefaultTableModel tableModel;
	MovieManegementPanel mmpn;
	private JTextField movieNumberTF;

	/**
	 * Create the panel.
	 */
	public MovieDeletePanel() {

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
		movieTB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int selectedRow=movieTB.getSelectedRow();
					ArrayList<MovieVo> movieList = movieService.findMovieByAll();
					MovieVo movie = (MovieVo)movieList.get(selectedRow);
					movieNumberTF.setText(movie.getMovieNumber()+"");
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		movieTB.setBounds(0, 0, 1, 1);
		scrollPane.setViewportView(movieTB);

		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton cancleB = new JButton("\uCDE8\uC18C");
		cancleB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				movieJTable();
				movieNumberTF.setText("");
				mmpn.changePannel("moviemanager");
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton deleteB = new JButton("\uC0AD\uC81C");
		deleteB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();

			}
		});
		
		JLabel deleteMovieLabel = new JLabel("\uC0AD\uC81C\uD560 \uC601\uD654\uBC88\uD638");
		panel.add(deleteMovieLabel);

		movieNumberTF = new JTextField();
		panel.add(movieNumberTF);
		movieNumberTF.setColumns(10);
		movieNumberTF.setEditable(false);
		panel.add(deleteB);
		panel.add(cancleB);

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BorderLayout(0, 0));

		JLabel label = new JLabel("\uC601\uD654\uC0AD\uC81C");
		panel_1.add(label, BorderLayout.WEST);
		label.setFont(new Font("Dialog", Font.PLAIN, 30));

		JButton button = new JButton("\uC0C8\uB85C\uACE0\uCE68");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					movieJTable();
					movieNumberTF.setText("");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel_1.add(button, BorderLayout.EAST);

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
			rowVector.add(movie.getTheaterCity());
			rowVector.add(movie.getTheaterName());
			rowVector.add(movie.getScreenAreaNum());
			rowVector.add(movie.getScreenTime());
			rowVector.add(movie.getFee());
			data.add(rowVector);
		}

		tableModel = new DefaultTableModel(data, columnNames);
		movieTB.setModel(tableModel);
	}
	
	public void delete() {
		String movieNumber = movieNumberTF.getText();
		if(movieNumber.equals("")) {
			JOptionPane.showMessageDialog(null, "삭제할 영화를 선택하세요.", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			try {
				ArrayList<MovieVo> movieList = movieService.findMovieByAll();
				for (int i = 0; i < movieList.size(); i++) {
					if(movieList.get(i).getMovieNumber() == Integer.parseInt(movieNumber)) {
						try {
							movieService.movieDelete(Integer.parseInt(movieNumber));
							movieJTable();
						} catch (Exception e) {
							e.printStackTrace();
						}
					} 
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
		
	}

	public void setmovieMPanel(MovieManegementPanel moviemanagementPanel) {
		this.mmpn = moviemanagementPanel;

	}

}
