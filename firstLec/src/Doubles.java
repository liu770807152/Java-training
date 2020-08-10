import java.util.Random;

public class Doubles {
    public static void main(String[] args) {
        double x = 3.1;
        System.out.println("x: "+x);
        // 科学计数法：1.23456 * 10的-7次方
        double y = 1.23456e-7;
        System.out.println("y: "+y);
        String s = "3.123";
        // 解析成double类型的值
        double z = Double.parseDouble(s);
        System.out.println("z: "+z);

        System.out.println("add: "+3.0+5.2);   // string concatenation！一定要加括号！
        System.out.println("add: "+(3.0+5.2));
        System.out.println("sub: "+(3.0-5.2));
        System.out.println("mul: "+(3.0*5.2));
        System.out.println("div: "+(3.0/5.2));

        // 强制类型转换(int)，向下取整
        System.out.println("convert to int (floor): "+((int) (5.2)));
        System.out.println("convert to int (floor): "+((int) (5.9)));
        System.out.println("convert to int (round): "+((int) (Math.round(5.2))));
        System.out.println("convert to int (round): "+((int) (Math.round(5.9))));
        System.out.println("convert to int (ceil): "+((int) (Math.ceil(5.2))));
        System.out.println("convert to int (ceil): "+((int) (Math.ceil(5.9))));

        // 保留2位小数
        System.out.println("format: "+String.format("%.5f",3.124));
        System.out.println("max: "+Double.MAX_VALUE);
        System.out.println("min: "+Double.MIN_VALUE);
        System.out.println("min: "+Double.SIZE);
    }
}
