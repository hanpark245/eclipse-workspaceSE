package ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import movie.MovieService;
import movie.MovieVo;
import seat.SeatService;
import seat.SeatVo;
import theater.TheaterService;

public class MovieInsertPanel extends JPanel {
	/****** MovieService 멤버변수선언 ********/
	MovieService movieservie;
	TheaterService theaterService;
	SeatService seatService;
	/****************************************/
	private JTextField movieNameTF;
	private JTextField movieGenreTF;
	private JTextField limitAgeTF;
	private JTextField theaterAreaTF;
	private JTextField screenTheaterTF;
	private JTextField screenAreaTF;
	private JTextField screenTimeTF;
	private JTextField feeTF;
	MovieManegementPanel mmpn;
	private JTextField screenDateTF;
	

	/**
	 * Create the panel.
	 */
	public MovieInsertPanel() {
		/******MovieService 멤버객체생성********/
	 try {
		movieservie = new  MovieService();
		theaterService = new TheaterService();
		seatService = new SeatService();	
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel label_1 = new JLabel("\uC601\uD654\uCD94\uAC00");
		panel_1.add(label_1, BorderLayout.WEST);
		label_1.setFont(new Font("Dialog", Font.PLAIN, 30));
		
		JButton btnRefresh = new JButton("\uC0C8\uB85C\uACE0\uCE68");
		panel_1.add(btnRefresh, BorderLayout.EAST);
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetForm();
			}
		});
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(10, 0, 0, 0));
		
		JLabel MovieTitleL = new JLabel("\uC601\uD654\uC81C\uBAA9");
		panel.add(MovieTitleL);
		
		movieNameTF = new JTextField();
		panel.add(movieNameTF);
		movieNameTF.setColumns(10);
		
		JLabel label = new JLabel("\uC601\uD654\uC7A5\uB974");
		panel.add(label);
		
		movieGenreTF = new JTextField();
		panel.add(movieGenreTF);
		movieGenreTF.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\uAD00\uB78C\uB4F1\uAE09");
		panel.add(lblNewLabel);
		
		limitAgeTF = new JTextField();
		panel.add(limitAgeTF);
		limitAgeTF.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\uADF9\uC7A5\uC9C0\uC5ED");
		panel.add(lblNewLabel_1);
		
		theaterAreaTF = new JTextField();
		panel.add(theaterAreaTF);
		theaterAreaTF.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\uADF9\uC7A5\uC774\uB984");
		panel.add(lblNewLabel_2);
		
		screenTheaterTF = new JTextField();
		panel.add(screenTheaterTF);
		screenTheaterTF.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\uC0C1\uC601\uC2DC\uAC04");
		panel.add(lblNewLabel_5);
		
		screenAreaTF = new JTextField();
		panel.add(screenAreaTF);
		screenAreaTF.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\uC0C1\uC601\uAD00\uBC88\uD638");
		panel.add(lblNewLabel_3);
		
		screenTimeTF = new JTextField();
		panel.add(screenTimeTF);
		screenTimeTF.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\uC601\uD654\uAC00\uACA9");
		panel.add(lblNewLabel_4);
		
		feeTF = new JTextField();
		panel.add(feeTF);
		feeTF.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("\uC0C1\uC601\uB0A0\uC9DC");
		panel.add(lblNewLabel_6);
		
		screenDateTF = new JTextField();
		panel.add(screenDateTF);
		screenDateTF.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton insertB = new JButton("\uB4F1\uB85D");
		panel_2.add(insertB);
		
		JButton btnNewButton = new JButton("\uC601\uD654\uB9AC\uC2A4\uD2B8");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetForm();
				mmpn.changePannel("movielist");
			}
		});
		panel_2.add(btnNewButton);
		
		JButton cancleB = new JButton("\uCDE8\uC18C");
		panel_2.add(cancleB);
		cancleB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetForm();
				mmpn.changePannel("moviemanager");
			}
			});
		insertB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertMovie();
				
			}
		});

		
		
		
	}
	/************화면 초기화***********/
	private void resetForm() {
		movieNameTF.setText("");
		 movieGenreTF.setText("");
		 limitAgeTF.setText("");
		 theaterAreaTF.setText("");
		 screenTheaterTF.setText("");
	screenAreaTF.setText("");
		 screenTimeTF.setText("");
		feeTF.setText("");
		screenDateTF.setText("");
	}
	/************영화 등록***********/
	private void insertMovie() {
		
		String movieName= movieNameTF.getText();
		String movieGenre= movieGenreTF.getText();
		String limitAge=limitAgeTF.getText();
		String theaterCity = theaterAreaTF.getText();
		String theaterName=screenTheaterTF.getText();
		String screenDate= screenDateTF.getText();
		String screenAreaNum=screenAreaTF.getText();
		String screenTime= screenTimeTF.getText();
		String fee=feeTF.getText();
	
	
	MovieVo addmovie = 
			new MovieVo(movieName, movieGenre, Integer.parseInt(limitAge),theaterCity,theaterName,screenDate,Integer.parseInt(screenTime),Integer.parseInt(screenAreaNum), Integer.parseInt(fee));
	System.out.println(addmovie);
	try {
		int seatTotNum = theaterService.findSeatTotNumByTheaterNumber(
				theaterService.findTheaterNumberByCityTheater(addmovie.getTheaterCity(), addmovie.getTheaterName()));
		SeatVo addSeat = 
				new SeatVo(addmovie.getTheaterCity(),
						addmovie.getTheaterName(),
						addmovie.getScreenDate(),
						addmovie.getScreenAreaNum(),
						addmovie.getScreenTime(),
						new boolean[seatTotNum]);
		movieservie.movieRegister(addmovie);
		seatService.seatListInfoRegister(addSeat);
		JOptionPane.showMessageDialog(null, "영화 등록 성공", "", JOptionPane.INFORMATION_MESSAGE);
		resetForm();
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
}

	

	public void setmovieMPanel(MovieManegementPanel movieManegementPanel) {
	this.mmpn=movieManegementPanel;
		
	}
}

