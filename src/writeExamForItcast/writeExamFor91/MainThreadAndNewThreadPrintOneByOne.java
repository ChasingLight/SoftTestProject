package writeExamForItcast.writeExamFor91;

import java.util.Scanner;
import java.util.concurrent.locks.LockSupport;

/*
原题题干：【考察线程通信】
* A.在启动类中创建并运行一个新线程；
* B.在该线程中从键盘读入一行字符串；
* C.当读入的字符串为"EXIT"时退出线程；
* D.否则将该值传递给主线程，由主线程打印出来。
* 循环B、C、D直至程序退出。
* */
public class MainThreadAndNewThreadPrintOneByOne {

    static Thread t1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final String[] value = {""};

        Thread mainThread = Thread.currentThread();

        t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    System.out.println("Please Enter String:");
                    value[0] = sc.nextLine();  //读取字符串型输入
                    if ("Exit".equalsIgnoreCase(value[0])){
                        break;
                    }
                    System.out.println("等到主线程打印");
                    LockSupport.unpark(mainThread);
                    LockSupport.park();
                }

            }
        });
        t1.start();

        while(true){
            LockSupport.park();
            if ("Exit".equalsIgnoreCase(value[0])){
                break;
            }
            System.out.println(value[0]);
            LockSupport.unpark(t1);
        }
    }
}
