
public class AcademyMemberArrayCastingMain 
{
	public static void main(String[] args) 
	{
		AcademyMember[] members = 
		{
			new AcademyStudent(1, "KIM", "JAVA"),
			new AcademyStudent(2, "TIM", "KAVA"),
			new AcademyStudent(3, "BIM", "AAVA"),

			new AcademyGangsa(4, "FIM", "C"),
			new AcademyGangsa(5, "ZIM", "C++"),
			

			new AcademyStaff(6, "VIM", "MARKETING"),
			new AcademyStaff(7, "QIM", "CEO")
		};
	
		
		for (int i = 0; i < members.length; i++) 
		{
			members[i].print();
		}
		
		/*//INASTANCEOF-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-00-0-0-0--0-00--00-0--
			형태 = 참조변수 instanceof 클래스이름
			변환 = true or false 반환
		*/
		System.out.println("------학생만출력------");
		for (int i = 0; i < members.length; i++) 
		{
			if(members[i] instanceof AcademyStudent)
			{
				members[i].print();
				AcademyStudent tempStudent = (AcademyStudent)members[i];
				String ban = tempStudent.getBan();
				System.out.println("반 :" + ban);
			}
		}
	}
	
}
