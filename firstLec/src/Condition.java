public class Condition {
    public static void main(String[] args) {
        boolean a = true;
        boolean b = false;
        int c = 2;
        int d = 3;

        // circuit短路操作
        if (a && b) {
            System.out.println("Both are true");
        } else {
            System.out.println("At least one is false");
        }
        if ((c & d) != 0) {
            System.out.println("c和d做按位与操作不为0");
        } else {
            System.out.println("c和d做按位与操作为0");
        }

        if (a || b) {
            System.out.println("One of a and b is true, or both are true");
        } else {
            System.out.println("Both are false");
        }
        if ((c | d) != 0) {
            System.out.println("c和d做按位或操作不为0");
        } else {
            System.out.println("c和d做按位与操作为0");
        }

        if (!a) {
            System.out.println("a is false");
        } else {
            System.out.println("a is true");
        }
    }
}
