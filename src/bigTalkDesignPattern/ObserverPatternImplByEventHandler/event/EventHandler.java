package bigTalkDesignPattern.ObserverPatternImplByEventHandler.event;

import JavaConcurrencyInPractice.annotation.ThreadSafe;

import java.util.ArrayList;
import java.util.List;

// 事件处理对象
// 注意：使用线程封闭保证线程安全性
@ThreadSafe
public class EventHandler {

    private final List<Event> events = new ArrayList<>();

    public synchronized void addEvent(Event event){
        events.add(event);
    }

    public synchronized void removeEvent(Event event){
        events.remove(event);
    }

    public synchronized void notifyEvents() throws Exception {
        for (int i = 0; i < events.size(); i++) {
            events.get(i).invoke();
        }
    }
}
