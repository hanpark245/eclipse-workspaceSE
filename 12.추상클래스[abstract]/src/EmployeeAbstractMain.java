
public class EmployeeAbstractMain 
{
	public static void main(String[] args) 
	{
		SalaryEmployee emp1 = new SalaryEmployee(1, "KIM", 30000000);
		emp1.calculatePay();
		emp1.print();
		HourlyEmployee emp2 = new HourlyEmployee(2, "JIM", 100, 20000);
		emp2.calculatePay();
		emp2.print();
		
		Employee e1 = emp1;
		Employee e2 = emp2;
		
		Employee[] emps = new Employee[5];
		emps[0] = e1;
		emps[1] = e2;
		emps[2] = new SalaryEmployee(3, "DIM", 3500000);
		emps[3] = new SalaryEmployee(4, "SIM", 5700000);
		emps[4] = new HourlyEmployee(5, "FIM", 120, 150000);
		
		for (int i = 0; i < emps.length; i++) 
		{
			emps[i].calculatePay();
			System.out.println("--------------" + emps[i].getName() + "님의 금여 명세표---------------");
			emps[i].print();
			System.out.println("------------------------------------------------");
			System.out.println();
			System.out.println();
			
		}
		
	}
}
