package OOP;

public class Inheritence {
    public static void main(String[] args) {
        Person mary = new Student(19, "Mary", "u1234567");
        Person fred = new COMP1110Student(21, "Fred", "u2345678", 4, 20, 3, 4, 7, 70);
        System.out.println("I created a student: "+mary);
        System.out.println("I created a student studying COMP1110: "+fred);
    }
}

