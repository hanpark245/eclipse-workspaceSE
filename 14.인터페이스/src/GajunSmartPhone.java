public class GajunSmartPhone implements GajunOnOff {

    public void operation1(){
    }

    public void operation2(){
    }
    @Override
    public void turnOn()
    {
    	System.out.println("GajunOnOff.turnOn()");
    }
    @Override
    public void turnOff()
    {
    	System.out.println("GajunOnOff.turnOff()");
    }
}
