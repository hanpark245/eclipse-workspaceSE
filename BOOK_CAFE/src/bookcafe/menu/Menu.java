
package bookcafe.menu;
import java.io.Serializable;

public class Menu implements Serializable {
	
	private int menu_no;//메뉴번호
	private int menu_price;//메뉴가격
	private String menu_name;//메뉴이름
	private int menu_stock;//메뉴수량
	public final static int AMERICANO=1;
	public final static int ESPRESSO=2;
	public final static int CARAMELMACCHIATO=3;
	public final static int CAFEMOCHA=4;
	public final static int CAFELATTE=5;
	public final static int VANILLALATTE=6;
	public final static int GREENTEALATTE=7;
	public final static int FRAPPUCCINO=8;
	public final static int COKE=9;
	public final static int MOCHABUN=10;
	public final static int CHEESECAKE=11;
	public final static int TIRAMISU=12;
	public final static int SANDWICH=13;
	public final static int HONEYBREAD=14;
	public final static int RAMEN=15;
	public final static int SPAGHETTI=16;
	public final static int DONKATSU=17;
	public final static int CURRY=18;

	public Menu(){}

	public Menu(int menu_no,String menu_name,int menu_price,int menu_stock) {
		super();
		this.menu_no = menu_no;
		this.menu_name = menu_name;
		this.menu_price = menu_price;
		this.menu_stock = menu_stock;
	}

	
	public int getMenu_no() {
		return menu_no;
	}
	public void setMenu_no(int menu_no) {
		this.menu_no = menu_no;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public int getMenu_price() {
		return menu_price;
	}
	public void setMenu_price(int menu_price) {
		this.menu_price = menu_price;
	}
	public int getMenu_stock() {
		return menu_stock;
	}
	public void setMenu_stock(int menu_stock) {
		this.menu_stock = menu_stock;
	}
	@Override
	public String toString() {
		
		return +menu_no+" "+menu_name+" "+menu_price+" "+menu_stock+"\n";
	}
	

}
