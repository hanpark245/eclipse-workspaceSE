
public class CalculatorStaticMain {

	public static void main(String[] args) {
		/*
		 << The constructor Calculator() is not visible >>
		Calculator calculator=new Calculator();
		int r = calculator.add(1, 2);
		System.out.println(r);
		 r = calculator.sub(1, 2);
		System.out.println(r);
		 r = calculator.div(1, 2);
		System.out.println(r);
		 r = calculator.mul(1, 2);
		System.out.println(r);
		*/
		System.out.println("---------static way----------------");
		System.out.println(Calculator.add(231, 3454));
		System.out.println(Calculator.sub(231, 3454));
		System.out.println(Calculator.div(231, 3454));
		System.out.println(Calculator.mul(231, 3454));
		System.out.println("------------Math class-----------");
		//Math m=new Math();
		System.out.println(Math.round(3.15487));
		System.out.println(Math.max(2,3));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
