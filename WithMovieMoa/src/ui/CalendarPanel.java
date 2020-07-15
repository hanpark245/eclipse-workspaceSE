package ui;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalendarPanel extends JPanel {
	
	Calendar cal = Calendar.getInstance();
	
	String[] dayName = {"ÀÏ", "¿ù", "È­", "¼ö", "¸ñ", "±Ý", "Åä"};
	 JButton[] dayButton = new JButton[dayName.length];
	JButton[] dateButton;
	JButton tempButton = new JButton();
	
	
	public JButton[] getDateButton() {
		return dateButton;
	}


	/**
	 * Create the panel.
	 */
	public CalendarPanel() {
		setLayout(new BorderLayout(0, 0));
		/*
		 * yearLabel = new JLabel(" "+Integer.toString(yearData)+" ³â ");
		  yearLabel.setFont(new Font("°íµñ", Font.BOLD, 20));
		  monthLabel = new JLabel(Integer.toString(monthData)+" ¿ù ");
		  monthLabel.setFont(new Font("°íµñ", Font.BOLD, 20));
		 */
		JPanel titlePanel = new JPanel();
		add(titlePanel, BorderLayout.NORTH);
		
		JLabel yearLabel = new JLabel(Integer.toString(cal.get(Calendar.YEAR))+"³â ");
		yearLabel.setFont(new Font("°íµñ", Font.BOLD, 20));
		titlePanel.add(yearLabel);
		
		JLabel monthLabel = new JLabel(Integer.toString(cal.get(Calendar.MONTH)+1)+"¿ù");
		monthLabel.setFont(new Font("°íµñ", Font.BOLD, 20));
		titlePanel.add(monthLabel);
		
		JPanel datePanel = new JPanel();
		add(datePanel, BorderLayout.CENTER);
		datePanel.setLayout(new GridLayout(0, 7));
		
		for(int i=0; i<dayButton.length; i++) {
			  dayButton[i] = new JButton(dayName[i]);
			  dayButton[i].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
			  
			  if(i == 0) {
				  dayButton[i].setForeground(Color.RED);
			  } else if(i == 6) {
				  dayButton[i].setForeground(Color.BLUE);
			  }
			  
			  datePanel.add(dayButton[i]);
		  }
		
		int START_DAY_OF_WEEK = 0;
		   int END_DAY = 0;
		   
		   Calendar sDay = Calendar.getInstance();
		   Calendar eDay = Calendar.getInstance();

		   sDay.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)-1, 1);
		   eDay.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1);

		   eDay.add(Calendar.DATE, -1);
		     
		   START_DAY_OF_WEEK = sDay.get(Calendar.DAY_OF_WEEK);
		   END_DAY = eDay.get(Calendar.DATE);
		   dateButton = new JButton[END_DAY];
		   
		   for(int i=1; i<START_DAY_OF_WEEK; i++) {
		    JLabel emptyLabel = new JLabel(" ");
		    emptyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		    datePanel.add(emptyLabel);
		   }
		   
		   for(int i=0; i<END_DAY; i++) {
			   if(i+1<10)
				   dateButton[i] = new JButton("0"+Integer.toString(i+1));
			   else
				   dateButton[i] = new JButton(Integer.toString(i+1));
		    dateButton[i].setHorizontalAlignment(SwingConstants.CENTER);
		    dateButton[i].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		    datePanel.add(dateButton[i]);
		    if(Integer.parseInt(dateButton[i].getText())<cal.get(Calendar.DATE))
		    	dateButton[i].setEnabled(false);
		    final int index = i;
		    dateButton[i].addActionListener(new ActionListener() {				
				@Override
				public void actionPerformed(ActionEvent e) {
					for (int j = 0; j < dateButton.length; j++) {
						dateButton[j].setBackground(tempButton.getBackground());
					}
					dateButton[index].setBackground(Color.RED);
					
				}
			});
		  }
		
		
	}

}
