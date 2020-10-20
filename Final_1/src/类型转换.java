public class 类型转换 {
    public static void main(String[] args) {
        double x = 3.1;
        System.out.println("x: "+x);
        // 科学计数法：1.23456 * 10的-7次方
        double y = 1.23456e-7;
        System.out.println("y: "+y);
        String s = "3.123";

        // 第一种类型转换方法
        double z = Double.parseDouble(s);
        System.out.println("z: "+z);

        // 第二种类型转换方法，强制类型转换(int)，向下取整
        System.out.println("convert to int (floor): "+((int) (5.2)));
        System.out.println("convert to int (floor): "+((int) (5.9)));
        System.out.println("convert to int (round): "+((int) (Math.round(5.2))));
        System.out.println("convert to int (round): "+((int) (Math.round(5.9))));
        System.out.println("convert to int (ceil): "+((int) (Math.ceil(5.2))));
        System.out.println("convert to int (ceil): "+((int) (Math.ceil(5.9))));


        // 保留5位小数
        System.out.println("format: "+String.format("%.5f",3.124));
        System.out.println("max: "+Double.MAX_VALUE);
        System.out.println("min: "+Double.MIN_VALUE);
        System.out.println("min: "+Double.SIZE);
    }
}
