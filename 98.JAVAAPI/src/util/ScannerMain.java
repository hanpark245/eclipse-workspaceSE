package util;

import java.util.Scanner;

public class ScannerMain {

	public static void main(String[] args) {
		/*
		 * 키보드객체생성
		 */
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.print("이름을 입력하세요:");
			/*
			 * Thread가 String을 키보드로부터입력받기위해서 blocking
			 */
			String nameString = scanner.next();
			System.out.print("국어점수를 입력하세요:");
			int kor = scanner.nextInt();
			System.out.print("영어점수를 입력하세요:");
			int eng = scanner.nextInt();
			System.out.print("수학점수를 입력하세요:");
			int math = scanner.nextInt();
			int tot = kor + eng + math;
			double avg = tot / 3.0;
			System.out.println(nameString + "\t" + kor + "\t" + eng + "\t" + math + "\t" + tot + "\t" + avg);
			System.out.print("계속할까요?(y/n):");
			String yn = scanner.next();
			if(yn.equalsIgnoreCase("n")) {
				System.out.println("프로그램종료합니다.");
				break;
			}
			
			
		}

	}

}
