public class GajunTV implements GajunOnOff {

    public void operation1(){
    }

    public void operation2(){
    }

    public void operation3(){
    }

    public void operation4(){
    }
    @Override
    public void turnOn()
    {
    	System.out.println("GajunOnOff.turnOn()구현");
    	System.out.println("TV.turnOn");
    }
    @Override
    public void turnOff()
    {
    	System.out.println("GajunOnOff.turnOff()구현");
    	System.out.println("TV.turnOff");
    }

}
