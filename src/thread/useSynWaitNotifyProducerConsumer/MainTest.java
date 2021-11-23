package thread.useSynWaitNotifyProducerConsumer;

//synchronized(integer)原因就知道了， integer++是创建了一个新的Integer对象，并将引用赋值给integer。因为integer一直在变，线程每次加锁可能都加在了不同对象的实例上
public class MainTest {
    public static void main(String[] args) {
        Object lock = "";  //不可变类

        Thread numberThread = new Thread(new NumberThread(lock));
        Thread charThread = new Thread(new CharThread(lock));

        charThread.start();
        numberThread.start();

    }
}
