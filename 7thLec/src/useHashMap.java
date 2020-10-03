import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class useHashMap {
    public static void main(String[] args) {
        /**
         * hashMap的用法:
         * 键不能重复，值可以；键和值可以存储null；
         * 取数据没有顺序；
         */
        HashMap<String,String> hashMap=new HashMap<String, String>();
        hashMap.put("cn","中国");
        hashMap.put("en","英国");
        hashMap.put("us","美国");
        System.out.println(hashMap);
        System.out.println("cn"+hashMap.get("cn"));
        System.out.println(hashMap.keySet());
        System.out.println("==================================");

        /*===========================遍历============================*/
        /**
         * Iterator循环hashMap
         */
        Iterator iterator=hashMap.keySet().iterator();
        while (iterator.hasNext())
        {
            String key=iterator.next().toString();
            System.out.println("key:"+key);
            System.out.println("value:"+hashMap.get(key));
        }
        /**
         * 使用entry遍历hashMap
         */
        System.out.println("==================================");
        Set<Map.Entry<String,String>> sets=hashMap.entrySet();
        for(Map.Entry<String,String>entry :sets)
        {
            System.out.println(entry.getKey()+",");
            System.out.println(entry.getValue());
        }

        /*===========================其他常规操作============================*/
        System.out.println("==================================");
        HashMap hashMap2 = (HashMap) hashMap.clone();
        System.out.println(hashMap2);
        System.out.println(hashMap2.containsKey("en"));
        System.out.println(hashMap2.containsValue("中国"));
        System.out.println(hashMap2.get("cn"));
        System.out.println(hashMap2.remove("en"));
        hashMap2.clear();
        System.out.println(hashMap2);
    }

}
