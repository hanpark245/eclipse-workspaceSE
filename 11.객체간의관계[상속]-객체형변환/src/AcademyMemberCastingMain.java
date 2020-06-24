
public class AcademyMemberCastingMain 
{
	public static void main(String[] args) 
	{
		AcademyMember m1 = new AcademyStudent(1, "KIM", "JAVA");
		AcademyMember m2 = new AcademyStudent(2, "LIM", "JAVARA");
		AcademyMember m3 = new AcademyStudent(3, "HIM", "PYTHON");
		AcademyMember m4 = new AcademyGangsa(4, "김소라", "디자인");
		AcademyMember m5 = new AcademyGangsa(5, "김중라", "오피스");
		AcademyMember m6 = new AcademyStaff(6, "정비사", "OP");
		AcademyMember m7 = new AcademyStaff(7, "HONG", "MARKETING");
		
		m1.print();
		m2.print();
		m3.print();
		m4.print();
		m5.print();
		m6.print();
		m7.print();
		
		AcademyMember[] members = new AcademyMember[7];
		members[0] = m1;
		members[1] = m2;
		members[2] = m3;
		members[3] = m4;
		members[4] = m5;
		members[5] = m6;
		members[6] = m7;
		
		System.out.println("-----AcademyMember print-----");
		for (int i = 0; i < members.length; i++) 
		{
			members[i].print();
		}
	}
}
