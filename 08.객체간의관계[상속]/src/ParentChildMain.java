
public class ParentChildMain {

	public static void main(String[] args) {
		System.out.println("------------Child1---------------");
		Child1 c1=new Child1();
		c1.member1=1;
		c1.member2=2;
		c1.member3=3;
		c1.method1();
		c1.method2();
		c1.method3();
		//c1.parentPrint();
		c1.childPrint();
		System.out.println("------------Child2---------------");
		Child2 c2=new Child2();
		c2.member1=1;
		c2.member2=2;
		c2.member4=4;
		c2.method1();
		c2.method2();
		c2.method4();
		//c2.parentPrint();
		c2.childPrint();
		System.out.println("------------Parent---------------");
		Parent p=new Parent();
		p.member1=1;
		p.member2=2;
		p.method1();
		p.method2();
		p.parentPrint();
	}

}






