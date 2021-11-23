package thread.useBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class JadenBlockingQueue {

    //BlockingQueue是线程安全的容器类哦
    static BlockingQueue<String> q1 = new ArrayBlockingQueue(1);
    static BlockingQueue<String> q2 = new ArrayBlockingQueue(1);

    public static void main(String[] args) {
        char[] numberArray = "123456".toCharArray();
        char[] charArray = "ABCDEF".toCharArray();

        Thread t1 = new Thread(() -> {
            for (char temp : numberArray) {
                System.out.println(temp);
                try{
                    q1.put("ok");  //动作执行完毕，往阻塞队列中放ok
                    q2.take();  //能取到值，继续执行；如果取不到值，队列阻塞。
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (char temp : charArray) {

                try{
                    q1.take();
                    System.out.println(temp);
                    q2.put("ok");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

            }
        });

        t1.start();
        t2.start();

    }
}
