package writeExamForItcast.writeExamFor91.alibabaInterview;


public class Async2 {

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        // 在这⾥创建⼀个线程或线程池，
        // 异步执⾏下⾯的⽅法
        final int[] result = {0};

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                result[0] = sum();  //执行求和方法
            }
        });
        thread.start();

        thread.join();  //主线程等待-新线程求和执行结束
        System.out.println(result[0]);


        // 确保拿到result 并输出
        System.out.println("异步计算结果为："+ result[0]);
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
