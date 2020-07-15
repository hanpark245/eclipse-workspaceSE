package ui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import movie.MovieService;
import java.awt.BorderLayout;

public class MemberScreenNumTimePanel extends JPanel {
	
	MemberServiceJFrameMain mainFrame;
	MovieService movieService;
	JPanel[] panel;
	JLabel[] screenNum;
	private JPanel screenNumTimeListPanel;
	ArrayList<JButton> buttonList = new ArrayList<JButton>();
	JButton tempButton = new JButton();
	private int sNumber;
	private int sTime;
	/**
	 * Create the panel.
	 */
	public MemberScreenNumTimePanel(MemberServiceJFrameMain mainFrame) throws Exception{
		movieService = new MovieService();
		
		this.mainFrame = mainFrame;
		setLayout(new BorderLayout(0, 0));
		
		screenNumTimeListPanel = new JPanel();
		add(screenNumTimeListPanel);
		screenNumTimeListPanel.setLayout(new GridLayout(0,1));
		
		screenNumPaint();
		
	}

	
	
	private void screenNumPaint()  throws Exception{
			screenNum = new JLabel[movieService.findscreenNumListByMovieAndCityAndTheaterAndDate(
					mainFrame.getSelectedMovieName(),
					mainFrame.getSelectedCity(),
					mainFrame.getSelectedTheater(),
					mainFrame.getSelectedDate()).length];
			panel = new JPanel[movieService.findscreenNumListByMovieAndCityAndTheaterAndDate(
					mainFrame.getSelectedMovieName(),
					mainFrame.getSelectedCity(),
					mainFrame.getSelectedTheater(),
					mainFrame.getSelectedDate()).length];
			
			for (int i = 0; i < panel.length; i++) {

				final int indexScreenNumber = i;
				screenNum[i] = new JLabel(movieService.findscreenNumListByMovieAndCityAndTheaterAndDate(
						mainFrame.getSelectedMovieName(),
						mainFrame.getSelectedCity(),
						mainFrame.getSelectedTheater(),
						mainFrame.getSelectedDate())[i] + "�󿵰�");
				screenNumTimeListPanel.add(screenNum[i]);
				panel[i] = new JPanel();
				screenNumTimeListPanel.add(panel[i]);
				panel[i].setLayout(new FlowLayout());
				JButton[] screenTime = new JButton[movieService.findscreenTimeListByMovieAndCityAndTheaterAndDateAndScreenNum(
						mainFrame.getSelectedMovieName(),
						mainFrame.getSelectedCity(),
						mainFrame.getSelectedTheater(),
						mainFrame.getSelectedDate(),
						(movieService.findscreenNumListByMovieAndCityAndTheaterAndDate(
						mainFrame.getSelectedMovieName(),
						mainFrame.getSelectedCity(),
						mainFrame.getSelectedTheater(),
						mainFrame.getSelectedDate())[i])).length];
				
				for (int j = 0; j < screenTime.length; j++) {
					
					screenTime[j] = new JButton(movieService.findscreenTimeListByMovieAndCityAndTheaterAndDateAndScreenNum(
							mainFrame.getSelectedMovieName(),
							mainFrame.getSelectedCity(),
							mainFrame.getSelectedTheater(),
							mainFrame.getSelectedDate(),
							(movieService.findscreenNumListByMovieAndCityAndTheaterAndDate(
							mainFrame.getSelectedMovieName(),
							mainFrame.getSelectedCity(),
							mainFrame.getSelectedTheater(),
							mainFrame.getSelectedDate())[indexScreenNumber]))[j] + " : 00");
							panel[i].add(screenTime[j]);
							buttonList.add(screenTime[j]);
				}
				for (int j = 0; j < screenTime.length; j++) {
					final int indexScreenTime = j;
					screenTime[j].addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							try {
								for (int k = 0; k < buttonList.size(); k++) {
									buttonList.get(k).setBackground(tempButton.getBackground());
								}
								sNumber = movieService.findscreenNumListByMovieAndCityAndTheaterAndDate(
										mainFrame.getSelectedMovieName(),
										mainFrame.getSelectedCity(),
										mainFrame.getSelectedTheater(),
										mainFrame.getSelectedDate())[indexScreenNumber];
								sTime = movieService.findscreenTimeListByMovieAndCityAndTheaterAndDateAndScreenNum(
										mainFrame.getSelectedMovieName(),
										mainFrame.getSelectedCity(),
										mainFrame.getSelectedTheater(),
										mainFrame.getSelectedDate(),
										(movieService.findscreenNumListByMovieAndCityAndTheaterAndDate(
										mainFrame.getSelectedMovieName(),
										mainFrame.getSelectedCity(),
										mainFrame.getSelectedTheater(),
										mainFrame.getSelectedDate())[indexScreenNumber]))[indexScreenTime];
								screenTime[indexScreenTime].setBackground(Color.RED);
								mainFrame.setSelectedScreenNum(sNumber);
								mainFrame.setSelectedScreenTime(sTime);
								System.out.println("��ȭ���� : " + mainFrame.getSelectedMovieName());
								System.out.println("��ȭ�� : " + mainFrame.getSelectedCity()+" " + mainFrame.getSelectedTheater());
								System.out.println("�󿵳�¥ : " + mainFrame.getSelectedDate());
								System.out.println("�󿵰��ѹ� : " + mainFrame.getSelectedScreenNum() + "�󿵰�");
								System.out.println("�󿵽ð� : " + mainFrame.getSelectedScreenTime() + " : 00");
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					});
				}
			}
						
				
				
	}
}
