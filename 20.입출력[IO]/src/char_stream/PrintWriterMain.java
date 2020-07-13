package char_stream;

import java.io.FileWriter;
import java.io.PrintWriter;

public class PrintWriterMain {

	public static void main(String[] args) throws Exception{
		PrintWriter pw=new PrintWriter(new FileWriter("printWriter.txt"));
		pw.println(2142134);
		pw.println(true);
		pw.println('문');
		pw.println('자');
		pw.println(23.2651);
		pw.println("문자열~~~");
		
		pw.flush();
		pw.close();
		System.out.println("---------PrintWriter.print---------");

	}

}
