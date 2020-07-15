package ui;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import movie.MovieService;
import theater.TheaterService;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

public class MemberDateFirstPanel extends JPanel {
	MovieService movieService;
	TheaterService theaterService;
	Calendar cal = Calendar.getInstance();
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JPanel MovieTheaterPanel;
	private JPanel MovieListPanel;
	private JPanel TheaterListPanel;
	JButton[] movieList;
	JLabel[] cityNameList;
	JButton tempButton = new JButton();
	JPanel[] cityListPanel;
	ArrayList<JButton> buttonList = new ArrayList<JButton>();
	MemberServiceJFrameMain mainFrame;
	private CalendarPanel calendarPanel;
	/**
	 * Create the panel.
	 */
	public MemberDateFirstPanel(MemberServiceJFrameMain mainFrame) throws Exception{
		this.mainFrame = mainFrame;
		movieService = new MovieService();
		theaterService = new TheaterService();
		setBackground(Color.WHITE);
		setLayout(new GridLayout(1, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);
		
		calendarPanel = new CalendarPanel();
		scrollPane.setViewportView(calendarPanel);
		
		MovieTheaterPanel = new JPanel();
		add(MovieTheaterPanel);
		MovieTheaterPanel.setLayout(new GridLayout(0, 1));
		calendarDisplay();
	}
	
	public void calendarDisplay() throws Exception {
		JButton tempButton[] = calendarPanel.getDateButton();
		for (int i = 0; i < tempButton.length; i++) {
			final int indexDate = i;
			tempButton[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						mainFrame.setSelectedDate(Integer.toString(cal.getActualMaximum(Calendar.MONTH)+1)+"/"+tempButton[indexDate].getText());
						MovieTheaterPanel.removeAll();
						movieDisplay();
					} catch (Exception e1) {
						e1.printStackTrace();
						throw new RuntimeException(e1.getMessage());
					}
				}
			});
		}
	}
	public void movieDisplay() throws Exception{
		if(scrollPane_1!=null) {
			MovieTheaterPanel.remove(scrollPane_1);
		}
		scrollPane_1 = new JScrollPane();
		MovieTheaterPanel.add(scrollPane_1);
		MovieListPanel = new JPanel();
		scrollPane_1.setViewportView(MovieListPanel);
		GridLayout gl_MovieListPanel = new GridLayout(20, 1);
		gl_MovieListPanel.setVgap(10);
		gl_MovieListPanel.setHgap(10);
		MovieListPanel.setLayout(gl_MovieListPanel);
		movieList = new JButton[movieService.findMovieListByDate(mainFrame.getSelectedDate()).length];
		for (int i = 0; i < movieList.length; i++) {
			movieList[i] = new JButton(movieService.findMovieListByDate(mainFrame.getSelectedDate())[i]);
			MovieListPanel.add(movieList[i]);
			final int index = i;
			tempButton = new JButton();
			movieList[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						for (int j = 0; j < movieList.length; j++) {
							movieList[j].setBackground(tempButton.getBackground());
						}
						mainFrame.setSelectedMovieName(movieList[index].getText());
						movieList[index].setBackground(Color.RED);
						try {
							theaterDisplay();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}
			});
		}
		MovieTheaterPanel.validate();
		MovieTheaterPanel.repaint();	
	}
	
	private void theaterDisplay()  throws Exception{
		
		if(scrollPane_2!=null) {
			MovieTheaterPanel.remove(scrollPane_2);
		}
		scrollPane_2 = new JScrollPane();
		MovieTheaterPanel.add(scrollPane_2);
		TheaterListPanel = new JPanel();
		scrollPane_2.setViewportView(TheaterListPanel);
		TheaterListPanel.setLayout(new GridLayout(0, 1));
		
		cityListPanel = new JPanel[movieService.findCityListByDateAndMovie(
				mainFrame.getSelectedDate(),
				mainFrame.getSelectedMovieName()).length];
		cityNameList = new JLabel[movieService.findCityListByDateAndMovie(
				mainFrame.getSelectedDate(),
				mainFrame.getSelectedMovieName()).length];
		for (int i = 0; i < cityListPanel.length; i++) {
			cityListPanel[i] = new JPanel();
			cityListPanel[i].setLayout(new FlowLayout());
			cityNameList[i] = new JLabel(movieService.findCityListByDateAndMovie(
					mainFrame.getSelectedDate(),
					mainFrame.getSelectedMovieName())[i]);
			final int indexCity = i;
			TheaterListPanel.add(cityNameList[i]);
			TheaterListPanel.add(cityListPanel[i]);
			JButton[] theaterNameList = new JButton[movieService.findTheaterListByDateAndMovieAndCity
			                                        (mainFrame.getSelectedDate(),
			                                        		mainFrame.getSelectedMovieName(), 
			                                        		movieService.findCityListByDateAndMovie(
			                                        				mainFrame.getSelectedDate(),
					                                        		mainFrame.getSelectedMovieName())[i]).length];

			for (int j = 0; j < theaterNameList.length; j++) {
				theaterNameList[j] = new JButton(
						movieService.findTheaterListByDateAndMovieAndCity
                        (mainFrame.getSelectedDate(),
                        		mainFrame.getSelectedMovieName(), 
                        		movieService.findCityListByDateAndMovie(
                        				mainFrame.getSelectedDate(),
                                		mainFrame.getSelectedMovieName())[i])[j]);
				buttonList.add(theaterNameList[j]);
				cityListPanel[i].add(theaterNameList[j]);

			}

			for (int j = 0; j < theaterNameList.length; j++) {
				final int indexTheater = j;
				theaterNameList[j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						for (int k = 0; k < buttonList.size(); k++) {
							buttonList.get(k).setBackground(tempButton.getBackground());
						}
						mainFrame.setSelectedCity(cityNameList[indexCity].getText());
						mainFrame.setSelectedTheater(theaterNameList[indexTheater].getText());
						theaterNameList[indexTheater].setBackground(Color.RED);
						System.out.println("영화제목 : " + mainFrame.getSelectedMovieName());
						System.out.println("영화관 : " + mainFrame.getSelectedCity()+" " + mainFrame.getSelectedTheater());
						System.out.println("상영날짜 : " + mainFrame.getSelectedDate());
					}
				});
			}
			
		}		
		
		MovieTheaterPanel.validate();
		MovieTheaterPanel.repaint();		
	}
}
