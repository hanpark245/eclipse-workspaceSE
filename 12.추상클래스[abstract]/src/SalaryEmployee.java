public class SalaryEmployee extends Employee 
{
	private int annualSalary;
	
	public SalaryEmployee() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public SalaryEmployee(int no, String name, int annualSalary) {
		super(no, name);
		this.annualSalary = annualSalary;
	}



	
	public int getAnnualSalary() {
		return annualSalary;
	}




	public void setAnnualSalary(int annualSalary) {
		this.annualSalary = annualSalary;
	}




	@Override
	public void calculatePay() {
		this.setPay(this.annualSalary / 12);
	}
	
	public void print()
	{
		super.print();
		System.out.println(annualSalary);
	}
}
