package com.itwill.객체파일저장;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import com.itwill.account.Account;

public class 객체파일읽기Main {
  
	public static void main(String[] args) throws Exception {
		ObjectInputStream ois=
				new ObjectInputStream(new FileInputStream("objectToFile.ser"));
		String title=(String)ois.readObject();
		int count = (Integer)ois.readObject();
		Account acc1=(Account)ois.readObject();
		ArrayList<Account> accountList=(ArrayList<Account>)ois.readObject();
		System.out.println(title);
		System.out.println(count);
		System.out.println(acc1);
		System.out.println(accountList);
		

	}

}
