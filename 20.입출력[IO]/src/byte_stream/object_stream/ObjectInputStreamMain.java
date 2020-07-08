package byte_stream.object_stream;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import byte_stream.filter_stream.Account;

public class ObjectInputStreamMain {

	public static void main(String[] args) throws Exception{
		ObjectInputStream ois=
				new ObjectInputStream(new FileInputStream("objects.ser"));
		
		System.out.println("--------objects.ser-->String Object read--------------");
		String msg1=(String)ois.readObject();
		System.out.println(msg1);
		System.out.println("--------objects.ser-->Integer Object read--------------");
		Integer wi2=(Integer)ois.readObject();
		System.out.println(wi2);
		System.out.println("--------objects.ser-->Account Object read--------------");
		Account account3=(Account)ois.readObject();
		account3.print();
		System.out.println("--------objects.ser-->Account Object read--------------");
		Account account4=(Account)ois.readObject();
		account4.print();
	}

}
