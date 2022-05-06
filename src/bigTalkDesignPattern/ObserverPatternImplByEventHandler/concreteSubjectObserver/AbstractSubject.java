package bigTalkDesignPattern.ObserverPatternImplByEventHandler.concreteSubjectObserver;

import bigTalkDesignPattern.ObserverPatternImplByEventHandler.event.Event;
import bigTalkDesignPattern.ObserverPatternImplByEventHandler.event.EventHandler;

// 主题-代理模式
public abstract class AbstractSubject {

    private final EventHandler eventHandler = new EventHandler();

    public void addObserver(Object obj, String methodName, Object...args){
        eventHandler.addEvent(new Event(obj,methodName,args));
    }

    public void removeObserver(Object obj, String methodName, Object...args){
        eventHandler.removeEvent(new Event(obj,methodName,args));
    }

    public void notifyObserver() throws Exception {
        eventHandler.notifyEvents();
    }

}
