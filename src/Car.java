public class Car{
    public int speed = 5;
    public int wheels = 4;

    public void go(){
        System.out.println("GO Speed : " + speed);
    }

    public void stop(){
        System.out.println("Stop");
    }
}

class Test{

    public void show(){
        Car car1 = new Car();
        car1.go();
    }
}