package thread.dynamicModifyThreadExecutor;

import java.util.concurrent.*;

//线程池运行过程中，动态修改参数。不必重启线程池，就能起作用！
public class DynamicChangeThreadPoolArgs {

    public static void main(String[] args) throws InterruptedException{
        dynamicModifyExecutor();
    }


    //自定义线程池
    private static ThreadPoolExecutor buildThreadPoolExecutor(){
        return new ThreadPoolExecutor(2,
                5,
                60,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(10),
                Executors.defaultThreadFactory());
    }

    //先提交任务给线程池，再【动态修改】线程池参数
    private static void dynamicModifyExecutor() throws InterruptedException {
        ThreadPoolExecutor executor = buildThreadPoolExecutor();
        for (int i = 0; i < 15; i++) {
            executor.submit(() -> {
                threadPoolStatus(executor, "创建任务");
                try {
                    TimeUnit.SECONDS.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }//end for  Java线程池实现原理及其在美团业务中的实践

        threadPoolStatus(executor, "改变之前");
        executor.setCorePoolSize(10);
        //executor.setMaximumPoolSize(10);
        int result = executor.prestartAllCoreThreads();
        System.out.println("-------------" + result);
        threadPoolStatus(executor, "改变之后");
        Thread.currentThread().join();


    }


    //打印线程池状态
    private static void threadPoolStatus(ThreadPoolExecutor executor, String name){
        BlockingQueue<Runnable> queue = executor.getQueue();
        System.out.println(Thread.currentThread().getName() + "-" + name + "-:" +
                "核心线程数：" + executor.getCorePoolSize() +
                "活动线程数：" + executor.getActiveCount() +
                "最大线程数：" + executor.getMaximumPoolSize() +
                "线程活跃度：" + divide(executor.getActiveCount(), executor.getMaximumPoolSize()) +
                "任务完成数：" + executor.getCompletedTaskCount() +
                "队列总大小：" + (queue.size() + queue.remainingCapacity())+
                "当前排队线程数：" + queue.size() +
                "队列剩余大小：" + queue.remainingCapacity() +
                "队列使用度：" + divide(queue.size(), queue.size() + queue.remainingCapacity())
                );
    }

    //保留2位小数
    private static String divide(int num1, int num2){
        return String.format("%1.2f%%", Double.parseDouble(num1+"") / Double.parseDouble(num2+"") * 100);
    }

}
