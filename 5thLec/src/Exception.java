public class Exception {
    public static void main(String[] args){
        try {
            foo();
        } catch(ArithmeticException ae) {
            System.out.println("处理异常");
        } // finally {}
        // ...
        System.out.println("Done!");
    }
    public static void foo(){
        int a = 5/0;  // 异常抛出点
        System.out.println("为什么还不给我涨工资!!!");  // 不会执行
    }
}
