
public class MemberField 
{
	/*
	 *  멤버변수선언
 	 *	0.멤버변수생성 초기화 없다면 자동초기화
 	 *	1.멤버필드생성 자동초기화
 	 *
 	 *	int 	: 0
 	 * 	double 	: 0.0
 	 * 	char 	: \u0000
 	 * 	boolean : false
 	 * 	String 	: null
 	 * 	참조변수: null
 	 * 
 	 */
	
	public int member1;
	public double member2;
	public char member3;
	public boolean member4;
	public Account member5;
	public String member6;
	
	public MemberField() 
	{
		//생성자 초기화
		this.member1 = 9999;
		this.member2 = 9.9999;
		this.member3 = 'A';
		this.member4 = true;
		this.member5 = new Account(12342, "HAN", 1254, 1);
		this.member6 = "String";
	}
}
