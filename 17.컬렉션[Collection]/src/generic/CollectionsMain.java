package generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsMain {

	public static void main(String[] args) {
		ArrayList<Integer> intList1=new ArrayList<Integer>();
		intList1.add(34);
		intList1.add(56);
		intList1.add(89);
		intList1.add(76);
		intList1.add(12);
		intList1.add(29);
		
		List<Integer> intList2 = Arrays.asList(34,56,89,76,12,29);
		List<String> nameList=Arrays.asList("김태희","이소라","이효리","장동건","유재석");
		List<Account> accountList=Arrays.asList(
				new Account(1111, "ZIM", 56000, 0.2),
				new Account(2222, "KIM", 56000, 0.9),
				new Account(3333, "PAR", 12000, 1.9),
				new Account(4444, "CHO", 89000, 4.9),
				new Account(5555, "SIM", 34000, 0.6),
				new Account(6666, "KIM", 77000, 0.1),
				new Account(7777, "KIM", 11000, 0.3),
				new Account(8888, "GIM", 21000, 2.4),
				new Account(9999, "QIM", 99000, 3.3));
		
		Collections.sort(intList1);
		for (int n : intList1) {
			System.out.print(n+" ");
		}
		System.out.println();
		Collections.reverse(intList1);
		for (int n : intList1) {
			System.out.print(n+" ");
		}
		System.out.println();
		Collections.shuffle(intList1);
		for (int n : intList1) {
			System.out.print(n+" ");
		}
		System.out.println();
		
		List<String> copyNameList=Arrays.asList(null,null,null,null,null);
		Collections.fill(copyNameList, "EMPTY");
		for (String name : copyNameList) {
			System.out.print(name+" ");
		}
		System.out.println();
		Collections.copy(copyNameList, nameList);
		for (String name : copyNameList) {
			System.out.print(name+" ");
		}
		System.out.println();
		
		System.out.println("-----------------Account sort[Comparable]-----------------------");
		Collections.sort(accountList);
		for (Account a : accountList) {
			a.print();
		}
		System.out.println("-----------------Account sort[Comparator]-----------------------");
		System.out.println("-------------BalanceDescComparator------------------");
		Collections.sort(accountList,new BalanceDescComparator());
		for (Account a : accountList) {
			a.print();
		}
		System.out.println("-------------NameAscComparator------------------");
		Collections.sort(accountList,new NameAscComparator());
		for (Account a : accountList) {
			a.print();
		}
	}

}












