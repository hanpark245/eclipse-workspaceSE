
public class GajunFactroyMain 
{
	public static void main(String[] args) 
	{
		System.out.println("-----------------GajunFactory--------------");
		GajunTV tv1 = new GajunTV();
		GajunTV tv2 = new GajunTV();
		GajunSmartPhone sm1 = new GajunSmartPhone();
		GajunSmartPhone sm2 = new GajunSmartPhone();
		GajunSmartPhone sm3 = new GajunSmartPhone();
		GajunAudio audio1 = new GajunAudio();
		GajunAudio audio2 = new GajunAudio();
		
		GajunOnOff[] gajunArray = new GajunOnOff[5];
		gajunArray[0] = tv1;
		gajunArray[1] = tv2;
		gajunArray[2] = sm1;
		gajunArray[3] = sm2;
		gajunArray[4] = sm3;
		gajunArray[5] = audio1;
		gajunArray[6] = audio2; 
		System.out.println("-------------GajunGumsa------------");
		for (int i = 0; i < gajunArray.length; i++) {
			gajunArray[i].turnOn();
			GajunVolume tempGajun = (GajunVolume)gajunArray[i];
			tempGajun.up();
			tempGajun.down();
			gajunArray[i].turnOff(); 
			System.out.println("---------------------" + gajunArray[i].getClass().getName() + "합격-----------------");
		}
	}
}
