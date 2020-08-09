import java.util.Random;

public class Integers {
    public static void main(String[] args) {
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
        System.out.println("div: "+(3/5));
        System.out.println("rem: "+(3%5));
        System.out.println("rem: "+(-3%5));
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
        System.out.println("and: "+(12345562 & 5));

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
        System.out.println("unary addition: "+sum);
        sum--;
        System.out.println("unary subtraction: "+sum);


    }
}
