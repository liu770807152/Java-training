package OOP;

public class Dog extends Animal{
    @Override
    public void eat() {
        System.out.println("吃狗粮");
    }

    public void work() {
        System.out.println("看家");
    }
}
