package thread.useReentrantReadWriteLock;


import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁实现类 ReentrantReadWriteLock
 * 1.不支持锁升级；【writeLock<--升级--readLock】即：当有读锁时，写锁就不能获得;
 * 2.支持锁降级；【writeLock--降级-->readLock】
 *    即：当有写锁时，除了获得写锁的这个线程可以获得读锁外，其他线程不能获得读锁；
 * 3.读锁可以在没有写锁的时被多个线程同时持有。即：读锁readLock之间是共享的；
 * 4.读锁 和 写锁之间是 互斥的；写锁和写锁之间是互斥的。
 * 【一个获得了读锁的线程必须能看到前一个释放的写锁所更新的内容，读写锁之间为互斥。】
 *
 * 拓展：ReentrantReadWriteLock 和 synchronized 区别
 * 答： 1>synchronized代码块，不仅写互斥、读也互斥；
 * 2>ReentrantReadWriteLock 可以保证读与读之间互不影响，读和写互斥、写写互斥，提高代码性能。
 *
 * 延展：RocketMQ中 NameServer路由中心，对路由表RouteInfoManager的修改就使用了ReentrantReadWriteLock。
 */
public class JadenReentrantReadWriteLock {

    public static void main(String[] args) {
        //notSupportLockUpgrade();
        //supportLockUpgrade();
        readLockShared();
    }

    // 有读锁且读锁未释放时，无法获取写锁。【无论当前线程，还是在新线程中】
    private static void notSupportLockUpgrade(){
        //默认是 非公平的---可重入读写锁【以争抢方式获取锁】
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        readWriteLock.readLock().lock();
        System.out.println("get readLock");

        new Thread(() -> {
            readWriteLock.writeLock().lock();
            System.out.println("newThread get writeLock");
        });

//        readWriteLock.writeLock().lock();
//        System.out.println("get writeLock");

    }

    // 有写锁且写锁未释放时，只能在当前线程中获得读锁---在新的线程中无法获得读锁。
    private static void supportLockUpgrade(){
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        readWriteLock.writeLock().lock();
        System.out.println("get writeLock");

//        new Thread(() -> {
//           readWriteLock.readLock().lock();
//            System.out.println("newThread get readLock");
//        });

        readWriteLock.readLock().lock();
        System.out.println("get readLock");

    }

    //读锁之间是可重入、共享的
    private static void readLockShared(){
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        Thread t1 = new Thread(()->{
            try{
                readWriteLock.readLock().lock();
                for (int i = 1; i <= 5; i++){
                    Thread.currentThread().sleep(1000);
                    System.out.println("t1业务执行中......");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                readWriteLock.readLock().unlock();
            }
        });

        Thread t2 = new Thread(()->{
            try{
                readWriteLock.readLock().lock();
                for (int i = 1; i <= 6; i++){
                    Thread.currentThread().sleep(1000);
                    System.out.println("t2业务执行中......");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                readWriteLock.readLock().unlock();
            }
        });

        t1.start();
        t2.start();

    }


}
