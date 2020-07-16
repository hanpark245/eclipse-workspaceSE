package member.ui;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class HSMLoginPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public HSMLoginPanel() {
		
	
		
		JLabel lblNewLabel = new JLabel("New label");
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("C:\\\\Users\\\\stu05\\\\eclipse-workspace\\\\HMS\\\\HSM 사진\\\\eric-mills-6ysUHAgX8tY-unsplash.jpg"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		Image dimg = img.getScaledInstance(687, 472, Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(dimg);
		lblNewLabel.setIcon(imageIcon);
		
		
	}

}
