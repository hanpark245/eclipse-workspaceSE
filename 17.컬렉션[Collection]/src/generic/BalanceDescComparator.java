package generic;

import java.util.Comparator;

public class BalanceDescComparator implements Comparator<Account>{

	@Override
	public int compare(Account o1, Account o2) {
		// TODO Auto-generated method stub
		return o2.getBalance()-o1.getBalance();
	}

}
