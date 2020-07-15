package seat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import theater.TheaterVo;


public class SeatDao {
	private File seatFile;
	public SeatDao() throws Exception {
		init();
	}
	private void init() throws Exception {
		seatFile = new File("Seat.ser");
		if (!seatFile.exists()) {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(seatFile));
			oos.writeObject(new ArrayList<SeatVo>());
			oos.close();
			System.out.println("--------颇老积己[Reserve.ser]---------");
		} else {
			System.out.println("--------颇老粮犁[Reserve.ser]--------");
		}
	}
	private ArrayList<SeatVo> readFile() throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(seatFile));
		ArrayList<SeatVo> seatList = (ArrayList<SeatVo>) ois.readObject();
		ois.close();
		return seatList;
	}
	private void writeFile(ArrayList<SeatVo> seatList)  throws Exception{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(seatFile));
		oos.writeObject(seatList);
		oos.close();
	}
	/*
	 * Create
	 */
	public void create(SeatVo seat) throws Exception {
		ArrayList<SeatVo> seatList = this.readFile();
		seat.setSeatNumber(seatList.size()+1);
		seatList.add(seat);
		this.writeFile(seatList);
	}
	
	/*
	 * Read all
	 */
	public ArrayList<SeatVo> readAll() throws Exception {
		return readFile();
		
	}
	
	/*
	 * Read One
	 */
	public SeatVo readOne(int seatNumber) throws Exception {
		for (int i = 0; i < readFile().size(); i++) {
			SeatVo findSeat = readFile().get(i);
			if (findSeat.getSeatNumber() == seatNumber) {
				return findSeat;
			}
		}		
		return null;
	}
	
	/*
	 * Delete
	 */
	public void delete(int seatNumber) throws Exception {
		ArrayList<SeatVo> seatList = this.readFile();
		int count = seatList.size();
		for (int i=0;i<seatList.size();i++) {
			if(seatList.get(i).getSeatNumber()==seatNumber) {
				count = i;
				seatList.remove(i);
				break;
			}
		}
		for (int i = count; i < seatList.size(); i++) {
			seatList.get(i).setSeatNumber(seatList.get(i).getSeatNumber()-1);
		}
		this.writeFile(seatList);
	}
}
