
public class Strings {
    public static void main(String[] args) {
        String x = "Hello";
        System.out.println(x);
        String y = "world";
        System.out.println(y);
        System.out.println(x+" "+y+"!");

        // 常用操作
        String z = x + " " + y+ "!";
        System.out.println("Concatenation: "+z);  // + operator
        System.out.println("Length: "+z.length());  // length
        System.out.println("charAt: "+z.charAt(4));  // charAt
        System.out.println("substring: "+z.substring(1,4)); // 截取
        System.out.println("toupper: "+z.toUpperCase());
        System.out.println("equals: "+x.equals("Hello")); // 大小写敏感！
        System.out.println("equals: "+x.equals("hello"));

    }
}
