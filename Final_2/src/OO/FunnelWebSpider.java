package OO;

public final class FunnelWebSpider extends Arachnid implements Venomous {
    public FunnelWebSpider(String name, int age) {
        super(name, age);
    }

    @Override
    public boolean isLeathalToAdultHumans() {
        return true;
    }
}
