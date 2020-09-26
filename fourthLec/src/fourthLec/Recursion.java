package fourthLec;

public class Recursion {
    public static int fi(int index) {
        System.out.println("current index is " + index);
        if (index == 1 || index == 2) {
            return 1;
        }
        return fi(index-1) + fi(index-2);
    }

    public static void main(String[] args) {
        System.out.println(fi(1));
        System.out.println("======================================");

        System.out.println(fi(2));
        System.out.println("======================================");

        System.out.println(fi(5));
    }
}
