import java.util.Random;

public class MathOperator {
    public static void main(String[] args) {
        /* ====================================算术运算符================================== */
        int w = 122;
        System.out.println("w: "+w);
        // 二进制表示
        int x = 0b110000;
        System.out.println("x: "+x);

        String s = "23";
        int z = Integer.parseInt(s);
        System.out.println("z: "+z);

        Random r = new Random();
        // 设定随机范围
        int y = r.nextInt(6);
        System.out.println("random: "+y);
        System.out.println("add: "+3+5);
        System.out.println("add: "+(3+5));
        System.out.println("sub: "+(3-5));
        System.out.println("mul: "+(3*5));
        System.out.println("div: "+(3.0/5));
        System.out.println("rem: "+(3%5));
        System.out.println("rem: "+(-3%5));

        System.out.println("int: "+5);
        System.out.println("convert to double: "+(double)5);

        System.out.println("max: "+Integer.MAX_VALUE);
        System.out.println("min: "+Integer.MIN_VALUE);

        int sum = x + 5;
        System.out.println("add: "+sum);
        // 单元运算符，设置数字的正负
        sum = -x + 5;   // unary -
        System.out.println("add: "+sum);
        sum = +x + 5;   // unary +
        System.out.println("add: "+sum);
        // 自增和自减
        // 重要！！关于i++和++i的区别：https://blog.csdn.net/xialei199023/article/details/76383013
        sum++;
        // return sum;
        // sum += 1;
        ++sum;
        // sum += 1;
        // return sum;
        System.out.println("unary addition: "+sum);
        sum--;
        System.out.println("unary subtraction: "+sum);

        /* ====================================位运算符================================== */
        System.out.println("==============================================================");
        System.out.println("bit shift: "+(0b1000 >> 0)); // 按位移动
        System.out.println("bit shift: "+(0b1000 >> 2)); // 1000 -> 0010 -> 2
        System.out.println("bit shift: "+(8 >> 0));
        System.out.println("bit shift: "+(8 >> 2));
        System.out.println("bit shift: "+(12345566 >> 2)); // 右移运算符，num >> 1,相当于num除以2
        System.out.println("bit shift: "+(12345566 >>> 2)); // 无符号右移，忽略符号位，空位都以0补齐
        System.out.println("bit shift: "+(-12345566 >> 2));
        System.out.println("bit shift: "+(-12345566 >>> 2));
        System.out.println("bit shift: "+(12345566 << 2)); // 左移运算符，num << 1,相当于num乘以2
        System.out.println("bit shift: "+(-12345566 << 2));
        System.out.println("and: "+(12345566 & 5));
        System.out.println("and: "+(12345567 & 5));
        System.out.println("and: "+(12345562 | 5));
        /*
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

        /* ====================================逻辑运算符================================== */
        System.out.println("==============================================================");
        boolean aa = false, bb = true;
        System.out.println("and: "+(bb && aa));
        System.out.println("or: "+(aa || bb));
        System.out.println("not: "+(!aa));
        // XOR异或，真值表见：https://zh.wikipedia.org/zh-hans/%E7%9C%9F%E5%80%BC%E8%A1%A8
        System.out.println("xor: "+(aa ^ bb));
        System.out.println("!(a && b) = " + (!(aa && bb)));
        /*
        逻辑与&& 逻辑或|| 逻辑非!
        逻辑与操作返回true的唯一可能是&&两边的布尔表达式都是true；两边任意一个表达式为false时，返回false

        逻辑或操作返回true的可能比较多，可能是||左边表达式为true，可能是右边表达式为true，也可能是两边都为true；只有当两边表达式都为false时，才返回false逻辑非操作返回右边表达式的否定

        总之，短路运算结果和真值表一致：https://zh.wikipedia.org/zh-hans/%E7%9C%9F%E5%80%BC%E8%A1%A8
        */

        /* ====================================关系运算符================================== */
        System.out.println("==============================================================");
        int a = 10;
        int b = 20;
        System.out.println("a == b = " + (a == b) );
        System.out.println("a != b = " + (a != b) );
        System.out.println("a > b = " + (a > b) );
        System.out.println("a < b = " + (a < b) );
        System.out.println("b >= a = " + (b >= a) );
        System.out.println("b <= a = " + (b <= a) );

        /* ====================================三元运算符================================== */
        System.out.println("==============================================================");
        a = 10;
        b = (a == 1) ? 20: 30;
        System.out.println( "Value of b is : " +  b );
        b = (a == 10) ? 20: 30;
        System.out.println( "Value of b is : " + b );

        /* ====================================instanceOf 运算符================================== */
        System.out.println("==============================================================");
        String name = "James";
        boolean result = name instanceof String; // 由于name是Strine类型，所以返回真
        System.out.println(result);
    }
}
