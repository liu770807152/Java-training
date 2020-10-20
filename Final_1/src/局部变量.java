public class 局部变量 {
    // 变量x的生命周期仅存在于boo函数内。boo函数结束后，x也随之死亡。

    String num;

    public static void boo(int x) {
        x += 1;
        System.out.println("x is "+x);
        System.out.println("Boo!");
    }

    // 参数x和y是传入参数的拷贝。如果是primitive type（基本数据类型，如int,boolean），是传递值；如果是对象，则变为传递引用（或地址）
    // 详细地说：
    //  a.传递值的数据类型：八种基本数据类型和String(但是事实上String也是传递的地址,只是string对象特殊，string对象不可改变，内容改变就会产生新对象)
    //　b.传递地址的数据类型：除String以外的所有复合数据类型，包括数组、类和接口。
    private static int[] add(int x, int[] array) {
        System.out.println(x);
        // jdk1.5 foreach
        for (int temp : array) {
            System.out.println(temp);
            // 能改变数组吗？
            temp += x;
        }
        for (int temp : array) {
            System.out.println(temp);
        }
        for (int i = 0; i < array.length; i++) {
            // 用索引可以改变数组吗？
            array[i] += x;
        }
        for (int temp : array) {
            System.out.println(temp);
        }
        return array;
    }

    局部变量(String x) {
        this.num = x;
    }

    public static void main(String[] args) {
        int x = 10;
        System.out.println("x is "+x);
        boo(x);
        // x的值是？
        System.out.println("x is "+x);
        int[] temp = new int[]{0, 1, 2};
        int[] result = add(x, temp);
        for (int num : result) {
            System.out.println(num);
        }

        局部变量 obj1 = new 局部变量("Tom");
        局部变量 obj2 = new 局部变量("Kay");
        局部变量 obj3 = new 局部变量("Mom");
        局部变量[] array = {obj1, obj2, obj3};
        for (局部变量 t : array) {
            t.num = "123";
            System.out.println(t.num);
        }
    }
}
