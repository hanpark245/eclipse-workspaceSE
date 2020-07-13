package basic;

import java.awt.Color;

import javax.swing.JFrame;

public class JFrameMain {

	public static void main(String[] args) {
		/*
		 * GUI프로그래밍 방법
		 *   1.  컨테이너클래스준비(JFrame)상속
		 *   2.  컨테이너클래스객체생성
		 *   3.  컨테이너객체의 크기설정
		 *   4.  
		 *   5.  
		 *   6.  컨테이너객체 보여주기
		 */

		JFrame f=new JFrame();
		f.setTitle("나의첫번째 프레임");
		f.getContentPane().setBackground(new Color(0,0,255));
		f.setSize(300, 400);
		f.setVisible(true);
		/*
		 * Frame.setVisible(true)
		 *    - 호출되면 GUI(awt) 쓰레드생성
		 *    - GUI(awt) 쓰레드 무한대기하면서
		 *       GUI컴포넌트 이벤트처리,그래픽처리담당
		 *    - GUI컴포넌트는 계속떠있다.
		 *       (JVM이종료되지않는다)   
		 */
		
		

	}

}
