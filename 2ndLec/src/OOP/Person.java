package OOP;
// package用于管理.class字节码文件，作用类似于文件夹。
// package意为包，在一个包内的文件可以共享一定的作用域。
// 不同的包之间的从属关系用.表示，如：COMP.COMP1110

public class Person {
    // 私有属性
    private int age;
    private String name;

    // 构造函数，在创建该类的对象时立即调用，大致底层过程详见文档
    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public static void main(String[] args) {
        Person mary = new Person(19, "Sue");
        Person fred = new Person(21, "Fred");
        System.out.println("I created a person: "+mary);
        System.out.println("I created a person: "+fred);
    }

    // 序列化方法（serialization），当打印该类的对象的值时，负责将该对象的属性以一定的逻辑转换成字符串
    @Override
    public String toString() {
        return name + " is aged " + age;
    }
}

