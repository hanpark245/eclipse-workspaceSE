package ui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import movie.MovieService;
import theater.TheaterService;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;

public class MemberMovieFirstPanel extends JPanel {

	MovieService movieService;
	TheaterService theaterService;
	MemberServiceJFrameMain mainFrame;
	Calendar cal = Calendar.getInstance();
	
	JButton[] movieList;
	JLabel[] cityNameList;
	JButton tempButton;
	JPanel[] cityListPanel;
	ArrayList<JButton> buttonList = new ArrayList<JButton>();
	private JPanel TheaterListPanel;
	private JPanel TheaterCalendarPanel;
	JScrollPane scrollPane_1;
	JScrollPane scrollPane_2;
	private JPanel MovieListPanel;

	/**
	 * Create the panel.
	 * 
	 * @throws Exception
	 */
	public MemberMovieFirstPanel(MemberServiceJFrameMain mainFrame) throws Exception {
		this.mainFrame = mainFrame;
		movieService = new MovieService();
		theaterService = new TheaterService();
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);

		MovieListPanel = new JPanel();
		scrollPane.setViewportView(MovieListPanel);
		GridLayout gl_MovieListPanel = new GridLayout(20, 1);
		gl_MovieListPanel.setVgap(10);
		gl_MovieListPanel.setHgap(10);
		MovieListPanel.setLayout(gl_MovieListPanel);

		TheaterCalendarPanel = new JPanel();
		add(TheaterCalendarPanel);
		TheaterCalendarPanel.setLayout(new GridLayout(0, 1));
		movieDisplay();
		
	}


	private void movieDisplay() throws Exception {
		movieList = new JButton[movieService.findMovieListByName().length];
		for (int i = 0; i < movieList.length; i++) {
			movieList[i] = new JButton(movieService.findMovieListByName()[i]);
			MovieListPanel.add(movieList[i]);
			final int index = i;
			tempButton = new JButton();
			movieList[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						for (int j = 0; j < movieList.length; j++) {
							movieList[j].setBackground(tempButton.getBackground());
						}
						System.out.println(movieList[index].getText());
						mainFrame.setSelectedMovieName(movieList[index].getText());
						movieList[index].setBackground(Color.RED);
						TheaterCalendarPanel.removeAll();
						theaterDisplay();
						
					} catch (Exception e1) {
						e1.printStackTrace();
						throw new RuntimeException(e1.getMessage());
					}
				}
			});
		}
	}
	private void theaterDisplay()  throws Exception{
		
		if(scrollPane_1!=null) {
			TheaterCalendarPanel.remove(scrollPane_1);
		}
		scrollPane_1 = new JScrollPane();
		TheaterCalendarPanel.add(scrollPane_1);
		TheaterListPanel = new JPanel();
		scrollPane_1.setViewportView(TheaterListPanel);
		TheaterListPanel.setLayout(new GridLayout(0, 1));
		
		cityListPanel = new JPanel[movieService.findCityListByMovieName(mainFrame.getSelectedMovieName()).length];
		cityNameList = new JLabel[movieService.findCityListByMovieName(mainFrame.getSelectedMovieName()).length];
		for (int i = 0; i < cityListPanel.length; i++) {
			cityListPanel[i] = new JPanel();
			cityListPanel[i].setLayout(new FlowLayout());
			cityNameList[i] = new JLabel(movieService.findCityListByMovieName(mainFrame.getSelectedMovieName())[i]);
			final int indexCity = i;
			TheaterListPanel.add(cityNameList[i]);
			TheaterListPanel.add(cityListPanel[i]);
			JButton[] theaterNameList = new JButton[movieService.findTheaterListByCityAndMovieName(
					mainFrame.getSelectedMovieName(),
					movieService.findCityListByMovieName(mainFrame.getSelectedMovieName())[i]).length];

			for (int j = 0; j < theaterNameList.length; j++) {
				theaterNameList[j] = new JButton(
						movieService.findTheaterListByCityAndMovieName(
								mainFrame.getSelectedMovieName()
								,movieService.findCityListByMovieName(mainFrame.getSelectedMovieName())[i])[j]);
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
						try {
							
							calendarDisplay();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
			}
			
		}		
		TheaterCalendarPanel.validate();
		TheaterCalendarPanel.repaint();		
	}
	
	private void calendarDisplay() throws Exception{
		if(scrollPane_2!=null) {
			TheaterCalendarPanel.remove(scrollPane_2);
		}
		scrollPane_2 = new JScrollPane();
		TheaterCalendarPanel.add(scrollPane_2);
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
		
		TheaterCalendarPanel.validate();
		TheaterCalendarPanel.repaint();	
	}
}
