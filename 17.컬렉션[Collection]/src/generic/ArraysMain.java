package generic;

import java.util.Arrays;

import org.omg.CORBA.OMGVMCID;

public class ArraysMain {

	public static void main(String[] args) {
		int[] intArray1= {1,3,5,7,9};
		int[] intArray2= {1,3,5,7,9};
		String[] strArray1= {new String("one"),"two","three"};
		String[] strArray2= {new String("one"),"two","three"};
		Account[] accounts= {
				new Account(1111,"ONE",50000,2.5),
				new Account(2222, "KIM", 56000, 0.9),
				new Account(3333, "PAR", 12000, 1.9),
				new Account(4444, "CHO", 89000, 4.9),
				new Account(5555, "SIM", 34000, 0.6),
				new Account(6666, "KIM", 77000, 0.1),
				new Account(7777, "KIM", 11000, 0.3),
				new Account(8888, "GIM", 21000, 2.4),
				new Account(9999, "QIM", 99000, 3.3)
		};
		System.out.println("1.배열의 내용비교");
		boolean isSame=Arrays.equals(intArray1, intArray2);
		System.out.println(">>>"+isSame);
		isSame=Arrays.equals(strArray1, strArray2);
		System.out.println(">>>"+isSame);
		System.out.println("2.배열의 원소채우기");
		int[] intArray3=new int[10];
		Arrays.fill(intArray3, 1);
		for (int tempi:intArray3) {
			System.out.print(tempi+",");
		}
		System.out.println("3.배열복사");
		int[] intArray1Copy = Arrays.copyOf(intArray1, 10);
		for (int i : intArray1Copy) {
			System.out.print(i+" ");
		}
		System.out.println();
		Account[] copyAccounts=Arrays.copyOf(accounts, 20);
		for (Account account : copyAccounts) {
			System.out.println(account);
		}
		int[] intArray2Copy=new int[intArray2.length];
		System.arraycopy(intArray2, 0, intArray2Copy, 0, intArray2.length);
		for (int i : intArray2Copy) {
			System.out.print(i+" ");
		}
		System.out.println("------------sort[기본형]---------------");
		int[] scoreArray= {90,34,88,23,56,11};
		Arrays.sort(scoreArray);
		for (int score : scoreArray) {
			System.out.print(score+" ");
		}
		System.out.println();
		System.out.println("------------sort[참조형]---------------");
		//String
		String[] nameArray= {"KIM","AIM","LIM","BIM","OIM"};
		Arrays.sort(nameArray);
		for (String name : nameArray) {
			System.out.print(name+" ");
		}
		System.out.println();
		//Wrapper
		Integer[] wia= {
			new Integer(90),
			new Integer(67),
			new Integer(12),
			new Integer(56),
			new Integer(89),
			new Integer(23),
			new Integer(99)	
		};
		Arrays.sort(wia);
		for (Integer wi : wia) {
			System.out.print(wi.intValue()+" ");
		}
		System.out.println("-------------Comparable--------------------");
		System.out.println();
		Arrays.sort(accounts);
		/*
		 * 1. Account 를 Comparable<T> interface type으로 형변환한다.
		 * 2. Comparable.compareTo()메쏘드를 호출한다.
		 * 3. 반환값이 양수이면 교체,음수이면 교체안함
		 */
		for (Account acc : accounts) {
			acc.print();
		}
		System.out.println("-------------BalanceDescComparator--------------------");
		Arrays.sort(accounts,new BalanceDescComparator());
		for (Account acc : accounts) {
			acc.print();
		}
		
		System.out.println("-------------NameAscComparator--------------------");
		Arrays.sort(accounts,new NameAscComparator());
		for (Account acc : accounts) {
			acc.print();
		}
		
		
		
	}
}
