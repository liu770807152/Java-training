public class Loop {
    public static void main(String[] args) {
        // 1: for loop（for循环）
        for (int i = 0; i < 4; i++) {
            System.out.println("for i: "+i);
        }

        int a[] = { 2, 3, 5, 7, 19, -3 };
        for (int idx = 0; idx < a.length; idx++) {
            System.out.println("a["+idx+"] is "+a[idx]);
        }
        // JDK8开始新加入的foreach语法，省略了索引信息
        for (int value : a) {
            System.out.println("next value is "+value);
        }

        // 2: while loop（while循环）
        int i = 1;
        while (i < 3) {
            System.out.println("while i is: "+i);
            // i = i + 1;
            i++;
        }

        // 3: do while loop
        do {
            System.out.println("do is : "+i);
            i++;
        } while (i < 5);

    }
}
