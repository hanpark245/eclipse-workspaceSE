package byte_stream.node_stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 1. 데이타 목적지(target) 선정(파일)
 * 2. 출력스트림(OutputStream)객체생성(FileOutputStream)
 * 3. 출력스트림(OutputStream)에 1바이트씩 쓴다(write).
 * 4. 출력스트림을 닫는다(close) 
 * 
 */
public class FileOutputStreamMain {

	public static void main(String[] args) throws IOException {
		
		FileOutputStream fos=new FileOutputStream("fileOut.dat");
		/*
		 << OutputStream >>
		    public abstract void write(int b) throws IOException;
		    	- Writes the specified byte to this output stream.
		    	- The general contract for write is that 
		    	   one byte is written to the output stream. 
		    	- The byte to be written is the eight low-order bits of the argument b.
		    	   The 24 high-order bits of b are ignored.
		 */
		/*
		  00000000|00000000|00000000|01000001
		 */
		fos.write(65);
		/*
		  00000000|00000000|00000000|01000010
		 */
		fos.write(66);
		/*
		 011111111|11111111|11111111|11111111
		 */
		fos.write(2147483647);
		/*
		 00000000|00000000|00000000|11111111
		 */
		fos.write(255);
		fos.write('C');
		fos.write('D');
		for (int i = 0; i < 256; i++) {
			fos.write(i);
		}
		fos.close();
		System.out.println("FileOutputStream.write!!!");
	}

}











