package com.itwill07.collection;


import javax.swing.JFrame;

public class StudentServiceFrameMain  extends JFrame{
	private StudentServiceArrayList studentService;
	public StudentServiceFrameMain() {
		
		super("학생관리 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		studentService=new StudentServiceArrayList();
		setSize(400, 450);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new StudentServiceFrameMain();
	}

}
