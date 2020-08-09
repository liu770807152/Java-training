public class Function {

    // 变量x的生命周期仅存在于boo函数内。boo函数结束后，x也随之死亡。
    private static void boo() {
        int x = 12;
        System.out.println("x is "+x);
        System.out.println("Boo!");
    }

    // 参数x和y是传入参数的拷贝。如果是primitive type（基本数据类型，如int,boolean），是传递值；如果是对象，则变为传递引用（或地址）
    // 详细地说：
    //  a.传递值的数据类型：八种基本数据类型和String(但是事实上String也是传递的地址,只是string对象特殊，string对象不可改变，内容改变就会产生新对象)
    //　b.传递地址的数据类型：除String以外的所有复合数据类型，包括数组、类和接口。
    private static void add(int x, int[] array) {
        System.out.println(x);

        for (int temp : array) {
            System.out.println(temp);
            // 为什么改不了数组？
            temp += 1;
        }
        for (int temp : array) {
            System.out.println(temp);
        }
        for (int i = 0; i < array.length; i++) {
            // 为什么用索引就可以？
            array[i] += 1;
        }
        for (int temp : array) {
            System.out.println(temp);
        }
    }

    public static void main(String[] args) {
        int x = 10;
        System.out.println("x is "+x);
        boo();
        // x还是10
        System.out.println("x is "+x);
        add(x, new int[]{0, 1, 2});
    }
}
