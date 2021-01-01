package fourthLec;

public class Hanoi {
    /**
     * 动画演示：http://www.hannuota.cn/
     * @param n N个柱子
     * @param A A柱
     * @param B B柱
     * @param C C柱
     */
    private static void hanoi(int n, char A, char B, char C) {
        if (n == 1) {
            System.out.println(A+"->"+C);
        } else {
            hanoi(n-1, A, C, B);
            System.out.println(A+"->"+C);
            hanoi(n-1, B, A, C);
        }
    }

    public static void main(String[] args) {
        hanoi(100, 'A', 'B', 'C');
    }
}
