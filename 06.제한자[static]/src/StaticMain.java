
public class StaticMain 
{
	public static void main(String[] args) 
	{
		/*
		 * 	객체멤버접근
		 * 		참조변수.멤버이름
		 * 	정적멤버접근
		 * 		클래스이름.멤버이름
		 */
	
		System.out.println("1.Static.static_member_field --> " + Static.static_member_field);
		Static.static_member_field = 898989;
		System.out.println("2.Static.static_member_field --> " + Static.static_member_field);
		Static.static_method();
		Static st1 = new Static();
		st1.instance_member_field = 1;
		st1.instance_method();
		
		Static st2 = new Static();
		st2.instance_member_field = 2;
		st2.instance_method();
		
	}
}
