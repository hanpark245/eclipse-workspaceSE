package generic;

import java.util.Comparator;

public class NameAscComparator implements Comparator<Account>{
	/*
	 * Think:
	 *   이름이 같을때 2차 번호순으로 오름차순 
	 */
	@Override
	public int compare(Account o1, Account o2) {
		// TODO Auto-generated method stub
		return o1.getOwner().compareTo(o2.getOwner());
	}
	

}
