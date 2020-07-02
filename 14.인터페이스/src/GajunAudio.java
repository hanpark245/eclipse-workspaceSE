
public class GajunAudio implements GajunOnOff, GajunVolume
{
	@Override
	public void turnOn()
	{
		System.out.println("GajunSmartPhone.turnOn()");
	}
	@Override
	public void turnOff()
	{
		System.out.println("GajunSmartPhoine.turnOff()");
	}
	
	
	@Override
	public void up()
	{
		System.out.println("GajunSmartPhone.VolumeUp()");
	}
	@Override
	public void down()
	{
		System.out.println("GajunSmartPhone.VolumeDown()");
	}
}
