package byte_stream.filter_stream;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class AccountReadMain {

	public static void main(String[] args) throws Exception{
		System.out.println("--------Account객체내용파일에서 읽기--------");
		DataInputStream accountDis=
				new DataInputStream(
						new FileInputStream("account.dat"));
		Account readAccount1=
				new Account(accountDis.readInt(),
							accountDis.readUTF(),
							accountDis.readInt(),
							accountDis.readDouble());
		Account readAccount2=
				new Account(accountDis.readInt(),
						accountDis.readUTF(),
						accountDis.readInt(),
						accountDis.readDouble());
		
		readAccount1.print();
		readAccount2.print();
		

	}

}
