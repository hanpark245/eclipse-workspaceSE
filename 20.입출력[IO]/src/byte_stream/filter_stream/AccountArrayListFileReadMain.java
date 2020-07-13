package byte_stream.filter_stream;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;

public class AccountArrayListFileReadMain {

	public static void main(String[] args) throws Exception{
	
		ArrayList<Account> accountList=new ArrayList<Account>();
		DataInputStream accountListDis=
				new DataInputStream(
						new FileInputStream("accountList.dat"));
		
		int size = accountListDis.readInt();
		for (int i = 0; i < size; i++) {
			accountList.add(
					new Account(	accountListDis.readInt(),
							 		accountListDis.readUTF(), 
							 		accountListDis.readInt(), 
							 		accountListDis.readDouble())
								);
		}
		accountListDis.close();
		
		Account.headerPrint();
		for (Account account : accountList) {
			account.print();
		}
		
	}

}









