import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

// 四种遍历方法的代码
public class Iter {
    public static void main(String[] args) {
        Collection<String> l = new ArrayList<>();
        l.add("1");
        l.add("2");
        l.add("3");
        l.add("4");

        System.out.println(l);
        /**
         * 遍历输出：四种方式
         */

        // 1、推荐使用的Iterator对象，迭代输出
        Iterator it = l.iterator(); // new Iterator()
        while (it.hasNext()) {
            System.out.println("迭代输出：" + it.next());
        }

        // 2、对集合进行foreach循环
        for (String str : l) {
            System.out.println("fore集合迭代输出：" + str);
        }

        // 3、for循环迭代，在for方法体内部实例化Iterator对象
        int i = 0;// for方法体内定义项不能出现多种不同类型
        for (Iterator iter = l.iterator(); i < l.size(); i++) {
            System.out.println("for循环迭代实例化输出：" + iter.next());
        }

        // 4、先将集合转换为数组，再利用数组的遍历输出；
        Object[] o = l.toArray();
        for (Object object : o) {
            System.out.println("转换数组迭代输出：" + object);
        }
    }
}
