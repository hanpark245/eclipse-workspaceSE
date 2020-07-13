package basic;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;

import javax.swing.JButton;
import javax.swing.JFrame;
/*
 * GUI프로그래밍 방법
 *   1.  컨테이너클래스준비(JFrame)상속
 *   2.  컨테이너클래스객체생성
 *   3.  컨테이너객체의 크기설정
 *   4.  컴포넌트생성(컨테이너의 멤버변수)
 *   5.  컨테이너에 컴포넌트 부치기(add)
 *   6.  컨테이너객체 보여주기
 */

public class ChildJFrame extends JFrame{
	private JButton btn1;
	private JButton btn2;
	
	public ChildJFrame() {
		System.out.println(">>>"+Thread.currentThread().getName()+" 쓰레드");
		this.setTitle("상속에의한 JFrame준비");
		Container contentPane=this.getContentPane();
		contentPane.setBackground(new Color(125,125,0));
		contentPane.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.setSize(300, 400);
		
		contentPane.setLayout(null);
		
		//4.  컴포넌트생성(컨테이너의 멤버변수)
		btn1=new JButton("확인");
		btn2=new JButton("취소");
		
		btn1.setBounds(40, 40, 80, 40);
		btn2.setBounds(130,40, 80, 40);
		//5.  컨테이너에 컴포넌트 부치기(add)
		contentPane.add(btn1);
		contentPane.add(btn2);
		
		
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		ChildJFrame f=new ChildJFrame();
		/*
		f.setTitle("상속에의한 JFrame준비");
		f.getContentPane().setBackground(new Color(125,125,0));
		f.setSize(300, 400);
		f.setVisible(true);
		*/
	}
}
