
public class OuterClass2 {
	public static void main(String[] args) {
		OuterClass2 oc2=new OuterClass2();
		//oc2.outer_class_method1();
		oc2.outer_class_method2();
	}
	
	public int outer_class_member_field;
	public void outer_class_method1() {
		AClassChild acc=new AClassChild();
		acc.print();
		acc.ssss();
		
		BClassChild bcc=new BClassChild();
		bcc.method1();
		CIntefaceImpl cii=new CIntefaceImpl();
		cii.method_one();
		cii.method_two();
	}
	public void outer_class_method2() {
		/*
		 *  익명 로칼 이너클래스(anonymous local inner class)
		 */
		AClass ac=new AClass() {
			@Override
			public void print() {
				System.out.println("익명클래스 에서 AClass.print() 재정의");
			}
			public void ssss() {
				
			}
		};
		ac.print();
		//ac.ssss();
		BClass bcc=new BClass() {
			@Override
			public void method1() {
				System.out.println("익명클래스 에서 BClass.method1()재정의(구현)");
				
			}
		};
		bcc.method1();
		
		CInterface cii = new CInterface() {
			@Override
			public void method_one() {
				System.out.println("익명클래스 에서 CInterface.method_one()재정의(구현)");
			}

			@Override
			public void method_two() {
				System.out.println("익명클래스 에서 CInterface.method_two()재정의(구현)");
			}
		};
		cii.method_one();
		cii.method_two();
		
		
		Object oc=new Object() {
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "익명클래스 재정의된 toString";
			}
		};
		System.out.println(oc);
		
		
	}
	
	
	/***********member inner class 1***************/
	public class AClassChild extends AClass{
		@Override
		public void print() {
			System.out.println("AClassChild 에서 AClass.print() 재정의");
		}
		public void ssss() {
			
		}
	}
	
	/**********member inner class 2****************/
	public class BClassChild extends BClass{
		@Override
		public void method1() {
			System.out.println("BClassChild에서 BClass.method1()재정의(구현)");
		}
		
	}
	
	/**********member inner class 3****************/
	public class CIntefaceImpl implements CInterface{
		@Override
		public void method_one() {
			System.out.println("CIntefaceImpl 에서 CInterface.method_one()재정의(구현)");
		}

		@Override
		public void method_two() {
			System.out.println("CIntefaceImpl 에서 CInterface.method_two()재정의(구현)");
		}
		
	}
}











