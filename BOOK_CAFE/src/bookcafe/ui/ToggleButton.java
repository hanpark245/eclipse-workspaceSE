package bookcafe.ui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;

public class ToggleButton extends JButton{
	boolean status=false;
	public ToggleButton() {
		// TODO Auto-generated constructor stub
	}
	public ToggleButton(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if(status){
			setBackground(Color.GRAY);
		}else{
			setBackground(Color.LIGHT_GRAY);
		}
	}
	
}
