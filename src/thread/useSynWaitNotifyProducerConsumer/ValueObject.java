package thread.useSynWaitNotifyProducerConsumer;

public class ValueObject {
    public volatile static Integer value = 0;  //有无必要加volatile修饰？
}