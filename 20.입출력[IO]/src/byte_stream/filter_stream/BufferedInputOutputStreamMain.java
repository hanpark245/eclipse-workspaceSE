package byte_stream.filter_stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BufferedInputOutputStreamMain {

	public static void main(String[] args)  throws Exception{
		FileOutputStream fos=new FileOutputStream("bufferedOut.txt");
		BufferedOutputStream bos=new BufferedOutputStream(fos);
		
		for (int i = 0; i < 256; i++) {
			bos.write(i);
		}
		/*
		Flushes this output stream and forces any buffered output bytes to be written out.
		 */
		bos.flush();
		bos.close();
		System.out.println("bufferedOut.txt -->write");
		
		BufferedInputStream bis=
				new BufferedInputStream(
						new FileInputStream("bufferedOut.txt"));
		while(true) {
			int readByte = bis.read();
			if(readByte==-1)break;
			System.out.print((char)readByte);
		}
		bis.close();
		System.out.println();
		System.out.println("bufferedOut.txt -->read");
	}

}
