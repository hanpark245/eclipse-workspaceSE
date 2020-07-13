package paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class PaintFrame extends JFrame {

	public PaintFrame() {
		setSize(300, 400);
		setVisible(true);
	}

	/*
	 * public void paint(Graphics g) 
	 * - Paints this component. 
	 * - This method is called when the contents of the component should be painted; 
	 *    such as when the component is first being shown 
	 *    or is damaged and in need of repair.
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Image backImage=
				Toolkit.getDefaultToolkit().getImage("penguin_back.jpg");
		g.drawImage(backImage,0,0,getWidth() ,getHeight(), this);
		
		/*
		 * Subclasses of Component that override this method need not call
		 * super.paint(g).
		 */
		// System.out.println("paint thread:"+Thread.currentThread().getName());
		/*
		 * << Graphics >> - 컴포넌트에 그릴수있는 펜객체
		 */
		/*
		 * 1.문자
		 */
		g.drawString("안녕 페인트!!", 80, 50);
		/*
		 * 2.라인,사각형,원
		 */
		g.setColor(Color.BLUE);
		g.drawLine(0, 80, this.getWidth(), 80);

		g.drawRect(20, 90, 50, 50);
		g.setColor(Color.PINK);
		g.fillRect(20, 150, 50, 50);

		g.drawOval(20, 210, 50, 50);
		g.setColor(Color.RED);
		g.fillOval(20, 270, 50, 50);

		Image image1 = Toolkit.getDefaultToolkit().getImage("penguin1.gif");
		Image image2 = Toolkit.getDefaultToolkit().getImage("penguin2.gif");
		Image image3 = Toolkit.getDefaultToolkit().getImage("penguin3.gif");
		
		g.drawImage(image1,20,330,this);
		g.drawImage(image2,100,330,this);
		g.drawImage(image3,180,330,this);
		

	}

	public static void main(String[] args) {
		new PaintFrame();

	}

}
