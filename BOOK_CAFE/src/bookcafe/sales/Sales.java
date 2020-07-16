package bookcafe.sales;

import java.io.Serializable;

public class Sales implements Serializable {
	private String sales_date;
	private int sales_food;
	private int sales_tm; // 시간 총 매출
	private int sales_tot;
	
	// 생성자 부분
	public Sales(String sales_date, int sales_food, int sales_tm, int sales_tot) {
		super();
		this.sales_date = sales_date;
		this.sales_food = sales_food;
		this.sales_tm = sales_tm;
		this.sales_tot = sales_tot;
	}

	// 값을 받고 주고 하는 부분
	
	public String getSales_date() {
		return sales_date;	// sm edit
	}
	
	/*public String getSales_month() {	// sm add
		return sales_date.split("/")[1];
	}*/

	public void setSales_date(String sales_date) {
		this.sales_date = sales_date;
	}

	public int getSales_tot() {
		return sales_tot;
	}

	public void setSales_tot(int sales_tot) {
		this.sales_tot = sales_tot;
	}

	public int getSales_food() {
		return sales_food;
	}

	public void setSales_food(int sales_food) {
		this.sales_food = sales_food;
	}

	public int getSales_tm() {
		return sales_tm;
	}

	public void setSales_tm(int sales_tm) {
		this.sales_tm = sales_tm;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.sales_date+"\t"+this.sales_tot+"\t"+this.sales_food+"\t"+this.sales_tm+"\n";
	}
	
	
	
	
	
	
	
	
}
