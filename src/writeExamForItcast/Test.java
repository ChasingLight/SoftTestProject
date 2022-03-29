package writeExamForItcast;


import java.util.*;

public class Test {

    public static void main(String[] args){
        String str = "aaaBBBB  6";
        System.out.println(str);
        System.out.println(countAndSortCharacterTimes(str));

        int x = 4;
        int y = (x--) + (x--) + (x*10);
        System.out.println(x);
        System.out.println(y);

    }

    private static String countAndSortCharacterTimes(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i < str.length(); i++) {
            Character temp = str.charAt(i);
            if (!map.containsKey(temp)){
                map.put(temp, 1);
            }else{
                map.put(temp, map.get(temp)+1);
            }
        }

        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((o1, o2) -> {
            return (o2.getValue() - o1.getValue());//根据value排序,此时为降序
        });


        //遍历展示最终结果
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<Character, Integer> entry : entryList) {
            sb.append(entry.getKey());
        }

        return sb.toString();
    }
}
