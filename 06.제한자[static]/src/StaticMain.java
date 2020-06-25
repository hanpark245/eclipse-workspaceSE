
public class StaticMain {
	public static void main(String[] args) {
		/*
		 * 객체멤버접근
		 *    참조변수.멤버이름
		 * 정적멤버접근
		 *    클래스이름.멤버이름
		 * 
		 */
		System.out.println("1.Static.static_member_field-->"+
					Static.static_member_field);
		Static.static_member_field=898989;
		System.out.println("2.Static.static_member_field-->"+
				Static.static_member_field);
		Static.static_method();
		
		Static st1=new Static();
		st1.instance_member_field=1;
		st1.instance_method();
		
		Static st2=new Static();
		st2.instance_member_field=2;
		st2.instance_method();
		
		System.out.println("----------------------------------");
		System.out.println(Static.static_member_field);
		st1.static_member_field=77777;
		System.out.println(st1.static_member_field);
		st2.static_member_field=88888;
		System.out.println(st2.static_member_field);
		//The static field Static.static_member_field should be accessed in a static way
		System.out.println("-----------모두 같은변수에 접근함-----------------");
		System.out.println(Static.static_member_field);
		System.out.println(st1.static_member_field);
		System.out.println(st2.static_member_field);
	}

}
