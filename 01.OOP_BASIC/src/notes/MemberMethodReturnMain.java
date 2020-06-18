package notes;

public class MemberMethodReturnMain 
{

	public static void main(String[] args) 
	{
		MemberMethodReturn mmr = new MemberMethodReturn();
		
		
		System.out.println("----------main 흐름 1----------");
		int result1 = mmr.method1();
		System.out.println("Result1 = " + result1);
		
		System.out.println("\n----------main 흐름 2----------");
		boolean isMarried = mmr.isMarried();
		System.out.println("isMarried?: " + isMarried);
		
		System.out.println("\n----------main 흐름 3----------");
		int result2 = mmr.add(212424, 1234124);
		System.out.println("Result2 = " + result2);
	}

}
