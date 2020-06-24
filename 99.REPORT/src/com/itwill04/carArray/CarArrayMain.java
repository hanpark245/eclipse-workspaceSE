package com.itwill04.carArray;

public class CarArrayMain {
	public static void main(String[] args) {
		/*
		 * NullPointerException
		 */
		Car[] carArray = 
			{
				null,null,new Car("2133", 12),null,null,
				null,null,new Car("1890", 11),null,null,
				null,null,null,null,null,
				null,null,new Car("4234", 9),null,null,
				null,null,null,new Car("7891", 11),null,
				new Car("6777", 10),null,null,null,null
			};
		System.out.println("1.전체차량출력");
		Car.headerPrint();
		for (int i = 0; i < carArray.length; i++) 
		{
			if(carArray[i] != null)
			{
				carArray[i].print();
			}
		}
		System.out.println("2.주차전체구획수:");
		
		int count = 0;
		System.out.println("3.주차가능주차구획수:" + count);
		System.out.println("4.입차");
		/*
		 * 1.차량객체생성 
		 * 2.빈자리찾아서대입
		 */
		Car car1 = new Car("8911", 13);
		
		boolean isFull = true;
		
		for (int i = 0; i < carArray.length; i++) 
		{
			if(carArray[i] == null)
			{
				carArray[i] = car1;
				isFull = false;
				break;
			}
		}
		if (isFull)
		{
			System.out.println("입차실패(만차)");
		}
		
		System.out.println("5.차량번호 4567번  차   한대 정보출력");
		for (int i = 0; i < carArray.length; i++) {
			if (carArray[i] != null) 
			{
				String tempNo = carArray[i].getNo();
				if(tempNo.equals("4567"))
				{
					carArray[i].print();
				}
			}
		}
		
		System.out.println("6.입차시간 8시이후 차 여러대 정보출력");
		Car.headerPrint();
		for (int i = 0; i < carArray.length; i++) 
		{
			if(carArray[i] != null && carArray[i].getInTime() >= 8)
			{
				carArray[i].print();
			}
		}
		
		
		System.out.println("7.7891번차량 12시 출차");
		Car.headerPrint();
		for (int i = 0; i < carArray.length; i++) 
		{
			if ((carArray[i] != null)) 
			{
				String tempNo = carArray[i].getNo();
				if(tempNo.equals("7891"))
				{
					carArray[i].setOutTime(12);
					carArray[i].calculateFee();
					carArray[i].print();
					carArray[i] = null;
					break;
				}
			}
		}
		
		
		/*
		 * 1 . 7891번차량찾기 
		 * 2 . 출차 
		 * 3 . 영수증출력 
		 * 4 . 주소값--> null
		 */
	}

}
