package wrapperclass;

public class WrapperClass유용한메쏘드Main 
{
	public static void main(String[] args) 
	{
		int y = 2137483647;
		String yStr = Integer.toString(y);
		System.out.println("int --> String");
		System.out.println(yStr);
		
		String yStr2 = y + "";
		System.out.println(yStr2);
		String yStr3 = Integer.toBinaryString(y);
		System.out.println(yStr3);
		
		
		//parse 사용법
		System.out.println("String --> 기본형");
		int i = Integer.parseInt("23445534");
		System.out.println(i);
		double d = Double.parseDouble("3.14159");
		System.out.println(d);
		boolean b = Boolean.parseBoolean("true");
		System.out.println(b);
				
		/*
		 * 연산자 오버로딩( + )
		 * 	-연산항이 문자열일경우 concatenate
		 */

		int number = 4545;
		String numStr = number + "";
		System.out.println(numStr);
		String numStr2 = 1 + 2 + 3 + "4";
		System.out.println(numStr2);
		String numStr3 = "1" + 2 + 3 + 4;
		System.out.println(numStr3);
		double dNumber = 3.14159;
		String numStr4 = dNumber + "";
		for (int j = 0; j < numStr4.length(); j++) 
		{
			char tc = numStr4.charAt(j);
			System.out.printf(tc + " ");
		}
		System.out.println();
		System.out.println("---------------Character--------------");
		
		Character wc1 = new Character('김');
		Character wc2 = '김';
		char c1 = wc1.charValue();
		char c2 = wc2;
		int i3 = wc2;
		
		System.out.println("-------------- String-->char, char[] --------------");
		char fc = "김경호".charAt(0);
		System.out.println(fc);
		/*
		String s1 = "김";
		char s2 = '김';
		*/
		
		char[] ca = "오늘은 비오는 일요일 강사는 아침부터 지랄을하고".toCharArray();
		for (int j = 0; j < ca.length; j++) 
		{
			System.out.print(ca[j] + "");
		}
		
		System.out.println();
		System.out.println("-------------- char[] --> String --------------");
		char c90 = '김';
		String s90 = String.valueOf(c90);
		String s91 = c90 + "";
		char[] c92 = {'J' , 'A' , 'V' , 'A'};
		String s92 = new String(c92);
		String s93 = String.copyValueOf(c92);
		System.out.println(s92);
		System.out.println(s93);
		
		String strs = "Hello Java##";
		
		for (int j = 0; j < strs.length(); j++) 
		{
			char tc = strs.charAt(j);
			
			int type = Character.getType(tc);
			System.out.println(type);
			if(type == Character.UPPERCASE_LETTER)
			{
				System.out.println("UPTTERCASE_LETTER " + tc);
			}
			if(type == Character.LOWERCASE_LETTER)
			{
				System.out.println("LOWERCASE_LETTER " + tc);
			}
			if(type == Character.DECIMAL_DIGIT_NUMBER)
			{
				System.out.println("DECIMAL_DIGIT_NUMBER " + tc);
			}
			if(type == Character.SPACE_SEPARATOR)
			{
				System.out.println("SPACE_SEPARATOR " + tc);
			}
			
			if(Character.isSpaceChar(tc))
			{
							
			}
			if(Character.isAlphabetic(tc))
			{
				
			}
			if(Character.isDigit(tc))
			{
				
			}
		}
		
		
	}
}
