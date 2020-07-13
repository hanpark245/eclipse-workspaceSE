package lang;

public class StringUseMain {

	public static void main(String[] args) {
		String str1="Have a nice day!!!";
		String str2="오늘은 금요일 회식을 할거여요!!";
		System.out.println("------------length()-------------");
		int length1 = str1.length();
		System.out.println(length1);
		System.out.println(str2.length());
		System.out.println("자바가 재미있네요!!!".length());
		String emptyStr="";
		System.out.println("empty string length:"+emptyStr.length());
		if(emptyStr.equals("")) {
			System.out.println("empty string 입니다.");
		}
		/*
		 * NullPointerException --> null.xxx()
		 */
		String id=null;
		if(id==null || id.equals("")) {
			System.out.println("아이디를 입력하삼~~~");
		}
		System.out.println("--------------String.substring()-------------");
		System.out.println("Have a nice day!!!".substring(7));
		System.out.println("Have a nice day!!!".substring(7,11));
		System.out.println("Have a nice day!!!".substring(7,11).length());
		System.out.println("오늘은 금요일 회식을 할거여요!!".substring(8));
		System.out.println("오늘은 금요일 회식을 할거여요!!".substring(8,10));
		System.out.println("----------charAt()------------");
		String userId = "test#00";
		char firstChar = userId.charAt(0);
		System.out.println(firstChar);
		for (int i = 0; i < userId.length(); i++) {
			char tempChar = userId.charAt(i);
			if(tempChar>='a' && tempChar<='z' ||
			   tempChar>='A' && tempChar<='Z' ||
			   tempChar>='0' && tempChar<='9'
			   ) {
				System.out.println("아이디로 유효한문자:"+tempChar);
			}else {
				System.out.println("아이디로 유효안한문자:"+tempChar);
				
			}
		}
		/*
		 * Quiz: 아이디로 적합한지판당하시요
		 *     - 길이가 3~7 사이여야한다.
		 *     - 영문,숫자로만 구성되어야한다.
		 *     - 첫글자가 숫자여서는 안된다.
		 */
		String memberId="dfgsdf@#@";
		
		System.out.println("--------------String.split()---------");
		String cardNo="123-4567-9877";
		String[] cardNoArray = cardNo.split("-");
		for (int i = 0; i < cardNoArray.length; i++) {
			System.out.println(cardNoArray[i]);
		}
		System.out.println("------------String.replace(char,char)-----------");
		String str3="우리는 자바를 공부합니다. 자바는 객체지향언어입니다.";
		String result3 = str3.replace('자', '저');
		System.out.println(result3);
		String result4 = str3.replace("자바", "파이썬");
		System.out.println(result4);
		String result5=str3.replaceFirst("자바", "파이썬");
		System.out.println(result5);
		System.out.println("---------String.toUpperCase,toLowerCase----");
		System.out.println("jaVA".toUpperCase());
		System.out.println("jaVA".toLowerCase());
		System.out.println("------------String.equalsIgnoreCase-------");
		System.out.println("Yes".equalsIgnoreCase("yes"));
		System.out.println("Yes".equalsIgnoreCase("YES"));
		System.out.println("Yes".equalsIgnoreCase("yeS"));
		System.out.println("------------String.indexOf()-------------");
		String fileName="xxx.gif";
		int dotIndex = fileName.indexOf(".");
		System.out.println("dot index:"+dotIndex);
		String fileNameNoExt = fileName.substring(0,dotIndex);
		String fileExt=fileName.substring(dotIndex+1);
		String copyFileName=fileNameNoExt+"-복사본."+fileExt;
		System.out.println(fileName);
		System.out.println(copyFileName);
		System.out.println("----------startWith,endWith-------");
		String fileName2="yyy.gif";
		if(fileName2.endsWith(".gif")|| fileName2.endsWith(".jpg")) {
			System.out.println(fileName2+" 는 이미지파일입니다[gif,jpg]");
		}
		String[] names= {"김경호","김미숙","최경녀","김은희","신명숙"};
		int count=0;
		for (int i = 0; i < names.length; i++) {
			if(names[i].startsWith("김")) {
				System.out.print(names[i]+" ");
				count++;
			}
		}
		System.out.println();
		String[] kimArray=new String[count];
		int index=0;
		for (int i = 0; i < names.length; i++) {
			if(names[i].startsWith("김")) {
				kimArray[index] = names[i];
				index++;
			} 
		}
		System.out.println("kimArray length:"+kimArray.length);
		for (int i = 0; i < kimArray.length; i++) {
			System.out.print(kimArray[i]+" ");
		}
		System.out.println();
		System.out.println("-------------trim()-------------");
		String id2=" guar  d ";
		System.out.println(id2.length());
		System.out.println(id2.trim().length());
		String spaceStr="       ";
		if(spaceStr.trim().equals("")) {
			System.out.println("empty string");
		}
		if(spaceStr.trim().length()==0) {
			System.out.println("empty string");
		}
		
	}

}













