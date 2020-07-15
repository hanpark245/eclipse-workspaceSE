package reserve;

import java.util.ArrayList;

public class ReserveService {

	ReserveDao reserveDao;
	
	public ReserveService() throws Exception {
		reserveDao = new ReserveDao();
	}
	
	public void reserveRegister(ReserveVo res) throws Exception{
		reserveDao.create(res);
	}
	
	public ArrayList<ReserveVo> findAllReserve() throws Exception{
		return reserveDao.readAll();
	}
	
	public ArrayList<ReserveVo> findResListByID(String ID) throws Exception {
		ArrayList<ReserveVo> resList = reserveDao.readAll();
		ArrayList<ReserveVo> tempList = new ArrayList<ReserveVo>();
		for (int i = 0; i < resList.size(); i++) {
			if(resList.get(i).getResID().equals(ID)) {
				tempList.add(resList.get(i));
			}
		}
		return tempList;
	}

	
}
