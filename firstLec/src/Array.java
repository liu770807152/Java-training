import java.util.Random;

public class Array {
    public static void main(String[] args) {
        double d[];
        d = new double[5];
        d[0] = 1.0;
        // 中间自动填充0
        d[4] = 3.2;
        System.out.println(d[0]);
        System.out.println(d[1]);
        System.out.println(d[2]);
        System.out.println(d[3]);
        System.out.println(d[4]);
        d[4] = 3.3;
        System.out.println(d[4]);
        System.out.println("Length of d is: "+d.length);

        int x = 7;
        // int[] i = new int[5];
        int[] i = { 2, 3, 4, 5, x};
        System.out.println(i[0]);
        System.out.println(i[4]);
        x = 42;
        // i[4]已经指向了7的内存区域，x重定向至新的内存区域不影响数组i
        // 结果是？
        System.out.println(i[4]);

    }
}
