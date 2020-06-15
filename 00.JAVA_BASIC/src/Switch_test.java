 /*
		switch 문
		 - 형식
		    switch(변수){
		    	case 값_1:
		    	  stmt1;
		    	  break;
		    	case 값_2:
		    	  stmt2;
		    	  break;  
		        case 값_n:
		          stmt3;
		    	  break;
		        default:
		          stmt4;
		    }
		switch(변수)  변수값은 byte,short,int char 
		              값이올수있다.(long 은안됨)
*/


public class Switch_test 
{
	public static void main(String[] args)
	{
		int day = 3;
		switch(day) 
		{
			case 1:
				System.out.println("Today is Monday.");
				break;
			case 2:
				System.out.println("Today is Tuesday.");
				break;
			case 3:
				System.out.println("Today is Wednsday.");
				break;
			case 4:
				System.out.println("Today is Thursday.");
				break;
			case 5:
				System.out.println("Today is Friday.");
				break;
			case 6:
				System.out.println("Today is Saturday.");
				break;
			case 7:
				System.out.println("Today is Sunday.");
				break;
		}
		
		///////////////////////////////////////////////////////////////////////
		/*
		 * 1~7사이의정수
		 */
		int level = 3;
		String msg="";
		
		switch (level) 
		{
		case 1:
			msg="초보";
			break;
		case 2:
			msg="중수";
			break;
		case 3:
			msg="고수";
			break;
		case 4:
			msg="초고수";
			break;
		case 5:
			msg="초고수";
			break;
		case 6:
			msg="초고수";
			break;
		case 7:
			msg="초고수";
			break;
		default:
			msg="레벨은 1~7사이의정수입니다.";
			break;	
		}
		System.out.println(level + "-->" + msg);
	}
}
