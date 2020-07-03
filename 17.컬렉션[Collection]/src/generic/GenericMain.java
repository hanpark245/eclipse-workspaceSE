package generic;

public class GenericMain {

	public static void main(String[] args) {
		System.out.println("--------------NoGeneric--------");
		NoGenericClass noGenericClass=new NoGenericClass();
		noGenericClass.setMember("스트링");
		String getMember=(String)noGenericClass.getMember();
		noGenericClass.setMember(new Account(1111,"FIRST",30000,0.4));
		System.out.println(getMember);
		Account getAccount = (Account)noGenericClass.getMember();
		getAccount.print();
		noGenericClass.setMember(new Car("1234",12));
		Car getCar=(Car)noGenericClass.getMember();
		getCar.print();
		
		System.out.println("--------------Generic--------");
		GenericClass<String> genericClass=new GenericClass<String>();
		genericClass.setMember("스트링");
		String str=genericClass.getMember();
		System.out.println(str);
		GenericClass<Account> genericClass1=
				new GenericClass<Account>();
		genericClass1.setMember(new Account(1111, "ONE", 10000, 1.1));
		Account acc = genericClass1.getMember();
		acc.print();
		
		GenericClass<Car> genericClass2=new GenericClass<Car>();
		genericClass2.setMember(new Car("3245", 7));
		Car car=genericClass2.getMember();
		car.print();
		
	}

}











