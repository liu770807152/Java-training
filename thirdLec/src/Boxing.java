public class Boxing {
    public static void main(String[] args) {
        Integer a = Integer.valueOf(6); // explicitly boxing
        Integer b = 6;  // auto boxing

        int c = b;  // auto unboxing

        if (a == b) {
            System.out.println("a ("+a+") == b ("+b+")");
        } else {
            System.out.println("a ("+a+") != b ("+b+")");
        }

        if (a.equals(b)) {
            System.out.println("a ("+a+") equals b ("+b+")");
        } else {
            System.out.println("a ("+a+") !equals b ("+b+")");
        }

        if (a == c)  // auto unboxing before the comparison
        {
            System.out.println("a ("+a+") == c ("+c+")");
        } else {
            System.out.println("a ("+a+") != c ("+c+")");
        }

    }

}
