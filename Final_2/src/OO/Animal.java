package OO;

public abstract class Animal {
    String name;
    int age;

    public Animal(String name, int age) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " is a "+getClass().getSimpleName()+", aged "+age;
    }
}
