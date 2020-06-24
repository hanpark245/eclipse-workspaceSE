
public class AcademyMemberOverridingMain {

	public static void main(String[] args) {
		AcademyStudent st1=new AcademyStudent(1,"KIM","LINUX");
		AcademyGangsa gs1=new AcademyGangsa(2,"LEE", "OFFICE");
		AcademyStaff sf1=new AcademyStaff(3, "HONG", "마케팅");
		
		st1.print();
		gs1.print();
		sf1.print();
		sf1.print();

	}

}
