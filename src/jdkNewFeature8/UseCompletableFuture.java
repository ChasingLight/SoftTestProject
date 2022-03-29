package jdkNewFeature8;

import java.util.concurrent.CompletableFuture;

/*
* 参考文章链接：https://www.liaoxuefeng.com/wiki/1252599548343744/1306581182447650
* 1.单个异步任务，成功回调函数；异常回调函数【有点类似 Ajax请求 success函数】
* 2.多个异步任务，串行化执行【上个任务结果，作为下个任务的入参】；
* 3.多个异步任务，并行任一个执行 anyof
* 4.多个异步任务，并行全部执行 allof
* */
public class UseCompletableFuture {
    public static void main(String[] args) throws InterruptedException {

        //condition1();
        condition2();


        //利用CompletableFuture.join(),完美解决主线程等待问题
    }


    //1.单个异步任务，成功回调函数；异常回调函数【有点类似 Ajax请求 success函数】
    public static void condition1(){

        // 创建异步执行任务:
        CompletableFuture<Integer> cf = CompletableFuture.supplyAsync(() -> addNumber(1,2));

        // 如果执行成功:
        cf.thenAccept((sum) -> {
            System.out.println("两数求和为：" + sum);
        });

        // 如果执行异常:
        cf.exceptionally((e) -> {
            e.printStackTrace();
            return 0;
        });

        cf.join();

    }

    //2.多个异步任务，串行化执行；
    public static void condition2(){
        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> addNumber(6,8));

        //必须从左往右写才可以识别  哈哈
        CompletableFuture<Integer> cf2 = cf1.thenApplyAsync((sum) -> doubleNum(sum));

        CompletableFuture<Integer> cf3 = cf2.thenApplyAsync((doubleNumer) -> fourFoldNum(doubleNumer));

        cf3.thenAccept((fourFoldNum) -> {
            System.out.println(fourFoldNum);
        }).join();

    }




    private static int addNumber(int a, int b) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return a+b;
    }

    private static Integer doubleNum(int a){
        return a*2;
    }

    private static Integer fourFoldNum(int a){
        return a*4;
    }


}
