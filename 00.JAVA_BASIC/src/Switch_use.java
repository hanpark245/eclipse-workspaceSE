
public class Switch_use 
{
	public static void main(String[] args)
	{
		//홀수짝수판별
		
		int number = 23;
		
		switch(number % 2)
		{
			case 0:
				System.out.println("짝수");
				break;
			case 1:
				System.out.println("홀수");
				break;
		}
		
		
		//4의배수 판별
		int number2 = 24;
		switch(number2 % 4)
		{
			case 0:
				System.out.println("4의배수");
				break;
			default:
				System.out.println("4의배수 아님");
				break;
		}
		
		/*	문자비교
		 * 	A: left
		 * 	D: right
		 * 	W: up
		 * 	X: down
		 *  S: rotate
		 */
		char direction = 'D';
		
		switch (direction)
		{
			case 'A':
				System.out.println("LEFT로 이동");
				break;
			case 'D':
				System.out.println("RIGHT으로 이동");
				break;
			case 'W':
				System.out.println("UP로 이동");
				break;
			case 'X':
				System.out.println("DOWN으로 이동");
				break;
			case 'S':
				System.out.println("ROTATE");
				break;	
		}

	}
}
