package byte_stream.filter_stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileFilterCopyMain {

	public static void main(String[] args) throws Exception {
		FileInputStream fis=new FileInputStream("eclipse-inst-win64.exe");
		BufferedInputStream bis=new BufferedInputStream(fis);
		
		FileOutputStream fos=new FileOutputStream("eclipse-inst-win64_copy.exe");
		BufferedOutputStream bos=new BufferedOutputStream(fos);
		
		int count=0;
		while (true) {
			int readByte = bis.read();
			if(readByte==-1)break;
			bos.write(readByte);
			count++;
			if(count%(1024*1024)==0) {
				System.out.print("▶");
			}
			
		}
		bos.close();
		bis.close();
		System.out.println();
		System.out.println(">>>> FileCopy: "+count+ " bytes..");
		
	}

}
