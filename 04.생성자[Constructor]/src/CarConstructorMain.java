
public class CarConstructorMain {

	public static void main(String[] args) {
		//입차
		Car car1 = new Car("1234", 12);
		car1.ipCha("1234", 12);
		
		Car car2 = new Car("5678", 13);
		car2.ipCha("5678", 13);
		
		/*
		 * 출차
		 *   - 출차시간대입
		 *   - 요금계산
		 */
		car1.setOutTime(14);
		car1.calculateFee();
		
		car2.setOutTime(14);
		car2.calculateFee();
		//영수증출력
		car1.print();
		car2.print();
	}

}
