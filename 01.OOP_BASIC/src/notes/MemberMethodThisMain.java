package notes;

public class MemberMethodThisMain 
{

	public static void main(String[] args) 
	{
		System.out.println("-----------------mmt1----------------");
		MemberMethodThis mmt1 = new MemberMethodThis();
		mmt1.member_field1=12121;
		mmt1.member_field2='김';
		mmt1.member_field3=3.14159;
		System.out.println("mmt1주소-->"+mmt1);
		mmt1.printMemberField();
		
		System.out.println("-----------------mmt2----------------");
		MemberMethodThis mmt2 = new MemberMethodThis();
		mmt2.member_field1=423;
		mmt2.member_field2='꿈';
		mmt2.member_field3=0.23584;
		System.out.println("mmt2주소-->"+mmt2);
		mmt2.printMemberField();
		System.out.println("-----------------mmt3----------------");
		MemberMethodThis mmt3 = new MemberMethodThis();
		mmt3.getMemberMethodThis(123,'r',3.132);
		mmt3.printMemberField();
	}

}

/*
public class MemberMethodThisMain 
{
	public static void main(String[] args)
	{
		MemberMethodThis mmt = new MemberMethodThis();				//객체생성
		mmt.member_field1 = 12121;
		mmt.member_field2 = '김';
		mmt.member_field3 = 3.14519;
		System.out.println("MemberMethodThis.setMemberField() 실행");
		//mmt.setMemberField(12121, 'ㅗ', 3.14159);								//setMemberField 호출
		System.out.println("MemberMethodThis.printMemberField() 실행");
		mmt.printMemberField(mmt.member_field1, mmt.member_field2, mmt.member_field3);
		
	}
}
*/