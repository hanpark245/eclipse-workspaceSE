package char_stream;

import java.io.FileReader;
import java.io.FileWriter;

public class FileReaderWriterCopyMain {

	public static void main(String[] args) throws Exception{
		FileReader fr=new FileReader("00.VariableDeclare.txt");
		FileWriter fw=new FileWriter("00.VariableDeclare_copy.txt");
		
		while(true) {
			int readChar = fr.read();
			if(readChar==-1)break;
			fw.write(readChar);
		}
		fr.close();
		fw.flush();
		fw.close();
		System.out.println("--------FileReaderWriterCopy------");

	}

}
