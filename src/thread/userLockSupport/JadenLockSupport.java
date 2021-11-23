package thread.userLockSupport;

import java.util.concurrent.locks.LockSupport;

//使用LockSupport，交替打印【1A2B3C】
// LockSupport 比着  生产者-消费者模式【synchronized、wait、nofity、信号量】更加简洁优雅
public class JadenLockSupport {

    static Thread t1,t2;

    public static void main(String[] args) {
        char[] numberArray = "123456".toCharArray();
        char[] charArray = "ABCDEF".toCharArray();

        t1 = new Thread(() -> {
            for (char temp : numberArray) {
                System.out.println(temp);
                LockSupport.unpark(t2);
                LockSupport.park();

                //这样写，则t2就永远不会被唤醒了。
                //LockSupport.park();
                //LockSupport.unpark(t2);
            }
        }, "numberThread");

        t2 = new Thread(() -> {
            for (char temp : charArray) {
                LockSupport.park();
                System.out.println(temp);
                LockSupport.unpark(t1);
            }
        }, "charThread");

        t1.start();
        t2.start();

    }
}
