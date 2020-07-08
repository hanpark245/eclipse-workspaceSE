package byte_stream.filter_stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamMain {
	public static void main(String[] args) throws Exception {
		PrintStream ps = new PrintStream(new FileOutputStream("print.txt"));
		
		ps.write('A');
		ps.write(65);
		
		ps.print(65);
		ps.write('6');
		ps.write('5');
		System.out.println();
		ps.print(true);
		ps.print(12345678);
		ps.println("문자열");
		
		ps.flush();
		ps.close();
		System.out.println("--------print---------");
		
	}
}
