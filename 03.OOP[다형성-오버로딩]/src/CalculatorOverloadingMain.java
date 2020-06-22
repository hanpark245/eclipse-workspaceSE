
public class CalculatorOverloadingMain 
{
	public static void main(String[] args) 
	{
		Calculator calculator = new Calculator();
		calculator.add();
		calculator.add(1);
		calculator.add(1 ,2);
		calculator.add(1, 2, 3);
		//System.out.print();
	}
}