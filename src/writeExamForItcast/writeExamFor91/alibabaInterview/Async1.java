package writeExamForItcast.writeExamFor91.alibabaInterview;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

//原题题干：异步执行，同时拿到异步执行结果。【Callable接口、join()方法】
public class Async1 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        // 在这⾥创建⼀个线程或线程池，
        // 异步执⾏下⾯的⽅法
        int result = 0;

        FutureTask futureTask = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                System.out.println(Thread.currentThread().getName());
                return sum();
            }
        });

        new Thread(futureTask).start();  //futureTask实现了Runnable接口，启动线程启动call()

        try {
            result = (Integer) futureTask.get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 确保拿到result 并输出
        System.out.println("异步计算结果为："+result);
        System.out.println("使⽤时间："+ (System.currentTimeMillis()-start) + " ms");
        // 然后退出main线程
    }

    private static int sum() {
        return fibo(20);
    }

    private static int fibo(int a) {
        if ( a < 2) {
            return 1;
        }

        return fibo(a-1) + fibo(a-2);
    }


}
