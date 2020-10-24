public class Calcuate {
    // 静态方法属于类型而不属于对象
    public static int add(int a,int b){
        return a+b;
    }
    public int subtract(int a,int b){
        return a-b;
    }
    public int multiply(int a,int b){
        return a*b;
    }
    public int divide(int a,int b){
        return a/b;
    }

    class Temp extends Calcuate {
        public int add(){return -1;}
    }

}


