package generic;
import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListMain {

	public static void main(String[] args) {
		System.out.println("----------Object[]-------------");
		Object[] anyTypeArray = new Object[5];
		Account acc1=new Account(1111, "KING", 33000, 0.05);
		Account acc2=new Account(2222, "KING", 23000, 0.1);
		Account acc3=new Account(3333, "YONG", 89000, 0.2);
		Account acc4=new Account(4444, "SANG", 12000, 0.5);
		Account acc5=new Account(5555, "KING", 99000, 0.8);
		anyTypeArray[0]=acc1;
		anyTypeArray[1]=acc2;
		anyTypeArray[2]=acc3;
		anyTypeArray[3]=acc4;
		anyTypeArray[4]=acc5;
		
		for (int i = 0; i < anyTypeArray.length; i++) {
			Account tempAccount=(Account)anyTypeArray[i];
			tempAccount.print();
		}
		System.out.println("------------ArrayList[참조형]---------------");
		ArrayList<Account> accountList=new ArrayList<Account>();
		System.out.println("#size:"+accountList.size());
		System.out.println("*********** 1.add *****************");
		accountList.add(acc1);
		accountList.add(acc2);
		accountList.add(acc3);
		accountList.add(acc4);
		accountList.add(acc5);
		accountList.add(new Account(6666,"SIX",60000,6.0));
		accountList.add(0,new Account(1000,"FIRST",100000,1.0));
		System.out.println("#size:"+accountList.size());
		//accountList.add(acc3);//중복허용
		System.out.println(accountList.toString());
		System.out.println("*********** 2.set *****************");
		accountList.set(3, new Account(4445, "FOUR", 44000, 0.4));
		System.out.println("#size:"+accountList.size());
		System.out.println(accountList.toString());
		
		System.out.println("*********** 3.get *****************");
		Account getAccount = accountList.get(1);
		getAccount.print();
		
		getAccount = accountList.get(4);
		getAccount.print();
		System.out.println("*********** 4.remove *****************");
		accountList.remove(accountList.size()-1);
		System.out.println("#size:"+accountList.size());
		System.out.println(accountList);
		System.out.println("************전체출력******************");
		for (int i = 0; i < accountList.size(); i++) {
			accountList.get(i).print();
			
		}
		System.out.println("************전체출력[enhanced for]******************");
		for (Account account : accountList) {
			account.print();
		}
		System.out.println("*************계좌번호 5555번계좌한개출력*************");
		for (int i = 0; i < accountList.size(); i++) {
			Account tempAccount=accountList.get(i);
			if(tempAccount.getNo()==5555) {
				tempAccount.print();
				break;
			}
		}
		System.out.println("*************계좌이름 KING계좌들출력*************");
		for (int i = 0; i < accountList.size(); i++) {
			Account temAccount=accountList.get(i);
			if(temAccount.getOwner().equals("KING")) {
				temAccount.print();
			}
		}
		System.out.println("*************계좌번호 5555번계좌한개삭제*************");
		for (int i = 0; i < accountList.size(); i++) {
			Account tempAccount=accountList.get(i);
			if(tempAccount.getNo()==5555) {
				System.out.println("before remove size:"+accountList.size());
				accountList.remove(i);
				System.out.println("after remove size:"+accountList.size());
				break;
			}
		}
		System.out.println(accountList);
		System.out.println("*************계좌이름 KING인 계좌들삭제*************");
		for (int i = 0; i < accountList.size(); i++) {
			Account tempAccount = accountList.get(i);
			if(tempAccount.getOwner().equals("KING")){
				accountList.remove(i);
				i--;
			}
		}
		System.out.println(accountList);
		/********************iteration*********************/
		System.out.println("############### iteration ###############");
		Iterator<Account> accounIter=accountList.iterator();
		while (accounIter.hasNext()) {
			Account tempAccount=accounIter.next();
			tempAccount.print();
		}
		
		System.out.println("------------ArrayList[기본형(Wrapper,String)]---------------");
		ArrayList<Integer> scoreList = new ArrayList<Integer>();
		scoreList.add(90);
		scoreList.add(30);
		scoreList.add(45);
		scoreList.add(34);
		scoreList.add(12);
		scoreList.add(99);
		scoreList.add(62);
		scoreList.add(43);
		System.out.println("---add----");
		System.out.println(scoreList);
		System.out.println("---get----");
		Integer getScore0 = scoreList.get(0);
		System.out.println(getScore0.intValue());
		/******auto unboxing*******/
		int getScoreLast = scoreList.get(scoreList.size()-1);
		System.out.println(getScoreLast);
		System.out.println("---set----");
		scoreList.set(0, new Integer(100));
		scoreList.set(1, 100);
		System.out.println(scoreList);
		System.out.println("---remove(int index)----");
		System.out.println("size:"+scoreList.size());
		int removeScore = scoreList.remove(0);
		System.out.println("removeScore:"+removeScore);
		System.out.println("size:"+scoreList.size());
		/*
		<< Think >>
		`System.out.println("---remove(Object o)----");
		System.out.println(scoreList);
		scoreList.remove(new Integer(100));
		System.out.println(scoreList);
		 */
		System.out.println("-----------전체출력-------------");
		for (int i = 0; i < scoreList.size(); i++) {
			int score=scoreList.get(i);
			System.out.print(score+" ");
		}
		System.out.println();
		System.out.println("############전체출력[Iteration]#########");
		Iterator<Integer> scoreIter = scoreList.iterator();
		while (scoreIter.hasNext()) {
			int tempScore=scoreIter.next();
			System.out.print(tempScore+" ");
		}
		System.out.println();
		System.out.println("------------ArrayList[String]---------------");
		ArrayList<String> nameList=new ArrayList<String>();
		nameList.add("KIM");
		nameList.add("SIM");
		nameList.add("CIM");
		nameList.add("VIM");
		String str=new String("UIM");
		nameList.add(str);
		nameList.add("TIM");
		nameList.add("IIM");
		nameList.add("BIM");
		nameList.add("KIM");
		nameList.add("FIM");
		nameList.add("AIM");
		System.out.println("---add---");
		System.out.println("size:"+nameList.size());
		nameList.add("HHH");
		nameList.add(0,"KKK");
		System.out.println("size:"+nameList.size());
		System.out.println(nameList);
		System.out.println("---set---");
		nameList.set(3, "THREE");
		System.out.println(nameList);
		System.out.println("---remove(int index)---");
		nameList.remove(5);
		System.out.println(nameList);
		System.out.println("---remove(Object o)---");
		/*
		Removes the first occurrence of the specified element from this list
		 */
		nameList.remove(new String("KIM"));
		System.out.println(nameList);
		System.out.println("-----------전체출력--------------");
		for (String name:nameList) {
			System.out.print(name+",");
		}
		System.out.println();
		System.out.println("-----------전체출력[Iteration]--------------");
		Iterator<String> nameIter = nameList.iterator();
		while (nameIter.hasNext()) {
			String name = nameIter.next();
			System.out.print(name+",");
		}
		
	}

}












