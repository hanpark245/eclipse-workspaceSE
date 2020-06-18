package notes;

public class MemberMethodThis 
{
	int member_field1;
	char member_field2;
	double member_field3;

	
	void getMemberMethodThis(int member_field1, char member_field2, double member_field3)
	{
		this.member_field1 = member_field1;
		this.member_field2 = member_field2;
		this.member_field3 = member_field3;
	}
	void printMemberField()		//int a, char b, double c
	{	
		/*
		 *  this:
		 *  	-self 참조변수
		 *  	-print 메쏘드를 가지고있는 객체의 주소값
		 */
		System.out.println(member_field1);
		System.out.println(member_field2);
		System.out.println(member_field3);
		//System.out.println("member_field1 = " + a);	
		//System.out.println("member_field2 = " + b);
		//System.out.println("member_field3 = " + c);
	}
}
