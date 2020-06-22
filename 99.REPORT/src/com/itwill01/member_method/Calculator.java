package com.itwill01.member_method;
/*
 * 4개의 멤버메쏘드를 가짐
 */
public class Calculator 
{
	/*
	 * add( 두개의 정수를 인수로 받아서 더한결과를 반환)
	 * substract
	 * div
	 * multiple
	 */
	
	//------------------멤버변수 선언--------------------
	int sum;
	int difference;
	double div;
	double mul;
	
	//-------------------멤버 메소드---------------------
	//더하는 함수
	public int addition(int a, int b)
	{
		return a + b;
	}
	//빼는 함수
	public int subtraction(int a, int b)
	{
		return a - b;
	}
	//나누는 함수
	public double division(double a, double b)
	{
		return a / b;
	}
	//곱하는 함수 
	public double multiplication(double a, double b)
	{
		return a * b;
	}
	//출력함수
	public void print(int sum, int difference, double div, double mul)
	{
		System.out.println("Addition of two numbers: " + sum);
		System.out.println("Subtraction of two numbers: " + difference);
		System.out.println("Division of two numbers: " + div);
		System.out.println("Multiplication of two numbers: " + mul);
	}
}


