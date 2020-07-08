package byte_stream.object_stream;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import byte_stream.filter_stream.Account;

public class ObjectOutputStreamMain {

	public static void main(String[] args)throws Exception{
		/*
		 * 자바객체의 직렬화를 가능하게하려면
		 * 반드시 java.io.Serializable interface를 implement해야한다.
		 * 
		 */
		ObjectOutputStream oos=
				new ObjectOutputStream(
						new FileOutputStream("objects.ser"));
		
		
		String msg1=new String("객체스트림");
		Integer wi2=new Integer(2147483647);
		Account account3=new Account(1223,"김수한",34000,3.333);
		Account account4=new Account(3451,"김우한",78000,5.333);
		System.out.println("String Object write --> objects.ser");
		oos.writeObject(msg1);
		System.out.println("Integer Object write --> objects.ser");
		oos.writeObject(wi2);
		System.out.println("Account Object write1 --> objects.ser");
		oos.writeObject(account3);
		System.out.println("Account Object write2 --> objects.ser");
		oos.writeObject(account4);
		
		oos.flush();
		oos.close();
		
	}

}
