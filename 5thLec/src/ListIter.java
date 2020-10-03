import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIter {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<Integer>();
        l.add(12);
        l.add(24);
        l.add(36);
        l.add(23);
        l.add(37);

        System.out.println(l);

        ListIterator<Integer> it = l.listIterator();
        while(it.hasNext()){
            System.out.println("正序："+it.next());
        }
        System.out.println("==================================");
        //使用向前迭代前必须将游标（指针）移动到后边！
        while(it.hasPrevious()){
            System.out.println("逆序："+it.previous());
        }
    }
}