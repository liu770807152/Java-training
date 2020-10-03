public class Switch {
    public static void main(String[] args) {
        int c = 7;
        switch (c) {
            // 逐个匹配c
            case 1:
                // 匹配成功则跳入
                System.out.println("c == 1");
                // break非常重要！有了break才能停止匹配，跳出switch block
                break;
            case 2:
                System.out.println("c == 2");
                break;
            // 除了1和2的其他所有情况
            default:
                System.out.println("Something else");
        }

    }
}
