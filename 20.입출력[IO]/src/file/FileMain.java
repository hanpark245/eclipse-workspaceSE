package file;

import java.io.File;
import java.io.IOException;

public class FileMain {

	public static void main(String[] args) {
		System.out.println("1.파일구분자:"+File.separator);
		/*
		 *기준경로
		 *  eclise--> C:\JAVA_PYTHON\eclipse-workspaceSE\20.입출력[IO]
		 *상대경로
		 *    기준경로를 기준으로 경로를 기술
		 *절대경로
		 *    C:,D: 드라이브 기준으로 경로를 기술 
		 *       
		 */
		File file1=new File("image.png");
		//File file2=new File("sample\\A.크롬다운로드URL.txt");
		File file2=new File("sample/A.크롬다운로드URL.txt");
		File file3=new File("sample","Z.WB플러그인URL.txt");
		File file4=new File("C:\\JAVA_PYTHON\\eclipse-workspaceSE\\20.입출력[IO]\\sample\\B.윈도우PATH환경변수.txt");
		System.out.println();
		System.out.println("2.file path:"+file1.getPath());
		System.out.println("2.file path:"+file2.getPath());
		System.out.println("2.file path:"+file3.getPath());
		System.out.println("2.file path:"+file4.getPath());
		System.out.println();
		System.out.println("3.file absolute path:"+file1.getAbsolutePath());
		System.out.println("3.file absolute path:"+file2.getAbsolutePath());
		System.out.println("3.file absolute path:"+file3.getAbsolutePath());
		System.out.println("3.file absolute path:"+file4.getAbsolutePath());
		System.out.println();
		System.out.println("4.file name:"+file1.getName());
		System.out.println("4.file name:"+file2.getName());
		System.out.println("4.file name:"+file3.getName());
		System.out.println("4.file name:"+file4.getName());
		System.out.println();
		System.out.println("5.file parent:"+file1.getParent());
		System.out.println("5.file parent:"+file2.getParent());
		System.out.println("5.file parent:"+file3.getParent());
		System.out.println("5.file parent:"+file4.getParent());
		
		File dir1=new File("sample");
		File dir2=new File("sample/subSample1");
		File dir3=new File("sample","subSample2");
		
		System.out.println("6.isDirectory:"+dir1.isDirectory());
		System.out.println("6.isDirectory:"+dir2.isDirectory());
		System.out.println("6.isDirectory:"+dir3.isDirectory());
		System.out.println("6.isFile:"+file1.isFile());
		System.out.println("7.디렉토리안에 파일(디렉토리)의 String[]목록");
		String[] fileNameList=dir1.list();
		for (String fileName : fileNameList) {
			System.out.println("\t"+fileName);
		}
		System.out.println("8.디렉토리안에 파일(디렉토리)의 File[]목록");
		File[] fileList = dir1.listFiles();
		for (File file : fileList) {
			if(file.isDirectory()) {
				System.out.println("\tD:"+file.getName());
				/*
				File[] subFileList=file.listFiles();
				for (File subFile : subFileList) {
					System.out.println("\t\t"+subFile.getName());
				}
				*/
			}else if(file.isFile()) {
				System.out.println("\tF:"+file.getName());
			}
		}
		System.out.println("9. root directory 목록");
		File[] rootDirs = File.listRoots();
		for (File file : rootDirs) {
			System.out.println(file.getPath());
		}
		System.out.println("---------- C: ----------------");
		File rootC=new File("c:\\");
		File[] rootCFiles=rootC.listFiles();
		for (File file : rootCFiles) {
			if(file.isDirectory()) {
				System.out.println("\tD:"+file.getName());
			}else {
				System.out.println("\tF:"+file.getName());
			}
		}
		System.out.println("10.Directory생성");
		File newDir1 = new File("newDir1");
		File newDir2= new File("newDir2");
		File newDir3= new File("sample","subSample4");
		System.out.println("newDir1의 존재여부:"+newDir1.exists());
		System.out.println("newDir1의 생성여부:"+newDir1.mkdir());
		System.out.println(newDir2.mkdir());
		System.out.println(newDir3.mkdir());
		System.out.println("11.Directory이름변경");
		boolean isRename = 
				newDir2.renameTo(new File("renameDir2"));
		System.out.println(">>이름변경여부:"+isRename);
		System.out.println("12.Directory삭제");
		boolean isRemove = newDir3.delete();
		System.out.println(">>newDir3삭제여부:"+isRemove);
		System.out.println("13.File생성");
		try {
			File newFile=new File("newDir1","newFile.txt");
			boolean isCreate=newFile.createNewFile();
			System.out.println(">>파일생성여부:"+isCreate);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
