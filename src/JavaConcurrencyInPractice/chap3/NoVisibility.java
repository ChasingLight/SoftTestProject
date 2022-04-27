package JavaConcurrencyInPractice.chap3;

import JavaConcurrencyInPractice.annotation.NotThreadSafe;

//没有同步情况下共享变量
@NotThreadSafe
public class NoVisibility {
    private static  boolean ready = false;  //默认值为false
    private static  int number;

    private static class ReaderThread extends Thread{
        @Override
        public void run() {
            while (!ready){
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();   //读线程

        //主线程
        number = 27;
        ready = true;

    }
}
