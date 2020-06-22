
public class PrintOverloadingMain 
{
	public static void main(String[] args) 
	{
		Print p = new Print();
		p.print('김');
		p.print("김경호");
		p.print(3.15748);
		p.print(23145362);
	}
}
