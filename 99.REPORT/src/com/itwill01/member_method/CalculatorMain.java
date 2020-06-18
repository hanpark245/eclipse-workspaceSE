package com.itwill01.member_method;

public class CalculatorMain {

	public static void main(String[] args) 
	{
		//객체 선언
		Calculator calculator = new Calculator();
	
		
		//더하기 함수 호출
		calculator.sum = calculator.addition(1,3);
		//뺄셈 함수 호출
		calculator.difference = calculator.subtraction(1,3);
		//나눔 함수 호출
		calculator.div = calculator.division(3.0,1.0);
		//곱하기 함수 호출
		calculator.mul = calculator.multiplication(3.0,6.0);
		
		//출력함수 호출
		calculator.print(calculator.sum, calculator.difference, calculator.div, calculator.mul);
	
	}

}







