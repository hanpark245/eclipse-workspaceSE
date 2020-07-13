package paint;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GameFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameFrame frame = new GameFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GameFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		/**********************/
		backImage=Toolkit.getDefaultToolkit().getImage("penguin_back.jpg");
		penguinImgs=new Image[3];
		for (int i = 0; i < penguinImgs.length; i++) {
			penguinImgs[i] = 
					Toolkit.getDefaultToolkit().getImage("penguin"+(i+1)+".gif");
		}
		pX=10;
		pY=300;
		imageNo=0;
		requestFocus();
		/*
		 * event처리(KeyEvent)
		 *   이벤트소스참조변수.addXXXListener(핸들러객체)
		 */
		this.addKeyListener(new KeyHandler());
		/*
		this.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {}
			public void keyReleased(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {}
		});
		*/
	}
	
	private Image backImage;//백그라운드이미지
	private Image[] penguinImgs;//펭귄이미지3개
	int pX,pY;//펭귄의 위치
	int imageNo;//펭귄의 이미지번호
	@Override
	public void paint(Graphics g) {
		g.drawImage(backImage,0,0,getWidth(),getHeight(),this);
		g.drawImage(penguinImgs[imageNo],pX,pY,this);
	}
	/*********member inner class[KeyListener impl]**********/
	public class KeyHandler implements KeyListener{
		@Override
		public void keyPressed(KeyEvent e) {
			//System.out.println("pressed key char:"+e.getKeyChar());
			//System.out.println("pressed key code:"+e.getKeyCode());
			int keyCode=e.getKeyCode();
			switch (keyCode) {
			case KeyEvent.VK_UP:
				pY-=5;
				break;
			case KeyEvent.VK_DOWN:
				pY+=5;
				break;
			case KeyEvent.VK_LEFT:
				pX-=5;
				if(pX <= 0) {
					pX=0;
				}
				break;
			case KeyEvent.VK_RIGHT:
				pX+=5;
				if(pX >= getWidth()-penguinImgs[0].getWidth(GameFrame.this)) { 
					pX = getWidth()-penguinImgs[0].getWidth(GameFrame.this); 
				}	
				break;
			}
			imageNo++;
			imageNo=imageNo%3;
			repaint();
			
		}
		@Override
		public void keyTyped(KeyEvent e) {
			//System.out.println("typed key char:"+e.getKeyChar());
			//System.out.println("types key code:"+e.getKeyCode());
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			//System.out.println("released key char:"+e.getKeyChar());
			//System.out.println("released key code:"+e.getKeyCode());
		}
		
	}
}









