package JavaConcurrencyInPractice.chap3;

import writeExamForItcast.Test;

import java.util.HashMap;

/*
《Java并发编程实战 chap3.4 不变性 p38》
* final关键字在并发编程中的使用
* */
public class FinalInJavaConcurrency {

    private final HashMap<String, String> map;
    private final Integer i;

    public FinalInJavaConcurrency(HashMap<String, String> sourceMap, Integer i){
        this.i = i;

        // 克隆【2个map对象】
        this.map = (HashMap<String, String>)sourceMap.clone();
        // 【编译错误】直接指向原先的map【1个map对象】
        //this.map = sourceMap;
    }

    public HashMap<String, String> getMap() {
        return map;
    }

    // 【编译错误】无法修改final修饰引用类型的地址
    /*public void setMap(HashMap<String, String> map){
        this.map = map;
    }*/


    public static void main(String[] args) {

        HashMap<String, String> sourceMap = new HashMap<>();
        sourceMap.put("1","1");
        sourceMap.put("2","2");
        Integer sourceI = 6;


        FinalInJavaConcurrency finalConcurrency = new FinalInJavaConcurrency(sourceMap, sourceI);

        System.out.println(finalConcurrency.i);
        // 【编译错误】无法修改final修饰基础类型的值
        //finalConcurrency.i = 5;

        HashMap<String, String> finalMap = finalConcurrency.getMap();
        //无法修改final修饰引用类型的-地址-，但是可以修改map中的内容
        finalMap.put("4","4");
        System.out.println(finalMap);
        //【利用对象clone】sourceMap 和 final map 2个对象互不影响
        sourceMap.put("3","3");
        System.out.println(sourceMap);

        //验证：sourceMap 和 final map 是2个不同的对象
        System.out.println(sourceMap == finalMap);
        System.out.println(sourceMap.equals(finalMap));


    }
}
