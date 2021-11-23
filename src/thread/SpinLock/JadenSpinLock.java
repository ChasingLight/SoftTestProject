package thread.SpinLock;

import java.util.concurrent.locks.LockSupport;

// 使用自旋锁，交替打印【1A2B3C】
// (不经过操作系统的内核态)：就像人专心一个一个做事效率高；如果一个事情做一半切换做另一半，来回切换会耗费资源的。
public class JadenSpinLock {

    static volatile Integer flag = 0;

    public static void main(String[] args) {
        char[] numberArray = "123456".toCharArray();
        char[] charArray = "ABCDEF".toCharArray();

        Thread t1 = new Thread(() -> {
            for (char temp : numberArray) {
                while(flag != 0){}
                System.out.println(temp);
                flag = 1;
            }
        });

        Thread t2 = new Thread(() -> {
            for (char temp : charArray) {
                while(flag != 1){}
                System.out.println(temp);
                flag = 0;
            }
        });

        t1.start();
        t2.start();

    }
}
