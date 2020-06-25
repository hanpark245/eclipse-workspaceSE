public abstract class Employee 
{
    private int no;
    private String name;
    private int pay;

    public Employee() 
    {
	
    }
    public Employee(int no, String name) 
    {
    	this.no = no;
    	this.name = name;
    }
    
    /*
     *  급여계산
     *  	-실제구현작업 불가능
     *  	-자식객체에서 재정의해야하는 메쏘드
     *  	-재정의강제
     *  	-
     */

    public abstract void calculatePay();    
    
    //------GETTER SETTER------
    
    public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	
	public void print()
    {
    	System.out.print(no + "\t" + name + "\t" + pay + "\t");
    }

}
