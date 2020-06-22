
public class DefaultConstructor 
{
	/*
	생성자를 정의하지않을경우 컴파일러는 인자가하나도없는
    생성자[디폴트(기본) 생성자] 를 자동으로 넣어서 컴파일한다. 
	 */
	
	public DefaultConstructor() {
	}
	
	public DefaultConstructor(int m) {
		System.out.println("DefaultConstructor(int m)"+m);
	}
}
