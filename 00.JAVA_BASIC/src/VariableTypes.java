
public class VariableTypes {

	public static void main(String[] args) {
		
		// --------------------------占쏙옙占쏙옙----------------------------//
		//占쏙옙占쏙옙占쏙옙占싶뤄옙(true,false)
		 
		boolean bool1,bool2;
		bool1 = true;
		bool2 = false;
		/*
	    Type mismatch: cannot convert from char to boolean
		bool3 = 'A';
		*/
		System.out.println(bool1);
		System.out.println(bool2);
		
		
		/*
		 * 占쏙옙占쏙옙占쏙옙
		 * 占쏙옙占쏙옙占쏙옙占쏙옙占싶뤄옙('A','占쏙옙'...)
		 */
		char munja1,munja2,munja3,munja4,munja5,munja6,munja7;
		munja1 = 'A';
		munja2 = 'B';
		munja3 = 65; 

		//int intAny  = 65;
		//char char65= intAny;
		
		int  munja33 = 65;
		munja4 = 44032;
		munja5 = '\u0041';
		munja6 = '\uac00';
		munja7 = munja1;
		
		
		System.out.println(munja1);
		System.out.println(munja2);
		System.out.println(munja3);
		System.out.println(munja33);
		System.out.println(munja4);
		System.out.println(munja5);
		System.out.println(munja6);
		System.out.println(munja7);
		
		
		
		/*
		 *占쏙옙占쏙옙 : 占쏙옙占쏙옙占쏙옙
		 *  - 占쏙옙占쏙옙占쏙옙占쏙옙占싶뤄옙(1,34,777)
		 */
		byte b;
		short s;
		int i;
		long l;
		
		b = 127;
		s = 32767;
		i = 2147483647;
		l = 2147483648L;
		
		/*
		 *占쏙옙占쏙옙 : 占실쇽옙占쏙옙
		 *	 - 占실쇽옙占쏙옙占쏙옙占싶뤄옙(1.0, .1 , 3.1415)
		 */
		float f;
		double d;
		
		f = 3.14159F;
		d = 3.14159;
		
		System.out.println(b);
		System.out.println(s);
		System.out.println(i);
		System.out.println(l);
		System.out.println(f);
		System.out.println(d);
		
		System.out.println("-----------占쏙옙占쌘울옙占쏙옙------------");
		String str1;
		str1 = "占쏙옙占쏙옙占쏙옙";
		String str2="占쏙옙占쏙옙占쏙옙";
		String str3="占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쌌니댐옙.";
		
		int month = 6;
		int day = 10;
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		
		String message = str1+" "+month+"占쏙옙 "+day+"占쏙옙 "+str2+" "+str3;
		
		
		System.out.println(message);
		
		
		
		
		
		
		
		
		
	}

}

