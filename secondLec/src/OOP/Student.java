package OOP;

public class Student extends Person {
    // 特殊的私有属性，Person类是没有的
    private String uid;

    public Student(int age, String name, String uid) {
        // 调用父类的构造函数
        super(age, name);
        this.uid = uid;
    }

    // 额外且具体的新方法，父类也没有
    public String getUid() {
        return uid;
    }

    // 新的序列化方法
    @Override
    public String toString() {
        return super.toString() + ", has uid "+uid;
    }
}

