
public class Car 
{
	public static int count;		//차량의 총 생산대수
	private int no;			//차번호
	private String model;	//차모델명
	private String color;	//색상
	
	public Car()
	{
		Car.count++;
	}
	public Car(int no, String model, String color)
	{
		this.no = no;
		this.model = model;
		this.color = color;
		Car.count++;
	}
	
	public void print()
	{
		System.out.println(no + "\t" + model + "\t" + color);
	}
	
	//GETTER SETTER
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
}
