import java.util.Scanner;

public class IO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter an integer a: ");
        int a = in.nextInt();
        System.out.println("Enter a string b: ");
        // next()读到空格或者换行符就停止
        String b1 = in.nextLine();
        String b2 = in.nextLine();
        System.out.println("Enter a string c: ");
        // nextLine()仅读到换行符才停止
        String c = in.next();

        System.out.println("a: "+a+", b: "+b2+c);
    }
}
