
public class CarFactoryMain 
{
	public static void main(String[] args)  
	{
		Car.count = 0;
		Car c1 = new Car(1, "SM3", "RED");
		Car c2 = new Car(1, "SM4", "GREEN");
		Car c3 = new Car(1, "SM5", "BLUE");
		System.out.println("차량생산대수: " + Car.count);
	}
}
