
public class OuterClass {
	private InnerClass ic;
	public OuterClass() {
	}
	public int outer_member_field;
	public void outer_member_method() {
		System.out.println("OuterClass.outer_member_method()");
	}
	/*************외부클래스에서내부클래스사용************/
	public void outer_inner_use() {
		/*
		 * InnerClass객체생성
		 */
		InnerClass innerObject=new InnerClass();
		this.ic=innerObject;
		/*
		 * InnerClass객체사용
		 */
	}
	
	
	/****Nested Class[Inner Class]****/
	public class InnerClass{
		public int inner_member_field;
		public void inner_member_method() {
			System.out.println("InnerClass.inner_member_method()");
		}
		/*
		 * InnerClass의 사용이유
		 *   - 내부클래스(객체)에서 외부클래스(객체)의 
		 *     멤버의접근손쉽게하기위해사용
		 */
		
		public void inner_outer_access() {
			/*
			OuterClass.this.outer_member_field=758973;
			OuterClass.this.outer_member_method();
			*/
			outer_member_field=758973;
			outer_member_method();
		}
	}
	
}
