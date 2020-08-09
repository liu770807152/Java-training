import java.util.Random;

public class PrimitiveDataType {
    public static void main(String[] args) {
        // 整数类型：占用4字节
        int i = 0;
        System.out.println("i: "+i);
        i += 7;
        System.out.println("i: "+i);
        // double双精度类型： 占8个字节
        double j = 256;
        System.out.println("j: "+j);
        j %= j % 10;
        System.out.println("j: "+j);
        // float单精度类型：占4个字节
        float k = 999;
        System.out.println("k: "+k);
        /* double 和 float 的区别是double精度高，有效数字16位，float精度7位（可提供7位或8位有效数字，构成包括符号位、指数位和尾数位）。
           但double消耗内存是float的两倍，double的运算速度比float慢 */
        System.out.println("======================================================");

        // 布尔类型：只表示true/false
        boolean a = true;
        System.out.println("a: "+a);
        boolean b = false;
        System.out.println("b: "+b);
        // parse意为词法分析，parseBoolean顾名思义就是分析成布尔类型
        String s = "tRuE";
        boolean c = Boolean.parseBoolean(s);
        System.out.println("c: "+c);
        System.out.println("======================================================");

        // Random类用于生成各种随机值，详见：https://docs.oracle.com/javase/8/docs/api/java/util/Random.html
        Random random = new Random();
        boolean temp = random.nextBoolean();
        System.out.println("temp: "+temp);
        /*  常用短路运算：逻辑与&& 逻辑或|| 逻辑非!
            逻辑与操作返回true的唯一可能是&&两边的布尔表达式都是true；两边任意一个表达式为false时，返回false
            逻辑或操作返回true的可能比较多，可能是||左边表达式为true，可能是右边表达式为true，也可能是两边都为true；只有当两边表达式都为false时，才返回false
            逻辑非操作返回右边表达式的否定
            总之，短路运算结果和真值表一致：https://zh.wikipedia.org/zh-hans/%E7%9C%9F%E5%80%BC%E8%A1%A8

            按位与& 和按位或|：
            计算机中的数字都按二进制存储。以int 2为例，二进制的简洁表达方式是10，即 1*2的1次方 + 0*2的0次方 = 2.
            按位与：按位比较两个二进制数的值，都为1得1，其他情况得0；
            按位或：按位比较两个二进制数的值，都为0得0，其他情况得1.
            e.g.
               00010  -> 2               00010 -> 2
             & 01011  -> 11            | 01011 -> 11
             _______                     _________
               00010  -> 2               01011 -> 11
         */
        System.out.println("and: "+(a && b));
        System.out.println("or: "+(a || b));
        System.out.println("not: "+(!a));
        // XOR异或，真值表见：https://zh.wikipedia.org/zh-hans/%E7%9C%9F%E5%80%BC%E8%A1%A8
        System.out.println("xor: "+(a ^ b));


    }
}
