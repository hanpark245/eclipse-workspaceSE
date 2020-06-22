
public class Car 
{
	public int no;			//차량번호
	public String model;	//차량모델
	public Engine engine;	//차량엔진
	public Car()
	{
		
	}
	public Car(int no, String model, Engine engine)
	{
		this.no = no;
		this.model = model;
		this.engine = engine;
	}
	
	//public void print()
	//{
	//	System.out.print(this.no+"\t"+this.model+"\t"+this.engine);
	//}
	
	
	//getter,setter
		public void setEngine(Engine engine) {
			this.engine=engine;
		}
		
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
		
	public void print()
	{
		System.out.println(this.no + "\t" + this.model + "\t");  
		this.engine.print();
	}
	public Engine getEngine() 
	{
		return this.engine;
	}
			
	
	
}

