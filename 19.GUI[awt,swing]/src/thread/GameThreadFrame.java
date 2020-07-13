package thread;

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

public class GameThreadFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameThreadFrame frame = new GameThreadFrame();
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
	public GameThreadFrame() {
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
		moveThread=new MoveThread();
		moveThread.start();
		isPlay=true;
		direction=RIGHT;
	}
	public final static int LEFT=0;
	public final static int RIGHT=1;
	public final static int STOP=2;
	private Image backImage;//백그라운드이미지
	private Image[] penguinImgs;//펭귄이미지3개
	int pX,pY;//펭귄의 위치
	int imageNo;//펭귄의 이미지번호
	int direction;//펭귄의이동방향
	boolean isPlay;
	private MoveThread moveThread;
	@Override
	public void paint(Graphics g) {
		g.drawImage(backImage,0,0,getWidth(),getHeight(),this);
		g.drawImage(penguinImgs[imageNo],pX,pY,this);
	}
	/*********member inner class[MoveThread]**********/
	public class MoveThread extends Thread{
		@Override
		public void run() {
			while (isPlay) {
				try {
					
					if(direction==RIGHT) {
						//RIGHT
						pX+=3;
						if(pX >= getWidth()-penguinImgs[0].getWidth(GameThreadFrame.this)) {
							pX=getWidth()-penguinImgs[0].getWidth(GameThreadFrame.this);
						}
					}else if(direction==LEFT) {
						//LEFT
						pX-=3;
						if(pX <= 0) {
							pX=0;
						}
					}else if(direction==STOP){
						//STOP
						
					}
					imageNo++;
					imageNo=imageNo%3;
					repaint();
					Thread.sleep(50);
				}catch (Exception e) {
					
				}
			}
		}
	}
	/*********member inner class[KeyListener impl]**********/
	public class KeyHandler implements KeyListener{
		@Override
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				direction=LEFT;
				break;
			case KeyEvent.VK_RIGHT:
				direction=RIGHT;
				break;
			case KeyEvent.VK_SPACE:
				direction=STOP;
			}
			
		}
		@Override
		public void keyTyped(KeyEvent e) {}
		
		@Override
		public void keyReleased(KeyEvent e) {}
		
	}
}









