package reserve;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class ReserveDao {
	private File resFile;
	public ReserveDao() throws Exception {
		init();
	}
	private void init() throws Exception {
		resFile = new File("Reserve.ser");
		if (!resFile.exists()) {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(resFile));
			oos.writeObject(new ArrayList<ReserveVo>());
			oos.close();
			System.out.println("--------颇老积己[Reserve.ser]---------");
		} else {
			System.out.println("--------颇老粮犁[Reserve.ser]--------");
		}
	}
	private ArrayList<ReserveVo> readFile() throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(resFile));
		ArrayList<ReserveVo> resList = (ArrayList<ReserveVo>) ois.readObject();
		ois.close();
		return resList;
	}
	private void writeFile(ArrayList<ReserveVo> resList)  throws Exception{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(resFile));
		oos.writeObject(resList);
		oos.close();
	}
	/*
	 * Create
	 */
	public void create(ReserveVo res) throws Exception {
		ArrayList<ReserveVo> resList = this.readFile();
		resList.add(res);
		this.writeFile(resList);
	}
	
	/*
	 * Read all
	 */
	public ArrayList<ReserveVo> readAll() throws Exception {
		return readFile();
		
	}
	
	/*
	 * Delete
	 */
}
