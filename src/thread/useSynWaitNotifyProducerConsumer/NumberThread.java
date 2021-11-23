package thread.useSynWaitNotifyProducerConsumer;

public class NumberThread implements Runnable {

    private Object lock;
    NumberThread(){}
    NumberThread(Object lock){
        this.lock = lock;
    }

    @Override
    public void run() {
        int i = 1;
        while (i <= 26){
            synchronized (lock){
                if (ValueObject.value == 0) {
                    System.out.println(i++);
                    ValueObject.value = 1;
                    lock.notify();
                }else{
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }
}
