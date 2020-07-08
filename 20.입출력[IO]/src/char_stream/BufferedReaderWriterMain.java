package char_stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class BufferedReaderWriterMain 
{
	public static void main(String[] args) throws Exception 
	{
		int lineNo = 0;
		BufferedReader br = new BufferedReader(new FileReader("00.VariableDeclare.txt"));
		PrintWriter pw = new PrintWriter(new FileWriter("00.VariableDeclare_LineNumber_PrintWriter.txt"));
		while (true) 
		{
		
			String readLine = br.readLine();
		
			if (readLine == null) break;
			lineNo++;
			pw.println(lineNo + ":" + readLine);
		}
		pw.flush();
		pw.close();
		System.out.println("-------------BufferedReaderWriter Copy------------");
	}
}
