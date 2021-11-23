package thread.useSynWaitNotifyProducerConsumer;

public class CharThread implements Runnable {

    private Object lock;
    CharThread(){}
    CharThread(Object lock){
        this.lock = lock;
    }

    @Override
    public void run() {
        int i = Character.valueOf('A');
        while(i <= Character.valueOf('Z')){
            synchronized (lock){
                if (ValueObject.value == 1){
                    System.out.println((char)i++);
                    ValueObject.value = 0;
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
