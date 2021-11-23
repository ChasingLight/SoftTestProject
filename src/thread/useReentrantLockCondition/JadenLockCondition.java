package thread.useReentrantLockCondition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// ReentrantLock可重入锁 + Condition
// Lock的Condition可以精确地通知等待线程；而notify是通知所有的线程
public class JadenLockCondition {

    static Thread t1,t2;

    public static void main(String[] args) {
        char[] numberArray = "123456".toCharArray();
        char[] charArray = "ABCDEF".toCharArray();

        Lock lock = new ReentrantLock();
        Condition conditionT1 = lock.newCondition();
        Condition conditionT2 = lock.newCondition();

        t1 = new Thread(() -> {
            try{
                lock.lock();
                for (char temp : numberArray){
                    System.out.println(temp);
                    conditionT2.signal();
                    conditionT1.await();
                }

                conditionT2.signal(); //让main线程终止

            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        },"t1");

        t2 = new Thread(() -> {
            try{
                lock.lock();
                for (char temp : charArray){
                    System.out.println(temp);
                    conditionT1.signal();
                    conditionT2.await();
                }
                conditionT1.signal();  ////让main线程终止
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        },"t2");

        t1.start();
        t2.start();
    }
}
