package char_stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class BufferedReaderPrintWriterMain {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new FileReader("00.VariableDeclare.txt"));
		PrintWriter pw=new PrintWriter(new FileWriter("00.VariableDeclare_LineNumber_PrintWriter.txt"));
		int lineNo=0;
		while (true) {
			String readLine = br.readLine();
			if(readLine==null)break;
			lineNo++;
			pw.println(lineNo+":"+readLine);
		
		}
		pw.flush();
		pw.close();
		System.out.println("----------BufferedReaderPrintWriter Copy-------------");
		

	}

}
