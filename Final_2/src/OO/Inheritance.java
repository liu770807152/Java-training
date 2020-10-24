package OO;

public class Inheritance {
    public static void main(String[] args) {
        Human bob = new Human("Bob", 13);
        Dog spot = new Dog("Spot", 4);
        FruitBat fred = new FruitBat("Fred", 3);
        Albotross alex = new Albotross("Alex", 45);
        EasternBrownSnake steph = new EasternBrownSnake("Steph", 40);
        GreatWhiteShark george = new GreatWhiteShark("George", 20);
        FunnelWebSpider felicity = new FunnelWebSpider("Felicity", 1);
        Playtypus pat = new Playtypus("Pat", 10);

        Animal[] animals = {bob, spot, fred, alex, steph, george, felicity, pat};

        Playtypus p = (Playtypus) animals[7];
        p.quack();

        for (Animal a : animals) {
            System.out.println(a);
            if (a instanceof Playtypus)
                ((Playtypus)a).quack();
        }


        System.out.println("These animals are venomous:");
        for (Animal a : animals) {
            if (a instanceof Venomous) {
                Venomous nasty = (Venomous) a;
                if (nasty.isLeathalToAdultHumans()) {
                    System.out.println(nasty+" is lethal");
                } else {
                    System.out.println(nasty+" is venomous but non-lethal");
                }
            }
        }
    }
}
