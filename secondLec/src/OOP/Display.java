package OOP;

public class Display {
    public static void show(Animal other) {
        other.eat();
        // 类型判断
        if (other instanceof Cat) {
            Cat tmp = (Cat) other;
            tmp.work(); // 猫做的事情
        } else if (other instanceof Dog) {
            Dog tmp = (Dog) other;
            tmp.work(); // 狗做的事情
        }
    }

    public static void main(String[] args) {
        show(new Cat());  // 以 Cat 对象调用 show 方法
        show(new Dog());  // 以 Dog 对象调用 show 方法

        Animal animal = new Cat();  // 向上转型
        animal.eat();  // 调用的是 Cat 的 eat()
        //animal.work();  // Animal类没有work方法

        Cat cat = (Cat) animal;  // 向下转型
        cat.work();  // 调用的是 Cat 的work方法
    }
}
