package OO;

public final class Playtypus extends Monotrene implements Venomous {
    public Playtypus(String name, int age) {
        super(name, age);
    }

//    @Override
//    public void test() {
//        return;
//    }

    public void quack() {
        System.out.println("Quack!");
    }

    @Override
    public boolean isLeathalToAdultHumans() {
        return false;
    }
}
