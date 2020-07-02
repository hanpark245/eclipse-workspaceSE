
public class GajunGumsa 
{
	private GajunOnOff[] gajunArray;
	
	public GajunOnOff[] getGajunArray()
	{
		return gajunArray;
	}
	
	public void setGajunArray(GajunOnOff[] gajunArray)
	{
		this.gajunArray = gajunArray;
	}
	public void gumsa()
	{
		for (int i = 0; i < gajunArray.length; i++) {
			gajunArray[i].turnOn();
			GajunVolume tempGajun = (GajunVolume)gajunArray[i];
			tempGajun.up();
			tempGajun.down();
			gajunArray[i].turnOff();
		}
	}
	
}
