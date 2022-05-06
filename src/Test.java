import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class Test {

    public static void main(String[] args) throws Exception {
        int a = 10;
        a = a++;
        System.out.println(a);

        ConcurrentHashMap<String, String> conHashMap = new ConcurrentHashMap<>();
        conHashMap.put("1","1");
        conHashMap.put("2","2");
        conHashMap.get("1");
        System.out.println(conHashMap);

        HashMap<String, String> map = new HashMap<>();
        map.put("3","3");
        map.put("4","4");
        map.put(null, null);
        System.out.println(map);

        String s = "计算机工程系";
        System.out.println(s.length());

        StringBuffer sb = new StringBuffer();
        System.out.println(sb.capacity());
    }

}
