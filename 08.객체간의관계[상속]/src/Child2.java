
public class Child2 extends Parent {
	public int member4;
	public void method4() {
		System.out.println("Child2.method4()");
	}
	public void childPrint() {
		this.parentPrint();
		System.out.println(this.member4);
	}
}
