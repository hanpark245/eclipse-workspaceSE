public class Child1 extends Parent {
	/*
	public int member1;
	public int member2;
	public void method1() {
		System.out.println("Parent.method1()");
	}
	public void method2() {
		System.out.println("Parent.method2()");
		
	}
	public void parentPrint() {
		System.out.println(member1+"\t"+member2);
	}
	 */
	public int member3;
	public void method3() {
		System.out.println("Child1.method3()");
	}
	public void childPrint() {
		this.parentPrint();
		System.out.println(this.member3);
	}
}
