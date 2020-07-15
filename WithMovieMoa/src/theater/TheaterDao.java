package theater;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import member.MemberVo;

public class TheaterDao {
	private File theaterFile;
	public TheaterDao() throws Exception {
		init();
	}
	private void init() throws Exception {
		theaterFile = new File("theater.ser");
		if (!theaterFile.exists()) {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(theaterFile));
			oos.writeObject(new ArrayList<TheaterVo>());
			oos.close();
			System.out.println("--------파일생성[theater.ser]---------");
		} else {
			System.out.println("--------파일존재[theater.ser]--------");
		}
	}
	private ArrayList<TheaterVo> readFile() throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(theaterFile));
		ArrayList<TheaterVo> theaterList = (ArrayList<TheaterVo>) ois.readObject();
		ois.close();
		return theaterList;
	}
	private void writeFile(ArrayList<TheaterVo> theaterList)  throws Exception{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(theaterFile));
		oos.writeObject(theaterList);
		oos.close();
	}
	/*
	 * Create
	 */
	public void create(TheaterVo theater) throws Exception {
		ArrayList<TheaterVo> theaterList = this.readFile();
		theater.setTheaterNumber(theaterList.size()+1);
		theaterList.add(theater);
		this.writeFile(theaterList);
	}
	
	/*
	 * Read all
	 */
	public ArrayList<TheaterVo> readAll() throws Exception {
		return readFile();
		
	}

	/*
	 * Read One by theaterNumber
	 */
	public TheaterVo readOne(int theaterNumber) throws Exception {
		for (int i = 0; i < readFile().size(); i++) {
			TheaterVo findTheater = readFile().get(i);
			if (findTheater.getTheaterNumber() == theaterNumber) {
				return findTheater;
			}
		}		
		return null;
	}
	
	
	
	
	
	/*
	 * Update
	 */
	public void update(TheaterVo updateTheater) throws Exception {
		ArrayList<TheaterVo> theaterList = this.readFile();		
		for (int i = 0; i < theaterList.size(); i++) {
			if (theaterList.get(i).getTheaterNumber() == updateTheater.getTheaterNumber()) {
				theaterList.set(i, updateTheater);
				break;
			}
		}
		
		this.writeFile(theaterList);
	}
	/*
	 * 극장번호로 삭제
	 */
	public void delete(int theaterNumber) throws Exception {
		ArrayList<TheaterVo> theaterList = this.readFile();
		int count = theaterList.size();
		for (int i = 0; i < theaterList.size(); i++) {
			if (theaterList.get(i).getTheaterNumber() == theaterNumber) {
				count = i;
				theaterList.remove(i);
				break;
			}
		}
		for (int i = count; i < theaterList.size(); i++) {
			theaterList.get(i).setTheaterNumber(theaterList.get(i).getTheaterNumber()-1 );
			this.writeFile(theaterList);
		}
		this.writeFile(theaterList);
	}

	/*
	 * 해당 지역의 해당극장삭제 Delete2
	 */
	public void delete(String theaterName, String theaterCity) throws Exception {
		ArrayList<TheaterVo> theaterList = this.readFile();
		int count = theaterList.size();
		for (int i = 0; i < theaterList.size(); i++) {
			if (theaterList.get(i).getTheaterName().equals(theaterName)
					&& theaterList.get(i).getTheaterCity().equals(theaterCity)) {
				count = i;
				theaterList.remove(i);
				break;
			}
		}
		for (int i = count; i < theaterList.size(); i++) {
			theaterList.get(i).setTheaterNumber(theaterList.get(i).getTheaterNumber()-1 );
			this.writeFile(theaterList);
		}
		this.writeFile(theaterList);
	}
}