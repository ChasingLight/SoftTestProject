package writeExamForItcast.writeExamFor91;

import java.util.concurrent.locks.LockSupport;

//使用LockSupport，交替打印【1A2B3C】
// LockSupport 比着  生产者-消费者模式【synchronized、wait&nofity、信号量】真是简洁
public class JadenLockSupportForABC {

    static Thread t1,t2,t3;

    public static void main(String[] args) {
        char[] AArray = "AAAAAAAAAA".toCharArray();
        char[] BArray = "BBBBBBBBBB".toCharArray();
        char[] CArray = "CCCCCCCCCC".toCharArray();

        t1 = new Thread(() -> {
            for (char temp : AArray) {
                System.out.println(temp);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        }, "Thread-A");

        t2 = new Thread(() -> {
            for (char temp : BArray) {
                LockSupport.park();
                System.out.println(temp);
                LockSupport.unpark(t3);
            }
        }, "Thread-B");

        t3 = new Thread(() -> {
            for (char temp : CArray) {
                LockSupport.park();
                System.out.println(temp);
                LockSupport.unpark(t1);
            }
        }, "Thread-C");

        t1.start();
        t2.start();
        t3.start();

    }
}
