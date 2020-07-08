package byte_stream.node_stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/*
 * 1. 데이타 source 선정(파일)
 * 2. 입력스트림(InputStream)객체생성(FileInputStream)
 * 3. 입력스트림(InputStream)으로부터 1바이트씩 읽는다(read).
 * 4. 입력스트림을 닫는다(close) 
 * 
 */
public class FileInputStreamMain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("fileOut.dat");
		
		/*
		public abstract int read()
                throws IOException
			- Reads the next byte of data from the input stream.
			- The value byte is returned as an int in the range 0 to 255.
			- If no byte is available because the end of the stream has been reached,
			  the value -1 is returned.
			- This method blocks until input data is available, 
			  the end of the stream is detected, or an exception is thrown.
		*/
		int readByte = fis.read();
		System.out.println("1.byte:"+Integer.toBinaryString(readByte));
		readByte=fis.read();
		System.out.println("2.byte:"+Integer.toBinaryString(readByte));
		while (true) {
			readByte=fis.read();
			if(readByte==-1)break;
			//System.out.print(readByte);
			//System.out.print((char)readByte);
			System.out.print(Integer.toBinaryString(readByte));
		}
		
		fis.close();
	}

}














