package byte_stream.object_stream;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import byte_stream.filter_stream.Account;

public class AccountArrayListDeserializationMain {

	public static void main(String[] args) throws Exception{
		ObjectInputStream ois=
				new ObjectInputStream(new FileInputStream("accountList.ser"));
		
		List<Account> accountList=(List<Account>)ois.readObject();
		System.out.println("------ accountList.ser --> ArrayList<Student> read-----");
		Account.headerPrint();
		for (Account account : accountList) {
			account.print();
		}
	}

}









