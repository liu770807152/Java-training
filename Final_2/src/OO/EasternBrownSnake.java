package OO;

public final class EasternBrownSnake extends Reptile implements Venomous {
    public EasternBrownSnake(String name, int age) {
        super(name, age);
    }

    @Override
    public boolean isLeathalToAdultHumans() {
        return false;
    }
}
