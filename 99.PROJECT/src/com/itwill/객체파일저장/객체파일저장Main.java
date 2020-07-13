package com.itwill.객체파일저장;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.itwill.account.Account;

public class 객체파일저장Main {

	public static void main(String[] args) throws Exception{
		String title="제목";
		Integer count=56;
		Account acc1=new Account(2321, "김수한무", 98564, 2.13265465);
		ArrayList<Account> accountList=new ArrayList<Account>();
		accountList.add(new Account(8888, "팔팔팔", 453454, 1.2));
		accountList.add(new Account(8989, "팔구팔",90909090, 9.0));
		
		ObjectOutputStream oos=
				new ObjectOutputStream(
						new FileOutputStream("objectToFile.ser"));
		
		oos.writeObject(title);
		oos.writeObject(count);
		oos.writeObject(acc1);
		oos.writeObject(accountList);
		System.out.println("-------[objectToFile.ser--> writeObject()]--------");
		

	}

}
