package ui;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JScrollPane;

import movie.MovieService;
import theater.TheaterService;

public class MemberTheaterFirstPanel extends JPanel {
	MovieService movieService;
	TheaterService theaterService;
	Calendar cal = Calendar.getInstance();
	MemberServiceJFrameMain mainFrame;
	private JScrollPane scrollPane_2;
	private JScrollPane scrollPane_1;
	private JPanel MovieCalendarPanel;
	private JPanel MovieListPanel;
	JButton[] movieList;
	JLabel[] cityNameList;
	JButton tempButton = new JButton();
	JPanel[] cityListPanel;
	ArrayList<JButton> buttonList = new ArrayList<JButton>();
	private JPanel TheaterListPanel;
	/**
	 * Create the panel.
	 */
	public MemberTheaterFirstPanel(MemberServiceJFrameMain mainFrame) throws Exception{
		this.mainFrame = mainFrame;
		movieService = new MovieService();
		theaterService = new TheaterService();
		setBackground(Color.WHITE);
		setLayout(new GridLayout(1, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);
		
		TheaterListPanel = new JPanel();
		scrollPane.setViewportView(TheaterListPanel);
		GridLayout gl_TheaterListPanel = new GridLayout(20, 1);
		gl_TheaterListPanel.setVgap(10);
		gl_TheaterListPanel.setHgap(10);
		TheaterListPanel.setLayout(gl_TheaterListPanel);
		
		MovieCalendarPanel = new JPanel();
		add(MovieCalendarPanel);
		MovieCalendarPanel.setLayout(new GridLayout(0, 1));
		theaterDisplay();
		
		
		

	}

	public void theaterDisplay() throws Exception {
		cityListPanel = new JPanel[theaterService.findCityList().length];
		cityNameList = new JLabel[theaterService.findCityList().length];
		for (int i = 0; i < cityListPanel.length; i++) {
			cityListPanel[i] = new JPanel();
			cityListPanel[i].setLayout(new FlowLayout());
			cityNameList[i] = new JLabel(theaterService.findCityList()[i]);
			final int indexCity = i;
			TheaterListPanel.add(cityNameList[i]);
			TheaterListPanel.add(cityListPanel[i]);
			JButton[] theaterNameList = new JButton[theaterService
					.findTheaterListByCity(theaterService.findCityList()[i]).length];

			for (int j = 0; j < theaterNameList.length; j++) {
				theaterNameList[j] = new JButton(
						theaterService.findTheaterListByCity(theaterService.findCityList()[i])[j]);
				buttonList.add(theaterNameList[j]);
				cityListPanel[i].add(theaterNameList[j]);

			}

			for (int j = 0; j < theaterNameList.length; j++) {
				final int indexTheater = j;
				theaterNameList[j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							for (int k = 0; k < buttonList.size(); k++) {
								buttonList.get(k).setBackground(tempButton.getBackground());
							}
							mainFrame.setSelectedCity(cityNameList[indexCity].getText());
							mainFrame.setSelectedTheater(theaterNameList[indexTheater].getText());
							theaterNameList[indexTheater].setBackground(Color.RED);
							MovieCalendarPanel.removeAll();
							movieDisplay();
													
						} catch (Exception e1) {
							e1.printStackTrace();
							throw new RuntimeException(e1.getMessage());
						}
						
					}
				});
			}
			
		}	
	}
	public void movieDisplay() throws Exception{
		if(scrollPane_1!=null) {
			MovieCalendarPanel.remove(scrollPane_1);
		}
		scrollPane_1 = new JScrollPane();
		MovieCalendarPanel.add(scrollPane_1);
		MovieListPanel = new JPanel();
		scrollPane_1.setViewportView(MovieListPanel);
		GridLayout gl_MovieListPanel = new GridLayout(20, 1);
		gl_MovieListPanel.setVgap(10);
		gl_MovieListPanel.setHgap(10);
		MovieListPanel.setLayout(gl_MovieListPanel);
		movieList = new JButton[movieService.findMovieListByTheaterAndCity(
				mainFrame.getSelectedCity(),
				mainFrame.getSelectedTheater()).length];
		for (int i = 0; i < movieList.length; i++) {
			movieList[i] = new JButton(movieService.findMovieListByTheaterAndCity(
					mainFrame.getSelectedCity(),
					mainFrame.getSelectedTheater())[i]);
			MovieListPanel.add(movieList[i]);
			final int index = i;
			tempButton = new JButton();
			movieList[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						for (int j = 0; j < movieList.length; j++) {
							movieList[j].setBackground(tempButton.getBackground());
						}
						mainFrame.setSelectedMovieName(movieList[index].getText());
						movieList[index].setBackground(Color.RED);
						calendarDisplay();	
					} catch (Exception e1) {
						e1.printStackTrace();
						throw new RuntimeException(e1.getMessage());
					}
				}
			});
		}
		MovieCalendarPanel.validate();
		MovieCalendarPanel.repaint();	
	}
	public void calendarDisplay() throws Exception {
		if(scrollPane_2!=null) {
			MovieCalendarPanel.remove(scrollPane_2);
		}
		scrollPane_2 = new JScrollPane();
		MovieCalendarPanel.add(scrollPane_2);
		CalendarPanel calendarPanel = new CalendarPanel();
		scrollPane_2.setViewportView(calendarPanel);
		JButton tempButton[] = calendarPanel.getDateButton();
		for (int i = 0; i < tempButton.length; i++) {
			tempButton[i].setEnabled(false);
		}
		String[] screendateList = movieService.screenDateListByMovieAndCityAndTheater(
				mainFrame.getSelectedMovieName(), 
				mainFrame.getSelectedCity(),
				mainFrame.getSelectedTheater());
		for (int i = 0; i < screendateList.length; i++) {
			String[] valueDate = screendateList[i].split("/");
			for (int j = 0; j < tempButton.length; j++) {
				if(tempButton[j].getText().equals(valueDate[1]))
					tempButton[j].setEnabled(true);
			}
		}
		for (int i = 0; i < tempButton.length; i++) {
			final int indexDate = i;
			tempButton[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mainFrame.setSelectedDate(Integer.toString(cal.getActualMaximum(Calendar.MONTH)+1)+"/"+tempButton[indexDate].getText());
					System.out.println("영화제목 : " + mainFrame.getSelectedMovieName());
					System.out.println("영화관 : " + mainFrame.getSelectedCity()+" " + mainFrame.getSelectedTheater());
					System.out.println("상영날짜 : " + mainFrame.getSelectedDate());
				}
			});
		}
		
		MovieCalendarPanel.validate();
		MovieCalendarPanel.repaint();	
	}
}
