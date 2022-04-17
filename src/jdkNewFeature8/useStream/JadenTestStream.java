package jdkNewFeature8.useStream;


import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
* Stream流惭怍---参考链接地址：https://shimo.im/docs/WlArz4xd6zI17bA2/read
*
* 核心思想：获取流--->中间处理--->收集整合处理结果
* */
public class JadenTestStream {

    public static void main(String[] args) {
        //createStreamThreeWay();

        forEachMatchStream();


    }

    /**
     * 创建流三种方式：数组、集合、Stream类静态方法
     */
    private static void createStreamThreeWay() {
        //1.1 数组创建Stream流
        int[] array = {1,2,3,4,5,7};
        IntStream intStream = Arrays.stream(array);
        intStream.forEach(System.out::println);

        //1.2 集合创建Stream流
        List<String> list = Arrays.asList("a","b","c");
        Stream<String> orderStream = list.stream();
        Stream<String> parallelStream = list.parallelStream();
        orderStream.forEach(System.out::println);

        //1.3 Stream类的静态方法[of()、iterate()、generate()]，创建Stream流
        Stream<Integer> stream31 = Stream.of(1, 2, 3, 4, 5, 6);
        Stream<Integer> stream32 = Stream.iterate(0, (x) -> x + 3).limit(4);
        stream32.forEach(System.out::println); // 0 3 6 9
        Stream<Double> stream33 = Stream.generate(Math::random).limit(3);
        stream33.forEach(System.out::println);
    }

    private static void forEachMatchStream(){
        List<Integer> list = Arrays.asList(7, 6, 9, 3, 8, 2, 1);
        // 遍历输出符合条件的元素
         list.stream().filter(num -> num > 7).forEach(System.out::println);

        // 匹配第一个
         Optional<Integer> findFirst = list.stream().filter(x -> x > 7).findFirst();
        // 匹配任意（适用于并行流）
         Optional<Integer> findAny = list.parallelStream().filter(x -> x > 7).findAny();
        // 是否包含符合特定条件的元素
         boolean anyMatch = list.stream().anyMatch(x -> x < 6);
         System.out.println("匹配第一个值：" + findFirst.get());
         System.out.println("匹配任意一个值：" + findAny.get());
         System.out.println("是否存在大于6的值：" + anyMatch);


         //需求：Map中存放的是班级所有人的数学成绩[key是姓名、value是数学成绩]，
         // 查看map中是否有大于等于140分的人：如果有则打印；没有输出没有符合条件记录。
        HashMap<String,Integer> mathScoreMap = new HashMap<>();
        mathScoreMap.put("李阳",80);
        mathScoreMap.put("邢华阳",102);
        mathScoreMap.put("陈龙基", 70);
        mathScoreMap.put("靳浩东",92);
        mathScoreMap.put("李兆讫",141);

        //获取流
        Stream<Map.Entry<String, Integer>> entryStream = mathScoreMap.entrySet().stream();

        //操作流、收集流

        boolean b = entryStream.anyMatch(entry -> entry.getValue() >= 140);
        if (b){
            long count = mathScoreMap.entrySet().stream().filter(entry -> entry.getValue() >= 140).count();
            System.out.println("数学成绩大于140分的学生总个数：" + count);
            System.out.println("---具体成绩如下---");
            mathScoreMap.entrySet().stream().filter(entry -> entry.getValue() >= 140).forEach(System.out::println);
        }else{
            System.out.println("没有符合条件的记录");
        }


        //查询班级数学成绩最高分
        Optional<Integer> max = mathScoreMap.values().stream().max(Integer::compare);
        System.out.println("班级最高分为：" + max.get());

        //查询班级数学成绩最低分
        Optional<Integer> min = mathScoreMap.values().stream().min(Integer::compareTo);
        System.out.println("班级最低分为：" + min.get());

    }
}
